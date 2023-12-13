package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 72L,
   size64 = 72L
)
public class MovieTrackingSettings extends CFacade {
   public static final int __DNA__SDNA_INDEX = 553;
   public static final long[] __DNA__FIELD__flag = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__default_motion_model = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__default_algorithm_flag = new long[]{6L, 6L};
   public static final long[] __DNA__FIELD__default_minimum_correlation = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__default_pattern_size = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__default_search_size = new long[]{14L, 14L};
   public static final long[] __DNA__FIELD__default_frames_limit = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__default_margin = new long[]{18L, 18L};
   public static final long[] __DNA__FIELD__default_pattern_match = new long[]{20L, 20L};
   public static final long[] __DNA__FIELD__default_flag = new long[]{22L, 22L};
   public static final long[] __DNA__FIELD__default_weight = new long[]{24L, 24L};
   public static final long[] __DNA__FIELD__motion_flag = new long[]{28L, 28L};
   public static final long[] __DNA__FIELD__speed = new long[]{30L, 30L};
   public static final long[] __DNA__FIELD__keyframe1 = new long[]{32L, 32L};
   public static final long[] __DNA__FIELD__keyframe2 = new long[]{36L, 36L};
   public static final long[] __DNA__FIELD__reconstruction_flag = new long[]{40L, 40L};
   public static final long[] __DNA__FIELD__refine_camera_intrinsics = new long[]{44L, 44L};
   public static final long[] __DNA__FIELD__pad2 = new long[]{46L, 46L};
   public static final long[] __DNA__FIELD__dist = new long[]{48L, 48L};
   public static final long[] __DNA__FIELD__clean_frames = new long[]{52L, 52L};
   public static final long[] __DNA__FIELD__clean_action = new long[]{56L, 56L};
   public static final long[] __DNA__FIELD__clean_error = new long[]{60L, 60L};
   public static final long[] __DNA__FIELD__object_distance = new long[]{64L, 64L};
   public static final long[] __DNA__FIELD__pad3 = new long[]{68L, 68L};

   public MovieTrackingSettings(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MovieTrackingSettings(MovieTrackingSettings that) {
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

   public short getDefault_motion_model() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 4L) : this.__io__block.readShort(this.__io__address + 4L);
   }

