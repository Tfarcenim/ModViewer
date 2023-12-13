package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 48L,
   size64 = 64L
)
public class Paint extends CFacade {
   public static final int __DNA__SDNA_INDEX = 185;
   public static final long[] __DNA__FIELD__brush = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__palette = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__cavity_curve = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__paint_cursor = new long[]{12L, 24L};
   public static final long[] __DNA__FIELD__paint_cursor_col = new long[]{16L, 32L};
   public static final long[] __DNA__FIELD__flags = new long[]{20L, 36L};
   public static final long[] __DNA__FIELD__num_input_samples = new long[]{24L, 40L};
   public static final long[] __DNA__FIELD__symmetry_flags = new long[]{28L, 44L};
   public static final long[] __DNA__FIELD__tile_offset = new long[]{32L, 48L};
   public static final long[] __DNA__FIELD__pad2 = new long[]{44L, 60L};

   public Paint(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Paint(Paint that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<Brush> getBrush() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Brush.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 468), this.__io__blockTable);
   }

   public void setBrush(CPointer<Brush> brush) throws IOException {
      long __address = brush == null ? 0L : brush.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<Palette> getPalette() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Palette.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 470), this.__io__blockTable);
   }

   public void setPalette(CPointer<Palette> palette) throws IOException {
      long __address = palette == null ? 0L : palette.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public CPointer<CurveMapping> getCavity_curve() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{CurveMapping.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 461), this.__io__blockTable);
   }

   public void setCavity_curve(CPointer<CurveMapping> cavity_curve) throws IOException {
      long __address = cavity_curve == null ? 0L : cavity_curve.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      }

   }

   public CPointer<Object> getPaint_cursor() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 24L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 12L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setPaint_cursor(CPointer<Object> paint_cursor) throws IOException {
      long __address = paint_cursor == null ? 0L : paint_cursor.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 24L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 12L, __address);
      }

   }

   public CArrayFacade<Byte> getPaint_cursor_col() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 32L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 16L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPaint_cursor_col(CArrayFacade<Byte> paint_cursor_col) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 32L;
      } else {
         __dna__offset = 16L;
      }

      if (!this.__io__equals(paint_cursor_col, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, paint_cursor_col)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, paint_cursor_col);
         } else {
            __io__generic__copy(this.getPaint_cursor_col(), paint_cursor_col);
         }

      }
   }

   public int getFlags() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 36L) : this.__io__block.readInt(this.__io__address + 20L);
   }

   public void setFlags(int flags) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 36L, flags);
      } else {
         this.__io__block.writeInt(this.__io__address + 20L, flags);
      }

   }

   public int getNum_input_samples() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 40L) : this.__io__block.readInt(this.__io__address + 24L);
   }

   public void setNum_input_samples(int num_input_samples) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 40L, num_input_samples);
      } else {
         this.__io__block.writeInt(this.__io__address + 24L, num_input_samples);
      }

   }

   public int getSymmetry_flags() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 44L) : this.__io__block.readInt(this.__io__address + 28L);
   }

   public void setSymmetry_flags(int symmetry_flags) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 44L, symmetry_flags);
      } else {
         this.__io__block.writeInt(this.__io__address + 28L, symmetry_flags);
      }

   }

   public CArrayFacade<Float> getTile_offset() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 48L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 32L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setTile_offset(CArrayFacade<Float> tile_offset) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 48L;
      } else {
         __dna__offset = 32L;
      }

      if (!this.__io__equals(tile_offset, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, tile_offset)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, tile_offset);
         } else {
            __io__generic__copy(this.getTile_offset(), tile_offset);
         }

      }
   }

   public int getPad2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 60L) : this.__io__block.readInt(this.__io__address + 44L);
   }

   public void setPad2(int pad2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 60L, pad2);
      } else {
         this.__io__block.writeInt(this.__io__address + 44L, pad2);
      }

   }

   public CPointer<Paint> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Paint.class}, this.__io__block, this.__io__blockTable);
   }
}
