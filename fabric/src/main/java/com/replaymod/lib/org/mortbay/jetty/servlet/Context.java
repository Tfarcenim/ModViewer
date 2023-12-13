package com.replaymod.lib.org.mortbay.jetty.servlet;

import com.replaymod.lib.org.mortbay.jetty.Handler;
import com.replaymod.lib.org.mortbay.jetty.HandlerContainer;
import com.replaymod.lib.org.mortbay.jetty.handler.ContextHandler;
import com.replaymod.lib.org.mortbay.jetty.handler.ErrorHandler;
import com.replaymod.lib.org.mortbay.jetty.security.SecurityHandler;
import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.util.URIUtil;
import javax.servlet.RequestDispatcher;

public class Context extends ContextHandler {
   public static final int SESSIONS = 1;
   public static final int SECURITY = 2;
   public static final int NO_SESSIONS = 0;
   public static final int NO_SECURITY = 0;
   protected SecurityHandler _securityHandler;
   protected ServletHandler _servletHandler;
   protected SessionHandler _sessionHandler;

   public Context() {
      this((HandlerContainer)null, (SessionHandler)null, (SecurityHandler)null, (ServletHandler)null, (ErrorHandler)null);
   }

   public Context(int options) {
      this((HandlerContainer)null, (String)null, options);
   }

   public Context(HandlerContainer parent, String contextPath) {
      this(parent, contextPath, (SessionHandler)null, (SecurityHandler)null, (ServletHandler)null, (ErrorHandler)null);
   }

   public Context(HandlerContainer parent, String contextPath, int options) {
      this(parent, contextPath, (options & 1) != 0 ? new SessionHandler() : null, (options & 2) != 0 ? new SecurityHandler() : null, (ServletHandler)null, (ErrorHandler)null);
   }

   public Context(HandlerContainer parent, String contextPath, boolean sessions, boolean security) {
      this(parent, contextPath, (sessions ? 1 : 0) | (security ? 2 : 0));
   }

   public Context(HandlerContainer parent, SessionHandler sessionHandler, SecurityHandler securityHandler, ServletHandler servletHandler, ErrorHandler errorHandler) {
      this(parent, (String)null, sessionHandler, securityHandler, servletHandler, errorHandler);
   }

   public Context(HandlerContainer parent, String contextPath, SessionHandler sessionHandler, SecurityHandler securityHandler, ServletHandler servletHandler, ErrorHandler errorHandler) {
      super((ContextHandler.SContext)null);
      this._scontext = new Context.SContext();
      this._sessionHandler = sessionHandler;
      this._securityHandler = securityHandler;
      this._servletHandler = servletHandler != null ? servletHandler : new ServletHandler();
      if (this._sessionHandler != null) {
         this.setHandler(this._sessionHandler);
         if (securityHandler != null) {
            this._sessionHandler.setHandler(this._securityHandler);
            this._securityHandler.setHandler(this._servletHandler);
         } else {
            this._sessionHandler.setHandler(this._servletHandler);
         }
      } else if (this._securityHandler != null) {
         this.setHandler(this._securityHandler);
         this._securityHandler.setHandler(this._servletHandler);
      } else {
         this.setHandler(this._servletHandler);
      }

      if (errorHandler != null) {
         this.setErrorHandler(errorHandler);
      }

      if (contextPath != null) {
         this.setContextPath(contextPath);
      }

      if (parent != null) {
         parent.addHandler(this);
      }

   }

   protected void startContext() throws Exception {
      super.startContext();
      if (this._servletHandler != null && this._servletHandler.isStarted()) {
         this._servletHandler.initialize();
      }

   }

   public SecurityHandler getSecurityHandler() {
      return this._securityHandler;
   }

   public ServletHandler getServletHandler() {
      return this._servletHandler;
   }

   public SessionHandler getSessionHandler() {
      return this._sessionHandler;
   }

   public ServletHolder addServlet(String className, String pathSpec) {
      return this._servletHandler.addServletWithMapping(className, pathSpec);
   }

