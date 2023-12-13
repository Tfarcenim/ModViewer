package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 20L,
   size64 = 24L
)
public class GP_Interpolate_Settings extends CFacade {
   public static final int __DNA__SDNA_INDEX = 194;
   public static final long[] __DNA__FIELD__flag = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__type = new long[]{2L, 2L};
   public static final long[] __DNA__FIELD__easing = new long[]{3L, 3L};
   public static final long[] __DNA__FIELD__back = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__amplitude = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__period = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__custom_ipo = new long[]{16L, 16L};

   public GP_Interpolate_Settings(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected GP_Interpolate_Settings(GP_Interpolate_Settings that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 0L) : this.__io__block.readShort(this.__io__address + 0L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 0L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 0L, flag);
      }

   }

   public byte getType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 2L) : this.__io__block.readByte(this.__io__address + 2L);
   }

   public void setType(byte type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 2L, type);
      } else {
         this.__io__block.writeByte(this.__io__address + 2L, type);
      }

   }

   public byte getEasing() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 3L) : this.__io__block.readByte(this.__io__address + 3L);
   }

   public void setEasing(byte easing) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 3L, easing);
      } else {
         this.__io__block.writeByte(this.__io__address + 3L, easing);
      }

   }

   public float getBack() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 4L) : this.__io__block.readFloat(this.__io__address + 4L);
   }

   public void setBack(float back) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 4L, back);
      } else {
         this.__io__block.writeFloat(this.__io__address + 4L, back);
      }

   }

   public float getAmplitude() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 8L) : this.__io__block.readFloat(this.__io__address + 8L);
   }

   public void setAmplitude(float amplitude) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 8L, amplitude);
      } else {
         this.__io__block.writeFloat(this.__io__address + 8L, amplitude);
      }

   }

   public float getPeriod() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 12L) : this.__io__block.readFloat(this.__io__address + 12L);
   }

   public void setPeriod(float period) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 12L, period);
      } else {
         this.__io__block.writeFloat(this.__io__address + 12L, period);
      }

   }

   public CPointer<CurveMapping> getCustom_ipo() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{CurveMapping.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 461), this.__io__blockTable);
   }

   public void setCustom_ipo(CPointer<CurveMapping> custom_ipo) throws IOException {
      long __address = custom_ipo == null ? 0L : custom_ipo.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      }

   }

   public CPointer<GP_Interpolate_Settings> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{GP_Interpolate_Settings.class}, this.__io__block, this.__io__blockTable);
   }
}
