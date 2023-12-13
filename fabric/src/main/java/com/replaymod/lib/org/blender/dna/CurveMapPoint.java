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
public class CurveMapPoint extends CFacade {
   public static final int __DNA__SDNA_INDEX = 459;
   public static final long[] __DNA__FIELD__x = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__y = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__flag = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__shorty = new long[]{10L, 10L};

   public CurveMapPoint(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected CurveMapPoint(CurveMapPoint that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public float getX() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 0L) : this.__io__block.readFloat(this.__io__address + 0L);
   }

   public void setX(float x) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 0L, x);
      } else {
         this.__io__block.writeFloat(this.__io__address + 0L, x);
      }

   }

   public float getY() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 4L) : this.__io__block.readFloat(this.__io__address + 4L);
   }

   public void setY(float y) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 4L, y);
      } else {
         this.__io__block.writeFloat(this.__io__address + 4L, y);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 8L) : this.__io__block.readShort(this.__io__address + 8L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 8L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 8L, flag);
      }

   }

   public short getShorty() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 10L) : this.__io__block.readShort(this.__io__address + 10L);
   }

   public void setShorty(short shorty) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 10L, shorty);
      } else {
         this.__io__block.writeShort(this.__io__address + 10L, shorty);
      }

   }

   public CPointer<CurveMapPoint> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{CurveMapPoint.class}, this.__io__block, this.__io__blockTable);
   }
}