   public ServletHolder addServlet(Class servlet, String pathSpec) {
      return this._servletHandler.addServletWithMapping(servlet.getName(), pathSpec);
   }

   public void addServlet(ServletHolder servlet, String pathSpec) {
      this._servletHandler.addServletWithMapping(servlet, pathSpec);
   }

   public void addFilter(FilterHolder holder, String pathSpec, int dispatches) {
      this._servletHandler.addFilterWithMapping(holder, pathSpec, dispatches);
   }

   public FilterHolder addFilter(Class filterClass, String pathSpec, int dispatches) {
      return this._servletHandler.addFilterWithMapping(filterClass, pathSpec, dispatches);
   }

   public FilterHolder addFilter(String filterClass, String pathSpec, int dispatches) {
      return this._servletHandler.addFilterWithMapping(filterClass, pathSpec, dispatches);
   }

   public void setSessionHandler(SessionHandler sessionHandler) {
      if (this._sessionHandler != sessionHandler) {
         if (this._sessionHandler != null) {
            this._sessionHandler.setHandler((Handler)null);
         }

         this._sessionHandler = sessionHandler;
         this.setHandler(this._sessionHandler);
         if (this._securityHandler != null) {
            this._sessionHandler.setHandler(this._securityHandler);
         } else if (this._servletHandler != null) {
            this._sessionHandler.setHandler(this._servletHandler);
         }

      }
   }

   public void setSecurityHandler(SecurityHandler securityHandler) {
      if (this._securityHandler != securityHandler) {
         if (this._securityHandler != null) {
            this._securityHandler.setHandler((Handler)null);
         }

         this._securityHandler = securityHandler;
         if (this._securityHandler == null) {
            if (this._sessionHandler != null) {
               this._sessionHandler.setHandler(this._servletHandler);
            } else {
               this.setHandler(this._servletHandler);
            }
         } else {
            if (this._sessionHandler != null) {
               this._sessionHandler.setHandler(this._securityHandler);
            } else {
               this.setHandler(this._securityHandler);
            }

            if (this._servletHandler != null) {
               this._securityHandler.setHandler(this._servletHandler);
            }
         }

      }
   }

   public void setServletHandler(ServletHandler servletHandler) {
      if (this._servletHandler != servletHandler) {
         this._servletHandler = servletHandler;
         if (this._securityHandler != null) {
            this._securityHandler.setHandler(this._servletHandler);
         } else if (this._sessionHandler != null) {
            this._sessionHandler.setHandler(this._servletHandler);
         } else {
            this.setHandler(this._servletHandler);
         }

      }
   }

   public class SContext extends ContextHandler.SContext {
      public SContext() {
         super();
      }

      public RequestDispatcher getNamedDispatcher(String name) {
         ContextHandler context = Context.this;
         return Context.this._servletHandler != null && Context.this._servletHandler.getServlet(name) != null ? new Dispatcher(context, name) : null;
      }

      public RequestDispatcher getRequestDispatcher(String uriInContext) {
         if (uriInContext == null) {
            return null;
         } else if (!uriInContext.startsWith("/")) {
            return null;
         } else {
            try {
               String query = null;
               int qx = false;
               int q;
               if ((q = uriInContext.indexOf(63)) > 0) {
                  query = uriInContext.substring(q + 1);
                  uriInContext = uriInContext.substring(0, q);
               }

               if ((q = uriInContext.indexOf(59)) > 0) {
                  uriInContext = uriInContext.substring(0, q);
               }

               String pathInContext = URIUtil.canonicalPath(URIUtil.decodePath(uriInContext));
               String uri = URIUtil.addPaths(this.getContextPath(), uriInContext);
               ContextHandler context = Context.this;
               return new Dispatcher(context, uri, pathInContext, query);
            } catch (Exception var7) {
               Log.ignore(var7);
               return null;
            }
         }
      }
   }
}
