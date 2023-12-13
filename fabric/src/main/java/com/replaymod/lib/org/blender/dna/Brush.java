package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 2008L,
   size64 = 2072L
)
public class Brush extends CFacade {
   public static final int __DNA__SDNA_INDEX = 468;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__clone = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__curve = new long[]{120L, 144L};
   public static final long[] __DNA__FIELD__mtex = new long[]{124L, 152L};
   public static final long[] __DNA__FIELD__mask_mtex = new long[]{436L, 472L};
   public static final long[] __DNA__FIELD__toggle_brush = new long[]{748L, 792L};
   public static final long[] __DNA__FIELD__icon_imbuf = new long[]{752L, 800L};
   public static final long[] __DNA__FIELD__preview = new long[]{756L, 808L};
   public static final long[] __DNA__FIELD__gradient = new long[]{760L, 816L};
   public static final long[] __DNA__FIELD__paint_curve = new long[]{764L, 824L};
   public static final long[] __DNA__FIELD__icon_filepath = new long[]{768L, 832L};
   public static final long[] __DNA__FIELD__normal_weight = new long[]{1792L, 1856L};
   public static final long[] __DNA__FIELD__rake_factor = new long[]{1796L, 1860L};
   public static final long[] __DNA__FIELD__blend = new long[]{1800L, 1864L};
   public static final long[] __DNA__FIELD__ob_mode = new long[]{1802L, 1866L};
   public static final long[] __DNA__FIELD__weight = new long[]{1804L, 1868L};
   public static final long[] __DNA__FIELD__size = new long[]{1808L, 1872L};
   public static final long[] __DNA__FIELD__flag = new long[]{1812L, 1876L};
   public static final long[] __DNA__FIELD__mask_pressure = new long[]{1816L, 1880L};
   public static final long[] __DNA__FIELD__jitter = new long[]{1820L, 1884L};
   public static final long[] __DNA__FIELD__jitter_absolute = new long[]{1824L, 1888L};
   public static final long[] __DNA__FIELD__overlay_flags = new long[]{1828L, 1892L};
   public static final long[] __DNA__FIELD__spacing = new long[]{1832L, 1896L};
   public static final long[] __DNA__FIELD__smooth_stroke_radius = new long[]{1836L, 1900L};
   public static final long[] __DNA__FIELD__smooth_stroke_factor = new long[]{1840L, 1904L};
   public static final long[] __DNA__FIELD__rate = new long[]{1844L, 1908L};
   public static final long[] __DNA__FIELD__rgb = new long[]{1848L, 1912L};
   public static final long[] __DNA__FIELD__alpha = new long[]{1860L, 1924L};
   public static final long[] __DNA__FIELD__secondary_rgb = new long[]{1864L, 1928L};
   public static final long[] __DNA__FIELD__sculpt_plane = new long[]{1876L, 1940L};
   public static final long[] __DNA__FIELD__plane_offset = new long[]{1880L, 1944L};
   public static final long[] __DNA__FIELD__gradient_spacing = new long[]{1884L, 1948L};
   public static final long[] __DNA__FIELD__gradient_stroke_mode = new long[]{1888L, 1952L};
   public static final long[] __DNA__FIELD__gradient_fill_mode = new long[]{1892L, 1956L};
   public static final long[] __DNA__FIELD__sculpt_tool = new long[]{1896L, 1960L};
   public static final long[] __DNA__FIELD__vertexpaint_tool = new long[]{1897L, 1961L};
   public static final long[] __DNA__FIELD__imagepaint_tool = new long[]{1898L, 1962L};
   public static final long[] __DNA__FIELD__mask_tool = new long[]{1899L, 1963L};
   public static final long[] __DNA__FIELD__autosmooth_factor = new long[]{1900L, 1964L};
   public static final long[] __DNA__FIELD__crease_pinch_factor = new long[]{1904L, 1968L};
   public static final long[] __DNA__FIELD__plane_trim = new long[]{1908L, 1972L};
   public static final long[] __DNA__FIELD__height = new long[]{1912L, 1976L};
   public static final long[] __DNA__FIELD__texture_sample_bias = new long[]{1916L, 1980L};
   public static final long[] __DNA__FIELD__texture_overlay_alpha = new long[]{1920L, 1984L};
   public static final long[] __DNA__FIELD__mask_overlay_alpha = new long[]{1924L, 1988L};
   public static final long[] __DNA__FIELD__cursor_overlay_alpha = new long[]{1928L, 1992L};
   public static final long[] __DNA__FIELD__unprojected_radius = new long[]{1932L, 1996L};
   public static final long[] __DNA__FIELD__sharp_threshold = new long[]{1936L, 2000L};
   public static final long[] __DNA__FIELD__blur_kernel_radius = new long[]{1940L, 2004L};
   public static final long[] __DNA__FIELD__blur_mode = new long[]{1944L, 2008L};
   public static final long[] __DNA__FIELD__fill_threshold = new long[]{1948L, 2012L};
   public static final long[] __DNA__FIELD__add_col = new long[]{1952L, 2016L};
   public static final long[] __DNA__FIELD__sub_col = new long[]{1964L, 2028L};
   public static final long[] __DNA__FIELD__stencil_pos = new long[]{1976L, 2040L};
   public static final long[] __DNA__FIELD__stencil_dimension = new long[]{1984L, 2048L};
   public static final long[] __DNA__FIELD__mask_stencil_pos = new long[]{1992L, 2056L};
   public static final long[] __DNA__FIELD__mask_stencil_dimension = new long[]{2000L, 2064L};

