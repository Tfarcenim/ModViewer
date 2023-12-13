package com.replaymod.lib.com.fasterxml.jackson.databind.ser.std;

import com.replaymod.lib.com.fasterxml.jackson.core.JsonGenerator;
import com.replaymod.lib.com.fasterxml.jackson.databind.JavaType;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonMappingException;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonSerializable;
import com.replaymod.lib.com.fasterxml.jackson.databind.SerializerProvider;
import com.replaymod.lib.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.replaymod.lib.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.replaymod.lib.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

@JacksonStdImpl
public class SerializableSerializer extends StdSerializer<JsonSerializable> {
   public static final SerializableSerializer instance = new SerializableSerializer();

   protected SerializableSerializer() {
      super(JsonSerializable.class);
   }

   public boolean isEmpty(SerializerProvider serializers, JsonSerializable value) {
      return value instanceof JsonSerializable.Base ? ((JsonSerializable.Base)value).isEmpty(serializers) : false;
   }

   public void serialize(JsonSerializable value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
      value.serialize(gen, serializers);
   }

   public final void serializeWithType(JsonSerializable value, JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {
      value.serializeWithType(gen, serializers, typeSer);
   }

   public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint) throws JsonMappingException {
      visitor.expectAnyFormat(typeHint);
   }
}
