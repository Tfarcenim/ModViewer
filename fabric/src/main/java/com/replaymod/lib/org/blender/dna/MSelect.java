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
public class MSelect extends CFacade {
   public static final int __DNA__SDNA_INDEX = 70;
   public static final long[] __DNA__FIELD__index = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__type = new long[]{4L, 4L};

   public MSelect(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MSelect(MSelect that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public int getIndex() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 0L) : this.__io__block.readInt(this.__io__address + 0L);
   }

   public void setIndex(int index) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 0L, index);
      } else {
         this.__io__block.writeInt(this.__io__address + 0L, index);
      }

   }

   public int getType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 4L) : this.__io__block.readInt(this.__io__address + 4L);
   }

   public void setType(int type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 4L, type);
      } else {
         this.__io__block.writeInt(this.__io__address + 4L, type);
      }

   }

   public CPointer<MSelect> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MSelect.class}, this.__io__block, this.__io__blockTable);
   }
}
