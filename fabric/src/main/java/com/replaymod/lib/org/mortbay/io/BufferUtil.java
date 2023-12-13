package com.replaymod.lib.org.mortbay.io;

import com.replaymod.lib.org.mortbay.util.StringUtil;
import java.io.UnsupportedEncodingException;

public class BufferUtil {
   static final byte SPACE = 32;
   static final byte MINUS = 45;
   static final byte[] DIGIT = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
   private static int[] decDivisors = new int[]{1000000000, 100000000, 10000000, 1000000, 100000, 10000, 1000, 100, 10, 1};
   private static int[] hexDivisors = new int[]{268435456, 16777216, 1048576, 65536, 4096, 256, 16, 1};
   private static final long[] decDivisorsL = new long[]{1000000000000000000L, 100000000000000000L, 10000000000000000L, 1000000000000000L, 100000000000000L, 10000000000000L, 1000000000000L, 100000000000L, 10000000000L, 1000000000L, 100000000L, 10000000L, 1000000L, 100000L, 10000L, 1000L, 100L, 10L, 1L};

   public static int toInt(Buffer buffer) {
      int val = 0;
      boolean started = false;
      boolean minus = false;

      for(int i = buffer.getIndex(); i < buffer.putIndex(); ++i) {
         byte b = buffer.peek(i);
         if (b <= 32) {
            if (started) {
               break;
            }
         } else if (b >= 48 && b <= 57) {
            val = val * 10 + (b - 48);
            started = true;
         } else {
            if (b != 45 || started) {
               break;
            }

            minus = true;
         }
      }

      if (started) {
         return minus ? -val : val;
      } else {
         throw new NumberFormatException(buffer.toString());
      }
   }

   public static long toLong(Buffer buffer) {
      long val = 0L;
      boolean started = false;
      boolean minus = false;

      for(int i = buffer.getIndex(); i < buffer.putIndex(); ++i) {
         byte b = buffer.peek(i);
         if (b <= 32) {
            if (started) {
               break;
            }
         } else if (b >= 48 && b <= 57) {
            val = val * 10L + (long)(b - 48);
            started = true;
         } else {
            if (b != 45 || started) {
               break;
            }

            minus = true;
         }
      }

      if (started) {
         return minus ? -val : val;
      } else {
         throw new NumberFormatException(buffer.toString());
      }
   }

   public static void putHexInt(Buffer buffer, int n) {
      if (n < 0) {
         buffer.put((byte)45);
         if (n == Integer.MIN_VALUE) {
            buffer.put((byte)56);
            buffer.put((byte)48);
            buffer.put((byte)48);
            buffer.put((byte)48);
            buffer.put((byte)48);
            buffer.put((byte)48);
            buffer.put((byte)48);
            buffer.put((byte)48);
            return;
         }

         n = -n;
      }

      if (n < 16) {
         buffer.put(DIGIT[n]);
      } else {
         boolean started = false;

         for(int i = 0; i < hexDivisors.length; ++i) {
            if (n < hexDivisors[i]) {
               if (started) {
                  buffer.put((byte)48);
               }
            } else {
               started = true;
               int d = n / hexDivisors[i];
               buffer.put(DIGIT[d]);
               n -= d * hexDivisors[i];
            }
         }
      }

   }

   public static void prependHexInt(Buffer buffer, int n) {
      if (n == 0) {
         int gi = buffer.getIndex();
         --gi;
         buffer.poke(gi, (byte)48);
         buffer.setGetIndex(gi);
      } else {
         boolean minus = false;
         if (n < 0) {
            minus = true;
            n = -n;
         }

         int gi = buffer.getIndex();

         while(n > 0) {
            int d = 15 & n;
            n >>= 4;
            --gi;
            buffer.poke(gi, DIGIT[d]);
         }

         if (minus) {
            --gi;
            buffer.poke(gi, (byte)45);
         }

         buffer.setGetIndex(gi);
      }

   }

   public static void putDecInt(Buffer buffer, int n) {
      if (n < 0) {
         buffer.put((byte)45);
         if (n == Integer.MIN_VALUE) {
            buffer.put((byte)50);
            n = 147483648;
         } else {
            n = -n;
         }
      }

      if (n < 10) {
         buffer.put(DIGIT[n]);
      } else {
         boolean started = false;

         for(int i = 0; i < decDivisors.length; ++i) {
            if (n < decDivisors[i]) {
               if (started) {
                  buffer.put((byte)48);
               }
            } else {
               started = true;
               int d = n / decDivisors[i];
               buffer.put(DIGIT[d]);
               n -= d * decDivisors[i];
            }
         }
      }

   }

   public static void putDecLong(Buffer buffer, long n) {
      if (n < 0L) {
         buffer.put((byte)45);
         if (n == Long.MIN_VALUE) {
            buffer.put((byte)57);
            n = 223372036854775808L;
         } else {
            n = -n;
         }
      }

      if (n < 10L) {
         buffer.put(DIGIT[(int)n]);
      } else {
         boolean started = false;

         for(int i = 0; i < decDivisorsL.length; ++i) {
            if (n < decDivisorsL[i]) {
               if (started) {
                  buffer.put((byte)48);
               }
            } else {
               started = true;
               long d = n / decDivisorsL[i];
               buffer.put(DIGIT[(int)d]);
               n -= d * decDivisorsL[i];
            }
         }
      }

   }

   public static Buffer toBuffer(long value) {
      ByteArrayBuffer buf = new ByteArrayBuffer(16);
      putDecLong(buf, value);
      return buf;
   }

   public static void putCRLF(Buffer buffer) {
      buffer.put((byte)13);
      buffer.put((byte)10);
   }

   public static boolean isPrefix(Buffer prefix, Buffer buffer) {
      if (prefix.length() > buffer.length()) {
         return false;
      } else {
         int bi = buffer.getIndex();

         for(int i = prefix.getIndex(); i < prefix.putIndex(); ++i) {
            if (prefix.peek(i) != buffer.peek(bi++)) {
               return false;
            }
         }

         return true;
      }
   }

   public static String to8859_1_String(Buffer buffer) {
      if (buffer.isImmutable()) {
         return buffer.toString();
      } else {
         try {
            byte[] bytes = buffer.array();
            if (bytes != null) {
               return new String(bytes, buffer.getIndex(), buffer.length(), StringUtil.__ISO_8859_1);
            } else {
               StringBuffer b = new StringBuffer(buffer.length());
               int i = buffer.getIndex();

               for(int c = 0; c < buffer.length(); ++c) {
                  b.append((char)(127 & buffer.peek(i)));
                  ++i;
               }

               return b.toString();
            }
         } catch (UnsupportedEncodingException var5) {
            var5.printStackTrace();
            return buffer.toString();
         }
      }
   }
}
