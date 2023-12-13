package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 352L,
   size64 = 416L
)
public class Tex extends CFacade {
   public static final int __DNA__SDNA_INDEX = 39;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__adt = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__noisesize = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__turbul = new long[]{108L, 132L};
   public static final long[] __DNA__FIELD__bright = new long[]{112L, 136L};
   public static final long[] __DNA__FIELD__contrast = new long[]{116L, 140L};
   public static final long[] __DNA__FIELD__saturation = new long[]{120L, 144L};
   public static final long[] __DNA__FIELD__rfac = new long[]{124L, 148L};
   public static final long[] __DNA__FIELD__gfac = new long[]{128L, 152L};
   public static final long[] __DNA__FIELD__bfac = new long[]{132L, 156L};
   public static final long[] __DNA__FIELD__filtersize = new long[]{136L, 160L};
   public static final long[] __DNA__FIELD__pad2 = new long[]{140L, 164L};
   public static final long[] __DNA__FIELD__mg_H = new long[]{144L, 168L};
   public static final long[] __DNA__FIELD__mg_lacunarity = new long[]{148L, 172L};
   public static final long[] __DNA__FIELD__mg_octaves = new long[]{152L, 176L};
   public static final long[] __DNA__FIELD__mg_offset = new long[]{156L, 180L};
   public static final long[] __DNA__FIELD__mg_gain = new long[]{160L, 184L};
   public static final long[] __DNA__FIELD__dist_amount = new long[]{164L, 188L};
   public static final long[] __DNA__FIELD__ns_outscale = new long[]{168L, 192L};
   public static final long[] __DNA__FIELD__vn_w1 = new long[]{172L, 196L};
   public static final long[] __DNA__FIELD__vn_w2 = new long[]{176L, 200L};
   public static final long[] __DNA__FIELD__vn_w3 = new long[]{180L, 204L};
   public static final long[] __DNA__FIELD__vn_w4 = new long[]{184L, 208L};
   public static final long[] __DNA__FIELD__vn_mexp = new long[]{188L, 212L};
   public static final long[] __DNA__FIELD__vn_distm = new long[]{192L, 216L};
   public static final long[] __DNA__FIELD__vn_coltype = new long[]{194L, 218L};
   public static final long[] __DNA__FIELD__noisedepth = new long[]{196L, 220L};
   public static final long[] __DNA__FIELD__noisetype = new long[]{198L, 222L};
   public static final long[] __DNA__FIELD__noisebasis = new long[]{200L, 224L};
   public static final long[] __DNA__FIELD__noisebasis2 = new long[]{202L, 226L};
   public static final long[] __DNA__FIELD__imaflag = new long[]{204L, 228L};
   public static final long[] __DNA__FIELD__flag = new long[]{206L, 230L};
   public static final long[] __DNA__FIELD__type = new long[]{208L, 232L};
   public static final long[] __DNA__FIELD__stype = new long[]{210L, 234L};
   public static final long[] __DNA__FIELD__cropxmin = new long[]{212L, 236L};
   public static final long[] __DNA__FIELD__cropymin = new long[]{216L, 240L};
   public static final long[] __DNA__FIELD__cropxmax = new long[]{220L, 244L};
   public static final long[] __DNA__FIELD__cropymax = new long[]{224L, 248L};
   public static final long[] __DNA__FIELD__texfilter = new long[]{228L, 252L};
   public static final long[] __DNA__FIELD__afmax = new long[]{232L, 256L};
   public static final long[] __DNA__FIELD__xrepeat = new long[]{236L, 260L};
   public static final long[] __DNA__FIELD__yrepeat = new long[]{238L, 262L};
   public static final long[] __DNA__FIELD__extend = new long[]{240L, 264L};
   public static final long[] __DNA__FIELD__fie_ima = new long[]{242L, 266L};
   public static final long[] __DNA__FIELD__len = new long[]{244L, 268L};
   public static final long[] __DNA__FIELD__frames = new long[]{248L, 272L};
   public static final long[] __DNA__FIELD__offset = new long[]{252L, 276L};
   public static final long[] __DNA__FIELD__sfra = new long[]{256L, 280L};
   public static final long[] __DNA__FIELD__checkerdist = new long[]{260L, 284L};
   public static final long[] __DNA__FIELD__nabla = new long[]{264L, 288L};
   public static final long[] __DNA__FIELD__pad1 = new long[]{268L, 292L};
   public static final long[] __DNA__FIELD__iuser = new long[]{272L, 296L};
   public static final long[] __DNA__FIELD__nodetree = new long[]{308L, 336L};
   public static final long[] __DNA__FIELD__ipo = new long[]{312L, 344L};
   public static final long[] __DNA__FIELD__ima = new long[]{316L, 352L};
   public static final long[] __DNA__FIELD__coba = new long[]{320L, 360L};
   public static final long[] __DNA__FIELD__env = new long[]{324L, 368L};
   public static final long[] __DNA__FIELD__preview = new long[]{328L, 376L};
   public static final long[] __DNA__FIELD__pd = new long[]{332L, 384L};
   public static final long[] __DNA__FIELD__vd = new long[]{336L, 392L};
   public static final long[] __DNA__FIELD__ot = new long[]{340L, 400L};
   public static final long[] __DNA__FIELD__use_nodes = new long[]{344L, 408L};
   public static final long[] __DNA__FIELD__pad = new long[]{345L, 409L};

