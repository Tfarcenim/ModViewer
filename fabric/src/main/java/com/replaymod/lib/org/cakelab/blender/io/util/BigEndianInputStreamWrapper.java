package com.replaymod.lib.org.cakelab.blender.io.util;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

public class BigEndianInputStreamWrapper extends CDataReadWriteAccess {
   private DataInputStream in;
   private long offset;

   public BigEndianInputStreamWrapper(InputStream in, int pointerSize) {
      super(pointerSize);
      this.in = new DataInputStream(in);
   }

   public void close() throws IOException {
      this.in.close();
   }

   public byte readByte() throws IOException {
      ++this.offset;
      return this.in.readByte();
   }

   public void writeByte(int value) throws IOException {
      throw new UnsupportedOperationException();
   }

   public short readShort() throws IOException {
      this.offset += 2L;
      return this.in.readShort();
   }

   public void writeShort(short value) throws IOException {
      throw new UnsupportedOperationException();
   }

   public int readInt() throws IOException {
      this.offset += 4L;
      return this.in.readInt();
   }

   public void writeInt(int value) throws IOException {
      throw new UnsupportedOperationException();
   }

   public long readInt64() throws IOException {
      this.offset += 8L;
      return this.in.readLong();
   }

   public void writeInt64(long value) throws IOException {
      throw new UnsupportedOperationException();
   }

   public float readFloat() throws IOException {
      this.offset += 4L;
      return this.in.readFloat();
   }

   public void writeFloat(float value) throws IOException {
      throw new UnsupportedOperationException();
   }

   public double readDouble() throws IOException {
      this.offset += 8L;
      return this.in.readDouble();
   }

   public void writeDouble(double value) throws IOException {
      throw new UnsupportedOperationException();
   }

   public void padding(int alignment, boolean extend) throws IOException {
      throw new UnsupportedOperationException();
   }

   public void padding(int alignment) throws IOException {
      long pos = this.offset();
      long misalignment = pos % (long)alignment;
      if (misalignment > 0L) {
         long len = (long)this.available();
         long correction = (long)alignment - misalignment;
         if (pos + correction > len) {
            throw new IOException("padding beyond file boundary without write permission.");
         }

         this.skip(correction);
      }

   }

   public long skip(long n) throws IOException {
      int i;
      for(i = 0; (long)i < n; ++i) {
         this.readByte();
      }

      return (long)i;
   }

   public int available() throws IOException {
      return (int)((long)this.in.available() + this.offset);
   }

   public void offset(long offset) throws IOException {
      if (this.offset < offset) {
         throw new UnsupportedOperationException();
      } else {
         this.skip(offset - this.offset);
      }
   }

   public long offset() throws IOException {
      return this.offset;
   }

   public ByteOrder getByteOrder() {
      return ByteOrder.BIG_ENDIAN;
   }
}
