package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 32L,
   size64 = 32L
)
public class AudioData extends CFacade {
   public static final int __DNA__SDNA_INDEX = 172;
   public static final long[] __DNA__FIELD__mixrate = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__main = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__speed_of_sound = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__doppler_factor = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__distance_model = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__flag = new long[]{20L, 20L};
   public static final long[] __DNA__FIELD__pad = new long[]{22L, 22L};
   public static final long[] __DNA__FIELD__volume = new long[]{24L, 24L};
   public static final long[] __DNA__FIELD__pad2 = new long[]{28L, 28L};

   public AudioData(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected AudioData(AudioData that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public int getMixrate() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 0L) : this.__io__block.readInt(this.__io__address + 0L);
   }

   public void setMixrate(int mixrate) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 0L, mixrate);
      } else {
         this.__io__block.writeInt(this.__io__address + 0L, mixrate);
      }

   }

   public float getMain() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 4L) : this.__io__block.readFloat(this.__io__address + 4L);
   }

   public void setMain(float main) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 4L, main);
      } else {
         this.__io__block.writeFloat(this.__io__address + 4L, main);
      }

   }

   public float getSpeed_of_sound() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 8L) : this.__io__block.readFloat(this.__io__address + 8L);
   }

   public void setSpeed_of_sound(float speed_of_sound) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 8L, speed_of_sound);
      } else {
         this.__io__block.writeFloat(this.__io__address + 8L, speed_of_sound);
      }

   }

   public float getDoppler_factor() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 12L) : this.__io__block.readFloat(this.__io__address + 12L);
   }

   public void setDoppler_factor(float doppler_factor) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 12L, doppler_factor);
      } else {
         this.__io__block.writeFloat(this.__io__address + 12L, doppler_factor);
      }

   }

   public int getDistance_model() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 16L) : this.__io__block.readInt(this.__io__address + 16L);
   }

   public void setDistance_model(int distance_model) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 16L, distance_model);
      } else {
         this.__io__block.writeInt(this.__io__address + 16L, distance_model);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 20L) : this.__io__block.readShort(this.__io__address + 20L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 20L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 20L, flag);
      }

   }

   public short getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 22L) : this.__io__block.readShort(this.__io__address + 22L);
   }

   public void setPad(short pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 22L, pad);
      } else {
         this.__io__block.writeShort(this.__io__address + 22L, pad);
      }

   }

   public float getVolume() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 24L) : this.__io__block.readFloat(this.__io__address + 24L);
   }

   public void setVolume(float volume) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 24L, volume);
      } else {
         this.__io__block.writeFloat(this.__io__address + 24L, volume);
      }

   }

   public float getPad2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 28L) : this.__io__block.readFloat(this.__io__address + 28L);
   }

   public void setPad2(float pad2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 28L, pad2);
      } else {
         this.__io__block.writeFloat(this.__io__address + 28L, pad2);
      }

   }

   public CPointer<AudioData> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{AudioData.class}, this.__io__block, this.__io__blockTable);
   }
}
