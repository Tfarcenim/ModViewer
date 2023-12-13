package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 4336L,
   size64 = 4432L
)
public class RenderData extends CFacade {
   public static final int __DNA__SDNA_INDEX = 178;
   public static final long[] __DNA__FIELD__im_format = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__avicodecdata = new long[]{248L, 256L};
   public static final long[] __DNA__FIELD__qtcodecdata = new long[]{252L, 264L};
   public static final long[] __DNA__FIELD__qtcodecsettings = new long[]{256L, 272L};
   public static final long[] __DNA__FIELD__ffcodecdata = new long[]{320L, 336L};
   public static final long[] __DNA__FIELD__cfra = new long[]{404L, 424L};
   public static final long[] __DNA__FIELD__sfra = new long[]{408L, 428L};
   public static final long[] __DNA__FIELD__efra = new long[]{412L, 432L};
   public static final long[] __DNA__FIELD__subframe = new long[]{416L, 436L};
   public static final long[] __DNA__FIELD__psfra = new long[]{420L, 440L};
   public static final long[] __DNA__FIELD__pefra = new long[]{424L, 444L};
   public static final long[] __DNA__FIELD__images = new long[]{428L, 448L};
   public static final long[] __DNA__FIELD__framapto = new long[]{432L, 452L};
   public static final long[] __DNA__FIELD__flag = new long[]{436L, 456L};
   public static final long[] __DNA__FIELD__threads = new long[]{438L, 458L};
   public static final long[] __DNA__FIELD__framelen = new long[]{440L, 460L};
   public static final long[] __DNA__FIELD__blurfac = new long[]{444L, 464L};
   public static final long[] __DNA__FIELD__edgeR = new long[]{448L, 468L};
   public static final long[] __DNA__FIELD__edgeG = new long[]{452L, 472L};
   public static final long[] __DNA__FIELD__edgeB = new long[]{456L, 476L};
   public static final long[] __DNA__FIELD__fullscreen = new long[]{460L, 480L};
   public static final long[] __DNA__FIELD__xplay = new long[]{462L, 482L};
   public static final long[] __DNA__FIELD__yplay = new long[]{464L, 484L};
   public static final long[] __DNA__FIELD__freqplay = new long[]{466L, 486L};
   public static final long[] __DNA__FIELD__depth = new long[]{468L, 488L};
   public static final long[] __DNA__FIELD__attrib = new long[]{470L, 490L};
   public static final long[] __DNA__FIELD__frame_step = new long[]{472L, 492L};
   public static final long[] __DNA__FIELD__stereomode = new long[]{476L, 496L};
   public static final long[] __DNA__FIELD__dimensionspreset = new long[]{478L, 498L};
   public static final long[] __DNA__FIELD__filtertype = new long[]{480L, 500L};
   public static final long[] __DNA__FIELD__size = new long[]{482L, 502L};
   public static final long[] __DNA__FIELD__maximsize = new long[]{484L, 504L};
   public static final long[] __DNA__FIELD__pad6 = new long[]{486L, 506L};
   public static final long[] __DNA__FIELD__xsch = new long[]{488L, 508L};
   public static final long[] __DNA__FIELD__ysch = new long[]{492L, 512L};
   public static final long[] __DNA__FIELD__xparts = new long[]{496L, 516L};
   public static final long[] __DNA__FIELD__yparts = new long[]{498L, 518L};
   public static final long[] __DNA__FIELD__tilex = new long[]{500L, 520L};
   public static final long[] __DNA__FIELD__tiley = new long[]{504L, 524L};
   public static final long[] __DNA__FIELD__planes = new long[]{508L, 528L};
   public static final long[] __DNA__FIELD__imtype = new long[]{510L, 530L};
   public static final long[] __DNA__FIELD__subimtype = new long[]{512L, 532L};
   public static final long[] __DNA__FIELD__quality = new long[]{514L, 534L};
   public static final long[] __DNA__FIELD__displaymode = new long[]{516L, 536L};
   public static final long[] __DNA__FIELD__use_lock_interface = new long[]{518L, 538L};
   public static final long[] __DNA__FIELD__pad7 = new long[]{519L, 539L};
   public static final long[] __DNA__FIELD__scemode = new long[]{520L, 540L};
   public static final long[] __DNA__FIELD__mode = new long[]{524L, 544L};
   public static final long[] __DNA__FIELD__raytrace_options = new long[]{528L, 548L};
   public static final long[] __DNA__FIELD__raytrace_structure = new long[]{532L, 552L};
   public static final long[] __DNA__FIELD__pad1 = new long[]{534L, 554L};
   public static final long[] __DNA__FIELD__ocres = new long[]{536L, 556L};
   public static final long[] __DNA__FIELD__pad4 = new long[]{538L, 558L};
   public static final long[] __DNA__FIELD__alphamode = new long[]{540L, 560L};
   public static final long[] __DNA__FIELD__osa = new long[]{542L, 562L};
   public static final long[] __DNA__FIELD__frs_sec = new long[]{544L, 564L};
   public static final long[] __DNA__FIELD__edgeint = new long[]{546L, 566L};
   public static final long[] __DNA__FIELD__safety = new long[]{548L, 568L};
   public static final long[] __DNA__FIELD__border = new long[]{564L, 584L};
   public static final long[] __DNA__FIELD__disprect = new long[]{580L, 600L};
   public static final long[] __DNA__FIELD__layers = new long[]{596L, 616L};
   public static final long[] __DNA__FIELD__actlay = new long[]{604L, 632L};
   public static final long[] __DNA__FIELD__mblur_samples = new long[]{606L, 634L};
   public static final long[] __DNA__FIELD__xasp = new long[]{608L, 636L};
   public static final long[] __DNA__FIELD__yasp = new long[]{612L, 640L};
   public static final long[] __DNA__FIELD__frs_sec_base = new long[]{616L, 644L};
   public static final long[] __DNA__FIELD__gauss = new long[]{620L, 648L};
   public static final long[] __DNA__FIELD__color_mgt_flag = new long[]{624L, 652L};
   public static final long[] __DNA__FIELD__postgamma = new long[]{628L, 656L};
   public static final long[] __DNA__FIELD__posthue = new long[]{632L, 660L};
   public static final long[] __DNA__FIELD__postsat = new long[]{636L, 664L};
   public static final long[] __DNA__FIELD__dither_intensity = new long[]{640L, 668L};
   public static final long[] __DNA__FIELD__bake_osa = new long[]{644L, 672L};
   public static final long[] __DNA__FIELD__bake_filter = new long[]{646L, 674L};
   public static final long[] __DNA__FIELD__bake_mode = new long[]{648L, 676L};
   public static final long[] __DNA__FIELD__bake_flag = new long[]{650L, 678L};
   public static final long[] __DNA__FIELD__bake_normal_space = new long[]{652L, 680L};
   public static final long[] __DNA__FIELD__bake_quad_split = new long[]{654L, 682L};
   public static final long[] __DNA__FIELD__bake_maxdist = new long[]{656L, 684L};
   public static final long[] __DNA__FIELD__bake_biasdist = new long[]{660L, 688L};
   public static final long[] __DNA__FIELD__bake_samples = new long[]{664L, 692L};
   public static final long[] __DNA__FIELD__bake_pad = new long[]{666L, 694L};
   public static final long[] __DNA__FIELD__bake_user_scale = new long[]{668L, 696L};
   public static final long[] __DNA__FIELD__bake_pad1 = new long[]{672L, 700L};
   public static final long[] __DNA__FIELD__pic = new long[]{676L, 704L};
   public static final long[] __DNA__FIELD__stamp = new long[]{1700L, 1728L};
   public static final long[] __DNA__FIELD__stamp_font_id = new long[]{1704L, 1732L};
   public static final long[] __DNA__FIELD__pad3 = new long[]{1706L, 1734L};
   public static final long[] __DNA__FIELD__stamp_udata = new long[]{1708L, 1736L};
   public static final long[] __DNA__FIELD__fg_stamp = new long[]{2476L, 2504L};
   public static final long[] __DNA__FIELD__bg_stamp = new long[]{2492L, 2520L};
   public static final long[] __DNA__FIELD__seq_prev_type = new long[]{2508L, 2536L};
   public static final long[] __DNA__FIELD__seq_rend_type = new long[]{2509L, 2537L};
   public static final long[] __DNA__FIELD__seq_flag = new long[]{2510L, 2538L};
   public static final long[] __DNA__FIELD__pad5 = new long[]{2511L, 2539L};
   public static final long[] __DNA__FIELD__simplify_flag = new long[]{2516L, 2544L};
   public static final long[] __DNA__FIELD__simplify_subsurf = new long[]{2520L, 2548L};
   public static final long[] __DNA__FIELD__simplify_subsurf_render = new long[]{2522L, 2550L};
   public static final long[] __DNA__FIELD__simplify_shadowsamples = new long[]{2524L, 2552L};
   public static final long[] __DNA__FIELD__pad9 = new long[]{2526L, 2554L};
   public static final long[] __DNA__FIELD__simplify_particles = new long[]{2528L, 2556L};
   public static final long[] __DNA__FIELD__simplify_particles_render = new long[]{2532L, 2560L};
   public static final long[] __DNA__FIELD__simplify_aosss = new long[]{2536L, 2564L};
   public static final long[] __DNA__FIELD__cineonwhite = new long[]{2540L, 2568L};
   public static final long[] __DNA__FIELD__cineonblack = new long[]{2542L, 2570L};
   public static final long[] __DNA__FIELD__cineongamma = new long[]{2544L, 2572L};
   public static final long[] __DNA__FIELD__jp2_preset = new long[]{2548L, 2576L};
   public static final long[] __DNA__FIELD__jp2_depth = new long[]{2550L, 2578L};
   public static final long[] __DNA__FIELD__rpad3 = new long[]{2552L, 2580L};
   public static final long[] __DNA__FIELD__domeres = new long[]{2556L, 2584L};
   public static final long[] __DNA__FIELD__domemode = new long[]{2558L, 2586L};
   public static final long[] __DNA__FIELD__domeangle = new long[]{2560L, 2588L};
   public static final long[] __DNA__FIELD__dometilt = new long[]{2562L, 2590L};
   public static final long[] __DNA__FIELD__domeresbuf = new long[]{2564L, 2592L};
   public static final long[] __DNA__FIELD__pad2 = new long[]{2568L, 2596L};
   public static final long[] __DNA__FIELD__dometext = new long[]{2572L, 2600L};
   public static final long[] __DNA__FIELD__line_thickness_mode = new long[]{2576L, 2608L};
   public static final long[] __DNA__FIELD__unit_line_thickness = new long[]{2580L, 2612L};
   public static final long[] __DNA__FIELD__engine = new long[]{2584L, 2616L};
   public static final long[] __DNA__FIELD__bake = new long[]{2616L, 2648L};
   public static final long[] __DNA__FIELD__preview_start_resolution = new long[]{3976L, 4016L};
   public static final long[] __DNA__FIELD__debug_pass_type = new long[]{3980L, 4020L};
   public static final long[] __DNA__FIELD__pad = new long[]{3982L, 4022L};
   public static final long[] __DNA__FIELD__views = new long[]{3984L, 4024L};
   public static final long[] __DNA__FIELD__actview = new long[]{3992L, 4040L};
   public static final long[] __DNA__FIELD__views_format = new long[]{3994L, 4042L};
   public static final long[] __DNA__FIELD__pad8 = new long[]{3996L, 4044L};
   public static final long[] __DNA__FIELD__mblur_shutter_curve = new long[]{4000L, 4048L};

