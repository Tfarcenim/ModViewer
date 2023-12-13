package com.replaymod.lib.com.fasterxml.jackson.databind.jsontype;

import com.replaymod.lib.com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.replaymod.lib.com.fasterxml.jackson.databind.DeserializationConfig;
import com.replaymod.lib.com.fasterxml.jackson.databind.JavaType;
import com.replaymod.lib.com.fasterxml.jackson.databind.SerializationConfig;
import java.util.Collection;

public interface TypeResolverBuilder<T extends TypeResolverBuilder<T>> {
   Class<?> getDefaultImpl();

   TypeSerializer buildTypeSerializer(SerializationConfig var1, JavaType var2, Collection<NamedType> var3);

   TypeDeserializer buildTypeDeserializer(DeserializationConfig var1, JavaType var2, Collection<NamedType> var3);

   T init(JsonTypeInfo.Id var1, TypeIdResolver var2);

   T inclusion(JsonTypeInfo.As var1);

   T typeProperty(String var1);

   T defaultImpl(Class<?> var1);

   T typeIdVisibility(boolean var1);
}
