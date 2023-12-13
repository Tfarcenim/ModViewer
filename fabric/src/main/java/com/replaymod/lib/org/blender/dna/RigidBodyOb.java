package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 88L,
   size64 = 96L
)
public class RigidBodyOb extends CFacade {
   public static final int __DNA__SDNA_INDEX = 573;
   public static final long[] __DNA__FIELD__physics_object = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__physics_shape = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__type = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__shape = new long[]{10L, 18L};
   public static final long[] __DNA__FIELD__flag = new long[]{12L, 20L};
   public static final long[] __DNA__FIELD__col_groups = new long[]{16L, 24L};
   public static final long[] __DNA__FIELD__mesh_source = new long[]{20L, 28L};
   public static final long[] __DNA__FIELD__pad = new long[]{22L, 30L};
   public static final long[] __DNA__FIELD__mass = new long[]{24L, 32L};
   public static final long[] __DNA__FIELD__friction = new long[]{28L, 36L};
   public static final long[] __DNA__FIELD__restitution = new long[]{32L, 40L};
   public static final long[] __DNA__FIELD__margin = new long[]{36L, 44L};
   public static final long[] __DNA__FIELD__lin_damping = new long[]{40L, 48L};
   public static final long[] __DNA__FIELD__ang_damping = new long[]{44L, 52L};
   public static final long[] __DNA__FIELD__lin_sleep_thresh = new long[]{48L, 56L};
   public static final long[] __DNA__FIELD__ang_sleep_thresh = new long[]{52L, 60L};
   public static final long[] __DNA__FIELD__orn = new long[]{56L, 64L};
   public static final long[] __DNA__FIELD__pos = new long[]{72L, 80L};
   public static final long[] __DNA__FIELD__pad1 = new long[]{84L, 92L};

   public RigidBodyOb(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected RigidBodyOb(RigidBodyOb that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<Object> getPhysics_object() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setPhysics_object(CPointer<Object> physics_object) throws IOException {
      long __address = physics_object == null ? 0L : physics_object.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<Object> getPhysics_shape() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setPhysics_shape(CPointer<Object> physics_shape) throws IOException {
      long __address = physics_shape == null ? 0L : physics_shape.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public short getType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 16L) : this.__io__block.readShort(this.__io__address + 8L);
   }

   public void setType(short type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 16L, type);
      } else {
         this.__io__block.writeShort(this.__io__address + 8L, type);
      }

   }

   public short getShape() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 18L) : this.__io__block.readShort(this.__io__address + 10L);
   }

   public void setShape(short shape) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 18L, shape);
      } else {
         this.__io__block.writeShort(this.__io__address + 10L, shape);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 20L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 20L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, flag);
      }

   }

   public int getCol_groups() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 24L) : this.__io__block.readInt(this.__io__address + 16L);
   }

   public void setCol_groups(int col_groups) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 24L, col_groups);
      } else {
         this.__io__block.writeInt(this.__io__address + 16L, col_groups);
      }

   }

   public short getMesh_source() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 28L) : this.__io__block.readShort(this.__io__address + 20L);
   }

   public void setMesh_source(short mesh_source) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 28L, mesh_source);
      } else {
         this.__io__block.writeShort(this.__io__address + 20L, mesh_source);
      }

   }

   public short getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 30L) : this.__io__block.readShort(this.__io__address + 22L);
   }

   public void setPad(short pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 30L, pad);
      } else {
         this.__io__block.writeShort(this.__io__address + 22L, pad);
      }

   }

   public float getMass() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 32L) : this.__io__block.readFloat(this.__io__address + 24L);
   }

   public void setMass(float mass) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 32L, mass);
      } else {
         this.__io__block.writeFloat(this.__io__address + 24L, mass);
      }

   }

   public float getFriction() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 36L) : this.__io__block.readFloat(this.__io__address + 28L);
   }

   public void setFriction(float friction) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 36L, friction);
      } else {
         this.__io__block.writeFloat(this.__io__address + 28L, friction);
      }

   }

   public float getRestitution() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 40L) : this.__io__block.readFloat(this.__io__address + 32L);
   }

   public void setRestitution(float restitution) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 40L, restitution);
      } else {
         this.__io__block.writeFloat(this.__io__address + 32L, restitution);
      }

   }

   public float getMargin() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 44L) : this.__io__block.readFloat(this.__io__address + 36L);
   }

   public void setMargin(float margin) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 44L, margin);
      } else {
         this.__io__block.writeFloat(this.__io__address + 36L, margin);
      }

   }

   public float getLin_damping() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 48L) : this.__io__block.readFloat(this.__io__address + 40L);
   }

   public void setLin_damping(float lin_damping) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 48L, lin_damping);
      } else {
         this.__io__block.writeFloat(this.__io__address + 40L, lin_damping);
      }

   }

   public float getAng_damping() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 52L) : this.__io__block.readFloat(this.__io__address + 44L);
   }

   public void setAng_damping(float ang_damping) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 52L, ang_damping);
      } else {
         this.__io__block.writeFloat(this.__io__address + 44L, ang_damping);
      }

   }

   public float getLin_sleep_thresh() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 56L) : this.__io__block.readFloat(this.__io__address + 48L);
   }

   public void setLin_sleep_thresh(float lin_sleep_thresh) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 56L, lin_sleep_thresh);
      } else {
         this.__io__block.writeFloat(this.__io__address + 48L, lin_sleep_thresh);
      }

   }

   public float getAng_sleep_thresh() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 60L) : this.__io__block.readFloat(this.__io__address + 52L);
   }

   public void setAng_sleep_thresh(float ang_sleep_thresh) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 60L, ang_sleep_thresh);
      } else {
         this.__io__block.writeFloat(this.__io__address + 52L, ang_sleep_thresh);
      }

   }

   public CArrayFacade<Float> getOrn() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 64L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 56L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setOrn(CArrayFacade<Float> orn) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 64L;
      } else {
         __dna__offset = 56L;
      }

      if (!this.__io__equals(orn, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, orn)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, orn);
         } else {
            __io__generic__copy(this.getOrn(), orn);
         }

      }
   }

   public CArrayFacade<Float> getPos() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 80L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 72L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPos(CArrayFacade<Float> pos) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 80L;
      } else {
         __dna__offset = 72L;
      }

      if (!this.__io__equals(pos, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pos)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pos);
         } else {
            __io__generic__copy(this.getPos(), pos);
         }

      }
   }

   public float getPad1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 92L) : this.__io__block.readFloat(this.__io__address + 84L);
   }

   public void setPad1(float pad1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 92L, pad1);
      } else {
         this.__io__block.writeFloat(this.__io__address + 84L, pad1);
      }

   }

   public CPointer<RigidBodyOb> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{RigidBodyOb.class}, this.__io__block, this.__io__blockTable);
   }
}
