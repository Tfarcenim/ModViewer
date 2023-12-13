package com.replaymod.lib.com.fasterxml.jackson.databind.deser;

import com.replaymod.lib.com.fasterxml.jackson.databind.BeanDescription;
import com.replaymod.lib.com.fasterxml.jackson.databind.DeserializationConfig;
import com.replaymod.lib.com.fasterxml.jackson.databind.JavaType;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonMappingException;
import com.replaymod.lib.com.fasterxml.jackson.databind.KeyDeserializer;

public interface KeyDeserializers {
   KeyDeserializer findKeyDeserializer(JavaType var1, DeserializationConfig var2, BeanDescription var3) throws JsonMappingException;
}
