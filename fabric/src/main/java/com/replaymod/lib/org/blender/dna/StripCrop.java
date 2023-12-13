package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 16L,
   size64 = 16L
)
public class StripCrop extends CFacade {
   public static final int __DNA__SDNA_INDEX = 267;
   public static final long[] __DNA__FIELD__top = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__bottom = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__left = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__right = new long[]{12L, 12L};

   public StripCrop(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected StripCrop(StripCrop that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public int getTop() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 0L) : this.__io__block.readInt(this.__io__address + 0L);
   }

   public void setTop(int top) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 0L, top);
      } else {
         this.__io__block.writeInt(this.__io__address + 0L, top);
      }

   }

   public int getBottom() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 4L) : this.__io__block.readInt(this.__io__address + 4L);
   }

   public void setBottom(int bottom) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 4L, bottom);
      } else {
         this.__io__block.writeInt(this.__io__address + 4L, bottom);
      }

   }

   public int getLeft() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 8L) : this.__io__block.readInt(this.__io__address + 8L);
   }

   public void setLeft(int left) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 8L, left);
      } else {
         this.__io__block.writeInt(this.__io__address + 8L, left);
      }

   }

   public int getRight() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 12L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setRight(int right) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 12L, right);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, right);
      }

   }

   public CPointer<StripCrop> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{StripCrop.class}, this.__io__block, this.__io__blockTable);
   }
}
