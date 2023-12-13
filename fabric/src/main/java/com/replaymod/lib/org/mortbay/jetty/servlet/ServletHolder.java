package com.replaymod.lib.org.mortbay.jetty.servlet;

import com.replaymod.lib.org.mortbay.jetty.HttpConnection;
import com.replaymod.lib.org.mortbay.jetty.Request;
import com.replaymod.lib.org.mortbay.jetty.handler.ContextHandler;
import com.replaymod.lib.org.mortbay.jetty.security.SecurityHandler;
import com.replaymod.lib.org.mortbay.jetty.security.UserRealm;
import com.replaymod.lib.org.mortbay.log.Log;
import java.io.IOException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.SingleThreadModel;
import javax.servlet.UnavailableException;

public class ServletHolder extends Holder implements Comparable {
   private int _initOrder;
   private boolean _initOnStartup = false;
   private Map _roleMap;
   private String _forcedPath;
   private String _runAs;
   private UserRealm _realm;
   private transient Servlet _servlet;
   private transient ServletHolder.Config _config;
   private transient long _unavailable;
   private transient UnavailableException _unavailableEx;

   public ServletHolder() {
   }

   public ServletHolder(Servlet servlet) {
      this.setServlet(servlet);
   }

   public ServletHolder(Class servlet) {
      super(servlet);
   }

   public UnavailableException getUnavailableException() {
      return this._unavailableEx;
   }

   public synchronized void setServlet(Servlet servlet) {
      if (servlet != null && !(servlet instanceof SingleThreadModel)) {
         this._extInstance = true;
         this._servlet = servlet;
         this.setHeldClass(servlet.getClass());
         if (this.getName() == null) {
            this.setName(servlet.getClass().getName() + "-" + super.hashCode());
         }

      } else {
         throw new IllegalArgumentException();
      }
   }

   public int getInitOrder() {
      return this._initOrder;
   }

   public void setInitOrder(int order) {
      this._initOnStartup = true;
      this._initOrder = order;
   }

   public int compareTo(Object o) {
      if (o instanceof ServletHolder) {
         ServletHolder sh = (ServletHolder)o;
         if (sh == this) {
            return 0;
         } else if (sh._initOrder < this._initOrder) {
            return 1;
         } else if (sh._initOrder > this._initOrder) {
            return -1;
         } else {
            int c = this._className != null && sh._className != null ? this._className.compareTo(sh._className) : 0;
            if (c == 0) {
               c = this._name.compareTo(sh._name);
            }

            if (c == 0) {
               c = this.hashCode() > o.hashCode() ? 1 : -1;
            }

            return c;
         }
      } else {
         return 1;
      }
   }

   public boolean equals(Object o) {
      return this.compareTo(o) == 0;
   }

   public int hashCode() {
      return this._name == null ? System.identityHashCode(this) : this._name.hashCode();
   }

   public synchronized void setUserRoleLink(String name, String link) {
      if (this._roleMap == null) {
         this._roleMap = new HashMap();
      }

      this._roleMap.put(name, link);
   }

   public String getUserRoleLink(String name) {
      if (this._roleMap == null) {
         return name;
      } else {
         String link = (String)this._roleMap.get(name);
         return link == null ? name : link;
      }
   }

   public Map getRoleMap() {
      return this._roleMap;
   }

   public void setRunAs(String role) {
      this._runAs = role;
   }

   public String getRunAs() {
      return this._runAs;
   }

   public String getForcedPath() {
      return this._forcedPath;
   }

   public void setForcedPath(String forcedPath) {
      this._forcedPath = forcedPath;
   }

   public void doStart() throws Exception {
      this._unavailable = 0L;

      try {
         super.doStart();
         this.checkServletType();
      } catch (UnavailableException var2) {
         this.makeUnavailable(var2);
      }

      this._config = new ServletHolder.Config();
      if (this._runAs != null) {
         this._realm = ((SecurityHandler)((SecurityHandler)ContextHandler.getCurrentContext().getContextHandler().getChildHandlerByClass(SecurityHandler.class))).getUserRealm();
      }

      if (SingleThreadModel.class.isAssignableFrom(this._class)) {
         this._servlet = new ServletHolder.SingleThreadedWrapper();
      }

      if (this._extInstance || this._initOnStartup) {
         try {
            this.initServlet();
         } catch (Exception var3) {
            if (!this._servletHandler.isStartWithUnavailable()) {
               throw var3;
            }

            Log.ignore(var3);
         }
      }

   }

