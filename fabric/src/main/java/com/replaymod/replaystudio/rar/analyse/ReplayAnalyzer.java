package com.replaymod.replaystudio.rar.analyse;

import com.replaymod.lib.com.github.steveice10.packetlib.io.NetOutput;
import com.replaymod.replaystudio.PacketData;
import com.replaymod.replaystudio.io.ReplayInputStream;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.ProtocolVersion;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import com.replaymod.replaystudio.protocol.packets.PacketBlockChange;
import com.replaymod.replaystudio.protocol.packets.PacketChunkData;
import com.replaymod.replaystudio.protocol.packets.PacketDestroyEntities;
import com.replaymod.replaystudio.protocol.packets.PacketJoinGame;
import com.replaymod.replaystudio.protocol.packets.PacketNotifyClient;
import com.replaymod.replaystudio.protocol.packets.PacketPlayerListEntry;
import com.replaymod.replaystudio.protocol.packets.PacketRespawn;
import com.replaymod.replaystudio.protocol.packets.PacketSpawnPlayer;
import com.replaymod.replaystudio.protocol.packets.PacketUpdateLight;
import com.replaymod.replaystudio.protocol.packets.PacketUpdateSimulationDistance;
import com.replaymod.replaystudio.protocol.packets.PacketUpdateViewDistance;
import com.replaymod.replaystudio.protocol.packets.PacketUpdateViewPosition;
import com.replaymod.replaystudio.rar.cache.WriteableCache;
import com.replaymod.replaystudio.rar.state.Chunk;
import com.replaymod.replaystudio.rar.state.Entity;
import com.replaymod.replaystudio.rar.state.Replay;
import com.replaymod.replaystudio.rar.state.Weather;
import com.replaymod.replaystudio.rar.state.World;
import com.replaymod.replaystudio.util.IPosition;
import com.replaymod.replaystudio.util.Location;
import com.replaymod.replaystudio.util.PacketUtils;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap.Entry;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.IntConsumer;

public class ReplayAnalyzer {
   private final PacketTypeRegistry registry;
   private final NetOutput out;
   private final Replay.Builder replay;
   private int currentViewChunkX = 0;
   private int currentViewChunkZ = 0;
   private int currentViewDistance = 0;
   private int currentSimulationDistance = 0;
   private final Map<String, PacketPlayerListEntry> playerListEntries = new HashMap();
   private Packet lastLightUpdate = null;

   public ReplayAnalyzer(PacketTypeRegistry registry, NetOutput out, WriteableCache cache) throws IOException {
      this.registry = registry;
      this.out = out;
      this.replay = new Replay.Builder(registry, cache);
   }

