package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 180L,
   size64 = 224L
)
public class Key extends CFacade {
   public static final int __DNA__SDNA_INDEX = 17;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__adt = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__refkey = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__elemstr = new long[]{108L, 136L};
   public static final long[] __DNA__FIELD__elemsize = new long[]{140L, 168L};
   public static final long[] __DNA__FIELD__pad = new long[]{144L, 172L};
   public static final long[] __DNA__FIELD__block = new long[]{148L, 176L};
   public static final long[] __DNA__FIELD__ipo = new long[]{156L, 192L};
   public static final long[] __DNA__FIELD__from = new long[]{160L, 200L};
   public static final long[] __DNA__FIELD__totkey = new long[]{164L, 208L};
   public static final long[] __DNA__FIELD__flag = new long[]{168L, 212L};
   public static final long[] __DNA__FIELD__type = new long[]{170L, 214L};
   public static final long[] __DNA__FIELD__pad2 = new long[]{171L, 215L};
   public static final long[] __DNA__FIELD__ctime = new long[]{172L, 216L};
   public static final long[] __DNA__FIELD__uidgen = new long[]{176L, 220L};

   public Key(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Key(Key that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public ID getId() throws IOException {
      return this.__io__pointersize == 8 ? new ID(this.__io__address + 0L, this.__io__block, this.__io__blockTable) : new ID(this.__io__address + 0L, this.__io__block, this.__io__blockTable);
   }

   public void setId(ID id) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(id, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, id)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, id);
         } else {
            __io__generic__copy(this.getId(), id);
         }

      }
   }

   public CPointer<AnimData> getAdt() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 120L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 100L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{AnimData.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 528), this.__io__blockTable);
   }

   public void setAdt(CPointer<AnimData> adt) throws IOException {
      long __address = adt == null ? 0L : adt.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 120L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 100L, __address);
      }

   }

   public CPointer<KeyBlock> getRefkey() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 128L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 104L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{KeyBlock.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 16), this.__io__blockTable);
   }

   public void setRefkey(CPointer<KeyBlock> refkey) throws IOException {
      long __address = refkey == null ? 0L : refkey.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 128L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 104L, __address);
      }

   }

   public CArrayFacade<Byte> getElemstr() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{32};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 136L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 108L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setElemstr(CArrayFacade<Byte> elemstr) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 136L;
      } else {
         __dna__offset = 108L;
      }

      if (!this.__io__equals(elemstr, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, elemstr)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, elemstr);
         } else {
            __io__generic__copy(this.getElemstr(), elemstr);
         }

      }
   }

   public int getElemsize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 168L) : this.__io__block.readInt(this.__io__address + 140L);
   }

   public void setElemsize(int elemsize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 168L, elemsize);
      } else {
         this.__io__block.writeInt(this.__io__address + 140L, elemsize);
      }

   }

   public int getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 172L) : this.__io__block.readInt(this.__io__address + 144L);
   }

   public void setPad(int pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 172L, pad);
      } else {
         this.__io__block.writeInt(this.__io__address + 144L, pad);
      }

   }

   public ListBase getBlock() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 176L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 148L, this.__io__block, this.__io__blockTable);
   }

   public void setBlock(ListBase block) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 176L;
      } else {
         __dna__offset = 148L;
      }

      if (!this.__io__equals(block, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, block)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, block);
         } else {
            __io__generic__copy(this.getBlock(), block);
         }

      }
   }

   public CPointer<Ipo> getIpo() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 192L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 156L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Ipo.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 15), this.__io__blockTable);
   }

   public void setIpo(CPointer<Ipo> ipo) throws IOException {
      long __address = ipo == null ? 0L : ipo.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 192L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 156L, __address);
      }

   }

   public CPointer<ID> getFrom() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 200L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 160L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{ID.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 10), this.__io__blockTable);
   }

   public void setFrom(CPointer<ID> from) throws IOException {
      long __address = from == null ? 0L : from.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 200L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 160L, __address);
      }

   }

   public int getTotkey() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 208L) : this.__io__block.readInt(this.__io__address + 164L);
   }

   public void setTotkey(int totkey) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 208L, totkey);
      } else {
         this.__io__block.writeInt(this.__io__address + 164L, totkey);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 212L) : this.__io__block.readShort(this.__io__address + 168L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 212L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 168L, flag);
      }

   }

   public byte getType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 214L) : this.__io__block.readByte(this.__io__address + 170L);
   }

   public void setType(byte type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 214L, type);
      } else {
         this.__io__block.writeByte(this.__io__address + 170L, type);
      }

   }

   public byte getPad2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 215L) : this.__io__block.readByte(this.__io__address + 171L);
   }

   public void setPad2(byte pad2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 215L, pad2);
      } else {
         this.__io__block.writeByte(this.__io__address + 171L, pad2);
      }

   }

   public float getCtime() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 216L) : this.__io__block.readFloat(this.__io__address + 172L);
   }

   public void setCtime(float ctime) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 216L, ctime);
      } else {
         this.__io__block.writeFloat(this.__io__address + 172L, ctime);
      }

   }

   public int getUidgen() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 220L) : this.__io__block.readInt(this.__io__address + 176L);
   }

   public void setUidgen(int uidgen) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 220L, uidgen);
      } else {
         this.__io__block.writeInt(this.__io__address + 176L, uidgen);
      }

   }

   public CPointer<Key> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Key.class}, this.__io__block, this.__io__blockTable);
   }
}
