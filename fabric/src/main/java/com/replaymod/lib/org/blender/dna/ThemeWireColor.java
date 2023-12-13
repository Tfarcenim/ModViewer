package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 16L,
   size64 = 16L
)
public class ThemeWireColor extends CFacade {
   public static final int __DNA__SDNA_INDEX = 248;
   public static final long[] __DNA__FIELD__solid = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__select = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__active = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__flag = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__pad = new long[]{14L, 14L};

   public ThemeWireColor(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected ThemeWireColor(ThemeWireColor that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CArrayFacade<Byte> getSolid() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setSolid(CArrayFacade<Byte> solid) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(solid, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, solid)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, solid);
         } else {
            __io__generic__copy(this.getSolid(), solid);
         }

      }
   }

   public CArrayFacade<Byte> getSelect() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 4L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 4L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setSelect(CArrayFacade<Byte> select) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 4L;
      } else {
         __dna__offset = 4L;
      }

      if (!this.__io__equals(select, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, select)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, select);
         } else {
            __io__generic__copy(this.getSelect(), select);
         }

      }
   }

   public CArrayFacade<Byte> getActive() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setActive(CArrayFacade<Byte> active) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 8L;
      } else {
         __dna__offset = 8L;
      }

      if (!this.__io__equals(active, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, active)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, active);
         } else {
            __io__generic__copy(this.getActive(), active);
         }

      }
   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 12L) : this.__io__block.readShort(this.__io__address + 12L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 12L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 12L, flag);
      }

   }

   public short getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 14L) : this.__io__block.readShort(this.__io__address + 14L);
   }

   public void setPad(short pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 14L, pad);
      } else {
         this.__io__block.writeShort(this.__io__address + 14L, pad);
      }

   }

   public CPointer<ThemeWireColor> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{ThemeWireColor.class}, this.__io__block, this.__io__blockTable);
   }
}
