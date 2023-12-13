package com.replaymod.lib.org.cakelab.blender.io.util;

import com.replaymod.lib.org.cakelab.blender.io.Encoding;
import com.replaymod.lib.org.cakelab.blender.io.FileHeader;
import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class CDataReadWriteAccess implements Closeable {
   private int pointerSize;

   protected CDataReadWriteAccess(int pointerSize) {
      this.pointerSize = pointerSize;
   }

   public static CDataReadWriteAccess create(RandomAccessFile in, Encoding encoding) {
      CDataReadWriteAccess stream = null;
      if (encoding.getByteOrder() == ByteOrder.BIG_ENDIAN) {
         stream = new BigEndianCFileRW(in, encoding.getAddressWidth());
      } else {
         stream = new LittleEndianFileRW(in, encoding.getAddressWidth());
      }

      return (CDataReadWriteAccess)stream;
   }

   public static CDataReadWriteAccess create(byte[] data, long baseAddress, Encoding encoding) {
      ByteBuffer buffer = ByteBuffer.wrap(data);
      buffer.order(encoding.getByteOrder());
      return new CBufferReadWrite(buffer, baseAddress, encoding.getAddressWidth());
   }

   public final int getPointerSize() {
      return this.pointerSize;
   }

   public boolean readBoolean() throws IOException {
      return this.readByte() != 0;
   }

   public void writeBoolean(boolean value) throws IOException {
      this.writeByte(value ? 1 : 0);
   }

   public abstract byte readByte() throws IOException;

   public abstract void writeByte(int var1) throws IOException;

   public abstract short readShort() throws IOException;

   public abstract void writeShort(short var1) throws IOException;

   public abstract int readInt() throws IOException;

   public abstract void writeInt(int var1) throws IOException;

   public final long readLong() throws IOException {
      int size = this.getPointerSize();
      if (size == FileHeader.PointerSize.POINTER_SIZE_32BIT.getSize()) {
         return (long)this.readInt();
      } else if (size == FileHeader.PointerSize.POINTER_SIZE_64BIT.getSize()) {
         return this.readInt64();
      } else {
         throw new IOException("undefined pointer size");
      }
   }

   public final void writeLong(long value) throws IOException {
      int size = this.getPointerSize();
      if (size == FileHeader.PointerSize.POINTER_SIZE_32BIT.getSize()) {
         this.writeInt((int)value);
      } else {
         if (size != FileHeader.PointerSize.POINTER_SIZE_64BIT.getSize()) {
            throw new IOException("undefined pointer size");
         }

         this.writeInt64(value);
      }

   }

   public abstract long readInt64() throws IOException;

   public abstract void writeInt64(long var1) throws IOException;

   public abstract float readFloat() throws IOException;

   public abstract void writeFloat(float var1) throws IOException;

   public abstract double readDouble() throws IOException;

   public abstract void writeDouble(double var1) throws IOException;

   public final void readFully(byte[] b) throws IOException {
      this.readFully((byte[])b, 0, b.length);
   }

   public final void writeFully(byte[] b) throws IOException {
      this.writeFully((byte[])b, 0, b.length);
   }

   public void readFully(byte[] b, int off, int len) throws IOException {
      len += off;

      for(int i = off; i < len; ++i) {
         b[i] = this.readByte();
      }

   }

   public void writeFully(byte[] b, int off, int len) throws IOException {
      len += off;

      for(int i = off; i < len; ++i) {
         this.writeByte(b[i]);
      }

   }

   public void readFully(short[] b, int off, int len) throws IOException {
      len += off;

      for(int i = off; i < len; ++i) {
         b[i] = this.readShort();
      }

   }

   public void writeFully(short[] b, int off, int len) throws IOException {
      len += off;

      for(int i = off; i < len; ++i) {
         this.writeShort(b[i]);
      }

   }

   public void readFully(int[] b, int off, int len) throws IOException {
      len += off;

      for(int i = off; i < len; ++i) {
         b[i] = this.readInt();
      }

   }

   public void writeFully(int[] b, int off, int len) throws IOException {
      len += off;

      for(int i = off; i < len; ++i) {
         this.writeInt(b[i]);
      }

   }

   public void readFully(long[] b, int off, int len) throws IOException {
      len += off;

      for(int i = off; i < len; ++i) {
         b[i] = this.readLong();
      }

   }

   public void writeFully(long[] b, int off, int len) throws IOException {
      len += off;

      for(int i = off; i < len; ++i) {
         this.writeLong(b[i]);
      }

   }

   public void readFullyInt64(long[] b, int off, int len) throws IOException {
      len += off;

      for(int i = off; i < len; ++i) {
         b[i] = this.readInt64();
      }

   }

   public void writeFullyInt64(long[] b, int off, int len) throws IOException {
      len += off;

      for(int i = off; i < len; ++i) {
         this.writeInt64(b[i]);
      }

   }

   public void readFully(float[] b, int off, int len) throws IOException {
      len += off;

      for(int i = off; i < len; ++i) {
         b[i] = this.readFloat();
      }

   }

   public void writeFully(float[] b, int off, int len) throws IOException {
      len += off;

      for(int i = off; i < len; ++i) {
         this.writeFloat(b[i]);
      }

   }

   public void readFully(double[] b, int off, int len) throws IOException {
      len += off;

      for(int i = off; i < len; ++i) {
         b[i] = this.readDouble();
      }

   }

   public void writeFully(double[] b, int off, int len) throws IOException {
      len += off;

      for(int i = off; i < len; ++i) {
         this.writeDouble(b[i]);
      }

   }

   public abstract void padding(int var1, boolean var2) throws IOException;

   public abstract void padding(int var1) throws IOException;

   public abstract long skip(long var1) throws IOException;

   public abstract int available() throws IOException;

   public abstract void offset(long var1) throws IOException;

   public abstract long offset() throws IOException;

   public abstract ByteOrder getByteOrder();
}
