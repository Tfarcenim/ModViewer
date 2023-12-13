package com.replaymod.lib.org.mortbay.resource;

import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.util.IO;
import com.replaymod.lib.org.mortbay.util.URIUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;

public class JarResource extends URLResource {
   protected transient JarURLConnection _jarConnection;

   JarResource(URL url) {
      super(url, (URLConnection)null);
   }

   JarResource(URL url, boolean useCaches) {
      super(url, (URLConnection)null, useCaches);
   }

   public synchronized void release() {
      this._jarConnection = null;
      super.release();
   }

   protected boolean checkConnection() {
      super.checkConnection();

      try {
         if (this._jarConnection != this._connection) {
            this.newConnection();
         }
      } catch (IOException var2) {
         Log.ignore(var2);
         this._jarConnection = null;
      }

      return this._jarConnection != null;
   }

   protected void newConnection() throws IOException {
      this._jarConnection = (JarURLConnection)this._connection;
   }

   public boolean exists() {
      return this._urlString.endsWith("!/") ? this.checkConnection() : super.exists();
   }

   public File getFile() throws IOException {
      return null;
   }

   public InputStream getInputStream() throws IOException {
      this.checkConnection();
      if (!this._urlString.endsWith("!/")) {
         return new FilterInputStream(super.getInputStream()) {
            public void close() throws IOException {
               this.in = IO.getClosedStream();
            }
         };
      } else {
         URL url = new URL(this._urlString.substring(4, this._urlString.length() - 2));
         InputStream is = url.openStream();
         return is;
      }
   }

   public static void extract(Resource resource, File directory, boolean deleteOnExit) throws IOException {
      if (Log.isDebugEnabled()) {
         Log.debug("Extract " + resource + " to " + directory);
      }

      String urlString = resource.getURL().toExternalForm().trim();
      int endOfJarUrl = urlString.indexOf("!/");
      int startOfJarUrl = endOfJarUrl >= 0 ? 4 : 0;
      if (endOfJarUrl < 0) {
         throw new IOException("Not a valid jar url: " + urlString);
      } else {
         URL jarFileURL = new URL(urlString.substring(startOfJarUrl, endOfJarUrl));
         String subEntryName = endOfJarUrl + 2 < urlString.length() ? urlString.substring(endOfJarUrl + 2) : null;
         boolean subEntryIsDir = subEntryName != null && subEntryName.endsWith("/");
         if (Log.isDebugEnabled()) {
            Log.debug("Extracting entry = " + subEntryName + " from jar " + jarFileURL);
         }

         InputStream is = jarFileURL.openConnection().getInputStream();
         JarInputStream jin = new JarInputStream(is);
         String var13 = directory.getCanonicalPath() + "/";

         JarEntry entry;
         File file;
         while((entry = jin.getNextJarEntry()) != null) {
            String entryName = entry.getName();
            boolean shouldExtract;
            if (subEntryName != null && entryName.startsWith(subEntryName)) {
               if (subEntryIsDir) {
                  entryName = entryName.substring(subEntryName.length());
                  if (!entryName.equals("")) {
                     shouldExtract = true;
                  } else {
                     shouldExtract = false;
                  }
               } else {
                  shouldExtract = true;
               }
            } else if (subEntryName != null && !entryName.startsWith(subEntryName)) {
               shouldExtract = false;
            } else {
               shouldExtract = true;
            }

            if (!shouldExtract) {
               if (Log.isDebugEnabled()) {
                  Log.debug("Skipping entry: " + entryName);
               }
            } else {
               String dotCheck = entryName.replace('\\', '/');
               dotCheck = URIUtil.canonicalPath(dotCheck);
               if (dotCheck == null) {
                  if (Log.isDebugEnabled()) {
                     Log.debug("Invalid entry: " + entryName);
                  }
               } else {
                  file = new File(directory, entryName);
                  if (entry.isDirectory()) {
                     if (!file.exists()) {
                        file.mkdirs();
                     }
                  } else {
                     File dir = new File(file.getParent());
                     if (!dir.exists()) {
                        dir.mkdirs();
                     }

                     FileOutputStream fout = null;

                     try {
                        fout = new FileOutputStream(file);
                        IO.copy((InputStream)jin, (OutputStream)fout);
                     } finally {
                        IO.close((OutputStream)fout);
                     }

                     if (entry.getTime() >= 0L) {
                        file.setLastModified(entry.getTime());
                     }
                  }

                  if (deleteOnExit) {
                     file.deleteOnExit();
                  }
               }
            }
         }

         if (subEntryName == null || subEntryName != null && subEntryName.equalsIgnoreCase("META-INF/MANIFEST.MF")) {
            Manifest manifest = jin.getManifest();
            if (manifest != null) {
               File metaInf = new File(directory, "META-INF");
               metaInf.mkdir();
               file = new File(metaInf, "MANIFEST.MF");
               FileOutputStream fout = new FileOutputStream(file);
               manifest.write(fout);
               fout.close();
            }
         }

         IO.close((InputStream)jin);
      }
   }

   public void extract(File directory, boolean deleteOnExit) throws IOException {
      extract(this, directory, deleteOnExit);
   }
}
