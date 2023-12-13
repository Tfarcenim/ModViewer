package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 420L,
   size64 = 544L
)
public class World extends CFacade {
   public static final int __DNA__SDNA_INDEX = 166;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__adt = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__colormodel = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__totex = new long[]{106L, 130L};
   public static final long[] __DNA__FIELD__texact = new long[]{108L, 132L};
   public static final long[] __DNA__FIELD__mistype = new long[]{110L, 134L};
   public static final long[] __DNA__FIELD__horr = new long[]{112L, 136L};
   public static final long[] __DNA__FIELD__horg = new long[]{116L, 140L};
   public static final long[] __DNA__FIELD__horb = new long[]{120L, 144L};
   public static final long[] __DNA__FIELD__zenr = new long[]{124L, 148L};
   public static final long[] __DNA__FIELD__zeng = new long[]{128L, 152L};
   public static final long[] __DNA__FIELD__zenb = new long[]{132L, 156L};
   public static final long[] __DNA__FIELD__ambr = new long[]{136L, 160L};
   public static final long[] __DNA__FIELD__ambg = new long[]{140L, 164L};
   public static final long[] __DNA__FIELD__ambb = new long[]{144L, 168L};
   public static final long[] __DNA__FIELD__exposure = new long[]{148L, 172L};
   public static final long[] __DNA__FIELD__exp = new long[]{152L, 176L};
   public static final long[] __DNA__FIELD__range = new long[]{156L, 180L};
   public static final long[] __DNA__FIELD__linfac = new long[]{160L, 184L};
   public static final long[] __DNA__FIELD__logfac = new long[]{164L, 188L};
   public static final long[] __DNA__FIELD__gravity = new long[]{168L, 192L};
   public static final long[] __DNA__FIELD__activityBoxRadius = new long[]{172L, 196L};
   public static final long[] __DNA__FIELD__skytype = new long[]{176L, 200L};
   public static final long[] __DNA__FIELD__mode = new long[]{178L, 202L};
   public static final long[] __DNA__FIELD__occlusionRes = new long[]{180L, 204L};
   public static final long[] __DNA__FIELD__physicsEngine = new long[]{182L, 206L};
   public static final long[] __DNA__FIELD__ticrate = new long[]{184L, 208L};
   public static final long[] __DNA__FIELD__maxlogicstep = new long[]{186L, 210L};
   public static final long[] __DNA__FIELD__physubstep = new long[]{188L, 212L};
   public static final long[] __DNA__FIELD__maxphystep = new long[]{190L, 214L};
   public static final long[] __DNA__FIELD__misi = new long[]{192L, 216L};
   public static final long[] __DNA__FIELD__miststa = new long[]{196L, 220L};
   public static final long[] __DNA__FIELD__mistdist = new long[]{200L, 224L};
   public static final long[] __DNA__FIELD__misthi = new long[]{204L, 228L};
   public static final long[] __DNA__FIELD__starr = new long[]{208L, 232L};
   public static final long[] __DNA__FIELD__starg = new long[]{212L, 236L};
   public static final long[] __DNA__FIELD__starb = new long[]{216L, 240L};
   public static final long[] __DNA__FIELD__stark = new long[]{220L, 244L};
   public static final long[] __DNA__FIELD__starsize = new long[]{224L, 248L};
   public static final long[] __DNA__FIELD__starmindist = new long[]{228L, 252L};
   public static final long[] __DNA__FIELD__stardist = new long[]{232L, 256L};
   public static final long[] __DNA__FIELD__starcolnoise = new long[]{236L, 260L};
   public static final long[] __DNA__FIELD__dofsta = new long[]{240L, 264L};
   public static final long[] __DNA__FIELD__dofend = new long[]{242L, 266L};
   public static final long[] __DNA__FIELD__dofmin = new long[]{244L, 268L};
   public static final long[] __DNA__FIELD__dofmax = new long[]{246L, 270L};
   public static final long[] __DNA__FIELD__aodist = new long[]{248L, 272L};
   public static final long[] __DNA__FIELD__aodistfac = new long[]{252L, 276L};
   public static final long[] __DNA__FIELD__aoenergy = new long[]{256L, 280L};
   public static final long[] __DNA__FIELD__aobias = new long[]{260L, 284L};
   public static final long[] __DNA__FIELD__aomode = new long[]{264L, 288L};
   public static final long[] __DNA__FIELD__aosamp = new long[]{266L, 290L};
   public static final long[] __DNA__FIELD__aomix = new long[]{268L, 292L};
   public static final long[] __DNA__FIELD__aocolor = new long[]{270L, 294L};
   public static final long[] __DNA__FIELD__ao_adapt_thresh = new long[]{272L, 296L};
   public static final long[] __DNA__FIELD__ao_adapt_speed_fac = new long[]{276L, 300L};
   public static final long[] __DNA__FIELD__ao_approx_error = new long[]{280L, 304L};
   public static final long[] __DNA__FIELD__ao_approx_correction = new long[]{284L, 308L};
   public static final long[] __DNA__FIELD__ao_indirect_energy = new long[]{288L, 312L};
   public static final long[] __DNA__FIELD__ao_env_energy = new long[]{292L, 316L};
   public static final long[] __DNA__FIELD__ao_pad2 = new long[]{296L, 320L};
   public static final long[] __DNA__FIELD__ao_indirect_bounces = new long[]{300L, 324L};
   public static final long[] __DNA__FIELD__ao_pad = new long[]{302L, 326L};
   public static final long[] __DNA__FIELD__ao_samp_method = new long[]{304L, 328L};
   public static final long[] __DNA__FIELD__ao_gather_method = new long[]{306L, 330L};
   public static final long[] __DNA__FIELD__ao_approx_passes = new long[]{308L, 332L};
   public static final long[] __DNA__FIELD__flag = new long[]{310L, 334L};
   public static final long[] __DNA__FIELD__aosphere = new long[]{312L, 336L};
   public static final long[] __DNA__FIELD__aotables = new long[]{316L, 344L};
   public static final long[] __DNA__FIELD__ipo = new long[]{320L, 352L};
   public static final long[] __DNA__FIELD__mtex = new long[]{324L, 360L};
   public static final long[] __DNA__FIELD__pr_texture = new long[]{396L, 504L};
   public static final long[] __DNA__FIELD__use_nodes = new long[]{398L, 506L};
   public static final long[] __DNA__FIELD__pad = new long[]{400L, 508L};
   public static final long[] __DNA__FIELD__preview = new long[]{404L, 512L};
   public static final long[] __DNA__FIELD__nodetree = new long[]{408L, 520L};
   public static final long[] __DNA__FIELD__gpumaterial = new long[]{412L, 528L};

