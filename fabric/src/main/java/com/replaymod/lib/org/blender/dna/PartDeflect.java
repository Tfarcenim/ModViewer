package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 148L,
   size64 = 160L
)
public class PartDeflect extends CFacade {
   public static final int __DNA__SDNA_INDEX = 156;
   public static final long[] __DNA__FIELD__flag = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__deflect = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__forcefield = new long[]{6L, 6L};
   public static final long[] __DNA__FIELD__falloff = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__shape = new long[]{10L, 10L};
   public static final long[] __DNA__FIELD__tex_mode = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__kink = new long[]{14L, 14L};
   public static final long[] __DNA__FIELD__kink_axis = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__zdir = new long[]{18L, 18L};
   public static final long[] __DNA__FIELD__f_strength = new long[]{20L, 20L};
   public static final long[] __DNA__FIELD__f_damp = new long[]{24L, 24L};
   public static final long[] __DNA__FIELD__f_flow = new long[]{28L, 28L};
   public static final long[] __DNA__FIELD__f_size = new long[]{32L, 32L};
   public static final long[] __DNA__FIELD__f_power = new long[]{36L, 36L};
   public static final long[] __DNA__FIELD__maxdist = new long[]{40L, 40L};
   public static final long[] __DNA__FIELD__mindist = new long[]{44L, 44L};
   public static final long[] __DNA__FIELD__f_power_r = new long[]{48L, 48L};
   public static final long[] __DNA__FIELD__maxrad = new long[]{52L, 52L};
   public static final long[] __DNA__FIELD__minrad = new long[]{56L, 56L};
   public static final long[] __DNA__FIELD__pdef_damp = new long[]{60L, 60L};
   public static final long[] __DNA__FIELD__pdef_rdamp = new long[]{64L, 64L};
   public static final long[] __DNA__FIELD__pdef_perm = new long[]{68L, 68L};
   public static final long[] __DNA__FIELD__pdef_frict = new long[]{72L, 72L};
   public static final long[] __DNA__FIELD__pdef_rfrict = new long[]{76L, 76L};
   public static final long[] __DNA__FIELD__pdef_stickness = new long[]{80L, 80L};
   public static final long[] __DNA__FIELD__absorption = new long[]{84L, 84L};
   public static final long[] __DNA__FIELD__pdef_sbdamp = new long[]{88L, 88L};
   public static final long[] __DNA__FIELD__pdef_sbift = new long[]{92L, 92L};
   public static final long[] __DNA__FIELD__pdef_sboft = new long[]{96L, 96L};
   public static final long[] __DNA__FIELD__clump_fac = new long[]{100L, 100L};
   public static final long[] __DNA__FIELD__clump_pow = new long[]{104L, 104L};
   public static final long[] __DNA__FIELD__kink_freq = new long[]{108L, 108L};
   public static final long[] __DNA__FIELD__kink_shape = new long[]{112L, 112L};
   public static final long[] __DNA__FIELD__kink_amp = new long[]{116L, 116L};
   public static final long[] __DNA__FIELD__free_end = new long[]{120L, 120L};
   public static final long[] __DNA__FIELD__tex_nabla = new long[]{124L, 124L};
   public static final long[] __DNA__FIELD__tex = new long[]{128L, 128L};
   public static final long[] __DNA__FIELD__rng = new long[]{132L, 136L};
   public static final long[] __DNA__FIELD__f_noise = new long[]{136L, 144L};
   public static final long[] __DNA__FIELD__seed = new long[]{140L, 148L};
   public static final long[] __DNA__FIELD__f_source = new long[]{144L, 152L};

