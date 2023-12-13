package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 700L,
   size64 = 856L
)
public class ParticleSettings extends CFacade {
   public static final int __DNA__SDNA_INDEX = 485;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__adt = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__boids = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__fluid = new long[]{108L, 136L};
   public static final long[] __DNA__FIELD__effector_weights = new long[]{112L, 144L};
   public static final long[] __DNA__FIELD__collision_group = new long[]{116L, 152L};
   public static final long[] __DNA__FIELD__flag = new long[]{120L, 160L};
   public static final long[] __DNA__FIELD__rt = new long[]{124L, 164L};
   public static final long[] __DNA__FIELD__type = new long[]{128L, 168L};
   public static final long[] __DNA__FIELD__from = new long[]{130L, 170L};
   public static final long[] __DNA__FIELD__distr = new long[]{132L, 172L};
   public static final long[] __DNA__FIELD__texact = new long[]{134L, 174L};
   public static final long[] __DNA__FIELD__phystype = new long[]{136L, 176L};
   public static final long[] __DNA__FIELD__rotmode = new long[]{138L, 178L};
   public static final long[] __DNA__FIELD__avemode = new long[]{140L, 180L};
   public static final long[] __DNA__FIELD__reactevent = new long[]{142L, 182L};
   public static final long[] __DNA__FIELD__draw = new long[]{144L, 184L};
   public static final long[] __DNA__FIELD__pad1 = new long[]{148L, 188L};
   public static final long[] __DNA__FIELD__draw_as = new long[]{152L, 192L};
   public static final long[] __DNA__FIELD__draw_size = new long[]{154L, 194L};
   public static final long[] __DNA__FIELD__childtype = new long[]{156L, 196L};
   public static final long[] __DNA__FIELD__pad2 = new long[]{158L, 198L};
   public static final long[] __DNA__FIELD__ren_as = new long[]{160L, 200L};
   public static final long[] __DNA__FIELD__subframes = new long[]{162L, 202L};
   public static final long[] __DNA__FIELD__draw_col = new long[]{164L, 204L};
   public static final long[] __DNA__FIELD__draw_step = new long[]{166L, 206L};
   public static final long[] __DNA__FIELD__ren_step = new long[]{168L, 208L};
   public static final long[] __DNA__FIELD__hair_step = new long[]{170L, 210L};
   public static final long[] __DNA__FIELD__keys_step = new long[]{172L, 212L};
   public static final long[] __DNA__FIELD__adapt_angle = new long[]{174L, 214L};
   public static final long[] __DNA__FIELD__adapt_pix = new long[]{176L, 216L};
   public static final long[] __DNA__FIELD__disp = new long[]{178L, 218L};
   public static final long[] __DNA__FIELD__omat = new long[]{180L, 220L};
   public static final long[] __DNA__FIELD__interpolation = new long[]{182L, 222L};
   public static final long[] __DNA__FIELD__integrator = new long[]{184L, 224L};
   public static final long[] __DNA__FIELD__rotfrom = new long[]{186L, 226L};
   public static final long[] __DNA__FIELD__kink = new long[]{188L, 228L};
   public static final long[] __DNA__FIELD__kink_axis = new long[]{190L, 230L};
   public static final long[] __DNA__FIELD__bb_align = new long[]{192L, 232L};
   public static final long[] __DNA__FIELD__bb_uv_split = new long[]{194L, 234L};
   public static final long[] __DNA__FIELD__bb_anim = new long[]{196L, 236L};
   public static final long[] __DNA__FIELD__bb_split_offset = new long[]{198L, 238L};
   public static final long[] __DNA__FIELD__bb_tilt = new long[]{200L, 240L};
   public static final long[] __DNA__FIELD__bb_rand_tilt = new long[]{204L, 244L};
   public static final long[] __DNA__FIELD__bb_offset = new long[]{208L, 248L};
   public static final long[] __DNA__FIELD__bb_size = new long[]{216L, 256L};
   public static final long[] __DNA__FIELD__bb_vel_head = new long[]{224L, 264L};
   public static final long[] __DNA__FIELD__bb_vel_tail = new long[]{228L, 268L};
   public static final long[] __DNA__FIELD__color_vec_max = new long[]{232L, 272L};
   public static final long[] __DNA__FIELD__simplify_flag = new long[]{236L, 276L};
   public static final long[] __DNA__FIELD__simplify_refsize = new long[]{238L, 278L};
   public static final long[] __DNA__FIELD__simplify_rate = new long[]{240L, 280L};
   public static final long[] __DNA__FIELD__simplify_transition = new long[]{244L, 284L};
   public static final long[] __DNA__FIELD__simplify_viewport = new long[]{248L, 288L};
   public static final long[] __DNA__FIELD__sta = new long[]{252L, 292L};
   public static final long[] __DNA__FIELD__end = new long[]{256L, 296L};
   public static final long[] __DNA__FIELD__lifetime = new long[]{260L, 300L};
   public static final long[] __DNA__FIELD__randlife = new long[]{264L, 304L};
   public static final long[] __DNA__FIELD__timetweak = new long[]{268L, 308L};
   public static final long[] __DNA__FIELD__courant_target = new long[]{272L, 312L};
   public static final long[] __DNA__FIELD__jitfac = new long[]{276L, 316L};
   public static final long[] __DNA__FIELD__eff_hair = new long[]{280L, 320L};
   public static final long[] __DNA__FIELD__grid_rand = new long[]{284L, 324L};
   public static final long[] __DNA__FIELD__ps_offset = new long[]{288L, 328L};
   public static final long[] __DNA__FIELD__totpart = new long[]{292L, 332L};
   public static final long[] __DNA__FIELD__userjit = new long[]{296L, 336L};
   public static final long[] __DNA__FIELD__grid_res = new long[]{300L, 340L};
   public static final long[] __DNA__FIELD__effector_amount = new long[]{304L, 344L};
   public static final long[] __DNA__FIELD__time_flag = new long[]{308L, 348L};
   public static final long[] __DNA__FIELD__time_pad = new long[]{310L, 350L};
   public static final long[] __DNA__FIELD__normfac = new long[]{316L, 356L};
   public static final long[] __DNA__FIELD__obfac = new long[]{320L, 360L};
   public static final long[] __DNA__FIELD__randfac = new long[]{324L, 364L};
   public static final long[] __DNA__FIELD__partfac = new long[]{328L, 368L};
   public static final long[] __DNA__FIELD__tanfac = new long[]{332L, 372L};
   public static final long[] __DNA__FIELD__tanphase = new long[]{336L, 376L};
   public static final long[] __DNA__FIELD__reactfac = new long[]{340L, 380L};
   public static final long[] __DNA__FIELD__ob_vel = new long[]{344L, 384L};
   public static final long[] __DNA__FIELD__avefac = new long[]{356L, 396L};
   public static final long[] __DNA__FIELD__phasefac = new long[]{360L, 400L};
   public static final long[] __DNA__FIELD__randrotfac = new long[]{364L, 404L};
   public static final long[] __DNA__FIELD__randphasefac = new long[]{368L, 408L};
   public static final long[] __DNA__FIELD__mass = new long[]{372L, 412L};
   public static final long[] __DNA__FIELD__size = new long[]{376L, 416L};
   public static final long[] __DNA__FIELD__randsize = new long[]{380L, 420L};
   public static final long[] __DNA__FIELD__acc = new long[]{384L, 424L};
   public static final long[] __DNA__FIELD__dragfac = new long[]{396L, 436L};
   public static final long[] __DNA__FIELD__brownfac = new long[]{400L, 440L};
   public static final long[] __DNA__FIELD__dampfac = new long[]{404L, 444L};
   public static final long[] __DNA__FIELD__randlength = new long[]{408L, 448L};
   public static final long[] __DNA__FIELD__child_flag = new long[]{412L, 452L};
   public static final long[] __DNA__FIELD__pad3 = new long[]{416L, 456L};
   public static final long[] __DNA__FIELD__child_nbr = new long[]{420L, 460L};
   public static final long[] __DNA__FIELD__ren_child_nbr = new long[]{424L, 464L};
   public static final long[] __DNA__FIELD__parents = new long[]{428L, 468L};
   public static final long[] __DNA__FIELD__childsize = new long[]{432L, 472L};
   public static final long[] __DNA__FIELD__childrandsize = new long[]{436L, 476L};
   public static final long[] __DNA__FIELD__childrad = new long[]{440L, 480L};
   public static final long[] __DNA__FIELD__childflat = new long[]{444L, 484L};
   public static final long[] __DNA__FIELD__clumpfac = new long[]{448L, 488L};
   public static final long[] __DNA__FIELD__clumppow = new long[]{452L, 492L};
   public static final long[] __DNA__FIELD__kink_amp = new long[]{456L, 496L};
   public static final long[] __DNA__FIELD__kink_freq = new long[]{460L, 500L};
   public static final long[] __DNA__FIELD__kink_shape = new long[]{464L, 504L};
   public static final long[] __DNA__FIELD__kink_flat = new long[]{468L, 508L};
   public static final long[] __DNA__FIELD__kink_amp_clump = new long[]{472L, 512L};
   public static final long[] __DNA__FIELD__kink_extra_steps = new long[]{476L, 516L};
   public static final long[] __DNA__FIELD__pad4 = new long[]{480L, 520L};
   public static final long[] __DNA__FIELD__kink_axis_random = new long[]{484L, 524L};
   public static final long[] __DNA__FIELD__kink_amp_random = new long[]{488L, 528L};
   public static final long[] __DNA__FIELD__rough1 = new long[]{492L, 532L};
   public static final long[] __DNA__FIELD__rough1_size = new long[]{496L, 536L};
   public static final long[] __DNA__FIELD__rough2 = new long[]{500L, 540L};
   public static final long[] __DNA__FIELD__rough2_size = new long[]{504L, 544L};
   public static final long[] __DNA__FIELD__rough2_thres = new long[]{508L, 548L};
   public static final long[] __DNA__FIELD__rough_end = new long[]{512L, 552L};
   public static final long[] __DNA__FIELD__rough_end_shape = new long[]{516L, 556L};
   public static final long[] __DNA__FIELD__clength = new long[]{520L, 560L};
   public static final long[] __DNA__FIELD__clength_thres = new long[]{524L, 564L};
   public static final long[] __DNA__FIELD__parting_fac = new long[]{528L, 568L};
   public static final long[] __DNA__FIELD__parting_min = new long[]{532L, 572L};
   public static final long[] __DNA__FIELD__parting_max = new long[]{536L, 576L};
   public static final long[] __DNA__FIELD__branch_thres = new long[]{540L, 580L};
   public static final long[] __DNA__FIELD__draw_line = new long[]{544L, 584L};
   public static final long[] __DNA__FIELD__path_start = new long[]{552L, 592L};
   public static final long[] __DNA__FIELD__path_end = new long[]{556L, 596L};
   public static final long[] __DNA__FIELD__trail_count = new long[]{560L, 600L};
   public static final long[] __DNA__FIELD__keyed_loops = new long[]{564L, 604L};
   public static final long[] __DNA__FIELD__clumpcurve = new long[]{568L, 608L};
   public static final long[] __DNA__FIELD__roughcurve = new long[]{572L, 616L};
   public static final long[] __DNA__FIELD__clump_noise_size = new long[]{576L, 624L};
   public static final long[] __DNA__FIELD__bending_random = new long[]{580L, 628L};
   public static final long[] __DNA__FIELD__mtex = new long[]{584L, 632L};
   public static final long[] __DNA__FIELD__dup_group = new long[]{656L, 776L};
   public static final long[] __DNA__FIELD__dupliweights = new long[]{660L, 784L};
   public static final long[] __DNA__FIELD__eff_group = new long[]{668L, 800L};
   public static final long[] __DNA__FIELD__dup_ob = new long[]{672L, 808L};
   public static final long[] __DNA__FIELD__bb_ob = new long[]{676L, 816L};
   public static final long[] __DNA__FIELD__ipo = new long[]{680L, 824L};
   public static final long[] __DNA__FIELD__pd = new long[]{684L, 832L};
   public static final long[] __DNA__FIELD__pd2 = new long[]{688L, 840L};
   public static final long[] __DNA__FIELD__use_modifier_stack = new long[]{692L, 848L};
   public static final long[] __DNA__FIELD__pad5 = new long[]{694L, 850L};

