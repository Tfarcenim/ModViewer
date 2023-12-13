package com.replaymod.lib.org.mortbay.jetty.webapp;

import com.replaymod.lib.org.mortbay.jetty.Connector;
import com.replaymod.lib.org.mortbay.jetty.HandlerContainer;
import com.replaymod.lib.org.mortbay.jetty.HttpConnection;
import com.replaymod.lib.org.mortbay.jetty.Request;
import com.replaymod.lib.org.mortbay.jetty.Server;
import com.replaymod.lib.org.mortbay.jetty.deployer.WebAppDeployer;
import com.replaymod.lib.org.mortbay.jetty.handler.ContextHandler;
import com.replaymod.lib.org.mortbay.jetty.handler.ContextHandlerCollection;
import com.replaymod.lib.org.mortbay.jetty.handler.ErrorHandler;
import com.replaymod.lib.org.mortbay.jetty.handler.HandlerCollection;
import com.replaymod.lib.org.mortbay.jetty.security.SecurityHandler;
import com.replaymod.lib.org.mortbay.jetty.servlet.Context;
import com.replaymod.lib.org.mortbay.jetty.servlet.ErrorPageErrorHandler;
import com.replaymod.lib.org.mortbay.jetty.servlet.ServletHandler;
import com.replaymod.lib.org.mortbay.jetty.servlet.SessionHandler;
import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.resource.JarResource;
import com.replaymod.lib.org.mortbay.resource.Resource;
import com.replaymod.lib.org.mortbay.util.IO;
import com.replaymod.lib.org.mortbay.util.LazyList;
import com.replaymod.lib.org.mortbay.util.Loader;
import com.replaymod.lib.org.mortbay.util.StringUtil;
import com.replaymod.lib.org.mortbay.util.URIUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.PermissionCollection;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionListener;

public class WebAppContext extends Context {
   public static final String WEB_DEFAULTS_XML = "com/replaymod/lib/org/mortbay/jetty/webapp/webdefault.xml";
   public static final String ERROR_PAGE = "com.replaymod.lib.org.mortbay.jetty.error_page";
   private static String[] __dftConfigurationClasses = new String[]{"com.replaymod.lib.org.mortbay.jetty.webapp.WebInfConfiguration", "com.replaymod.lib.org.mortbay.jetty.webapp.WebXmlConfiguration", "com.replaymod.lib.org.mortbay.jetty.webapp.JettyWebXmlConfiguration", "com.replaymod.lib.org.mortbay.jetty.webapp.TagLibConfiguration"};
   private String[] _configurationClasses;
   private Configuration[] _configurations;
   private String _defaultsDescriptor;
   private String _descriptor;
   private String _overrideDescriptor;
   private boolean _distributable;
   private boolean _extractWAR;
   private boolean _copyDir;
   private boolean _logUrlOnStart;
   private boolean _parentLoaderPriority;
   private PermissionCollection _permissions;
   private String[] _systemClasses;
   private String[] _serverClasses;
   private File _tmpDir;
   private boolean _isExistingTmpDir;
   private String _war;
   private String _extraClasspath;
   private Throwable _unavailableException;
   private transient Map _resourceAliases;
   private transient boolean _ownClassLoader;
   private transient boolean _unavailable;

   public static ContextHandler getCurrentWebAppContext() {
      ContextHandler.SContext context = ContextHandler.getCurrentContext();
      if (context != null) {
         ContextHandler handler = context.getContextHandler();
         if (handler instanceof WebAppContext) {
            return handler;
         }
      }

      return null;
   }

   /** @deprecated */
   public static void addWebApplications(Server server, String webapps, String defaults, boolean extract, boolean java2CompliantClassLoader) throws IOException {
      addWebApplications(server, webapps, defaults, __dftConfigurationClasses, extract, java2CompliantClassLoader);
   }

   /** @deprecated */
   public static void addWebApplications(Server server, String webapps, String defaults, String[] configurations, boolean extract, boolean java2CompliantClassLoader) throws IOException {
      HandlerCollection contexts = (HandlerCollection)server.getChildHandlerByClass(ContextHandlerCollection.class);
      if (contexts == null) {
         contexts = (HandlerCollection)server.getChildHandlerByClass(HandlerCollection.class);
      }

      addWebApplications((HandlerContainer)contexts, webapps, defaults, configurations, extract, java2CompliantClassLoader);
   }