   public PartDeflect(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected PartDeflect(PartDeflect that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 0L) : this.__io__block.readInt(this.__io__address + 0L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 0L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 0L, flag);
      }

   }

   public short getDeflect() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 4L) : this.__io__block.readShort(this.__io__address + 4L);
   }

   public void setDeflect(short deflect) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 4L, deflect);
      } else {
         this.__io__block.writeShort(this.__io__address + 4L, deflect);
      }

   }

   public short getForcefield() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 6L) : this.__io__block.readShort(this.__io__address + 6L);
   }

   public void setForcefield(short forcefield) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 6L, forcefield);
      } else {
         this.__io__block.writeShort(this.__io__address + 6L, forcefield);
      }

   }

   public short getFalloff() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 8L) : this.__io__block.readShort(this.__io__address + 8L);
   }

   public void setFalloff(short falloff) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 8L, falloff);
      } else {
         this.__io__block.writeShort(this.__io__address + 8L, falloff);
      }

   }

   public short getShape() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 10L) : this.__io__block.readShort(this.__io__address + 10L);
   }

   public void setShape(short shape) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 10L, shape);
      } else {
         this.__io__block.writeShort(this.__io__address + 10L, shape);
      }

   }

   public short getTex_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 12L) : this.__io__block.readShort(this.__io__address + 12L);
   }

   public void setTex_mode(short tex_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 12L, tex_mode);
      } else {
         this.__io__block.writeShort(this.__io__address + 12L, tex_mode);
      }

   }

   public short getKink() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 14L) : this.__io__block.readShort(this.__io__address + 14L);
   }

   public void setKink(short kink) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 14L, kink);
      } else {
         this.__io__block.writeShort(this.__io__address + 14L, kink);
      }

   }

   public short getKink_axis() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 16L) : this.__io__block.readShort(this.__io__address + 16L);
   }

   public void setKink_axis(short kink_axis) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 16L, kink_axis);
      } else {
         this.__io__block.writeShort(this.__io__address + 16L, kink_axis);
      }

   }

   public short getZdir() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 18L) : this.__io__block.readShort(this.__io__address + 18L);
   }

   public void setZdir(short zdir) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 18L, zdir);
      } else {
         this.__io__block.writeShort(this.__io__address + 18L, zdir);
      }

   }

   public float getF_strength() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 20L) : this.__io__block.readFloat(this.__io__address + 20L);
   }

   public void setF_strength(float f_strength) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 20L, f_strength);
      } else {
         this.__io__block.writeFloat(this.__io__address + 20L, f_strength);
      }

   }

   public float getF_damp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 24L) : this.__io__block.readFloat(this.__io__address + 24L);
   }

   public void setF_damp(float f_damp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 24L, f_damp);
      } else {
         this.__io__block.writeFloat(this.__io__address + 24L, f_damp);
      }

   }

   public float getF_flow() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 28L) : this.__io__block.readFloat(this.__io__address + 28L);
   }

   public void setF_flow(float f_flow) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 28L, f_flow);
      } else {
         this.__io__block.writeFloat(this.__io__address + 28L, f_flow);
      }

   }

   public float getF_size() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 32L) : this.__io__block.readFloat(this.__io__address + 32L);
   }

   public void setF_size(float f_size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 32L, f_size);
      } else {
         this.__io__block.writeFloat(this.__io__address + 32L, f_size);
      }

   }

   public float getF_power() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 36L) : this.__io__block.readFloat(this.__io__address + 36L);
   }

   public void setF_power(float f_power) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 36L, f_power);
      } else {
         this.__io__block.writeFloat(this.__io__address + 36L, f_power);
      }

   }

   public float getMaxdist() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 40L) : this.__io__block.readFloat(this.__io__address + 40L);
   }

   public void setMaxdist(float maxdist) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 40L, maxdist);
      } else {
         this.__io__block.writeFloat(this.__io__address + 40L, maxdist);
      }

   }

   public float getMindist() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 44L) : this.__io__block.readFloat(this.__io__address + 44L);
   }

   public void setMindist(float mindist) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 44L, mindist);
      } else {
         this.__io__block.writeFloat(this.__io__address + 44L, mindist);
      }

   }

   public float getF_power_r() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 48L) : this.__io__block.readFloat(this.__io__address + 48L);
   }

   public void setF_power_r(float f_power_r) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 48L, f_power_r);
      } else {
         this.__io__block.writeFloat(this.__io__address + 48L, f_power_r);
      }

   }

   public float getMaxrad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 52L) : this.__io__block.readFloat(this.__io__address + 52L);
   }

   public void setMaxrad(float maxrad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 52L, maxrad);
      } else {
         this.__io__block.writeFloat(this.__io__address + 52L, maxrad);
      }

   }

   public float getMinrad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 56L) : this.__io__block.readFloat(this.__io__address + 56L);
   }

   public void setMinrad(float minrad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 56L, minrad);
      } else {
         this.__io__block.writeFloat(this.__io__address + 56L, minrad);
      }

   }

   public float getPdef_damp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 60L) : this.__io__block.readFloat(this.__io__address + 60L);
   }

   public void setPdef_damp(float pdef_damp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 60L, pdef_damp);
      } else {
         this.__io__block.writeFloat(this.__io__address + 60L, pdef_damp);
      }

   }

   public float getPdef_rdamp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 64L) : this.__io__block.readFloat(this.__io__address + 64L);
   }

   public void setPdef_rdamp(float pdef_rdamp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 64L, pdef_rdamp);
      } else {
         this.__io__block.writeFloat(this.__io__address + 64L, pdef_rdamp);
      }

   }

   public float getPdef_perm() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 68L) : this.__io__block.readFloat(this.__io__address + 68L);
   }

   public void setPdef_perm(float pdef_perm) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 68L, pdef_perm);
      } else {
         this.__io__block.writeFloat(this.__io__address + 68L, pdef_perm);
      }

   }

   public float getPdef_frict() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 72L) : this.__io__block.readFloat(this.__io__address + 72L);
   }

   public void setPdef_frict(float pdef_frict) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 72L, pdef_frict);
      } else {
         this.__io__block.writeFloat(this.__io__address + 72L, pdef_frict);
      }

   }

   public float getPdef_rfrict() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 76L) : this.__io__block.readFloat(this.__io__address + 76L);
   }

   public void setPdef_rfrict(float pdef_rfrict) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 76L, pdef_rfrict);
      } else {
         this.__io__block.writeFloat(this.__io__address + 76L, pdef_rfrict);
      }

   }

   public float getPdef_stickness() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 80L) : this.__io__block.readFloat(this.__io__address + 80L);
   }

   public void setPdef_stickness(float pdef_stickness) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 80L, pdef_stickness);
      } else {
         this.__io__block.writeFloat(this.__io__address + 80L, pdef_stickness);
      }

   }

   public float getAbsorption() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 84L) : this.__io__block.readFloat(this.__io__address + 84L);
   }

   public void setAbsorption(float absorption) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 84L, absorption);
      } else {
         this.__io__block.writeFloat(this.__io__address + 84L, absorption);
      }

   }

   public float getPdef_sbdamp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 88L) : this.__io__block.readFloat(this.__io__address + 88L);
   }

   public void setPdef_sbdamp(float pdef_sbdamp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 88L, pdef_sbdamp);
      } else {
         this.__io__block.writeFloat(this.__io__address + 88L, pdef_sbdamp);
      }

   }

   public float getPdef_sbift() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 92L) : this.__io__block.readFloat(this.__io__address + 92L);
   }

   public void setPdef_sbift(float pdef_sbift) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 92L, pdef_sbift);
      } else {
         this.__io__block.writeFloat(this.__io__address + 92L, pdef_sbift);
      }

   }

   public float getPdef_sboft() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 96L) : this.__io__block.readFloat(this.__io__address + 96L);
   }

   public void setPdef_sboft(float pdef_sboft) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 96L, pdef_sboft);
      } else {
         this.__io__block.writeFloat(this.__io__address + 96L, pdef_sboft);
      }

   }

   public float getClump_fac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 100L) : this.__io__block.readFloat(this.__io__address + 100L);
   }

   public void setClump_fac(float clump_fac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 100L, clump_fac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 100L, clump_fac);
      }

   }

   public float getClump_pow() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 104L) : this.__io__block.readFloat(this.__io__address + 104L);
   }

   public void setClump_pow(float clump_pow) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 104L, clump_pow);
      } else {
         this.__io__block.writeFloat(this.__io__address + 104L, clump_pow);
      }

   }

   public float getKink_freq() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 108L) : this.__io__block.readFloat(this.__io__address + 108L);
   }

   public void setKink_freq(float kink_freq) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 108L, kink_freq);
      } else {
         this.__io__block.writeFloat(this.__io__address + 108L, kink_freq);
      }

   }

   public float getKink_shape() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 112L) : this.__io__block.readFloat(this.__io__address + 112L);
   }

   public void setKink_shape(float kink_shape) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 112L, kink_shape);
      } else {
         this.__io__block.writeFloat(this.__io__address + 112L, kink_shape);
      }

   }

   public float getKink_amp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 116L) : this.__io__block.readFloat(this.__io__address + 116L);
   }

   public void setKink_amp(float kink_amp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 116L, kink_amp);
      } else {
         this.__io__block.writeFloat(this.__io__address + 116L, kink_amp);
      }

   }

   public float getFree_end() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 120L) : this.__io__block.readFloat(this.__io__address + 120L);
   }

   public void setFree_end(float free_end) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 120L, free_end);
      } else {
         this.__io__block.writeFloat(this.__io__address + 120L, free_end);
      }

   }

   public float getTex_nabla() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 124L) : this.__io__block.readFloat(this.__io__address + 124L);
   }

   public void setTex_nabla(float tex_nabla) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 124L, tex_nabla);
      } else {
         this.__io__block.writeFloat(this.__io__address + 124L, tex_nabla);
      }

   }

   public CPointer<Tex> getTex() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 128L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 128L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Tex.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 39), this.__io__blockTable);
   }

   public void setTex(CPointer<Tex> tex) throws IOException {
      long __address = tex == null ? 0L : tex.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 128L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 128L, __address);
      }

   }

   public CPointer<Object> getRng() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 136L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 132L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setRng(CPointer<Object> rng) throws IOException {
      long __address = rng == null ? 0L : rng.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 136L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 132L, __address);
      }

   }

   public float getF_noise() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 144L) : this.__io__block.readFloat(this.__io__address + 136L);
   }

   public void setF_noise(float f_noise) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 144L, f_noise);
      } else {
         this.__io__block.writeFloat(this.__io__address + 136L, f_noise);
      }

   }

   public int getSeed() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 148L) : this.__io__block.readInt(this.__io__address + 140L);
   }

   public void setSeed(int seed) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 148L, seed);
      } else {
         this.__io__block.writeInt(this.__io__address + 140L, seed);
      }

   }

   public CPointer<BlenderObject> getF_source() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 152L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 144L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setF_source(CPointer<BlenderObject> f_source) throws IOException {
      long __address = f_source == null ? 0L : f_source.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 152L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 144L, __address);
      }

   }

   public CPointer<PartDeflect> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{PartDeflect.class}, this.__io__block, this.__io__blockTable);
   }
}
