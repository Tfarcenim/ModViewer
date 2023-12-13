package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 48L,
   size64 = 64L
)
public class UvSculpt extends CFacade {
   public static final int __DNA__SDNA_INDEX = 190;
   public static final long[] __DNA__FIELD__paint = new long[]{0L, 0L};

   public UvSculpt(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected UvSculpt(UvSculpt that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public Paint getPaint() throws IOException {
      return this.__io__pointersize == 8 ? new Paint(this.__io__address + 0L, this.__io__block, this.__io__blockTable) : new Paint(this.__io__address + 0L, this.__io__block, this.__io__blockTable);
   }

   public void setPaint(Paint paint) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(paint, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, paint)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, paint);
         } else {
            __io__generic__copy(this.getPaint(), paint);
         }

      }
   }

   public CPointer<UvSculpt> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{UvSculpt.class}, this.__io__block, this.__io__blockTable);
   }
}
