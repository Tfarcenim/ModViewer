package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 248L,
   size64 = 256L
)
public class ImageFormatData extends CFacade {
   public static final int __DNA__SDNA_INDEX = 176;
   public static final long[] __DNA__FIELD__imtype = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__depth = new long[]{1L, 1L};
   public static final long[] __DNA__FIELD__planes = new long[]{2L, 2L};
   public static final long[] __DNA__FIELD__flag = new long[]{3L, 3L};
   public static final long[] __DNA__FIELD__quality = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__compress = new long[]{5L, 5L};
   public static final long[] __DNA__FIELD__exr_codec = new long[]{6L, 6L};
   public static final long[] __DNA__FIELD__cineon_flag = new long[]{7L, 7L};
   public static final long[] __DNA__FIELD__cineon_white = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__cineon_black = new long[]{10L, 10L};
   public static final long[] __DNA__FIELD__cineon_gamma = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__jp2_flag = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__jp2_codec = new long[]{17L, 17L};
   public static final long[] __DNA__FIELD__tiff_codec = new long[]{18L, 18L};
   public static final long[] __DNA__FIELD__pad = new long[]{19L, 19L};
   public static final long[] __DNA__FIELD__views_format = new long[]{23L, 23L};
   public static final long[] __DNA__FIELD__stereo3d_format = new long[]{24L, 24L};
   public static final long[] __DNA__FIELD__view_settings = new long[]{32L, 32L};
   public static final long[] __DNA__FIELD__display_settings = new long[]{184L, 192L};

   public ImageFormatData(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected ImageFormatData(ImageFormatData that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public byte getImtype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 0L) : this.__io__block.readByte(this.__io__address + 0L);
   }

