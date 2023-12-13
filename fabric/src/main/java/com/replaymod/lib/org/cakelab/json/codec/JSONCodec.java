package com.replaymod.lib.org.cakelab.json.codec;

import com.replaymod.lib.org.cakelab.json.JSONArray;
import com.replaymod.lib.org.cakelab.json.JSONCompoundType;
import com.replaymod.lib.org.cakelab.json.JSONException;
import com.replaymod.lib.org.cakelab.json.JSONObject;
import com.replaymod.lib.org.cakelab.json.JSONPrettyprint;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map.Entry;

public class JSONCodec {
   private static JSONCodecConfiguration defaultConfig;
   private static JSONStringFormatter formatterFactory = new JSONPrettyprint();
   private UnsafeAllocator allocator;
   private JSONCodecConfiguration cfg;

   public static void setDefaultConfiguration(JSONCodecConfiguration config) {
      defaultConfig = config;
   }

   public static JSONStringFormatter getDefaultStringFormatter() {
      return formatterFactory.create(defaultConfig.format);
   }

   public JSONCodec() {
      this(defaultConfig);
   }

   public JSONCodec(JSONCodecConfiguration config) {
      this.allocator = UnsafeAllocator.create();
      this.cfg = config;
   }

   /** @deprecated */
   public JSONCodec(Charset charset, boolean ignoreNull, boolean ignoreMissingFields) {
      this.allocator = UnsafeAllocator.create();
      this.cfg = new JSONCodecConfiguration();
      this.cfg.charset = charset;
      this.cfg.ignoreNull = ignoreNull;
      this.cfg.ignoreMissingFields = ignoreMissingFields;
   }

   /** @deprecated */
   public JSONCodec(boolean ignoreNull, boolean ignoreMissingFields) {
      this(Charset.defaultCharset(), ignoreNull, ignoreMissingFields);
   }

   /** @deprecated */
   public JSONCodec(Charset charset, boolean ignoreNull) {
      this(charset, ignoreNull, false);
   }

   /** @deprecated */
   public JSONCodec(boolean ignoreNull) {
      this(Charset.defaultCharset(), ignoreNull, false);
   }

   public Object decodeObject(String jsonString, Object target) throws JSONCodecException {
      try {
         Parser parser = new Parser(jsonString);
         JSONObject json = parser.parse();
         return this._decodeObject(json, (Object)target);
      } catch (JSONCodecException var5) {
         throw var5;
      } catch (Exception var6) {
         throw new JSONCodecException(var6);
      }
   }

   public Object decodeObject(InputStream inputStream, Object target) throws JSONCodecException {
      try {
         Parser parser = new Parser(inputStream, this.cfg.charset);
         JSONObject json = parser.parse();
         return this._decodeObject(json, (Object)target);
      } catch (JSONCodecException var5) {
         throw var5;
      } catch (Exception var6) {
         throw new JSONCodecException(var6);
      }
   }

   public Object decodeObject(InputStream inputStream, Class<?> target) throws JSONCodecException {
      try {
         Parser parser = new Parser(inputStream, this.cfg.charset);
         JSONObject json = parser.parse();
         return this._decodeObject(json, (Class)target);
      } catch (JSONCodecException var5) {
         throw var5;
      } catch (Exception var6) {
         throw new JSONCodecException(var6);
      }
   }

   public Object decodeObject(String jsonString, Class<?> type) throws JSONCodecException {
      try {
         Parser parser = new Parser(jsonString, this.cfg.ignoreNull);
         JSONObject json = parser.parse();
         return this._decodeObject(json, (Class)type);
      } catch (JSONCodecException var5) {
         throw var5;
      } catch (Exception var6) {
         throw new JSONCodecException(var6);
      }
   }

   public Object decodeObject(JSONObject json, Class<?> clazz) throws JSONCodecException {
      try {
         return this._decodeObject(json, (Class)clazz);
      } catch (InstantiationException var4) {
         throw new JSONCodecException(var4);
      }
   }

   private Object _decodeObject(Object json, Object target) throws JSONCodecException {
      if (json instanceof JSONObject) {
         return this.json2object((JSONObject)json, target);
      } else {
         return json instanceof JSONArray ? this.json2array((JSONArray)json, target) : this.json2primitive(json.toString(), target.getClass());
      }
   }

   private Object _decodeObject(Object json, Class<?> type) throws JSONCodecException, InstantiationException {
      if (json == null) {
         return null;
      } else if (json instanceof JSONObject) {
         if (this.cfg.considerClassAttribute) {
            String clazz = ((JSONObject)json).getString("class");
            if (clazz != null) {
               try {
                  Class<?> derived = JSONCodec.class.getClassLoader().loadClass(clazz);
                  if (!ReflectionHelper.isSubclassOf(derived, type)) {
                     throw new JSONCodecException("class " + clazz + " is not a subclass of " + type.getSimpleName());
                  }

                  type = derived;
               } catch (ClassNotFoundException var5) {
                  throw new JSONCodecException(var5);
               }
            }
         }

         return this.json2object((JSONObject)json, this.allocator.newInstance(type));
      } else {
         return json instanceof JSONArray ? this.json2array((JSONArray)json, Array.newInstance(type.getComponentType(), ((JSONArray)json).size())) : this.json2primitive(json.toString(), type);
      }
   }

