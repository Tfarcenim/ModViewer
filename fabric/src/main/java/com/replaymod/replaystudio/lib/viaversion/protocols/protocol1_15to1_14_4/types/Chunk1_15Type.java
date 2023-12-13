package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_15to1_14_4.types;

import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.BaseChunk;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.Chunk;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.ChunkSection;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.BaseChunkType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_13;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chunk1_15Type extends Type<Chunk> {
   private static final CompoundTag[] EMPTY_COMPOUNDS = new CompoundTag[0];

   public Chunk1_15Type() {
      super(Chunk.class);
   }

   public Chunk read(ByteBuf input) throws Exception {
      int chunkX = input.readInt();
      int chunkZ = input.readInt();
      boolean fullChunk = input.readBoolean();
      int primaryBitmask = Type.VAR_INT.readPrimitive(input);
      CompoundTag heightMap = (CompoundTag)Type.NBT.read(input);
      int[] biomeData = fullChunk ? new int[1024] : null;
      if (fullChunk) {
         for(int i = 0; i < 1024; ++i) {
            biomeData[i] = input.readInt();
         }
      }

      Type.VAR_INT.readPrimitive(input);
      ChunkSection[] sections = new ChunkSection[16];

      for(int i = 0; i < 16; ++i) {
         if ((primaryBitmask & 1 << i) != 0) {
            short nonAirBlocksCount = input.readShort();
            ChunkSection section = (ChunkSection)Types1_13.CHUNK_SECTION.read(input);
            section.setNonAirBlocksCount(nonAirBlocksCount);
            sections[i] = section;
         }
      }

      List<CompoundTag> nbtData = new ArrayList(Arrays.asList((Object[])Type.NBT_ARRAY.read(input)));
      if (input.readableBytes() > 0) {
         byte[] array = (byte[])Type.REMAINING_BYTES.read(input);
         if (Via.getManager().isDebug()) {
            Via.getPlatform().getLogger().warning("Found " + array.length + " more bytes than expected while reading the chunk: " + chunkX + "/" + chunkZ);
         }
      }

      return new BaseChunk(chunkX, chunkZ, fullChunk, false, primaryBitmask, sections, biomeData, heightMap, nbtData);
   }

   public void write(ByteBuf output, Chunk chunk) throws Exception {
      output.writeInt(chunk.getX());
      output.writeInt(chunk.getZ());
      output.writeBoolean(chunk.isFullChunk());
      Type.VAR_INT.writePrimitive(output, chunk.getBitmask());
      Type.NBT.write(output, chunk.getHeightMap());
      int i;
      if (chunk.isBiomeData()) {
         int[] var3 = chunk.getBiomeData();
         i = var3.length;

         for(int var5 = 0; var5 < i; ++var5) {
            int value = var3[var5];
            output.writeInt(value);
         }
      }

      ByteBuf buf = output.alloc().buffer();

      try {
         i = 0;

         while(true) {
            if (i >= 16) {
               buf.readerIndex(0);
               Type.VAR_INT.writePrimitive(output, buf.readableBytes());
               output.writeBytes(buf);
               break;
            }

            ChunkSection section = chunk.getSections()[i];
            if (section != null) {
               buf.writeShort(section.getNonAirBlocksCount());
               Types1_13.CHUNK_SECTION.write(buf, section);
            }

            ++i;
         }
      } finally {
         buf.release();
      }

      Type.NBT_ARRAY.write(output, chunk.getBlockEntities().toArray(EMPTY_COMPOUNDS));
   }

   public Class<? extends Type> getBaseClass() {
      return BaseChunkType.class;
   }
}
