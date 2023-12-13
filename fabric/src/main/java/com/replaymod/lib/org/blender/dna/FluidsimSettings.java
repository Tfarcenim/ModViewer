package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 1228L,
   size64 = 1240L
)
public class FluidsimSettings extends CFacade {
   public static final int __DNA__SDNA_INDEX = 165;
   public static final long[] __DNA__FIELD__fmd = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__threads = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__pad1 = new long[]{8L, 12L};
   public static final long[] __DNA__FIELD__type = new long[]{12L, 16L};
   public static final long[] __DNA__FIELD__show_advancedoptions = new long[]{14L, 18L};
   public static final long[] __DNA__FIELD__resolutionxyz = new long[]{16L, 20L};
   public static final long[] __DNA__FIELD__previewresxyz = new long[]{18L, 22L};
   public static final long[] __DNA__FIELD__realsize = new long[]{20L, 24L};
   public static final long[] __DNA__FIELD__guiDisplayMode = new long[]{24L, 28L};
   public static final long[] __DNA__FIELD__renderDisplayMode = new long[]{26L, 30L};
   public static final long[] __DNA__FIELD__viscosityValue = new long[]{28L, 32L};
   public static final long[] __DNA__FIELD__viscosityMode = new long[]{32L, 36L};
   public static final long[] __DNA__FIELD__viscosityExponent = new long[]{34L, 38L};
   public static final long[] __DNA__FIELD__grav = new long[]{36L, 40L};
   public static final long[] __DNA__FIELD__animStart = new long[]{48L, 52L};
   public static final long[] __DNA__FIELD__animEnd = new long[]{52L, 56L};
   public static final long[] __DNA__FIELD__bakeStart = new long[]{56L, 60L};
   public static final long[] __DNA__FIELD__bakeEnd = new long[]{60L, 64L};
   public static final long[] __DNA__FIELD__frameOffset = new long[]{64L, 68L};
   public static final long[] __DNA__FIELD__pad2 = new long[]{68L, 72L};
   public static final long[] __DNA__FIELD__gstar = new long[]{72L, 76L};
   public static final long[] __DNA__FIELD__maxRefine = new long[]{76L, 80L};
   public static final long[] __DNA__FIELD__iniVelx = new long[]{80L, 84L};
   public static final long[] __DNA__FIELD__iniVely = new long[]{84L, 88L};
   public static final long[] __DNA__FIELD__iniVelz = new long[]{88L, 92L};
   public static final long[] __DNA__FIELD__surfdataPath = new long[]{92L, 96L};
   public static final long[] __DNA__FIELD__bbStart = new long[]{1116L, 1120L};
   public static final long[] __DNA__FIELD__bbSize = new long[]{1128L, 1132L};
   public static final long[] __DNA__FIELD__ipo = new long[]{1140L, 1144L};
   public static final long[] __DNA__FIELD__typeFlags = new long[]{1144L, 1152L};
   public static final long[] __DNA__FIELD__domainNovecgen = new long[]{1146L, 1154L};
   public static final long[] __DNA__FIELD__volumeInitType = new long[]{1147L, 1155L};
   public static final long[] __DNA__FIELD__partSlipValue = new long[]{1148L, 1156L};
   public static final long[] __DNA__FIELD__generateTracers = new long[]{1152L, 1160L};
   public static final long[] __DNA__FIELD__generateParticles = new long[]{1156L, 1164L};
   public static final long[] __DNA__FIELD__surfaceSmoothing = new long[]{1160L, 1168L};
   public static final long[] __DNA__FIELD__surfaceSubdivs = new long[]{1164L, 1172L};
   public static final long[] __DNA__FIELD__flag = new long[]{1168L, 1176L};
   public static final long[] __DNA__FIELD__particleInfSize = new long[]{1172L, 1180L};
   public static final long[] __DNA__FIELD__particleInfAlpha = new long[]{1176L, 1184L};
   public static final long[] __DNA__FIELD__farFieldSize = new long[]{1180L, 1188L};
   public static final long[] __DNA__FIELD__meshVelocities = new long[]{1184L, 1192L};
   public static final long[] __DNA__FIELD__totvert = new long[]{1188L, 1200L};
   public static final long[] __DNA__FIELD__cpsTimeStart = new long[]{1192L, 1204L};
   public static final long[] __DNA__FIELD__cpsTimeEnd = new long[]{1196L, 1208L};
   public static final long[] __DNA__FIELD__cpsQuality = new long[]{1200L, 1212L};
   public static final long[] __DNA__FIELD__attractforceStrength = new long[]{1204L, 1216L};
   public static final long[] __DNA__FIELD__attractforceRadius = new long[]{1208L, 1220L};
   public static final long[] __DNA__FIELD__velocityforceStrength = new long[]{1212L, 1224L};
   public static final long[] __DNA__FIELD__velocityforceRadius = new long[]{1216L, 1228L};
   public static final long[] __DNA__FIELD__lastgoodframe = new long[]{1220L, 1232L};
   public static final long[] __DNA__FIELD__animRate = new long[]{1224L, 1236L};

