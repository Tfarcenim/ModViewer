package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 84L,
   size64 = 88L
)
public class FFMpegCodecData extends CFacade {
   public static final int __DNA__SDNA_INDEX = 171;
   public static final long[] __DNA__FIELD__type = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__codec = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__audio_codec = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__video_bitrate = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__audio_bitrate = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__audio_mixrate = new long[]{20L, 20L};
   public static final long[] __DNA__FIELD__audio_channels = new long[]{24L, 24L};
   public static final long[] __DNA__FIELD__audio_pad = new long[]{28L, 28L};
   public static final long[] __DNA__FIELD__audio_volume = new long[]{32L, 32L};
   public static final long[] __DNA__FIELD__gop_size = new long[]{36L, 36L};
   public static final long[] __DNA__FIELD__max_b_frames = new long[]{40L, 40L};
   public static final long[] __DNA__FIELD__flags = new long[]{44L, 44L};
   public static final long[] __DNA__FIELD__constant_rate_factor = new long[]{48L, 48L};
   public static final long[] __DNA__FIELD__ffmpeg_preset = new long[]{52L, 52L};
   public static final long[] __DNA__FIELD__rc_min_rate = new long[]{56L, 56L};
   public static final long[] __DNA__FIELD__rc_max_rate = new long[]{60L, 60L};
   public static final long[] __DNA__FIELD__rc_buffer_size = new long[]{64L, 64L};
   public static final long[] __DNA__FIELD__mux_packet_size = new long[]{68L, 68L};
   public static final long[] __DNA__FIELD__mux_rate = new long[]{72L, 72L};
   public static final long[] __DNA__FIELD__pad1 = new long[]{76L, 76L};
   public static final long[] __DNA__FIELD__properties = new long[]{80L, 80L};

   public FFMpegCodecData(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected FFMpegCodecData(FFMpegCodecData that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public int getType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 0L) : this.__io__block.readInt(this.__io__address + 0L);
   }

