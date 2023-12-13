package com.replaymod.lib.org.cakelab.json.codec;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class UnsafeAllocator {
   public abstract <T> T newInstance(Class<T> var1) throws InstantiationException;

   public static UnsafeAllocator create() {
      try {
         Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
         Field f = unsafeClass.getDeclaredField("theUnsafe");
         f.setAccessible(true);
         final Object unsafe = f.get((Object)null);
         final Method allocateInstance = unsafeClass.getMethod("allocateInstance", Class.class);
         return new UnsafeAllocator() {
            public <T> T newInstance(Class<T> c) throws InstantiationException {
               Object o = null;

               try {
                  o = allocateInstance.invoke(unsafe, c);
                  return o;
               } catch (Exception var4) {
                  throw new InstantiationException(var4.toString());
               }
            }
         };
      } catch (Exception var6) {
         final Method getConstructorId;
         try {
            getConstructorId = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
            getConstructorId.setAccessible(true);
            return new UnsafeAllocator() {
               public <T> T newInstance(Class<T> c) throws InstantiationException {
                  Object o = null;

                  try {
                     o = getConstructorId.invoke((Object)null, c, Object.class);
                     return o;
                  } catch (Exception var4) {
                     throw new InstantiationException(var4.toString());
                  }
               }
            };
         } catch (Exception var5) {
            try {
               getConstructorId = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
               getConstructorId.setAccessible(true);
               final int constructorId = (Integer)getConstructorId.invoke((Object)null, Object.class);
               final Method newInstance = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
               newInstance.setAccessible(true);
               return new UnsafeAllocator() {
                  public <T> T newInstance(Class<T> c) throws InstantiationException {
                     try {
                        return newInstance.invoke((Object)null, c, constructorId);
                     } catch (Exception var3) {
                        throw new InstantiationException(var3.toString());
                     }
                  }
               };
            } catch (Exception var4) {
               return new UnsafeAllocator() {
                  public <T> T newInstance(Class<T> c) {
                     throw new UnsupportedOperationException("Cannot allocate " + c);
                  }
               };
            }
         }
      }
   }
}
