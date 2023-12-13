package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 108L,
   size64 = 112L
)
public class GP_BrushEdit_Settings extends CFacade {
   public static final int __DNA__SDNA_INDEX = 193;
   public static final long[] __DNA__FIELD__brush = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__paintcursor = new long[]{88L, 88L};
   public static final long[] __DNA__FIELD__brushtype = new long[]{92L, 96L};
   public static final long[] __DNA__FIELD__flag = new long[]{96L, 100L};
   public static final long[] __DNA__FIELD__lock_axis = new long[]{100L, 104L};
   public static final long[] __DNA__FIELD__alpha = new long[]{104L, 108L};

   public GP_BrushEdit_Settings(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected GP_BrushEdit_Settings(GP_BrushEdit_Settings that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CArrayFacade<GP_EditBrush_Data> getBrush() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{GP_EditBrush_Data.class};
      int[] __dna__dimensions = new int[]{11};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setBrush(CArrayFacade<GP_EditBrush_Data> brush) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(brush, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, brush)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, brush);
         } else {
            __io__generic__copy(this.getBrush(), brush);
         }

      }
   }

   public CPointer<Object> getPaintcursor() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 88L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 88L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setPaintcursor(CPointer<Object> paintcursor) throws IOException {
      long __address = paintcursor == null ? 0L : paintcursor.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 88L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 88L, __address);
      }

   }

   public int getBrushtype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 96L) : this.__io__block.readInt(this.__io__address + 92L);
   }

   public void setBrushtype(int brushtype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 96L, brushtype);
      } else {
         this.__io__block.writeInt(this.__io__address + 92L, brushtype);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 100L) : this.__io__block.readInt(this.__io__address + 96L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 100L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 96L, flag);
      }

   }

   public int getLock_axis() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 104L) : this.__io__block.readInt(this.__io__address + 100L);
   }

   public void setLock_axis(int lock_axis) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 104L, lock_axis);
      } else {
         this.__io__block.writeInt(this.__io__address + 100L, lock_axis);
      }

   }

   public float getAlpha() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 108L) : this.__io__block.readFloat(this.__io__address + 104L);
   }

   public void setAlpha(float alpha) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 108L, alpha);
      } else {
         this.__io__block.writeFloat(this.__io__address + 104L, alpha);
      }

   }

   public CPointer<GP_BrushEdit_Settings> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{GP_BrushEdit_Settings.class}, this.__io__block, this.__io__blockTable);
   }
}
