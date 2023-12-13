package com.replaymod.lib.com.fasterxml.jackson.databind.introspect;

import com.replaymod.lib.com.fasterxml.jackson.databind.JavaType;
import com.replaymod.lib.com.fasterxml.jackson.databind.type.TypeBindings;
import com.replaymod.lib.com.fasterxml.jackson.databind.type.TypeFactory;
import java.lang.reflect.Type;

public interface TypeResolutionContext {
   JavaType resolveType(Type var1);

   public static class Basic implements TypeResolutionContext {
      private final TypeFactory _typeFactory;
      private final TypeBindings _bindings;

      public Basic(TypeFactory tf, TypeBindings b) {
         this._typeFactory = tf;
         this._bindings = b;
      }

      public JavaType resolveType(Type type) {
         return this._typeFactory.constructType(type, this._bindings);
      }
   }
}
