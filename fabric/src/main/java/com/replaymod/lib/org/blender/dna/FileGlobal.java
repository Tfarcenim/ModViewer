package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 1080L,
   size64 = 1088L
)
public class FileGlobal extends CFacade {
   public static final int __DNA__SDNA_INDEX = 264;
   public static final long[] __DNA__FIELD__subvstr = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__subversion = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__minversion = new long[]{6L, 6L};
   public static final long[] __DNA__FIELD__minsubversion = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__pad = new long[]{10L, 10L};
   public static final long[] __DNA__FIELD__curscreen = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__curscene = new long[]{20L, 24L};
   public static final long[] __DNA__FIELD__fileflags = new long[]{24L, 32L};
   public static final long[] __DNA__FIELD__globalf = new long[]{28L, 36L};
   public static final long[] __DNA__FIELD__build_commit_timestamp = new long[]{32L, 40L};
   public static final long[] __DNA__FIELD__build_hash = new long[]{40L, 48L};
   public static final long[] __DNA__FIELD__filename = new long[]{56L, 64L};

   public FileGlobal(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected FileGlobal(FileGlobal that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CArrayFacade<Byte> getSubvstr() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setSubvstr(CArrayFacade<Byte> subvstr) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(subvstr, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, subvstr)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, subvstr);
         } else {
            __io__generic__copy(this.getSubvstr(), subvstr);
         }

      }
   }

   public short getSubversion() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 4L) : this.__io__block.readShort(this.__io__address + 4L);
   }

   public void setSubversion(short subversion) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 4L, subversion);
      } else {
         this.__io__block.writeShort(this.__io__address + 4L, subversion);
      }

   }

   public short getMinversion() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 6L) : this.__io__block.readShort(this.__io__address + 6L);
   }

   public void setMinversion(short minversion) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 6L, minversion);
      } else {
         this.__io__block.writeShort(this.__io__address + 6L, minversion);
      }

   }

   public short getMinsubversion() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 8L) : this.__io__block.readShort(this.__io__address + 8L);
   }

   public void setMinsubversion(short minsubversion) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 8L, minsubversion);
      } else {
         this.__io__block.writeShort(this.__io__address + 8L, minsubversion);
      }

   }

   public CArrayFacade<Byte> getPad() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{6};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 10L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 10L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad(CArrayFacade<Byte> pad) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 10L;
      } else {
         __dna__offset = 10L;
      }

      if (!this.__io__equals(pad, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad);
         } else {
            __io__generic__copy(this.getPad(), pad);
         }

      }
   }

   public CPointer<bScreen> getCurscreen() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bScreen.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 255), this.__io__blockTable);
   }

   public void setCurscreen(CPointer<bScreen> curscreen) throws IOException {
      long __address = curscreen == null ? 0L : curscreen.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      }

   }

   public CPointer<Scene> getCurscene() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 24L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 20L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Scene.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 204), this.__io__blockTable);
   }

   public void setCurscene(CPointer<Scene> curscene) throws IOException {
      long __address = curscene == null ? 0L : curscene.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 24L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 20L, __address);
      }

   }

   public int getFileflags() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 32L) : this.__io__block.readInt(this.__io__address + 24L);
   }

   public void setFileflags(int fileflags) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 32L, fileflags);
      } else {
         this.__io__block.writeInt(this.__io__address + 24L, fileflags);
      }

   }

   public int getGlobalf() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 36L) : this.__io__block.readInt(this.__io__address + 28L);
   }

   public void setGlobalf(int globalf) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 36L, globalf);
      } else {
         this.__io__block.writeInt(this.__io__address + 28L, globalf);
      }

   }

   public long getBuild_commit_timestamp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt64(this.__io__address + 40L) : this.__io__block.readInt64(this.__io__address + 32L);
   }

   public void setBuild_commit_timestamp(long build_commit_timestamp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt64(this.__io__address + 40L, build_commit_timestamp);
      } else {
         this.__io__block.writeInt64(this.__io__address + 32L, build_commit_timestamp);
      }

   }

   public CArrayFacade<Byte> getBuild_hash() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{16};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 48L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 40L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setBuild_hash(CArrayFacade<Byte> build_hash) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 48L;
      } else {
         __dna__offset = 40L;
      }

      if (!this.__io__equals(build_hash, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, build_hash)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, build_hash);
         } else {
            __io__generic__copy(this.getBuild_hash(), build_hash);
         }

      }
   }

   public CArrayFacade<Byte> getFilename() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{1024};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 64L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 56L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setFilename(CArrayFacade<Byte> filename) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 64L;
      } else {
         __dna__offset = 56L;
      }

      if (!this.__io__equals(filename, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, filename)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, filename);
         } else {
            __io__generic__copy(this.getFilename(), filename);
         }

      }
   }

   public CPointer<FileGlobal> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{FileGlobal.class}, this.__io__block, this.__io__blockTable);
   }
}
