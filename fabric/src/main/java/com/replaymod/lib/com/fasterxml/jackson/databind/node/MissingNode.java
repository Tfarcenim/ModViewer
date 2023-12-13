package com.replaymod.lib.com.fasterxml.jackson.databind.node;

import com.replaymod.lib.com.fasterxml.jackson.core.JsonGenerator;
import com.replaymod.lib.com.fasterxml.jackson.core.JsonProcessingException;
import com.replaymod.lib.com.fasterxml.jackson.core.JsonToken;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonNode;
import com.replaymod.lib.com.fasterxml.jackson.databind.SerializerProvider;
import com.replaymod.lib.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

public final class MissingNode extends ValueNode {
   private static final MissingNode instance = new MissingNode();

   protected MissingNode() {
   }

   public boolean isMissingNode() {
      return true;
   }

   public <T extends JsonNode> T deepCopy() {
      return this;
   }

   public static MissingNode getInstance() {
      return instance;
   }

   public JsonNodeType getNodeType() {
      return JsonNodeType.MISSING;
   }

   public JsonToken asToken() {
      return JsonToken.NOT_AVAILABLE;
   }

   public String asText() {
      return "";
   }

   public String asText(String defaultValue) {
      return defaultValue;
   }

   public final void serialize(JsonGenerator jg, SerializerProvider provider) throws IOException, JsonProcessingException {
      jg.writeNull();
   }

   public void serializeWithType(JsonGenerator g, SerializerProvider provider, TypeSerializer typeSer) throws IOException, JsonProcessingException {
      g.writeNull();
   }

   public boolean equals(Object o) {
      return o == this;
   }

   public String toString() {
      return "";
   }

   public int hashCode() {
      return JsonNodeType.MISSING.ordinal();
   }
}
