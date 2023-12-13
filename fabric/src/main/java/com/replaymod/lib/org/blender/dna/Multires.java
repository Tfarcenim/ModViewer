package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 420L,
   size64 = 464L
)
public class Multires extends CFacade {
   public static final int __DNA__SDNA_INDEX = 83;
   public static final long[] __DNA__FIELD__levels = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__verts = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__level_count = new long[]{12L, 24L};
   public static final long[] __DNA__FIELD__current = new long[]{13L, 25L};
   public static final long[] __DNA__FIELD__newlvl = new long[]{14L, 26L};
   public static final long[] __DNA__FIELD__edgelvl = new long[]{15L, 27L};
   public static final long[] __DNA__FIELD__pinlvl = new long[]{16L, 28L};
   public static final long[] __DNA__FIELD__renderlvl = new long[]{17L, 29L};
   public static final long[] __DNA__FIELD__use_col = new long[]{18L, 30L};
   public static final long[] __DNA__FIELD__flag = new long[]{19L, 31L};
   public static final long[] __DNA__FIELD__vdata = new long[]{20L, 32L};
   public static final long[] __DNA__FIELD__fdata = new long[]{216L, 240L};
   public static final long[] __DNA__FIELD__edge_flags = new long[]{412L, 448L};
   public static final long[] __DNA__FIELD__edge_creases = new long[]{416L, 456L};

   public Multires(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Multires(Multires that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public ListBase getLevels() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 0L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 0L, this.__io__block, this.__io__blockTable);
   }

   public void setLevels(ListBase levels) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(levels, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, levels)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, levels);
         } else {
            __io__generic__copy(this.getLevels(), levels);
         }

      }
   }

   public CPointer<MVert> getVerts() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MVert.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 63), this.__io__blockTable);
   }

   public void setVerts(CPointer<MVert> verts) throws IOException {
      long __address = verts == null ? 0L : verts.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      }

   }

   public byte getLevel_count() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 24L) : this.__io__block.readByte(this.__io__address + 12L);
   }

   public void setLevel_count(byte level_count) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 24L, level_count);
      } else {
         this.__io__block.writeByte(this.__io__address + 12L, level_count);
      }

   }

   public byte getCurrent() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 25L) : this.__io__block.readByte(this.__io__address + 13L);
   }

   public void setCurrent(byte current) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 25L, current);
      } else {
         this.__io__block.writeByte(this.__io__address + 13L, current);
      }

   }

   public byte getNewlvl() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 26L) : this.__io__block.readByte(this.__io__address + 14L);
   }

   public void setNewlvl(byte newlvl) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 26L, newlvl);
      } else {
         this.__io__block.writeByte(this.__io__address + 14L, newlvl);
      }

   }

   public byte getEdgelvl() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 27L) : this.__io__block.readByte(this.__io__address + 15L);
   }

   public void setEdgelvl(byte edgelvl) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 27L, edgelvl);
      } else {
         this.__io__block.writeByte(this.__io__address + 15L, edgelvl);
      }

   }

   public byte getPinlvl() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 28L) : this.__io__block.readByte(this.__io__address + 16L);
   }

   public void setPinlvl(byte pinlvl) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 28L, pinlvl);
      } else {
         this.__io__block.writeByte(this.__io__address + 16L, pinlvl);
      }

   }

   public byte getRenderlvl() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 29L) : this.__io__block.readByte(this.__io__address + 17L);
   }

   public void setRenderlvl(byte renderlvl) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 29L, renderlvl);
      } else {
         this.__io__block.writeByte(this.__io__address + 17L, renderlvl);
      }

   }

   public byte getUse_col() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 30L) : this.__io__block.readByte(this.__io__address + 18L);
   }

   public void setUse_col(byte use_col) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 30L, use_col);
      } else {
         this.__io__block.writeByte(this.__io__address + 18L, use_col);
      }

   }

   public byte getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 31L) : this.__io__block.readByte(this.__io__address + 19L);
   }

   public void setFlag(byte flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 31L, flag);
      } else {
         this.__io__block.writeByte(this.__io__address + 19L, flag);
      }

   }

   public CustomData getVdata() throws IOException {
      return this.__io__pointersize == 8 ? new CustomData(this.__io__address + 32L, this.__io__block, this.__io__blockTable) : new CustomData(this.__io__address + 20L, this.__io__block, this.__io__blockTable);
   }

   public void setVdata(CustomData vdata) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 32L;
      } else {
         __dna__offset = 20L;
      }

      if (!this.__io__equals(vdata, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, vdata)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, vdata);
         } else {
            __io__generic__copy(this.getVdata(), vdata);
         }

      }
   }

   public CustomData getFdata() throws IOException {
      return this.__io__pointersize == 8 ? new CustomData(this.__io__address + 240L, this.__io__block, this.__io__blockTable) : new CustomData(this.__io__address + 216L, this.__io__block, this.__io__blockTable);
   }

   public void setFdata(CustomData fdata) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 240L;
      } else {
         __dna__offset = 216L;
      }

      if (!this.__io__equals(fdata, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, fdata)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, fdata);
         } else {
            __io__generic__copy(this.getFdata(), fdata);
         }

      }
   }

   public CPointer<Short> getEdge_flags() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 448L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 412L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Short.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, __dna__targetTypes), this.__io__blockTable);
   }

   public void setEdge_flags(CPointer<Short> edge_flags) throws IOException {
      long __address = edge_flags == null ? 0L : edge_flags.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 448L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 412L, __address);
      }

   }

   public CPointer<Byte> getEdge_creases() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 456L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 416L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, __dna__targetTypes), this.__io__blockTable);
   }

   public void setEdge_creases(CPointer<Byte> edge_creases) throws IOException {
      long __address = edge_creases == null ? 0L : edge_creases.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 456L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 416L, __address);
      }

   }

   public CPointer<Multires> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Multires.class}, this.__io__block, this.__io__blockTable);
   }
}
