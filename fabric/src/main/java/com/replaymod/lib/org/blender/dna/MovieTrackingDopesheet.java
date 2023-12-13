package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 32L,
   size64 = 48L
)
public class MovieTrackingDopesheet extends CFacade {
   public static final int __DNA__SDNA_INDEX = 560;
   public static final long[] __DNA__FIELD__ok = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__sort_method = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__flag = new long[]{6L, 6L};
   public static final long[] __DNA__FIELD__coverage_segments = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__channels = new long[]{16L, 24L};
   public static final long[] __DNA__FIELD__tot_channel = new long[]{24L, 40L};
   public static final long[] __DNA__FIELD__pad = new long[]{28L, 44L};

   public MovieTrackingDopesheet(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MovieTrackingDopesheet(MovieTrackingDopesheet that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public int getOk() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 0L) : this.__io__block.readInt(this.__io__address + 0L);
   }

   public void setOk(int ok) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 0L, ok);
      } else {
         this.__io__block.writeInt(this.__io__address + 0L, ok);
      }

   }

   public short getSort_method() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 4L) : this.__io__block.readShort(this.__io__address + 4L);
   }

   public void setSort_method(short sort_method) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 4L, sort_method);
      } else {
         this.__io__block.writeShort(this.__io__address + 4L, sort_method);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 6L) : this.__io__block.readShort(this.__io__address + 6L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 6L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 6L, flag);
      }

   }

   public ListBase getCoverage_segments() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 8L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 8L, this.__io__block, this.__io__blockTable);
   }

   public void setCoverage_segments(ListBase coverage_segments) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 8L;
      } else {
         __dna__offset = 8L;
      }

      if (!this.__io__equals(coverage_segments, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, coverage_segments)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, coverage_segments);
         } else {
            __io__generic__copy(this.getCoverage_segments(), coverage_segments);
         }

      }
   }

   public ListBase getChannels() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 24L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 16L, this.__io__block, this.__io__blockTable);
   }

   public void setChannels(ListBase channels) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 24L;
      } else {
         __dna__offset = 16L;
      }

      if (!this.__io__equals(channels, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, channels)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, channels);
         } else {
            __io__generic__copy(this.getChannels(), channels);
         }

      }
   }

   public int getTot_channel() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 40L) : this.__io__block.readInt(this.__io__address + 24L);
   }

   public void setTot_channel(int tot_channel) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 40L, tot_channel);
      } else {
         this.__io__block.writeInt(this.__io__address + 24L, tot_channel);
      }

   }

   public int getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 44L) : this.__io__block.readInt(this.__io__address + 28L);
   }

   public void setPad(int pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 44L, pad);
      } else {
         this.__io__block.writeInt(this.__io__address + 28L, pad);
      }

   }

   public CPointer<MovieTrackingDopesheet> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MovieTrackingDopesheet.class}, this.__io__block, this.__io__blockTable);
   }
}
