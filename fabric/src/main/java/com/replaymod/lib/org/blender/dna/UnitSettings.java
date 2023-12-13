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
public class UnitSettings extends CFacade {
   public static final int __DNA__SDNA_INDEX = 201;
   public static final long[] __DNA__FIELD__scale_length = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__system = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__system_rotation = new long[]{5L, 5L};
   public static final long[] __DNA__FIELD__flag = new long[]{6L, 6L};

   public UnitSettings(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected UnitSettings(UnitSettings that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public float getScale_length() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 0L) : this.__io__block.readFloat(this.__io__address + 0L);
   }

   public void setScale_length(float scale_length) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 0L, scale_length);
      } else {
         this.__io__block.writeFloat(this.__io__address + 0L, scale_length);
      }

   }

   public byte getSystem() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 4L) : this.__io__block.readByte(this.__io__address + 4L);
   }

   public void setSystem(byte system) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 4L, system);
      } else {
         this.__io__block.writeByte(this.__io__address + 4L, system);
      }

   }

   public byte getSystem_rotation() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 5L) : this.__io__block.readByte(this.__io__address + 5L);
   }

   public void setSystem_rotation(byte system_rotation) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 5L, system_rotation);
      } else {
         this.__io__block.writeByte(this.__io__address + 5L, system_rotation);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 6L) : this.__io__block.readShort(this.__io__address + 6L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 6L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 6L, flag);
      }

   }

   public CPointer<UnitSettings> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{UnitSettings.class}, this.__io__block, this.__io__blockTable);
   }
}
