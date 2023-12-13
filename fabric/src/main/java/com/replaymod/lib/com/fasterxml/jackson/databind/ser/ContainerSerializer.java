package com.replaymod.lib.com.fasterxml.jackson.databind.ser;

import com.replaymod.lib.com.fasterxml.jackson.databind.BeanProperty;
import com.replaymod.lib.com.fasterxml.jackson.databind.JavaType;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonSerializer;
import com.replaymod.lib.com.fasterxml.jackson.databind.SerializerProvider;
import com.replaymod.lib.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.replaymod.lib.com.fasterxml.jackson.databind.ser.std.StdSerializer;

public abstract class ContainerSerializer<T> extends StdSerializer<T> {
   protected ContainerSerializer(Class<T> t) {
      super(t);
   }

   protected ContainerSerializer(JavaType fullType) {
      super(fullType);
   }

   protected ContainerSerializer(Class<?> t, boolean dummy) {
      super(t, dummy);
   }

   protected ContainerSerializer(ContainerSerializer<?> src) {
      super(src._handledType, false);
   }

   public ContainerSerializer<?> withValueTypeSerializer(TypeSerializer vts) {
      return vts == null ? this : this._withValueTypeSerializer(vts);
   }

   public abstract JavaType getContentType();

   public abstract JsonSerializer<?> getContentSerializer();

   public abstract boolean hasSingleElement(T var1);

   protected abstract ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer var1);

   /** @deprecated */
   @Deprecated
   protected boolean hasContentTypeAnnotation(SerializerProvider provider, BeanProperty property) {
      return false;
   }
}
