package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 28L,
   size64 = 40L
)
public class ReportList extends CFacade {
   public static final int __DNA__SDNA_INDEX = 498;
   public static final long[] __DNA__FIELD__list = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__printlevel = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__storelevel = new long[]{12L, 20L};
   public static final long[] __DNA__FIELD__flag = new long[]{16L, 24L};
   public static final long[] __DNA__FIELD__pad = new long[]{20L, 28L};
   public static final long[] __DNA__FIELD__reporttimer = new long[]{24L, 32L};

   public ReportList(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected ReportList(ReportList that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public ListBase getList() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 0L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 0L, this.__io__block, this.__io__blockTable);
   }

   public void setList(ListBase list) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(list, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, list)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, list);
         } else {
            __io__generic__copy(this.getList(), list);
         }

      }
   }

   public int getPrintlevel() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 16L) : this.__io__block.readInt(this.__io__address + 8L);
   }

   public void setPrintlevel(int printlevel) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 16L, printlevel);
      } else {
         this.__io__block.writeInt(this.__io__address + 8L, printlevel);
      }

   }

   public int getStorelevel() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 20L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setStorelevel(int storelevel) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 20L, storelevel);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, storelevel);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 24L) : this.__io__block.readInt(this.__io__address + 16L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 24L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 16L, flag);
      }

   }

   public int getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 28L) : this.__io__block.readInt(this.__io__address + 20L);
   }

   public void setPad(int pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 28L, pad);
      } else {
         this.__io__block.writeInt(this.__io__address + 20L, pad);
      }

   }

   public CPointer<Object> getReporttimer() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 32L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 24L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setReporttimer(CPointer<Object> reporttimer) throws IOException {
      long __address = reporttimer == null ? 0L : reporttimer.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 32L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 24L, __address);
      }

   }

   public CPointer<ReportList> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{ReportList.class}, this.__io__block, this.__io__blockTable);
   }
}
