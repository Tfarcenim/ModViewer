package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 1396L,
   size64 = 1528L
)
public class Material extends CFacade {
   public static final int __DNA__SDNA_INDEX = 46;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__adt = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__material_type = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__flag = new long[]{106L, 130L};
   public static final long[] __DNA__FIELD__r = new long[]{108L, 132L};
   public static final long[] __DNA__FIELD__g = new long[]{112L, 136L};
   public static final long[] __DNA__FIELD__b = new long[]{116L, 140L};
   public static final long[] __DNA__FIELD__specr = new long[]{120L, 144L};
   public static final long[] __DNA__FIELD__specg = new long[]{124L, 148L};
   public static final long[] __DNA__FIELD__specb = new long[]{128L, 152L};
   public static final long[] __DNA__FIELD__mirr = new long[]{132L, 156L};
   public static final long[] __DNA__FIELD__mirg = new long[]{136L, 160L};
   public static final long[] __DNA__FIELD__mirb = new long[]{140L, 164L};
   public static final long[] __DNA__FIELD__ambr = new long[]{144L, 168L};
   public static final long[] __DNA__FIELD__ambb = new long[]{148L, 172L};
   public static final long[] __DNA__FIELD__ambg = new long[]{152L, 176L};
   public static final long[] __DNA__FIELD__amb = new long[]{156L, 180L};
   public static final long[] __DNA__FIELD__emit = new long[]{160L, 184L};
   public static final long[] __DNA__FIELD__ang = new long[]{164L, 188L};
   public static final long[] __DNA__FIELD__spectra = new long[]{168L, 192L};
   public static final long[] __DNA__FIELD__ray_mirror = new long[]{172L, 196L};
   public static final long[] __DNA__FIELD__alpha = new long[]{176L, 200L};
   public static final long[] __DNA__FIELD__ref = new long[]{180L, 204L};
   public static final long[] __DNA__FIELD__spec = new long[]{184L, 208L};
   public static final long[] __DNA__FIELD__zoffs = new long[]{188L, 212L};
   public static final long[] __DNA__FIELD__add = new long[]{192L, 216L};
   public static final long[] __DNA__FIELD__translucency = new long[]{196L, 220L};
   public static final long[] __DNA__FIELD__vol = new long[]{200L, 224L};
   public static final long[] __DNA__FIELD__game = new long[]{288L, 312L};
   public static final long[] __DNA__FIELD__fresnel_mir = new long[]{304L, 328L};
   public static final long[] __DNA__FIELD__fresnel_mir_i = new long[]{308L, 332L};
   public static final long[] __DNA__FIELD__fresnel_tra = new long[]{312L, 336L};
   public static final long[] __DNA__FIELD__fresnel_tra_i = new long[]{316L, 340L};
   public static final long[] __DNA__FIELD__filter = new long[]{320L, 344L};
   public static final long[] __DNA__FIELD__tx_limit = new long[]{324L, 348L};
   public static final long[] __DNA__FIELD__tx_falloff = new long[]{328L, 352L};
   public static final long[] __DNA__FIELD__ray_depth = new long[]{332L, 356L};
   public static final long[] __DNA__FIELD__ray_depth_tra = new long[]{334L, 358L};
   public static final long[] __DNA__FIELD__har = new long[]{336L, 360L};
   public static final long[] __DNA__FIELD__seed1 = new long[]{338L, 362L};
   public static final long[] __DNA__FIELD__seed2 = new long[]{339L, 363L};
   public static final long[] __DNA__FIELD__gloss_mir = new long[]{340L, 364L};
   public static final long[] __DNA__FIELD__gloss_tra = new long[]{344L, 368L};
   public static final long[] __DNA__FIELD__samp_gloss_mir = new long[]{348L, 372L};
   public static final long[] __DNA__FIELD__samp_gloss_tra = new long[]{350L, 374L};
   public static final long[] __DNA__FIELD__adapt_thresh_mir = new long[]{352L, 376L};
   public static final long[] __DNA__FIELD__adapt_thresh_tra = new long[]{356L, 380L};
   public static final long[] __DNA__FIELD__aniso_gloss_mir = new long[]{360L, 384L};
   public static final long[] __DNA__FIELD__dist_mir = new long[]{364L, 388L};
   public static final long[] __DNA__FIELD__fadeto_mir = new long[]{368L, 392L};
   public static final long[] __DNA__FIELD__shade_flag = new long[]{370L, 394L};
   public static final long[] __DNA__FIELD__mode = new long[]{372L, 396L};
   public static final long[] __DNA__FIELD__mode_l = new long[]{376L, 400L};
   public static final long[] __DNA__FIELD__mode2 = new long[]{380L, 404L};
   public static final long[] __DNA__FIELD__mode2_l = new long[]{384L, 408L};
   public static final long[] __DNA__FIELD__flarec = new long[]{388L, 412L};
   public static final long[] __DNA__FIELD__starc = new long[]{390L, 414L};
   public static final long[] __DNA__FIELD__linec = new long[]{392L, 416L};
   public static final long[] __DNA__FIELD__ringc = new long[]{394L, 418L};
   public static final long[] __DNA__FIELD__hasize = new long[]{396L, 420L};
   public static final long[] __DNA__FIELD__flaresize = new long[]{400L, 424L};
   public static final long[] __DNA__FIELD__subsize = new long[]{404L, 428L};
   public static final long[] __DNA__FIELD__flareboost = new long[]{408L, 432L};
   public static final long[] __DNA__FIELD__strand_sta = new long[]{412L, 436L};
   public static final long[] __DNA__FIELD__strand_end = new long[]{416L, 440L};
   public static final long[] __DNA__FIELD__strand_ease = new long[]{420L, 444L};
   public static final long[] __DNA__FIELD__strand_surfnor = new long[]{424L, 448L};
   public static final long[] __DNA__FIELD__strand_min = new long[]{428L, 452L};
   public static final long[] __DNA__FIELD__strand_widthfade = new long[]{432L, 456L};
   public static final long[] __DNA__FIELD__strand_uvname = new long[]{436L, 460L};
   public static final long[] __DNA__FIELD__sbias = new long[]{500L, 524L};
   public static final long[] __DNA__FIELD__lbias = new long[]{504L, 528L};
   public static final long[] __DNA__FIELD__shad_alpha = new long[]{508L, 532L};
   public static final long[] __DNA__FIELD__septex = new long[]{512L, 536L};
   public static final long[] __DNA__FIELD__rgbsel = new long[]{516L, 540L};
   public static final long[] __DNA__FIELD__texact = new long[]{517L, 541L};
   public static final long[] __DNA__FIELD__pr_type = new long[]{518L, 542L};
   public static final long[] __DNA__FIELD__use_nodes = new long[]{519L, 543L};
   public static final long[] __DNA__FIELD__pr_lamp = new long[]{520L, 544L};
   public static final long[] __DNA__FIELD__pr_texture = new long[]{522L, 546L};
   public static final long[] __DNA__FIELD__ml_flag = new long[]{524L, 548L};
   public static final long[] __DNA__FIELD__mapflag = new long[]{526L, 550L};
   public static final long[] __DNA__FIELD__pad = new long[]{527L, 551L};
   public static final long[] __DNA__FIELD__diff_shader = new long[]{528L, 552L};
   public static final long[] __DNA__FIELD__spec_shader = new long[]{530L, 554L};
   public static final long[] __DNA__FIELD__roughness = new long[]{532L, 556L};
   public static final long[] __DNA__FIELD__refrac = new long[]{536L, 560L};
   public static final long[] __DNA__FIELD__param = new long[]{540L, 564L};
   public static final long[] __DNA__FIELD__rms = new long[]{556L, 580L};
   public static final long[] __DNA__FIELD__darkness = new long[]{560L, 584L};
   public static final long[] __DNA__FIELD__texco = new long[]{564L, 588L};
   public static final long[] __DNA__FIELD__mapto = new long[]{566L, 590L};
   public static final long[] __DNA__FIELD__ramp_col = new long[]{568L, 592L};
   public static final long[] __DNA__FIELD__ramp_spec = new long[]{572L, 600L};
   public static final long[] __DNA__FIELD__rampin_col = new long[]{576L, 608L};
   public static final long[] __DNA__FIELD__rampin_spec = new long[]{577L, 609L};
   public static final long[] __DNA__FIELD__rampblend_col = new long[]{578L, 610L};
   public static final long[] __DNA__FIELD__rampblend_spec = new long[]{579L, 611L};
   public static final long[] __DNA__FIELD__ramp_show = new long[]{580L, 612L};
   public static final long[] __DNA__FIELD__pad3 = new long[]{582L, 614L};
   public static final long[] __DNA__FIELD__rampfac_col = new long[]{584L, 616L};
   public static final long[] __DNA__FIELD__rampfac_spec = new long[]{588L, 620L};
   public static final long[] __DNA__FIELD__mtex = new long[]{592L, 624L};
   public static final long[] __DNA__FIELD__nodetree = new long[]{664L, 768L};
   public static final long[] __DNA__FIELD__ipo = new long[]{668L, 776L};
   public static final long[] __DNA__FIELD__group = new long[]{672L, 784L};
   public static final long[] __DNA__FIELD__preview = new long[]{676L, 792L};
   public static final long[] __DNA__FIELD__friction = new long[]{680L, 800L};
   public static final long[] __DNA__FIELD__fh = new long[]{684L, 804L};
   public static final long[] __DNA__FIELD__reflect = new long[]{688L, 808L};
   public static final long[] __DNA__FIELD__fhdist = new long[]{692L, 812L};
   public static final long[] __DNA__FIELD__xyfrict = new long[]{696L, 816L};
   public static final long[] __DNA__FIELD__dynamode = new long[]{700L, 820L};
   public static final long[] __DNA__FIELD__pad2 = new long[]{702L, 822L};
   public static final long[] __DNA__FIELD__sss_radius = new long[]{704L, 824L};
   public static final long[] __DNA__FIELD__sss_col = new long[]{716L, 836L};
   public static final long[] __DNA__FIELD__sss_error = new long[]{728L, 848L};
   public static final long[] __DNA__FIELD__sss_scale = new long[]{732L, 852L};
   public static final long[] __DNA__FIELD__sss_ior = new long[]{736L, 856L};
   public static final long[] __DNA__FIELD__sss_colfac = new long[]{740L, 860L};
   public static final long[] __DNA__FIELD__sss_texfac = new long[]{744L, 864L};
   public static final long[] __DNA__FIELD__sss_front = new long[]{748L, 868L};
   public static final long[] __DNA__FIELD__sss_back = new long[]{752L, 872L};
   public static final long[] __DNA__FIELD__sss_flag = new long[]{756L, 876L};
   public static final long[] __DNA__FIELD__sss_preset = new long[]{758L, 878L};
   public static final long[] __DNA__FIELD__mapto_textured = new long[]{760L, 880L};
   public static final long[] __DNA__FIELD__shadowonly_flag = new long[]{764L, 884L};
   public static final long[] __DNA__FIELD__index = new long[]{766L, 886L};
   public static final long[] __DNA__FIELD__line_col = new long[]{768L, 888L};
   public static final long[] __DNA__FIELD__line_priority = new long[]{784L, 904L};
   public static final long[] __DNA__FIELD__vcol_alpha = new long[]{786L, 906L};
   public static final long[] __DNA__FIELD__paint_active_slot = new long[]{788L, 908L};
   public static final long[] __DNA__FIELD__paint_clone_slot = new long[]{790L, 910L};
   public static final long[] __DNA__FIELD__tot_slots = new long[]{792L, 912L};
   public static final long[] __DNA__FIELD__pad4 = new long[]{794L, 914L};
   public static final long[] __DNA__FIELD__nmap_tangent_names = new long[]{800L, 920L};
   public static final long[] __DNA__FIELD__nmap_tangent_names_count = new long[]{1376L, 1496L};
   public static final long[] __DNA__FIELD__pad5 = new long[]{1380L, 1500L};
   public static final long[] __DNA__FIELD__texpaintslot = new long[]{1384L, 1504L};
   public static final long[] __DNA__FIELD__gpumaterial = new long[]{1388L, 1512L};

