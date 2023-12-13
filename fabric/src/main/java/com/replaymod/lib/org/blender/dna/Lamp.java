package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 424L,
   size64 = 536L
)
public class Lamp extends CFacade {
   public static final int __DNA__SDNA_INDEX = 42;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__adt = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__type = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__flag = new long[]{106L, 130L};
   public static final long[] __DNA__FIELD__mode = new long[]{108L, 132L};
   public static final long[] __DNA__FIELD__colormodel = new long[]{112L, 136L};
   public static final long[] __DNA__FIELD__totex = new long[]{114L, 138L};
   public static final long[] __DNA__FIELD__r = new long[]{116L, 140L};
   public static final long[] __DNA__FIELD__g = new long[]{120L, 144L};
   public static final long[] __DNA__FIELD__b = new long[]{124L, 148L};
   public static final long[] __DNA__FIELD__k = new long[]{128L, 152L};
   public static final long[] __DNA__FIELD__shdwr = new long[]{132L, 156L};
   public static final long[] __DNA__FIELD__shdwg = new long[]{136L, 160L};
   public static final long[] __DNA__FIELD__shdwb = new long[]{140L, 164L};
   public static final long[] __DNA__FIELD__shdwpad = new long[]{144L, 168L};
   public static final long[] __DNA__FIELD__energy = new long[]{148L, 172L};
   public static final long[] __DNA__FIELD__dist = new long[]{152L, 176L};
   public static final long[] __DNA__FIELD__spotsize = new long[]{156L, 180L};
   public static final long[] __DNA__FIELD__spotblend = new long[]{160L, 184L};
   public static final long[] __DNA__FIELD__haint = new long[]{164L, 188L};
   public static final long[] __DNA__FIELD__att1 = new long[]{168L, 192L};
   public static final long[] __DNA__FIELD__att2 = new long[]{172L, 196L};
   public static final long[] __DNA__FIELD__coeff_const = new long[]{176L, 200L};
   public static final long[] __DNA__FIELD__coeff_lin = new long[]{180L, 204L};
   public static final long[] __DNA__FIELD__coeff_quad = new long[]{184L, 208L};
   public static final long[] __DNA__FIELD__coeff_pad = new long[]{188L, 212L};
   public static final long[] __DNA__FIELD__curfalloff = new long[]{192L, 216L};
   public static final long[] __DNA__FIELD__falloff_type = new long[]{196L, 224L};
   public static final long[] __DNA__FIELD__pad2 = new long[]{198L, 226L};
   public static final long[] __DNA__FIELD__clipsta = new long[]{200L, 228L};
   public static final long[] __DNA__FIELD__clipend = new long[]{204L, 232L};
   public static final long[] __DNA__FIELD__bias = new long[]{208L, 236L};
   public static final long[] __DNA__FIELD__soft = new long[]{212L, 240L};
   public static final long[] __DNA__FIELD__compressthresh = new long[]{216L, 244L};
   public static final long[] __DNA__FIELD__bleedbias = new long[]{220L, 248L};
   public static final long[] __DNA__FIELD__pad5 = new long[]{224L, 252L};
   public static final long[] __DNA__FIELD__bufsize = new long[]{228L, 256L};
   public static final long[] __DNA__FIELD__samp = new long[]{230L, 258L};
   public static final long[] __DNA__FIELD__buffers = new long[]{232L, 260L};
   public static final long[] __DNA__FIELD__filtertype = new long[]{234L, 262L};
   public static final long[] __DNA__FIELD__bufflag = new long[]{236L, 264L};
   public static final long[] __DNA__FIELD__buftype = new long[]{237L, 265L};
   public static final long[] __DNA__FIELD__ray_samp = new long[]{238L, 266L};
   public static final long[] __DNA__FIELD__ray_sampy = new long[]{240L, 268L};
   public static final long[] __DNA__FIELD__ray_sampz = new long[]{242L, 270L};
   public static final long[] __DNA__FIELD__ray_samp_type = new long[]{244L, 272L};
   public static final long[] __DNA__FIELD__area_shape = new long[]{246L, 274L};
   public static final long[] __DNA__FIELD__area_size = new long[]{248L, 276L};
   public static final long[] __DNA__FIELD__area_sizey = new long[]{252L, 280L};
   public static final long[] __DNA__FIELD__area_sizez = new long[]{256L, 284L};
   public static final long[] __DNA__FIELD__adapt_thresh = new long[]{260L, 288L};
   public static final long[] __DNA__FIELD__ray_samp_method = new long[]{264L, 292L};
   public static final long[] __DNA__FIELD__shadowmap_type = new long[]{266L, 294L};
   public static final long[] __DNA__FIELD__texact = new long[]{268L, 296L};
   public static final long[] __DNA__FIELD__shadhalostep = new long[]{270L, 298L};
   public static final long[] __DNA__FIELD__sun_effect_type = new long[]{272L, 300L};
   public static final long[] __DNA__FIELD__skyblendtype = new long[]{274L, 302L};
   public static final long[] __DNA__FIELD__horizon_brightness = new long[]{276L, 304L};
   public static final long[] __DNA__FIELD__spread = new long[]{280L, 308L};
   public static final long[] __DNA__FIELD__sun_brightness = new long[]{284L, 312L};
   public static final long[] __DNA__FIELD__sun_size = new long[]{288L, 316L};
   public static final long[] __DNA__FIELD__backscattered_light = new long[]{292L, 320L};
   public static final long[] __DNA__FIELD__sun_intensity = new long[]{296L, 324L};
   public static final long[] __DNA__FIELD__atm_turbidity = new long[]{300L, 328L};
   public static final long[] __DNA__FIELD__atm_inscattering_factor = new long[]{304L, 332L};
   public static final long[] __DNA__FIELD__atm_extinction_factor = new long[]{308L, 336L};
   public static final long[] __DNA__FIELD__atm_distance_factor = new long[]{312L, 340L};
   public static final long[] __DNA__FIELD__skyblendfac = new long[]{316L, 344L};
   public static final long[] __DNA__FIELD__sky_exposure = new long[]{320L, 348L};
   public static final long[] __DNA__FIELD__shadow_frustum_size = new long[]{324L, 352L};
   public static final long[] __DNA__FIELD__sky_colorspace = new long[]{328L, 356L};
   public static final long[] __DNA__FIELD__pad4 = new long[]{330L, 358L};
   public static final long[] __DNA__FIELD__ipo = new long[]{332L, 360L};
   public static final long[] __DNA__FIELD__mtex = new long[]{336L, 368L};
   public static final long[] __DNA__FIELD__pr_texture = new long[]{408L, 512L};
   public static final long[] __DNA__FIELD__use_nodes = new long[]{410L, 514L};
   public static final long[] __DNA__FIELD__pad6 = new long[]{412L, 516L};
   public static final long[] __DNA__FIELD__preview = new long[]{416L, 520L};
   public static final long[] __DNA__FIELD__nodetree = new long[]{420L, 528L};

