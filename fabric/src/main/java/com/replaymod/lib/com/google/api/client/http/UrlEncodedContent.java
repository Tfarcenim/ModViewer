package com.replaymod.lib.com.google.api.client.http;

import com.replaymod.lib.com.google.api.client.util.Data;
import com.replaymod.lib.com.google.api.client.util.FieldInfo;
import com.replaymod.lib.com.google.api.client.util.Preconditions;
import com.replaymod.lib.com.google.api.client.util.Types;
import com.replaymod.lib.com.google.api.client.util.escape.CharEscapers;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class UrlEncodedContent extends AbstractHttpContent {
   private Object data;

   public UrlEncodedContent(Object data) {
      super(UrlEncodedParser.MEDIA_TYPE);
      this.setData(data);
   }

   public void writeTo(OutputStream out) throws IOException {
      Writer writer = new BufferedWriter(new OutputStreamWriter(out, this.getCharset()));
      boolean first = true;
      Iterator i$ = Data.mapOf(this.data).entrySet().iterator();

      while(true) {
         while(true) {
            Entry nameValueEntry;
            Object value;
            do {
               if (!i$.hasNext()) {
                  writer.flush();
                  return;
               }

               nameValueEntry = (Entry)i$.next();
               value = nameValueEntry.getValue();
            } while(value == null);

            String name = CharEscapers.escapeUri((String)nameValueEntry.getKey());
            Class<? extends Object> valueClass = value.getClass();
            Object repeatedValue;
            if (!(value instanceof Iterable) && !valueClass.isArray()) {
               first = appendParam(first, writer, name, value);
            } else {
               for(Iterator i$ = Types.iterableOf(value).iterator(); i$.hasNext(); first = appendParam(first, writer, name, repeatedValue)) {
                  repeatedValue = i$.next();
               }
            }
         }
      }
   }

   public UrlEncodedContent setMediaType(HttpMediaType mediaType) {
      super.setMediaType(mediaType);
      return this;
   }

   public final Object getData() {
      return this.data;
   }

   public UrlEncodedContent setData(Object data) {
      this.data = Preconditions.checkNotNull(data);
      return this;
   }

   public static UrlEncodedContent getContent(HttpRequest request) {
      HttpContent content = request.getContent();
      if (content != null) {
         return (UrlEncodedContent)content;
      } else {
         UrlEncodedContent result = new UrlEncodedContent(new HashMap());
         request.setContent(result);
         return result;
      }
   }

   private static boolean appendParam(boolean first, Writer writer, String name, Object value) throws IOException {
      if (value != null && !Data.isNull(value)) {
         if (first) {
            first = false;
         } else {
            writer.write("&");
         }

         writer.write(name);
         String stringValue = CharEscapers.escapeUri(value instanceof Enum ? FieldInfo.of((Enum)value).getName() : value.toString());
         if (stringValue.length() != 0) {
            writer.write("=");
            writer.write(stringValue);
         }

         return first;
      } else {
         return first;
      }
   }
}
