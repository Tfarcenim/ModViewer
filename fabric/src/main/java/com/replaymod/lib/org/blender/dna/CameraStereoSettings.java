package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 24L,
   size64 = 24L
)
public class CameraStereoSettings extends CFacade {
   public static final int __DNA__SDNA_INDEX = 24;
   public static final long[] __DNA__FIELD__interocular_distance = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__convergence_distance = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__convergence_mode = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__pivot = new long[]{10L, 10L};
   public static final long[] __DNA__FIELD__flag = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__pad = new long[]{14L, 14L};
   public static final long[] __DNA__FIELD__pole_merge_angle_from = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__pole_merge_angle_to = new long[]{20L, 20L};

   public CameraStereoSettings(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected CameraStereoSettings(CameraStereoSettings that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public float getInterocular_distance() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 0L) : this.__io__block.readFloat(this.__io__address + 0L);
   }

   public void setInterocular_distance(float interocular_distance) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 0L, interocular_distance);
      } else {
         this.__io__block.writeFloat(this.__io__address + 0L, interocular_distance);
      }

   }

   public float getConvergence_distance() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 4L) : this.__io__block.readFloat(this.__io__address + 4L);
   }

   public void setConvergence_distance(float convergence_distance) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 4L, convergence_distance);
      } else {
         this.__io__block.writeFloat(this.__io__address + 4L, convergence_distance);
      }

   }

   public short getConvergence_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 8L) : this.__io__block.readShort(this.__io__address + 8L);
   }

   public void setConvergence_mode(short convergence_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 8L, convergence_mode);
      } else {
         this.__io__block.writeShort(this.__io__address + 8L, convergence_mode);
      }

   }

   public short getPivot() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 10L) : this.__io__block.readShort(this.__io__address + 10L);
   }

   public void setPivot(short pivot) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 10L, pivot);
      } else {
         this.__io__block.writeShort(this.__io__address + 10L, pivot);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 12L) : this.__io__block.readShort(this.__io__address + 12L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 12L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 12L, flag);
      }

   }

   public short getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 14L) : this.__io__block.readShort(this.__io__address + 14L);
   }

   public void setPad(short pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 14L, pad);
      } else {
         this.__io__block.writeShort(this.__io__address + 14L, pad);
      }

   }

   public float getPole_merge_angle_from() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 16L) : this.__io__block.readFloat(this.__io__address + 16L);
   }

   public void setPole_merge_angle_from(float pole_merge_angle_from) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 16L, pole_merge_angle_from);
      } else {
         this.__io__block.writeFloat(this.__io__address + 16L, pole_merge_angle_from);
      }

   }

   public float getPole_merge_angle_to() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 20L) : this.__io__block.readFloat(this.__io__address + 20L);
   }

   public void setPole_merge_angle_to(float pole_merge_angle_to) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 20L, pole_merge_angle_to);
      } else {
         this.__io__block.writeFloat(this.__io__address + 20L, pole_merge_angle_to);
      }

   }

   public CPointer<CameraStereoSettings> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{CameraStereoSettings.class}, this.__io__block, this.__io__blockTable);
   }
}