   /** @deprecated */
   public static void addWebApplications(HandlerContainer contexts, String webapps, String defaults, boolean extract, boolean java2CompliantClassLoader) throws IOException {
      addWebApplications(contexts, webapps, defaults, __dftConfigurationClasses, extract, java2CompliantClassLoader);
   }

   /** @deprecated */
   public static void addWebApplications(HandlerContainer contexts, String webapps, String defaults, String[] configurations, boolean extract, boolean java2CompliantClassLoader) throws IOException {
      Log.warn("Deprecated configuration used for " + webapps);
      WebAppDeployer deployer = new WebAppDeployer();
      deployer.setContexts(contexts);
      deployer.setWebAppDir(webapps);
      deployer.setConfigurationClasses(configurations);
      deployer.setExtract(extract);
      deployer.setParentLoaderPriority(java2CompliantClassLoader);

      try {
         deployer.start();
      } catch (IOException var8) {
         throw var8;
      } catch (Exception var9) {
         throw new RuntimeException(var9);
      }
   }

   public WebAppContext() {
      this((SecurityHandler)null, (SessionHandler)null, (ServletHandler)null, (ErrorHandler)null);
   }

   public WebAppContext(String webApp, String contextPath) {
      super((HandlerContainer)null, contextPath, 3);
      this._configurationClasses = __dftConfigurationClasses;
      this._defaultsDescriptor = "com/replaymod/lib/org/mortbay/jetty/webapp/webdefault.xml";
      this._descriptor = null;
      this._overrideDescriptor = null;
      this._distributable = false;
      this._extractWAR = true;
      this._copyDir = false;
      this._logUrlOnStart = false;
      this._parentLoaderPriority = Boolean.getBoolean("com.replaymod.lib.org.mortbay.jetty.webapp.parentLoaderPriority");
      this._systemClasses = new String[]{"java.", "javax.", "com.replaymod.lib.org.mortbay.", "org.xml.", "org.w3c.", "com.replaymod.lib.org.apache.commons.logging.", "org.apache.log4j."};
      this._serverClasses = new String[]{"-org.mortbay.jetty.plus.annotation.", "-org.mortbay.jetty.plus.jaas.", "-org.mortbay.jetty.plus.naming.", "-org.mortbay.jetty.plus.jaas.", "-org.mortbay.jetty.servlet.DefaultServlet", "com.replaymod.lib.org.mortbay.jetty.", "com.replaymod.lib.org.slf4j."};
      this._ownClassLoader = false;
      this.setContextPath(contextPath);
      this.setWar(webApp);
      this.setErrorHandler(new ErrorPageErrorHandler());
   }

   public WebAppContext(HandlerContainer parent, String webApp, String contextPath) {
      super(parent, contextPath, 3);
      this._configurationClasses = __dftConfigurationClasses;
      this._defaultsDescriptor = "com/replaymod/lib/org/mortbay/jetty/webapp/webdefault.xml";
      this._descriptor = null;
      this._overrideDescriptor = null;
      this._distributable = false;
      this._extractWAR = true;
      this._copyDir = false;
      this._logUrlOnStart = false;
      this._parentLoaderPriority = Boolean.getBoolean("com.replaymod.lib.org.mortbay.jetty.webapp.parentLoaderPriority");
      this._systemClasses = new String[]{"java.", "javax.", "com.replaymod.lib.org.mortbay.", "org.xml.", "org.w3c.", "com.replaymod.lib.org.apache.commons.logging.", "org.apache.log4j."};
      this._serverClasses = new String[]{"-org.mortbay.jetty.plus.annotation.", "-org.mortbay.jetty.plus.jaas.", "-org.mortbay.jetty.plus.naming.", "-org.mortbay.jetty.plus.jaas.", "-org.mortbay.jetty.servlet.DefaultServlet", "com.replaymod.lib.org.mortbay.jetty.", "com.replaymod.lib.org.slf4j."};
      this._ownClassLoader = false;
      this.setWar(webApp);
      this.setErrorHandler(new ErrorPageErrorHandler());
   }

