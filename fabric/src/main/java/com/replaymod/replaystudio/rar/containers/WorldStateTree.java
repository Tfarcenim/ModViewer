package com.replaymod.replaystudio.rar.containers;

import com.replaymod.lib.com.github.steveice10.packetlib.io.NetInput;
import com.replaymod.lib.com.github.steveice10.packetlib.io.NetOutput;
import com.replaymod.lib.com.github.steveice10.packetlib.tcp.io.ByteBufNetOutput;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.ProtocolVersion;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketType;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import com.replaymod.replaystudio.protocol.packets.PacketJoinGame;
import com.replaymod.replaystudio.rar.PacketSink;
import com.replaymod.replaystudio.rar.cache.ReadableCache;
import com.replaymod.replaystudio.rar.cache.WriteableCache;
import com.replaymod.replaystudio.rar.state.World;
import com.replaymod.replaystudio.util.IOBiConsumer;
import com.replaymod.replaystudio.util.IPosition;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.io.IOException;
import java.util.Map.Entry;

public class WorldStateTree extends StateTree<World> {
   private final PacketTypeRegistry registry;
   private final IOBiConsumer<PacketSink, Integer> restoreStateAfterJoinGame;
   private ReadableCache cache;
   private World activeWorld;

   public WorldStateTree(PacketTypeRegistry registry, IOBiConsumer<PacketSink, Integer> restoreStateAfterJoinGame, int index) {
      super(index);
      this.registry = registry;
      this.restoreStateAfterJoinGame = restoreStateAfterJoinGame;
   }

   public void load(PacketSink sink, ReadableCache cache) throws IOException {
      this.cache = cache;
      super.load(sink, cache);
   }

   public void unload(PacketSink sink, ReadableCache cache) throws IOException {
      if (this.activeWorld != null) {
         this.activeWorld.unload(sink, cache);
         this.activeWorld = null;
      }

      this.cache = null;
      super.unload(sink, cache);
   }

   protected World read(NetInput in) throws IOException {
      return new World(this.registry, in);
   }

   protected void discard(World value) {
   }

   private void ensureActiveWorld(World world) throws IOException {
      if (world != this.activeWorld) {
         if (this.activeWorld != null) {
            this.activeWorld.unload(Packet::release, this.cache);
            this.activeWorld = null;
         }

         if (world != null) {
            world.load(Packet::release, this.cache);
            this.activeWorld = world;
         }

      }
   }

