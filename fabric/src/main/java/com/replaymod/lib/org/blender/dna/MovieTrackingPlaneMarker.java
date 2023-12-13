package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 40L,
   size64 = 40L
)
public class MovieTrackingPlaneMarker extends CFacade {
   public static final int __DNA__SDNA_INDEX = 551;
   public static final long[] __DNA__FIELD__corners = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__framenr = new long[]{32L, 32L};
   public static final long[] __DNA__FIELD__flag = new long[]{36L, 36L};

   public MovieTrackingPlaneMarker(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MovieTrackingPlaneMarker(MovieTrackingPlaneMarker that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CArrayFacade<CArrayFacade<Float>> getCorners() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CArrayFacade.class, Float.class};
      int[] __dna__dimensions = new int[]{4, 2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setCorners(CArrayFacade<CArrayFacade<Float>> corners) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(corners, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, corners)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, corners);
         } else {
            __io__generic__copy(this.getCorners(), corners);
         }

      }
   }

   public int getFramenr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 32L) : this.__io__block.readInt(this.__io__address + 32L);
   }

   public void setFramenr(int framenr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 32L, framenr);
      } else {
         this.__io__block.writeInt(this.__io__address + 32L, framenr);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 36L) : this.__io__block.readInt(this.__io__address + 36L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 36L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 36L, flag);
      }

   }

   public CPointer<MovieTrackingPlaneMarker> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MovieTrackingPlaneMarker.class}, this.__io__block, this.__io__blockTable);
   }
}