   public WebAppContext(SecurityHandler securityHandler, SessionHandler sessionHandler, ServletHandler servletHandler, ErrorHandler errorHandler) {
      super((HandlerContainer)null, sessionHandler != null ? sessionHandler : new SessionHandler(), securityHandler != null ? securityHandler : new SecurityHandler(), servletHandler != null ? servletHandler : new ServletHandler(), (ErrorHandler)null);
      this._configurationClasses = __dftConfigurationClasses;
      this._defaultsDescriptor = "com/replaymod/lib/org/mortbay/jetty/webapp/webdefault.xml";
      this._descriptor = null;
      this._overrideDescriptor = null;
      this._distributable = false;
      this._extractWAR = true;
      this._copyDir = false;
      this._logUrlOnStart = false;
      this._parentLoaderPriority = Boolean.getBoolean("com.replaymod.lib.org.mortbay.jetty.webapp.parentLoaderPriority");
      this._systemClasses = new String[]{"java.", "javax.", "com.replaymod.lib.org.mortbay.", "org.xml.", "org.w3c.", "com.replaymod.lib.org.apache.commons.logging.", "org.apache.log4j."};
      this._serverClasses = new String[]{"-org.mortbay.jetty.plus.annotation.", "-org.mortbay.jetty.plus.jaas.", "-org.mortbay.jetty.plus.naming.", "-org.mortbay.jetty.plus.jaas.", "-org.mortbay.jetty.servlet.DefaultServlet", "com.replaymod.lib.org.mortbay.jetty.", "com.replaymod.lib.org.slf4j."};
      this._ownClassLoader = false;
      this.setErrorHandler((ErrorHandler)(errorHandler != null ? errorHandler : new ErrorPageErrorHandler()));
   }

   public Throwable getUnavailableException() {
      return this._unavailableException;
   }

   public void setResourceAlias(String alias, String uri) {
      if (this._resourceAliases == null) {
         this._resourceAliases = new HashMap(5);
      }

      this._resourceAliases.put(alias, uri);
   }

   public Map getResourceAliases() {
      return this._resourceAliases == null ? null : this._resourceAliases;
   }

   public void setResourceAliases(Map map) {
      this._resourceAliases = map;
   }

   public String getResourceAlias(String alias) {
      return this._resourceAliases == null ? null : (String)this._resourceAliases.get(alias);
   }

   public String removeResourceAlias(String alias) {
      return this._resourceAliases == null ? null : (String)this._resourceAliases.remove(alias);
   }

   public void setClassLoader(ClassLoader classLoader) {
      super.setClassLoader(classLoader);
      if (classLoader != null && classLoader instanceof WebAppClassLoader) {
         ((WebAppClassLoader)classLoader).setName(this.getDisplayName());
      }

   }

   public Resource getResource(String uriInContext) throws MalformedURLException {
      IOException ioe = null;
      Resource resource = null;
      int var4 = 0;

      while(uriInContext != null && var4++ < 100) {
         try {
            resource = super.getResource(uriInContext);
            if (resource != null && resource.exists()) {
               return resource;
            }

            uriInContext = this.getResourceAlias(uriInContext);
         } catch (IOException var6) {
            Log.ignore(var6);
            if (ioe == null) {
               ioe = var6;
            }
         }
      }

      if (ioe != null && ioe instanceof MalformedURLException) {
         throw (MalformedURLException)ioe;
      } else {
         return resource;
      }
   }

