package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 188L,
   size64 = 192L
)
public class GameData extends CFacade {
   public static final int __DNA__SDNA_INDEX = 183;
   public static final long[] __DNA__FIELD__framing = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__playerflag = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__xplay = new long[]{18L, 18L};
   public static final long[] __DNA__FIELD__yplay = new long[]{20L, 20L};
   public static final long[] __DNA__FIELD__freqplay = new long[]{22L, 22L};
   public static final long[] __DNA__FIELD__depth = new long[]{24L, 24L};
   public static final long[] __DNA__FIELD__attrib = new long[]{26L, 26L};
   public static final long[] __DNA__FIELD__rt1 = new long[]{28L, 28L};
   public static final long[] __DNA__FIELD__rt2 = new long[]{30L, 30L};
   public static final long[] __DNA__FIELD__aasamples = new long[]{32L, 32L};
   public static final long[] __DNA__FIELD__pad4 = new long[]{34L, 34L};
   public static final long[] __DNA__FIELD__dome = new long[]{40L, 40L};
   public static final long[] __DNA__FIELD__stereoflag = new long[]{60L, 64L};
   public static final long[] __DNA__FIELD__stereomode = new long[]{62L, 66L};
   public static final long[] __DNA__FIELD__eyeseparation = new long[]{64L, 68L};
   public static final long[] __DNA__FIELD__recastData = new long[]{68L, 72L};
   public static final long[] __DNA__FIELD__gravity = new long[]{124L, 128L};
   public static final long[] __DNA__FIELD__activityBoxRadius = new long[]{128L, 132L};
   public static final long[] __DNA__FIELD__flag = new long[]{132L, 136L};
   public static final long[] __DNA__FIELD__mode = new long[]{136L, 140L};
   public static final long[] __DNA__FIELD__matmode = new long[]{138L, 142L};
   public static final long[] __DNA__FIELD__occlusionRes = new long[]{140L, 144L};
   public static final long[] __DNA__FIELD__physicsEngine = new long[]{142L, 146L};
   public static final long[] __DNA__FIELD__exitkey = new long[]{144L, 148L};
   public static final long[] __DNA__FIELD__vsync = new long[]{146L, 150L};
   public static final long[] __DNA__FIELD__ticrate = new long[]{148L, 152L};
   public static final long[] __DNA__FIELD__maxlogicstep = new long[]{150L, 154L};
   public static final long[] __DNA__FIELD__physubstep = new long[]{152L, 156L};
   public static final long[] __DNA__FIELD__maxphystep = new long[]{154L, 158L};
   public static final long[] __DNA__FIELD__obstacleSimulation = new long[]{156L, 160L};
   public static final long[] __DNA__FIELD__raster_storage = new long[]{158L, 162L};
   public static final long[] __DNA__FIELD__levelHeight = new long[]{160L, 164L};
   public static final long[] __DNA__FIELD__deactivationtime = new long[]{164L, 168L};
   public static final long[] __DNA__FIELD__lineardeactthreshold = new long[]{168L, 172L};
   public static final long[] __DNA__FIELD__angulardeactthreshold = new long[]{172L, 176L};
   public static final long[] __DNA__FIELD__lodflag = new long[]{176L, 180L};
   public static final long[] __DNA__FIELD__pad2 = new long[]{178L, 182L};
   public static final long[] __DNA__FIELD__scehysteresis = new long[]{180L, 184L};
   public static final long[] __DNA__FIELD__pad5 = new long[]{184L, 188L};

