package com.replaymod.lib.com.fasterxml.jackson.databind.ser.std;

import com.replaymod.lib.com.fasterxml.jackson.core.JsonGenerator;
import com.replaymod.lib.com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

/** @deprecated */
@Deprecated
public class StdKeySerializer extends StdSerializer<Object> {
   public StdKeySerializer() {
      super(Object.class);
   }

   public void serialize(Object value, JsonGenerator g, SerializerProvider provider) throws IOException {
      g.writeFieldName(value.toString());
   }
}
