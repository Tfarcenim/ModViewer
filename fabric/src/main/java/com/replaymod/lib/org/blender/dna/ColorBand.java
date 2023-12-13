package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 776L,
   size64 = 776L
)
public class ColorBand extends CFacade {
   public static final int __DNA__SDNA_INDEX = 34;
   public static final long[] __DNA__FIELD__tot = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__cur = new long[]{2L, 2L};
   public static final long[] __DNA__FIELD__ipotype = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__ipotype_hue = new long[]{5L, 5L};
   public static final long[] __DNA__FIELD__color_mode = new long[]{6L, 6L};
   public static final long[] __DNA__FIELD__pad = new long[]{7L, 7L};
   public static final long[] __DNA__FIELD__data = new long[]{8L, 8L};

   public ColorBand(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected ColorBand(ColorBand that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public short getTot() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 0L) : this.__io__block.readShort(this.__io__address + 0L);
   }

   public void setTot(short tot) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 0L, tot);
      } else {
         this.__io__block.writeShort(this.__io__address + 0L, tot);
      }

   }

   public short getCur() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 2L) : this.__io__block.readShort(this.__io__address + 2L);
   }

   public void setCur(short cur) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 2L, cur);
      } else {
         this.__io__block.writeShort(this.__io__address + 2L, cur);
      }

   }

   public byte getIpotype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 4L) : this.__io__block.readByte(this.__io__address + 4L);
   }

   public void setIpotype(byte ipotype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 4L, ipotype);
      } else {
         this.__io__block.writeByte(this.__io__address + 4L, ipotype);
      }

   }

   public byte getIpotype_hue() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 5L) : this.__io__block.readByte(this.__io__address + 5L);
   }

   public void setIpotype_hue(byte ipotype_hue) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 5L, ipotype_hue);
      } else {
         this.__io__block.writeByte(this.__io__address + 5L, ipotype_hue);
      }

   }

   public byte getColor_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 6L) : this.__io__block.readByte(this.__io__address + 6L);
   }

   public void setColor_mode(byte color_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 6L, color_mode);
      } else {
         this.__io__block.writeByte(this.__io__address + 6L, color_mode);
      }

   }

   public CArrayFacade<Byte> getPad() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{1};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 7L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 7L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad(CArrayFacade<Byte> pad) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 7L;
      } else {
         __dna__offset = 7L;
      }

      if (!this.__io__equals(pad, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad);
         } else {
            __io__generic__copy(this.getPad(), pad);
         }

      }
   }

   public CArrayFacade<CBData> getData() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CBData.class};
      int[] __dna__dimensions = new int[]{32};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setData(CArrayFacade<CBData> data) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 8L;
      } else {
         __dna__offset = 8L;
      }

      if (!this.__io__equals(data, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, data)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, data);
         } else {
            __io__generic__copy(this.getData(), data);
         }

      }
   }

   public CPointer<ColorBand> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{ColorBand.class}, this.__io__block, this.__io__blockTable);
   }
}
