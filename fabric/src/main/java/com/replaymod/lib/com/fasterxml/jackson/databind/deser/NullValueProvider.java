package com.replaymod.lib.com.fasterxml.jackson.databind.deser;

import com.replaymod.lib.com.fasterxml.jackson.databind.DeserializationContext;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonMappingException;
import com.replaymod.lib.com.fasterxml.jackson.databind.util.AccessPattern;

public interface NullValueProvider {
   Object getNullValue(DeserializationContext var1) throws JsonMappingException;

   AccessPattern getNullAccessPattern();
}
