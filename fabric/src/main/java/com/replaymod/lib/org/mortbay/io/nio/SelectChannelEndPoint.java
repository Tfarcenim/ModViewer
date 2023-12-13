package com.replaymod.lib.org.mortbay.io.nio;

import com.replaymod.lib.org.mortbay.io.Buffer;
import com.replaymod.lib.org.mortbay.io.Connection;
import com.replaymod.lib.org.mortbay.jetty.EofException;
import com.replaymod.lib.org.mortbay.jetty.HttpException;
import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.thread.Timeout;
import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

public class SelectChannelEndPoint extends ChannelEndPoint implements Runnable {
   protected SelectorManager _manager;
   protected SelectorManager.SelectSet _selectSet;
   protected boolean _dispatched = false;
   protected boolean _writable = true;
   protected SelectionKey _key;
   protected int _interestOps;
   protected boolean _readBlocked;
   protected boolean _writeBlocked;
   protected Connection _connection;
   private Timeout.Task _timeoutTask = new SelectChannelEndPoint.IdleTask();

   public Connection getConnection() {
      return this._connection;
   }

   public SelectChannelEndPoint(SocketChannel channel, SelectorManager.SelectSet selectSet, SelectionKey key) {
      super(channel);
      this._manager = selectSet.getManager();
      this._selectSet = selectSet;
      this._connection = this._manager.newConnection(channel, this);
      this._manager.endPointOpened(this);
      this._key = key;
   }

   void dispatch() throws IOException {
      boolean dispatch_done = true;

      try {
         if (this.dispatch(this._manager.isDelaySelectKeyUpdate())) {
            dispatch_done = false;
            dispatch_done = this._manager.dispatch(this);
         }
      } finally {
         if (!dispatch_done) {
            Log.warn("dispatch failed!");
            this.undispatch();
         }

      }

   }

   public boolean dispatch(boolean assumeShortDispatch) throws IOException {
      synchronized(this) {
         if (this._key != null && this._key.isValid()) {
            if (!this._readBlocked && !this._writeBlocked) {
               if (!assumeShortDispatch) {
                  this._key.interestOps(0);
               }

               if (this._dispatched) {
                  this._key.interestOps(0);
                  return false;
               } else {
                  if ((this._key.readyOps() & 4) == 4 && (this._key.interestOps() & 4) == 4) {
                     this._interestOps = this._key.interestOps() & -5;
                     this._key.interestOps(this._interestOps);
                     this._writable = true;
                  }

                  this._dispatched = true;
                  return true;
               }
            } else {
               if (this._readBlocked && this._key.isReadable()) {
                  this._readBlocked = false;
               }

               if (this._writeBlocked && this._key.isWritable()) {
                  this._writeBlocked = false;
               }

               this.notifyAll();
               this._key.interestOps(0);
               return false;
            }
         } else {
            this._readBlocked = false;
            this._writeBlocked = false;
            this.notifyAll();
            return false;
         }
      }
   }

   public void scheduleIdle() {
      this._selectSet.scheduleIdle(this._timeoutTask);
   }

   public void cancelIdle() {
      this._selectSet.cancelIdle(this._timeoutTask);
   }

   protected void idleExpired() {
      try {
         this.close();
      } catch (IOException var2) {
         Log.ignore(var2);
      }

   }

   public void undispatch() {
      synchronized(this) {
         try {
            this._dispatched = false;
            this.updateKey();
         } catch (Exception var4) {
            Log.ignore(var4);
            this._interestOps = -1;
            this._selectSet.addChange(this);
         }

      }
   }

   public int flush(Buffer header, Buffer buffer, Buffer trailer) throws IOException {
      int l = super.flush(header, buffer, trailer);
      this._writable = l > 0;
      return l;
   }

   public int flush(Buffer buffer) throws IOException {
      int l = super.flush(buffer);
      this._writable = l > 0;
      return l;
   }

   public boolean blockReadable(long timeoutMs) throws IOException {
      synchronized(this) {
         long start = this._selectSet.getNow();

         try {
            this._readBlocked = true;

            while(this.isOpen() && this._readBlocked) {
               try {
                  this.updateKey();
                  this.wait(timeoutMs);
                  if (this._readBlocked && timeoutMs < this._selectSet.getNow() - start) {
                     boolean var6 = false;
                     return var6;
                  }
               } catch (InterruptedException var12) {
                  Log.warn((Throwable)var12);
               }
            }
         } finally {
            this._readBlocked = false;
         }

         return true;
      }
   }

