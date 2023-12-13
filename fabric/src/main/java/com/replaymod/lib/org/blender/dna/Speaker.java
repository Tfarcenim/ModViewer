package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 156L,
   size64 = 184L
)
public class Speaker extends CFacade {
   public static final int __DNA__SDNA_INDEX = 542;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__adt = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__sound = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__volume_max = new long[]{108L, 136L};
   public static final long[] __DNA__FIELD__volume_min = new long[]{112L, 140L};
   public static final long[] __DNA__FIELD__distance_max = new long[]{116L, 144L};
   public static final long[] __DNA__FIELD__distance_reference = new long[]{120L, 148L};
   public static final long[] __DNA__FIELD__attenuation = new long[]{124L, 152L};
   public static final long[] __DNA__FIELD__cone_angle_outer = new long[]{128L, 156L};
   public static final long[] __DNA__FIELD__cone_angle_inner = new long[]{132L, 160L};
   public static final long[] __DNA__FIELD__cone_volume_outer = new long[]{136L, 164L};
   public static final long[] __DNA__FIELD__volume = new long[]{140L, 168L};
   public static final long[] __DNA__FIELD__pitch = new long[]{144L, 172L};
   public static final long[] __DNA__FIELD__flag = new long[]{148L, 176L};
   public static final long[] __DNA__FIELD__pad1 = new long[]{150L, 178L};

   public Speaker(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Speaker(Speaker that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public ID getId() throws IOException {
      return this.__io__pointersize == 8 ? new ID(this.__io__address + 0L, this.__io__block, this.__io__blockTable) : new ID(this.__io__address + 0L, this.__io__block, this.__io__blockTable);
   }

   public void setId(ID id) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(id, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, id)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, id);
         } else {
            __io__generic__copy(this.getId(), id);
         }

      }
   }

   public CPointer<AnimData> getAdt() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 120L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 100L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{AnimData.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 528), this.__io__blockTable);
   }

   public void setAdt(CPointer<AnimData> adt) throws IOException {
      long __address = adt == null ? 0L : adt.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 120L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 100L, __address);
      }

   }

   public CPointer<bSound> getSound() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 128L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 104L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bSound.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 339), this.__io__blockTable);
   }

   public void setSound(CPointer<bSound> sound) throws IOException {
      long __address = sound == null ? 0L : sound.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 128L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 104L, __address);
      }

   }

   public float getVolume_max() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 136L) : this.__io__block.readFloat(this.__io__address + 108L);
   }

   public void setVolume_max(float volume_max) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 136L, volume_max);
      } else {
         this.__io__block.writeFloat(this.__io__address + 108L, volume_max);
      }

   }

   public float getVolume_min() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 140L) : this.__io__block.readFloat(this.__io__address + 112L);
   }

   public void setVolume_min(float volume_min) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 140L, volume_min);
      } else {
         this.__io__block.writeFloat(this.__io__address + 112L, volume_min);
      }

   }

   public float getDistance_max() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 144L) : this.__io__block.readFloat(this.__io__address + 116L);
   }

   public void setDistance_max(float distance_max) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 144L, distance_max);
      } else {
         this.__io__block.writeFloat(this.__io__address + 116L, distance_max);
      }

   }

   public float getDistance_reference() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 148L) : this.__io__block.readFloat(this.__io__address + 120L);
   }

   public void setDistance_reference(float distance_reference) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 148L, distance_reference);
      } else {
         this.__io__block.writeFloat(this.__io__address + 120L, distance_reference);
      }

   }

   public float getAttenuation() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 152L) : this.__io__block.readFloat(this.__io__address + 124L);
   }

   public void setAttenuation(float attenuation) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 152L, attenuation);
      } else {
         this.__io__block.writeFloat(this.__io__address + 124L, attenuation);
      }

   }

   public float getCone_angle_outer() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 156L) : this.__io__block.readFloat(this.__io__address + 128L);
   }

   public void setCone_angle_outer(float cone_angle_outer) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 156L, cone_angle_outer);
      } else {
         this.__io__block.writeFloat(this.__io__address + 128L, cone_angle_outer);
      }

   }

   public float getCone_angle_inner() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 160L) : this.__io__block.readFloat(this.__io__address + 132L);
   }

   public void setCone_angle_inner(float cone_angle_inner) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 160L, cone_angle_inner);
      } else {
         this.__io__block.writeFloat(this.__io__address + 132L, cone_angle_inner);
      }

   }

   public float getCone_volume_outer() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 164L) : this.__io__block.readFloat(this.__io__address + 136L);
   }

   public void setCone_volume_outer(float cone_volume_outer) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 164L, cone_volume_outer);
      } else {
         this.__io__block.writeFloat(this.__io__address + 136L, cone_volume_outer);
      }

   }

   public float getVolume() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 168L) : this.__io__block.readFloat(this.__io__address + 140L);
   }

   public void setVolume(float volume) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 168L, volume);
      } else {
         this.__io__block.writeFloat(this.__io__address + 140L, volume);
      }

   }

   public float getPitch() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 172L) : this.__io__block.readFloat(this.__io__address + 144L);
   }

   public void setPitch(float pitch) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 172L, pitch);
      } else {
         this.__io__block.writeFloat(this.__io__address + 144L, pitch);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 176L) : this.__io__block.readShort(this.__io__address + 148L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 176L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 148L, flag);
      }

   }

   public CArrayFacade<Short> getPad1() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Short.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 178L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 150L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad1(CArrayFacade<Short> pad1) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 178L;
      } else {
         __dna__offset = 150L;
      }

      if (!this.__io__equals(pad1, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad1)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad1);
         } else {
            __io__generic__copy(this.getPad1(), pad1);
         }

      }
   }

   public CPointer<Speaker> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Speaker.class}, this.__io__block, this.__io__blockTable);
   }
}
