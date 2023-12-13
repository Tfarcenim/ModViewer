package com.replaymod.lib.com.fasterxml.jackson.databind.deser;

import com.replaymod.lib.com.fasterxml.jackson.databind.DeserializationContext;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonMappingException;

public interface ResolvableDeserializer {
   void resolve(DeserializationContext var1) throws JsonMappingException;
}