   public void setDefault_motion_model(short default_motion_model) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 4L, default_motion_model);
      } else {
         this.__io__block.writeShort(this.__io__address + 4L, default_motion_model);
      }

   }

   public short getDefault_algorithm_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 6L) : this.__io__block.readShort(this.__io__address + 6L);
   }

   public void setDefault_algorithm_flag(short default_algorithm_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 6L, default_algorithm_flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 6L, default_algorithm_flag);
      }

   }

   public float getDefault_minimum_correlation() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 8L) : this.__io__block.readFloat(this.__io__address + 8L);
   }

   public void setDefault_minimum_correlation(float default_minimum_correlation) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 8L, default_minimum_correlation);
      } else {
         this.__io__block.writeFloat(this.__io__address + 8L, default_minimum_correlation);
      }

   }

   public short getDefault_pattern_size() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 12L) : this.__io__block.readShort(this.__io__address + 12L);
   }

   public void setDefault_pattern_size(short default_pattern_size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 12L, default_pattern_size);
      } else {
         this.__io__block.writeShort(this.__io__address + 12L, default_pattern_size);
      }

   }

   public short getDefault_search_size() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 14L) : this.__io__block.readShort(this.__io__address + 14L);
   }

   public void setDefault_search_size(short default_search_size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 14L, default_search_size);
      } else {
         this.__io__block.writeShort(this.__io__address + 14L, default_search_size);
      }

   }

   public short getDefault_frames_limit() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 16L) : this.__io__block.readShort(this.__io__address + 16L);
   }

   public void setDefault_frames_limit(short default_frames_limit) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 16L, default_frames_limit);
      } else {
         this.__io__block.writeShort(this.__io__address + 16L, default_frames_limit);
      }

   }

   public short getDefault_margin() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 18L) : this.__io__block.readShort(this.__io__address + 18L);
   }

   public void setDefault_margin(short default_margin) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 18L, default_margin);
      } else {
         this.__io__block.writeShort(this.__io__address + 18L, default_margin);
      }

   }

   public short getDefault_pattern_match() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 20L) : this.__io__block.readShort(this.__io__address + 20L);
   }

   public void setDefault_pattern_match(short default_pattern_match) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 20L, default_pattern_match);
      } else {
         this.__io__block.writeShort(this.__io__address + 20L, default_pattern_match);
      }

   }

   public short getDefault_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 22L) : this.__io__block.readShort(this.__io__address + 22L);
   }

   public void setDefault_flag(short default_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 22L, default_flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 22L, default_flag);
      }

   }

   public float getDefault_weight() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 24L) : this.__io__block.readFloat(this.__io__address + 24L);
   }

   public void setDefault_weight(float default_weight) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 24L, default_weight);
      } else {
         this.__io__block.writeFloat(this.__io__address + 24L, default_weight);
      }

   }

   public short getMotion_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 28L) : this.__io__block.readShort(this.__io__address + 28L);
   }

   public void setMotion_flag(short motion_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 28L, motion_flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 28L, motion_flag);
      }

   }

   public short getSpeed() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 30L) : this.__io__block.readShort(this.__io__address + 30L);
   }

   public void setSpeed(short speed) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 30L, speed);
      } else {
         this.__io__block.writeShort(this.__io__address + 30L, speed);
      }

   }

   public int getKeyframe1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 32L) : this.__io__block.readInt(this.__io__address + 32L);
   }

   public void setKeyframe1(int keyframe1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 32L, keyframe1);
      } else {
         this.__io__block.writeInt(this.__io__address + 32L, keyframe1);
      }

   }

   public int getKeyframe2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 36L) : this.__io__block.readInt(this.__io__address + 36L);
   }

   public void setKeyframe2(int keyframe2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 36L, keyframe2);
      } else {
         this.__io__block.writeInt(this.__io__address + 36L, keyframe2);
      }

   }

   public int getReconstruction_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 40L) : this.__io__block.readInt(this.__io__address + 40L);
   }

   public void setReconstruction_flag(int reconstruction_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 40L, reconstruction_flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 40L, reconstruction_flag);
      }

   }

   public short getRefine_camera_intrinsics() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 44L) : this.__io__block.readShort(this.__io__address + 44L);
   }

   public void setRefine_camera_intrinsics(short refine_camera_intrinsics) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 44L, refine_camera_intrinsics);
      } else {
         this.__io__block.writeShort(this.__io__address + 44L, refine_camera_intrinsics);
      }

   }

   public short getPad2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 46L) : this.__io__block.readShort(this.__io__address + 46L);
   }

   public void setPad2(short pad2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 46L, pad2);
      } else {
         this.__io__block.writeShort(this.__io__address + 46L, pad2);
      }

   }

   public float getDist() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 48L) : this.__io__block.readFloat(this.__io__address + 48L);
   }

   public void setDist(float dist) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 48L, dist);
      } else {
         this.__io__block.writeFloat(this.__io__address + 48L, dist);
      }

   }

   public int getClean_frames() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 52L) : this.__io__block.readInt(this.__io__address + 52L);
   }

   public void setClean_frames(int clean_frames) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 52L, clean_frames);
      } else {
         this.__io__block.writeInt(this.__io__address + 52L, clean_frames);
      }

   }

   public int getClean_action() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 56L) : this.__io__block.readInt(this.__io__address + 56L);
   }

   public void setClean_action(int clean_action) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 56L, clean_action);
      } else {
         this.__io__block.writeInt(this.__io__address + 56L, clean_action);
      }

   }

   public float getClean_error() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 60L) : this.__io__block.readFloat(this.__io__address + 60L);
   }

   public void setClean_error(float clean_error) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 60L, clean_error);
      } else {
         this.__io__block.writeFloat(this.__io__address + 60L, clean_error);
      }

   }

   public float getObject_distance() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 64L) : this.__io__block.readFloat(this.__io__address + 64L);
   }

   public void setObject_distance(float object_distance) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 64L, object_distance);
      } else {
         this.__io__block.writeFloat(this.__io__address + 64L, object_distance);
      }

   }

   public int getPad3() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 68L) : this.__io__block.readInt(this.__io__address + 68L);
   }

   public void setPad3(int pad3) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 68L, pad3);
      } else {
         this.__io__block.writeInt(this.__io__address + 68L, pad3);
      }

   }

   public CPointer<MovieTrackingSettings> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MovieTrackingSettings.class}, this.__io__block, this.__io__blockTable);
   }
}
