package com.replaymod.lib.com.coremedia.iso;

import java.io.UnsupportedEncodingException;

public final class Utf8 {
   public static byte[] convert(String s) {
      try {
         return s != null ? s.getBytes("UTF-8") : null;
      } catch (UnsupportedEncodingException var2) {
         throw new Error(var2);
      }
   }

   public static String convert(byte[] b) {
      try {
         return b != null ? new String(b, "UTF-8") : null;
      } catch (UnsupportedEncodingException var2) {
         throw new Error(var2);
      }
   }

   public static int utf8StringLengthInBytes(String utf8) {
      try {
         return utf8 != null ? utf8.getBytes("UTF-8").length : 0;
      } catch (UnsupportedEncodingException var1) {
         throw new RuntimeException();
      }
   }
}
