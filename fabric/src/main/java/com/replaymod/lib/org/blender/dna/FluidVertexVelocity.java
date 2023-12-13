package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 12L,
   size64 = 12L
)
public class FluidVertexVelocity extends CFacade {
   public static final int __DNA__SDNA_INDEX = 164;
   public static final long[] __DNA__FIELD__vel = new long[]{0L, 0L};

   public FluidVertexVelocity(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected FluidVertexVelocity(FluidVertexVelocity that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CArrayFacade<Float> getVel() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setVel(CArrayFacade<Float> vel) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(vel, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, vel)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, vel);
         } else {
            __io__generic__copy(this.getVel(), vel);
         }

      }
   }

   public CPointer<FluidVertexVelocity> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{FluidVertexVelocity.class}, this.__io__block, this.__io__blockTable);
   }
}
