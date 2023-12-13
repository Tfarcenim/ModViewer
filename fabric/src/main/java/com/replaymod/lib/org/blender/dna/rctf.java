package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 16L,
   size64 = 16L
)
public class rctf extends CFacade {
   public static final int __DNA__SDNA_INDEX = 7;
   public static final long[] __DNA__FIELD__xmin = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__xmax = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__ymin = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__ymax = new long[]{12L, 12L};

   public rctf(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected rctf(rctf that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public float getXmin() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 0L) : this.__io__block.readFloat(this.__io__address + 0L);
   }

   public void setXmin(float xmin) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 0L, xmin);
      } else {
         this.__io__block.writeFloat(this.__io__address + 0L, xmin);
      }

   }

   public float getXmax() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 4L) : this.__io__block.readFloat(this.__io__address + 4L);
   }

   public void setXmax(float xmax) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 4L, xmax);
      } else {
         this.__io__block.writeFloat(this.__io__address + 4L, xmax);
      }

   }

   public float getYmin() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 8L) : this.__io__block.readFloat(this.__io__address + 8L);
   }

   public void setYmin(float ymin) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 8L, ymin);
      } else {
         this.__io__block.writeFloat(this.__io__address + 8L, ymin);
      }

   }

   public float getYmax() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 12L) : this.__io__block.readFloat(this.__io__address + 12L);
   }

   public void setYmax(float ymax) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 12L, ymax);
      } else {
         this.__io__block.writeFloat(this.__io__address + 12L, ymax);
      }

   }

   public CPointer<rctf> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{rctf.class}, this.__io__block, this.__io__blockTable);
   }
}
