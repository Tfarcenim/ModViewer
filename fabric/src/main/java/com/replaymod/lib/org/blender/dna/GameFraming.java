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
public class GameFraming extends CFacade {
   public static final int __DNA__SDNA_INDEX = 181;
   public static final long[] __DNA__FIELD__col = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__type = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__pad1 = new long[]{13L, 13L};
   public static final long[] __DNA__FIELD__pad2 = new long[]{14L, 14L};
   public static final long[] __DNA__FIELD__pad3 = new long[]{15L, 15L};

   public GameFraming(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected GameFraming(GameFraming that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CArrayFacade<Float> getCol() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setCol(CArrayFacade<Float> col) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(col, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, col)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, col);
         } else {
            __io__generic__copy(this.getCol(), col);
         }

      }
   }

   public byte getType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 12L) : this.__io__block.readByte(this.__io__address + 12L);
   }

   public void setType(byte type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 12L, type);
      } else {
         this.__io__block.writeByte(this.__io__address + 12L, type);
      }

   }

   public byte getPad1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 13L) : this.__io__block.readByte(this.__io__address + 13L);
   }

   public void setPad1(byte pad1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 13L, pad1);
      } else {
         this.__io__block.writeByte(this.__io__address + 13L, pad1);
      }

   }

   public byte getPad2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 14L) : this.__io__block.readByte(this.__io__address + 14L);
   }

   public void setPad2(byte pad2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 14L, pad2);
      } else {
         this.__io__block.writeByte(this.__io__address + 14L, pad2);
      }

   }

   public byte getPad3() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 15L) : this.__io__block.readByte(this.__io__address + 15L);
   }

   public void setPad3(byte pad3) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 15L, pad3);
      } else {
         this.__io__block.writeByte(this.__io__address + 15L, pad3);
      }

   }

   public CPointer<GameFraming> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{GameFraming.class}, this.__io__block, this.__io__blockTable);
   }
}
