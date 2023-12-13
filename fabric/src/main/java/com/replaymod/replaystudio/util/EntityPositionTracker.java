package com.replaymod.replaystudio.util;

import com.replaymod.lib.com.github.steveice10.packetlib.io.NetInput;
import com.replaymod.lib.com.github.steveice10.packetlib.io.NetOutput;
import com.replaymod.lib.com.github.steveice10.packetlib.io.stream.StreamNetInput;
import com.replaymod.lib.com.github.steveice10.packetlib.io.stream.StreamNetOutput;
import com.replaymod.replaystudio.PacketData;
import com.replaymod.replaystudio.io.ReplayInputStream;
import com.replaymod.replaystudio.lib.guava.base.Optional;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.State;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import com.replaymod.replaystudio.replay.ReplayFile;
import com.replaymod.replaystudio.replay.ReplayMetaData;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.function.Consumer;

public class EntityPositionTracker {
   private static final String CACHE_ENTRY = "entity_positions.bin";
   private static final String OLD_CACHE_ENTRY = "entity_positions.json";
   private final ReplayFile replayFile;
   private volatile Map<Integer, NavigableMap<Long, Location>> entityPositions;

   public EntityPositionTracker(ReplayFile replayFile) {
      this.replayFile = replayFile;
   }

   public void load(Consumer<Double> progressMonitor) throws IOException {
      Optional cached;
      synchronized(this.replayFile) {
         Optional<InputStream> oldCache = this.replayFile.get("entity_positions.json");
         if (oldCache.isPresent()) {
            ((InputStream)oldCache.get()).close();
            this.replayFile.remove("entity_positions.json");
         }

         cached = this.replayFile.getCache("entity_positions.bin");
      }

      if (cached.isPresent()) {
         try {
            InputStream in = (InputStream)cached.get();
            Throwable var22 = null;

            try {
               this.loadFromCache(in);
            } catch (Throwable var18) {
               var22 = var18;
               throw var18;
            } finally {
               if (in != null) {
                  if (var22 != null) {
                     try {
                        in.close();
                     } catch (Throwable var17) {
                        var22.addSuppressed(var17);
                     }
                  } else {
                     in.close();
                  }
               }

            }
         } catch (EOFException var20) {
            this.loadFromPacketData(progressMonitor);
            synchronized(this.replayFile) {
               this.replayFile.removeCache("entity_positions.bin");
            }

            this.saveToCache();
         }
      } else {
         this.loadFromPacketData(progressMonitor);
         this.saveToCache();
      }

   }

   private void loadFromCache(InputStream rawIn) throws IOException {
      NetInput in = new StreamNetInput(rawIn);
      this.entityPositions = new TreeMap();

      for(int i = in.readVarInt(); i > 0; --i) {
         int entityId = in.readVarInt();
         TreeMap<Long, Location> locationMap = new TreeMap();
         long time = 0L;

         for(int j = in.readVarInt(); j > 0; --j) {
            time += in.readVarLong();
            locationMap.put(time, new Location(in.readDouble(), in.readDouble(), in.readDouble(), in.readFloat(), in.readFloat()));
         }

         this.entityPositions.put(entityId, locationMap);
      }

   }

