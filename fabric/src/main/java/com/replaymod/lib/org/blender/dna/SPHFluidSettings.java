package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 68L,
   size64 = 68L
)
public class SPHFluidSettings extends CFacade {
   public static final int __DNA__SDNA_INDEX = 484;
   public static final long[] __DNA__FIELD__radius = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__spring_k = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__rest_length = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__plasticity_constant = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__yield_ratio = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__plasticity_balance = new long[]{20L, 20L};
   public static final long[] __DNA__FIELD__yield_balance = new long[]{24L, 24L};
   public static final long[] __DNA__FIELD__viscosity_omega = new long[]{28L, 28L};
   public static final long[] __DNA__FIELD__viscosity_beta = new long[]{32L, 32L};
   public static final long[] __DNA__FIELD__stiffness_k = new long[]{36L, 36L};
   public static final long[] __DNA__FIELD__stiffness_knear = new long[]{40L, 40L};
   public static final long[] __DNA__FIELD__rest_density = new long[]{44L, 44L};
   public static final long[] __DNA__FIELD__buoyancy = new long[]{48L, 48L};
   public static final long[] __DNA__FIELD__flag = new long[]{52L, 52L};
   public static final long[] __DNA__FIELD__spring_frames = new long[]{56L, 56L};
   public static final long[] __DNA__FIELD__solver = new long[]{60L, 60L};
   public static final long[] __DNA__FIELD__pad = new long[]{62L, 62L};

   public SPHFluidSettings(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected SPHFluidSettings(SPHFluidSettings that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public float getRadius() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 0L) : this.__io__block.readFloat(this.__io__address + 0L);
   }

   public void setRadius(float radius) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 0L, radius);
      } else {
         this.__io__block.writeFloat(this.__io__address + 0L, radius);
      }

   }

   public float getSpring_k() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 4L) : this.__io__block.readFloat(this.__io__address + 4L);
   }

   public void setSpring_k(float spring_k) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 4L, spring_k);
      } else {
         this.__io__block.writeFloat(this.__io__address + 4L, spring_k);
      }

   }

   public float getRest_length() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 8L) : this.__io__block.readFloat(this.__io__address + 8L);
   }

   public void setRest_length(float rest_length) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 8L, rest_length);
      } else {
         this.__io__block.writeFloat(this.__io__address + 8L, rest_length);
      }

   }

   public float getPlasticity_constant() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 12L) : this.__io__block.readFloat(this.__io__address + 12L);
   }

   public void setPlasticity_constant(float plasticity_constant) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 12L, plasticity_constant);
      } else {
         this.__io__block.writeFloat(this.__io__address + 12L, plasticity_constant);
      }

   }

   public float getYield_ratio() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 16L) : this.__io__block.readFloat(this.__io__address + 16L);
   }

   public void setYield_ratio(float yield_ratio) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 16L, yield_ratio);
      } else {
         this.__io__block.writeFloat(this.__io__address + 16L, yield_ratio);
      }

   }

   public float getPlasticity_balance() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 20L) : this.__io__block.readFloat(this.__io__address + 20L);
   }

   public void setPlasticity_balance(float plasticity_balance) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 20L, plasticity_balance);
      } else {
         this.__io__block.writeFloat(this.__io__address + 20L, plasticity_balance);
      }

   }

   public float getYield_balance() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 24L) : this.__io__block.readFloat(this.__io__address + 24L);
   }

   public void setYield_balance(float yield_balance) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 24L, yield_balance);
      } else {
         this.__io__block.writeFloat(this.__io__address + 24L, yield_balance);
      }

   }

   public float getViscosity_omega() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 28L) : this.__io__block.readFloat(this.__io__address + 28L);
   }

   public void setViscosity_omega(float viscosity_omega) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 28L, viscosity_omega);
      } else {
         this.__io__block.writeFloat(this.__io__address + 28L, viscosity_omega);
      }

   }

   public float getViscosity_beta() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 32L) : this.__io__block.readFloat(this.__io__address + 32L);
   }

   public void setViscosity_beta(float viscosity_beta) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 32L, viscosity_beta);
      } else {
         this.__io__block.writeFloat(this.__io__address + 32L, viscosity_beta);
      }

   }

   public float getStiffness_k() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 36L) : this.__io__block.readFloat(this.__io__address + 36L);
   }

   public void setStiffness_k(float stiffness_k) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 36L, stiffness_k);
      } else {
         this.__io__block.writeFloat(this.__io__address + 36L, stiffness_k);
      }

   }

   public float getStiffness_knear() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 40L) : this.__io__block.readFloat(this.__io__address + 40L);
   }

   public void setStiffness_knear(float stiffness_knear) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 40L, stiffness_knear);
      } else {
         this.__io__block.writeFloat(this.__io__address + 40L, stiffness_knear);
      }

   }

   public float getRest_density() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 44L) : this.__io__block.readFloat(this.__io__address + 44L);
   }

   public void setRest_density(float rest_density) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 44L, rest_density);
      } else {
         this.__io__block.writeFloat(this.__io__address + 44L, rest_density);
      }

   }

   public float getBuoyancy() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 48L) : this.__io__block.readFloat(this.__io__address + 48L);
   }

   public void setBuoyancy(float buoyancy) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 48L, buoyancy);
      } else {
         this.__io__block.writeFloat(this.__io__address + 48L, buoyancy);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 52L) : this.__io__block.readInt(this.__io__address + 52L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 52L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 52L, flag);
      }

   }

   public int getSpring_frames() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 56L) : this.__io__block.readInt(this.__io__address + 56L);
   }

   public void setSpring_frames(int spring_frames) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 56L, spring_frames);
      } else {
         this.__io__block.writeInt(this.__io__address + 56L, spring_frames);
      }

   }

   public short getSolver() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 60L) : this.__io__block.readShort(this.__io__address + 60L);
   }

   public void setSolver(short solver) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 60L, solver);
      } else {
         this.__io__block.writeShort(this.__io__address + 60L, solver);
      }

   }

   public CArrayFacade<Short> getPad() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Short.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 62L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 62L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad(CArrayFacade<Short> pad) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 62L;
      } else {
         __dna__offset = 62L;
      }

      if (!this.__io__equals(pad, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad);
         } else {
            __io__generic__copy(this.getPad(), pad);
         }

      }
   }

   public CPointer<SPHFluidSettings> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{SPHFluidSettings.class}, this.__io__block, this.__io__blockTable);
   }
}
