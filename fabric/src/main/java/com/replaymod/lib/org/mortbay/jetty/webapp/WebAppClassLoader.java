package com.replaymod.lib.org.mortbay.jetty.webapp;

import com.replaymod.lib.org.mortbay.jetty.handler.ContextHandler;
import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.resource.Resource;
import com.replaymod.lib.org.mortbay.util.IO;
import com.replaymod.lib.org.mortbay.util.LazyList;
import com.replaymod.lib.org.mortbay.util.StringUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.CodeSource;
import java.security.PermissionCollection;
import java.util.HashSet;
import java.util.StringTokenizer;

public class WebAppClassLoader extends URLClassLoader {
   private String _name;
   private WebAppContext _context;
   private ClassLoader _parent;
   private HashSet _extensions;

   public WebAppClassLoader(WebAppContext context) throws IOException {
      this((ClassLoader)null, context);
   }

   public WebAppClassLoader(ClassLoader parent, WebAppContext context) throws IOException {
      super(new URL[0], parent != null ? parent : (Thread.currentThread().getContextClassLoader() != null ? Thread.currentThread().getContextClassLoader() : (WebAppClassLoader.class.getClassLoader() != null ? WebAppClassLoader.class.getClassLoader() : ClassLoader.getSystemClassLoader())));
      this._parent = this.getParent();
      this._context = context;
      if (this._parent == null) {
         throw new IllegalArgumentException("no parent classloader!");
      } else {
         this._extensions = new HashSet();
         this._extensions.add(".jar");
         this._extensions.add(".zip");
         String extensions = System.getProperty(WebAppClassLoader.class.getName() + ".extensions");
         if (extensions != null) {
            StringTokenizer tokenizer = new StringTokenizer(extensions, ",;");

            while(tokenizer.hasMoreTokens()) {
               this._extensions.add(tokenizer.nextToken().trim());
            }
         }

         if (context.getExtraClasspath() != null) {
            this.addClassPath(context.getExtraClasspath());
         }

      }
   }

   public String getName() {
      return this._name;
   }

   public void setName(String name) {
      this._name = name;
   }

   public ContextHandler getContext() {
      return this._context;
   }

   public void addClassPath(String classPath) throws IOException {
      if (classPath != null) {
         StringTokenizer tokenizer = new StringTokenizer(classPath, ",;");

         while(true) {
            while(tokenizer.hasMoreTokens()) {
               Resource resource = Resource.newResource(tokenizer.nextToken());
               if (Log.isDebugEnabled()) {
                  Log.debug("Path resource=" + resource);
               }

               File file = resource.getFile();
               URL url;
               if (file != null) {
                  url = resource.getURL();
                  this.addURL(url);
               } else if (!resource.isDirectory() && file == null) {
                  InputStream in = resource.getInputStream();
                  File tmp_dir = this._context.getTempDirectory();
                  if (tmp_dir == null) {
                     tmp_dir = File.createTempFile("jetty.cl.lib", (String)null);
                     tmp_dir.mkdir();
                     tmp_dir.deleteOnExit();
                  }

                  File lib = new File(tmp_dir, "lib");
                  if (!lib.exists()) {
                     lib.mkdir();
                     lib.deleteOnExit();
                  }

                  File jar = File.createTempFile("Jetty-", ".jar", lib);
                  jar.deleteOnExit();
                  if (Log.isDebugEnabled()) {
                     Log.debug("Extract " + resource + " to " + jar);
                  }

                  FileOutputStream out = null;

                  try {
                     out = new FileOutputStream(jar);
                     IO.copy((InputStream)in, (OutputStream)out);
                  } finally {
                     IO.close((OutputStream)out);
                  }

                  URL url = jar.toURL();
                  this.addURL(url);
               } else {
                  url = resource.getURL();
                  this.addURL(url);
               }
            }

            return;
         }
      }
   }

   private boolean isFileSupported(String file) {
      int dot = file.lastIndexOf(46);
      return dot != -1 && this._extensions.contains(file.substring(dot));
   }

