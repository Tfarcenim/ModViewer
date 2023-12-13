package com.replaymod.lib.org.mortbay.jetty.servlet;

import com.replaymod.lib.org.mortbay.jetty.HttpConnection;
import com.replaymod.lib.org.mortbay.jetty.Request;
import com.replaymod.lib.org.mortbay.jetty.RetryRequest;
import com.replaymod.lib.org.mortbay.jetty.Server;
import com.replaymod.lib.org.mortbay.jetty.SessionManager;
import com.replaymod.lib.org.mortbay.jetty.handler.HandlerWrapper;
import com.replaymod.lib.org.mortbay.log.Log;
import java.io.IOException;
import java.util.EventListener;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionHandler extends HandlerWrapper {
   private SessionManager _sessionManager;

   public SessionHandler() {
      this(new HashSessionManager());
   }

   public SessionHandler(SessionManager manager) {
      this.setSessionManager(manager);
   }

   public SessionManager getSessionManager() {
      return this._sessionManager;
   }

   public void setSessionManager(SessionManager sessionManager) {
      if (this.isStarted()) {
         throw new IllegalStateException();
      } else {
         SessionManager old_session_manager = this._sessionManager;
         if (this.getServer() != null) {
            this.getServer().getContainer().update(this, (Object)old_session_manager, (Object)sessionManager, "sessionManager", true);
         }

         if (sessionManager != null) {
            sessionManager.setSessionHandler(this);
         }

         this._sessionManager = sessionManager;
         if (old_session_manager != null) {
            old_session_manager.setSessionHandler((SessionHandler)null);
         }

      }
   }

   public void setServer(Server server) {
      Server old_server = this.getServer();
      if (old_server != null && old_server != server) {
         old_server.getContainer().update(this, (Object)this._sessionManager, (Object)null, "sessionManager", true);
      }

      super.setServer(server);
      if (server != null && server != old_server) {
         server.getContainer().update(this, (Object)null, (Object)this._sessionManager, "sessionManager", true);
      }

   }

   protected void doStart() throws Exception {
      this._sessionManager.start();
      super.doStart();
   }

   protected void doStop() throws Exception {
      super.doStop();
      this._sessionManager.stop();
   }

   public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch) throws IOException, ServletException {
      this.setRequestedId(request, dispatch);
      Request base_request = request instanceof Request ? (Request)request : HttpConnection.getCurrentConnection().getRequest();
      SessionManager old_session_manager = null;
      HttpSession old_session = null;
      boolean var14 = false;

      HttpSession session;
      try {
         var14 = true;
         old_session_manager = base_request.getSessionManager();
         old_session = base_request.getSession(false);
         if (old_session_manager != this._sessionManager) {
            base_request.setSessionManager(this._sessionManager);
            base_request.setSession((HttpSession)null);
         }

         session = null;
         if (this._sessionManager != null) {
            session = base_request.getSession(false);
            if (session != null) {
               if (session != old_session) {
                  Cookie cookie = this._sessionManager.access(session, request.isSecure());
                  if (cookie != null) {
                     response.addCookie(cookie);
                  }
               }
            } else {
               session = base_request.recoverNewSession(this._sessionManager);
               if (session != null) {
                  base_request.setSession(session);
               }
            }
         }

         if (Log.isDebugEnabled()) {
            Log.debug("sessionManager=" + this._sessionManager);
            Log.debug("session=" + session);
         }

         this.getHandler().handle(target, request, response, dispatch);
         var14 = false;
      } catch (RetryRequest var15) {
         HttpSession session = base_request.getSession(false);
         if (session != null && session.isNew()) {
            base_request.saveNewSession(this._sessionManager, session);
         }

         throw var15;
      } finally {
         if (var14) {
            HttpSession session = request.getSession(false);
            if (old_session_manager != this._sessionManager) {
               if (session != null) {
                  this._sessionManager.complete(session);
               }

               if (old_session_manager != null) {
                  base_request.setSessionManager(old_session_manager);
                  base_request.setSession(old_session);
               }
            }

         }
      }

      session = request.getSession(false);
      if (old_session_manager != this._sessionManager) {
         if (session != null) {
            this._sessionManager.complete(session);
         }

         if (old_session_manager != null) {
            base_request.setSessionManager(old_session_manager);
            base_request.setSession(old_session);
         }
      }

   }

   protected void setRequestedId(HttpServletRequest request, int dispatch) {
      Request base_request = request instanceof Request ? (Request)request : HttpConnection.getCurrentConnection().getRequest();
      String requested_session_id = request.getRequestedSessionId();
      if (dispatch == 1 && requested_session_id == null) {
         SessionManager sessionManager = this.getSessionManager();
         boolean requested_session_id_from_cookie = false;
         HttpSession session = null;
         if (this._sessionManager.isUsingCookies()) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null && cookies.length > 0) {
               for(int i = 0; i < cookies.length; ++i) {
                  if (sessionManager.getSessionCookie().equalsIgnoreCase(cookies[i].getName())) {
                     if (requested_session_id != null && sessionManager.getHttpSession(requested_session_id) != null) {
                        break;
                     }

                     requested_session_id = cookies[i].getValue();
                     requested_session_id_from_cookie = true;
                     if (Log.isDebugEnabled()) {
                        Log.debug("Got Session ID " + requested_session_id + " from cookie");
                     }

                     session = sessionManager.getHttpSession(requested_session_id);
                     if (session != null) {
                        base_request.setSession(session);
                     }
                  }
               }
            }
         }

         if (requested_session_id == null || session == null) {
            String uri = request.getRequestURI();
            String prefix = sessionManager.getSessionURLPrefix();
            if (prefix != null) {
               int s = uri.indexOf(prefix);
               if (s >= 0) {
                  s += prefix.length();

                  int i;
                  for(i = s; i < uri.length(); ++i) {
                     char c = uri.charAt(i);
                     if (c == ';' || c == '#' || c == '?' || c == '/') {
                        break;
                     }
                  }

                  requested_session_id = uri.substring(s, i);
                  requested_session_id_from_cookie = false;
                  if (Log.isDebugEnabled()) {
                     Log.debug("Got Session ID " + requested_session_id + " from URL");
                  }
               }
            }
         }

         base_request.setRequestedSessionId(requested_session_id);
         base_request.setRequestedSessionIdFromCookie(requested_session_id != null && requested_session_id_from_cookie);
      }
   }

   public void addEventListener(EventListener listener) {
      if (this._sessionManager != null) {
         this._sessionManager.addEventListener(listener);
      }

   }

   public void clearEventListeners() {
      if (this._sessionManager != null) {
         this._sessionManager.clearEventListeners();
      }

   }
}
