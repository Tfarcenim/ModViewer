package com.replaymod.lib.org.mortbay.io.bio;

import com.replaymod.lib.org.mortbay.io.Buffer;
import com.replaymod.lib.org.mortbay.io.EndPoint;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamEndPoint implements EndPoint {
   InputStream _in;
   OutputStream _out;

   public StreamEndPoint(InputStream in, OutputStream out) {
      this._in = in;
      this._out = out;
   }

   public boolean isBlocking() {
      return true;
   }

   public boolean blockReadable(long millisecs) throws IOException {
      return true;
   }

   public boolean blockWritable(long millisecs) throws IOException {
      return true;
   }

   public boolean isOpen() {
      return this._in != null;
   }

   public final boolean isClosed() {
      return !this.isOpen();
   }

   public void shutdownOutput() throws IOException {
   }

   public void close() throws IOException {
      if (this._in != null) {
         this._in.close();
      }

      this._in = null;
      if (this._out != null) {
         this._out.close();
      }

      this._out = null;
   }

   public int fill(Buffer buffer) throws IOException {
      if (this._in == null) {
         return 0;
      } else {
         int space = buffer.space();
         if (space <= 0) {
            if (buffer.hasContent()) {
               return 0;
            } else {
               throw new IOException("FULL");
            }
         } else {
            int len = buffer.readFrom(this._in, space);
            return len;
         }
      }
   }

   public int flush(Buffer buffer) throws IOException {
      if (this._out == null) {
         return -1;
      } else {
         int length = buffer.length();
         if (length > 0) {
            buffer.writeTo(this._out);
         }

         buffer.clear();
         return length;
      }
   }

   public int flush(Buffer header, Buffer buffer, Buffer trailer) throws IOException {
      int len = 0;
      int tw;
      int f;
      if (header != null) {
         tw = header.length();
         if (tw > 0) {
            f = this.flush(header);
            len = f;
            if (f < tw) {
               return f;
            }
         }
      }

      if (buffer != null) {
         tw = buffer.length();
         if (tw > 0) {
            f = this.flush(buffer);
            if (f < 0) {
               return len > 0 ? len : f;
            }

            len += f;
            if (f < tw) {
               return len;
            }
         }
      }

      if (trailer != null) {
         tw = trailer.length();
         if (tw > 0) {
            f = this.flush(trailer);
            if (f < 0) {
               return len > 0 ? len : f;
            }

            len += f;
         }
      }

      return len;
   }

   public String getLocalAddr() {
      return null;
   }

   public String getLocalHost() {
      return null;
   }

   public int getLocalPort() {
      return 0;
   }

   public String getRemoteAddr() {
      return null;
   }

   public String getRemoteHost() {
      return null;
   }

   public int getRemotePort() {
      return 0;
   }

   public Object getTransport() {
      return null;
   }

   public InputStream getInputStream() {
      return this._in;
   }

   public void setInputStream(InputStream in) {
      this._in = in;
   }

   public OutputStream getOutputStream() {
      return this._out;
   }

   public void setOutputStream(OutputStream out) {
      this._out = out;
   }

   public void flush() throws IOException {
      this._out.flush();
   }

   public boolean isBufferingInput() {
      return false;
   }

   public boolean isBufferingOutput() {
      return false;
   }

   public boolean isBufferred() {
      return false;
   }
}
