package com.replaymod.lib.com.fasterxml.jackson.databind.jsontype;

import com.replaymod.lib.com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.replaymod.lib.com.fasterxml.jackson.databind.DatabindContext;
import com.replaymod.lib.com.fasterxml.jackson.databind.JavaType;
import java.io.IOException;

public interface TypeIdResolver {
   void init(JavaType var1);

   String idFromValue(Object var1);

   String idFromValueAndType(Object var1, Class<?> var2);

   String idFromBaseType();

   JavaType typeFromId(DatabindContext var1, String var2) throws IOException;

   String getDescForKnownTypeIds();

   JsonTypeInfo.Id getMechanism();
}
