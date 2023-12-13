package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 200L,
   size64 = 256L
)
public class bArmature extends CFacade {
   public static final int __DNA__SDNA_INDEX = 343;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__adt = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__bonebase = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__chainbase = new long[]{112L, 144L};
   public static final long[] __DNA__FIELD__edbo = new long[]{120L, 160L};
   public static final long[] __DNA__FIELD__act_bone = new long[]{124L, 168L};
   public static final long[] __DNA__FIELD__act_edbone = new long[]{128L, 176L};
   public static final long[] __DNA__FIELD__sketch = new long[]{132L, 184L};
   public static final long[] __DNA__FIELD__flag = new long[]{136L, 192L};
   public static final long[] __DNA__FIELD__drawtype = new long[]{140L, 196L};
   public static final long[] __DNA__FIELD__gevertdeformer = new long[]{144L, 200L};
   public static final long[] __DNA__FIELD__pad = new long[]{148L, 204L};
   public static final long[] __DNA__FIELD__deformflag = new long[]{152L, 208L};
   public static final long[] __DNA__FIELD__pathflag = new long[]{154L, 210L};
   public static final long[] __DNA__FIELD__layer_used = new long[]{156L, 212L};
   public static final long[] __DNA__FIELD__layer = new long[]{160L, 216L};
   public static final long[] __DNA__FIELD__layer_protected = new long[]{164L, 220L};
   public static final long[] __DNA__FIELD__ghostep = new long[]{168L, 224L};
   public static final long[] __DNA__FIELD__ghostsize = new long[]{170L, 226L};
   public static final long[] __DNA__FIELD__ghosttype = new long[]{172L, 228L};
   public static final long[] __DNA__FIELD__pathsize = new long[]{174L, 230L};
   public static final long[] __DNA__FIELD__ghostsf = new long[]{176L, 232L};
   public static final long[] __DNA__FIELD__ghostef = new long[]{180L, 236L};
   public static final long[] __DNA__FIELD__pathsf = new long[]{184L, 240L};
   public static final long[] __DNA__FIELD__pathef = new long[]{188L, 244L};
   public static final long[] __DNA__FIELD__pathbc = new long[]{192L, 248L};
   public static final long[] __DNA__FIELD__pathac = new long[]{196L, 252L};

   public bArmature(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected bArmature(bArmature that) {
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

   public ListBase getBonebase() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 128L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 104L, this.__io__block, this.__io__blockTable);
   }

