package com.replaymod.lib.com.googlecode.mp4parser.util;

public abstract class Logger {
   public static Logger getLogger(Class clz) {
      return (Logger)(System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik") ? new AndroidLogger(clz.getSimpleName()) : new JuliLogger(clz.getSimpleName()));
   }

   public abstract void logDebug(String var1);

   public abstract void logWarn(String var1);

   public abstract void logError(String var1);
}
