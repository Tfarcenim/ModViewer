package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 76L,
   size64 = 112L
)
public class FCurve extends CFacade {
   public static final int __DNA__SDNA_INDEX = 520;
   public static final long[] __DNA__FIELD__next = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__prev = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__grp = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__driver = new long[]{12L, 24L};
   public static final long[] __DNA__FIELD__modifiers = new long[]{16L, 32L};
   public static final long[] __DNA__FIELD__bezt = new long[]{24L, 48L};
   public static final long[] __DNA__FIELD__fpt = new long[]{28L, 56L};
   public static final long[] __DNA__FIELD__totvert = new long[]{32L, 64L};
   public static final long[] __DNA__FIELD__curval = new long[]{36L, 68L};
   public static final long[] __DNA__FIELD__flag = new long[]{40L, 72L};
   public static final long[] __DNA__FIELD__extend = new long[]{42L, 74L};
   public static final long[] __DNA__FIELD__array_index = new long[]{44L, 76L};
   public static final long[] __DNA__FIELD__rna_path = new long[]{48L, 80L};
   public static final long[] __DNA__FIELD__color_mode = new long[]{52L, 88L};
   public static final long[] __DNA__FIELD__color = new long[]{56L, 92L};
   public static final long[] __DNA__FIELD__prev_norm_factor = new long[]{68L, 104L};
   public static final long[] __DNA__FIELD__prev_offset = new long[]{72L, 108L};

   public FCurve(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected FCurve(FCurve that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<FCurve> getNext() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{FCurve.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 520), this.__io__blockTable);
   }

   public void setNext(CPointer<FCurve> next) throws IOException {
      long __address = next == null ? 0L : next.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<FCurve> getPrev() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{FCurve.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 520), this.__io__blockTable);
   }

   public void setPrev(CPointer<FCurve> prev) throws IOException {
      long __address = prev == null ? 0L : prev.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public CPointer<bActionGroup> getGrp() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bActionGroup.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 351), this.__io__blockTable);
   }

   public void setGrp(CPointer<bActionGroup> grp) throws IOException {
      long __address = grp == null ? 0L : grp.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      }

   }

   public CPointer<ChannelDriver> getDriver() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 24L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 12L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{ChannelDriver.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 518), this.__io__blockTable);
   }

   public void setDriver(CPointer<ChannelDriver> driver) throws IOException {
      long __address = driver == null ? 0L : driver.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 24L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 12L, __address);
      }

   }

   public ListBase getModifiers() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 32L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 16L, this.__io__block, this.__io__blockTable);
   }

   public void setModifiers(ListBase modifiers) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 32L;
      } else {
         __dna__offset = 16L;
      }

      if (!this.__io__equals(modifiers, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, modifiers)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, modifiers);
         } else {
            __io__generic__copy(this.getModifiers(), modifiers);
         }

      }
   }

   public CPointer<BezTriple> getBezt() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 48L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 24L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BezTriple.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 50), this.__io__blockTable);
   }

   public void setBezt(CPointer<BezTriple> bezt) throws IOException {
      long __address = bezt == null ? 0L : bezt.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 48L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 24L, __address);
      }

   }

   public CPointer<FPoint> getFpt() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 56L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 28L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{FPoint.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 519), this.__io__blockTable);
   }

   public void setFpt(CPointer<FPoint> fpt) throws IOException {
      long __address = fpt == null ? 0L : fpt.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 56L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 28L, __address);
      }

   }

   public int getTotvert() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 64L) : this.__io__block.readInt(this.__io__address + 32L);
   }

   public void setTotvert(int totvert) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 64L, totvert);
      } else {
         this.__io__block.writeInt(this.__io__address + 32L, totvert);
      }

   }

   public float getCurval() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 68L) : this.__io__block.readFloat(this.__io__address + 36L);
   }

   public void setCurval(float curval) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 68L, curval);
      } else {
         this.__io__block.writeFloat(this.__io__address + 36L, curval);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 72L) : this.__io__block.readShort(this.__io__address + 40L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 72L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 40L, flag);
      }

   }

   public short getExtend() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 74L) : this.__io__block.readShort(this.__io__address + 42L);
   }

   public void setExtend(short extend) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 74L, extend);
      } else {
         this.__io__block.writeShort(this.__io__address + 42L, extend);
      }

   }

   public int getArray_index() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 76L) : this.__io__block.readInt(this.__io__address + 44L);
   }

   public void setArray_index(int array_index) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 76L, array_index);
      } else {
         this.__io__block.writeInt(this.__io__address + 44L, array_index);
      }

   }

   public CPointer<Byte> getRna_path() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 80L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 48L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, __dna__targetTypes), this.__io__blockTable);
   }

   public void setRna_path(CPointer<Byte> rna_path) throws IOException {
      long __address = rna_path == null ? 0L : rna_path.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 80L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 48L, __address);
      }

   }

   public int getColor_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 88L) : this.__io__block.readInt(this.__io__address + 52L);
   }

   public void setColor_mode(int color_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 88L, color_mode);
      } else {
         this.__io__block.writeInt(this.__io__address + 52L, color_mode);
      }

   }

   public CArrayFacade<Float> getColor() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 92L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 56L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setColor(CArrayFacade<Float> color) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 92L;
      } else {
         __dna__offset = 56L;
      }

      if (!this.__io__equals(color, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, color)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, color);
         } else {
            __io__generic__copy(this.getColor(), color);
         }

      }
   }

   public float getPrev_norm_factor() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 104L) : this.__io__block.readFloat(this.__io__address + 68L);
   }

   public void setPrev_norm_factor(float prev_norm_factor) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 104L, prev_norm_factor);
      } else {
         this.__io__block.writeFloat(this.__io__address + 68L, prev_norm_factor);
      }

   }

   public float getPrev_offset() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 108L) : this.__io__block.readFloat(this.__io__address + 72L);
   }

   public void setPrev_offset(float prev_offset) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 108L, prev_offset);
      } else {
         this.__io__block.writeFloat(this.__io__address + 72L, prev_offset);
      }

   }

   public CPointer<FCurve> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{FCurve.class}, this.__io__block, this.__io__blockTable);
   }
}
