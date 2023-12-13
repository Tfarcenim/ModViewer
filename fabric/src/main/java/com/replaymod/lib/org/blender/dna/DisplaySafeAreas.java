package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 32L,
   size64 = 32L
)
public class DisplaySafeAreas extends CFacade {
   public static final int __DNA__SDNA_INDEX = 203;
   public static final long[] __DNA__FIELD__title = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__action = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__title_center = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__action_center = new long[]{24L, 24L};

   public DisplaySafeAreas(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected DisplaySafeAreas(DisplaySafeAreas that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CArrayFacade<Float> getTitle() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setTitle(CArrayFacade<Float> title) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(title, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, title)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, title);
         } else {
            __io__generic__copy(this.getTitle(), title);
         }

      }
   }

   public CArrayFacade<Float> getAction() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setAction(CArrayFacade<Float> action) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 8L;
      } else {
         __dna__offset = 8L;
      }

      if (!this.__io__equals(action, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, action)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, action);
         } else {
            __io__generic__copy(this.getAction(), action);
         }

      }
   }

   public CArrayFacade<Float> getTitle_center() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 16L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 16L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setTitle_center(CArrayFacade<Float> title_center) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 16L;
      } else {
         __dna__offset = 16L;
      }

      if (!this.__io__equals(title_center, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, title_center)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, title_center);
         } else {
            __io__generic__copy(this.getTitle_center(), title_center);
         }

      }
   }

   public CArrayFacade<Float> getAction_center() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 24L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 24L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setAction_center(CArrayFacade<Float> action_center) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 24L;
      } else {
         __dna__offset = 24L;
      }

      if (!this.__io__equals(action_center, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, action_center)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, action_center);
         } else {
            __io__generic__copy(this.getAction_center(), action_center);
         }

      }
   }

   public CPointer<DisplaySafeAreas> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{DisplaySafeAreas.class}, this.__io__block, this.__io__blockTable);
   }
}
