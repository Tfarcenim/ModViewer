package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 8L,
   size64 = 8L
)
public class CharInfo extends CFacade {
   public static final int __DNA__SDNA_INDEX = 53;
   public static final long[] __DNA__FIELD__kern = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__mat_nr = new long[]{2L, 2L};
   public static final long[] __DNA__FIELD__flag = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__pad = new long[]{5L, 5L};
   public static final long[] __DNA__FIELD__pad2 = new long[]{6L, 6L};

   public CharInfo(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected CharInfo(CharInfo that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public short getKern() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 0L) : this.__io__block.readShort(this.__io__address + 0L);
   }

   public void setKern(short kern) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 0L, kern);
      } else {
         this.__io__block.writeShort(this.__io__address + 0L, kern);
      }

   }

   public short getMat_nr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 2L) : this.__io__block.readShort(this.__io__address + 2L);
   }

   public void setMat_nr(short mat_nr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 2L, mat_nr);
      } else {
         this.__io__block.writeShort(this.__io__address + 2L, mat_nr);
      }

   }

   public byte getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 4L) : this.__io__block.readByte(this.__io__address + 4L);
   }

   public void setFlag(byte flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 4L, flag);
      } else {
         this.__io__block.writeByte(this.__io__address + 4L, flag);
      }

   }

   public byte getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 5L) : this.__io__block.readByte(this.__io__address + 5L);
   }

   public void setPad(byte pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 5L, pad);
      } else {
         this.__io__block.writeByte(this.__io__address + 5L, pad);
      }

   }

   public short getPad2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 6L) : this.__io__block.readShort(this.__io__address + 6L);
   }

   public void setPad2(short pad2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 6L, pad2);
      } else {
         this.__io__block.writeShort(this.__io__address + 6L, pad2);
      }

   }

   public CPointer<CharInfo> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{CharInfo.class}, this.__io__block, this.__io__blockTable);
   }
}
