package com.replaymod.lib.com.google.api.client.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class ArrayValueMap {
   private final Map<String, ArrayValueMap.ArrayValue> keyMap = ArrayMap.create();
   private final Map<Field, ArrayValueMap.ArrayValue> fieldMap = ArrayMap.create();
   private final Object destination;

   public ArrayValueMap(Object destination) {
      this.destination = destination;
   }

   public void setValues() {
      Iterator i$ = this.keyMap.entrySet().iterator();

      Entry entry;
      while(i$.hasNext()) {
         entry = (Entry)i$.next();
         Map<String, Object> destinationMap = (Map)this.destination;
         destinationMap.put(entry.getKey(), ((ArrayValueMap.ArrayValue)entry.getValue()).toArray());
      }

      i$ = this.fieldMap.entrySet().iterator();

      while(i$.hasNext()) {
         entry = (Entry)i$.next();
         FieldInfo.setFieldValue((Field)entry.getKey(), this.destination, ((ArrayValueMap.ArrayValue)entry.getValue()).toArray());
      }

   }

   public void put(Field field, Class<?> arrayComponentType, Object value) {
      ArrayValueMap.ArrayValue arrayValue = (ArrayValueMap.ArrayValue)this.fieldMap.get(field);
      if (arrayValue == null) {
         arrayValue = new ArrayValueMap.ArrayValue(arrayComponentType);
         this.fieldMap.put(field, arrayValue);
      }

      arrayValue.addValue(arrayComponentType, value);
   }

   public void put(String keyName, Class<?> arrayComponentType, Object value) {
      ArrayValueMap.ArrayValue arrayValue = (ArrayValueMap.ArrayValue)this.keyMap.get(keyName);
      if (arrayValue == null) {
         arrayValue = new ArrayValueMap.ArrayValue(arrayComponentType);
         this.keyMap.put(keyName, arrayValue);
      }

      arrayValue.addValue(arrayComponentType, value);
   }

   static class ArrayValue {
      final Class<?> componentType;
      final ArrayList<Object> values = new ArrayList();

      ArrayValue(Class<?> componentType) {
         this.componentType = componentType;
      }

      Object toArray() {
         return Types.toArray(this.values, this.componentType);
      }

      void addValue(Class<?> componentType, Object value) {
         Preconditions.checkArgument(componentType == this.componentType);
         this.values.add(value);
      }
   }
}
