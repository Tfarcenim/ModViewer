package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 76L,
   size64 = 80L
)
public class EffectorWeights extends CFacade {
   public static final int __DNA__SDNA_INDEX = 157;
   public static final long[] __DNA__FIELD__group = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__weight = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__global_gravity = new long[]{60L, 64L};
   public static final long[] __DNA__FIELD__flag = new long[]{64L, 68L};
   public static final long[] __DNA__FIELD__rt = new long[]{66L, 70L};
   public static final long[] __DNA__FIELD__pad = new long[]{72L, 76L};

   public EffectorWeights(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected EffectorWeights(EffectorWeights that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<Group> getGroup() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Group.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 341), this.__io__blockTable);
   }

   public void setGroup(CPointer<Group> group) throws IOException {
      long __address = group == null ? 0L : group.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CArrayFacade<Float> getWeight() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{14};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 4L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setWeight(CArrayFacade<Float> weight) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 8L;
      } else {
         __dna__offset = 4L;
      }

      if (!this.__io__equals(weight, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, weight)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, weight);
         } else {
            __io__generic__copy(this.getWeight(), weight);
         }

      }
   }

   public float getGlobal_gravity() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 64L) : this.__io__block.readFloat(this.__io__address + 60L);
   }

   public void setGlobal_gravity(float global_gravity) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 64L, global_gravity);
      } else {
         this.__io__block.writeFloat(this.__io__address + 60L, global_gravity);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 68L) : this.__io__block.readShort(this.__io__address + 64L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 68L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 64L, flag);
      }

   }

   public CArrayFacade<Short> getRt() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Short.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 70L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 66L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setRt(CArrayFacade<Short> rt) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 70L;
      } else {
         __dna__offset = 66L;
      }

      if (!this.__io__equals(rt, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, rt)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, rt);
         } else {
            __io__generic__copy(this.getRt(), rt);
         }

      }
   }

   public int getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 76L) : this.__io__block.readInt(this.__io__address + 72L);
   }

   public void setPad(int pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 76L, pad);
      } else {
         this.__io__block.writeInt(this.__io__address + 72L, pad);
      }

   }

   public CPointer<EffectorWeights> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{EffectorWeights.class}, this.__io__block, this.__io__blockTable);
   }
}
