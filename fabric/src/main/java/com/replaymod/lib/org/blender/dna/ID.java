package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 100L,
   size64 = 120L
)
public class ID extends CFacade {
   public static final int __DNA__SDNA_INDEX = 10;
   public static final long[] __DNA__FIELD__next = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__prev = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__newid = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__lib = new long[]{12L, 24L};
   public static final long[] __DNA__FIELD__name = new long[]{16L, 32L};
   public static final long[] __DNA__FIELD__flag = new long[]{82L, 98L};
   public static final long[] __DNA__FIELD__tag = new long[]{84L, 100L};
   public static final long[] __DNA__FIELD__pad_s1 = new long[]{86L, 102L};
   public static final long[] __DNA__FIELD__us = new long[]{88L, 104L};
   public static final long[] __DNA__FIELD__icon_id = new long[]{92L, 108L};
   public static final long[] __DNA__FIELD__properties = new long[]{96L, 112L};

   public ID(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected ID(ID that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<Object> getNext() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setNext(CPointer<Object> next) throws IOException {
      long __address = next == null ? 0L : next.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<Object> getPrev() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setPrev(CPointer<Object> prev) throws IOException {
      long __address = prev == null ? 0L : prev.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public CPointer<ID> getNewid() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{ID.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 10), this.__io__blockTable);
   }

   public void setNewid(CPointer<ID> newid) throws IOException {
      long __address = newid == null ? 0L : newid.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      }

   }

   public CPointer<Library> getLib() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 24L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 12L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Library.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 11), this.__io__blockTable);
   }

   public void setLib(CPointer<Library> lib) throws IOException {
      long __address = lib == null ? 0L : lib.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 24L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 12L, __address);
      }

   }

   public CArrayFacade<Byte> getName() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{66};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 32L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 16L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setName(CArrayFacade<Byte> name) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 32L;
      } else {
         __dna__offset = 16L;
      }

      if (!this.__io__equals(name, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, name)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, name);
         } else {
            __io__generic__copy(this.getName(), name);
         }

      }
   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 98L) : this.__io__block.readShort(this.__io__address + 82L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 98L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 82L, flag);
      }

   }

   public short getTag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 100L) : this.__io__block.readShort(this.__io__address + 84L);
   }

   public void setTag(short tag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 100L, tag);
      } else {
         this.__io__block.writeShort(this.__io__address + 84L, tag);
      }

   }

   public short getPad_s1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 102L) : this.__io__block.readShort(this.__io__address + 86L);
   }

   public void setPad_s1(short pad_s1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 102L, pad_s1);
      } else {
         this.__io__block.writeShort(this.__io__address + 86L, pad_s1);
      }

   }

   public int getUs() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 104L) : this.__io__block.readInt(this.__io__address + 88L);
   }

   public void setUs(int us) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 104L, us);
      } else {
         this.__io__block.writeInt(this.__io__address + 88L, us);
      }

   }

   public int getIcon_id() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 108L) : this.__io__block.readInt(this.__io__address + 92L);
   }

   public void setIcon_id(int icon_id) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 108L, icon_id);
      } else {
         this.__io__block.writeInt(this.__io__address + 92L, icon_id);
      }

   }

   public CPointer<IDProperty> getProperties() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 112L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 96L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{IDProperty.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 9), this.__io__blockTable);
   }

   public void setProperties(CPointer<IDProperty> properties) throws IOException {
      long __address = properties == null ? 0L : properties.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 112L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 96L, __address);
      }

   }

   public CPointer<ID> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{ID.class}, this.__io__block, this.__io__blockTable);
   }
}
