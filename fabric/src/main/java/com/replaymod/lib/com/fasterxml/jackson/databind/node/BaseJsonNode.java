package com.replaymod.lib.com.fasterxml.jackson.databind.node;

import com.replaymod.lib.com.fasterxml.jackson.core.JsonGenerator;
import com.replaymod.lib.com.fasterxml.jackson.core.JsonParser;
import com.replaymod.lib.com.fasterxml.jackson.core.JsonProcessingException;
import com.replaymod.lib.com.fasterxml.jackson.core.JsonToken;
import com.replaymod.lib.com.fasterxml.jackson.core.ObjectCodec;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonNode;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonSerializable;
import com.replaymod.lib.com.fasterxml.jackson.databind.SerializerProvider;
import com.replaymod.lib.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

public abstract class BaseJsonNode extends JsonNode implements JsonSerializable {
   protected BaseJsonNode() {
   }

   public final JsonNode findPath(String fieldName) {
      JsonNode value = this.findValue(fieldName);
      return (JsonNode)(value == null ? MissingNode.getInstance() : value);
   }

   public abstract int hashCode();

   public JsonParser traverse() {
      return new TreeTraversingParser(this);
   }

   public JsonParser traverse(ObjectCodec codec) {
      return new TreeTraversingParser(this, codec);
   }

   public abstract JsonToken asToken();

   public JsonParser.NumberType numberType() {
      return null;
   }

   public abstract void serialize(JsonGenerator var1, SerializerProvider var2) throws IOException, JsonProcessingException;

   public abstract void serializeWithType(JsonGenerator var1, SerializerProvider var2, TypeSerializer var3) throws IOException, JsonProcessingException;
}
