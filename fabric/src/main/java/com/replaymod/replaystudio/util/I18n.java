package com.replaymod.replaystudio.util;

public class I18n {
   private static volatile I18n.Impl impl;

   public static void setI18n(I18n.Impl impl) {
      I18n.impl = impl;
   }

   public static String format(String key, Object... args) {
      return impl.format(key, args);
   }

   public interface Impl {
      String format(String var1, Object... var2);
   }
}
