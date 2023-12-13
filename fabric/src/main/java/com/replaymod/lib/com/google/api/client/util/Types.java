package com.replaymod.lib.com.google.api.client.util;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Types {
   public static ParameterizedType getSuperParameterizedType(Type type, Class<?> superClass) {
      if (type instanceof Class || type instanceof ParameterizedType) {
         label45:
         while(type != null && type != Object.class) {
            Class rawType;
            if (type instanceof Class) {
               rawType = (Class)type;
            } else {
               ParameterizedType parameterizedType = (ParameterizedType)type;
               rawType = getRawClass(parameterizedType);
               if (rawType == superClass) {
                  return parameterizedType;
               }

               if (superClass.isInterface()) {
                  Type[] arr$ = rawType.getGenericInterfaces();
                  int len$ = arr$.length;

                  for(int i$ = 0; i$ < len$; ++i$) {
                     Type interfaceType = arr$[i$];
                     Class<?> interfaceClass = interfaceType instanceof Class ? (Class)interfaceType : getRawClass((ParameterizedType)interfaceType);
                     if (superClass.isAssignableFrom(interfaceClass)) {
                        type = interfaceType;
                        continue label45;
                     }
                  }
               }
            }

            type = rawType.getGenericSuperclass();
         }
      }

      return null;
   }

   public static boolean isAssignableToOrFrom(Class<?> classToCheck, Class<?> anotherClass) {
      return classToCheck.isAssignableFrom(anotherClass) || anotherClass.isAssignableFrom(classToCheck);
   }

   public static <T> T newInstance(Class<T> clazz) {
      try {
         return clazz.newInstance();
      } catch (IllegalAccessException var2) {
         throw handleExceptionForNewInstance(var2, clazz);
      } catch (InstantiationException var3) {
         throw handleExceptionForNewInstance(var3, clazz);
      }
   }

   private static IllegalArgumentException handleExceptionForNewInstance(Exception e, Class<?> clazz) {
      StringBuilder buf = (new StringBuilder("unable to create new instance of class ")).append(clazz.getName());
      ArrayList<String> reasons = new ArrayList();
      if (clazz.isArray()) {
         reasons.add("because it is an array");
      } else if (clazz.isPrimitive()) {
         reasons.add("because it is primitive");
      } else if (clazz == Void.class) {
         reasons.add("because it is void");
      } else {
         if (Modifier.isInterface(clazz.getModifiers())) {
            reasons.add("because it is an interface");
         } else if (Modifier.isAbstract(clazz.getModifiers())) {
            reasons.add("because it is abstract");
         }

         if (clazz.getEnclosingClass() != null && !Modifier.isStatic(clazz.getModifiers())) {
            reasons.add("because it is not static");
         }

         if (!Modifier.isPublic(clazz.getModifiers())) {
            reasons.add("possibly because it is not public");
         } else {
            try {
               clazz.getConstructor();
            } catch (NoSuchMethodException var7) {
               reasons.add("because it has no accessible default constructor");
            }
         }
      }

      boolean and = false;

      String reason;
      for(Iterator i$ = reasons.iterator(); i$.hasNext(); buf.append(" ").append(reason)) {
         reason = (String)i$.next();
         if (and) {
            buf.append(" and");
         } else {
            and = true;
         }
      }

      return new IllegalArgumentException(buf.toString(), e);
   }

   public static boolean isArray(Type type) {
      return type instanceof GenericArrayType || type instanceof Class && ((Class)type).isArray();
   }

   public static Type getArrayComponentType(Type array) {
      return (Type)(array instanceof GenericArrayType ? ((GenericArrayType)array).getGenericComponentType() : ((Class)array).getComponentType());
   }

   public static Class<?> getRawClass(ParameterizedType parameterType) {
      return (Class)parameterType.getRawType();
   }

   public static Type getBound(WildcardType wildcardType) {
      Type[] lowerBounds = wildcardType.getLowerBounds();
      return lowerBounds.length != 0 ? lowerBounds[0] : wildcardType.getUpperBounds()[0];
   }

   public static Type resolveTypeVariable(List<Type> context, TypeVariable<?> typeVariable) {
      GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
      if (genericDeclaration instanceof Class) {
         Class<?> rawGenericDeclaration = (Class)genericDeclaration;
         int contextIndex = context.size();

         ParameterizedType parameterizedType;
         for(parameterizedType = null; parameterizedType == null; parameterizedType = getSuperParameterizedType((Type)context.get(contextIndex), rawGenericDeclaration)) {
            --contextIndex;
            if (contextIndex < 0) {
               break;
            }
         }

         if (parameterizedType != null) {
            TypeVariable<?>[] typeParameters = genericDeclaration.getTypeParameters();

            int index;
            for(index = 0; index < typeParameters.length; ++index) {
               TypeVariable<?> typeParameter = typeParameters[index];
               if (typeParameter.equals(typeVariable)) {
                  break;
               }
            }

            Type result = parameterizedType.getActualTypeArguments()[index];
            if (result instanceof TypeVariable) {
               Type resolve = resolveTypeVariable(context, (TypeVariable)result);
               if (resolve != null) {
                  return resolve;
               }
            }

            return result;
         }
      }

      return null;
   }

   public static Class<?> getRawArrayComponentType(List<Type> context, Type componentType) {
      if (componentType instanceof TypeVariable) {
         componentType = resolveTypeVariable(context, (TypeVariable)componentType);
      }

      if (componentType instanceof GenericArrayType) {
         Class<?> raw = getRawArrayComponentType(context, getArrayComponentType(componentType));
         return Array.newInstance(raw, 0).getClass();
      } else if (componentType instanceof Class) {
         return (Class)componentType;
      } else if (componentType instanceof ParameterizedType) {
         return getRawClass((ParameterizedType)componentType);
      } else {
         Preconditions.checkArgument(componentType == null, "wildcard type is not supported: %s", componentType);
         return Object.class;
      }
   }

   public static Type getIterableParameter(Type iterableType) {
      return getActualParameterAtPosition(iterableType, Iterable.class, 0);
   }

   public static Type getMapValueParameter(Type mapType) {
      return getActualParameterAtPosition(mapType, Map.class, 1);
   }

   private static Type getActualParameterAtPosition(Type type, Class<?> superClass, int position) {
      ParameterizedType parameterizedType = getSuperParameterizedType(type, superClass);
      if (parameterizedType == null) {
         return null;
      } else {
         Type valueType = parameterizedType.getActualTypeArguments()[position];
         if (valueType instanceof TypeVariable) {
            Type resolve = resolveTypeVariable(Arrays.asList(type), (TypeVariable)valueType);
            if (resolve != null) {
               return resolve;
            }
         }

         return valueType;
      }
   }

   public static <T> Iterable<T> iterableOf(Object value) {
      if (value instanceof Iterable) {
         return (Iterable)value;
      } else {
         Class<?> valueClass = value.getClass();
         Preconditions.checkArgument(valueClass.isArray(), "not an array or Iterable: %s", valueClass);
         Class<?> subClass = valueClass.getComponentType();
         return (Iterable)(!subClass.isPrimitive() ? Arrays.asList((Object[])((Object[])value)) : new Iterable<T>() {
            public Iterator<T> iterator() {
               return new Iterator<T>() {
                  final int length = Array.getLength(value);
                  int index = 0;

                  public boolean hasNext() {
                     return this.index < this.length;
                  }

                  public T next() {
                     if (!this.hasNext()) {
                        throw new NoSuchElementException();
                     } else {
                        return Array.get(value, this.index++);
                     }
                  }

                  public void remove() {
                     throw new UnsupportedOperationException();
                  }
               };
            }
         });
      }
   }

   public static Object toArray(Collection<?> collection, Class<?> componentType) {
      if (!componentType.isPrimitive()) {
         return collection.toArray((Object[])((Object[])Array.newInstance(componentType, collection.size())));
      } else {
         Object array = Array.newInstance(componentType, collection.size());
         int index = 0;
         Iterator i$ = collection.iterator();

         while(i$.hasNext()) {
            Object value = i$.next();
            Array.set(array, index++, value);
         }

         return array;
      }
   }

   private Types() {
   }
}
