package com.replaymod.lib.org.mortbay.resource;

import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.util.URIUtil;
import java.io.File;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.Permission;

public class URLResource extends Resource {
   protected URL _url;
   protected String _urlString;
   protected transient URLConnection _connection;
   protected transient InputStream _in;
   transient boolean _useCaches;

   protected URLResource(URL url, URLConnection connection) {
      this._in = null;
      this._useCaches = Resource.__defaultUseCaches;
      this._url = url;
      this._urlString = this._url.toString();
      this._connection = connection;
   }

   protected URLResource(URL url, URLConnection connection, boolean useCaches) {
      this(url, connection);
      this._useCaches = useCaches;
   }

   protected synchronized boolean checkConnection() {
      if (this._connection == null) {
         try {
            this._connection = this._url.openConnection();
            this._connection.setUseCaches(this._useCaches);
         } catch (IOException var2) {
            Log.ignore(var2);
         }
      }

      return this._connection != null;
   }

   public synchronized void release() {
      if (this._in != null) {
         try {
            this._in.close();
         } catch (IOException var2) {
            Log.ignore(var2);
         }

         this._in = null;
      }

      if (this._connection != null) {
         this._connection = null;
      }

   }

   public boolean exists() {
      try {
         synchronized(this) {
            if (this.checkConnection() && this._in == null) {
               this._in = this._connection.getInputStream();
            }
         }
      } catch (IOException var4) {
         Log.ignore(var4);
      }

      return this._in != null;
   }

   public boolean isDirectory() {
      return this.exists() && this._url.toString().endsWith("/");
   }

   public long lastModified() {
      return this.checkConnection() ? this._connection.getLastModified() : -1L;
   }

   public long length() {
      return this.checkConnection() ? (long)this._connection.getContentLength() : -1L;
   }

   public URL getURL() {
      return this._url;
   }

   public File getFile() throws IOException {
      if (this.checkConnection()) {
         Permission perm = this._connection.getPermission();
         if (perm instanceof FilePermission) {
            return new File(perm.getName());
         }
      }

      try {
         return new File(this._url.getFile());
      } catch (Exception var2) {
         Log.ignore(var2);
         return null;
      }
   }

   public String getName() {
      return this._url.toExternalForm();
   }

   public synchronized InputStream getInputStream() throws IOException {
      if (!this.checkConnection()) {
         throw new IOException("Invalid resource");
      } else {
         InputStream var2;
         try {
            InputStream in;
            if (this._in == null) {
               in = this._connection.getInputStream();
               return in;
            }

            in = this._in;
            this._in = null;
            var2 = in;
         } finally {
            this._connection = null;
         }

         return var2;
      }
   }

   public OutputStream getOutputStream() throws IOException, SecurityException {
      throw new IOException("Output not supported");
   }

   public boolean delete() throws SecurityException {
      throw new SecurityException("Delete not supported");
   }

   public boolean renameTo(Resource dest) throws SecurityException {
      throw new SecurityException("RenameTo not supported");
   }

   public String[] list() {
      return null;
   }

   public Resource addPath(String path) throws IOException, MalformedURLException {
      if (path == null) {
         return null;
      } else {
         path = URIUtil.canonicalPath(path);
         return newResource(URIUtil.addPaths(this._url.toExternalForm(), path));
      }
   }

   public String toString() {
      return this._urlString;
   }

   public int hashCode() {
      return this._url.hashCode();
   }

   public boolean equals(Object o) {
      return o instanceof URLResource && this._url.equals(((URLResource)o)._url);
   }

   public boolean getUseCaches() {
      return this._useCaches;
   }
}
