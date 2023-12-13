package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 120L,
   size64 = 120L
)
public class BulletSoftBody extends CFacade {
   public static final int __DNA__SDNA_INDEX = 162;
   public static final long[] __DNA__FIELD__flag = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__linStiff = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__angStiff = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__volume = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__viterations = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__piterations = new long[]{20L, 20L};
   public static final long[] __DNA__FIELD__diterations = new long[]{24L, 24L};
   public static final long[] __DNA__FIELD__citerations = new long[]{28L, 28L};
   public static final long[] __DNA__FIELD__kSRHR_CL = new long[]{32L, 32L};
   public static final long[] __DNA__FIELD__kSKHR_CL = new long[]{36L, 36L};
   public static final long[] __DNA__FIELD__kSSHR_CL = new long[]{40L, 40L};
   public static final long[] __DNA__FIELD__kSR_SPLT_CL = new long[]{44L, 44L};
   public static final long[] __DNA__FIELD__kSK_SPLT_CL = new long[]{48L, 48L};
   public static final long[] __DNA__FIELD__kSS_SPLT_CL = new long[]{52L, 52L};
   public static final long[] __DNA__FIELD__kVCF = new long[]{56L, 56L};
   public static final long[] __DNA__FIELD__kDP = new long[]{60L, 60L};
   public static final long[] __DNA__FIELD__kDG = new long[]{64L, 64L};
   public static final long[] __DNA__FIELD__kLF = new long[]{68L, 68L};
   public static final long[] __DNA__FIELD__kPR = new long[]{72L, 72L};
   public static final long[] __DNA__FIELD__kVC = new long[]{76L, 76L};
   public static final long[] __DNA__FIELD__kDF = new long[]{80L, 80L};
   public static final long[] __DNA__FIELD__kMT = new long[]{84L, 84L};
   public static final long[] __DNA__FIELD__kCHR = new long[]{88L, 88L};
   public static final long[] __DNA__FIELD__kKHR = new long[]{92L, 92L};
   public static final long[] __DNA__FIELD__kSHR = new long[]{96L, 96L};
   public static final long[] __DNA__FIELD__kAHR = new long[]{100L, 100L};
   public static final long[] __DNA__FIELD__collisionflags = new long[]{104L, 104L};
   public static final long[] __DNA__FIELD__numclusteriterations = new long[]{108L, 108L};
   public static final long[] __DNA__FIELD__welding = new long[]{112L, 112L};
   public static final long[] __DNA__FIELD__margin = new long[]{116L, 116L};

