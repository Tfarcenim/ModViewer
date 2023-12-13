package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 4L,
   size64 = 4L
)
public class MLoopCol extends CFacade {
   public static final int __DNA__SDNA_INDEX = 69;
   public static final long[] __DNA__FIELD__r = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__g = new long[]{1L, 1L};
   public static final long[] __DNA__FIELD__b = new long[]{2L, 2L};
   public static final long[] __DNA__FIELD__a = new long[]{3L, 3L};

   public MLoopCol(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MLoopCol(MLoopCol that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public byte getR() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 0L) : this.__io__block.readByte(this.__io__address + 0L);
   }

   public void setR(byte r) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 0L, r);
      } else {
         this.__io__block.writeByte(this.__io__address + 0L, r);
      }

   }

   public byte getG() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1L) : this.__io__block.readByte(this.__io__address + 1L);
   }

   public void setG(byte g) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1L, g);
      } else {
         this.__io__block.writeByte(this.__io__address + 1L, g);
      }

   }

   public byte getB() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 2L) : this.__io__block.readByte(this.__io__address + 2L);
   }

   public void setB(byte b) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 2L, b);
      } else {
         this.__io__block.writeByte(this.__io__address + 2L, b);
      }

   }

   public byte getA() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 3L) : this.__io__block.readByte(this.__io__address + 3L);
   }

   public void setA(byte a) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 3L, a);
      } else {
         this.__io__block.writeByte(this.__io__address + 3L, a);
      }

   }

   public CPointer<MLoopCol> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MLoopCol.class}, this.__io__block, this.__io__blockTable);
   }
}
