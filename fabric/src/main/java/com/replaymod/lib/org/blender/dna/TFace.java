package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 60L,
   size64 = 64L
)
public class TFace extends CFacade {
   public static final int __DNA__SDNA_INDEX = 58;
   public static final long[] __DNA__FIELD__tpage = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__uv = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__col = new long[]{36L, 40L};
   public static final long[] __DNA__FIELD__flag = new long[]{52L, 56L};
   public static final long[] __DNA__FIELD__transp = new long[]{53L, 57L};
   public static final long[] __DNA__FIELD__mode = new long[]{54L, 58L};
   public static final long[] __DNA__FIELD__tile = new long[]{56L, 60L};
   public static final long[] __DNA__FIELD__unwrap = new long[]{58L, 62L};

   public TFace(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected TFace(TFace that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<Object> getTpage() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setTpage(CPointer<Object> tpage) throws IOException {
      long __address = tpage == null ? 0L : tpage.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CArrayFacade<CArrayFacade<Float>> getUv() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CArrayFacade.class, Float.class};
      int[] __dna__dimensions = new int[]{4, 2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 4L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setUv(CArrayFacade<CArrayFacade<Float>> uv) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 8L;
      } else {
         __dna__offset = 4L;
      }

      if (!this.__io__equals(uv, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, uv)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, uv);
         } else {
            __io__generic__copy(this.getUv(), uv);
         }

      }
   }

   public CArrayFacade<Integer> getCol() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Integer.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 40L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 36L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setCol(CArrayFacade<Integer> col) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 40L;
      } else {
         __dna__offset = 36L;
      }

      if (!this.__io__equals(col, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, col)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, col);
         } else {
            __io__generic__copy(this.getCol(), col);
         }

      }
   }

   public byte getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 56L) : this.__io__block.readByte(this.__io__address + 52L);
   }

   public void setFlag(byte flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 56L, flag);
      } else {
         this.__io__block.writeByte(this.__io__address + 52L, flag);
      }

   }

   public byte getTransp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 57L) : this.__io__block.readByte(this.__io__address + 53L);
   }

   public void setTransp(byte transp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 57L, transp);
      } else {
         this.__io__block.writeByte(this.__io__address + 53L, transp);
      }

   }

   public short getMode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 58L) : this.__io__block.readShort(this.__io__address + 54L);
   }

   public void setMode(short mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 58L, mode);
      } else {
         this.__io__block.writeShort(this.__io__address + 54L, mode);
      }

   }

   public short getTile() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 60L) : this.__io__block.readShort(this.__io__address + 56L);
   }

   public void setTile(short tile) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 60L, tile);
      } else {
         this.__io__block.writeShort(this.__io__address + 56L, tile);
      }

   }

   public short getUnwrap() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 62L) : this.__io__block.readShort(this.__io__address + 58L);
   }

   public void setUnwrap(short unwrap) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 62L, unwrap);
      } else {
         this.__io__block.writeShort(this.__io__address + 58L, unwrap);
      }

   }

   public CPointer<TFace> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{TFace.class}, this.__io__block, this.__io__blockTable);
   }
}
