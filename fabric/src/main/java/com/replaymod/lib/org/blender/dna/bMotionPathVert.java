package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 16L,
   size64 = 16L
)
public class bMotionPathVert extends CFacade {
   public static final int __DNA__SDNA_INDEX = 344;
   public static final long[] __DNA__FIELD__co = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__flag = new long[]{12L, 12L};

   public bMotionPathVert(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected bMotionPathVert(bMotionPathVert that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CArrayFacade<Float> getCo() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setCo(CArrayFacade<Float> co) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(co, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, co)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, co);
         } else {
            __io__generic__copy(this.getCo(), co);
         }

      }
   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 12L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 12L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, flag);
      }

   }

   public CPointer<bMotionPathVert> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{bMotionPathVert.class}, this.__io__block, this.__io__blockTable);
   }
}
