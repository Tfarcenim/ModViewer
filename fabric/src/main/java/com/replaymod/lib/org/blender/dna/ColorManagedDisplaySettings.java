package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 64L,
   size64 = 64L
)
public class ColorManagedDisplaySettings extends CFacade {
   public static final int __DNA__SDNA_INDEX = 465;
   public static final long[] __DNA__FIELD__display_device = new long[]{0L, 0L};

   public ColorManagedDisplaySettings(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected ColorManagedDisplaySettings(ColorManagedDisplaySettings that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CArrayFacade<Byte> getDisplay_device() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setDisplay_device(CArrayFacade<Byte> display_device) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(display_device, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, display_device)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, display_device);
         } else {
            __io__generic__copy(this.getDisplay_device(), display_device);
         }

      }
   }

   public CPointer<ColorManagedDisplaySettings> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{ColorManagedDisplaySettings.class}, this.__io__block, this.__io__blockTable);
   }
}
