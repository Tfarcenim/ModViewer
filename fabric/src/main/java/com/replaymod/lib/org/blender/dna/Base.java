package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 28L,
   size64 = 40L
)
public class Base extends CFacade {
   public static final int __DNA__SDNA_INDEX = 167;
   public static final long[] __DNA__FIELD__next = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__prev = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__lay = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__selcol = new long[]{12L, 20L};
   public static final long[] __DNA__FIELD__flag = new long[]{16L, 24L};
   public static final long[] __DNA__FIELD__sx = new long[]{20L, 28L};
   public static final long[] __DNA__FIELD__sy = new long[]{22L, 30L};
   public static final long[] __DNA__FIELD__object = new long[]{24L, 32L};

   public Base(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Base(Base that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<Base> getNext() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Base.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 167), this.__io__blockTable);
   }

   public void setNext(CPointer<Base> next) throws IOException {
      long __address = next == null ? 0L : next.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<Base> getPrev() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Base.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 167), this.__io__blockTable);
   }

   public void setPrev(CPointer<Base> prev) throws IOException {
      long __address = prev == null ? 0L : prev.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public int getLay() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 16L) : this.__io__block.readInt(this.__io__address + 8L);
   }

   public void setLay(int lay) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 16L, lay);
      } else {
         this.__io__block.writeInt(this.__io__address + 8L, lay);
      }

   }

   public int getSelcol() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 20L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setSelcol(int selcol) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 20L, selcol);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, selcol);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 24L) : this.__io__block.readInt(this.__io__address + 16L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 24L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 16L, flag);
      }

   }

   public short getSx() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 28L) : this.__io__block.readShort(this.__io__address + 20L);
   }

   public void setSx(short sx) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 28L, sx);
      } else {
         this.__io__block.writeShort(this.__io__address + 20L, sx);
      }

   }

   public short getSy() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 30L) : this.__io__block.readShort(this.__io__address + 22L);
   }

   public void setSy(short sy) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 30L, sy);
      } else {
         this.__io__block.writeShort(this.__io__address + 22L, sy);
      }

   }

   public CPointer<BlenderObject> getObject() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 32L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 24L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setObject(CPointer<BlenderObject> object) throws IOException {
      long __address = object == null ? 0L : object.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 32L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 24L, __address);
      }

   }

   public CPointer<Base> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Base.class}, this.__io__block, this.__io__blockTable);
   }
}
