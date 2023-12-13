package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 168L,
   size64 = 200L
)
public class EnvMap extends CFacade {
   public static final int __DNA__SDNA_INDEX = 35;
   public static final long[] __DNA__FIELD__object = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__ima = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__cube = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__imat = new long[]{32L, 64L};
   public static final long[] __DNA__FIELD__obimat = new long[]{96L, 128L};
   public static final long[] __DNA__FIELD__type = new long[]{132L, 164L};
   public static final long[] __DNA__FIELD__stype = new long[]{134L, 166L};
   public static final long[] __DNA__FIELD__clipsta = new long[]{136L, 168L};
   public static final long[] __DNA__FIELD__clipend = new long[]{140L, 172L};
   public static final long[] __DNA__FIELD__viewscale = new long[]{144L, 176L};
   public static final long[] __DNA__FIELD__notlay = new long[]{148L, 180L};
   public static final long[] __DNA__FIELD__cuberes = new long[]{152L, 184L};
   public static final long[] __DNA__FIELD__depth = new long[]{154L, 186L};
   public static final long[] __DNA__FIELD__ok = new long[]{156L, 188L};
   public static final long[] __DNA__FIELD__lastframe = new long[]{160L, 192L};
   public static final long[] __DNA__FIELD__recalc = new long[]{164L, 196L};
   public static final long[] __DNA__FIELD__lastsize = new long[]{166L, 198L};

   public EnvMap(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected EnvMap(EnvMap that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<BlenderObject> getObject() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setObject(CPointer<BlenderObject> object) throws IOException {
      long __address = object == null ? 0L : object.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<Image> getIma() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Image.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 31), this.__io__blockTable);
   }

   public void setIma(CPointer<Image> ima) throws IOException {
      long __address = ima == null ? 0L : ima.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public CArrayFacade<CPointer<Object>> getCube() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CPointer.class, Object.class};
      int[] __dna__dimensions = new int[]{6};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 16L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setCube(CArrayFacade<CPointer<Object>> cube) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 16L;
      } else {
         __dna__offset = 8L;
      }

      if (!this.__io__equals(cube, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, cube)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, cube);
         } else {
            __io__generic__copy(this.getCube(), cube);
         }

      }
   }

   public CArrayFacade<CArrayFacade<Float>> getImat() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CArrayFacade.class, Float.class};
      int[] __dna__dimensions = new int[]{4, 4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 64L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 32L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setImat(CArrayFacade<CArrayFacade<Float>> imat) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 64L;
      } else {
         __dna__offset = 32L;
      }

      if (!this.__io__equals(imat, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, imat)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, imat);
         } else {
            __io__generic__copy(this.getImat(), imat);
         }

      }
   }

   public CArrayFacade<CArrayFacade<Float>> getObimat() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CArrayFacade.class, Float.class};
      int[] __dna__dimensions = new int[]{3, 3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 128L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 96L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setObimat(CArrayFacade<CArrayFacade<Float>> obimat) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 128L;
      } else {
         __dna__offset = 96L;
      }

      if (!this.__io__equals(obimat, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, obimat)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, obimat);
         } else {
            __io__generic__copy(this.getObimat(), obimat);
         }

      }
   }

   public short getType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 164L) : this.__io__block.readShort(this.__io__address + 132L);
   }

   public void setType(short type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 164L, type);
      } else {
         this.__io__block.writeShort(this.__io__address + 132L, type);
      }

   }

   public short getStype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 166L) : this.__io__block.readShort(this.__io__address + 134L);
   }

   public void setStype(short stype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 166L, stype);
      } else {
         this.__io__block.writeShort(this.__io__address + 134L, stype);
      }

   }

   public float getClipsta() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 168L) : this.__io__block.readFloat(this.__io__address + 136L);
   }

   public void setClipsta(float clipsta) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 168L, clipsta);
      } else {
         this.__io__block.writeFloat(this.__io__address + 136L, clipsta);
      }

   }

   public float getClipend() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 172L) : this.__io__block.readFloat(this.__io__address + 140L);
   }

   public void setClipend(float clipend) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 172L, clipend);
      } else {
         this.__io__block.writeFloat(this.__io__address + 140L, clipend);
      }

   }

   public float getViewscale() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 176L) : this.__io__block.readFloat(this.__io__address + 144L);
   }

   public void setViewscale(float viewscale) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 176L, viewscale);
      } else {
         this.__io__block.writeFloat(this.__io__address + 144L, viewscale);
      }

   }

   public int getNotlay() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 180L) : this.__io__block.readInt(this.__io__address + 148L);
   }

   public void setNotlay(int notlay) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 180L, notlay);
      } else {
         this.__io__block.writeInt(this.__io__address + 148L, notlay);
      }

   }

   public short getCuberes() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 184L) : this.__io__block.readShort(this.__io__address + 152L);
   }

   public void setCuberes(short cuberes) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 184L, cuberes);
      } else {
         this.__io__block.writeShort(this.__io__address + 152L, cuberes);
      }

   }

   public short getDepth() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 186L) : this.__io__block.readShort(this.__io__address + 154L);
   }

   public void setDepth(short depth) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 186L, depth);
      } else {
         this.__io__block.writeShort(this.__io__address + 154L, depth);
      }

   }

   public int getOk() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 188L) : this.__io__block.readInt(this.__io__address + 156L);
   }

   public void setOk(int ok) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 188L, ok);
      } else {
         this.__io__block.writeInt(this.__io__address + 156L, ok);
      }

   }

   public int getLastframe() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 192L) : this.__io__block.readInt(this.__io__address + 160L);
   }

   public void setLastframe(int lastframe) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 192L, lastframe);
      } else {
         this.__io__block.writeInt(this.__io__address + 160L, lastframe);
      }

   }

   public short getRecalc() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 196L) : this.__io__block.readShort(this.__io__address + 164L);
   }

   public void setRecalc(short recalc) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 196L, recalc);
      } else {
         this.__io__block.writeShort(this.__io__address + 164L, recalc);
      }

   }

   public short getLastsize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 198L) : this.__io__block.readShort(this.__io__address + 166L);
   }

   public void setLastsize(short lastsize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 198L, lastsize);
      } else {
         this.__io__block.writeShort(this.__io__address + 166L, lastsize);
      }

   }

   public CPointer<EnvMap> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{EnvMap.class}, this.__io__block, this.__io__blockTable);
   }
}
