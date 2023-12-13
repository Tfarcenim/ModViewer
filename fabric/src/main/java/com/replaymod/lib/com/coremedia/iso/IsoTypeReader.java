package com.replaymod.lib.com.coremedia.iso;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public final class IsoTypeReader {
   public static long readUInt32BE(ByteBuffer bb) {
      long ch1 = (long)readUInt8(bb);
      long ch2 = (long)readUInt8(bb);
      long ch3 = (long)readUInt8(bb);
      long ch4 = (long)readUInt8(bb);
      return (ch4 << 24) + (ch3 << 16) + (ch2 << 8) + (ch1 << 0);
   }

   public static long readUInt32(ByteBuffer bb) {
      long i = (long)bb.getInt();
      if (i < 0L) {
         i += 4294967296L;
      }

      return i;
   }

   public static int readUInt24(ByteBuffer bb) {
      int result = 0;
      int result = result + (readUInt16(bb) << 8);
      result += byte2int(bb.get());
      return result;
   }

   public static int readUInt16(ByteBuffer bb) {
      int result = 0;
      int result = result + (byte2int(bb.get()) << 8);
      result += byte2int(bb.get());
      return result;
   }

   public static int readUInt16BE(ByteBuffer bb) {
      int result = 0;
      int result = result + byte2int(bb.get());
      result += byte2int(bb.get()) << 8;
      return result;
   }

   public static int readUInt8(ByteBuffer bb) {
      return byte2int(bb.get());
   }

   public static int byte2int(byte b) {
      return b < 0 ? b + 256 : b;
   }

   public static String readString(ByteBuffer byteBuffer) {
      ByteArrayOutputStream out = new ByteArrayOutputStream();

      byte read;
      while((read = byteBuffer.get()) != 0) {
         out.write(read);
      }

      return Utf8.convert(out.toByteArray());
   }

   public static String readString(ByteBuffer byteBuffer, int length) {
      byte[] buffer = new byte[length];
      byteBuffer.get(buffer);
      return Utf8.convert(buffer);
   }

   public static long readUInt64(ByteBuffer byteBuffer) {
      long result = 0L;
      result += readUInt32(byteBuffer) << 32;
      if (result < 0L) {
         throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
      } else {
         result += readUInt32(byteBuffer);
         return result;
      }
   }

   public static double readFixedPoint1616(ByteBuffer bb) {
      byte[] bytes = new byte[4];
      bb.get(bytes);
      int result = 0;
      int result = result | bytes[0] << 24 & -16777216;
      result |= bytes[1] << 16 & 16711680;
      result |= bytes[2] << 8 & '\uff00';
      result |= bytes[3] & 255;
      return (double)result / 65536.0D;
   }

   public static double readFixedPoint0230(ByteBuffer bb) {
      byte[] bytes = new byte[4];
      bb.get(bytes);
      int result = 0;
      int result = result | bytes[0] << 24 & -16777216;
      result |= bytes[1] << 16 & 16711680;
      result |= bytes[2] << 8 & '\uff00';
      result |= bytes[3] & 255;
      return (double)result / 1.073741824E9D;
   }

   public static float readFixedPoint88(ByteBuffer bb) {
      byte[] bytes = new byte[2];
      bb.get(bytes);
      short result = 0;
      short result = (short)(result | bytes[0] << 8 & '\uff00');
      result = (short)(result | bytes[1] & 255);
      return (float)result / 256.0F;
   }

   public static String readIso639(ByteBuffer bb) {
      int bits = readUInt16(bb);
      StringBuilder result = new StringBuilder();

      for(int i = 0; i < 3; ++i) {
         int c = bits >> (2 - i) * 5 & 31;
         result.append((char)(c + 96));
      }

      return result.toString();
   }

   public static String read4cc(ByteBuffer bb) {
      byte[] codeBytes = new byte[4];
      bb.get(codeBytes);

      try {
         return new String(codeBytes, "ISO-8859-1");
      } catch (UnsupportedEncodingException var3) {
         throw new RuntimeException(var3);
      }
   }

   public static long readUInt48(ByteBuffer byteBuffer) {
      long result = (long)readUInt16(byteBuffer) << 32;
      if (result < 0L) {
         throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
      } else {
         result += readUInt32(byteBuffer);
         return result;
      }
   }
}
