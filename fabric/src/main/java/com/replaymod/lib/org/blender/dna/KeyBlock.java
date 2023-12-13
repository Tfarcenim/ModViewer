package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 172L,
   size64 = 184L
)
public class KeyBlock extends CFacade {
   public static final int __DNA__SDNA_INDEX = 16;
   public static final long[] __DNA__FIELD__next = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__prev = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__pos = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__curval = new long[]{12L, 20L};
   public static final long[] __DNA__FIELD__type = new long[]{16L, 24L};
   public static final long[] __DNA__FIELD__pad1 = new long[]{18L, 26L};
   public static final long[] __DNA__FIELD__relative = new long[]{20L, 28L};
   public static final long[] __DNA__FIELD__flag = new long[]{22L, 30L};
   public static final long[] __DNA__FIELD__totelem = new long[]{24L, 32L};
   public static final long[] __DNA__FIELD__uid = new long[]{28L, 36L};
   public static final long[] __DNA__FIELD__data = new long[]{32L, 40L};
   public static final long[] __DNA__FIELD__name = new long[]{36L, 48L};
   public static final long[] __DNA__FIELD__vgroup = new long[]{100L, 112L};
   public static final long[] __DNA__FIELD__slidermin = new long[]{164L, 176L};
   public static final long[] __DNA__FIELD__slidermax = new long[]{168L, 180L};

   public KeyBlock(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected KeyBlock(KeyBlock that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<KeyBlock> getNext() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{KeyBlock.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 16), this.__io__blockTable);
   }

   public void setNext(CPointer<KeyBlock> next) throws IOException {
      long __address = next == null ? 0L : next.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<KeyBlock> getPrev() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{KeyBlock.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 16), this.__io__blockTable);
   }

   public void setPrev(CPointer<KeyBlock> prev) throws IOException {
      long __address = prev == null ? 0L : prev.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public float getPos() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 16L) : this.__io__block.readFloat(this.__io__address + 8L);
   }

   public void setPos(float pos) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 16L, pos);
      } else {
         this.__io__block.writeFloat(this.__io__address + 8L, pos);
      }

   }

   public float getCurval() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 20L) : this.__io__block.readFloat(this.__io__address + 12L);
   }

   public void setCurval(float curval) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 20L, curval);
      } else {
         this.__io__block.writeFloat(this.__io__address + 12L, curval);
      }

   }

   public short getType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 24L) : this.__io__block.readShort(this.__io__address + 16L);
   }

   public void setType(short type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 24L, type);
      } else {
         this.__io__block.writeShort(this.__io__address + 16L, type);
      }

   }

   public short getPad1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 26L) : this.__io__block.readShort(this.__io__address + 18L);
   }

   public void setPad1(short pad1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 26L, pad1);
      } else {
         this.__io__block.writeShort(this.__io__address + 18L, pad1);
      }

   }

   public short getRelative() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 28L) : this.__io__block.readShort(this.__io__address + 20L);
   }

   public void setRelative(short relative) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 28L, relative);
      } else {
         this.__io__block.writeShort(this.__io__address + 20L, relative);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 30L) : this.__io__block.readShort(this.__io__address + 22L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 30L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 22L, flag);
      }

   }

   public int getTotelem() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 32L) : this.__io__block.readInt(this.__io__address + 24L);
   }

   public void setTotelem(int totelem) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 32L, totelem);
      } else {
         this.__io__block.writeInt(this.__io__address + 24L, totelem);
      }

   }

   public int getUid() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 36L) : this.__io__block.readInt(this.__io__address + 28L);
   }

   public void setUid(int uid) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 36L, uid);
      } else {
         this.__io__block.writeInt(this.__io__address + 28L, uid);
      }

   }

   public CPointer<Object> getData() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 40L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 32L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setData(CPointer<Object> data) throws IOException {
      long __address = data == null ? 0L : data.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 40L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 32L, __address);
      }

   }

   public CArrayFacade<Byte> getName() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 48L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 36L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setName(CArrayFacade<Byte> name) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 48L;
      } else {
         __dna__offset = 36L;
      }

      if (!this.__io__equals(name, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, name)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, name);
         } else {
            __io__generic__copy(this.getName(), name);
         }

      }
   }

   public CArrayFacade<Byte> getVgroup() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 112L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 100L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setVgroup(CArrayFacade<Byte> vgroup) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 112L;
      } else {
         __dna__offset = 100L;
      }

      if (!this.__io__equals(vgroup, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, vgroup)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, vgroup);
         } else {
            __io__generic__copy(this.getVgroup(), vgroup);
         }

      }
   }

   public float getSlidermin() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 176L) : this.__io__block.readFloat(this.__io__address + 164L);
   }

   public void setSlidermin(float slidermin) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 176L, slidermin);
      } else {
         this.__io__block.writeFloat(this.__io__address + 164L, slidermin);
      }

   }

   public float getSlidermax() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 180L) : this.__io__block.readFloat(this.__io__address + 168L);
   }

   public void setSlidermax(float slidermax) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 180L, slidermax);
      } else {
         this.__io__block.writeFloat(this.__io__address + 168L, slidermax);
      }

   }

   public CPointer<KeyBlock> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{KeyBlock.class}, this.__io__block, this.__io__blockTable);
   }
}
