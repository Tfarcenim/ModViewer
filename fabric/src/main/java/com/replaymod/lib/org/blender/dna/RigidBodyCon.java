package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 140L,
   size64 = 152L
)
public class RigidBodyCon extends CFacade {
   public static final int __DNA__SDNA_INDEX = 574;
   public static final long[] __DNA__FIELD__ob1 = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__ob2 = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__type = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__num_solver_iterations = new long[]{10L, 18L};
   public static final long[] __DNA__FIELD__flag = new long[]{12L, 20L};
   public static final long[] __DNA__FIELD__breaking_threshold = new long[]{16L, 24L};
   public static final long[] __DNA__FIELD__pad = new long[]{20L, 28L};
   public static final long[] __DNA__FIELD__limit_lin_x_lower = new long[]{24L, 32L};
   public static final long[] __DNA__FIELD__limit_lin_x_upper = new long[]{28L, 36L};
   public static final long[] __DNA__FIELD__limit_lin_y_lower = new long[]{32L, 40L};
   public static final long[] __DNA__FIELD__limit_lin_y_upper = new long[]{36L, 44L};
   public static final long[] __DNA__FIELD__limit_lin_z_lower = new long[]{40L, 48L};
   public static final long[] __DNA__FIELD__limit_lin_z_upper = new long[]{44L, 52L};
   public static final long[] __DNA__FIELD__limit_ang_x_lower = new long[]{48L, 56L};
   public static final long[] __DNA__FIELD__limit_ang_x_upper = new long[]{52L, 60L};
   public static final long[] __DNA__FIELD__limit_ang_y_lower = new long[]{56L, 64L};
   public static final long[] __DNA__FIELD__limit_ang_y_upper = new long[]{60L, 68L};
   public static final long[] __DNA__FIELD__limit_ang_z_lower = new long[]{64L, 72L};
   public static final long[] __DNA__FIELD__limit_ang_z_upper = new long[]{68L, 76L};
   public static final long[] __DNA__FIELD__spring_stiffness_x = new long[]{72L, 80L};
   public static final long[] __DNA__FIELD__spring_stiffness_y = new long[]{76L, 84L};
   public static final long[] __DNA__FIELD__spring_stiffness_z = new long[]{80L, 88L};
   public static final long[] __DNA__FIELD__spring_stiffness_ang_x = new long[]{84L, 92L};
   public static final long[] __DNA__FIELD__spring_stiffness_ang_y = new long[]{88L, 96L};
   public static final long[] __DNA__FIELD__spring_stiffness_ang_z = new long[]{92L, 100L};
   public static final long[] __DNA__FIELD__spring_damping_x = new long[]{96L, 104L};
   public static final long[] __DNA__FIELD__spring_damping_y = new long[]{100L, 108L};
   public static final long[] __DNA__FIELD__spring_damping_z = new long[]{104L, 112L};
   public static final long[] __DNA__FIELD__spring_damping_ang_x = new long[]{108L, 116L};
   public static final long[] __DNA__FIELD__spring_damping_ang_y = new long[]{112L, 120L};
   public static final long[] __DNA__FIELD__spring_damping_ang_z = new long[]{116L, 124L};
   public static final long[] __DNA__FIELD__motor_lin_target_velocity = new long[]{120L, 128L};
   public static final long[] __DNA__FIELD__motor_ang_target_velocity = new long[]{124L, 132L};
   public static final long[] __DNA__FIELD__motor_lin_max_impulse = new long[]{128L, 136L};
   public static final long[] __DNA__FIELD__motor_ang_max_impulse = new long[]{132L, 140L};
   public static final long[] __DNA__FIELD__physics_constraint = new long[]{136L, 144L};

