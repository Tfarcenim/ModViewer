package com.replaymod.lib.org.cakelab.blender.nio;

public class UnsignedLong {
   public static final long MIN_VALUE = 0L;
   public static final long MAX_VALUE = -1L;

   public static int compare(long ul1, long ul2) {
      if (ul1 >= 0L && ul2 >= 0L) {
         return Long.compare(ul1, ul2);
      } else {
         int result = Long.compare(ul1 >>> 1, ul2 >>> 1);
         return result != 0 ? result : Integer.compare((int)ul1 & 1, (int)ul2 & 1);
      }
   }

   public static long minus(long ul1, long ul2) {
      return ul1 - ul2;
   }

   public static long plus(long ul1, long ul2) {
      return ul1 + ul2;
   }

   public static boolean le(long ul1, long ul2) {
      return compare(ul1, ul2) <= 0;
   }

   public static boolean lt(long ul1, long ul2) {
      return compare(ul1, ul2) < 0;
   }

   public static boolean ge(long ul1, long ul2) {
      return compare(ul1, ul2) >= 0;
   }

   public static boolean gt(long ul1, long ul2) {
      return compare(ul1, ul2) > 0;
   }

   public static boolean eq(long ul1, long ul2) {
      return ul1 == ul2;
   }
}