   public RenderData(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected RenderData(RenderData that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public ImageFormatData getIm_format() throws IOException {
      return this.__io__pointersize == 8 ? new ImageFormatData(this.__io__address + 0L, this.__io__block, this.__io__blockTable) : new ImageFormatData(this.__io__address + 0L, this.__io__block, this.__io__blockTable);
   }

   public void setIm_format(ImageFormatData im_format) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(im_format, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, im_format)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, im_format);
         } else {
            __io__generic__copy(this.getIm_format(), im_format);
         }

      }
   }

   public CPointer<AviCodecData> getAvicodecdata() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 256L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 248L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{AviCodecData.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 168), this.__io__blockTable);
   }

   public void setAvicodecdata(CPointer<AviCodecData> avicodecdata) throws IOException {
      long __address = avicodecdata == null ? 0L : avicodecdata.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 256L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 248L, __address);
      }

   }

   public CPointer<QuicktimeCodecData> getQtcodecdata() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 264L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 252L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{QuicktimeCodecData.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 169), this.__io__blockTable);
   }

   public void setQtcodecdata(CPointer<QuicktimeCodecData> qtcodecdata) throws IOException {
      long __address = qtcodecdata == null ? 0L : qtcodecdata.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 264L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 252L, __address);
      }

   }

   public QuicktimeCodecSettings getQtcodecsettings() throws IOException {
      return this.__io__pointersize == 8 ? new QuicktimeCodecSettings(this.__io__address + 272L, this.__io__block, this.__io__blockTable) : new QuicktimeCodecSettings(this.__io__address + 256L, this.__io__block, this.__io__blockTable);
   }

   public void setQtcodecsettings(QuicktimeCodecSettings qtcodecsettings) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 272L;
      } else {
         __dna__offset = 256L;
      }

      if (!this.__io__equals(qtcodecsettings, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, qtcodecsettings)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, qtcodecsettings);
         } else {
            __io__generic__copy(this.getQtcodecsettings(), qtcodecsettings);
         }

      }
   }

   public FFMpegCodecData getFfcodecdata() throws IOException {
      return this.__io__pointersize == 8 ? new FFMpegCodecData(this.__io__address + 336L, this.__io__block, this.__io__blockTable) : new FFMpegCodecData(this.__io__address + 320L, this.__io__block, this.__io__blockTable);
   }

   public void setFfcodecdata(FFMpegCodecData ffcodecdata) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 336L;
      } else {
         __dna__offset = 320L;
      }

      if (!this.__io__equals(ffcodecdata, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, ffcodecdata)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, ffcodecdata);
         } else {
            __io__generic__copy(this.getFfcodecdata(), ffcodecdata);
         }

      }
   }

   public int getCfra() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 424L) : this.__io__block.readInt(this.__io__address + 404L);
   }

   public void setCfra(int cfra) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 424L, cfra);
      } else {
         this.__io__block.writeInt(this.__io__address + 404L, cfra);
      }

   }

   public int getSfra() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 428L) : this.__io__block.readInt(this.__io__address + 408L);
   }

   public void setSfra(int sfra) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 428L, sfra);
      } else {
         this.__io__block.writeInt(this.__io__address + 408L, sfra);
      }

   }

   public int getEfra() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 432L) : this.__io__block.readInt(this.__io__address + 412L);
   }

   public void setEfra(int efra) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 432L, efra);
      } else {
         this.__io__block.writeInt(this.__io__address + 412L, efra);
      }

   }

   public float getSubframe() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 436L) : this.__io__block.readFloat(this.__io__address + 416L);
   }

   public void setSubframe(float subframe) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 436L, subframe);
      } else {
         this.__io__block.writeFloat(this.__io__address + 416L, subframe);
      }

   }

   public int getPsfra() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 440L) : this.__io__block.readInt(this.__io__address + 420L);
   }

   public void setPsfra(int psfra) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 440L, psfra);
      } else {
         this.__io__block.writeInt(this.__io__address + 420L, psfra);
      }

   }

   public int getPefra() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 444L) : this.__io__block.readInt(this.__io__address + 424L);
   }

   public void setPefra(int pefra) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 444L, pefra);
      } else {
         this.__io__block.writeInt(this.__io__address + 424L, pefra);
      }

   }

   public int getImages() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 448L) : this.__io__block.readInt(this.__io__address + 428L);
   }

   public void setImages(int images) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 448L, images);
      } else {
         this.__io__block.writeInt(this.__io__address + 428L, images);
      }

   }

   public int getFramapto() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 452L) : this.__io__block.readInt(this.__io__address + 432L);
   }

   public void setFramapto(int framapto) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 452L, framapto);
      } else {
         this.__io__block.writeInt(this.__io__address + 432L, framapto);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 456L) : this.__io__block.readShort(this.__io__address + 436L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 456L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 436L, flag);
      }

   }

   public short getThreads() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 458L) : this.__io__block.readShort(this.__io__address + 438L);
   }

   public void setThreads(short threads) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 458L, threads);
      } else {
         this.__io__block.writeShort(this.__io__address + 438L, threads);
      }

   }

   public float getFramelen() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 460L) : this.__io__block.readFloat(this.__io__address + 440L);
   }

   public void setFramelen(float framelen) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 460L, framelen);
      } else {
         this.__io__block.writeFloat(this.__io__address + 440L, framelen);
      }

   }

   public float getBlurfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 464L) : this.__io__block.readFloat(this.__io__address + 444L);
   }

   public void setBlurfac(float blurfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 464L, blurfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 444L, blurfac);
      }

   }

   public float getEdgeR() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 468L) : this.__io__block.readFloat(this.__io__address + 448L);
   }

   public void setEdgeR(float edgeR) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 468L, edgeR);
      } else {
         this.__io__block.writeFloat(this.__io__address + 448L, edgeR);
      }

   }

   public float getEdgeG() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 472L) : this.__io__block.readFloat(this.__io__address + 452L);
   }

   public void setEdgeG(float edgeG) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 472L, edgeG);
      } else {
         this.__io__block.writeFloat(this.__io__address + 452L, edgeG);
      }

   }

   public float getEdgeB() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 476L) : this.__io__block.readFloat(this.__io__address + 456L);
   }

   public void setEdgeB(float edgeB) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 476L, edgeB);
      } else {
         this.__io__block.writeFloat(this.__io__address + 456L, edgeB);
      }

   }

   public short getFullscreen() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 480L) : this.__io__block.readShort(this.__io__address + 460L);
   }

   public void setFullscreen(short fullscreen) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 480L, fullscreen);
      } else {
         this.__io__block.writeShort(this.__io__address + 460L, fullscreen);
      }

   }

   public short getXplay() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 482L) : this.__io__block.readShort(this.__io__address + 462L);
   }

   public void setXplay(short xplay) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 482L, xplay);
      } else {
         this.__io__block.writeShort(this.__io__address + 462L, xplay);
      }

   }

   public short getYplay() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 484L) : this.__io__block.readShort(this.__io__address + 464L);
   }

   public void setYplay(short yplay) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 484L, yplay);
      } else {
         this.__io__block.writeShort(this.__io__address + 464L, yplay);
      }

   }

   public short getFreqplay() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 486L) : this.__io__block.readShort(this.__io__address + 466L);
   }

   public void setFreqplay(short freqplay) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 486L, freqplay);
      } else {
         this.__io__block.writeShort(this.__io__address + 466L, freqplay);
      }

   }

   public short getDepth() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 488L) : this.__io__block.readShort(this.__io__address + 468L);
   }

   public void setDepth(short depth) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 488L, depth);
      } else {
         this.__io__block.writeShort(this.__io__address + 468L, depth);
      }

   }

   public short getAttrib() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 490L) : this.__io__block.readShort(this.__io__address + 470L);
   }

   public void setAttrib(short attrib) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 490L, attrib);
      } else {
         this.__io__block.writeShort(this.__io__address + 470L, attrib);
      }

   }

   public int getFrame_step() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 492L) : this.__io__block.readInt(this.__io__address + 472L);
   }

   public void setFrame_step(int frame_step) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 492L, frame_step);
      } else {
         this.__io__block.writeInt(this.__io__address + 472L, frame_step);
      }

   }

   public short getStereomode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 496L) : this.__io__block.readShort(this.__io__address + 476L);
   }

   public void setStereomode(short stereomode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 496L, stereomode);
      } else {
         this.__io__block.writeShort(this.__io__address + 476L, stereomode);
      }

   }

   public short getDimensionspreset() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 498L) : this.__io__block.readShort(this.__io__address + 478L);
   }

   public void setDimensionspreset(short dimensionspreset) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 498L, dimensionspreset);
      } else {
         this.__io__block.writeShort(this.__io__address + 478L, dimensionspreset);
      }

   }

   public short getFiltertype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 500L) : this.__io__block.readShort(this.__io__address + 480L);
   }

   public void setFiltertype(short filtertype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 500L, filtertype);
      } else {
         this.__io__block.writeShort(this.__io__address + 480L, filtertype);
      }

   }

   public short getSize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 502L) : this.__io__block.readShort(this.__io__address + 482L);
   }

   public void setSize(short size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 502L, size);
      } else {
         this.__io__block.writeShort(this.__io__address + 482L, size);
      }

   }

   public short getMaximsize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 504L) : this.__io__block.readShort(this.__io__address + 484L);
   }

   public void setMaximsize(short maximsize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 504L, maximsize);
      } else {
         this.__io__block.writeShort(this.__io__address + 484L, maximsize);
      }

   }

   public short getPad6() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 506L) : this.__io__block.readShort(this.__io__address + 486L);
   }

   public void setPad6(short pad6) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 506L, pad6);
      } else {
         this.__io__block.writeShort(this.__io__address + 486L, pad6);
      }

   }

   public int getXsch() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 508L) : this.__io__block.readInt(this.__io__address + 488L);
   }

   public void setXsch(int xsch) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 508L, xsch);
      } else {
         this.__io__block.writeInt(this.__io__address + 488L, xsch);
      }

   }

   public int getYsch() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 512L) : this.__io__block.readInt(this.__io__address + 492L);
   }

   public void setYsch(int ysch) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 512L, ysch);
      } else {
         this.__io__block.writeInt(this.__io__address + 492L, ysch);
      }

   }

   public short getXparts() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 516L) : this.__io__block.readShort(this.__io__address + 496L);
   }

   public void setXparts(short xparts) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 516L, xparts);
      } else {
         this.__io__block.writeShort(this.__io__address + 496L, xparts);
      }

   }

   public short getYparts() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 518L) : this.__io__block.readShort(this.__io__address + 498L);
   }

   public void setYparts(short yparts) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 518L, yparts);
      } else {
         this.__io__block.writeShort(this.__io__address + 498L, yparts);
      }

   }

   public int getTilex() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 520L) : this.__io__block.readInt(this.__io__address + 500L);
   }

   public void setTilex(int tilex) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 520L, tilex);
      } else {
         this.__io__block.writeInt(this.__io__address + 500L, tilex);
      }

   }

   public int getTiley() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 524L) : this.__io__block.readInt(this.__io__address + 504L);
   }

   public void setTiley(int tiley) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 524L, tiley);
      } else {
         this.__io__block.writeInt(this.__io__address + 504L, tiley);
      }

   }

   public short getPlanes() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 528L) : this.__io__block.readShort(this.__io__address + 508L);
   }

   public void setPlanes(short planes) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 528L, planes);
      } else {
         this.__io__block.writeShort(this.__io__address + 508L, planes);
      }

   }

   public short getImtype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 530L) : this.__io__block.readShort(this.__io__address + 510L);
   }

   public void setImtype(short imtype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 530L, imtype);
      } else {
         this.__io__block.writeShort(this.__io__address + 510L, imtype);
      }

   }

   public short getSubimtype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 532L) : this.__io__block.readShort(this.__io__address + 512L);
   }

   public void setSubimtype(short subimtype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 532L, subimtype);
      } else {
         this.__io__block.writeShort(this.__io__address + 512L, subimtype);
      }

   }

   public short getQuality() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 534L) : this.__io__block.readShort(this.__io__address + 514L);
   }

   public void setQuality(short quality) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 534L, quality);
      } else {
         this.__io__block.writeShort(this.__io__address + 514L, quality);
      }

   }

   public short getDisplaymode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 536L) : this.__io__block.readShort(this.__io__address + 516L);
   }

   public void setDisplaymode(short displaymode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 536L, displaymode);
      } else {
         this.__io__block.writeShort(this.__io__address + 516L, displaymode);
      }

   }

   public byte getUse_lock_interface() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 538L) : this.__io__block.readByte(this.__io__address + 518L);
   }

   public void setUse_lock_interface(byte use_lock_interface) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 538L, use_lock_interface);
      } else {
         this.__io__block.writeByte(this.__io__address + 518L, use_lock_interface);
      }

   }

   public byte getPad7() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 539L) : this.__io__block.readByte(this.__io__address + 519L);
   }

   public void setPad7(byte pad7) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 539L, pad7);
      } else {
         this.__io__block.writeByte(this.__io__address + 519L, pad7);
      }

   }

   public int getScemode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 540L) : this.__io__block.readInt(this.__io__address + 520L);
   }

   public void setScemode(int scemode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 540L, scemode);
      } else {
         this.__io__block.writeInt(this.__io__address + 520L, scemode);
      }

   }

   public int getMode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 544L) : this.__io__block.readInt(this.__io__address + 524L);
   }

   public void setMode(int mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 544L, mode);
      } else {
         this.__io__block.writeInt(this.__io__address + 524L, mode);
      }

   }

   public int getRaytrace_options() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 548L) : this.__io__block.readInt(this.__io__address + 528L);
   }

   public void setRaytrace_options(int raytrace_options) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 548L, raytrace_options);
      } else {
         this.__io__block.writeInt(this.__io__address + 528L, raytrace_options);
      }

   }

   public short getRaytrace_structure() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 552L) : this.__io__block.readShort(this.__io__address + 532L);
   }

   public void setRaytrace_structure(short raytrace_structure) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 552L, raytrace_structure);
      } else {
         this.__io__block.writeShort(this.__io__address + 532L, raytrace_structure);
      }

   }

   public short getPad1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 554L) : this.__io__block.readShort(this.__io__address + 534L);
   }

   public void setPad1(short pad1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 554L, pad1);
      } else {
         this.__io__block.writeShort(this.__io__address + 534L, pad1);
      }

   }

   public short getOcres() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 556L) : this.__io__block.readShort(this.__io__address + 536L);
   }

   public void setOcres(short ocres) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 556L, ocres);
      } else {
         this.__io__block.writeShort(this.__io__address + 536L, ocres);
      }

   }

   public short getPad4() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 558L) : this.__io__block.readShort(this.__io__address + 538L);
   }

   public void setPad4(short pad4) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 558L, pad4);
      } else {
         this.__io__block.writeShort(this.__io__address + 538L, pad4);
      }

   }

   public short getAlphamode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 560L) : this.__io__block.readShort(this.__io__address + 540L);
   }

   public void setAlphamode(short alphamode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 560L, alphamode);
      } else {
         this.__io__block.writeShort(this.__io__address + 540L, alphamode);
      }

   }

   public short getOsa() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 562L) : this.__io__block.readShort(this.__io__address + 542L);
   }

   public void setOsa(short osa) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 562L, osa);
      } else {
         this.__io__block.writeShort(this.__io__address + 542L, osa);
      }

   }

   public short getFrs_sec() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 564L) : this.__io__block.readShort(this.__io__address + 544L);
   }

   public void setFrs_sec(short frs_sec) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 564L, frs_sec);
      } else {
         this.__io__block.writeShort(this.__io__address + 544L, frs_sec);
      }

   }

   public short getEdgeint() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 566L) : this.__io__block.readShort(this.__io__address + 546L);
   }

   public void setEdgeint(short edgeint) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 566L, edgeint);
      } else {
         this.__io__block.writeShort(this.__io__address + 546L, edgeint);
      }

   }

   public rctf getSafety() throws IOException {
      return this.__io__pointersize == 8 ? new rctf(this.__io__address + 568L, this.__io__block, this.__io__blockTable) : new rctf(this.__io__address + 548L, this.__io__block, this.__io__blockTable);
   }

   public void setSafety(rctf safety) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 568L;
      } else {
         __dna__offset = 548L;
      }

      if (!this.__io__equals(safety, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, safety)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, safety);
         } else {
            __io__generic__copy(this.getSafety(), safety);
         }

      }
   }

   public rctf getBorder() throws IOException {
      return this.__io__pointersize == 8 ? new rctf(this.__io__address + 584L, this.__io__block, this.__io__blockTable) : new rctf(this.__io__address + 564L, this.__io__block, this.__io__blockTable);
   }

   public void setBorder(rctf border) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 584L;
      } else {
         __dna__offset = 564L;
      }

      if (!this.__io__equals(border, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, border)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, border);
         } else {
            __io__generic__copy(this.getBorder(), border);
         }

      }
   }

   public rcti getDisprect() throws IOException {
      return this.__io__pointersize == 8 ? new rcti(this.__io__address + 600L, this.__io__block, this.__io__blockTable) : new rcti(this.__io__address + 580L, this.__io__block, this.__io__blockTable);
   }

   public void setDisprect(rcti disprect) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 600L;
      } else {
         __dna__offset = 580L;
      }

      if (!this.__io__equals(disprect, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, disprect)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, disprect);
         } else {
            __io__generic__copy(this.getDisprect(), disprect);
         }

      }
   }

   public ListBase getLayers() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 616L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 596L, this.__io__block, this.__io__blockTable);
   }

   public void setLayers(ListBase layers) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 616L;
      } else {
         __dna__offset = 596L;
      }

      if (!this.__io__equals(layers, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, layers)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, layers);
         } else {
            __io__generic__copy(this.getLayers(), layers);
         }

      }
   }

   public short getActlay() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 632L) : this.__io__block.readShort(this.__io__address + 604L);
   }

   public void setActlay(short actlay) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 632L, actlay);
      } else {
         this.__io__block.writeShort(this.__io__address + 604L, actlay);
      }

   }

   public short getMblur_samples() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 634L) : this.__io__block.readShort(this.__io__address + 606L);
   }

   public void setMblur_samples(short mblur_samples) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 634L, mblur_samples);
      } else {
         this.__io__block.writeShort(this.__io__address + 606L, mblur_samples);
      }

   }

   public float getXasp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 636L) : this.__io__block.readFloat(this.__io__address + 608L);
   }

   public void setXasp(float xasp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 636L, xasp);
      } else {
         this.__io__block.writeFloat(this.__io__address + 608L, xasp);
      }

   }

   public float getYasp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 640L) : this.__io__block.readFloat(this.__io__address + 612L);
   }

   public void setYasp(float yasp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 640L, yasp);
      } else {
         this.__io__block.writeFloat(this.__io__address + 612L, yasp);
      }

   }

   public float getFrs_sec_base() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 644L) : this.__io__block.readFloat(this.__io__address + 616L);
   }

   public void setFrs_sec_base(float frs_sec_base) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 644L, frs_sec_base);
      } else {
         this.__io__block.writeFloat(this.__io__address + 616L, frs_sec_base);
      }

   }

   public float getGauss() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 648L) : this.__io__block.readFloat(this.__io__address + 620L);
   }

   public void setGauss(float gauss) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 648L, gauss);
      } else {
         this.__io__block.writeFloat(this.__io__address + 620L, gauss);
      }

   }

   public int getColor_mgt_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 652L) : this.__io__block.readInt(this.__io__address + 624L);
   }

   public void setColor_mgt_flag(int color_mgt_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 652L, color_mgt_flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 624L, color_mgt_flag);
      }

   }

   public float getPostgamma() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 656L) : this.__io__block.readFloat(this.__io__address + 628L);
   }

   public void setPostgamma(float postgamma) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 656L, postgamma);
      } else {
         this.__io__block.writeFloat(this.__io__address + 628L, postgamma);
      }

   }

   public float getPosthue() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 660L) : this.__io__block.readFloat(this.__io__address + 632L);
   }

   public void setPosthue(float posthue) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 660L, posthue);
      } else {
         this.__io__block.writeFloat(this.__io__address + 632L, posthue);
      }

   }

   public float getPostsat() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 664L) : this.__io__block.readFloat(this.__io__address + 636L);
   }

   public void setPostsat(float postsat) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 664L, postsat);
      } else {
         this.__io__block.writeFloat(this.__io__address + 636L, postsat);
      }

   }

   public float getDither_intensity() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 668L) : this.__io__block.readFloat(this.__io__address + 640L);
   }

   public void setDither_intensity(float dither_intensity) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 668L, dither_intensity);
      } else {
         this.__io__block.writeFloat(this.__io__address + 640L, dither_intensity);
      }

   }

   public short getBake_osa() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 672L) : this.__io__block.readShort(this.__io__address + 644L);
   }

   public void setBake_osa(short bake_osa) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 672L, bake_osa);
      } else {
         this.__io__block.writeShort(this.__io__address + 644L, bake_osa);
      }

   }

   public short getBake_filter() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 674L) : this.__io__block.readShort(this.__io__address + 646L);
   }

   public void setBake_filter(short bake_filter) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 674L, bake_filter);
      } else {
         this.__io__block.writeShort(this.__io__address + 646L, bake_filter);
      }

   }

   public short getBake_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 676L) : this.__io__block.readShort(this.__io__address + 648L);
   }

   public void setBake_mode(short bake_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 676L, bake_mode);
      } else {
         this.__io__block.writeShort(this.__io__address + 648L, bake_mode);
      }

   }

   public short getBake_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 678L) : this.__io__block.readShort(this.__io__address + 650L);
   }

   public void setBake_flag(short bake_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 678L, bake_flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 650L, bake_flag);
      }

   }

   public short getBake_normal_space() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 680L) : this.__io__block.readShort(this.__io__address + 652L);
   }

   public void setBake_normal_space(short bake_normal_space) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 680L, bake_normal_space);
      } else {
         this.__io__block.writeShort(this.__io__address + 652L, bake_normal_space);
      }

   }

   public short getBake_quad_split() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 682L) : this.__io__block.readShort(this.__io__address + 654L);
   }

   public void setBake_quad_split(short bake_quad_split) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 682L, bake_quad_split);
      } else {
         this.__io__block.writeShort(this.__io__address + 654L, bake_quad_split);
      }

   }

   public float getBake_maxdist() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 684L) : this.__io__block.readFloat(this.__io__address + 656L);
   }

   public void setBake_maxdist(float bake_maxdist) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 684L, bake_maxdist);
      } else {
         this.__io__block.writeFloat(this.__io__address + 656L, bake_maxdist);
      }

   }

   public float getBake_biasdist() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 688L) : this.__io__block.readFloat(this.__io__address + 660L);
   }

   public void setBake_biasdist(float bake_biasdist) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 688L, bake_biasdist);
      } else {
         this.__io__block.writeFloat(this.__io__address + 660L, bake_biasdist);
      }

   }

   public short getBake_samples() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 692L) : this.__io__block.readShort(this.__io__address + 664L);
   }

   public void setBake_samples(short bake_samples) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 692L, bake_samples);
      } else {
         this.__io__block.writeShort(this.__io__address + 664L, bake_samples);
      }

   }

   public short getBake_pad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 694L) : this.__io__block.readShort(this.__io__address + 666L);
   }

   public void setBake_pad(short bake_pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 694L, bake_pad);
      } else {
         this.__io__block.writeShort(this.__io__address + 666L, bake_pad);
      }

   }

   public float getBake_user_scale() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 696L) : this.__io__block.readFloat(this.__io__address + 668L);
   }

   public void setBake_user_scale(float bake_user_scale) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 696L, bake_user_scale);
      } else {
         this.__io__block.writeFloat(this.__io__address + 668L, bake_user_scale);
      }

   }

   public float getBake_pad1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 700L) : this.__io__block.readFloat(this.__io__address + 672L);
   }

   public void setBake_pad1(float bake_pad1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 700L, bake_pad1);
      } else {
         this.__io__block.writeFloat(this.__io__address + 672L, bake_pad1);
      }

   }

   public CArrayFacade<Byte> getPic() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{1024};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 704L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 676L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPic(CArrayFacade<Byte> pic) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 704L;
      } else {
         __dna__offset = 676L;
      }

      if (!this.__io__equals(pic, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pic)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pic);
         } else {
            __io__generic__copy(this.getPic(), pic);
         }

      }
   }

   public int getStamp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1728L) : this.__io__block.readInt(this.__io__address + 1700L);
   }

   public void setStamp(int stamp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1728L, stamp);
      } else {
         this.__io__block.writeInt(this.__io__address + 1700L, stamp);
      }

   }

   public short getStamp_font_id() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1732L) : this.__io__block.readShort(this.__io__address + 1704L);
   }

   public void setStamp_font_id(short stamp_font_id) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1732L, stamp_font_id);
      } else {
         this.__io__block.writeShort(this.__io__address + 1704L, stamp_font_id);
      }

   }

   public short getPad3() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1734L) : this.__io__block.readShort(this.__io__address + 1706L);
   }

   public void setPad3(short pad3) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1734L, pad3);
      } else {
         this.__io__block.writeShort(this.__io__address + 1706L, pad3);
      }

   }

   public CArrayFacade<Byte> getStamp_udata() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{768};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1736L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1708L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setStamp_udata(CArrayFacade<Byte> stamp_udata) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1736L;
      } else {
         __dna__offset = 1708L;
      }

      if (!this.__io__equals(stamp_udata, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, stamp_udata)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, stamp_udata);
         } else {
            __io__generic__copy(this.getStamp_udata(), stamp_udata);
         }

      }
   }

   public CArrayFacade<Float> getFg_stamp() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 2504L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 2476L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setFg_stamp(CArrayFacade<Float> fg_stamp) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 2504L;
      } else {
         __dna__offset = 2476L;
      }

      if (!this.__io__equals(fg_stamp, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, fg_stamp)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, fg_stamp);
         } else {
            __io__generic__copy(this.getFg_stamp(), fg_stamp);
         }

      }
   }

   public CArrayFacade<Float> getBg_stamp() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 2520L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 2492L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setBg_stamp(CArrayFacade<Float> bg_stamp) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 2520L;
      } else {
         __dna__offset = 2492L;
      }

      if (!this.__io__equals(bg_stamp, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, bg_stamp)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, bg_stamp);
         } else {
            __io__generic__copy(this.getBg_stamp(), bg_stamp);
         }

      }
   }

   public byte getSeq_prev_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 2536L) : this.__io__block.readByte(this.__io__address + 2508L);
   }

   public void setSeq_prev_type(byte seq_prev_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 2536L, seq_prev_type);
      } else {
         this.__io__block.writeByte(this.__io__address + 2508L, seq_prev_type);
      }

   }

   public byte getSeq_rend_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 2537L) : this.__io__block.readByte(this.__io__address + 2509L);
   }

   public void setSeq_rend_type(byte seq_rend_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 2537L, seq_rend_type);
      } else {
         this.__io__block.writeByte(this.__io__address + 2509L, seq_rend_type);
      }

   }

   public byte getSeq_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 2538L) : this.__io__block.readByte(this.__io__address + 2510L);
   }

   public void setSeq_flag(byte seq_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 2538L, seq_flag);
      } else {
         this.__io__block.writeByte(this.__io__address + 2510L, seq_flag);
      }

   }

   public CArrayFacade<Byte> getPad5() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{5};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 2539L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 2511L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad5(CArrayFacade<Byte> pad5) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 2539L;
      } else {
         __dna__offset = 2511L;
      }

      if (!this.__io__equals(pad5, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad5)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad5);
         } else {
            __io__generic__copy(this.getPad5(), pad5);
         }

      }
   }

   public int getSimplify_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 2544L) : this.__io__block.readInt(this.__io__address + 2516L);
   }

   public void setSimplify_flag(int simplify_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 2544L, simplify_flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 2516L, simplify_flag);
      }

   }

   public short getSimplify_subsurf() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 2548L) : this.__io__block.readShort(this.__io__address + 2520L);
   }

   public void setSimplify_subsurf(short simplify_subsurf) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 2548L, simplify_subsurf);
      } else {
         this.__io__block.writeShort(this.__io__address + 2520L, simplify_subsurf);
      }

   }

   public short getSimplify_subsurf_render() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 2550L) : this.__io__block.readShort(this.__io__address + 2522L);
   }

   public void setSimplify_subsurf_render(short simplify_subsurf_render) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 2550L, simplify_subsurf_render);
      } else {
         this.__io__block.writeShort(this.__io__address + 2522L, simplify_subsurf_render);
      }

   }

   public short getSimplify_shadowsamples() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 2552L) : this.__io__block.readShort(this.__io__address + 2524L);
   }

   public void setSimplify_shadowsamples(short simplify_shadowsamples) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 2552L, simplify_shadowsamples);
      } else {
         this.__io__block.writeShort(this.__io__address + 2524L, simplify_shadowsamples);
      }

   }

   public short getPad9() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 2554L) : this.__io__block.readShort(this.__io__address + 2526L);
   }

   public void setPad9(short pad9) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 2554L, pad9);
      } else {
         this.__io__block.writeShort(this.__io__address + 2526L, pad9);
      }

   }

   public float getSimplify_particles() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 2556L) : this.__io__block.readFloat(this.__io__address + 2528L);
   }

   public void setSimplify_particles(float simplify_particles) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 2556L, simplify_particles);
      } else {
         this.__io__block.writeFloat(this.__io__address + 2528L, simplify_particles);
      }

   }

   public float getSimplify_particles_render() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 2560L) : this.__io__block.readFloat(this.__io__address + 2532L);
   }

   public void setSimplify_particles_render(float simplify_particles_render) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 2560L, simplify_particles_render);
      } else {
         this.__io__block.writeFloat(this.__io__address + 2532L, simplify_particles_render);
      }

   }

   public float getSimplify_aosss() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 2564L) : this.__io__block.readFloat(this.__io__address + 2536L);
   }

   public void setSimplify_aosss(float simplify_aosss) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 2564L, simplify_aosss);
      } else {
         this.__io__block.writeFloat(this.__io__address + 2536L, simplify_aosss);
      }

   }

   public short getCineonwhite() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 2568L) : this.__io__block.readShort(this.__io__address + 2540L);
   }

   public void setCineonwhite(short cineonwhite) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 2568L, cineonwhite);
      } else {
         this.__io__block.writeShort(this.__io__address + 2540L, cineonwhite);
      }

   }

   public short getCineonblack() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 2570L) : this.__io__block.readShort(this.__io__address + 2542L);
   }

   public void setCineonblack(short cineonblack) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 2570L, cineonblack);
      } else {
         this.__io__block.writeShort(this.__io__address + 2542L, cineonblack);
      }

   }

   public float getCineongamma() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 2572L) : this.__io__block.readFloat(this.__io__address + 2544L);
   }

   public void setCineongamma(float cineongamma) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 2572L, cineongamma);
      } else {
         this.__io__block.writeFloat(this.__io__address + 2544L, cineongamma);
      }

   }

   public short getJp2_preset() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 2576L) : this.__io__block.readShort(this.__io__address + 2548L);
   }

   public void setJp2_preset(short jp2_preset) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 2576L, jp2_preset);
      } else {
         this.__io__block.writeShort(this.__io__address + 2548L, jp2_preset);
      }

   }

   public short getJp2_depth() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 2578L) : this.__io__block.readShort(this.__io__address + 2550L);
   }

   public void setJp2_depth(short jp2_depth) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 2578L, jp2_depth);
      } else {
         this.__io__block.writeShort(this.__io__address + 2550L, jp2_depth);
      }

   }

   public int getRpad3() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 2580L) : this.__io__block.readInt(this.__io__address + 2552L);
   }

   public void setRpad3(int rpad3) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 2580L, rpad3);
      } else {
         this.__io__block.writeInt(this.__io__address + 2552L, rpad3);
      }

   }

   public short getDomeres() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 2584L) : this.__io__block.readShort(this.__io__address + 2556L);
   }

   public void setDomeres(short domeres) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 2584L, domeres);
      } else {
         this.__io__block.writeShort(this.__io__address + 2556L, domeres);
      }

   }

   public short getDomemode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 2586L) : this.__io__block.readShort(this.__io__address + 2558L);
   }

   public void setDomemode(short domemode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 2586L, domemode);
      } else {
         this.__io__block.writeShort(this.__io__address + 2558L, domemode);
      }

   }

   public short getDomeangle() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 2588L) : this.__io__block.readShort(this.__io__address + 2560L);
   }

   public void setDomeangle(short domeangle) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 2588L, domeangle);
      } else {
         this.__io__block.writeShort(this.__io__address + 2560L, domeangle);
      }

   }

   public short getDometilt() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 2590L) : this.__io__block.readShort(this.__io__address + 2562L);
   }

   public void setDometilt(short dometilt) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 2590L, dometilt);
      } else {
         this.__io__block.writeShort(this.__io__address + 2562L, dometilt);
      }

   }

   public float getDomeresbuf() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 2592L) : this.__io__block.readFloat(this.__io__address + 2564L);
   }

   public void setDomeresbuf(float domeresbuf) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 2592L, domeresbuf);
      } else {
         this.__io__block.writeFloat(this.__io__address + 2564L, domeresbuf);
      }

   }

   public float getPad2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 2596L) : this.__io__block.readFloat(this.__io__address + 2568L);
   }

   public void setPad2(float pad2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 2596L, pad2);
      } else {
         this.__io__block.writeFloat(this.__io__address + 2568L, pad2);
      }

   }

   public CPointer<Text> getDometext() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 2600L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 2572L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Text.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 19), this.__io__blockTable);
   }

   public void setDometext(CPointer<Text> dometext) throws IOException {
      long __address = dometext == null ? 0L : dometext.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 2600L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 2572L, __address);
      }

   }

   public int getLine_thickness_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 2608L) : this.__io__block.readInt(this.__io__address + 2576L);
   }

   public void setLine_thickness_mode(int line_thickness_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 2608L, line_thickness_mode);
      } else {
         this.__io__block.writeInt(this.__io__address + 2576L, line_thickness_mode);
      }

   }

   public float getUnit_line_thickness() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 2612L) : this.__io__block.readFloat(this.__io__address + 2580L);
   }

   public void setUnit_line_thickness(float unit_line_thickness) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 2612L, unit_line_thickness);
      } else {
         this.__io__block.writeFloat(this.__io__address + 2580L, unit_line_thickness);
      }

   }

   public CArrayFacade<Byte> getEngine() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{32};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 2616L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 2584L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setEngine(CArrayFacade<Byte> engine) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 2616L;
      } else {
         __dna__offset = 2584L;
      }

      if (!this.__io__equals(engine, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, engine)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, engine);
         } else {
            __io__generic__copy(this.getEngine(), engine);
         }

      }
   }

   public BakeData getBake() throws IOException {
      return this.__io__pointersize == 8 ? new BakeData(this.__io__address + 2648L, this.__io__block, this.__io__blockTable) : new BakeData(this.__io__address + 2616L, this.__io__block, this.__io__blockTable);
   }

   public void setBake(BakeData bake) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 2648L;
      } else {
         __dna__offset = 2616L;
      }

      if (!this.__io__equals(bake, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, bake)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, bake);
         } else {
            __io__generic__copy(this.getBake(), bake);
         }

      }
   }

   public int getPreview_start_resolution() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 4016L) : this.__io__block.readInt(this.__io__address + 3976L);
   }

   public void setPreview_start_resolution(int preview_start_resolution) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 4016L, preview_start_resolution);
      } else {
         this.__io__block.writeInt(this.__io__address + 3976L, preview_start_resolution);
      }

   }

   public short getDebug_pass_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 4020L) : this.__io__block.readShort(this.__io__address + 3980L);
   }

   public void setDebug_pass_type(short debug_pass_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 4020L, debug_pass_type);
      } else {
         this.__io__block.writeShort(this.__io__address + 3980L, debug_pass_type);
      }

   }

   public short getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 4022L) : this.__io__block.readShort(this.__io__address + 3982L);
   }

   public void setPad(short pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 4022L, pad);
      } else {
         this.__io__block.writeShort(this.__io__address + 3982L, pad);
      }

   }

   public ListBase getViews() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 4024L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 3984L, this.__io__block, this.__io__blockTable);
   }

   public void setViews(ListBase views) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 4024L;
      } else {
         __dna__offset = 3984L;
      }

      if (!this.__io__equals(views, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, views)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, views);
         } else {
            __io__generic__copy(this.getViews(), views);
         }

      }
   }

   public short getActview() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 4040L) : this.__io__block.readShort(this.__io__address + 3992L);
   }

   public void setActview(short actview) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 4040L, actview);
      } else {
         this.__io__block.writeShort(this.__io__address + 3992L, actview);
      }

   }

   public short getViews_format() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 4042L) : this.__io__block.readShort(this.__io__address + 3994L);
   }

   public void setViews_format(short views_format) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 4042L, views_format);
      } else {
         this.__io__block.writeShort(this.__io__address + 3994L, views_format);
      }

   }

   public CArrayFacade<Short> getPad8() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Short.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 4044L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 3996L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad8(CArrayFacade<Short> pad8) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 4044L;
      } else {
         __dna__offset = 3996L;
      }

      if (!this.__io__equals(pad8, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad8)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad8);
         } else {
            __io__generic__copy(this.getPad8(), pad8);
         }

      }
   }

   public CurveMapping getMblur_shutter_curve() throws IOException {
      return this.__io__pointersize == 8 ? new CurveMapping(this.__io__address + 4048L, this.__io__block, this.__io__blockTable) : new CurveMapping(this.__io__address + 4000L, this.__io__block, this.__io__blockTable);
   }

   public void setMblur_shutter_curve(CurveMapping mblur_shutter_curve) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 4048L;
      } else {
         __dna__offset = 4000L;
      }

      if (!this.__io__equals(mblur_shutter_curve, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, mblur_shutter_curve)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, mblur_shutter_curve);
         } else {
            __io__generic__copy(this.getMblur_shutter_curve(), mblur_shutter_curve);
         }

      }
   }

   public CPointer<RenderData> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{RenderData.class}, this.__io__block, this.__io__blockTable);
   }
}