   public void setImtype(byte imtype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 0L, imtype);
      } else {
         this.__io__block.writeByte(this.__io__address + 0L, imtype);
      }

   }

   public byte getDepth() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1L) : this.__io__block.readByte(this.__io__address + 1L);
   }

   public void setDepth(byte depth) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1L, depth);
      } else {
         this.__io__block.writeByte(this.__io__address + 1L, depth);
      }

   }

   public byte getPlanes() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 2L) : this.__io__block.readByte(this.__io__address + 2L);
   }

   public void setPlanes(byte planes) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 2L, planes);
      } else {
         this.__io__block.writeByte(this.__io__address + 2L, planes);
      }

   }

   public byte getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 3L) : this.__io__block.readByte(this.__io__address + 3L);
   }

   public void setFlag(byte flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 3L, flag);
      } else {
         this.__io__block.writeByte(this.__io__address + 3L, flag);
      }

   }

   public byte getQuality() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 4L) : this.__io__block.readByte(this.__io__address + 4L);
   }

   public void setQuality(byte quality) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 4L, quality);
      } else {
         this.__io__block.writeByte(this.__io__address + 4L, quality);
      }

   }

   public byte getCompress() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 5L) : this.__io__block.readByte(this.__io__address + 5L);
   }

   public void setCompress(byte compress) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 5L, compress);
      } else {
         this.__io__block.writeByte(this.__io__address + 5L, compress);
      }

   }

   public byte getExr_codec() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 6L) : this.__io__block.readByte(this.__io__address + 6L);
   }

   public void setExr_codec(byte exr_codec) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 6L, exr_codec);
      } else {
         this.__io__block.writeByte(this.__io__address + 6L, exr_codec);
      }

   }

   public byte getCineon_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 7L) : this.__io__block.readByte(this.__io__address + 7L);
   }

   public void setCineon_flag(byte cineon_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 7L, cineon_flag);
      } else {
         this.__io__block.writeByte(this.__io__address + 7L, cineon_flag);
      }

   }

   public short getCineon_white() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 8L) : this.__io__block.readShort(this.__io__address + 8L);
   }

   public void setCineon_white(short cineon_white) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 8L, cineon_white);
      } else {
         this.__io__block.writeShort(this.__io__address + 8L, cineon_white);
      }

   }

   public short getCineon_black() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 10L) : this.__io__block.readShort(this.__io__address + 10L);
   }

   public void setCineon_black(short cineon_black) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 10L, cineon_black);
      } else {
         this.__io__block.writeShort(this.__io__address + 10L, cineon_black);
      }

   }

   public float getCineon_gamma() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 12L) : this.__io__block.readFloat(this.__io__address + 12L);
   }

   public void setCineon_gamma(float cineon_gamma) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 12L, cineon_gamma);
      } else {
         this.__io__block.writeFloat(this.__io__address + 12L, cineon_gamma);
      }

   }

   public byte getJp2_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 16L) : this.__io__block.readByte(this.__io__address + 16L);
   }

   public void setJp2_flag(byte jp2_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 16L, jp2_flag);
      } else {
         this.__io__block.writeByte(this.__io__address + 16L, jp2_flag);
      }

   }

   public byte getJp2_codec() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 17L) : this.__io__block.readByte(this.__io__address + 17L);
   }

   public void setJp2_codec(byte jp2_codec) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 17L, jp2_codec);
      } else {
         this.__io__block.writeByte(this.__io__address + 17L, jp2_codec);
      }

   }

   public byte getTiff_codec() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 18L) : this.__io__block.readByte(this.__io__address + 18L);
   }

   public void setTiff_codec(byte tiff_codec) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 18L, tiff_codec);
      } else {
         this.__io__block.writeByte(this.__io__address + 18L, tiff_codec);
      }

   }

   public CArrayFacade<Byte> getPad() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 19L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 19L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad(CArrayFacade<Byte> pad) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 19L;
      } else {
         __dna__offset = 19L;
      }

      if (!this.__io__equals(pad, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad);
         } else {
            __io__generic__copy(this.getPad(), pad);
         }

      }
   }

   public byte getViews_format() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 23L) : this.__io__block.readByte(this.__io__address + 23L);
   }

   public void setViews_format(byte views_format) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 23L, views_format);
      } else {
         this.__io__block.writeByte(this.__io__address + 23L, views_format);
      }

   }

   public Stereo3dFormat getStereo3d_format() throws IOException {
      return this.__io__pointersize == 8 ? new Stereo3dFormat(this.__io__address + 24L, this.__io__block, this.__io__blockTable) : new Stereo3dFormat(this.__io__address + 24L, this.__io__block, this.__io__blockTable);
   }

   public void setStereo3d_format(Stereo3dFormat stereo3d_format) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 24L;
      } else {
         __dna__offset = 24L;
      }

      if (!this.__io__equals(stereo3d_format, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, stereo3d_format)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, stereo3d_format);
         } else {
            __io__generic__copy(this.getStereo3d_format(), stereo3d_format);
         }

      }
   }

   public ColorManagedViewSettings getView_settings() throws IOException {
      return this.__io__pointersize == 8 ? new ColorManagedViewSettings(this.__io__address + 32L, this.__io__block, this.__io__blockTable) : new ColorManagedViewSettings(this.__io__address + 32L, this.__io__block, this.__io__blockTable);
   }

   public void setView_settings(ColorManagedViewSettings view_settings) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 32L;
      } else {
         __dna__offset = 32L;
      }

      if (!this.__io__equals(view_settings, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, view_settings)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, view_settings);
         } else {
            __io__generic__copy(this.getView_settings(), view_settings);
         }

      }
   }

   public ColorManagedDisplaySettings getDisplay_settings() throws IOException {
      return this.__io__pointersize == 8 ? new ColorManagedDisplaySettings(this.__io__address + 192L, this.__io__block, this.__io__blockTable) : new ColorManagedDisplaySettings(this.__io__address + 184L, this.__io__block, this.__io__blockTable);
   }

   public void setDisplay_settings(ColorManagedDisplaySettings display_settings) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 192L;
      } else {
         __dna__offset = 184L;
      }

      if (!this.__io__equals(display_settings, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, display_settings)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, display_settings);
         } else {
            __io__generic__copy(this.getDisplay_settings(), display_settings);
         }

      }
   }

   public CPointer<ImageFormatData> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{ImageFormatData.class}, this.__io__block, this.__io__blockTable);
   }
}
