package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 104L,
   size64 = 120L
)
public class bActionGroup extends CFacade {
   public static final int __DNA__SDNA_INDEX = 351;
   public static final long[] __DNA__FIELD__next = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__prev = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__channels = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__flag = new long[]{16L, 32L};
   public static final long[] __DNA__FIELD__customCol = new long[]{20L, 36L};
   public static final long[] __DNA__FIELD__name = new long[]{24L, 40L};
   public static final long[] __DNA__FIELD__cs = new long[]{88L, 104L};

   public bActionGroup(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected bActionGroup(bActionGroup that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<bActionGroup> getNext() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bActionGroup.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 351), this.__io__blockTable);
   }

   public void setNext(CPointer<bActionGroup> next) throws IOException {
      long __address = next == null ? 0L : next.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<bActionGroup> getPrev() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bActionGroup.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 351), this.__io__blockTable);
   }

   public void setPrev(CPointer<bActionGroup> prev) throws IOException {
      long __address = prev == null ? 0L : prev.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public ListBase getChannels() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 16L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 8L, this.__io__block, this.__io__blockTable);
   }

   public void setChannels(ListBase channels) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 16L;
      } else {
         __dna__offset = 8L;
      }

      if (!this.__io__equals(channels, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, channels)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, channels);
         } else {
            __io__generic__copy(this.getChannels(), channels);
         }

      }
   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 32L) : this.__io__block.readInt(this.__io__address + 16L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 32L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 16L, flag);
      }

   }

   public int getCustomCol() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 36L) : this.__io__block.readInt(this.__io__address + 20L);
   }

   public void setCustomCol(int customCol) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 36L, customCol);
      } else {
         this.__io__block.writeInt(this.__io__address + 20L, customCol);
      }

   }

   public CArrayFacade<Byte> getName() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 40L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 24L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setName(CArrayFacade<Byte> name) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 40L;
      } else {
         __dna__offset = 24L;
      }

      if (!this.__io__equals(name, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, name)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, name);
         } else {
            __io__generic__copy(this.getName(), name);
         }

      }
   }

   public ThemeWireColor getCs() throws IOException {
      return this.__io__pointersize == 8 ? new ThemeWireColor(this.__io__address + 104L, this.__io__block, this.__io__blockTable) : new ThemeWireColor(this.__io__address + 88L, this.__io__block, this.__io__blockTable);
   }

   public void setCs(ThemeWireColor cs) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 104L;
      } else {
         __dna__offset = 88L;
      }

      if (!this.__io__equals(cs, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, cs)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, cs);
         } else {
            __io__generic__copy(this.getCs(), cs);
         }

      }
   }

   public CPointer<bActionGroup> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{bActionGroup.class}, this.__io__block, this.__io__blockTable);
   }
}
