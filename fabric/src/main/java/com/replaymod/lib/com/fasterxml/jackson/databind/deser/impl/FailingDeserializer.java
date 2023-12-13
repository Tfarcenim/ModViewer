package com.replaymod.lib.com.fasterxml.jackson.databind.deser.impl;

import com.replaymod.lib.com.fasterxml.jackson.core.JsonParser;
import com.replaymod.lib.com.fasterxml.jackson.databind.DeserializationContext;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonDeserializer;
import com.replaymod.lib.com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

public class FailingDeserializer extends StdDeserializer<Object> {
   private static final long serialVersionUID = 1L;
   protected final String _message;

   public FailingDeserializer(String m) {
      super(Object.class);
      this._message = m;
   }

   public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
      ctxt.reportInputMismatch((JsonDeserializer)this, this._message);
      return null;
   }
}
