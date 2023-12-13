package com.replaymod.lib.org.mortbay.resource;

import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.util.URIUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.security.Permission;

public class FileResource extends URLResource {
   private static boolean __checkAliases = "true".equalsIgnoreCase(System.getProperty("com.replaymod.lib.org.mortbay.util.FileResource.checkAliases", "true"));
   private File _file;
   private transient URL _alias = null;
   private transient boolean _aliasChecked = false;

   public static void setCheckAliases(boolean checkAliases) {
      __checkAliases = checkAliases;
   }

   public static boolean getCheckAliases() {
      return __checkAliases;
   }

   public FileResource(URL url) throws IOException, URISyntaxException {
      super(url, (URLConnection)null);

      try {
         this._file = new File(new URI(url.toString()));
      } catch (Exception var6) {
         Log.ignore(var6);

         try {
            String file_url = "file:" + URIUtil.encodePath(url.toString().substring(5));
            URI uri = new URI(file_url);
            if (uri.getAuthority() == null) {
               this._file = new File(uri);
            } else {
               this._file = new File("//" + uri.getAuthority() + URIUtil.decodePath(url.getFile()));
            }
         } catch (Exception var5) {
            Log.ignore(var5);
            this.checkConnection();
            Permission perm = this._connection.getPermission();
            this._file = new File(perm == null ? url.getFile() : perm.getName());
         }
      }

      if (this._file.isDirectory()) {
         if (!this._urlString.endsWith("/")) {
            this._urlString = this._urlString + "/";
         }
      } else if (this._urlString.endsWith("/")) {
         this._urlString = this._urlString.substring(0, this._urlString.length() - 1);
      }

   }

   FileResource(URL url, URLConnection connection, File file) {
      super(url, connection);
      this._file = file;
      if (this._file.isDirectory() && !this._urlString.endsWith("/")) {
         this._urlString = this._urlString + "/";
      }

   }

   public Resource addPath(String path) throws IOException, MalformedURLException {
      URLResource r = null;
      String url = null;
      path = URIUtil.canonicalPath(path);
      String rel;
      if (!this.isDirectory()) {
         r = (FileResource)super.addPath(path);
         url = ((URLResource)r)._urlString;
      } else {
         if (path == null) {
            throw new MalformedURLException();
         }

         rel = path;
         if (path.startsWith("/")) {
            rel = path.substring(1);
         }

         url = URIUtil.addPaths(this._urlString, URIUtil.encodePath(rel));
         r = (URLResource)Resource.newResource(url);
      }

      rel = URIUtil.encodePath(path);
      int expected = ((URLResource)r).toString().length() - rel.length();
      int index = ((URLResource)r)._urlString.lastIndexOf(rel, expected);
      if (expected != index && (expected - 1 != index || path.endsWith("/") || !((URLResource)r).isDirectory()) && !(r instanceof BadResource)) {
         ((FileResource)r)._alias = new URL(url);
         ((FileResource)r)._aliasChecked = true;
      }

      return (Resource)r;
   }

   public URL getAlias() {
      if (__checkAliases && !this._aliasChecked) {
         try {
            String abs = this._file.getAbsolutePath();
            String can = this._file.getCanonicalPath();
            if (abs.length() != can.length() || !abs.equals(can)) {
               this._alias = (new File(can)).toURI().toURL();
            }

            this._aliasChecked = true;
            if (this._alias != null && Log.isDebugEnabled()) {
               Log.debug("ALIAS abs=" + abs);
               Log.debug("ALIAS can=" + can);
            }
         } catch (Exception var3) {
            Log.warn("EXCEPTION ", (Throwable)var3);
            return this.getURL();
         }
      }

      return this._alias;
   }

   public boolean exists() {
      return this._file.exists();
   }

   public long lastModified() {
      return this._file.lastModified();
   }

   public boolean isDirectory() {
      return this._file.isDirectory();
   }

   public long length() {
      return this._file.length();
   }

   public String getName() {
      return this._file.getAbsolutePath();
   }

   public File getFile() {
      return this._file;
   }

   public InputStream getInputStream() throws IOException {
      return new FileInputStream(this._file);
   }

   public OutputStream getOutputStream() throws IOException, SecurityException {
      return new FileOutputStream(this._file);
   }

   public boolean delete() throws SecurityException {
      return this._file.delete();
   }

   public boolean renameTo(Resource dest) throws SecurityException {
      return dest instanceof FileResource ? this._file.renameTo(((FileResource)dest)._file) : false;
   }

   public String[] list() {
      String[] list = this._file.list();
      if (list == null) {
         return null;
      } else {
         int i = list.length;

         while(i-- > 0) {
            if ((new File(this._file, list[i])).isDirectory() && !list[i].endsWith("/")) {
               list[i] = list[i] + "/";
            }
         }

         return list;
      }
   }

   public String encode(String uri) {
      return uri;
   }

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (null != o && o instanceof FileResource) {
         FileResource f = (FileResource)o;
         return f._file == this._file || null != this._file && this._file.equals(f._file);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return null == this._file ? super.hashCode() : this._file.hashCode();
   }

   static {
      if (__checkAliases) {
         Log.debug("Checking Resource aliases");
      } else {
         Log.warn("Resource alias checking is disabled");
      }

   }
}
