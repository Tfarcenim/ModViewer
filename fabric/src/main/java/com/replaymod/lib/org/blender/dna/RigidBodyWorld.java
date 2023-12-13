package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 56L,
   size64 = 88L
)
public class RigidBodyWorld extends CFacade {
   public static final int __DNA__SDNA_INDEX = 572;
   public static final long[] __DNA__FIELD__effector_weights = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__group = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__objects = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__constraints = new long[]{12L, 24L};
   public static final long[] __DNA__FIELD__pad = new long[]{16L, 32L};
   public static final long[] __DNA__FIELD__ltime = new long[]{20L, 36L};
   public static final long[] __DNA__FIELD__pointcache = new long[]{24L, 40L};
   public static final long[] __DNA__FIELD__ptcaches = new long[]{28L, 48L};
   public static final long[] __DNA__FIELD__numbodies = new long[]{36L, 64L};
   public static final long[] __DNA__FIELD__steps_per_second = new long[]{40L, 68L};
   public static final long[] __DNA__FIELD__num_solver_iterations = new long[]{42L, 70L};
   public static final long[] __DNA__FIELD__flag = new long[]{44L, 72L};
   public static final long[] __DNA__FIELD__time_scale = new long[]{48L, 76L};
   public static final long[] __DNA__FIELD__physics_world = new long[]{52L, 80L};

   public RigidBodyWorld(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected RigidBodyWorld(RigidBodyWorld that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<EffectorWeights> getEffector_weights() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{EffectorWeights.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 157), this.__io__blockTable);
   }

   public void setEffector_weights(CPointer<EffectorWeights> effector_weights) throws IOException {
      long __address = effector_weights == null ? 0L : effector_weights.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<Group> getGroup() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Group.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 341), this.__io__blockTable);
   }

   public void setGroup(CPointer<Group> group) throws IOException {
      long __address = group == null ? 0L : group.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public CPointer<CPointer<BlenderObject>> getObjects() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{CPointer.class, BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, __dna__targetTypes), this.__io__blockTable);
   }

   public void setObjects(CPointer<CPointer<BlenderObject>> objects) throws IOException {
      long __address = objects == null ? 0L : objects.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      }

   }

   public CPointer<Group> getConstraints() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 24L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 12L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Group.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 341), this.__io__blockTable);
   }

   public void setConstraints(CPointer<Group> constraints) throws IOException {
      long __address = constraints == null ? 0L : constraints.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 24L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 12L, __address);
      }

   }

   public int getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 32L) : this.__io__block.readInt(this.__io__address + 16L);
   }

   public void setPad(int pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 32L, pad);
      } else {
         this.__io__block.writeInt(this.__io__address + 16L, pad);
      }

   }

   public float getLtime() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 36L) : this.__io__block.readFloat(this.__io__address + 20L);
   }

   public void setLtime(float ltime) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 36L, ltime);
      } else {
         this.__io__block.writeFloat(this.__io__address + 20L, ltime);
      }

   }

   public CPointer<PointCache> getPointcache() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 40L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 24L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PointCache.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 160), this.__io__blockTable);
   }

   public void setPointcache(CPointer<PointCache> pointcache) throws IOException {
      long __address = pointcache == null ? 0L : pointcache.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 40L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 24L, __address);
      }

   }

   public ListBase getPtcaches() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 48L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 28L, this.__io__block, this.__io__blockTable);
   }

   public void setPtcaches(ListBase ptcaches) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 48L;
      } else {
         __dna__offset = 28L;
      }

      if (!this.__io__equals(ptcaches, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, ptcaches)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, ptcaches);
         } else {
            __io__generic__copy(this.getPtcaches(), ptcaches);
         }

      }
   }

   public int getNumbodies() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 64L) : this.__io__block.readInt(this.__io__address + 36L);
   }

   public void setNumbodies(int numbodies) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 64L, numbodies);
      } else {
         this.__io__block.writeInt(this.__io__address + 36L, numbodies);
      }

   }

   public short getSteps_per_second() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 68L) : this.__io__block.readShort(this.__io__address + 40L);
   }

   public void setSteps_per_second(short steps_per_second) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 68L, steps_per_second);
      } else {
         this.__io__block.writeShort(this.__io__address + 40L, steps_per_second);
      }

   }

   public short getNum_solver_iterations() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 70L) : this.__io__block.readShort(this.__io__address + 42L);
   }

   public void setNum_solver_iterations(short num_solver_iterations) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 70L, num_solver_iterations);
      } else {
         this.__io__block.writeShort(this.__io__address + 42L, num_solver_iterations);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 72L) : this.__io__block.readInt(this.__io__address + 44L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 72L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 44L, flag);
      }

   }

   public float getTime_scale() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 76L) : this.__io__block.readFloat(this.__io__address + 48L);
   }

   public void setTime_scale(float time_scale) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 76L, time_scale);
      } else {
         this.__io__block.writeFloat(this.__io__address + 48L, time_scale);
      }

   }

   public CPointer<Object> getPhysics_world() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 80L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 52L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setPhysics_world(CPointer<Object> physics_world) throws IOException {
      long __address = physics_world == null ? 0L : physics_world.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 80L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 52L, __address);
      }

   }

   public CPointer<RigidBodyWorld> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{RigidBodyWorld.class}, this.__io__block, this.__io__blockTable);
   }
}
