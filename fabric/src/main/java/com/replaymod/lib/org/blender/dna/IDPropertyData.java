package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 20L,
   size64 = 32L
)
public class IDPropertyData extends CFacade {
   public static final int __DNA__SDNA_INDEX = 8;
   public static final long[] __DNA__FIELD__pointer = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__group = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__val = new long[]{12L, 24L};
   public static final long[] __DNA__FIELD__val2 = new long[]{16L, 28L};

   public IDPropertyData(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected IDPropertyData(IDPropertyData that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<Object> getPointer() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setPointer(CPointer<Object> pointer) throws IOException {
      long __address = pointer == null ? 0L : pointer.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public ListBase getGroup() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 8L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 4L, this.__io__block, this.__io__blockTable);
   }

   public void setGroup(ListBase group) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 8L;
      } else {
         __dna__offset = 4L;
      }

      if (!this.__io__equals(group, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, group)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, group);
         } else {
            __io__generic__copy(this.getGroup(), group);
         }

      }
   }

   public int getVal() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 24L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setVal(int val) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 24L, val);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, val);
      }

   }

   public int getVal2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 28L) : this.__io__block.readInt(this.__io__address + 16L);
   }

   public void setVal2(int val2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 28L, val2);
      } else {
         this.__io__block.writeInt(this.__io__address + 16L, val2);
      }

   }

   public CPointer<IDPropertyData> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{IDPropertyData.class}, this.__io__block, this.__io__blockTable);
   }
}
