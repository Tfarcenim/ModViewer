package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 1036L,
   size64 = 1048L
)
public class ImagePackedFile extends CFacade {
   public static final int __DNA__SDNA_INDEX = 29;
   public static final long[] __DNA__FIELD__next = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__prev = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__packedfile = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__filepath = new long[]{12L, 24L};

   public ImagePackedFile(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected ImagePackedFile(ImagePackedFile that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<ImagePackedFile> getNext() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{ImagePackedFile.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 29), this.__io__blockTable);
   }

   public void setNext(CPointer<ImagePackedFile> next) throws IOException {
      long __address = next == null ? 0L : next.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<ImagePackedFile> getPrev() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{ImagePackedFile.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 29), this.__io__blockTable);
   }

   public void setPrev(CPointer<ImagePackedFile> prev) throws IOException {
      long __address = prev == null ? 0L : prev.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public CPointer<PackedFile> getPackedfile() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PackedFile.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 20), this.__io__blockTable);
   }

   public void setPackedfile(CPointer<PackedFile> packedfile) throws IOException {
      long __address = packedfile == null ? 0L : packedfile.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      }

   }

   public CArrayFacade<Byte> getFilepath() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{1024};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 24L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 12L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setFilepath(CArrayFacade<Byte> filepath) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 24L;
      } else {
         __dna__offset = 12L;
      }

      if (!this.__io__equals(filepath, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, filepath)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, filepath);
         } else {
            __io__generic__copy(this.getFilepath(), filepath);
         }

      }
   }

   public CPointer<ImagePackedFile> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{ImagePackedFile.class}, this.__io__block, this.__io__blockTable);
   }
}
