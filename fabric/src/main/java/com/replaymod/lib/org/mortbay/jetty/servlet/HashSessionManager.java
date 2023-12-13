package com.replaymod.lib.org.mortbay.jetty.servlet;

import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.util.LazyList;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;

public class HashSessionManager extends AbstractSessionManager {
   private Timer _timer;
   private TimerTask _task;
   private int _scavengePeriodMs = 30000;
   private int _savePeriodMs = 0;
   private TimerTask _saveTask;
   protected Map _sessions;
   private File _storeDir;
   private boolean _lazyLoad = false;
   private boolean _sessionsLoaded = false;

   public void doStart() throws Exception {
      this._sessions = new HashMap();
      super.doStart();
      this._timer = new Timer(true);
      this.setScavengePeriod(this.getScavengePeriod());
      if (this._storeDir != null) {
         if (!this._storeDir.exists()) {
            this._storeDir.mkdir();
         }

         if (!this._lazyLoad) {
            this.restoreSessions();
         }
      }

      this.setSavePeriod(this.getSavePeriod());
   }

   public void doStop() throws Exception {
      if (this._storeDir != null) {
         this.saveSessions();
      }

      super.doStop();
      this._sessions.clear();
      this._sessions = null;
      synchronized(this) {
         if (this._saveTask != null) {
            this._saveTask.cancel();
         }

         if (this._task != null) {
            this._task.cancel();
         }

         if (this._timer != null) {
            this._timer.cancel();
         }

         this._timer = null;
      }
   }

   public int getScavengePeriod() {
      return this._scavengePeriodMs / 1000;
   }

   public Map getSessionMap() {
      return Collections.unmodifiableMap(this._sessions);
   }

   public int getSessions() {
      return this._sessions.size();
   }

   public void setMaxInactiveInterval(int seconds) {
      super.setMaxInactiveInterval(seconds);
      if (this._dftMaxIdleSecs > 0 && this._scavengePeriodMs > this._dftMaxIdleSecs * 1000) {
         this.setScavengePeriod((this._dftMaxIdleSecs + 9) / 10);
      }

   }

   public void setSavePeriod(int seconds) {
      int oldSavePeriod = this._savePeriodMs;
      int period = seconds * 1000;
      if (period < 0) {
         period = 0;
      }

      this._savePeriodMs = period;
      if (this._timer != null) {
         synchronized(this) {
            if (this._saveTask != null) {
               this._saveTask.cancel();
            }

            if (this._savePeriodMs > 0 && this._storeDir != null) {
               this._saveTask = new TimerTask() {
                  public void run() {
                     try {
                        HashSessionManager.this.saveSessions();
                     } catch (Exception var2) {
                        Log.warn((Throwable)var2);
                     }

                  }
               };
               this._timer.schedule(this._saveTask, (long)this._savePeriodMs, (long)this._savePeriodMs);
            }
         }
      }

   }

   public int getSavePeriod() {
      return this._savePeriodMs <= 0 ? 0 : this._savePeriodMs / 1000;
   }

   public void setScavengePeriod(int seconds) {
      if (seconds == 0) {
         seconds = 60;
      }

      int old_period = this._scavengePeriodMs;
      int period = seconds * 1000;
      if (period > 60000) {
         period = 60000;
      }

      if (period < 1000) {
         period = 1000;
      }

      this._scavengePeriodMs = period;
      if (this._timer != null && (period != old_period || this._task == null)) {
         synchronized(this) {
            if (this._task != null) {
               this._task.cancel();
            }

            this._task = new TimerTask() {
               public void run() {
                  HashSessionManager.this.scavenge();
               }
            };
            this._timer.schedule(this._task, (long)this._scavengePeriodMs, (long)this._scavengePeriodMs);
         }
      }

   }

