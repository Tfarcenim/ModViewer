package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 12L,
   size64 = 16L
)
public class EditLatt extends CFacade {
   public static final int __DNA__SDNA_INDEX = 148;
   public static final long[] __DNA__FIELD__latt = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__shapenr = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__pad = new long[]{8L, 12L};

   public EditLatt(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected EditLatt(EditLatt that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<Lattice> getLatt() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Lattice.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 149), this.__io__blockTable);
   }

   public void setLatt(CPointer<Lattice> latt) throws IOException {
      long __address = latt == null ? 0L : latt.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public int getShapenr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 8L) : this.__io__block.readInt(this.__io__address + 4L);
   }

   public void setShapenr(int shapenr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 8L, shapenr);
      } else {
         this.__io__block.writeInt(this.__io__address + 4L, shapenr);
      }

   }

   public CArrayFacade<Byte> getPad() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 12L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad(CArrayFacade<Byte> pad) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 12L;
      } else {
         __dna__offset = 8L;
      }

      if (!this.__io__equals(pad, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad);
         } else {
            __io__generic__copy(this.getPad(), pad);
         }

      }
   }

   public CPointer<EditLatt> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{EditLatt.class}, this.__io__block, this.__io__blockTable);
   }
}
