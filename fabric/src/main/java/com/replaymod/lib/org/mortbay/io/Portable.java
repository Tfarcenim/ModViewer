package com.replaymod.lib.org.mortbay.io;

import com.replaymod.lib.org.mortbay.util.StringUtil;

public class Portable {
   public static final String ALL_INTERFACES = "0.0.0.0";

   public static void arraycopy(byte[] src, int srcOffset, byte[] dst, int dstOffset, int length) {
      System.arraycopy(src, srcOffset, dst, dstOffset, length);
   }

   public static void throwNotSupported() {
      throw new RuntimeException("Not Supported");
   }

   public static byte[] getBytes(String s) {
      try {
         return s.getBytes(StringUtil.__ISO_8859_1);
      } catch (Exception var2) {
         return s.getBytes();
      }
   }
}
