package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 20L,
   size64 = 24L
)
public class GameDome extends CFacade {
   public static final int __DNA__SDNA_INDEX = 180;
   public static final long[] __DNA__FIELD__res = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__mode = new long[]{2L, 2L};
   public static final long[] __DNA__FIELD__angle = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__tilt = new long[]{6L, 6L};
   public static final long[] __DNA__FIELD__resbuf = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__pad2 = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__warptext = new long[]{16L, 16L};

   public GameDome(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected GameDome(GameDome that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public short getRes() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 0L) : this.__io__block.readShort(this.__io__address + 0L);
   }

   public void setRes(short res) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 0L, res);
      } else {
         this.__io__block.writeShort(this.__io__address + 0L, res);
      }

   }

   public short getMode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 2L) : this.__io__block.readShort(this.__io__address + 2L);
   }

   public void setMode(short mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 2L, mode);
      } else {
         this.__io__block.writeShort(this.__io__address + 2L, mode);
      }

   }

   public short getAngle() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 4L) : this.__io__block.readShort(this.__io__address + 4L);
   }

   public void setAngle(short angle) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 4L, angle);
      } else {
         this.__io__block.writeShort(this.__io__address + 4L, angle);
      }

   }

   public short getTilt() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 6L) : this.__io__block.readShort(this.__io__address + 6L);
   }

   public void setTilt(short tilt) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 6L, tilt);
      } else {
         this.__io__block.writeShort(this.__io__address + 6L, tilt);
      }

   }

   public float getResbuf() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 8L) : this.__io__block.readFloat(this.__io__address + 8L);
   }

   public void setResbuf(float resbuf) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 8L, resbuf);
      } else {
         this.__io__block.writeFloat(this.__io__address + 8L, resbuf);
      }

   }

   public float getPad2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 12L) : this.__io__block.readFloat(this.__io__address + 12L);
   }

   public void setPad2(float pad2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 12L, pad2);
      } else {
         this.__io__block.writeFloat(this.__io__address + 12L, pad2);
      }

   }

   public CPointer<Text> getWarptext() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Text.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 19), this.__io__blockTable);
   }

   public void setWarptext(CPointer<Text> warptext) throws IOException {
      long __address = warptext == null ? 0L : warptext.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      }

   }

   public CPointer<GameDome> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{GameDome.class}, this.__io__block, this.__io__blockTable);
   }
}
