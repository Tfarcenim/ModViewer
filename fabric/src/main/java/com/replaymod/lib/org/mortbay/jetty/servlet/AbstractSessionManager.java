package com.replaymod.lib.org.mortbay.jetty.servlet;

import com.replaymod.lib.org.mortbay.component.AbstractLifeCycle;
import com.replaymod.lib.org.mortbay.jetty.HttpOnlyCookie;
import com.replaymod.lib.org.mortbay.jetty.Server;
import com.replaymod.lib.org.mortbay.jetty.SessionIdManager;
import com.replaymod.lib.org.mortbay.jetty.SessionManager;
import com.replaymod.lib.org.mortbay.jetty.handler.ContextHandler;
import com.replaymod.lib.org.mortbay.util.LazyList;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public abstract class AbstractSessionManager extends AbstractLifeCycle implements SessionManager {
   public static final int __distantFuture = 628992000;
   private static final HttpSessionContext __nullSessionContext = new AbstractSessionManager.NullSessionContext();
   private boolean _usingCookies = true;
   protected int _dftMaxIdleSecs = -1;
   protected SessionHandler _sessionHandler;
   protected boolean _httpOnly = false;
   protected int _maxSessions = 0;
   protected int _minSessions = 0;
   protected SessionIdManager _sessionIdManager;
   protected boolean _secureCookies = false;
   protected Object _sessionAttributeListeners;
   protected Object _sessionListeners;
   protected ClassLoader _loader;
   protected ContextHandler.SContext _context;
   protected String _sessionCookie = "JSESSIONID";
   protected String _sessionURL = "jsessionid";
   protected String _sessionURLPrefix;
   protected String _sessionDomain;
   protected String _sessionPath;
   protected int _maxCookieAge;
   protected int _refreshCookieAge;
   protected boolean _nodeIdInSessionId;

   public AbstractSessionManager() {
      this._sessionURLPrefix = ";" + this._sessionURL + "=";
      this._maxCookieAge = -1;
   }

   public Cookie access(HttpSession session, boolean secure) {
      long now = System.currentTimeMillis();
      AbstractSessionManager.Session s = ((AbstractSessionManager.SessionIf)session).getSession();
      s.access(now);
      if (!this.isUsingCookies() || !s.isIdChanged() && (this.getMaxCookieAge() <= 0 || this.getRefreshCookieAge() <= 0 || (now - s.getCookieSetTime()) / 1000L <= (long)this.getRefreshCookieAge())) {
         return null;
      } else {
         Cookie cookie = this.getSessionCookie(session, this._context.getContextPath(), secure);
         s.cookieSet();
         s.setIdChanged(false);
         return cookie;
      }
   }

   public void addEventListener(EventListener listener) {
      if (listener instanceof HttpSessionAttributeListener) {
         this._sessionAttributeListeners = LazyList.add(this._sessionAttributeListeners, listener);
      }

      if (listener instanceof HttpSessionListener) {
         this._sessionListeners = LazyList.add(this._sessionListeners, listener);
      }

   }

   public void clearEventListeners() {
      this._sessionAttributeListeners = null;
      this._sessionListeners = null;
   }

   public void complete(HttpSession session) {
      AbstractSessionManager.Session s = ((AbstractSessionManager.SessionIf)session).getSession();
      s.complete();
   }

   public void doStart() throws Exception {
      this._context = ContextHandler.getCurrentContext();
      this._loader = Thread.currentThread().getContextClassLoader();
      if (this._sessionIdManager == null) {
         Server server = this.getSessionHandler().getServer();
         synchronized(server) {
            this._sessionIdManager = server.getSessionIdManager();
            if (this._sessionIdManager == null) {
               this._sessionIdManager = new HashSessionIdManager();
               server.setSessionIdManager(this._sessionIdManager);
            }
         }
      }

      if (!this._sessionIdManager.isStarted()) {
         this._sessionIdManager.start();
      }

      if (this._context != null) {
         String tmp = this._context.getInitParameter("com.replaymod.lib.org.mortbay.jetty.servlet.SessionCookie");
         if (tmp != null) {
            this._sessionCookie = tmp;
         }

         tmp = this._context.getInitParameter("com.replaymod.lib.org.mortbay.jetty.servlet.SessionURL");
         if (tmp != null) {
            this._sessionURL = tmp != null && !"none".equals(tmp) ? tmp : null;
            this._sessionURLPrefix = tmp != null && !"none".equals(tmp) ? ";" + this._sessionURL + "=" : null;
         }

         if (this._maxCookieAge == -1) {
            tmp = this._context.getInitParameter("com.replaymod.lib.org.mortbay.jetty.servlet.MaxAge");
            if (tmp != null) {
               this._maxCookieAge = Integer.parseInt(tmp.trim());
            }
         }

         if (this._sessionDomain == null) {
            this._sessionDomain = this._context.getInitParameter("com.replaymod.lib.org.mortbay.jetty.servlet.SessionDomain");
         }

         if (this._sessionPath == null) {
            this._sessionPath = this._context.getInitParameter("com.replaymod.lib.org.mortbay.jetty.servlet.SessionPath");
         }
      }

      super.doStart();
   }

   public void doStop() throws Exception {
      super.doStop();
      this.invalidateSessions();
      this._loader = null;
   }

   public boolean getHttpOnly() {
      return this._httpOnly;
   }

   public HttpSession getHttpSession(String nodeId) {
      String cluster_id = this.getIdManager().getClusterId(nodeId);
      synchronized(this) {
         AbstractSessionManager.Session session = this.getSession(cluster_id);
         if (session != null && !session.getNodeId().equals(nodeId)) {
            session.setIdChanged(true);
         }

         return session;
      }
   }

   public SessionIdManager getIdManager() {
      return this._sessionIdManager;
   }

   public int getMaxCookieAge() {
      return this._maxCookieAge;
   }

   public int getMaxInactiveInterval() {
      return this._dftMaxIdleSecs;
   }

   public int getMaxSessions() {
      return this._maxSessions;
   }

   /** @deprecated */
   public SessionIdManager getMetaManager() {
      return this.getIdManager();
   }

   public int getMinSessions() {
      return this._minSessions;
   }

   public int getRefreshCookieAge() {
      return this._refreshCookieAge;
   }

   public boolean getSecureCookies() {
      return this._secureCookies;
   }

   public String getSessionCookie() {
      return this._sessionCookie;
   }

   public Cookie getSessionCookie(HttpSession session, String contextPath, boolean requestIsSecure) {
      if (this.isUsingCookies()) {
         String id = this.getNodeId(session);
         Cookie cookie = this.getHttpOnly() ? new HttpOnlyCookie(this._sessionCookie, id) : new Cookie(this._sessionCookie, id);
         ((Cookie)cookie).setPath(contextPath != null && contextPath.length() != 0 ? contextPath : "/");
         ((Cookie)cookie).setMaxAge(this.getMaxCookieAge());
         ((Cookie)cookie).setSecure(requestIsSecure && this.getSecureCookies());
         if (this._sessionDomain != null) {
            ((Cookie)cookie).setDomain(this._sessionDomain);
         }

         if (this._sessionPath != null) {
            ((Cookie)cookie).setPath(this._sessionPath);
         }

         return (Cookie)cookie;
      } else {
         return null;
      }
   }

   public String getSessionDomain() {
      return this._sessionDomain;
   }

   public SessionHandler getSessionHandler() {
      return this._sessionHandler;
   }

   public abstract Map getSessionMap();

   public String getSessionPath() {
      return this._sessionPath;
   }

   public abstract int getSessions();

   public String getSessionURL() {
      return this._sessionURL;
   }

   public String getSessionURLPrefix() {
      return this._sessionURLPrefix;
   }

   public boolean isUsingCookies() {
      return this._usingCookies;
   }

   public boolean isValid(HttpSession session) {
      AbstractSessionManager.Session s = ((AbstractSessionManager.SessionIf)session).getSession();
      return s.isValid();
   }

   public String getClusterId(HttpSession session) {
      AbstractSessionManager.Session s = ((AbstractSessionManager.SessionIf)session).getSession();
      return s.getClusterId();
   }

   public String getNodeId(HttpSession session) {
      AbstractSessionManager.Session s = ((AbstractSessionManager.SessionIf)session).getSession();
      return s.getNodeId();
   }

   public HttpSession newHttpSession(HttpServletRequest request) {
      AbstractSessionManager.Session session = this.newSession(request);
      session.setMaxInactiveInterval(this._dftMaxIdleSecs);
      this.addSession(session, true);
      return session;
   }

   public void removeEventListener(EventListener listener) {
      if (listener instanceof HttpSessionAttributeListener) {
         this._sessionAttributeListeners = LazyList.remove(this._sessionAttributeListeners, listener);
      }

      if (listener instanceof HttpSessionListener) {
         this._sessionListeners = LazyList.remove(this._sessionListeners, listener);
      }

   }

   public void resetStats() {
      this._minSessions = this.getSessions();
      this._maxSessions = this.getSessions();
   }

   public void setHttpOnly(boolean httpOnly) {
      this._httpOnly = httpOnly;
   }

   public void setIdManager(SessionIdManager metaManager) {
      this._sessionIdManager = metaManager;
   }

   public void setMaxCookieAge(int maxCookieAgeInSeconds) {
      this._maxCookieAge = maxCookieAgeInSeconds;
      if (this._maxCookieAge > 0 && this._refreshCookieAge == 0) {
         this._refreshCookieAge = this._maxCookieAge / 3;
      }

   }

   public void setMaxInactiveInterval(int seconds) {
      this._dftMaxIdleSecs = seconds;
   }

   /** @deprecated */
   public void setMetaManager(SessionIdManager metaManager) {
      this.setIdManager(metaManager);
   }

   public void setRefreshCookieAge(int ageInSeconds) {
      this._refreshCookieAge = ageInSeconds;
   }

   public void setSecureCookies(boolean secureCookies) {
      this._secureCookies = secureCookies;
   }

   public void setSessionCookie(String cookieName) {
      this._sessionCookie = cookieName;
   }

   public void setSessionDomain(String domain) {
      this._sessionDomain = domain;
   }

   public void setSessionHandler(SessionHandler sessionHandler) {
      this._sessionHandler = sessionHandler;
   }

   public void setSessionPath(String path) {
      this._sessionPath = path;
   }

   public void setSessionURL(String param) {
      this._sessionURL = param != null && !"none".equals(param) ? param : null;
      this._sessionURLPrefix = param != null && !"none".equals(param) ? ";" + this._sessionURL + "=" : null;
   }

   public void setUsingCookies(boolean usingCookies) {
      this._usingCookies = usingCookies;
   }

   protected abstract void addSession(AbstractSessionManager.Session var1);

   protected void addSession(AbstractSessionManager.Session session, boolean created) {
      synchronized(this._sessionIdManager) {
         this._sessionIdManager.addSession(session);
         synchronized(this) {
            this.addSession(session);
            if (this.getSessions() > this._maxSessions) {
               this._maxSessions = this.getSessions();
            }
         }
      }

      if (!created) {
         session.didActivate();
      } else if (this._sessionListeners != null) {
         HttpSessionEvent event = new HttpSessionEvent(session);

         for(int i = 0; i < LazyList.size(this._sessionListeners); ++i) {
            ((HttpSessionListener)LazyList.get(this._sessionListeners, i)).sessionCreated(event);
         }
      }

   }

   public abstract AbstractSessionManager.Session getSession(String var1);

   protected abstract void invalidateSessions();

   protected abstract AbstractSessionManager.Session newSession(HttpServletRequest var1);

   public boolean isNodeIdInSessionId() {
      return this._nodeIdInSessionId;
   }

   public void setNodeIdInSessionId(boolean nodeIdInSessionId) {
      this._nodeIdInSessionId = nodeIdInSessionId;
   }

   public void removeSession(HttpSession session, boolean invalidate) {
      AbstractSessionManager.Session s = ((AbstractSessionManager.SessionIf)session).getSession();
      this.removeSession(s, invalidate);
   }

   public void removeSession(AbstractSessionManager.Session session, boolean invalidate) {
      boolean removed = false;
      synchronized(this) {
         if (this.getSession(session.getClusterId()) != null) {
            removed = true;
            this.removeSession(session.getClusterId());
         }
      }

      if (removed && invalidate) {
         this._sessionIdManager.removeSession(session);
         this._sessionIdManager.invalidateAll(session.getClusterId());
      }

      if (invalidate && this._sessionListeners != null) {
         HttpSessionEvent event = new HttpSessionEvent(session);
         int i = LazyList.size(this._sessionListeners);

         while(i-- > 0) {
            ((HttpSessionListener)LazyList.get(this._sessionListeners, i)).sessionDestroyed(event);
         }
      }

      if (!invalidate) {
         session.willPassivate();
      }

   }

   protected abstract void removeSession(String var1);

   public abstract class Session implements AbstractSessionManager.SessionIf, Serializable {
      protected final String _clusterId;
      protected final String _nodeId;
      protected boolean _idChanged;
      protected final long _created;
      protected long _cookieSet;
      protected long _accessed;
      protected long _lastAccessed;
      protected boolean _invalid;
      protected boolean _doInvalidate;
      protected long _maxIdleMs;
      protected boolean _newSession;
      protected Map _values;
      protected int _requests;

      protected Session(HttpServletRequest request) {
         this._maxIdleMs = (long)(AbstractSessionManager.this._dftMaxIdleSecs * 1000);
         this._newSession = true;
         this._created = System.currentTimeMillis();
         this._clusterId = AbstractSessionManager.this._sessionIdManager.newSessionId(request, this._created);
         this._nodeId = AbstractSessionManager.this._sessionIdManager.getNodeId(this._clusterId, request);
         this._accessed = this._created;
         this._requests = 1;
      }

      protected Session(long created, String clusterId) {
         this._maxIdleMs = (long)(AbstractSessionManager.this._dftMaxIdleSecs * 1000);
         this._created = created;
         this._clusterId = clusterId;
         this._nodeId = AbstractSessionManager.this._sessionIdManager.getNodeId(this._clusterId, (HttpServletRequest)null);
         this._accessed = this._created;
      }

      public AbstractSessionManager.Session getSession() {
         return this;
      }

      protected void initValues() {
         this._values = this.newAttributeMap();
      }

      public synchronized Object getAttribute(String name) {
         if (this._invalid) {
            throw new IllegalStateException();
         } else {
            return null == this._values ? null : this._values.get(name);
         }
      }

      public synchronized Enumeration getAttributeNames() {
         if (this._invalid) {
            throw new IllegalStateException();
         } else {
            List names = this._values == null ? Collections.EMPTY_LIST : new ArrayList(this._values.keySet());
            return Collections.enumeration((Collection)names);
         }
      }

      public long getCookieSetTime() {
         return this._cookieSet;
      }

      public long getCreationTime() throws IllegalStateException {
         if (this._invalid) {
            throw new IllegalStateException();
         } else {
            return this._created;
         }
      }

      public String getId() throws IllegalStateException {
         return AbstractSessionManager.this._nodeIdInSessionId ? this._nodeId : this._clusterId;
      }

      protected String getNodeId() {
         return this._nodeId;
      }

      protected String getClusterId() {
         return this._clusterId;
      }

      public long getLastAccessedTime() throws IllegalStateException {
         if (this._invalid) {
            throw new IllegalStateException();
         } else {
            return this._lastAccessed;
         }
      }

      public int getMaxInactiveInterval() {
         if (this._invalid) {
            throw new IllegalStateException();
         } else {
            return (int)(this._maxIdleMs / 1000L);
         }
      }

      public ServletContext getServletContext() {
         return AbstractSessionManager.this._context;
      }

      /** @deprecated */
      public HttpSessionContext getSessionContext() throws IllegalStateException {
         if (this._invalid) {
            throw new IllegalStateException();
         } else {
            return AbstractSessionManager.__nullSessionContext;
         }
      }

      /** @deprecated */
      public Object getValue(String name) throws IllegalStateException {
         return this.getAttribute(name);
      }

      /** @deprecated */
      public synchronized String[] getValueNames() throws IllegalStateException {
         if (this._invalid) {
            throw new IllegalStateException();
         } else if (this._values == null) {
            return new String[0];
         } else {
            String[] a = new String[this._values.size()];
            return (String[])((String[])this._values.keySet().toArray(a));
         }
      }

      protected void access(long time) {
         synchronized(this) {
            this._newSession = false;
            this._lastAccessed = this._accessed;
            this._accessed = time;
            ++this._requests;
         }
      }

      protected void complete() {
         synchronized(this) {
            --this._requests;
            if (this._doInvalidate && this._requests <= 0) {
               this.doInvalidate();
            }

         }
      }

      protected void timeout() throws IllegalStateException {
         AbstractSessionManager.this.removeSession(this, true);
         synchronized(this) {
            if (!this._invalid) {
               if (this._requests <= 0) {
                  this.doInvalidate();
               } else {
                  this._doInvalidate = true;
               }
            }

         }
      }

      public void invalidate() throws IllegalStateException {
         AbstractSessionManager.this.removeSession(this, true);
         this.doInvalidate();
      }

      protected void doInvalidate() throws IllegalStateException {
         try {
            if (this._invalid) {
               throw new IllegalStateException();
            }

            label114:
            while(this._values != null && this._values.size() > 0) {
               ArrayList keys;
               synchronized(this) {
                  keys = new ArrayList(this._values.keySet());
               }

               Iterator iter = keys.iterator();

               while(true) {
                  String key;
                  Object value;
                  do {
                     if (!iter.hasNext()) {
                        continue label114;
                     }

                     key = (String)iter.next();
                     synchronized(this) {
                        value = this._values.remove(key);
                     }

                     this.unbindValue(key, value);
                  } while(AbstractSessionManager.this._sessionAttributeListeners == null);

                  HttpSessionBindingEvent event = new HttpSessionBindingEvent(this, key, value);

                  for(int i = 0; i < LazyList.size(AbstractSessionManager.this._sessionAttributeListeners); ++i) {
                     ((HttpSessionAttributeListener)LazyList.get(AbstractSessionManager.this._sessionAttributeListeners, i)).attributeRemoved(event);
                  }
               }
            }
         } finally {
            this._invalid = true;
         }

      }

      public boolean isIdChanged() {
         return this._idChanged;
      }

      public boolean isNew() throws IllegalStateException {
         if (this._invalid) {
            throw new IllegalStateException();
         } else {
            return this._newSession;
         }
      }

      /** @deprecated */
      public void putValue(String name, Object value) throws IllegalStateException {
         this.setAttribute(name, value);
      }

      public synchronized void removeAttribute(String name) {
         if (this._invalid) {
            throw new IllegalStateException();
         } else if (this._values != null) {
            Object old = this._values.remove(name);
            if (old != null) {
               this.unbindValue(name, old);
               if (AbstractSessionManager.this._sessionAttributeListeners != null) {
                  HttpSessionBindingEvent event = new HttpSessionBindingEvent(this, name, old);

                  for(int i = 0; i < LazyList.size(AbstractSessionManager.this._sessionAttributeListeners); ++i) {
                     ((HttpSessionAttributeListener)LazyList.get(AbstractSessionManager.this._sessionAttributeListeners, i)).attributeRemoved(event);
                  }
               }
            }

         }
      }

      /** @deprecated */
      public void removeValue(String name) throws IllegalStateException {
         this.removeAttribute(name);
      }

      public synchronized void setAttribute(String name, Object value) {
         if (value == null) {
            this.removeAttribute(name);
         } else if (this._invalid) {
            throw new IllegalStateException();
         } else {
            if (this._values == null) {
               this._values = this.newAttributeMap();
            }

            Object oldValue = this._values.put(name, value);
            if (oldValue == null || !value.equals(oldValue)) {
               this.unbindValue(name, oldValue);
               this.bindValue(name, value);
               if (AbstractSessionManager.this._sessionAttributeListeners != null) {
                  HttpSessionBindingEvent event = new HttpSessionBindingEvent(this, name, oldValue == null ? value : oldValue);

                  for(int i = 0; i < LazyList.size(AbstractSessionManager.this._sessionAttributeListeners); ++i) {
                     HttpSessionAttributeListener l = (HttpSessionAttributeListener)LazyList.get(AbstractSessionManager.this._sessionAttributeListeners, i);
                     if (oldValue == null) {
                        l.attributeAdded(event);
                     } else if (value == null) {
                        l.attributeRemoved(event);
                     } else {
                        l.attributeReplaced(event);
                     }
                  }
               }
            }

         }
      }

      public void setIdChanged(boolean changed) {
         this._idChanged = changed;
      }

      public void setMaxInactiveInterval(int secs) {
         this._maxIdleMs = (long)secs * 1000L;
      }

      public String toString() {
         return this.getClass().getName() + ":" + this.getId() + "@" + this.hashCode();
      }

      protected void bindValue(String name, Object value) {
         if (value != null && value instanceof HttpSessionBindingListener) {
            ((HttpSessionBindingListener)value).valueBound(new HttpSessionBindingEvent(this, name));
         }

      }

      protected boolean isValid() {
         return !this._invalid;
      }

      protected abstract Map newAttributeMap();

      protected void cookieSet() {
         this._cookieSet = this._accessed;
      }

      protected void unbindValue(String name, Object value) {
         if (value != null && value instanceof HttpSessionBindingListener) {
            ((HttpSessionBindingListener)value).valueUnbound(new HttpSessionBindingEvent(this, name));
         }

      }

      protected synchronized void willPassivate() {
         HttpSessionEvent event = new HttpSessionEvent(this);
         Iterator iter = this._values.values().iterator();

         while(iter.hasNext()) {
            Object value = iter.next();
            if (value instanceof HttpSessionActivationListener) {
               HttpSessionActivationListener listener = (HttpSessionActivationListener)value;
               listener.sessionWillPassivate(event);
            }
         }

      }

      protected synchronized void didActivate() {
         HttpSessionEvent event = new HttpSessionEvent(this);
         Iterator iter = this._values.values().iterator();

         while(iter.hasNext()) {
            Object value = iter.next();
            if (value instanceof HttpSessionActivationListener) {
               HttpSessionActivationListener listener = (HttpSessionActivationListener)value;
               listener.sessionDidActivate(event);
            }
         }

      }
   }

   public interface SessionIf extends HttpSession {
      AbstractSessionManager.Session getSession();
   }

   public static class NullSessionContext implements HttpSessionContext {
      private NullSessionContext() {
      }

      /** @deprecated */
      public Enumeration getIds() {
         return Collections.enumeration(Collections.EMPTY_LIST);
      }

      /** @deprecated */
      public HttpSession getSession(String id) {
         return null;
      }

      // $FF: synthetic method
      NullSessionContext(Object x0) {
         this();
      }
   }
}
