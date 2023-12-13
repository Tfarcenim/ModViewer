package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 156L,
   size64 = 200L
)
public class bGPdata extends CFacade {
   public static final int __DNA__SDNA_INDEX = 497;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__adt = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__layers = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__flag = new long[]{112L, 144L};
   public static final long[] __DNA__FIELD__sbuffer_size = new long[]{116L, 148L};
   public static final long[] __DNA__FIELD__sbuffer_sflag = new long[]{118L, 150L};
   public static final long[] __DNA__FIELD__sbuffer = new long[]{120L, 152L};
   public static final long[] __DNA__FIELD__scolor = new long[]{124L, 160L};
   public static final long[] __DNA__FIELD__pad = new long[]{140L, 176L};
   public static final long[] __DNA__FIELD__sflag = new long[]{146L, 182L};
   public static final long[] __DNA__FIELD__palettes = new long[]{148L, 184L};

   public bGPdata(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected bGPdata(bGPdata that) {
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

   public CPointer<AnimData> getAdt() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 120L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 100L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{AnimData.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 528), this.__io__blockTable);
   }

   public void setAdt(CPointer<AnimData> adt) throws IOException {
      long __address = adt == null ? 0L : adt.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 120L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 100L, __address);
      }

   }

   public ListBase getLayers() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 128L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 104L, this.__io__block, this.__io__blockTable);
   }

   public void setLayers(ListBase layers) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 128L;
      } else {
         __dna__offset = 104L;
      }

      if (!this.__io__equals(layers, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, layers)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, layers);
         } else {
            __io__generic__copy(this.getLayers(), layers);
         }

      }
   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 144L) : this.__io__block.readInt(this.__io__address + 112L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 144L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 112L, flag);
      }

   }

   public short getSbuffer_size() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 148L) : this.__io__block.readShort(this.__io__address + 116L);
   }

   public void setSbuffer_size(short sbuffer_size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 148L, sbuffer_size);
      } else {
         this.__io__block.writeShort(this.__io__address + 116L, sbuffer_size);
      }

   }

   public short getSbuffer_sflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 150L) : this.__io__block.readShort(this.__io__address + 118L);
   }

   public void setSbuffer_sflag(short sbuffer_sflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 150L, sbuffer_sflag);
      } else {
         this.__io__block.writeShort(this.__io__address + 118L, sbuffer_sflag);
      }

   }

   public CPointer<Object> getSbuffer() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 152L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 120L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setSbuffer(CPointer<Object> sbuffer) throws IOException {
      long __address = sbuffer == null ? 0L : sbuffer.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 152L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 120L, __address);
      }

   }

   public CArrayFacade<Float> getScolor() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 160L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 124L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setScolor(CArrayFacade<Float> scolor) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 160L;
      } else {
         __dna__offset = 124L;
      }

      if (!this.__io__equals(scolor, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, scolor)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, scolor);
         } else {
            __io__generic__copy(this.getScolor(), scolor);
         }

      }
   }

   public CArrayFacade<Byte> getPad() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{6};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 176L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 140L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad(CArrayFacade<Byte> pad) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 176L;
      } else {
         __dna__offset = 140L;
      }

      if (!this.__io__equals(pad, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad);
         } else {
            __io__generic__copy(this.getPad(), pad);
         }

      }
   }

   public short getSflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 182L) : this.__io__block.readShort(this.__io__address + 146L);
   }

   public void setSflag(short sflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 182L, sflag);
      } else {
         this.__io__block.writeShort(this.__io__address + 146L, sflag);
      }

   }

   public ListBase getPalettes() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 184L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 148L, this.__io__block, this.__io__blockTable);
   }

   public void setPalettes(ListBase palettes) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 184L;
      } else {
         __dna__offset = 148L;
      }

      if (!this.__io__equals(palettes, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, palettes)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, palettes);
         } else {
            __io__generic__copy(this.getPalettes(), palettes);
         }

      }
   }

   public CPointer<bGPdata> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{bGPdata.class}, this.__io__block, this.__io__blockTable);
   }
}