   public BulletSoftBody(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected BulletSoftBody(BulletSoftBody that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 0L) : this.__io__block.readInt(this.__io__address + 0L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 0L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 0L, flag);
      }

   }

   public float getLinStiff() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 4L) : this.__io__block.readFloat(this.__io__address + 4L);
   }

   public void setLinStiff(float linStiff) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 4L, linStiff);
      } else {
         this.__io__block.writeFloat(this.__io__address + 4L, linStiff);
      }

   }

   public float getAngStiff() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 8L) : this.__io__block.readFloat(this.__io__address + 8L);
   }

   public void setAngStiff(float angStiff) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 8L, angStiff);
      } else {
         this.__io__block.writeFloat(this.__io__address + 8L, angStiff);
      }

   }

   public float getVolume() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 12L) : this.__io__block.readFloat(this.__io__address + 12L);
   }

   public void setVolume(float volume) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 12L, volume);
      } else {
         this.__io__block.writeFloat(this.__io__address + 12L, volume);
      }

   }

   public int getViterations() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 16L) : this.__io__block.readInt(this.__io__address + 16L);
   }

   public void setViterations(int viterations) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 16L, viterations);
      } else {
         this.__io__block.writeInt(this.__io__address + 16L, viterations);
      }

   }

   public int getPiterations() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 20L) : this.__io__block.readInt(this.__io__address + 20L);
   }

   public void setPiterations(int piterations) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 20L, piterations);
      } else {
         this.__io__block.writeInt(this.__io__address + 20L, piterations);
      }

   }

   public int getDiterations() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 24L) : this.__io__block.readInt(this.__io__address + 24L);
   }

   public void setDiterations(int diterations) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 24L, diterations);
      } else {
         this.__io__block.writeInt(this.__io__address + 24L, diterations);
      }

   }

   public int getCiterations() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 28L) : this.__io__block.readInt(this.__io__address + 28L);
   }

   public void setCiterations(int citerations) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 28L, citerations);
      } else {
         this.__io__block.writeInt(this.__io__address + 28L, citerations);
      }

   }

   public float getKSRHR_CL() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 32L) : this.__io__block.readFloat(this.__io__address + 32L);
   }

   public void setKSRHR_CL(float kSRHR_CL) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 32L, kSRHR_CL);
      } else {
         this.__io__block.writeFloat(this.__io__address + 32L, kSRHR_CL);
      }

   }

   public float getKSKHR_CL() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 36L) : this.__io__block.readFloat(this.__io__address + 36L);
   }

   public void setKSKHR_CL(float kSKHR_CL) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 36L, kSKHR_CL);
      } else {
         this.__io__block.writeFloat(this.__io__address + 36L, kSKHR_CL);
      }

   }

   public float getKSSHR_CL() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 40L) : this.__io__block.readFloat(this.__io__address + 40L);
   }

   public void setKSSHR_CL(float kSSHR_CL) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 40L, kSSHR_CL);
      } else {
         this.__io__block.writeFloat(this.__io__address + 40L, kSSHR_CL);
      }

   }

   public float getKSR_SPLT_CL() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 44L) : this.__io__block.readFloat(this.__io__address + 44L);
   }

   public void setKSR_SPLT_CL(float kSR_SPLT_CL) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 44L, kSR_SPLT_CL);
      } else {
         this.__io__block.writeFloat(this.__io__address + 44L, kSR_SPLT_CL);
      }

   }

   public float getKSK_SPLT_CL() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 48L) : this.__io__block.readFloat(this.__io__address + 48L);
   }

   public void setKSK_SPLT_CL(float kSK_SPLT_CL) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 48L, kSK_SPLT_CL);
      } else {
         this.__io__block.writeFloat(this.__io__address + 48L, kSK_SPLT_CL);
      }

   }

   public float getKSS_SPLT_CL() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 52L) : this.__io__block.readFloat(this.__io__address + 52L);
   }

   public void setKSS_SPLT_CL(float kSS_SPLT_CL) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 52L, kSS_SPLT_CL);
      } else {
         this.__io__block.writeFloat(this.__io__address + 52L, kSS_SPLT_CL);
      }

   }

   public float getKVCF() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 56L) : this.__io__block.readFloat(this.__io__address + 56L);
   }

   public void setKVCF(float kVCF) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 56L, kVCF);
      } else {
         this.__io__block.writeFloat(this.__io__address + 56L, kVCF);
      }

   }

   public float getKDP() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 60L) : this.__io__block.readFloat(this.__io__address + 60L);
   }

   public void setKDP(float kDP) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 60L, kDP);
      } else {
         this.__io__block.writeFloat(this.__io__address + 60L, kDP);
      }

   }

   public float getKDG() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 64L) : this.__io__block.readFloat(this.__io__address + 64L);
   }

   public void setKDG(float kDG) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 64L, kDG);
      } else {
         this.__io__block.writeFloat(this.__io__address + 64L, kDG);
      }

   }

   public float getKLF() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 68L) : this.__io__block.readFloat(this.__io__address + 68L);
   }

   public void setKLF(float kLF) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 68L, kLF);
      } else {
         this.__io__block.writeFloat(this.__io__address + 68L, kLF);
      }

   }

   public float getKPR() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 72L) : this.__io__block.readFloat(this.__io__address + 72L);
   }

   public void setKPR(float kPR) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 72L, kPR);
      } else {
         this.__io__block.writeFloat(this.__io__address + 72L, kPR);
      }

   }

   public float getKVC() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 76L) : this.__io__block.readFloat(this.__io__address + 76L);
   }

   public void setKVC(float kVC) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 76L, kVC);
      } else {
         this.__io__block.writeFloat(this.__io__address + 76L, kVC);
      }

   }

   public float getKDF() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 80L) : this.__io__block.readFloat(this.__io__address + 80L);
   }

   public void setKDF(float kDF) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 80L, kDF);
      } else {
         this.__io__block.writeFloat(this.__io__address + 80L, kDF);
      }

   }

   public float getKMT() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 84L) : this.__io__block.readFloat(this.__io__address + 84L);
   }

   public void setKMT(float kMT) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 84L, kMT);
      } else {
         this.__io__block.writeFloat(this.__io__address + 84L, kMT);
      }

   }

   public float getKCHR() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 88L) : this.__io__block.readFloat(this.__io__address + 88L);
   }

   public void setKCHR(float kCHR) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 88L, kCHR);
      } else {
         this.__io__block.writeFloat(this.__io__address + 88L, kCHR);
      }

   }

   public float getKKHR() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 92L) : this.__io__block.readFloat(this.__io__address + 92L);
   }

   public void setKKHR(float kKHR) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 92L, kKHR);
      } else {
         this.__io__block.writeFloat(this.__io__address + 92L, kKHR);
      }

   }

   public float getKSHR() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 96L) : this.__io__block.readFloat(this.__io__address + 96L);
   }

   public void setKSHR(float kSHR) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 96L, kSHR);
      } else {
         this.__io__block.writeFloat(this.__io__address + 96L, kSHR);
      }

   }

   public float getKAHR() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 100L) : this.__io__block.readFloat(this.__io__address + 100L);
   }

   public void setKAHR(float kAHR) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 100L, kAHR);
      } else {
         this.__io__block.writeFloat(this.__io__address + 100L, kAHR);
      }

   }

   public int getCollisionflags() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 104L) : this.__io__block.readInt(this.__io__address + 104L);
   }

   public void setCollisionflags(int collisionflags) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 104L, collisionflags);
      } else {
         this.__io__block.writeInt(this.__io__address + 104L, collisionflags);
      }

   }

   public int getNumclusteriterations() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 108L) : this.__io__block.readInt(this.__io__address + 108L);
   }

   public void setNumclusteriterations(int numclusteriterations) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 108L, numclusteriterations);
      } else {
         this.__io__block.writeInt(this.__io__address + 108L, numclusteriterations);
      }

   }

   public float getWelding() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 112L) : this.__io__block.readFloat(this.__io__address + 112L);
   }

   public void setWelding(float welding) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 112L, welding);
      } else {
         this.__io__block.writeFloat(this.__io__address + 112L, welding);
      }

   }

   public float getMargin() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 116L) : this.__io__block.readFloat(this.__io__address + 116L);
   }

   public void setMargin(float margin) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 116L, margin);
      } else {
         this.__io__block.writeFloat(this.__io__address + 116L, margin);
      }

   }

   public CPointer<BulletSoftBody> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{BulletSoftBody.class}, this.__io__block, this.__io__blockTable);
   }
}
