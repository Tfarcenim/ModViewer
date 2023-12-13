package com.replaymod.lib.com.fasterxml.jackson.databind.deser.impl;

import com.replaymod.lib.com.fasterxml.jackson.databind.BeanProperty;
import com.replaymod.lib.com.fasterxml.jackson.databind.DeserializationContext;
import com.replaymod.lib.com.fasterxml.jackson.databind.JavaType;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonMappingException;
import com.replaymod.lib.com.fasterxml.jackson.databind.PropertyMetadata;
import com.replaymod.lib.com.fasterxml.jackson.databind.PropertyName;
import com.replaymod.lib.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.replaymod.lib.com.fasterxml.jackson.databind.util.Annotations;
import java.io.IOException;

public class ValueInjector extends BeanProperty.Std {
   private static final long serialVersionUID = 1L;
   protected final Object _valueId;

   public ValueInjector(PropertyName propName, JavaType type, AnnotatedMember mutator, Object valueId) {
      super(propName, type, (PropertyName)null, mutator, PropertyMetadata.STD_OPTIONAL);
      this._valueId = valueId;
   }

   /** @deprecated */
   @Deprecated
   public ValueInjector(PropertyName propName, JavaType type, Annotations contextAnnotations, AnnotatedMember mutator, Object valueId) {
      this(propName, type, mutator, valueId);
   }

   public Object findValue(DeserializationContext context, Object beanInstance) throws JsonMappingException {
      return context.findInjectableValue(this._valueId, this, beanInstance);
   }

   public void inject(DeserializationContext context, Object beanInstance) throws IOException {
      this._member.setValue(beanInstance, this.findValue(context, beanInstance));
   }
}
