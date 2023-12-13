package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 12L,
   size64 = 12L
)
public class MPoly extends CFacade {
   public static final int __DNA__SDNA_INDEX = 65;
   public static final long[] __DNA__FIELD__loopstart = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__totloop = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__mat_nr = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__flag = new long[]{10L, 10L};
   public static final long[] __DNA__FIELD__pad = new long[]{11L, 11L};

   public MPoly(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MPoly(MPoly that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public int getLoopstart() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 0L) : this.__io__block.readInt(this.__io__address + 0L);
   }

   public void setLoopstart(int loopstart) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 0L, loopstart);
      } else {
         this.__io__block.writeInt(this.__io__address + 0L, loopstart);
      }

   }

   public int getTotloop() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 4L) : this.__io__block.readInt(this.__io__address + 4L);
   }

   public void setTotloop(int totloop) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 4L, totloop);
      } else {
         this.__io__block.writeInt(this.__io__address + 4L, totloop);
      }

   }

   public short getMat_nr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 8L) : this.__io__block.readShort(this.__io__address + 8L);
   }

   public void setMat_nr(short mat_nr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 8L, mat_nr);
      } else {
         this.__io__block.writeShort(this.__io__address + 8L, mat_nr);
      }

   }

   public byte getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 10L) : this.__io__block.readByte(this.__io__address + 10L);
   }

   public void setFlag(byte flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 10L, flag);
      } else {
         this.__io__block.writeByte(this.__io__address + 10L, flag);
      }

   }

   public byte getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 11L) : this.__io__block.readByte(this.__io__address + 11L);
   }

   public void setPad(byte pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 11L, pad);
      } else {
         this.__io__block.writeByte(this.__io__address + 11L, pad);
      }

   }

   public CPointer<MPoly> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MPoly.class}, this.__io__block, this.__io__blockTable);
   }
}
