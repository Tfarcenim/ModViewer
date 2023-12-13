package com.replaymod.lib.org.cakelab.json.codec;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class ReflectionHelper {
   private static HashMap<Class<?>, Vector<Field>> fieldLists = new HashMap();
   private static HashMap<Class<?>, HashMap<String, Field>> fieldMaps = new HashMap();

   public static List<Field> getDeclaredFields(Class<?> type) {
      Vector<Field> fields = (Vector)fieldLists.get(type);
      if (fields == null) {
         fields = new Vector();
         if (!type.equals(Object.class)) {
            List<Field> superFields = getDeclaredFields(type.getSuperclass());
            fields.addAll(superFields);
         }

         Field[] var6 = type.getDeclaredFields();
         int var3 = var6.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            Field f = var6[var4];
            fields.add(f);
         }

         fieldLists.put(type, fields);
      }

      return fields;
   }

   public static HashMap<String, Field> getDeclaredFieldsMap(Class<?> type) {
      HashMap<String, Field> map = (HashMap)fieldMaps.get(type);
      if (map == null) {
         map = new HashMap();
         if (!type.equals(Object.class)) {
            HashMap<String, Field> superFields = getDeclaredFieldsMap(type.getSuperclass());
            map.putAll(superFields);
         }

         Field[] var6 = type.getDeclaredFields();
         int var3 = var6.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            Field f = var6[var4];
            map.put(f.getName(), f);
         }

         fieldMaps.put(type, map);
      }

      return map;
   }

   public static boolean isPrimitive(Class<?> type) {
      return type.isPrimitive() || type.equals(String.class) || type.equals(Long.class) || type.equals(Integer.class) || type.equals(Short.class) || type.equals(Double.class) || type.equals(Float.class) || type.equals(Byte.class) || type.equals(Character.class) || type.equals(Boolean.class);
   }

   public static Field getDeclaredField(Class<? extends Object> class1, String name) throws NoSuchFieldException {
      Field f = null;

      try {
         f = class1.getDeclaredField(name);
         return f;
      } catch (NoSuchFieldException var4) {
         if (!class1.getSuperclass().equals(Object.class)) {
            return getDeclaredField(class1.getSuperclass(), name);
         } else {
            throw var4;
         }
      }
   }

   public static void checkParameter(Method method, int param, Field field, Class<?> paramType) throws JSONCodecException {
      Class<?>[] params = method.getParameterTypes();
      if (params.length < param + 1) {
         throw new JSONCodecException(method.getDeclaringClass() + "." + method.getName() + "(): needs a " + param + ". parameter");
      } else if (!params[param].equals(paramType)) {
         throw new JSONCodecException(method.getDeclaringClass() + "." + method.getName() + "(): " + Integer.toString(param + 1) + ". parameter must have type " + paramType.getSimpleName());
      }
   }

   public static Method findMethod(Class<?> target, String methodName, Class<?>[] params) throws JSONCodecException {
      Method method = null;

      try {
         return target.getMethod(methodName, params);
      } catch (Exception var9) {
         Method[] var5 = target.getDeclaredMethods();
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            Method m = var5[var7];
            if (m.getName().equals(methodName)) {
               method = m;
               break;
            }
         }

         if (method == null) {
            throw new JSONCodecException(target.getName() + '.' + methodName + "(): not found");
         } else {
            return method;
         }
      }
   }

   public static boolean isSubclassOf(Class<?> derived, Class<?> superclass) {
      if (derived.equals(superclass)) {
         return true;
      } else if (derived.equals(Object.class)) {
         return false;
      } else {
         Class[] var2 = derived.getInterfaces();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            Class<?> interf = var2[var4];
            if (isSubclassOf(interf, superclass)) {
               return true;
            }
         }

         return isSubclassOf(derived.getSuperclass(), superclass);
      }
   }
}
