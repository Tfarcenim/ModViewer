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
public class GP_EditBrush_Data extends CFacade {
   public static final int __DNA__SDNA_INDEX = 192;
   public static final long[] __DNA__FIELD__size = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__flag = new long[]{2L, 2L};
   public static final long[] __DNA__FIELD__strength = new long[]{4L, 4L};

   public GP_EditBrush_Data(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected GP_EditBrush_Data(GP_EditBrush_Data that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public short getSize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 0L) : this.__io__block.readShort(this.__io__address + 0L);
   }

   public void setSize(short size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 0L, size);
      } else {
         this.__io__block.writeShort(this.__io__address + 0L, size);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 2L) : this.__io__block.readShort(this.__io__address + 2L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 2L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 2L, flag);
      }

   }

   public float getStrength() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 4L) : this.__io__block.readFloat(this.__io__address + 4L);
   }

   public void setStrength(float strength) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 4L, strength);
      } else {
         this.__io__block.writeFloat(this.__io__address + 4L, strength);
      }

   }

   public CPointer<GP_EditBrush_Data> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{GP_EditBrush_Data.class}, this.__io__block, this.__io__blockTable);
   }
}
