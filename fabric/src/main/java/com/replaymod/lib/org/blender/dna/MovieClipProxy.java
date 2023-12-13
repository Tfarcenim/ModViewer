package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 776L,
   size64 = 776L
)
public class MovieClipProxy extends CFacade {
   public static final int __DNA__SDNA_INDEX = 544;
   public static final long[] __DNA__FIELD__dir = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__tc = new long[]{768L, 768L};
   public static final long[] __DNA__FIELD__quality = new long[]{770L, 770L};
   public static final long[] __DNA__FIELD__build_size_flag = new long[]{772L, 772L};
   public static final long[] __DNA__FIELD__build_tc_flag = new long[]{774L, 774L};

   public MovieClipProxy(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MovieClipProxy(MovieClipProxy that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CArrayFacade<Byte> getDir() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{768};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 0L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setDir(CArrayFacade<Byte> dir) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(dir, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, dir)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, dir);
         } else {
            __io__generic__copy(this.getDir(), dir);
         }

      }
   }

   public short getTc() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 768L) : this.__io__block.readShort(this.__io__address + 768L);
   }

   public void setTc(short tc) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 768L, tc);
      } else {
         this.__io__block.writeShort(this.__io__address + 768L, tc);
      }

   }

   public short getQuality() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 770L) : this.__io__block.readShort(this.__io__address + 770L);
   }

   public void setQuality(short quality) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 770L, quality);
      } else {
         this.__io__block.writeShort(this.__io__address + 770L, quality);
      }

   }

   public short getBuild_size_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 772L) : this.__io__block.readShort(this.__io__address + 772L);
   }

   public void setBuild_size_flag(short build_size_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 772L, build_size_flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 772L, build_size_flag);
      }

   }

   public short getBuild_tc_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 774L) : this.__io__block.readShort(this.__io__address + 774L);
   }

   public void setBuild_tc_flag(short build_tc_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 774L, build_tc_flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 774L, build_tc_flag);
      }

   }

   public CPointer<MovieClipProxy> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MovieClipProxy.class}, this.__io__block, this.__io__blockTable);
   }
}
