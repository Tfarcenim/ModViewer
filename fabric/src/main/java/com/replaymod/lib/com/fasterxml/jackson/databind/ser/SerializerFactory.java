package com.replaymod.lib.com.fasterxml.jackson.databind.ser;

import com.replaymod.lib.com.fasterxml.jackson.databind.JavaType;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonMappingException;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonSerializer;
import com.replaymod.lib.com.fasterxml.jackson.databind.SerializationConfig;
import com.replaymod.lib.com.fasterxml.jackson.databind.SerializerProvider;
import com.replaymod.lib.com.fasterxml.jackson.databind.jsontype.TypeSerializer;

public abstract class SerializerFactory {
   public abstract SerializerFactory withAdditionalSerializers(Serializers var1);

   public abstract SerializerFactory withAdditionalKeySerializers(Serializers var1);

   public abstract SerializerFactory withSerializerModifier(BeanSerializerModifier var1);

   public abstract JsonSerializer<Object> createSerializer(SerializerProvider var1, JavaType var2) throws JsonMappingException;

   public abstract TypeSerializer createTypeSerializer(SerializationConfig var1, JavaType var2) throws JsonMappingException;

   public abstract JsonSerializer<Object> createKeySerializer(SerializationConfig var1, JavaType var2, JsonSerializer<Object> var3) throws JsonMappingException;
}
