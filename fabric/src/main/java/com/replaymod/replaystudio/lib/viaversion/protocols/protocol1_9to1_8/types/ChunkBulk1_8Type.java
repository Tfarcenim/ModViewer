package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9to1_8.types;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.Chunk;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.ChunkSection;
import com.replaymod.replaystudio.lib.viaversion.api.type.PartialType;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.BaseChunkBulkType;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.ClientWorld;
import io.netty.buffer.ByteBuf;

public class ChunkBulk1_8Type extends PartialType<Chunk[], ClientWorld> {
   private static final int BLOCKS_PER_SECTION = 4096;
   private static final int BLOCKS_BYTES = 8192;
   private static final int LIGHT_BYTES = 2048;
   private static final int BIOME_BYTES = 256;

   public ChunkBulk1_8Type(ClientWorld clientWorld) {
      super(clientWorld, Chunk[].class);
   }

   public Class<? extends Type> getBaseClass() {
      return BaseChunkBulkType.class;
   }

   public Chunk[] read(ByteBuf input, ClientWorld world) throws Exception {
      boolean skyLight = input.readBoolean();
      int count = Type.VAR_INT.readPrimitive(input);
      Chunk[] chunks = new Chunk[count];
      ChunkBulk1_8Type.ChunkBulkSection[] chunkInfo = new ChunkBulk1_8Type.ChunkBulkSection[count];

      int i;
      for(i = 0; i < chunkInfo.length; ++i) {
         chunkInfo[i] = new ChunkBulk1_8Type.ChunkBulkSection(input, skyLight);
      }

      for(i = 0; i < chunks.length; ++i) {
         ChunkBulk1_8Type.ChunkBulkSection chunkBulkSection = chunkInfo[i];
         chunkBulkSection.readData(input);
         chunks[i] = Chunk1_8Type.deserialize(chunkBulkSection.chunkX, chunkBulkSection.chunkZ, true, skyLight, chunkBulkSection.bitmask, chunkBulkSection.getData());
      }

      return chunks;
   }

   public void write(ByteBuf output, ClientWorld world, Chunk[] chunks) throws Exception {
      boolean skyLight = false;
      Chunk[] var5 = chunks;
      int var6 = chunks.length;

      int var7;
      Chunk c;
      label42:
      for(var7 = 0; var7 < var6; ++var7) {
         c = var5[var7];
         ChunkSection[] var9 = c.getSections();
         int var10 = var9.length;

         for(int var11 = 0; var11 < var10; ++var11) {
            ChunkSection section = var9[var11];
            if (section != null && section.getLight().hasSkyLight()) {
               skyLight = true;
               break label42;
            }
         }
      }

      output.writeBoolean(skyLight);
      Type.VAR_INT.writePrimitive(output, chunks.length);
      var5 = chunks;
      var6 = chunks.length;

      for(var7 = 0; var7 < var6; ++var7) {
         c = var5[var7];
         output.writeInt(c.getX());
         output.writeInt(c.getZ());
         output.writeShort(c.getBitmask());
      }

      var5 = chunks;
      var6 = chunks.length;

      for(var7 = 0; var7 < var6; ++var7) {
         c = var5[var7];
         output.writeBytes(Chunk1_8Type.serialize(c));
      }

   }

   public static final class ChunkBulkSection {
      private final int chunkX;
      private final int chunkZ;
      private final int bitmask;
      private final byte[] data;

      public ChunkBulkSection(ByteBuf input, boolean skyLight) {
         this.chunkX = input.readInt();
         this.chunkZ = input.readInt();
         this.bitmask = input.readUnsignedShort();
         int setSections = Integer.bitCount(this.bitmask);
         this.data = new byte[setSections * (8192 + (skyLight ? 4096 : 2048)) + 256];
      }

      public void readData(ByteBuf input) {
         input.readBytes(this.data);
      }

      public int getChunkX() {
         return this.chunkX;
      }

      public int getChunkZ() {
         return this.chunkZ;
      }

      public int getBitmask() {
         return this.bitmask;
      }

      public byte[] getData() {
         return this.data;
      }
   }
}