   private void scavenge() {
      if (!this.isStopping() && !this.isStopped()) {
         Thread thread = Thread.currentThread();
         ClassLoader old_loader = thread.getContextClassLoader();

         try {
            if (this._loader != null) {
               thread.setContextClassLoader(this._loader);
            }

            long now = System.currentTimeMillis();

            try {
               if (!this._sessionsLoaded && this._lazyLoad) {
                  this.restoreSessions();
               }
            } catch (Exception var17) {
               Log.debug((Throwable)var17);
            }

            Object stale = null;
            synchronized(this) {
               Iterator i = this._sessions.values().iterator();

               while(i.hasNext()) {
                  HashSessionManager.Session session = (HashSessionManager.Session)i.next();
                  long idleTime = session._maxIdleMs;
                  if (idleTime > 0L && session._accessed + idleTime < now) {
                     stale = LazyList.add(stale, session);
                  }
               }
            }

            int i = LazyList.size(stale);

            while(i-- > 0) {
               HashSessionManager.Session session = (HashSessionManager.Session)LazyList.get(stale, i);
               long idleTime = session._maxIdleMs;
               if (idleTime > 0L && session._accessed + idleTime < System.currentTimeMillis()) {
                  session.timeout();
                  int nbsess = this._sessions.size();
                  if (nbsess < this._minSessions) {
                     this._minSessions = nbsess;
                  }
               }
            }
         } catch (Throwable var19) {
            if (var19 instanceof ThreadDeath) {
               throw (ThreadDeath)var19;
            }

            Log.warn("Problem scavenging sessions", var19);
         } finally {
            thread.setContextClassLoader(old_loader);
         }

      }
   }

   protected void addSession(AbstractSessionManager.Session session) {
      this._sessions.put(session.getClusterId(), session);
   }

   public AbstractSessionManager.Session getSession(String idInCluster) {
      try {
         if (!this._sessionsLoaded && this._lazyLoad) {
            this.restoreSessions();
         }
      } catch (Exception var3) {
         Log.warn((Throwable)var3);
      }

      return this._sessions == null ? null : (HashSessionManager.Session)this._sessions.get(idInCluster);
   }

   protected void invalidateSessions() {
      ArrayList sessions = new ArrayList(this._sessions.values());
      Iterator i = sessions.iterator();

      while(i.hasNext()) {
         HashSessionManager.Session session = (HashSessionManager.Session)i.next();
         session.invalidate();
      }

      this._sessions.clear();
   }

   protected AbstractSessionManager.Session newSession(HttpServletRequest request) {
      return new HashSessionManager.Session(request);
   }

   protected void removeSession(String clusterId) {
      this._sessions.remove(clusterId);
   }

   public void setStoreDirectory(File dir) {
      this._storeDir = dir;
   }

   public File getStoreDirectory() {
      return this._storeDir;
   }

   public void setLazyLoad(boolean lazyLoad) {
      this._lazyLoad = lazyLoad;
   }

   public boolean isLazyLoad() {
      return this._lazyLoad;
   }

   public void restoreSessions() throws Exception {
      if (this._storeDir != null && this._storeDir.exists()) {
         if (!this._storeDir.canRead()) {
            Log.warn("Unable to restore Sessions: Cannot read from Session storage directory " + this._storeDir.getAbsolutePath());
         } else {
            File[] files = this._storeDir.listFiles();

            for(int i = 0; files != null && i < files.length; ++i) {
               try {
                  FileInputStream in = new FileInputStream(files[i]);
                  HashSessionManager.Session session = this.restoreSession(in);
                  in.close();
                  this.addSession(session, false);
                  files[i].delete();
               } catch (Exception var5) {
                  Log.warn("Problem restoring session " + files[i].getName(), (Throwable)var5);
               }
            }

            this._sessionsLoaded = true;
         }
      }
   }

   public void saveSessions() throws Exception {
      if (this._storeDir != null && this._storeDir.exists()) {
         if (!this._storeDir.canWrite()) {
            Log.warn("Unable to save Sessions: Session persistence storage directory " + this._storeDir.getAbsolutePath() + " is not writeable");
         } else {
            synchronized(this) {
               Iterator itor = this._sessions.entrySet().iterator();

               while(itor.hasNext()) {
                  Entry entry = (Entry)itor.next();
                  String id = (String)entry.getKey();
                  HashSessionManager.Session session = (HashSessionManager.Session)entry.getValue();

                  try {
                     File file = new File(this._storeDir, id);
                     if (file.exists()) {
                        file.delete();
                     }

                     file.createNewFile();
                     FileOutputStream fos = new FileOutputStream(file);
                     session.save(fos);
                     fos.close();
                  } catch (Exception var9) {
                     Log.warn("Problem persisting session " + id, (Throwable)var9);
                  }
               }

            }
         }
      }
   }

