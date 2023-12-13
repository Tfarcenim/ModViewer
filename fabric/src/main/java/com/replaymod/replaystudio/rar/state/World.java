package com.replaymod.replaystudio.rar.state;

import com.replaymod.lib.com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.replaymod.lib.com.github.steveice10.packetlib.io.NetInput;
import com.replaymod.lib.com.github.steveice10.packetlib.io.NetOutput;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.ProtocolVersion;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import com.replaymod.replaystudio.protocol.packets.PacketJoinGame;
import com.replaymod.replaystudio.protocol.packets.PacketRespawn;
import com.replaymod.replaystudio.protocol.registry.DimensionType;
import com.replaymod.replaystudio.rar.PacketSink;
import com.replaymod.replaystudio.rar.RandomAccessState;
import com.replaymod.replaystudio.rar.cache.ReadableCache;
import com.replaymod.replaystudio.rar.cache.WriteableCache;
import com.replaymod.replaystudio.rar.containers.PacketStateTree;
import com.replaymod.replaystudio.rar.containers.TransientThings;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class World implements RandomAccessState {
   public final World.Info info;
   private final TransientThings transientThings;
   private final PacketStateTree viewPosition;
   private final PacketStateTree viewDistance;
   private final PacketStateTree simulationDistance;
   private final PacketStateTree worldTimes;
   private final PacketStateTree thunderStrengths;

   public World(PacketTypeRegistry registry, NetInput in) throws IOException {
      this.info = new World.Info(registry, in);
      this.transientThings = new TransientThings(registry, in.readVarInt());
      this.viewPosition = new PacketStateTree(registry, in.readVarInt());
      this.viewDistance = new PacketStateTree(registry, in.readVarInt());
      this.simulationDistance = new PacketStateTree(registry, in.readVarInt());
      this.worldTimes = new PacketStateTree(registry, in.readVarInt());
      this.thunderStrengths = new PacketStateTree(registry, in.readVarInt());
   }

   public void load(PacketSink sink, ReadableCache cache) throws IOException {
      this.viewPosition.load(sink, cache);
      this.viewDistance.load(sink, cache);
      this.simulationDistance.load(sink, cache);
      this.transientThings.load(sink, cache);
      this.worldTimes.load(sink, cache);
      this.thunderStrengths.load(sink, cache);
   }

   public void unload(PacketSink sink, ReadableCache cache) throws IOException {
      this.viewPosition.unload(sink, cache);
      this.viewDistance.unload(sink, cache);
      this.simulationDistance.unload(sink, cache);
      this.transientThings.unload(sink, cache);
      this.worldTimes.unload(sink, cache);
      this.thunderStrengths.unload(sink, cache);
   }

   public void play(PacketSink sink, int currentTimeStamp, int targetTime) throws IOException {
      this.viewPosition.play(sink, currentTimeStamp, targetTime);
      this.viewDistance.play(sink, currentTimeStamp, targetTime);
      this.simulationDistance.play(sink, currentTimeStamp, targetTime);
      this.transientThings.play(sink, currentTimeStamp, targetTime);
      this.worldTimes.play(sink, currentTimeStamp, targetTime);
      this.thunderStrengths.play(sink, currentTimeStamp, targetTime);
   }

   public void rewind(PacketSink sink, int currentTimeStamp, int targetTime) throws IOException {
      this.viewPosition.rewind(sink, currentTimeStamp, targetTime);
      this.viewDistance.rewind(sink, currentTimeStamp, targetTime);
      this.simulationDistance.rewind(sink, currentTimeStamp, targetTime);
      this.transientThings.rewind(sink, currentTimeStamp, targetTime);
      this.worldTimes.rewind(sink, currentTimeStamp, targetTime);
      this.thunderStrengths.rewind(sink, currentTimeStamp, targetTime);
   }

   public static final class Info {
      public final List<String> dimensions;
      public final CompoundTag registry;
      public final String dimension;
      public final DimensionType dimensionType;
      public final long seed;
      public final int difficulty;
      public final boolean debugWorld;
      public final boolean flatWorld;

      public Info(List<String> dimensions, CompoundTag registry, String dimension, DimensionType dimensionType, long seed, int difficulty, boolean debugWorld, boolean flatWorld) {
         this.dimensions = dimensions;
         this.registry = registry;
         this.dimension = dimension;
         this.dimensionType = dimensionType;
         this.seed = seed;
         this.difficulty = difficulty;
         this.debugWorld = debugWorld;
         this.flatWorld = flatWorld;
      }

      public Info(PacketJoinGame packet) {
         this(packet.dimensions, packet.registry, packet.dimension, packet.dimensionType, packet.seed, packet.difficulty, packet.debugWorld, packet.flatWorld);
      }

      public Info(List<String> dimensions, CompoundTag registry, PacketRespawn packet) {
         this(dimensions, registry, packet.dimension, packet.dimensionType, packet.seed, packet.difficulty, packet.debugWorld, packet.flatWorld);
      }

      public Info(World.Info info, PacketRespawn packet) {
         this(info.dimensions, info.registry, packet);
      }

      public Info(PacketTypeRegistry registry, NetInput in) throws IOException {
         List var10001;
         if (registry.atLeast(ProtocolVersion.v1_16)) {
            in.getClass();
            var10001 = Packet.Reader.readList(registry, in, in::readString);
         } else {
            var10001 = null;
         }

         this(var10001, registry.atLeast(ProtocolVersion.v1_16) ? Packet.Reader.readNBT(registry, in) : null, in.readString(), new DimensionType((CompoundTag)Objects.requireNonNull(Packet.Reader.readNBT(registry, in)), in.readString()), in.readLong(), in.readByte(), in.readBoolean(), in.readBoolean());
      }

      public void write(PacketTypeRegistry registry, NetOutput out) throws IOException {
         if (registry.atLeast(ProtocolVersion.v1_16)) {
            Packet.Writer.writeList(registry, out, this.dimensions, out::writeString);
            Packet.Writer.writeNBT(registry, out, this.registry);
         }

         out.writeString(this.dimension);
         Packet.Writer.writeNBT(registry, out, this.dimensionType.getTag());
         out.writeString(this.dimensionType.getName());
         out.writeLong(this.seed);
         out.writeByte(this.difficulty);
         out.writeBoolean(this.debugWorld);
         out.writeBoolean(this.flatWorld);
      }

      public boolean isRespawnSufficient(World.Info other) {
         return Objects.equals(this.dimensions, other.dimensions) && Objects.equals(this.registry, other.registry) && !this.dimension.equals(other.dimension);
      }

      public PacketJoinGame toPacketJoinGame() {
         PacketJoinGame joinGame = new PacketJoinGame();
         joinGame.entityId = -1789435;
         joinGame.gameMode = 3;
         joinGame.prevGameMode = 3;
         joinGame.dimensions = this.dimensions;
         joinGame.registry = this.registry;
         joinGame.dimensionType = this.dimensionType;
         joinGame.dimension = this.dimension;
         joinGame.seed = this.seed;
         joinGame.difficulty = this.difficulty;
         joinGame.debugWorld = this.debugWorld;
         joinGame.flatWorld = this.flatWorld;
         return joinGame;
      }

      public PacketRespawn toRespawnPacket() {
         PacketRespawn respawn = new PacketRespawn();
         respawn.gameMode = 3;
         respawn.prevGameMode = 3;
         respawn.dimensionType = this.dimensionType;
         respawn.dimension = this.dimension;
         respawn.seed = this.seed;
         respawn.difficulty = this.difficulty;
         respawn.debugWorld = this.debugWorld;
         respawn.flatWorld = this.flatWorld;
         return respawn;
      }

      public boolean equals(Object o) {
         if (this == o) {
            return true;
         } else if (o != null && this.getClass() == o.getClass()) {
            World.Info info = (World.Info)o;
            return this.seed == info.seed && this.difficulty == info.difficulty && this.debugWorld == info.debugWorld && this.flatWorld == info.flatWorld && Objects.equals(this.dimensions, info.dimensions) && Objects.equals(this.registry, info.registry) && this.dimension.equals(info.dimension) && this.dimensionType.equals(info.dimensionType);
         } else {
            return false;
         }
      }

      public int hashCode() {
         return Objects.hash(new Object[]{this.dimensions, this.registry, this.dimension, this.dimensionType, this.seed, this.difficulty, this.debugWorld, this.flatWorld});
      }
   }

   public static class Builder {
      private final WriteableCache cache;
      private final PacketTypeRegistry registry;
      public final World.Info info;
      public final TransientThings.Builder transientThings;
      public final PacketStateTree.Builder viewPosition = new PacketStateTree.Builder();
      public final PacketStateTree.Builder viewDistance = new PacketStateTree.Builder();
      public final PacketStateTree.Builder simulationDistance = new PacketStateTree.Builder();
      public final PacketStateTree.Builder worldTimes = new PacketStateTree.Builder();
      public final PacketStateTree.Builder thunderStrengths = new PacketStateTree.Builder();

      public Builder(PacketTypeRegistry registry, WriteableCache cache, World.Info info) throws IOException {
         this.registry = registry;
         this.cache = cache;
         this.info = info;
         this.transientThings = new TransientThings.Builder(registry, cache, info.dimensionType);
      }

      public void build(NetOutput out, int time) throws IOException {
         this.info.write(this.registry, out);
         out.writeVarInt(this.transientThings.build(time));
         out.writeVarInt(this.viewPosition.build(this.cache));
         out.writeVarInt(this.viewDistance.build(this.cache));
         out.writeVarInt(this.simulationDistance.build(this.cache));
         out.writeVarInt(this.worldTimes.build(this.cache));
         out.writeVarInt(this.thunderStrengths.build(this.cache));
      }
   }
}
