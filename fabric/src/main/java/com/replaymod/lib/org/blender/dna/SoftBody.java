package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 444L,
   size64 = 480L
)
public class SoftBody extends CFacade {
   public static final int __DNA__SDNA_INDEX = 163;
   public static final long[] __DNA__FIELD__totpoint = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__totspring = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__bpoint = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__bspring = new long[]{12L, 16L};
   public static final long[] __DNA__FIELD__pad = new long[]{16L, 24L};
   public static final long[] __DNA__FIELD__msg_lock = new long[]{17L, 25L};
   public static final long[] __DNA__FIELD__msg_value = new long[]{18L, 26L};
   public static final long[] __DNA__FIELD__nodemass = new long[]{20L, 28L};
   public static final long[] __DNA__FIELD__namedVG_Mass = new long[]{24L, 32L};
   public static final long[] __DNA__FIELD__grav = new long[]{88L, 96L};
   public static final long[] __DNA__FIELD__mediafrict = new long[]{92L, 100L};
   public static final long[] __DNA__FIELD__rklimit = new long[]{96L, 104L};
   public static final long[] __DNA__FIELD__physics_speed = new long[]{100L, 108L};
   public static final long[] __DNA__FIELD__goalspring = new long[]{104L, 112L};
   public static final long[] __DNA__FIELD__goalfrict = new long[]{108L, 116L};
   public static final long[] __DNA__FIELD__mingoal = new long[]{112L, 120L};
   public static final long[] __DNA__FIELD__maxgoal = new long[]{116L, 124L};
   public static final long[] __DNA__FIELD__defgoal = new long[]{120L, 128L};
   public static final long[] __DNA__FIELD__vertgroup = new long[]{124L, 132L};
   public static final long[] __DNA__FIELD__namedVG_Softgoal = new long[]{126L, 134L};
   public static final long[] __DNA__FIELD__fuzzyness = new long[]{190L, 198L};
   public static final long[] __DNA__FIELD__inspring = new long[]{192L, 200L};
   public static final long[] __DNA__FIELD__infrict = new long[]{196L, 204L};
   public static final long[] __DNA__FIELD__namedVG_Spring_K = new long[]{200L, 208L};
   public static final long[] __DNA__FIELD__sfra = new long[]{264L, 272L};
   public static final long[] __DNA__FIELD__efra = new long[]{268L, 276L};
   public static final long[] __DNA__FIELD__interval = new long[]{272L, 280L};
   public static final long[] __DNA__FIELD__local = new long[]{276L, 284L};
   public static final long[] __DNA__FIELD__solverflags = new long[]{278L, 286L};
   public static final long[] __DNA__FIELD__keys = new long[]{280L, 288L};
   public static final long[] __DNA__FIELD__totpointkey = new long[]{284L, 296L};
   public static final long[] __DNA__FIELD__totkey = new long[]{288L, 300L};
   public static final long[] __DNA__FIELD__secondspring = new long[]{292L, 304L};
   public static final long[] __DNA__FIELD__colball = new long[]{296L, 308L};
   public static final long[] __DNA__FIELD__balldamp = new long[]{300L, 312L};
   public static final long[] __DNA__FIELD__ballstiff = new long[]{304L, 316L};
   public static final long[] __DNA__FIELD__sbc_mode = new long[]{308L, 320L};
   public static final long[] __DNA__FIELD__aeroedge = new long[]{310L, 322L};
   public static final long[] __DNA__FIELD__minloops = new long[]{312L, 324L};
   public static final long[] __DNA__FIELD__maxloops = new long[]{314L, 326L};
   public static final long[] __DNA__FIELD__choke = new long[]{316L, 328L};
   public static final long[] __DNA__FIELD__solver_ID = new long[]{318L, 330L};
   public static final long[] __DNA__FIELD__plastic = new long[]{320L, 332L};
   public static final long[] __DNA__FIELD__springpreload = new long[]{322L, 334L};
   public static final long[] __DNA__FIELD__scratch = new long[]{324L, 336L};
   public static final long[] __DNA__FIELD__shearstiff = new long[]{328L, 344L};
   public static final long[] __DNA__FIELD__inpush = new long[]{332L, 348L};
   public static final long[] __DNA__FIELD__pointcache = new long[]{336L, 352L};
   public static final long[] __DNA__FIELD__ptcaches = new long[]{340L, 360L};
   public static final long[] __DNA__FIELD__collision_group = new long[]{348L, 376L};
   public static final long[] __DNA__FIELD__effector_weights = new long[]{352L, 384L};
   public static final long[] __DNA__FIELD__lcom = new long[]{356L, 392L};
   public static final long[] __DNA__FIELD__lrot = new long[]{368L, 404L};
   public static final long[] __DNA__FIELD__lscale = new long[]{404L, 440L};
   public static final long[] __DNA__FIELD__last_frame = new long[]{440L, 476L};

