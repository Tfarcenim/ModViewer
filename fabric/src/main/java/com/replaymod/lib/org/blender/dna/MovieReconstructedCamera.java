package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 72L,
   size64 = 72L
)
public class MovieReconstructedCamera extends CFacade {
   public static final int __DNA__SDNA_INDEX = 547;
   public static final long[] __DNA__FIELD__framenr = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__error = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__mat = new long[]{8L, 8L};

   public MovieReconstructedCamera(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MovieReconstructedCamera(MovieReconstructedCamera that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public int getFramenr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 0L) : this.__io__block.readInt(this.__io__address + 0L);
   }

   public void setFramenr(int framenr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 0L, framenr);
      } else {
         this.__io__block.writeInt(this.__io__address + 0L, framenr);
      }

   }

   public float getError() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 4L) : this.__io__block.readFloat(this.__io__address + 4L);
   }

   public void setError(float error) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 4L, error);
      } else {
         this.__io__block.writeFloat(this.__io__address + 4L, error);
      }

   }

   public CArrayFacade<CArrayFacade<Float>> getMat() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CArrayFacade.class, Float.class};
      int[] __dna__dimensions = new int[]{4, 4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setMat(CArrayFacade<CArrayFacade<Float>> mat) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 8L;
      } else {
         __dna__offset = 8L;
      }

      if (!this.__io__equals(mat, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, mat)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, mat);
         } else {
            __io__generic__copy(this.getMat(), mat);
         }

      }
   }

   public CPointer<MovieReconstructedCamera> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MovieReconstructedCamera.class}, this.__io__block, this.__io__blockTable);
   }
}