   public void analyse(ReplayInputStream in, IntConsumer progress) throws IOException {
      int time;
      PacketData packetData;
      Packet packet;
      for(time = 0; (packetData = in.readPacket()) != null; packet.release()) {
         Integer entityId;
         Entity.Builder entity;
         packet = packetData.getPacket();
         time = (int)packetData.getTime();
         progress.accept(time);
         entityId = PacketUtils.getEntityId(packet);
         Iterator var15;
         label128:
         switch(packet.getType()) {
         case SpawnMob:
         case SpawnObject:
         case SpawnPainting:
            entity = this.replay.world.transientThings.newEntity(time, entityId);
            entity.addSpawnPacket(packet.retain());
            break;
         case SpawnPlayer:
            entity = this.replay.world.transientThings.newEntity(time, entityId);
            PacketPlayerListEntry entry = (PacketPlayerListEntry)this.playerListEntries.get(PacketSpawnPlayer.getPlayerListEntryId(packet));
            if (entry != null) {
               entity.addSpawnPacket(PacketPlayerListEntry.write(this.registry, PacketPlayerListEntry.Action.init(this.registry), entry));
            }

            entity.addSpawnPacket(packet.retain());
            break;
         case DestroyEntity:
         case DestroyEntities:
            var15 = PacketDestroyEntities.getEntityIds(packet).iterator();

            while(true) {
               if (!var15.hasNext()) {
                  break label128;
               }

               int id = (Integer)var15.next();
               this.replay.world.transientThings.removeEntity(time, id);
            }
         case UnloadChunk:
         case ChunkData:
            PacketChunkData chunkData = PacketChunkData.read(packet, this.replay.world.info.dimensionType.getSections());
            if (chunkData.isUnload()) {
               this.replay.world.transientThings.removeChunk(time, chunkData.getUnloadX(), chunkData.getUnloadZ());
            } else {
               this.processChunkLoad(time, chunkData.getColumn());
            }
            break;
         case BulkChunkData:
            var15 = PacketChunkData.readBulk(packet).iterator();

            while(true) {
               if (!var15.hasNext()) {
                  break label128;
               }

               PacketChunkData.Column column = (PacketChunkData.Column)var15.next();
               this.processChunkLoad(time, column);
            }
         case UpdateLight:
            if (this.registry.atLeast(ProtocolVersion.v1_18)) {
               break;
            }

            PacketUpdateLight updateLight = PacketUpdateLight.read(packet);
            Chunk.Builder chunk = this.replay.world.transientThings.getChunk(updateLight.getX(), updateLight.getZ());
            if (chunk != null && chunk.spawnPackets.list.size() == 1) {
               chunk.spawnPackets.list.add(0, packet.retain());
               break;
            }

            if (this.lastLightUpdate != null) {
               this.lastLightUpdate.release();
            }

            this.lastLightUpdate = packet.retain();
            break;
         case BlockChange:
         case MultiBlockChange:
            var15 = PacketBlockChange.readSingleOrBulk(packet).iterator();

            while(true) {
               if (!var15.hasNext()) {
                  break label128;
               }

               PacketBlockChange record = (PacketBlockChange)var15.next();
               IPosition pos = record.getPosition();
               Chunk.Builder chunk = this.replay.world.transientThings.getChunk(pos.getX() >> 4, pos.getZ() >> 4);
               if (chunk != null) {
                  chunk.blocks.update(time, record);
               }
            }
         case PlayerListEntry:
            Set<PacketPlayerListEntry.Action> actions = PacketPlayerListEntry.getActions(packet);
            Iterator var16 = PacketPlayerListEntry.read(packet).iterator();

            while(var16.hasNext()) {
               PacketPlayerListEntry entry = (PacketPlayerListEntry)var16.next();
               Iterator var10 = actions.iterator();

               while(var10.hasNext()) {
                  PacketPlayerListEntry.Action action = (PacketPlayerListEntry.Action)var10.next();
                  switch(action) {
                  case ADD:
                     this.playerListEntries.put(entry.getId(), entry);
                     break;
                  case CHAT_KEY:
                     this.playerListEntries.computeIfPresent(entry.getId(), (key, it) -> {
                        return PacketPlayerListEntry.updateChatKey(it, entry.getSigData());
                     });
                     break;
                  case GAMEMODE:
                     this.playerListEntries.computeIfPresent(entry.getId(), (key, it) -> {
                        return PacketPlayerListEntry.updateGamemode(it, entry.getGamemode());
                     });
                     break;
                  case LISTED:
                     this.playerListEntries.computeIfPresent(entry.getId(), (key, it) -> {
                        return PacketPlayerListEntry.updateListed(it, entry.isListed());
                     });
                     break;
                  case LATENCY:
                     this.playerListEntries.computeIfPresent(entry.getId(), (key, it) -> {
                        return PacketPlayerListEntry.updateLatency(it, entry.getLatency());
                     });
                     break;
                  case DISPLAY_NAME:
                     this.playerListEntries.computeIfPresent(entry.getId(), (key, it) -> {
                        return PacketPlayerListEntry.updateDisplayName(it, entry.getDisplayName());
                     });
                     break;
                  case REMOVE:
                     this.playerListEntries.remove(entry.getId());
                  }
               }
            }
            break;
         case Respawn:
            PacketRespawn respawn = PacketRespawn.read(packet, this.replay.world.info.registry);
            String newDimension = respawn.dimension;
            if (!newDimension.equals(this.replay.world.info.dimension)) {
               World.Builder world = this.replay.newWorld(time, new World.Info(this.replay.world.info, respawn));
               if (this.registry.atLeast(ProtocolVersion.v1_14)) {
                  this.currentViewChunkX = this.currentViewChunkZ = 0;
                  world.viewPosition.put(time, PacketUpdateViewPosition.write(this.registry, 0, 0));
                  world.viewDistance.put(time, PacketUpdateViewDistance.write(this.registry, this.currentViewDistance));
               }

               if (this.registry.atLeast(ProtocolVersion.v1_18)) {
                  world.simulationDistance.put(time, PacketUpdateSimulationDistance.write(this.registry, this.currentSimulationDistance));
               }
            }
            break;
         case JoinGame:
            PacketJoinGame joinGame = PacketJoinGame.read(packet);
            this.replay.newWorld(time, new World.Info(joinGame));
            if (this.registry.atLeast(ProtocolVersion.v1_14)) {
               this.currentViewChunkX = this.currentViewChunkZ = 0;
               this.replay.world.viewPosition.put(time, PacketUpdateViewPosition.write(this.registry, 0, 0));
               this.currentViewDistance = joinGame.viewDistance;
               this.replay.world.viewDistance.put(time, PacketUpdateViewDistance.write(this.registry, this.currentViewDistance));
            }

            if (this.registry.atLeast(ProtocolVersion.v1_18)) {
               this.currentSimulationDistance = joinGame.simulationDistance;
               this.replay.world.simulationDistance.put(time, PacketUpdateSimulationDistance.write(this.registry, this.currentSimulationDistance));
            }
            break;
         case Features:
            this.replay.features.put(time, packet.retain());
            break;
         case Tags:
            this.replay.tags.put(time, packet.retain());
            break;
         case UpdateViewPosition:
            this.currentViewChunkX = PacketUpdateViewPosition.getChunkX(packet);
            this.currentViewChunkZ = PacketUpdateViewPosition.getChunkZ(packet);
            this.invalidateOutOfBoundsChunks(time, this.currentViewChunkX, this.currentViewChunkZ, this.currentViewDistance);
            this.replay.world.viewPosition.put(time, packet.retain());
            break;
         case UpdateViewDistance:
            this.currentViewDistance = PacketUpdateViewDistance.getDistance(packet);
            this.invalidateOutOfBoundsChunks(time, this.currentViewChunkX, this.currentViewChunkZ, this.currentViewDistance);
            this.replay.world.viewDistance.put(time, packet.retain());
            break;
         case UpdateSimulationDistance:
            this.currentSimulationDistance = PacketUpdateSimulationDistance.getDistance(packet);
            this.replay.world.simulationDistance.put(time, packet.retain());
            break;
         case UpdateTime:
            this.replay.world.worldTimes.put(time, packet.retain());
            break;
         case NotifyClient:
            switch(PacketNotifyClient.getAction(packet)) {
            case START_RAIN:
               this.replay.world.transientThings.newWeather(time);
               break;
            case STOP_RAIN:
               this.replay.world.transientThings.removeWeather(time);
               break;
            case RAIN_STRENGTH:
               Weather.Builder weather = this.replay.world.transientThings.getWeather();
               if (weather != null) {
                  weather.updateRainStrength(time, packet.retain());
               }
               break;
            case THUNDER_STRENGTH:
               this.replay.world.thunderStrengths.put(time, packet.retain());
            }
         }

         if (entityId != null) {
            entity = this.replay.world.transientThings.getEntity(entityId);
            if (entity != null) {
               Location current = entity.getLocation();
               Location updated = PacketUtils.updateLocation(current, packet);
               if (updated != null) {
                  entity.updateLocation(time, updated);
               }
            }
         }
      }

      if (this.lastLightUpdate != null) {
         this.lastLightUpdate.release();
      }

      this.replay.build(this.out, time);
   }

