package com.replaymod.lib.com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.replaymod.lib.com.fasterxml.jackson.databind.SerializerProvider;

public interface JsonFormatVisitorWithSerializerProvider {
   SerializerProvider getProvider();

   void setProvider(SerializerProvider var1);
}
