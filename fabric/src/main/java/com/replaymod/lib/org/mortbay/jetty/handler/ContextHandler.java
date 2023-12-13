package com.replaymod.lib.org.mortbay.jetty.handler;

import com.replaymod.lib.org.mortbay.io.Buffer;
import com.replaymod.lib.org.mortbay.jetty.Handler;
import com.replaymod.lib.org.mortbay.jetty.HandlerContainer;
import com.replaymod.lib.org.mortbay.jetty.HttpConnection;
import com.replaymod.lib.org.mortbay.jetty.HttpException;
import com.replaymod.lib.org.mortbay.jetty.MimeTypes;
import com.replaymod.lib.org.mortbay.jetty.Request;
import com.replaymod.lib.org.mortbay.jetty.Server;
import com.replaymod.lib.org.mortbay.jetty.webapp.WebAppClassLoader;
import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.log.Logger;
import com.replaymod.lib.org.mortbay.resource.Resource;
import com.replaymod.lib.org.mortbay.util.Attributes;
import com.replaymod.lib.org.mortbay.util.AttributesMap;
import com.replaymod.lib.org.mortbay.util.LazyList;
import com.replaymod.lib.org.mortbay.util.Loader;
import com.replaymod.lib.org.mortbay.util.QuotedStringTokenizer;
import com.replaymod.lib.org.mortbay.util.URIUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextHandler extends HandlerWrapper implements Attributes, Server.Graceful {
   private static ThreadLocal __context = new ThreadLocal();
   public static final String MANAGED_ATTRIBUTES = "com.replaymod.lib.org.mortbay.jetty.servlet.ManagedAttributes";
   protected ContextHandler.SContext _scontext;
   private AttributesMap _attributes;
   private AttributesMap _contextAttributes;
   private ClassLoader _classLoader;
   private String _contextPath;
   private Map _initParams;
   private String _displayName;
   private Resource _baseResource;
   private MimeTypes _mimeTypes;
   private Map _localeEncodingMap;
   private String[] _welcomeFiles;
   private ErrorHandler _errorHandler;
   private String[] _vhosts;
   private Set _connectors;
   private EventListener[] _eventListeners;
   private Logger _logger;
   private boolean _shutdown;
   private boolean _allowNullPathInfo;
   private int _maxFormContentSize;
   private boolean _compactPath;
   private Object _contextListeners;
   private Object _contextAttributeListeners;
   private Object _requestListeners;
   private Object _requestAttributeListeners;
   private Set _managedAttributes;

   public static ContextHandler.SContext getCurrentContext() {
      ContextHandler.SContext context = (ContextHandler.SContext)__context.get();
      return context;
   }

   public ContextHandler() {
      this._contextPath = "/";
      this._maxFormContentSize = Integer.getInteger("com.replaymod.lib.org.mortbay.jetty.Request.maxFormContentSize", 200000);
      this._compactPath = false;
      this._scontext = new ContextHandler.SContext();
      this._attributes = new AttributesMap();
      this._initParams = new HashMap();
   }

   protected ContextHandler(ContextHandler.SContext context) {
      this._contextPath = "/";
      this._maxFormContentSize = Integer.getInteger("com.replaymod.lib.org.mortbay.jetty.Request.maxFormContentSize", 200000);
      this._compactPath = false;
      this._scontext = context;
      this._attributes = new AttributesMap();
      this._initParams = new HashMap();
   }

   public ContextHandler(String contextPath) {
      this();
      this.setContextPath(contextPath);
   }

   public ContextHandler(HandlerContainer parent, String contextPath) {
      this();
      this.setContextPath(contextPath);
      parent.addHandler(this);
   }

   public ContextHandler.SContext getServletContext() {
      return this._scontext;
   }

   public boolean getAllowNullPathInfo() {
      return this._allowNullPathInfo;
   }

   public void setAllowNullPathInfo(boolean allowNullPathInfo) {
      this._allowNullPathInfo = allowNullPathInfo;
   }

   public void setServer(Server server) {
      if (this._errorHandler != null) {
         Server old_server = this.getServer();
         if (old_server != null && old_server != server) {
            old_server.getContainer().update(this, (Object)this._errorHandler, (Object)null, "error", true);
         }

         super.setServer(server);
         if (server != null && server != old_server) {
            server.getContainer().update(this, (Object)null, (Object)this._errorHandler, "error", true);
         }

         this._errorHandler.setServer(server);
      } else {
         super.setServer(server);
      }

   }

   public void setVirtualHosts(String[] vhosts) {
      if (vhosts == null) {
         this._vhosts = vhosts;
      } else {
         this._vhosts = new String[vhosts.length];

         for(int i = 0; i < vhosts.length; ++i) {
            this._vhosts[i] = this.normalizeHostname(vhosts[i]);
         }
      }

   }

   public String[] getVirtualHosts() {
      return this._vhosts;
   }

   /** @deprecated */
   public void setHosts(String[] hosts) {
      this.setConnectorNames(hosts);
   }

   /** @deprecated */
   public String[] getHosts() {
      return this.getConnectorNames();
   }

   public String[] getConnectorNames() {
      return this._connectors != null && this._connectors.size() != 0 ? (String[])((String[])this._connectors.toArray(new String[this._connectors.size()])) : null;
   }

   public void setConnectorNames(String[] connectors) {
      if (connectors != null && connectors.length != 0) {
         this._connectors = new HashSet(Arrays.asList(connectors));
      } else {
         this._connectors = null;
      }

   }

   public Object getAttribute(String name) {
      return this._attributes.getAttribute(name);
   }

   public Enumeration getAttributeNames() {
      return AttributesMap.getAttributeNamesCopy(this._attributes);
   }

   public Attributes getAttributes() {
      return this._attributes;
   }

   public ClassLoader getClassLoader() {
      return this._classLoader;
   }

   public String getClassPath() {
      if (this._classLoader != null && this._classLoader instanceof URLClassLoader) {
         URLClassLoader loader = (URLClassLoader)this._classLoader;
         URL[] urls = loader.getURLs();
         StringBuffer classpath = new StringBuffer();

         for(int i = 0; i < urls.length; ++i) {
            try {
               Resource resource = Resource.newResource(urls[i]);
               File file = resource.getFile();
               if (file.exists()) {
                  if (classpath.length() > 0) {
                     classpath.append(File.pathSeparatorChar);
                  }

                  classpath.append(file.getAbsolutePath());
               }
            } catch (IOException var7) {
               Log.debug((Throwable)var7);
            }
         }

         if (classpath.length() == 0) {
            return null;
         } else {
            return classpath.toString();
         }
      } else {
         return null;
      }
   }

   public String getContextPath() {
      return this._contextPath;
   }

   public String getInitParameter(String name) {
      return (String)this._initParams.get(name);
   }

   public Enumeration getInitParameterNames() {
      return Collections.enumeration(this._initParams.keySet());
   }

   public Map getInitParams() {
      return this._initParams;
   }

   public String getDisplayName() {
      return this._displayName;
   }

   public EventListener[] getEventListeners() {
      return this._eventListeners;
   }

   public void setEventListeners(EventListener[] eventListeners) {
      this._contextListeners = null;
      this._contextAttributeListeners = null;
      this._requestListeners = null;
      this._requestAttributeListeners = null;
      this._eventListeners = eventListeners;

      for(int i = 0; eventListeners != null && i < eventListeners.length; ++i) {
         EventListener listener = this._eventListeners[i];
         if (listener instanceof ServletContextListener) {
            this._contextListeners = LazyList.add(this._contextListeners, listener);
         }

         if (listener instanceof ServletContextAttributeListener) {
            this._contextAttributeListeners = LazyList.add(this._contextAttributeListeners, listener);
         }

         if (listener instanceof ServletRequestListener) {
            this._requestListeners = LazyList.add(this._requestListeners, listener);
         }

         if (listener instanceof ServletRequestAttributeListener) {
            this._requestAttributeListeners = LazyList.add(this._requestAttributeListeners, listener);
         }
      }

   }

   public void addEventListener(EventListener listener) {
      this.setEventListeners((EventListener[])((EventListener[])LazyList.addToArray(this.getEventListeners(), listener, EventListener.class)));
   }

   public boolean isShutdown() {
      return !this._shutdown;
   }

   public void setShutdown(boolean shutdown) {
      this._shutdown = shutdown;
   }

   protected void doStart() throws Exception {
      if (this._contextPath == null) {
         throw new IllegalStateException("Null contextPath");
      } else {
         this._logger = Log.getLogger(this.getDisplayName() == null ? this.getContextPath() : this.getDisplayName());
         ClassLoader old_classloader = null;
         Thread current_thread = null;
         ContextHandler.SContext old_context = null;
         this._contextAttributes = new AttributesMap();

         try {
            if (this._classLoader != null) {
               current_thread = Thread.currentThread();
               old_classloader = current_thread.getContextClassLoader();
               current_thread.setContextClassLoader(this._classLoader);
            }

            if (this._mimeTypes == null) {
               this._mimeTypes = new MimeTypes();
            }

            old_context = (ContextHandler.SContext)__context.get();
            __context.set(this._scontext);
            if (this._errorHandler == null) {
               this.setErrorHandler(new ErrorHandler());
            }

            this.startContext();
         } finally {
            __context.set(old_context);
            if (this._classLoader != null) {
               current_thread.setContextClassLoader(old_classloader);
            }

         }

      }
   }

   protected void startContext() throws Exception {
      super.doStart();
      if (this._errorHandler != null) {
         this._errorHandler.start();
      }

      if (this._contextListeners != null) {
         ServletContextEvent event = new ServletContextEvent(this._scontext);

         for(int i = 0; i < LazyList.size(this._contextListeners); ++i) {
            ((ServletContextListener)LazyList.get(this._contextListeners, i)).contextInitialized(event);
         }
      }

      String managedAttributes = (String)this._initParams.get("com.replaymod.lib.org.mortbay.jetty.servlet.ManagedAttributes");
      if (managedAttributes != null) {
         this._managedAttributes = new HashSet();
         QuotedStringTokenizer tok = new QuotedStringTokenizer(managedAttributes, ",");

         while(tok.hasMoreTokens()) {
            this._managedAttributes.add(tok.nextToken().trim());
         }

         Enumeration e = this._scontext.getAttributeNames();

         while(e.hasMoreElements()) {
            String name = (String)e.nextElement();
            Object value = this._scontext.getAttribute(name);
            this.setManagedAttribute(name, value);
         }
      }

   }

   protected void doStop() throws Exception {
      ClassLoader old_classloader = null;
      Thread current_thread = null;
      ContextHandler.SContext old_context = (ContextHandler.SContext)__context.get();
      __context.set(this._scontext);

      try {
         if (this._classLoader != null) {
            current_thread = Thread.currentThread();
            old_classloader = current_thread.getContextClassLoader();
            current_thread.setContextClassLoader(this._classLoader);
         }

         super.doStop();
         if (this._contextListeners != null) {
            ServletContextEvent event = new ServletContextEvent(this._scontext);
            int i = LazyList.size(this._contextListeners);

            while(i-- > 0) {
               ((ServletContextListener)LazyList.get(this._contextListeners, i)).contextDestroyed(event);
            }
         }

         if (this._errorHandler != null) {
            this._errorHandler.stop();
         }

         Enumeration e = this._scontext.getAttributeNames();

         while(e.hasMoreElements()) {
            String name = (String)e.nextElement();
            this.setManagedAttribute(name, (Object)null);
         }
      } finally {
         __context.set(old_context);
         if (this._classLoader != null) {
            current_thread.setContextClassLoader(old_classloader);
         }

      }

      if (this._contextAttributes != null) {
         this._contextAttributes.clearAttributes();
      }

      this._contextAttributes = null;
   }

   public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch) throws IOException, ServletException {
      boolean new_context = false;
      ContextHandler.SContext old_context = null;
      String old_context_path = null;
      String old_servlet_path = null;
      String old_path_info = null;
      ClassLoader old_classloader = null;
      Thread current_thread = null;
      Request base_request = request instanceof Request ? (Request)request : HttpConnection.getCurrentConnection().getRequest();
      if (this.isStarted() && !this._shutdown && (dispatch != 1 || !base_request.isHandled())) {
         old_context = base_request.getContext();
         String vhost;
         int i;
         if (old_context != this._scontext) {
            new_context = true;
            if (this._vhosts != null && this._vhosts.length > 0) {
               vhost = this.normalizeHostname(request.getServerName());
               boolean match = false;

               for(i = 0; !match && i < this._vhosts.length; ++i) {
                  String contextVhost = this._vhosts[i];
                  if (contextVhost != null) {
                     if (contextVhost.startsWith("*.")) {
                        match = contextVhost.regionMatches(true, 2, vhost, vhost.indexOf(".") + 1, contextVhost.length() - 2);
                     } else {
                        match = contextVhost.equalsIgnoreCase(vhost);
                     }
                  }
               }

               if (!match) {
                  return;
               }
            }

            if (this._connectors != null && this._connectors.size() > 0) {
               vhost = HttpConnection.getCurrentConnection().getConnector().getName();
               if (vhost == null || !this._connectors.contains(vhost)) {
                  return;
               }
            }

            if (dispatch == 1) {
               if (this._compactPath) {
                  target = URIUtil.compactPath(target);
               }

               if (target.equals(this._contextPath)) {
                  if (!this._allowNullPathInfo && !target.endsWith("/")) {
                     base_request.setHandled(true);
                     if (request.getQueryString() != null) {
                        response.sendRedirect(response.encodeRedirectURL(URIUtil.addPaths(request.getRequestURI(), "/") + "?" + request.getQueryString()));
                     } else {
                        response.sendRedirect(response.encodeRedirectURL(URIUtil.addPaths(request.getRequestURI(), "/")));
                     }

                     return;
                  }

                  if (this._contextPath.length() > 1) {
                     target = "/";
                     request.setAttribute("com.replaymod.lib.org.mortbay.jetty.nullPathInfo", target);
                  }
               } else {
                  if (!target.startsWith(this._contextPath) || this._contextPath.length() != 1 && target.charAt(this._contextPath.length()) != '/') {
                     return;
                  }

                  if (this._contextPath.length() > 1) {
                     target = target.substring(this._contextPath.length());
                  }
               }
            }
         }

         try {
            old_context_path = base_request.getContextPath();
            old_servlet_path = base_request.getServletPath();
            old_path_info = base_request.getPathInfo();
            base_request.setContext(this._scontext);
            if (dispatch != 4 && target.startsWith("/")) {
               if (this._contextPath.length() == 1) {
                  base_request.setContextPath("");
               } else {
                  base_request.setContextPath(this._contextPath);
               }

               base_request.setServletPath((String)null);
               base_request.setPathInfo(target);
            }

            vhost = null;
            int i;
            if (new_context) {
               if (this._classLoader != null) {
                  current_thread = Thread.currentThread();
                  old_classloader = current_thread.getContextClassLoader();
                  current_thread.setContextClassLoader(this._classLoader);
               }

               base_request.setRequestListeners(this._requestListeners);
               if (this._requestAttributeListeners != null) {
                  i = LazyList.size(this._requestAttributeListeners);

                  for(i = 0; i < i; ++i) {
                     base_request.addEventListener((EventListener)LazyList.get(this._requestAttributeListeners, i));
                  }
               }
            }

            boolean var26 = false;

            label712: {
               try {
                  var26 = true;
                  if (dispatch == 1 && this.isProtectedTarget(target)) {
                     throw new HttpException(404);
                  }

                  Handler handler = this.getHandler();
                  if (handler != null) {
                     handler.handle(target, request, response, dispatch);
                     var26 = false;
                  } else {
                     var26 = false;
                  }
                  break label712;
               } catch (HttpException var27) {
                  Log.debug((Throwable)var27);
                  response.sendError(var27.getStatus(), var27.getReason());
                  var26 = false;
               } finally {
                  if (var26) {
                     if (new_context) {
                        base_request.takeRequestListeners();
                        if (this._requestAttributeListeners != null) {
                           int i = LazyList.size(this._requestAttributeListeners);

                           while(i-- > 0) {
                              base_request.removeEventListener((EventListener)LazyList.get(this._requestAttributeListeners, i));
                           }
                        }
                     }

                  }
               }

               if (new_context) {
                  base_request.takeRequestListeners();
                  if (this._requestAttributeListeners != null) {
                     i = LazyList.size(this._requestAttributeListeners);

                     while(i-- > 0) {
                        base_request.removeEventListener((EventListener)LazyList.get(this._requestAttributeListeners, i));
                     }
                  }
               }

               return;
            }

            if (new_context) {
               base_request.takeRequestListeners();
               if (this._requestAttributeListeners != null) {
                  i = LazyList.size(this._requestAttributeListeners);

                  while(i-- > 0) {
                     base_request.removeEventListener((EventListener)LazyList.get(this._requestAttributeListeners, i));
                  }
               }
            }
         } finally {
            if (old_context != this._scontext) {
               if (this._classLoader != null) {
                  current_thread.setContextClassLoader(old_classloader);
               }

               base_request.setContext(old_context);
               base_request.setContextPath(old_context_path);
               base_request.setServletPath(old_servlet_path);
               base_request.setPathInfo(old_path_info);
            }

         }

      }
   }

   protected boolean isProtectedTarget(String target) {
      return false;
   }

   public void removeAttribute(String name) {
      this.setManagedAttribute(name, (Object)null);
      this._attributes.removeAttribute(name);
   }

   public void setAttribute(String name, Object value) {
      this.setManagedAttribute(name, value);
      this._attributes.setAttribute(name, value);
   }

   public void setAttributes(Attributes attributes) {
      Enumeration e;
      String name;
      if (attributes instanceof AttributesMap) {
         this._attributes = (AttributesMap)attributes;
         e = this._attributes.getAttributeNames();

         while(e.hasMoreElements()) {
            name = (String)e.nextElement();
            this.setManagedAttribute(name, attributes.getAttribute(name));
         }
      } else {
         this._attributes = new AttributesMap();
         e = attributes.getAttributeNames();

         while(e.hasMoreElements()) {
            name = (String)e.nextElement();
            Object value = attributes.getAttribute(name);
            this.setManagedAttribute(name, value);
            this._attributes.setAttribute(name, value);
         }
      }

   }

   public void clearAttributes() {
      Enumeration e = this._attributes.getAttributeNames();

      while(e.hasMoreElements()) {
         String name = (String)e.nextElement();
         this.setManagedAttribute(name, (Object)null);
      }

      this._attributes.clearAttributes();
   }

   private void setManagedAttribute(String name, Object value) {
      if (this._managedAttributes != null && this._managedAttributes.contains(name)) {
         Object o = this._scontext.getAttribute(name);
         if (o != null) {
            this.getServer().getContainer().removeBean(o);
         }

         if (value != null) {
            this.getServer().getContainer().addBean(value);
         }
      }

   }

   public void setClassLoader(ClassLoader classLoader) {
      this._classLoader = classLoader;
   }

   public void setContextPath(String contextPath) {
      if (contextPath != null && contextPath.length() > 1 && contextPath.endsWith("/")) {
         throw new IllegalArgumentException("ends with /");
      } else {
         this._contextPath = contextPath;
         if (this.getServer() != null && (this.getServer().isStarting() || this.getServer().isStarted())) {
            Handler[] contextCollections = this.getServer().getChildHandlersByClass(ContextHandlerCollection.class);

            for(int h = 0; contextCollections != null && h < contextCollections.length; ++h) {
               ((ContextHandlerCollection)contextCollections[h]).mapContexts();
            }
         }

      }
   }

   public void setInitParams(Map initParams) {
      if (initParams != null) {
         this._initParams = new HashMap(initParams);
      }
   }

   public void setDisplayName(String servletContextName) {
      this._displayName = servletContextName;
      if (this._classLoader != null && this._classLoader instanceof WebAppClassLoader) {
         ((WebAppClassLoader)this._classLoader).setName(servletContextName);
      }

   }

   public Resource getBaseResource() {
      return this._baseResource == null ? null : this._baseResource;
   }

   public String getResourceBase() {
      return this._baseResource == null ? null : this._baseResource.toString();
   }

   public void setBaseResource(Resource base) {
      this._baseResource = base;
   }

   public void setResourceBase(String resourceBase) {
      try {
         this.setBaseResource(Resource.newResource(resourceBase));
      } catch (Exception var3) {
         Log.warn(var3.toString());
         Log.debug((Throwable)var3);
         throw new IllegalArgumentException(resourceBase);
      }
   }

   public MimeTypes getMimeTypes() {
      return this._mimeTypes;
   }

   public void setMimeTypes(MimeTypes mimeTypes) {
      this._mimeTypes = mimeTypes;
   }

   public void setWelcomeFiles(String[] files) {
      this._welcomeFiles = files;
   }

   public String[] getWelcomeFiles() {
      return this._welcomeFiles;
   }

   public ErrorHandler getErrorHandler() {
      return this._errorHandler;
   }

   public void setErrorHandler(ErrorHandler errorHandler) {
      if (errorHandler != null) {
         errorHandler.setServer(this.getServer());
      }

      if (this.getServer() != null) {
         this.getServer().getContainer().update(this, (Object)this._errorHandler, (Object)errorHandler, "errorHandler", true);
      }

      this._errorHandler = errorHandler;
   }

   public int getMaxFormContentSize() {
      return this._maxFormContentSize;
   }

   public void setMaxFormContentSize(int maxSize) {
      this._maxFormContentSize = maxSize;
   }

   public boolean isCompactPath() {
      return this._compactPath;
   }

   public void setCompactPath(boolean compactPath) {
      this._compactPath = compactPath;
   }

   public String toString() {
      return this.getClass().getName() + "@" + Integer.toHexString(this.hashCode()) + "{" + this.getContextPath() + "," + this.getBaseResource() + "}";
   }

   public synchronized Class loadClass(String className) throws ClassNotFoundException {
      if (className == null) {
         return null;
      } else {
         return this._classLoader == null ? Loader.loadClass(this.getClass(), className) : this._classLoader.loadClass(className);
      }
   }

   public void addLocaleEncoding(String locale, String encoding) {
      if (this._localeEncodingMap == null) {
         this._localeEncodingMap = new HashMap();
      }

      this._localeEncodingMap.put(locale, encoding);
   }

   public String getLocaleEncoding(Locale locale) {
      if (this._localeEncodingMap == null) {
         return null;
      } else {
         String encoding = (String)this._localeEncodingMap.get(locale.toString());
         if (encoding == null) {
            encoding = (String)this._localeEncodingMap.get(locale.getLanguage());
         }

         return encoding;
      }
   }

   public Resource getResource(String path) throws MalformedURLException {
      if (path != null && path.startsWith("/")) {
         if (this._baseResource == null) {
            return null;
         } else {
            try {
               path = URIUtil.canonicalPath(path);
               Resource resource = this._baseResource.addPath(path);
               return resource;
            } catch (Exception var3) {
               Log.ignore(var3);
               return null;
            }
         }
      } else {
         throw new MalformedURLException(path);
      }
   }

   public Set getResourcePaths(String path) {
      try {
         path = URIUtil.canonicalPath(path);
         Resource resource = this.getResource(path);
         if (resource != null && resource.exists()) {
            if (!path.endsWith("/")) {
               path = path + "/";
            }

            String[] l = resource.list();
            if (l != null) {
               HashSet set = new HashSet();

               for(int i = 0; i < l.length; ++i) {
                  set.add(path + l[i]);
               }

               return set;
            }
         }
      } catch (Exception var6) {
         Log.ignore(var6);
      }

      return Collections.EMPTY_SET;
   }

   private String normalizeHostname(String host) {
      if (host == null) {
         return null;
      } else {
         return host.endsWith(".") ? host.substring(0, host.length() - 1) : host;
      }
   }

   public class SContext implements ServletContext {
      protected SContext() {
      }

      public ContextHandler getContextHandler() {
         return ContextHandler.this;
      }

      public ServletContext getContext(String uripath) {
         ContextHandler context = null;
         Handler[] handlers = ContextHandler.this.getServer().getChildHandlersByClass(ContextHandler.class);

         for(int i = 0; i < handlers.length; ++i) {
            if (handlers[i] != null && handlers[i].isStarted()) {
               ContextHandler ch = (ContextHandler)handlers[i];
               String context_path = ch.getContextPath();
               if ((uripath.equals(context_path) || uripath.startsWith(context_path) && uripath.charAt(context_path.length()) == '/') && (context == null || context_path.length() > context.getContextPath().length())) {
                  context = ch;
               }
            }
         }

         if (context != null) {
            return context._scontext;
         } else {
            return null;
         }
      }

      public int getMajorVersion() {
         return 2;
      }

      public String getMimeType(String file) {
         if (ContextHandler.this._mimeTypes == null) {
            return null;
         } else {
            Buffer mime = ContextHandler.this._mimeTypes.getMimeByExtension(file);
            return mime != null ? mime.toString() : null;
         }
      }

      public int getMinorVersion() {
         return 5;
      }

      public RequestDispatcher getNamedDispatcher(String name) {
         return null;
      }

      public String getRealPath(String path) {
         if (path == null) {
            return null;
         } else {
            if (path.length() == 0) {
               path = "/";
            } else if (path.charAt(0) != '/') {
               path = "/" + path;
            }

            try {
               Resource resource = ContextHandler.this.getResource(path);
               if (resource != null) {
                  File file = resource.getFile();
                  if (file != null) {
                     return file.getCanonicalPath();
                  }
               }
            } catch (Exception var4) {
               Log.ignore(var4);
            }

            return null;
         }
      }

      public RequestDispatcher getRequestDispatcher(String uriInContext) {
         return null;
      }

      public URL getResource(String path) throws MalformedURLException {
         Resource resource = ContextHandler.this.getResource(path);
         return resource != null && resource.exists() ? resource.getURL() : null;
      }

      public InputStream getResourceAsStream(String path) {
         try {
            URL url = this.getResource(path);
            return url == null ? null : url.openStream();
         } catch (Exception var3) {
            Log.ignore(var3);
            return null;
         }
      }

      public Set getResourcePaths(String path) {
         return ContextHandler.this.getResourcePaths(path);
      }

      public String getServerInfo() {
         return "jetty/" + Server.getVersion();
      }

      public Servlet getServlet(String name) throws ServletException {
         return null;
      }

      public Enumeration getServletNames() {
         return Collections.enumeration(Collections.EMPTY_LIST);
      }

      public Enumeration getServlets() {
         return Collections.enumeration(Collections.EMPTY_LIST);
      }

      public void log(Exception exception, String msg) {
         ContextHandler.this._logger.warn(msg, exception);
      }

      public void log(String msg) {
         ContextHandler.this._logger.info(msg, (Object)null, (Object)null);
      }

      public void log(String message, Throwable throwable) {
         ContextHandler.this._logger.warn(message, throwable);
      }

      public String getInitParameter(String name) {
         return ContextHandler.this.getInitParameter(name);
      }

      public Enumeration getInitParameterNames() {
         return ContextHandler.this.getInitParameterNames();
      }

      public synchronized Object getAttribute(String name) {
         Object o = ContextHandler.this.getAttribute(name);
         if (o == null && ContextHandler.this._contextAttributes != null) {
            o = ContextHandler.this._contextAttributes.getAttribute(name);
         }

         return o;
      }

      public synchronized Enumeration getAttributeNames() {
         HashSet set = new HashSet();
         Enumeration e;
         if (ContextHandler.this._contextAttributes != null) {
            e = ContextHandler.this._contextAttributes.getAttributeNames();

            while(e.hasMoreElements()) {
               set.add(e.nextElement());
            }
         }

         e = ContextHandler.this._attributes.getAttributeNames();

         while(e.hasMoreElements()) {
            set.add(e.nextElement());
         }

         return Collections.enumeration(set);
      }

      public synchronized void setAttribute(String name, Object value) {
         if (ContextHandler.this._contextAttributes == null) {
            ContextHandler.this.setAttribute(name, value);
         } else {
            ContextHandler.this.setManagedAttribute(name, value);
            Object old_value = ContextHandler.this._contextAttributes.getAttribute(name);
            if (value == null) {
               ContextHandler.this._contextAttributes.removeAttribute(name);
            } else {
               ContextHandler.this._contextAttributes.setAttribute(name, value);
            }

            if (ContextHandler.this._contextAttributeListeners != null) {
               ServletContextAttributeEvent event = new ServletContextAttributeEvent(ContextHandler.this._scontext, name, old_value == null ? value : old_value);

               for(int i = 0; i < LazyList.size(ContextHandler.this._contextAttributeListeners); ++i) {
                  ServletContextAttributeListener l = (ServletContextAttributeListener)LazyList.get(ContextHandler.this._contextAttributeListeners, i);
                  if (old_value == null) {
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

      public synchronized void removeAttribute(String name) {
         ContextHandler.this.setManagedAttribute(name, (Object)null);
         if (ContextHandler.this._contextAttributes == null) {
            ContextHandler.this._attributes.removeAttribute(name);
         } else {
            Object old_value = ContextHandler.this._contextAttributes.getAttribute(name);
            ContextHandler.this._contextAttributes.removeAttribute(name);
            if (old_value != null && ContextHandler.this._contextAttributeListeners != null) {
               ServletContextAttributeEvent event = new ServletContextAttributeEvent(ContextHandler.this._scontext, name, old_value);

               for(int i = 0; i < LazyList.size(ContextHandler.this._contextAttributeListeners); ++i) {
                  ((ServletContextAttributeListener)LazyList.get(ContextHandler.this._contextAttributeListeners, i)).attributeRemoved(event);
               }
            }

         }
      }

      public String getServletContextName() {
         String name = ContextHandler.this.getDisplayName();
         if (name == null) {
            name = ContextHandler.this.getContextPath();
         }

         return name;
      }

      public String getContextPath() {
         return ContextHandler.this._contextPath != null && ContextHandler.this._contextPath.equals("/") ? "" : ContextHandler.this._contextPath;
      }

      public String toString() {
         return "ServletContext@" + Integer.toHexString(this.hashCode()) + "{" + (this.getContextPath().equals("") ? "/" : this.getContextPath()) + "," + ContextHandler.this.getBaseResource() + "}";
      }
   }
}
