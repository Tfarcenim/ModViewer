package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 336L,
   size64 = 360L
)
public class Bone extends CFacade {
   public static final int __DNA__SDNA_INDEX = 342;
   public static final long[] __DNA__FIELD__next = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__prev = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__prop = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__parent = new long[]{12L, 24L};
   public static final long[] __DNA__FIELD__childbase = new long[]{16L, 32L};
   public static final long[] __DNA__FIELD__name = new long[]{24L, 48L};
   public static final long[] __DNA__FIELD__roll = new long[]{88L, 112L};
   public static final long[] __DNA__FIELD__head = new long[]{92L, 116L};
   public static final long[] __DNA__FIELD__tail = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__bone_mat = new long[]{116L, 140L};
   public static final long[] __DNA__FIELD__flag = new long[]{152L, 176L};
   public static final long[] __DNA__FIELD__arm_head = new long[]{156L, 180L};
   public static final long[] __DNA__FIELD__arm_tail = new long[]{168L, 192L};
   public static final long[] __DNA__FIELD__arm_mat = new long[]{180L, 204L};
   public static final long[] __DNA__FIELD__arm_roll = new long[]{244L, 268L};
   public static final long[] __DNA__FIELD__dist = new long[]{248L, 272L};
   public static final long[] __DNA__FIELD__weight = new long[]{252L, 276L};
   public static final long[] __DNA__FIELD__xwidth = new long[]{256L, 280L};
   public static final long[] __DNA__FIELD__length = new long[]{260L, 284L};
   public static final long[] __DNA__FIELD__zwidth = new long[]{264L, 288L};
   public static final long[] __DNA__FIELD__ease1 = new long[]{268L, 292L};
   public static final long[] __DNA__FIELD__ease2 = new long[]{272L, 296L};
   public static final long[] __DNA__FIELD__rad_head = new long[]{276L, 300L};
   public static final long[] __DNA__FIELD__rad_tail = new long[]{280L, 304L};
   public static final long[] __DNA__FIELD__roll1 = new long[]{284L, 308L};
   public static final long[] __DNA__FIELD__roll2 = new long[]{288L, 312L};
   public static final long[] __DNA__FIELD__curveInX = new long[]{292L, 316L};
   public static final long[] __DNA__FIELD__curveInY = new long[]{296L, 320L};
   public static final long[] __DNA__FIELD__curveOutX = new long[]{300L, 324L};
   public static final long[] __DNA__FIELD__curveOutY = new long[]{304L, 328L};
   public static final long[] __DNA__FIELD__scaleIn = new long[]{308L, 332L};
   public static final long[] __DNA__FIELD__scaleOut = new long[]{312L, 336L};
   public static final long[] __DNA__FIELD__size = new long[]{316L, 340L};
   public static final long[] __DNA__FIELD__layer = new long[]{328L, 352L};
   public static final long[] __DNA__FIELD__segments = new long[]{332L, 356L};
   public static final long[] __DNA__FIELD__pad1 = new long[]{334L, 358L};

