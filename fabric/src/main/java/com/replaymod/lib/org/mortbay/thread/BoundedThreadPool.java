package com.replaymod.lib.org.mortbay.thread;

import com.replaymod.lib.org.mortbay.component.AbstractLifeCycle;
import com.replaymod.lib.org.mortbay.log.Log;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/** @deprecated */
public class BoundedThreadPool extends AbstractLifeCycle implements Serializable, ThreadPool {
   private static int __id;
   private boolean _daemon;
   private int _id;
   private List _idle;
   private final Object _lock = new Object();
   private final Object _joinLock = new Object();
   private long _lastShrink;
   private int _maxIdleTimeMs = 60000;
   private int _maxThreads = 255;
   private int _minThreads = 1;
   private String _name;
   private List _queue;
   private Set _threads;
   private boolean _warned = false;
   int _lowThreads = 0;
   int _priority = 5;

   public BoundedThreadPool() {
      this._name = "btpool" + __id++;
   }

   public boolean dispatch(Runnable job) {
      synchronized(this._lock) {
         if (this.isRunning() && job != null) {
            int idle = this._idle.size();
            if (idle > 0) {
               BoundedThreadPool.PoolThread thread = (BoundedThreadPool.PoolThread)this._idle.remove(idle - 1);
               thread.dispatch(job);
            } else if (this._threads.size() < this._maxThreads) {
               this.newThread(job);
            } else {
               if (!this._warned) {
                  this._warned = true;
                  Log.debug("Out of threads for {}", this);
               }

               this._queue.add(job);
            }

            return true;
         } else {
            return false;
         }
      }
   }

   public int getIdleThreads() {
      return this._idle == null ? 0 : this._idle.size();
   }

   public int getLowThreads() {
      return this._lowThreads;
   }

   public int getMaxIdleTimeMs() {
      return this._maxIdleTimeMs;
   }

   public int getMaxThreads() {
      return this._maxThreads;
   }

   public int getMinThreads() {
      return this._minThreads;
   }

   public String getName() {
      return this._name;
   }

   public int getThreads() {
      return this._threads.size();
   }

   public int getThreadsPriority() {
      return this._priority;
   }

   public int getQueueSize() {
      synchronized(this._lock) {
         return this._queue.size();
      }
   }

   public boolean isDaemon() {
      return this._daemon;
   }

   public boolean isLowOnThreads() {
      synchronized(this._lock) {
         return this._queue.size() > this._lowThreads;
      }
   }

   public void join() throws InterruptedException {
      synchronized(this._joinLock) {
         while(this.isRunning()) {
            this._joinLock.wait();
         }
      }

      while(this.isStopping()) {
         Thread.sleep(10L);
      }

   }

   public void setDaemon(boolean daemon) {
      this._daemon = daemon;
   }

   public void setLowThreads(int lowThreads) {
      this._lowThreads = lowThreads;
   }

   public void setMaxIdleTimeMs(int maxIdleTimeMs) {
      this._maxIdleTimeMs = maxIdleTimeMs;
   }

   public void setMaxThreads(int maxThreads) {
      if (this.isStarted() && maxThreads < this._minThreads) {
         throw new IllegalArgumentException("!minThreads<maxThreads");
      } else {
         this._maxThreads = maxThreads;
      }
   }

   public void setMinThreads(int minThreads) {
      if (!this.isStarted() || minThreads > 0 && minThreads <= this._maxThreads) {
         this._minThreads = minThreads;
         synchronized(this._lock) {
            while(this.isStarted() && this._threads.size() < this._minThreads) {
               this.newThread((Runnable)null);
            }

         }
      } else {
         throw new IllegalArgumentException("!0<=minThreads<maxThreads");
      }
   }

   public void setName(String name) {
      this._name = name;
   }

   public void setThreadsPriority(int priority) {
      this._priority = priority;
   }