   public void doStop() {
      Principal user = null;

      try {
         if (this._runAs != null && this._realm != null) {
            user = this._realm.pushRole((Principal)null, this._runAs);
         }

         if (this._servlet != null) {
            try {
               this.destroyInstance(this._servlet);
            } catch (Exception var6) {
               Log.warn((Throwable)var6);
            }
         }

         if (!this._extInstance) {
            this._servlet = null;
         }

         this._config = null;
      } finally {
         super.doStop();
         if (this._runAs != null && this._realm != null && user != null) {
            this._realm.popRole(user);
         }

      }

   }

   public void destroyInstance(Object o) throws Exception {
      if (o != null) {
         Servlet servlet = (Servlet)o;
         servlet.destroy();
         this.getServletHandler().customizeServletDestroy(servlet);
      }
   }

   public synchronized Servlet getServlet() throws ServletException {
      if (this._unavailable != 0L) {
         if (this._unavailable < 0L || this._unavailable > 0L && System.currentTimeMillis() < this._unavailable) {
            throw this._unavailableEx;
         }

         this._unavailable = 0L;
         this._unavailableEx = null;
      }

      if (this._servlet == null) {
         this.initServlet();
      }

      return this._servlet;
   }

   public Servlet getServletInstance() {
      return this._servlet;
   }

   public void checkServletType() throws UnavailableException {
      if (!Servlet.class.isAssignableFrom(this._class)) {
         throw new UnavailableException("Servlet " + this._class + " is not a javax.servlet.Servlet");
      }
   }

   public boolean isAvailable() {
      if (this.isStarted() && this._unavailable == 0L) {
         return true;
      } else {
         try {
            this.getServlet();
         } catch (Exception var2) {
            Log.ignore(var2);
         }

         return this.isStarted() && this._unavailable == 0L;
      }
   }

   private void makeUnavailable(UnavailableException e) {
      if (this._unavailableEx != e || this._unavailable == 0L) {
         this._servletHandler.getServletContext().log("Unavailable " + e);
         this._unavailableEx = e;
         this._unavailable = -1L;
         if (e.isPermanent()) {
            this._unavailable = -1L;
         } else if (this._unavailableEx.getUnavailableSeconds() > 0) {
            this._unavailable = System.currentTimeMillis() + (long)(1000 * this._unavailableEx.getUnavailableSeconds());
         } else {
            this._unavailable = System.currentTimeMillis() + 5000L;
         }

      }
   }

   private void makeUnavailable(Throwable e) {
      if (e instanceof UnavailableException) {
         this.makeUnavailable((UnavailableException)e);
      } else {
         this._servletHandler.getServletContext().log("unavailable", e);
         this._unavailableEx = new UnavailableException(e.toString(), -1);
         this._unavailable = -1L;
      }

   }

   private void initServlet() throws ServletException {
      Principal user = null;

      try {
         if (this._servlet == null) {
            this._servlet = (Servlet)this.newInstance();
         }

         if (this._config == null) {
            this._config = new ServletHolder.Config();
         }

         if (!(this._servlet instanceof ServletHolder.SingleThreadedWrapper)) {
            this._servlet = this.getServletHandler().customizeServlet(this._servlet);
         }

         if (this._runAs != null && this._realm != null) {
            user = this._realm.pushRole((Principal)null, this._runAs);
         }

         this._servlet.init(this._config);
      } catch (UnavailableException var8) {
         this.makeUnavailable(var8);
         this._servlet = null;
         this._config = null;
         throw var8;
      } catch (ServletException var9) {
         this.makeUnavailable((Throwable)(var9.getCause() == null ? var9 : var9.getCause()));
         this._servlet = null;
         this._config = null;
         throw var9;
      } catch (Exception var10) {
         this.makeUnavailable((Throwable)var10);
         this._servlet = null;
         this._config = null;
         throw new ServletException(var10);
      } finally {
         if (this._runAs != null && this._realm != null && user != null) {
            this._realm.popRole(user);
         }

      }

   }

