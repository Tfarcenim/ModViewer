package com.replaymod.lib.com.fasterxml.jackson.databind.deser.std;

import com.replaymod.lib.com.fasterxml.jackson.core.JsonParser;
import com.replaymod.lib.com.fasterxml.jackson.core.JsonToken;
import com.replaymod.lib.com.fasterxml.jackson.databind.DeserializationContext;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonMappingException;
import com.replaymod.lib.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.replaymod.lib.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;

@JacksonStdImpl
public class StringDeserializer extends StdScalarDeserializer<String> {
   private static final long serialVersionUID = 1L;
   public static final StringDeserializer instance = new StringDeserializer();

   public StringDeserializer() {
      super(String.class);
   }

   public boolean isCachable() {
      return true;
   }

   public Object getEmptyValue(DeserializationContext ctxt) throws JsonMappingException {
      return "";
   }

   public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
      if (p.hasToken(JsonToken.VALUE_STRING)) {
         return p.getText();
      } else {
         JsonToken t = p.getCurrentToken();
         if (t == JsonToken.START_ARRAY) {
            return (String)this._deserializeFromArray(p, ctxt);
         } else if (t == JsonToken.VALUE_EMBEDDED_OBJECT) {
            Object ob = p.getEmbeddedObject();
            if (ob == null) {
               return null;
            } else {
               return ob instanceof byte[] ? ctxt.getBase64Variant().encode((byte[])((byte[])ob), false) : ob.toString();
            }
         } else {
            if (t.isScalarValue()) {
               String text = p.getValueAsString();
               if (text != null) {
                  return text;
               }
            }

            return (String)ctxt.handleUnexpectedToken(this._valueClass, p);
         }
      }
   }

   public String deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
      return this.deserialize(p, ctxt);
   }
}