   private void processChunkLoad(int time, PacketChunkData.Column column) throws IOException {
      Chunk.Builder chunk;
      if (column.isFull()) {
         chunk = this.replay.world.transientThings.newChunk(time, column);
         if (this.lastLightUpdate != null) {
            PacketUpdateLight updateLight = PacketUpdateLight.read(this.lastLightUpdate);
            if (column.x == updateLight.getX() && column.z == updateLight.getZ()) {
               chunk.spawnPackets.list.add(0, this.lastLightUpdate);
               this.lastLightUpdate = null;
            }
         }
      } else {
         chunk = this.replay.world.transientThings.getChunk(column.x, column.z);
         if (chunk != null) {
            chunk.blocks.update(time, column);
         }
      }

   }

   private void invalidateOutOfBoundsChunks(int time, int centerX, int centerZ, int viewDistance) throws IOException {
      int distance = Math.max(2, viewDistance) + 3;
      LongSet toBeRemoved = new LongOpenHashSet();
      ObjectIterator var7 = this.replay.world.transientThings.getChunks().long2ObjectEntrySet().iterator();

      while(true) {
         long key;
         int x;
         int z;
         do {
            if (!var7.hasNext()) {
               LongIterator var13 = toBeRemoved.iterator();

               while(var13.hasNext()) {
                  long key = (Long)var13.next();
                  this.replay.world.transientThings.removeChunk(time, key);
               }

               return;
            }

            Entry<Chunk.Builder> entry = (Entry)var7.next();
            key = entry.getLongKey();
            x = PacketChunkData.Column.longToX(key);
            z = PacketChunkData.Column.longToZ(key);
         } while(Math.abs(x - centerX) <= distance && Math.abs(z - centerZ) <= distance);

         toBeRemoved.add(key);
      }
   }
}
