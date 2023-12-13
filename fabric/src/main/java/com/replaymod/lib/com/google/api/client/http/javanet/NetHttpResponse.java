package com.replaymod.lib.com.google.api.client.http.javanet;

import com.replaymod.lib.com.google.api.client.http.LowLevelHttpResponse;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class NetHttpResponse extends LowLevelHttpResponse {
   private final HttpURLConnection connection;
   private final int responseCode;
   private final String responseMessage;
   private final ArrayList<String> headerNames = new ArrayList();
   private final ArrayList<String> headerValues = new ArrayList();

   NetHttpResponse(HttpURLConnection connection) throws IOException {
      this.connection = connection;
      int responseCode = connection.getResponseCode();
      this.responseCode = responseCode == -1 ? 0 : responseCode;
      this.responseMessage = connection.getResponseMessage();
      List<String> headerNames = this.headerNames;
      List<String> headerValues = this.headerValues;
      Iterator i$ = connection.getHeaderFields().entrySet().iterator();

      while(true) {
         Entry entry;
         String key;
         do {
            if (!i$.hasNext()) {
               return;
            }

            entry = (Entry)i$.next();
            key = (String)entry.getKey();
         } while(key == null);

         Iterator i$ = ((List)entry.getValue()).iterator();

         while(i$.hasNext()) {
            String value = (String)i$.next();
            if (value != null) {
               headerNames.add(key);
               headerValues.add(value);
            }
         }
      }
   }

   public int getStatusCode() {
      return this.responseCode;
   }

   public InputStream getContent() throws IOException {
      InputStream in = null;

      try {
         in = this.connection.getInputStream();
      } catch (IOException var3) {
         in = this.connection.getErrorStream();
      }

      return in == null ? null : new NetHttpResponse.SizeValidatingInputStream(in);
   }

   public String getContentEncoding() {
      return this.connection.getContentEncoding();
   }

   public long getContentLength() {
      String string = this.connection.getHeaderField("Content-Length");
      return string == null ? -1L : Long.parseLong(string);
   }

   public String getContentType() {
      return this.connection.getHeaderField("Content-Type");
   }

   public String getReasonPhrase() {
      return this.responseMessage;
   }

   public String getStatusLine() {
      String result = this.connection.getHeaderField(0);
      return result != null && result.startsWith("HTTP/1.") ? result : null;
   }

   public int getHeaderCount() {
      return this.headerNames.size();
   }

   public String getHeaderName(int index) {
      return (String)this.headerNames.get(index);
   }

   public String getHeaderValue(int index) {
      return (String)this.headerValues.get(index);
   }

   public void disconnect() {
      this.connection.disconnect();
   }

   private final class SizeValidatingInputStream extends FilterInputStream {
      private long bytesRead = 0L;

      public SizeValidatingInputStream(InputStream in) {
         super(in);
      }

      public int read(byte[] b, int off, int len) throws IOException {
         int n = this.in.read(b, off, len);
         if (n == -1) {
            this.throwIfFalseEOF();
         } else {
            this.bytesRead += (long)n;
         }

         return n;
      }

      public int read() throws IOException {
         int n = this.in.read();
         if (n == -1) {
            this.throwIfFalseEOF();
         } else {
            ++this.bytesRead;
         }

         return n;
      }

      private void throwIfFalseEOF() throws IOException {
         long contentLength = NetHttpResponse.this.getContentLength();
         if (contentLength != -1L) {
            if (this.bytesRead != 0L && this.bytesRead < contentLength) {
               throw new IOException("Connection closed prematurely: bytesRead = " + this.bytesRead + ", Content-Length = " + contentLength);
            }
         }
      }
   }
}
