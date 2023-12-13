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
public class SBVertex extends CFacade {
   public static final int __DNA__SDNA_INDEX = 161;
   public static final long[] __DNA__FIELD__vec = new long[]{0L, 0L};

   public SBVertex(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected SBVertex(SBVertex that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CArrayFacade<Float> getVec() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setVec(CArrayFacade<Float> vec) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(vec, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, vec)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, vec);
         } else {
            __io__generic__copy(this.getVec(), vec);
         }

      }
   }

   public CPointer<SBVertex> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{SBVertex.class}, this.__io__block, this.__io__blockTable);
   }
}