   private World getWorldOrSwitch(PacketSink sink, int currentTimeStamp, int targetTime) throws IOException {
      Entry<Integer, World> previousEntry = this.map.floorEntry(currentTimeStamp);
      Entry<Integer, World> targetEntry = this.map.floorEntry(targetTime);
      World previousWorld = previousEntry != null ? (World)previousEntry.getValue() : null;
      World targetWorld = targetEntry != null ? (World)targetEntry.getValue() : null;
      if (previousWorld == null && targetWorld == null) {
         return null;
      } else {
         this.ensureActiveWorld(previousWorld);
         if (previousWorld == targetWorld) {
            return targetWorld;
         } else {
            if (previousWorld != null) {
               previousWorld.unload(sink, this.cache);
            }

            this.activeWorld = targetWorld;
            if (targetWorld != null) {
               if (previousWorld == null || !previousWorld.info.equals(targetWorld.info)) {
                  if (previousWorld != null && previousWorld.info.isRespawnSufficient(targetWorld.info)) {
                     sink.accept(targetWorld.info.toRespawnPacket().write(this.registry));
                  } else {
                     PacketJoinGame joinGame = targetWorld.info.toPacketJoinGame();
                     if (this.registry.olderThan(ProtocolVersion.v1_16)) {
                        joinGame.dimension = joinGame.dimension.equals("0") ? "-1" : "0";
                     }

                     sink.accept(joinGame.write(this.registry));
                     this.restoreStateAfterJoinGame.accept(sink, targetTime);
                     if (this.registry.olderThan(ProtocolVersion.v1_18_2)) {
                        sink.accept(targetWorld.info.toRespawnPacket().write(this.registry));
                     }
                  }

                  Packet packet;
                  Packet.Writer out;
                  Throwable var10;
                  if (this.registry.atLeast(ProtocolVersion.v1_18_2)) {
                     packet = new Packet(this.registry, PacketType.SpawnPosition);
                     out = packet.overwrite();
                     var10 = null;

                     try {
                        out.writePosition(new IPosition(0, 0, 0));
                        out.writeFloat(0.0F);
                     } catch (Throwable var34) {
                        var10 = var34;
                        throw var34;
                     } finally {
                        if (out != null) {
                           if (var10 != null) {
                              try {
                                 out.close();
                              } catch (Throwable var31) {
                                 var10.addSuppressed(var31);
                              }
                           } else {
                              out.close();
                           }
                        }

                     }
                  } else {
                     packet = new Packet(this.registry, PacketType.PlayerPositionRotation);
                     out = packet.overwrite();
                     var10 = null;

                     try {
                        out.writeDouble(0.0D);
                        out.writeDouble(0.0D);
                        out.writeDouble(0.0D);
                        out.writeFloat(0.0F);
                        out.writeFloat(0.0F);
                        out.writeByte(0);
                        if (packet.atLeast(ProtocolVersion.v1_9)) {
                           out.writeVarInt(0);
                        }

                        if (packet.atLeast(ProtocolVersion.v1_17) && packet.atMost(ProtocolVersion.v1_19_3)) {
                           out.writeBoolean(false);
                        }
                     } catch (Throwable var33) {
                        var10 = var33;
                        throw var33;
                     } finally {
                        if (out != null) {
                           if (var10 != null) {
                              try {
                                 out.close();
                              } catch (Throwable var32) {
                                 var10.addSuppressed(var32);
                              }
                           } else {
                              out.close();
                           }
                        }

                     }
                  }

                  sink.accept(packet);
               }

               targetWorld.load(sink, this.cache);
               targetWorld.play(sink, -1, targetTime);
            }

            return null;
         }
      }
   }

   public void play(PacketSink sink, int currentTimeStamp, int targetTime) throws IOException {
      World world = this.getWorldOrSwitch(sink, currentTimeStamp, targetTime);
      if (world != null) {
         world.play(sink, currentTimeStamp, targetTime);
      }

   }

   public void rewind(PacketSink sink, int currentTimeStamp, int targetTime) throws IOException {
      World world = this.getWorldOrSwitch(sink, currentTimeStamp, targetTime);
      if (world != null) {
         world.rewind(sink, currentTimeStamp, targetTime);
      }

   }

   public static class Builder {
      private final PacketTypeRegistry registry;
      private final WriteableCache cache;
      private final WorldStateTree.Builder.TreeBuilder builder = new WorldStateTree.Builder.TreeBuilder();
      public World.Builder world;

      public Builder(PacketTypeRegistry registry, WriteableCache cache) throws IOException {
         this.registry = registry;
         this.cache = cache;
      }

      public World.Builder newWorld(int time, World.Info info) throws IOException {
         World.Builder builder = new World.Builder(this.registry, this.cache, info);
         this.builder.put(time, this.world = builder);
         return builder;
      }

      public int build(int time) throws IOException {
         this.builder.endTime = time;
         return this.builder.build(this.cache);
      }

      private static class TreeBuilder extends StateTree.Builder<World.Builder> {
         private int endTime;

         private TreeBuilder() {
         }

         protected void write(NetOutput out, World.Builder world, int time) throws IOException {
            Integer nextTime = (Integer)this.map.higherKey(time);
            world.build(out, nextTime != null ? nextTime : this.endTime);
         }

         protected void discard(World.Builder world) {
            ByteBuf buf = Unpooled.buffer();

            try {
               world.build(new ByteBufNetOutput(buf), 0);
            } catch (IOException var4) {
               throw new RuntimeException(var4);
            }

            buf.release();
         }

         // $FF: synthetic method
         TreeBuilder(Object x0) {
            this();
         }
      }
   }
}
