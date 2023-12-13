package com.replaymod.lib.com.fasterxml.jackson.databind.deser.std;

import com.replaymod.lib.com.fasterxml.jackson.core.JsonParser;
import com.replaymod.lib.com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanDeserializer extends StdScalarDeserializer<AtomicBoolean> {
   private static final long serialVersionUID = 1L;

   public AtomicBooleanDeserializer() {
      super(AtomicBoolean.class);
   }

   public AtomicBoolean deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
      return new AtomicBoolean(this._parseBooleanPrimitive(jp, ctxt));
   }
}
