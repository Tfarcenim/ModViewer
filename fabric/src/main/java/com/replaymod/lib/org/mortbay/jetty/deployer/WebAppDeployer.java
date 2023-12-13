package com.replaymod.lib.org.mortbay.jetty.deployer;

import com.replaymod.lib.org.mortbay.component.AbstractLifeCycle;
import com.replaymod.lib.org.mortbay.jetty.Handler;
import com.replaymod.lib.org.mortbay.jetty.HandlerContainer;
import com.replaymod.lib.org.mortbay.jetty.handler.ContextHandler;
import com.replaymod.lib.org.mortbay.jetty.handler.ContextHandlerCollection;
import com.replaymod.lib.org.mortbay.jetty.webapp.WebAppContext;
import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.resource.Resource;
import java.util.ArrayList;

public class WebAppDeployer extends AbstractLifeCycle {
   private HandlerContainer _contexts;
   private String _webAppDir;
   private String _defaultsDescriptor;
   private String[] _configurationClasses;
   private boolean _extract;
   private boolean _parentLoaderPriority;
   private boolean _allowDuplicates;
   private ArrayList _deployed;

   public String[] getConfigurationClasses() {
      return this._configurationClasses;
   }

   public void setConfigurationClasses(String[] configurationClasses) {
      this._configurationClasses = configurationClasses;
   }

   public HandlerContainer getContexts() {
      return this._contexts;
   }

   public void setContexts(HandlerContainer contexts) {
      this._contexts = contexts;
   }

   public String getDefaultsDescriptor() {
      return this._defaultsDescriptor;
   }

   public void setDefaultsDescriptor(String defaultsDescriptor) {
      this._defaultsDescriptor = defaultsDescriptor;
   }

   public boolean isExtract() {
      return this._extract;
   }

   public void setExtract(boolean extract) {
      this._extract = extract;
   }

   public boolean isParentLoaderPriority() {
      return this._parentLoaderPriority;
   }

   public void setParentLoaderPriority(boolean parentPriorityClassLoading) {
      this._parentLoaderPriority = parentPriorityClassLoading;
   }

   public String getWebAppDir() {
      return this._webAppDir;
   }

   public void setWebAppDir(String dir) {
      this._webAppDir = dir;
   }

   public boolean getAllowDuplicates() {
      return this._allowDuplicates;
   }

   public void setAllowDuplicates(boolean allowDuplicates) {
      this._allowDuplicates = allowDuplicates;
   }

   public void doStart() throws Exception {
      this._deployed = new ArrayList();
      this.scan();
   }

   public void scan() throws Exception {
      if (this._contexts == null) {
         throw new IllegalArgumentException("No HandlerContainer");
      } else {
         Resource r = Resource.newResource(this._webAppDir);
         if (!r.exists()) {
            throw new IllegalArgumentException("No such webapps resource " + r);
         } else if (!r.isDirectory()) {
            throw new IllegalArgumentException("Not directory webapps resource " + r);
         } else {
            String[] files = r.list();

            label136:
            for(int f = 0; files != null && f < files.length; ++f) {
               String context = files[f];
               if (!context.equalsIgnoreCase("CVS/") && !context.equalsIgnoreCase("CVS") && !context.startsWith(".")) {
                  Resource app = r.addPath(r.encode(context));
                  Resource wah;
                  if (!context.toLowerCase().endsWith(".war") && !context.toLowerCase().endsWith(".jar")) {
                     if (!app.isDirectory()) {
                        continue;
                     }
                  } else {
                     context = context.substring(0, context.length() - 4);
                     wah = r.addPath(context);
                     if (wah != null && wah.exists() && wah.isDirectory()) {
                        continue;
                     }
                  }

                  if (!context.equalsIgnoreCase("root") && !context.equalsIgnoreCase("root/")) {
                     context = "/" + context;
                  } else {
                     context = "/";
                  }

                  if (context.endsWith("/") && context.length() > 0) {
                     context = context.substring(0, context.length() - 1);
                  }

                  if (!this._allowDuplicates) {
                     Handler[] installed = this._contexts.getChildHandlersByClass(ContextHandler.class);

                     for(int i = 0; i < installed.length; ++i) {
                        ContextHandler c = (ContextHandler)installed[i];
                        if (context.equals(c.getContextPath())) {
                           continue label136;
                        }

                        try {
                           String path = null;
                           if (c instanceof WebAppContext) {
                              path = Resource.newResource(((WebAppContext)c).getWar()).getFile().getAbsolutePath();
                           } else if (c.getBaseResource() != null) {
                              path = c.getBaseResource().getFile().getAbsolutePath();
                           }

                           if (path != null && path.equals(app.getFile().getAbsolutePath())) {
                              continue label136;
                           }
                        } catch (Exception var11) {
                           Log.ignore(var11);
                        }
                     }
                  }

                  wah = null;
                  WebAppContext wah;
                  if (this._contexts instanceof ContextHandlerCollection && WebAppContext.class.isAssignableFrom(((ContextHandlerCollection)this._contexts).getContextClass())) {
                     try {
                        wah = (WebAppContext)((ContextHandlerCollection)this._contexts).getContextClass().newInstance();
                     } catch (Exception var10) {
                        throw new Error(var10);
                     }
                  } else {
                     wah = new WebAppContext();
                  }

                  wah.setContextPath(context);
                  if (this._configurationClasses != null) {
                     wah.setConfigurationClasses(this._configurationClasses);
                  }

                  if (this._defaultsDescriptor != null) {
                     wah.setDefaultsDescriptor(this._defaultsDescriptor);
                  }

                  wah.setExtractWAR(this._extract);
                  wah.setWar(app.toString());
                  wah.setParentLoaderPriority(this._parentLoaderPriority);
                  this._contexts.addHandler(wah);
                  this._deployed.add(wah);
                  if (this._contexts.isStarted()) {
                     wah.start();
                  }
               }
            }

         }
      }
   }

   public void doStop() throws Exception {
      int i = this._deployed.size();

      while(i-- > 0) {
         ContextHandler wac = (ContextHandler)this._deployed.get(i);
         wac.stop();
      }

   }
}
