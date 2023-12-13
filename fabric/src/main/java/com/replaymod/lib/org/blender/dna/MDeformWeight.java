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
public class MDeformWeight extends CFacade {
   public static final int __DNA__SDNA_INDEX = 61;
   public static final long[] __DNA__FIELD__def_nr = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__weight = new long[]{4L, 4L};

   public MDeformWeight(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MDeformWeight(MDeformWeight that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public int getDef_nr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 0L) : this.__io__block.readInt(this.__io__address + 0L);
   }

   public void setDef_nr(int def_nr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 0L, def_nr);
      } else {
         this.__io__block.writeInt(this.__io__address + 0L, def_nr);
      }

   }

   public float getWeight() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 4L) : this.__io__block.readFloat(this.__io__address + 4L);
   }

   public void setWeight(float weight) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 4L, weight);
      } else {
         this.__io__block.writeFloat(this.__io__address + 4L, weight);
      }

   }

   public CPointer<MDeformWeight> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MDeformWeight.class}, this.__io__block, this.__io__blockTable);
   }
}
