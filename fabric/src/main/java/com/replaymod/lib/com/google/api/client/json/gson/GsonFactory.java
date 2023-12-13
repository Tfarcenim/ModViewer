package com.replaymod.lib.com.google.api.client.json.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.replaymod.lib.com.google.api.client.json.JsonFactory;
import com.replaymod.lib.com.google.api.client.json.JsonGenerator;
import com.replaymod.lib.com.google.api.client.json.JsonParser;
import com.replaymod.lib.com.google.api.client.util.Beta;
import com.replaymod.lib.com.google.api.client.util.Charsets;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;

public class GsonFactory extends JsonFactory {
   @Beta
   public static GsonFactory getDefaultInstance() {
      return GsonFactory.InstanceHolder.INSTANCE;
   }

   public JsonParser createJsonParser(InputStream in) {
      return this.createJsonParser((Reader)(new InputStreamReader(in, Charsets.UTF_8)));
   }

   public JsonParser createJsonParser(InputStream in, Charset charset) {
      return charset == null ? this.createJsonParser(in) : this.createJsonParser((Reader)(new InputStreamReader(in, charset)));
   }

   public JsonParser createJsonParser(String value) {
      return this.createJsonParser((Reader)(new StringReader(value)));
   }

   public JsonParser createJsonParser(Reader reader) {
      return new GsonParser(this, new JsonReader(reader));
   }

   public JsonGenerator createJsonGenerator(OutputStream out, Charset enc) {
      return this.createJsonGenerator(new OutputStreamWriter(out, enc));
   }

   public JsonGenerator createJsonGenerator(Writer writer) {
      return new GsonGenerator(this, new JsonWriter(writer));
   }

   @Beta
   static class InstanceHolder {
      static final GsonFactory INSTANCE = new GsonFactory();
   }
}
