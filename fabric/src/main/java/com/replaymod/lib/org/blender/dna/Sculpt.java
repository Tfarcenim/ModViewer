package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 92L,
   size64 = 112L
)
public class Sculpt extends CFacade {
   public static final int __DNA__SDNA_INDEX = 189;
   public static final long[] __DNA__FIELD__paint = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__flags = new long[]{48L, 64L};
   public static final long[] __DNA__FIELD__radial_symm = new long[]{52L, 68L};
   public static final long[] __DNA__FIELD__detail_size = new long[]{64L, 80L};
   public static final long[] __DNA__FIELD__symmetrize_direction = new long[]{68L, 84L};
   public static final long[] __DNA__FIELD__gravity_factor = new long[]{72L, 88L};
   public static final long[] __DNA__FIELD__constant_detail = new long[]{76L, 92L};
   public static final long[] __DNA__FIELD__detail_percent = new long[]{80L, 96L};
   public static final long[] __DNA__FIELD__pad = new long[]{84L, 100L};
   public static final long[] __DNA__FIELD__gravity_object = new long[]{88L, 104L};

   public Sculpt(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Sculpt(Sculpt that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public Paint getPaint() throws IOException {
      return this.__io__pointersize == 8 ? new Paint(this.__io__address + 0L, this.__io__block, this.__io__blockTable) : new Paint(this.__io__address + 0L, this.__io__block, this.__io__blockTable);
   }

   public void setPaint(Paint paint) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(paint, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, paint)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, paint);
         } else {
            __io__generic__copy(this.getPaint(), paint);
         }

      }
   }

   public int getFlags() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 64L) : this.__io__block.readInt(this.__io__address + 48L);
   }

   public void setFlags(int flags) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 64L, flags);
      } else {
         this.__io__block.writeInt(this.__io__address + 48L, flags);
      }

   }

   public CArrayFacade<Integer> getRadial_symm() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Integer.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 68L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 52L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setRadial_symm(CArrayFacade<Integer> radial_symm) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 68L;
      } else {
         __dna__offset = 52L;
      }

      if (!this.__io__equals(radial_symm, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, radial_symm)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, radial_symm);
         } else {
            __io__generic__copy(this.getRadial_symm(), radial_symm);
         }

      }
   }

   public float getDetail_size() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 80L) : this.__io__block.readFloat(this.__io__address + 64L);
   }

   public void setDetail_size(float detail_size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 80L, detail_size);
      } else {
         this.__io__block.writeFloat(this.__io__address + 64L, detail_size);
      }

   }

   public int getSymmetrize_direction() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 84L) : this.__io__block.readInt(this.__io__address + 68L);
   }

   public void setSymmetrize_direction(int symmetrize_direction) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 84L, symmetrize_direction);
      } else {
         this.__io__block.writeInt(this.__io__address + 68L, symmetrize_direction);
      }

   }

   public float getGravity_factor() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 88L) : this.__io__block.readFloat(this.__io__address + 72L);
   }

   public void setGravity_factor(float gravity_factor) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 88L, gravity_factor);
      } else {
         this.__io__block.writeFloat(this.__io__address + 72L, gravity_factor);
      }

   }

   public float getConstant_detail() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 92L) : this.__io__block.readFloat(this.__io__address + 76L);
   }

   public void setConstant_detail(float constant_detail) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 92L, constant_detail);
      } else {
         this.__io__block.writeFloat(this.__io__address + 76L, constant_detail);
      }

   }

   public float getDetail_percent() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 96L) : this.__io__block.readFloat(this.__io__address + 80L);
   }

   public void setDetail_percent(float detail_percent) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 96L, detail_percent);
      } else {
         this.__io__block.writeFloat(this.__io__address + 80L, detail_percent);
      }

   }

   public float getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 100L) : this.__io__block.readFloat(this.__io__address + 84L);
   }

   public void setPad(float pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 100L, pad);
      } else {
         this.__io__block.writeFloat(this.__io__address + 84L, pad);
      }

   }

   public CPointer<BlenderObject> getGravity_object() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 104L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 88L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setGravity_object(CPointer<BlenderObject> gravity_object) throws IOException {
      long __address = gravity_object == null ? 0L : gravity_object.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 104L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 88L, __address);
      }

   }

   public CPointer<Sculpt> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Sculpt.class}, this.__io__block, this.__io__blockTable);
   }
}
