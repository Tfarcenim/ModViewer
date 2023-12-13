package com.replaymod.lib.org.mortbay.resource;

import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.util.IO;
import com.replaymod.lib.org.mortbay.util.Loader;
import com.replaymod.lib.org.mortbay.util.StringUtil;
import com.replaymod.lib.org.mortbay.util.URIUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;

public abstract class Resource implements Serializable {
   public static boolean __defaultUseCaches = true;
   Object _associate;

   public static void setDefaultUseCaches(boolean useCaches) {
      __defaultUseCaches = useCaches;
   }

   public static boolean getDefaultUseCaches() {
      return __defaultUseCaches;
   }

   public static Resource newResource(URL url) throws IOException {
      return newResource(url, __defaultUseCaches);
   }

   public static Resource newResource(URL url, boolean useCaches) {
      if (url == null) {
         return null;
      } else {
         String url_string = url.toExternalForm();
         if (url_string.startsWith("file:")) {
            try {
               FileResource fileResource = new FileResource(url);
               return fileResource;
            } catch (Exception var4) {
               Log.debug("EXCEPTION ", var4);
               return new BadResource(url, var4.toString());
            }
         } else if (url_string.startsWith("jar:file:")) {
            return new JarFileResource(url, useCaches);
         } else {
            return (Resource)(url_string.startsWith("jar:") ? new JarResource(url, useCaches) : new URLResource(url, (URLConnection)null, useCaches));
         }
      }
   }

   public static Resource newResource(String resource) throws MalformedURLException, IOException {
      return newResource(resource, __defaultUseCaches);
   }

   public static Resource newResource(String resource, boolean useCaches) throws MalformedURLException, IOException {
      URL url = null;

      try {
         url = new URL(resource);
      } catch (MalformedURLException var8) {
         if (!resource.startsWith("ftp:") && !resource.startsWith("file:") && !resource.startsWith("jar:")) {
            try {
               if (resource.startsWith("./")) {
                  resource = resource.substring(2);
               }

               File file = (new File(resource)).getCanonicalFile();
               url = new URL(URIUtil.encodePath(file.toURL().toString()));
               URLConnection connection = url.openConnection();
               connection.setUseCaches(useCaches);
               FileResource fileResource = new FileResource(url, connection, file);
               return fileResource;
            } catch (Exception var7) {
               Log.debug("EXCEPTION ", var7);
               throw var8;
            }
         }

         Log.warn("Bad Resource: " + resource);
         throw var8;
      }

      String nurl = url.toString();
      return (Resource)(nurl.length() <= 0 || nurl.charAt(nurl.length() - 1) == resource.charAt(resource.length() - 1) || nurl.charAt(nurl.length() - 1) == '/' && nurl.charAt(nurl.length() - 2) == resource.charAt(resource.length() - 1) || resource.charAt(resource.length() - 1) == '/' && resource.charAt(resource.length() - 2) == nurl.charAt(nurl.length() - 1) ? newResource(url) : new BadResource(url, "Trailing special characters stripped by URL in " + resource));
   }

   public static Resource newSystemResource(String resource) throws IOException {
      URL url = null;
      ClassLoader loader = Thread.currentThread().getContextClassLoader();
      if (loader != null) {
         url = loader.getResource(resource);
         if (url == null && resource.startsWith("/")) {
            url = loader.getResource(resource.substring(1));
         }
      }

      if (url == null) {
         loader = Resource.class.getClassLoader();
         if (loader != null) {
            url = loader.getResource(resource);
            if (url == null && resource.startsWith("/")) {
               url = loader.getResource(resource.substring(1));
            }
         }
      }

      if (url == null) {
         url = ClassLoader.getSystemResource(resource);
         if (url == null && resource.startsWith("/")) {
            url = loader.getResource(resource.substring(1));
         }
      }

      return url == null ? null : newResource(url);
   }

   public static Resource newClassPathResource(String resource) {
      return newClassPathResource(resource, true, false);
   }

   public static Resource newClassPathResource(String name, boolean useCaches, boolean checkParents) {
      URL url = Resource.class.getResource(name);
      if (url == null) {
         try {
            url = Loader.getResource(Resource.class, name, checkParents);
         } catch (ClassNotFoundException var5) {
            url = ClassLoader.getSystemResource(name);
         }
      }

      return url == null ? null : newResource(url, useCaches);
   }