   public World(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected World(World that) {
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

   public short getColormodel() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 128L) : this.__io__block.readShort(this.__io__address + 104L);
   }

   public void setColormodel(short colormodel) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 128L, colormodel);
      } else {
         this.__io__block.writeShort(this.__io__address + 104L, colormodel);
      }

   }

   public short getTotex() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 130L) : this.__io__block.readShort(this.__io__address + 106L);
   }

   public void setTotex(short totex) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 130L, totex);
      } else {
         this.__io__block.writeShort(this.__io__address + 106L, totex);
      }

   }

   public short getTexact() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 132L) : this.__io__block.readShort(this.__io__address + 108L);
   }

   public void setTexact(short texact) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 132L, texact);
      } else {
         this.__io__block.writeShort(this.__io__address + 108L, texact);
      }

   }

   public short getMistype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 134L) : this.__io__block.readShort(this.__io__address + 110L);
   }

   public void setMistype(short mistype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 134L, mistype);
      } else {
         this.__io__block.writeShort(this.__io__address + 110L, mistype);
      }

   }

   public float getHorr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 136L) : this.__io__block.readFloat(this.__io__address + 112L);
   }

   public void setHorr(float horr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 136L, horr);
      } else {
         this.__io__block.writeFloat(this.__io__address + 112L, horr);
      }

   }

   public float getHorg() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 140L) : this.__io__block.readFloat(this.__io__address + 116L);
   }

   public void setHorg(float horg) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 140L, horg);
      } else {
         this.__io__block.writeFloat(this.__io__address + 116L, horg);
      }

   }

   public float getHorb() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 144L) : this.__io__block.readFloat(this.__io__address + 120L);
   }

   public void setHorb(float horb) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 144L, horb);
      } else {
         this.__io__block.writeFloat(this.__io__address + 120L, horb);
      }

   }

   public float getZenr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 148L) : this.__io__block.readFloat(this.__io__address + 124L);
   }

   public void setZenr(float zenr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 148L, zenr);
      } else {
         this.__io__block.writeFloat(this.__io__address + 124L, zenr);
      }

   }

   public float getZeng() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 152L) : this.__io__block.readFloat(this.__io__address + 128L);
   }

   public void setZeng(float zeng) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 152L, zeng);
      } else {
         this.__io__block.writeFloat(this.__io__address + 128L, zeng);
      }

   }

   public float getZenb() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 156L) : this.__io__block.readFloat(this.__io__address + 132L);
   }

   public void setZenb(float zenb) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 156L, zenb);
      } else {
         this.__io__block.writeFloat(this.__io__address + 132L, zenb);
      }

   }

   public float getAmbr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 160L) : this.__io__block.readFloat(this.__io__address + 136L);
   }

   public void setAmbr(float ambr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 160L, ambr);
      } else {
         this.__io__block.writeFloat(this.__io__address + 136L, ambr);
      }

   }

   public float getAmbg() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 164L) : this.__io__block.readFloat(this.__io__address + 140L);
   }

   public void setAmbg(float ambg) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 164L, ambg);
      } else {
         this.__io__block.writeFloat(this.__io__address + 140L, ambg);
      }

   }

   public float getAmbb() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 168L) : this.__io__block.readFloat(this.__io__address + 144L);
   }

   public void setAmbb(float ambb) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 168L, ambb);
      } else {
         this.__io__block.writeFloat(this.__io__address + 144L, ambb);
      }

   }

   public float getExposure() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 172L) : this.__io__block.readFloat(this.__io__address + 148L);
   }

   public void setExposure(float exposure) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 172L, exposure);
      } else {
         this.__io__block.writeFloat(this.__io__address + 148L, exposure);
      }

   }

   public float getExp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 176L) : this.__io__block.readFloat(this.__io__address + 152L);
   }

   public void setExp(float exp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 176L, exp);
      } else {
         this.__io__block.writeFloat(this.__io__address + 152L, exp);
      }

   }

   public float getRange() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 180L) : this.__io__block.readFloat(this.__io__address + 156L);
   }

   public void setRange(float range) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 180L, range);
      } else {
         this.__io__block.writeFloat(this.__io__address + 156L, range);
      }

   }

   public float getLinfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 184L) : this.__io__block.readFloat(this.__io__address + 160L);
   }

   public void setLinfac(float linfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 184L, linfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 160L, linfac);
      }

   }

   public float getLogfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 188L) : this.__io__block.readFloat(this.__io__address + 164L);
   }

   public void setLogfac(float logfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 188L, logfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 164L, logfac);
      }

   }

   public float getGravity() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 192L) : this.__io__block.readFloat(this.__io__address + 168L);
   }

   public void setGravity(float gravity) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 192L, gravity);
      } else {
         this.__io__block.writeFloat(this.__io__address + 168L, gravity);
      }

   }

   public float getActivityBoxRadius() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 196L) : this.__io__block.readFloat(this.__io__address + 172L);
   }

   public void setActivityBoxRadius(float activityBoxRadius) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 196L, activityBoxRadius);
      } else {
         this.__io__block.writeFloat(this.__io__address + 172L, activityBoxRadius);
      }

   }

   public short getSkytype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 200L) : this.__io__block.readShort(this.__io__address + 176L);
   }

   public void setSkytype(short skytype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 200L, skytype);
      } else {
         this.__io__block.writeShort(this.__io__address + 176L, skytype);
      }

   }

   public short getMode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 202L) : this.__io__block.readShort(this.__io__address + 178L);
   }

   public void setMode(short mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 202L, mode);
      } else {
         this.__io__block.writeShort(this.__io__address + 178L, mode);
      }

   }

   public short getOcclusionRes() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 204L) : this.__io__block.readShort(this.__io__address + 180L);
   }

   public void setOcclusionRes(short occlusionRes) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 204L, occlusionRes);
      } else {
         this.__io__block.writeShort(this.__io__address + 180L, occlusionRes);
      }

   }

   public short getPhysicsEngine() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 206L) : this.__io__block.readShort(this.__io__address + 182L);
   }

   public void setPhysicsEngine(short physicsEngine) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 206L, physicsEngine);
      } else {
         this.__io__block.writeShort(this.__io__address + 182L, physicsEngine);
      }

   }

   public short getTicrate() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 208L) : this.__io__block.readShort(this.__io__address + 184L);
   }

   public void setTicrate(short ticrate) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 208L, ticrate);
      } else {
         this.__io__block.writeShort(this.__io__address + 184L, ticrate);
      }

   }

   public short getMaxlogicstep() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 210L) : this.__io__block.readShort(this.__io__address + 186L);
   }

   public void setMaxlogicstep(short maxlogicstep) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 210L, maxlogicstep);
      } else {
         this.__io__block.writeShort(this.__io__address + 186L, maxlogicstep);
      }

   }

   public short getPhysubstep() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 212L) : this.__io__block.readShort(this.__io__address + 188L);
   }

   public void setPhysubstep(short physubstep) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 212L, physubstep);
      } else {
         this.__io__block.writeShort(this.__io__address + 188L, physubstep);
      }

   }

   public short getMaxphystep() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 214L) : this.__io__block.readShort(this.__io__address + 190L);
   }

   public void setMaxphystep(short maxphystep) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 214L, maxphystep);
      } else {
         this.__io__block.writeShort(this.__io__address + 190L, maxphystep);
      }

   }

   public float getMisi() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 216L) : this.__io__block.readFloat(this.__io__address + 192L);
   }

   public void setMisi(float misi) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 216L, misi);
      } else {
         this.__io__block.writeFloat(this.__io__address + 192L, misi);
      }

   }

   public float getMiststa() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 220L) : this.__io__block.readFloat(this.__io__address + 196L);
   }

   public void setMiststa(float miststa) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 220L, miststa);
      } else {
         this.__io__block.writeFloat(this.__io__address + 196L, miststa);
      }

   }

   public float getMistdist() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 224L) : this.__io__block.readFloat(this.__io__address + 200L);
   }

   public void setMistdist(float mistdist) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 224L, mistdist);
      } else {
         this.__io__block.writeFloat(this.__io__address + 200L, mistdist);
      }

   }

   public float getMisthi() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 228L) : this.__io__block.readFloat(this.__io__address + 204L);
   }

   public void setMisthi(float misthi) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 228L, misthi);
      } else {
         this.__io__block.writeFloat(this.__io__address + 204L, misthi);
      }

   }

   public float getStarr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 232L) : this.__io__block.readFloat(this.__io__address + 208L);
   }

   public void setStarr(float starr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 232L, starr);
      } else {
         this.__io__block.writeFloat(this.__io__address + 208L, starr);
      }

   }

   public float getStarg() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 236L) : this.__io__block.readFloat(this.__io__address + 212L);
   }

   public void setStarg(float starg) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 236L, starg);
      } else {
         this.__io__block.writeFloat(this.__io__address + 212L, starg);
      }

   }

   public float getStarb() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 240L) : this.__io__block.readFloat(this.__io__address + 216L);
   }

   public void setStarb(float starb) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 240L, starb);
      } else {
         this.__io__block.writeFloat(this.__io__address + 216L, starb);
      }

   }

   public float getStark() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 244L) : this.__io__block.readFloat(this.__io__address + 220L);
   }

   public void setStark(float stark) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 244L, stark);
      } else {
         this.__io__block.writeFloat(this.__io__address + 220L, stark);
      }

   }

   public float getStarsize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 248L) : this.__io__block.readFloat(this.__io__address + 224L);
   }

   public void setStarsize(float starsize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 248L, starsize);
      } else {
         this.__io__block.writeFloat(this.__io__address + 224L, starsize);
      }

   }

   public float getStarmindist() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 252L) : this.__io__block.readFloat(this.__io__address + 228L);
   }

   public void setStarmindist(float starmindist) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 252L, starmindist);
      } else {
         this.__io__block.writeFloat(this.__io__address + 228L, starmindist);
      }

   }

   public float getStardist() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 256L) : this.__io__block.readFloat(this.__io__address + 232L);
   }

   public void setStardist(float stardist) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 256L, stardist);
      } else {
         this.__io__block.writeFloat(this.__io__address + 232L, stardist);
      }

   }

   public float getStarcolnoise() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 260L) : this.__io__block.readFloat(this.__io__address + 236L);
   }

   public void setStarcolnoise(float starcolnoise) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 260L, starcolnoise);
      } else {
         this.__io__block.writeFloat(this.__io__address + 236L, starcolnoise);
      }

   }

   public short getDofsta() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 264L) : this.__io__block.readShort(this.__io__address + 240L);
   }

   public void setDofsta(short dofsta) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 264L, dofsta);
      } else {
         this.__io__block.writeShort(this.__io__address + 240L, dofsta);
      }

   }

   public short getDofend() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 266L) : this.__io__block.readShort(this.__io__address + 242L);
   }

   public void setDofend(short dofend) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 266L, dofend);
      } else {
         this.__io__block.writeShort(this.__io__address + 242L, dofend);
      }

   }

   public short getDofmin() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 268L) : this.__io__block.readShort(this.__io__address + 244L);
   }

   public void setDofmin(short dofmin) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 268L, dofmin);
      } else {
         this.__io__block.writeShort(this.__io__address + 244L, dofmin);
      }

   }

   public short getDofmax() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 270L) : this.__io__block.readShort(this.__io__address + 246L);
   }

   public void setDofmax(short dofmax) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 270L, dofmax);
      } else {
         this.__io__block.writeShort(this.__io__address + 246L, dofmax);
      }

   }

   public float getAodist() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 272L) : this.__io__block.readFloat(this.__io__address + 248L);
   }

   public void setAodist(float aodist) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 272L, aodist);
      } else {
         this.__io__block.writeFloat(this.__io__address + 248L, aodist);
      }

   }

   public float getAodistfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 276L) : this.__io__block.readFloat(this.__io__address + 252L);
   }

   public void setAodistfac(float aodistfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 276L, aodistfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 252L, aodistfac);
      }

   }

   public float getAoenergy() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 280L) : this.__io__block.readFloat(this.__io__address + 256L);
   }

   public void setAoenergy(float aoenergy) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 280L, aoenergy);
      } else {
         this.__io__block.writeFloat(this.__io__address + 256L, aoenergy);
      }

   }

   public float getAobias() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 284L) : this.__io__block.readFloat(this.__io__address + 260L);
   }

   public void setAobias(float aobias) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 284L, aobias);
      } else {
         this.__io__block.writeFloat(this.__io__address + 260L, aobias);
      }

   }

   public short getAomode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 288L) : this.__io__block.readShort(this.__io__address + 264L);
   }

   public void setAomode(short aomode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 288L, aomode);
      } else {
         this.__io__block.writeShort(this.__io__address + 264L, aomode);
      }

   }

   public short getAosamp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 290L) : this.__io__block.readShort(this.__io__address + 266L);
   }

   public void setAosamp(short aosamp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 290L, aosamp);
      } else {
         this.__io__block.writeShort(this.__io__address + 266L, aosamp);
      }

   }

   public short getAomix() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 292L) : this.__io__block.readShort(this.__io__address + 268L);
   }

   public void setAomix(short aomix) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 292L, aomix);
      } else {
         this.__io__block.writeShort(this.__io__address + 268L, aomix);
      }

   }

   public short getAocolor() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 294L) : this.__io__block.readShort(this.__io__address + 270L);
   }

   public void setAocolor(short aocolor) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 294L, aocolor);
      } else {
         this.__io__block.writeShort(this.__io__address + 270L, aocolor);
      }

   }

   public float getAo_adapt_thresh() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 296L) : this.__io__block.readFloat(this.__io__address + 272L);
   }

   public void setAo_adapt_thresh(float ao_adapt_thresh) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 296L, ao_adapt_thresh);
      } else {
         this.__io__block.writeFloat(this.__io__address + 272L, ao_adapt_thresh);
      }

   }

   public float getAo_adapt_speed_fac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 300L) : this.__io__block.readFloat(this.__io__address + 276L);
   }

   public void setAo_adapt_speed_fac(float ao_adapt_speed_fac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 300L, ao_adapt_speed_fac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 276L, ao_adapt_speed_fac);
      }

   }

   public float getAo_approx_error() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 304L) : this.__io__block.readFloat(this.__io__address + 280L);
   }

   public void setAo_approx_error(float ao_approx_error) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 304L, ao_approx_error);
      } else {
         this.__io__block.writeFloat(this.__io__address + 280L, ao_approx_error);
      }

   }

   public float getAo_approx_correction() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 308L) : this.__io__block.readFloat(this.__io__address + 284L);
   }

   public void setAo_approx_correction(float ao_approx_correction) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 308L, ao_approx_correction);
      } else {
         this.__io__block.writeFloat(this.__io__address + 284L, ao_approx_correction);
      }

   }

   public float getAo_indirect_energy() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 312L) : this.__io__block.readFloat(this.__io__address + 288L);
   }

   public void setAo_indirect_energy(float ao_indirect_energy) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 312L, ao_indirect_energy);
      } else {
         this.__io__block.writeFloat(this.__io__address + 288L, ao_indirect_energy);
      }

   }

   public float getAo_env_energy() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 316L) : this.__io__block.readFloat(this.__io__address + 292L);
   }

   public void setAo_env_energy(float ao_env_energy) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 316L, ao_env_energy);
      } else {
         this.__io__block.writeFloat(this.__io__address + 292L, ao_env_energy);
      }

   }

   public float getAo_pad2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 320L) : this.__io__block.readFloat(this.__io__address + 296L);
   }

   public void setAo_pad2(float ao_pad2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 320L, ao_pad2);
      } else {
         this.__io__block.writeFloat(this.__io__address + 296L, ao_pad2);
      }

   }

   public short getAo_indirect_bounces() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 324L) : this.__io__block.readShort(this.__io__address + 300L);
   }

   public void setAo_indirect_bounces(short ao_indirect_bounces) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 324L, ao_indirect_bounces);
      } else {
         this.__io__block.writeShort(this.__io__address + 300L, ao_indirect_bounces);
      }

   }

   public short getAo_pad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 326L) : this.__io__block.readShort(this.__io__address + 302L);
   }

   public void setAo_pad(short ao_pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 326L, ao_pad);
      } else {
         this.__io__block.writeShort(this.__io__address + 302L, ao_pad);
      }

   }

   public short getAo_samp_method() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 328L) : this.__io__block.readShort(this.__io__address + 304L);
   }

   public void setAo_samp_method(short ao_samp_method) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 328L, ao_samp_method);
      } else {
         this.__io__block.writeShort(this.__io__address + 304L, ao_samp_method);
      }

   }

   public short getAo_gather_method() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 330L) : this.__io__block.readShort(this.__io__address + 306L);
   }

   public void setAo_gather_method(short ao_gather_method) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 330L, ao_gather_method);
      } else {
         this.__io__block.writeShort(this.__io__address + 306L, ao_gather_method);
      }

   }

   public short getAo_approx_passes() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 332L) : this.__io__block.readShort(this.__io__address + 308L);
   }

   public void setAo_approx_passes(short ao_approx_passes) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 332L, ao_approx_passes);
      } else {
         this.__io__block.writeShort(this.__io__address + 308L, ao_approx_passes);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 334L) : this.__io__block.readShort(this.__io__address + 310L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 334L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 310L, flag);
      }

   }

   public CPointer<Float> getAosphere() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 336L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 312L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, __dna__targetTypes), this.__io__blockTable);
   }

   public void setAosphere(CPointer<Float> aosphere) throws IOException {
      long __address = aosphere == null ? 0L : aosphere.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 336L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 312L, __address);
      }

   }

   public CPointer<Float> getAotables() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 344L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 316L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, __dna__targetTypes), this.__io__blockTable);
   }

   public void setAotables(CPointer<Float> aotables) throws IOException {
      long __address = aotables == null ? 0L : aotables.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 344L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 316L, __address);
      }

   }

   public CPointer<Ipo> getIpo() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 352L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 320L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Ipo.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 15), this.__io__blockTable);
   }

   public void setIpo(CPointer<Ipo> ipo) throws IOException {
      long __address = ipo == null ? 0L : ipo.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 352L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 320L, __address);
      }

   }

   public CArrayFacade<CPointer<MTex>> getMtex() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CPointer.class, MTex.class};
      int[] __dna__dimensions = new int[]{18};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 360L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 324L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setMtex(CArrayFacade<CPointer<MTex>> mtex) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 360L;
      } else {
         __dna__offset = 324L;
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
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 504L) : this.__io__block.readShort(this.__io__address + 396L);
   }

   public void setPr_texture(short pr_texture) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 504L, pr_texture);
      } else {
         this.__io__block.writeShort(this.__io__address + 396L, pr_texture);
      }

   }

   public short getUse_nodes() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 506L) : this.__io__block.readShort(this.__io__address + 398L);
   }

   public void setUse_nodes(short use_nodes) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 506L, use_nodes);
      } else {
         this.__io__block.writeShort(this.__io__address + 398L, use_nodes);
      }

   }

   public CArrayFacade<Short> getPad() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Short.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 508L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 400L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad(CArrayFacade<Short> pad) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 508L;
      } else {
         __dna__offset = 400L;
      }

      if (!this.__io__equals(pad, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad);
         } else {
            __io__generic__copy(this.getPad(), pad);
         }

      }
   }

   public CPointer<PreviewImage> getPreview() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 512L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 404L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PreviewImage.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 12), this.__io__blockTable);
   }

   public void setPreview(CPointer<PreviewImage> preview) throws IOException {
      long __address = preview == null ? 0L : preview.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 512L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 404L, __address);
      }

   }

   public CPointer<bNodeTree> getNodetree() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 520L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 408L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bNodeTree.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 397), this.__io__blockTable);
   }

   public void setNodetree(CPointer<bNodeTree> nodetree) throws IOException {
      long __address = nodetree == null ? 0L : nodetree.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 520L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 408L, __address);
      }

   }

   public ListBase getGpumaterial() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 528L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 412L, this.__io__block, this.__io__blockTable);
   }

   public void setGpumaterial(ListBase gpumaterial) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 528L;
      } else {
         __dna__offset = 412L;
      }

      if (!this.__io__equals(gpumaterial, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, gpumaterial)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, gpumaterial);
         } else {
            __io__generic__copy(this.getGpumaterial(), gpumaterial);
         }

      }
   }

   public CPointer<World> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{World.class}, this.__io__block, this.__io__blockTable);
   }
}
