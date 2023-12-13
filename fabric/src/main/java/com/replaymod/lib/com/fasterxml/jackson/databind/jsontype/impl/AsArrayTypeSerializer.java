package com.replaymod.lib.com.fasterxml.jackson.databind.jsontype.impl;

import com.replaymod.lib.com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.replaymod.lib.com.fasterxml.jackson.databind.BeanProperty;
import com.replaymod.lib.com.fasterxml.jackson.databind.jsontype.TypeIdResolver;

public class AsArrayTypeSerializer extends TypeSerializerBase {
   public AsArrayTypeSerializer(TypeIdResolver idRes, BeanProperty property) {
      super(idRes, property);
   }

   public AsArrayTypeSerializer forProperty(BeanProperty prop) {
      return this._property == prop ? this : new AsArrayTypeSerializer(this._idResolver, prop);
   }

   public JsonTypeInfo.As getTypeInclusion() {
      return JsonTypeInfo.As.WRAPPER_ARRAY;
   }
}
