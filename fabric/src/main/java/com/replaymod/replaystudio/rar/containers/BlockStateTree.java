package com.replaymod.replaystudio.rar.containers;

import com.replaymod.lib.com.github.steveice10.packetlib.io.NetInput;
import com.replaymod.lib.com.github.steveice10.packetlib.io.NetOutput;
import com.replaymod.replaystudio.lib.guava.collect.ListMultimap;
import com.replaymod.replaystudio.lib.guava.collect.Multimaps;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.PaletteType;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import com.replaymod.replaystudio.protocol.packets.PacketBlockChange;
import com.replaymod.replaystudio.protocol.packets.PacketChunkData;
import com.replaymod.replaystudio.protocol.registry.DimensionType;
import com.replaymod.replaystudio.rar.PacketSink;
import com.replaymod.replaystudio.util.IPosition;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BlockStateTree extends DiffStateTree<Collection<BlockStateTree.BlockChange>> {
   private final PacketTypeRegistry registry;

   public BlockStateTree(PacketTypeRegistry registry, int index) {
      super(index);
      this.registry = registry;
   }

   protected Collection<BlockStateTree.BlockChange> read(NetInput in) throws IOException {
      List<BlockStateTree.BlockChange> list = new LinkedList();

      for(int j = in.readVarInt(); j > 0; --j) {
         list.add(new BlockStateTree.BlockChange(Packet.Reader.readPosition(this.registry, in), in.readVarInt(), in.readVarInt()));
      }

      return list;
   }

   protected void discard(Collection<BlockStateTree.BlockChange> value) {
   }

   protected void play(PacketSink sink, Collection<BlockStateTree.BlockChange> value) throws IOException {
      Iterator var3 = value.iterator();

      while(var3.hasNext()) {
         BlockStateTree.BlockChange change = (BlockStateTree.BlockChange)var3.next();
         sink.accept((new PacketBlockChange(change.pos, change.to)).write(this.registry));
      }

   }

   protected void rewind(PacketSink sink, Collection<BlockStateTree.BlockChange> value) throws IOException {
      Iterator it = ((LinkedList)value).descendingIterator();

      while(it.hasNext()) {
         BlockStateTree.BlockChange update = (BlockStateTree.BlockChange)it.next();
         sink.accept(PacketBlockChange.write(this.registry, update.pos, update.from));
      }

   }

   public static class BlockChange {
      public IPosition pos;
      public int from;
      public int to;

      public BlockChange(IPosition pos, int from, int to) {
         this.pos = pos;
         this.from = from;
         this.to = to;
      }
   }

   public static class Builder extends DiffStateTree.Builder<Collection<BlockStateTree.BlockChange>> {
      private final PacketTypeRegistry registry;
      private final DimensionType dimensionType;
      private final ListMultimap<Integer, BlockStateTree.BlockChange> blocks;
      private final PacketChunkData.PalettedStorage[] currentBlockState;

      public Builder(PacketTypeRegistry registry, DimensionType dimensionType, PacketChunkData.Column column) {
         this.blocks = Multimaps.newListMultimap(this.map, LinkedList::new);
         this.registry = registry;
         this.dimensionType = dimensionType;
         this.currentBlockState = new PacketChunkData.PalettedStorage[dimensionType.getSections()];
         PacketChunkData.Chunk[] chunks = column.chunks;

         for(int i = 0; i < this.currentBlockState.length; ++i) {
            this.currentBlockState[i] = i < chunks.length && chunks[i] != null ? chunks[i].blocks.copy() : new PacketChunkData.PalettedStorage(PaletteType.BLOCKS, registry);
         }

      }

      public void update(int time, PacketBlockChange record) {
         IPosition pos = record.getPosition();
         int sectionIndex = this.dimensionType.sectionYToIndex(pos.getY() >> 4);
         if (sectionIndex >= 0 && sectionIndex < this.currentBlockState.length) {
            PacketChunkData.PalettedStorage blockStorage = this.currentBlockState[sectionIndex];
            int x = pos.getX() & 15;
            int y = pos.getY() & 15;
            int z = pos.getZ() & 15;
            int prevState = blockStorage.get(x, y, z);
            int newState = record.getId();
            blockStorage.set(x, y, z, newState);
            this.blocks.put(time, new BlockStateTree.BlockChange(pos, prevState, newState));
         }
      }

      public void update(int time, PacketChunkData.Column column) {
         int sectionY = this.dimensionType.getMinY();
         int sectionIndex = 0;
         PacketChunkData.Chunk[] var5 = column.chunks;
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            PacketChunkData.Chunk section = var5[var7];
            if (section == null) {
               ++sectionY;
               ++sectionIndex;
            } else {
               PacketChunkData.PalettedStorage toBlocks = section.blocks;
               PacketChunkData.PalettedStorage fromBlocks = this.currentBlockState[sectionIndex];

               for(int y = 0; y < 16; ++y) {
                  for(int z = 0; z < 16; ++z) {
                     for(int x = 0; x < 16; ++x) {
                        int fromState = fromBlocks.get(x, y, z);
                        int toState = toBlocks.get(x, y, z);
                        if (fromState != toState) {
                           IPosition pos = new IPosition(column.x << 4 | x, sectionY << 4 | y, column.z << 4 | z);
                           this.blocks.put(time, new BlockStateTree.BlockChange(pos, fromState, toState));
                        }
                     }
                  }
               }

               this.currentBlockState[sectionIndex] = toBlocks;
               ++sectionY;
               ++sectionIndex;
            }
         }

      }

      protected void write(NetOutput out, Collection<BlockStateTree.BlockChange> value, int time) throws IOException {
         out.writeVarInt(value.size());
         Iterator var4 = value.iterator();

         while(var4.hasNext()) {
            BlockStateTree.BlockChange blockChange = (BlockStateTree.BlockChange)var4.next();
            Packet.Writer.writePosition(this.registry, out, blockChange.pos);
            out.writeVarInt(blockChange.from);
            out.writeVarInt(blockChange.to);
         }

      }

      protected void discard(Collection<BlockStateTree.BlockChange> value) {
      }
   }
}
