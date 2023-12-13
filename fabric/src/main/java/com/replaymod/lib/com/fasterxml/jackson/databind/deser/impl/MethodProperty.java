package com.replaymod.lib.com.fasterxml.jackson.databind.deser.impl;

import com.replaymod.lib.com.fasterxml.jackson.core.JsonParser;
import com.replaymod.lib.com.fasterxml.jackson.core.JsonToken;
import com.replaymod.lib.com.fasterxml.jackson.databind.DeserializationConfig;
import com.replaymod.lib.com.fasterxml.jackson.databind.DeserializationContext;
import com.replaymod.lib.com.fasterxml.jackson.databind.JavaType;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonDeserializer;
import com.replaymod.lib.com.fasterxml.jackson.databind.MapperFeature;
import com.replaymod.lib.com.fasterxml.jackson.databind.PropertyName;
import com.replaymod.lib.com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.replaymod.lib.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.replaymod.lib.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.replaymod.lib.com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.replaymod.lib.com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.replaymod.lib.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.replaymod.lib.com.fasterxml.jackson.databind.util.Annotations;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public final class MethodProperty extends SettableBeanProperty {
   private static final long serialVersionUID = 1L;
   protected final AnnotatedMethod _annotated;
   protected final transient Method _setter;
   protected final boolean _skipNulls;

   public MethodProperty(BeanPropertyDefinition propDef, JavaType type, TypeDeserializer typeDeser, Annotations contextAnnotations, AnnotatedMethod method) {
      super(propDef, type, typeDeser, contextAnnotations);
      this._annotated = method;
      this._setter = method.getAnnotated();
      this._skipNulls = NullsConstantProvider.isSkipper(this._nullProvider);
   }

   protected MethodProperty(MethodProperty src, JsonDeserializer<?> deser, NullValueProvider nva) {
      super(src, deser, nva);
      this._annotated = src._annotated;
      this._setter = src._setter;
      this._skipNulls = NullsConstantProvider.isSkipper(nva);
   }

   protected MethodProperty(MethodProperty src, PropertyName newName) {
      super(src, newName);
      this._annotated = src._annotated;
      this._setter = src._setter;
      this._skipNulls = src._skipNulls;
   }

   protected MethodProperty(MethodProperty src, Method m) {
      super(src);
      this._annotated = src._annotated;
      this._setter = m;
      this._skipNulls = src._skipNulls;
   }

   public SettableBeanProperty withName(PropertyName newName) {
      return new MethodProperty(this, newName);
   }

   public SettableBeanProperty withValueDeserializer(JsonDeserializer<?> deser) {
      return this._valueDeserializer == deser ? this : new MethodProperty(this, deser, this._nullProvider);
   }

   public SettableBeanProperty withNullProvider(NullValueProvider nva) {
      return new MethodProperty(this, this._valueDeserializer, nva);
   }

   public void fixAccess(DeserializationConfig config) {
      this._annotated.fixAccess(config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
   }

   public <A extends Annotation> A getAnnotation(Class<A> acls) {
      return this._annotated == null ? null : this._annotated.getAnnotation(acls);
   }

   public AnnotatedMember getMember() {
      return this._annotated;
   }

   public void deserializeAndSet(JsonParser p, DeserializationContext ctxt, Object instance) throws IOException {
      Object value;
      if (p.hasToken(JsonToken.VALUE_NULL)) {
         if (this._skipNulls) {
            return;
         }

         value = this._nullProvider.getNullValue(ctxt);
      } else if (this._valueTypeDeserializer == null) {
         value = this._valueDeserializer.deserialize(p, ctxt);
         if (value == null) {
            if (this._skipNulls) {
               return;
            }

            value = this._nullProvider.getNullValue(ctxt);
         }
      } else {
         value = this._valueDeserializer.deserializeWithType(p, ctxt, this._valueTypeDeserializer);
      }

      try {
         this._setter.invoke(instance, value);
      } catch (Exception var6) {
         this._throwAsIOE(p, var6, value);
      }

   }

   public Object deserializeSetAndReturn(JsonParser p, DeserializationContext ctxt, Object instance) throws IOException {
      Object value;
      if (p.hasToken(JsonToken.VALUE_NULL)) {
         if (this._skipNulls) {
            return instance;
         }

         value = this._nullProvider.getNullValue(ctxt);
      } else if (this._valueTypeDeserializer == null) {
         value = this._valueDeserializer.deserialize(p, ctxt);
         if (value == null) {
            if (this._skipNulls) {
               return instance;
            }

            value = this._nullProvider.getNullValue(ctxt);
         }
      } else {
         value = this._valueDeserializer.deserializeWithType(p, ctxt, this._valueTypeDeserializer);
      }

      try {
         Object result = this._setter.invoke(instance, value);
         return result == null ? instance : result;
      } catch (Exception var6) {
         this._throwAsIOE(p, var6, value);
         return null;
      }
   }

   public final void set(Object instance, Object value) throws IOException {
      try {
         this._setter.invoke(instance, value);
      } catch (Exception var4) {
         this._throwAsIOE(var4, value);
      }

   }

   public Object setAndReturn(Object instance, Object value) throws IOException {
      try {
         Object result = this._setter.invoke(instance, value);
         return result == null ? instance : result;
      } catch (Exception var4) {
         this._throwAsIOE(var4, value);
         return null;
      }
   }

   Object readResolve() {
      return new MethodProperty(this, this._annotated.getAnnotated());
   }
}
