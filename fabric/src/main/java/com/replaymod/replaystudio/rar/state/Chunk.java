package com.replaymod.replaystudio.rar.state;

import com.replaymod.lib.com.github.steveice10.packetlib.io.NetInput;
import com.replaymod.lib.com.github.steveice10.packetlib.io.NetOutput;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import com.replaymod.replaystudio.protocol.packets.PacketChunkData;
import com.replaymod.replaystudio.protocol.registry.DimensionType;
import com.replaymod.replaystudio.rar.PacketSink;
import com.replaymod.replaystudio.rar.RandomAccessState;
import com.replaymod.replaystudio.rar.cache.ReadableCache;
import com.replaymod.replaystudio.rar.cache.WriteableCache;
import com.replaymod.replaystudio.rar.containers.BlockStateTree;
import java.io.IOException;

public class Chunk extends TransientThing implements RandomAccessState {
   private final BlockStateTree blocks;

   public Chunk(PacketTypeRegistry registry, NetInput in) throws IOException {
      super(registry, in);
      this.blocks = new BlockStateTree(registry, in.readVarInt());
   }

   public void load(PacketSink sink, ReadableCache cache) throws IOException {
      super.load(sink, cache);
      this.blocks.load(sink, cache);
   }

   public void unload(PacketSink sink, ReadableCache cache) throws IOException {
      super.unload(sink, cache);
      this.blocks.unload(sink, cache);
   }

   public void play(PacketSink sink, int currentTimeStamp, int targetTime) throws IOException {
      this.blocks.play(sink, currentTimeStamp, targetTime);
   }

   public void rewind(PacketSink sink, int currentTimeStamp, int targetTime) throws IOException {
      if (currentTimeStamp >= this.despawnTime) {
         this.play(sink, this.spawnTime - 1, targetTime);
      } else {
         this.blocks.rewind(sink, currentTimeStamp, targetTime);
      }
   }

   public static class Builder extends TransientThing.Builder {
      public final BlockStateTree.Builder blocks;

      public Builder(PacketTypeRegistry registry, DimensionType dimensionType, PacketChunkData.Column column) throws IOException {
         this.addSpawnPacket(PacketChunkData.load(column).write(registry));
         this.addDespawnPacket(PacketChunkData.unload(column.x, column.z).write(registry));
         this.blocks = new BlockStateTree.Builder(registry, dimensionType, column);
      }

      public void build(NetOutput out, WriteableCache cache) throws IOException {
         super.build(out, cache);
         out.writeVarInt(this.blocks.build(cache));
      }
   }
}