   public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch) throws IOException, ServletException {
      if (this._unavailable) {
         Request base_request = request instanceof Request ? (Request)request : HttpConnection.getCurrentConnection().getRequest();
         base_request.setHandled(true);
         response.sendError(503);
      } else {
         super.handle(target, request, response, dispatch);
      }

   }

   protected void doStart() throws Exception {
      try {
         this.loadConfigurations();

         int i;
         for(i = 0; i < this._configurations.length; ++i) {
            this._configurations[i].setWebAppContext(this);
         }

         this._ownClassLoader = false;
         if (this.getClassLoader() == null) {
            WebAppClassLoader classLoader = new WebAppClassLoader(this);
            this.setClassLoader(classLoader);
            this._ownClassLoader = true;
         }

         if (Log.isDebugEnabled()) {
            ClassLoader loader = this.getClassLoader();
            Log.debug("Thread Context class loader is: " + loader);

            for(loader = loader.getParent(); loader != null; loader = loader.getParent()) {
               Log.debug("Parent class loader is: " + loader);
            }
         }

         for(i = 0; i < this._configurations.length; ++i) {
            this._configurations[i].configureClassLoader();
         }

         this.getTempDirectory();
         if (this._tmpDir != null && !this._isExistingTmpDir && !this.isTempWorkDirectory()) {
            File sentinel = new File(this._tmpDir, ".active");
            if (!sentinel.exists()) {
               sentinel.mkdir();
            }
         }

         super.doStart();
         if (this.isLogUrlOnStart()) {
            this.dumpUrl();
         }
      } catch (Exception var2) {
         Log.warn("Failed startup of context " + this, (Throwable)var2);
         this._unavailableException = var2;
         this._unavailable = true;
      }

   }

   public void dumpUrl() {
      Connector[] connectors = this.getServer().getConnectors();

      for(int i = 0; i < connectors.length; ++i) {
         String connectorName = connectors[i].getName();
         String displayName = this.getDisplayName();
         if (displayName == null) {
            displayName = "WebApp@" + connectors.hashCode();
         }

         Log.info(displayName + " at http://" + connectorName + this.getContextPath());
      }

   }

   protected void doStop() throws Exception {
      super.doStop();

      try {
         int i = this._configurations.length;

         while(true) {
            if (i-- <= 0) {
               this._configurations = null;
               if (this._securityHandler.getHandler() == null) {
                  this._sessionHandler.setHandler(this._securityHandler);
                  this._securityHandler.setHandler(this._servletHandler);
               }

               if (this._tmpDir != null && !this._isExistingTmpDir && !this.isTempWorkDirectory()) {
                  IO.delete(this._tmpDir);
                  this._tmpDir = null;
               }
               break;
            }

            this._configurations[i].deconfigureWebApp();
         }
      } finally {
         if (this._ownClassLoader) {
            this.setClassLoader((ClassLoader)null);
         }

         this._unavailable = false;
         this._unavailableException = null;
      }

   }

   public String[] getConfigurationClasses() {
      return this._configurationClasses;
   }

   public Configuration[] getConfigurations() {
      return this._configurations;
   }

   public String getDefaultsDescriptor() {
      return this._defaultsDescriptor;
   }

   public String getOverrideDescriptor() {
      return this._overrideDescriptor;
   }

   public PermissionCollection getPermissions() {
      return this._permissions;
   }

   public String[] getServerClasses() {
      return this._serverClasses;
   }

   public String[] getSystemClasses() {
      return this._systemClasses;
   }

   public File getTempDirectory() {
      if (this._tmpDir != null && this._tmpDir.isDirectory() && this._tmpDir.canWrite()) {
         return this._tmpDir;
      } else {
         Object t = this.getAttribute("javax.servlet.context.tempdir");
         if (t != null && t instanceof File) {
            this._tmpDir = (File)t;
            if (this._tmpDir.isDirectory() && this._tmpDir.canWrite()) {
               return this._tmpDir;
            }
         }

         if (t != null && t instanceof String) {
            try {
               this._tmpDir = new File((String)t);
               if (this._tmpDir.isDirectory() && this._tmpDir.canWrite()) {
                  if (Log.isDebugEnabled()) {
                     Log.debug("Converted to File " + this._tmpDir + " for " + this);
                  }

                  this.setAttribute("javax.servlet.context.tempdir", this._tmpDir);
                  return this._tmpDir;
               }
            } catch (Exception var7) {
               Log.warn("EXCEPTION ", (Throwable)var7);
            }
         }

         File work = null;

         try {
            File w = new File(System.getProperty("jetty.home"), "work");
            if (w.exists() && w.canWrite() && w.isDirectory()) {
               work = w;
            } else if (this.getBaseResource() != null) {
               Resource web_inf = this.getWebInf();
               if (web_inf != null && web_inf.exists()) {
                  w = new File(web_inf.getFile(), "work");
                  if (w.exists() && w.canWrite() && w.isDirectory()) {
                     work = w;
                  }
               }
            }
         } catch (Exception var8) {
            Log.ignore(var8);
         }

         try {
            String temp = this.getCanonicalNameForWebAppTmpDir();
            if (work != null) {
               this._tmpDir = new File(work, temp);
            } else {
               this._tmpDir = new File(System.getProperty("java.io.tmpdir"), temp);
               if (this._tmpDir.exists()) {
                  if (Log.isDebugEnabled()) {
                     Log.debug("Delete existing temp dir " + this._tmpDir + " for " + this);
                  }

                  if (!IO.delete(this._tmpDir) && Log.isDebugEnabled()) {
                     Log.debug("Failed to delete temp dir " + this._tmpDir);
                  }

                  if (this._tmpDir.exists()) {
                     String old = this._tmpDir.toString();
                     this._tmpDir = File.createTempFile(temp + "_", "");
                     if (this._tmpDir.exists()) {
                        this._tmpDir.delete();
                     }

                     Log.warn("Can't reuse " + old + ", using " + this._tmpDir);
                  }
               }
            }

            if (!this._tmpDir.exists()) {
               this._tmpDir.mkdir();
            }

            if (!this.isTempWorkDirectory()) {
               this._tmpDir.deleteOnExit();
            }

            if (Log.isDebugEnabled()) {
               Log.debug("Created temp dir " + this._tmpDir + " for " + this);
            }
         } catch (Exception var6) {
            this._tmpDir = null;
            Log.ignore(var6);
         }

         if (this._tmpDir == null) {
            try {
               this._tmpDir = File.createTempFile("JettyContext", "");
               if (this._tmpDir.exists()) {
                  this._tmpDir.delete();
               }

               this._tmpDir.mkdir();
               this._tmpDir.deleteOnExit();
               if (Log.isDebugEnabled()) {
                  Log.debug("Created temp dir " + this._tmpDir + " for " + this);
               }
            } catch (IOException var5) {
               Log.warn("tmpdir", (Throwable)var5);
               System.exit(1);
            }
         }

         this.setAttribute("javax.servlet.context.tempdir", this._tmpDir);
         return this._tmpDir;
      }
   }

   public boolean isTempWorkDirectory() {
      if (this._tmpDir == null) {
         return false;
      } else if (this._tmpDir.getName().equalsIgnoreCase("work")) {
         return true;
      } else {
         File t = this._tmpDir.getParentFile();
         return t == null ? false : t.getName().equalsIgnoreCase("work");
      }
   }

   public String getWar() {
      if (this._war == null) {
         this._war = this.getResourceBase();
      }

      return this._war;
   }

   public Resource getWebInf() throws IOException {
      this.resolveWebApp();
      Resource web_inf = super.getBaseResource().addPath("WEB-INF/");
      return web_inf.exists() && web_inf.isDirectory() ? web_inf : null;
   }

   public boolean isDistributable() {
      return this._distributable;
   }

   public boolean isExtractWAR() {
      return this._extractWAR;
   }

   public boolean isCopyWebDir() {
      return this._copyDir;
   }

   public boolean isParentLoaderPriority() {
      return this._parentLoaderPriority;
   }

   protected void loadConfigurations() throws Exception {
      if (this._configurations == null) {
         if (this._configurationClasses == null) {
            this._configurationClasses = __dftConfigurationClasses;
         }

         this._configurations = new Configuration[this._configurationClasses.length];

         for(int i = 0; i < this._configurations.length; ++i) {
            this._configurations[i] = (Configuration)Loader.loadClass(this.getClass(), this._configurationClasses[i]).newInstance();
         }

      }
   }

   protected boolean isProtectedTarget(String target) {
      while(target.startsWith("//")) {
         target = URIUtil.compactPath(target);
      }

      return StringUtil.startsWithIgnoreCase(target, "/web-inf") || StringUtil.startsWithIgnoreCase(target, "/meta-inf");
   }

   public String toString() {
      return this.getClass().getName() + "@" + Integer.toHexString(this.hashCode()) + "{" + this.getContextPath() + "," + (this._war == null ? this.getResourceBase() : this._war) + "}";
   }

   protected void resolveWebApp() throws IOException {
      Resource web_app = super.getBaseResource();
      if (web_app == null) {
         if (this._war == null || this._war.length() == 0) {
            this._war = this.getResourceBase();
         }

         web_app = Resource.newResource(this._war);
         if (web_app.getAlias() != null) {
            Log.debug(web_app + " anti-aliased to " + web_app.getAlias());
            web_app = Resource.newResource(web_app.getAlias());
         }

         if (Log.isDebugEnabled()) {
            Log.debug("Try webapp=" + web_app + ", exists=" + web_app.exists() + ", directory=" + web_app.isDirectory());
         }

         if (web_app.exists() && !web_app.isDirectory() && !web_app.toString().startsWith("jar:")) {
            Resource jarWebApp = Resource.newResource("jar:" + web_app + "!/");
            if (jarWebApp.exists() && jarWebApp.isDirectory()) {
               web_app = jarWebApp;
            }
         }

         if (web_app.exists() && (this._copyDir && web_app.getFile() != null && web_app.getFile().isDirectory() || this._extractWAR && web_app.getFile() != null && !web_app.getFile().isDirectory() || this._extractWAR && web_app.getFile() == null || !web_app.isDirectory())) {
            File extractedWebAppDir = new File(this.getTempDirectory(), "webapp");
            if (web_app.getFile() != null && web_app.getFile().isDirectory()) {
               Log.info("Copy " + web_app.getFile() + " to " + extractedWebAppDir);
               IO.copyDir(web_app.getFile(), extractedWebAppDir);
            } else if (!extractedWebAppDir.exists()) {
               extractedWebAppDir.mkdir();
               Log.info("Extract " + this._war + " to " + extractedWebAppDir);
               JarResource.extract(web_app, extractedWebAppDir, false);
            } else if (web_app.lastModified() > extractedWebAppDir.lastModified()) {
               IO.delete(extractedWebAppDir);
               extractedWebAppDir.mkdir();
               Log.info("Extract " + this._war + " to " + extractedWebAppDir);
               JarResource.extract(web_app, extractedWebAppDir, false);
            }

            web_app = Resource.newResource(extractedWebAppDir.getCanonicalPath());
         }

         if (!web_app.exists() || !web_app.isDirectory()) {
            Log.warn("Web application not found " + this._war);
            throw new FileNotFoundException(this._war);
         }

         if (Log.isDebugEnabled()) {
            Log.debug("webapp=" + web_app);
         }

         super.setBaseResource(web_app);
      }

   }

   public void setConfigurationClasses(String[] configurations) {
      if (this.isRunning()) {
         throw new IllegalStateException("Running");
      } else {
         this._configurationClasses = configurations == null ? null : (String[])((String[])configurations.clone());
      }
   }

   public void setConfigurations(Configuration[] configurations) {
      if (this.isRunning()) {
         throw new IllegalStateException("Running");
      } else {
         this._configurations = configurations == null ? null : (Configuration[])((Configuration[])configurations.clone());
      }
   }

   public void setDefaultsDescriptor(String defaultsDescriptor) {
      if (this.isRunning()) {
         throw new IllegalStateException("Running");
      } else {
         this._defaultsDescriptor = defaultsDescriptor;
      }
   }

   public void setOverrideDescriptor(String overrideDescriptor) {
      if (this.isRunning()) {
         throw new IllegalStateException("Running");
      } else {
         this._overrideDescriptor = overrideDescriptor;
      }
   }

   public String getDescriptor() {
      return this._descriptor;
   }

   public void setDescriptor(String descriptor) {
      if (this.isRunning()) {
         throw new IllegalStateException("Running");
      } else {
         this._descriptor = descriptor;
      }
   }

   public void setDistributable(boolean distributable) {
      this._distributable = distributable;
   }

   public void setEventListeners(EventListener[] eventListeners) {
      if (this._sessionHandler != null) {
         this._sessionHandler.clearEventListeners();
      }

      super.setEventListeners(eventListeners);

      for(int i = 0; eventListeners != null && i < eventListeners.length; ++i) {
         EventListener listener = eventListeners[i];
         if ((listener instanceof HttpSessionActivationListener || listener instanceof HttpSessionAttributeListener || listener instanceof HttpSessionBindingListener || listener instanceof HttpSessionListener) && this._sessionHandler != null) {
            this._sessionHandler.addEventListener(listener);
         }
      }

   }

   public void addEventListener(EventListener listener) {
      this.setEventListeners((EventListener[])((EventListener[])LazyList.addToArray(this.getEventListeners(), listener, EventListener.class)));
   }

   public void setExtractWAR(boolean extractWAR) {
      this._extractWAR = extractWAR;
   }

   public void setCopyWebDir(boolean copy) {
      this._copyDir = copy;
   }

   public void setParentLoaderPriority(boolean java2compliant) {
      this._parentLoaderPriority = java2compliant;
   }

   public void setPermissions(PermissionCollection permissions) {
      this._permissions = permissions;
   }

   public void setServerClasses(String[] serverClasses) {
      this._serverClasses = serverClasses == null ? null : (String[])((String[])serverClasses.clone());
   }

   public void setSystemClasses(String[] systemClasses) {
      this._systemClasses = systemClasses == null ? null : (String[])((String[])systemClasses.clone());
   }

   public void setTempDirectory(File dir) {
      if (this.isStarted()) {
         throw new IllegalStateException("Started");
      } else {
         if (dir != null) {
            try {
               dir = new File(dir.getCanonicalPath());
            } catch (IOException var3) {
               Log.warn("EXCEPTION ", (Throwable)var3);
            }
         }

         if (dir != null && !dir.exists()) {
            dir.mkdir();
            dir.deleteOnExit();
         } else if (dir != null) {
            this._isExistingTmpDir = true;
         }

         if (dir == null || dir.exists() && dir.isDirectory() && dir.canWrite()) {
            this._tmpDir = dir;
            this.setAttribute("javax.servlet.context.tempdir", this._tmpDir);
         } else {
            throw new IllegalArgumentException("Bad temp directory: " + dir);
         }
      }
   }

   public void setWar(String war) {
      this._war = war;
   }

   public String getExtraClasspath() {
      return this._extraClasspath;
   }

   public void setExtraClasspath(String extraClasspath) {
      this._extraClasspath = extraClasspath;
   }

   public boolean isLogUrlOnStart() {
      return this._logUrlOnStart;
   }

   public void setLogUrlOnStart(boolean logOnStart) {
      this._logUrlOnStart = logOnStart;
   }

   protected void startContext() throws Exception {
      for(int i = 0; i < this._configurations.length; ++i) {
         this._configurations[i].configureDefaults();
      }

      Resource web_inf = this.getWebInf();
      if (web_inf != null) {
         Resource work = web_inf.addPath("work");
         if (work.exists() && work.isDirectory() && work.getFile() != null && work.getFile().canWrite() && this.getAttribute("javax.servlet.context.tempdir") == null) {
            this.setAttribute("javax.servlet.context.tempdir", work.getFile());
         }
      }

      for(int i = 0; i < this._configurations.length; ++i) {
         this._configurations[i].configureWebApp();
      }

      super.startContext();
   }

   private String getCanonicalNameForWebAppTmpDir() {
      StringBuffer canonicalName = new StringBuffer();
      canonicalName.append("Jetty");
      Connector[] connectors = this.getServer().getConnectors();
      canonicalName.append("_");
      String host = connectors != null && connectors[0] != null ? connectors[0].getHost() : "";
      if (host == null) {
         host = "0.0.0.0";
      }

      canonicalName.append(host.replace('.', '_'));
      canonicalName.append("_");
      int port = connectors != null && connectors[0] != null ? connectors[0].getLocalPort() : 0;
      if (port < 0) {
         port = connectors[0].getPort();
      }

      canonicalName.append(port);
      canonicalName.append("_");

      try {
         Resource resource = super.getBaseResource();
         if (resource == null) {
            if (this._war == null || this._war.length() == 0) {
               resource = Resource.newResource(this.getResourceBase());
            }

            resource = Resource.newResource(this._war);
         }

         String tmp = URIUtil.decodePath(resource.getURL().getPath());
         if (tmp.endsWith("/")) {
            tmp = tmp.substring(0, tmp.length() - 1);
         }

         if (tmp.endsWith("!")) {
            tmp = tmp.substring(0, tmp.length() - 1);
         }

         int i = tmp.lastIndexOf("/");
         canonicalName.append(tmp.substring(i + 1, tmp.length()));
      } catch (Exception var10) {
         Log.warn("Can't generate resourceBase as part of webapp tmp dir name", (Throwable)var10);
      }

      canonicalName.append("_");
      String contextPath = this.getContextPath();
      contextPath = contextPath.replace('/', '_');
      contextPath = contextPath.replace('\\', '_');
      canonicalName.append(contextPath);
      canonicalName.append("_");
      String[] vhosts = this.getVirtualHosts();
      canonicalName.append(vhosts != null && vhosts[0] != null ? vhosts[0] : "");
      String hash = Integer.toString(canonicalName.toString().hashCode(), 36);
      canonicalName.append("_");
      canonicalName.append(hash);

      for(int i = 0; i < canonicalName.length(); ++i) {
         char c = canonicalName.charAt(i);
         if (!Character.isJavaIdentifierPart(c)) {
            canonicalName.setCharAt(i, '.');
         }
      }

      return canonicalName.toString();
   }
}
