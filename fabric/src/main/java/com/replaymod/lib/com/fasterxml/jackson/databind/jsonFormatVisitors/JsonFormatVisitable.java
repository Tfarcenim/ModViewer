package com.replaymod.lib.com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.replaymod.lib.com.fasterxml.jackson.databind.JavaType;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonMappingException;

public interface JsonFormatVisitable {
   void acceptJsonFormatVisitor(JsonFormatVisitorWrapper var1, JavaType var2) throws JsonMappingException;
}
