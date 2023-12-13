package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 36L,
   size64 = 40L
)
public class bMotionPath extends CFacade {
   public static final int __DNA__SDNA_INDEX = 345;
   public static final long[] __DNA__FIELD__points = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__length = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__start_frame = new long[]{8L, 12L};
   public static final long[] __DNA__FIELD__end_frame = new long[]{12L, 16L};
   public static final long[] __DNA__FIELD__color = new long[]{16L, 20L};
   public static final long[] __DNA__FIELD__line_thickness = new long[]{28L, 32L};
   public static final long[] __DNA__FIELD__flag = new long[]{32L, 36L};

   public bMotionPath(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected bMotionPath(bMotionPath that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<bMotionPathVert> getPoints() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bMotionPathVert.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 344), this.__io__blockTable);
   }

   public void setPoints(CPointer<bMotionPathVert> points) throws IOException {
      long __address = points == null ? 0L : points.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public int getLength() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 8L) : this.__io__block.readInt(this.__io__address + 4L);
   }

   public void setLength(int length) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 8L, length);
      } else {
         this.__io__block.writeInt(this.__io__address + 4L, length);
      }

   }

   public int getStart_frame() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 12L) : this.__io__block.readInt(this.__io__address + 8L);
   }

   public void setStart_frame(int start_frame) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 12L, start_frame);
      } else {
         this.__io__block.writeInt(this.__io__address + 8L, start_frame);
      }

   }

   public int getEnd_frame() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 16L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setEnd_frame(int end_frame) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 16L, end_frame);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, end_frame);
      }

   }

   public CArrayFacade<Float> getColor() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 20L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 16L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setColor(CArrayFacade<Float> color) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 20L;
      } else {
         __dna__offset = 16L;
      }

      if (!this.__io__equals(color, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, color)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, color);
         } else {
            __io__generic__copy(this.getColor(), color);
         }

      }
   }

   public int getLine_thickness() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 32L) : this.__io__block.readInt(this.__io__address + 28L);
   }

   public void setLine_thickness(int line_thickness) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 32L, line_thickness);
      } else {
         this.__io__block.writeInt(this.__io__address + 28L, line_thickness);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 36L) : this.__io__block.readInt(this.__io__address + 32L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 36L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 32L, flag);
      }

   }

   public CPointer<bMotionPath> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{bMotionPath.class}, this.__io__block, this.__io__blockTable);
   }
}
