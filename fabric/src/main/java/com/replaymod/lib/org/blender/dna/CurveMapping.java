package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 336L,
   size64 = 384L
)
public class CurveMapping extends CFacade {
   public static final int __DNA__SDNA_INDEX = 461;
   public static final long[] __DNA__FIELD__flag = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__cur = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__preset = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__changed_timestamp = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__curr = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__clipr = new long[]{32L, 32L};
   public static final long[] __DNA__FIELD__cm = new long[]{48L, 48L};
   public static final long[] __DNA__FIELD__black = new long[]{288L, 336L};
   public static final long[] __DNA__FIELD__white = new long[]{300L, 348L};
   public static final long[] __DNA__FIELD__bwmul = new long[]{312L, 360L};
   public static final long[] __DNA__FIELD__sample = new long[]{324L, 372L};

   public CurveMapping(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected CurveMapping(CurveMapping that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 0L) : this.__io__block.readInt(this.__io__address + 0L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 0L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 0L, flag);
      }

   }

   public int getCur() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 4L) : this.__io__block.readInt(this.__io__address + 4L);
   }

   public void setCur(int cur) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 4L, cur);
      } else {
         this.__io__block.writeInt(this.__io__address + 4L, cur);
      }

   }

   public int getPreset() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 8L) : this.__io__block.readInt(this.__io__address + 8L);
   }

   public void setPreset(int preset) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 8L, preset);
      } else {
         this.__io__block.writeInt(this.__io__address + 8L, preset);
      }

   }

   public int getChanged_timestamp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 12L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setChanged_timestamp(int changed_timestamp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 12L, changed_timestamp);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, changed_timestamp);
      }

   }

   public rctf getCurr() throws IOException {
      return this.__io__pointersize == 8 ? new rctf(this.__io__address + 16L, this.__io__block, this.__io__blockTable) : new rctf(this.__io__address + 16L, this.__io__block, this.__io__blockTable);
   }

   public void setCurr(rctf curr) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 16L;
      } else {
         __dna__offset = 16L;
      }

      if (!this.__io__equals(curr, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, curr)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, curr);
         } else {
            __io__generic__copy(this.getCurr(), curr);
         }

      }
   }

   public rctf getClipr() throws IOException {
      return this.__io__pointersize == 8 ? new rctf(this.__io__address + 32L, this.__io__block, this.__io__blockTable) : new rctf(this.__io__address + 32L, this.__io__block, this.__io__blockTable);
   }

   public void setClipr(rctf clipr) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 32L;
      } else {
         __dna__offset = 32L;
      }

      if (!this.__io__equals(clipr, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, clipr)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, clipr);
         } else {
            __io__generic__copy(this.getClipr(), clipr);
         }

      }
   }

   public CArrayFacade<CurveMap> getCm() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CurveMap.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 48L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 48L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setCm(CArrayFacade<CurveMap> cm) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 48L;
      } else {
         __dna__offset = 48L;
      }

      if (!this.__io__equals(cm, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, cm)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, cm);
         } else {
            __io__generic__copy(this.getCm(), cm);
         }

      }
   }

   public CArrayFacade<Float> getBlack() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 336L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 288L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setBlack(CArrayFacade<Float> black) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 336L;
      } else {
         __dna__offset = 288L;
      }

      if (!this.__io__equals(black, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, black)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, black);
         } else {
            __io__generic__copy(this.getBlack(), black);
         }

      }
   }

   public CArrayFacade<Float> getWhite() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 348L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 300L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setWhite(CArrayFacade<Float> white) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 348L;
      } else {
         __dna__offset = 300L;
      }

      if (!this.__io__equals(white, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, white)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, white);
         } else {
            __io__generic__copy(this.getWhite(), white);
         }

      }
   }

   public CArrayFacade<Float> getBwmul() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 360L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 312L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setBwmul(CArrayFacade<Float> bwmul) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 360L;
      } else {
         __dna__offset = 312L;
      }

      if (!this.__io__equals(bwmul, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, bwmul)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, bwmul);
         } else {
            __io__generic__copy(this.getBwmul(), bwmul);
         }

      }
   }

   public CArrayFacade<Float> getSample() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 372L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 324L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setSample(CArrayFacade<Float> sample) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 372L;
      } else {
         __dna__offset = 324L;
      }

      if (!this.__io__equals(sample, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, sample)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, sample);
         } else {
            __io__generic__copy(this.getSample(), sample);
         }

      }
   }

   public CPointer<CurveMapping> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{CurveMapping.class}, this.__io__block, this.__io__blockTable);
   }
}
