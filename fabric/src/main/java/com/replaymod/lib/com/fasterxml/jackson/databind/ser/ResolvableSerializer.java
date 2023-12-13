package com.replaymod.lib.com.fasterxml.jackson.databind.ser;

import com.replaymod.lib.com.fasterxml.jackson.databind.JsonMappingException;
import com.replaymod.lib.com.fasterxml.jackson.databind.SerializerProvider;

public interface ResolvableSerializer {
   void resolve(SerializerProvider var1) throws JsonMappingException;
}
