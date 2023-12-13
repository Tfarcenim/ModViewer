package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 12L,
   size64 = 12L
)
public class MEdge extends CFacade {
   public static final int __DNA__SDNA_INDEX = 60;
   public static final long[] __DNA__FIELD__v1 = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__v2 = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__crease = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__bweight = new long[]{9L, 9L};
   public static final long[] __DNA__FIELD__flag = new long[]{10L, 10L};

   public MEdge(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MEdge(MEdge that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public int getV1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 0L) : this.__io__block.readInt(this.__io__address + 0L);
   }

   public void setV1(int v1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 0L, v1);
      } else {
         this.__io__block.writeInt(this.__io__address + 0L, v1);
      }

   }

   public int getV2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 4L) : this.__io__block.readInt(this.__io__address + 4L);
   }

   public void setV2(int v2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 4L, v2);
      } else {
         this.__io__block.writeInt(this.__io__address + 4L, v2);
      }

   }

   public byte getCrease() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 8L) : this.__io__block.readByte(this.__io__address + 8L);
   }

   public void setCrease(byte crease) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 8L, crease);
      } else {
         this.__io__block.writeByte(this.__io__address + 8L, crease);
      }

   }

   public byte getBweight() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 9L) : this.__io__block.readByte(this.__io__address + 9L);
   }

   public void setBweight(byte bweight) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 9L, bweight);
      } else {
         this.__io__block.writeByte(this.__io__address + 9L, bweight);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 10L) : this.__io__block.readShort(this.__io__address + 10L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 10L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 10L, flag);
      }

   }

   public CPointer<MEdge> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MEdge.class}, this.__io__block, this.__io__blockTable);
   }
}
