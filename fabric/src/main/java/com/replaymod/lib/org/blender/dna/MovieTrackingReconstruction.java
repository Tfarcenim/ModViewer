package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 20L,
   size64 = 24L
)
public class MovieTrackingReconstruction extends CFacade {
   public static final int __DNA__SDNA_INDEX = 555;
   public static final long[] __DNA__FIELD__flag = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__error = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__last_camera = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__camnr = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__cameras = new long[]{16L, 16L};

   public MovieTrackingReconstruction(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MovieTrackingReconstruction(MovieTrackingReconstruction that) {
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

   public float getError() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 4L) : this.__io__block.readFloat(this.__io__address + 4L);
   }

   public void setError(float error) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 4L, error);
      } else {
         this.__io__block.writeFloat(this.__io__address + 4L, error);
      }

   }

   public int getLast_camera() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 8L) : this.__io__block.readInt(this.__io__address + 8L);
   }

   public void setLast_camera(int last_camera) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 8L, last_camera);
      } else {
         this.__io__block.writeInt(this.__io__address + 8L, last_camera);
      }

   }

   public int getCamnr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 12L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setCamnr(int camnr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 12L, camnr);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, camnr);
      }

   }

   public CPointer<MovieReconstructedCamera> getCameras() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MovieReconstructedCamera.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 547), this.__io__blockTable);
   }

   public void setCameras(CPointer<MovieReconstructedCamera> cameras) throws IOException {
      long __address = cameras == null ? 0L : cameras.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      }

   }

   public CPointer<MovieTrackingReconstruction> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MovieTrackingReconstruction.class}, this.__io__block, this.__io__blockTable);
   }
}
