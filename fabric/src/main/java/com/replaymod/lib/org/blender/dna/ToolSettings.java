package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 808L,
   size64 = 896L
)
public class ToolSettings extends CFacade {
   public static final int __DNA__SDNA_INDEX = 199;
   public static final long[] __DNA__FIELD__vpaint = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__wpaint = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__sculpt = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__uvsculpt = new long[]{12L, 24L};
   public static final long[] __DNA__FIELD__vgroup_weight = new long[]{16L, 32L};
   public static final long[] __DNA__FIELD__doublimit = new long[]{20L, 36L};
   public static final long[] __DNA__FIELD__normalsize = new long[]{24L, 40L};
   public static final long[] __DNA__FIELD__automerge = new long[]{28L, 44L};
   public static final long[] __DNA__FIELD__selectmode = new long[]{30L, 46L};
   public static final long[] __DNA__FIELD__unwrapper = new long[]{32L, 48L};
   public static final long[] __DNA__FIELD__uvcalc_flag = new long[]{33L, 49L};
   public static final long[] __DNA__FIELD__uv_flag = new long[]{34L, 50L};
   public static final long[] __DNA__FIELD__uv_selectmode = new long[]{35L, 51L};
   public static final long[] __DNA__FIELD__uvcalc_margin = new long[]{36L, 52L};
   public static final long[] __DNA__FIELD__autoik_chainlen = new long[]{40L, 56L};
   public static final long[] __DNA__FIELD__gpencil_flags = new long[]{42L, 58L};
   public static final long[] __DNA__FIELD__gpencil_src = new long[]{43L, 59L};
   public static final long[] __DNA__FIELD__gpencil_v3d_align = new long[]{44L, 60L};
   public static final long[] __DNA__FIELD__gpencil_v2d_align = new long[]{45L, 61L};
   public static final long[] __DNA__FIELD__gpencil_seq_align = new long[]{46L, 62L};
   public static final long[] __DNA__FIELD__gpencil_ima_align = new long[]{47L, 63L};
   public static final long[] __DNA__FIELD__gp_sculpt = new long[]{48L, 64L};
   public static final long[] __DNA__FIELD__gp_interpolate = new long[]{156L, 176L};
   public static final long[] __DNA__FIELD__gp_brushes = new long[]{176L, 200L};
   public static final long[] __DNA__FIELD__imapaint = new long[]{184L, 216L};
   public static final long[] __DNA__FIELD__particle = new long[]{280L, 344L};
   public static final long[] __DNA__FIELD__proportional_size = new long[]{440L, 520L};
   public static final long[] __DNA__FIELD__select_thresh = new long[]{444L, 524L};
   public static final long[] __DNA__FIELD__autokey_mode = new long[]{448L, 528L};
   public static final long[] __DNA__FIELD__autokey_flag = new long[]{450L, 530L};
   public static final long[] __DNA__FIELD__keyframe_type = new long[]{452L, 532L};
   public static final long[] __DNA__FIELD__multires_subdiv_type = new long[]{453L, 533L};
   public static final long[] __DNA__FIELD__skgen_resolution = new long[]{454L, 534L};
   public static final long[] __DNA__FIELD__skgen_threshold_internal = new long[]{456L, 536L};
   public static final long[] __DNA__FIELD__skgen_threshold_external = new long[]{460L, 540L};
   public static final long[] __DNA__FIELD__skgen_length_ratio = new long[]{464L, 544L};
   public static final long[] __DNA__FIELD__skgen_length_limit = new long[]{468L, 548L};
   public static final long[] __DNA__FIELD__skgen_angle_limit = new long[]{472L, 552L};
   public static final long[] __DNA__FIELD__skgen_correlation_limit = new long[]{476L, 556L};
   public static final long[] __DNA__FIELD__skgen_symmetry_limit = new long[]{480L, 560L};
   public static final long[] __DNA__FIELD__skgen_retarget_angle_weight = new long[]{484L, 564L};
   public static final long[] __DNA__FIELD__skgen_retarget_length_weight = new long[]{488L, 568L};
   public static final long[] __DNA__FIELD__skgen_retarget_distance_weight = new long[]{492L, 572L};
   public static final long[] __DNA__FIELD__skgen_options = new long[]{496L, 576L};
   public static final long[] __DNA__FIELD__skgen_postpro = new long[]{498L, 578L};
   public static final long[] __DNA__FIELD__skgen_postpro_passes = new long[]{499L, 579L};
   public static final long[] __DNA__FIELD__skgen_subdivisions = new long[]{500L, 580L};
   public static final long[] __DNA__FIELD__skgen_multi_level = new long[]{503L, 583L};
   public static final long[] __DNA__FIELD__skgen_template = new long[]{504L, 584L};
   public static final long[] __DNA__FIELD__bone_sketching = new long[]{508L, 592L};
   public static final long[] __DNA__FIELD__bone_sketching_convert = new long[]{509L, 593L};
   public static final long[] __DNA__FIELD__skgen_subdivision_number = new long[]{510L, 594L};
   public static final long[] __DNA__FIELD__skgen_retarget_options = new long[]{511L, 595L};
   public static final long[] __DNA__FIELD__skgen_retarget_roll = new long[]{512L, 596L};
   public static final long[] __DNA__FIELD__skgen_side_string = new long[]{513L, 597L};
   public static final long[] __DNA__FIELD__skgen_num_string = new long[]{521L, 605L};
   public static final long[] __DNA__FIELD__edge_mode = new long[]{529L, 613L};
   public static final long[] __DNA__FIELD__edge_mode_live_unwrap = new long[]{530L, 614L};
   public static final long[] __DNA__FIELD__snap_mode = new long[]{531L, 615L};
   public static final long[] __DNA__FIELD__snap_node_mode = new long[]{532L, 616L};
   public static final long[] __DNA__FIELD__snap_uv_mode = new long[]{533L, 617L};
   public static final long[] __DNA__FIELD__snap_flag = new long[]{534L, 618L};
   public static final long[] __DNA__FIELD__snap_target = new long[]{536L, 620L};
   public static final long[] __DNA__FIELD__proportional = new long[]{538L, 622L};
   public static final long[] __DNA__FIELD__prop_mode = new long[]{540L, 624L};
   public static final long[] __DNA__FIELD__proportional_objects = new long[]{542L, 626L};
   public static final long[] __DNA__FIELD__proportional_mask = new long[]{543L, 627L};
   public static final long[] __DNA__FIELD__proportional_action = new long[]{544L, 628L};
   public static final long[] __DNA__FIELD__proportional_fcurve = new long[]{545L, 629L};
   public static final long[] __DNA__FIELD__lock_markers = new long[]{546L, 630L};
   public static final long[] __DNA__FIELD__pad4 = new long[]{547L, 631L};
   public static final long[] __DNA__FIELD__auto_normalize = new long[]{552L, 636L};
   public static final long[] __DNA__FIELD__multipaint = new long[]{553L, 637L};
   public static final long[] __DNA__FIELD__weightuser = new long[]{554L, 638L};
   public static final long[] __DNA__FIELD__vgroupsubset = new long[]{555L, 639L};
   public static final long[] __DNA__FIELD__use_uv_sculpt = new long[]{556L, 640L};
   public static final long[] __DNA__FIELD__uv_sculpt_settings = new long[]{560L, 644L};
   public static final long[] __DNA__FIELD__uv_sculpt_tool = new long[]{564L, 648L};
   public static final long[] __DNA__FIELD__uv_relax_method = new long[]{568L, 652L};
   public static final long[] __DNA__FIELD__sculpt_paint_settings = new long[]{572L, 656L};
   public static final long[] __DNA__FIELD__pad5 = new long[]{574L, 658L};
   public static final long[] __DNA__FIELD__sculpt_paint_unified_size = new long[]{576L, 660L};
   public static final long[] __DNA__FIELD__sculpt_paint_unified_unprojected_radius = new long[]{580L, 664L};
   public static final long[] __DNA__FIELD__sculpt_paint_unified_alpha = new long[]{584L, 668L};
   public static final long[] __DNA__FIELD__unified_paint_settings = new long[]{588L, 672L};
   public static final long[] __DNA__FIELD__curve_paint_settings = new long[]{736L, 824L};
   public static final long[] __DNA__FIELD__statvis = new long[]{768L, 856L};

