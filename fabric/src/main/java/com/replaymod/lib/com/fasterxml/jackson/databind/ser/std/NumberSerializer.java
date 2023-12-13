package com.replaymod.lib.com.fasterxml.jackson.databind.ser.std;

import com.replaymod.lib.com.fasterxml.jackson.annotation.JsonFormat;
import com.replaymod.lib.com.fasterxml.jackson.core.JsonGenerator;
import com.replaymod.lib.com.fasterxml.jackson.core.JsonParser;
import com.replaymod.lib.com.fasterxml.jackson.databind.BeanProperty;
import com.replaymod.lib.com.fasterxml.jackson.databind.JavaType;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonMappingException;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonNode;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonSerializer;
import com.replaymod.lib.com.fasterxml.jackson.databind.SerializerProvider;
import com.replaymod.lib.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.replaymod.lib.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.replaymod.lib.com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;

@JacksonStdImpl
public class NumberSerializer extends StdScalarSerializer<Number> implements ContextualSerializer {
   public static final NumberSerializer instance = new NumberSerializer(Number.class);
   protected final boolean _isInt;

   public NumberSerializer(Class<? extends Number> rawType) {
      super(rawType, false);
      this._isInt = rawType == BigInteger.class;
   }

   public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {
      JsonFormat.Value format = this.findFormatOverrides(prov, property, this.handledType());
      if (format != null) {
         switch(format.getShape()) {
         case STRING:
            return ToStringSerializer.instance;
         }
      }

      return this;
   }

   public void serialize(Number value, JsonGenerator g, SerializerProvider provider) throws IOException {
      if (value instanceof BigDecimal) {
         g.writeNumber((BigDecimal)value);
      } else if (value instanceof BigInteger) {
         g.writeNumber((BigInteger)value);
      } else if (value instanceof Long) {
         g.writeNumber(value.longValue());
      } else if (value instanceof Double) {
         g.writeNumber(value.doubleValue());
      } else if (value instanceof Float) {
         g.writeNumber(value.floatValue());
      } else if (!(value instanceof Integer) && !(value instanceof Byte) && !(value instanceof Short)) {
         g.writeNumber(value.toString());
      } else {
         g.writeNumber(value.intValue());
      }

   }

   public JsonNode getSchema(SerializerProvider provider, Type typeHint) {
      return this.createSchemaNode(this._isInt ? "integer" : "number", true);
   }

   public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint) throws JsonMappingException {
      if (this._isInt) {
         this.visitIntFormat(visitor, typeHint, JsonParser.NumberType.BIG_INTEGER);
      } else {
         Class<?> h = this.handledType();
         if (h == BigDecimal.class) {
            this.visitFloatFormat(visitor, typeHint, JsonParser.NumberType.BIG_DECIMAL);
         } else {
            visitor.expectNumberFormat(typeHint);
         }
      }

   }
}
