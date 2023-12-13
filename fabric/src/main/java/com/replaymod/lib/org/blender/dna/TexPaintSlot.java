package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 16L,
   size64 = 24L
)
public class TexPaintSlot extends CFacade {
   public static final int __DNA__SDNA_INDEX = 45;
   public static final long[] __DNA__FIELD__ima = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__uvname = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__index = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__pad = new long[]{12L, 20L};

   public TexPaintSlot(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected TexPaintSlot(TexPaintSlot that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<Image> getIma() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Image.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 31), this.__io__blockTable);
   }

   public void setIma(CPointer<Image> ima) throws IOException {
      long __address = ima == null ? 0L : ima.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<Byte> getUvname() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, __dna__targetTypes), this.__io__blockTable);
   }

   public void setUvname(CPointer<Byte> uvname) throws IOException {
      long __address = uvname == null ? 0L : uvname.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public int getIndex() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 16L) : this.__io__block.readInt(this.__io__address + 8L);
   }

   public void setIndex(int index) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 16L, index);
      } else {
         this.__io__block.writeInt(this.__io__address + 8L, index);
      }

   }

   public int getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 20L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setPad(int pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 20L, pad);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, pad);
      }

   }

   public CPointer<TexPaintSlot> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{TexPaintSlot.class}, this.__io__block, this.__io__blockTable);
   }
}
