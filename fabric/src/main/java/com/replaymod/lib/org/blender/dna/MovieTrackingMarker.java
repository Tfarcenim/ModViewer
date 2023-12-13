package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 64L,
   size64 = 64L
)
public class MovieTrackingMarker extends CFacade {
   public static final int __DNA__SDNA_INDEX = 549;
   public static final long[] __DNA__FIELD__pos = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__pattern_corners = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__search_min = new long[]{40L, 40L};
   public static final long[] __DNA__FIELD__search_max = new long[]{48L, 48L};
   public static final long[] __DNA__FIELD__framenr = new long[]{56L, 56L};
   public static final long[] __DNA__FIELD__flag = new long[]{60L, 60L};

   public MovieTrackingMarker(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MovieTrackingMarker(MovieTrackingMarker that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CArrayFacade<Float> getPos() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPos(CArrayFacade<Float> pos) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(pos, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pos)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pos);
         } else {
            __io__generic__copy(this.getPos(), pos);
         }

      }
   }

   public CArrayFacade<CArrayFacade<Float>> getPattern_corners() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CArrayFacade.class, Float.class};
      int[] __dna__dimensions = new int[]{4, 2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPattern_corners(CArrayFacade<CArrayFacade<Float>> pattern_corners) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 8L;
      } else {
         __dna__offset = 8L;
      }

      if (!this.__io__equals(pattern_corners, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pattern_corners)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pattern_corners);
         } else {
            __io__generic__copy(this.getPattern_corners(), pattern_corners);
         }

      }
   }

   public CArrayFacade<Float> getSearch_min() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 40L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 40L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setSearch_min(CArrayFacade<Float> search_min) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 40L;
      } else {
         __dna__offset = 40L;
      }

      if (!this.__io__equals(search_min, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, search_min)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, search_min);
         } else {
            __io__generic__copy(this.getSearch_min(), search_min);
         }

      }
   }

   public CArrayFacade<Float> getSearch_max() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 48L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 48L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setSearch_max(CArrayFacade<Float> search_max) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 48L;
      } else {
         __dna__offset = 48L;
      }

      if (!this.__io__equals(search_max, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, search_max)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, search_max);
         } else {
            __io__generic__copy(this.getSearch_max(), search_max);
         }

      }
   }

   public int getFramenr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 56L) : this.__io__block.readInt(this.__io__address + 56L);
   }

   public void setFramenr(int framenr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 56L, framenr);
      } else {
         this.__io__block.writeInt(this.__io__address + 56L, framenr);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 60L) : this.__io__block.readInt(this.__io__address + 60L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 60L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 60L, flag);
      }

   }

   public CPointer<MovieTrackingMarker> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MovieTrackingMarker.class}, this.__io__block, this.__io__blockTable);
   }
}