   public RigidBodyCon(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected RigidBodyCon(RigidBodyCon that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<BlenderObject> getOb1() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setOb1(CPointer<BlenderObject> ob1) throws IOException {
      long __address = ob1 == null ? 0L : ob1.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<BlenderObject> getOb2() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setOb2(CPointer<BlenderObject> ob2) throws IOException {
      long __address = ob2 == null ? 0L : ob2.getAddress();
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

   public short getNum_solver_iterations() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 18L) : this.__io__block.readShort(this.__io__address + 10L);
   }

   public void setNum_solver_iterations(short num_solver_iterations) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 18L, num_solver_iterations);
      } else {
         this.__io__block.writeShort(this.__io__address + 10L, num_solver_iterations);
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

   public float getBreaking_threshold() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 24L) : this.__io__block.readFloat(this.__io__address + 16L);
   }

   public void setBreaking_threshold(float breaking_threshold) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 24L, breaking_threshold);
      } else {
         this.__io__block.writeFloat(this.__io__address + 16L, breaking_threshold);
      }

   }

   public float getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 28L) : this.__io__block.readFloat(this.__io__address + 20L);
   }

   public void setPad(float pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 28L, pad);
      } else {
         this.__io__block.writeFloat(this.__io__address + 20L, pad);
      }

   }

   public float getLimit_lin_x_lower() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 32L) : this.__io__block.readFloat(this.__io__address + 24L);
   }

   public void setLimit_lin_x_lower(float limit_lin_x_lower) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 32L, limit_lin_x_lower);
      } else {
         this.__io__block.writeFloat(this.__io__address + 24L, limit_lin_x_lower);
      }

   }

   public float getLimit_lin_x_upper() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 36L) : this.__io__block.readFloat(this.__io__address + 28L);
   }

   public void setLimit_lin_x_upper(float limit_lin_x_upper) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 36L, limit_lin_x_upper);
      } else {
         this.__io__block.writeFloat(this.__io__address + 28L, limit_lin_x_upper);
      }

   }

   public float getLimit_lin_y_lower() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 40L) : this.__io__block.readFloat(this.__io__address + 32L);
   }

   public void setLimit_lin_y_lower(float limit_lin_y_lower) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 40L, limit_lin_y_lower);
      } else {
         this.__io__block.writeFloat(this.__io__address + 32L, limit_lin_y_lower);
      }

   }

   public float getLimit_lin_y_upper() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 44L) : this.__io__block.readFloat(this.__io__address + 36L);
   }

   public void setLimit_lin_y_upper(float limit_lin_y_upper) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 44L, limit_lin_y_upper);
      } else {
         this.__io__block.writeFloat(this.__io__address + 36L, limit_lin_y_upper);
      }

   }

   public float getLimit_lin_z_lower() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 48L) : this.__io__block.readFloat(this.__io__address + 40L);
   }

   public void setLimit_lin_z_lower(float limit_lin_z_lower) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 48L, limit_lin_z_lower);
      } else {
         this.__io__block.writeFloat(this.__io__address + 40L, limit_lin_z_lower);
      }

   }

   public float getLimit_lin_z_upper() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 52L) : this.__io__block.readFloat(this.__io__address + 44L);
   }

   public void setLimit_lin_z_upper(float limit_lin_z_upper) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 52L, limit_lin_z_upper);
      } else {
         this.__io__block.writeFloat(this.__io__address + 44L, limit_lin_z_upper);
      }

   }

   public float getLimit_ang_x_lower() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 56L) : this.__io__block.readFloat(this.__io__address + 48L);
   }

   public void setLimit_ang_x_lower(float limit_ang_x_lower) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 56L, limit_ang_x_lower);
      } else {
         this.__io__block.writeFloat(this.__io__address + 48L, limit_ang_x_lower);
      }

   }

   public float getLimit_ang_x_upper() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 60L) : this.__io__block.readFloat(this.__io__address + 52L);
   }

   public void setLimit_ang_x_upper(float limit_ang_x_upper) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 60L, limit_ang_x_upper);
      } else {
         this.__io__block.writeFloat(this.__io__address + 52L, limit_ang_x_upper);
      }

   }

   public float getLimit_ang_y_lower() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 64L) : this.__io__block.readFloat(this.__io__address + 56L);
   }

   public void setLimit_ang_y_lower(float limit_ang_y_lower) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 64L, limit_ang_y_lower);
      } else {
         this.__io__block.writeFloat(this.__io__address + 56L, limit_ang_y_lower);
      }

   }

   public float getLimit_ang_y_upper() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 68L) : this.__io__block.readFloat(this.__io__address + 60L);
   }

   public void setLimit_ang_y_upper(float limit_ang_y_upper) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 68L, limit_ang_y_upper);
      } else {
         this.__io__block.writeFloat(this.__io__address + 60L, limit_ang_y_upper);
      }

   }

   public float getLimit_ang_z_lower() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 72L) : this.__io__block.readFloat(this.__io__address + 64L);
   }

   public void setLimit_ang_z_lower(float limit_ang_z_lower) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 72L, limit_ang_z_lower);
      } else {
         this.__io__block.writeFloat(this.__io__address + 64L, limit_ang_z_lower);
      }

   }

   public float getLimit_ang_z_upper() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 76L) : this.__io__block.readFloat(this.__io__address + 68L);
   }

   public void setLimit_ang_z_upper(float limit_ang_z_upper) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 76L, limit_ang_z_upper);
      } else {
         this.__io__block.writeFloat(this.__io__address + 68L, limit_ang_z_upper);
      }

   }

   public float getSpring_stiffness_x() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 80L) : this.__io__block.readFloat(this.__io__address + 72L);
   }

   public void setSpring_stiffness_x(float spring_stiffness_x) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 80L, spring_stiffness_x);
      } else {
         this.__io__block.writeFloat(this.__io__address + 72L, spring_stiffness_x);
      }

   }

   public float getSpring_stiffness_y() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 84L) : this.__io__block.readFloat(this.__io__address + 76L);
   }

   public void setSpring_stiffness_y(float spring_stiffness_y) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 84L, spring_stiffness_y);
      } else {
         this.__io__block.writeFloat(this.__io__address + 76L, spring_stiffness_y);
      }

   }

   public float getSpring_stiffness_z() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 88L) : this.__io__block.readFloat(this.__io__address + 80L);
   }

   public void setSpring_stiffness_z(float spring_stiffness_z) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 88L, spring_stiffness_z);
      } else {
         this.__io__block.writeFloat(this.__io__address + 80L, spring_stiffness_z);
      }

   }

   public float getSpring_stiffness_ang_x() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 92L) : this.__io__block.readFloat(this.__io__address + 84L);
   }

   public void setSpring_stiffness_ang_x(float spring_stiffness_ang_x) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 92L, spring_stiffness_ang_x);
      } else {
         this.__io__block.writeFloat(this.__io__address + 84L, spring_stiffness_ang_x);
      }

   }

   public float getSpring_stiffness_ang_y() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 96L) : this.__io__block.readFloat(this.__io__address + 88L);
   }

   public void setSpring_stiffness_ang_y(float spring_stiffness_ang_y) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 96L, spring_stiffness_ang_y);
      } else {
         this.__io__block.writeFloat(this.__io__address + 88L, spring_stiffness_ang_y);
      }

   }

   public float getSpring_stiffness_ang_z() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 100L) : this.__io__block.readFloat(this.__io__address + 92L);
   }

   public void setSpring_stiffness_ang_z(float spring_stiffness_ang_z) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 100L, spring_stiffness_ang_z);
      } else {
         this.__io__block.writeFloat(this.__io__address + 92L, spring_stiffness_ang_z);
      }

   }

   public float getSpring_damping_x() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 104L) : this.__io__block.readFloat(this.__io__address + 96L);
   }

   public void setSpring_damping_x(float spring_damping_x) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 104L, spring_damping_x);
      } else {
         this.__io__block.writeFloat(this.__io__address + 96L, spring_damping_x);
      }

   }

   public float getSpring_damping_y() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 108L) : this.__io__block.readFloat(this.__io__address + 100L);
   }

   public void setSpring_damping_y(float spring_damping_y) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 108L, spring_damping_y);
      } else {
         this.__io__block.writeFloat(this.__io__address + 100L, spring_damping_y);
      }

   }

   public float getSpring_damping_z() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 112L) : this.__io__block.readFloat(this.__io__address + 104L);
   }

   public void setSpring_damping_z(float spring_damping_z) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 112L, spring_damping_z);
      } else {
         this.__io__block.writeFloat(this.__io__address + 104L, spring_damping_z);
      }

   }

   public float getSpring_damping_ang_x() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 116L) : this.__io__block.readFloat(this.__io__address + 108L);
   }

   public void setSpring_damping_ang_x(float spring_damping_ang_x) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 116L, spring_damping_ang_x);
      } else {
         this.__io__block.writeFloat(this.__io__address + 108L, spring_damping_ang_x);
      }

   }

   public float getSpring_damping_ang_y() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 120L) : this.__io__block.readFloat(this.__io__address + 112L);
   }

   public void setSpring_damping_ang_y(float spring_damping_ang_y) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 120L, spring_damping_ang_y);
      } else {
         this.__io__block.writeFloat(this.__io__address + 112L, spring_damping_ang_y);
      }

   }

   public float getSpring_damping_ang_z() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 124L) : this.__io__block.readFloat(this.__io__address + 116L);
   }

   public void setSpring_damping_ang_z(float spring_damping_ang_z) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 124L, spring_damping_ang_z);
      } else {
         this.__io__block.writeFloat(this.__io__address + 116L, spring_damping_ang_z);
      }

   }

   public float getMotor_lin_target_velocity() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 128L) : this.__io__block.readFloat(this.__io__address + 120L);
   }

   public void setMotor_lin_target_velocity(float motor_lin_target_velocity) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 128L, motor_lin_target_velocity);
      } else {
         this.__io__block.writeFloat(this.__io__address + 120L, motor_lin_target_velocity);
      }

   }

   public float getMotor_ang_target_velocity() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 132L) : this.__io__block.readFloat(this.__io__address + 124L);
   }

   public void setMotor_ang_target_velocity(float motor_ang_target_velocity) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 132L, motor_ang_target_velocity);
      } else {
         this.__io__block.writeFloat(this.__io__address + 124L, motor_ang_target_velocity);
      }

   }

   public float getMotor_lin_max_impulse() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 136L) : this.__io__block.readFloat(this.__io__address + 128L);
   }

   public void setMotor_lin_max_impulse(float motor_lin_max_impulse) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 136L, motor_lin_max_impulse);
      } else {
         this.__io__block.writeFloat(this.__io__address + 128L, motor_lin_max_impulse);
      }

   }

   public float getMotor_ang_max_impulse() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 140L) : this.__io__block.readFloat(this.__io__address + 132L);
   }

   public void setMotor_ang_max_impulse(float motor_ang_max_impulse) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 140L, motor_ang_max_impulse);
      } else {
         this.__io__block.writeFloat(this.__io__address + 132L, motor_ang_max_impulse);
      }

   }

   public CPointer<Object> getPhysics_constraint() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 144L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 136L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setPhysics_constraint(CPointer<Object> physics_constraint) throws IOException {
      long __address = physics_constraint == null ? 0L : physics_constraint.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 144L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 136L, __address);
      }

   }

   public CPointer<RigidBodyCon> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{RigidBodyCon.class}, this.__io__block, this.__io__blockTable);
   }
}
