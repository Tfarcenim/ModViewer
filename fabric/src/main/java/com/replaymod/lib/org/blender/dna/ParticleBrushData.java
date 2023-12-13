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
public class ParticleBrushData extends CFacade {
   public static final int __DNA__SDNA_INDEX = 187;
   public static final long[] __DNA__FIELD__size = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__step = new long[]{2L, 2L};
   public static final long[] __DNA__FIELD__invert = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__count = new long[]{6L, 6L};
   public static final long[] __DNA__FIELD__flag = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__strength = new long[]{12L, 12L};

   public ParticleBrushData(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected ParticleBrushData(ParticleBrushData that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public short getSize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 0L) : this.__io__block.readShort(this.__io__address + 0L);
   }

   public void setSize(short size) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 0L, size);
      } else {
         this.__io__block.writeShort(this.__io__address + 0L, size);
      }

   }

   public short getStep() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 2L) : this.__io__block.readShort(this.__io__address + 2L);
   }

   public void setStep(short step) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 2L, step);
      } else {
         this.__io__block.writeShort(this.__io__address + 2L, step);
      }

   }

   public short getInvert() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 4L) : this.__io__block.readShort(this.__io__address + 4L);
   }

   public void setInvert(short invert) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 4L, invert);
      } else {
         this.__io__block.writeShort(this.__io__address + 4L, invert);
      }

   }

   public short getCount() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 6L) : this.__io__block.readShort(this.__io__address + 6L);
   }

   public void setCount(short count) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 6L, count);
      } else {
         this.__io__block.writeShort(this.__io__address + 6L, count);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 8L) : this.__io__block.readInt(this.__io__address + 8L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 8L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 8L, flag);
      }

   }

   public float getStrength() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 12L) : this.__io__block.readFloat(this.__io__address + 12L);
   }

   public void setStrength(float strength) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 12L, strength);
      } else {
         this.__io__block.writeFloat(this.__io__address + 12L, strength);
      }

   }

   public CPointer<ParticleBrushData> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{ParticleBrushData.class}, this.__io__block, this.__io__blockTable);
   }
}
