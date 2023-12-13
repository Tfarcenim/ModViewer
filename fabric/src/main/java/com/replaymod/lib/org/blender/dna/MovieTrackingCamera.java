package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 52L,
   size64 = 56L
)
public class MovieTrackingCamera extends CFacade {
   public static final int __DNA__SDNA_INDEX = 548;
   public static final long[] __DNA__FIELD__intrinsics = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__distortion_model = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__pad = new long[]{6L, 10L};
   public static final long[] __DNA__FIELD__sensor_width = new long[]{8L, 12L};
   public static final long[] __DNA__FIELD__pixel_aspect = new long[]{12L, 16L};
   public static final long[] __DNA__FIELD__focal = new long[]{16L, 20L};
   public static final long[] __DNA__FIELD__units = new long[]{20L, 24L};
   public static final long[] __DNA__FIELD__pad1 = new long[]{22L, 26L};
   public static final long[] __DNA__FIELD__principal = new long[]{24L, 28L};
   public static final long[] __DNA__FIELD__k1 = new long[]{32L, 36L};
   public static final long[] __DNA__FIELD__k2 = new long[]{36L, 40L};
   public static final long[] __DNA__FIELD__k3 = new long[]{40L, 44L};
   public static final long[] __DNA__FIELD__division_k1 = new long[]{44L, 48L};
   public static final long[] __DNA__FIELD__division_k2 = new long[]{48L, 52L};

   public MovieTrackingCamera(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MovieTrackingCamera(MovieTrackingCamera that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<Object> getIntrinsics() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setIntrinsics(CPointer<Object> intrinsics) throws IOException {
      long __address = intrinsics == null ? 0L : intrinsics.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public short getDistortion_model() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 8L) : this.__io__block.readShort(this.__io__address + 4L);
   }

   public void setDistortion_model(short distortion_model) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 8L, distortion_model);
      } else {
         this.__io__block.writeShort(this.__io__address + 4L, distortion_model);
      }

   }

   public short getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 10L) : this.__io__block.readShort(this.__io__address + 6L);
   }

   public void setPad(short pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 10L, pad);
      } else {
         this.__io__block.writeShort(this.__io__address + 6L, pad);
      }

   }

   public float getSensor_width() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 12L) : this.__io__block.readFloat(this.__io__address + 8L);
   }

   public void setSensor_width(float sensor_width) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 12L, sensor_width);
      } else {
         this.__io__block.writeFloat(this.__io__address + 8L, sensor_width);
      }

   }

   public float getPixel_aspect() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 16L) : this.__io__block.readFloat(this.__io__address + 12L);
   }

   public void setPixel_aspect(float pixel_aspect) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 16L, pixel_aspect);
      } else {
         this.__io__block.writeFloat(this.__io__address + 12L, pixel_aspect);
      }

   }

   public float getFocal() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 20L) : this.__io__block.readFloat(this.__io__address + 16L);
   }

   public void setFocal(float focal) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 20L, focal);
      } else {
         this.__io__block.writeFloat(this.__io__address + 16L, focal);
      }

   }

   public short getUnits() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 24L) : this.__io__block.readShort(this.__io__address + 20L);
   }

   public void setUnits(short units) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 24L, units);
      } else {
         this.__io__block.writeShort(this.__io__address + 20L, units);
      }

   }

   public short getPad1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 26L) : this.__io__block.readShort(this.__io__address + 22L);
   }

   public void setPad1(short pad1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 26L, pad1);
      } else {
         this.__io__block.writeShort(this.__io__address + 22L, pad1);
      }

   }

   public CArrayFacade<Float> getPrincipal() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 28L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 24L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPrincipal(CArrayFacade<Float> principal) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 28L;
      } else {
         __dna__offset = 24L;
      }

      if (!this.__io__equals(principal, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, principal)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, principal);
         } else {
            __io__generic__copy(this.getPrincipal(), principal);
         }

      }
   }

   public float getK1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 36L) : this.__io__block.readFloat(this.__io__address + 32L);
   }

   public void setK1(float k1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 36L, k1);
      } else {
         this.__io__block.writeFloat(this.__io__address + 32L, k1);
      }

   }

   public float getK2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 40L) : this.__io__block.readFloat(this.__io__address + 36L);
   }

   public void setK2(float k2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 40L, k2);
      } else {
         this.__io__block.writeFloat(this.__io__address + 36L, k2);
      }

   }

   public float getK3() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 44L) : this.__io__block.readFloat(this.__io__address + 40L);
   }

   public void setK3(float k3) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 44L, k3);
      } else {
         this.__io__block.writeFloat(this.__io__address + 40L, k3);
      }

   }

   public float getDivision_k1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 48L) : this.__io__block.readFloat(this.__io__address + 44L);
   }

   public void setDivision_k1(float division_k1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 48L, division_k1);
      } else {
         this.__io__block.writeFloat(this.__io__address + 44L, division_k1);
      }

   }

   public float getDivision_k2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 52L) : this.__io__block.readFloat(this.__io__address + 48L);
   }

   public void setDivision_k2(float division_k2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 52L, division_k2);
      } else {
         this.__io__block.writeFloat(this.__io__address + 48L, division_k2);
      }

   }

   public CPointer<MovieTrackingCamera> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MovieTrackingCamera.class}, this.__io__block, this.__io__blockTable);
   }
}
