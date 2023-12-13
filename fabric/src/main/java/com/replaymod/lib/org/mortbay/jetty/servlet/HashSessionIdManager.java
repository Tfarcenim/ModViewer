package com.replaymod.lib.org.mortbay.jetty.servlet;

import com.replaymod.lib.org.mortbay.component.AbstractLifeCycle;
import com.replaymod.lib.org.mortbay.jetty.SessionIdManager;
import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.util.MultiMap;
import java.security.SecureRandom;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class HashSessionIdManager extends AbstractLifeCycle implements SessionIdManager {
   private static final String __NEW_SESSION_ID = "com.replaymod.lib.org.mortbay.jetty.newSessionId";
   MultiMap _sessions;
   protected Random _random;
   private boolean _weakRandom;
   private String _workerName;

   public HashSessionIdManager() {
   }

   public HashSessionIdManager(Random random) {
      this._random = random;
   }

   public String getWorkerName() {
      return this._workerName;
   }

   public void setWorkerName(String workerName) {
      this._workerName = workerName;
   }

   public String getNodeId(String clusterId, HttpServletRequest request) {
      String worker = request == null ? null : (String)request.getAttribute("com.replaymod.lib.org.mortbay.http.ajp.JVMRoute");
      if (worker != null) {
         return clusterId + '.' + worker;
      } else {
         return this._workerName != null ? clusterId + '.' + this._workerName : clusterId;
      }
   }

   public String getClusterId(String nodeId) {
      int dot = nodeId.lastIndexOf(46);
      return dot > 0 ? nodeId.substring(0, dot) : nodeId;
   }

   protected void doStart() {
      if (this._random == null) {
         try {
            Log.debug("Init SecureRandom.");
            this._random = new SecureRandom();
         } catch (Exception var2) {
            Log.warn("Could not generate SecureRandom for session-id randomness", (Throwable)var2);
            this._random = new Random();
            this._weakRandom = true;
         }
      }

      this._sessions = new MultiMap();
   }

   protected void doStop() {
      if (this._sessions != null) {
         this._sessions.clear();
      }

      this._sessions = null;
   }

   public boolean idInUse(String id) {
      return this._sessions.containsKey(id);
   }

   public void addSession(HttpSession session) {
      synchronized(this) {
         this._sessions.add(this.getClusterId(session.getId()), session);
      }
   }

   public void removeSession(HttpSession session) {
      synchronized(this) {
         this._sessions.removeValue(this.getClusterId(session.getId()), session);
      }
   }

   public void invalidateAll(String id) {
      while(true) {
         AbstractSessionManager.Session session = null;
         synchronized(this) {
            if (!this._sessions.containsKey(id)) {
               return;
            }

            session = (AbstractSessionManager.Session)this._sessions.getValue(id, 0);
            this._sessions.removeValue(id, session);
         }

         if (session.isValid()) {
            session.invalidate();
         }
      }
   }

   public String newSessionId(HttpServletRequest request, long created) {
      synchronized(this) {
         String requested_id = request.getRequestedSessionId();
         String new_id;
         if (requested_id != null) {
            new_id = this.getClusterId(requested_id);
            if (this.idInUse(new_id)) {
               return new_id;
            }
         }

         new_id = (String)request.getAttribute("com.replaymod.lib.org.mortbay.jetty.newSessionId");
         if (new_id != null && this.idInUse(new_id)) {
            return new_id;
         } else {
            String id;
            long r0;
            long r1;
            for(id = null; id == null || id.length() == 0 || this.idInUse(id); id = Long.toString(r0, 36) + Long.toString(r1, 36)) {
               r0 = this._weakRandom ? (long)this.hashCode() ^ Runtime.getRuntime().freeMemory() ^ (long)this._random.nextInt() ^ (long)request.hashCode() << 32 : this._random.nextLong();
               r1 = this._random.nextLong();
               if (r0 < 0L) {
                  r0 = -r0;
               }

               if (r1 < 0L) {
                  r1 = -r1;
               }
            }

            if (this._workerName != null) {
               id = this._workerName + id;
            }

            request.setAttribute("com.replaymod.lib.org.mortbay.jetty.newSessionId", id);
            return id;
         }
      }
   }

   public Random getRandom() {
      return this._random;
   }

   public void setRandom(Random random) {
      this._random = random;
      this._weakRandom = false;
   }
}
