package com.replaymod.lib.org.cakelab.blender.io.util;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;

public class LittleEndianFileRW extends CDataFileRWAccess {
   public LittleEndianFileRW(RandomAccessFile in, int pointerSize) {
      super(in, pointerSize);
   }

   public final short readShort() throws IOException {
      return swapShort(this.io.readShort());
   }

   public final void writeShort(short value) throws IOException {
      this.io.writeShort(swapShort(value));
   }

   public final int readInt() throws IOException {
      return swapInteger(this.io.readInt());
   }

   public final void writeInt(int value) throws IOException {
      this.io.writeInt(swapInteger(value));
   }

   public final long readInt64() throws IOException {
      return swapLong(this.io.readLong());
   }

   public final void writeInt64(long value) throws IOException {
      this.io.writeLong(swapLong(value));
   }

   public final float readFloat() throws IOException {
      return swapFloat(this.io.readFloat());
   }

   public final void writeFloat(float value) throws IOException {
      this.io.writeFloat(swapFloat(value));
   }

   public final double readDouble() throws IOException {
      return swapDouble(this.io.readDouble());
   }

   public final void writeDouble(double value) throws IOException {
      this.io.writeDouble(swapDouble(value));
   }

   public static short swapShort(short value) {
      return (short)(((value >> 0 & 255) << 8) + ((value >> 8 & 255) << 0));
   }

   public static int swapInteger(int value) {
      return ((value >> 0 & 255) << 24) + ((value >> 8 & 255) << 16) + ((value >> 16 & 255) << 8) + ((value >> 24 & 255) << 0);
   }

   public static long swapLong(long value) {
      return ((value >> 0 & 255L) << 56) + ((value >> 8 & 255L) << 48) + ((value >> 16 & 255L) << 40) + ((value >> 24 & 255L) << 32) + ((value >> 32 & 255L) << 24) + ((value >> 40 & 255L) << 16) + ((value >> 48 & 255L) << 8) + ((value >> 56 & 255L) << 0);
   }

   public static float swapFloat(float value) {
      return Float.intBitsToFloat(swapInteger(Float.floatToIntBits(value)));
   }

   public static double swapDouble(double value) {
      return Double.longBitsToDouble(swapLong(Double.doubleToLongBits(value)));
   }

   public ByteOrder getByteOrder() {
      return ByteOrder.LITTLE_ENDIAN;
   }
}
