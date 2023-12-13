package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 96L,
   size64 = 128L
)
public class ImagePaintSettings extends CFacade {
   public static final int __DNA__SDNA_INDEX = 186;
   public static final long[] __DNA__FIELD__paint = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__flag = new long[]{48L, 64L};
   public static final long[] __DNA__FIELD__missing_data = new long[]{50L, 66L};
   public static final long[] __DNA__FIELD__seam_bleed = new long[]{52L, 68L};
   public static final long[] __DNA__FIELD__normal_angle = new long[]{54L, 70L};
   public static final long[] __DNA__FIELD__screen_grab_size = new long[]{56L, 72L};
   public static final long[] __DNA__FIELD__mode = new long[]{60L, 76L};
   public static final long[] __DNA__FIELD__paintcursor = new long[]{64L, 80L};
   public static final long[] __DNA__FIELD__stencil = new long[]{68L, 88L};
   public static final long[] __DNA__FIELD__clone = new long[]{72L, 96L};
   public static final long[] __DNA__FIELD__canvas = new long[]{76L, 104L};
   public static final long[] __DNA__FIELD__stencil_col = new long[]{80L, 112L};
   public static final long[] __DNA__FIELD__dither = new long[]{92L, 124L};

   public ImagePaintSettings(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected ImagePaintSettings(ImagePaintSettings that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public Paint getPaint() throws IOException {
      return this.__io__pointersize == 8 ? new Paint(this.__io__address + 0L, this.__io__block, this.__io__blockTable) : new Paint(this.__io__address + 0L, this.__io__block, this.__io__blockTable);
   }

   public void setPaint(Paint paint) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(paint, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, paint)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, paint);
         } else {
            __io__generic__copy(this.getPaint(), paint);
         }

      }
   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 64L) : this.__io__block.readShort(this.__io__address + 48L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 64L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 48L, flag);
      }

   }

   public short getMissing_data() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 66L) : this.__io__block.readShort(this.__io__address + 50L);
   }

   public void setMissing_data(short missing_data) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 66L, missing_data);
      } else {
         this.__io__block.writeShort(this.__io__address + 50L, missing_data);
      }

   }

   public short getSeam_bleed() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 68L) : this.__io__block.readShort(this.__io__address + 52L);
   }

   public void setSeam_bleed(short seam_bleed) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 68L, seam_bleed);
      } else {
         this.__io__block.writeShort(this.__io__address + 52L, seam_bleed);
      }

   }

   public short getNormal_angle() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 70L) : this.__io__block.readShort(this.__io__address + 54L);
   }

   public void setNormal_angle(short normal_angle) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 70L, normal_angle);
      } else {
         this.__io__block.writeShort(this.__io__address + 54L, normal_angle);
      }

   }

   public CArrayFacade<Short> getScreen_grab_size() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Short.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 72L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 56L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setScreen_grab_size(CArrayFacade<Short> screen_grab_size) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 72L;
      } else {
         __dna__offset = 56L;
      }

      if (!this.__io__equals(screen_grab_size, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, screen_grab_size)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, screen_grab_size);
         } else {
            __io__generic__copy(this.getScreen_grab_size(), screen_grab_size);
         }

      }
   }

   public int getMode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 76L) : this.__io__block.readInt(this.__io__address + 60L);
   }

   public void setMode(int mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 76L, mode);
      } else {
         this.__io__block.writeInt(this.__io__address + 60L, mode);
      }

   }

   public CPointer<Object> getPaintcursor() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 80L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 64L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setPaintcursor(CPointer<Object> paintcursor) throws IOException {
      long __address = paintcursor == null ? 0L : paintcursor.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 80L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 64L, __address);
      }

   }

   public CPointer<Image> getStencil() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 88L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 68L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Image.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 31), this.__io__blockTable);
   }

   public void setStencil(CPointer<Image> stencil) throws IOException {
      long __address = stencil == null ? 0L : stencil.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 88L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 68L, __address);
      }

   }

   public CPointer<Image> getClone() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 96L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 72L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Image.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 31), this.__io__blockTable);
   }

   public void setClone(CPointer<Image> clone) throws IOException {
      long __address = clone == null ? 0L : clone.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 96L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 72L, __address);
      }

   }

   public CPointer<Image> getCanvas() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 104L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 76L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Image.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 31), this.__io__blockTable);
   }

   public void setCanvas(CPointer<Image> canvas) throws IOException {
      long __address = canvas == null ? 0L : canvas.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 104L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 76L, __address);
      }

   }

   public CArrayFacade<Float> getStencil_col() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 112L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 80L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setStencil_col(CArrayFacade<Float> stencil_col) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 112L;
      } else {
         __dna__offset = 80L;
      }

      if (!this.__io__equals(stencil_col, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, stencil_col)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, stencil_col);
         } else {
            __io__generic__copy(this.getStencil_col(), stencil_col);
         }

      }
   }

   public float getDither() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 124L) : this.__io__block.readFloat(this.__io__address + 92L);
   }

   public void setDither(float dither) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 124L, dither);
      } else {
         this.__io__block.writeFloat(this.__io__address + 92L, dither);
      }

   }

   public CPointer<ImagePaintSettings> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{ImagePaintSettings.class}, this.__io__block, this.__io__blockTable);
   }
}