   public FluidsimSettings(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected FluidsimSettings(FluidsimSettings that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<FluidsimModifierData> getFmd() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{FluidsimModifierData.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 121), this.__io__blockTable);
   }

   public void setFmd(CPointer<FluidsimModifierData> fmd) throws IOException {
      long __address = fmd == null ? 0L : fmd.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public int getThreads() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 8L) : this.__io__block.readInt(this.__io__address + 4L);
   }

   public void setThreads(int threads) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 8L, threads);
      } else {
         this.__io__block.writeInt(this.__io__address + 4L, threads);
      }

   }

   public int getPad1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 12L) : this.__io__block.readInt(this.__io__address + 8L);
   }

   public void setPad1(int pad1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 12L, pad1);
      } else {
         this.__io__block.writeInt(this.__io__address + 8L, pad1);
      }

   }

   public short getType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 16L) : this.__io__block.readShort(this.__io__address + 12L);
   }

   public void setType(short type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 16L, type);
      } else {
         this.__io__block.writeShort(this.__io__address + 12L, type);
      }

   }

   public short getShow_advancedoptions() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 18L) : this.__io__block.readShort(this.__io__address + 14L);
   }

   public void setShow_advancedoptions(short show_advancedoptions) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 18L, show_advancedoptions);
      } else {
         this.__io__block.writeShort(this.__io__address + 14L, show_advancedoptions);
      }

   }

   public short getResolutionxyz() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 20L) : this.__io__block.readShort(this.__io__address + 16L);
   }

   public void setResolutionxyz(short resolutionxyz) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 20L, resolutionxyz);
      } else {
         this.__io__block.writeShort(this.__io__address + 16L, resolutionxyz);
      }

   }

   public short getPreviewresxyz() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 22L) : this.__io__block.readShort(this.__io__address + 18L);
   }

   public void setPreviewresxyz(short previewresxyz) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 22L, previewresxyz);
      } else {
         this.__io__block.writeShort(this.__io__address + 18L, previewresxyz);
      }

   }

   public float getRealsize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 24L) : this.__io__block.readFloat(this.__io__address + 20L);
   }

   public void setRealsize(float realsize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 24L, realsize);
      } else {
         this.__io__block.writeFloat(this.__io__address + 20L, realsize);
      }

   }

   public short getGuiDisplayMode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 28L) : this.__io__block.readShort(this.__io__address + 24L);
   }

   public void setGuiDisplayMode(short guiDisplayMode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 28L, guiDisplayMode);
      } else {
         this.__io__block.writeShort(this.__io__address + 24L, guiDisplayMode);
      }

   }

   public short getRenderDisplayMode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 30L) : this.__io__block.readShort(this.__io__address + 26L);
   }

   public void setRenderDisplayMode(short renderDisplayMode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 30L, renderDisplayMode);
      } else {
         this.__io__block.writeShort(this.__io__address + 26L, renderDisplayMode);
      }

   }

   public float getViscosityValue() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 32L) : this.__io__block.readFloat(this.__io__address + 28L);
   }

   public void setViscosityValue(float viscosityValue) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 32L, viscosityValue);
      } else {
         this.__io__block.writeFloat(this.__io__address + 28L, viscosityValue);
      }

   }

   public short getViscosityMode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 36L) : this.__io__block.readShort(this.__io__address + 32L);
   }

   public void setViscosityMode(short viscosityMode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 36L, viscosityMode);
      } else {
         this.__io__block.writeShort(this.__io__address + 32L, viscosityMode);
      }

   }

   public short getViscosityExponent() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 38L) : this.__io__block.readShort(this.__io__address + 34L);
   }

   public void setViscosityExponent(short viscosityExponent) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 38L, viscosityExponent);
      } else {
         this.__io__block.writeShort(this.__io__address + 34L, viscosityExponent);
      }

   }

   public CArrayFacade<Float> getGrav() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 40L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 36L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setGrav(CArrayFacade<Float> grav) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 40L;
      } else {
         __dna__offset = 36L;
      }

      if (!this.__io__equals(grav, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, grav)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, grav);
         } else {
            __io__generic__copy(this.getGrav(), grav);
         }

      }
   }

   public float getAnimStart() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 52L) : this.__io__block.readFloat(this.__io__address + 48L);
   }

   public void setAnimStart(float animStart) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 52L, animStart);
      } else {
         this.__io__block.writeFloat(this.__io__address + 48L, animStart);
      }

   }

   public float getAnimEnd() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 56L) : this.__io__block.readFloat(this.__io__address + 52L);
   }

   public void setAnimEnd(float animEnd) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 56L, animEnd);
      } else {
         this.__io__block.writeFloat(this.__io__address + 52L, animEnd);
      }

   }

   public int getBakeStart() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 60L) : this.__io__block.readInt(this.__io__address + 56L);
   }

   public void setBakeStart(int bakeStart) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 60L, bakeStart);
      } else {
         this.__io__block.writeInt(this.__io__address + 56L, bakeStart);
      }

   }

   public int getBakeEnd() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 64L) : this.__io__block.readInt(this.__io__address + 60L);
   }

   public void setBakeEnd(int bakeEnd) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 64L, bakeEnd);
      } else {
         this.__io__block.writeInt(this.__io__address + 60L, bakeEnd);
      }

   }

   public int getFrameOffset() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 68L) : this.__io__block.readInt(this.__io__address + 64L);
   }

   public void setFrameOffset(int frameOffset) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 68L, frameOffset);
      } else {
         this.__io__block.writeInt(this.__io__address + 64L, frameOffset);
      }

   }

   public int getPad2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 72L) : this.__io__block.readInt(this.__io__address + 68L);
   }

   public void setPad2(int pad2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 72L, pad2);
      } else {
         this.__io__block.writeInt(this.__io__address + 68L, pad2);
      }

   }

   public float getGstar() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 76L) : this.__io__block.readFloat(this.__io__address + 72L);
   }

   public void setGstar(float gstar) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 76L, gstar);
      } else {
         this.__io__block.writeFloat(this.__io__address + 72L, gstar);
      }

   }

   public int getMaxRefine() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 80L) : this.__io__block.readInt(this.__io__address + 76L);
   }

   public void setMaxRefine(int maxRefine) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 80L, maxRefine);
      } else {
         this.__io__block.writeInt(this.__io__address + 76L, maxRefine);
      }

   }

   public float getIniVelx() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 84L) : this.__io__block.readFloat(this.__io__address + 80L);
   }

   public void setIniVelx(float iniVelx) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 84L, iniVelx);
      } else {
         this.__io__block.writeFloat(this.__io__address + 80L, iniVelx);
      }

   }

   public float getIniVely() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 88L) : this.__io__block.readFloat(this.__io__address + 84L);
   }

   public void setIniVely(float iniVely) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 88L, iniVely);
      } else {
         this.__io__block.writeFloat(this.__io__address + 84L, iniVely);
      }

   }

   public float getIniVelz() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 92L) : this.__io__block.readFloat(this.__io__address + 88L);
   }

   public void setIniVelz(float iniVelz) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 92L, iniVelz);
      } else {
         this.__io__block.writeFloat(this.__io__address + 88L, iniVelz);
      }

   }

   public CArrayFacade<Byte> getSurfdataPath() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{1024};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 96L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 92L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setSurfdataPath(CArrayFacade<Byte> surfdataPath) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 96L;
      } else {
         __dna__offset = 92L;
      }

      if (!this.__io__equals(surfdataPath, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, surfdataPath)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, surfdataPath);
         } else {
            __io__generic__copy(this.getSurfdataPath(), surfdataPath);
         }

      }
   }

   public CArrayFacade<Float> getBbStart() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1120L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1116L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setBbStart(CArrayFacade<Float> bbStart) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1120L;
      } else {
         __dna__offset = 1116L;
      }

      if (!this.__io__equals(bbStart, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, bbStart)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, bbStart);
         } else {
            __io__generic__copy(this.getBbStart(), bbStart);
         }

      }
   }

   public CArrayFacade<Float> getBbSize() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1132L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1128L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setBbSize(CArrayFacade<Float> bbSize) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1132L;
      } else {
         __dna__offset = 1128L;
      }

      if (!this.__io__equals(bbSize, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, bbSize)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, bbSize);
         } else {
            __io__generic__copy(this.getBbSize(), bbSize);
         }

      }
   }

   public CPointer<Ipo> getIpo() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1144L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1140L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Ipo.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 15), this.__io__blockTable);
   }

   public void setIpo(CPointer<Ipo> ipo) throws IOException {
      long __address = ipo == null ? 0L : ipo.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1144L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1140L, __address);
      }

   }

   public short getTypeFlags() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1152L) : this.__io__block.readShort(this.__io__address + 1144L);
   }

   public void setTypeFlags(short typeFlags) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1152L, typeFlags);
      } else {
         this.__io__block.writeShort(this.__io__address + 1144L, typeFlags);
      }

   }

   public byte getDomainNovecgen() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1154L) : this.__io__block.readByte(this.__io__address + 1146L);
   }

   public void setDomainNovecgen(byte domainNovecgen) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1154L, domainNovecgen);
      } else {
         this.__io__block.writeByte(this.__io__address + 1146L, domainNovecgen);
      }

   }

   public byte getVolumeInitType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1155L) : this.__io__block.readByte(this.__io__address + 1147L);
   }

   public void setVolumeInitType(byte volumeInitType) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1155L, volumeInitType);
      } else {
         this.__io__block.writeByte(this.__io__address + 1147L, volumeInitType);
      }

   }

   public float getPartSlipValue() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1156L) : this.__io__block.readFloat(this.__io__address + 1148L);
   }

   public void setPartSlipValue(float partSlipValue) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1156L, partSlipValue);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1148L, partSlipValue);
      }

   }

   public int getGenerateTracers() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1160L) : this.__io__block.readInt(this.__io__address + 1152L);
   }

   public void setGenerateTracers(int generateTracers) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1160L, generateTracers);
      } else {
         this.__io__block.writeInt(this.__io__address + 1152L, generateTracers);
      }

   }

   public float getGenerateParticles() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1164L) : this.__io__block.readFloat(this.__io__address + 1156L);
   }

   public void setGenerateParticles(float generateParticles) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1164L, generateParticles);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1156L, generateParticles);
      }

   }

   public float getSurfaceSmoothing() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1168L) : this.__io__block.readFloat(this.__io__address + 1160L);
   }

   public void setSurfaceSmoothing(float surfaceSmoothing) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1168L, surfaceSmoothing);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1160L, surfaceSmoothing);
      }

   }

   public int getSurfaceSubdivs() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1172L) : this.__io__block.readInt(this.__io__address + 1164L);
   }

   public void setSurfaceSubdivs(int surfaceSubdivs) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1172L, surfaceSubdivs);
      } else {
         this.__io__block.writeInt(this.__io__address + 1164L, surfaceSubdivs);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1176L) : this.__io__block.readInt(this.__io__address + 1168L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1176L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 1168L, flag);
      }

   }

   public float getParticleInfSize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1180L) : this.__io__block.readFloat(this.__io__address + 1172L);
   }

   public void setParticleInfSize(float particleInfSize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1180L, particleInfSize);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1172L, particleInfSize);
      }

   }

   public float getParticleInfAlpha() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1184L) : this.__io__block.readFloat(this.__io__address + 1176L);
   }

   public void setParticleInfAlpha(float particleInfAlpha) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1184L, particleInfAlpha);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1176L, particleInfAlpha);
      }

   }

   public float getFarFieldSize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1188L) : this.__io__block.readFloat(this.__io__address + 1180L);
   }

   public void setFarFieldSize(float farFieldSize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1188L, farFieldSize);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1180L, farFieldSize);
      }

   }

   public CPointer<FluidVertexVelocity> getMeshVelocities() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1192L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1184L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{FluidVertexVelocity.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 164), this.__io__blockTable);
   }

   public void setMeshVelocities(CPointer<FluidVertexVelocity> meshVelocities) throws IOException {
      long __address = meshVelocities == null ? 0L : meshVelocities.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1192L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1184L, __address);
      }

   }

   public int getTotvert() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1200L) : this.__io__block.readInt(this.__io__address + 1188L);
   }

   public void setTotvert(int totvert) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1200L, totvert);
      } else {
         this.__io__block.writeInt(this.__io__address + 1188L, totvert);
      }

   }

   public float getCpsTimeStart() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1204L) : this.__io__block.readFloat(this.__io__address + 1192L);
   }

   public void setCpsTimeStart(float cpsTimeStart) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1204L, cpsTimeStart);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1192L, cpsTimeStart);
      }

   }

   public float getCpsTimeEnd() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1208L) : this.__io__block.readFloat(this.__io__address + 1196L);
   }

   public void setCpsTimeEnd(float cpsTimeEnd) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1208L, cpsTimeEnd);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1196L, cpsTimeEnd);
      }

   }

   public float getCpsQuality() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1212L) : this.__io__block.readFloat(this.__io__address + 1200L);
   }

   public void setCpsQuality(float cpsQuality) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1212L, cpsQuality);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1200L, cpsQuality);
      }

   }

   public float getAttractforceStrength() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1216L) : this.__io__block.readFloat(this.__io__address + 1204L);
   }

   public void setAttractforceStrength(float attractforceStrength) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1216L, attractforceStrength);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1204L, attractforceStrength);
      }

   }

   public float getAttractforceRadius() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1220L) : this.__io__block.readFloat(this.__io__address + 1208L);
   }

   public void setAttractforceRadius(float attractforceRadius) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1220L, attractforceRadius);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1208L, attractforceRadius);
      }

   }

   public float getVelocityforceStrength() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1224L) : this.__io__block.readFloat(this.__io__address + 1212L);
   }

   public void setVelocityforceStrength(float velocityforceStrength) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1224L, velocityforceStrength);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1212L, velocityforceStrength);
      }

   }

   public float getVelocityforceRadius() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1228L) : this.__io__block.readFloat(this.__io__address + 1216L);
   }

   public void setVelocityforceRadius(float velocityforceRadius) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1228L, velocityforceRadius);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1216L, velocityforceRadius);
      }

   }

   public int getLastgoodframe() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1232L) : this.__io__block.readInt(this.__io__address + 1220L);
   }

   public void setLastgoodframe(int lastgoodframe) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1232L, lastgoodframe);
      } else {
         this.__io__block.writeInt(this.__io__address + 1220L, lastgoodframe);
      }

   }

   public float getAnimRate() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1236L) : this.__io__block.readFloat(this.__io__address + 1224L);
   }

   public void setAnimRate(float animRate) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1236L, animRate);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1224L, animRate);
      }

   }

   public CPointer<FluidsimSettings> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{FluidsimSettings.class}, this.__io__block, this.__io__blockTable);
   }
}