   public Bone(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Bone(Bone that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<Bone> getNext() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Bone.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 342), this.__io__blockTable);
   }

   public void setNext(CPointer<Bone> next) throws IOException {
      long __address = next == null ? 0L : next.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<Bone> getPrev() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Bone.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 342), this.__io__blockTable);
   }

   public void setPrev(CPointer<Bone> prev) throws IOException {
      long __address = prev == null ? 0L : prev.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public CPointer<IDProperty> getProp() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{IDProperty.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 9), this.__io__blockTable);
   }

   public void setProp(CPointer<IDProperty> prop) throws IOException {
      long __address = prop == null ? 0L : prop.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      }

   }

   public CPointer<Bone> getParent() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 24L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 12L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Bone.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 342), this.__io__blockTable);
   }

   public void setParent(CPointer<Bone> parent) throws IOException {
      long __address = parent == null ? 0L : parent.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 24L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 12L, __address);
      }

   }

   public ListBase getChildbase() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 32L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 16L, this.__io__block, this.__io__blockTable);
   }

   public void setChildbase(ListBase childbase) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 32L;
      } else {
         __dna__offset = 16L;
      }

      if (!this.__io__equals(childbase, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, childbase)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, childbase);
         } else {
            __io__generic__copy(this.getChildbase(), childbase);
         }

      }
   }

   public CArrayFacade<Byte> getName() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 48L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 24L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setName(CArrayFacade<Byte> name) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 48L;
      } else {
         __dna__offset = 24L;
      }

      if (!this.__io__equals(name, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, name)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, name);
         } else {
            __io__generic__copy(this.getName(), name);
         }

      }
   }

   public float getRoll() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 112L) : this.__io__block.readFloat(this.__io__address + 88L);
   }

   public void setRoll(float roll) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 112L, roll);
      } else {
         this.__io__block.writeFloat(this.__io__address + 88L, roll);
      }

   }

   public CArrayFacade<Float> getHead() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 116L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 92L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setHead(CArrayFacade<Float> head) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 116L;
      } else {
         __dna__offset = 92L;
      }

      if (!this.__io__equals(head, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, head)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, head);
         } else {
            __io__generic__copy(this.getHead(), head);
         }

      }
   }

   public CArrayFacade<Float> getTail() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 128L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 104L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setTail(CArrayFacade<Float> tail) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 128L;
      } else {
         __dna__offset = 104L;
      }

      if (!this.__io__equals(tail, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, tail)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, tail);
         } else {
            __io__generic__copy(this.getTail(), tail);
         }

      }
   }

   public CArrayFacade<CArrayFacade<Float>> getBone_mat() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CArrayFacade.class, Float.class};
      int[] __dna__dimensions = new int[]{3, 3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 140L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 116L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setBone_mat(CArrayFacade<CArrayFacade<Float>> bone_mat) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 140L;
      } else {
         __dna__offset = 116L;
      }

      if (!this.__io__equals(bone_mat, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, bone_mat)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, bone_mat);
         } else {
            __io__generic__copy(this.getBone_mat(), bone_mat);
         }

      }
   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 176L) : this.__io__block.readInt(this.__io__address + 152L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 176L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 152L, flag);
      }

   }

   public CArrayFacade<Float> getArm_head() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 180L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 156L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setArm_head(CArrayFacade<Float> arm_head) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 180L;
      } else {
         __dna__offset = 156L;
      }

      if (!this.__io__equals(arm_head, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, arm_head)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, arm_head);
         } else {
            __io__generic__copy(this.getArm_head(), arm_head);
         }

      }
   }

   public CArrayFacade<Float> getArm_tail() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 192L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 168L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setArm_tail(CArrayFacade<Float> arm_tail) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 192L;
      } else {
         __dna__offset = 168L;
      }

      if (!this.__io__equals(arm_tail, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, arm_tail)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, arm_tail);
         } else {
            __io__generic__copy(this.getArm_tail(), arm_tail);
         }

      }
   }

   public CArrayFacade<CArrayFacade<Float>> getArm_mat() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CArrayFacade.class, Float.class};
      int[] __dna__dimensions = new int[]{4, 4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 204L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 180L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setArm_mat(CArrayFacade<CArrayFacade<Float>> arm_mat) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 204L;
      } else {
         __dna__offset = 180L;
      }

      if (!this.__io__equals(arm_mat, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, arm_mat)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, arm_mat);
         } else {
            __io__generic__copy(this.getArm_mat(), arm_mat);
         }

      }
   }

   public float getArm_roll() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 268L) : this.__io__block.readFloat(this.__io__address + 244L);
   }

   public void setArm_roll(float arm_roll) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 268L, arm_roll);
      } else {
         this.__io__block.writeFloat(this.__io__address + 244L, arm_roll);
      }

   }

   public float getDist() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 272L) : this.__io__block.readFloat(this.__io__address + 248L);
   }

   public void setDist(float dist) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 272L, dist);
      } else {
         this.__io__block.writeFloat(this.__io__address + 248L, dist);
      }

   }

   public float getWeight() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 276L) : this.__io__block.readFloat(this.__io__address + 252L);
   }

   public void setWeight(float weight) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 276L, weight);
      } else {
         this.__io__block.writeFloat(this.__io__address + 252L, weight);
      }

   }

   public float getXwidth() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 280L) : this.__io__block.readFloat(this.__io__address + 256L);
   }

   public void setXwidth(float xwidth) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 280L, xwidth);
      } else {
         this.__io__block.writeFloat(this.__io__address + 256L, xwidth);
      }

   }

   public float getLength() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 284L) : this.__io__block.readFloat(this.__io__address + 260L);
   }

   public void setLength(float length) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 284L, length);
      } else {
         this.__io__block.writeFloat(this.__io__address + 260L, length);
      }

   }

   public float getZwidth() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 288L) : this.__io__block.readFloat(this.__io__address + 264L);
   }

   public void setZwidth(float zwidth) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 288L, zwidth);
      } else {
         this.__io__block.writeFloat(this.__io__address + 264L, zwidth);
      }

   }

   public float getEase1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 292L) : this.__io__block.readFloat(this.__io__address + 268L);
   }

   public void setEase1(float ease1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 292L, ease1);
      } else {
         this.__io__block.writeFloat(this.__io__address + 268L, ease1);
      }

   }

   public float getEase2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 296L) : this.__io__block.readFloat(this.__io__address + 272L);
   }

   public void setEase2(float ease2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 296L, ease2);
      } else {
         this.__io__block.writeFloat(this.__io__address + 272L, ease2);
      }

   }

   public float getRad_head() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 300L) : this.__io__block.readFloat(this.__io__address + 276L);
   }

   public void setRad_head(float rad_head) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 300L, rad_head);
      } else {
         this.__io__block.writeFloat(this.__io__address + 276L, rad_head);
      }

   }

   public float getRad_tail() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 304L) : this.__io__block.readFloat(this.__io__address + 280L);
   }

   public void setRad_tail(float rad_tail) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 304L, rad_tail);
      } else {
         this.__io__block.writeFloat(this.__io__address + 280L, rad_tail);
      }

   }

   public float getRoll1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 308L) : this.__io__block.readFloat(this.__io__address + 284L);
   }

   public void setRoll1(float roll1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 308L, roll1);
      } else {
         this.__io__block.writeFloat(this.__io__address + 284L, roll1);
      }

   }

   public float getRoll2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 312L) : this.__io__block.readFloat(this.__io__address + 288L);
   }

   public void setRoll2(float roll2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 312L, roll2);
      } else {
         this.__io__block.writeFloat(this.__io__address + 288L, roll2);
      }

   }

   public float getCurveInX() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 316L) : this.__io__block.readFloat(this.__io__address + 292L);
   }

   public void setCurveInX(float curveInX) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 316L, curveInX);
      } else {
         this.__io__block.writeFloat(this.__io__address + 292L, curveInX);
      }

   }

   public float getCurveInY() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 320L) : this.__io__block.readFloat(this.__io__address + 296L);
   }

   public void setCurveInY(float curveInY) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 320L, curveInY);
      } else {
         this.__io__block.writeFloat(this.__io__address + 296L, curveInY);
      }

   }

   public float getCurveOutX() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 324L) : this.__io__block.readFloat(this.__io__address + 300L);
   }

   public void setCurveOutX(float curveOutX) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 324L, curveOutX);
      } else {
         this.__io__block.writeFloat(this.__io__address + 300L, curveOutX);
      }

   }

   public float getCurveOutY() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 328L) : this.__io__block.readFloat(this.__io__address + 304L);
   }

   public void setCurveOutY(float curveOutY) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 328L, curveOutY);
      } else {
         this.__io__block.writeFloat(this.__io__address + 304L, curveOutY);
      }

   }

   public float getScaleIn() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 332L) : this.__io__block.readFloat(this.__io__address + 308L);
   }

   public void setScaleIn(float scaleIn) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 332L, scaleIn);
      } else {
         this.__io__block.writeFloat(this.__io__address + 308L, scaleIn);
      }

   }

   public float getScaleOut() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 336L) : this.__io__block.readFloat(this.__io__address + 312L);
   }

   public void setScaleOut(float scaleOut) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 336L, scaleOut);
      } else {
         this.__io__block.writeFloat(this.__io__address + 312L, scaleOut);
      }

   }

   public CArrayFacade<Float> getSize() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 340L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 316L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setSize(CArrayFacade<Float> size) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 340L;
      } else {
         __dna__offset = 316L;
      }

      if (!this.__io__equals(size, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, size)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, size);
         } else {
            __io__generic__copy(this.getSize(), size);
         }

      }
   }

   public int getLayer() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 352L) : this.__io__block.readInt(this.__io__address + 328L);
   }

   public void setLayer(int layer) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 352L, layer);
      } else {
         this.__io__block.writeInt(this.__io__address + 328L, layer);
      }

   }

   public short getSegments() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 356L) : this.__io__block.readShort(this.__io__address + 332L);
   }

   public void setSegments(short segments) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 356L, segments);
      } else {
         this.__io__block.writeShort(this.__io__address + 332L, segments);
      }

   }

   public short getPad1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 358L) : this.__io__block.readShort(this.__io__address + 334L);
   }

   public void setPad1(short pad1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 358L, pad1);
      } else {
         this.__io__block.writeShort(this.__io__address + 334L, pad1);
      }

   }

   public CPointer<Bone> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Bone.class}, this.__io__block, this.__io__blockTable);
   }
}