   public void setType(int type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 0L, type);
      } else {
         this.__io__block.writeInt(this.__io__address + 0L, type);
      }

   }

   public int getCodec() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 4L) : this.__io__block.readInt(this.__io__address + 4L);
   }

   public void setCodec(int codec) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 4L, codec);
      } else {
         this.__io__block.writeInt(this.__io__address + 4L, codec);
      }

   }

   public int getAudio_codec() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 8L) : this.__io__block.readInt(this.__io__address + 8L);
   }

   public void setAudio_codec(int audio_codec) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 8L, audio_codec);
      } else {
         this.__io__block.writeInt(this.__io__address + 8L, audio_codec);
      }

   }

   public int getVideo_bitrate() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 12L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setVideo_bitrate(int video_bitrate) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 12L, video_bitrate);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, video_bitrate);
      }

   }

   public int getAudio_bitrate() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 16L) : this.__io__block.readInt(this.__io__address + 16L);
   }

   public void setAudio_bitrate(int audio_bitrate) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 16L, audio_bitrate);
      } else {
         this.__io__block.writeInt(this.__io__address + 16L, audio_bitrate);
      }

   }

   public int getAudio_mixrate() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 20L) : this.__io__block.readInt(this.__io__address + 20L);
   }

   public void setAudio_mixrate(int audio_mixrate) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 20L, audio_mixrate);
      } else {
         this.__io__block.writeInt(this.__io__address + 20L, audio_mixrate);
      }

   }

   public int getAudio_channels() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 24L) : this.__io__block.readInt(this.__io__address + 24L);
   }

   public void setAudio_channels(int audio_channels) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 24L, audio_channels);
      } else {
         this.__io__block.writeInt(this.__io__address + 24L, audio_channels);
      }

   }

   public int getAudio_pad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 28L) : this.__io__block.readInt(this.__io__address + 28L);
   }

   public void setAudio_pad(int audio_pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 28L, audio_pad);
      } else {
         this.__io__block.writeInt(this.__io__address + 28L, audio_pad);
      }

   }

   public float getAudio_volume() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 32L) : this.__io__block.readFloat(this.__io__address + 32L);
   }

   public void setAudio_volume(float audio_volume) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 32L, audio_volume);
      } else {
         this.__io__block.writeFloat(this.__io__address + 32L, audio_volume);
      }

   }

   public int getGop_size() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 36L) : this.__io__block.readInt(this.__io__address + 36L);
   }

   public void setGop_size(int gop_size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 36L, gop_size);
      } else {
         this.__io__block.writeInt(this.__io__address + 36L, gop_size);
      }

   }

   public int getMax_b_frames() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 40L) : this.__io__block.readInt(this.__io__address + 40L);
   }

   public void setMax_b_frames(int max_b_frames) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 40L, max_b_frames);
      } else {
         this.__io__block.writeInt(this.__io__address + 40L, max_b_frames);
      }

   }

   public int getFlags() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 44L) : this.__io__block.readInt(this.__io__address + 44L);
   }

   public void setFlags(int flags) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 44L, flags);
      } else {
         this.__io__block.writeInt(this.__io__address + 44L, flags);
      }

   }

   public int getConstant_rate_factor() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 48L) : this.__io__block.readInt(this.__io__address + 48L);
   }

   public void setConstant_rate_factor(int constant_rate_factor) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 48L, constant_rate_factor);
      } else {
         this.__io__block.writeInt(this.__io__address + 48L, constant_rate_factor);
      }

   }

   public int getFfmpeg_preset() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 52L) : this.__io__block.readInt(this.__io__address + 52L);
   }

   public void setFfmpeg_preset(int ffmpeg_preset) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 52L, ffmpeg_preset);
      } else {
         this.__io__block.writeInt(this.__io__address + 52L, ffmpeg_preset);
      }

   }

   public int getRc_min_rate() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 56L) : this.__io__block.readInt(this.__io__address + 56L);
   }

   public void setRc_min_rate(int rc_min_rate) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 56L, rc_min_rate);
      } else {
         this.__io__block.writeInt(this.__io__address + 56L, rc_min_rate);
      }

   }

   public int getRc_max_rate() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 60L) : this.__io__block.readInt(this.__io__address + 60L);
   }

   public void setRc_max_rate(int rc_max_rate) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 60L, rc_max_rate);
      } else {
         this.__io__block.writeInt(this.__io__address + 60L, rc_max_rate);
      }

   }

   public int getRc_buffer_size() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 64L) : this.__io__block.readInt(this.__io__address + 64L);
   }

   public void setRc_buffer_size(int rc_buffer_size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 64L, rc_buffer_size);
      } else {
         this.__io__block.writeInt(this.__io__address + 64L, rc_buffer_size);
      }

   }

   public int getMux_packet_size() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 68L) : this.__io__block.readInt(this.__io__address + 68L);
   }

   public void setMux_packet_size(int mux_packet_size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 68L, mux_packet_size);
      } else {
         this.__io__block.writeInt(this.__io__address + 68L, mux_packet_size);
      }

   }

   public int getMux_rate() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 72L) : this.__io__block.readInt(this.__io__address + 72L);
   }

   public void setMux_rate(int mux_rate) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 72L, mux_rate);
      } else {
         this.__io__block.writeInt(this.__io__address + 72L, mux_rate);
      }

   }

   public int getPad1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 76L) : this.__io__block.readInt(this.__io__address + 76L);
   }

   public void setPad1(int pad1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 76L, pad1);
      } else {
         this.__io__block.writeInt(this.__io__address + 76L, pad1);
      }

   }

   public CPointer<IDProperty> getProperties() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 80L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 80L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{IDProperty.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 9), this.__io__blockTable);
   }

   public void setProperties(CPointer<IDProperty> properties) throws IOException {
      long __address = properties == null ? 0L : properties.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 80L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 80L, __address);
      }

   }

   public CPointer<FFMpegCodecData> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{FFMpegCodecData.class}, this.__io__block, this.__io__blockTable);
   }
}
