package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 8L,
   size64 = 8L
)
public class StripTransform extends CFacade {
   public static final int __DNA__SDNA_INDEX = 268;
   public static final long[] __DNA__FIELD__xofs = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__yofs = new long[]{4L, 4L};

   public StripTransform(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected StripTransform(StripTransform that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public int getXofs() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 0L) : this.__io__block.readInt(this.__io__address + 0L);
   }

   public void setXofs(int xofs) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 0L, xofs);
      } else {
         this.__io__block.writeInt(this.__io__address + 0L, xofs);
      }

   }

   public int getYofs() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 4L) : this.__io__block.readInt(this.__io__address + 4L);
   }

   public void setYofs(int yofs) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 4L, yofs);
      } else {
         this.__io__block.writeInt(this.__io__address + 4L, yofs);
      }

   }

   public CPointer<StripTransform> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{StripTransform.class}, this.__io__block, this.__io__blockTable);
   }
}
