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
public class GameSettings extends CFacade {
   public static final int __DNA__SDNA_INDEX = 44;
   public static final long[] __DNA__FIELD__flag = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__alpha_blend = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__face_orientation = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__pad1 = new long[]{12L, 12L};

   public GameSettings(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected GameSettings(GameSettings that) {
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

   public int getAlpha_blend() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 4L) : this.__io__block.readInt(this.__io__address + 4L);
   }

   public void setAlpha_blend(int alpha_blend) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 4L, alpha_blend);
      } else {
         this.__io__block.writeInt(this.__io__address + 4L, alpha_blend);
      }

   }

   public int getFace_orientation() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 8L) : this.__io__block.readInt(this.__io__address + 8L);
   }

   public void setFace_orientation(int face_orientation) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 8L, face_orientation);
      } else {
         this.__io__block.writeInt(this.__io__address + 8L, face_orientation);
      }

   }

   public int getPad1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 12L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setPad1(int pad1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 12L, pad1);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, pad1);
      }

   }

   public CPointer<GameSettings> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{GameSettings.class}, this.__io__block, this.__io__blockTable);
   }
}
