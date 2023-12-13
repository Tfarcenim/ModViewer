package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 148L,
   size64 = 152L
)
public class UnifiedPaintSettings extends CFacade {
   public static final int __DNA__SDNA_INDEX = 196;
   public static final long[] __DNA__FIELD__size = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__unprojected_radius = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__alpha = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__weight = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__rgb = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__secondary_rgb = new long[]{28L, 28L};
   public static final long[] __DNA__FIELD__flag = new long[]{40L, 40L};
   public static final long[] __DNA__FIELD__last_rake = new long[]{44L, 44L};
   public static final long[] __DNA__FIELD__last_rake_angle = new long[]{52L, 52L};
   public static final long[] __DNA__FIELD__last_stroke_valid = new long[]{56L, 56L};
   public static final long[] __DNA__FIELD__average_stroke_accum = new long[]{60L, 60L};
   public static final long[] __DNA__FIELD__average_stroke_counter = new long[]{72L, 72L};
   public static final long[] __DNA__FIELD__brush_rotation = new long[]{76L, 76L};
   public static final long[] __DNA__FIELD__brush_rotation_sec = new long[]{80L, 80L};
   public static final long[] __DNA__FIELD__anchored_size = new long[]{84L, 84L};
   public static final long[] __DNA__FIELD__overlap_factor = new long[]{88L, 88L};
   public static final long[] __DNA__FIELD__draw_inverted = new long[]{92L, 92L};
   public static final long[] __DNA__FIELD__stroke_active = new long[]{93L, 93L};
   public static final long[] __DNA__FIELD__draw_anchored = new long[]{94L, 94L};
   public static final long[] __DNA__FIELD__do_linear_conversion = new long[]{95L, 95L};
   public static final long[] __DNA__FIELD__last_location = new long[]{96L, 96L};
   public static final long[] __DNA__FIELD__last_hit = new long[]{108L, 108L};
   public static final long[] __DNA__FIELD__anchored_initial_mouse = new long[]{112L, 112L};
   public static final long[] __DNA__FIELD__pixel_radius = new long[]{120L, 120L};
   public static final long[] __DNA__FIELD__size_pressure_value = new long[]{124L, 124L};
   public static final long[] __DNA__FIELD__tex_mouse = new long[]{128L, 128L};
   public static final long[] __DNA__FIELD__mask_tex_mouse = new long[]{136L, 136L};
   public static final long[] __DNA__FIELD__colorspace = new long[]{144L, 144L};

   public UnifiedPaintSettings(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected UnifiedPaintSettings(UnifiedPaintSettings that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public int getSize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 0L) : this.__io__block.readInt(this.__io__address + 0L);
   }

