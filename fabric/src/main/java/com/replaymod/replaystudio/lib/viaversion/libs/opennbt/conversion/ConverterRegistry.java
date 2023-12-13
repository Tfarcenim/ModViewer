package com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion;

import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.builtin.ByteArrayTagConverter;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.builtin.ByteTagConverter;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.builtin.CompoundTagConverter;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.builtin.DoubleTagConverter;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.builtin.FloatTagConverter;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.builtin.IntArrayTagConverter;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.builtin.IntTagConverter;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.builtin.ListTagConverter;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.builtin.LongArrayTagConverter;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.builtin.LongTagConverter;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.builtin.ShortTagConverter;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.conversion.builtin.StringTagConverter;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.ByteArrayTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.ByteTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.DoubleTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.FloatTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.IntArrayTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.IntTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.ListTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.LongArrayTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.LongTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.ShortTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.StringTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.Tag;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConverterRegistry {
   private static final Map<Class<? extends Tag>, TagConverter<? extends Tag, ?>> tagToConverter = new HashMap();
   private static final Map<Class<?>, TagConverter<? extends Tag, ?>> typeToConverter = new HashMap();

   public static <T extends Tag, V> void register(Class<T> tag, Class<V> type, TagConverter<T, V> converter) throws ConverterRegisterException {
      if (tagToConverter.containsKey(tag)) {
         throw new ConverterRegisterException("Type conversion to tag " + tag.getName() + " is already registered.");
      } else if (typeToConverter.containsKey(type)) {
         throw new ConverterRegisterException("Tag conversion to type " + type.getName() + " is already registered.");
      } else {
         tagToConverter.put(tag, converter);
         typeToConverter.put(type, converter);
      }
   }

   public static <T extends Tag, V> void unregister(Class<T> tag, Class<V> type) {
      tagToConverter.remove(tag);
      typeToConverter.remove(type);
   }

   public static <T extends Tag, V> V convertToValue(T tag) throws ConversionException {
      if (tag != null && tag.getValue() != null) {
         if (!tagToConverter.containsKey(tag.getClass())) {
            throw new ConversionException("Tag type " + tag.getClass().getName() + " has no converter.");
         } else {
            TagConverter<T, ?> converter = (TagConverter)tagToConverter.get(tag.getClass());
            return converter.convert(tag);
         }
      } else {
         return null;
      }
   }

   public static <V, T extends Tag> T convertToTag(V value) throws ConversionException {
      if (value == null) {
         return null;
      } else {
         TagConverter<T, V> converter = (TagConverter)typeToConverter.get(value.getClass());
         if (converter == null) {
            Iterator var2 = getAllClasses(value.getClass()).iterator();

            label31:
            while(true) {
               Class clazz;
               do {
                  if (!var2.hasNext()) {
                     break label31;
                  }

                  clazz = (Class)var2.next();
               } while(!typeToConverter.containsKey(clazz));

               try {
                  converter = (TagConverter)typeToConverter.get(clazz);
                  break;
               } catch (ClassCastException var5) {
               }
            }
         }

         if (converter == null) {
            throw new ConversionException("Value type " + value.getClass().getName() + " has no converter.");
         } else {
            return converter.convert(value);
         }
      }
   }

   private static Set<Class<?>> getAllClasses(Class<?> clazz) {
      Set<Class<?>> ret = new LinkedHashSet();

      for(Class c = clazz; c != null; c = c.getSuperclass()) {
         ret.add(c);
         ret.addAll(getAllSuperInterfaces(c));
      }

      if (ret.contains(Serializable.class)) {
         ret.remove(Serializable.class);
         ret.add(Serializable.class);
      }

      return ret;
   }

   private static Set<Class<?>> getAllSuperInterfaces(Class<?> clazz) {
      Set<Class<?>> ret = new HashSet();
      Class[] var2 = clazz.getInterfaces();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Class<?> c = var2[var4];
         ret.add(c);
         ret.addAll(getAllSuperInterfaces(c));
      }

      return ret;
   }

   static {
      register(ByteTag.class, Byte.class, new ByteTagConverter());
      register(ShortTag.class, Short.class, new ShortTagConverter());
      register(IntTag.class, Integer.class, new IntTagConverter());
      register(LongTag.class, Long.class, new LongTagConverter());
      register(FloatTag.class, Float.class, new FloatTagConverter());
      register(DoubleTag.class, Double.class, new DoubleTagConverter());
      register(ByteArrayTag.class, byte[].class, new ByteArrayTagConverter());
      register(StringTag.class, String.class, new StringTagConverter());
      register(ListTag.class, List.class, new ListTagConverter());
      register(CompoundTag.class, Map.class, new CompoundTagConverter());
      register(IntArrayTag.class, int[].class, new IntArrayTagConverter());
      register(LongArrayTag.class, long[].class, new LongArrayTagConverter());
   }
}
