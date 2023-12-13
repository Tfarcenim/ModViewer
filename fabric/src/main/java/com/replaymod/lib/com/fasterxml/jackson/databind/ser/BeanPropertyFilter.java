package com.replaymod.lib.com.fasterxml.jackson.databind.ser;

import com.replaymod.lib.com.fasterxml.jackson.core.JsonGenerator;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonMappingException;
import com.replaymod.lib.com.fasterxml.jackson.databind.SerializerProvider;
import com.replaymod.lib.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.replaymod.lib.com.fasterxml.jackson.databind.node.ObjectNode;

/** @deprecated */
@Deprecated
public interface BeanPropertyFilter {
   void serializeAsField(Object var1, JsonGenerator var2, SerializerProvider var3, BeanPropertyWriter var4) throws Exception;

   /** @deprecated */
   @Deprecated
   void depositSchemaProperty(BeanPropertyWriter var1, ObjectNode var2, SerializerProvider var3) throws JsonMappingException;

   void depositSchemaProperty(BeanPropertyWriter var1, JsonObjectFormatVisitor var2, SerializerProvider var3) throws JsonMappingException;
}
