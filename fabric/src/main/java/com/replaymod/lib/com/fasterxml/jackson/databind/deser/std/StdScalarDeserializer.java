package com.replaymod.lib.com.fasterxml.jackson.databind.deser.std;

import com.replaymod.lib.com.fasterxml.jackson.core.JsonParser;
import com.replaymod.lib.com.fasterxml.jackson.databind.DeserializationConfig;
import com.replaymod.lib.com.fasterxml.jackson.databind.DeserializationContext;
import com.replaymod.lib.com.fasterxml.jackson.databind.JavaType;
import com.replaymod.lib.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.replaymod.lib.com.fasterxml.jackson.databind.util.AccessPattern;
import java.io.IOException;

public abstract class StdScalarDeserializer<T> extends StdDeserializer<T> {
   private static final long serialVersionUID = 1L;

   protected StdScalarDeserializer(Class<?> vc) {
      super(vc);
   }

   protected StdScalarDeserializer(JavaType valueType) {
      super(valueType);
   }

   protected StdScalarDeserializer(StdScalarDeserializer<?> src) {
      super((StdDeserializer)src);
   }

   public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
      return typeDeserializer.deserializeTypedFromScalar(p, ctxt);
   }

   public T deserialize(JsonParser p, DeserializationContext ctxt, T intoValue) throws IOException {
      ctxt.reportBadMerge(this);
      return this.deserialize(p, ctxt);
   }

   public Boolean supportsUpdate(DeserializationConfig config) {
      return Boolean.FALSE;
   }

   public AccessPattern getNullAccessPattern() {
      return AccessPattern.ALWAYS_NULL;
   }

   public AccessPattern getEmptyAccessPattern() {
      return AccessPattern.CONSTANT;
   }
}
