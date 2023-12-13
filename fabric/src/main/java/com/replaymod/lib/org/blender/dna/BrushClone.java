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
   size64 = 24L
)
public class BrushClone extends CFacade {
   public static final int __DNA__SDNA_INDEX = 467;
   public static final long[] __DNA__FIELD__image = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__offset = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__alpha = new long[]{12L, 16L};
   public static final long[] __DNA__FIELD__pad = new long[]{16L, 20L};

   public BrushClone(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected BrushClone(BrushClone that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<Image> getImage() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Image.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 31), this.__io__blockTable);
   }

   public void setImage(CPointer<Image> image) throws IOException {
      long __address = image == null ? 0L : image.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CArrayFacade<Float> getOffset() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 4L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setOffset(CArrayFacade<Float> offset) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 8L;
      } else {
         __dna__offset = 4L;
      }

      if (!this.__io__equals(offset, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, offset)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, offset);
         } else {
            __io__generic__copy(this.getOffset(), offset);
         }

      }
   }

   public float getAlpha() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 16L) : this.__io__block.readFloat(this.__io__address + 12L);
   }

   public void setAlpha(float alpha) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 16L, alpha);
      } else {
         this.__io__block.writeFloat(this.__io__address + 12L, alpha);
      }

   }

   public float getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 20L) : this.__io__block.readFloat(this.__io__address + 16L);
   }

   public void setPad(float pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 20L, pad);
      } else {
         this.__io__block.writeFloat(this.__io__address + 16L, pad);
      }

   }

   public CPointer<BrushClone> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{BrushClone.class}, this.__io__block, this.__io__blockTable);
   }
}
