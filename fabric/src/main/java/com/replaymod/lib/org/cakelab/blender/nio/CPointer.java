package com.replaymod.lib.org.cakelab.blender.nio;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class CPointer<T> extends CFacade {
   protected Class<?>[] targetTypeList;
   protected long targetSize;
   private Constructor<T> constructor;

   CPointer(CPointer<T> other, long targetAddress) {
      super(other, targetAddress);
      this.targetTypeList = other.targetTypeList;
      this.targetSize = other.targetSize;
      this.constructor = other.constructor;
   }

   public CPointer(CPointer<T> other) {
      this(other, other.__io__address);
   }

   public CPointer(long targetAddress, Class<?>[] targetTypes, Block block, BlockTable memory) {
      super(targetAddress, block, memory);
      this.targetTypeList = (Class[])targetTypes;
      this.targetSize = this.__io__sizeof(targetTypes[0]);
   }

   public T get() throws IOException {
      return this.isNull() ? null : this.__get(this.__io__address);
   }

   protected T __get(long address) throws IOException {
      if (this.targetSize == 0L) {
         throw new ClassCastException("Target type is unspecified (i.e. void*). Use cast() to specify its type first.");
      } else if (this.isPrimitive(this.targetTypeList[0])) {
         return this.getScalar(address);
      } else if (this.targetTypeList[0].equals(CArrayFacade.class)) {
         throw new ClassCastException("Impossible type declaration containing a pointer on an array (Cannot be declared in C).");
      } else {
         return this.getCFacade(address);
      }
   }

   public void set(T value) throws IOException {
      this.__set(this.__io__address, value);
   }

   protected void __set(long address, T value) throws IOException {
      if (this.isPrimitive(this.targetTypeList[0])) {
         this.setScalar(address, value);
      } else if (this.targetTypeList[0].equals(CPointer.class)) {
         CPointer<?> p = (CPointer)value;
         long referenced_address = p == null ? 0L : p.__io__address;
         this.__io__block.writeLong(address, referenced_address);
      } else if (!this.__io__equals((CFacade)value, address)) {
         if (this.__io__same__encoding(this, (CFacade)value)) {
            __io__native__copy(this.__io__block, address, (CFacade)value);
         } else {
            this.__io__generic__copy((CFacade)this.__get(address));
         }
      }

   }

   public long getAddress() throws IOException {
      return this.__io__address;
   }

   public boolean isNull() {
      return this.__io__address == 0L;
   }

   public boolean isValid() {
      return !this.isNull() && this.__io__block != null && this.__io__block.contains(this.__io__address);
   }

   public <U> CPointer<U> cast(Class<U> type) {
      return new CPointer(this.__io__address, new Class[]{type}, this.__io__block, this.__io__blockTable);
   }

   public <U> CPointer<U> cast(Class<?>[] types) {
      return new CPointer(this.__io__address, types, this.__io__block, this.__io__blockTable);
   }

   public CArrayFacade<T> cast(CArrayFacade<T> type) throws IOException {
      if (this instanceof CArrayFacade) {
         return (CArrayFacade)this;
      } else {
         throw new IOException("pointer does not point to an array");
      }
   }

   public T[] toArray(int length) throws IOException {
      if (this.isNull()) {
         return null;
      } else {
         T[] arr = (Object[])((Object[])Array.newInstance(this.targetTypeList[0], length));
         long address = this.__io__address;

         for(int i = 0; i < length; ++i) {
            arr[i] = this.__get(address);
            address += this.targetSize;
         }

         return arr;
      }
   }

   public CArrayFacade<T> toCArrayFacade(int len) {
      return new CArrayFacade(this.__io__address, this.targetTypeList, new int[]{len}, this.__io__block, this.__io__blockTable);
   }

   public byte[] toArray(byte[] data, int off, int len) throws IOException {
      if (!this.targetTypeList[0].equals(Byte.class)) {
         throw new ClassCastException("cannot cast " + this.targetTypeList[0].getSimpleName() + " to " + data.getClass().getSimpleName() + ". You have to cast the pointer first.");
      } else {
         this.__io__block.readFully(this.__io__address, data, off, len);
         return data;
      }
   }

   public void fromArray(byte[] data, int off, int len) throws IOException {
      if (!this.targetTypeList[0].equals(Byte.class)) {
         throw new ClassCastException("cannot cast " + data.getClass().getSimpleName() + " to " + this.targetTypeList[0].getSimpleName() + ". You have to cast the pointer first.");
      } else {
         this.__io__block.writeFully(this.__io__address, data, off, len);
      }
   }

   public byte[] toByteArray(int len) throws IOException {
      return this.toArray((byte[])(new byte[len]), 0, len);
   }

   public void fromArray(byte[] data) throws IOException {
      this.fromArray((byte[])data, 0, data.length);
   }

   public short[] toArray(short[] data, int off, int len) throws IOException {
      if (!this.targetTypeList[0].equals(Short.class)) {
         throw new ClassCastException("cannot cast " + this.targetTypeList[0].getSimpleName() + " to " + data.getClass().getSimpleName() + ". You have to cast the pointer first.");
      } else {
         this.__io__block.readFully(this.__io__address, data, off, len);
         return data;
      }
   }

   public void fromArray(short[] data, int off, int len) throws IOException {
      if (!this.targetTypeList[0].equals(Short.class)) {
         throw new ClassCastException("cannot cast " + data.getClass().getSimpleName() + " to " + this.targetTypeList[0].getSimpleName() + ". You have to cast the pointer first.");
      } else {
         this.__io__block.writeFully(this.__io__address, data, off, len);
      }
   }

   public short[] toShortArray(int len) throws IOException {
      return this.toArray((short[])(new short[len]), 0, len);
   }

   public void fromArray(short[] data) throws IOException {
      this.fromArray((short[])data, 0, data.length);
   }

   public int[] toArray(int[] data, int off, int len) throws IOException {
      if (!this.targetTypeList[0].equals(Integer.class)) {
         throw new ClassCastException("cannot cast " + this.targetTypeList[0].getSimpleName() + " to " + data.getClass().getSimpleName() + ". You have to cast the pointer first.");
      } else {
         this.__io__block.readFully(this.__io__address, data, off, len);
         return data;
      }
   }

   public int[] toIntArray(int len) throws IOException {
      return this.toArray((int[])(new int[len]), 0, len);
   }

   public void fromArray(int[] data, int off, int len) throws IOException {
      if (!this.targetTypeList[0].equals(Integer.class)) {
         throw new ClassCastException("cannot cast " + data.getClass().getSimpleName() + " to " + this.targetTypeList[0].getSimpleName() + ". You have to cast the pointer first.");
      } else {
         this.__io__block.writeFully(this.__io__address, data, off, len);
      }
   }

   public void fromArray(int[] data) throws IOException {
      this.fromArray((int[])data, 0, data.length);
   }

   public long[] toArray(long[] data, int off, int len) throws IOException {
      if (!this.targetTypeList[0].equals(Long.class)) {
         throw new ClassCastException("cannot cast " + this.targetTypeList[0].getSimpleName() + " to " + data.getClass().getSimpleName() + ". You have to cast the pointer first.");
      } else {
         this.__io__block.readFully(this.__io__address, data, off, len);
         return data;
      }
   }

   public long[] toLongArray(int len) throws IOException {
      return this.toArray((long[])(new long[len]), 0, len);
   }

   public void fromArray(long[] data, int off, int len) throws IOException {
      if (!this.targetTypeList[0].equals(Long.class)) {
         throw new ClassCastException("cannot cast " + data.getClass().getSimpleName() + " to " + this.targetTypeList[0].getSimpleName() + ". You have to cast the pointer first.");
      } else {
         this.__io__block.writeFully(this.__io__address, data, off, len);
      }
   }

   public void fromArray(long[] data) throws IOException {
      this.fromArray((long[])data, 0, data.length);
   }

   public long[] toArrayInt64(long[] data, int off, int len) throws IOException {
      if (!this.targetTypeList[0].equals(int64.class)) {
         throw new ClassCastException("cannot cast " + this.targetTypeList[0].getSimpleName() + " to " + data.getClass().getSimpleName() + ". You have to cast the pointer first.");
      } else {
         this.__io__block.readFullyInt64(this.__io__address, data, off, len);
         return data;
      }
   }

   public long[] toInt64Array(int len) throws IOException {
      return this.toArray((long[])(new long[len]), 0, len);
   }

   public void fromInt64Array(long[] data, int off, int len) throws IOException {
      if (!this.targetTypeList[0].equals(int64.class)) {
         throw new ClassCastException("cannot cast " + data.getClass().getSimpleName() + " to " + this.targetTypeList[0].getSimpleName() + ". You have to cast the pointer first.");
      } else {
         this.__io__block.writeFullyInt64(this.__io__address, data, off, len);
      }
   }

   public void fromInt64Array(long[] data) throws IOException {
      this.fromArray((long[])data, 0, data.length);
   }

   public float[] toArray(float[] data, int off, int len) throws IOException {
      if (!this.targetTypeList[0].equals(Float.class)) {
         throw new ClassCastException("cannot cast " + this.targetTypeList[0].getSimpleName() + " to " + data.getClass().getSimpleName() + ". You have to cast the pointer first.");
      } else {
         this.__io__block.readFully(this.__io__address, data, off, len);
         return data;
      }
   }

   public float[] toFloatArray(int len) throws IOException {
      return this.toArray((float[])(new float[len]), 0, len);
   }

   public void fromArray(float[] data, int off, int len) throws IOException {
      if (!this.targetTypeList[0].equals(Float.class)) {
         throw new ClassCastException("cannot cast " + data.getClass().getSimpleName() + " to " + this.targetTypeList[0].getSimpleName() + ". You have to cast the pointer first.");
      } else {
         this.__io__block.writeFully(this.__io__address, data, off, len);
      }
   }

   public void fromArray(float[] data) throws IOException {
      this.fromArray((float[])data, 0, data.length);
   }

   public double[] toArray(double[] data, int off, int len) throws IOException {
      if (!this.targetTypeList[0].equals(Double.class)) {
         throw new ClassCastException("cannot cast " + this.targetTypeList[0].getSimpleName() + " to " + data.getClass().getSimpleName() + ". You have to cast the pointer first.");
      } else {
         this.__io__block.readFully(this.__io__address, data, off, len);
         return data;
      }
   }

   public double[] toDoubleArray(int len) throws IOException {
      return this.toArray((double[])(new double[len]), 0, len);
   }

   public void fromArray(double[] data, int off, int len) throws IOException {
      if (!this.targetTypeList[0].equals(Double.class)) {
         throw new ClassCastException("cannot cast " + data.getClass().getSimpleName() + " to " + this.targetTypeList[0].getSimpleName() + ". You have to cast the pointer first.");
      } else {
         this.__io__block.writeFully(this.__io__address, data, off, len);
      }
   }

   public void fromArray(double[] data) throws IOException {
      this.fromArray((double[])data, 0, data.length);
   }

   public CPointerMutable<T> mutable() {
      return new CPointerMutable(this);
   }

   public CPointer<T> plus(int value) throws IOException {
      return new CPointer(this, this.__io__address + this.targetSize);
   }

   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      } else if (obj instanceof CArrayFacade.CArrayFacadeIterator) {
         return this.__io__address == ((CArrayFacade.CArrayFacadeIterator)obj).getCurrentAddress();
      } else if (obj instanceof CFacade) {
         return ((CFacade)obj).__io__address == this.__io__address;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return (int)(this.__io__address >> 32 ^ this.__io__address);
   }

   protected boolean isPrimitive(Class<?> type) {
      return type.isPrimitive() || type.equals(int64.class) || type.equals(Byte.class) || type.equals(Short.class) || type.equals(Integer.class) || type.equals(Long.class) || type.equals(Float.class) || type.equals(Double.class);
   }

   protected T getCFacade(long targetAddress) throws IOException {
      try {
         if (this.targetTypeList[0].equals(CPointer.class)) {
            long address = this.__io__block.readLong(targetAddress);
            Class<?>[] type = (Class[])Arrays.copyOfRange(this.targetTypeList, 1, this.targetTypeList.length);
            Block block = this.__io__blockTable.getBlock(address, type);
            return new CPointer(address, type, block, this.__io__blockTable);
         } else if (this.isNull()) {
            return null;
         } else {
            if (this.constructor == null) {
               this.constructor = this.targetTypeList[0].getDeclaredConstructor(Long.TYPE, Block.class, BlockTable.class);
            }

            return CFacade.__io__newInstance(this.constructor, this.targetTypeList[0], targetAddress, this.__io__block, this.__io__blockTable);
         }
      } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | InstantiationException var7) {
         throw new IOException(var7);
      }
   }

   protected T getScalar(long address) throws IOException {
      Object result = null;
      Class<?> type = this.targetTypeList[0];
      if (!type.equals(Byte.class) && !type.equals(Byte.TYPE)) {
         if (!type.equals(Short.class) && !type.equals(Short.TYPE)) {
            if (!type.equals(Integer.class) && !type.equals(Integer.TYPE)) {
               if (!type.equals(Long.class) && !type.equals(Long.TYPE)) {
                  if (type.equals(int64.class)) {
                     result = this.__io__block.readInt64(address);
                  } else if (!type.equals(Float.class) && !type.equals(Float.TYPE)) {
                     if (!type.equals(Double.class) && !type.equals(Double.TYPE)) {
                        throw new ClassCastException("unrecognized scalar type: " + type.getName());
                     }

                     result = this.__io__block.readDouble(address);
                  } else {
                     result = this.__io__block.readFloat(address);
                  }
               } else {
                  result = this.__io__block.readLong(address);
               }
            } else {
               result = this.__io__block.readInt(address);
            }
         } else {
            result = this.__io__block.readShort(address);
         }
      } else {
         result = this.__io__block.readByte(address);
      }

      return result;
   }

   protected void setScalar(long address, T elem) throws IOException {
      Class<?> type = this.targetTypeList[0];
      if (type.equals(Byte.class)) {
         this.__io__block.writeByte(address, (Byte)elem);
      } else if (type.equals(Short.class)) {
         this.__io__block.writeShort(address, (Short)elem);
      } else if (type.equals(Integer.class)) {
         this.__io__block.writeInt(address, (Integer)elem);
      } else if (type.equals(Long.class)) {
         this.__io__block.writeLong(address, (Long)elem);
      } else if (type.equals(int64.class)) {
         this.__io__block.writeInt64(address, (Long)elem);
      } else if (type.equals(Float.class)) {
         this.__io__block.writeFloat(address, (Float)elem);
      } else {
         if (!type.equals(Double.class)) {
            throw new ClassCastException("unrecognized scalar type: " + type.getName());
         }

         this.__io__block.writeDouble(address, (Double)elem);
      }

   }
}
