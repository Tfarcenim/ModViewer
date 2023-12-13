package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 876L,
   size64 = 904L
)
public class Strip extends CFacade {
   public static final int __DNA__SDNA_INDEX = 271;
   public static final long[] __DNA__FIELD__next = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__prev = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__us = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__done = new long[]{12L, 20L};
   public static final long[] __DNA__FIELD__startstill = new long[]{16L, 24L};
   public static final long[] __DNA__FIELD__endstill = new long[]{20L, 28L};
   public static final long[] __DNA__FIELD__stripdata = new long[]{24L, 32L};
   public static final long[] __DNA__FIELD__dir = new long[]{28L, 40L};
   public static final long[] __DNA__FIELD__proxy = new long[]{796L, 808L};
   public static final long[] __DNA__FIELD__crop = new long[]{800L, 816L};
   public static final long[] __DNA__FIELD__transform = new long[]{804L, 824L};
   public static final long[] __DNA__FIELD__color_balance = new long[]{808L, 832L};
   public static final long[] __DNA__FIELD__colorspace_settings = new long[]{812L, 840L};

   public Strip(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Strip(Strip that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<Strip> getNext() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Strip.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 271), this.__io__blockTable);
   }

   public void setNext(CPointer<Strip> next) throws IOException {
      long __address = next == null ? 0L : next.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<Strip> getPrev() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Strip.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 271), this.__io__blockTable);
   }

   public void setPrev(CPointer<Strip> prev) throws IOException {
      long __address = prev == null ? 0L : prev.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public int getUs() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 16L) : this.__io__block.readInt(this.__io__address + 8L);
   }

   public void setUs(int us) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 16L, us);
      } else {
         this.__io__block.writeInt(this.__io__address + 8L, us);
      }

   }

   public int getDone() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 20L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setDone(int done) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 20L, done);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, done);
      }

   }

   public int getStartstill() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 24L) : this.__io__block.readInt(this.__io__address + 16L);
   }

   public void setStartstill(int startstill) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 24L, startstill);
      } else {
         this.__io__block.writeInt(this.__io__address + 16L, startstill);
      }

   }

   public int getEndstill() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 28L) : this.__io__block.readInt(this.__io__address + 20L);
   }

   public void setEndstill(int endstill) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 28L, endstill);
      } else {
         this.__io__block.writeInt(this.__io__address + 20L, endstill);
      }

   }

   public CPointer<StripElem> getStripdata() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 32L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 24L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{StripElem.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 266), this.__io__blockTable);
   }

   public void setStripdata(CPointer<StripElem> stripdata) throws IOException {
      long __address = stripdata == null ? 0L : stripdata.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 32L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 24L, __address);
      }

   }

   public CArrayFacade<Byte> getDir() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{768};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 40L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 28L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setDir(CArrayFacade<Byte> dir) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 40L;
      } else {
         __dna__offset = 28L;
      }

      if (!this.__io__equals(dir, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, dir)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, dir);
         } else {
            __io__generic__copy(this.getDir(), dir);
         }

      }
   }

   public CPointer<StripProxy> getProxy() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 808L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 796L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{StripProxy.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 270), this.__io__blockTable);
   }

   public void setProxy(CPointer<StripProxy> proxy) throws IOException {
      long __address = proxy == null ? 0L : proxy.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 808L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 796L, __address);
      }

   }

   public CPointer<StripCrop> getCrop() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 816L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 800L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{StripCrop.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 267), this.__io__blockTable);
   }

   public void setCrop(CPointer<StripCrop> crop) throws IOException {
      long __address = crop == null ? 0L : crop.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 816L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 800L, __address);
      }

   }

   public CPointer<StripTransform> getTransform() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 824L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 804L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{StripTransform.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 268), this.__io__blockTable);
   }

   public void setTransform(CPointer<StripTransform> transform) throws IOException {
      long __address = transform == null ? 0L : transform.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 824L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 804L, __address);
      }

   }

   public CPointer<StripColorBalance> getColor_balance() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 832L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 808L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{StripColorBalance.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 269), this.__io__blockTable);
   }

   public void setColor_balance(CPointer<StripColorBalance> color_balance) throws IOException {
      long __address = color_balance == null ? 0L : color_balance.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 832L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 808L, __address);
      }

   }

   public ColorManagedColorspaceSettings getColorspace_settings() throws IOException {
      return this.__io__pointersize == 8 ? new ColorManagedColorspaceSettings(this.__io__address + 840L, this.__io__block, this.__io__blockTable) : new ColorManagedColorspaceSettings(this.__io__address + 812L, this.__io__block, this.__io__blockTable);
   }

   public void setColorspace_settings(ColorManagedColorspaceSettings colorspace_settings) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 840L;
      } else {
         __dna__offset = 812L;
      }

      if (!this.__io__equals(colorspace_settings, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, colorspace_settings)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, colorspace_settings);
         } else {
            __io__generic__copy(this.getColorspace_settings(), colorspace_settings);
         }

      }
   }

   public CPointer<Strip> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Strip.class}, this.__io__block, this.__io__blockTable);
   }
}
