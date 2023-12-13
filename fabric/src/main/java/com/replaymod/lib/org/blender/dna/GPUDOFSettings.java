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
public class GPUDOFSettings extends CFacade {
   public static final int __DNA__SDNA_INDEX = 21;
   public static final long[] __DNA__FIELD__focus_distance = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__fstop = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__focal_length = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__sensor = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__num_blades = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__high_quality = new long[]{20L, 20L};

   public GPUDOFSettings(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected GPUDOFSettings(GPUDOFSettings that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public float getFocus_distance() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 0L) : this.__io__block.readFloat(this.__io__address + 0L);
   }

   public void setFocus_distance(float focus_distance) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 0L, focus_distance);
      } else {
         this.__io__block.writeFloat(this.__io__address + 0L, focus_distance);
      }

   }

   public float getFstop() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 4L) : this.__io__block.readFloat(this.__io__address + 4L);
   }

   public void setFstop(float fstop) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 4L, fstop);
      } else {
         this.__io__block.writeFloat(this.__io__address + 4L, fstop);
      }

   }

   public float getFocal_length() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 8L) : this.__io__block.readFloat(this.__io__address + 8L);
   }

   public void setFocal_length(float focal_length) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 8L, focal_length);
      } else {
         this.__io__block.writeFloat(this.__io__address + 8L, focal_length);
      }

   }

   public float getSensor() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 12L) : this.__io__block.readFloat(this.__io__address + 12L);
   }

   public void setSensor(float sensor) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 12L, sensor);
      } else {
         this.__io__block.writeFloat(this.__io__address + 12L, sensor);
      }

   }

   public int getNum_blades() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 16L) : this.__io__block.readInt(this.__io__address + 16L);
   }

   public void setNum_blades(int num_blades) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 16L, num_blades);
      } else {
         this.__io__block.writeInt(this.__io__address + 16L, num_blades);
      }

   }

   public int getHigh_quality() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 20L) : this.__io__block.readInt(this.__io__address + 20L);
   }

   public void setHigh_quality(int high_quality) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 20L, high_quality);
      } else {
         this.__io__block.writeInt(this.__io__address + 20L, high_quality);
      }

   }

   public CPointer<GPUDOFSettings> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{GPUDOFSettings.class}, this.__io__block, this.__io__blockTable);
   }
}