   public boolean blockWritable(long timeoutMs) throws IOException {
      synchronized(this) {
         long start = this._selectSet.getNow();

         try {
            this._writeBlocked = true;

            while(this.isOpen() && this._writeBlocked) {
               try {
                  this.updateKey();
                  this.wait(timeoutMs);
                  if (this._writeBlocked && timeoutMs < this._selectSet.getNow() - start) {
                     boolean var6 = false;
                     return var6;
                  }
               } catch (InterruptedException var12) {
                  Log.warn((Throwable)var12);
               }
            }
         } finally {
            this._writeBlocked = false;
            this.scheduleIdle();
         }

         return true;
      }
   }

   public void setWritable(boolean writable) {
      this._writable = writable;
   }

   public void scheduleWrite() {
      this._writable = false;
      this.updateKey();
   }

   private void updateKey() {
      synchronized(this) {
         int ops = -1;
         if (this.getChannel().isOpen()) {
            ops = this._key != null && this._key.isValid() ? this._key.interestOps() : -1;
            this._interestOps = (this._dispatched && !this._readBlocked ? 0 : 1) | (this._writable && !this._writeBlocked ? 0 : 4);
         }

         if (this._interestOps == ops && this.getChannel().isOpen()) {
            return;
         }
      }

      this._selectSet.addChange(this);
      this._selectSet.wakeup();
   }

   void doUpdateKey() {
      synchronized(this) {
         if (this.getChannel().isOpen()) {
            if (this._interestOps > 0) {
               if (this._key != null && this._key.isValid()) {
                  this._key.interestOps(this._interestOps);
               } else {
                  SelectableChannel sc = (SelectableChannel)this.getChannel();
                  if (sc.isRegistered()) {
                     this.updateKey();
                  } else {
                     try {
                        this._key = ((SelectableChannel)this.getChannel()).register(this._selectSet.getSelector(), this._interestOps, this);
                     } catch (Exception var5) {
                        Log.ignore(var5);
                        if (this._key != null && this._key.isValid()) {
                           this._key.cancel();
                        }

                        this.cancelIdle();
                        this._manager.endPointClosed(this);
                        this._key = null;
                     }
                  }
               }
            } else if (this._key != null && this._key.isValid()) {
               this._key.interestOps(0);
            } else {
               this._key = null;
            }
         } else {
            if (this._key != null && this._key.isValid()) {
               this._key.interestOps(0);
               this._key.cancel();
            }

            this.cancelIdle();
            this._manager.endPointClosed(this);
            this._key = null;
         }

      }
   }

   public void run() {
      try {
         this._connection.handle();
      } catch (ClosedChannelException var15) {
         Log.ignore(var15);
      } catch (EofException var16) {
         Log.debug("EOF", var16);

         try {
            this.close();
         } catch (IOException var14) {
            Log.ignore(var14);
         }
      } catch (HttpException var17) {
         Log.debug("BAD", var17);

         try {
            this.close();
         } catch (IOException var13) {
            Log.ignore(var13);
         }
      } catch (Throwable var18) {
         Log.warn("handle failed", var18);

         try {
            this.close();
         } catch (IOException var12) {
            Log.ignore(var12);
         }
      } finally {
         this.undispatch();
      }

   }

   public void close() throws IOException {
      try {
         super.close();
      } catch (IOException var5) {
         Log.ignore(var5);
      } finally {
         this.updateKey();
      }

   }

   public String toString() {
      return "SCEP@" + this.hashCode() + "[d=" + this._dispatched + ",io=" + this._interestOps + ",w=" + this._writable + ",b=" + this._readBlocked + "|" + this._writeBlocked + "]";
   }

   public Timeout.Task getTimeoutTask() {
      return this._timeoutTask;
   }

   public SelectorManager.SelectSet getSelectSet() {
      return this._selectSet;
   }

   public class IdleTask extends Timeout.Task {
      public void expired() {
         SelectChannelEndPoint.this.idleExpired();
      }

      public String toString() {
         return "TimeoutTask:" + SelectChannelEndPoint.this.toString();
      }
   }
}
