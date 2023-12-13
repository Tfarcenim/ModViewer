package com.replaymod.lib.org.cakelab.blender.io.util;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;

public class BigEndianCFileRW extends CDataFileRWAccess {
   private RandomAccessFile in;

   public BigEndianCFileRW(RandomAccessFile in, int pointerSize) {
      super(in, pointerSize);
      this.in = in;
   }

   public short readShort() throws IOException {
      return this.in.readShort();
   }

   public final void writeShort(short v) throws IOException {
      this.in.writeShort(v);
   }

   public int readInt() throws IOException {
      return this.in.readInt();
   }

   public final void writeInt(int v) throws IOException {
      this.in.writeInt(v);
   }

   public long readInt64() throws IOException {
      return this.in.readLong();
   }

   public void writeInt64(long value) throws IOException {
      this.in.writeLong(value);
   }

   public float readFloat() throws IOException {
      return this.in.readFloat();
   }

   public final void writeFloat(float v) throws IOException {
      this.in.writeFloat(v);
   }

   public double readDouble() throws IOException {
      return this.in.readDouble();
   }

   public final void writeDouble(double v) throws IOException {
      this.in.writeDouble(v);
   }

   public long offset() throws IOException {
      return this.in.getFilePointer();
   }

   public ByteOrder getByteOrder() {
      return ByteOrder.BIG_ENDIAN;
   }
}
