package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 76L,
   size64 = 76L
)
public class PaintCurvePoint extends CFacade {
   public static final int __DNA__SDNA_INDEX = 471;
   public static final long[] __DNA__FIELD__bez = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__pressure = new long[]{72L, 72L};

   public PaintCurvePoint(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected PaintCurvePoint(PaintCurvePoint that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public BezTriple getBez() throws IOException {
      return this.__io__pointersize == 8 ? new BezTriple(this.__io__address + 0L, this.__io__block, this.__io__blockTable) : new BezTriple(this.__io__address + 0L, this.__io__block, this.__io__blockTable);
   }

   public void setBez(BezTriple bez) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(bez, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, bez)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, bez);
         } else {
            __io__generic__copy(this.getBez(), bez);
         }

      }
   }

   public float getPressure() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 72L) : this.__io__block.readFloat(this.__io__address + 72L);
   }

   public void setPressure(float pressure) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 72L, pressure);
      } else {
         this.__io__block.writeFloat(this.__io__address + 72L, pressure);
      }

   }

   public CPointer<PaintCurvePoint> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{PaintCurvePoint.class}, this.__io__block, this.__io__blockTable);
   }
}
