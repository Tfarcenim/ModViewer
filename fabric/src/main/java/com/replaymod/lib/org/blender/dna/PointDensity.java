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
   size64 = 168L
)
public class PointDensity extends CFacade {
   public static final int __DNA__SDNA_INDEX = 36;
   public static final long[] __DNA__FIELD__flag = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__falloff_type = new long[]{2L, 2L};
   public static final long[] __DNA__FIELD__falloff_softness = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__radius = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__source = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__pad0 = new long[]{14L, 14L};
   public static final long[] __DNA__FIELD__color_source = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__ob_color_source = new long[]{18L, 18L};
   public static final long[] __DNA__FIELD__totpoints = new long[]{20L, 20L};
   public static final long[] __DNA__FIELD__object = new long[]{24L, 24L};
   public static final long[] __DNA__FIELD__psys = new long[]{28L, 32L};
   public static final long[] __DNA__FIELD__psys_cache_space = new long[]{32L, 36L};
   public static final long[] __DNA__FIELD__ob_cache_space = new long[]{34L, 38L};
   public static final long[] __DNA__FIELD__vertex_attribute_name = new long[]{36L, 40L};
   public static final long[] __DNA__FIELD__point_tree = new long[]{100L, 104L};
   public static final long[] __DNA__FIELD__point_data = new long[]{104L, 112L};
   public static final long[] __DNA__FIELD__noise_size = new long[]{108L, 120L};
   public static final long[] __DNA__FIELD__noise_depth = new long[]{112L, 124L};
   public static final long[] __DNA__FIELD__noise_influence = new long[]{114L, 126L};
   public static final long[] __DNA__FIELD__noise_basis = new long[]{116L, 128L};
   public static final long[] __DNA__FIELD__pad1 = new long[]{118L, 130L};
   public static final long[] __DNA__FIELD__noise_fac = new long[]{124L, 136L};
   public static final long[] __DNA__FIELD__speed_scale = new long[]{128L, 140L};
   public static final long[] __DNA__FIELD__falloff_speed_scale = new long[]{132L, 144L};
   public static final long[] __DNA__FIELD__pad2 = new long[]{136L, 148L};
   public static final long[] __DNA__FIELD__coba = new long[]{140L, 152L};
   public static final long[] __DNA__FIELD__falloff_curve = new long[]{144L, 160L};

