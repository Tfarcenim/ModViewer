package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_18to1_17_1.types;

import com.replaymod.replaystudio.lib.guava.base.Preconditions;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.blockentity.BlockEntity;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.Chunk;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.Chunk1_18;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.ChunkSection;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.BaseChunkType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.ChunkSectionType1_18;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_18;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.Iterator;

public final class Chunk1_18Type extends Type<Chunk> {
   private final ChunkSectionType1_18 sectionType;
   private final int ySectionCount;

   public Chunk1_18Type(int ySectionCount, int globalPaletteBlockBits, int globalPaletteBiomeBits) {
      super(Chunk.class);
      Preconditions.checkArgument(ySectionCount > 0);
      this.sectionType = new ChunkSectionType1_18(globalPaletteBlockBits, globalPaletteBiomeBits);
      this.ySectionCount = ySectionCount;
   }

   public Chunk read(ByteBuf buffer) throws Exception {
      int chunkX = buffer.readInt();
      int chunkZ = buffer.readInt();
      CompoundTag heightMap = (CompoundTag)Type.NBT.read(buffer);
      ByteBuf sectionsBuf = buffer.readBytes(Type.VAR_INT.readPrimitive(buffer));
      ChunkSection[] sections = new ChunkSection[this.ySectionCount];

      int blockEntitiesLength;
      try {
         for(blockEntitiesLength = 0; blockEntitiesLength < this.ySectionCount; ++blockEntitiesLength) {
            sections[blockEntitiesLength] = this.sectionType.read(sectionsBuf);
         }
      } finally {
         sectionsBuf.release();
      }

      blockEntitiesLength = Type.VAR_INT.readPrimitive(buffer);
      ArrayList blockEntities = new ArrayList(blockEntitiesLength);

      for(int i = 0; i < blockEntitiesLength; ++i) {
         blockEntities.add(Types1_18.BLOCK_ENTITY.read(buffer));
      }

      return new Chunk1_18(chunkX, chunkZ, sections, heightMap, blockEntities);
   }

   public void write(ByteBuf buffer, Chunk chunk) throws Exception {
      buffer.writeInt(chunk.getX());
      buffer.writeInt(chunk.getZ());
      Type.NBT.write(buffer, chunk.getHeightMap());
      ByteBuf sectionBuffer = buffer.alloc().buffer();

      try {
         ChunkSection[] var4 = chunk.getSections();
         int var5 = var4.length;
         int var6 = 0;

         while(true) {
            if (var6 >= var5) {
               sectionBuffer.readerIndex(0);
               Type.VAR_INT.writePrimitive(buffer, sectionBuffer.readableBytes());
               buffer.writeBytes(sectionBuffer);
               break;
            }

            ChunkSection section = var4[var6];
            this.sectionType.write(sectionBuffer, section);
            ++var6;
         }
      } finally {
         sectionBuffer.release();
      }

      Type.VAR_INT.writePrimitive(buffer, chunk.blockEntities().size());
      Iterator var11 = chunk.blockEntities().iterator();

      while(var11.hasNext()) {
         BlockEntity blockEntity = (BlockEntity)var11.next();
         Types1_18.BLOCK_ENTITY.write(buffer, blockEntity);
      }

   }

   public Class<? extends Type> getBaseClass() {
      return BaseChunkType.class;
   }
}
