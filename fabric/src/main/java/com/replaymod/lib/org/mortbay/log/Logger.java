package com.replaymod.lib.org.mortbay.log;

public interface Logger {
   boolean isDebugEnabled();

   void setDebugEnabled(boolean var1);

   void info(String var1, Object var2, Object var3);

   void debug(String var1, Throwable var2);

   void debug(String var1, Object var2, Object var3);

   void warn(String var1, Object var2, Object var3);

   void warn(String var1, Throwable var2);

   Logger getLogger(String var1);
}
