package com.replaymod.lib.org.cakelab.blender.io;

import java.nio.ByteOrder;

public class Encoding {
   public static final int ADDR_WIDTH_64BIT = 8;
   public static final int ADDR_WIDTH_32BIT = 4;
   private static final int BIG_ENDIAN = 65536;
   private static final int LITTLE_ENDIAN = 0;
   public static final Encoding LITTLE_ENDIAN_64BIT;
   public static final Encoding BIG_ENDIAN_64BIT;
   public static final Encoding LITTLE_ENDIAN_32BIT;
   public static final Encoding BIG_ENDIAN_32BIT;
   public static final int LITTLE_ENDIAN_64BIT_ID = 8;
   public static final int LITTLE_ENDIAN_32BIT_ID = 4;
   public static final int BIG_ENDIAN_64BIT_ID = 65544;
   public static final int BIG_ENDIAN_32BIT_ID = 65540;
   public static final Encoding JAVA_NATIVE;
   private final ByteOrder byteOrder;
   private final int addressWidth;
   private final int id;

   private Encoding(ByteOrder byteOrder, int addrWidth) {
      this.byteOrder = byteOrder;
      this.addressWidth = addrWidth;
      this.id = getId(byteOrder, addrWidth);
   }

   public int id() {
      return this.id;
   }

   public ByteOrder getByteOrder() {
      return this.byteOrder;
   }

   public int getAddressWidth() {
      return this.addressWidth;
   }

   private static final int getId(ByteOrder byteOrder, int addressWidth) {
      return (byteOrder == ByteOrder.BIG_ENDIAN ? 65536 : 0) | addressWidth;
   }

   public static Encoding get(ByteOrder byteOrder, int addressWidth) {
      switch(getId(byteOrder, addressWidth)) {
      case 4:
         return LITTLE_ENDIAN_32BIT;
      case 8:
         return LITTLE_ENDIAN_64BIT;
      case 65540:
         return BIG_ENDIAN_32BIT;
      case 65544:
         return BIG_ENDIAN_64BIT;
      default:
         return null;
      }
   }

   public static Encoding nativeEncoding() {
      return System.getProperty("os.arch").contains("64") ? get(ByteOrder.nativeOrder(), 8) : get(ByteOrder.nativeOrder(), 4);
   }

   static {
      LITTLE_ENDIAN_64BIT = new Encoding(ByteOrder.LITTLE_ENDIAN, 8);
      BIG_ENDIAN_64BIT = new Encoding(ByteOrder.BIG_ENDIAN, 8);
      LITTLE_ENDIAN_32BIT = new Encoding(ByteOrder.LITTLE_ENDIAN, 4);
      BIG_ENDIAN_32BIT = new Encoding(ByteOrder.BIG_ENDIAN, 4);
      JAVA_NATIVE = BIG_ENDIAN_64BIT;
   }
}
