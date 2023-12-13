package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 2168L,
   size64 = 2200L
)
public class Library extends CFacade {
   public static final int __DNA__SDNA_INDEX = 11;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__filedata = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__name = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__filepath = new long[]{1128L, 1152L};
   public static final long[] __DNA__FIELD__parent = new long[]{2152L, 2176L};
   public static final long[] __DNA__FIELD__packedfile = new long[]{2156L, 2184L};
   public static final long[] __DNA__FIELD__temp_index = new long[]{2160L, 2192L};
   public static final long[] __DNA__FIELD__versionfile = new long[]{2164L, 2196L};
   public static final long[] __DNA__FIELD__subversionfile = new long[]{2166L, 2198L};

   public Library(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Library(Library that) {
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

   public CPointer<Object> getFiledata() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 120L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 100L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setFiledata(CPointer<Object> filedata) throws IOException {
      long __address = filedata == null ? 0L : filedata.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 120L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 100L, __address);
      }

   }

   public CArrayFacade<Byte> getName() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{1024};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 128L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 104L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setName(CArrayFacade<Byte> name) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 128L;
      } else {
         __dna__offset = 104L;
      }

      if (!this.__io__equals(name, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, name)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, name);
         } else {
            __io__generic__copy(this.getName(), name);
         }

      }
   }

   public CArrayFacade<Byte> getFilepath() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{1024};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1152L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1128L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setFilepath(CArrayFacade<Byte> filepath) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1152L;
      } else {
         __dna__offset = 1128L;
      }

      if (!this.__io__equals(filepath, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, filepath)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, filepath);
         } else {
            __io__generic__copy(this.getFilepath(), filepath);
         }

      }
   }

   public CPointer<Library> getParent() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 2176L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 2152L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Library.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 11), this.__io__blockTable);
   }

   public void setParent(CPointer<Library> parent) throws IOException {
      long __address = parent == null ? 0L : parent.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 2176L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 2152L, __address);
      }

   }

   public CPointer<PackedFile> getPackedfile() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 2184L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 2156L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PackedFile.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 20), this.__io__blockTable);
   }

   public void setPackedfile(CPointer<PackedFile> packedfile) throws IOException {
      long __address = packedfile == null ? 0L : packedfile.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 2184L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 2156L, __address);
      }

   }

   public int getTemp_index() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 2192L) : this.__io__block.readInt(this.__io__address + 2160L);
   }

   public void setTemp_index(int temp_index) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 2192L, temp_index);
      } else {
         this.__io__block.writeInt(this.__io__address + 2160L, temp_index);
      }

   }

   public short getVersionfile() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 2196L) : this.__io__block.readShort(this.__io__address + 2164L);
   }

   public void setVersionfile(short versionfile) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 2196L, versionfile);
      } else {
         this.__io__block.writeShort(this.__io__address + 2164L, versionfile);
      }

   }

   public short getSubversionfile() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 2198L) : this.__io__block.readShort(this.__io__address + 2166L);
   }

   public void setSubversionfile(short subversionfile) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 2198L, subversionfile);
      } else {
         this.__io__block.writeShort(this.__io__address + 2166L, subversionfile);
      }

   }

   public CPointer<Library> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Library.class}, this.__io__block, this.__io__blockTable);
   }
}
