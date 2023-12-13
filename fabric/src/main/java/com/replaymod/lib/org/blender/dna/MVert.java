package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 20L,
   size64 = 20L
)
public class MVert extends CFacade {
   public static final int __DNA__SDNA_INDEX = 63;
   public static final long[] __DNA__FIELD__co = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__no = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__flag = new long[]{18L, 18L};
   public static final long[] __DNA__FIELD__bweight = new long[]{19L, 19L};

   public MVert(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MVert(MVert that) {
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

   public CArrayFacade<Short> getNo() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Short.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 12L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 12L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setNo(CArrayFacade<Short> no) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 12L;
      } else {
         __dna__offset = 12L;
      }

      if (!this.__io__equals(no, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, no)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, no);
         } else {
            __io__generic__copy(this.getNo(), no);
         }

      }
   }

   public byte getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 18L) : this.__io__block.readByte(this.__io__address + 18L);
   }

   public void setFlag(byte flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 18L, flag);
      } else {
         this.__io__block.writeByte(this.__io__address + 18L, flag);
      }

   }

   public byte getBweight() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 19L) : this.__io__block.readByte(this.__io__address + 19L);
   }

   public void setBweight(byte bweight) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 19L, bweight);
      } else {
         this.__io__block.writeByte(this.__io__address + 19L, bweight);
      }

   }

   public CPointer<MVert> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MVert.class}, this.__io__block, this.__io__blockTable);
   }
}
