package com.replaymod.lib.com.fasterxml.jackson.databind.deser.std;

import com.replaymod.lib.com.fasterxml.jackson.core.JsonParser;
import com.replaymod.lib.com.fasterxml.jackson.core.JsonToken;
import com.replaymod.lib.com.fasterxml.jackson.databind.DeserializationConfig;
import com.replaymod.lib.com.fasterxml.jackson.databind.DeserializationContext;
import com.replaymod.lib.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;

public class NullifyingDeserializer extends StdDeserializer<Object> {
   private static final long serialVersionUID = 1L;
   public static final NullifyingDeserializer instance = new NullifyingDeserializer();

   public NullifyingDeserializer() {
      super(Object.class);
   }

   public Boolean supportsUpdate(DeserializationConfig config) {
      return Boolean.FALSE;
   }

   public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
      if (p.hasToken(JsonToken.FIELD_NAME)) {
         while(true) {
            JsonToken t = p.nextToken();
            if (t == null || t == JsonToken.END_OBJECT) {
               break;
            }

            p.skipChildren();
         }
      } else {
         p.skipChildren();
      }

      return null;
   }

   public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
      switch(p.getCurrentTokenId()) {
      case 1:
      case 3:
      case 5:
         return typeDeserializer.deserializeTypedFromAny(p, ctxt);
      case 2:
      case 4:
      default:
         return null;
      }
   }
}
