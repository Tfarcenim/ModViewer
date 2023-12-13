package com.replaymod.replaystudio.rar.containers;

import com.replaymod.lib.com.github.steveice10.packetlib.io.NetInput;
import com.replaymod.replaystudio.lib.guava.collect.ListMultimap;
import com.replaymod.replaystudio.lib.guava.collect.Multimaps;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import com.replaymod.replaystudio.protocol.packets.PacketChunkData;
import com.replaymod.replaystudio.protocol.registry.DimensionType;
import com.replaymod.replaystudio.rar.PacketSink;
import com.replaymod.replaystudio.rar.RandomAccessState;
import com.replaymod.replaystudio.rar.cache.ReadableCache;
import com.replaymod.replaystudio.rar.cache.WriteableCache;
import com.replaymod.replaystudio.rar.state.Chunk;
import com.replaymod.replaystudio.rar.state.Entity;
import com.replaymod.replaystudio.rar.state.TransientThing;
import com.replaymod.replaystudio.rar.state.Weather;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class TransientThings implements RandomAccessState {
   private final TreeMap<Integer, Collection<TransientThing>> thingSpawns = new TreeMap();
   private final TreeMap<Integer, Collection<TransientThing>> thingDespawns = new TreeMap();
   private int activeThingsTime = -1;
   private final List<TransientThing> activeThings = new LinkedList();
   private final PacketTypeRegistry registry;
   private final int index;
   private ReadableCache cache;

   public TransientThings(PacketTypeRegistry registry, int index) {
      this.registry = registry;
      this.index = index;
   }

   public void load(PacketSink sink, ReadableCache cache) throws IOException {
      this.cache = cache;
      NetInput in = cache.seek(this.index);
      ListMultimap<Integer, TransientThing> thingSpawns = Multimaps.newListMultimap(this.thingSpawns, ArrayList::new);
      ListMultimap thingDespawns = Multimaps.newListMultimap(this.thingDespawns, ArrayList::new);

      while(true) {
         Object trackedThing;
         switch(in.readVarInt()) {
         case 0:
            return;
         case 1:
            trackedThing = new Entity(this.registry, in);
            break;
         case 2:
            trackedThing = new Chunk(this.registry, in);
            break;
         case 3:
            trackedThing = new Weather(this.registry, in);
            break;
         default:
            throw new IOException("Invalid transient thing id.");
         }

         thingSpawns.put(((TransientThing)trackedThing).spawnTime, trackedThing);
         thingDespawns.put(((TransientThing)trackedThing).despawnTime, trackedThing);
      }
   }

   public void unload(PacketSink sink, ReadableCache cache) throws IOException {
      Iterator var3 = this.activeThings.iterator();

      while(var3.hasNext()) {
         TransientThing activeThing = (TransientThing)var3.next();
         activeThing.unload(sink, cache);
      }

      this.activeThings.clear();
      this.activeThingsTime = -1;
      this.thingSpawns.clear();
      this.thingDespawns.clear();
   }

   private void computeActiveThings(int time) throws IOException {
      if (time != this.activeThingsTime) {
         Iterator var2 = this.activeThings.iterator();

         while(var2.hasNext()) {
            TransientThing activeThing = (TransientThing)var2.next();
            activeThing.unload(Packet::release, this.cache);
         }

         this.activeThings.clear();
         var2 = this.thingSpawns.subMap(-1, false, time, true).values().iterator();

         while(var2.hasNext()) {
            Collection<TransientThing> things = (Collection)var2.next();
            Iterator var4 = things.iterator();

            while(var4.hasNext()) {
               TransientThing thing = (TransientThing)var4.next();
               if (thing.despawnTime > time) {
                  thing.load(Packet::release, this.cache);
                  this.activeThings.add(thing);
               }
            }
         }

         this.activeThingsTime = time;
      }
   }

   public void play(PacketSink sink, int currentTimeStamp, int targetTime) throws IOException {
      this.computeActiveThings(currentTimeStamp);
      Iterator activeIter = this.activeThings.iterator();

      while(activeIter.hasNext()) {
         TransientThing thing = (TransientThing)activeIter.next();
         if (thing.despawnTime <= targetTime) {
            thing.unload(sink, this.cache);
            activeIter.remove();
         }
      }

      Iterator var9 = this.thingSpawns.subMap(currentTimeStamp, false, targetTime, true).values().iterator();

      while(var9.hasNext()) {
         Collection<TransientThing> things = (Collection)var9.next();
         Iterator var7 = things.iterator();

         while(var7.hasNext()) {
            TransientThing thing = (TransientThing)var7.next();
            if (thing.despawnTime > targetTime) {
               thing.load(sink, this.cache);
               this.activeThings.add(thing);
            }
         }
      }

      this.activeThingsTime = targetTime;
      var9 = this.activeThings.iterator();

      while(var9.hasNext()) {
         TransientThing thing = (TransientThing)var9.next();
         thing.play(sink, currentTimeStamp, targetTime);
      }

   }

   public void rewind(PacketSink sink, int currentTimeStamp, int targetTime) throws IOException {
      this.computeActiveThings(currentTimeStamp);
      Iterator activeIter = this.activeThings.iterator();

      while(activeIter.hasNext()) {
         TransientThing thing = (TransientThing)activeIter.next();
         if (thing.spawnTime > targetTime) {
            thing.unload(sink, this.cache);
            activeIter.remove();
         }
      }

      Iterator var9 = this.thingDespawns.subMap(targetTime, false, currentTimeStamp, true).values().iterator();

      while(var9.hasNext()) {
         Collection<TransientThing> things = (Collection)var9.next();
         Iterator var7 = things.iterator();

         while(var7.hasNext()) {
            TransientThing thing = (TransientThing)var7.next();
            if (thing.spawnTime <= targetTime) {
               thing.load(sink, this.cache);
               this.activeThings.add(thing);
            }
         }
      }

      this.activeThingsTime = targetTime;
      var9 = this.activeThings.iterator();

      while(var9.hasNext()) {
         TransientThing thing = (TransientThing)var9.next();
         thing.rewind(sink, currentTimeStamp, targetTime);
      }

   }

   public static class Builder {
      private final PacketTypeRegistry registry;
      private final WriteableCache cache;
      private final WriteableCache.Deferred indexOut;
      private final DimensionType dimensionType;
      private final Long2ObjectMap<Entity.Builder> entities = new Long2ObjectOpenHashMap();
      private final Long2ObjectMap<Chunk.Builder> chunks = new Long2ObjectOpenHashMap();
      private final Long2ObjectMap<Weather.Builder> weather = new Long2ObjectOpenHashMap();

      public Builder(PacketTypeRegistry registry, WriteableCache cache, DimensionType dimensionType) {
         this.registry = registry;
         this.cache = cache;
         this.indexOut = cache.deferred();
         this.dimensionType = dimensionType;
      }

      public Long2ObjectMap<Chunk.Builder> getChunks() {
         return this.chunks;
      }

      public Entity.Builder newEntity(int time, int entityId) throws IOException {
         return (Entity.Builder)this.newTransientThing(this.entities, time, (long)entityId, new Entity.Builder(this.registry, entityId));
      }

      public Chunk.Builder newChunk(int time, PacketChunkData.Column column) throws IOException {
         return (Chunk.Builder)this.newTransientThing(this.chunks, time, column.coordToLong(), new Chunk.Builder(this.registry, this.dimensionType, column));
      }

      public Weather.Builder newWeather(int time) throws IOException {
         return (Weather.Builder)this.newTransientThing(this.weather, time, 0L, new Weather.Builder(this.registry));
      }

      private <T extends TransientThing.Builder> T newTransientThing(Long2ObjectMap<T> map, int time, long key, T thing) throws IOException {
         thing.setSpawnTime(time);
         TransientThing.Builder prev = (TransientThing.Builder)map.put(key, thing);
         if (prev != null) {
            this.commitTransientThing(time, prev);
         }

         return thing;
      }

      public Entity.Builder getEntity(int entityId) {
         return (Entity.Builder)this.entities.get((long)entityId);
      }

      public Chunk.Builder getChunk(int x, int z) {
         return (Chunk.Builder)this.chunks.get(PacketChunkData.Column.coordToLong(x, z));
      }

      public Weather.Builder getWeather() {
         return (Weather.Builder)this.weather.get(0L);
      }

      public Entity.Builder removeEntity(int time, int entityId) throws IOException {
         Entity.Builder entity = (Entity.Builder)this.entities.remove((long)entityId);
         if (entity != null) {
            this.commitTransientThing(time, entity);
         }

         return entity;
      }

      public Chunk.Builder removeChunk(int time, int x, int z) throws IOException {
         return this.removeChunk(time, PacketChunkData.Column.coordToLong(x, z));
      }

      public Chunk.Builder removeChunk(int time, long key) throws IOException {
         Chunk.Builder chunk = (Chunk.Builder)this.chunks.remove(key);
         if (chunk != null) {
            this.commitTransientThing(time, chunk);
         }

         return chunk;
      }

      public Weather.Builder removeWeather(int time) throws IOException {
         Weather.Builder weather = (Weather.Builder)this.weather.remove(0L);
         if (weather != null) {
            this.commitTransientThing(time, weather);
         }

         return weather;
      }

      private void commitTransientThing(int time, TransientThing.Builder thing) throws IOException {
         byte id;
         if (thing instanceof Entity.Builder) {
            id = 1;
         } else if (thing instanceof Chunk.Builder) {
            id = 2;
         } else {
            if (!(thing instanceof Weather.Builder)) {
               throw new IllegalArgumentException("Unsupported type of thing: " + thing.getClass());
            }

            id = 3;
         }

         this.indexOut.writeByte(id);
         thing.setDespawnTime(time);
         thing.build(this.indexOut, this.cache);
      }

      private void commitTransientThings(int time, Collection<? extends TransientThing.Builder> things) throws IOException {
         Iterator var3 = things.iterator();

         while(var3.hasNext()) {
            TransientThing.Builder thing = (TransientThing.Builder)var3.next();
            this.commitTransientThing(time, thing);
         }

      }

      public void flush(int time) throws IOException {
         this.commitTransientThings(time, this.chunks.values());
         this.commitTransientThings(time, this.entities.values());
         this.commitTransientThings(time, this.weather.values());
         this.chunks.clear();
         this.entities.clear();
         this.weather.clear();
      }

      public int build(int time) throws IOException {
         this.flush(time);
         this.indexOut.writeByte(0);
         return this.indexOut.commit();
      }
   }
}
