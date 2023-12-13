package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 20L,
   size64 = 20L
)
public class MFace extends CFacade {
   public static final int __DNA__SDNA_INDEX = 59;
   public static final long[] __DNA__FIELD__v1 = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__v2 = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__v3 = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__v4 = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__mat_nr = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__edcode = new long[]{18L, 18L};
   public static final long[] __DNA__FIELD__flag = new long[]{19L, 19L};

   public MFace(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MFace(MFace that) {
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

   public int getV3() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 8L) : this.__io__block.readInt(this.__io__address + 8L);
   }

   public void setV3(int v3) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 8L, v3);
      } else {
         this.__io__block.writeInt(this.__io__address + 8L, v3);
      }

   }

   public int getV4() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 12L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setV4(int v4) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 12L, v4);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, v4);
      }

   }

   public short getMat_nr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 16L) : this.__io__block.readShort(this.__io__address + 16L);
   }

   public void setMat_nr(short mat_nr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 16L, mat_nr);
      } else {
         this.__io__block.writeShort(this.__io__address + 16L, mat_nr);
      }

   }

   public byte getEdcode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 18L) : this.__io__block.readByte(this.__io__address + 18L);
   }

   public void setEdcode(byte edcode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 18L, edcode);
      } else {
         this.__io__block.writeByte(this.__io__address + 18L, edcode);
      }

   }

   public byte getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 19L) : this.__io__block.readByte(this.__io__address + 19L);
   }

   public void setFlag(byte flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 19L, flag);
      } else {
         this.__io__block.writeByte(this.__io__address + 19L, flag);
      }

   }

   public CPointer<MFace> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MFace.class}, this.__io__block, this.__io__blockTable);
   }
}
