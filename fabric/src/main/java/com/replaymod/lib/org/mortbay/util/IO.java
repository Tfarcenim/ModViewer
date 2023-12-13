package com.replaymod.lib.org.mortbay.util;

import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.thread.BoundedThreadPool;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class IO extends BoundedThreadPool {
   public static final String CRLF = "\r\n";
   public static final byte[] CRLF_BYTES = new byte[]{13, 10};
   public static int bufferSize = 16384;
   private static IO.NullOS __nullStream = new IO.NullOS();
   private static IO.ClosedIS __closedStream = new IO.ClosedIS();
   private static IO.NullWrite __nullWriter = new IO.NullWrite();

   public static IO instance() {
      return IO.Singleton.__instance;
   }

   public static void copyThread(InputStream in, OutputStream out) {
      try {
         IO.Job job = new IO.Job(in, out);
         if (!instance().dispatch(job)) {
            job.run();
         }
      } catch (Exception var3) {
         Log.warn((Throwable)var3);
      }

   }

   public static void copy(InputStream in, OutputStream out) throws IOException {
      copy(in, out, -1L);
   }

   public static void copyThread(Reader in, Writer out) {
      try {
         IO.Job job = new IO.Job(in, out);
         if (!instance().dispatch(job)) {
            job.run();
         }
      } catch (Exception var3) {
         Log.warn((Throwable)var3);
      }

   }

   public static void copy(Reader in, Writer out) throws IOException {
      copy(in, out, -1L);
   }

   public static void copy(InputStream in, OutputStream out, long byteCount) throws IOException {
      byte[] buffer = new byte[bufferSize];
      int len = bufferSize;
      if (byteCount >= 0L) {
         while(byteCount > 0L) {
            if (byteCount < (long)bufferSize) {
               len = in.read(buffer, 0, (int)byteCount);
            } else {
               len = in.read(buffer, 0, bufferSize);
            }

            if (len == -1) {
               break;
            }

            byteCount -= (long)len;
            out.write(buffer, 0, len);
         }
      } else {
         while(true) {
            len = in.read(buffer, 0, bufferSize);
            if (len < 0) {
               break;
            }

            out.write(buffer, 0, len);
         }
      }

   }

   public static void copy(Reader in, Writer out, long byteCount) throws IOException {
      char[] buffer = new char[bufferSize];
      int len = bufferSize;
      if (byteCount >= 0L) {
         while(byteCount > 0L) {
            if (byteCount < (long)bufferSize) {
               len = in.read(buffer, 0, (int)byteCount);
            } else {
               len = in.read(buffer, 0, bufferSize);
            }

            if (len == -1) {
               break;
            }

            byteCount -= (long)len;
            out.write(buffer, 0, len);
         }
      } else if (out instanceof PrintWriter) {
         PrintWriter pout = (PrintWriter)out;

         while(!pout.checkError()) {
            len = in.read(buffer, 0, bufferSize);
            if (len == -1) {
               break;
            }

            out.write(buffer, 0, len);
         }
      } else {
         while(true) {
            len = in.read(buffer, 0, bufferSize);
            if (len == -1) {
               break;
            }

            out.write(buffer, 0, len);
         }
      }

   }

   public static void copy(File from, File to) throws IOException {
      if (from.isDirectory()) {
         copyDir(from, to);
      } else {
         copyFile(from, to);
      }

   }

   public static void copyDir(File from, File to) throws IOException {
      if (to.exists()) {
         if (!to.isDirectory()) {
            throw new IllegalArgumentException(to.toString());
         }
      } else {
         to.mkdirs();
      }

      File[] files = from.listFiles();
      if (files != null) {
         for(int i = 0; i < files.length; ++i) {
            String name = files[i].getName();
            if (!".".equals(name) && !"..".equals(name)) {
               copy(files[i], new File(to, name));
            }
         }
      }

   }

   public static void copyFile(File from, File to) throws IOException {
      FileInputStream in = new FileInputStream(from);
      FileOutputStream out = new FileOutputStream(to);
      copy((InputStream)in, (OutputStream)out);
      in.close();
      out.close();
   }

   public static String toString(InputStream in) throws IOException {
      return toString(in, (String)null);
   }

   public static String toString(InputStream in, String encoding) throws IOException {
      StringWriter writer = new StringWriter();
      InputStreamReader reader = encoding == null ? new InputStreamReader(in) : new InputStreamReader(in, encoding);
      copy((Reader)reader, (Writer)writer);
      return writer.toString();
   }

   public static String toString(Reader in) throws IOException {
      StringWriter writer = new StringWriter();
      copy((Reader)in, (Writer)writer);
      return writer.toString();
   }

   public static boolean delete(File file) {
      if (!file.exists()) {
         return false;
      } else {
         if (file.isDirectory()) {
            File[] files = file.listFiles();

            for(int i = 0; files != null && i < files.length; ++i) {
               delete(files[i]);
            }
         }

         return file.delete();
      }
   }

   public static void close(InputStream is) {
      try {
         if (is != null) {
            is.close();
         }
      } catch (IOException var2) {
         Log.ignore(var2);
      }

   }

   public static byte[] readBytes(InputStream in) throws IOException {
      ByteArrayOutputStream bout = new ByteArrayOutputStream();
      copy((InputStream)in, (OutputStream)bout);
      return bout.toByteArray();
   }

   public static void close(OutputStream os) {
      try {
         if (os != null) {
            os.close();
         }
      } catch (IOException var2) {
         Log.ignore(var2);
      }

   }

   public static OutputStream getNullStream() {
      return __nullStream;
   }

   public static InputStream getClosedStream() {
      return __closedStream;
   }

   public static Writer getNullWriter() {
      return __nullWriter;
   }

   private static class NullWrite extends Writer {
      private NullWrite() {
      }

      public void close() {
      }

      public void flush() {
      }

      public void write(char[] b) {
      }

      public void write(char[] b, int o, int l) {
      }

      public void write(int b) {
      }

      public void write(String s) {
      }

      public void write(String s, int o, int l) {
      }

      // $FF: synthetic method
      NullWrite(Object x0) {
         this();
      }
   }

   private static class ClosedIS extends InputStream {
      private ClosedIS() {
      }

      public int read() throws IOException {
         return -1;
      }

      // $FF: synthetic method
      ClosedIS(Object x0) {
         this();
      }
   }

   private static class NullOS extends OutputStream {
      private NullOS() {
      }

      public void close() {
      }

      public void flush() {
      }

      public void write(byte[] b) {
      }

      public void write(byte[] b, int i, int l) {
      }

      public void write(int b) {
      }

      // $FF: synthetic method
      NullOS(Object x0) {
         this();
      }
   }

   static class Job implements Runnable {
      InputStream in;
      OutputStream out;
      Reader read;
      Writer write;

      Job(InputStream in, OutputStream out) {
         this.in = in;
         this.out = out;
         this.read = null;
         this.write = null;
      }

      Job(Reader read, Writer write) {
         this.in = null;
         this.out = null;
         this.read = read;
         this.write = write;
      }

      public void run() {
         try {
            if (this.in != null) {
               IO.copy(this.in, this.out, -1L);
            } else {
               IO.copy(this.read, this.write, -1L);
            }
         } catch (IOException var4) {
            Log.ignore(var4);

            try {
               if (this.out != null) {
                  this.out.close();
               }

               if (this.write != null) {
                  this.write.close();
               }
            } catch (IOException var3) {
               Log.ignore(var3);
            }
         }

      }
   }

   private static class Singleton {
      static final IO __instance = new IO();

      static {
         try {
            __instance.start();
         } catch (Exception var1) {
            Log.warn((Throwable)var1);
            System.exit(1);
         }

      }
   }
}
