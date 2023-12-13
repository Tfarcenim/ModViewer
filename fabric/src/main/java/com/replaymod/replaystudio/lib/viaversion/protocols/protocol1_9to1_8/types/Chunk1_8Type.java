package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9to1_8.types;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.Environment;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.BaseChunk;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.Chunk;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.ChunkSection;
import com.replaymod.replaystudio.lib.viaversion.api.type.PartialType;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.BaseChunkType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_8;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.ClientWorld;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.ArrayList;

public class Chunk1_8Type extends PartialType<Chunk, ClientWorld> {
   public Chunk1_8Type(ClientWorld param) {
      super(param, Chunk.class);
   }

   public Class<? extends Type> getBaseClass() {
      return BaseChunkType.class;
   }

   public Chunk read(ByteBuf input, ClientWorld world) throws Exception {
      int chunkX = input.readInt();
      int chunkZ = input.readInt();
      boolean fullChunk = input.readBoolean();
      int bitmask = input.readUnsignedShort();
      int dataLength = Type.VAR_INT.readPrimitive(input);
      byte[] data = new byte[dataLength];
      input.readBytes(data);
      return (Chunk)(fullChunk && bitmask == 0 ? new BaseChunk(chunkX, chunkZ, true, false, 0, new ChunkSection[16], (int[])null, new ArrayList()) : deserialize(chunkX, chunkZ, fullChunk, world.getEnvironment() == Environment.NORMAL, bitmask, data));
   }

   public void write(ByteBuf output, ClientWorld world, Chunk chunk) throws Exception {
      output.writeInt(chunk.getX());
      output.writeInt(chunk.getZ());
      output.writeBoolean(chunk.isFullChunk());
      output.writeShort(chunk.getBitmask());
      byte[] data = serialize(chunk);
      Type.VAR_INT.writePrimitive(output, data.length);
      output.writeBytes(data);
   }

   public static Chunk deserialize(int chunkX, int chunkZ, boolean fullChunk, boolean skyLight, int bitmask, byte[] data) throws Exception {
      ByteBuf input = Unpooled.wrappedBuffer(data);
      ChunkSection[] sections = new ChunkSection[16];
      int[] biomeData = null;

      int i;
      for(i = 0; i < sections.length; ++i) {
         if ((bitmask & 1 << i) != 0) {
            sections[i] = (ChunkSection)Types1_8.CHUNK_SECTION.read(input);
         }
      }

      for(i = 0; i < sections.length; ++i) {
         if ((bitmask & 1 << i) != 0) {
            sections[i].getLight().readBlockLight(input);
         }
      }

      if (skyLight) {
         for(i = 0; i < sections.length; ++i) {
            if ((bitmask & 1 << i) != 0) {
               sections[i].getLight().readSkyLight(input);
            }
         }
      }

      if (fullChunk) {
         biomeData = new int[256];

         for(i = 0; i < 256; ++i) {
            biomeData[i] = input.readUnsignedByte();
         }
      }

      input.release();
      return new BaseChunk(chunkX, chunkZ, fullChunk, false, bitmask, sections, biomeData, new ArrayList());
   }

   public static byte[] serialize(Chunk chunk) throws Exception {
      ByteBuf output = Unpooled.buffer();

      int i;
      for(i = 0; i < chunk.getSections().length; ++i) {
         if ((chunk.getBitmask() & 1 << i) != 0) {
            Types1_8.CHUNK_SECTION.write(output, chunk.getSections()[i]);
         }
      }

      for(i = 0; i < chunk.getSections().length; ++i) {
         if ((chunk.getBitmask() & 1 << i) != 0) {
            chunk.getSections()[i].getLight().writeBlockLight(output);
         }
      }

      for(i = 0; i < chunk.getSections().length; ++i) {
         if ((chunk.getBitmask() & 1 << i) != 0 && chunk.getSections()[i].getLight().hasSkyLight()) {
            chunk.getSections()[i].getLight().writeSkyLight(output);
         }
      }

      if (chunk.isFullChunk() && chunk.getBiomeData() != null) {
         int[] var6 = chunk.getBiomeData();
         int var3 = var6.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            int biome = var6[var4];
            output.writeByte((byte)biome);
         }
      }

      byte[] data = new byte[output.readableBytes()];
      output.readBytes(data);
      output.release();
      return data;
   }
}
