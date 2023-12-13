package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 12L,
   size64 = 16L
)
public class PackedFile extends CFacade {
   public static final int __DNA__SDNA_INDEX = 20;
   public static final long[] __DNA__FIELD__size = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__seek = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__data = new long[]{8L, 8L};

   public PackedFile(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected PackedFile(PackedFile that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public int getSize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 0L) : this.__io__block.readInt(this.__io__address + 0L);
   }

   public void setSize(int size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 0L, size);
      } else {
         this.__io__block.writeInt(this.__io__address + 0L, size);
      }

   }

   public int getSeek() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 4L) : this.__io__block.readInt(this.__io__address + 4L);
   }

   public void setSeek(int seek) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 4L, seek);
      } else {
         this.__io__block.writeInt(this.__io__address + 4L, seek);
      }

   }

   public CPointer<Object> getData() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setData(CPointer<Object> data) throws IOException {
      long __address = data == null ? 0L : data.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      }

   }

   public CPointer<PackedFile> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{PackedFile.class}, this.__io__block, this.__io__blockTable);
   }
}
