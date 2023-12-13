package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 1360L,
   size64 = 1368L
)
public class BakeData extends CFacade {
   public static final int __DNA__SDNA_INDEX = 177;
   public static final long[] __DNA__FIELD__im_format = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__filepath = new long[]{248L, 256L};
   public static final long[] __DNA__FIELD__width = new long[]{1272L, 1280L};
   public static final long[] __DNA__FIELD__height = new long[]{1274L, 1282L};
   public static final long[] __DNA__FIELD__margin = new long[]{1276L, 1284L};
   public static final long[] __DNA__FIELD__flag = new long[]{1278L, 1286L};
   public static final long[] __DNA__FIELD__cage_extrusion = new long[]{1280L, 1288L};
   public static final long[] __DNA__FIELD__pass_filter = new long[]{1284L, 1292L};
   public static final long[] __DNA__FIELD__normal_swizzle = new long[]{1288L, 1296L};
   public static final long[] __DNA__FIELD__normal_space = new long[]{1291L, 1299L};
   public static final long[] __DNA__FIELD__save_mode = new long[]{1292L, 1300L};
   public static final long[] __DNA__FIELD__pad = new long[]{1293L, 1301L};
   public static final long[] __DNA__FIELD__cage = new long[]{1296L, 1304L};

   public BakeData(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected BakeData(BakeData that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public ImageFormatData getIm_format() throws IOException {
      return this.__io__pointersize == 8 ? new ImageFormatData(this.__io__address + 0L, this.__io__block, this.__io__blockTable) : new ImageFormatData(this.__io__address + 0L, this.__io__block, this.__io__blockTable);
   }

   public void setIm_format(ImageFormatData im_format) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(im_format, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, im_format)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, im_format);
         } else {
            __io__generic__copy(this.getIm_format(), im_format);
         }

      }
   }

   public CArrayFacade<Byte> getFilepath() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{1024};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 256L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 248L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setFilepath(CArrayFacade<Byte> filepath) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 256L;
      } else {
         __dna__offset = 248L;
      }

      if (!this.__io__equals(filepath, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, filepath)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, filepath);
         } else {
            __io__generic__copy(this.getFilepath(), filepath);
         }

      }
   }

   public short getWidth() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1280L) : this.__io__block.readShort(this.__io__address + 1272L);
   }

   public void setWidth(short width) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1280L, width);
      } else {
         this.__io__block.writeShort(this.__io__address + 1272L, width);
      }

   }

   public short getHeight() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1282L) : this.__io__block.readShort(this.__io__address + 1274L);
   }

   public void setHeight(short height) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1282L, height);
      } else {
         this.__io__block.writeShort(this.__io__address + 1274L, height);
      }

   }

   public short getMargin() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1284L) : this.__io__block.readShort(this.__io__address + 1276L);
   }

   public void setMargin(short margin) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1284L, margin);
      } else {
         this.__io__block.writeShort(this.__io__address + 1276L, margin);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1286L) : this.__io__block.readShort(this.__io__address + 1278L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1286L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 1278L, flag);
      }

   }

   public float getCage_extrusion() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1288L) : this.__io__block.readFloat(this.__io__address + 1280L);
   }

   public void setCage_extrusion(float cage_extrusion) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1288L, cage_extrusion);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1280L, cage_extrusion);
      }

   }

   public int getPass_filter() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1292L) : this.__io__block.readInt(this.__io__address + 1284L);
   }

   public void setPass_filter(int pass_filter) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1292L, pass_filter);
      } else {
         this.__io__block.writeInt(this.__io__address + 1284L, pass_filter);
      }

   }

   public CArrayFacade<Byte> getNormal_swizzle() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1296L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1288L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setNormal_swizzle(CArrayFacade<Byte> normal_swizzle) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1296L;
      } else {
         __dna__offset = 1288L;
      }

      if (!this.__io__equals(normal_swizzle, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, normal_swizzle)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, normal_swizzle);
         } else {
            __io__generic__copy(this.getNormal_swizzle(), normal_swizzle);
         }

      }
   }

   public byte getNormal_space() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1299L) : this.__io__block.readByte(this.__io__address + 1291L);
   }

   public void setNormal_space(byte normal_space) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1299L, normal_space);
      } else {
         this.__io__block.writeByte(this.__io__address + 1291L, normal_space);
      }

   }

   public byte getSave_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1300L) : this.__io__block.readByte(this.__io__address + 1292L);
   }

   public void setSave_mode(byte save_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1300L, save_mode);
      } else {
         this.__io__block.writeByte(this.__io__address + 1292L, save_mode);
      }

   }

   public CArrayFacade<Byte> getPad() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1301L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1293L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad(CArrayFacade<Byte> pad) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1301L;
      } else {
         __dna__offset = 1293L;
      }

      if (!this.__io__equals(pad, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad);
         } else {
            __io__generic__copy(this.getPad(), pad);
         }

      }
   }

   public CArrayFacade<Byte> getCage() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1304L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1296L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setCage(CArrayFacade<Byte> cage) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1304L;
      } else {
         __dna__offset = 1296L;
      }

      if (!this.__io__equals(cage, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, cage)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, cage);
         } else {
            __io__generic__copy(this.getCage(), cage);
         }

      }
   }

   public CPointer<BakeData> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{BakeData.class}, this.__io__block, this.__io__blockTable);
   }
}
