package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 4L,
   size64 = 4L
)
public class bNodeInstanceKey extends CFacade {
   public static final int __DNA__SDNA_INDEX = 393;
   public static final long[] __DNA__FIELD__value = new long[]{0L, 0L};

   public bNodeInstanceKey(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected bNodeInstanceKey(bNodeInstanceKey that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public int getValue() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 0L) : this.__io__block.readInt(this.__io__address + 0L);
   }

   public void setValue(int value) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 0L, value);
      } else {
         this.__io__block.writeInt(this.__io__address + 0L, value);
      }

   }

   public CPointer<bNodeInstanceKey> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{bNodeInstanceKey.class}, this.__io__block, this.__io__blockTable);
   }
}
