package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 24L,
   size64 = 24L
)
public class PhysicsSettings extends CFacade {
   public static final int __DNA__SDNA_INDEX = 202;
   public static final long[] __DNA__FIELD__gravity = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__flag = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__quick_cache_step = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__rt = new long[]{20L, 20L};

   public PhysicsSettings(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected PhysicsSettings(PhysicsSettings that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CArrayFacade<Float> getGravity() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setGravity(CArrayFacade<Float> gravity) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(gravity, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, gravity)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, gravity);
         } else {
            __io__generic__copy(this.getGravity(), gravity);
         }

      }
   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 12L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 12L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, flag);
      }

   }

   public int getQuick_cache_step() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 16L) : this.__io__block.readInt(this.__io__address + 16L);
   }

   public void setQuick_cache_step(int quick_cache_step) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 16L, quick_cache_step);
      } else {
         this.__io__block.writeInt(this.__io__address + 16L, quick_cache_step);
      }

   }

   public int getRt() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 20L) : this.__io__block.readInt(this.__io__address + 20L);
   }

   public void setRt(int rt) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 20L, rt);
      } else {
         this.__io__block.writeInt(this.__io__address + 20L, rt);
      }

   }

   public CPointer<PhysicsSettings> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{PhysicsSettings.class}, this.__io__block, this.__io__blockTable);
   }
}