   protected void finalize() {
      this.release();
   }

   public abstract void release();

   public abstract boolean exists();

   public abstract boolean isDirectory();

   public abstract long lastModified();

   public abstract long length();

   public abstract URL getURL();

   public abstract File getFile() throws IOException;

   public abstract String getName();

   public abstract InputStream getInputStream() throws IOException;

   public abstract OutputStream getOutputStream() throws IOException, SecurityException;

   public abstract boolean delete() throws SecurityException;

   public abstract boolean renameTo(Resource var1) throws SecurityException;

   public abstract String[] list();

   public abstract Resource addPath(String var1) throws IOException, MalformedURLException;

   public String encode(String uri) {
      return URIUtil.encodePath(uri);
   }

   public Object getAssociate() {
      return this._associate;
   }

   public void setAssociate(Object o) {
      this._associate = o;
   }

   public URL getAlias() {
      return null;
   }

   public String getListHTML(String base, boolean parent) throws IOException {
      base = URIUtil.canonicalPath(base);
      if (base != null && this.isDirectory()) {
         String[] ls = this.list();
         if (ls == null) {
            return null;
         } else {
            Arrays.sort(ls);
            String decodedBase = URIUtil.decodePath(base);
            String title = "Directory: " + deTag(decodedBase);
            StringBuffer buf = new StringBuffer(4096);
            buf.append("<HTML><HEAD><TITLE>");
            buf.append(title);
            buf.append("</TITLE></HEAD><BODY>\n<H1>");
            buf.append(title);
            buf.append("</H1>\n<TABLE BORDER=0>\n");
            if (parent) {
               buf.append("<TR><TD><A HREF=\"");
               buf.append(URIUtil.addPaths(base, "../"));
               buf.append("\">Parent Directory</A></TD><TD></TD><TD></TD></TR>\n");
            }

            String defangedBase = defangURI(base);
            DateFormat dfmt = DateFormat.getDateTimeInstance(2, 2);

            for(int i = 0; i < ls.length; ++i) {
               Resource item = this.addPath(ls[i]);
               buf.append("\n<TR><TD><A HREF=\"");
               String path = URIUtil.addPaths(defangedBase, URIUtil.encodePath(ls[i]));
               buf.append(path);
               if (item.isDirectory() && !path.endsWith("/")) {
                  buf.append("/");
               }

               buf.append("\">");
               buf.append(deTag(ls[i]));
               buf.append("&nbsp;");
               buf.append("</TD><TD ALIGN=right>");
               buf.append(item.length());
               buf.append(" bytes&nbsp;</TD><TD>");
               buf.append(dfmt.format(new Date(item.lastModified())));
               buf.append("</TD></TR>");
            }

            buf.append("</TABLE>\n");
            buf.append("</BODY></HTML>\n");
            return buf.toString();
         }
      } else {
         return null;
      }
   }

   private static String defangURI(String raw) {
      StringBuffer buf = null;
      int i;
      char c;
      if (buf == null) {
         i = 0;

         while(i < raw.length()) {
            c = raw.charAt(i);
            switch(c) {
            case '"':
            case '\'':
            case '<':
            case '>':
               buf = new StringBuffer(raw.length() << 1);
            default:
               ++i;
            }
         }

         if (buf == null) {
            return raw;
         }
      }

      for(i = 0; i < raw.length(); ++i) {
         c = raw.charAt(i);
         switch(c) {
         case '"':
            buf.append("%22");
            break;
         case '\'':
            buf.append("%27");
            break;
         case '<':
            buf.append("%3C");
            break;
         case '>':
            buf.append("%3E");
            break;
         default:
            buf.append(c);
         }
      }

      return buf.toString();
   }

   private static String deTag(String raw) {
      return StringUtil.replace(StringUtil.replace(raw, "<", "&lt;"), ">", "&gt;");
   }

   public void writeTo(OutputStream out, long start, long count) throws IOException {
      InputStream in = this.getInputStream();

      try {
         in.skip(start);
         if (count < 0L) {
            IO.copy(in, out);
         } else {
            IO.copy(in, out, count);
         }
      } finally {
         in.close();
      }

   }
}
