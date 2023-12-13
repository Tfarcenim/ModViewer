package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 44L,
   size64 = 44L
)
public class StripColorBalance extends CFacade {
   public static final int __DNA__SDNA_INDEX = 269;
   public static final long[] __DNA__FIELD__lift = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__gamma = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__gain = new long[]{24L, 24L};
   public static final long[] __DNA__FIELD__flag = new long[]{36L, 36L};
   public static final long[] __DNA__FIELD__pad = new long[]{40L, 40L};

   public StripColorBalance(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected StripColorBalance(StripColorBalance that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CArrayFacade<Float> getLift() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setLift(CArrayFacade<Float> lift) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(lift, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, lift)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, lift);
         } else {
            __io__generic__copy(this.getLift(), lift);
         }

      }
   }

   public CArrayFacade<Float> getGamma() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 12L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 12L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setGamma(CArrayFacade<Float> gamma) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 12L;
      } else {
         __dna__offset = 12L;
      }

      if (!this.__io__equals(gamma, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, gamma)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, gamma);
         } else {
            __io__generic__copy(this.getGamma(), gamma);
         }

      }
   }

   public CArrayFacade<Float> getGain() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 24L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 24L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setGain(CArrayFacade<Float> gain) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 24L;
      } else {
         __dna__offset = 24L;
      }

      if (!this.__io__equals(gain, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, gain)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, gain);
         } else {
            __io__generic__copy(this.getGain(), gain);
         }

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

   public int getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 40L) : this.__io__block.readInt(this.__io__address + 40L);
   }

   public void setPad(int pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 40L, pad);
      } else {
         this.__io__block.writeInt(this.__io__address + 40L, pad);
      }

   }

   public CPointer<StripColorBalance> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{StripColorBalance.class}, this.__io__block, this.__io__blockTable);
   }
}
