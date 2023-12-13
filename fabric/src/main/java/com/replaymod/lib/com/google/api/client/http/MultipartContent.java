package com.replaymod.lib.com.google.api.client.http;

import com.replaymod.lib.com.google.api.client.util.Preconditions;
import com.replaymod.lib.com.google.api.client.util.StreamingContent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.logging.Logger;

public class MultipartContent extends AbstractHttpContent {
   static final String NEWLINE = "\r\n";
   private static final String TWO_DASHES = "--";
   private ArrayList<MultipartContent.Part> parts = new ArrayList();

   public MultipartContent() {
      super((new HttpMediaType("multipart/related")).setParameter("boundary", "__END_OF_PART__"));
   }

   public void writeTo(OutputStream out) throws IOException {
      Writer writer = new OutputStreamWriter(out, this.getCharset());
      String boundary = this.getBoundary();

      for(Iterator i$ = this.parts.iterator(); i$.hasNext(); writer.write("\r\n")) {
         MultipartContent.Part part = (MultipartContent.Part)i$.next();
         HttpHeaders headers = (new HttpHeaders()).setAcceptEncoding((String)null);
         if (part.headers != null) {
            headers.fromHttpHeaders(part.headers);
         }

         headers.setContentEncoding((String)null).setUserAgent((String)null).setContentType((String)null).setContentLength((Long)null).set("Content-Transfer-Encoding", (Object)null);
         HttpContent content = part.content;
         StreamingContent streamingContent = null;
         if (content != null) {
            headers.set("Content-Transfer-Encoding", Arrays.asList("binary"));
            headers.setContentType(content.getType());
            HttpEncoding encoding = part.encoding;
            long contentLength;
            if (encoding == null) {
               contentLength = content.getLength();
               streamingContent = content;
            } else {
               headers.setContentEncoding(encoding.getName());
               streamingContent = new HttpEncodingStreamingContent(content, encoding);
               contentLength = AbstractHttpContent.computeLength(content);
            }

            if (contentLength != -1L) {
               headers.setContentLength(contentLength);
            }
         }

         writer.write("--");
         writer.write(boundary);
         writer.write("\r\n");
         HttpHeaders.serializeHeadersForMultipartRequests(headers, (StringBuilder)null, (Logger)null, writer);
         if (streamingContent != null) {
            writer.write("\r\n");
            writer.flush();
            ((StreamingContent)streamingContent).writeTo(out);
         }
      }

      writer.write("--");
      writer.write(boundary);
      writer.write("--");
      writer.write("\r\n");
      writer.flush();
   }

   public boolean retrySupported() {
      Iterator i$ = this.parts.iterator();

      MultipartContent.Part part;
      do {
         if (!i$.hasNext()) {
            return true;
         }

         part = (MultipartContent.Part)i$.next();
      } while(part.content.retrySupported());

      return false;
   }

   public MultipartContent setMediaType(HttpMediaType mediaType) {
      super.setMediaType(mediaType);
      return this;
   }

   public final Collection<MultipartContent.Part> getParts() {
      return Collections.unmodifiableCollection(this.parts);
   }

   public MultipartContent addPart(MultipartContent.Part part) {
      this.parts.add(Preconditions.checkNotNull(part));
      return this;
   }

   public MultipartContent setParts(Collection<MultipartContent.Part> parts) {
      this.parts = new ArrayList(parts);
      return this;
   }

   public MultipartContent setContentParts(Collection<? extends HttpContent> contentParts) {
      this.parts = new ArrayList(contentParts.size());
      Iterator i$ = contentParts.iterator();

      while(i$.hasNext()) {
         HttpContent contentPart = (HttpContent)i$.next();
         this.addPart(new MultipartContent.Part(contentPart));
      }

      return this;
   }

   public final String getBoundary() {
      return this.getMediaType().getParameter("boundary");
   }

   public MultipartContent setBoundary(String boundary) {
      this.getMediaType().setParameter("boundary", (String)Preconditions.checkNotNull(boundary));
      return this;
   }

   public static final class Part {
      HttpContent content;
      HttpHeaders headers;
      HttpEncoding encoding;

      public Part() {
         this((HttpContent)null);
      }

      public Part(HttpContent content) {
         this((HttpHeaders)null, content);
      }

      public Part(HttpHeaders headers, HttpContent content) {
         this.setHeaders(headers);
         this.setContent(content);
      }

      public MultipartContent.Part setContent(HttpContent content) {
         this.content = content;
         return this;
      }

      public HttpContent getContent() {
         return this.content;
      }

      public MultipartContent.Part setHeaders(HttpHeaders headers) {
         this.headers = headers;
         return this;
      }

      public HttpHeaders getHeaders() {
         return this.headers;
      }

      public MultipartContent.Part setEncoding(HttpEncoding encoding) {
         this.encoding = encoding;
         return this;
      }

      public HttpEncoding getEncoding() {
         return this.encoding;
      }
   }
}
