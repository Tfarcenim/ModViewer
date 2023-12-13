package com.replaymod.lib.org.cakelab.blender.nio;

import java.io.IOException;

public class CPointerMutable<T> extends CPointer<T> {
   public CPointerMutable(CPointer<T> pointer) {
      super(pointer);
   }

   public CPointerMutable(CPointer<T> pointer, long address) {
      super(pointer, address);
   }

   public CPointerMutable<T> add(int increment) {
      this.__io__address += this.targetSize;
      return this;
   }

   public CPointerMutable<T> plus(int value) throws IOException {
      return new CPointerMutable(this, this.__io__address + this.targetSize);
   }

   public void assign(long address) throws IOException {
      this.__io__address = address;
      if (!this.isValid()) {
         this.__io__block = this.__io__blockTable.getBlock(address, -1);
      }

   }

   public void assign(CPointer<T> address) throws IOException {
      this.assign(address.__io__address);
   }

   public long value() {
      return this.__io__address;
   }
}