   public void handle(ServletRequest request, ServletResponse response) throws ServletException, UnavailableException, IOException {
      if (this._class == null) {
         throw new UnavailableException("Servlet Not Initialized");
      } else {
         Servlet servlet = this._servlet;
         synchronized(this) {
            if (this._unavailable != 0L || !this._initOnStartup) {
               servlet = this.getServlet();
            }

            if (servlet == null) {
               throw new UnavailableException("Could not instantiate " + this._class);
            }
         }

         boolean servlet_error = true;
         Principal user = null;
         Request base_request = null;

         try {
            if (this._forcedPath != null) {
               request.setAttribute("org.apache.catalina.jsp_file", this._forcedPath);
            }

            if (this._runAs != null && this._realm != null) {
               base_request = HttpConnection.getCurrentConnection().getRequest();
               user = this._realm.pushRole(base_request.getUserPrincipal(), this._runAs);
               base_request.setUserPrincipal(user);
            }

            servlet.service(request, response);
            servlet_error = false;
         } catch (UnavailableException var12) {
            this.makeUnavailable(var12);
            throw this._unavailableEx;
         } finally {
            if (this._runAs != null && this._realm != null && user != null && base_request != null) {
               user = this._realm.popRole(user);
               base_request.setUserPrincipal(user);
            }

            if (servlet_error) {
               request.setAttribute("javax.servlet.error.servlet_name", this.getName());
            }

         }

      }
   }

   private class SingleThreadedWrapper implements Servlet {
      Stack _stack;

      private SingleThreadedWrapper() {
         this._stack = new Stack();
      }

      public void destroy() {
         synchronized(this) {
            while(this._stack.size() > 0) {
               try {
                  ((Servlet)this._stack.pop()).destroy();
               } catch (Exception var4) {
                  Log.warn((Throwable)var4);
               }
            }

         }
      }

      public ServletConfig getServletConfig() {
         return ServletHolder.this._config;
      }

      public String getServletInfo() {
         return null;
      }

      public void init(ServletConfig config) throws ServletException {
         synchronized(this) {
            if (this._stack.size() == 0) {
               try {
                  Servlet s = (Servlet)ServletHolder.this.newInstance();
                  s = ServletHolder.this.getServletHandler().customizeServlet(s);
                  s.init(config);
                  this._stack.push(s);
               } catch (ServletException var5) {
                  throw var5;
               } catch (Exception var6) {
                  throw new ServletException(var6);
               }
            }

         }
      }

      public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
         Servlet s;
         synchronized(this) {
            if (this._stack.size() > 0) {
               s = (Servlet)this._stack.pop();
            } else {
               try {
                  s = (Servlet)ServletHolder.this.newInstance();
                  s = ServletHolder.this.getServletHandler().customizeServlet(s);
                  s.init(ServletHolder.this._config);
               } catch (ServletException var22) {
                  throw var22;
               } catch (IOException var23) {
                  throw var23;
               } catch (Exception var24) {
                  throw new ServletException(var24);
               }
            }
         }

         boolean var18 = false;

         try {
            var18 = true;
            s.service(req, res);
            var18 = false;
         } finally {
            if (var18) {
               synchronized(this) {
                  this._stack.push(s);
               }
            }
         }

         synchronized(this) {
            this._stack.push(s);
         }
      }

      // $FF: synthetic method
      SingleThreadedWrapper(Object x1) {
         this();
      }
   }

   class Config implements ServletConfig {
      public String getServletName() {
         return ServletHolder.this.getName();
      }

      public ServletContext getServletContext() {
         return ServletHolder.this._servletHandler.getServletContext();
      }

      public String getInitParameter(String param) {
         return ServletHolder.this.getInitParameter(param);
      }

      public Enumeration getInitParameterNames() {
         return ServletHolder.this.getInitParameterNames();
      }
   }
}
