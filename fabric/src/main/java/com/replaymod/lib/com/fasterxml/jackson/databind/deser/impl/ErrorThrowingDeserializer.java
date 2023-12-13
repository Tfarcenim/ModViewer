package com.replaymod.lib.com.fasterxml.jackson.databind.deser.impl;

import com.replaymod.lib.com.fasterxml.jackson.core.JsonParser;
import com.replaymod.lib.com.fasterxml.jackson.databind.DeserializationContext;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class ErrorThrowingDeserializer extends JsonDeserializer<Object> {
   private final Error _cause;

   public ErrorThrowingDeserializer(NoClassDefFoundError cause) {
      this._cause = cause;
   }

   public Object deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
      throw this._cause;
   }
}