   public ParticleSettings(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected ParticleSettings(ParticleSettings that) {
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

   public CPointer<BoidSettings> getBoids() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 128L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 104L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BoidSettings.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 538), this.__io__blockTable);
   }

   public void setBoids(CPointer<BoidSettings> boids) throws IOException {
      long __address = boids == null ? 0L : boids.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 128L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 104L, __address);
      }

   }

   public CPointer<SPHFluidSettings> getFluid() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 136L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 108L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{SPHFluidSettings.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 484), this.__io__blockTable);
   }

   public void setFluid(CPointer<SPHFluidSettings> fluid) throws IOException {
      long __address = fluid == null ? 0L : fluid.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 136L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 108L, __address);
      }

   }

   public CPointer<EffectorWeights> getEffector_weights() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 144L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 112L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{EffectorWeights.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 157), this.__io__blockTable);
   }

   public void setEffector_weights(CPointer<EffectorWeights> effector_weights) throws IOException {
      long __address = effector_weights == null ? 0L : effector_weights.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 144L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 112L, __address);
      }

   }

   public CPointer<Group> getCollision_group() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 152L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 116L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Group.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 341), this.__io__blockTable);
   }

   public void setCollision_group(CPointer<Group> collision_group) throws IOException {
      long __address = collision_group == null ? 0L : collision_group.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 152L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 116L, __address);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 160L) : this.__io__block.readInt(this.__io__address + 120L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 160L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 120L, flag);
      }

   }

   public int getRt() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 164L) : this.__io__block.readInt(this.__io__address + 124L);
   }

   public void setRt(int rt) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 164L, rt);
      } else {
         this.__io__block.writeInt(this.__io__address + 124L, rt);
      }

   }

   public short getType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 168L) : this.__io__block.readShort(this.__io__address + 128L);
   }

   public void setType(short type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 168L, type);
      } else {
         this.__io__block.writeShort(this.__io__address + 128L, type);
      }

   }

   public short getFrom() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 170L) : this.__io__block.readShort(this.__io__address + 130L);
   }

   public void setFrom(short from) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 170L, from);
      } else {
         this.__io__block.writeShort(this.__io__address + 130L, from);
      }

   }

   public short getDistr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 172L) : this.__io__block.readShort(this.__io__address + 132L);
   }

   public void setDistr(short distr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 172L, distr);
      } else {
         this.__io__block.writeShort(this.__io__address + 132L, distr);
      }

   }

   public short getTexact() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 174L) : this.__io__block.readShort(this.__io__address + 134L);
   }

   public void setTexact(short texact) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 174L, texact);
      } else {
         this.__io__block.writeShort(this.__io__address + 134L, texact);
      }

   }

   public short getPhystype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 176L) : this.__io__block.readShort(this.__io__address + 136L);
   }

   public void setPhystype(short phystype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 176L, phystype);
      } else {
         this.__io__block.writeShort(this.__io__address + 136L, phystype);
      }

   }

   public short getRotmode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 178L) : this.__io__block.readShort(this.__io__address + 138L);
   }

   public void setRotmode(short rotmode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 178L, rotmode);
      } else {
         this.__io__block.writeShort(this.__io__address + 138L, rotmode);
      }

   }

   public short getAvemode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 180L) : this.__io__block.readShort(this.__io__address + 140L);
   }

   public void setAvemode(short avemode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 180L, avemode);
      } else {
         this.__io__block.writeShort(this.__io__address + 140L, avemode);
      }

   }

   public short getReactevent() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 182L) : this.__io__block.readShort(this.__io__address + 142L);
   }

   public void setReactevent(short reactevent) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 182L, reactevent);
      } else {
         this.__io__block.writeShort(this.__io__address + 142L, reactevent);
      }

   }

   public int getDraw() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 184L) : this.__io__block.readInt(this.__io__address + 144L);
   }

   public void setDraw(int draw) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 184L, draw);
      } else {
         this.__io__block.writeInt(this.__io__address + 144L, draw);
      }

   }

   public int getPad1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 188L) : this.__io__block.readInt(this.__io__address + 148L);
   }

   public void setPad1(int pad1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 188L, pad1);
      } else {
         this.__io__block.writeInt(this.__io__address + 148L, pad1);
      }

   }

   public short getDraw_as() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 192L) : this.__io__block.readShort(this.__io__address + 152L);
   }

   public void setDraw_as(short draw_as) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 192L, draw_as);
      } else {
         this.__io__block.writeShort(this.__io__address + 152L, draw_as);
      }

   }

   public short getDraw_size() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 194L) : this.__io__block.readShort(this.__io__address + 154L);
   }

   public void setDraw_size(short draw_size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 194L, draw_size);
      } else {
         this.__io__block.writeShort(this.__io__address + 154L, draw_size);
      }

   }

   public short getChildtype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 196L) : this.__io__block.readShort(this.__io__address + 156L);
   }

   public void setChildtype(short childtype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 196L, childtype);
      } else {
         this.__io__block.writeShort(this.__io__address + 156L, childtype);
      }

   }

   public short getPad2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 198L) : this.__io__block.readShort(this.__io__address + 158L);
   }

   public void setPad2(short pad2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 198L, pad2);
      } else {
         this.__io__block.writeShort(this.__io__address + 158L, pad2);
      }

   }

   public short getRen_as() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 200L) : this.__io__block.readShort(this.__io__address + 160L);
   }

   public void setRen_as(short ren_as) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 200L, ren_as);
      } else {
         this.__io__block.writeShort(this.__io__address + 160L, ren_as);
      }

   }

   public short getSubframes() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 202L) : this.__io__block.readShort(this.__io__address + 162L);
   }

   public void setSubframes(short subframes) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 202L, subframes);
      } else {
         this.__io__block.writeShort(this.__io__address + 162L, subframes);
      }

   }

   public short getDraw_col() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 204L) : this.__io__block.readShort(this.__io__address + 164L);
   }

   public void setDraw_col(short draw_col) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 204L, draw_col);
      } else {
         this.__io__block.writeShort(this.__io__address + 164L, draw_col);
      }

   }

   public short getDraw_step() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 206L) : this.__io__block.readShort(this.__io__address + 166L);
   }

   public void setDraw_step(short draw_step) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 206L, draw_step);
      } else {
         this.__io__block.writeShort(this.__io__address + 166L, draw_step);
      }

   }

   public short getRen_step() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 208L) : this.__io__block.readShort(this.__io__address + 168L);
   }

   public void setRen_step(short ren_step) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 208L, ren_step);
      } else {
         this.__io__block.writeShort(this.__io__address + 168L, ren_step);
      }

   }

   public short getHair_step() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 210L) : this.__io__block.readShort(this.__io__address + 170L);
   }

   public void setHair_step(short hair_step) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 210L, hair_step);
      } else {
         this.__io__block.writeShort(this.__io__address + 170L, hair_step);
      }

   }

   public short getKeys_step() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 212L) : this.__io__block.readShort(this.__io__address + 172L);
   }

   public void setKeys_step(short keys_step) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 212L, keys_step);
      } else {
         this.__io__block.writeShort(this.__io__address + 172L, keys_step);
      }

   }

   public short getAdapt_angle() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 214L) : this.__io__block.readShort(this.__io__address + 174L);
   }

   public void setAdapt_angle(short adapt_angle) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 214L, adapt_angle);
      } else {
         this.__io__block.writeShort(this.__io__address + 174L, adapt_angle);
      }

   }

   public short getAdapt_pix() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 216L) : this.__io__block.readShort(this.__io__address + 176L);
   }

   public void setAdapt_pix(short adapt_pix) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 216L, adapt_pix);
      } else {
         this.__io__block.writeShort(this.__io__address + 176L, adapt_pix);
      }

   }

   public short getDisp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 218L) : this.__io__block.readShort(this.__io__address + 178L);
   }

   public void setDisp(short disp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 218L, disp);
      } else {
         this.__io__block.writeShort(this.__io__address + 178L, disp);
      }

   }

   public short getOmat() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 220L) : this.__io__block.readShort(this.__io__address + 180L);
   }

   public void setOmat(short omat) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 220L, omat);
      } else {
         this.__io__block.writeShort(this.__io__address + 180L, omat);
      }

   }

   public short getInterpolation() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 222L) : this.__io__block.readShort(this.__io__address + 182L);
   }

   public void setInterpolation(short interpolation) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 222L, interpolation);
      } else {
         this.__io__block.writeShort(this.__io__address + 182L, interpolation);
      }

   }

   public short getIntegrator() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 224L) : this.__io__block.readShort(this.__io__address + 184L);
   }

   public void setIntegrator(short integrator) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 224L, integrator);
      } else {
         this.__io__block.writeShort(this.__io__address + 184L, integrator);
      }

   }

   public short getRotfrom() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 226L) : this.__io__block.readShort(this.__io__address + 186L);
   }

   public void setRotfrom(short rotfrom) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 226L, rotfrom);
      } else {
         this.__io__block.writeShort(this.__io__address + 186L, rotfrom);
      }

   }

   public short getKink() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 228L) : this.__io__block.readShort(this.__io__address + 188L);
   }

   public void setKink(short kink) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 228L, kink);
      } else {
         this.__io__block.writeShort(this.__io__address + 188L, kink);
      }

   }

   public short getKink_axis() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 230L) : this.__io__block.readShort(this.__io__address + 190L);
   }

   public void setKink_axis(short kink_axis) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 230L, kink_axis);
      } else {
         this.__io__block.writeShort(this.__io__address + 190L, kink_axis);
      }

   }

   public short getBb_align() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 232L) : this.__io__block.readShort(this.__io__address + 192L);
   }

   public void setBb_align(short bb_align) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 232L, bb_align);
      } else {
         this.__io__block.writeShort(this.__io__address + 192L, bb_align);
      }

   }

   public short getBb_uv_split() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 234L) : this.__io__block.readShort(this.__io__address + 194L);
   }

   public void setBb_uv_split(short bb_uv_split) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 234L, bb_uv_split);
      } else {
         this.__io__block.writeShort(this.__io__address + 194L, bb_uv_split);
      }

   }

   public short getBb_anim() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 236L) : this.__io__block.readShort(this.__io__address + 196L);
   }

   public void setBb_anim(short bb_anim) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 236L, bb_anim);
      } else {
         this.__io__block.writeShort(this.__io__address + 196L, bb_anim);
      }

   }

   public short getBb_split_offset() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 238L) : this.__io__block.readShort(this.__io__address + 198L);
   }

   public void setBb_split_offset(short bb_split_offset) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 238L, bb_split_offset);
      } else {
         this.__io__block.writeShort(this.__io__address + 198L, bb_split_offset);
      }

   }

   public float getBb_tilt() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 240L) : this.__io__block.readFloat(this.__io__address + 200L);
   }

   public void setBb_tilt(float bb_tilt) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 240L, bb_tilt);
      } else {
         this.__io__block.writeFloat(this.__io__address + 200L, bb_tilt);
      }

   }

   public float getBb_rand_tilt() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 244L) : this.__io__block.readFloat(this.__io__address + 204L);
   }

   public void setBb_rand_tilt(float bb_rand_tilt) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 244L, bb_rand_tilt);
      } else {
         this.__io__block.writeFloat(this.__io__address + 204L, bb_rand_tilt);
      }

   }

   public CArrayFacade<Float> getBb_offset() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 248L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 208L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setBb_offset(CArrayFacade<Float> bb_offset) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 248L;
      } else {
         __dna__offset = 208L;
      }

      if (!this.__io__equals(bb_offset, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, bb_offset)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, bb_offset);
         } else {
            __io__generic__copy(this.getBb_offset(), bb_offset);
         }

      }
   }

   public CArrayFacade<Float> getBb_size() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 256L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 216L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setBb_size(CArrayFacade<Float> bb_size) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 256L;
      } else {
         __dna__offset = 216L;
      }

      if (!this.__io__equals(bb_size, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, bb_size)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, bb_size);
         } else {
            __io__generic__copy(this.getBb_size(), bb_size);
         }

      }
   }

   public float getBb_vel_head() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 264L) : this.__io__block.readFloat(this.__io__address + 224L);
   }

   public void setBb_vel_head(float bb_vel_head) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 264L, bb_vel_head);
      } else {
         this.__io__block.writeFloat(this.__io__address + 224L, bb_vel_head);
      }

   }

   public float getBb_vel_tail() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 268L) : this.__io__block.readFloat(this.__io__address + 228L);
   }

   public void setBb_vel_tail(float bb_vel_tail) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 268L, bb_vel_tail);
      } else {
         this.__io__block.writeFloat(this.__io__address + 228L, bb_vel_tail);
      }

   }

   public float getColor_vec_max() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 272L) : this.__io__block.readFloat(this.__io__address + 232L);
   }

   public void setColor_vec_max(float color_vec_max) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 272L, color_vec_max);
      } else {
         this.__io__block.writeFloat(this.__io__address + 232L, color_vec_max);
      }

   }

   public short getSimplify_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 276L) : this.__io__block.readShort(this.__io__address + 236L);
   }

   public void setSimplify_flag(short simplify_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 276L, simplify_flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 236L, simplify_flag);
      }

   }

   public short getSimplify_refsize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 278L) : this.__io__block.readShort(this.__io__address + 238L);
   }

   public void setSimplify_refsize(short simplify_refsize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 278L, simplify_refsize);
      } else {
         this.__io__block.writeShort(this.__io__address + 238L, simplify_refsize);
      }

   }

   public float getSimplify_rate() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 280L) : this.__io__block.readFloat(this.__io__address + 240L);
   }

   public void setSimplify_rate(float simplify_rate) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 280L, simplify_rate);
      } else {
         this.__io__block.writeFloat(this.__io__address + 240L, simplify_rate);
      }

   }

   public float getSimplify_transition() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 284L) : this.__io__block.readFloat(this.__io__address + 244L);
   }

   public void setSimplify_transition(float simplify_transition) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 284L, simplify_transition);
      } else {
         this.__io__block.writeFloat(this.__io__address + 244L, simplify_transition);
      }

   }

   public float getSimplify_viewport() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 288L) : this.__io__block.readFloat(this.__io__address + 248L);
   }

   public void setSimplify_viewport(float simplify_viewport) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 288L, simplify_viewport);
      } else {
         this.__io__block.writeFloat(this.__io__address + 248L, simplify_viewport);
      }

   }

   public float getSta() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 292L) : this.__io__block.readFloat(this.__io__address + 252L);
   }

   public void setSta(float sta) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 292L, sta);
      } else {
         this.__io__block.writeFloat(this.__io__address + 252L, sta);
      }

   }

   public float getEnd() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 296L) : this.__io__block.readFloat(this.__io__address + 256L);
   }

   public void setEnd(float end) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 296L, end);
      } else {
         this.__io__block.writeFloat(this.__io__address + 256L, end);
      }

   }

   public float getLifetime() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 300L) : this.__io__block.readFloat(this.__io__address + 260L);
   }

   public void setLifetime(float lifetime) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 300L, lifetime);
      } else {
         this.__io__block.writeFloat(this.__io__address + 260L, lifetime);
      }

   }

   public float getRandlife() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 304L) : this.__io__block.readFloat(this.__io__address + 264L);
   }

   public void setRandlife(float randlife) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 304L, randlife);
      } else {
         this.__io__block.writeFloat(this.__io__address + 264L, randlife);
      }

   }

   public float getTimetweak() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 308L) : this.__io__block.readFloat(this.__io__address + 268L);
   }

   public void setTimetweak(float timetweak) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 308L, timetweak);
      } else {
         this.__io__block.writeFloat(this.__io__address + 268L, timetweak);
      }

   }

   public float getCourant_target() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 312L) : this.__io__block.readFloat(this.__io__address + 272L);
   }

   public void setCourant_target(float courant_target) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 312L, courant_target);
      } else {
         this.__io__block.writeFloat(this.__io__address + 272L, courant_target);
      }

   }

   public float getJitfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 316L) : this.__io__block.readFloat(this.__io__address + 276L);
   }

   public void setJitfac(float jitfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 316L, jitfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 276L, jitfac);
      }

   }

   public float getEff_hair() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 320L) : this.__io__block.readFloat(this.__io__address + 280L);
   }

   public void setEff_hair(float eff_hair) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 320L, eff_hair);
      } else {
         this.__io__block.writeFloat(this.__io__address + 280L, eff_hair);
      }

   }

   public float getGrid_rand() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 324L) : this.__io__block.readFloat(this.__io__address + 284L);
   }

   public void setGrid_rand(float grid_rand) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 324L, grid_rand);
      } else {
         this.__io__block.writeFloat(this.__io__address + 284L, grid_rand);
      }

   }

   public CArrayFacade<Float> getPs_offset() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{1};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 328L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 288L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPs_offset(CArrayFacade<Float> ps_offset) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 328L;
      } else {
         __dna__offset = 288L;
      }

      if (!this.__io__equals(ps_offset, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, ps_offset)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, ps_offset);
         } else {
            __io__generic__copy(this.getPs_offset(), ps_offset);
         }

      }
   }

   public int getTotpart() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 332L) : this.__io__block.readInt(this.__io__address + 292L);
   }

   public void setTotpart(int totpart) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 332L, totpart);
      } else {
         this.__io__block.writeInt(this.__io__address + 292L, totpart);
      }

   }

   public int getUserjit() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 336L) : this.__io__block.readInt(this.__io__address + 296L);
   }

   public void setUserjit(int userjit) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 336L, userjit);
      } else {
         this.__io__block.writeInt(this.__io__address + 296L, userjit);
      }

   }

   public int getGrid_res() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 340L) : this.__io__block.readInt(this.__io__address + 300L);
   }

   public void setGrid_res(int grid_res) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 340L, grid_res);
      } else {
         this.__io__block.writeInt(this.__io__address + 300L, grid_res);
      }

   }

   public int getEffector_amount() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 344L) : this.__io__block.readInt(this.__io__address + 304L);
   }

   public void setEffector_amount(int effector_amount) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 344L, effector_amount);
      } else {
         this.__io__block.writeInt(this.__io__address + 304L, effector_amount);
      }

   }

   public short getTime_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 348L) : this.__io__block.readShort(this.__io__address + 308L);
   }

   public void setTime_flag(short time_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 348L, time_flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 308L, time_flag);
      }

   }

   public CArrayFacade<Short> getTime_pad() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Short.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 350L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 310L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setTime_pad(CArrayFacade<Short> time_pad) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 350L;
      } else {
         __dna__offset = 310L;
      }

      if (!this.__io__equals(time_pad, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, time_pad)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, time_pad);
         } else {
            __io__generic__copy(this.getTime_pad(), time_pad);
         }

      }
   }

   public float getNormfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 356L) : this.__io__block.readFloat(this.__io__address + 316L);
   }

   public void setNormfac(float normfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 356L, normfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 316L, normfac);
      }

   }

   public float getObfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 360L) : this.__io__block.readFloat(this.__io__address + 320L);
   }

   public void setObfac(float obfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 360L, obfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 320L, obfac);
      }

   }

   public float getRandfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 364L) : this.__io__block.readFloat(this.__io__address + 324L);
   }

   public void setRandfac(float randfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 364L, randfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 324L, randfac);
      }

   }

   public float getPartfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 368L) : this.__io__block.readFloat(this.__io__address + 328L);
   }

   public void setPartfac(float partfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 368L, partfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 328L, partfac);
      }

   }

   public float getTanfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 372L) : this.__io__block.readFloat(this.__io__address + 332L);
   }

   public void setTanfac(float tanfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 372L, tanfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 332L, tanfac);
      }

   }

   public float getTanphase() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 376L) : this.__io__block.readFloat(this.__io__address + 336L);
   }

   public void setTanphase(float tanphase) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 376L, tanphase);
      } else {
         this.__io__block.writeFloat(this.__io__address + 336L, tanphase);
      }

   }

   public float getReactfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 380L) : this.__io__block.readFloat(this.__io__address + 340L);
   }

   public void setReactfac(float reactfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 380L, reactfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 340L, reactfac);
      }

   }

   public CArrayFacade<Float> getOb_vel() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 384L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 344L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setOb_vel(CArrayFacade<Float> ob_vel) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 384L;
      } else {
         __dna__offset = 344L;
      }

      if (!this.__io__equals(ob_vel, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, ob_vel)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, ob_vel);
         } else {
            __io__generic__copy(this.getOb_vel(), ob_vel);
         }

      }
   }

   public float getAvefac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 396L) : this.__io__block.readFloat(this.__io__address + 356L);
   }

   public void setAvefac(float avefac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 396L, avefac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 356L, avefac);
      }

   }

   public float getPhasefac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 400L) : this.__io__block.readFloat(this.__io__address + 360L);
   }

   public void setPhasefac(float phasefac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 400L, phasefac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 360L, phasefac);
      }

   }

   public float getRandrotfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 404L) : this.__io__block.readFloat(this.__io__address + 364L);
   }

   public void setRandrotfac(float randrotfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 404L, randrotfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 364L, randrotfac);
      }

   }

   public float getRandphasefac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 408L) : this.__io__block.readFloat(this.__io__address + 368L);
   }

   public void setRandphasefac(float randphasefac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 408L, randphasefac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 368L, randphasefac);
      }

   }

   public float getMass() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 412L) : this.__io__block.readFloat(this.__io__address + 372L);
   }

   public void setMass(float mass) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 412L, mass);
      } else {
         this.__io__block.writeFloat(this.__io__address + 372L, mass);
      }

   }

   public float getSize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 416L) : this.__io__block.readFloat(this.__io__address + 376L);
   }

   public void setSize(float size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 416L, size);
      } else {
         this.__io__block.writeFloat(this.__io__address + 376L, size);
      }

   }

   public float getRandsize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 420L) : this.__io__block.readFloat(this.__io__address + 380L);
   }

   public void setRandsize(float randsize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 420L, randsize);
      } else {
         this.__io__block.writeFloat(this.__io__address + 380L, randsize);
      }

   }

   public CArrayFacade<Float> getAcc() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 424L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 384L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setAcc(CArrayFacade<Float> acc) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 424L;
      } else {
         __dna__offset = 384L;
      }

      if (!this.__io__equals(acc, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, acc)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, acc);
         } else {
            __io__generic__copy(this.getAcc(), acc);
         }

      }
   }

   public float getDragfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 436L) : this.__io__block.readFloat(this.__io__address + 396L);
   }

   public void setDragfac(float dragfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 436L, dragfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 396L, dragfac);
      }

   }

   public float getBrownfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 440L) : this.__io__block.readFloat(this.__io__address + 400L);
   }

   public void setBrownfac(float brownfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 440L, brownfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 400L, brownfac);
      }

   }

   public float getDampfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 444L) : this.__io__block.readFloat(this.__io__address + 404L);
   }

   public void setDampfac(float dampfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 444L, dampfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 404L, dampfac);
      }

   }

   public float getRandlength() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 448L) : this.__io__block.readFloat(this.__io__address + 408L);
   }

   public void setRandlength(float randlength) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 448L, randlength);
      } else {
         this.__io__block.writeFloat(this.__io__address + 408L, randlength);
      }

   }

   public int getChild_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 452L) : this.__io__block.readInt(this.__io__address + 412L);
   }

   public void setChild_flag(int child_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 452L, child_flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 412L, child_flag);
      }

   }

   public int getPad3() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 456L) : this.__io__block.readInt(this.__io__address + 416L);
   }

   public void setPad3(int pad3) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 456L, pad3);
      } else {
         this.__io__block.writeInt(this.__io__address + 416L, pad3);
      }

   }

   public int getChild_nbr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 460L) : this.__io__block.readInt(this.__io__address + 420L);
   }

   public void setChild_nbr(int child_nbr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 460L, child_nbr);
      } else {
         this.__io__block.writeInt(this.__io__address + 420L, child_nbr);
      }

   }

   public int getRen_child_nbr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 464L) : this.__io__block.readInt(this.__io__address + 424L);
   }

   public void setRen_child_nbr(int ren_child_nbr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 464L, ren_child_nbr);
      } else {
         this.__io__block.writeInt(this.__io__address + 424L, ren_child_nbr);
      }

   }

   public float getParents() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 468L) : this.__io__block.readFloat(this.__io__address + 428L);
   }

   public void setParents(float parents) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 468L, parents);
      } else {
         this.__io__block.writeFloat(this.__io__address + 428L, parents);
      }

   }

   public float getChildsize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 472L) : this.__io__block.readFloat(this.__io__address + 432L);
   }

   public void setChildsize(float childsize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 472L, childsize);
      } else {
         this.__io__block.writeFloat(this.__io__address + 432L, childsize);
      }

   }

   public float getChildrandsize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 476L) : this.__io__block.readFloat(this.__io__address + 436L);
   }

   public void setChildrandsize(float childrandsize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 476L, childrandsize);
      } else {
         this.__io__block.writeFloat(this.__io__address + 436L, childrandsize);
      }

   }

   public float getChildrad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 480L) : this.__io__block.readFloat(this.__io__address + 440L);
   }

   public void setChildrad(float childrad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 480L, childrad);
      } else {
         this.__io__block.writeFloat(this.__io__address + 440L, childrad);
      }

   }

   public float getChildflat() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 484L) : this.__io__block.readFloat(this.__io__address + 444L);
   }

   public void setChildflat(float childflat) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 484L, childflat);
      } else {
         this.__io__block.writeFloat(this.__io__address + 444L, childflat);
      }

   }

   public float getClumpfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 488L) : this.__io__block.readFloat(this.__io__address + 448L);
   }

   public void setClumpfac(float clumpfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 488L, clumpfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 448L, clumpfac);
      }

   }

   public float getClumppow() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 492L) : this.__io__block.readFloat(this.__io__address + 452L);
   }

   public void setClumppow(float clumppow) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 492L, clumppow);
      } else {
         this.__io__block.writeFloat(this.__io__address + 452L, clumppow);
      }

   }

   public float getKink_amp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 496L) : this.__io__block.readFloat(this.__io__address + 456L);
   }

   public void setKink_amp(float kink_amp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 496L, kink_amp);
      } else {
         this.__io__block.writeFloat(this.__io__address + 456L, kink_amp);
      }

   }

   public float getKink_freq() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 500L) : this.__io__block.readFloat(this.__io__address + 460L);
   }

   public void setKink_freq(float kink_freq) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 500L, kink_freq);
      } else {
         this.__io__block.writeFloat(this.__io__address + 460L, kink_freq);
      }

   }

   public float getKink_shape() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 504L) : this.__io__block.readFloat(this.__io__address + 464L);
   }

   public void setKink_shape(float kink_shape) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 504L, kink_shape);
      } else {
         this.__io__block.writeFloat(this.__io__address + 464L, kink_shape);
      }

   }

   public float getKink_flat() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 508L) : this.__io__block.readFloat(this.__io__address + 468L);
   }

   public void setKink_flat(float kink_flat) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 508L, kink_flat);
      } else {
         this.__io__block.writeFloat(this.__io__address + 468L, kink_flat);
      }

   }

   public float getKink_amp_clump() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 512L) : this.__io__block.readFloat(this.__io__address + 472L);
   }

   public void setKink_amp_clump(float kink_amp_clump) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 512L, kink_amp_clump);
      } else {
         this.__io__block.writeFloat(this.__io__address + 472L, kink_amp_clump);
      }

   }

   public int getKink_extra_steps() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 516L) : this.__io__block.readInt(this.__io__address + 476L);
   }

   public void setKink_extra_steps(int kink_extra_steps) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 516L, kink_extra_steps);
      } else {
         this.__io__block.writeInt(this.__io__address + 476L, kink_extra_steps);
      }

   }

   public int getPad4() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 520L) : this.__io__block.readInt(this.__io__address + 480L);
   }

   public void setPad4(int pad4) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 520L, pad4);
      } else {
         this.__io__block.writeInt(this.__io__address + 480L, pad4);
      }

   }

   public float getKink_axis_random() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 524L) : this.__io__block.readFloat(this.__io__address + 484L);
   }

   public void setKink_axis_random(float kink_axis_random) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 524L, kink_axis_random);
      } else {
         this.__io__block.writeFloat(this.__io__address + 484L, kink_axis_random);
      }

   }

   public float getKink_amp_random() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 528L) : this.__io__block.readFloat(this.__io__address + 488L);
   }

   public void setKink_amp_random(float kink_amp_random) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 528L, kink_amp_random);
      } else {
         this.__io__block.writeFloat(this.__io__address + 488L, kink_amp_random);
      }

   }

   public float getRough1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 532L) : this.__io__block.readFloat(this.__io__address + 492L);
   }

   public void setRough1(float rough1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 532L, rough1);
      } else {
         this.__io__block.writeFloat(this.__io__address + 492L, rough1);
      }

   }

   public float getRough1_size() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 536L) : this.__io__block.readFloat(this.__io__address + 496L);
   }

   public void setRough1_size(float rough1_size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 536L, rough1_size);
      } else {
         this.__io__block.writeFloat(this.__io__address + 496L, rough1_size);
      }

   }

   public float getRough2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 540L) : this.__io__block.readFloat(this.__io__address + 500L);
   }

   public void setRough2(float rough2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 540L, rough2);
      } else {
         this.__io__block.writeFloat(this.__io__address + 500L, rough2);
      }

   }

   public float getRough2_size() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 544L) : this.__io__block.readFloat(this.__io__address + 504L);
   }

   public void setRough2_size(float rough2_size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 544L, rough2_size);
      } else {
         this.__io__block.writeFloat(this.__io__address + 504L, rough2_size);
      }

   }

   public float getRough2_thres() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 548L) : this.__io__block.readFloat(this.__io__address + 508L);
   }

   public void setRough2_thres(float rough2_thres) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 548L, rough2_thres);
      } else {
         this.__io__block.writeFloat(this.__io__address + 508L, rough2_thres);
      }

   }

   public float getRough_end() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 552L) : this.__io__block.readFloat(this.__io__address + 512L);
   }

   public void setRough_end(float rough_end) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 552L, rough_end);
      } else {
         this.__io__block.writeFloat(this.__io__address + 512L, rough_end);
      }

   }

   public float getRough_end_shape() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 556L) : this.__io__block.readFloat(this.__io__address + 516L);
   }

   public void setRough_end_shape(float rough_end_shape) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 556L, rough_end_shape);
      } else {
         this.__io__block.writeFloat(this.__io__address + 516L, rough_end_shape);
      }

   }

   public float getClength() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 560L) : this.__io__block.readFloat(this.__io__address + 520L);
   }

   public void setClength(float clength) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 560L, clength);
      } else {
         this.__io__block.writeFloat(this.__io__address + 520L, clength);
      }

   }

   public float getClength_thres() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 564L) : this.__io__block.readFloat(this.__io__address + 524L);
   }

   public void setClength_thres(float clength_thres) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 564L, clength_thres);
      } else {
         this.__io__block.writeFloat(this.__io__address + 524L, clength_thres);
      }

   }

   public float getParting_fac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 568L) : this.__io__block.readFloat(this.__io__address + 528L);
   }

   public void setParting_fac(float parting_fac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 568L, parting_fac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 528L, parting_fac);
      }

   }

   public float getParting_min() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 572L) : this.__io__block.readFloat(this.__io__address + 532L);
   }

   public void setParting_min(float parting_min) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 572L, parting_min);
      } else {
         this.__io__block.writeFloat(this.__io__address + 532L, parting_min);
      }

   }

   public float getParting_max() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 576L) : this.__io__block.readFloat(this.__io__address + 536L);
   }

   public void setParting_max(float parting_max) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 576L, parting_max);
      } else {
         this.__io__block.writeFloat(this.__io__address + 536L, parting_max);
      }

   }

   public float getBranch_thres() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 580L) : this.__io__block.readFloat(this.__io__address + 540L);
   }

   public void setBranch_thres(float branch_thres) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 580L, branch_thres);
      } else {
         this.__io__block.writeFloat(this.__io__address + 540L, branch_thres);
      }

   }

   public CArrayFacade<Float> getDraw_line() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 584L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 544L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setDraw_line(CArrayFacade<Float> draw_line) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 584L;
      } else {
         __dna__offset = 544L;
      }

      if (!this.__io__equals(draw_line, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, draw_line)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, draw_line);
         } else {
            __io__generic__copy(this.getDraw_line(), draw_line);
         }

      }
   }

   public float getPath_start() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 592L) : this.__io__block.readFloat(this.__io__address + 552L);
   }

   public void setPath_start(float path_start) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 592L, path_start);
      } else {
         this.__io__block.writeFloat(this.__io__address + 552L, path_start);
      }

   }

   public float getPath_end() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 596L) : this.__io__block.readFloat(this.__io__address + 556L);
   }

   public void setPath_end(float path_end) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 596L, path_end);
      } else {
         this.__io__block.writeFloat(this.__io__address + 556L, path_end);
      }

   }

   public int getTrail_count() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 600L) : this.__io__block.readInt(this.__io__address + 560L);
   }

   public void setTrail_count(int trail_count) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 600L, trail_count);
      } else {
         this.__io__block.writeInt(this.__io__address + 560L, trail_count);
      }

   }

   public int getKeyed_loops() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 604L) : this.__io__block.readInt(this.__io__address + 564L);
   }

   public void setKeyed_loops(int keyed_loops) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 604L, keyed_loops);
      } else {
         this.__io__block.writeInt(this.__io__address + 564L, keyed_loops);
      }

   }

   public CPointer<CurveMapping> getClumpcurve() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 608L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 568L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{CurveMapping.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 461), this.__io__blockTable);
   }

   public void setClumpcurve(CPointer<CurveMapping> clumpcurve) throws IOException {
      long __address = clumpcurve == null ? 0L : clumpcurve.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 608L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 568L, __address);
      }

   }

   public CPointer<CurveMapping> getRoughcurve() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 616L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 572L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{CurveMapping.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 461), this.__io__blockTable);
   }

   public void setRoughcurve(CPointer<CurveMapping> roughcurve) throws IOException {
      long __address = roughcurve == null ? 0L : roughcurve.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 616L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 572L, __address);
      }

   }

   public float getClump_noise_size() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 624L) : this.__io__block.readFloat(this.__io__address + 576L);
   }

   public void setClump_noise_size(float clump_noise_size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 624L, clump_noise_size);
      } else {
         this.__io__block.writeFloat(this.__io__address + 576L, clump_noise_size);
      }

   }

   public float getBending_random() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 628L) : this.__io__block.readFloat(this.__io__address + 580L);
   }

   public void setBending_random(float bending_random) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 628L, bending_random);
      } else {
         this.__io__block.writeFloat(this.__io__address + 580L, bending_random);
      }

   }

   public CArrayFacade<CPointer<MTex>> getMtex() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CPointer.class, MTex.class};
      int[] __dna__dimensions = new int[]{18};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 632L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 584L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setMtex(CArrayFacade<CPointer<MTex>> mtex) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 632L;
      } else {
         __dna__offset = 584L;
      }

      if (!this.__io__equals(mtex, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, mtex)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, mtex);
         } else {
            __io__generic__copy(this.getMtex(), mtex);
         }

      }
   }

   public CPointer<Group> getDup_group() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 776L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 656L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Group.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 341), this.__io__blockTable);
   }

   public void setDup_group(CPointer<Group> dup_group) throws IOException {
      long __address = dup_group == null ? 0L : dup_group.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 776L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 656L, __address);
      }

   }

   public ListBase getDupliweights() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 784L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 660L, this.__io__block, this.__io__blockTable);
   }

   public void setDupliweights(ListBase dupliweights) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 784L;
      } else {
         __dna__offset = 660L;
      }

      if (!this.__io__equals(dupliweights, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, dupliweights)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, dupliweights);
         } else {
            __io__generic__copy(this.getDupliweights(), dupliweights);
         }

      }
   }

   public CPointer<Group> getEff_group() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 800L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 668L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Group.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 341), this.__io__blockTable);
   }

   public void setEff_group(CPointer<Group> eff_group) throws IOException {
      long __address = eff_group == null ? 0L : eff_group.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 800L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 668L, __address);
      }

   }

   public CPointer<BlenderObject> getDup_ob() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 808L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 672L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setDup_ob(CPointer<BlenderObject> dup_ob) throws IOException {
      long __address = dup_ob == null ? 0L : dup_ob.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 808L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 672L, __address);
      }

   }

   public CPointer<BlenderObject> getBb_ob() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 816L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 676L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setBb_ob(CPointer<BlenderObject> bb_ob) throws IOException {
      long __address = bb_ob == null ? 0L : bb_ob.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 816L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 676L, __address);
      }

   }

   public CPointer<Ipo> getIpo() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 824L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 680L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Ipo.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 15), this.__io__blockTable);
   }

   public void setIpo(CPointer<Ipo> ipo) throws IOException {
      long __address = ipo == null ? 0L : ipo.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 824L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 680L, __address);
      }

   }

   public CPointer<PartDeflect> getPd() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 832L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 684L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PartDeflect.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 156), this.__io__blockTable);
   }

   public void setPd(CPointer<PartDeflect> pd) throws IOException {
      long __address = pd == null ? 0L : pd.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 832L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 684L, __address);
      }

   }

   public CPointer<PartDeflect> getPd2() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 840L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 688L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PartDeflect.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 156), this.__io__blockTable);
   }

   public void setPd2(CPointer<PartDeflect> pd2) throws IOException {
      long __address = pd2 == null ? 0L : pd2.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 840L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 688L, __address);
      }

   }

   public short getUse_modifier_stack() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 848L) : this.__io__block.readShort(this.__io__address + 692L);
   }

   public void setUse_modifier_stack(short use_modifier_stack) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 848L, use_modifier_stack);
      } else {
         this.__io__block.writeShort(this.__io__address + 692L, use_modifier_stack);
      }

   }

   public CArrayFacade<Short> getPad5() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Short.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 850L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 694L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad5(CArrayFacade<Short> pad5) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 850L;
      } else {
         __dna__offset = 694L;
      }

      if (!this.__io__equals(pad5, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad5)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad5);
         } else {
            __io__generic__copy(this.getPad5(), pad5);
         }

      }
   }

   public CPointer<ParticleSettings> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{ParticleSettings.class}, this.__io__block, this.__io__blockTable);
   }
}
