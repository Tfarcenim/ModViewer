package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 8L,
   size64 = 8L
)
public class Stereo3dFormat extends CFacade {
   public static final int __DNA__SDNA_INDEX = 175;
   public static final long[] __DNA__FIELD__flag = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__display_mode = new long[]{2L, 2L};
   public static final long[] __DNA__FIELD__anaglyph_type = new long[]{3L, 3L};
   public static final long[] __DNA__FIELD__interlace_type = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__pad = new long[]{5L, 5L};

   public Stereo3dFormat(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Stereo3dFormat(Stereo3dFormat that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 0L) : this.__io__block.readShort(this.__io__address + 0L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 0L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 0L, flag);
      }

   }

   public byte getDisplay_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 2L) : this.__io__block.readByte(this.__io__address + 2L);
   }

   public void setDisplay_mode(byte display_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 2L, display_mode);
      } else {
         this.__io__block.writeByte(this.__io__address + 2L, display_mode);
      }

   }

   public byte getAnaglyph_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 3L) : this.__io__block.readByte(this.__io__address + 3L);
   }

   public void setAnaglyph_type(byte anaglyph_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 3L, anaglyph_type);
      } else {
         this.__io__block.writeByte(this.__io__address + 3L, anaglyph_type);
      }

   }

   public byte getInterlace_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 4L) : this.__io__block.readByte(this.__io__address + 4L);
   }

   public void setInterlace_type(byte interlace_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 4L, interlace_type);
      } else {
         this.__io__block.writeByte(this.__io__address + 4L, interlace_type);
      }

   }

   public CArrayFacade<Byte> getPad() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 5L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 5L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad(CArrayFacade<Byte> pad) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 5L;
      } else {
         __dna__offset = 5L;
      }

      if (!this.__io__equals(pad, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad);
         } else {
            __io__generic__copy(this.getPad(), pad);
         }

      }
   }

   public CPointer<Stereo3dFormat> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Stereo3dFormat.class}, this.__io__block, this.__io__blockTable);
   }
}
