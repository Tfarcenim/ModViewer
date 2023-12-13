package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 96L,
   size64 = 104L
)
public class BoidSettings extends CFacade {
   public static final int __DNA__SDNA_INDEX = 538;
   public static final long[] __DNA__FIELD__options = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__last_state_id = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__landing_smoothness = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__height = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__banking = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__pitch = new long[]{20L, 20L};
   public static final long[] __DNA__FIELD__health = new long[]{24L, 24L};
   public static final long[] __DNA__FIELD__aggression = new long[]{28L, 28L};
   public static final long[] __DNA__FIELD__strength = new long[]{32L, 32L};
   public static final long[] __DNA__FIELD__accuracy = new long[]{36L, 36L};
   public static final long[] __DNA__FIELD__range = new long[]{40L, 40L};
   public static final long[] __DNA__FIELD__air_min_speed = new long[]{44L, 44L};
   public static final long[] __DNA__FIELD__air_max_speed = new long[]{48L, 48L};
   public static final long[] __DNA__FIELD__air_max_acc = new long[]{52L, 52L};
   public static final long[] __DNA__FIELD__air_max_ave = new long[]{56L, 56L};
   public static final long[] __DNA__FIELD__air_personal_space = new long[]{60L, 60L};
   public static final long[] __DNA__FIELD__land_jump_speed = new long[]{64L, 64L};
   public static final long[] __DNA__FIELD__land_max_speed = new long[]{68L, 68L};
   public static final long[] __DNA__FIELD__land_max_acc = new long[]{72L, 72L};
   public static final long[] __DNA__FIELD__land_max_ave = new long[]{76L, 76L};
   public static final long[] __DNA__FIELD__land_personal_space = new long[]{80L, 80L};
   public static final long[] __DNA__FIELD__land_stick_force = new long[]{84L, 84L};
   public static final long[] __DNA__FIELD__states = new long[]{88L, 88L};

   public BoidSettings(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected BoidSettings(BoidSettings that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public int getOptions() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 0L) : this.__io__block.readInt(this.__io__address + 0L);
   }