   public void addJars(Resource lib) {
      if (lib.exists() && lib.isDirectory()) {
         String[] files = lib.list();

         for(int f = 0; files != null && f < files.length; ++f) {
            try {
               Resource fn = lib.addPath(files[f]);
               String fnlc = fn.getName().toLowerCase();
               if (this.isFileSupported(fnlc)) {
                  String jar = fn.toString();
                  jar = StringUtil.replace(jar, ",", "%2C");
                  jar = StringUtil.replace(jar, ";", "%3B");
                  this.addClassPath(jar);
               }
            } catch (Exception var7) {
               Log.warn("EXCEPTION ", (Throwable)var7);
            }
         }
      }

   }

   public void destroy() {
      this._parent = null;
   }

   public PermissionCollection getPermissions(CodeSource cs) {
      PermissionCollection permissions = this._context.getPermissions();
      PermissionCollection pc = permissions == null ? super.getPermissions(cs) : permissions;
      return pc;
   }

   public URL getResource(String name) {
      URL url = null;
      boolean tried_parent = false;
      if (this._context.isParentLoaderPriority() || this.isSystemPath(name)) {
         tried_parent = true;
         if (this._parent != null) {
            url = this._parent.getResource(name);
         }
      }

      if (url == null) {
         url = this.findResource(name);
         if (url == null && name.startsWith("/")) {
            if (Log.isDebugEnabled()) {
               Log.debug("HACK leading / off " + name);
            }

            url = this.findResource(name.substring(1));
         }
      }

      if (url == null && !tried_parent && this._parent != null) {
         url = this._parent.getResource(name);
      }

      if (url != null && Log.isDebugEnabled()) {
         Log.debug("getResource(" + name + ")=" + url);
      }

      return url;
   }

   public boolean isServerPath(String name) {
      for(name = name.replace('/', '.'); name.startsWith("."); name = name.substring(1)) {
      }

      String[] server_classes = this._context.getServerClasses();
      if (server_classes != null) {
         for(int i = 0; i < server_classes.length; ++i) {
            boolean result = true;
            String c = server_classes[i];
            if (c.startsWith("-")) {
               c = c.substring(1);
               result = false;
            }

            if (c.endsWith(".")) {
               if (name.startsWith(c)) {
                  return result;
               }
            } else if (name.equals(c)) {
               return result;
            }
         }
      }

      return false;
   }

   public boolean isSystemPath(String name) {
      for(name = name.replace('/', '.'); name.startsWith("."); name = name.substring(1)) {
      }

      String[] system_classes = this._context.getSystemClasses();
      if (system_classes != null) {
         for(int i = 0; i < system_classes.length; ++i) {
            boolean result = true;
            String c = system_classes[i];
            if (c.startsWith("-")) {
               c = c.substring(1);
               result = false;
            }

            if (c.endsWith(".")) {
               if (name.startsWith(c)) {
                  return result;
               }
            } else if (name.equals(c)) {
               return result;
            }
         }
      }

      return false;
   }

   public Class loadClass(String name) throws ClassNotFoundException {
      return this.loadClass(name, false);
   }

   protected synchronized Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
      Class c = this.findLoadedClass(name);
      ClassNotFoundException ex = null;
      boolean tried_parent = false;
      if (c == null && this._parent != null && (this._context.isParentLoaderPriority() || this.isSystemPath(name))) {
         tried_parent = true;

         try {
            c = this._parent.loadClass(name);
            if (Log.isDebugEnabled()) {
               Log.debug("loaded " + c);
            }
         } catch (ClassNotFoundException var8) {
            ex = var8;
         }
      }

      if (c == null) {
         try {
            c = this.findClass(name);
         } catch (ClassNotFoundException var7) {
            ex = var7;
         }
      }

      if (c == null && this._parent != null && !tried_parent && !this.isServerPath(name)) {
         c = this._parent.loadClass(name);
      }

      if (c == null) {
         throw ex;
      } else {
         if (resolve) {
            this.resolveClass(c);
         }

         if (Log.isDebugEnabled()) {
            Log.debug("loaded " + c + " from " + c.getClassLoader());
         }

         return c;
      }
   }

   public String toString() {
      return Log.isDebugEnabled() ? "ContextLoader@" + this._name + "(" + LazyList.array2List(this.getURLs()) + ") / " + this._parent : "ContextLoader@" + this._name;
   }
}
