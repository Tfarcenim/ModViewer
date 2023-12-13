package com.replaymod.lib.org.mortbay.thread;

public interface ThreadPool {
   boolean dispatch(Runnable var1);

   void join() throws InterruptedException;

   int getThreads();

   int getIdleThreads();

   boolean isLowOnThreads();
}
