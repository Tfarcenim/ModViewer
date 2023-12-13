package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 264L,
   size64 = 264L
)
public class StripElem extends CFacade {
   public static final int __DNA__SDNA_INDEX = 266;
   public static final long[] __DNA__FIELD__name = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__orig_width = new long[]{256L, 256L};
   public static final long[] __DNA__FIELD__orig_height = new long[]{260L, 260L};

   public StripElem(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected StripElem(StripElem that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CArrayFacade<Byte> getName() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{256};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setName(CArrayFacade<Byte> name) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(name, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, name)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, name);
         } else {
            __io__generic__copy(this.getName(), name);
         }

      }
   }

   public int getOrig_width() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 256L) : this.__io__block.readInt(this.__io__address + 256L);
   }

   public void setOrig_width(int orig_width) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 256L, orig_width);
      } else {
         this.__io__block.writeInt(this.__io__address + 256L, orig_width);
      }

   }

   public int getOrig_height() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 260L) : this.__io__block.readInt(this.__io__address + 260L);
   }

   public void setOrig_height(int orig_height) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 260L, orig_height);
      } else {
         this.__io__block.writeInt(this.__io__address + 260L, orig_height);
      }

   }

   public CPointer<StripElem> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{StripElem.class}, this.__io__block, this.__io__blockTable);
   }
}
