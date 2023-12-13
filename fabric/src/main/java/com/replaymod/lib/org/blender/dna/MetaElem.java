package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 84L,
   size64 = 104L
)
public class MetaElem extends CFacade {
   public static final int __DNA__SDNA_INDEX = 48;
   public static final long[] __DNA__FIELD__next = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__prev = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__bb = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__type = new long[]{12L, 24L};
   public static final long[] __DNA__FIELD__flag = new long[]{14L, 26L};
   public static final long[] __DNA__FIELD__selcol1 = new long[]{16L, 28L};
   public static final long[] __DNA__FIELD__selcol2 = new long[]{18L, 30L};
   public static final long[] __DNA__FIELD__x = new long[]{20L, 32L};
   public static final long[] __DNA__FIELD__y = new long[]{24L, 36L};
   public static final long[] __DNA__FIELD__z = new long[]{28L, 40L};
   public static final long[] __DNA__FIELD__quat = new long[]{32L, 44L};
   public static final long[] __DNA__FIELD__expx = new long[]{48L, 60L};
   public static final long[] __DNA__FIELD__expy = new long[]{52L, 64L};
   public static final long[] __DNA__FIELD__expz = new long[]{56L, 68L};
   public static final long[] __DNA__FIELD__rad = new long[]{60L, 72L};
   public static final long[] __DNA__FIELD__rad2 = new long[]{64L, 76L};
   public static final long[] __DNA__FIELD__s = new long[]{68L, 80L};
   public static final long[] __DNA__FIELD__len = new long[]{72L, 84L};
   public static final long[] __DNA__FIELD__mat = new long[]{76L, 88L};
   public static final long[] __DNA__FIELD__imat = new long[]{80L, 96L};

   public MetaElem(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MetaElem(MetaElem that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<MetaElem> getNext() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MetaElem.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 48), this.__io__blockTable);
   }

   public void setNext(CPointer<MetaElem> next) throws IOException {
      long __address = next == null ? 0L : next.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<MetaElem> getPrev() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MetaElem.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 48), this.__io__blockTable);
   }

   public void setPrev(CPointer<MetaElem> prev) throws IOException {
      long __address = prev == null ? 0L : prev.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public CPointer<BoundBox> getBb() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BoundBox.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 151), this.__io__blockTable);
   }

   public void setBb(CPointer<BoundBox> bb) throws IOException {
      long __address = bb == null ? 0L : bb.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      }

   }

   public short getType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 24L) : this.__io__block.readShort(this.__io__address + 12L);
   }

   public void setType(short type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 24L, type);
      } else {
         this.__io__block.writeShort(this.__io__address + 12L, type);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 26L) : this.__io__block.readShort(this.__io__address + 14L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 26L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 14L, flag);
      }

   }

   public short getSelcol1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 28L) : this.__io__block.readShort(this.__io__address + 16L);
   }

   public void setSelcol1(short selcol1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 28L, selcol1);
      } else {
         this.__io__block.writeShort(this.__io__address + 16L, selcol1);
      }

   }

   public short getSelcol2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 30L) : this.__io__block.readShort(this.__io__address + 18L);
   }

   public void setSelcol2(short selcol2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 30L, selcol2);
      } else {
         this.__io__block.writeShort(this.__io__address + 18L, selcol2);
      }

   }

   public float getX() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 32L) : this.__io__block.readFloat(this.__io__address + 20L);
   }

   public void setX(float x) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 32L, x);
      } else {
         this.__io__block.writeFloat(this.__io__address + 20L, x);
      }

   }

   public float getY() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 36L) : this.__io__block.readFloat(this.__io__address + 24L);
   }

   public void setY(float y) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 36L, y);
      } else {
         this.__io__block.writeFloat(this.__io__address + 24L, y);
      }

   }

   public float getZ() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 40L) : this.__io__block.readFloat(this.__io__address + 28L);
   }

   public void setZ(float z) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 40L, z);
      } else {
         this.__io__block.writeFloat(this.__io__address + 28L, z);
      }

   }

   public CArrayFacade<Float> getQuat() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 44L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 32L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setQuat(CArrayFacade<Float> quat) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 44L;
      } else {
         __dna__offset = 32L;
      }

      if (!this.__io__equals(quat, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, quat)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, quat);
         } else {
            __io__generic__copy(this.getQuat(), quat);
         }

      }
   }

   public float getExpx() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 60L) : this.__io__block.readFloat(this.__io__address + 48L);
   }

   public void setExpx(float expx) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 60L, expx);
      } else {
         this.__io__block.writeFloat(this.__io__address + 48L, expx);
      }

   }

   public float getExpy() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 64L) : this.__io__block.readFloat(this.__io__address + 52L);
   }

   public void setExpy(float expy) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 64L, expy);
      } else {
         this.__io__block.writeFloat(this.__io__address + 52L, expy);
      }

   }

   public float getExpz() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 68L) : this.__io__block.readFloat(this.__io__address + 56L);
   }

   public void setExpz(float expz) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 68L, expz);
      } else {
         this.__io__block.writeFloat(this.__io__address + 56L, expz);
      }

   }

   public float getRad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 72L) : this.__io__block.readFloat(this.__io__address + 60L);
   }

   public void setRad(float rad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 72L, rad);
      } else {
         this.__io__block.writeFloat(this.__io__address + 60L, rad);
      }

   }

   public float getRad2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 76L) : this.__io__block.readFloat(this.__io__address + 64L);
   }

   public void setRad2(float rad2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 76L, rad2);
      } else {
         this.__io__block.writeFloat(this.__io__address + 64L, rad2);
      }

   }

   public float getS() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 80L) : this.__io__block.readFloat(this.__io__address + 68L);
   }

   public void setS(float s) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 80L, s);
      } else {
         this.__io__block.writeFloat(this.__io__address + 68L, s);
      }

   }

   public float getLen() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 84L) : this.__io__block.readFloat(this.__io__address + 72L);
   }

   public void setLen(float len) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 84L, len);
      } else {
         this.__io__block.writeFloat(this.__io__address + 72L, len);
      }

   }

   public CPointer<Float> getMat() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 88L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 76L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, __dna__targetTypes), this.__io__blockTable);
   }

   public void setMat(CPointer<Float> mat) throws IOException {
      long __address = mat == null ? 0L : mat.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 88L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 76L, __address);
      }

   }

   public CPointer<Float> getImat() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 96L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 80L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, __dna__targetTypes), this.__io__blockTable);
   }

   public void setImat(CPointer<Float> imat) throws IOException {
      long __address = imat == null ? 0L : imat.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 96L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 80L, __address);
      }

   }

   public CPointer<MetaElem> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MetaElem.class}, this.__io__block, this.__io__blockTable);
   }
}