   public HashSessionManager.Session restoreSession(FileInputStream fis) throws Exception {
      DataInputStream in = new DataInputStream(fis);
      String clusterId = in.readUTF();
      String nodeId = in.readUTF();
      boolean idChanged = in.readBoolean();
      long created = in.readLong();
      long cookieSet = in.readLong();
      long accessed = in.readLong();
      long lastAccessed = in.readLong();
      int requests = in.readInt();
      HashSessionManager.Session session = new HashSessionManager.Session(created, clusterId);
      session._cookieSet = cookieSet;
      session._lastAccessed = lastAccessed;
      int size = in.readInt();
      if (size > 0) {
         ArrayList keys = new ArrayList();

         for(int i = 0; i < size; ++i) {
            String key = in.readUTF();
            keys.add(key);
         }

         HashSessionManager.ClassLoadingObjectInputStream ois = new HashSessionManager.ClassLoadingObjectInputStream(in);

         for(int i = 0; i < size; ++i) {
            Object value = ois.readObject();
            session.setAttribute((String)keys.get(i), value);
         }

         ois.close();
      } else {
         session.initValues();
      }

      in.close();
      return session;
   }

   protected class ClassLoadingObjectInputStream extends ObjectInputStream {
      public ClassLoadingObjectInputStream(InputStream in) throws IOException {
         super(in);
      }

      public ClassLoadingObjectInputStream() throws IOException {
      }

      public Class resolveClass(ObjectStreamClass cl) throws IOException, ClassNotFoundException {
         try {
            return Class.forName(cl.getName(), false, Thread.currentThread().getContextClassLoader());
         } catch (ClassNotFoundException var4) {
            return super.resolveClass(cl);
         }
      }
   }

   protected class Session extends AbstractSessionManager.Session {
      private static final long serialVersionUID = -2134521374206116367L;

      protected Session(HttpServletRequest request) {
         super(request);
      }

      protected Session(long created, String clusterId) {
         super(created, clusterId);
      }

      public void setMaxInactiveInterval(int secs) {
         super.setMaxInactiveInterval(secs);
         if (this._maxIdleMs > 0L && this._maxIdleMs / 10L < (long)HashSessionManager.this._scavengePeriodMs) {
            HashSessionManager.this.setScavengePeriod((secs + 9) / 10);
         }

      }

      protected Map newAttributeMap() {
         return new HashMap(3);
      }

      public void invalidate() throws IllegalStateException {
         super.invalidate();
         this.remove(this.getId());
      }

      public void remove(String id) {
         if (id != null) {
            if (!HashSessionManager.this.isStopping() && !HashSessionManager.this.isStopped()) {
               if (HashSessionManager.this._storeDir != null && HashSessionManager.this._storeDir.exists()) {
                  File f = new File(HashSessionManager.this._storeDir, id);
                  f.delete();
               }
            }
         }
      }

      public void save(FileOutputStream fos) throws IOException {
         DataOutputStream out = new DataOutputStream(fos);
         out.writeUTF(this._clusterId);
         out.writeUTF(this._nodeId);
         out.writeBoolean(this._idChanged);
         out.writeLong(this._created);
         out.writeLong(this._cookieSet);
         out.writeLong(this._accessed);
         out.writeLong(this._lastAccessed);
         out.writeInt(this._requests);
         if (this._values != null) {
            out.writeInt(this._values.size());
            Iterator itor = this._values.keySet().iterator();

            while(itor.hasNext()) {
               String key = (String)itor.next();
               out.writeUTF(key);
            }

            itor = this._values.values().iterator();
            ObjectOutputStream oos = new ObjectOutputStream(out);

            while(itor.hasNext()) {
               oos.writeObject(itor.next());
            }

            oos.close();
         } else {
            out.writeInt(0);
         }

         out.close();
      }
   }
}