   public Brush(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Brush(Brush that) {
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

   public BrushClone getClone() throws IOException {
      return this.__io__pointersize == 8 ? new BrushClone(this.__io__address + 120L, this.__io__block, this.__io__blockTable) : new BrushClone(this.__io__address + 100L, this.__io__block, this.__io__blockTable);
   }

   public void setClone(BrushClone clone) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 120L;
      } else {
         __dna__offset = 100L;
      }

      if (!this.__io__equals(clone, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, clone)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, clone);
         } else {
            __io__generic__copy(this.getClone(), clone);
         }

      }
   }

   public CPointer<CurveMapping> getCurve() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 144L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 120L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{CurveMapping.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 461), this.__io__blockTable);
   }

   public void setCurve(CPointer<CurveMapping> curve) throws IOException {
      long __address = curve == null ? 0L : curve.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 144L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 120L, __address);
      }

   }

   public MTex getMtex() throws IOException {
      return this.__io__pointersize == 8 ? new MTex(this.__io__address + 152L, this.__io__block, this.__io__blockTable) : new MTex(this.__io__address + 124L, this.__io__block, this.__io__blockTable);
   }

   public void setMtex(MTex mtex) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 152L;
      } else {
         __dna__offset = 124L;
      }

      if (!this.__io__equals(mtex, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, mtex)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, mtex);
         } else {
            __io__generic__copy(this.getMtex(), mtex);
         }

      }
   }

   public MTex getMask_mtex() throws IOException {
      return this.__io__pointersize == 8 ? new MTex(this.__io__address + 472L, this.__io__block, this.__io__blockTable) : new MTex(this.__io__address + 436L, this.__io__block, this.__io__blockTable);
   }

   public void setMask_mtex(MTex mask_mtex) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 472L;
      } else {
         __dna__offset = 436L;
      }

      if (!this.__io__equals(mask_mtex, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, mask_mtex)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, mask_mtex);
         } else {
            __io__generic__copy(this.getMask_mtex(), mask_mtex);
         }

      }
   }

   public CPointer<Brush> getToggle_brush() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 792L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 748L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Brush.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 468), this.__io__blockTable);
   }

   public void setToggle_brush(CPointer<Brush> toggle_brush) throws IOException {
      long __address = toggle_brush == null ? 0L : toggle_brush.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 792L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 748L, __address);
      }

   }

   public CPointer<Object> getIcon_imbuf() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 800L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 752L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setIcon_imbuf(CPointer<Object> icon_imbuf) throws IOException {
      long __address = icon_imbuf == null ? 0L : icon_imbuf.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 800L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 752L, __address);
      }

   }

   public CPointer<PreviewImage> getPreview() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 808L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 756L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PreviewImage.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 12), this.__io__blockTable);
   }

   public void setPreview(CPointer<PreviewImage> preview) throws IOException {
      long __address = preview == null ? 0L : preview.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 808L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 756L, __address);
      }

   }

   public CPointer<ColorBand> getGradient() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 816L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 760L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{ColorBand.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 34), this.__io__blockTable);
   }

   public void setGradient(CPointer<ColorBand> gradient) throws IOException {
      long __address = gradient == null ? 0L : gradient.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 816L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 760L, __address);
      }

   }

   public CPointer<PaintCurve> getPaint_curve() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 824L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 764L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PaintCurve.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 472), this.__io__blockTable);
   }

   public void setPaint_curve(CPointer<PaintCurve> paint_curve) throws IOException {
      long __address = paint_curve == null ? 0L : paint_curve.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 824L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 764L, __address);
      }

   }

   public CArrayFacade<Byte> getIcon_filepath() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{1024};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 832L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 768L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setIcon_filepath(CArrayFacade<Byte> icon_filepath) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 832L;
      } else {
         __dna__offset = 768L;
      }

      if (!this.__io__equals(icon_filepath, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, icon_filepath)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, icon_filepath);
         } else {
            __io__generic__copy(this.getIcon_filepath(), icon_filepath);
         }

      }
   }

   public float getNormal_weight() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1856L) : this.__io__block.readFloat(this.__io__address + 1792L);
   }

   public void setNormal_weight(float normal_weight) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1856L, normal_weight);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1792L, normal_weight);
      }

   }

   public float getRake_factor() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1860L) : this.__io__block.readFloat(this.__io__address + 1796L);
   }

   public void setRake_factor(float rake_factor) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1860L, rake_factor);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1796L, rake_factor);
      }

   }

   public short getBlend() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1864L) : this.__io__block.readShort(this.__io__address + 1800L);
   }

   public void setBlend(short blend) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1864L, blend);
      } else {
         this.__io__block.writeShort(this.__io__address + 1800L, blend);
      }

   }

   public short getOb_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1866L) : this.__io__block.readShort(this.__io__address + 1802L);
   }

   public void setOb_mode(short ob_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1866L, ob_mode);
      } else {
         this.__io__block.writeShort(this.__io__address + 1802L, ob_mode);
      }

   }

   public float getWeight() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1868L) : this.__io__block.readFloat(this.__io__address + 1804L);
   }

   public void setWeight(float weight) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1868L, weight);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1804L, weight);
      }

   }

   public int getSize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1872L) : this.__io__block.readInt(this.__io__address + 1808L);
   }

   public void setSize(int size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1872L, size);
      } else {
         this.__io__block.writeInt(this.__io__address + 1808L, size);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1876L) : this.__io__block.readInt(this.__io__address + 1812L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1876L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 1812L, flag);
      }

   }

   public int getMask_pressure() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1880L) : this.__io__block.readInt(this.__io__address + 1816L);
   }

   public void setMask_pressure(int mask_pressure) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1880L, mask_pressure);
      } else {
         this.__io__block.writeInt(this.__io__address + 1816L, mask_pressure);
      }

   }

   public float getJitter() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1884L) : this.__io__block.readFloat(this.__io__address + 1820L);
   }

   public void setJitter(float jitter) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1884L, jitter);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1820L, jitter);
      }

   }

   public int getJitter_absolute() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1888L) : this.__io__block.readInt(this.__io__address + 1824L);
   }

   public void setJitter_absolute(int jitter_absolute) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1888L, jitter_absolute);
      } else {
         this.__io__block.writeInt(this.__io__address + 1824L, jitter_absolute);
      }

   }

   public int getOverlay_flags() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1892L) : this.__io__block.readInt(this.__io__address + 1828L);
   }

   public void setOverlay_flags(int overlay_flags) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1892L, overlay_flags);
      } else {
         this.__io__block.writeInt(this.__io__address + 1828L, overlay_flags);
      }

   }

   public int getSpacing() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1896L) : this.__io__block.readInt(this.__io__address + 1832L);
   }

   public void setSpacing(int spacing) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1896L, spacing);
      } else {
         this.__io__block.writeInt(this.__io__address + 1832L, spacing);
      }

   }

   public int getSmooth_stroke_radius() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1900L) : this.__io__block.readInt(this.__io__address + 1836L);
   }

   public void setSmooth_stroke_radius(int smooth_stroke_radius) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1900L, smooth_stroke_radius);
      } else {
         this.__io__block.writeInt(this.__io__address + 1836L, smooth_stroke_radius);
      }

   }

   public float getSmooth_stroke_factor() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1904L) : this.__io__block.readFloat(this.__io__address + 1840L);
   }

   public void setSmooth_stroke_factor(float smooth_stroke_factor) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1904L, smooth_stroke_factor);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1840L, smooth_stroke_factor);
      }

   }

   public float getRate() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1908L) : this.__io__block.readFloat(this.__io__address + 1844L);
   }

   public void setRate(float rate) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1908L, rate);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1844L, rate);
      }

   }

   public CArrayFacade<Float> getRgb() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1912L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1848L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setRgb(CArrayFacade<Float> rgb) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1912L;
      } else {
         __dna__offset = 1848L;
      }

      if (!this.__io__equals(rgb, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, rgb)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, rgb);
         } else {
            __io__generic__copy(this.getRgb(), rgb);
         }

      }
   }

   public float getAlpha() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1924L) : this.__io__block.readFloat(this.__io__address + 1860L);
   }

   public void setAlpha(float alpha) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1924L, alpha);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1860L, alpha);
      }

   }

   public CArrayFacade<Float> getSecondary_rgb() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1928L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1864L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setSecondary_rgb(CArrayFacade<Float> secondary_rgb) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1928L;
      } else {
         __dna__offset = 1864L;
      }

      if (!this.__io__equals(secondary_rgb, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, secondary_rgb)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, secondary_rgb);
         } else {
            __io__generic__copy(this.getSecondary_rgb(), secondary_rgb);
         }

      }
   }

   public int getSculpt_plane() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1940L) : this.__io__block.readInt(this.__io__address + 1876L);
   }

   public void setSculpt_plane(int sculpt_plane) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1940L, sculpt_plane);
      } else {
         this.__io__block.writeInt(this.__io__address + 1876L, sculpt_plane);
      }

   }

   public float getPlane_offset() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1944L) : this.__io__block.readFloat(this.__io__address + 1880L);
   }

   public void setPlane_offset(float plane_offset) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1944L, plane_offset);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1880L, plane_offset);
      }

   }

   public int getGradient_spacing() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1948L) : this.__io__block.readInt(this.__io__address + 1884L);
   }

   public void setGradient_spacing(int gradient_spacing) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1948L, gradient_spacing);
      } else {
         this.__io__block.writeInt(this.__io__address + 1884L, gradient_spacing);
      }

   }

   public int getGradient_stroke_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1952L) : this.__io__block.readInt(this.__io__address + 1888L);
   }

   public void setGradient_stroke_mode(int gradient_stroke_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1952L, gradient_stroke_mode);
      } else {
         this.__io__block.writeInt(this.__io__address + 1888L, gradient_stroke_mode);
      }

   }

   public int getGradient_fill_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1956L) : this.__io__block.readInt(this.__io__address + 1892L);
   }

   public void setGradient_fill_mode(int gradient_fill_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1956L, gradient_fill_mode);
      } else {
         this.__io__block.writeInt(this.__io__address + 1892L, gradient_fill_mode);
      }

   }

   public byte getSculpt_tool() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1960L) : this.__io__block.readByte(this.__io__address + 1896L);
   }

   public void setSculpt_tool(byte sculpt_tool) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1960L, sculpt_tool);
      } else {
         this.__io__block.writeByte(this.__io__address + 1896L, sculpt_tool);
      }

   }

   public byte getVertexpaint_tool() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1961L) : this.__io__block.readByte(this.__io__address + 1897L);
   }

   public void setVertexpaint_tool(byte vertexpaint_tool) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1961L, vertexpaint_tool);
      } else {
         this.__io__block.writeByte(this.__io__address + 1897L, vertexpaint_tool);
      }

   }

   public byte getImagepaint_tool() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1962L) : this.__io__block.readByte(this.__io__address + 1898L);
   }

   public void setImagepaint_tool(byte imagepaint_tool) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1962L, imagepaint_tool);
      } else {
         this.__io__block.writeByte(this.__io__address + 1898L, imagepaint_tool);
      }

   }

   public byte getMask_tool() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1963L) : this.__io__block.readByte(this.__io__address + 1899L);
   }

   public void setMask_tool(byte mask_tool) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1963L, mask_tool);
      } else {
         this.__io__block.writeByte(this.__io__address + 1899L, mask_tool);
      }

   }

   public float getAutosmooth_factor() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1964L) : this.__io__block.readFloat(this.__io__address + 1900L);
   }

   public void setAutosmooth_factor(float autosmooth_factor) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1964L, autosmooth_factor);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1900L, autosmooth_factor);
      }

   }

   public float getCrease_pinch_factor() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1968L) : this.__io__block.readFloat(this.__io__address + 1904L);
   }

   public void setCrease_pinch_factor(float crease_pinch_factor) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1968L, crease_pinch_factor);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1904L, crease_pinch_factor);
      }

   }

   public float getPlane_trim() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1972L) : this.__io__block.readFloat(this.__io__address + 1908L);
   }

   public void setPlane_trim(float plane_trim) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1972L, plane_trim);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1908L, plane_trim);
      }

   }

   public float getHeight() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1976L) : this.__io__block.readFloat(this.__io__address + 1912L);
   }

   public void setHeight(float height) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1976L, height);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1912L, height);
      }

   }

   public float getTexture_sample_bias() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1980L) : this.__io__block.readFloat(this.__io__address + 1916L);
   }

   public void setTexture_sample_bias(float texture_sample_bias) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1980L, texture_sample_bias);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1916L, texture_sample_bias);
      }

   }

   public int getTexture_overlay_alpha() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1984L) : this.__io__block.readInt(this.__io__address + 1920L);
   }

   public void setTexture_overlay_alpha(int texture_overlay_alpha) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1984L, texture_overlay_alpha);
      } else {
         this.__io__block.writeInt(this.__io__address + 1920L, texture_overlay_alpha);
      }

   }

   public int getMask_overlay_alpha() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1988L) : this.__io__block.readInt(this.__io__address + 1924L);
   }

   public void setMask_overlay_alpha(int mask_overlay_alpha) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1988L, mask_overlay_alpha);
      } else {
         this.__io__block.writeInt(this.__io__address + 1924L, mask_overlay_alpha);
      }

   }

   public int getCursor_overlay_alpha() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1992L) : this.__io__block.readInt(this.__io__address + 1928L);
   }

   public void setCursor_overlay_alpha(int cursor_overlay_alpha) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1992L, cursor_overlay_alpha);
      } else {
         this.__io__block.writeInt(this.__io__address + 1928L, cursor_overlay_alpha);
      }

   }

   public float getUnprojected_radius() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1996L) : this.__io__block.readFloat(this.__io__address + 1932L);
   }

   public void setUnprojected_radius(float unprojected_radius) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1996L, unprojected_radius);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1932L, unprojected_radius);
      }

   }

   public float getSharp_threshold() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 2000L) : this.__io__block.readFloat(this.__io__address + 1936L);
   }

   public void setSharp_threshold(float sharp_threshold) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 2000L, sharp_threshold);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1936L, sharp_threshold);
      }

   }

   public int getBlur_kernel_radius() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 2004L) : this.__io__block.readInt(this.__io__address + 1940L);
   }

   public void setBlur_kernel_radius(int blur_kernel_radius) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 2004L, blur_kernel_radius);
      } else {
         this.__io__block.writeInt(this.__io__address + 1940L, blur_kernel_radius);
      }

   }

   public int getBlur_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 2008L) : this.__io__block.readInt(this.__io__address + 1944L);
   }

   public void setBlur_mode(int blur_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 2008L, blur_mode);
      } else {
         this.__io__block.writeInt(this.__io__address + 1944L, blur_mode);
      }

   }

   public float getFill_threshold() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 2012L) : this.__io__block.readFloat(this.__io__address + 1948L);
   }

   public void setFill_threshold(float fill_threshold) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 2012L, fill_threshold);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1948L, fill_threshold);
      }

   }

   public CArrayFacade<Float> getAdd_col() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 2016L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1952L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setAdd_col(CArrayFacade<Float> add_col) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 2016L;
      } else {
         __dna__offset = 1952L;
      }

      if (!this.__io__equals(add_col, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, add_col)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, add_col);
         } else {
            __io__generic__copy(this.getAdd_col(), add_col);
         }

      }
   }

   public CArrayFacade<Float> getSub_col() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 2028L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1964L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setSub_col(CArrayFacade<Float> sub_col) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 2028L;
      } else {
         __dna__offset = 1964L;
      }

      if (!this.__io__equals(sub_col, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, sub_col)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, sub_col);
         } else {
            __io__generic__copy(this.getSub_col(), sub_col);
         }

      }
   }

   public CArrayFacade<Float> getStencil_pos() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 2040L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1976L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setStencil_pos(CArrayFacade<Float> stencil_pos) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 2040L;
      } else {
         __dna__offset = 1976L;
      }

      if (!this.__io__equals(stencil_pos, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, stencil_pos)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, stencil_pos);
         } else {
            __io__generic__copy(this.getStencil_pos(), stencil_pos);
         }

      }
   }

   public CArrayFacade<Float> getStencil_dimension() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 2048L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1984L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setStencil_dimension(CArrayFacade<Float> stencil_dimension) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 2048L;
      } else {
         __dna__offset = 1984L;
      }

      if (!this.__io__equals(stencil_dimension, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, stencil_dimension)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, stencil_dimension);
         } else {
            __io__generic__copy(this.getStencil_dimension(), stencil_dimension);
         }

      }
   }

   public CArrayFacade<Float> getMask_stencil_pos() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 2056L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1992L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setMask_stencil_pos(CArrayFacade<Float> mask_stencil_pos) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 2056L;
      } else {
         __dna__offset = 1992L;
      }

      if (!this.__io__equals(mask_stencil_pos, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, mask_stencil_pos)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, mask_stencil_pos);
         } else {
            __io__generic__copy(this.getMask_stencil_pos(), mask_stencil_pos);
         }

      }
   }

   public CArrayFacade<Float> getMask_stencil_dimension() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 2064L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 2000L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setMask_stencil_dimension(CArrayFacade<Float> mask_stencil_dimension) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 2064L;
      } else {
         __dna__offset = 2000L;
      }

      if (!this.__io__equals(mask_stencil_dimension, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, mask_stencil_dimension)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, mask_stencil_dimension);
         } else {
            __io__generic__copy(this.getMask_stencil_dimension(), mask_stencil_dimension);
         }

      }
   }

   public CPointer<Brush> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Brush.class}, this.__io__block, this.__io__blockTable);
   }
}