   protected void doStart() throws Exception {
      if (this._maxThreads >= this._minThreads && this._minThreads > 0) {
         this._threads = new HashSet();
         this._idle = new ArrayList();
         this._queue = new LinkedList();

         for(int i = 0; i < this._minThreads; ++i) {
            this.newThread((Runnable)null);
         }

      } else {
         throw new IllegalArgumentException("!0<minThreads<maxThreads");
      }
   }

   protected void doStop() throws Exception {
      super.doStop();

      for(int i = 0; i < 100; ++i) {
         synchronized(this._lock) {
            Iterator iter = this._threads.iterator();

            while(true) {
               if (!iter.hasNext()) {
                  break;
               }

               ((Thread)iter.next()).interrupt();
            }
         }

         Thread.yield();
         if (this._threads.size() == 0) {
            break;
         }

         try {
            Thread.sleep((long)(i * 100));
         } catch (InterruptedException var7) {
         }
      }

      if (this._threads.size() > 0) {
         Log.warn(this._threads.size() + " threads could not be stopped");
      }

      synchronized(this._joinLock) {
         this._joinLock.notifyAll();
      }
   }

   protected BoundedThreadPool.PoolThread newThread(Runnable job) {
      synchronized(this._lock) {
         BoundedThreadPool.PoolThread thread = new BoundedThreadPool.PoolThread(job);
         this._threads.add(thread);
         thread.setName(this._name + "-" + this._id++);
         thread.start();
         return thread;
      }
   }

   protected void stopJob(Thread thread, Object job) {
      thread.interrupt();
   }

   public class PoolThread extends Thread {
      Runnable _job = null;

      PoolThread() {
         this.setDaemon(BoundedThreadPool.this._daemon);
         this.setPriority(BoundedThreadPool.this._priority);
      }

      PoolThread(Runnable job) {
         this.setDaemon(BoundedThreadPool.this._daemon);
         this.setPriority(BoundedThreadPool.this._priority);
         this._job = job;
      }

      public void run() {
         try {
            Runnable job = null;
            synchronized(this) {
               job = this._job;
               this._job = null;
            }

            while(BoundedThreadPool.this.isRunning()) {
               if (job != null) {
                  Runnable todo = job;
                  job = null;
                  todo.run();
               } else {
                  synchronized(BoundedThreadPool.this._lock) {
                     if (BoundedThreadPool.this._queue.size() > 0) {
                        job = (Runnable)BoundedThreadPool.this._queue.remove(0);
                        continue;
                     }

                     BoundedThreadPool.this._warned = false;
                     if (BoundedThreadPool.this._threads.size() > BoundedThreadPool.this._maxThreads || BoundedThreadPool.this._idle.size() > 0 && BoundedThreadPool.this._threads.size() > BoundedThreadPool.this._minThreads) {
                        long now = System.currentTimeMillis();
                        if (now - BoundedThreadPool.this._lastShrink > (long)BoundedThreadPool.this.getMaxIdleTimeMs()) {
                           BoundedThreadPool.this._lastShrink = now;
                           return;
                        }
                     }

                     BoundedThreadPool.this._idle.add(this);
                  }

                  try {
                     synchronized(this) {
                        if (this._job == null) {
                           this.wait((long)BoundedThreadPool.this.getMaxIdleTimeMs());
                        }

                        job = this._job;
                        this._job = null;
                     }
                  } catch (InterruptedException var46) {
                     Log.ignore(var46);
                  } finally {
                     synchronized(BoundedThreadPool.this._lock) {
                        BoundedThreadPool.this._idle.remove(this);
                     }
                  }
               }
            }

         } finally {
            synchronized(BoundedThreadPool.this._lock) {
               BoundedThreadPool.this._threads.remove(this);
            }

            Runnable jobx = null;
            synchronized(this) {
               jobx = this._job;
            }

            if (jobx != null && BoundedThreadPool.this.isRunning()) {
               BoundedThreadPool.this.dispatch(jobx);
            }

         }
      }

      void dispatch(Runnable job) {
         synchronized(this) {
            if (this._job == null && job != null) {
               this._job = job;
               this.notify();
            } else {
               throw new IllegalStateException();
            }
         }
      }
   }
}
