package com.replaymod.lib.com.fasterxml.jackson.databind.deser;

import com.replaymod.lib.com.fasterxml.jackson.databind.BeanProperty;
import com.replaymod.lib.com.fasterxml.jackson.databind.DeserializationContext;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonDeserializer;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonMappingException;

public interface ContextualDeserializer {
   JsonDeserializer<?> createContextual(DeserializationContext var1, BeanProperty var2) throws JsonMappingException;
}
