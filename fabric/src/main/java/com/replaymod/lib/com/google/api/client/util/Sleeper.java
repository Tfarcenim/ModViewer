package com.replaymod.lib.com.google.api.client.util;

public interface Sleeper {
   Sleeper DEFAULT = new Sleeper() {
      public void sleep(long millis) throws InterruptedException {
         Thread.sleep(millis);
      }
   };

   void sleep(long var1) throws InterruptedException;
}
