package com.replaymod.lib.com.fasterxml.jackson.databind.ser;

import com.replaymod.lib.com.fasterxml.jackson.databind.BeanProperty;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonMappingException;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonSerializer;
import com.replaymod.lib.com.fasterxml.jackson.databind.SerializerProvider;

public interface ContextualSerializer {
   JsonSerializer<?> createContextual(SerializerProvider var1, BeanProperty var2) throws JsonMappingException;
}
