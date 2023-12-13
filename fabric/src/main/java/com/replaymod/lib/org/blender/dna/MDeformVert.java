package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 12L,
   size64 = 16L
)
public class MDeformVert extends CFacade {
   public static final int __DNA__SDNA_INDEX = 62;
   public static final long[] __DNA__FIELD__dw = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__totweight = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__flag = new long[]{8L, 12L};

   public MDeformVert(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MDeformVert(MDeformVert that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<MDeformWeight> getDw() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MDeformWeight.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 61), this.__io__blockTable);
   }

   public void setDw(CPointer<MDeformWeight> dw) throws IOException {
      long __address = dw == null ? 0L : dw.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public int getTotweight() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 8L) : this.__io__block.readInt(this.__io__address + 4L);
   }

   public void setTotweight(int totweight) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 8L, totweight);
      } else {
         this.__io__block.writeInt(this.__io__address + 4L, totweight);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 12L) : this.__io__block.readInt(this.__io__address + 8L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 12L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 8L, flag);
      }

   }

   public CPointer<MDeformVert> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MDeformVert.class}, this.__io__block, this.__io__blockTable);
   }
}
