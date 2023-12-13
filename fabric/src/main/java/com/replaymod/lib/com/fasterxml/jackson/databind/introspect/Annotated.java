package com.replaymod.lib.com.fasterxml.jackson.databind.introspect;

import com.replaymod.lib.com.fasterxml.jackson.databind.JavaType;
import com.replaymod.lib.com.fasterxml.jackson.databind.type.TypeBindings;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public abstract class Annotated {
   protected Annotated() {
   }

   public abstract <A extends Annotation> A getAnnotation(Class<A> var1);

   public abstract boolean hasAnnotation(Class<?> var1);

   public abstract boolean hasOneOf(Class<? extends Annotation>[] var1);

   public abstract AnnotatedElement getAnnotated();

   protected abstract int getModifiers();

   public boolean isPublic() {
      return Modifier.isPublic(this.getModifiers());
   }

   public abstract String getName();

   public abstract JavaType getType();

   /** @deprecated */
   @Deprecated
   public final JavaType getType(TypeBindings bogus) {
      return this.getType();
   }

   /** @deprecated */
   @Deprecated
   public Type getGenericType() {
      return this.getRawType();
   }

   public abstract Class<?> getRawType();

   /** @deprecated */
   @Deprecated
   public abstract Iterable<Annotation> annotations();

   public abstract boolean equals(Object var1);

   public abstract int hashCode();

   public abstract String toString();
}
