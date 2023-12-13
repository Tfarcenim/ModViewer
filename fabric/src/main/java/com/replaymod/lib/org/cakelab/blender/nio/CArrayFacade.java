package com.replaymod.lib.org.cakelab.blender.nio;

import com.replaymod.lib.org.cakelab.blender.io.Encoding;
import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.ReadOnlyBufferException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;

public class CArrayFacade<T> extends CPointer<T> implements Iterable<T> {
   protected Class<?>[] targetTypeList;
   protected int[] dimensions;
   protected long componentSize;

   public CArrayFacade(CArrayFacade<T> other) {
      super(other);
      this.targetTypeList = other.targetTypeList;
      this.dimensions = other.dimensions;
      this.componentSize = other.componentSize;
   }

   public CArrayFacade(long baseAddress, Class<?>[] targetTypeList, int[] dimensions, Block block, BlockTable __blockTable) {
      super(baseAddress, (Class[])Arrays.copyOfRange(targetTypeList, dimensions.length - 1, targetTypeList.length), block, __blockTable);
      this.targetTypeList = targetTypeList;
      this.dimensions = dimensions;
      this.componentSize = this.calcComponentSize(targetTypeList[dimensions.length - 1]);
   }

   public int length() {
      return this.dimensions[0];
   }

   public long sizeof() {
      return (long)this.length() * this.componentSize;
   }

   long getAddress(int index) {
      return this.__io__address + (long)index * this.componentSize;
   }

   public T get(int index) throws IOException {
      long address = this.getAddress(index);
      if (this.dimensions.length > 1) {
         assert this.targetTypeList[0].equals(CArrayFacade.class);

         return new CArrayFacade(address, (Class[])Arrays.copyOfRange(this.targetTypeList, 1, this.targetTypeList.length), Arrays.copyOfRange(this.dimensions, 1, this.dimensions.length), this.__io__block, this.__io__blockTable);
      } else if (this.targetTypeList[0].equals(CPointer.class)) {
         long pointerAddress = this.__io__block.readLong(address);
         Class<?>[] type = (Class[])Arrays.copyOfRange(this.targetTypeList, 1, this.targetTypeList.length);
         Block block = this.__io__blockTable.getBlock(pointerAddress, type);
         return new CPointer(pointerAddress, type, block, this.__io__blockTable);
      } else {
         return this.isPrimitive(this.targetTypeList[0]) ? this.getScalar(address) : this.getCFacade(address);
      }
   }

   public void set(int index, T value) throws IOException {
      long address = this.getAddress(index);
      super.__set(address, value);
   }

   public T[] toArray() throws IOException {
      Object array = Array.newInstance(this.targetTypeList[0], this.length());

      for(int i = 0; i < this.length(); ++i) {
         Array.set(array, i, this.get(i));
      }

      return (Object[])((Object[])array);
   }

   public void fromArray(T[] data) throws IOException {
      for(int i = 0; i < this.length(); ++i) {
         this.set(i, data[i]);
      }

   }

   public String asString() throws IOException {
      if ((this.targetTypeList[0].equals(Byte.TYPE) || this.targetTypeList[0].equals(Byte.class)) && this.dimensions.length == 1) {
         byte[] bytes = this.toByteArray();

         int len;
         for(len = 0; len < bytes.length && bytes[len] != 0; ++len) {
         }

         return new String(bytes, 0, len);
      } else {
         throw new IllegalArgumentException("component type of array has to be byte to allow conversion to string. Consider a type cast.");
      }
   }

   public void fromString(String str) throws IOException {
      this.fromString(str, Charset.defaultCharset(), true);
   }

   public void fromString(String str, boolean addNullTermination) throws IOException {
      this.fromString(str, Charset.defaultCharset(), addNullTermination);
   }

   public void fromString(String str, Charset charset, boolean addNullTermination) throws IOException {
      if ((this.targetTypeList[0].equals(Byte.TYPE) || this.targetTypeList[0].equals(Byte.class)) && this.dimensions.length == 1) {
         byte[] bytes = str.getBytes(charset);
         super.fromArray((byte[])bytes, 0, bytes.length);
         if (addNullTermination) {
            this.set(bytes.length, (byte)0);
         }

      } else {
         throw new IllegalArgumentException("component type of array has to be byte to allow conversion from string. Consider a type cast.");
      }
   }

   public byte[] toByteArray() throws IOException {
      return super.toByteArray(this.length());
   }

   public void fromByteArray(byte[] data) throws IOException {
      super.fromArray(data);
   }

   public short[] toShortArray() throws IOException {
      return super.toShortArray(this.length());
   }

   public int[] toIntArray() throws IOException {
      return super.toIntArray(this.length());
   }

   public long[] toLongArray() throws IOException {
      return super.toLongArray(this.length());
   }

   public long[] toInt64Array() throws IOException {
      return super.toInt64Array(this.length());
   }

   public float[] toFloatArray() throws IOException {
      return super.toFloatArray(this.length());
   }

   public double[] toDoubleArray() throws IOException {
      return super.toDoubleArray(this.length());
   }

   private long calcComponentSize(Class<?> elementaryType) {
      long size = this.__io__sizeof(elementaryType);
      if (this.dimensions.length > 1) {
         long length = (long)this.dimensions[1];

         for(int i = 2; i < this.dimensions.length; ++i) {
            length *= (long)this.dimensions[i];
         }

         size *= length;
      }

      return size;
   }

   public static long __io__sizeof(Class<?> elementaryType, int[] dimensions, Encoding encoding) {
      long size = CFacade.__io__sizeof(elementaryType, encoding.getAddressWidth());
      if (dimensions.length > 0) {
         long length = (long)dimensions[0];

         for(int i = 1; i < dimensions.length; ++i) {
            length *= (long)dimensions[i];
         }

         size *= length;
      }

      return size;
   }

   protected void __io__generic__copy(CFacade sourceArray) throws IOException {
      assert sourceArray instanceof CArrayFacade;

      CArrayFacade<T> source = (CArrayFacade)sourceArray;

      for(int i = 0; i < source.length(); ++i) {
         this.set(i, source.get(i));
      }

   }

   public Iterator<T> iterator() {
      return new CArrayFacade.CArrayFacadeIterator(this);
   }

   static class CArrayFacadeIterator<T> extends CArrayFacade<T> implements Iterator<T> {
      private int current = 0;

      public CArrayFacadeIterator(CArrayFacade<T> dnaArray) {
         super(dnaArray);
      }

      public boolean hasNext() {
         return this.current < this.length();
      }

      public T next() {
         try {
            return this.get(this.current++);
         } catch (IOException var2) {
            throw new RuntimeException(var2);
         }
      }

      /** @deprecated */
      @Deprecated
      public void remove() throws ReadOnlyBufferException {
         throw new ReadOnlyBufferException();
      }

      public long getCurrentAddress() {
         return this.getAddress(this.current);
      }
   }
}
