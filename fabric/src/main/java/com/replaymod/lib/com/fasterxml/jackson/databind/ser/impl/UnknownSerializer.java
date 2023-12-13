package com.replaymod.lib.com.fasterxml.jackson.databind.ser.impl;

import com.replaymod.lib.com.fasterxml.jackson.core.JsonGenerator;
import com.replaymod.lib.com.fasterxml.jackson.core.JsonToken;
import com.replaymod.lib.com.fasterxml.jackson.core.type.WritableTypeId;
import com.replaymod.lib.com.fasterxml.jackson.databind.JavaType;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonMappingException;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonNode;
import com.replaymod.lib.com.fasterxml.jackson.databind.SerializationFeature;
import com.replaymod.lib.com.fasterxml.jackson.databind.SerializerProvider;
import com.replaymod.lib.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.replaymod.lib.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.replaymod.lib.com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.lang.reflect.Type;

public class UnknownSerializer extends StdSerializer<Object> {
   public UnknownSerializer() {
      super(Object.class);
   }

   public UnknownSerializer(Class<?> cls) {
      super(cls, false);
   }

   public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {
      if (provider.isEnabled(SerializationFeature.FAIL_ON_EMPTY_BEANS)) {
         this.failForEmpty(provider, value);
      }

      gen.writeStartObject();
      gen.writeEndObject();
   }

   public final void serializeWithType(Object value, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer) throws IOException {
      if (provider.isEnabled(SerializationFeature.FAIL_ON_EMPTY_BEANS)) {
         this.failForEmpty(provider, value);
      }

      WritableTypeId typeIdDef = typeSer.writeTypePrefix(gen, typeSer.typeId(value, JsonToken.START_OBJECT));
      typeSer.writeTypeSuffix(gen, typeIdDef);
   }

   public boolean isEmpty(SerializerProvider provider, Object value) {
      return true;
   }

   public JsonNode getSchema(SerializerProvider provider, Type typeHint) throws JsonMappingException {
      return null;
   }

   public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint) throws JsonMappingException {
      visitor.expectAnyFormat(typeHint);
   }

   protected void failForEmpty(SerializerProvider prov, Object value) throws JsonMappingException {
      prov.reportBadDefinition(this.handledType(), String.format("No serializer found for class %s and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)", value.getClass().getName()));
   }
}
