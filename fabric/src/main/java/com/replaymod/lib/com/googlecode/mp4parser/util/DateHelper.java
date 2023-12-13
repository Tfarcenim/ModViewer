package com.replaymod.lib.com.googlecode.mp4parser.util;

import java.util.Date;

public class DateHelper {
   public static Date convert(long secondsSince) {
      return new Date((secondsSince - 2082844800L) * 1000L);
   }

   public static long convert(Date date) {
      return date.getTime() / 1000L + 2082844800L;
   }
}