   public Lamp(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Lamp(Lamp that) {
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

   public short getType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 128L) : this.__io__block.readShort(this.__io__address + 104L);
   }

   public void setType(short type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 128L, type);
      } else {
         this.__io__block.writeShort(this.__io__address + 104L, type);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 130L) : this.__io__block.readShort(this.__io__address + 106L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 130L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 106L, flag);
      }

   }

   public int getMode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 132L) : this.__io__block.readInt(this.__io__address + 108L);
   }

   public void setMode(int mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 132L, mode);
      } else {
         this.__io__block.writeInt(this.__io__address + 108L, mode);
      }

   }

   public short getColormodel() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 136L) : this.__io__block.readShort(this.__io__address + 112L);
   }

   public void setColormodel(short colormodel) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 136L, colormodel);
      } else {
         this.__io__block.writeShort(this.__io__address + 112L, colormodel);
      }

   }

   public short getTotex() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 138L) : this.__io__block.readShort(this.__io__address + 114L);
   }

   public void setTotex(short totex) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 138L, totex);
      } else {
         this.__io__block.writeShort(this.__io__address + 114L, totex);
      }

   }

   public float getR() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 140L) : this.__io__block.readFloat(this.__io__address + 116L);
   }

   public void setR(float r) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 140L, r);
      } else {
         this.__io__block.writeFloat(this.__io__address + 116L, r);
      }

   }

   public float getG() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 144L) : this.__io__block.readFloat(this.__io__address + 120L);
   }

   public void setG(float g) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 144L, g);
      } else {
         this.__io__block.writeFloat(this.__io__address + 120L, g);
      }

   }

   public float getB() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 148L) : this.__io__block.readFloat(this.__io__address + 124L);
   }

   public void setB(float b) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 148L, b);
      } else {
         this.__io__block.writeFloat(this.__io__address + 124L, b);
      }

   }

   public float getK() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 152L) : this.__io__block.readFloat(this.__io__address + 128L);
   }

   public void setK(float k) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 152L, k);
      } else {
         this.__io__block.writeFloat(this.__io__address + 128L, k);
      }

   }

   public float getShdwr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 156L) : this.__io__block.readFloat(this.__io__address + 132L);
   }

   public void setShdwr(float shdwr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 156L, shdwr);
      } else {
         this.__io__block.writeFloat(this.__io__address + 132L, shdwr);
      }

   }

   public float getShdwg() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 160L) : this.__io__block.readFloat(this.__io__address + 136L);
   }

   public void setShdwg(float shdwg) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 160L, shdwg);
      } else {
         this.__io__block.writeFloat(this.__io__address + 136L, shdwg);
      }

   }

   public float getShdwb() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 164L) : this.__io__block.readFloat(this.__io__address + 140L);
   }

   public void setShdwb(float shdwb) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 164L, shdwb);
      } else {
         this.__io__block.writeFloat(this.__io__address + 140L, shdwb);
      }

   }

   public float getShdwpad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 168L) : this.__io__block.readFloat(this.__io__address + 144L);
   }

   public void setShdwpad(float shdwpad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 168L, shdwpad);
      } else {
         this.__io__block.writeFloat(this.__io__address + 144L, shdwpad);
      }

   }

   public float getEnergy() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 172L) : this.__io__block.readFloat(this.__io__address + 148L);
   }

   public void setEnergy(float energy) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 172L, energy);
      } else {
         this.__io__block.writeFloat(this.__io__address + 148L, energy);
      }

   }

   public float getDist() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 176L) : this.__io__block.readFloat(this.__io__address + 152L);
   }

   public void setDist(float dist) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 176L, dist);
      } else {
         this.__io__block.writeFloat(this.__io__address + 152L, dist);
      }

   }

   public float getSpotsize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 180L) : this.__io__block.readFloat(this.__io__address + 156L);
   }

   public void setSpotsize(float spotsize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 180L, spotsize);
      } else {
         this.__io__block.writeFloat(this.__io__address + 156L, spotsize);
      }

   }

   public float getSpotblend() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 184L) : this.__io__block.readFloat(this.__io__address + 160L);
   }

   public void setSpotblend(float spotblend) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 184L, spotblend);
      } else {
         this.__io__block.writeFloat(this.__io__address + 160L, spotblend);
      }

   }

   public float getHaint() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 188L) : this.__io__block.readFloat(this.__io__address + 164L);
   }

   public void setHaint(float haint) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 188L, haint);
      } else {
         this.__io__block.writeFloat(this.__io__address + 164L, haint);
      }

   }

   public float getAtt1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 192L) : this.__io__block.readFloat(this.__io__address + 168L);
   }

   public void setAtt1(float att1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 192L, att1);
      } else {
         this.__io__block.writeFloat(this.__io__address + 168L, att1);
      }

   }

   public float getAtt2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 196L) : this.__io__block.readFloat(this.__io__address + 172L);
   }

   public void setAtt2(float att2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 196L, att2);
      } else {
         this.__io__block.writeFloat(this.__io__address + 172L, att2);
      }

   }

   public float getCoeff_const() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 200L) : this.__io__block.readFloat(this.__io__address + 176L);
   }

   public void setCoeff_const(float coeff_const) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 200L, coeff_const);
      } else {
         this.__io__block.writeFloat(this.__io__address + 176L, coeff_const);
      }

   }

   public float getCoeff_lin() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 204L) : this.__io__block.readFloat(this.__io__address + 180L);
   }

   public void setCoeff_lin(float coeff_lin) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 204L, coeff_lin);
      } else {
         this.__io__block.writeFloat(this.__io__address + 180L, coeff_lin);
      }

   }

   public float getCoeff_quad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 208L) : this.__io__block.readFloat(this.__io__address + 184L);
   }

   public void setCoeff_quad(float coeff_quad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 208L, coeff_quad);
      } else {
         this.__io__block.writeFloat(this.__io__address + 184L, coeff_quad);
      }

   }

   public float getCoeff_pad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 212L) : this.__io__block.readFloat(this.__io__address + 188L);
   }

   public void setCoeff_pad(float coeff_pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 212L, coeff_pad);
      } else {
         this.__io__block.writeFloat(this.__io__address + 188L, coeff_pad);
      }

   }

   public CPointer<CurveMapping> getCurfalloff() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 216L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 192L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{CurveMapping.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 461), this.__io__blockTable);
   }

   public void setCurfalloff(CPointer<CurveMapping> curfalloff) throws IOException {
      long __address = curfalloff == null ? 0L : curfalloff.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 216L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 192L, __address);
      }

   }

   public short getFalloff_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 224L) : this.__io__block.readShort(this.__io__address + 196L);
   }

   public void setFalloff_type(short falloff_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 224L, falloff_type);
      } else {
         this.__io__block.writeShort(this.__io__address + 196L, falloff_type);
      }

   }

   public short getPad2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 226L) : this.__io__block.readShort(this.__io__address + 198L);
   }

   public void setPad2(short pad2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 226L, pad2);
      } else {
         this.__io__block.writeShort(this.__io__address + 198L, pad2);
      }

   }

   public float getClipsta() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 228L) : this.__io__block.readFloat(this.__io__address + 200L);
   }

   public void setClipsta(float clipsta) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 228L, clipsta);
      } else {
         this.__io__block.writeFloat(this.__io__address + 200L, clipsta);
      }

   }

   public float getClipend() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 232L) : this.__io__block.readFloat(this.__io__address + 204L);
   }

   public void setClipend(float clipend) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 232L, clipend);
      } else {
         this.__io__block.writeFloat(this.__io__address + 204L, clipend);
      }

   }

   public float getBias() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 236L) : this.__io__block.readFloat(this.__io__address + 208L);
   }

   public void setBias(float bias) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 236L, bias);
      } else {
         this.__io__block.writeFloat(this.__io__address + 208L, bias);
      }

   }

   public float getSoft() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 240L) : this.__io__block.readFloat(this.__io__address + 212L);
   }

   public void setSoft(float soft) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 240L, soft);
      } else {
         this.__io__block.writeFloat(this.__io__address + 212L, soft);
      }

   }

   public float getCompressthresh() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 244L) : this.__io__block.readFloat(this.__io__address + 216L);
   }

   public void setCompressthresh(float compressthresh) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 244L, compressthresh);
      } else {
         this.__io__block.writeFloat(this.__io__address + 216L, compressthresh);
      }

   }

   public float getBleedbias() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 248L) : this.__io__block.readFloat(this.__io__address + 220L);
   }

   public void setBleedbias(float bleedbias) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 248L, bleedbias);
      } else {
         this.__io__block.writeFloat(this.__io__address + 220L, bleedbias);
      }

   }

   public float getPad5() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 252L) : this.__io__block.readFloat(this.__io__address + 224L);
   }

   public void setPad5(float pad5) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 252L, pad5);
      } else {
         this.__io__block.writeFloat(this.__io__address + 224L, pad5);
      }

   }

   public short getBufsize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 256L) : this.__io__block.readShort(this.__io__address + 228L);
   }

   public void setBufsize(short bufsize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 256L, bufsize);
      } else {
         this.__io__block.writeShort(this.__io__address + 228L, bufsize);
      }

   }

   public short getSamp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 258L) : this.__io__block.readShort(this.__io__address + 230L);
   }

   public void setSamp(short samp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 258L, samp);
      } else {
         this.__io__block.writeShort(this.__io__address + 230L, samp);
      }

   }

   public short getBuffers() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 260L) : this.__io__block.readShort(this.__io__address + 232L);
   }

   public void setBuffers(short buffers) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 260L, buffers);
      } else {
         this.__io__block.writeShort(this.__io__address + 232L, buffers);
      }

   }

   public short getFiltertype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 262L) : this.__io__block.readShort(this.__io__address + 234L);
   }

   public void setFiltertype(short filtertype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 262L, filtertype);
      } else {
         this.__io__block.writeShort(this.__io__address + 234L, filtertype);
      }

   }

   public byte getBufflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 264L) : this.__io__block.readByte(this.__io__address + 236L);
   }

   public void setBufflag(byte bufflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 264L, bufflag);
      } else {
         this.__io__block.writeByte(this.__io__address + 236L, bufflag);
      }

   }

   public byte getBuftype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 265L) : this.__io__block.readByte(this.__io__address + 237L);
   }

   public void setBuftype(byte buftype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 265L, buftype);
      } else {
         this.__io__block.writeByte(this.__io__address + 237L, buftype);
      }

   }

   public short getRay_samp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 266L) : this.__io__block.readShort(this.__io__address + 238L);
   }

   public void setRay_samp(short ray_samp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 266L, ray_samp);
      } else {
         this.__io__block.writeShort(this.__io__address + 238L, ray_samp);
      }

   }

   public short getRay_sampy() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 268L) : this.__io__block.readShort(this.__io__address + 240L);
   }

   public void setRay_sampy(short ray_sampy) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 268L, ray_sampy);
      } else {
         this.__io__block.writeShort(this.__io__address + 240L, ray_sampy);
      }

   }

   public short getRay_sampz() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 270L) : this.__io__block.readShort(this.__io__address + 242L);
   }

   public void setRay_sampz(short ray_sampz) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 270L, ray_sampz);
      } else {
         this.__io__block.writeShort(this.__io__address + 242L, ray_sampz);
      }

   }

   public short getRay_samp_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 272L) : this.__io__block.readShort(this.__io__address + 244L);
   }

   public void setRay_samp_type(short ray_samp_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 272L, ray_samp_type);
      } else {
         this.__io__block.writeShort(this.__io__address + 244L, ray_samp_type);
      }

   }

   public short getArea_shape() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 274L) : this.__io__block.readShort(this.__io__address + 246L);
   }

   public void setArea_shape(short area_shape) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 274L, area_shape);
      } else {
         this.__io__block.writeShort(this.__io__address + 246L, area_shape);
      }

   }

   public float getArea_size() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 276L) : this.__io__block.readFloat(this.__io__address + 248L);
   }

   public void setArea_size(float area_size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 276L, area_size);
      } else {
         this.__io__block.writeFloat(this.__io__address + 248L, area_size);
      }

   }

   public float getArea_sizey() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 280L) : this.__io__block.readFloat(this.__io__address + 252L);
   }

   public void setArea_sizey(float area_sizey) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 280L, area_sizey);
      } else {
         this.__io__block.writeFloat(this.__io__address + 252L, area_sizey);
      }

   }

   public float getArea_sizez() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 284L) : this.__io__block.readFloat(this.__io__address + 256L);
   }

   public void setArea_sizez(float area_sizez) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 284L, area_sizez);
      } else {
         this.__io__block.writeFloat(this.__io__address + 256L, area_sizez);
      }

   }

   public float getAdapt_thresh() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 288L) : this.__io__block.readFloat(this.__io__address + 260L);
   }

   public void setAdapt_thresh(float adapt_thresh) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 288L, adapt_thresh);
      } else {
         this.__io__block.writeFloat(this.__io__address + 260L, adapt_thresh);
      }

   }

   public short getRay_samp_method() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 292L) : this.__io__block.readShort(this.__io__address + 264L);
   }

   public void setRay_samp_method(short ray_samp_method) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 292L, ray_samp_method);
      } else {
         this.__io__block.writeShort(this.__io__address + 264L, ray_samp_method);
      }

   }

   public short getShadowmap_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 294L) : this.__io__block.readShort(this.__io__address + 266L);
   }

   public void setShadowmap_type(short shadowmap_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 294L, shadowmap_type);
      } else {
         this.__io__block.writeShort(this.__io__address + 266L, shadowmap_type);
      }

   }

   public short getTexact() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 296L) : this.__io__block.readShort(this.__io__address + 268L);
   }

   public void setTexact(short texact) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 296L, texact);
      } else {
         this.__io__block.writeShort(this.__io__address + 268L, texact);
      }

   }

   public short getShadhalostep() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 298L) : this.__io__block.readShort(this.__io__address + 270L);
   }

   public void setShadhalostep(short shadhalostep) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 298L, shadhalostep);
      } else {
         this.__io__block.writeShort(this.__io__address + 270L, shadhalostep);
      }

   }

   public short getSun_effect_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 300L) : this.__io__block.readShort(this.__io__address + 272L);
   }

   public void setSun_effect_type(short sun_effect_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 300L, sun_effect_type);
      } else {
         this.__io__block.writeShort(this.__io__address + 272L, sun_effect_type);
      }

   }

   public short getSkyblendtype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 302L) : this.__io__block.readShort(this.__io__address + 274L);
   }

   public void setSkyblendtype(short skyblendtype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 302L, skyblendtype);
      } else {
         this.__io__block.writeShort(this.__io__address + 274L, skyblendtype);
      }

   }

   public float getHorizon_brightness() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 304L) : this.__io__block.readFloat(this.__io__address + 276L);
   }

   public void setHorizon_brightness(float horizon_brightness) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 304L, horizon_brightness);
      } else {
         this.__io__block.writeFloat(this.__io__address + 276L, horizon_brightness);
      }

   }

   public float getSpread() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 308L) : this.__io__block.readFloat(this.__io__address + 280L);
   }

   public void setSpread(float spread) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 308L, spread);
      } else {
         this.__io__block.writeFloat(this.__io__address + 280L, spread);
      }

   }

   public float getSun_brightness() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 312L) : this.__io__block.readFloat(this.__io__address + 284L);
   }

   public void setSun_brightness(float sun_brightness) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 312L, sun_brightness);
      } else {
         this.__io__block.writeFloat(this.__io__address + 284L, sun_brightness);
      }

   }

   public float getSun_size() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 316L) : this.__io__block.readFloat(this.__io__address + 288L);
   }

   public void setSun_size(float sun_size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 316L, sun_size);
      } else {
         this.__io__block.writeFloat(this.__io__address + 288L, sun_size);
      }

   }

   public float getBackscattered_light() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 320L) : this.__io__block.readFloat(this.__io__address + 292L);
   }

   public void setBackscattered_light(float backscattered_light) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 320L, backscattered_light);
      } else {
         this.__io__block.writeFloat(this.__io__address + 292L, backscattered_light);
      }

   }

   public float getSun_intensity() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 324L) : this.__io__block.readFloat(this.__io__address + 296L);
   }

   public void setSun_intensity(float sun_intensity) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 324L, sun_intensity);
      } else {
         this.__io__block.writeFloat(this.__io__address + 296L, sun_intensity);
      }

   }

   public float getAtm_turbidity() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 328L) : this.__io__block.readFloat(this.__io__address + 300L);
   }

   public void setAtm_turbidity(float atm_turbidity) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 328L, atm_turbidity);
      } else {
         this.__io__block.writeFloat(this.__io__address + 300L, atm_turbidity);
      }

   }

   public float getAtm_inscattering_factor() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 332L) : this.__io__block.readFloat(this.__io__address + 304L);
   }

   public void setAtm_inscattering_factor(float atm_inscattering_factor) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 332L, atm_inscattering_factor);
      } else {
         this.__io__block.writeFloat(this.__io__address + 304L, atm_inscattering_factor);
      }

   }

   public float getAtm_extinction_factor() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 336L) : this.__io__block.readFloat(this.__io__address + 308L);
   }

   public void setAtm_extinction_factor(float atm_extinction_factor) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 336L, atm_extinction_factor);
      } else {
         this.__io__block.writeFloat(this.__io__address + 308L, atm_extinction_factor);
      }

   }

   public float getAtm_distance_factor() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 340L) : this.__io__block.readFloat(this.__io__address + 312L);
   }

   public void setAtm_distance_factor(float atm_distance_factor) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 340L, atm_distance_factor);
      } else {
         this.__io__block.writeFloat(this.__io__address + 312L, atm_distance_factor);
      }

   }

   public float getSkyblendfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 344L) : this.__io__block.readFloat(this.__io__address + 316L);
   }

   public void setSkyblendfac(float skyblendfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 344L, skyblendfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 316L, skyblendfac);
      }

   }

   public float getSky_exposure() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 348L) : this.__io__block.readFloat(this.__io__address + 320L);
   }

   public void setSky_exposure(float sky_exposure) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 348L, sky_exposure);
      } else {
         this.__io__block.writeFloat(this.__io__address + 320L, sky_exposure);
      }

   }

   public float getShadow_frustum_size() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 352L) : this.__io__block.readFloat(this.__io__address + 324L);
   }

   public void setShadow_frustum_size(float shadow_frustum_size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 352L, shadow_frustum_size);
      } else {
         this.__io__block.writeFloat(this.__io__address + 324L, shadow_frustum_size);
      }

   }

   public short getSky_colorspace() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 356L) : this.__io__block.readShort(this.__io__address + 328L);
   }

   public void setSky_colorspace(short sky_colorspace) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 356L, sky_colorspace);
      } else {
         this.__io__block.writeShort(this.__io__address + 328L, sky_colorspace);
      }

   }

   public CArrayFacade<Byte> getPad4() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 358L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 330L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad4(CArrayFacade<Byte> pad4) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 358L;
      } else {
         __dna__offset = 330L;
      }

      if (!this.__io__equals(pad4, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad4)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad4);
         } else {
            __io__generic__copy(this.getPad4(), pad4);
         }

      }
   }

   public CPointer<Ipo> getIpo() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 360L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 332L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Ipo.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 15), this.__io__blockTable);
   }

   public void setIpo(CPointer<Ipo> ipo) throws IOException {
      long __address = ipo == null ? 0L : ipo.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 360L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 332L, __address);
      }

   }

   public CArrayFacade<CPointer<MTex>> getMtex() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CPointer.class, MTex.class};
      int[] __dna__dimensions = new int[]{18};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 368L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 336L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setMtex(CArrayFacade<CPointer<MTex>> mtex) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 368L;
      } else {
         __dna__offset = 336L;
      }

      if (!this.__io__equals(mtex, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, mtex)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, mtex);
         } else {
            __io__generic__copy(this.getMtex(), mtex);
         }

      }
   }

   public short getPr_texture() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 512L) : this.__io__block.readShort(this.__io__address + 408L);
   }

   public void setPr_texture(short pr_texture) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 512L, pr_texture);
      } else {
         this.__io__block.writeShort(this.__io__address + 408L, pr_texture);
      }

   }

   public short getUse_nodes() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 514L) : this.__io__block.readShort(this.__io__address + 410L);
   }

   public void setUse_nodes(short use_nodes) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 514L, use_nodes);
      } else {
         this.__io__block.writeShort(this.__io__address + 410L, use_nodes);
      }

   }

   public CArrayFacade<Byte> getPad6() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 516L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 412L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad6(CArrayFacade<Byte> pad6) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 516L;
      } else {
         __dna__offset = 412L;
      }

      if (!this.__io__equals(pad6, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad6)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad6);
         } else {
            __io__generic__copy(this.getPad6(), pad6);
         }

      }
   }

   public CPointer<PreviewImage> getPreview() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 520L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 416L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PreviewImage.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 12), this.__io__blockTable);
   }

   public void setPreview(CPointer<PreviewImage> preview) throws IOException {
      long __address = preview == null ? 0L : preview.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 520L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 416L, __address);
      }

   }

   public CPointer<bNodeTree> getNodetree() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 528L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 420L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bNodeTree.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 397), this.__io__blockTable);
   }

   public void setNodetree(CPointer<bNodeTree> nodetree) throws IOException {
      long __address = nodetree == null ? 0L : nodetree.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 528L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 420L, __address);
      }

   }

   public CPointer<Lamp> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Lamp.class}, this.__io__block, this.__io__blockTable);
   }
}
