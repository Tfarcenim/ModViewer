package com.replaymod.lib.com.google.api.client.json.gson;

import com.google.gson.stream.JsonReader;
import com.replaymod.lib.com.google.api.client.json.JsonFactory;
import com.replaymod.lib.com.google.api.client.json.JsonParser;
import com.replaymod.lib.com.google.api.client.json.JsonToken;
import com.replaymod.lib.com.google.api.client.util.Preconditions;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class GsonParser extends JsonParser {
   private final JsonReader reader;
   private final GsonFactory factory;
   private List<String> currentNameStack = new ArrayList();
   private JsonToken currentToken;
   private String currentText;

   GsonParser(GsonFactory factory, JsonReader reader) {
      this.factory = factory;
      this.reader = reader;
      reader.setLenient(true);
   }

   public void close() throws IOException {
      this.reader.close();
   }

   public String getCurrentName() {
      return this.currentNameStack.isEmpty() ? null : (String)this.currentNameStack.get(this.currentNameStack.size() - 1);
   }

   public JsonToken getCurrentToken() {
      return this.currentToken;
   }

   public JsonFactory getFactory() {
      return this.factory;
   }

   public byte getByteValue() {
      this.checkNumber();
      return Byte.valueOf(this.currentText);
   }

   public short getShortValue() {
      this.checkNumber();
      return Short.valueOf(this.currentText);
   }

   public int getIntValue() {
      this.checkNumber();
      return Integer.valueOf(this.currentText);
   }

   public float getFloatValue() {
      this.checkNumber();
      return Float.valueOf(this.currentText);
   }

   public BigInteger getBigIntegerValue() {
      this.checkNumber();
      return new BigInteger(this.currentText);
   }

   public BigDecimal getDecimalValue() {
      this.checkNumber();
      return new BigDecimal(this.currentText);
   }

   public double getDoubleValue() {
      this.checkNumber();
      return Double.valueOf(this.currentText);
   }

   public long getLongValue() {
      this.checkNumber();
      return Long.valueOf(this.currentText);
   }

   private void checkNumber() {
      Preconditions.checkArgument(this.currentToken == JsonToken.VALUE_NUMBER_INT || this.currentToken == JsonToken.VALUE_NUMBER_FLOAT);
   }

   public String getText() {
      return this.currentText;
   }

   public JsonToken nextToken() throws IOException {
      if (this.currentToken != null) {
         switch(this.currentToken) {
         case START_ARRAY:
            this.reader.beginArray();
            this.currentNameStack.add((Object)null);
            break;
         case START_OBJECT:
            this.reader.beginObject();
            this.currentNameStack.add((Object)null);
         }
      }

      com.google.gson.stream.JsonToken peek;
      try {
         peek = this.reader.peek();
      } catch (EOFException var3) {
         peek = com.google.gson.stream.JsonToken.END_DOCUMENT;
      }

      switch(peek) {
      case BEGIN_ARRAY:
         this.currentText = "[";
         this.currentToken = JsonToken.START_ARRAY;
         break;
      case END_ARRAY:
         this.currentText = "]";
         this.currentToken = JsonToken.END_ARRAY;
         this.currentNameStack.remove(this.currentNameStack.size() - 1);
         this.reader.endArray();
         break;
      case BEGIN_OBJECT:
         this.currentText = "{";
         this.currentToken = JsonToken.START_OBJECT;
         break;
      case END_OBJECT:
         this.currentText = "}";
         this.currentToken = JsonToken.END_OBJECT;
         this.currentNameStack.remove(this.currentNameStack.size() - 1);
         this.reader.endObject();
         break;
      case BOOLEAN:
         if (this.reader.nextBoolean()) {
            this.currentText = "true";
            this.currentToken = JsonToken.VALUE_TRUE;
         } else {
            this.currentText = "false";
            this.currentToken = JsonToken.VALUE_FALSE;
         }
         break;
      case NULL:
         this.currentText = "null";
         this.currentToken = JsonToken.VALUE_NULL;
         this.reader.nextNull();
         break;
      case STRING:
         this.currentText = this.reader.nextString();
         this.currentToken = JsonToken.VALUE_STRING;
         break;
      case NUMBER:
         this.currentText = this.reader.nextString();
         this.currentToken = this.currentText.indexOf(46) == -1 ? JsonToken.VALUE_NUMBER_INT : JsonToken.VALUE_NUMBER_FLOAT;
         break;
      case NAME:
         this.currentText = this.reader.nextName();
         this.currentToken = JsonToken.FIELD_NAME;
         this.currentNameStack.set(this.currentNameStack.size() - 1, this.currentText);
         break;
      default:
         this.currentText = null;
         this.currentToken = null;
      }

      return this.currentToken;
   }

   public JsonParser skipChildren() throws IOException {
      if (this.currentToken != null) {
         switch(this.currentToken) {
         case START_ARRAY:
            this.reader.skipValue();
            this.currentText = "]";
            this.currentToken = JsonToken.END_ARRAY;
            break;
         case START_OBJECT:
            this.reader.skipValue();
            this.currentText = "}";
            this.currentToken = JsonToken.END_OBJECT;
         }
      }

      return this;
   }
}
