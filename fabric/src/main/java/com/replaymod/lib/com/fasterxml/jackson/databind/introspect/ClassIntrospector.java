package com.replaymod.lib.com.fasterxml.jackson.databind.introspect;

import com.replaymod.lib.com.fasterxml.jackson.databind.BeanDescription;
import com.replaymod.lib.com.fasterxml.jackson.databind.DeserializationConfig;
import com.replaymod.lib.com.fasterxml.jackson.databind.JavaType;
import com.replaymod.lib.com.fasterxml.jackson.databind.SerializationConfig;
import com.replaymod.lib.com.fasterxml.jackson.databind.cfg.MapperConfig;

public abstract class ClassIntrospector {
   protected ClassIntrospector() {
   }

   public abstract ClassIntrospector copy();

   public abstract BeanDescription forSerialization(SerializationConfig var1, JavaType var2, ClassIntrospector.MixInResolver var3);

   public abstract BeanDescription forDeserialization(DeserializationConfig var1, JavaType var2, ClassIntrospector.MixInResolver var3);

   public abstract BeanDescription forDeserializationWithBuilder(DeserializationConfig var1, JavaType var2, ClassIntrospector.MixInResolver var3);

   public abstract BeanDescription forCreation(DeserializationConfig var1, JavaType var2, ClassIntrospector.MixInResolver var3);

   public abstract BeanDescription forClassAnnotations(MapperConfig<?> var1, JavaType var2, ClassIntrospector.MixInResolver var3);

   public abstract BeanDescription forDirectClassAnnotations(MapperConfig<?> var1, JavaType var2, ClassIntrospector.MixInResolver var3);

   public interface MixInResolver {
      Class<?> findMixInClassFor(Class<?> var1);

      ClassIntrospector.MixInResolver copy();
   }
}