   public void setOptions(int options) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 0L, options);
      } else {
         this.__io__block.writeInt(this.__io__address + 0L, options);
      }

   }

   public int getLast_state_id() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 4L) : this.__io__block.readInt(this.__io__address + 4L);
   }

   public void setLast_state_id(int last_state_id) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 4L, last_state_id);
      } else {
         this.__io__block.writeInt(this.__io__address + 4L, last_state_id);
      }

   }

   public float getLanding_smoothness() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 8L) : this.__io__block.readFloat(this.__io__address + 8L);
   }

   public void setLanding_smoothness(float landing_smoothness) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 8L, landing_smoothness);
      } else {
         this.__io__block.writeFloat(this.__io__address + 8L, landing_smoothness);
      }

   }

   public float getHeight() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 12L) : this.__io__block.readFloat(this.__io__address + 12L);
   }

   public void setHeight(float height) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 12L, height);
      } else {
         this.__io__block.writeFloat(this.__io__address + 12L, height);
      }

   }

   public float getBanking() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 16L) : this.__io__block.readFloat(this.__io__address + 16L);
   }

   public void setBanking(float banking) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 16L, banking);
      } else {
         this.__io__block.writeFloat(this.__io__address + 16L, banking);
      }

   }

   public float getPitch() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 20L) : this.__io__block.readFloat(this.__io__address + 20L);
   }

   public void setPitch(float pitch) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 20L, pitch);
      } else {
         this.__io__block.writeFloat(this.__io__address + 20L, pitch);
      }

   }

   public float getHealth() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 24L) : this.__io__block.readFloat(this.__io__address + 24L);
   }

   public void setHealth(float health) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 24L, health);
      } else {
         this.__io__block.writeFloat(this.__io__address + 24L, health);
      }

   }

   public float getAggression() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 28L) : this.__io__block.readFloat(this.__io__address + 28L);
   }

   public void setAggression(float aggression) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 28L, aggression);
      } else {
         this.__io__block.writeFloat(this.__io__address + 28L, aggression);
      }

   }

   public float getStrength() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 32L) : this.__io__block.readFloat(this.__io__address + 32L);
   }

   public void setStrength(float strength) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 32L, strength);
      } else {
         this.__io__block.writeFloat(this.__io__address + 32L, strength);
      }

   }

   public float getAccuracy() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 36L) : this.__io__block.readFloat(this.__io__address + 36L);
   }

   public void setAccuracy(float accuracy) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 36L, accuracy);
      } else {
         this.__io__block.writeFloat(this.__io__address + 36L, accuracy);
      }

   }

   public float getRange() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 40L) : this.__io__block.readFloat(this.__io__address + 40L);
   }

   public void setRange(float range) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 40L, range);
      } else {
         this.__io__block.writeFloat(this.__io__address + 40L, range);
      }

   }

   public float getAir_min_speed() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 44L) : this.__io__block.readFloat(this.__io__address + 44L);
   }

   public void setAir_min_speed(float air_min_speed) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 44L, air_min_speed);
      } else {
         this.__io__block.writeFloat(this.__io__address + 44L, air_min_speed);
      }

   }

   public float getAir_max_speed() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 48L) : this.__io__block.readFloat(this.__io__address + 48L);
   }

   public void setAir_max_speed(float air_max_speed) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 48L, air_max_speed);
      } else {
         this.__io__block.writeFloat(this.__io__address + 48L, air_max_speed);
      }

   }

   public float getAir_max_acc() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 52L) : this.__io__block.readFloat(this.__io__address + 52L);
   }

   public void setAir_max_acc(float air_max_acc) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 52L, air_max_acc);
      } else {
         this.__io__block.writeFloat(this.__io__address + 52L, air_max_acc);
      }

   }

   public float getAir_max_ave() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 56L) : this.__io__block.readFloat(this.__io__address + 56L);
   }

   public void setAir_max_ave(float air_max_ave) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 56L, air_max_ave);
      } else {
         this.__io__block.writeFloat(this.__io__address + 56L, air_max_ave);
      }

   }

   public float getAir_personal_space() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 60L) : this.__io__block.readFloat(this.__io__address + 60L);
   }

   public void setAir_personal_space(float air_personal_space) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 60L, air_personal_space);
      } else {
         this.__io__block.writeFloat(this.__io__address + 60L, air_personal_space);
      }

   }

   public float getLand_jump_speed() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 64L) : this.__io__block.readFloat(this.__io__address + 64L);
   }

   public void setLand_jump_speed(float land_jump_speed) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 64L, land_jump_speed);
      } else {
         this.__io__block.writeFloat(this.__io__address + 64L, land_jump_speed);
      }

   }

   public float getLand_max_speed() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 68L) : this.__io__block.readFloat(this.__io__address + 68L);
   }

   public void setLand_max_speed(float land_max_speed) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 68L, land_max_speed);
      } else {
         this.__io__block.writeFloat(this.__io__address + 68L, land_max_speed);
      }

   }

   public float getLand_max_acc() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 72L) : this.__io__block.readFloat(this.__io__address + 72L);
   }

   public void setLand_max_acc(float land_max_acc) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 72L, land_max_acc);
      } else {
         this.__io__block.writeFloat(this.__io__address + 72L, land_max_acc);
      }

   }

   public float getLand_max_ave() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 76L) : this.__io__block.readFloat(this.__io__address + 76L);
   }

   public void setLand_max_ave(float land_max_ave) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 76L, land_max_ave);
      } else {
         this.__io__block.writeFloat(this.__io__address + 76L, land_max_ave);
      }

   }

   public float getLand_personal_space() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 80L) : this.__io__block.readFloat(this.__io__address + 80L);
   }

   public void setLand_personal_space(float land_personal_space) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 80L, land_personal_space);
      } else {
         this.__io__block.writeFloat(this.__io__address + 80L, land_personal_space);
      }

   }

   public float getLand_stick_force() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 84L) : this.__io__block.readFloat(this.__io__address + 84L);
   }

   public void setLand_stick_force(float land_stick_force) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 84L, land_stick_force);
      } else {
         this.__io__block.writeFloat(this.__io__address + 84L, land_stick_force);
      }

   }

   public ListBase getStates() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 88L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 88L, this.__io__block, this.__io__blockTable);
   }

   public void setStates(ListBase states) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 88L;
      } else {
         __dna__offset = 88L;
      }

      if (!this.__io__equals(states, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, states)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, states);
         } else {
            __io__generic__copy(this.getStates(), states);
         }

      }
   }

   public CPointer<BoidSettings> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{BoidSettings.class}, this.__io__block, this.__io__blockTable);
   }
}
