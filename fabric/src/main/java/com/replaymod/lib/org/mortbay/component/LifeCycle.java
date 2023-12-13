package com.replaymod.lib.org.mortbay.component;

import java.util.EventListener;

public interface LifeCycle {
   void start() throws Exception;

   void stop() throws Exception;

   boolean isRunning();

   boolean isStarted();

   boolean isStarting();

   boolean isStopping();

   boolean isStopped();

   boolean isFailed();

   void addLifeCycleListener(LifeCycle.Listener var1);

   void removeLifeCycleListener(LifeCycle.Listener var1);

   public interface Listener extends EventListener {
      void lifeCycleStarting(LifeCycle var1);

      void lifeCycleStarted(LifeCycle var1);

      void lifeCycleFailure(LifeCycle var1, Throwable var2);

      void lifeCycleStopping(LifeCycle var1);

      void lifeCycleStopped(LifeCycle var1);
   }
}
