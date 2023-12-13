package com.replaymod.replaystudio.lib.viaversion.api.type.types.version;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.ChunkSection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.ChunkSectionImpl;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.DataPalette;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.PaletteType;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.util.CompactArrayUtil;
import io.netty.buffer.ByteBuf;

public class ChunkSectionType1_13 extends Type<ChunkSection> {
   private static final int GLOBAL_PALETTE = 14;

   public ChunkSectionType1_13() {
      super("Chunk Section Type", ChunkSection.class);
   }

   public ChunkSection read(ByteBuf buffer) throws Exception {
      int bitsPerBlock = buffer.readUnsignedByte();
      if (bitsPerBlock > 8) {
         bitsPerBlock = 14;
      } else if (bitsPerBlock < 4) {
         bitsPerBlock = 4;
      }

      ChunkSectionImpl chunkSection;
      if (bitsPerBlock != 14) {
         int paletteLength = Type.VAR_INT.readPrimitive(buffer);
         chunkSection = new ChunkSectionImpl(true, paletteLength);
         DataPalette blockPalette = chunkSection.palette(PaletteType.BLOCKS);

         for(int i = 0; i < paletteLength; ++i) {
            blockPalette.addId(Type.VAR_INT.readPrimitive(buffer));
         }
      } else {
         chunkSection = new ChunkSectionImpl(true);
      }

      long[] blockData = (long[])Type.LONG_ARRAY_PRIMITIVE.read(buffer);
      if (blockData.length > 0) {
         int expectedLength = (int)Math.ceil((double)(4096 * bitsPerBlock) / 64.0D);
         if (blockData.length == expectedLength) {
            DataPalette blockPalette = chunkSection.palette(PaletteType.BLOCKS);
            CompactArrayUtil.iterateCompactArray(bitsPerBlock, 4096, blockData, bitsPerBlock == 14 ? blockPalette::setIdAt : blockPalette::setPaletteIndexAt);
         }
      }

      return chunkSection;
   }

   public void write(ByteBuf buffer, ChunkSection chunkSection) throws Exception {
      int bitsPerBlock = 4;

      DataPalette blockPalette;
      for(blockPalette = chunkSection.palette(PaletteType.BLOCKS); blockPalette.size() > 1 << bitsPerBlock; ++bitsPerBlock) {
      }

      if (bitsPerBlock > 8) {
         bitsPerBlock = 14;
      }

      buffer.writeByte(bitsPerBlock);
      if (bitsPerBlock != 14) {
         Type.VAR_INT.writePrimitive(buffer, blockPalette.size());

         for(int i = 0; i < blockPalette.size(); ++i) {
            Type.VAR_INT.writePrimitive(buffer, blockPalette.idByIndex(i));
         }
      }

      long[] data = CompactArrayUtil.createCompactArray(bitsPerBlock, 4096, bitsPerBlock == 14 ? blockPalette::idAt : blockPalette::paletteIndexAt);
      Type.LONG_ARRAY_PRIMITIVE.write(buffer, data);
   }
}