   public void setBonebase(ListBase bonebase) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 128L;
      } else {
         __dna__offset = 104L;
      }

      if (!this.__io__equals(bonebase, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, bonebase)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, bonebase);
         } else {
            __io__generic__copy(this.getBonebase(), bonebase);
         }

      }
   }

   public ListBase getChainbase() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 144L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 112L, this.__io__block, this.__io__blockTable);
   }

   public void setChainbase(ListBase chainbase) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 144L;
      } else {
         __dna__offset = 112L;
      }

      if (!this.__io__equals(chainbase, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, chainbase)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, chainbase);
         } else {
            __io__generic__copy(this.getChainbase(), chainbase);
         }

      }
   }

   public CPointer<ListBase> getEdbo() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 160L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 120L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{ListBase.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 2), this.__io__blockTable);
   }

   public void setEdbo(CPointer<ListBase> edbo) throws IOException {
      long __address = edbo == null ? 0L : edbo.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 160L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 120L, __address);
      }

   }

   public CPointer<Bone> getAct_bone() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 168L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 124L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Bone.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 342), this.__io__blockTable);
   }

   public void setAct_bone(CPointer<Bone> act_bone) throws IOException {
      long __address = act_bone == null ? 0L : act_bone.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 168L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 124L, __address);
      }

   }

   public CPointer<Object> getAct_edbone() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 176L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 128L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setAct_edbone(CPointer<Object> act_edbone) throws IOException {
      long __address = act_edbone == null ? 0L : act_edbone.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 176L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 128L, __address);
      }

   }

   public CPointer<Object> getSketch() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 184L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 132L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setSketch(CPointer<Object> sketch) throws IOException {
      long __address = sketch == null ? 0L : sketch.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 184L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 132L, __address);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 192L) : this.__io__block.readInt(this.__io__address + 136L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 192L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 136L, flag);
      }

   }

   public int getDrawtype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 196L) : this.__io__block.readInt(this.__io__address + 140L);
   }

   public void setDrawtype(int drawtype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 196L, drawtype);
      } else {
         this.__io__block.writeInt(this.__io__address + 140L, drawtype);
      }

   }

   public int getGevertdeformer() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 200L) : this.__io__block.readInt(this.__io__address + 144L);
   }

   public void setGevertdeformer(int gevertdeformer) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 200L, gevertdeformer);
      } else {
         this.__io__block.writeInt(this.__io__address + 144L, gevertdeformer);
      }

   }

   public int getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 204L) : this.__io__block.readInt(this.__io__address + 148L);
   }

   public void setPad(int pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 204L, pad);
      } else {
         this.__io__block.writeInt(this.__io__address + 148L, pad);
      }

   }

   public short getDeformflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 208L) : this.__io__block.readShort(this.__io__address + 152L);
   }

   public void setDeformflag(short deformflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 208L, deformflag);
      } else {
         this.__io__block.writeShort(this.__io__address + 152L, deformflag);
      }

   }

   public short getPathflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 210L) : this.__io__block.readShort(this.__io__address + 154L);
   }

   public void setPathflag(short pathflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 210L, pathflag);
      } else {
         this.__io__block.writeShort(this.__io__address + 154L, pathflag);
      }

   }

   public int getLayer_used() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 212L) : this.__io__block.readInt(this.__io__address + 156L);
   }

   public void setLayer_used(int layer_used) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 212L, layer_used);
      } else {
         this.__io__block.writeInt(this.__io__address + 156L, layer_used);
      }

   }

   public int getLayer() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 216L) : this.__io__block.readInt(this.__io__address + 160L);
   }

   public void setLayer(int layer) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 216L, layer);
      } else {
         this.__io__block.writeInt(this.__io__address + 160L, layer);
      }

   }

   public int getLayer_protected() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 220L) : this.__io__block.readInt(this.__io__address + 164L);
   }

   public void setLayer_protected(int layer_protected) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 220L, layer_protected);
      } else {
         this.__io__block.writeInt(this.__io__address + 164L, layer_protected);
      }

   }

   public short getGhostep() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 224L) : this.__io__block.readShort(this.__io__address + 168L);
   }

   public void setGhostep(short ghostep) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 224L, ghostep);
      } else {
         this.__io__block.writeShort(this.__io__address + 168L, ghostep);
      }

   }

   public short getGhostsize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 226L) : this.__io__block.readShort(this.__io__address + 170L);
   }

   public void setGhostsize(short ghostsize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 226L, ghostsize);
      } else {
         this.__io__block.writeShort(this.__io__address + 170L, ghostsize);
      }

   }

   public short getGhosttype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 228L) : this.__io__block.readShort(this.__io__address + 172L);
   }

   public void setGhosttype(short ghosttype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 228L, ghosttype);
      } else {
         this.__io__block.writeShort(this.__io__address + 172L, ghosttype);
      }

   }

   public short getPathsize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 230L) : this.__io__block.readShort(this.__io__address + 174L);
   }

   public void setPathsize(short pathsize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 230L, pathsize);
      } else {
         this.__io__block.writeShort(this.__io__address + 174L, pathsize);
      }

   }

   public int getGhostsf() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 232L) : this.__io__block.readInt(this.__io__address + 176L);
   }

   public void setGhostsf(int ghostsf) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 232L, ghostsf);
      } else {
         this.__io__block.writeInt(this.__io__address + 176L, ghostsf);
      }

   }

   public int getGhostef() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 236L) : this.__io__block.readInt(this.__io__address + 180L);
   }

   public void setGhostef(int ghostef) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 236L, ghostef);
      } else {
         this.__io__block.writeInt(this.__io__address + 180L, ghostef);
      }

   }

   public int getPathsf() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 240L) : this.__io__block.readInt(this.__io__address + 184L);
   }

   public void setPathsf(int pathsf) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 240L, pathsf);
      } else {
         this.__io__block.writeInt(this.__io__address + 184L, pathsf);
      }

   }

   public int getPathef() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 244L) : this.__io__block.readInt(this.__io__address + 188L);
   }

   public void setPathef(int pathef) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 244L, pathef);
      } else {
         this.__io__block.writeInt(this.__io__address + 188L, pathef);
      }

   }

   public int getPathbc() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 248L) : this.__io__block.readInt(this.__io__address + 192L);
   }

   public void setPathbc(int pathbc) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 248L, pathbc);
      } else {
         this.__io__block.writeInt(this.__io__address + 192L, pathbc);
      }

   }

   public int getPathac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 252L) : this.__io__block.readInt(this.__io__address + 196L);
   }

   public void setPathac(int pathac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 252L, pathac);
      } else {
         this.__io__block.writeInt(this.__io__address + 196L, pathac);
      }

   }

   public CPointer<bArmature> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{bArmature.class}, this.__io__block, this.__io__blockTable);
   }
}
