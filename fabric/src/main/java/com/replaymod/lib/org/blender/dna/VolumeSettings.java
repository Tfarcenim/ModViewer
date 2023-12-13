package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 88L,
   size64 = 88L
)
public class VolumeSettings extends CFacade {
   public static final int __DNA__SDNA_INDEX = 43;
   public static final long[] __DNA__FIELD__density = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__emission = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__scattering = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__reflection = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__emission_col = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__transmission_col = new long[]{28L, 28L};
   public static final long[] __DNA__FIELD__reflection_col = new long[]{40L, 40L};
   public static final long[] __DNA__FIELD__density_scale = new long[]{52L, 52L};
   public static final long[] __DNA__FIELD__depth_cutoff = new long[]{56L, 56L};
   public static final long[] __DNA__FIELD__asymmetry = new long[]{60L, 60L};
   public static final long[] __DNA__FIELD__stepsize_type = new long[]{64L, 64L};
   public static final long[] __DNA__FIELD__shadeflag = new long[]{66L, 66L};
   public static final long[] __DNA__FIELD__shade_type = new long[]{68L, 68L};
   public static final long[] __DNA__FIELD__precache_resolution = new long[]{70L, 70L};
   public static final long[] __DNA__FIELD__stepsize = new long[]{72L, 72L};
   public static final long[] __DNA__FIELD__ms_diff = new long[]{76L, 76L};
   public static final long[] __DNA__FIELD__ms_intensity = new long[]{80L, 80L};
   public static final long[] __DNA__FIELD__ms_spread = new long[]{84L, 84L};

   public VolumeSettings(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected VolumeSettings(VolumeSettings that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public float getDensity() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 0L) : this.__io__block.readFloat(this.__io__address + 0L);
   }

   public void setDensity(float density) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 0L, density);
      } else {
         this.__io__block.writeFloat(this.__io__address + 0L, density);
      }

   }

   public float getEmission() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 4L) : this.__io__block.readFloat(this.__io__address + 4L);
   }

   public void setEmission(float emission) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 4L, emission);
      } else {
         this.__io__block.writeFloat(this.__io__address + 4L, emission);
      }

   }

   public float getScattering() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 8L) : this.__io__block.readFloat(this.__io__address + 8L);
   }

   public void setScattering(float scattering) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 8L, scattering);
      } else {
         this.__io__block.writeFloat(this.__io__address + 8L, scattering);
      }

   }

   public float getReflection() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 12L) : this.__io__block.readFloat(this.__io__address + 12L);
   }

   public void setReflection(float reflection) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 12L, reflection);
      } else {
         this.__io__block.writeFloat(this.__io__address + 12L, reflection);
      }

   }

   public CArrayFacade<Float> getEmission_col() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 16L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 16L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setEmission_col(CArrayFacade<Float> emission_col) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 16L;
      } else {
         __dna__offset = 16L;
      }

      if (!this.__io__equals(emission_col, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, emission_col)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, emission_col);
         } else {
            __io__generic__copy(this.getEmission_col(), emission_col);
         }

      }
   }

   public CArrayFacade<Float> getTransmission_col() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 28L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 28L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setTransmission_col(CArrayFacade<Float> transmission_col) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 28L;
      } else {
         __dna__offset = 28L;
      }

      if (!this.__io__equals(transmission_col, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, transmission_col)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, transmission_col);
         } else {
            __io__generic__copy(this.getTransmission_col(), transmission_col);
         }

      }
   }

   public CArrayFacade<Float> getReflection_col() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 40L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 40L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setReflection_col(CArrayFacade<Float> reflection_col) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 40L;
      } else {
         __dna__offset = 40L;
      }

      if (!this.__io__equals(reflection_col, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, reflection_col)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, reflection_col);
         } else {
            __io__generic__copy(this.getReflection_col(), reflection_col);
         }

      }
   }

   public float getDensity_scale() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 52L) : this.__io__block.readFloat(this.__io__address + 52L);
   }

   public void setDensity_scale(float density_scale) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 52L, density_scale);
      } else {
         this.__io__block.writeFloat(this.__io__address + 52L, density_scale);
      }

   }

   public float getDepth_cutoff() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 56L) : this.__io__block.readFloat(this.__io__address + 56L);
   }

   public void setDepth_cutoff(float depth_cutoff) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 56L, depth_cutoff);
      } else {
         this.__io__block.writeFloat(this.__io__address + 56L, depth_cutoff);
      }

   }

   public float getAsymmetry() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 60L) : this.__io__block.readFloat(this.__io__address + 60L);
   }

   public void setAsymmetry(float asymmetry) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 60L, asymmetry);
      } else {
         this.__io__block.writeFloat(this.__io__address + 60L, asymmetry);
      }

   }

   public short getStepsize_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 64L) : this.__io__block.readShort(this.__io__address + 64L);
   }

   public void setStepsize_type(short stepsize_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 64L, stepsize_type);
      } else {
         this.__io__block.writeShort(this.__io__address + 64L, stepsize_type);
      }

   }

   public short getShadeflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 66L) : this.__io__block.readShort(this.__io__address + 66L);
   }

   public void setShadeflag(short shadeflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 66L, shadeflag);
      } else {
         this.__io__block.writeShort(this.__io__address + 66L, shadeflag);
      }

   }

   public short getShade_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 68L) : this.__io__block.readShort(this.__io__address + 68L);
   }

   public void setShade_type(short shade_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 68L, shade_type);
      } else {
         this.__io__block.writeShort(this.__io__address + 68L, shade_type);
      }

   }

   public short getPrecache_resolution() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 70L) : this.__io__block.readShort(this.__io__address + 70L);
   }

   public void setPrecache_resolution(short precache_resolution) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 70L, precache_resolution);
      } else {
         this.__io__block.writeShort(this.__io__address + 70L, precache_resolution);
      }

   }

   public float getStepsize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 72L) : this.__io__block.readFloat(this.__io__address + 72L);
   }

   public void setStepsize(float stepsize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 72L, stepsize);
      } else {
         this.__io__block.writeFloat(this.__io__address + 72L, stepsize);
      }

   }

   public float getMs_diff() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 76L) : this.__io__block.readFloat(this.__io__address + 76L);
   }

   public void setMs_diff(float ms_diff) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 76L, ms_diff);
      } else {
         this.__io__block.writeFloat(this.__io__address + 76L, ms_diff);
      }

   }

   public float getMs_intensity() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 80L) : this.__io__block.readFloat(this.__io__address + 80L);
   }

   public void setMs_intensity(float ms_intensity) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 80L, ms_intensity);
      } else {
         this.__io__block.writeFloat(this.__io__address + 80L, ms_intensity);
      }

   }

   public float getMs_spread() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 84L) : this.__io__block.readFloat(this.__io__address + 84L);
   }

   public void setMs_spread(float ms_spread) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 84L, ms_spread);
      } else {
         this.__io__block.writeFloat(this.__io__address + 84L, ms_spread);
      }

   }

   public CPointer<VolumeSettings> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{VolumeSettings.class}, this.__io__block, this.__io__blockTable);
   }
}
