package com.replaymod.lib.com.google.api.client.json;

import com.replaymod.lib.com.google.api.client.util.ObjectParser;
import com.replaymod.lib.com.google.api.client.util.Preconditions;
import com.replaymod.lib.com.google.api.client.util.Sets;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class JsonObjectParser implements ObjectParser {
   private final JsonFactory jsonFactory;
   private final Set<String> wrapperKeys;

   public JsonObjectParser(JsonFactory jsonFactory) {
      this(new JsonObjectParser.Builder(jsonFactory));
   }

   protected JsonObjectParser(JsonObjectParser.Builder builder) {
      this.jsonFactory = builder.jsonFactory;
      this.wrapperKeys = new HashSet(builder.wrapperKeys);
   }

   public <T> T parseAndClose(InputStream in, Charset charset, Class<T> dataClass) throws IOException {
      return this.parseAndClose(in, charset, (Type)dataClass);
   }

   public Object parseAndClose(InputStream in, Charset charset, Type dataType) throws IOException {
      JsonParser parser = this.jsonFactory.createJsonParser(in, charset);
      this.initializeParser(parser);
      return parser.parse(dataType, true);
   }

   public <T> T parseAndClose(Reader reader, Class<T> dataClass) throws IOException {
      return this.parseAndClose(reader, (Type)dataClass);
   }

   public Object parseAndClose(Reader reader, Type dataType) throws IOException {
      JsonParser parser = this.jsonFactory.createJsonParser(reader);
      this.initializeParser(parser);
      return parser.parse(dataType, true);
   }

   public final JsonFactory getJsonFactory() {
      return this.jsonFactory;
   }

   public Set<String> getWrapperKeys() {
      return Collections.unmodifiableSet(this.wrapperKeys);
   }

   private void initializeParser(JsonParser parser) throws IOException {
      if (!this.wrapperKeys.isEmpty()) {
         boolean failed = true;

         try {
            String match = parser.skipToKey(this.wrapperKeys);
            Preconditions.checkArgument(match != null && parser.getCurrentToken() != JsonToken.END_OBJECT, "wrapper key(s) not found: %s", this.wrapperKeys);
            failed = false;
         } finally {
            if (failed) {
               parser.close();
            }

         }

      }
   }

   public static class Builder {
      final JsonFactory jsonFactory;
      Collection<String> wrapperKeys = Sets.newHashSet();

      public Builder(JsonFactory jsonFactory) {
         this.jsonFactory = (JsonFactory)Preconditions.checkNotNull(jsonFactory);
      }

      public JsonObjectParser build() {
         return new JsonObjectParser(this);
      }

      public final JsonFactory getJsonFactory() {
         return this.jsonFactory;
      }

      public final Collection<String> getWrapperKeys() {
         return this.wrapperKeys;
      }

      public JsonObjectParser.Builder setWrapperKeys(Collection<String> wrapperKeys) {
         this.wrapperKeys = wrapperKeys;
         return this;
      }
   }
}
