package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 32L,
   size64 = 32L
)
public class CurvePaintSettings extends CFacade {
   public static final int __DNA__SDNA_INDEX = 197;
   public static final long[] __DNA__FIELD__curve_type = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__flag = new long[]{1L, 1L};
   public static final long[] __DNA__FIELD__depth_mode = new long[]{2L, 2L};
   public static final long[] __DNA__FIELD__surface_plane = new long[]{3L, 3L};
   public static final long[] __DNA__FIELD__fit_method = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__pad = new long[]{5L, 5L};
   public static final long[] __DNA__FIELD__error_threshold = new long[]{6L, 6L};
   public static final long[] __DNA__FIELD__radius_min = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__radius_max = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__radius_taper_start = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__radius_taper_end = new long[]{20L, 20L};
   public static final long[] __DNA__FIELD__surface_offset = new long[]{24L, 24L};
   public static final long[] __DNA__FIELD__corner_angle = new long[]{28L, 28L};

   public CurvePaintSettings(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected CurvePaintSettings(CurvePaintSettings that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public byte getCurve_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 0L) : this.__io__block.readByte(this.__io__address + 0L);
   }

   public void setCurve_type(byte curve_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 0L, curve_type);
      } else {
         this.__io__block.writeByte(this.__io__address + 0L, curve_type);
      }

   }

   public byte getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1L) : this.__io__block.readByte(this.__io__address + 1L);
   }

   public void setFlag(byte flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1L, flag);
      } else {
         this.__io__block.writeByte(this.__io__address + 1L, flag);
      }

   }

   public byte getDepth_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 2L) : this.__io__block.readByte(this.__io__address + 2L);
   }

   public void setDepth_mode(byte depth_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 2L, depth_mode);
      } else {
         this.__io__block.writeByte(this.__io__address + 2L, depth_mode);
      }

   }

   public byte getSurface_plane() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 3L) : this.__io__block.readByte(this.__io__address + 3L);
   }

   public void setSurface_plane(byte surface_plane) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 3L, surface_plane);
      } else {
         this.__io__block.writeByte(this.__io__address + 3L, surface_plane);
      }

   }

   public byte getFit_method() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 4L) : this.__io__block.readByte(this.__io__address + 4L);
   }

   public void setFit_method(byte fit_method) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 4L, fit_method);
      } else {
         this.__io__block.writeByte(this.__io__address + 4L, fit_method);
      }

   }

   public byte getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 5L) : this.__io__block.readByte(this.__io__address + 5L);
   }

   public void setPad(byte pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 5L, pad);
      } else {
         this.__io__block.writeByte(this.__io__address + 5L, pad);
      }

   }

   public short getError_threshold() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 6L) : this.__io__block.readShort(this.__io__address + 6L);
   }

   public void setError_threshold(short error_threshold) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 6L, error_threshold);
      } else {
         this.__io__block.writeShort(this.__io__address + 6L, error_threshold);
      }

   }

   public float getRadius_min() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 8L) : this.__io__block.readFloat(this.__io__address + 8L);
   }

   public void setRadius_min(float radius_min) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 8L, radius_min);
      } else {
         this.__io__block.writeFloat(this.__io__address + 8L, radius_min);
      }

   }

   public float getRadius_max() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 12L) : this.__io__block.readFloat(this.__io__address + 12L);
   }

   public void setRadius_max(float radius_max) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 12L, radius_max);
      } else {
         this.__io__block.writeFloat(this.__io__address + 12L, radius_max);
      }

   }

   public float getRadius_taper_start() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 16L) : this.__io__block.readFloat(this.__io__address + 16L);
   }

   public void setRadius_taper_start(float radius_taper_start) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 16L, radius_taper_start);
      } else {
         this.__io__block.writeFloat(this.__io__address + 16L, radius_taper_start);
      }

   }

   public float getRadius_taper_end() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 20L) : this.__io__block.readFloat(this.__io__address + 20L);
   }

   public void setRadius_taper_end(float radius_taper_end) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 20L, radius_taper_end);
      } else {
         this.__io__block.writeFloat(this.__io__address + 20L, radius_taper_end);
      }

   }

   public float getSurface_offset() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 24L) : this.__io__block.readFloat(this.__io__address + 24L);
   }

   public void setSurface_offset(float surface_offset) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 24L, surface_offset);
      } else {
         this.__io__block.writeFloat(this.__io__address + 24L, surface_offset);
      }

   }

   public float getCorner_angle() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 28L) : this.__io__block.readFloat(this.__io__address + 28L);
   }

   public void setCorner_angle(float corner_angle) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 28L, corner_angle);
      } else {
         this.__io__block.writeFloat(this.__io__address + 28L, corner_angle);
      }

   }

   public CPointer<CurvePaintSettings> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{CurvePaintSettings.class}, this.__io__block, this.__io__blockTable);
   }
}
