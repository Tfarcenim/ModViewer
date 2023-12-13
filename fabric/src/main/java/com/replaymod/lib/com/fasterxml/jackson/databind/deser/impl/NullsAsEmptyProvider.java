package com.replaymod.lib.com.fasterxml.jackson.databind.deser.impl;

import com.replaymod.lib.com.fasterxml.jackson.databind.DeserializationContext;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonDeserializer;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonMappingException;
import com.replaymod.lib.com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.replaymod.lib.com.fasterxml.jackson.databind.util.AccessPattern;
import java.io.Serializable;

public class NullsAsEmptyProvider implements NullValueProvider, Serializable {
   private static final long serialVersionUID = 1L;
   protected final JsonDeserializer<?> _deserializer;

   public NullsAsEmptyProvider(JsonDeserializer<?> deser) {
      this._deserializer = deser;
   }

   public AccessPattern getNullAccessPattern() {
      return AccessPattern.DYNAMIC;
   }

   public Object getNullValue(DeserializationContext ctxt) throws JsonMappingException {
      return this._deserializer.getEmptyValue(ctxt);
   }
}
