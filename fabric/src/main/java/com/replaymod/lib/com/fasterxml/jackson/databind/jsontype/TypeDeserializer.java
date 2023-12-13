package com.replaymod.lib.com.fasterxml.jackson.databind.jsontype;

import com.replaymod.lib.com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.replaymod.lib.com.fasterxml.jackson.core.JsonParser;
import com.replaymod.lib.com.fasterxml.jackson.core.JsonToken;
import com.replaymod.lib.com.fasterxml.jackson.databind.BeanProperty;
import com.replaymod.lib.com.fasterxml.jackson.databind.DeserializationContext;
import com.replaymod.lib.com.fasterxml.jackson.databind.JavaType;
import java.io.IOException;

public abstract class TypeDeserializer {
   public abstract TypeDeserializer forProperty(BeanProperty var1);

   public abstract JsonTypeInfo.As getTypeInclusion();

   public abstract String getPropertyName();

   public abstract TypeIdResolver getTypeIdResolver();

   public abstract Class<?> getDefaultImpl();

   public abstract Object deserializeTypedFromObject(JsonParser var1, DeserializationContext var2) throws IOException;

   public abstract Object deserializeTypedFromArray(JsonParser var1, DeserializationContext var2) throws IOException;

   public abstract Object deserializeTypedFromScalar(JsonParser var1, DeserializationContext var2) throws IOException;

   public abstract Object deserializeTypedFromAny(JsonParser var1, DeserializationContext var2) throws IOException;

   public static Object deserializeIfNatural(JsonParser p, DeserializationContext ctxt, JavaType baseType) throws IOException {
      return deserializeIfNatural(p, ctxt, baseType.getRawClass());
   }

   public static Object deserializeIfNatural(JsonParser p, DeserializationContext ctxt, Class<?> base) throws IOException {
      JsonToken t = p.getCurrentToken();
      if (t == null) {
         return null;
      } else {
         switch(t) {
         case VALUE_STRING:
            if (base.isAssignableFrom(String.class)) {
               return p.getText();
            }
            break;
         case VALUE_NUMBER_INT:
            if (base.isAssignableFrom(Integer.class)) {
               return p.getIntValue();
            }
            break;
         case VALUE_NUMBER_FLOAT:
            if (base.isAssignableFrom(Double.class)) {
               return p.getDoubleValue();
            }
            break;
         case VALUE_TRUE:
            if (base.isAssignableFrom(Boolean.class)) {
               return Boolean.TRUE;
            }
            break;
         case VALUE_FALSE:
            if (base.isAssignableFrom(Boolean.class)) {
               return Boolean.FALSE;
            }
         }

         return null;
      }
   }
}
