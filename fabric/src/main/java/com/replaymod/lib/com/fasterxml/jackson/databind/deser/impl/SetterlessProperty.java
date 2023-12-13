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

public final class SetterlessProperty extends SettableBeanProperty {
   private static final long serialVersionUID = 1L;
   protected final AnnotatedMethod _annotated;
   protected final Method _getter;

   public SetterlessProperty(BeanPropertyDefinition propDef, JavaType type, TypeDeserializer typeDeser, Annotations contextAnnotations, AnnotatedMethod method) {
      super(propDef, type, typeDeser, contextAnnotations);
      this._annotated = method;
      this._getter = method.getAnnotated();
   }

   protected SetterlessProperty(SetterlessProperty src, JsonDeserializer<?> deser, NullValueProvider nva) {
      super(src, deser, nva);
      this._annotated = src._annotated;
      this._getter = src._getter;
   }

   protected SetterlessProperty(SetterlessProperty src, PropertyName newName) {
      super(src, newName);
      this._annotated = src._annotated;
      this._getter = src._getter;
   }

   public SettableBeanProperty withName(PropertyName newName) {
      return new SetterlessProperty(this, newName);
   }

   public SettableBeanProperty withValueDeserializer(JsonDeserializer<?> deser) {
      return this._valueDeserializer == deser ? this : new SetterlessProperty(this, deser, this._nullProvider);
   }

   public SettableBeanProperty withNullProvider(NullValueProvider nva) {
      return new SetterlessProperty(this, this._valueDeserializer, nva);
   }

   public void fixAccess(DeserializationConfig config) {
      this._annotated.fixAccess(config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
   }

   public <A extends Annotation> A getAnnotation(Class<A> acls) {
      return this._annotated.getAnnotation(acls);
   }

   public AnnotatedMember getMember() {
      return this._annotated;
   }

   public final void deserializeAndSet(JsonParser p, DeserializationContext ctxt, Object instance) throws IOException {
      JsonToken t = p.getCurrentToken();
      if (t != JsonToken.VALUE_NULL) {
         if (this._valueTypeDeserializer != null) {
            ctxt.reportBadDefinition(this.getType(), String.format("Problem deserializing 'setterless' property (\"%s\"): no way to handle typed deser with setterless yet", this.getName()));
         }

         Object toModify;
         try {
            toModify = this._getter.invoke(instance, (Object[])null);
         } catch (Exception var7) {
            this._throwAsIOE(p, var7);
            return;
         }

         if (toModify == null) {
            ctxt.reportBadDefinition(this.getType(), String.format("Problem deserializing 'setterless' property '%s': get method returned null", this.getName()));
         }

         this._valueDeserializer.deserialize(p, ctxt, toModify);
      }
   }

   public Object deserializeSetAndReturn(JsonParser p, DeserializationContext ctxt, Object instance) throws IOException {
      this.deserializeAndSet(p, ctxt, instance);
      return instance;
   }

   public final void set(Object instance, Object value) throws IOException {
      throw new UnsupportedOperationException("Should never call `set()` on setterless property ('" + this.getName() + "')");
   }

   public Object setAndReturn(Object instance, Object value) throws IOException {
      this.set(instance, value);
      return instance;
   }
}