   public ToolSettings(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected ToolSettings(ToolSettings that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<VPaint> getVpaint() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{VPaint.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 191), this.__io__blockTable);
   }

   public void setVpaint(CPointer<VPaint> vpaint) throws IOException {
      long __address = vpaint == null ? 0L : vpaint.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<VPaint> getWpaint() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{VPaint.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 191), this.__io__blockTable);
   }

   public void setWpaint(CPointer<VPaint> wpaint) throws IOException {
      long __address = wpaint == null ? 0L : wpaint.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public CPointer<Sculpt> getSculpt() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Sculpt.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 189), this.__io__blockTable);
   }

   public void setSculpt(CPointer<Sculpt> sculpt) throws IOException {
      long __address = sculpt == null ? 0L : sculpt.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      }

   }

   public CPointer<UvSculpt> getUvsculpt() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 24L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 12L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{UvSculpt.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 190), this.__io__blockTable);
   }

   public void setUvsculpt(CPointer<UvSculpt> uvsculpt) throws IOException {
      long __address = uvsculpt == null ? 0L : uvsculpt.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 24L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 12L, __address);
      }

   }

   public float getVgroup_weight() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 32L) : this.__io__block.readFloat(this.__io__address + 16L);
   }

   public void setVgroup_weight(float vgroup_weight) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 32L, vgroup_weight);
      } else {
         this.__io__block.writeFloat(this.__io__address + 16L, vgroup_weight);
      }

   }

   public float getDoublimit() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 36L) : this.__io__block.readFloat(this.__io__address + 20L);
   }

   public void setDoublimit(float doublimit) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 36L, doublimit);
      } else {
         this.__io__block.writeFloat(this.__io__address + 20L, doublimit);
      }

   }

   public float getNormalsize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 40L) : this.__io__block.readFloat(this.__io__address + 24L);
   }

   public void setNormalsize(float normalsize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 40L, normalsize);
      } else {
         this.__io__block.writeFloat(this.__io__address + 24L, normalsize);
      }

   }

   public short getAutomerge() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 44L) : this.__io__block.readShort(this.__io__address + 28L);
   }

   public void setAutomerge(short automerge) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 44L, automerge);
      } else {
         this.__io__block.writeShort(this.__io__address + 28L, automerge);
      }

   }

   public short getSelectmode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 46L) : this.__io__block.readShort(this.__io__address + 30L);
   }

   public void setSelectmode(short selectmode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 46L, selectmode);
      } else {
         this.__io__block.writeShort(this.__io__address + 30L, selectmode);
      }

   }

   public byte getUnwrapper() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 48L) : this.__io__block.readByte(this.__io__address + 32L);
   }

   public void setUnwrapper(byte unwrapper) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 48L, unwrapper);
      } else {
         this.__io__block.writeByte(this.__io__address + 32L, unwrapper);
      }

   }

   public byte getUvcalc_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 49L) : this.__io__block.readByte(this.__io__address + 33L);
   }

   public void setUvcalc_flag(byte uvcalc_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 49L, uvcalc_flag);
      } else {
         this.__io__block.writeByte(this.__io__address + 33L, uvcalc_flag);
      }

   }

   public byte getUv_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 50L) : this.__io__block.readByte(this.__io__address + 34L);
   }

   public void setUv_flag(byte uv_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 50L, uv_flag);
      } else {
         this.__io__block.writeByte(this.__io__address + 34L, uv_flag);
      }

   }

   public byte getUv_selectmode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 51L) : this.__io__block.readByte(this.__io__address + 35L);
   }

   public void setUv_selectmode(byte uv_selectmode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 51L, uv_selectmode);
      } else {
         this.__io__block.writeByte(this.__io__address + 35L, uv_selectmode);
      }

   }

   public float getUvcalc_margin() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 52L) : this.__io__block.readFloat(this.__io__address + 36L);
   }

   public void setUvcalc_margin(float uvcalc_margin) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 52L, uvcalc_margin);
      } else {
         this.__io__block.writeFloat(this.__io__address + 36L, uvcalc_margin);
      }

   }

   public short getAutoik_chainlen() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 56L) : this.__io__block.readShort(this.__io__address + 40L);
   }

   public void setAutoik_chainlen(short autoik_chainlen) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 56L, autoik_chainlen);
      } else {
         this.__io__block.writeShort(this.__io__address + 40L, autoik_chainlen);
      }

   }

   public byte getGpencil_flags() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 58L) : this.__io__block.readByte(this.__io__address + 42L);
   }

   public void setGpencil_flags(byte gpencil_flags) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 58L, gpencil_flags);
      } else {
         this.__io__block.writeByte(this.__io__address + 42L, gpencil_flags);
      }

   }

   public byte getGpencil_src() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 59L) : this.__io__block.readByte(this.__io__address + 43L);
   }

   public void setGpencil_src(byte gpencil_src) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 59L, gpencil_src);
      } else {
         this.__io__block.writeByte(this.__io__address + 43L, gpencil_src);
      }

   }

   public byte getGpencil_v3d_align() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 60L) : this.__io__block.readByte(this.__io__address + 44L);
   }

   public void setGpencil_v3d_align(byte gpencil_v3d_align) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 60L, gpencil_v3d_align);
      } else {
         this.__io__block.writeByte(this.__io__address + 44L, gpencil_v3d_align);
      }

   }

   public byte getGpencil_v2d_align() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 61L) : this.__io__block.readByte(this.__io__address + 45L);
   }

   public void setGpencil_v2d_align(byte gpencil_v2d_align) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 61L, gpencil_v2d_align);
      } else {
         this.__io__block.writeByte(this.__io__address + 45L, gpencil_v2d_align);
      }

   }

   public byte getGpencil_seq_align() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 62L) : this.__io__block.readByte(this.__io__address + 46L);
   }

   public void setGpencil_seq_align(byte gpencil_seq_align) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 62L, gpencil_seq_align);
      } else {
         this.__io__block.writeByte(this.__io__address + 46L, gpencil_seq_align);
      }

   }

   public byte getGpencil_ima_align() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 63L) : this.__io__block.readByte(this.__io__address + 47L);
   }

   public void setGpencil_ima_align(byte gpencil_ima_align) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 63L, gpencil_ima_align);
      } else {
         this.__io__block.writeByte(this.__io__address + 47L, gpencil_ima_align);
      }

   }

   public GP_BrushEdit_Settings getGp_sculpt() throws IOException {
      return this.__io__pointersize == 8 ? new GP_BrushEdit_Settings(this.__io__address + 64L, this.__io__block, this.__io__blockTable) : new GP_BrushEdit_Settings(this.__io__address + 48L, this.__io__block, this.__io__blockTable);
   }

   public void setGp_sculpt(GP_BrushEdit_Settings gp_sculpt) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 64L;
      } else {
         __dna__offset = 48L;
      }

      if (!this.__io__equals(gp_sculpt, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, gp_sculpt)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, gp_sculpt);
         } else {
            __io__generic__copy(this.getGp_sculpt(), gp_sculpt);
         }

      }
   }

   public GP_Interpolate_Settings getGp_interpolate() throws IOException {
      return this.__io__pointersize == 8 ? new GP_Interpolate_Settings(this.__io__address + 176L, this.__io__block, this.__io__blockTable) : new GP_Interpolate_Settings(this.__io__address + 156L, this.__io__block, this.__io__blockTable);
   }

   public void setGp_interpolate(GP_Interpolate_Settings gp_interpolate) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 176L;
      } else {
         __dna__offset = 156L;
      }

      if (!this.__io__equals(gp_interpolate, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, gp_interpolate)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, gp_interpolate);
         } else {
            __io__generic__copy(this.getGp_interpolate(), gp_interpolate);
         }

      }
   }

   public ListBase getGp_brushes() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 200L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 176L, this.__io__block, this.__io__blockTable);
   }

   public void setGp_brushes(ListBase gp_brushes) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 200L;
      } else {
         __dna__offset = 176L;
      }

      if (!this.__io__equals(gp_brushes, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, gp_brushes)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, gp_brushes);
         } else {
            __io__generic__copy(this.getGp_brushes(), gp_brushes);
         }

      }
   }

   public ImagePaintSettings getImapaint() throws IOException {
      return this.__io__pointersize == 8 ? new ImagePaintSettings(this.__io__address + 216L, this.__io__block, this.__io__blockTable) : new ImagePaintSettings(this.__io__address + 184L, this.__io__block, this.__io__blockTable);
   }

   public void setImapaint(ImagePaintSettings imapaint) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 216L;
      } else {
         __dna__offset = 184L;
      }

      if (!this.__io__equals(imapaint, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, imapaint)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, imapaint);
         } else {
            __io__generic__copy(this.getImapaint(), imapaint);
         }

      }
   }

   public ParticleEditSettings getParticle() throws IOException {
      return this.__io__pointersize == 8 ? new ParticleEditSettings(this.__io__address + 344L, this.__io__block, this.__io__blockTable) : new ParticleEditSettings(this.__io__address + 280L, this.__io__block, this.__io__blockTable);
   }

   public void setParticle(ParticleEditSettings particle) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 344L;
      } else {
         __dna__offset = 280L;
      }

      if (!this.__io__equals(particle, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, particle)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, particle);
         } else {
            __io__generic__copy(this.getParticle(), particle);
         }

      }
   }

   public float getProportional_size() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 520L) : this.__io__block.readFloat(this.__io__address + 440L);
   }

   public void setProportional_size(float proportional_size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 520L, proportional_size);
      } else {
         this.__io__block.writeFloat(this.__io__address + 440L, proportional_size);
      }

   }

   public float getSelect_thresh() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 524L) : this.__io__block.readFloat(this.__io__address + 444L);
   }

   public void setSelect_thresh(float select_thresh) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 524L, select_thresh);
      } else {
         this.__io__block.writeFloat(this.__io__address + 444L, select_thresh);
      }

   }

   public short getAutokey_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 528L) : this.__io__block.readShort(this.__io__address + 448L);
   }

   public void setAutokey_mode(short autokey_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 528L, autokey_mode);
      } else {
         this.__io__block.writeShort(this.__io__address + 448L, autokey_mode);
      }

   }

   public short getAutokey_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 530L) : this.__io__block.readShort(this.__io__address + 450L);
   }

   public void setAutokey_flag(short autokey_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 530L, autokey_flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 450L, autokey_flag);
      }

   }

   public byte getKeyframe_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 532L) : this.__io__block.readByte(this.__io__address + 452L);
   }

   public void setKeyframe_type(byte keyframe_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 532L, keyframe_type);
      } else {
         this.__io__block.writeByte(this.__io__address + 452L, keyframe_type);
      }

   }

   public byte getMultires_subdiv_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 533L) : this.__io__block.readByte(this.__io__address + 453L);
   }

   public void setMultires_subdiv_type(byte multires_subdiv_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 533L, multires_subdiv_type);
      } else {
         this.__io__block.writeByte(this.__io__address + 453L, multires_subdiv_type);
      }

   }

   public short getSkgen_resolution() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 534L) : this.__io__block.readShort(this.__io__address + 454L);
   }

   public void setSkgen_resolution(short skgen_resolution) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 534L, skgen_resolution);
      } else {
         this.__io__block.writeShort(this.__io__address + 454L, skgen_resolution);
      }

   }

   public float getSkgen_threshold_internal() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 536L) : this.__io__block.readFloat(this.__io__address + 456L);
   }

   public void setSkgen_threshold_internal(float skgen_threshold_internal) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 536L, skgen_threshold_internal);
      } else {
         this.__io__block.writeFloat(this.__io__address + 456L, skgen_threshold_internal);
      }

   }

   public float getSkgen_threshold_external() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 540L) : this.__io__block.readFloat(this.__io__address + 460L);
   }

   public void setSkgen_threshold_external(float skgen_threshold_external) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 540L, skgen_threshold_external);
      } else {
         this.__io__block.writeFloat(this.__io__address + 460L, skgen_threshold_external);
      }

   }

   public float getSkgen_length_ratio() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 544L) : this.__io__block.readFloat(this.__io__address + 464L);
   }

   public void setSkgen_length_ratio(float skgen_length_ratio) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 544L, skgen_length_ratio);
      } else {
         this.__io__block.writeFloat(this.__io__address + 464L, skgen_length_ratio);
      }

   }

   public float getSkgen_length_limit() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 548L) : this.__io__block.readFloat(this.__io__address + 468L);
   }

   public void setSkgen_length_limit(float skgen_length_limit) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 548L, skgen_length_limit);
      } else {
         this.__io__block.writeFloat(this.__io__address + 468L, skgen_length_limit);
      }

   }

   public float getSkgen_angle_limit() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 552L) : this.__io__block.readFloat(this.__io__address + 472L);
   }

   public void setSkgen_angle_limit(float skgen_angle_limit) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 552L, skgen_angle_limit);
      } else {
         this.__io__block.writeFloat(this.__io__address + 472L, skgen_angle_limit);
      }

   }

   public float getSkgen_correlation_limit() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 556L) : this.__io__block.readFloat(this.__io__address + 476L);
   }

   public void setSkgen_correlation_limit(float skgen_correlation_limit) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 556L, skgen_correlation_limit);
      } else {
         this.__io__block.writeFloat(this.__io__address + 476L, skgen_correlation_limit);
      }

   }

   public float getSkgen_symmetry_limit() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 560L) : this.__io__block.readFloat(this.__io__address + 480L);
   }

   public void setSkgen_symmetry_limit(float skgen_symmetry_limit) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 560L, skgen_symmetry_limit);
      } else {
         this.__io__block.writeFloat(this.__io__address + 480L, skgen_symmetry_limit);
      }

   }

   public float getSkgen_retarget_angle_weight() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 564L) : this.__io__block.readFloat(this.__io__address + 484L);
   }

   public void setSkgen_retarget_angle_weight(float skgen_retarget_angle_weight) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 564L, skgen_retarget_angle_weight);
      } else {
         this.__io__block.writeFloat(this.__io__address + 484L, skgen_retarget_angle_weight);
      }

   }

   public float getSkgen_retarget_length_weight() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 568L) : this.__io__block.readFloat(this.__io__address + 488L);
   }

   public void setSkgen_retarget_length_weight(float skgen_retarget_length_weight) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 568L, skgen_retarget_length_weight);
      } else {
         this.__io__block.writeFloat(this.__io__address + 488L, skgen_retarget_length_weight);
      }

   }

   public float getSkgen_retarget_distance_weight() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 572L) : this.__io__block.readFloat(this.__io__address + 492L);
   }

   public void setSkgen_retarget_distance_weight(float skgen_retarget_distance_weight) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 572L, skgen_retarget_distance_weight);
      } else {
         this.__io__block.writeFloat(this.__io__address + 492L, skgen_retarget_distance_weight);
      }

   }

   public short getSkgen_options() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 576L) : this.__io__block.readShort(this.__io__address + 496L);
   }

   public void setSkgen_options(short skgen_options) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 576L, skgen_options);
      } else {
         this.__io__block.writeShort(this.__io__address + 496L, skgen_options);
      }

   }

   public byte getSkgen_postpro() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 578L) : this.__io__block.readByte(this.__io__address + 498L);
   }

   public void setSkgen_postpro(byte skgen_postpro) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 578L, skgen_postpro);
      } else {
         this.__io__block.writeByte(this.__io__address + 498L, skgen_postpro);
      }

   }

   public byte getSkgen_postpro_passes() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 579L) : this.__io__block.readByte(this.__io__address + 499L);
   }

   public void setSkgen_postpro_passes(byte skgen_postpro_passes) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 579L, skgen_postpro_passes);
      } else {
         this.__io__block.writeByte(this.__io__address + 499L, skgen_postpro_passes);
      }

   }

   public CArrayFacade<Byte> getSkgen_subdivisions() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 580L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 500L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setSkgen_subdivisions(CArrayFacade<Byte> skgen_subdivisions) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 580L;
      } else {
         __dna__offset = 500L;
      }

      if (!this.__io__equals(skgen_subdivisions, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, skgen_subdivisions)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, skgen_subdivisions);
         } else {
            __io__generic__copy(this.getSkgen_subdivisions(), skgen_subdivisions);
         }

      }
   }

   public byte getSkgen_multi_level() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 583L) : this.__io__block.readByte(this.__io__address + 503L);
   }

   public void setSkgen_multi_level(byte skgen_multi_level) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 583L, skgen_multi_level);
      } else {
         this.__io__block.writeByte(this.__io__address + 503L, skgen_multi_level);
      }

   }

   public CPointer<BlenderObject> getSkgen_template() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 584L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 504L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setSkgen_template(CPointer<BlenderObject> skgen_template) throws IOException {
      long __address = skgen_template == null ? 0L : skgen_template.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 584L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 504L, __address);
      }

   }

   public byte getBone_sketching() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 592L) : this.__io__block.readByte(this.__io__address + 508L);
   }

   public void setBone_sketching(byte bone_sketching) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 592L, bone_sketching);
      } else {
         this.__io__block.writeByte(this.__io__address + 508L, bone_sketching);
      }

   }

   public byte getBone_sketching_convert() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 593L) : this.__io__block.readByte(this.__io__address + 509L);
   }

   public void setBone_sketching_convert(byte bone_sketching_convert) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 593L, bone_sketching_convert);
      } else {
         this.__io__block.writeByte(this.__io__address + 509L, bone_sketching_convert);
      }

   }

   public byte getSkgen_subdivision_number() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 594L) : this.__io__block.readByte(this.__io__address + 510L);
   }

   public void setSkgen_subdivision_number(byte skgen_subdivision_number) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 594L, skgen_subdivision_number);
      } else {
         this.__io__block.writeByte(this.__io__address + 510L, skgen_subdivision_number);
      }

   }

   public byte getSkgen_retarget_options() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 595L) : this.__io__block.readByte(this.__io__address + 511L);
   }

   public void setSkgen_retarget_options(byte skgen_retarget_options) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 595L, skgen_retarget_options);
      } else {
         this.__io__block.writeByte(this.__io__address + 511L, skgen_retarget_options);
      }

   }

   public byte getSkgen_retarget_roll() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 596L) : this.__io__block.readByte(this.__io__address + 512L);
   }

   public void setSkgen_retarget_roll(byte skgen_retarget_roll) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 596L, skgen_retarget_roll);
      } else {
         this.__io__block.writeByte(this.__io__address + 512L, skgen_retarget_roll);
      }

   }

   public CArrayFacade<Byte> getSkgen_side_string() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{8};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 597L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 513L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setSkgen_side_string(CArrayFacade<Byte> skgen_side_string) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 597L;
      } else {
         __dna__offset = 513L;
      }

      if (!this.__io__equals(skgen_side_string, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, skgen_side_string)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, skgen_side_string);
         } else {
            __io__generic__copy(this.getSkgen_side_string(), skgen_side_string);
         }

      }
   }

   public CArrayFacade<Byte> getSkgen_num_string() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{8};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 605L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 521L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setSkgen_num_string(CArrayFacade<Byte> skgen_num_string) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 605L;
      } else {
         __dna__offset = 521L;
      }

      if (!this.__io__equals(skgen_num_string, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, skgen_num_string)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, skgen_num_string);
         } else {
            __io__generic__copy(this.getSkgen_num_string(), skgen_num_string);
         }

      }
   }

   public byte getEdge_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 613L) : this.__io__block.readByte(this.__io__address + 529L);
   }

   public void setEdge_mode(byte edge_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 613L, edge_mode);
      } else {
         this.__io__block.writeByte(this.__io__address + 529L, edge_mode);
      }

   }

   public byte getEdge_mode_live_unwrap() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 614L) : this.__io__block.readByte(this.__io__address + 530L);
   }

   public void setEdge_mode_live_unwrap(byte edge_mode_live_unwrap) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 614L, edge_mode_live_unwrap);
      } else {
         this.__io__block.writeByte(this.__io__address + 530L, edge_mode_live_unwrap);
      }

   }

   public byte getSnap_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 615L) : this.__io__block.readByte(this.__io__address + 531L);
   }

   public void setSnap_mode(byte snap_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 615L, snap_mode);
      } else {
         this.__io__block.writeByte(this.__io__address + 531L, snap_mode);
      }

   }

   public byte getSnap_node_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 616L) : this.__io__block.readByte(this.__io__address + 532L);
   }

   public void setSnap_node_mode(byte snap_node_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 616L, snap_node_mode);
      } else {
         this.__io__block.writeByte(this.__io__address + 532L, snap_node_mode);
      }

   }

   public byte getSnap_uv_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 617L) : this.__io__block.readByte(this.__io__address + 533L);
   }

   public void setSnap_uv_mode(byte snap_uv_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 617L, snap_uv_mode);
      } else {
         this.__io__block.writeByte(this.__io__address + 533L, snap_uv_mode);
      }

   }

   public short getSnap_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 618L) : this.__io__block.readShort(this.__io__address + 534L);
   }

   public void setSnap_flag(short snap_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 618L, snap_flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 534L, snap_flag);
      }

   }

   public short getSnap_target() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 620L) : this.__io__block.readShort(this.__io__address + 536L);
   }

   public void setSnap_target(short snap_target) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 620L, snap_target);
      } else {
         this.__io__block.writeShort(this.__io__address + 536L, snap_target);
      }

   }

   public short getProportional() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 622L) : this.__io__block.readShort(this.__io__address + 538L);
   }

   public void setProportional(short proportional) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 622L, proportional);
      } else {
         this.__io__block.writeShort(this.__io__address + 538L, proportional);
      }

   }

   public short getProp_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 624L) : this.__io__block.readShort(this.__io__address + 540L);
   }

   public void setProp_mode(short prop_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 624L, prop_mode);
      } else {
         this.__io__block.writeShort(this.__io__address + 540L, prop_mode);
      }

   }

   public byte getProportional_objects() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 626L) : this.__io__block.readByte(this.__io__address + 542L);
   }

   public void setProportional_objects(byte proportional_objects) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 626L, proportional_objects);
      } else {
         this.__io__block.writeByte(this.__io__address + 542L, proportional_objects);
      }

   }

   public byte getProportional_mask() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 627L) : this.__io__block.readByte(this.__io__address + 543L);
   }

   public void setProportional_mask(byte proportional_mask) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 627L, proportional_mask);
      } else {
         this.__io__block.writeByte(this.__io__address + 543L, proportional_mask);
      }

   }

   public byte getProportional_action() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 628L) : this.__io__block.readByte(this.__io__address + 544L);
   }

   public void setProportional_action(byte proportional_action) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 628L, proportional_action);
      } else {
         this.__io__block.writeByte(this.__io__address + 544L, proportional_action);
      }

   }

   public byte getProportional_fcurve() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 629L) : this.__io__block.readByte(this.__io__address + 545L);
   }

   public void setProportional_fcurve(byte proportional_fcurve) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 629L, proportional_fcurve);
      } else {
         this.__io__block.writeByte(this.__io__address + 545L, proportional_fcurve);
      }

   }

   public byte getLock_markers() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 630L) : this.__io__block.readByte(this.__io__address + 546L);
   }

   public void setLock_markers(byte lock_markers) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 630L, lock_markers);
      } else {
         this.__io__block.writeByte(this.__io__address + 546L, lock_markers);
      }

   }

   public CArrayFacade<Byte> getPad4() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{5};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 631L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 547L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad4(CArrayFacade<Byte> pad4) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 631L;
      } else {
         __dna__offset = 547L;
      }

      if (!this.__io__equals(pad4, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad4)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad4);
         } else {
            __io__generic__copy(this.getPad4(), pad4);
         }

      }
   }

   public byte getAuto_normalize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 636L) : this.__io__block.readByte(this.__io__address + 552L);
   }

   public void setAuto_normalize(byte auto_normalize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 636L, auto_normalize);
      } else {
         this.__io__block.writeByte(this.__io__address + 552L, auto_normalize);
      }

   }

   public byte getMultipaint() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 637L) : this.__io__block.readByte(this.__io__address + 553L);
   }

   public void setMultipaint(byte multipaint) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 637L, multipaint);
      } else {
         this.__io__block.writeByte(this.__io__address + 553L, multipaint);
      }

   }

   public byte getWeightuser() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 638L) : this.__io__block.readByte(this.__io__address + 554L);
   }

   public void setWeightuser(byte weightuser) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 638L, weightuser);
      } else {
         this.__io__block.writeByte(this.__io__address + 554L, weightuser);
      }

   }

   public byte getVgroupsubset() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 639L) : this.__io__block.readByte(this.__io__address + 555L);
   }

   public void setVgroupsubset(byte vgroupsubset) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 639L, vgroupsubset);
      } else {
         this.__io__block.writeByte(this.__io__address + 555L, vgroupsubset);
      }

   }

   public int getUse_uv_sculpt() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 640L) : this.__io__block.readInt(this.__io__address + 556L);
   }

   public void setUse_uv_sculpt(int use_uv_sculpt) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 640L, use_uv_sculpt);
      } else {
         this.__io__block.writeInt(this.__io__address + 556L, use_uv_sculpt);
      }

   }

   public int getUv_sculpt_settings() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 644L) : this.__io__block.readInt(this.__io__address + 560L);
   }

   public void setUv_sculpt_settings(int uv_sculpt_settings) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 644L, uv_sculpt_settings);
      } else {
         this.__io__block.writeInt(this.__io__address + 560L, uv_sculpt_settings);
      }

   }

   public int getUv_sculpt_tool() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 648L) : this.__io__block.readInt(this.__io__address + 564L);
   }

   public void setUv_sculpt_tool(int uv_sculpt_tool) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 648L, uv_sculpt_tool);
      } else {
         this.__io__block.writeInt(this.__io__address + 564L, uv_sculpt_tool);
      }

   }

   public int getUv_relax_method() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 652L) : this.__io__block.readInt(this.__io__address + 568L);
   }

   public void setUv_relax_method(int uv_relax_method) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 652L, uv_relax_method);
      } else {
         this.__io__block.writeInt(this.__io__address + 568L, uv_relax_method);
      }

   }

   public short getSculpt_paint_settings() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 656L) : this.__io__block.readShort(this.__io__address + 572L);
   }

   public void setSculpt_paint_settings(short sculpt_paint_settings) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 656L, sculpt_paint_settings);
      } else {
         this.__io__block.writeShort(this.__io__address + 572L, sculpt_paint_settings);
      }

   }

   public short getPad5() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 658L) : this.__io__block.readShort(this.__io__address + 574L);
   }

   public void setPad5(short pad5) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 658L, pad5);
      } else {
         this.__io__block.writeShort(this.__io__address + 574L, pad5);
      }

   }

   public int getSculpt_paint_unified_size() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 660L) : this.__io__block.readInt(this.__io__address + 576L);
   }

   public void setSculpt_paint_unified_size(int sculpt_paint_unified_size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 660L, sculpt_paint_unified_size);
      } else {
         this.__io__block.writeInt(this.__io__address + 576L, sculpt_paint_unified_size);
      }

   }

   public float getSculpt_paint_unified_unprojected_radius() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 664L) : this.__io__block.readFloat(this.__io__address + 580L);
   }

   public void setSculpt_paint_unified_unprojected_radius(float sculpt_paint_unified_unprojected_radius) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 664L, sculpt_paint_unified_unprojected_radius);
      } else {
         this.__io__block.writeFloat(this.__io__address + 580L, sculpt_paint_unified_unprojected_radius);
      }

   }

   public float getSculpt_paint_unified_alpha() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 668L) : this.__io__block.readFloat(this.__io__address + 584L);
   }

   public void setSculpt_paint_unified_alpha(float sculpt_paint_unified_alpha) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 668L, sculpt_paint_unified_alpha);
      } else {
         this.__io__block.writeFloat(this.__io__address + 584L, sculpt_paint_unified_alpha);
      }

   }

   public UnifiedPaintSettings getUnified_paint_settings() throws IOException {
      return this.__io__pointersize == 8 ? new UnifiedPaintSettings(this.__io__address + 672L, this.__io__block, this.__io__blockTable) : new UnifiedPaintSettings(this.__io__address + 588L, this.__io__block, this.__io__blockTable);
   }

   public void setUnified_paint_settings(UnifiedPaintSettings unified_paint_settings) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 672L;
      } else {
         __dna__offset = 588L;
      }

      if (!this.__io__equals(unified_paint_settings, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, unified_paint_settings)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, unified_paint_settings);
         } else {
            __io__generic__copy(this.getUnified_paint_settings(), unified_paint_settings);
         }

      }
   }

   public CurvePaintSettings getCurve_paint_settings() throws IOException {
      return this.__io__pointersize == 8 ? new CurvePaintSettings(this.__io__address + 824L, this.__io__block, this.__io__blockTable) : new CurvePaintSettings(this.__io__address + 736L, this.__io__block, this.__io__blockTable);
   }

   public void setCurve_paint_settings(CurvePaintSettings curve_paint_settings) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 824L;
      } else {
         __dna__offset = 736L;
      }

      if (!this.__io__equals(curve_paint_settings, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, curve_paint_settings)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, curve_paint_settings);
         } else {
            __io__generic__copy(this.getCurve_paint_settings(), curve_paint_settings);
         }

      }
   }

   public MeshStatVis getStatvis() throws IOException {
      return this.__io__pointersize == 8 ? new MeshStatVis(this.__io__address + 856L, this.__io__block, this.__io__blockTable) : new MeshStatVis(this.__io__address + 768L, this.__io__block, this.__io__blockTable);
   }

   public void setStatvis(MeshStatVis statvis) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 856L;
      } else {
         __dna__offset = 768L;
      }

      if (!this.__io__equals(statvis, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, statvis)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, statvis);
         } else {
            __io__generic__copy(this.getStatvis(), statvis);
         }

      }
   }

   public CPointer<ToolSettings> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{ToolSettings.class}, this.__io__block, this.__io__blockTable);
   }
}