   public Material(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Material(Material that) {
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

   public short getMaterial_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 128L) : this.__io__block.readShort(this.__io__address + 104L);
   }

   public void setMaterial_type(short material_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 128L, material_type);
      } else {
         this.__io__block.writeShort(this.__io__address + 104L, material_type);
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

   public float getR() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 132L) : this.__io__block.readFloat(this.__io__address + 108L);
   }

   public void setR(float r) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 132L, r);
      } else {
         this.__io__block.writeFloat(this.__io__address + 108L, r);
      }

   }

   public float getG() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 136L) : this.__io__block.readFloat(this.__io__address + 112L);
   }

   public void setG(float g) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 136L, g);
      } else {
         this.__io__block.writeFloat(this.__io__address + 112L, g);
      }

   }

   public float getB() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 140L) : this.__io__block.readFloat(this.__io__address + 116L);
   }

   public void setB(float b) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 140L, b);
      } else {
         this.__io__block.writeFloat(this.__io__address + 116L, b);
      }

   }

   public float getSpecr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 144L) : this.__io__block.readFloat(this.__io__address + 120L);
   }

   public void setSpecr(float specr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 144L, specr);
      } else {
         this.__io__block.writeFloat(this.__io__address + 120L, specr);
      }

   }

   public float getSpecg() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 148L) : this.__io__block.readFloat(this.__io__address + 124L);
   }

   public void setSpecg(float specg) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 148L, specg);
      } else {
         this.__io__block.writeFloat(this.__io__address + 124L, specg);
      }

   }

   public float getSpecb() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 152L) : this.__io__block.readFloat(this.__io__address + 128L);
   }

   public void setSpecb(float specb) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 152L, specb);
      } else {
         this.__io__block.writeFloat(this.__io__address + 128L, specb);
      }

   }

   public float getMirr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 156L) : this.__io__block.readFloat(this.__io__address + 132L);
   }

   public void setMirr(float mirr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 156L, mirr);
      } else {
         this.__io__block.writeFloat(this.__io__address + 132L, mirr);
      }

   }

   public float getMirg() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 160L) : this.__io__block.readFloat(this.__io__address + 136L);
   }

   public void setMirg(float mirg) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 160L, mirg);
      } else {
         this.__io__block.writeFloat(this.__io__address + 136L, mirg);
      }

   }

   public float getMirb() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 164L) : this.__io__block.readFloat(this.__io__address + 140L);
   }

   public void setMirb(float mirb) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 164L, mirb);
      } else {
         this.__io__block.writeFloat(this.__io__address + 140L, mirb);
      }

   }

   public float getAmbr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 168L) : this.__io__block.readFloat(this.__io__address + 144L);
   }

   public void setAmbr(float ambr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 168L, ambr);
      } else {
         this.__io__block.writeFloat(this.__io__address + 144L, ambr);
      }

   }

   public float getAmbb() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 172L) : this.__io__block.readFloat(this.__io__address + 148L);
   }

   public void setAmbb(float ambb) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 172L, ambb);
      } else {
         this.__io__block.writeFloat(this.__io__address + 148L, ambb);
      }

   }

   public float getAmbg() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 176L) : this.__io__block.readFloat(this.__io__address + 152L);
   }

   public void setAmbg(float ambg) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 176L, ambg);
      } else {
         this.__io__block.writeFloat(this.__io__address + 152L, ambg);
      }

   }

   public float getAmb() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 180L) : this.__io__block.readFloat(this.__io__address + 156L);
   }

   public void setAmb(float amb) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 180L, amb);
      } else {
         this.__io__block.writeFloat(this.__io__address + 156L, amb);
      }

   }

   public float getEmit() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 184L) : this.__io__block.readFloat(this.__io__address + 160L);
   }

   public void setEmit(float emit) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 184L, emit);
      } else {
         this.__io__block.writeFloat(this.__io__address + 160L, emit);
      }

   }

   public float getAng() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 188L) : this.__io__block.readFloat(this.__io__address + 164L);
   }

   public void setAng(float ang) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 188L, ang);
      } else {
         this.__io__block.writeFloat(this.__io__address + 164L, ang);
      }

   }

   public float getSpectra() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 192L) : this.__io__block.readFloat(this.__io__address + 168L);
   }

   public void setSpectra(float spectra) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 192L, spectra);
      } else {
         this.__io__block.writeFloat(this.__io__address + 168L, spectra);
      }

   }

   public float getRay_mirror() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 196L) : this.__io__block.readFloat(this.__io__address + 172L);
   }

   public void setRay_mirror(float ray_mirror) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 196L, ray_mirror);
      } else {
         this.__io__block.writeFloat(this.__io__address + 172L, ray_mirror);
      }

   }

   public float getAlpha() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 200L) : this.__io__block.readFloat(this.__io__address + 176L);
   }

   public void setAlpha(float alpha) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 200L, alpha);
      } else {
         this.__io__block.writeFloat(this.__io__address + 176L, alpha);
      }

   }

   public float getRef() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 204L) : this.__io__block.readFloat(this.__io__address + 180L);
   }

   public void setRef(float ref) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 204L, ref);
      } else {
         this.__io__block.writeFloat(this.__io__address + 180L, ref);
      }

   }

   public float getSpec() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 208L) : this.__io__block.readFloat(this.__io__address + 184L);
   }

   public void setSpec(float spec) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 208L, spec);
      } else {
         this.__io__block.writeFloat(this.__io__address + 184L, spec);
      }

   }

   public float getZoffs() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 212L) : this.__io__block.readFloat(this.__io__address + 188L);
   }

   public void setZoffs(float zoffs) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 212L, zoffs);
      } else {
         this.__io__block.writeFloat(this.__io__address + 188L, zoffs);
      }

   }

   public float getAdd() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 216L) : this.__io__block.readFloat(this.__io__address + 192L);
   }

   public void setAdd(float add) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 216L, add);
      } else {
         this.__io__block.writeFloat(this.__io__address + 192L, add);
      }

   }

   public float getTranslucency() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 220L) : this.__io__block.readFloat(this.__io__address + 196L);
   }

   public void setTranslucency(float translucency) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 220L, translucency);
      } else {
         this.__io__block.writeFloat(this.__io__address + 196L, translucency);
      }

   }

   public VolumeSettings getVol() throws IOException {
      return this.__io__pointersize == 8 ? new VolumeSettings(this.__io__address + 224L, this.__io__block, this.__io__blockTable) : new VolumeSettings(this.__io__address + 200L, this.__io__block, this.__io__blockTable);
   }

   public void setVol(VolumeSettings vol) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 224L;
      } else {
         __dna__offset = 200L;
      }

      if (!this.__io__equals(vol, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, vol)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, vol);
         } else {
            __io__generic__copy(this.getVol(), vol);
         }

      }
   }

   public GameSettings getGame() throws IOException {
      return this.__io__pointersize == 8 ? new GameSettings(this.__io__address + 312L, this.__io__block, this.__io__blockTable) : new GameSettings(this.__io__address + 288L, this.__io__block, this.__io__blockTable);
   }

   public void setGame(GameSettings game) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 312L;
      } else {
         __dna__offset = 288L;
      }

      if (!this.__io__equals(game, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, game)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, game);
         } else {
            __io__generic__copy(this.getGame(), game);
         }

      }
   }

   public float getFresnel_mir() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 328L) : this.__io__block.readFloat(this.__io__address + 304L);
   }

   public void setFresnel_mir(float fresnel_mir) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 328L, fresnel_mir);
      } else {
         this.__io__block.writeFloat(this.__io__address + 304L, fresnel_mir);
      }

   }

   public float getFresnel_mir_i() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 332L) : this.__io__block.readFloat(this.__io__address + 308L);
   }

   public void setFresnel_mir_i(float fresnel_mir_i) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 332L, fresnel_mir_i);
      } else {
         this.__io__block.writeFloat(this.__io__address + 308L, fresnel_mir_i);
      }

   }

   public float getFresnel_tra() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 336L) : this.__io__block.readFloat(this.__io__address + 312L);
   }

   public void setFresnel_tra(float fresnel_tra) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 336L, fresnel_tra);
      } else {
         this.__io__block.writeFloat(this.__io__address + 312L, fresnel_tra);
      }

   }

   public float getFresnel_tra_i() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 340L) : this.__io__block.readFloat(this.__io__address + 316L);
   }

   public void setFresnel_tra_i(float fresnel_tra_i) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 340L, fresnel_tra_i);
      } else {
         this.__io__block.writeFloat(this.__io__address + 316L, fresnel_tra_i);
      }

   }

   public float getFilter() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 344L) : this.__io__block.readFloat(this.__io__address + 320L);
   }

   public void setFilter(float filter) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 344L, filter);
      } else {
         this.__io__block.writeFloat(this.__io__address + 320L, filter);
      }

   }

   public float getTx_limit() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 348L) : this.__io__block.readFloat(this.__io__address + 324L);
   }

   public void setTx_limit(float tx_limit) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 348L, tx_limit);
      } else {
         this.__io__block.writeFloat(this.__io__address + 324L, tx_limit);
      }

   }

   public float getTx_falloff() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 352L) : this.__io__block.readFloat(this.__io__address + 328L);
   }

   public void setTx_falloff(float tx_falloff) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 352L, tx_falloff);
      } else {
         this.__io__block.writeFloat(this.__io__address + 328L, tx_falloff);
      }

   }

   public short getRay_depth() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 356L) : this.__io__block.readShort(this.__io__address + 332L);
   }

   public void setRay_depth(short ray_depth) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 356L, ray_depth);
      } else {
         this.__io__block.writeShort(this.__io__address + 332L, ray_depth);
      }

   }

   public short getRay_depth_tra() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 358L) : this.__io__block.readShort(this.__io__address + 334L);
   }

   public void setRay_depth_tra(short ray_depth_tra) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 358L, ray_depth_tra);
      } else {
         this.__io__block.writeShort(this.__io__address + 334L, ray_depth_tra);
      }

   }

   public short getHar() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 360L) : this.__io__block.readShort(this.__io__address + 336L);
   }

   public void setHar(short har) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 360L, har);
      } else {
         this.__io__block.writeShort(this.__io__address + 336L, har);
      }

   }

   public byte getSeed1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 362L) : this.__io__block.readByte(this.__io__address + 338L);
   }

   public void setSeed1(byte seed1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 362L, seed1);
      } else {
         this.__io__block.writeByte(this.__io__address + 338L, seed1);
      }

   }

   public byte getSeed2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 363L) : this.__io__block.readByte(this.__io__address + 339L);
   }

   public void setSeed2(byte seed2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 363L, seed2);
      } else {
         this.__io__block.writeByte(this.__io__address + 339L, seed2);
      }

   }

   public float getGloss_mir() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 364L) : this.__io__block.readFloat(this.__io__address + 340L);
   }

   public void setGloss_mir(float gloss_mir) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 364L, gloss_mir);
      } else {
         this.__io__block.writeFloat(this.__io__address + 340L, gloss_mir);
      }

   }

   public float getGloss_tra() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 368L) : this.__io__block.readFloat(this.__io__address + 344L);
   }

   public void setGloss_tra(float gloss_tra) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 368L, gloss_tra);
      } else {
         this.__io__block.writeFloat(this.__io__address + 344L, gloss_tra);
      }

   }

   public short getSamp_gloss_mir() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 372L) : this.__io__block.readShort(this.__io__address + 348L);
   }

   public void setSamp_gloss_mir(short samp_gloss_mir) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 372L, samp_gloss_mir);
      } else {
         this.__io__block.writeShort(this.__io__address + 348L, samp_gloss_mir);
      }

   }

   public short getSamp_gloss_tra() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 374L) : this.__io__block.readShort(this.__io__address + 350L);
   }

   public void setSamp_gloss_tra(short samp_gloss_tra) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 374L, samp_gloss_tra);
      } else {
         this.__io__block.writeShort(this.__io__address + 350L, samp_gloss_tra);
      }

   }

   public float getAdapt_thresh_mir() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 376L) : this.__io__block.readFloat(this.__io__address + 352L);
   }

   public void setAdapt_thresh_mir(float adapt_thresh_mir) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 376L, adapt_thresh_mir);
      } else {
         this.__io__block.writeFloat(this.__io__address + 352L, adapt_thresh_mir);
      }

   }

   public float getAdapt_thresh_tra() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 380L) : this.__io__block.readFloat(this.__io__address + 356L);
   }

   public void setAdapt_thresh_tra(float adapt_thresh_tra) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 380L, adapt_thresh_tra);
      } else {
         this.__io__block.writeFloat(this.__io__address + 356L, adapt_thresh_tra);
      }

   }

   public float getAniso_gloss_mir() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 384L) : this.__io__block.readFloat(this.__io__address + 360L);
   }

   public void setAniso_gloss_mir(float aniso_gloss_mir) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 384L, aniso_gloss_mir);
      } else {
         this.__io__block.writeFloat(this.__io__address + 360L, aniso_gloss_mir);
      }

   }

   public float getDist_mir() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 388L) : this.__io__block.readFloat(this.__io__address + 364L);
   }

   public void setDist_mir(float dist_mir) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 388L, dist_mir);
      } else {
         this.__io__block.writeFloat(this.__io__address + 364L, dist_mir);
      }

   }

   public short getFadeto_mir() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 392L) : this.__io__block.readShort(this.__io__address + 368L);
   }

   public void setFadeto_mir(short fadeto_mir) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 392L, fadeto_mir);
      } else {
         this.__io__block.writeShort(this.__io__address + 368L, fadeto_mir);
      }

   }

   public short getShade_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 394L) : this.__io__block.readShort(this.__io__address + 370L);
   }

   public void setShade_flag(short shade_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 394L, shade_flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 370L, shade_flag);
      }

   }

   public int getMode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 396L) : this.__io__block.readInt(this.__io__address + 372L);
   }

   public void setMode(int mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 396L, mode);
      } else {
         this.__io__block.writeInt(this.__io__address + 372L, mode);
      }

   }

   public int getMode_l() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 400L) : this.__io__block.readInt(this.__io__address + 376L);
   }

   public void setMode_l(int mode_l) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 400L, mode_l);
      } else {
         this.__io__block.writeInt(this.__io__address + 376L, mode_l);
      }

   }

   public int getMode2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 404L) : this.__io__block.readInt(this.__io__address + 380L);
   }

   public void setMode2(int mode2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 404L, mode2);
      } else {
         this.__io__block.writeInt(this.__io__address + 380L, mode2);
      }

   }

   public int getMode2_l() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 408L) : this.__io__block.readInt(this.__io__address + 384L);
   }

   public void setMode2_l(int mode2_l) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 408L, mode2_l);
      } else {
         this.__io__block.writeInt(this.__io__address + 384L, mode2_l);
      }

   }

   public short getFlarec() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 412L) : this.__io__block.readShort(this.__io__address + 388L);
   }

   public void setFlarec(short flarec) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 412L, flarec);
      } else {
         this.__io__block.writeShort(this.__io__address + 388L, flarec);
      }

   }

   public short getStarc() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 414L) : this.__io__block.readShort(this.__io__address + 390L);
   }

   public void setStarc(short starc) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 414L, starc);
      } else {
         this.__io__block.writeShort(this.__io__address + 390L, starc);
      }

   }

   public short getLinec() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 416L) : this.__io__block.readShort(this.__io__address + 392L);
   }

   public void setLinec(short linec) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 416L, linec);
      } else {
         this.__io__block.writeShort(this.__io__address + 392L, linec);
      }

   }

   public short getRingc() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 418L) : this.__io__block.readShort(this.__io__address + 394L);
   }

   public void setRingc(short ringc) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 418L, ringc);
      } else {
         this.__io__block.writeShort(this.__io__address + 394L, ringc);
      }

   }

   public float getHasize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 420L) : this.__io__block.readFloat(this.__io__address + 396L);
   }

   public void setHasize(float hasize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 420L, hasize);
      } else {
         this.__io__block.writeFloat(this.__io__address + 396L, hasize);
      }

   }

   public float getFlaresize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 424L) : this.__io__block.readFloat(this.__io__address + 400L);
   }

   public void setFlaresize(float flaresize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 424L, flaresize);
      } else {
         this.__io__block.writeFloat(this.__io__address + 400L, flaresize);
      }

   }

   public float getSubsize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 428L) : this.__io__block.readFloat(this.__io__address + 404L);
   }

   public void setSubsize(float subsize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 428L, subsize);
      } else {
         this.__io__block.writeFloat(this.__io__address + 404L, subsize);
      }

   }

   public float getFlareboost() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 432L) : this.__io__block.readFloat(this.__io__address + 408L);
   }

   public void setFlareboost(float flareboost) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 432L, flareboost);
      } else {
         this.__io__block.writeFloat(this.__io__address + 408L, flareboost);
      }

   }

   public float getStrand_sta() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 436L) : this.__io__block.readFloat(this.__io__address + 412L);
   }

   public void setStrand_sta(float strand_sta) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 436L, strand_sta);
      } else {
         this.__io__block.writeFloat(this.__io__address + 412L, strand_sta);
      }

   }

   public float getStrand_end() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 440L) : this.__io__block.readFloat(this.__io__address + 416L);
   }

   public void setStrand_end(float strand_end) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 440L, strand_end);
      } else {
         this.__io__block.writeFloat(this.__io__address + 416L, strand_end);
      }

   }

   public float getStrand_ease() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 444L) : this.__io__block.readFloat(this.__io__address + 420L);
   }

   public void setStrand_ease(float strand_ease) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 444L, strand_ease);
      } else {
         this.__io__block.writeFloat(this.__io__address + 420L, strand_ease);
      }

   }

   public float getStrand_surfnor() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 448L) : this.__io__block.readFloat(this.__io__address + 424L);
   }

   public void setStrand_surfnor(float strand_surfnor) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 448L, strand_surfnor);
      } else {
         this.__io__block.writeFloat(this.__io__address + 424L, strand_surfnor);
      }

   }

   public float getStrand_min() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 452L) : this.__io__block.readFloat(this.__io__address + 428L);
   }

   public void setStrand_min(float strand_min) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 452L, strand_min);
      } else {
         this.__io__block.writeFloat(this.__io__address + 428L, strand_min);
      }

   }

   public float getStrand_widthfade() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 456L) : this.__io__block.readFloat(this.__io__address + 432L);
   }

   public void setStrand_widthfade(float strand_widthfade) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 456L, strand_widthfade);
      } else {
         this.__io__block.writeFloat(this.__io__address + 432L, strand_widthfade);
      }

   }

   public CArrayFacade<Byte> getStrand_uvname() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 460L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 436L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setStrand_uvname(CArrayFacade<Byte> strand_uvname) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 460L;
      } else {
         __dna__offset = 436L;
      }

      if (!this.__io__equals(strand_uvname, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, strand_uvname)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, strand_uvname);
         } else {
            __io__generic__copy(this.getStrand_uvname(), strand_uvname);
         }

      }
   }

   public float getSbias() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 524L) : this.__io__block.readFloat(this.__io__address + 500L);
   }

   public void setSbias(float sbias) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 524L, sbias);
      } else {
         this.__io__block.writeFloat(this.__io__address + 500L, sbias);
      }

   }

   public float getLbias() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 528L) : this.__io__block.readFloat(this.__io__address + 504L);
   }

   public void setLbias(float lbias) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 528L, lbias);
      } else {
         this.__io__block.writeFloat(this.__io__address + 504L, lbias);
      }

   }

   public float getShad_alpha() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 532L) : this.__io__block.readFloat(this.__io__address + 508L);
   }

   public void setShad_alpha(float shad_alpha) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 532L, shad_alpha);
      } else {
         this.__io__block.writeFloat(this.__io__address + 508L, shad_alpha);
      }

   }

   public int getSeptex() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 536L) : this.__io__block.readInt(this.__io__address + 512L);
   }

   public void setSeptex(int septex) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 536L, septex);
      } else {
         this.__io__block.writeInt(this.__io__address + 512L, septex);
      }

   }

   public byte getRgbsel() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 540L) : this.__io__block.readByte(this.__io__address + 516L);
   }

   public void setRgbsel(byte rgbsel) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 540L, rgbsel);
      } else {
         this.__io__block.writeByte(this.__io__address + 516L, rgbsel);
      }

   }

   public byte getTexact() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 541L) : this.__io__block.readByte(this.__io__address + 517L);
   }

   public void setTexact(byte texact) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 541L, texact);
      } else {
         this.__io__block.writeByte(this.__io__address + 517L, texact);
      }

   }

   public byte getPr_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 542L) : this.__io__block.readByte(this.__io__address + 518L);
   }

   public void setPr_type(byte pr_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 542L, pr_type);
      } else {
         this.__io__block.writeByte(this.__io__address + 518L, pr_type);
      }

   }

   public byte getUse_nodes() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 543L) : this.__io__block.readByte(this.__io__address + 519L);
   }

   public void setUse_nodes(byte use_nodes) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 543L, use_nodes);
      } else {
         this.__io__block.writeByte(this.__io__address + 519L, use_nodes);
      }

   }

   public short getPr_lamp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 544L) : this.__io__block.readShort(this.__io__address + 520L);
   }

   public void setPr_lamp(short pr_lamp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 544L, pr_lamp);
      } else {
         this.__io__block.writeShort(this.__io__address + 520L, pr_lamp);
      }

   }

   public short getPr_texture() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 546L) : this.__io__block.readShort(this.__io__address + 522L);
   }

   public void setPr_texture(short pr_texture) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 546L, pr_texture);
      } else {
         this.__io__block.writeShort(this.__io__address + 522L, pr_texture);
      }

   }

   public short getMl_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 548L) : this.__io__block.readShort(this.__io__address + 524L);
   }

   public void setMl_flag(short ml_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 548L, ml_flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 524L, ml_flag);
      }

   }

   public byte getMapflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 550L) : this.__io__block.readByte(this.__io__address + 526L);
   }

   public void setMapflag(byte mapflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 550L, mapflag);
      } else {
         this.__io__block.writeByte(this.__io__address + 526L, mapflag);
      }

   }

   public byte getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 551L) : this.__io__block.readByte(this.__io__address + 527L);
   }

   public void setPad(byte pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 551L, pad);
      } else {
         this.__io__block.writeByte(this.__io__address + 527L, pad);
      }

   }

   public short getDiff_shader() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 552L) : this.__io__block.readShort(this.__io__address + 528L);
   }

   public void setDiff_shader(short diff_shader) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 552L, diff_shader);
      } else {
         this.__io__block.writeShort(this.__io__address + 528L, diff_shader);
      }

   }

   public short getSpec_shader() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 554L) : this.__io__block.readShort(this.__io__address + 530L);
   }

   public void setSpec_shader(short spec_shader) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 554L, spec_shader);
      } else {
         this.__io__block.writeShort(this.__io__address + 530L, spec_shader);
      }

   }

   public float getRoughness() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 556L) : this.__io__block.readFloat(this.__io__address + 532L);
   }

   public void setRoughness(float roughness) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 556L, roughness);
      } else {
         this.__io__block.writeFloat(this.__io__address + 532L, roughness);
      }

   }

   public float getRefrac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 560L) : this.__io__block.readFloat(this.__io__address + 536L);
   }

   public void setRefrac(float refrac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 560L, refrac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 536L, refrac);
      }

   }

   public CArrayFacade<Float> getParam() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 564L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 540L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setParam(CArrayFacade<Float> param) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 564L;
      } else {
         __dna__offset = 540L;
      }

      if (!this.__io__equals(param, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, param)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, param);
         } else {
            __io__generic__copy(this.getParam(), param);
         }

      }
   }

   public float getRms() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 580L) : this.__io__block.readFloat(this.__io__address + 556L);
   }

   public void setRms(float rms) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 580L, rms);
      } else {
         this.__io__block.writeFloat(this.__io__address + 556L, rms);
      }

   }

   public float getDarkness() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 584L) : this.__io__block.readFloat(this.__io__address + 560L);
   }

   public void setDarkness(float darkness) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 584L, darkness);
      } else {
         this.__io__block.writeFloat(this.__io__address + 560L, darkness);
      }

   }

   public short getTexco() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 588L) : this.__io__block.readShort(this.__io__address + 564L);
   }

   public void setTexco(short texco) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 588L, texco);
      } else {
         this.__io__block.writeShort(this.__io__address + 564L, texco);
      }

   }

   public short getMapto() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 590L) : this.__io__block.readShort(this.__io__address + 566L);
   }

   public void setMapto(short mapto) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 590L, mapto);
      } else {
         this.__io__block.writeShort(this.__io__address + 566L, mapto);
      }

   }

   public CPointer<ColorBand> getRamp_col() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 592L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 568L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{ColorBand.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 34), this.__io__blockTable);
   }

   public void setRamp_col(CPointer<ColorBand> ramp_col) throws IOException {
      long __address = ramp_col == null ? 0L : ramp_col.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 592L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 568L, __address);
      }

   }

   public CPointer<ColorBand> getRamp_spec() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 600L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 572L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{ColorBand.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 34), this.__io__blockTable);
   }

   public void setRamp_spec(CPointer<ColorBand> ramp_spec) throws IOException {
      long __address = ramp_spec == null ? 0L : ramp_spec.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 600L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 572L, __address);
      }

   }

   public byte getRampin_col() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 608L) : this.__io__block.readByte(this.__io__address + 576L);
   }

   public void setRampin_col(byte rampin_col) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 608L, rampin_col);
      } else {
         this.__io__block.writeByte(this.__io__address + 576L, rampin_col);
      }

   }

   public byte getRampin_spec() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 609L) : this.__io__block.readByte(this.__io__address + 577L);
   }

   public void setRampin_spec(byte rampin_spec) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 609L, rampin_spec);
      } else {
         this.__io__block.writeByte(this.__io__address + 577L, rampin_spec);
      }

   }

   public byte getRampblend_col() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 610L) : this.__io__block.readByte(this.__io__address + 578L);
   }

   public void setRampblend_col(byte rampblend_col) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 610L, rampblend_col);
      } else {
         this.__io__block.writeByte(this.__io__address + 578L, rampblend_col);
      }

   }

   public byte getRampblend_spec() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 611L) : this.__io__block.readByte(this.__io__address + 579L);
   }

   public void setRampblend_spec(byte rampblend_spec) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 611L, rampblend_spec);
      } else {
         this.__io__block.writeByte(this.__io__address + 579L, rampblend_spec);
      }

   }

   public short getRamp_show() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 612L) : this.__io__block.readShort(this.__io__address + 580L);
   }

   public void setRamp_show(short ramp_show) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 612L, ramp_show);
      } else {
         this.__io__block.writeShort(this.__io__address + 580L, ramp_show);
      }

   }

   public short getPad3() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 614L) : this.__io__block.readShort(this.__io__address + 582L);
   }

   public void setPad3(short pad3) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 614L, pad3);
      } else {
         this.__io__block.writeShort(this.__io__address + 582L, pad3);
      }

   }

   public float getRampfac_col() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 616L) : this.__io__block.readFloat(this.__io__address + 584L);
   }

   public void setRampfac_col(float rampfac_col) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 616L, rampfac_col);
      } else {
         this.__io__block.writeFloat(this.__io__address + 584L, rampfac_col);
      }

   }

   public float getRampfac_spec() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 620L) : this.__io__block.readFloat(this.__io__address + 588L);
   }

   public void setRampfac_spec(float rampfac_spec) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 620L, rampfac_spec);
      } else {
         this.__io__block.writeFloat(this.__io__address + 588L, rampfac_spec);
      }

   }

   public CArrayFacade<CPointer<MTex>> getMtex() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CPointer.class, MTex.class};
      int[] __dna__dimensions = new int[]{18};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 624L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 592L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setMtex(CArrayFacade<CPointer<MTex>> mtex) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 624L;
      } else {
         __dna__offset = 592L;
      }

      if (!this.__io__equals(mtex, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, mtex)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, mtex);
         } else {
            __io__generic__copy(this.getMtex(), mtex);
         }

      }
   }

   public CPointer<bNodeTree> getNodetree() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 768L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 664L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bNodeTree.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 397), this.__io__blockTable);
   }

   public void setNodetree(CPointer<bNodeTree> nodetree) throws IOException {
      long __address = nodetree == null ? 0L : nodetree.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 768L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 664L, __address);
      }

   }

   public CPointer<Ipo> getIpo() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 776L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 668L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Ipo.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 15), this.__io__blockTable);
   }

   public void setIpo(CPointer<Ipo> ipo) throws IOException {
      long __address = ipo == null ? 0L : ipo.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 776L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 668L, __address);
      }

   }

   public CPointer<Group> getGroup() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 784L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 672L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Group.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 341), this.__io__blockTable);
   }

   public void setGroup(CPointer<Group> group) throws IOException {
      long __address = group == null ? 0L : group.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 784L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 672L, __address);
      }

   }

   public CPointer<PreviewImage> getPreview() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 792L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 676L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PreviewImage.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 12), this.__io__blockTable);
   }

   public void setPreview(CPointer<PreviewImage> preview) throws IOException {
      long __address = preview == null ? 0L : preview.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 792L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 676L, __address);
      }

   }

   public float getFriction() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 800L) : this.__io__block.readFloat(this.__io__address + 680L);
   }

   public void setFriction(float friction) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 800L, friction);
      } else {
         this.__io__block.writeFloat(this.__io__address + 680L, friction);
      }

   }

   public float getFh() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 804L) : this.__io__block.readFloat(this.__io__address + 684L);
   }

   public void setFh(float fh) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 804L, fh);
      } else {
         this.__io__block.writeFloat(this.__io__address + 684L, fh);
      }

   }

   public float getReflect() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 808L) : this.__io__block.readFloat(this.__io__address + 688L);
   }

   public void setReflect(float reflect) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 808L, reflect);
      } else {
         this.__io__block.writeFloat(this.__io__address + 688L, reflect);
      }

   }

   public float getFhdist() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 812L) : this.__io__block.readFloat(this.__io__address + 692L);
   }

   public void setFhdist(float fhdist) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 812L, fhdist);
      } else {
         this.__io__block.writeFloat(this.__io__address + 692L, fhdist);
      }

   }

   public float getXyfrict() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 816L) : this.__io__block.readFloat(this.__io__address + 696L);
   }

   public void setXyfrict(float xyfrict) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 816L, xyfrict);
      } else {
         this.__io__block.writeFloat(this.__io__address + 696L, xyfrict);
      }

   }

   public short getDynamode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 820L) : this.__io__block.readShort(this.__io__address + 700L);
   }

   public void setDynamode(short dynamode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 820L, dynamode);
      } else {
         this.__io__block.writeShort(this.__io__address + 700L, dynamode);
      }

   }

   public short getPad2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 822L) : this.__io__block.readShort(this.__io__address + 702L);
   }

   public void setPad2(short pad2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 822L, pad2);
      } else {
         this.__io__block.writeShort(this.__io__address + 702L, pad2);
      }

   }

   public CArrayFacade<Float> getSss_radius() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 824L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 704L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setSss_radius(CArrayFacade<Float> sss_radius) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 824L;
      } else {
         __dna__offset = 704L;
      }

      if (!this.__io__equals(sss_radius, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, sss_radius)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, sss_radius);
         } else {
            __io__generic__copy(this.getSss_radius(), sss_radius);
         }

      }
   }

   public CArrayFacade<Float> getSss_col() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 836L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 716L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setSss_col(CArrayFacade<Float> sss_col) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 836L;
      } else {
         __dna__offset = 716L;
      }

      if (!this.__io__equals(sss_col, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, sss_col)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, sss_col);
         } else {
            __io__generic__copy(this.getSss_col(), sss_col);
         }

      }
   }

   public float getSss_error() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 848L) : this.__io__block.readFloat(this.__io__address + 728L);
   }

   public void setSss_error(float sss_error) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 848L, sss_error);
      } else {
         this.__io__block.writeFloat(this.__io__address + 728L, sss_error);
      }

   }

   public float getSss_scale() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 852L) : this.__io__block.readFloat(this.__io__address + 732L);
   }

   public void setSss_scale(float sss_scale) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 852L, sss_scale);
      } else {
         this.__io__block.writeFloat(this.__io__address + 732L, sss_scale);
      }

   }

   public float getSss_ior() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 856L) : this.__io__block.readFloat(this.__io__address + 736L);
   }

   public void setSss_ior(float sss_ior) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 856L, sss_ior);
      } else {
         this.__io__block.writeFloat(this.__io__address + 736L, sss_ior);
      }

   }

   public float getSss_colfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 860L) : this.__io__block.readFloat(this.__io__address + 740L);
   }

   public void setSss_colfac(float sss_colfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 860L, sss_colfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 740L, sss_colfac);
      }

   }

   public float getSss_texfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 864L) : this.__io__block.readFloat(this.__io__address + 744L);
   }

   public void setSss_texfac(float sss_texfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 864L, sss_texfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 744L, sss_texfac);
      }

   }

   public float getSss_front() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 868L) : this.__io__block.readFloat(this.__io__address + 748L);
   }

   public void setSss_front(float sss_front) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 868L, sss_front);
      } else {
         this.__io__block.writeFloat(this.__io__address + 748L, sss_front);
      }

   }

   public float getSss_back() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 872L) : this.__io__block.readFloat(this.__io__address + 752L);
   }

   public void setSss_back(float sss_back) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 872L, sss_back);
      } else {
         this.__io__block.writeFloat(this.__io__address + 752L, sss_back);
      }

   }

   public short getSss_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 876L) : this.__io__block.readShort(this.__io__address + 756L);
   }

   public void setSss_flag(short sss_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 876L, sss_flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 756L, sss_flag);
      }

   }

   public short getSss_preset() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 878L) : this.__io__block.readShort(this.__io__address + 758L);
   }

   public void setSss_preset(short sss_preset) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 878L, sss_preset);
      } else {
         this.__io__block.writeShort(this.__io__address + 758L, sss_preset);
      }

   }

   public int getMapto_textured() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 880L) : this.__io__block.readInt(this.__io__address + 760L);
   }

   public void setMapto_textured(int mapto_textured) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 880L, mapto_textured);
      } else {
         this.__io__block.writeInt(this.__io__address + 760L, mapto_textured);
      }

   }

   public short getShadowonly_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 884L) : this.__io__block.readShort(this.__io__address + 764L);
   }

   public void setShadowonly_flag(short shadowonly_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 884L, shadowonly_flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 764L, shadowonly_flag);
      }

   }

   public short getIndex() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 886L) : this.__io__block.readShort(this.__io__address + 766L);
   }

   public void setIndex(short index) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 886L, index);
      } else {
         this.__io__block.writeShort(this.__io__address + 766L, index);
      }

   }

   public CArrayFacade<Float> getLine_col() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 888L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 768L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setLine_col(CArrayFacade<Float> line_col) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 888L;
      } else {
         __dna__offset = 768L;
      }

      if (!this.__io__equals(line_col, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, line_col)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, line_col);
         } else {
            __io__generic__copy(this.getLine_col(), line_col);
         }

      }
   }

   public short getLine_priority() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 904L) : this.__io__block.readShort(this.__io__address + 784L);
   }

   public void setLine_priority(short line_priority) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 904L, line_priority);
      } else {
         this.__io__block.writeShort(this.__io__address + 784L, line_priority);
      }

   }

   public short getVcol_alpha() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 906L) : this.__io__block.readShort(this.__io__address + 786L);
   }

   public void setVcol_alpha(short vcol_alpha) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 906L, vcol_alpha);
      } else {
         this.__io__block.writeShort(this.__io__address + 786L, vcol_alpha);
      }

   }

   public short getPaint_active_slot() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 908L) : this.__io__block.readShort(this.__io__address + 788L);
   }

   public void setPaint_active_slot(short paint_active_slot) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 908L, paint_active_slot);
      } else {
         this.__io__block.writeShort(this.__io__address + 788L, paint_active_slot);
      }

   }

   public short getPaint_clone_slot() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 910L) : this.__io__block.readShort(this.__io__address + 790L);
   }

   public void setPaint_clone_slot(short paint_clone_slot) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 910L, paint_clone_slot);
      } else {
         this.__io__block.writeShort(this.__io__address + 790L, paint_clone_slot);
      }

   }

   public short getTot_slots() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 912L) : this.__io__block.readShort(this.__io__address + 792L);
   }

   public void setTot_slots(short tot_slots) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 912L, tot_slots);
      } else {
         this.__io__block.writeShort(this.__io__address + 792L, tot_slots);
      }

   }

   public CArrayFacade<Short> getPad4() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Short.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 914L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 794L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad4(CArrayFacade<Short> pad4) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 914L;
      } else {
         __dna__offset = 794L;
      }

      if (!this.__io__equals(pad4, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad4)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad4);
         } else {
            __io__generic__copy(this.getPad4(), pad4);
         }

      }
   }

   public CArrayFacade<CArrayFacade<Byte>> getNmap_tangent_names() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CArrayFacade.class, Byte.class};
      int[] __dna__dimensions = new int[]{9, 64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 920L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 800L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setNmap_tangent_names(CArrayFacade<CArrayFacade<Byte>> nmap_tangent_names) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 920L;
      } else {
         __dna__offset = 800L;
      }

      if (!this.__io__equals(nmap_tangent_names, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, nmap_tangent_names)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, nmap_tangent_names);
         } else {
            __io__generic__copy(this.getNmap_tangent_names(), nmap_tangent_names);
         }

      }
   }

   public int getNmap_tangent_names_count() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1496L) : this.__io__block.readInt(this.__io__address + 1376L);
   }

   public void setNmap_tangent_names_count(int nmap_tangent_names_count) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1496L, nmap_tangent_names_count);
      } else {
         this.__io__block.writeInt(this.__io__address + 1376L, nmap_tangent_names_count);
      }

   }

   public int getPad5() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1500L) : this.__io__block.readInt(this.__io__address + 1380L);
   }

   public void setPad5(int pad5) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1500L, pad5);
      } else {
         this.__io__block.writeInt(this.__io__address + 1380L, pad5);
      }

   }

   public CPointer<TexPaintSlot> getTexpaintslot() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1504L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1384L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{TexPaintSlot.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 45), this.__io__blockTable);
   }

   public void setTexpaintslot(CPointer<TexPaintSlot> texpaintslot) throws IOException {
      long __address = texpaintslot == null ? 0L : texpaintslot.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1504L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1384L, __address);
      }

   }

   public ListBase getGpumaterial() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 1512L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 1388L, this.__io__block, this.__io__blockTable);
   }

   public void setGpumaterial(ListBase gpumaterial) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1512L;
      } else {
         __dna__offset = 1388L;
      }

      if (!this.__io__equals(gpumaterial, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, gpumaterial)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, gpumaterial);
         } else {
            __io__generic__copy(this.getGpumaterial(), gpumaterial);
         }

      }
   }

   public CPointer<Material> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Material.class}, this.__io__block, this.__io__blockTable);
   }
}
