package com.replaymod.lib.org.mortbay.io.nio;

import com.replaymod.lib.org.mortbay.component.AbstractLifeCycle;
import com.replaymod.lib.org.mortbay.io.Connection;
import com.replaymod.lib.org.mortbay.io.EndPoint;
import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.thread.Timeout;
import java.io.IOException;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class SelectorManager extends AbstractLifeCycle {
   private static final int __JVMBUG_THRESHHOLD = Integer.getInteger("com.replaymod.lib.org.mortbay.io.nio.JVMBUG_THRESHHOLD", 512);
   private static final int __MONITOR_PERIOD = Integer.getInteger("com.replaymod.lib.org.mortbay.io.nio.MONITOR_PERIOD", 1000);
   private static final int __MAX_SELECTS = Integer.getInteger("com.replaymod.lib.org.mortbay.io.nio.MAX_SELECTS", 15000);
   private static final int __BUSY_PAUSE = Integer.getInteger("com.replaymod.lib.org.mortbay.io.nio.BUSY_PAUSE", 50);
   private static final int __BUSY_KEY = Integer.getInteger("com.replaymod.lib.org.mortbay.io.nio.BUSY_KEY", -1);
   private boolean _delaySelectKeyUpdate = true;
   private long _maxIdleTime;
   private long _lowResourcesConnections;
   private long _lowResourcesMaxIdleTime;
   private transient SelectorManager.SelectSet[] _selectSet;
   private int _selectSets = 1;
   private volatile int _set;

   public void setMaxIdleTime(long maxIdleTime) {
      this._maxIdleTime = maxIdleTime;
   }

   public void setSelectSets(int selectSets) {
      long lrc = this._lowResourcesConnections * (long)this._selectSets;
      this._selectSets = selectSets;
      this._lowResourcesConnections = lrc / (long)this._selectSets;
   }

   public long getMaxIdleTime() {
      return this._maxIdleTime;
   }

   public int getSelectSets() {
      return this._selectSets;
   }

   public boolean isDelaySelectKeyUpdate() {
      return this._delaySelectKeyUpdate;
   }

   public void register(SocketChannel channel, Object att) throws IOException {
      int s = this._set++;
      s %= this._selectSets;
      SelectorManager.SelectSet[] sets = this._selectSet;
      if (sets != null) {
         SelectorManager.SelectSet set = sets[s];
         set.addChange(channel, att);
         set.wakeup();
      }

   }

   public void register(ServerSocketChannel acceptChannel) throws IOException {
      int s = this._set++;
      s %= this._selectSets;
      SelectorManager.SelectSet set = this._selectSet[s];
      set.addChange(acceptChannel);
      set.wakeup();
   }

   public long getLowResourcesConnections() {
      return this._lowResourcesConnections * (long)this._selectSets;
   }

   public void setLowResourcesConnections(long lowResourcesConnections) {
      this._lowResourcesConnections = (lowResourcesConnections + (long)this._selectSets - 1L) / (long)this._selectSets;
   }

   public long getLowResourcesMaxIdleTime() {
      return this._lowResourcesMaxIdleTime;
   }

   public void setLowResourcesMaxIdleTime(long lowResourcesMaxIdleTime) {
      this._lowResourcesMaxIdleTime = lowResourcesMaxIdleTime;
   }

   public void doSelect(int acceptorID) throws IOException {
      SelectorManager.SelectSet[] sets = this._selectSet;
      if (sets != null && sets.length > acceptorID && sets[acceptorID] != null) {
         sets[acceptorID].doSelect();
      }

   }

   public void setDelaySelectKeyUpdate(boolean delaySelectKeyUpdate) {
      this._delaySelectKeyUpdate = delaySelectKeyUpdate;
   }

   protected abstract SocketChannel acceptChannel(SelectionKey var1) throws IOException;

   public abstract boolean dispatch(Runnable var1) throws IOException;

   protected void doStart() throws Exception {
      this._selectSet = new SelectorManager.SelectSet[this._selectSets];

      for(int i = 0; i < this._selectSet.length; ++i) {
         this._selectSet[i] = new SelectorManager.SelectSet(i);
      }

      super.doStart();
   }

   protected void doStop() throws Exception {
      SelectorManager.SelectSet[] sets = this._selectSet;
      this._selectSet = null;
      if (sets != null) {
         for(int i = 0; i < sets.length; ++i) {
            SelectorManager.SelectSet set = sets[i];
            if (set != null) {
               set.stop();
            }
         }
      }

      super.doStop();
   }

   protected abstract void endPointClosed(SelectChannelEndPoint var1);

   protected abstract void endPointOpened(SelectChannelEndPoint var1);

   protected abstract Connection newConnection(SocketChannel var1, SelectChannelEndPoint var2);

   protected abstract SelectChannelEndPoint newEndPoint(SocketChannel var1, SelectorManager.SelectSet var2, SelectionKey var3) throws IOException;

   protected void connectionFailed(SocketChannel channel, Throwable ex, Object attachment) {
      Log.warn(ex);
   }

   private interface ChangeTask {
      void run();
   }

   private static class ChangeSelectableChannel {
      final SelectableChannel _channel;
      final Object _attachment;

      public ChangeSelectableChannel(SelectableChannel channel, Object attachment) {
         this._channel = channel;
         this._attachment = attachment;
      }
   }

   public class SelectSet {
      private transient int _change;
      private transient List[] _changes;
      private transient Timeout _idleTimeout;
      private transient int _nextSet;
      private transient Timeout _retryTimeout;
      private transient Selector _selector;
      private transient int _setID;
      private volatile boolean _selecting;
      private transient int _jvmBug;
      private int _selects;
      private long _monitorStart;
      private long _monitorNext;
      private boolean _pausing;
      private SelectionKey _busyKey;
      private int _busyKeyCount;
      private long _log;
      private int _paused;
      private int _jvmFix0;
      private int _jvmFix1;
      private int _jvmFix2;

      SelectSet(int acceptorID) throws Exception {
         this._setID = acceptorID;
         this._idleTimeout = new Timeout(this);
         this._idleTimeout.setDuration(SelectorManager.this.getMaxIdleTime());
         this._retryTimeout = new Timeout(this);
         this._retryTimeout.setDuration(0L);
         this._selector = Selector.open();
         this._changes = new ArrayList[]{new ArrayList(), new ArrayList()};
         this._change = 0;
         this._monitorStart = System.currentTimeMillis();
         this._monitorNext = this._monitorStart + (long)SelectorManager.__MONITOR_PERIOD;
         this._log = this._monitorStart + 60000L;
      }

      public void addChange(Object point) {
         synchronized(this._changes) {
            this._changes[this._change].add(point);
         }
      }

      public void addChange(SelectableChannel channel, Object att) {
         if (att == null) {
            this.addChange(channel);
         } else if (att instanceof EndPoint) {
            this.addChange(att);
         } else {
            this.addChange(new SelectorManager.ChangeSelectableChannel(channel, att));
         }

      }

      public void cancelIdle(Timeout.Task task) {
         synchronized(this) {
            task.cancel();
         }
      }

      public void doSelect() throws IOException {
         SelectionKey key = null;

         try {
            List changes;
            Selector selector;
            synchronized(this._changes) {
               changes = this._changes[this._change];
               this._change = this._change == 0 ? 1 : 0;
               this._selecting = true;
               selector = this._selector;
            }

            try {
               for(int i = 0; i < changes.size(); ++i) {
                  try {
                     Object o = changes.get(i);
                     if (o instanceof EndPoint) {
                        SelectChannelEndPoint endpointx = (SelectChannelEndPoint)o;
                        endpointx.doUpdateKey();
                     } else if (o instanceof Runnable) {
                        SelectorManager.this.dispatch((Runnable)o);
                     } else if (o instanceof SelectorManager.ChangeSelectableChannel) {
                        SelectorManager.ChangeSelectableChannel asc = (SelectorManager.ChangeSelectableChannel)o;
                        SelectableChannel channelxx = asc._channel;
                        Object att = asc._attachment;
                        if (channelxx instanceof SocketChannel && ((SocketChannel)channelxx).isConnected()) {
                           key = channelxx.register(selector, 1, att);
                           SelectChannelEndPoint endpointxx = SelectorManager.this.newEndPoint((SocketChannel)channelxx, this, key);
                           key.attach(endpointxx);
                           endpointxx.dispatch();
                        } else if (channelxx.isOpen()) {
                           channelxx.register(selector, 8, att);
                        }
                     } else if (o instanceof SocketChannel) {
                        SocketChannel channelx = (SocketChannel)o;
                        if (channelx.isConnected()) {
                           key = channelx.register(selector, 1, (Object)null);
                           SelectChannelEndPoint endpoint = SelectorManager.this.newEndPoint(channelx, this, key);
                           key.attach(endpoint);
                           endpoint.dispatch();
                        } else if (channelx.isOpen()) {
                           channelx.register(selector, 8, (Object)null);
                        }
                     } else if (o instanceof ServerSocketChannel) {
                        ServerSocketChannel channel = (ServerSocketChannel)o;
                        channel.register(this.getSelector(), 16);
                     } else {
                        if (!(o instanceof SelectorManager.ChangeTask)) {
                           throw new IllegalArgumentException(o.toString());
                        }

                        ((SelectorManager.ChangeTask)o).run();
                     }
                  } catch (Exception var82) {
                     if (SelectorManager.this.isRunning()) {
                        Log.warn((Throwable)var82);
                     } else {
                        Log.debug((Throwable)var82);
                     }
                  } catch (Error var83) {
                     if (SelectorManager.this.isRunning()) {
                        Log.warn((Throwable)var83);
                     } else {
                        Log.debug((Throwable)var83);
                     }
                  }
               }
            } finally {
               changes.clear();
            }

            long idle_next = 0L;
            long retry_next = 0L;
            long now = System.currentTimeMillis();
            synchronized(this) {
               this._idleTimeout.setNow(now);
               this._retryTimeout.setNow(now);
               if (SelectorManager.this._lowResourcesConnections > 0L && (long)selector.keys().size() > SelectorManager.this._lowResourcesConnections) {
                  this._idleTimeout.setDuration(SelectorManager.this._lowResourcesMaxIdleTime);
               } else {
                  this._idleTimeout.setDuration(SelectorManager.this._maxIdleTime);
               }

               idle_next = this._idleTimeout.getTimeToNext();
               retry_next = this._retryTimeout.getTimeToNext();
            }

            long wait = 1000L;
            if (idle_next >= 0L && wait > idle_next) {
               wait = idle_next;
            }

            if (wait > 0L && retry_next >= 0L && wait > retry_next) {
               wait = retry_next;
            }

            SelectionKey cKey;
            final SelectChannelEndPoint endpointxxxxx;
            if (wait > 2L) {
               if (this._pausing) {
                  try {
                     Thread.sleep((long)SelectorManager.__BUSY_PAUSE);
                  } catch (InterruptedException var76) {
                     Log.ignore(var76);
                  }
               }

               long before = now;
               int selected = selector.select(wait);
               now = System.currentTimeMillis();
               this._idleTimeout.setNow(now);
               this._retryTimeout.setNow(now);
               ++this._selects;
               if (now > this._monitorNext) {
                  this._selects = (int)((long)(this._selects * SelectorManager.__MONITOR_PERIOD) / (now - this._monitorStart));
                  this._pausing = this._selects > SelectorManager.__MAX_SELECTS;
                  if (this._pausing) {
                     ++this._paused;
                  }

                  this._selects = 0;
                  this._jvmBug = 0;
                  this._monitorStart = now;
                  this._monitorNext = now + (long)SelectorManager.__MONITOR_PERIOD;
               }

               if (now > this._log) {
                  if (this._paused > 0) {
                     Log.info(this + " Busy selector - injecting delay " + this._paused + " times");
                  }

                  if (this._jvmFix2 > 0) {
                     Log.info(this + " JVM BUG(s) - injecting delay" + this._jvmFix2 + " times");
                  }

                  if (this._jvmFix1 > 0) {
                     Log.info(this + " JVM BUG(s) - recreating selector " + this._jvmFix1 + " times, canceled keys " + this._jvmFix0 + " times");
                  } else if (Log.isDebugEnabled() && this._jvmFix0 > 0) {
                     Log.info(this + " JVM BUG(s) - canceled keys " + this._jvmFix0 + " times");
                  }

                  this._paused = 0;
                  this._jvmFix2 = 0;
                  this._jvmFix1 = 0;
                  this._jvmFix0 = 0;
                  this._log = now + 60000L;
               }

               if (selected == 0 && wait > 10L && now - before < wait / 2L) {
                  ++this._jvmBug;
                  if (this._jvmBug > SelectorManager.__JVMBUG_THRESHHOLD) {
                     try {
                        if (this._jvmBug == SelectorManager.__JVMBUG_THRESHHOLD + 1) {
                           ++this._jvmFix2;
                        }

                        Thread.sleep((long)SelectorManager.__BUSY_PAUSE);
                     } catch (InterruptedException var75) {
                        Log.ignore(var75);
                     }
                  } else {
                     if (this._jvmBug == SelectorManager.__JVMBUG_THRESHHOLD) {
                        synchronized(this) {
                           ++this._jvmFix1;
                           Selector new_selector = Selector.open();
                           Iterator iterator = this._selector.keys().iterator();

                           while(iterator.hasNext()) {
                              SelectionKey kx = (SelectionKey)iterator.next();
                              if (kx.isValid() && kx.interestOps() != 0) {
                                 SelectableChannel channelxxxx = kx.channel();
                                 Object attachment = kx.attachment();
                                 if (attachment == null) {
                                    this.addChange(channelxxxx);
                                 } else {
                                    this.addChange(channelxxxx, attachment);
                                 }
                              }
                           }

                           Selector old_selector = this._selector;
                           this._selector = new_selector;

                           try {
                              old_selector.close();
                           } catch (Exception var74) {
                              Log.warn((Throwable)var74);
                           }

                           return;
                        }
                     }

                     if (this._jvmBug % 32 == 31) {
                        int cancelled = 0;
                        Iterator iterx = selector.keys().iterator();

                        while(iterx.hasNext()) {
                           SelectionKey k = (SelectionKey)iterx.next();
                           if (k.isValid() && k.interestOps() == 0) {
                              k.cancel();
                              ++cancelled;
                           }
                        }

                        if (cancelled > 0) {
                           ++this._jvmFix0;
                        }

                        return;
                     }
                  }
               } else if (SelectorManager.__BUSY_KEY > 0 && selected == 1 && this._selects > SelectorManager.__MAX_SELECTS) {
                  cKey = (SelectionKey)selector.selectedKeys().iterator().next();
                  if (cKey == this._busyKey) {
                     if (++this._busyKeyCount > SelectorManager.__BUSY_KEY && !(cKey.channel() instanceof ServerSocketChannel)) {
                        endpointxxxxx = (SelectChannelEndPoint)cKey.attachment();
                        Log.warn("Busy Key " + cKey.channel() + " " + endpointxxxxx);
                        cKey.cancel();
                        if (endpointxxxxx != null) {
                           SelectorManager.this.dispatch(new Runnable() {
                              public void run() {
                                 try {
                                    endpointxxxxx.close();
                                 } catch (IOException var2) {
                                    Log.ignore(var2);
                                 }

                              }
                           });
                        }
                     }
                  } else {
                     this._busyKeyCount = 0;
                  }

                  this._busyKey = cKey;
               }
            } else {
               selector.selectNow();
               ++this._selects;
            }

            if (this._selector != null && selector.isOpen()) {
               Iterator iter = selector.selectedKeys().iterator();

               while(iter.hasNext()) {
                  key = (SelectionKey)iter.next();

                  try {
                     if (!key.isValid()) {
                        key.cancel();
                        SelectChannelEndPoint endpointxxx = (SelectChannelEndPoint)key.attachment();
                        if (endpointxxx != null) {
                           endpointxxx.doUpdateKey();
                        }
                     } else {
                        Object attx = key.attachment();
                        if (attx instanceof SelectChannelEndPoint) {
                           SelectChannelEndPoint endpointxxxx = (SelectChannelEndPoint)attx;
                           endpointxxxx.dispatch();
                        } else {
                           SocketChannel channelxxx;
                           if (key.isAcceptable()) {
                              channelxxx = SelectorManager.this.acceptChannel(key);
                              if (channelxxx == null) {
                                 continue;
                              }

                              channelxxx.configureBlocking(false);
                              this._nextSet = ++this._nextSet % SelectorManager.this._selectSet.length;
                              if (this._nextSet == this._setID) {
                                 cKey = channelxxx.register(SelectorManager.this._selectSet[this._nextSet].getSelector(), 1);
                                 endpointxxxxx = SelectorManager.this.newEndPoint(channelxxx, SelectorManager.this._selectSet[this._nextSet], cKey);
                                 cKey.attach(endpointxxxxx);
                                 if (endpointxxxxx != null) {
                                    endpointxxxxx.dispatch();
                                 }
                              } else {
                                 SelectorManager.this._selectSet[this._nextSet].addChange(channelxxx);
                                 SelectorManager.this._selectSet[this._nextSet].wakeup();
                              }
                           } else if (key.isConnectable()) {
                              label1510: {
                                 channelxxx = (SocketChannel)key.channel();
                                 boolean connected = false;
                                 boolean var57 = false;

                                 label1398: {
                                    try {
                                       var57 = true;
                                       connected = channelxxx.finishConnect();
                                       var57 = false;
                                       break label1398;
                                    } catch (Exception var78) {
                                       SelectorManager.this.connectionFailed(channelxxx, var78, attx);
                                       var57 = false;
                                    } finally {
                                       if (var57) {
                                          if (connected) {
                                             key.interestOps(1);
                                             SelectChannelEndPoint endpointxxxxxxx = SelectorManager.this.newEndPoint(channelxxx, this, key);
                                             key.attach(endpointxxxxxxx);
                                             endpointxxxxxxx.dispatch();
                                          } else {
                                             key.cancel();
                                          }

                                       }
                                    }

                                    if (connected) {
                                       key.interestOps(1);
                                       endpointxxxxx = SelectorManager.this.newEndPoint(channelxxx, this, key);
                                       key.attach(endpointxxxxx);
                                       endpointxxxxx.dispatch();
                                    } else {
                                       key.cancel();
                                    }
                                    break label1510;
                                 }

                                 if (connected) {
                                    key.interestOps(1);
                                    endpointxxxxx = SelectorManager.this.newEndPoint(channelxxx, this, key);
                                    key.attach(endpointxxxxx);
                                    endpointxxxxx.dispatch();
                                 } else {
                                    key.cancel();
                                 }
                              }
                           } else {
                              channelxxx = (SocketChannel)key.channel();
                              SelectChannelEndPoint endpointxxxxxx = SelectorManager.this.newEndPoint(channelxxx, this, key);
                              key.attach(endpointxxxxxx);
                              if (key.isReadable()) {
                                 endpointxxxxxx.dispatch();
                              }
                           }
                        }

                        key = null;
                     }
                  } catch (CancelledKeyException var80) {
                     Log.ignore(var80);
                  } catch (Exception var81) {
                     if (SelectorManager.this.isRunning()) {
                        Log.warn((Throwable)var81);
                     } else {
                        Log.ignore(var81);
                     }

                     if (key != null && !(key.channel() instanceof ServerSocketChannel) && key.isValid()) {
                        key.interestOps(0);
                        key.cancel();
                     }
                  }
               }

               selector.selectedKeys().clear();
               this._idleTimeout.tick(now);
               this._retryTimeout.tick(now);
            }
         } catch (ClosedSelectorException var87) {
            Log.warn((Throwable)var87);
         } catch (CancelledKeyException var88) {
            Log.ignore(var88);
         } finally {
            this._selecting = false;
         }
      }

      public SelectorManager getManager() {
         return SelectorManager.this;
      }

      public long getNow() {
         return this._idleTimeout.getNow();
      }

      public void scheduleIdle(Timeout.Task task) {
         synchronized(this) {
            if (this._idleTimeout.getDuration() > 0L) {
               task.schedule(this._idleTimeout);
            }
         }
      }

      public void scheduleTimeout(Timeout.Task task, long timeout) {
         synchronized(this) {
            this._retryTimeout.schedule(task, timeout);
         }
      }

      public void wakeup() {
         Selector selector = this._selector;
         if (selector != null) {
            selector.wakeup();
         }

      }

      Selector getSelector() {
         return this._selector;
      }

      void stop() throws Exception {
         boolean selecting;
         for(selecting = true; selecting; selecting = this._selecting) {
            this.wakeup();
         }

         ArrayList keys = new ArrayList(this._selector.keys());
         Iterator iter = keys.iterator();

         while(iter.hasNext()) {
            SelectionKey key = (SelectionKey)iter.next();
            if (key != null) {
               Object att = key.attachment();
               if (att instanceof EndPoint) {
                  EndPoint endpoint = (EndPoint)att;

                  try {
                     endpoint.close();
                  } catch (IOException var10) {
                     Log.ignore(var10);
                  }
               }
            }
         }

         synchronized(this) {
            for(selecting = this._selecting; selecting; selecting = this._selecting) {
               this.wakeup();
            }

            this._idleTimeout.cancelAll();
            this._retryTimeout.cancelAll();

            try {
               if (this._selector != null) {
                  this._selector.close();
               }
            } catch (IOException var9) {
               Log.ignore(var9);
            }

            this._selector = null;
         }
      }
   }
}
