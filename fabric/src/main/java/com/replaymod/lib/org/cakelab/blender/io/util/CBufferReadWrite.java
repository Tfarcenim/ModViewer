package com.replaymod.lib.org.cakelab.blender.io.util;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class CBufferReadWrite extends CDataReadWriteAccess {
   private ByteBuffer rawData;
   private long address;

   public CBufferReadWrite(ByteBuffer rawData, long address, int pointerSize) {
      super(pointerSize);
      this.rawData = rawData;
      this.address = address;
   }

   public short readShort() throws IOException {
      return this.rawData.getShort();
   }

   public int readInt() throws IOException {
      return this.rawData.getInt();
   }

   public long readInt64() throws IOException {
      return this.rawData.getLong();
   }

   public float readFloat() throws IOException {
      return this.rawData.getFloat();
   }

   public double readDouble() throws IOException {
      return this.rawData.getDouble();
   }

   public long offset() throws IOException {
      return (long)this.rawData.position();
   }

   public void offset(long offset) throws IOException {
      this.rawData.position((int)offset);
   }

   public long skip(long n) throws IOException {
      this.rawData.position((int)((long)this.rawData.position() + n));
      return n;
   }

   public int available() throws IOException {
      return this.rawData.limit() - this.rawData.position();
   }

   public void padding(int alignment) throws IOException {
      long pos = this.address + (long)this.rawData.position();
      long misalignment = pos % (long)alignment;
      if (misalignment > 0L) {
         this.skip((long)alignment - misalignment);
      }

   }

   public void padding(int alignment, boolean extend) throws IOException {
      if (extend) {
         throw new IllegalArgumentException("cannot extend underlying buffer");
      } else {
         this.padding(alignment);
      }
   }

   public void close() throws IOException {
      this.rawData = null;
   }

   public byte readByte() throws IOException {
      return this.rawData.get();
   }

   public void readFully(byte[] b, int off, int len) throws IOException {
      this.rawData.get(b, off, len);
   }

   public void writeByte(int value) throws IOException {
      this.rawData.put((byte)value);
   }

   public void writeShort(short value) throws IOException {
      this.rawData.putShort(value);
   }

   public void writeInt(int value) throws IOException {
      this.rawData.putInt(value);
   }

   public void writeInt64(long value) throws IOException {
      this.rawData.putLong(value);
   }

   public void writeFloat(float value) throws IOException {
      this.rawData.putFloat(value);
   }

   public void writeDouble(double value) throws IOException {
      this.rawData.putDouble(value);
   }

   public ByteOrder getByteOrder() {
      return this.rawData.order();
   }

   public byte[] getBytes() {
      return this.rawData.array();
   }
}
