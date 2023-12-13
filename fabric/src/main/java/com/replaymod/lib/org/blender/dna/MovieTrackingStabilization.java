package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 68L,
   size64 = 72L
)
public class MovieTrackingStabilization extends CFacade {
   public static final int __DNA__SDNA_INDEX = 554;
   public static final long[] __DNA__FIELD__flag = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__tot_track = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__act_track = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__tot_rot_track = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__act_rot_track = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__maxscale = new long[]{20L, 20L};
   public static final long[] __DNA__FIELD__rot_track = new long[]{24L, 24L};
   public static final long[] __DNA__FIELD__anchor_frame = new long[]{28L, 32L};
   public static final long[] __DNA__FIELD__target_pos = new long[]{32L, 36L};
   public static final long[] __DNA__FIELD__target_rot = new long[]{40L, 44L};
   public static final long[] __DNA__FIELD__scale = new long[]{44L, 48L};
   public static final long[] __DNA__FIELD__locinf = new long[]{48L, 52L};
   public static final long[] __DNA__FIELD__scaleinf = new long[]{52L, 56L};
   public static final long[] __DNA__FIELD__rotinf = new long[]{56L, 60L};
   public static final long[] __DNA__FIELD__filter = new long[]{60L, 64L};
   public static final long[] __DNA__FIELD__ok = new long[]{64L, 68L};

   public MovieTrackingStabilization(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MovieTrackingStabilization(MovieTrackingStabilization that) {
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

   public int getTot_track() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 4L) : this.__io__block.readInt(this.__io__address + 4L);
   }

   public void setTot_track(int tot_track) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 4L, tot_track);
      } else {
         this.__io__block.writeInt(this.__io__address + 4L, tot_track);
      }

   }

   public int getAct_track() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 8L) : this.__io__block.readInt(this.__io__address + 8L);
   }

   public void setAct_track(int act_track) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 8L, act_track);
      } else {
         this.__io__block.writeInt(this.__io__address + 8L, act_track);
      }

   }

   public int getTot_rot_track() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 12L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setTot_rot_track(int tot_rot_track) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 12L, tot_rot_track);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, tot_rot_track);
      }

   }

   public int getAct_rot_track() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 16L) : this.__io__block.readInt(this.__io__address + 16L);
   }

   public void setAct_rot_track(int act_rot_track) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 16L, act_rot_track);
      } else {
         this.__io__block.writeInt(this.__io__address + 16L, act_rot_track);
      }

   }

   public float getMaxscale() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 20L) : this.__io__block.readFloat(this.__io__address + 20L);
   }

   public void setMaxscale(float maxscale) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 20L, maxscale);
      } else {
         this.__io__block.writeFloat(this.__io__address + 20L, maxscale);
      }

   }

   public CPointer<MovieTrackingTrack> getRot_track() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 24L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 24L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MovieTrackingTrack.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 550), this.__io__blockTable);
   }

   public void setRot_track(CPointer<MovieTrackingTrack> rot_track) throws IOException {
      long __address = rot_track == null ? 0L : rot_track.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 24L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 24L, __address);
      }

   }

   public int getAnchor_frame() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 32L) : this.__io__block.readInt(this.__io__address + 28L);
   }

   public void setAnchor_frame(int anchor_frame) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 32L, anchor_frame);
      } else {
         this.__io__block.writeInt(this.__io__address + 28L, anchor_frame);
      }

   }

   public CArrayFacade<Float> getTarget_pos() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 36L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 32L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setTarget_pos(CArrayFacade<Float> target_pos) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 36L;
      } else {
         __dna__offset = 32L;
      }

      if (!this.__io__equals(target_pos, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, target_pos)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, target_pos);
         } else {
            __io__generic__copy(this.getTarget_pos(), target_pos);
         }

      }
   }

   public float getTarget_rot() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 44L) : this.__io__block.readFloat(this.__io__address + 40L);
   }

   public void setTarget_rot(float target_rot) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 44L, target_rot);
      } else {
         this.__io__block.writeFloat(this.__io__address + 40L, target_rot);
      }

   }

   public float getScale() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 48L) : this.__io__block.readFloat(this.__io__address + 44L);
   }

   public void setScale(float scale) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 48L, scale);
      } else {
         this.__io__block.writeFloat(this.__io__address + 44L, scale);
      }

   }

   public float getLocinf() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 52L) : this.__io__block.readFloat(this.__io__address + 48L);
   }

   public void setLocinf(float locinf) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 52L, locinf);
      } else {
         this.__io__block.writeFloat(this.__io__address + 48L, locinf);
      }

   }

   public float getScaleinf() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 56L) : this.__io__block.readFloat(this.__io__address + 52L);
   }

   public void setScaleinf(float scaleinf) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 56L, scaleinf);
      } else {
         this.__io__block.writeFloat(this.__io__address + 52L, scaleinf);
      }

   }

   public float getRotinf() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 60L) : this.__io__block.readFloat(this.__io__address + 56L);
   }

   public void setRotinf(float rotinf) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 60L, rotinf);
      } else {
         this.__io__block.writeFloat(this.__io__address + 56L, rotinf);
      }

   }

   public int getFilter() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 64L) : this.__io__block.readInt(this.__io__address + 60L);
   }

   public void setFilter(int filter) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 64L, filter);
      } else {
         this.__io__block.writeInt(this.__io__address + 60L, filter);
      }

   }

   public int getOk() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 68L) : this.__io__block.readInt(this.__io__address + 64L);
   }

   public void setOk(int ok) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 68L, ok);
      } else {
         this.__io__block.writeInt(this.__io__address + 64L, ok);
      }

   }

   public CPointer<MovieTrackingStabilization> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MovieTrackingStabilization.class}, this.__io__block, this.__io__blockTable);
   }
}
