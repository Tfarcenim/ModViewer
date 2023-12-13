package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 1044L,
   size64 = 1048L
)
public class StripProxy extends CFacade {
   public static final int __DNA__SDNA_INDEX = 270;
   public static final long[] __DNA__FIELD__dir = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__file = new long[]{768L, 768L};
   public static final long[] __DNA__FIELD__anim = new long[]{1024L, 1024L};
   public static final long[] __DNA__FIELD__tc = new long[]{1028L, 1032L};
   public static final long[] __DNA__FIELD__quality = new long[]{1030L, 1034L};
   public static final long[] __DNA__FIELD__build_size_flags = new long[]{1032L, 1036L};
   public static final long[] __DNA__FIELD__build_tc_flags = new long[]{1034L, 1038L};
   public static final long[] __DNA__FIELD__build_flags = new long[]{1036L, 1040L};
   public static final long[] __DNA__FIELD__storage = new long[]{1038L, 1042L};
   public static final long[] __DNA__FIELD__pad = new long[]{1039L, 1043L};

   public StripProxy(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected StripProxy(StripProxy that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CArrayFacade<Byte> getDir() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{768};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setDir(CArrayFacade<Byte> dir) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(dir, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, dir)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, dir);
         } else {
            __io__generic__copy(this.getDir(), dir);
         }

      }
   }

   public CArrayFacade<Byte> getFile() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{256};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 768L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 768L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setFile(CArrayFacade<Byte> file) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 768L;
      } else {
         __dna__offset = 768L;
      }

      if (!this.__io__equals(file, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, file)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, file);
         } else {
            __io__generic__copy(this.getFile(), file);
         }

      }
   }

   public CPointer<Object> getAnim() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1024L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1024L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setAnim(CPointer<Object> anim) throws IOException {
      long __address = anim == null ? 0L : anim.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1024L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1024L, __address);
      }

   }

   public short getTc() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1032L) : this.__io__block.readShort(this.__io__address + 1028L);
   }

   public void setTc(short tc) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1032L, tc);
      } else {
         this.__io__block.writeShort(this.__io__address + 1028L, tc);
      }

   }

   public short getQuality() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1034L) : this.__io__block.readShort(this.__io__address + 1030L);
   }

   public void setQuality(short quality) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1034L, quality);
      } else {
         this.__io__block.writeShort(this.__io__address + 1030L, quality);
      }

   }

   public short getBuild_size_flags() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1036L) : this.__io__block.readShort(this.__io__address + 1032L);
   }

   public void setBuild_size_flags(short build_size_flags) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1036L, build_size_flags);
      } else {
         this.__io__block.writeShort(this.__io__address + 1032L, build_size_flags);
      }

   }

   public short getBuild_tc_flags() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1038L) : this.__io__block.readShort(this.__io__address + 1034L);
   }

   public void setBuild_tc_flags(short build_tc_flags) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1038L, build_tc_flags);
      } else {
         this.__io__block.writeShort(this.__io__address + 1034L, build_tc_flags);
      }

   }

   public short getBuild_flags() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1040L) : this.__io__block.readShort(this.__io__address + 1036L);
   }

   public void setBuild_flags(short build_flags) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1040L, build_flags);
      } else {
         this.__io__block.writeShort(this.__io__address + 1036L, build_flags);
      }

   }

   public byte getStorage() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1042L) : this.__io__block.readByte(this.__io__address + 1038L);
   }

   public void setStorage(byte storage) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1042L, storage);
      } else {
         this.__io__block.writeByte(this.__io__address + 1038L, storage);
      }

   }

   public CArrayFacade<Byte> getPad() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{5};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1043L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1039L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad(CArrayFacade<Byte> pad) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1043L;
      } else {
         __dna__offset = 1039L;
      }

      if (!this.__io__equals(pad, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad);
         } else {
            __io__generic__copy(this.getPad(), pad);
         }

      }
   }

   public CPointer<StripProxy> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{StripProxy.class}, this.__io__block, this.__io__blockTable);
   }
}
