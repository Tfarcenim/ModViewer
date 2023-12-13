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
public class CBData extends CFacade {
   public static final int __DNA__SDNA_INDEX = 33;
   public static final long[] __DNA__FIELD__r = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__g = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__b = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__a = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__pos = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__cur = new long[]{20L, 20L};

   public CBData(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected CBData(CBData that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public float getR() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 0L) : this.__io__block.readFloat(this.__io__address + 0L);
   }

   public void setR(float r) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 0L, r);
      } else {
         this.__io__block.writeFloat(this.__io__address + 0L, r);
      }

   }

   public float getG() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 4L) : this.__io__block.readFloat(this.__io__address + 4L);
   }

   public void setG(float g) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 4L, g);
      } else {
         this.__io__block.writeFloat(this.__io__address + 4L, g);
      }

   }

   public float getB() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 8L) : this.__io__block.readFloat(this.__io__address + 8L);
   }

   public void setB(float b) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 8L, b);
      } else {
         this.__io__block.writeFloat(this.__io__address + 8L, b);
      }

   }

   public float getA() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 12L) : this.__io__block.readFloat(this.__io__address + 12L);
   }

   public void setA(float a) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 12L, a);
      } else {
         this.__io__block.writeFloat(this.__io__address + 12L, a);
      }

   }

   public float getPos() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 16L) : this.__io__block.readFloat(this.__io__address + 16L);
   }

   public void setPos(float pos) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 16L, pos);
      } else {
         this.__io__block.writeFloat(this.__io__address + 16L, pos);
      }

   }

   public int getCur() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 20L) : this.__io__block.readInt(this.__io__address + 20L);
   }

   public void setCur(int cur) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 20L, cur);
      } else {
         this.__io__block.writeInt(this.__io__address + 20L, cur);
      }

   }

   public CPointer<CBData> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{CBData.class}, this.__io__block, this.__io__blockTable);
   }
}
