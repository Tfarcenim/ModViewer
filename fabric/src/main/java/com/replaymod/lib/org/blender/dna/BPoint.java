package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 36L,
   size64 = 36L
)
public class BPoint extends CFacade {
   public static final int __DNA__SDNA_INDEX = 51;
   public static final long[] __DNA__FIELD__vec = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__alfa = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__weight = new long[]{20L, 20L};
   public static final long[] __DNA__FIELD__f1 = new long[]{24L, 24L};
   public static final long[] __DNA__FIELD__hide = new long[]{26L, 26L};
   public static final long[] __DNA__FIELD__radius = new long[]{28L, 28L};
   public static final long[] __DNA__FIELD__pad = new long[]{32L, 32L};

   public BPoint(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected BPoint(BPoint that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CArrayFacade<Float> getVec() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setVec(CArrayFacade<Float> vec) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(vec, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, vec)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, vec);
         } else {
            __io__generic__copy(this.getVec(), vec);
         }

      }
   }

   public float getAlfa() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 16L) : this.__io__block.readFloat(this.__io__address + 16L);
   }

   public void setAlfa(float alfa) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 16L, alfa);
      } else {
         this.__io__block.writeFloat(this.__io__address + 16L, alfa);
      }

   }

   public float getWeight() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 20L) : this.__io__block.readFloat(this.__io__address + 20L);
   }

   public void setWeight(float weight) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 20L, weight);
      } else {
         this.__io__block.writeFloat(this.__io__address + 20L, weight);
      }

   }

   public short getF1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 24L) : this.__io__block.readShort(this.__io__address + 24L);
   }

   public void setF1(short f1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 24L, f1);
      } else {
         this.__io__block.writeShort(this.__io__address + 24L, f1);
      }

   }

   public short getHide() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 26L) : this.__io__block.readShort(this.__io__address + 26L);
   }

   public void setHide(short hide) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 26L, hide);
      } else {
         this.__io__block.writeShort(this.__io__address + 26L, hide);
      }

   }

   public float getRadius() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 28L) : this.__io__block.readFloat(this.__io__address + 28L);
   }

   public void setRadius(float radius) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 28L, radius);
      } else {
         this.__io__block.writeFloat(this.__io__address + 28L, radius);
      }

   }

   public float getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 32L) : this.__io__block.readFloat(this.__io__address + 32L);
   }

   public void setPad(float pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 32L, pad);
      } else {
         this.__io__block.writeFloat(this.__io__address + 32L, pad);
      }

   }

   public CPointer<BPoint> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{BPoint.class}, this.__io__block, this.__io__blockTable);
   }
}