   private Object json2object(JSONObject json, Object target) throws JSONCodecException {
      Class type = target.getClass();

      try {
         Iterator var4 = json.entrySet().iterator();

         while(var4.hasNext()) {
            Entry e = (Entry)var4.next();

            try {
               if (!this.cfg.considerClassAttribute || !((String)e.getKey()).equals("class")) {
                  Field field = ReflectionHelper.getDeclaredField(type, (String)e.getKey());
                  if (!this.isIgnoredField(field)) {
                     boolean accessible = field.isAccessible();
                     field.setAccessible(true);
                     if (ReflectionHelper.isPrimitive(field.getType())) {
                        field.set(target, this.json2primitive(e.getValue().toString(), field.getType()));
                     } else {
                        field.set(target, this._decodeObject(e.getValue(), field.getType()));
                     }

                     field.setAccessible(accessible);
                  }
               }
            } catch (NoSuchFieldException var8) {
               if (!this.cfg.ignoreMissingFields) {
                  throw new JSONCodecException(var8);
               }
            }
         }

         return target;
      } catch (IllegalAccessException | InstantiationException | IllegalArgumentException var9) {
         throw new JSONCodecException(var9);
      }
   }

   private Object json2array(JSONArray json, Object target) throws JSONCodecException {
      try {
         for(int i = 0; i < json.size(); ++i) {
            Object jsonValue = json.get(i);
            Object value = this._decodeObject(jsonValue, target.getClass().getComponentType());
            Array.set(target, i, value);
         }

         return target;
      } catch (InstantiationException var6) {
         throw new JSONCodecException(var6);
      }
   }

   private Object json2primitive(String body, Class<?> type) {
      if (type.equals(String.class)) {
         return body;
      } else if (type.equals(Character.class)) {
         body = body.trim();
         return body.length() > 0 ? body.charAt(0) : null;
      } else if (!type.equals(Long.class) && !type.equals(Long.TYPE)) {
         if (!type.equals(Integer.class) && !type.equals(Integer.TYPE)) {
            if (!type.equals(Double.class) && !type.equals(Double.TYPE)) {
               if (!type.equals(Float.class) && !type.equals(Float.TYPE)) {
                  if (!type.equals(Short.class) && !type.equals(Short.TYPE)) {
                     if (!type.equals(Byte.class) && !type.equals(Byte.TYPE)) {
                        return !type.equals(Boolean.class) && !type.equals(Boolean.TYPE) ? null : Boolean.parseBoolean(body);
                     } else {
                        return Byte.parseByte(body);
                     }
                  } else {
                     return Short.parseShort(body);
                  }
               } else {
                  return Float.parseFloat(body);
               }
            } else {
               return Double.parseDouble(body);
            }
         } else {
            return Integer.decode(body);
         }
      } else {
         return Long.decode(body);
      }
   }

   public String encodeObject(Object o) throws JSONCodecException {
      if (o == null) {
         throw new JSONCodecException("Cannot encode a toplevel null object");
      } else {
         try {
            Object json;
            if (o instanceof JSONCompoundType) {
               json = o;
            } else {
               json = this.encodeObjectJSON(o, (Class)null);
            }

            return json instanceof JSONCompoundType ? ((JSONCompoundType)json).toString(this.getFormatter()) : json.toString();
         } catch (Exception var4) {
            throw new JSONCodecException(var4);
         }
      }
   }

   private JSONStringFormatter getFormatter() {
      return formatterFactory.create(this.cfg.format);
   }

   public void encodeObject(Object o, OutputStream out) throws JSONCodecException {
      if (o == null) {
         throw new JSONCodecException("Cannot encode a toplevel null object");
      } else {
         try {
            String str = this.encodeObject(o);
            byte[] bytes = str.getBytes();
            out.write(bytes);
         } catch (Exception var5) {
            throw new JSONCodecException(var5);
         }
      }
   }

   public Object encodeObjectJSON(Object o, Class<?> referenceType) throws JSONCodecException {
      try {
         if (ReflectionHelper.isPrimitive(o.getClass())) {
            return this.primitive2json(o);
         } else {
            return o.getClass().isArray() ? this.array2json(o) : this.object2json(o, referenceType);
         }
      } catch (JSONCodecException var4) {
         throw var4;
      } catch (Exception var5) {
         throw new JSONCodecException(var5);
      }
   }

   public Object encodeObjectJSON(Object o) throws JSONCodecException {
      return this.encodeObjectJSON(o, o.getClass());
   }

   private Object primitive2json(Object o) {
      return o;
   }

   private JSONObject object2json(Object o, Class<?> referenceType) throws JSONCodecException, IllegalArgumentException, IllegalAccessException {
      JSONObject json = new JSONObject();
      Class<?> type = o.getClass();
      Iterator var5 = ReflectionHelper.getDeclaredFields(type).iterator();

      while(var5.hasNext()) {
         Field field = (Field)var5.next();
         if (!this.isIgnoredField(field)) {
            boolean accessible = field.isAccessible();
            field.setAccessible(true);
            Object value = field.get(o);
            if (value == null) {
               if (!this.cfg.ignoreNull) {
                  json.put(field.getName(), (Object)null);
               }
            } else {
               json.put(field.getName(), this.encodeObjectJSON(value, field.getType()));
            }

            field.setAccessible(accessible);
         }
      }

      if (referenceType != null && referenceType != type) {
         json.put("class", type.getName());
      }

      return json;
   }

   private JSONArray array2json(Object o) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, IOException, JSONException, JSONCodecException {
      JSONArray json = new JSONArray();

      for(int i = 0; i < Array.getLength(o); ++i) {
         Object value = Array.get(o, i);
         if (value == null) {
            if (!this.cfg.ignoreNull) {
               json.add((Object)null);
            }
         } else {
            json.add(this.encodeObjectJSON(value, o.getClass().getComponentType()));
         }
      }

      return json;
   }

   private boolean isIgnoredField(Field field) {
      int mod = field.getModifiers();
      return Modifier.isTransient(mod) || Modifier.isStatic(mod) || Modifier.isNative(mod);
   }

   static {
      setDefaultConfiguration(new JSONCodecConfiguration());
   }
}