   public void setSize(int size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 0L, size);
      } else {
         this.__io__block.writeInt(this.__io__address + 0L, size);
      }

   }

   public float getUnprojected_radius() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 4L) : this.__io__block.readFloat(this.__io__address + 4L);
   }

   public void setUnprojected_radius(float unprojected_radius) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 4L, unprojected_radius);
      } else {
         this.__io__block.writeFloat(this.__io__address + 4L, unprojected_radius);
      }

   }

   public float getAlpha() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 8L) : this.__io__block.readFloat(this.__io__address + 8L);
   }

   public void setAlpha(float alpha) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 8L, alpha);
      } else {
         this.__io__block.writeFloat(this.__io__address + 8L, alpha);
      }

   }

   public float getWeight() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 12L) : this.__io__block.readFloat(this.__io__address + 12L);
   }

   public void setWeight(float weight) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 12L, weight);
      } else {
         this.__io__block.writeFloat(this.__io__address + 12L, weight);
      }

   }

   public CArrayFacade<Float> getRgb() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 16L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 16L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setRgb(CArrayFacade<Float> rgb) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 16L;
      } else {
         __dna__offset = 16L;
      }

      if (!this.__io__equals(rgb, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, rgb)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, rgb);
         } else {
            __io__generic__copy(this.getRgb(), rgb);
         }

      }
   }

   public CArrayFacade<Float> getSecondary_rgb() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 28L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 28L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setSecondary_rgb(CArrayFacade<Float> secondary_rgb) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 28L;
      } else {
         __dna__offset = 28L;
      }

      if (!this.__io__equals(secondary_rgb, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, secondary_rgb)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, secondary_rgb);
         } else {
            __io__generic__copy(this.getSecondary_rgb(), secondary_rgb);
         }

      }
   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 40L) : this.__io__block.readInt(this.__io__address + 40L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 40L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 40L, flag);
      }

   }

   public CArrayFacade<Float> getLast_rake() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 44L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 44L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setLast_rake(CArrayFacade<Float> last_rake) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 44L;
      } else {
         __dna__offset = 44L;
      }

      if (!this.__io__equals(last_rake, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, last_rake)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, last_rake);
         } else {
            __io__generic__copy(this.getLast_rake(), last_rake);
         }

      }
   }

   public float getLast_rake_angle() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 52L) : this.__io__block.readFloat(this.__io__address + 52L);
   }

   public void setLast_rake_angle(float last_rake_angle) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 52L, last_rake_angle);
      } else {
         this.__io__block.writeFloat(this.__io__address + 52L, last_rake_angle);
      }

   }

   public int getLast_stroke_valid() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 56L) : this.__io__block.readInt(this.__io__address + 56L);
   }

   public void setLast_stroke_valid(int last_stroke_valid) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 56L, last_stroke_valid);
      } else {
         this.__io__block.writeInt(this.__io__address + 56L, last_stroke_valid);
      }

   }

   public CArrayFacade<Float> getAverage_stroke_accum() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 60L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 60L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setAverage_stroke_accum(CArrayFacade<Float> average_stroke_accum) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 60L;
      } else {
         __dna__offset = 60L;
      }

      if (!this.__io__equals(average_stroke_accum, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, average_stroke_accum)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, average_stroke_accum);
         } else {
            __io__generic__copy(this.getAverage_stroke_accum(), average_stroke_accum);
         }

      }
   }

   public int getAverage_stroke_counter() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 72L) : this.__io__block.readInt(this.__io__address + 72L);
   }

   public void setAverage_stroke_counter(int average_stroke_counter) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 72L, average_stroke_counter);
      } else {
         this.__io__block.writeInt(this.__io__address + 72L, average_stroke_counter);
      }

   }

   public float getBrush_rotation() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 76L) : this.__io__block.readFloat(this.__io__address + 76L);
   }

   public void setBrush_rotation(float brush_rotation) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 76L, brush_rotation);
      } else {
         this.__io__block.writeFloat(this.__io__address + 76L, brush_rotation);
      }

   }

   public float getBrush_rotation_sec() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 80L) : this.__io__block.readFloat(this.__io__address + 80L);
   }

   public void setBrush_rotation_sec(float brush_rotation_sec) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 80L, brush_rotation_sec);
      } else {
         this.__io__block.writeFloat(this.__io__address + 80L, brush_rotation_sec);
      }

   }

   public int getAnchored_size() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 84L) : this.__io__block.readInt(this.__io__address + 84L);
   }

   public void setAnchored_size(int anchored_size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 84L, anchored_size);
      } else {
         this.__io__block.writeInt(this.__io__address + 84L, anchored_size);
      }

   }

   public float getOverlap_factor() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 88L) : this.__io__block.readFloat(this.__io__address + 88L);
   }

   public void setOverlap_factor(float overlap_factor) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 88L, overlap_factor);
      } else {
         this.__io__block.writeFloat(this.__io__address + 88L, overlap_factor);
      }

   }

   public byte getDraw_inverted() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 92L) : this.__io__block.readByte(this.__io__address + 92L);
   }

   public void setDraw_inverted(byte draw_inverted) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 92L, draw_inverted);
      } else {
         this.__io__block.writeByte(this.__io__address + 92L, draw_inverted);
      }

   }

   public byte getStroke_active() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 93L) : this.__io__block.readByte(this.__io__address + 93L);
   }

   public void setStroke_active(byte stroke_active) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 93L, stroke_active);
      } else {
         this.__io__block.writeByte(this.__io__address + 93L, stroke_active);
      }

   }

   public byte getDraw_anchored() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 94L) : this.__io__block.readByte(this.__io__address + 94L);
   }

   public void setDraw_anchored(byte draw_anchored) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 94L, draw_anchored);
      } else {
         this.__io__block.writeByte(this.__io__address + 94L, draw_anchored);
      }

   }

   public byte getDo_linear_conversion() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 95L) : this.__io__block.readByte(this.__io__address + 95L);
   }

   public void setDo_linear_conversion(byte do_linear_conversion) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 95L, do_linear_conversion);
      } else {
         this.__io__block.writeByte(this.__io__address + 95L, do_linear_conversion);
      }

   }

   public CArrayFacade<Float> getLast_location() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 96L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 96L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setLast_location(CArrayFacade<Float> last_location) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 96L;
      } else {
         __dna__offset = 96L;
      }

      if (!this.__io__equals(last_location, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, last_location)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, last_location);
         } else {
            __io__generic__copy(this.getLast_location(), last_location);
         }

      }
   }

   public int getLast_hit() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 108L) : this.__io__block.readInt(this.__io__address + 108L);
   }

   public void setLast_hit(int last_hit) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 108L, last_hit);
      } else {
         this.__io__block.writeInt(this.__io__address + 108L, last_hit);
      }

   }

   public CArrayFacade<Float> getAnchored_initial_mouse() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 112L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 112L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setAnchored_initial_mouse(CArrayFacade<Float> anchored_initial_mouse) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 112L;
      } else {
         __dna__offset = 112L;
      }

      if (!this.__io__equals(anchored_initial_mouse, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, anchored_initial_mouse)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, anchored_initial_mouse);
         } else {
            __io__generic__copy(this.getAnchored_initial_mouse(), anchored_initial_mouse);
         }

      }
   }

   public float getPixel_radius() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 120L) : this.__io__block.readFloat(this.__io__address + 120L);
   }

   public void setPixel_radius(float pixel_radius) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 120L, pixel_radius);
      } else {
         this.__io__block.writeFloat(this.__io__address + 120L, pixel_radius);
      }

   }

   public float getSize_pressure_value() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 124L) : this.__io__block.readFloat(this.__io__address + 124L);
   }

   public void setSize_pressure_value(float size_pressure_value) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 124L, size_pressure_value);
      } else {
         this.__io__block.writeFloat(this.__io__address + 124L, size_pressure_value);
      }

   }

   public CArrayFacade<Float> getTex_mouse() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 128L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 128L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setTex_mouse(CArrayFacade<Float> tex_mouse) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 128L;
      } else {
         __dna__offset = 128L;
      }

      if (!this.__io__equals(tex_mouse, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, tex_mouse)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, tex_mouse);
         } else {
            __io__generic__copy(this.getTex_mouse(), tex_mouse);
         }

      }
   }

   public CArrayFacade<Float> getMask_tex_mouse() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 136L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 136L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setMask_tex_mouse(CArrayFacade<Float> mask_tex_mouse) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 136L;
      } else {
         __dna__offset = 136L;
      }

      if (!this.__io__equals(mask_tex_mouse, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, mask_tex_mouse)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, mask_tex_mouse);
         } else {
            __io__generic__copy(this.getMask_tex_mouse(), mask_tex_mouse);
         }

      }
   }

   public CPointer<Object> getColorspace() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 144L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 144L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setColorspace(CPointer<Object> colorspace) throws IOException {
      long __address = colorspace == null ? 0L : colorspace.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 144L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 144L, __address);
      }

   }

   public CPointer<UnifiedPaintSettings> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{UnifiedPaintSettings.class}, this.__io__block, this.__io__blockTable);
   }
}