   public Tex(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Tex(Tex that) {
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

   public float getNoisesize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 128L) : this.__io__block.readFloat(this.__io__address + 104L);
   }

   public void setNoisesize(float noisesize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 128L, noisesize);
      } else {
         this.__io__block.writeFloat(this.__io__address + 104L, noisesize);
      }

   }

   public float getTurbul() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 132L) : this.__io__block.readFloat(this.__io__address + 108L);
   }

   public void setTurbul(float turbul) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 132L, turbul);
      } else {
         this.__io__block.writeFloat(this.__io__address + 108L, turbul);
      }

   }

   public float getBright() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 136L) : this.__io__block.readFloat(this.__io__address + 112L);
   }

   public void setBright(float bright) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 136L, bright);
      } else {
         this.__io__block.writeFloat(this.__io__address + 112L, bright);
      }

   }

   public float getContrast() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 140L) : this.__io__block.readFloat(this.__io__address + 116L);
   }

   public void setContrast(float contrast) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 140L, contrast);
      } else {
         this.__io__block.writeFloat(this.__io__address + 116L, contrast);
      }

   }

   public float getSaturation() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 144L) : this.__io__block.readFloat(this.__io__address + 120L);
   }

   public void setSaturation(float saturation) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 144L, saturation);
      } else {
         this.__io__block.writeFloat(this.__io__address + 120L, saturation);
      }

   }

   public float getRfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 148L) : this.__io__block.readFloat(this.__io__address + 124L);
   }

   public void setRfac(float rfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 148L, rfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 124L, rfac);
      }

   }

   public float getGfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 152L) : this.__io__block.readFloat(this.__io__address + 128L);
   }

   public void setGfac(float gfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 152L, gfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 128L, gfac);
      }

   }

   public float getBfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 156L) : this.__io__block.readFloat(this.__io__address + 132L);
   }

   public void setBfac(float bfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 156L, bfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 132L, bfac);
      }

   }

   public float getFiltersize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 160L) : this.__io__block.readFloat(this.__io__address + 136L);
   }

   public void setFiltersize(float filtersize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 160L, filtersize);
      } else {
         this.__io__block.writeFloat(this.__io__address + 136L, filtersize);
      }

   }

   public float getPad2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 164L) : this.__io__block.readFloat(this.__io__address + 140L);
   }

   public void setPad2(float pad2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 164L, pad2);
      } else {
         this.__io__block.writeFloat(this.__io__address + 140L, pad2);
      }

   }

   public float getMg_H() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 168L) : this.__io__block.readFloat(this.__io__address + 144L);
   }

   public void setMg_H(float mg_H) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 168L, mg_H);
      } else {
         this.__io__block.writeFloat(this.__io__address + 144L, mg_H);
      }

   }

   public float getMg_lacunarity() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 172L) : this.__io__block.readFloat(this.__io__address + 148L);
   }

   public void setMg_lacunarity(float mg_lacunarity) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 172L, mg_lacunarity);
      } else {
         this.__io__block.writeFloat(this.__io__address + 148L, mg_lacunarity);
      }

   }

   public float getMg_octaves() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 176L) : this.__io__block.readFloat(this.__io__address + 152L);
   }

   public void setMg_octaves(float mg_octaves) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 176L, mg_octaves);
      } else {
         this.__io__block.writeFloat(this.__io__address + 152L, mg_octaves);
      }

   }

   public float getMg_offset() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 180L) : this.__io__block.readFloat(this.__io__address + 156L);
   }

   public void setMg_offset(float mg_offset) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 180L, mg_offset);
      } else {
         this.__io__block.writeFloat(this.__io__address + 156L, mg_offset);
      }

   }

   public float getMg_gain() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 184L) : this.__io__block.readFloat(this.__io__address + 160L);
   }

   public void setMg_gain(float mg_gain) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 184L, mg_gain);
      } else {
         this.__io__block.writeFloat(this.__io__address + 160L, mg_gain);
      }

   }

   public float getDist_amount() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 188L) : this.__io__block.readFloat(this.__io__address + 164L);
   }

   public void setDist_amount(float dist_amount) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 188L, dist_amount);
      } else {
         this.__io__block.writeFloat(this.__io__address + 164L, dist_amount);
      }

   }

   public float getNs_outscale() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 192L) : this.__io__block.readFloat(this.__io__address + 168L);
   }

   public void setNs_outscale(float ns_outscale) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 192L, ns_outscale);
      } else {
         this.__io__block.writeFloat(this.__io__address + 168L, ns_outscale);
      }

   }

   public float getVn_w1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 196L) : this.__io__block.readFloat(this.__io__address + 172L);
   }

   public void setVn_w1(float vn_w1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 196L, vn_w1);
      } else {
         this.__io__block.writeFloat(this.__io__address + 172L, vn_w1);
      }

   }

   public float getVn_w2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 200L) : this.__io__block.readFloat(this.__io__address + 176L);
   }

   public void setVn_w2(float vn_w2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 200L, vn_w2);
      } else {
         this.__io__block.writeFloat(this.__io__address + 176L, vn_w2);
      }

   }

   public float getVn_w3() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 204L) : this.__io__block.readFloat(this.__io__address + 180L);
   }

   public void setVn_w3(float vn_w3) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 204L, vn_w3);
      } else {
         this.__io__block.writeFloat(this.__io__address + 180L, vn_w3);
      }

   }

   public float getVn_w4() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 208L) : this.__io__block.readFloat(this.__io__address + 184L);
   }

   public void setVn_w4(float vn_w4) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 208L, vn_w4);
      } else {
         this.__io__block.writeFloat(this.__io__address + 184L, vn_w4);
      }

   }

   public float getVn_mexp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 212L) : this.__io__block.readFloat(this.__io__address + 188L);
   }

   public void setVn_mexp(float vn_mexp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 212L, vn_mexp);
      } else {
         this.__io__block.writeFloat(this.__io__address + 188L, vn_mexp);
      }

   }

   public short getVn_distm() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 216L) : this.__io__block.readShort(this.__io__address + 192L);
   }

   public void setVn_distm(short vn_distm) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 216L, vn_distm);
      } else {
         this.__io__block.writeShort(this.__io__address + 192L, vn_distm);
      }

   }

   public short getVn_coltype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 218L) : this.__io__block.readShort(this.__io__address + 194L);
   }

   public void setVn_coltype(short vn_coltype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 218L, vn_coltype);
      } else {
         this.__io__block.writeShort(this.__io__address + 194L, vn_coltype);
      }

   }

   public short getNoisedepth() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 220L) : this.__io__block.readShort(this.__io__address + 196L);
   }

   public void setNoisedepth(short noisedepth) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 220L, noisedepth);
      } else {
         this.__io__block.writeShort(this.__io__address + 196L, noisedepth);
      }

   }

   public short getNoisetype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 222L) : this.__io__block.readShort(this.__io__address + 198L);
   }

   public void setNoisetype(short noisetype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 222L, noisetype);
      } else {
         this.__io__block.writeShort(this.__io__address + 198L, noisetype);
      }

   }

   public short getNoisebasis() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 224L) : this.__io__block.readShort(this.__io__address + 200L);
   }

   public void setNoisebasis(short noisebasis) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 224L, noisebasis);
      } else {
         this.__io__block.writeShort(this.__io__address + 200L, noisebasis);
      }

   }

   public short getNoisebasis2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 226L) : this.__io__block.readShort(this.__io__address + 202L);
   }

   public void setNoisebasis2(short noisebasis2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 226L, noisebasis2);
      } else {
         this.__io__block.writeShort(this.__io__address + 202L, noisebasis2);
      }

   }

   public short getImaflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 228L) : this.__io__block.readShort(this.__io__address + 204L);
   }

   public void setImaflag(short imaflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 228L, imaflag);
      } else {
         this.__io__block.writeShort(this.__io__address + 204L, imaflag);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 230L) : this.__io__block.readShort(this.__io__address + 206L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 230L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 206L, flag);
      }

   }

   public short getType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 232L) : this.__io__block.readShort(this.__io__address + 208L);
   }

   public void setType(short type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 232L, type);
      } else {
         this.__io__block.writeShort(this.__io__address + 208L, type);
      }

   }

   public short getStype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 234L) : this.__io__block.readShort(this.__io__address + 210L);
   }

   public void setStype(short stype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 234L, stype);
      } else {
         this.__io__block.writeShort(this.__io__address + 210L, stype);
      }

   }

   public float getCropxmin() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 236L) : this.__io__block.readFloat(this.__io__address + 212L);
   }

   public void setCropxmin(float cropxmin) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 236L, cropxmin);
      } else {
         this.__io__block.writeFloat(this.__io__address + 212L, cropxmin);
      }

   }

   public float getCropymin() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 240L) : this.__io__block.readFloat(this.__io__address + 216L);
   }

   public void setCropymin(float cropymin) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 240L, cropymin);
      } else {
         this.__io__block.writeFloat(this.__io__address + 216L, cropymin);
      }

   }

   public float getCropxmax() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 244L) : this.__io__block.readFloat(this.__io__address + 220L);
   }

   public void setCropxmax(float cropxmax) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 244L, cropxmax);
      } else {
         this.__io__block.writeFloat(this.__io__address + 220L, cropxmax);
      }

   }

   public float getCropymax() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 248L) : this.__io__block.readFloat(this.__io__address + 224L);
   }

   public void setCropymax(float cropymax) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 248L, cropymax);
      } else {
         this.__io__block.writeFloat(this.__io__address + 224L, cropymax);
      }

   }

   public int getTexfilter() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 252L) : this.__io__block.readInt(this.__io__address + 228L);
   }

   public void setTexfilter(int texfilter) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 252L, texfilter);
      } else {
         this.__io__block.writeInt(this.__io__address + 228L, texfilter);
      }

   }

   public int getAfmax() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 256L) : this.__io__block.readInt(this.__io__address + 232L);
   }

   public void setAfmax(int afmax) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 256L, afmax);
      } else {
         this.__io__block.writeInt(this.__io__address + 232L, afmax);
      }

   }

   public short getXrepeat() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 260L) : this.__io__block.readShort(this.__io__address + 236L);
   }

   public void setXrepeat(short xrepeat) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 260L, xrepeat);
      } else {
         this.__io__block.writeShort(this.__io__address + 236L, xrepeat);
      }

   }

   public short getYrepeat() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 262L) : this.__io__block.readShort(this.__io__address + 238L);
   }

   public void setYrepeat(short yrepeat) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 262L, yrepeat);
      } else {
         this.__io__block.writeShort(this.__io__address + 238L, yrepeat);
      }

   }

   public short getExtend() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 264L) : this.__io__block.readShort(this.__io__address + 240L);
   }

   public void setExtend(short extend) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 264L, extend);
      } else {
         this.__io__block.writeShort(this.__io__address + 240L, extend);
      }

   }

   public short getFie_ima() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 266L) : this.__io__block.readShort(this.__io__address + 242L);
   }

   public void setFie_ima(short fie_ima) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 266L, fie_ima);
      } else {
         this.__io__block.writeShort(this.__io__address + 242L, fie_ima);
      }

   }

   public int getLen() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 268L) : this.__io__block.readInt(this.__io__address + 244L);
   }

   public void setLen(int len) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 268L, len);
      } else {
         this.__io__block.writeInt(this.__io__address + 244L, len);
      }

   }

   public int getFrames() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 272L) : this.__io__block.readInt(this.__io__address + 248L);
   }

   public void setFrames(int frames) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 272L, frames);
      } else {
         this.__io__block.writeInt(this.__io__address + 248L, frames);
      }

   }

   public int getOffset() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 276L) : this.__io__block.readInt(this.__io__address + 252L);
   }

   public void setOffset(int offset) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 276L, offset);
      } else {
         this.__io__block.writeInt(this.__io__address + 252L, offset);
      }

   }

   public int getSfra() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 280L) : this.__io__block.readInt(this.__io__address + 256L);
   }

   public void setSfra(int sfra) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 280L, sfra);
      } else {
         this.__io__block.writeInt(this.__io__address + 256L, sfra);
      }

   }

   public float getCheckerdist() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 284L) : this.__io__block.readFloat(this.__io__address + 260L);
   }

   public void setCheckerdist(float checkerdist) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 284L, checkerdist);
      } else {
         this.__io__block.writeFloat(this.__io__address + 260L, checkerdist);
      }

   }

   public float getNabla() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 288L) : this.__io__block.readFloat(this.__io__address + 264L);
   }

   public void setNabla(float nabla) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 288L, nabla);
      } else {
         this.__io__block.writeFloat(this.__io__address + 264L, nabla);
      }

   }

   public float getPad1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 292L) : this.__io__block.readFloat(this.__io__address + 268L);
   }

   public void setPad1(float pad1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 292L, pad1);
      } else {
         this.__io__block.writeFloat(this.__io__address + 268L, pad1);
      }

   }

   public ImageUser getIuser() throws IOException {
      return this.__io__pointersize == 8 ? new ImageUser(this.__io__address + 296L, this.__io__block, this.__io__blockTable) : new ImageUser(this.__io__address + 272L, this.__io__block, this.__io__blockTable);
   }

   public void setIuser(ImageUser iuser) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 296L;
      } else {
         __dna__offset = 272L;
      }

      if (!this.__io__equals(iuser, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, iuser)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, iuser);
         } else {
            __io__generic__copy(this.getIuser(), iuser);
         }

      }
   }

   public CPointer<bNodeTree> getNodetree() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 336L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 308L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bNodeTree.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 397), this.__io__blockTable);
   }

   public void setNodetree(CPointer<bNodeTree> nodetree) throws IOException {
      long __address = nodetree == null ? 0L : nodetree.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 336L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 308L, __address);
      }

   }

   public CPointer<Ipo> getIpo() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 344L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 312L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Ipo.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 15), this.__io__blockTable);
   }

   public void setIpo(CPointer<Ipo> ipo) throws IOException {
      long __address = ipo == null ? 0L : ipo.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 344L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 312L, __address);
      }

   }

   public CPointer<Image> getIma() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 352L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 316L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Image.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 31), this.__io__blockTable);
   }

   public void setIma(CPointer<Image> ima) throws IOException {
      long __address = ima == null ? 0L : ima.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 352L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 316L, __address);
      }

   }

   public CPointer<ColorBand> getCoba() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 360L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 320L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{ColorBand.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 34), this.__io__blockTable);
   }

   public void setCoba(CPointer<ColorBand> coba) throws IOException {
      long __address = coba == null ? 0L : coba.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 360L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 320L, __address);
      }

   }

   public CPointer<EnvMap> getEnv() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 368L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 324L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{EnvMap.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 35), this.__io__blockTable);
   }

   public void setEnv(CPointer<EnvMap> env) throws IOException {
      long __address = env == null ? 0L : env.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 368L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 324L, __address);
      }

   }

   public CPointer<PreviewImage> getPreview() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 376L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 328L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PreviewImage.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 12), this.__io__blockTable);
   }

   public void setPreview(CPointer<PreviewImage> preview) throws IOException {
      long __address = preview == null ? 0L : preview.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 376L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 328L, __address);
      }

   }

   public CPointer<PointDensity> getPd() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 384L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 332L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PointDensity.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 36), this.__io__blockTable);
   }

   public void setPd(CPointer<PointDensity> pd) throws IOException {
      long __address = pd == null ? 0L : pd.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 384L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 332L, __address);
      }

   }

   public CPointer<VoxelData> getVd() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 392L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 336L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{VoxelData.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 37), this.__io__blockTable);
   }

   public void setVd(CPointer<VoxelData> vd) throws IOException {
      long __address = vd == null ? 0L : vd.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 392L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 336L, __address);
      }

   }

   public CPointer<OceanTex> getOt() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 400L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 340L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{OceanTex.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 38), this.__io__blockTable);
   }

   public void setOt(CPointer<OceanTex> ot) throws IOException {
      long __address = ot == null ? 0L : ot.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 400L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 340L, __address);
      }

   }

   public byte getUse_nodes() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 408L) : this.__io__block.readByte(this.__io__address + 344L);
   }

   public void setUse_nodes(byte use_nodes) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 408L, use_nodes);
      } else {
         this.__io__block.writeByte(this.__io__address + 344L, use_nodes);
      }

   }

   public CArrayFacade<Byte> getPad() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{7};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 409L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 345L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad(CArrayFacade<Byte> pad) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 409L;
      } else {
         __dna__offset = 345L;
      }

      if (!this.__io__equals(pad, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad);
         } else {
            __io__generic__copy(this.getPad(), pad);
         }

      }
   }

   public CPointer<Tex> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Tex.class}, this.__io__block, this.__io__blockTable);
   }
}
