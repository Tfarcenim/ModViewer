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
public class MTexPoly extends CFacade {
   public static final int __DNA__SDNA_INDEX = 67;
   public static final long[] __DNA__FIELD__tpage = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__flag = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__transp = new long[]{5L, 9L};
   public static final long[] __DNA__FIELD__mode = new long[]{6L, 10L};
   public static final long[] __DNA__FIELD__tile = new long[]{8L, 12L};
   public static final long[] __DNA__FIELD__pad = new long[]{10L, 14L};

   public MTexPoly(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MTexPoly(MTexPoly that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<Image> getTpage() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Image.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 31), this.__io__blockTable);
   }

   public void setTpage(CPointer<Image> tpage) throws IOException {
      long __address = tpage == null ? 0L : tpage.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public byte getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 8L) : this.__io__block.readByte(this.__io__address + 4L);
   }

   public void setFlag(byte flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 8L, flag);
      } else {
         this.__io__block.writeByte(this.__io__address + 4L, flag);
      }

   }

   public byte getTransp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 9L) : this.__io__block.readByte(this.__io__address + 5L);
   }

   public void setTransp(byte transp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 9L, transp);
      } else {
         this.__io__block.writeByte(this.__io__address + 5L, transp);
      }

   }

   public short getMode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 10L) : this.__io__block.readShort(this.__io__address + 6L);
   }

   public void setMode(short mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 10L, mode);
      } else {
         this.__io__block.writeShort(this.__io__address + 6L, mode);
      }

   }

   public short getTile() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 12L) : this.__io__block.readShort(this.__io__address + 8L);
   }

   public void setTile(short tile) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 12L, tile);
      } else {
         this.__io__block.writeShort(this.__io__address + 8L, tile);
      }

   }

   public short getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 14L) : this.__io__block.readShort(this.__io__address + 10L);
   }

   public void setPad(short pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 14L, pad);
      } else {
         this.__io__block.writeShort(this.__io__address + 10L, pad);
      }

   }

   public CPointer<MTexPoly> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MTexPoly.class}, this.__io__block, this.__io__blockTable);
   }
}
