package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 76L,
   size64 = 80L
)
public class OceanTex extends CFacade {
   public static final int __DNA__SDNA_INDEX = 38;
   public static final long[] __DNA__FIELD__object = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__oceanmod = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__output = new long[]{68L, 72L};
   public static final long[] __DNA__FIELD__pad = new long[]{72L, 76L};

   public OceanTex(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected OceanTex(OceanTex that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<BlenderObject> getObject() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setObject(CPointer<BlenderObject> object) throws IOException {
      long __address = object == null ? 0L : object.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CArrayFacade<Byte> getOceanmod() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 4L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setOceanmod(CArrayFacade<Byte> oceanmod) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 8L;
      } else {
         __dna__offset = 4L;
      }

      if (!this.__io__equals(oceanmod, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, oceanmod)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, oceanmod);
         } else {
            __io__generic__copy(this.getOceanmod(), oceanmod);
         }

      }
   }

   public int getOutput() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 72L) : this.__io__block.readInt(this.__io__address + 68L);
   }

   public void setOutput(int output) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 72L, output);
      } else {
         this.__io__block.writeInt(this.__io__address + 68L, output);
      }

   }

   public int getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 76L) : this.__io__block.readInt(this.__io__address + 72L);
   }

   public void setPad(int pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 76L, pad);
      } else {
         this.__io__block.writeInt(this.__io__address + 72L, pad);
      }

   }

   public CPointer<OceanTex> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{OceanTex.class}, this.__io__block, this.__io__blockTable);
   }
}
