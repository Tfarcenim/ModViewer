package com.replaymod.lib.org.mortbay.jetty.security;

import com.replaymod.lib.org.mortbay.util.StringUtil;
import java.io.UnsupportedEncodingException;

public class B64Code {
   static final char pad = '=';
   static final char[] nibble2code = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
   static byte[] code2nibble = null;

   public static String encode(String s) {
      try {
         return encode(s, (String)null);
      } catch (UnsupportedEncodingException var2) {
         throw new IllegalArgumentException(var2.toString());
      }
   }

   public static String encode(String s, String charEncoding) throws UnsupportedEncodingException {
      byte[] bytes;
      if (charEncoding == null) {
         bytes = s.getBytes(StringUtil.__ISO_8859_1);
      } else {
         bytes = s.getBytes(charEncoding);
      }

      return new String(encode(bytes));
   }

   public static char[] encode(byte[] b) {
      if (b == null) {
         return null;
      } else {
         int bLen = b.length;
         char[] r = new char[(bLen + 2) / 3 * 4];
         int ri = 0;
         int bi = 0;

         byte b0;
         byte b1;
         byte b2;
         for(int stop = bLen / 3 * 3; bi < stop; r[ri++] = nibble2code[b2 & 63]) {
            b0 = b[bi++];
            b1 = b[bi++];
            b2 = b[bi++];
            r[ri++] = nibble2code[b0 >>> 2 & 63];
            r[ri++] = nibble2code[b0 << 4 & 63 | b1 >>> 4 & 15];
            r[ri++] = nibble2code[b1 << 2 & 63 | b2 >>> 6 & 3];
         }

         if (bLen != bi) {
            switch(bLen % 3) {
            case 1:
               b0 = b[bi++];
               r[ri++] = nibble2code[b0 >>> 2 & 63];
               r[ri++] = nibble2code[b0 << 4 & 63];
               r[ri++] = '=';
               r[ri++] = '=';
               break;
            case 2:
               b0 = b[bi++];
               b1 = b[bi++];
               r[ri++] = nibble2code[b0 >>> 2 & 63];
               r[ri++] = nibble2code[b0 << 4 & 63 | b1 >>> 4 & 15];
               r[ri++] = nibble2code[b1 << 2 & 63];
               r[ri++] = '=';
            }
         }

         return r;
      }
   }

   public static String decode(String s) {
      try {
         return decode(s, StringUtil.__ISO_8859_1);
      } catch (UnsupportedEncodingException var2) {
         throw new IllegalArgumentException(var2.toString());
      }
   }

   public static String decode(String s, String charEncoding) throws UnsupportedEncodingException {
      byte[] decoded = decode(s.toCharArray());
      return charEncoding == null ? new String(decoded) : new String(decoded, charEncoding);
   }

   public static byte[] decode(char[] b) {
      if (b == null) {
         return null;
      } else {
         int bLen = b.length;
         if (bLen % 4 != 0) {
            throw new IllegalArgumentException("Input block size is not 4");
         } else {
            int li;
            for(li = bLen - 1; li >= 0 && b[li] == '='; --li) {
            }

            if (li < 0) {
               return new byte[0];
            } else {
               int rLen = (li + 1) * 3 / 4;
               byte[] r = new byte[rLen];
               int ri = 0;
               int bi = 0;
               int stop = rLen / 3 * 3;

               try {
                  byte b0;
                  byte b1;
                  byte b2;
                  while(ri < stop) {
                     b0 = code2nibble[b[bi++]];
                     b1 = code2nibble[b[bi++]];
                     b2 = code2nibble[b[bi++]];
                     byte b3 = code2nibble[b[bi++]];
                     if (b0 < 0 || b1 < 0 || b2 < 0 || b3 < 0) {
                        throw new IllegalArgumentException("Not B64 encoded");
                     }

                     r[ri++] = (byte)(b0 << 2 | b1 >>> 4);
                     r[ri++] = (byte)(b1 << 4 | b2 >>> 2);
                     r[ri++] = (byte)(b2 << 6 | b3);
                  }

                  if (rLen != ri) {
                     switch(rLen % 3) {
                     case 1:
                        b0 = code2nibble[b[bi++]];
                        b1 = code2nibble[b[bi++]];
                        if (b0 >= 0 && b1 >= 0) {
                           r[ri++] = (byte)(b0 << 2 | b1 >>> 4);
                           break;
                        }

                        throw new IllegalArgumentException("Not B64 encoded");
                     case 2:
                        b0 = code2nibble[b[bi++]];
                        b1 = code2nibble[b[bi++]];
                        b2 = code2nibble[b[bi++]];
                        if (b0 < 0 || b1 < 0 || b2 < 0) {
                           throw new IllegalArgumentException("Not B64 encoded");
                        }

                        r[ri++] = (byte)(b0 << 2 | b1 >>> 4);
                        r[ri++] = (byte)(b1 << 4 | b2 >>> 2);
                     }
                  }

                  return r;
               } catch (IndexOutOfBoundsException var13) {
                  throw new IllegalArgumentException("char " + bi + " was not B64 encoded");
               }
            }
         }
      }
   }

   static {
      code2nibble = new byte[256];

      for(int i = 0; i < 256; ++i) {
         code2nibble[i] = -1;
      }

      for(byte b = 0; b < 64; code2nibble[(byte)nibble2code[b]] = b++) {
      }

      code2nibble[61] = 0;
   }
}
