package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 152L,
   size64 = 168L
)
public class wmKeyConfig extends CFacade {
   public static final int __DNA__SDNA_INDEX = 504;
   public static final long[] __DNA__FIELD__next = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__prev = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__idname = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__basename = new long[]{72L, 80L};
   public static final long[] __DNA__FIELD__keymaps = new long[]{136L, 144L};
   public static final long[] __DNA__FIELD__actkeymap = new long[]{144L, 160L};
   public static final long[] __DNA__FIELD__flag = new long[]{148L, 164L};

   public wmKeyConfig(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected wmKeyConfig(wmKeyConfig that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<wmKeyConfig> getNext() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{wmKeyConfig.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 504), this.__io__blockTable);
   }

   public void setNext(CPointer<wmKeyConfig> next) throws IOException {
      long __address = next == null ? 0L : next.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<wmKeyConfig> getPrev() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{wmKeyConfig.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 504), this.__io__blockTable);
   }

   public void setPrev(CPointer<wmKeyConfig> prev) throws IOException {
      long __address = prev == null ? 0L : prev.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public CArrayFacade<Byte> getIdname() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 16L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setIdname(CArrayFacade<Byte> idname) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 16L;
      } else {
         __dna__offset = 8L;
      }

      if (!this.__io__equals(idname, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, idname)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, idname);
         } else {
            __io__generic__copy(this.getIdname(), idname);
         }

      }
   }

   public CArrayFacade<Byte> getBasename() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 80L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 72L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setBasename(CArrayFacade<Byte> basename) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 80L;
      } else {
         __dna__offset = 72L;
      }

      if (!this.__io__equals(basename, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, basename)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, basename);
         } else {
            __io__generic__copy(this.getBasename(), basename);
         }

      }
   }

   public ListBase getKeymaps() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 144L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 136L, this.__io__block, this.__io__blockTable);
   }

   public void setKeymaps(ListBase keymaps) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 144L;
      } else {
         __dna__offset = 136L;
      }

      if (!this.__io__equals(keymaps, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, keymaps)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, keymaps);
         } else {
            __io__generic__copy(this.getKeymaps(), keymaps);
         }

      }
   }

   public int getActkeymap() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 160L) : this.__io__block.readInt(this.__io__address + 144L);
   }

   public void setActkeymap(int actkeymap) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 160L, actkeymap);
      } else {
         this.__io__block.writeInt(this.__io__address + 144L, actkeymap);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 164L) : this.__io__block.readInt(this.__io__address + 148L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 164L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 148L, flag);
      }

   }

   public CPointer<wmKeyConfig> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{wmKeyConfig.class}, this.__io__block, this.__io__blockTable);
   }
}