   public GameData(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected GameData(GameData that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public GameFraming getFraming() throws IOException {
      return this.__io__pointersize == 8 ? new GameFraming(this.__io__address + 0L, this.__io__block, this.__io__blockTable) : new GameFraming(this.__io__address + 0L, this.__io__block, this.__io__blockTable);
   }

   public void setFraming(GameFraming framing) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(framing, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, framing)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, framing);
         } else {
            __io__generic__copy(this.getFraming(), framing);
         }

      }
   }

   public short getPlayerflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 16L) : this.__io__block.readShort(this.__io__address + 16L);
   }

   public void setPlayerflag(short playerflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 16L, playerflag);
      } else {
         this.__io__block.writeShort(this.__io__address + 16L, playerflag);
      }

   }

   public short getXplay() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 18L) : this.__io__block.readShort(this.__io__address + 18L);
   }

   public void setXplay(short xplay) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 18L, xplay);
      } else {
         this.__io__block.writeShort(this.__io__address + 18L, xplay);
      }

   }

   public short getYplay() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 20L) : this.__io__block.readShort(this.__io__address + 20L);
   }

   public void setYplay(short yplay) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 20L, yplay);
      } else {
         this.__io__block.writeShort(this.__io__address + 20L, yplay);
      }

   }

   public short getFreqplay() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 22L) : this.__io__block.readShort(this.__io__address + 22L);
   }

   public void setFreqplay(short freqplay) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 22L, freqplay);
      } else {
         this.__io__block.writeShort(this.__io__address + 22L, freqplay);
      }

   }

   public short getDepth() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 24L) : this.__io__block.readShort(this.__io__address + 24L);
   }

   public void setDepth(short depth) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 24L, depth);
      } else {
         this.__io__block.writeShort(this.__io__address + 24L, depth);
      }

   }

   public short getAttrib() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 26L) : this.__io__block.readShort(this.__io__address + 26L);
   }

   public void setAttrib(short attrib) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 26L, attrib);
      } else {
         this.__io__block.writeShort(this.__io__address + 26L, attrib);
      }

   }

   public short getRt1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 28L) : this.__io__block.readShort(this.__io__address + 28L);
   }

   public void setRt1(short rt1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 28L, rt1);
      } else {
         this.__io__block.writeShort(this.__io__address + 28L, rt1);
      }

   }

   public short getRt2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 30L) : this.__io__block.readShort(this.__io__address + 30L);
   }

   public void setRt2(short rt2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 30L, rt2);
      } else {
         this.__io__block.writeShort(this.__io__address + 30L, rt2);
      }

   }

   public short getAasamples() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 32L) : this.__io__block.readShort(this.__io__address + 32L);
   }

   public void setAasamples(short aasamples) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 32L, aasamples);
      } else {
         this.__io__block.writeShort(this.__io__address + 32L, aasamples);
      }

   }

   public CArrayFacade<Short> getPad4() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Short.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 34L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 34L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad4(CArrayFacade<Short> pad4) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 34L;
      } else {
         __dna__offset = 34L;
      }

      if (!this.__io__equals(pad4, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad4)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad4);
         } else {
            __io__generic__copy(this.getPad4(), pad4);
         }

      }
   }

   public GameDome getDome() throws IOException {
      return this.__io__pointersize == 8 ? new GameDome(this.__io__address + 40L, this.__io__block, this.__io__blockTable) : new GameDome(this.__io__address + 40L, this.__io__block, this.__io__blockTable);
   }

   public void setDome(GameDome dome) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 40L;
      } else {
         __dna__offset = 40L;
      }

      if (!this.__io__equals(dome, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, dome)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, dome);
         } else {
            __io__generic__copy(this.getDome(), dome);
         }

      }
   }

   public short getStereoflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 64L) : this.__io__block.readShort(this.__io__address + 60L);
   }

   public void setStereoflag(short stereoflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 64L, stereoflag);
      } else {
         this.__io__block.writeShort(this.__io__address + 60L, stereoflag);
      }

   }

   public short getStereomode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 66L) : this.__io__block.readShort(this.__io__address + 62L);
   }

   public void setStereomode(short stereomode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 66L, stereomode);
      } else {
         this.__io__block.writeShort(this.__io__address + 62L, stereomode);
      }

   }

   public float getEyeseparation() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 68L) : this.__io__block.readFloat(this.__io__address + 64L);
   }

   public void setEyeseparation(float eyeseparation) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 68L, eyeseparation);
      } else {
         this.__io__block.writeFloat(this.__io__address + 64L, eyeseparation);
      }

   }

   public RecastData getRecastData() throws IOException {
      return this.__io__pointersize == 8 ? new RecastData(this.__io__address + 72L, this.__io__block, this.__io__blockTable) : new RecastData(this.__io__address + 68L, this.__io__block, this.__io__blockTable);
   }

   public void setRecastData(RecastData recastData) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 72L;
      } else {
         __dna__offset = 68L;
      }

      if (!this.__io__equals(recastData, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, recastData)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, recastData);
         } else {
            __io__generic__copy(this.getRecastData(), recastData);
         }

      }
   }

   public float getGravity() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 128L) : this.__io__block.readFloat(this.__io__address + 124L);
   }

   public void setGravity(float gravity) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 128L, gravity);
      } else {
         this.__io__block.writeFloat(this.__io__address + 124L, gravity);
      }

   }

   public float getActivityBoxRadius() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 132L) : this.__io__block.readFloat(this.__io__address + 128L);
   }

   public void setActivityBoxRadius(float activityBoxRadius) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 132L, activityBoxRadius);
      } else {
         this.__io__block.writeFloat(this.__io__address + 128L, activityBoxRadius);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 136L) : this.__io__block.readInt(this.__io__address + 132L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 136L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 132L, flag);
      }

   }

   public short getMode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 140L) : this.__io__block.readShort(this.__io__address + 136L);
   }

   public void setMode(short mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 140L, mode);
      } else {
         this.__io__block.writeShort(this.__io__address + 136L, mode);
      }

   }

   public short getMatmode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 142L) : this.__io__block.readShort(this.__io__address + 138L);
   }

   public void setMatmode(short matmode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 142L, matmode);
      } else {
         this.__io__block.writeShort(this.__io__address + 138L, matmode);
      }

   }

   public short getOcclusionRes() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 144L) : this.__io__block.readShort(this.__io__address + 140L);
   }

   public void setOcclusionRes(short occlusionRes) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 144L, occlusionRes);
      } else {
         this.__io__block.writeShort(this.__io__address + 140L, occlusionRes);
      }

   }

   public short getPhysicsEngine() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 146L) : this.__io__block.readShort(this.__io__address + 142L);
   }

   public void setPhysicsEngine(short physicsEngine) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 146L, physicsEngine);
      } else {
         this.__io__block.writeShort(this.__io__address + 142L, physicsEngine);
      }

   }

   public short getExitkey() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 148L) : this.__io__block.readShort(this.__io__address + 144L);
   }

   public void setExitkey(short exitkey) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 148L, exitkey);
      } else {
         this.__io__block.writeShort(this.__io__address + 144L, exitkey);
      }

   }

   public short getVsync() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 150L) : this.__io__block.readShort(this.__io__address + 146L);
   }

   public void setVsync(short vsync) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 150L, vsync);
      } else {
         this.__io__block.writeShort(this.__io__address + 146L, vsync);
      }

   }

   public short getTicrate() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 152L) : this.__io__block.readShort(this.__io__address + 148L);
   }

   public void setTicrate(short ticrate) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 152L, ticrate);
      } else {
         this.__io__block.writeShort(this.__io__address + 148L, ticrate);
      }

   }

   public short getMaxlogicstep() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 154L) : this.__io__block.readShort(this.__io__address + 150L);
   }

   public void setMaxlogicstep(short maxlogicstep) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 154L, maxlogicstep);
      } else {
         this.__io__block.writeShort(this.__io__address + 150L, maxlogicstep);
      }

   }

   public short getPhysubstep() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 156L) : this.__io__block.readShort(this.__io__address + 152L);
   }

   public void setPhysubstep(short physubstep) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 156L, physubstep);
      } else {
         this.__io__block.writeShort(this.__io__address + 152L, physubstep);
      }

   }

   public short getMaxphystep() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 158L) : this.__io__block.readShort(this.__io__address + 154L);
   }

   public void setMaxphystep(short maxphystep) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 158L, maxphystep);
      } else {
         this.__io__block.writeShort(this.__io__address + 154L, maxphystep);
      }

   }

   public short getObstacleSimulation() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 160L) : this.__io__block.readShort(this.__io__address + 156L);
   }

   public void setObstacleSimulation(short obstacleSimulation) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 160L, obstacleSimulation);
      } else {
         this.__io__block.writeShort(this.__io__address + 156L, obstacleSimulation);
      }

   }

   public short getRaster_storage() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 162L) : this.__io__block.readShort(this.__io__address + 158L);
   }

   public void setRaster_storage(short raster_storage) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 162L, raster_storage);
      } else {
         this.__io__block.writeShort(this.__io__address + 158L, raster_storage);
      }

   }

   public float getLevelHeight() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 164L) : this.__io__block.readFloat(this.__io__address + 160L);
   }

   public void setLevelHeight(float levelHeight) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 164L, levelHeight);
      } else {
         this.__io__block.writeFloat(this.__io__address + 160L, levelHeight);
      }

   }

   public float getDeactivationtime() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 168L) : this.__io__block.readFloat(this.__io__address + 164L);
   }

   public void setDeactivationtime(float deactivationtime) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 168L, deactivationtime);
      } else {
         this.__io__block.writeFloat(this.__io__address + 164L, deactivationtime);
      }

   }

   public float getLineardeactthreshold() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 172L) : this.__io__block.readFloat(this.__io__address + 168L);
   }

   public void setLineardeactthreshold(float lineardeactthreshold) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 172L, lineardeactthreshold);
      } else {
         this.__io__block.writeFloat(this.__io__address + 168L, lineardeactthreshold);
      }

   }

   public float getAngulardeactthreshold() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 176L) : this.__io__block.readFloat(this.__io__address + 172L);
   }

   public void setAngulardeactthreshold(float angulardeactthreshold) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 176L, angulardeactthreshold);
      } else {
         this.__io__block.writeFloat(this.__io__address + 172L, angulardeactthreshold);
      }

   }

   public short getLodflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 180L) : this.__io__block.readShort(this.__io__address + 176L);
   }

   public void setLodflag(short lodflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 180L, lodflag);
      } else {
         this.__io__block.writeShort(this.__io__address + 176L, lodflag);
      }

   }

   public short getPad2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 182L) : this.__io__block.readShort(this.__io__address + 178L);
   }

   public void setPad2(short pad2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 182L, pad2);
      } else {
         this.__io__block.writeShort(this.__io__address + 178L, pad2);
      }

   }

   public int getScehysteresis() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 184L) : this.__io__block.readInt(this.__io__address + 180L);
   }

   public void setScehysteresis(int scehysteresis) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 184L, scehysteresis);
      } else {
         this.__io__block.writeInt(this.__io__address + 180L, scehysteresis);
      }

   }

   public int getPad5() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 188L) : this.__io__block.readInt(this.__io__address + 184L);
   }

   public void setPad5(int pad5) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 188L, pad5);
      } else {
         this.__io__block.writeInt(this.__io__address + 184L, pad5);
      }

   }

   public CPointer<GameData> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{GameData.class}, this.__io__block, this.__io__blockTable);
   }
}
