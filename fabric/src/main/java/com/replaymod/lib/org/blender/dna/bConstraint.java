package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 104L,
   size64 = 120L
)
public class bConstraint extends CFacade {
   public static final int __DNA__SDNA_INDEX = 357;
   public static final long[] __DNA__FIELD__next = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__prev = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__data = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__type = new long[]{12L, 24L};
   public static final long[] __DNA__FIELD__flag = new long[]{14L, 26L};
   public static final long[] __DNA__FIELD__ownspace = new long[]{16L, 28L};
   public static final long[] __DNA__FIELD__tarspace = new long[]{17L, 29L};
   public static final long[] __DNA__FIELD__name = new long[]{18L, 30L};
   public static final long[] __DNA__FIELD__pad = new long[]{82L, 94L};
   public static final long[] __DNA__FIELD__enforce = new long[]{84L, 96L};
   public static final long[] __DNA__FIELD__headtail = new long[]{88L, 100L};
   public static final long[] __DNA__FIELD__ipo = new long[]{92L, 104L};
   public static final long[] __DNA__FIELD__lin_error = new long[]{96L, 112L};
   public static final long[] __DNA__FIELD__rot_error = new long[]{100L, 116L};

   public bConstraint(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected bConstraint(bConstraint that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<bConstraint> getNext() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bConstraint.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 357), this.__io__blockTable);
   }

   public void setNext(CPointer<bConstraint> next) throws IOException {
      long __address = next == null ? 0L : next.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<bConstraint> getPrev() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bConstraint.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 357), this.__io__blockTable);
   }

   public void setPrev(CPointer<bConstraint> prev) throws IOException {
      long __address = prev == null ? 0L : prev.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public CPointer<Object> getData() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setData(CPointer<Object> data) throws IOException {
      long __address = data == null ? 0L : data.getAddress();
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

   public byte getOwnspace() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 28L) : this.__io__block.readByte(this.__io__address + 16L);
   }

   public void setOwnspace(byte ownspace) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 28L, ownspace);
      } else {
         this.__io__block.writeByte(this.__io__address + 16L, ownspace);
      }

   }

   public byte getTarspace() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 29L) : this.__io__block.readByte(this.__io__address + 17L);
   }

   public void setTarspace(byte tarspace) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 29L, tarspace);
      } else {
         this.__io__block.writeByte(this.__io__address + 17L, tarspace);
      }

   }

   public CArrayFacade<Byte> getName() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 30L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 18L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setName(CArrayFacade<Byte> name) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 30L;
      } else {
         __dna__offset = 18L;
      }

      if (!this.__io__equals(name, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, name)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, name);
         } else {
            __io__generic__copy(this.getName(), name);
         }

      }
   }

   public short getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 94L) : this.__io__block.readShort(this.__io__address + 82L);
   }

   public void setPad(short pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 94L, pad);
      } else {
         this.__io__block.writeShort(this.__io__address + 82L, pad);
      }

   }

   public float getEnforce() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 96L) : this.__io__block.readFloat(this.__io__address + 84L);
   }

   public void setEnforce(float enforce) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 96L, enforce);
      } else {
         this.__io__block.writeFloat(this.__io__address + 84L, enforce);
      }

   }

   public float getHeadtail() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 100L) : this.__io__block.readFloat(this.__io__address + 88L);
   }

   public void setHeadtail(float headtail) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 100L, headtail);
      } else {
         this.__io__block.writeFloat(this.__io__address + 88L, headtail);
      }

   }

   public CPointer<Ipo> getIpo() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 104L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 92L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Ipo.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 15), this.__io__blockTable);
   }

   public void setIpo(CPointer<Ipo> ipo) throws IOException {
      long __address = ipo == null ? 0L : ipo.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 104L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 92L, __address);
      }

   }

   public float getLin_error() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 112L) : this.__io__block.readFloat(this.__io__address + 96L);
   }

   public void setLin_error(float lin_error) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 112L, lin_error);
      } else {
         this.__io__block.writeFloat(this.__io__address + 96L, lin_error);
      }

   }

   public float getRot_error() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 116L) : this.__io__block.readFloat(this.__io__address + 100L);
   }

   public void setRot_error(float rot_error) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 116L, rot_error);
      } else {
         this.__io__block.writeFloat(this.__io__address + 100L, rot_error);
      }

   }

   public CPointer<bConstraint> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{bConstraint.class}, this.__io__block, this.__io__blockTable);
   }
}
