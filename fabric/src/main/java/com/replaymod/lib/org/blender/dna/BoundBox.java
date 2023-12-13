package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 104L,
   size64 = 104L
)
public class BoundBox extends CFacade {
   public static final int __DNA__SDNA_INDEX = 151;
   public static final long[] __DNA__FIELD__vec = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__flag = new long[]{96L, 96L};
   public static final long[] __DNA__FIELD__pad = new long[]{100L, 100L};

   public BoundBox(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected BoundBox(BoundBox that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CArrayFacade<CArrayFacade<Float>> getVec() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CArrayFacade.class, Float.class};
      int[] __dna__dimensions = new int[]{8, 3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setVec(CArrayFacade<CArrayFacade<Float>> vec) throws IOException {
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

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 96L) : this.__io__block.readInt(this.__io__address + 96L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 96L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 96L, flag);
      }

   }

   public int getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 100L) : this.__io__block.readInt(this.__io__address + 100L);
   }

   public void setPad(int pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 100L, pad);
      } else {
         this.__io__block.writeInt(this.__io__address + 100L, pad);
      }

   }

   public CPointer<BoundBox> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{BoundBox.class}, this.__io__block, this.__io__blockTable);
   }
}
