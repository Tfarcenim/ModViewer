package com.replaymod.lib.com.google.api.client.http;

import com.replaymod.lib.com.google.api.client.util.StreamingContent;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class GZipEncoding implements HttpEncoding {
   public String getName() {
      return "gzip";
   }

   public void encode(StreamingContent content, OutputStream out) throws IOException {
      OutputStream out2 = new BufferedOutputStream(out) {
         public void close() throws IOException {
            try {
               this.flush();
            } catch (IOException var2) {
            }

         }
      };
      GZIPOutputStream zipper = new GZIPOutputStream(out2);
      content.writeTo(zipper);
      zipper.close();
   }
}
