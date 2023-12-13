package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 1136L,
   size64 = 1168L
)
public class VFont extends CFacade {
   public static final int __DNA__SDNA_INDEX = 47;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__name = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__data = new long[]{1124L, 1144L};
   public static final long[] __DNA__FIELD__packedfile = new long[]{1128L, 1152L};
   public static final long[] __DNA__FIELD__temp_pf = new long[]{1132L, 1160L};

   public VFont(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected VFont(VFont that) {
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

   public CArrayFacade<Byte> getName() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{1024};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 120L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 100L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setName(CArrayFacade<Byte> name) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 120L;
      } else {
         __dna__offset = 100L;
      }

      if (!this.__io__equals(name, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, name)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, name);
         } else {
            __io__generic__copy(this.getName(), name);
         }

      }
   }

   public CPointer<Object> getData() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1144L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1124L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setData(CPointer<Object> data) throws IOException {
      long __address = data == null ? 0L : data.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1144L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1124L, __address);
      }

   }

   public CPointer<PackedFile> getPackedfile() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1152L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1128L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PackedFile.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 20), this.__io__blockTable);
   }

   public void setPackedfile(CPointer<PackedFile> packedfile) throws IOException {
      long __address = packedfile == null ? 0L : packedfile.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1152L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1128L, __address);
      }

   }

   public CPointer<PackedFile> getTemp_pf() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1160L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1132L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PackedFile.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 20), this.__io__blockTable);
   }

   public void setTemp_pf(CPointer<PackedFile> temp_pf) throws IOException {
      long __address = temp_pf == null ? 0L : temp_pf.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1160L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1132L, __address);
      }

   }

   public CPointer<VFont> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{VFont.class}, this.__io__block, this.__io__blockTable);
   }
}