   public PointDensity(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected PointDensity(PointDensity that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 0L) : this.__io__block.readShort(this.__io__address + 0L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 0L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 0L, flag);
      }

   }

   public short getFalloff_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 2L) : this.__io__block.readShort(this.__io__address + 2L);
   }

   public void setFalloff_type(short falloff_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 2L, falloff_type);
      } else {
         this.__io__block.writeShort(this.__io__address + 2L, falloff_type);
      }

   }

   public float getFalloff_softness() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 4L) : this.__io__block.readFloat(this.__io__address + 4L);
   }

   public void setFalloff_softness(float falloff_softness) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 4L, falloff_softness);
      } else {
         this.__io__block.writeFloat(this.__io__address + 4L, falloff_softness);
      }

   }

   public float getRadius() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 8L) : this.__io__block.readFloat(this.__io__address + 8L);
   }

   public void setRadius(float radius) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 8L, radius);
      } else {
         this.__io__block.writeFloat(this.__io__address + 8L, radius);
      }

   }

   public short getSource() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 12L) : this.__io__block.readShort(this.__io__address + 12L);
   }

   public void setSource(short source) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 12L, source);
      } else {
         this.__io__block.writeShort(this.__io__address + 12L, source);
      }

   }

   public short getPad0() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 14L) : this.__io__block.readShort(this.__io__address + 14L);
   }

   public void setPad0(short pad0) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 14L, pad0);
      } else {
         this.__io__block.writeShort(this.__io__address + 14L, pad0);
      }

   }

   public short getColor_source() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 16L) : this.__io__block.readShort(this.__io__address + 16L);
   }

   public void setColor_source(short color_source) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 16L, color_source);
      } else {
         this.__io__block.writeShort(this.__io__address + 16L, color_source);
      }

   }

   public short getOb_color_source() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 18L) : this.__io__block.readShort(this.__io__address + 18L);
   }

   public void setOb_color_source(short ob_color_source) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 18L, ob_color_source);
      } else {
         this.__io__block.writeShort(this.__io__address + 18L, ob_color_source);
      }

   }

   public int getTotpoints() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 20L) : this.__io__block.readInt(this.__io__address + 20L);
   }

   public void setTotpoints(int totpoints) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 20L, totpoints);
      } else {
         this.__io__block.writeInt(this.__io__address + 20L, totpoints);
      }

   }

   public CPointer<BlenderObject> getObject() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 24L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 24L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setObject(CPointer<BlenderObject> object) throws IOException {
      long __address = object == null ? 0L : object.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 24L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 24L, __address);
      }

   }

   public int getPsys() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 32L) : this.__io__block.readInt(this.__io__address + 28L);
   }

   public void setPsys(int psys) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 32L, psys);
      } else {
         this.__io__block.writeInt(this.__io__address + 28L, psys);
      }

   }

   public short getPsys_cache_space() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 36L) : this.__io__block.readShort(this.__io__address + 32L);
   }

   public void setPsys_cache_space(short psys_cache_space) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 36L, psys_cache_space);
      } else {
         this.__io__block.writeShort(this.__io__address + 32L, psys_cache_space);
      }

   }

   public short getOb_cache_space() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 38L) : this.__io__block.readShort(this.__io__address + 34L);
   }

   public void setOb_cache_space(short ob_cache_space) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 38L, ob_cache_space);
      } else {
         this.__io__block.writeShort(this.__io__address + 34L, ob_cache_space);
      }

   }

   public CArrayFacade<Byte> getVertex_attribute_name() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 40L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 36L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setVertex_attribute_name(CArrayFacade<Byte> vertex_attribute_name) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 40L;
      } else {
         __dna__offset = 36L;
      }

      if (!this.__io__equals(vertex_attribute_name, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, vertex_attribute_name)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, vertex_attribute_name);
         } else {
            __io__generic__copy(this.getVertex_attribute_name(), vertex_attribute_name);
         }

      }
   }

   public CPointer<Object> getPoint_tree() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 104L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 100L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setPoint_tree(CPointer<Object> point_tree) throws IOException {
      long __address = point_tree == null ? 0L : point_tree.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 104L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 100L, __address);
      }

   }

   public CPointer<Float> getPoint_data() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 112L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 104L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, __dna__targetTypes), this.__io__blockTable);
   }

   public void setPoint_data(CPointer<Float> point_data) throws IOException {
      long __address = point_data == null ? 0L : point_data.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 112L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 104L, __address);
      }

   }

   public float getNoise_size() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 120L) : this.__io__block.readFloat(this.__io__address + 108L);
   }

   public void setNoise_size(float noise_size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 120L, noise_size);
      } else {
         this.__io__block.writeFloat(this.__io__address + 108L, noise_size);
      }

   }

   public short getNoise_depth() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 124L) : this.__io__block.readShort(this.__io__address + 112L);
   }

   public void setNoise_depth(short noise_depth) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 124L, noise_depth);
      } else {
         this.__io__block.writeShort(this.__io__address + 112L, noise_depth);
      }

   }

   public short getNoise_influence() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 126L) : this.__io__block.readShort(this.__io__address + 114L);
   }

   public void setNoise_influence(short noise_influence) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 126L, noise_influence);
      } else {
         this.__io__block.writeShort(this.__io__address + 114L, noise_influence);
      }

   }

   public short getNoise_basis() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 128L) : this.__io__block.readShort(this.__io__address + 116L);
   }

   public void setNoise_basis(short noise_basis) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 128L, noise_basis);
      } else {
         this.__io__block.writeShort(this.__io__address + 116L, noise_basis);
      }

   }

   public CArrayFacade<Short> getPad1() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Short.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 130L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 118L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad1(CArrayFacade<Short> pad1) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 130L;
      } else {
         __dna__offset = 118L;
      }

      if (!this.__io__equals(pad1, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad1)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad1);
         } else {
            __io__generic__copy(this.getPad1(), pad1);
         }

      }
   }

   public float getNoise_fac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 136L) : this.__io__block.readFloat(this.__io__address + 124L);
   }

   public void setNoise_fac(float noise_fac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 136L, noise_fac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 124L, noise_fac);
      }

   }

   public float getSpeed_scale() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 140L) : this.__io__block.readFloat(this.__io__address + 128L);
   }

   public void setSpeed_scale(float speed_scale) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 140L, speed_scale);
      } else {
         this.__io__block.writeFloat(this.__io__address + 128L, speed_scale);
      }

   }

   public float getFalloff_speed_scale() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 144L) : this.__io__block.readFloat(this.__io__address + 132L);
   }

   public void setFalloff_speed_scale(float falloff_speed_scale) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 144L, falloff_speed_scale);
      } else {
         this.__io__block.writeFloat(this.__io__address + 132L, falloff_speed_scale);
      }

   }

   public float getPad2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 148L) : this.__io__block.readFloat(this.__io__address + 136L);
   }

   public void setPad2(float pad2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 148L, pad2);
      } else {
         this.__io__block.writeFloat(this.__io__address + 136L, pad2);
      }

   }

   public CPointer<ColorBand> getCoba() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 152L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 140L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{ColorBand.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 34), this.__io__blockTable);
   }

   public void setCoba(CPointer<ColorBand> coba) throws IOException {
      long __address = coba == null ? 0L : coba.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 152L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 140L, __address);
      }

   }

   public CPointer<CurveMapping> getFalloff_curve() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 160L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 144L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{CurveMapping.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 461), this.__io__blockTable);
   }

   public void setFalloff_curve(CPointer<CurveMapping> falloff_curve) throws IOException {
      long __address = falloff_curve == null ? 0L : falloff_curve.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 160L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 144L, __address);
      }

   }

   public CPointer<PointDensity> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{PointDensity.class}, this.__io__block, this.__io__blockTable);
   }
}
