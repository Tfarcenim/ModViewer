package com.replaymod.lib.org.mortbay.util.ajax;

import com.replaymod.lib.org.mortbay.log.Log;

public class WaitingContinuation implements Continuation {
   Object _mutex;
   Object _object;
   boolean _new = true;
   boolean _resumed = false;
   boolean _pending = false;

   public WaitingContinuation() {
      this._mutex = this;
   }

   public WaitingContinuation(Object mutex) {
      this._mutex = mutex == null ? this : mutex;
   }

   public void resume() {
      synchronized(this._mutex) {
         this._resumed = true;
         this._mutex.notify();
      }
   }

   public void reset() {
      synchronized(this._mutex) {
         this._resumed = false;
         this._pending = false;
         this._mutex.notify();
      }
   }

   public boolean isNew() {
      return this._new;
   }

   public boolean suspend(long timeout) {
      synchronized(this._mutex) {
         this._new = false;
         this._pending = true;

         boolean var4;
         try {
            if (!this._resumed && timeout >= 0L) {
               if (timeout == 0L) {
                  this._mutex.wait();
               } else if (timeout > 0L) {
                  this._mutex.wait(timeout);
               }
            }
         } catch (InterruptedException var12) {
            Log.ignore(var12);
         } finally {
            var4 = this._resumed;
            this._resumed = false;
            this._pending = false;
         }

         return var4;
      }
   }

   public boolean isPending() {
      synchronized(this._mutex) {
         return this._pending;
      }
   }

   public boolean isResumed() {
      synchronized(this._mutex) {
         return this._resumed;
      }
   }

   public Object getObject() {
      return this._object;
   }

   public void setObject(Object object) {
      this._object = object;
   }

   public Object getMutex() {
      return this._mutex;
   }

   public void setMutex(Object mutex) {
      if (this._pending && mutex != this._mutex) {
         throw new IllegalStateException();
      } else {
         this._mutex = mutex == null ? this : mutex;
      }
   }

   public String toString() {
      synchronized(this) {
         return "WaitingContinuation@" + this.hashCode() + (this._new ? ",new" : "") + (this._pending ? ",pending" : "") + (this._resumed ? ",resumed" : "");
      }
   }
}