   public SoftBody(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected SoftBody(SoftBody that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public int getTotpoint() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 0L) : this.__io__block.readInt(this.__io__address + 0L);
   }

   public void setTotpoint(int totpoint) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 0L, totpoint);
      } else {
         this.__io__block.writeInt(this.__io__address + 0L, totpoint);
      }

   }

   public int getTotspring() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 4L) : this.__io__block.readInt(this.__io__address + 4L);
   }

   public void setTotspring(int totspring) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 4L, totspring);
      } else {
         this.__io__block.writeInt(this.__io__address + 4L, totspring);
      }

   }

   public CPointer<Object> getBpoint() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setBpoint(CPointer<Object> bpoint) throws IOException {
      long __address = bpoint == null ? 0L : bpoint.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      }

   }

   public CPointer<Object> getBspring() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 12L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setBspring(CPointer<Object> bspring) throws IOException {
      long __address = bspring == null ? 0L : bspring.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 12L, __address);
      }

   }

   public byte getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 24L) : this.__io__block.readByte(this.__io__address + 16L);
   }

   public void setPad(byte pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 24L, pad);
      } else {
         this.__io__block.writeByte(this.__io__address + 16L, pad);
      }

   }

   public byte getMsg_lock() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 25L) : this.__io__block.readByte(this.__io__address + 17L);
   }

   public void setMsg_lock(byte msg_lock) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 25L, msg_lock);
      } else {
         this.__io__block.writeByte(this.__io__address + 17L, msg_lock);
      }

   }

   public short getMsg_value() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 26L) : this.__io__block.readShort(this.__io__address + 18L);
   }

   public void setMsg_value(short msg_value) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 26L, msg_value);
      } else {
         this.__io__block.writeShort(this.__io__address + 18L, msg_value);
      }

   }

   public float getNodemass() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 28L) : this.__io__block.readFloat(this.__io__address + 20L);
   }

   public void setNodemass(float nodemass) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 28L, nodemass);
      } else {
         this.__io__block.writeFloat(this.__io__address + 20L, nodemass);
      }

   }

   public CArrayFacade<Byte> getNamedVG_Mass() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 32L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 24L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setNamedVG_Mass(CArrayFacade<Byte> namedVG_Mass) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 32L;
      } else {
         __dna__offset = 24L;
      }

      if (!this.__io__equals(namedVG_Mass, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, namedVG_Mass)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, namedVG_Mass);
         } else {
            __io__generic__copy(this.getNamedVG_Mass(), namedVG_Mass);
         }

      }
   }

   public float getGrav() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 96L) : this.__io__block.readFloat(this.__io__address + 88L);
   }

   public void setGrav(float grav) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 96L, grav);
      } else {
         this.__io__block.writeFloat(this.__io__address + 88L, grav);
      }

   }

   public float getMediafrict() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 100L) : this.__io__block.readFloat(this.__io__address + 92L);
   }

   public void setMediafrict(float mediafrict) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 100L, mediafrict);
      } else {
         this.__io__block.writeFloat(this.__io__address + 92L, mediafrict);
      }

   }

   public float getRklimit() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 104L) : this.__io__block.readFloat(this.__io__address + 96L);
   }

   public void setRklimit(float rklimit) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 104L, rklimit);
      } else {
         this.__io__block.writeFloat(this.__io__address + 96L, rklimit);
      }

   }

   public float getPhysics_speed() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 108L) : this.__io__block.readFloat(this.__io__address + 100L);
   }

   public void setPhysics_speed(float physics_speed) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 108L, physics_speed);
      } else {
         this.__io__block.writeFloat(this.__io__address + 100L, physics_speed);
      }

   }

   public float getGoalspring() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 112L) : this.__io__block.readFloat(this.__io__address + 104L);
   }

   public void setGoalspring(float goalspring) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 112L, goalspring);
      } else {
         this.__io__block.writeFloat(this.__io__address + 104L, goalspring);
      }

   }

   public float getGoalfrict() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 116L) : this.__io__block.readFloat(this.__io__address + 108L);
   }

   public void setGoalfrict(float goalfrict) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 116L, goalfrict);
      } else {
         this.__io__block.writeFloat(this.__io__address + 108L, goalfrict);
      }

   }

   public float getMingoal() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 120L) : this.__io__block.readFloat(this.__io__address + 112L);
   }

   public void setMingoal(float mingoal) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 120L, mingoal);
      } else {
         this.__io__block.writeFloat(this.__io__address + 112L, mingoal);
      }

   }

   public float getMaxgoal() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 124L) : this.__io__block.readFloat(this.__io__address + 116L);
   }

   public void setMaxgoal(float maxgoal) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 124L, maxgoal);
      } else {
         this.__io__block.writeFloat(this.__io__address + 116L, maxgoal);
      }

   }

   public float getDefgoal() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 128L) : this.__io__block.readFloat(this.__io__address + 120L);
   }

   public void setDefgoal(float defgoal) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 128L, defgoal);
      } else {
         this.__io__block.writeFloat(this.__io__address + 120L, defgoal);
      }

   }

   public short getVertgroup() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 132L) : this.__io__block.readShort(this.__io__address + 124L);
   }

   public void setVertgroup(short vertgroup) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 132L, vertgroup);
      } else {
         this.__io__block.writeShort(this.__io__address + 124L, vertgroup);
      }

   }

   public CArrayFacade<Byte> getNamedVG_Softgoal() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 134L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 126L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setNamedVG_Softgoal(CArrayFacade<Byte> namedVG_Softgoal) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 134L;
      } else {
         __dna__offset = 126L;
      }

      if (!this.__io__equals(namedVG_Softgoal, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, namedVG_Softgoal)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, namedVG_Softgoal);
         } else {
            __io__generic__copy(this.getNamedVG_Softgoal(), namedVG_Softgoal);
         }

      }
   }

   public short getFuzzyness() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 198L) : this.__io__block.readShort(this.__io__address + 190L);
   }

   public void setFuzzyness(short fuzzyness) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 198L, fuzzyness);
      } else {
         this.__io__block.writeShort(this.__io__address + 190L, fuzzyness);
      }

   }

   public float getInspring() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 200L) : this.__io__block.readFloat(this.__io__address + 192L);
   }

   public void setInspring(float inspring) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 200L, inspring);
      } else {
         this.__io__block.writeFloat(this.__io__address + 192L, inspring);
      }

   }

   public float getInfrict() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 204L) : this.__io__block.readFloat(this.__io__address + 196L);
   }

   public void setInfrict(float infrict) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 204L, infrict);
      } else {
         this.__io__block.writeFloat(this.__io__address + 196L, infrict);
      }

   }

   public CArrayFacade<Byte> getNamedVG_Spring_K() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 208L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 200L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setNamedVG_Spring_K(CArrayFacade<Byte> namedVG_Spring_K) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 208L;
      } else {
         __dna__offset = 200L;
      }

      if (!this.__io__equals(namedVG_Spring_K, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, namedVG_Spring_K)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, namedVG_Spring_K);
         } else {
            __io__generic__copy(this.getNamedVG_Spring_K(), namedVG_Spring_K);
         }

      }
   }

   public int getSfra() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 272L) : this.__io__block.readInt(this.__io__address + 264L);
   }

   public void setSfra(int sfra) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 272L, sfra);
      } else {
         this.__io__block.writeInt(this.__io__address + 264L, sfra);
      }

   }

   public int getEfra() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 276L) : this.__io__block.readInt(this.__io__address + 268L);
   }

   public void setEfra(int efra) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 276L, efra);
      } else {
         this.__io__block.writeInt(this.__io__address + 268L, efra);
      }

   }

   public int getInterval() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 280L) : this.__io__block.readInt(this.__io__address + 272L);
   }

   public void setInterval(int interval) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 280L, interval);
      } else {
         this.__io__block.writeInt(this.__io__address + 272L, interval);
      }

   }

   public short getLocal() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 284L) : this.__io__block.readShort(this.__io__address + 276L);
   }

   public void setLocal(short local) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 284L, local);
      } else {
         this.__io__block.writeShort(this.__io__address + 276L, local);
      }

   }

   public short getSolverflags() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 286L) : this.__io__block.readShort(this.__io__address + 278L);
   }

   public void setSolverflags(short solverflags) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 286L, solverflags);
      } else {
         this.__io__block.writeShort(this.__io__address + 278L, solverflags);
      }

   }

   public CPointer<CPointer<SBVertex>> getKeys() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 288L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 280L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{CPointer.class, SBVertex.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, __dna__targetTypes), this.__io__blockTable);
   }

   public void setKeys(CPointer<CPointer<SBVertex>> keys) throws IOException {
      long __address = keys == null ? 0L : keys.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 288L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 280L, __address);
      }

   }

   public int getTotpointkey() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 296L) : this.__io__block.readInt(this.__io__address + 284L);
   }

   public void setTotpointkey(int totpointkey) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 296L, totpointkey);
      } else {
         this.__io__block.writeInt(this.__io__address + 284L, totpointkey);
      }

   }

   public int getTotkey() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 300L) : this.__io__block.readInt(this.__io__address + 288L);
   }

   public void setTotkey(int totkey) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 300L, totkey);
      } else {
         this.__io__block.writeInt(this.__io__address + 288L, totkey);
      }

   }

   public float getSecondspring() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 304L) : this.__io__block.readFloat(this.__io__address + 292L);
   }

   public void setSecondspring(float secondspring) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 304L, secondspring);
      } else {
         this.__io__block.writeFloat(this.__io__address + 292L, secondspring);
      }

   }

   public float getColball() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 308L) : this.__io__block.readFloat(this.__io__address + 296L);
   }

   public void setColball(float colball) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 308L, colball);
      } else {
         this.__io__block.writeFloat(this.__io__address + 296L, colball);
      }

   }

   public float getBalldamp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 312L) : this.__io__block.readFloat(this.__io__address + 300L);
   }

   public void setBalldamp(float balldamp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 312L, balldamp);
      } else {
         this.__io__block.writeFloat(this.__io__address + 300L, balldamp);
      }

   }

   public float getBallstiff() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 316L) : this.__io__block.readFloat(this.__io__address + 304L);
   }

   public void setBallstiff(float ballstiff) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 316L, ballstiff);
      } else {
         this.__io__block.writeFloat(this.__io__address + 304L, ballstiff);
      }

   }

   public short getSbc_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 320L) : this.__io__block.readShort(this.__io__address + 308L);
   }

   public void setSbc_mode(short sbc_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 320L, sbc_mode);
      } else {
         this.__io__block.writeShort(this.__io__address + 308L, sbc_mode);
      }

   }

   public short getAeroedge() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 322L) : this.__io__block.readShort(this.__io__address + 310L);
   }

   public void setAeroedge(short aeroedge) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 322L, aeroedge);
      } else {
         this.__io__block.writeShort(this.__io__address + 310L, aeroedge);
      }

   }

   public short getMinloops() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 324L) : this.__io__block.readShort(this.__io__address + 312L);
   }

   public void setMinloops(short minloops) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 324L, minloops);
      } else {
         this.__io__block.writeShort(this.__io__address + 312L, minloops);
      }

   }

   public short getMaxloops() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 326L) : this.__io__block.readShort(this.__io__address + 314L);
   }

   public void setMaxloops(short maxloops) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 326L, maxloops);
      } else {
         this.__io__block.writeShort(this.__io__address + 314L, maxloops);
      }

   }

   public short getChoke() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 328L) : this.__io__block.readShort(this.__io__address + 316L);
   }

   public void setChoke(short choke) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 328L, choke);
      } else {
         this.__io__block.writeShort(this.__io__address + 316L, choke);
      }

   }

   public short getSolver_ID() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 330L) : this.__io__block.readShort(this.__io__address + 318L);
   }

   public void setSolver_ID(short solver_ID) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 330L, solver_ID);
      } else {
         this.__io__block.writeShort(this.__io__address + 318L, solver_ID);
      }

   }

   public short getPlastic() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 332L) : this.__io__block.readShort(this.__io__address + 320L);
   }

   public void setPlastic(short plastic) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 332L, plastic);
      } else {
         this.__io__block.writeShort(this.__io__address + 320L, plastic);
      }

   }

   public short getSpringpreload() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 334L) : this.__io__block.readShort(this.__io__address + 322L);
   }

   public void setSpringpreload(short springpreload) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 334L, springpreload);
      } else {
         this.__io__block.writeShort(this.__io__address + 322L, springpreload);
      }

   }

   public CPointer<Object> getScratch() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 336L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 324L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setScratch(CPointer<Object> scratch) throws IOException {
      long __address = scratch == null ? 0L : scratch.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 336L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 324L, __address);
      }

   }

   public float getShearstiff() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 344L) : this.__io__block.readFloat(this.__io__address + 328L);
   }

   public void setShearstiff(float shearstiff) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 344L, shearstiff);
      } else {
         this.__io__block.writeFloat(this.__io__address + 328L, shearstiff);
      }

   }

   public float getInpush() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 348L) : this.__io__block.readFloat(this.__io__address + 332L);
   }

   public void setInpush(float inpush) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 348L, inpush);
      } else {
         this.__io__block.writeFloat(this.__io__address + 332L, inpush);
      }

   }

   public CPointer<PointCache> getPointcache() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 352L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 336L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PointCache.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 160), this.__io__blockTable);
   }

   public void setPointcache(CPointer<PointCache> pointcache) throws IOException {
      long __address = pointcache == null ? 0L : pointcache.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 352L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 336L, __address);
      }

   }

   public ListBase getPtcaches() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 360L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 340L, this.__io__block, this.__io__blockTable);
   }

   public void setPtcaches(ListBase ptcaches) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 360L;
      } else {
         __dna__offset = 340L;
      }

      if (!this.__io__equals(ptcaches, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, ptcaches)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, ptcaches);
         } else {
            __io__generic__copy(this.getPtcaches(), ptcaches);
         }

      }
   }

   public CPointer<Group> getCollision_group() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 376L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 348L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Group.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 341), this.__io__blockTable);
   }

   public void setCollision_group(CPointer<Group> collision_group) throws IOException {
      long __address = collision_group == null ? 0L : collision_group.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 376L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 348L, __address);
      }

   }

   public CPointer<EffectorWeights> getEffector_weights() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 384L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 352L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{EffectorWeights.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 157), this.__io__blockTable);
   }

   public void setEffector_weights(CPointer<EffectorWeights> effector_weights) throws IOException {
      long __address = effector_weights == null ? 0L : effector_weights.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 384L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 352L, __address);
      }

   }

   public CArrayFacade<Float> getLcom() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 392L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 356L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setLcom(CArrayFacade<Float> lcom) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 392L;
      } else {
         __dna__offset = 356L;
      }

      if (!this.__io__equals(lcom, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, lcom)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, lcom);
         } else {
            __io__generic__copy(this.getLcom(), lcom);
         }

      }
   }

   public CArrayFacade<CArrayFacade<Float>> getLrot() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CArrayFacade.class, Float.class};
      int[] __dna__dimensions = new int[]{3, 3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 404L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 368L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setLrot(CArrayFacade<CArrayFacade<Float>> lrot) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 404L;
      } else {
         __dna__offset = 368L;
      }

      if (!this.__io__equals(lrot, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, lrot)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, lrot);
         } else {
            __io__generic__copy(this.getLrot(), lrot);
         }

      }
   }

   public CArrayFacade<CArrayFacade<Float>> getLscale() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CArrayFacade.class, Float.class};
      int[] __dna__dimensions = new int[]{3, 3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 440L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 404L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setLscale(CArrayFacade<CArrayFacade<Float>> lscale) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 440L;
      } else {
         __dna__offset = 404L;
      }

      if (!this.__io__equals(lscale, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, lscale)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, lscale);
         } else {
            __io__generic__copy(this.getLscale(), lscale);
         }

      }
   }

   public int getLast_frame() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 476L) : this.__io__block.readInt(this.__io__address + 440L);
   }

   public void setLast_frame(int last_frame) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 476L, last_frame);
      } else {
         this.__io__block.writeInt(this.__io__address + 440L, last_frame);
      }

   }

   public CPointer<SoftBody> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{SoftBody.class}, this.__io__block, this.__io__blockTable);
   }
}
