package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 72L,
   size64 = 72L
)
public class BezTriple extends CFacade {
   public static final int __DNA__SDNA_INDEX = 50;
   public static final long[] __DNA__FIELD__vec = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__alfa = new long[]{36L, 36L};
   public static final long[] __DNA__FIELD__weight = new long[]{40L, 40L};
   public static final long[] __DNA__FIELD__radius = new long[]{44L, 44L};
   public static final long[] __DNA__FIELD__ipo = new long[]{48L, 48L};
   public static final long[] __DNA__FIELD__h1 = new long[]{49L, 49L};
   public static final long[] __DNA__FIELD__h2 = new long[]{50L, 50L};
   public static final long[] __DNA__FIELD__f1 = new long[]{51L, 51L};
   public static final long[] __DNA__FIELD__f2 = new long[]{52L, 52L};
   public static final long[] __DNA__FIELD__f3 = new long[]{53L, 53L};
   public static final long[] __DNA__FIELD__hide = new long[]{54L, 54L};
   public static final long[] __DNA__FIELD__easing = new long[]{55L, 55L};
   public static final long[] __DNA__FIELD__back = new long[]{56L, 56L};
   public static final long[] __DNA__FIELD__amplitude = new long[]{60L, 60L};
   public static final long[] __DNA__FIELD__period = new long[]{64L, 64L};
   public static final long[] __DNA__FIELD__pad = new long[]{68L, 68L};

   public BezTriple(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected BezTriple(BezTriple that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CArrayFacade<CArrayFacade<Float>> getVec() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CArrayFacade.class, Float.class};
      int[] __dna__dimensions = new int[]{3, 3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setVec(CArrayFacade<CArrayFacade<Float>> vec) throws IOException {
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
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 36L) : this.__io__block.readFloat(this.__io__address + 36L);
   }

   public void setAlfa(float alfa) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 36L, alfa);
      } else {
         this.__io__block.writeFloat(this.__io__address + 36L, alfa);
      }

   }

   public float getWeight() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 40L) : this.__io__block.readFloat(this.__io__address + 40L);
   }

   public void setWeight(float weight) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 40L, weight);
      } else {
         this.__io__block.writeFloat(this.__io__address + 40L, weight);
      }

   }

   public float getRadius() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 44L) : this.__io__block.readFloat(this.__io__address + 44L);
   }

   public void setRadius(float radius) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 44L, radius);
      } else {
         this.__io__block.writeFloat(this.__io__address + 44L, radius);
      }

   }

   public byte getIpo() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 48L) : this.__io__block.readByte(this.__io__address + 48L);
   }

   public void setIpo(byte ipo) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 48L, ipo);
      } else {
         this.__io__block.writeByte(this.__io__address + 48L, ipo);
      }

   }

   public byte getH1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 49L) : this.__io__block.readByte(this.__io__address + 49L);
   }

   public void setH1(byte h1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 49L, h1);
      } else {
         this.__io__block.writeByte(this.__io__address + 49L, h1);
      }

   }

   public byte getH2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 50L) : this.__io__block.readByte(this.__io__address + 50L);
   }

   public void setH2(byte h2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 50L, h2);
      } else {
         this.__io__block.writeByte(this.__io__address + 50L, h2);
      }

   }

   public byte getF1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 51L) : this.__io__block.readByte(this.__io__address + 51L);
   }

   public void setF1(byte f1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 51L, f1);
      } else {
         this.__io__block.writeByte(this.__io__address + 51L, f1);
      }

   }

   public byte getF2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 52L) : this.__io__block.readByte(this.__io__address + 52L);
   }

   public void setF2(byte f2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 52L, f2);
      } else {
         this.__io__block.writeByte(this.__io__address + 52L, f2);
      }

   }

   public byte getF3() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 53L) : this.__io__block.readByte(this.__io__address + 53L);
   }

   public void setF3(byte f3) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 53L, f3);
      } else {
         this.__io__block.writeByte(this.__io__address + 53L, f3);
      }

   }

   public byte getHide() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 54L) : this.__io__block.readByte(this.__io__address + 54L);
   }

   public void setHide(byte hide) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 54L, hide);
      } else {
         this.__io__block.writeByte(this.__io__address + 54L, hide);
      }

   }

   public byte getEasing() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 55L) : this.__io__block.readByte(this.__io__address + 55L);
   }

   public void setEasing(byte easing) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 55L, easing);
      } else {
         this.__io__block.writeByte(this.__io__address + 55L, easing);
      }

   }

   public float getBack() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 56L) : this.__io__block.readFloat(this.__io__address + 56L);
   }

   public void setBack(float back) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 56L, back);
      } else {
         this.__io__block.writeFloat(this.__io__address + 56L, back);
      }

   }

   public float getAmplitude() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 60L) : this.__io__block.readFloat(this.__io__address + 60L);
   }

   public void setAmplitude(float amplitude) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 60L, amplitude);
      } else {
         this.__io__block.writeFloat(this.__io__address + 60L, amplitude);
      }

   }

   public float getPeriod() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 64L) : this.__io__block.readFloat(this.__io__address + 64L);
   }

   public void setPeriod(float period) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 64L, period);
      } else {
         this.__io__block.writeFloat(this.__io__address + 64L, period);
      }

   }

   public CArrayFacade<Byte> getPad() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 68L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 68L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad(CArrayFacade<Byte> pad) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 68L;
      } else {
         __dna__offset = 68L;
      }

      if (!this.__io__equals(pad, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad);
         } else {
            __io__generic__copy(this.getPad(), pad);
         }

      }
   }

   public CPointer<BezTriple> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{BezTriple.class}, this.__io__block, this.__io__blockTable);
   }
}
