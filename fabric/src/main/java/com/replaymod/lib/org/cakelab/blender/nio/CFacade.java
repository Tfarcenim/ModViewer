package com.replaymod.lib.org.cakelab.blender.nio;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteOrder;

public abstract class CFacade {
   protected long __io__address;
   protected BlockTable __io__blockTable;
   protected Block __io__block;
   protected int __io__arch_index;
   protected int __io__pointersize;

   protected CFacade(long __address, Block block, BlockTable __blockTable) {
      this.__io__address = __address;
      this.__io__block = block;
      this.__io__blockTable = __blockTable;
      this.__io__pointersize = __blockTable.getEncoding().getAddressWidth();
      this.__io__arch_index = this.__io__pointersize == 4 ? 0 : 1;
   }

   protected CFacade(CFacade other, long targetAddress) {
      this.__io__address = targetAddress;
      this.__io__block = other.__io__block;
      this.__io__blockTable = other.__io__blockTable;
      this.__io__arch_index = other.__io__arch_index;
   }

   public long __io__sizeof(Class<?> type) {
      return __io__sizeof(type, this.__io__pointersize);
   }

   public static long __io__sizeof(Class<?> type, int addressWidth) {
      if (type.equals(CPointer.class)) {
         return (long)addressWidth;
      } else if (type.equals(CArrayFacade.class)) {
         throw new IllegalArgumentException("no generic runtime type information for array types available");
      } else if (__io__subclassof(type, CFacade.class)) {
         CMetaData typeInfo = (CMetaData)type.getAnnotation(CMetaData.class);
         return addressWidth == 8 ? typeInfo.size64() : typeInfo.size32();
      } else if (!type.equals(Byte.TYPE) && !type.equals(Byte.class)) {
         if (!type.equals(Short.TYPE) && !type.equals(Short.class)) {
            if (!type.equals(Integer.TYPE) && !type.equals(Integer.class)) {
               if (!type.equals(Long.TYPE) && !type.equals(Long.class)) {
                  if (type.equals(int64.class)) {
                     return 8L;
                  } else if (!type.equals(Float.TYPE) && !type.equals(Float.class)) {
                     if (!type.equals(Double.TYPE) && !type.equals(Double.class)) {
                        if (type.equals(Object.class)) {
                           return 0L;
                        } else {
                           throw new IllegalArgumentException("missing size information for type '" + type.getSimpleName() + "'");
                        }
                     } else {
                        return 8L;
                     }
                  } else {
                     return 4L;
                  }
               } else {
                  return (long)addressWidth;
               }
            } else {
               return 4L;
            }
         } else {
            return 2L;
         }
      } else {
         return 1L;
      }
   }

   public static <T extends CFacade> CPointer<T> __io__addressof(T object) {
      return new CPointer(object.__io__address, new Class[]{object.getClass()}, object.__io__block, object.__io__blockTable);
   }

   public CPointer<Object> __io__addressof(long[] fieldDescriptor) {
      return new CPointer(this.__io__address + fieldDescriptor[this.__io__arch_index], new Class[]{Object.class}, this.__io__block, this.__io__blockTable);
   }

   public static boolean __io__subclassof(Class<?> type, Class<?> superType) {
      Class<?> superClass = type.getSuperclass();
      if (superClass != null && !superClass.equals(Object.class)) {
         return superClass.equals(superType) ? true : __io__subclassof(superClass, superType);
      } else {
         return false;
      }
   }

   public static boolean __io__instanceof(CFacade object, Class<?> clazz) {
      Class<?> testClass = object.getClass();
      return testClass.equals(clazz) ? true : __io__subclassof(testClass, clazz);
   }

   public static CFacade __io__newInstance(Class<? extends CFacade> type, long address, Block block, BlockTable blockTable) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
      Constructor<?> constructor = type.getDeclaredConstructor(Long.TYPE, Block.class, BlockTable.class);
      return (CFacade)constructor.newInstance(address, block, blockTable);
   }

   static CFacade __io__newInstance(Constructor<?> constructor, Class<? extends CFacade> type, long address, Block block, BlockTable blockTable) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
      return (CFacade)constructor.newInstance(address, block, blockTable);
   }

   protected boolean __io__equals(CFacade facade, long address) {
      return facade.__io__block == this.__io__block && facade.__io__address == address;
   }

   protected static void __io__native__copy(Block targetBlock, long targetAddress, CFacade source) throws IOException {
      assert targetBlock.contains(targetAddress);

      int size;
      if (source instanceof CArrayFacade) {
         size = (int)((CArrayFacade)source).sizeof();
      } else {
         size = (int)source.__io__sizeof(source.getClass());
      }

      byte[] buffer = new byte[size];
      source.__io__block.readFully(source.__io__address, buffer);
      targetBlock.writeFully(targetAddress, buffer);
   }

   protected void __io__generic__copy(CFacade source) throws IOException {
      Class clazz = source.getClass();

      try {
         Method[] var3 = clazz.getDeclaredMethods();
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            Method getter = var3[var5];
            if (getter.getName().startsWith("get")) {
               String setterName = getter.getName().replaceFirst("g", "s");
               Method setter = clazz.getDeclaredMethod(setterName, getter.getReturnType());
               setter.invoke(this, getter.invoke(source));
            }
         }

      } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException var9) {
         throw new IOException("unexpected case", var9);
      }
   }

   protected static void __io__generic__copy(CFacade target, CFacade source) throws IOException {
      target.__io__generic__copy(source);
   }

   protected boolean __io__same__encoding(CFacade facadeA, CFacade facadeB) {
      return facadeA.__io__pointersize == facadeB.__io__pointersize && facadeA.__io__byteorder() == facadeB.__io__byteorder();
   }

   private ByteOrder __io__byteorder() {
      return this.__io__blockTable.getEncoding().getByteOrder();
   }
}
