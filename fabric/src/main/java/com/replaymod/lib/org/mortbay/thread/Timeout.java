package com.replaymod.lib.org.mortbay.thread;

import com.replaymod.lib.org.mortbay.log.Log;

public class Timeout {
   private Object _lock;
   private long _duration;
   private volatile long _now = System.currentTimeMillis();
   private Timeout.Task _head = new Timeout.Task();

   public Timeout() {
      this._lock = new Object();
      this._head._timeout = this;
   }

   public Timeout(Object lock) {
      this._lock = lock;
      this._head._timeout = this;
   }

   public long getDuration() {
      return this._duration;
   }

   public void setDuration(long duration) {
      this._duration = duration;
   }

   public long setNow() {
      this._now = System.currentTimeMillis();
      return this._now;
   }

   public long getNow() {
      return this._now;
   }

   public void setNow(long now) {
      this._now = now;
   }

   public Timeout.Task expired() {
      long now = this._now;
      synchronized(this._lock) {
         long _expiry = now - this._duration;
         if (this._head._next != this._head) {
            Timeout.Task task = this._head._next;
            if (task._timestamp > _expiry) {
               return null;
            } else {
               task.unlink();
               task._expired = true;
               return task;
            }
         } else {
            return null;
         }
      }
   }

   public void tick() {
      long expiry = this._now - this._duration;
      Timeout.Task task = null;

      while(true) {
         try {
            synchronized(this._lock) {
               task = this._head._next;
               if (task == this._head || task._timestamp > expiry) {
                  return;
               }

               task.unlink();
               task._expired = true;
               task.expire();
            }

            task.expired();
         } catch (Throwable var7) {
            Log.warn("EXCEPTION ", var7);
         }
      }
   }

   public void tick(long now) {
      this._now = now;
      this.tick();
   }

   public void schedule(Timeout.Task task) {
      this.schedule(task, 0L);
   }

   public void schedule(Timeout.Task task, long delay) {
      synchronized(this._lock) {
         if (task._timestamp != 0L) {
            task.unlink();
            task._timestamp = 0L;
         }

         task._timeout = this;
         task._expired = false;
         task._delay = delay;
         task._timestamp = this._now + delay;

         Timeout.Task last;
         for(last = this._head._prev; last != this._head && last._timestamp > task._timestamp; last = last._prev) {
         }

         last.link(task);
      }
   }

   public void cancelAll() {
      synchronized(this._lock) {
         this._head._next = this._head._prev = this._head;
      }
   }

   public boolean isEmpty() {
      synchronized(this._lock) {
         return this._head._next == this._head;
      }
   }

   public long getTimeToNext() {
      synchronized(this._lock) {
         if (this._head._next == this._head) {
            return -1L;
         } else {
            long to_next = this._duration + this._head._next._timestamp - this._now;
            return to_next < 0L ? 0L : to_next;
         }
      }
   }

   public String toString() {
      StringBuffer buf = new StringBuffer();
      buf.append(super.toString());

      for(Timeout.Task task = this._head._next; task != this._head; task = task._next) {
         buf.append("-->");
         buf.append(task);
      }

      return buf.toString();
   }

   public static class Task {
      Timeout.Task _next;
      Timeout.Task _prev;
      Timeout _timeout;
      long _delay;
      long _timestamp = 0L;
      boolean _expired = false;

      public Task() {
         this._next = this._prev = this;
      }

      public long getTimestamp() {
         return this._timestamp;
      }

      public long getAge() {
         Timeout t = this._timeout;
         if (t != null) {
            long now = t._now;
            if (now != 0L && this._timestamp != 0L) {
               return now - this._timestamp;
            }
         }

         return 0L;
      }

      private void unlink() {
         this._next._prev = this._prev;
         this._prev._next = this._next;
         this._next = this._prev = this;
         this._expired = false;
      }

      private void link(Timeout.Task task) {
         Timeout.Task next_next = this._next;
         this._next._prev = task;
         this._next = task;
         this._next._next = next_next;
         this._next._prev = this;
      }

      public void schedule(Timeout timer) {
         timer.schedule(this);
      }

      public void schedule(Timeout timer, long delay) {
         timer.schedule(this, delay);
      }

      public void reschedule() {
         Timeout timeout = this._timeout;
         if (timeout != null) {
            timeout.schedule(this, this._delay);
         }

      }

      public void cancel() {
         Timeout timeout = this._timeout;
         if (timeout != null) {
            synchronized(timeout._lock) {
               this.unlink();
               this._timestamp = 0L;
            }
         }

      }

      public boolean isExpired() {
         return this._expired;
      }

      public boolean isScheduled() {
         return this._next != this;
      }

      public void expire() {
      }

      public void expired() {
      }
   }
}
