package com.replaymod.replaystudio.filter;

import com.google.gson.JsonObject;
import com.replaymod.lib.com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.replaymod.lib.org.apache.commons.lang3.tuple.MutablePair;
import com.replaymod.lib.org.apache.commons.lang3.tuple.Pair;
import com.replaymod.lib.org.apache.commons.lang3.tuple.Triple;
import com.replaymod.replaystudio.PacketData;
import com.replaymod.replaystudio.Studio;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.State;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.ProtocolVersion;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketType;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import com.replaymod.replaystudio.protocol.packets.PacketBlockChange;
import com.replaymod.replaystudio.protocol.packets.PacketChunkData;
import com.replaymod.replaystudio.protocol.packets.PacketDestroyEntities;
import com.replaymod.replaystudio.protocol.packets.PacketEntityMovement;
import com.replaymod.replaystudio.protocol.packets.PacketJoinGame;
import com.replaymod.replaystudio.protocol.packets.PacketRespawn;
import com.replaymod.replaystudio.protocol.packets.PacketSetSlot;
import com.replaymod.replaystudio.protocol.packets.PacketTeam;
import com.replaymod.replaystudio.protocol.packets.PacketUpdateLight;
import com.replaymod.replaystudio.protocol.packets.PacketWindowItems;
import com.replaymod.replaystudio.protocol.registry.DimensionType;
import com.replaymod.replaystudio.stream.IteratorStream;
import com.replaymod.replaystudio.stream.PacketStream;
import com.replaymod.replaystudio.util.DPosition;
import com.replaymod.replaystudio.util.IPosition;
import com.replaymod.replaystudio.util.PacketUtils;
import com.replaymod.replaystudio.util.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class SquashFilter implements StreamFilter {
   private static final long POS_MIN = -128L;
   private static final long POS_MAX = 127L;
   private PacketTypeRegistry registry;
   private boolean forgeHandshake;
   private final List<PacketData> loginPhase;
   private final List<PacketData> unhandled;
   private final Map<Integer, SquashFilter.Entity> entities;
   private final Map<String, SquashFilter.Team> teams;
   private final Map<Integer, PacketData> mainInventoryChanges;
   private final Map<Integer, Packet> maps;
   private final List<PacketData> currentWorld;
   private final List<PacketData> currentWindow;
   private final List<PacketData> closeWindows;
   private final Map<PacketType, PacketData> latestOnly;
   private final Map<Long, SquashFilter.ChunkData> chunks;
   private final Map<Long, Long> unloadedChunks;
   private CompoundTag registries;
   private String dimension;
   private DimensionType dimensionType;
   private long prevTimestamp;

   public SquashFilter(CompoundTag registries, String dimension, DimensionType dimensionType) {
      this.loginPhase = new ArrayList();
      this.unhandled = new ArrayList();
      this.entities = new HashMap();
      this.teams = new HashMap();
      this.mainInventoryChanges = new HashMap();
      this.maps = new HashMap();
      this.currentWorld = new ArrayList();
      this.currentWindow = new ArrayList();
      this.closeWindows = new ArrayList();
      this.latestOnly = new HashMap();
      this.chunks = new HashMap();
      this.unloadedChunks = new HashMap();
      this.registries = registries;
      this.dimension = dimension;
      this.dimensionType = dimensionType;
   }

   public SquashFilter(DimensionTracker dimensionTracker) {
      this(dimensionTracker.registries, dimensionTracker.dimension, dimensionTracker.dimensionType);
   }

   public SquashFilter copy() {
      SquashFilter copy = new SquashFilter(this.registries, this.dimension, this.dimensionType);
      copy.registry = this.registry;
      copy.forgeHandshake = this.forgeHandshake;
      this.teams.forEach((key, value) -> {
         SquashFilter.Team var10000 = (SquashFilter.Team)copy.teams.put(key, value.copy());
      });
      this.entities.forEach((key, value) -> {
         SquashFilter.Entity var10000 = (SquashFilter.Entity)copy.entities.put(key, value.copy());
      });
      this.loginPhase.forEach((it) -> {
         copy.loginPhase.add(it.copy());
      });
      this.unhandled.forEach((it) -> {
         copy.unhandled.add(it.copy());
      });
      this.mainInventoryChanges.forEach((key, value) -> {
         PacketData var10000 = (PacketData)copy.mainInventoryChanges.put(key, value.copy());
      });
      this.maps.forEach((key, value) -> {
         Packet var10000 = (Packet)copy.maps.put(key, value.copy());
      });
      this.currentWorld.forEach((it) -> {
         copy.currentWorld.add(it.copy());
      });
      this.currentWindow.forEach((it) -> {
         copy.currentWindow.add(it.copy());
      });
      this.closeWindows.forEach((it) -> {
         copy.closeWindows.add(it.copy());
      });
      this.latestOnly.forEach((key, value) -> {
         PacketData var10000 = (PacketData)copy.latestOnly.put(key, value.copy());
      });
      this.chunks.forEach((key, value) -> {
         SquashFilter.ChunkData var10000 = (SquashFilter.ChunkData)copy.chunks.put(key, value.copy());
      });
      copy.unloadedChunks.putAll(this.unloadedChunks);
      copy.prevTimestamp = this.prevTimestamp;
      return copy;
   }

   private void flush() throws IOException {
      List<PacketData> flushedPackets = new ArrayList();
      this.onEnd(new IteratorStream(flushedPackets.listIterator(), (PacketStream.FilterInfo)null), 0L);
      this.loginPhase.addAll(flushedPackets);
   }

   public void release() {
      this.teams.values().forEach(SquashFilter.Team::release);
      this.entities.values().forEach(SquashFilter.Entity::release);
      this.loginPhase.forEach(PacketData::release);
      this.unhandled.forEach(PacketData::release);
      this.mainInventoryChanges.values().forEach(PacketData::release);
      this.maps.values().forEach(Packet::release);
      this.currentWorld.forEach(PacketData::release);
      this.currentWindow.forEach(PacketData::release);
      this.closeWindows.forEach(PacketData::release);
      this.latestOnly.values().forEach(PacketData::release);
   }

   public void onStart(PacketStream stream) {
   }

   public boolean onPacket(PacketStream stream, PacketData originalData) throws IOException {
      PacketData data = new PacketData(Math.max(originalData.getTime(), this.prevTimestamp + 1L), originalData.getPacket());
      this.prevTimestamp = data.getTime();
      Packet packet = data.getPacket();
      PacketType type = packet.getType();
      this.registry = packet.getRegistry();
      long lastTimestamp = data.getTime();
      Integer entityId = PacketUtils.getEntityId(packet);
      if (entityId != null) {
         SquashFilter.Entity entity;
         if (entityId == -1) {
            for(Iterator var16 = PacketUtils.getEntityIds(packet).iterator(); var16.hasNext(); entity.lastTimestamp = lastTimestamp) {
               int id = (Integer)var16.next();
               if (type != PacketType.DestroyEntity && type != PacketType.DestroyEntities) {
                  entity = (SquashFilter.Entity)this.entities.compute(id, (i, e) -> {
                     return e != null && !e.despawned ? e : new SquashFilter.Entity();
                  });
                  entity.packets.add(data.retain());
               } else {
                  entity = (SquashFilter.Entity)this.entities.computeIfAbsent(id, (i) -> {
                     return new SquashFilter.Entity();
                  });
                  entity.release();
                  entity.despawned = true;
                  if (entity.complete) {
                     this.entities.remove(id);
                  }
               }
            }
         } else {
            SquashFilter.Entity entity = (SquashFilter.Entity)this.entities.compute(entityId, (i, e) -> {
               return e != null && !e.despawned ? e : new SquashFilter.Entity();
            });
            if (type != PacketType.EntityMovement && type != PacketType.EntityPosition && type != PacketType.EntityRotation && type != PacketType.EntityPositionRotation) {
               if (type == PacketType.EntityTeleport) {
                  if (entity.teleport != null) {
                     entity.teleport.release();
                  }

                  entity.dx = entity.dy = entity.dz = 0L;
                  entity.yaw = entity.pitch = null;
                  entity.teleport = packet.retain();
               } else {
                  if (PacketUtils.isSpawnEntityPacket(packet)) {
                     entity.complete = true;
                  }

                  entity.packets.add(data.retain());
               }
            } else {
               Triple<DPosition, Pair<Float, Float>, Boolean> movement = PacketEntityMovement.getMovement(packet);
               DPosition deltaPos = (DPosition)movement.getLeft();
               Pair<Float, Float> yawPitch = (Pair)movement.getMiddle();
               if (deltaPos != null) {
                  entity.dx = (long)((double)entity.dx + deltaPos.getX() * 32.0D);
                  entity.dy = (long)((double)entity.dy + deltaPos.getY() * 32.0D);
                  entity.dz = (long)((double)entity.dz + deltaPos.getZ() * 32.0D);
               }

               if (yawPitch != null) {
                  entity.yaw = (Float)yawPitch.getKey();
                  entity.pitch = (Float)yawPitch.getValue();
               }

               entity.onGround = (Boolean)movement.getRight();
            }

            entity.lastTimestamp = lastTimestamp;
         }

         return false;
      } else {
         PacketData prev;
         Iterator var26;
         label175:
         switch(type) {
         case PlayerActionAck:
         case SpawnParticle:
         case ConfirmTransaction:
            break;
         case Respawn:
            PacketRespawn packetRespawn = PacketRespawn.read(packet, this.registries);
            String newDimension = packetRespawn.dimension;
            if (this.dimension == null) {
               this.flush();
            } else if (!this.dimension.equals(newDimension)) {
               this.currentWorld.forEach(PacketData::release);
               this.currentWorld.clear();
               this.chunks.clear();
               this.unloadedChunks.clear();
               this.currentWindow.forEach(PacketData::release);
               this.currentWindow.clear();
               this.entities.values().forEach(SquashFilter.Entity::release);
               this.entities.clear();
            }

            this.dimension = newDimension;
            this.dimensionType = packetRespawn.dimensionType;
            PacketData prev = (PacketData)this.latestOnly.put(type, data.retain());
            if (prev != null) {
               prev.release();
            }
            break;
         case JoinGame:
            this.currentWorld.forEach(PacketData::release);
            this.currentWorld.clear();
            this.chunks.clear();
            this.unloadedChunks.clear();
            this.currentWindow.forEach(PacketData::release);
            this.currentWindow.clear();
            this.entities.values().forEach(SquashFilter.Entity::release);
            this.entities.clear();
            PacketJoinGame packetJoinGame = PacketJoinGame.read(packet);
            this.registries = packetJoinGame.registry;
            this.dimension = packetJoinGame.dimension;
            this.dimensionType = packetJoinGame.dimensionType;
            this.forgeHandshake = false;
         case SetExperience:
         case PlayerAbilities:
         case Difficulty:
         case UpdateViewPosition:
         case UpdateViewDistance:
            PacketData prev = (PacketData)this.latestOnly.put(type, data.retain());
            if (prev != null) {
               prev.release();
            }
            break;
         case UpdateLight:
            PacketUpdateLight updateLight = PacketUpdateLight.read(packet);
            ((SquashFilter.ChunkData)this.chunks.computeIfAbsent(SquashFilter.ColumnPos.coordToLong(updateLight.getX(), updateLight.getZ()), (idx) -> {
               return new SquashFilter.ChunkData(data.getTime(), updateLight.getX(), updateLight.getZ());
            })).updateLight(updateLight.getData());
            break;
         case ChunkData:
         case UnloadChunk:
            PacketChunkData chunkData = PacketChunkData.read(packet, this.dimensionType.getSections());
            if (chunkData.isUnload()) {
               this.unloadChunk(data.getTime(), chunkData.getUnloadX(), chunkData.getUnloadZ());
            } else {
               this.updateChunk(data.getTime(), chunkData.getColumn());
            }
            break;
         case BulkChunkData:
            var26 = PacketChunkData.readBulk(packet).iterator();

            while(var26.hasNext()) {
               PacketChunkData.Column column = (PacketChunkData.Column)var26.next();
               this.updateChunk(data.getTime(), column);
            }

            return false;
         case BlockChange:
            this.updateBlock(data.getTime(), PacketBlockChange.read(packet));
            break;
         case MultiBlockChange:
            var26 = PacketBlockChange.readBulk(packet).iterator();

            while(var26.hasNext()) {
               PacketBlockChange change = (PacketBlockChange)var26.next();
               this.updateBlock(data.getTime(), change);
            }

            return false;
         case PlayerPositionRotation:
         case BlockBreakAnim:
         case BlockValue:
         case Explosion:
         case OpenTileEntityEditor:
         case PlayEffect:
         case PlaySound:
         case SpawnPosition:
         case UpdateSign:
         case UpdateTileEntity:
         case UpdateTime:
         case WorldBorder:
         case NotifyClient:
         case MapData:
            this.currentWorld.add(data.retain());
            break;
         case CloseWindow:
            this.currentWindow.forEach(PacketData::release);
            this.currentWindow.clear();
            this.closeWindows.add(data.retain());
            break;
         case OpenWindow:
         case TradeList:
         case WindowProperty:
            this.currentWindow.add(data.retain());
            break;
         case WindowItems:
            if (PacketWindowItems.getWindowId(packet) == 0) {
               prev = (PacketData)this.latestOnly.put(type, data.retain());
               if (prev != null) {
                  prev.release();
               }
            } else {
               this.currentWindow.add(data.retain());
            }
            break;
         case SetSlot:
            if (PacketSetSlot.getWindowId(packet) == 0) {
               prev = (PacketData)this.mainInventoryChanges.put(PacketSetSlot.getSlot(packet), data.retain());
               if (prev != null) {
                  prev.release();
               }
            } else {
               this.currentWindow.add(data.retain());
            }
            break;
         case Team:
            SquashFilter.Team team = (SquashFilter.Team)this.teams.computeIfAbsent(PacketTeam.getName(packet), (x$0) -> {
               return new SquashFilter.Team(x$0);
            });
            Iterator var13;
            String player;
            switch(PacketTeam.getAction(packet)) {
            case CREATE:
               if (team.create != null) {
                  team.create.release();
               }

               team.create = packet.retain();
               return false;
            case UPDATE:
               if (team.update != null) {
                  team.update.release();
               }

               team.update = packet.retain();
               return false;
            case REMOVE:
               if (team.remove != null) {
                  team.remove.release();
               }

               team.remove = packet.retain();
               if (team.create != null) {
                  team.release();
                  this.teams.remove(team.name);
               }

               return false;
            case ADD_PLAYER:
               var13 = PacketTeam.getPlayers(packet).iterator();

               while(var13.hasNext()) {
                  player = (String)var13.next();
                  if (!team.removed.remove(player)) {
                     team.added.add(player);
                  }
               }

               return false;
            case REMOVE_PLAYER:
               var13 = PacketTeam.getPlayers(packet).iterator();

               while(var13.hasNext()) {
                  player = (String)var13.next();
                  if (!team.added.remove(player)) {
                     team.removed.add(player);
                  }
               }
               break label175;
            default:
               return false;
            }
         default:
            if (type.getState() != State.LOGIN && !this.forgeHandshake) {
               this.unhandled.add(data.retain());
            } else {
               this.loginPhase.add(data.retain());
               this.forgeHandshake = true;
            }
         }

         return false;
      }
   }

   public void onEnd(PacketStream stream, long timestamp) throws IOException {
      boolean inBundle = false;

      PacketData respawn;
      for(Iterator var5 = this.loginPhase.iterator(); var5.hasNext(); stream.insert(timestamp, respawn.getPacket())) {
         respawn = (PacketData)var5.next();
         if (respawn.getPacket().getType() == PacketType.Bundle) {
            inBundle = !inBundle;
         }
      }

      this.loginPhase.clear();
      PacketData join = (PacketData)this.latestOnly.remove(PacketType.JoinGame);
      respawn = (PacketData)this.latestOnly.remove(PacketType.Respawn);
      if (join != null) {
         stream.insert(timestamp, join.getPacket());
      }

      if (respawn != null) {
         stream.insert(timestamp, respawn.getPacket());
      }

      PacketData updateViewPosition = (PacketData)this.latestOnly.remove(PacketType.UpdateViewPosition);
      PacketData updateViewDistance = (PacketData)this.latestOnly.remove(PacketType.UpdateViewDistance);
      if (updateViewPosition != null) {
         stream.insert(timestamp, updateViewPosition.getPacket());
      }

      if (updateViewDistance != null) {
         stream.insert(timestamp, updateViewDistance.getPacket());
      }

      List<PacketData> result = new ArrayList();
      result.addAll(this.unhandled);
      result.addAll(this.currentWorld);
      result.addAll(this.currentWindow);
      result.addAll(this.closeWindows);
      result.addAll(this.mainInventoryChanges.values());
      result.addAll(this.latestOnly.values());
      this.unhandled.clear();
      this.currentWorld.clear();
      this.currentWindow.clear();
      this.closeWindows.clear();
      this.mainInventoryChanges.clear();
      this.latestOnly.clear();
      Iterator var10 = this.entities.entrySet().iterator();

      while(true) {
         Entry e;
         while(var10.hasNext()) {
            e = (Entry)var10.next();
            SquashFilter.Entity entity = (SquashFilter.Entity)e.getValue();
            if (entity.despawned) {
               result.add(new PacketData(entity.lastTimestamp, PacketDestroyEntities.write(this.registry, (Integer)e.getKey())));
               entity.release();
            } else {
               Iterator var13 = entity.packets.iterator();

               while(true) {
                  label205:
                  while(var13.hasNext()) {
                     PacketData data = (PacketData)var13.next();
                     Packet packet = data.getPacket();
                     Iterator var16 = PacketUtils.getEntityIds(packet).iterator();

                     while(var16.hasNext()) {
                        int i = (Integer)var16.next();
                        SquashFilter.Entity other = (SquashFilter.Entity)this.entities.get(i);
                        if (other == null || other.despawned) {
                           packet.release();
                           continue label205;
                        }
                     }

                     result.add(data);
                  }

                  if (entity.teleport != null) {
                     result.add(new PacketData(entity.lastTimestamp, entity.teleport));
                  }

                  while(entity.dx != 0L || entity.dy != 0L || entity.dz != 0L) {
                     long mx = Utils.within(entity.dx, -128L, 127L);
                     long my = Utils.within(entity.dy, -128L, 127L);
                     long mz = Utils.within(entity.dz, -128L, 127L);
                     entity.dx = entity.dx - mx;
                     entity.dy = entity.dy - my;
                     entity.dz = entity.dz - mz;
                     DPosition deltaPos = new DPosition((double)mx / 32.0D, (double)my / 32.0D, (double)mz / 32.0D);
                     result.add(new PacketData(entity.lastTimestamp, PacketEntityMovement.write(this.registry, (Integer)e.getKey(), deltaPos, (Pair)null, entity.onGround)));
                  }

                  if (entity.yaw != null && entity.pitch != null) {
                     result.add(new PacketData(entity.lastTimestamp, PacketEntityMovement.write(this.registry, (Integer)e.getKey(), (DPosition)null, Pair.of(entity.yaw, entity.pitch), entity.onGround)));
                  }
                  break;
               }
            }
         }

         this.entities.clear();
         var10 = this.unloadedChunks.entrySet().iterator();

         while(var10.hasNext()) {
            e = (Entry)var10.next();
            int x = SquashFilter.ColumnPos.longToX((Long)e.getKey());
            int z = SquashFilter.ColumnPos.longToZ((Long)e.getKey());
            result.add(new PacketData((Long)e.getValue(), PacketChunkData.unload(x, z).write(this.registry)));
         }

         var10 = this.chunks.values().iterator();

         while(var10.hasNext()) {
            SquashFilter.ChunkData chunk = (SquashFilter.ChunkData)var10.next();
            PacketUpdateLight.Data lightData = new PacketUpdateLight.Data(Arrays.asList(chunk.skyLight), Arrays.asList(chunk.blockLight));
            PacketChunkData.Column column = new PacketChunkData.Column(chunk.x, chunk.z, chunk.changes, chunk.biomeData, chunk.tileEntities, chunk.heightmaps, chunk.biomes, chunk.useExistingLightData, lightData);
            if (column.isFull() || !Utils.containsOnlyNull(chunk.changes)) {
               result.add(new PacketData(chunk.firstAppearance, PacketChunkData.load(column).write(this.registry)));
            }

            Map[] var32 = chunk.blockChanges;
            int var35 = var32.length;

            for(int var37 = 0; var37 < var35; ++var37) {
               Map<Short, MutablePair<Long, PacketBlockChange>> e = var32[var37];
               if (e != null) {
                  Iterator var40 = e.values().iterator();

                  while(var40.hasNext()) {
                     MutablePair<Long, PacketBlockChange> pair = (MutablePair)var40.next();
                     result.add(new PacketData((Long)pair.getLeft(), ((PacketBlockChange)pair.getRight()).write(this.registry)));
                  }
               }
            }

            Iterator var33 = chunk.allBlockChanges.values().iterator();

            while(var33.hasNext()) {
               MutablePair<Long, PacketBlockChange> pair = (MutablePair)var33.next();
               result.add(new PacketData((Long)pair.getLeft(), ((PacketBlockChange)pair.getRight()).write(this.registry)));
            }

            if (chunk.hasLight() && this.registry.olderThan(ProtocolVersion.v1_18)) {
               result.add(new PacketData(chunk.firstAppearance, (new PacketUpdateLight(chunk.x, chunk.z, lightData)).write(this.registry)));
            }
         }

         this.chunks.clear();
         result.sort(Comparator.comparingLong(PacketData::getTime));
         PacketData pendingBundle = null;
         Iterator var23 = result.iterator();

         while(true) {
            while(var23.hasNext()) {
               PacketData data = (PacketData)var23.next();
               if (data.getPacket().getType() == PacketType.Bundle) {
                  if (!inBundle) {
                     if (pendingBundle != null) {
                        pendingBundle.release();
                        pendingBundle = null;
                        data.release();
                     } else {
                        pendingBundle = data;
                     }
                     continue;
                  }

                  inBundle = false;
               } else if (pendingBundle != null) {
                  this.add(stream, timestamp, pendingBundle.getPacket());
                  pendingBundle = null;
                  inBundle = true;
               }

               this.add(stream, timestamp, data.getPacket());
            }

            if (pendingBundle != null) {
               this.add(stream, timestamp, pendingBundle.getPacket());
            }

            var23 = this.teams.values().iterator();

            while(var23.hasNext()) {
               SquashFilter.Team team = (SquashFilter.Team)var23.next();
               if (team.create != null) {
                  this.add(stream, timestamp, team.create);
               }

               if (team.update != null) {
                  this.add(stream, timestamp, team.update);
               }

               if (team.remove != null) {
                  this.add(stream, timestamp, team.remove);
               } else {
                  if (!team.added.isEmpty()) {
                     this.add(stream, timestamp, PacketTeam.addPlayers(this.registry, team.name, team.added));
                  }

                  if (!team.removed.isEmpty()) {
                     this.add(stream, timestamp, PacketTeam.removePlayers(this.registry, team.name, team.removed));
                  }
               }
            }

            this.teams.clear();
            var23 = this.maps.values().iterator();

            while(var23.hasNext()) {
               Packet packet = (Packet)var23.next();
               this.add(stream, timestamp, packet);
            }

            this.maps.clear();
            return;
         }
      }
   }

   public String getName() {
      return "squash";
   }

   public void init(Studio studio, JsonObject config) {
   }

   private void add(PacketStream stream, long timestamp, Packet packet) {
      stream.insert(new PacketData(timestamp, packet));
   }

   private void updateBlock(long time, PacketBlockChange record) {
      IPosition pos = record.getPosition();
      ((SquashFilter.ChunkData)this.chunks.computeIfAbsent(SquashFilter.ColumnPos.coordToLong(pos.getX() >> 4, pos.getZ() >> 4), (idx) -> {
         return new SquashFilter.ChunkData(time, pos.getX() >> 4, pos.getZ() >> 4);
      })).updateBlock(time, record);
   }

   private void unloadChunk(long time, int x, int z) {
      long coord = SquashFilter.ColumnPos.coordToLong(x, z);
      this.chunks.remove(coord);
      this.unloadedChunks.put(coord, time);
   }

   private void updateChunk(long time, PacketChunkData.Column column) {
      long coord = SquashFilter.ColumnPos.coordToLong(column.x, column.z);
      this.unloadedChunks.remove(coord);
      SquashFilter.ChunkData chunk = (SquashFilter.ChunkData)this.chunks.get(coord);
      if (chunk == null) {
         this.chunks.put(coord, chunk = new SquashFilter.ChunkData(time, column.x, column.z));
      }

      chunk.update(column.chunks, column.biomeData, column.tileEntities, column.heightMaps, column.biomes, column.useExistingLightData);
      if (column.lightData != null) {
         chunk.updateLight(column.lightData);
      }

   }

   private static class ColumnPos {
      private static long coordToLong(int x, int z) {
         return (long)x << 32 | (long)z & 4294967295L;
      }

      private static int longToX(long coord) {
         return (int)(coord >> 32);
      }

      private static int longToZ(long coord) {
         return (int)(coord & 4294967295L);
      }
   }

   private class ChunkData {
      private final long firstAppearance;
      private final int x;
      private final int z;
      private PacketChunkData.Chunk[] changes = new PacketChunkData.Chunk[0];
      private byte[] biomeData;
      private Map<Short, MutablePair<Long, PacketBlockChange>>[] blockChanges = new Map[16];
      private final Map<Integer, MutablePair<Long, PacketBlockChange>> allBlockChanges = new HashMap();
      private PacketChunkData.TileEntity[] tileEntities;
      private CompoundTag heightmaps;
      private byte[][] skyLight = new byte[0][];
      private byte[][] blockLight = new byte[0][];
      private int[] biomes;
      private boolean useExistingLightData = true;

      ChunkData(long firstAppearance, int x, int z) {
         this.firstAppearance = firstAppearance;
         this.x = x;
         this.z = z;
      }

      SquashFilter.ChunkData copy() {
         SquashFilter.ChunkData copy = SquashFilter.this.new ChunkData(this.firstAppearance, this.x, this.z);
         copy.changes = new PacketChunkData.Chunk[this.changes.length];

         int i;
         for(i = 0; i < this.changes.length; ++i) {
            copy.changes[i] = this.changes[i] != null ? this.changes[i].copy() : null;
         }

         copy.biomeData = this.biomeData;

         for(i = 0; i < this.blockChanges.length; ++i) {
            if (this.blockChanges[i] != null) {
               Map<Short, MutablePair<Long, PacketBlockChange>> copyMap = new HashMap();
               copy.blockChanges[i] = copyMap;
               this.blockChanges[i].forEach((key, value) -> {
                  MutablePair var10000 = (MutablePair)copyMap.put(key, new MutablePair(value.left, value.right));
               });
            }
         }

         this.allBlockChanges.forEach((key, value) -> {
            MutablePair var10000 = (MutablePair)copy.allBlockChanges.put(key, new MutablePair(value.left, value.right));
         });
         copy.tileEntities = this.tileEntities;
         copy.heightmaps = this.heightmaps;
         copy.skyLight = (byte[][])this.skyLight.clone();
         copy.blockLight = (byte[][])this.blockLight.clone();
         copy.biomes = this.biomes;
         copy.useExistingLightData = this.useExistingLightData;
         return copy;
      }

      void update(PacketChunkData.Chunk[] newChunks, byte[] newBiomeData, PacketChunkData.TileEntity[] newTileEntities, CompoundTag newHeightmaps, int[] newBiomes, boolean useExistingLightData) {
         if (this.changes.length < newChunks.length) {
            this.changes = (PacketChunkData.Chunk[])Arrays.copyOf(this.changes, newChunks.length);
         }

         for(int i = 0; i < newChunks.length; ++i) {
            if (newChunks[i] != null) {
               this.changes[i] = newChunks[i];
               if (SquashFilter.this.registry.olderThan(ProtocolVersion.v1_17)) {
                  this.blockChanges[i] = null;
               }
            }
         }

         this.allBlockChanges.clear();
         if (newBiomeData != null) {
            this.biomeData = newBiomeData;
         }

         if (newTileEntities != null) {
            this.tileEntities = newTileEntities;
         }

         if (newHeightmaps != null) {
            this.heightmaps = newHeightmaps;
         }

         if (newBiomes != null) {
            this.biomes = newBiomes;
         }

         if (!useExistingLightData) {
            this.useExistingLightData = false;
         }

      }

      private void updateLight(PacketUpdateLight.Data data) {
         List<byte[]> skyLightUpdates = data.skyLight;
         List<byte[]> blockLightUpdates = data.blockLight;
         if (this.skyLight.length < skyLightUpdates.size()) {
            this.skyLight = (byte[][])Arrays.copyOf(this.skyLight, skyLightUpdates.size());
         }

         if (this.blockLight.length < blockLightUpdates.size()) {
            this.blockLight = (byte[][])Arrays.copyOf(this.blockLight, blockLightUpdates.size());
         }

         int i = 0;

         Iterator var5;
         byte[] light;
         for(var5 = skyLightUpdates.iterator(); var5.hasNext(); ++i) {
            light = (byte[])var5.next();
            if (light != null) {
               this.skyLight[i] = light;
            }
         }

         i = 0;

         for(var5 = blockLightUpdates.iterator(); var5.hasNext(); ++i) {
            light = (byte[])var5.next();
            if (light != null) {
               this.blockLight[i] = light;
            }
         }

      }

      private boolean hasLight() {
         byte[][] var1 = this.skyLight;
         int var2 = var1.length;

         int var3;
         byte[] light;
         for(var3 = 0; var3 < var2; ++var3) {
            light = var1[var3];
            if (light != null) {
               return true;
            }
         }

         var1 = this.blockLight;
         var2 = var1.length;

         for(var3 = 0; var3 < var2; ++var3) {
            light = var1[var3];
            if (light != null) {
               return true;
            }
         }

         return false;
      }

      private MutablePair<Long, PacketBlockChange> blockChanges(IPosition pos) {
         int x = pos.getX();
         int y = pos.getY();
         int chunkY = y / 16;
         int z = pos.getZ();
         if (SquashFilter.this.registry.atLeast(ProtocolVersion.v1_17)) {
            int indexx = y << 10 | (x & 15) << 5 | z & 15;
            return (MutablePair)this.allBlockChanges.computeIfAbsent(indexx, (k) -> {
               return MutablePair.of(0L, (Object)null);
            });
         } else if (chunkY >= 0 && chunkY < this.blockChanges.length) {
            if (this.blockChanges[chunkY] == null) {
               this.blockChanges[chunkY] = new HashMap();
            }

            short index = (short)((x & 15) << 10 | (y & 15) << 5 | z & 15);
            return (MutablePair)this.blockChanges[chunkY].computeIfAbsent(index, (k) -> {
               return MutablePair.of(0L, (Object)null);
            });
         } else {
            return null;
         }
      }

      void updateBlock(long time, PacketBlockChange change) {
         MutablePair<Long, PacketBlockChange> pair = this.blockChanges(change.getPosition());
         if (pair != null && (Long)pair.getLeft() <= time) {
            pair.setLeft(time);
            pair.setRight(change);
         }

      }
   }

   private static class Entity {
      private boolean complete;
      private boolean despawned;
      private List<PacketData> packets;
      private long lastTimestamp;
      private Packet teleport;
      private long dx;
      private long dy;
      private long dz;
      private Float yaw;
      private Float pitch;
      private boolean onGround;

      private Entity() {
         this.packets = new ArrayList();
         this.lastTimestamp = 0L;
         this.dx = 0L;
         this.dy = 0L;
         this.dz = 0L;
         this.yaw = null;
         this.pitch = null;
         this.onGround = false;
      }

      SquashFilter.Entity copy() {
         SquashFilter.Entity copy = new SquashFilter.Entity();
         copy.complete = this.complete;
         copy.despawned = this.despawned;
         this.packets.forEach((it) -> {
            copy.packets.add(it.copy());
         });
         copy.lastTimestamp = this.lastTimestamp;
         copy.teleport = this.teleport != null ? this.teleport.copy() : null;
         copy.dx = this.dx;
         copy.dy = this.dy;
         copy.dz = this.dz;
         copy.yaw = this.yaw;
         copy.pitch = this.pitch;
         copy.onGround = this.onGround;
         return copy;
      }

      void release() {
         if (this.teleport != null) {
            this.teleport.release();
            this.teleport = null;
         }

         this.packets.forEach(PacketData::release);
         this.packets.clear();
      }

      // $FF: synthetic method
      Entity(Object x0) {
         this();
      }
   }

   private static class Team {
      private final String name;
      private Packet create;
      private Packet update;
      private Packet remove;
      private final Set<String> added;
      private final Set<String> removed;

      private Team(String name) {
         this.added = new HashSet();
         this.removed = new HashSet();
         this.name = name;
      }

      public SquashFilter.Team copy() {
         SquashFilter.Team copy = new SquashFilter.Team(this.name);
         copy.create = this.create != null ? this.create.copy() : null;
         copy.update = this.update != null ? this.update.copy() : null;
         copy.remove = this.remove != null ? this.remove.copy() : null;
         copy.added.addAll(this.added);
         copy.removed.addAll(this.removed);
         return copy;
      }

      void release() {
         if (this.create != null) {
            this.create.release();
            this.create = null;
         }

         if (this.update != null) {
            this.update.release();
            this.update = null;
         }

         if (this.remove != null) {
            this.remove.release();
            this.remove = null;
         }

      }

      // $FF: synthetic method
      Team(String x0, Object x1) {
         this(x0);
      }
   }
}
