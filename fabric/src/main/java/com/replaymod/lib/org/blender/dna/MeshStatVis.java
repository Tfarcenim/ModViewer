package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 40L,
   size64 = 40L
)
public class MeshStatVis extends CFacade {
   public static final int __DNA__SDNA_INDEX = 198;
   public static final long[] __DNA__FIELD__type = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD___pad1 = new long[]{1L, 1L};
   public static final long[] __DNA__FIELD__overhang_axis = new long[]{3L, 3L};
   public static final long[] __DNA__FIELD__overhang_min = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__overhang_max = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__thickness_min = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__thickness_max = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__thickness_samples = new long[]{20L, 20L};
   public static final long[] __DNA__FIELD___pad2 = new long[]{21L, 21L};
   public static final long[] __DNA__FIELD__distort_min = new long[]{24L, 24L};
   public static final long[] __DNA__FIELD__distort_max = new long[]{28L, 28L};
   public static final long[] __DNA__FIELD__sharp_min = new long[]{32L, 32L};
   public static final long[] __DNA__FIELD__sharp_max = new long[]{36L, 36L};

   public MeshStatVis(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MeshStatVis(MeshStatVis that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public byte getType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 0L) : this.__io__block.readByte(this.__io__address + 0L);
   }

   public void setType(byte type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 0L, type);
      } else {
         this.__io__block.writeByte(this.__io__address + 0L, type);
      }

   }

   public CArrayFacade<Byte> get_pad1() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void set_pad1(CArrayFacade<Byte> _pad1) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1L;
      } else {
         __dna__offset = 1L;
      }

      if (!this.__io__equals(_pad1, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, _pad1)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, _pad1);
         } else {
            __io__generic__copy(this.get_pad1(), _pad1);
         }

      }
   }

   public byte getOverhang_axis() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 3L) : this.__io__block.readByte(this.__io__address + 3L);
   }

   public void setOverhang_axis(byte overhang_axis) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 3L, overhang_axis);
      } else {
         this.__io__block.writeByte(this.__io__address + 3L, overhang_axis);
      }

   }

   public float getOverhang_min() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 4L) : this.__io__block.readFloat(this.__io__address + 4L);
   }

   public void setOverhang_min(float overhang_min) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 4L, overhang_min);
      } else {
         this.__io__block.writeFloat(this.__io__address + 4L, overhang_min);
      }

   }

   public float getOverhang_max() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 8L) : this.__io__block.readFloat(this.__io__address + 8L);
   }

   public void setOverhang_max(float overhang_max) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 8L, overhang_max);
      } else {
         this.__io__block.writeFloat(this.__io__address + 8L, overhang_max);
      }

   }

   public float getThickness_min() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 12L) : this.__io__block.readFloat(this.__io__address + 12L);
   }

   public void setThickness_min(float thickness_min) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 12L, thickness_min);
      } else {
         this.__io__block.writeFloat(this.__io__address + 12L, thickness_min);
      }

   }

   public float getThickness_max() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 16L) : this.__io__block.readFloat(this.__io__address + 16L);
   }

   public void setThickness_max(float thickness_max) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 16L, thickness_max);
      } else {
         this.__io__block.writeFloat(this.__io__address + 16L, thickness_max);
      }

   }

   public byte getThickness_samples() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 20L) : this.__io__block.readByte(this.__io__address + 20L);
   }

   public void setThickness_samples(byte thickness_samples) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 20L, thickness_samples);
      } else {
         this.__io__block.writeByte(this.__io__address + 20L, thickness_samples);
      }

   }

   public CArrayFacade<Byte> get_pad2() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 21L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 21L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void set_pad2(CArrayFacade<Byte> _pad2) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 21L;
      } else {
         __dna__offset = 21L;
      }

      if (!this.__io__equals(_pad2, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, _pad2)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, _pad2);
         } else {
            __io__generic__copy(this.get_pad2(), _pad2);
         }

      }
   }

   public float getDistort_min() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 24L) : this.__io__block.readFloat(this.__io__address + 24L);
   }

   public void setDistort_min(float distort_min) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 24L, distort_min);
      } else {
         this.__io__block.writeFloat(this.__io__address + 24L, distort_min);
      }

   }

   public float getDistort_max() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 28L) : this.__io__block.readFloat(this.__io__address + 28L);
   }

   public void setDistort_max(float distort_max) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 28L, distort_max);
      } else {
         this.__io__block.writeFloat(this.__io__address + 28L, distort_max);
      }

   }

   public float getSharp_min() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 32L) : this.__io__block.readFloat(this.__io__address + 32L);
   }

   public void setSharp_min(float sharp_min) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 32L, sharp_min);
      } else {
         this.__io__block.writeFloat(this.__io__address + 32L, sharp_min);
      }

   }

   public float getSharp_max() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 36L) : this.__io__block.readFloat(this.__io__address + 36L);
   }

   public void setSharp_max(float sharp_max) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 36L, sharp_max);
      } else {
         this.__io__block.writeFloat(this.__io__address + 36L, sharp_max);
      }

   }

   public CPointer<MeshStatVis> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MeshStatVis.class}, this.__io__block, this.__io__blockTable);
   }
}
