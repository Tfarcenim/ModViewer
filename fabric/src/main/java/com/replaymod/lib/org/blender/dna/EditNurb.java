package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 20L,
   size64 = 32L
)
public class EditNurb extends CFacade {
   public static final int __DNA__SDNA_INDEX = 55;
   public static final long[] __DNA__FIELD__nurbs = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__keyindex = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__shapenr = new long[]{12L, 24L};
   public static final long[] __DNA__FIELD__pad = new long[]{16L, 28L};

   public EditNurb(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected EditNurb(EditNurb that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public ListBase getNurbs() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 0L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 0L, this.__io__block, this.__io__blockTable);
   }

   public void setNurbs(ListBase nurbs) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(nurbs, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, nurbs)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, nurbs);
         } else {
            __io__generic__copy(this.getNurbs(), nurbs);
         }

      }
   }

   public CPointer<Object> getKeyindex() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setKeyindex(CPointer<Object> keyindex) throws IOException {
      long __address = keyindex == null ? 0L : keyindex.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      }

   }

   public int getShapenr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 24L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setShapenr(int shapenr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 24L, shapenr);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, shapenr);
      }

   }

   public CArrayFacade<Byte> getPad() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 28L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 16L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad(CArrayFacade<Byte> pad) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 28L;
      } else {
         __dna__offset = 16L;
      }

      if (!this.__io__equals(pad, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad);
         } else {
            __io__generic__copy(this.getPad(), pad);
         }

      }
   }

   public CPointer<EditNurb> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{EditNurb.class}, this.__io__block, this.__io__blockTable);
   }
}
