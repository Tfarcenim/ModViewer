package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 20L,
   size64 = 40L
)
public class AnimMapper extends CFacade {
   public static final int __DNA__SDNA_INDEX = 522;
   public static final long[] __DNA__FIELD__next = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__prev = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__target = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__mappings = new long[]{12L, 24L};

   public AnimMapper(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected AnimMapper(AnimMapper that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<AnimMapper> getNext() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{AnimMapper.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 522), this.__io__blockTable);
   }

   public void setNext(CPointer<AnimMapper> next) throws IOException {
      long __address = next == null ? 0L : next.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<AnimMapper> getPrev() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{AnimMapper.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 522), this.__io__blockTable);
   }

   public void setPrev(CPointer<AnimMapper> prev) throws IOException {
      long __address = prev == null ? 0L : prev.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public CPointer<bAction> getTarget() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bAction.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 352), this.__io__blockTable);
   }

   public void setTarget(CPointer<bAction> target) throws IOException {
      long __address = target == null ? 0L : target.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      }

   }

   public ListBase getMappings() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 24L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 12L, this.__io__block, this.__io__blockTable);
   }

   public void setMappings(ListBase mappings) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 24L;
      } else {
         __dna__offset = 12L;
      }

      if (!this.__io__equals(mappings, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, mappings)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, mappings);
         } else {
            __io__generic__copy(this.getMappings(), mappings);
         }

      }
   }

   public CPointer<AnimMapper> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{AnimMapper.class}, this.__io__block, this.__io__blockTable);
   }
}
