package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 108L,
   size64 = 128L
)
public class IDProperty extends CFacade {
   public static final int __DNA__SDNA_INDEX = 9;
   public static final long[] __DNA__FIELD__next = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__prev = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__type = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__subtype = new long[]{9L, 17L};
   public static final long[] __DNA__FIELD__flag = new long[]{10L, 18L};
   public static final long[] __DNA__FIELD__name = new long[]{12L, 20L};
   public static final long[] __DNA__FIELD__saved = new long[]{76L, 84L};
   public static final long[] __DNA__FIELD__data = new long[]{80L, 88L};
   public static final long[] __DNA__FIELD__len = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__totallen = new long[]{104L, 124L};

   public IDProperty(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected IDProperty(IDProperty that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<IDProperty> getNext() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{IDProperty.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 9), this.__io__blockTable);
   }

   public void setNext(CPointer<IDProperty> next) throws IOException {
      long __address = next == null ? 0L : next.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<IDProperty> getPrev() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{IDProperty.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 9), this.__io__blockTable);
   }

   public void setPrev(CPointer<IDProperty> prev) throws IOException {
      long __address = prev == null ? 0L : prev.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public byte getType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 16L) : this.__io__block.readByte(this.__io__address + 8L);
   }

   public void setType(byte type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 16L, type);
      } else {
         this.__io__block.writeByte(this.__io__address + 8L, type);
      }

   }

   public byte getSubtype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 17L) : this.__io__block.readByte(this.__io__address + 9L);
   }

   public void setSubtype(byte subtype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 17L, subtype);
      } else {
         this.__io__block.writeByte(this.__io__address + 9L, subtype);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 18L) : this.__io__block.readShort(this.__io__address + 10L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 18L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 10L, flag);
      }

   }

   public CArrayFacade<Byte> getName() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 20L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 12L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setName(CArrayFacade<Byte> name) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 20L;
      } else {
         __dna__offset = 12L;
      }

      if (!this.__io__equals(name, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, name)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, name);
         } else {
            __io__generic__copy(this.getName(), name);
         }

      }
   }

   public int getSaved() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 84L) : this.__io__block.readInt(this.__io__address + 76L);
   }

   public void setSaved(int saved) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 84L, saved);
      } else {
         this.__io__block.writeInt(this.__io__address + 76L, saved);
      }

   }

   public IDPropertyData getData() throws IOException {
      return this.__io__pointersize == 8 ? new IDPropertyData(this.__io__address + 88L, this.__io__block, this.__io__blockTable) : new IDPropertyData(this.__io__address + 80L, this.__io__block, this.__io__blockTable);
   }

   public void setData(IDPropertyData data) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 88L;
      } else {
         __dna__offset = 80L;
      }

      if (!this.__io__equals(data, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, data)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, data);
         } else {
            __io__generic__copy(this.getData(), data);
         }

      }
   }

   public int getLen() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 120L) : this.__io__block.readInt(this.__io__address + 100L);
   }

   public void setLen(int len) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 120L, len);
      } else {
         this.__io__block.writeInt(this.__io__address + 100L, len);
      }

   }

   public int getTotallen() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 124L) : this.__io__block.readInt(this.__io__address + 104L);
   }

   public void setTotallen(int totallen) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 124L, totallen);
      } else {
         this.__io__block.writeInt(this.__io__address + 104L, totallen);
      }

   }

   public CPointer<IDProperty> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{IDProperty.class}, this.__io__block, this.__io__blockTable);
   }
}
