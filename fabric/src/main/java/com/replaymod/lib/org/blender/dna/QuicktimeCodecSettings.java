package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 64L,
   size64 = 64L
)
public class QuicktimeCodecSettings extends CFacade {
   public static final int __DNA__SDNA_INDEX = 170;
   public static final long[] __DNA__FIELD__codecType = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__codecSpatialQuality = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__codec = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__codecFlags = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__colorDepth = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__codecTemporalQuality = new long[]{20L, 20L};
   public static final long[] __DNA__FIELD__minSpatialQuality = new long[]{24L, 24L};
   public static final long[] __DNA__FIELD__minTemporalQuality = new long[]{28L, 28L};
   public static final long[] __DNA__FIELD__keyFrameRate = new long[]{32L, 32L};
   public static final long[] __DNA__FIELD__bitRate = new long[]{36L, 36L};
   public static final long[] __DNA__FIELD__audiocodecType = new long[]{40L, 40L};
   public static final long[] __DNA__FIELD__audioSampleRate = new long[]{44L, 44L};
   public static final long[] __DNA__FIELD__audioBitDepth = new long[]{48L, 48L};
   public static final long[] __DNA__FIELD__audioChannels = new long[]{50L, 50L};
   public static final long[] __DNA__FIELD__audioCodecFlags = new long[]{52L, 52L};
   public static final long[] __DNA__FIELD__audioBitRate = new long[]{56L, 56L};
   public static final long[] __DNA__FIELD__pad1 = new long[]{60L, 60L};

   public QuicktimeCodecSettings(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected QuicktimeCodecSettings(QuicktimeCodecSettings that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public int getCodecType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 0L) : this.__io__block.readInt(this.__io__address + 0L);
   }

   public void setCodecType(int codecType) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 0L, codecType);
      } else {
         this.__io__block.writeInt(this.__io__address + 0L, codecType);
      }

   }

   public int getCodecSpatialQuality() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 4L) : this.__io__block.readInt(this.__io__address + 4L);
   }

   public void setCodecSpatialQuality(int codecSpatialQuality) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 4L, codecSpatialQuality);
      } else {
         this.__io__block.writeInt(this.__io__address + 4L, codecSpatialQuality);
      }

   }

   public int getCodec() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 8L) : this.__io__block.readInt(this.__io__address + 8L);
   }

   public void setCodec(int codec) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 8L, codec);
      } else {
         this.__io__block.writeInt(this.__io__address + 8L, codec);
      }

   }

   public int getCodecFlags() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 12L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setCodecFlags(int codecFlags) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 12L, codecFlags);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, codecFlags);
      }

   }

   public int getColorDepth() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 16L) : this.__io__block.readInt(this.__io__address + 16L);
   }

   public void setColorDepth(int colorDepth) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 16L, colorDepth);
      } else {
         this.__io__block.writeInt(this.__io__address + 16L, colorDepth);
      }

   }

   public int getCodecTemporalQuality() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 20L) : this.__io__block.readInt(this.__io__address + 20L);
   }

   public void setCodecTemporalQuality(int codecTemporalQuality) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 20L, codecTemporalQuality);
      } else {
         this.__io__block.writeInt(this.__io__address + 20L, codecTemporalQuality);
      }

   }

   public int getMinSpatialQuality() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 24L) : this.__io__block.readInt(this.__io__address + 24L);
   }

   public void setMinSpatialQuality(int minSpatialQuality) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 24L, minSpatialQuality);
      } else {
         this.__io__block.writeInt(this.__io__address + 24L, minSpatialQuality);
      }

   }

   public int getMinTemporalQuality() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 28L) : this.__io__block.readInt(this.__io__address + 28L);
   }

   public void setMinTemporalQuality(int minTemporalQuality) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 28L, minTemporalQuality);
      } else {
         this.__io__block.writeInt(this.__io__address + 28L, minTemporalQuality);
      }

   }

   public int getKeyFrameRate() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 32L) : this.__io__block.readInt(this.__io__address + 32L);
   }

   public void setKeyFrameRate(int keyFrameRate) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 32L, keyFrameRate);
      } else {
         this.__io__block.writeInt(this.__io__address + 32L, keyFrameRate);
      }

   }

   public int getBitRate() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 36L) : this.__io__block.readInt(this.__io__address + 36L);
   }

   public void setBitRate(int bitRate) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 36L, bitRate);
      } else {
         this.__io__block.writeInt(this.__io__address + 36L, bitRate);
      }

   }

   public int getAudiocodecType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 40L) : this.__io__block.readInt(this.__io__address + 40L);
   }

   public void setAudiocodecType(int audiocodecType) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 40L, audiocodecType);
      } else {
         this.__io__block.writeInt(this.__io__address + 40L, audiocodecType);
      }

   }

   public int getAudioSampleRate() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 44L) : this.__io__block.readInt(this.__io__address + 44L);
   }

   public void setAudioSampleRate(int audioSampleRate) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 44L, audioSampleRate);
      } else {
         this.__io__block.writeInt(this.__io__address + 44L, audioSampleRate);
      }

   }

   public short getAudioBitDepth() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 48L) : this.__io__block.readShort(this.__io__address + 48L);
   }

   public void setAudioBitDepth(short audioBitDepth) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 48L, audioBitDepth);
      } else {
         this.__io__block.writeShort(this.__io__address + 48L, audioBitDepth);
      }

   }

   public short getAudioChannels() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 50L) : this.__io__block.readShort(this.__io__address + 50L);
   }

   public void setAudioChannels(short audioChannels) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 50L, audioChannels);
      } else {
         this.__io__block.writeShort(this.__io__address + 50L, audioChannels);
      }

   }

   public int getAudioCodecFlags() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 52L) : this.__io__block.readInt(this.__io__address + 52L);
   }

   public void setAudioCodecFlags(int audioCodecFlags) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 52L, audioCodecFlags);
      } else {
         this.__io__block.writeInt(this.__io__address + 52L, audioCodecFlags);
      }

   }

   public int getAudioBitRate() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 56L) : this.__io__block.readInt(this.__io__address + 56L);
   }

   public void setAudioBitRate(int audioBitRate) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 56L, audioBitRate);
      } else {
         this.__io__block.writeInt(this.__io__address + 56L, audioBitRate);
      }

   }

   public int getPad1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 60L) : this.__io__block.readInt(this.__io__address + 60L);
   }

   public void setPad1(int pad1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 60L, pad1);
      } else {
         this.__io__block.writeInt(this.__io__address + 60L, pad1);
      }

   }

   public CPointer<QuicktimeCodecSettings> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{QuicktimeCodecSettings.class}, this.__io__block, this.__io__blockTable);
   }
}