   private void saveToCache() throws IOException {
      synchronized(this.replayFile) {
         Optional<InputStream> cached = this.replayFile.getCache("entity_positions.bin");
         if (cached.isPresent()) {
            ((InputStream)cached.get()).close();
         } else {
            OutputStream rawOut = this.replayFile.writeCache("entity_positions.bin");
            Throwable var4 = null;

            try {
               NetOutput out = new StreamNetOutput(rawOut);
               out.writeVarInt(this.entityPositions.size());
               Iterator var6 = this.entityPositions.entrySet().iterator();

               while(var6.hasNext()) {
                  Entry<Integer, NavigableMap<Long, Location>> entry = (Entry)var6.next();
                  out.writeVarInt((Integer)entry.getKey());
                  out.writeVarInt(((NavigableMap)entry.getValue()).size());
                  long time = 0L;
                  Iterator var10 = ((NavigableMap)entry.getValue()).entrySet().iterator();

                  while(var10.hasNext()) {
                     Entry<Long, Location> locEntry = (Entry)var10.next();
                     out.writeVarLong((Long)locEntry.getKey() - time);
                     time = (Long)locEntry.getKey();
                     Location loc = (Location)locEntry.getValue();
                     out.writeDouble(loc.getX());
                     out.writeDouble(loc.getY());
                     out.writeDouble(loc.getZ());
                     out.writeFloat(loc.getYaw());
                     out.writeFloat(loc.getPitch());
                  }
               }
            } catch (Throwable var22) {
               var4 = var22;
               throw var22;
            } finally {
               if (rawOut != null) {
                  if (var4 != null) {
                     try {
                        rawOut.close();
                     } catch (Throwable var21) {
                        var4.addSuppressed(var21);
                     }
                  } else {
                     rawOut.close();
                  }
               }

            }

         }
      }
   }

   private void loadFromPacketData(Consumer<Double> progressMonitor) throws IOException {
      int replayLength;
      ReplayInputStream origIn;
      synchronized(this.replayFile) {
         ReplayMetaData metaData = this.replayFile.getMetaData();
         replayLength = Math.max(1, metaData.getDuration());
         origIn = this.replayFile.getPacketData(PacketTypeRegistry.get(metaData.getProtocolVersion(), State.LOGIN));
      }

      Map<Integer, NavigableMap<Long, Location>> entityPositions = new HashMap();
      ReplayInputStream in = origIn;
      Throwable var6 = null;

      try {
         PacketData packetData;
         try {
            while((packetData = in.readPacket()) != null) {
               Packet packet = packetData.getPacket();
               Integer entityID = PacketUtils.getEntityId(packet);
               if (entityID == null) {
                  packet.release();
               } else {
                  NavigableMap<Long, Location> positions = (NavigableMap)entityPositions.get(entityID);
                  if (positions == null) {
                     entityPositions.put(entityID, positions = new TreeMap());
                  }

                  Location oldPosition = ((NavigableMap)positions).isEmpty() ? null : (Location)((NavigableMap)positions).lastEntry().getValue();
                  Location newPosition = PacketUtils.updateLocation(oldPosition, packet);
                  if (newPosition != null) {
                     ((NavigableMap)positions).put(packetData.getTime(), newPosition);
                     double progress = (double)packetData.getTime() / (double)replayLength;
                     progressMonitor.accept(Math.min(1.0D, Math.max(0.0D, progress)));
                  }

                  packet.release();
               }
            }
         } catch (Throwable var24) {
            var6 = var24;
            throw var24;
         }
      } finally {
         if (in != null) {
            if (var6 != null) {
               try {
                  in.close();
               } catch (Throwable var22) {
                  var6.addSuppressed(var22);
               }
            } else {
               in.close();
            }
         }

      }

      this.entityPositions = entityPositions;
   }

   public Location getEntityPositionAtTimestamp(int entityID, long timestamp) {
      if (this.entityPositions == null) {
         throw new IllegalStateException("Not yet initialized.");
      } else {
         NavigableMap<Long, Location> positions = (NavigableMap)this.entityPositions.get(entityID);
         if (positions == null) {
            return null;
         } else {
            Entry<Long, Location> lower = positions.floorEntry(timestamp);
            Entry<Long, Location> higher = positions.higherEntry(timestamp);
            if (lower != null && higher != null) {
               double r = (double)(((Long)higher.getKey() - timestamp) / ((Long)higher.getKey() - (Long)lower.getKey()));
               Location l = (Location)lower.getValue();
               Location h = (Location)higher.getValue();
               return new Location(l.getX() + (h.getX() - l.getX()) * r, l.getY() + (h.getY() - l.getY()) * r, l.getZ() + (h.getZ() - l.getZ()) * r, l.getYaw() + (h.getYaw() - l.getYaw()) * (float)r, l.getPitch() + (h.getPitch() - l.getPitch()) * (float)r);
            } else {
               return null;
            }
         }
      }
   }
}
