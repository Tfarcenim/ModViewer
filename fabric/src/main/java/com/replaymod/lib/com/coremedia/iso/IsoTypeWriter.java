package com.replaymod.lib.com.coremedia.iso;

import java.nio.ByteBuffer;

public final class IsoTypeWriter {
   public static void writeUInt64(ByteBuffer bb, long u) {
      assert u >= 0L : "The given long is negative";

      bb.putLong(u);
   }

   public static void writeUInt32(ByteBuffer bb, long u) {
      assert u >= 0L && u <= 4294967296L : "The given long is not in the range of uint32 (" + u + ")";

      bb.putInt((int)u);
   }

   public static void writeUInt32BE(ByteBuffer bb, long u) {
      assert u >= 0L && u <= 4294967296L : "The given long is not in the range of uint32 (" + u + ")";

      writeUInt16BE(bb, (int)u & '\uffff');
      writeUInt16BE(bb, (int)(u >> 16 & 65535L));
   }

   public static void writeUInt24(ByteBuffer bb, int i) {
      i &= 16777215;
      writeUInt16(bb, i >> 8);
      writeUInt8(bb, i);
   }

   public static void writeUInt48(ByteBuffer bb, long l) {
      l &= 281474976710655L;
      writeUInt16(bb, (int)(l >> 32));
      writeUInt32(bb, l & 4294967295L);
   }

   public static void writeUInt16(ByteBuffer bb, int i) {
      i &= 65535;
      writeUInt8(bb, i >> 8);
      writeUInt8(bb, i & 255);
   }

   public static void writeUInt16BE(ByteBuffer bb, int i) {
      i &= 65535;
      writeUInt8(bb, i & 255);
      writeUInt8(bb, i >> 8);
   }

   public static void writeUInt8(ByteBuffer bb, int i) {
      i &= 255;
      bb.put((byte)i);
   }

   public static void writeFixedPoint1616(ByteBuffer bb, double v) {
      int result = (int)(v * 65536.0D);
      bb.put((byte)((result & -16777216) >> 24));
      bb.put((byte)((result & 16711680) >> 16));
      bb.put((byte)((result & '\uff00') >> 8));
      bb.put((byte)(result & 255));
   }

   public static void writeFixedPoint0230(ByteBuffer bb, double v) {
      int result = (int)(v * 1.073741824E9D);
      bb.put((byte)((result & -16777216) >> 24));
      bb.put((byte)((result & 16711680) >> 16));
      bb.put((byte)((result & '\uff00') >> 8));
      bb.put((byte)(result & 255));
   }

   public static void writeFixedPoint88(ByteBuffer bb, double v) {
      short result = (short)((int)(v * 256.0D));
      bb.put((byte)((result & '\uff00') >> 8));
      bb.put((byte)(result & 255));
   }

   public static void writeIso639(ByteBuffer bb, String language) {
      if (language.getBytes().length != 3) {
         throw new IllegalArgumentException("\"" + language + "\" language string isn't exactly 3 characters long!");
      } else {
         int bits = 0;

         for(int i = 0; i < 3; ++i) {
            bits += language.getBytes()[i] - 96 << (2 - i) * 5;
         }

         writeUInt16(bb, bits);
      }
   }

   public static void writePascalUtfString(ByteBuffer bb, String string) {
      byte[] b = Utf8.convert(string);

      assert b.length < 255;

      writeUInt8(bb, b.length);
      bb.put(b);
   }

   public static void writeZeroTermUtf8String(ByteBuffer bb, String string) {
      byte[] b = Utf8.convert(string);
      bb.put(b);
      writeUInt8(bb, 0);
   }

   public static void writeUtf8String(ByteBuffer bb, String string) {
      bb.put(Utf8.convert(string));
      writeUInt8(bb, 0);
   }
}
