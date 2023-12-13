package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 60L,
   size64 = 72L
)
public class CurveMap extends CFacade {
   public static final int __DNA__SDNA_INDEX = 460;
   public static final long[] __DNA__FIELD__totpoint = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__flag = new long[]{2L, 2L};
   public static final long[] __DNA__FIELD__range = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__mintable = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__maxtable = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__ext_in = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__ext_out = new long[]{24L, 24L};
   public static final long[] __DNA__FIELD__curve = new long[]{32L, 32L};
   public static final long[] __DNA__FIELD__table = new long[]{36L, 40L};
   public static final long[] __DNA__FIELD__premultable = new long[]{40L, 48L};
   public static final long[] __DNA__FIELD__premul_ext_in = new long[]{44L, 56L};
   public static final long[] __DNA__FIELD__premul_ext_out = new long[]{52L, 64L};

   public CurveMap(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected CurveMap(CurveMap that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public short getTotpoint() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 0L) : this.__io__block.readShort(this.__io__address + 0L);
   }

   public void setTotpoint(short totpoint) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 0L, totpoint);
      } else {
         this.__io__block.writeShort(this.__io__address + 0L, totpoint);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 2L) : this.__io__block.readShort(this.__io__address + 2L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 2L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 2L, flag);
      }

   }

   public float getRange() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 4L) : this.__io__block.readFloat(this.__io__address + 4L);
   }

   public void setRange(float range) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 4L, range);
      } else {
         this.__io__block.writeFloat(this.__io__address + 4L, range);
      }

   }

   public float getMintable() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 8L) : this.__io__block.readFloat(this.__io__address + 8L);
   }

   public void setMintable(float mintable) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 8L, mintable);
      } else {
         this.__io__block.writeFloat(this.__io__address + 8L, mintable);
      }

   }

   public float getMaxtable() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 12L) : this.__io__block.readFloat(this.__io__address + 12L);
   }

   public void setMaxtable(float maxtable) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 12L, maxtable);
      } else {
         this.__io__block.writeFloat(this.__io__address + 12L, maxtable);
      }

   }

   public CArrayFacade<Float> getExt_in() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 16L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 16L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setExt_in(CArrayFacade<Float> ext_in) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 16L;
      } else {
         __dna__offset = 16L;
      }

      if (!this.__io__equals(ext_in, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, ext_in)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, ext_in);
         } else {
            __io__generic__copy(this.getExt_in(), ext_in);
         }

      }
   }

   public CArrayFacade<Float> getExt_out() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 24L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 24L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setExt_out(CArrayFacade<Float> ext_out) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 24L;
      } else {
         __dna__offset = 24L;
      }

      if (!this.__io__equals(ext_out, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, ext_out)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, ext_out);
         } else {
            __io__generic__copy(this.getExt_out(), ext_out);
         }

      }
   }

   public CPointer<CurveMapPoint> getCurve() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 32L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 32L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{CurveMapPoint.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 459), this.__io__blockTable);
   }

   public void setCurve(CPointer<CurveMapPoint> curve) throws IOException {
      long __address = curve == null ? 0L : curve.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 32L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 32L, __address);
      }

   }

   public CPointer<CurveMapPoint> getTable() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 40L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 36L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{CurveMapPoint.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 459), this.__io__blockTable);
   }

   public void setTable(CPointer<CurveMapPoint> table) throws IOException {
      long __address = table == null ? 0L : table.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 40L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 36L, __address);
      }

   }

   public CPointer<CurveMapPoint> getPremultable() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 48L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 40L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{CurveMapPoint.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 459), this.__io__blockTable);
   }

   public void setPremultable(CPointer<CurveMapPoint> premultable) throws IOException {
      long __address = premultable == null ? 0L : premultable.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 48L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 40L, __address);
      }

   }

   public CArrayFacade<Float> getPremul_ext_in() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 56L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 44L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPremul_ext_in(CArrayFacade<Float> premul_ext_in) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 56L;
      } else {
         __dna__offset = 44L;
      }

      if (!this.__io__equals(premul_ext_in, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, premul_ext_in)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, premul_ext_in);
         } else {
            __io__generic__copy(this.getPremul_ext_in(), premul_ext_in);
         }

      }
   }

   public CArrayFacade<Float> getPremul_ext_out() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 64L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 52L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPremul_ext_out(CArrayFacade<Float> premul_ext_out) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 64L;
      } else {
         __dna__offset = 52L;
      }

      if (!this.__io__equals(premul_ext_out, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, premul_ext_out)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, premul_ext_out);
         } else {
            __io__generic__copy(this.getPremul_ext_out(), premul_ext_out);
         }

      }
   }

   public CPointer<CurveMap> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{CurveMap.class}, this.__io__block, this.__io__blockTable);
   }
}
