package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 44L,
   size64 = 48L
)
public class MTFace extends CFacade {
   public static final int __DNA__SDNA_INDEX = 71;
   public static final long[] __DNA__FIELD__uv = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__tpage = new long[]{32L, 32L};
   public static final long[] __DNA__FIELD__flag = new long[]{36L, 40L};
   public static final long[] __DNA__FIELD__transp = new long[]{37L, 41L};
   public static final long[] __DNA__FIELD__mode = new long[]{38L, 42L};
   public static final long[] __DNA__FIELD__tile = new long[]{40L, 44L};
   public static final long[] __DNA__FIELD__unwrap = new long[]{42L, 46L};

   public MTFace(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MTFace(MTFace that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CArrayFacade<CArrayFacade<Float>> getUv() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CArrayFacade.class, Float.class};
      int[] __dna__dimensions = new int[]{4, 2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setUv(CArrayFacade<CArrayFacade<Float>> uv) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(uv, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, uv)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, uv);
         } else {
            __io__generic__copy(this.getUv(), uv);
         }

      }
   }

   public CPointer<Image> getTpage() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 32L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 32L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Image.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 31), this.__io__blockTable);
   }

   public void setTpage(CPointer<Image> tpage) throws IOException {
      long __address = tpage == null ? 0L : tpage.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 32L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 32L, __address);
      }

   }

   public byte getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 40L) : this.__io__block.readByte(this.__io__address + 36L);
   }

   public void setFlag(byte flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 40L, flag);
      } else {
         this.__io__block.writeByte(this.__io__address + 36L, flag);
      }

   }

   public byte getTransp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 41L) : this.__io__block.readByte(this.__io__address + 37L);
   }

   public void setTransp(byte transp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 41L, transp);
      } else {
         this.__io__block.writeByte(this.__io__address + 37L, transp);
      }

   }

   public short getMode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 42L) : this.__io__block.readShort(this.__io__address + 38L);
   }

   public void setMode(short mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 42L, mode);
      } else {
         this.__io__block.writeShort(this.__io__address + 38L, mode);
      }

   }

   public short getTile() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 44L) : this.__io__block.readShort(this.__io__address + 40L);
   }

   public void setTile(short tile) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 44L, tile);
      } else {
         this.__io__block.writeShort(this.__io__address + 40L, tile);
      }

   }

   public short getUnwrap() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 46L) : this.__io__block.readShort(this.__io__address + 42L);
   }

   public void setUnwrap(short unwrap) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 46L, unwrap);
      } else {
         this.__io__block.writeShort(this.__io__address + 42L, unwrap);
      }

   }

   public CPointer<MTFace> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MTFace.class}, this.__io__block, this.__io__blockTable);
   }
}
