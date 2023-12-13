package com.replaymod.lib.com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.replaymod.lib.com.fasterxml.jackson.core.JsonParser;

public interface JsonIntegerFormatVisitor extends JsonValueFormatVisitor {
   void numberType(JsonParser.NumberType var1);

   public static class Base extends JsonValueFormatVisitor.Base implements JsonIntegerFormatVisitor {
      public void numberType(JsonParser.NumberType type) {
      }
   }
}
