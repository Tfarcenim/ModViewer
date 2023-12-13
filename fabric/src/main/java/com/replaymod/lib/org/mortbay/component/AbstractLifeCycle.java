package com.replaymod.lib.org.mortbay.component;

import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.util.LazyList;

public abstract class AbstractLifeCycle implements LifeCycle {
   private Object _lock = new Object();
   private final int FAILED = -1;
   private final int STOPPED = 0;
   private final int STARTING = 1;
   private final int STARTED = 2;
   private final int STOPPING = 3;
   private volatile int _state = 0;
   protected LifeCycle.Listener[] _listeners;

   protected void doStart() throws Exception {
   }

   protected void doStop() throws Exception {
   }

   public final void start() throws Exception {
      synchronized(this._lock) {
         try {
            if (this._state == 2 || this._state == 1) {
               return;
            }

            this.setStarting();
            this.doStart();
            Log.debug("started {}", this);
            this.setStarted();
         } catch (Exception var4) {
            this.setFailed(var4);
            throw var4;
         } catch (Error var5) {
            this.setFailed(var5);
            throw var5;
         }

      }
   }

   public final void stop() throws Exception {
      synchronized(this._lock) {
         try {
            if (this._state == 3 || this._state == 0) {
               return;
            }

            this.setStopping();
            this.doStop();
            Log.debug("stopped {}", this);
            this.setStopped();
         } catch (Exception var4) {
            this.setFailed(var4);
            throw var4;
         } catch (Error var5) {
            this.setFailed(var5);
            throw var5;
         }

      }
   }

   public boolean isRunning() {
      return this._state == 2 || this._state == 1;
   }

   public boolean isStarted() {
      return this._state == 2;
   }

   public boolean isStarting() {
      return this._state == 1;
   }

   public boolean isStopping() {
      return this._state == 3;
   }

   public boolean isStopped() {
      return this._state == 0;
   }

   public boolean isFailed() {
      return this._state == -1;
   }

   public void addLifeCycleListener(LifeCycle.Listener listener) {
      this._listeners = (LifeCycle.Listener[])((LifeCycle.Listener[])LazyList.addToArray(this._listeners, listener, LifeCycle.Listener.class));
   }

   public void removeLifeCycleListener(LifeCycle.Listener listener) {
      this._listeners = (LifeCycle.Listener[])((LifeCycle.Listener[])LazyList.removeFromArray(this._listeners, listener));
   }

   private void setStarted() {
      this._state = 2;
      if (this._listeners != null) {
         for(int i = 0; i < this._listeners.length; ++i) {
            this._listeners[i].lifeCycleStarted(this);
         }
      }

   }

   private void setStarting() {
      this._state = 1;
      if (this._listeners != null) {
         for(int i = 0; i < this._listeners.length; ++i) {
            this._listeners[i].lifeCycleStarting(this);
         }
      }

   }

   private void setStopping() {
      this._state = 3;
      if (this._listeners != null) {
         for(int i = 0; i < this._listeners.length; ++i) {
            this._listeners[i].lifeCycleStopping(this);
         }
      }

   }

   private void setStopped() {
      this._state = 0;
      if (this._listeners != null) {
         for(int i = 0; i < this._listeners.length; ++i) {
            this._listeners[i].lifeCycleStopped(this);
         }
      }

   }

   private void setFailed(Throwable th) {
      Log.warn("failed " + this + ": " + th);
      Log.debug(th);
      this._state = -1;
      if (this._listeners != null) {
         for(int i = 0; i < this._listeners.length; ++i) {
            this._listeners[i].lifeCycleFailure(this, th);
         }
      }

   }
}
