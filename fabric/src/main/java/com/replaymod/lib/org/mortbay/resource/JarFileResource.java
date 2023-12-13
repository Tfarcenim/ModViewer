package com.replaymod.lib.org.mortbay.resource;

import com.replaymod.lib.org.mortbay.log.Log;
import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

class JarFileResource extends JarResource {
   transient JarFile _jarFile;
   transient File _file;
   transient String[] _list;
   transient JarEntry _entry;
   transient boolean _directory;
   transient String _jarUrl;
   transient String _path;
   transient boolean _exists;

   JarFileResource(URL url) {
      super(url);
   }

   JarFileResource(URL url, boolean useCaches) {
      super(url, useCaches);
   }

   public synchronized void release() {
      this._list = null;
      this._entry = null;
      this._file = null;
      this._jarFile = null;
      super.release();
   }

   protected boolean checkConnection() {
      try {
         super.checkConnection();
      } finally {
         if (this._jarConnection == null) {
            this._entry = null;
            this._file = null;
            this._jarFile = null;
            this._list = null;
         }

      }

      return this._jarFile != null;
   }

   protected void newConnection() throws IOException {
      super.newConnection();
      this._entry = null;
      this._file = null;
      this._jarFile = null;
      this._list = null;
      int sep = this._urlString.indexOf("!/");
      this._jarUrl = this._urlString.substring(0, sep + 2);
      this._path = this._urlString.substring(sep + 2);
      if (this._path.length() == 0) {
         this._path = null;
      }

      this._jarFile = this._jarConnection.getJarFile();
      this._file = new File(this._jarFile.getName());
   }

   public boolean exists() {
      if (this._exists) {
         return true;
      } else if (this._urlString.endsWith("!/")) {
         String file_url = this._urlString.substring(4, this._urlString.length() - 2);

         try {
            return newResource(file_url).exists();
         } catch (Exception var6) {
            Log.ignore(var6);
            return false;
         }
      } else {
         boolean check = this.checkConnection();
         if (this._jarUrl != null && this._path == null) {
            this._directory = check;
            return true;
         } else {
            JarFile jarFile = null;
            if (check) {
               jarFile = this._jarFile;
            } else {
               try {
                  JarURLConnection c = (JarURLConnection)((JarURLConnection)(new URL(this._jarUrl)).openConnection());
                  c.setUseCaches(this.getUseCaches());
                  jarFile = c.getJarFile();
               } catch (Exception var7) {
                  Log.ignore(var7);
               }
            }

            if (jarFile != null && this._entry == null && !this._directory) {
               Enumeration e = jarFile.entries();

               while(e.hasMoreElements()) {
                  JarEntry entry = (JarEntry)e.nextElement();
                  String name = entry.getName().replace('\\', '/');
                  if (name.equals(this._path)) {
                     this._entry = entry;
                     this._directory = this._path.endsWith("/");
                     break;
                  }

                  if (this._path.endsWith("/")) {
                     if (name.startsWith(this._path)) {
                        this._directory = true;
                        break;
                     }
                  } else if (name.startsWith(this._path) && name.length() > this._path.length() && name.charAt(this._path.length()) == '/') {
                     this._directory = true;
                     break;
                  }
               }
            }

            this._exists = this._directory || this._entry != null;
            return this._exists;
         }
      }
   }

   public boolean isDirectory() {
      return this._urlString.endsWith("/") || this.exists() && this._directory;
   }

   public long lastModified() {
      return this.checkConnection() && this._file != null ? this._file.lastModified() : -1L;
   }

   public synchronized String[] list() {
      if (this.isDirectory() && this._list == null) {
         ArrayList list = new ArrayList(32);
         this.checkConnection();
         JarFile jarFile = this._jarFile;
         if (jarFile == null) {
            try {
               JarURLConnection jc = (JarURLConnection)((JarURLConnection)(new URL(this._jarUrl)).openConnection());
               jc.setUseCaches(this.getUseCaches());
               jarFile = jc.getJarFile();
            } catch (Exception var9) {
               Log.ignore(var9);
            }
         }

         Enumeration e = jarFile.entries();
         String dir = this._urlString.substring(this._urlString.indexOf("!/") + 2);

         while(true) {
            String listName;
            while(true) {
               String name;
               do {
                  do {
                     if (!e.hasMoreElements()) {
                        this._list = new String[list.size()];
                        list.toArray(this._list);
                        return this._list;
                     }

                     JarEntry entry = (JarEntry)e.nextElement();
                     name = entry.getName().replace('\\', '/');
                  } while(!name.startsWith(dir));
               } while(name.length() == dir.length());

               listName = name.substring(dir.length());
               int dash = listName.indexOf(47);
               if (dash < 0) {
                  break;
               }

               if (dash != 0 || listName.length() != 1) {
                  if (dash == 0) {
                     listName = listName.substring(dash + 1, listName.length());
                  } else {
                     listName = listName.substring(0, dash + 1);
                  }

                  if (!list.contains(listName)) {
                     break;
                  }
               }
            }

            list.add(listName);
         }
      } else {
         return this._list;
      }
   }

   public long length() {
      if (this.isDirectory()) {
         return -1L;
      } else {
         return this._entry != null ? this._entry.getSize() : -1L;
      }
   }

   public String encode(String uri) {
      return uri;
   }

   public static Resource getNonCachingResource(Resource resource) {
      if (!(resource instanceof JarFileResource)) {
         return resource;
      } else {
         JarFileResource oldResource = (JarFileResource)resource;
         JarFileResource newResource = new JarFileResource(oldResource.getURL(), false);
         return newResource;
      }
   }
}
