package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_1_2to1_9_3_4.types;

import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.Environment;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.BaseChunk;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.Chunk;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.ChunkSection;
import com.replaymod.replaystudio.lib.viaversion.api.type.PartialType;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.BaseChunkType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_9;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.ClientWorld;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chunk1_9_3_4Type extends PartialType<Chunk, ClientWorld> {
   public Chunk1_9_3_4Type(ClientWorld param) {
      super(param, Chunk.class);
   }

   public Chunk read(ByteBuf input, ClientWorld world) throws Exception {
      int chunkX = input.readInt();
      int chunkZ = input.readInt();
      boolean fullChunk = input.readBoolean();
      int primaryBitmask = Type.VAR_INT.readPrimitive(input);
      Type.VAR_INT.readPrimitive(input);
      ChunkSection[] sections = new ChunkSection[16];

      for(int i = 0; i < 16; ++i) {
         if ((primaryBitmask & 1 << i) != 0) {
            ChunkSection section = (ChunkSection)Types1_9.CHUNK_SECTION.read(input);
            sections[i] = section;
            section.getLight().readBlockLight(input);
            if (world.getEnvironment() == Environment.NORMAL) {
               section.getLight().readSkyLight(input);
            }
         }
      }

      int[] biomeData = fullChunk ? new int[256] : null;
      if (fullChunk) {
         for(int i = 0; i < 256; ++i) {
            biomeData[i] = input.readByte() & 255;
         }
      }

      List<CompoundTag> nbtData = new ArrayList(Arrays.asList((Object[])Type.NBT_ARRAY.read(input)));
      if (input.readableBytes() > 0) {
         byte[] array = (byte[])Type.REMAINING_BYTES.read(input);
         if (Via.getManager().isDebug()) {
            Via.getPlatform().getLogger().warning("Found " + array.length + " more bytes than expected while reading the chunk: " + chunkX + "/" + chunkZ);
         }
      }

      return new BaseChunk(chunkX, chunkZ, fullChunk, false, primaryBitmask, sections, biomeData, nbtData);
   }

   public void write(ByteBuf output, ClientWorld world, Chunk chunk) throws Exception {
      output.writeInt(chunk.getX());
      output.writeInt(chunk.getZ());
      output.writeBoolean(chunk.isFullChunk());
      Type.VAR_INT.writePrimitive(output, chunk.getBitmask());
      ByteBuf buf = output.alloc().buffer();

      try {
         for(int i = 0; i < 16; ++i) {
            ChunkSection section = chunk.getSections()[i];
            if (section != null) {
               Types1_9.CHUNK_SECTION.write(buf, section);
               section.getLight().writeBlockLight(buf);
               if (section.getLight().hasSkyLight()) {
                  section.getLight().writeSkyLight(buf);
               }
            }
         }

         buf.readerIndex(0);
         Type.VAR_INT.writePrimitive(output, buf.readableBytes() + (chunk.isBiomeData() ? 256 : 0));
         output.writeBytes(buf);
      } finally {
         buf.release();
      }

      if (chunk.isBiomeData()) {
         int[] var11 = chunk.getBiomeData();
         int var12 = var11.length;

         for(int var7 = 0; var7 < var12; ++var7) {
            int biome = var11[var7];
            output.writeByte((byte)biome);
         }
      }

      Type.NBT_ARRAY.write(output, chunk.getBlockEntities().toArray(new CompoundTag[0]));
   }

   public Class<? extends Type> getBaseClass() {
      return BaseChunkType.class;
   }
}
