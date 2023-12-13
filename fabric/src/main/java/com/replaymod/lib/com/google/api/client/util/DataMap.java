package com.replaymod.lib.com.google.api.client.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class DataMap extends AbstractMap<String, Object> {
   final Object object;
   final ClassInfo classInfo;

   DataMap(Object object, boolean ignoreCase) {
      this.object = object;
      this.classInfo = ClassInfo.of(object.getClass(), ignoreCase);
      Preconditions.checkArgument(!this.classInfo.isEnum());
   }

   public DataMap.EntrySet entrySet() {
      return new DataMap.EntrySet();
   }

   public boolean containsKey(Object key) {
      return this.get(key) != null;
   }

   public Object get(Object key) {
      if (!(key instanceof String)) {
         return null;
      } else {
         FieldInfo fieldInfo = this.classInfo.getFieldInfo((String)key);
         return fieldInfo == null ? null : fieldInfo.getValue(this.object);
      }
   }

   public Object put(String key, Object value) {
      FieldInfo fieldInfo = this.classInfo.getFieldInfo(key);
      Preconditions.checkNotNull(fieldInfo, "no field of key " + key);
      Object oldValue = fieldInfo.getValue(this.object);
      fieldInfo.setValue(this.object, Preconditions.checkNotNull(value));
      return oldValue;
   }

   final class Entry implements java.util.Map.Entry<String, Object> {
      private Object fieldValue;
      private final FieldInfo fieldInfo;

      Entry(FieldInfo fieldInfo, Object fieldValue) {
         this.fieldInfo = fieldInfo;
         this.fieldValue = Preconditions.checkNotNull(fieldValue);
      }

      public String getKey() {
         String result = this.fieldInfo.getName();
         if (DataMap.this.classInfo.getIgnoreCase()) {
            result = result.toLowerCase();
         }

         return result;
      }

      public Object getValue() {
         return this.fieldValue;
      }

      public Object setValue(Object value) {
         Object oldValue = this.fieldValue;
         this.fieldValue = Preconditions.checkNotNull(value);
         this.fieldInfo.setValue(DataMap.this.object, value);
         return oldValue;
      }

      public int hashCode() {
         return this.getKey().hashCode() ^ this.getValue().hashCode();
      }

      public boolean equals(Object obj) {
         if (this == obj) {
            return true;
         } else if (!(obj instanceof java.util.Map.Entry)) {
            return false;
         } else {
            java.util.Map.Entry<?, ?> other = (java.util.Map.Entry)obj;
            return this.getKey().equals(other.getKey()) && this.getValue().equals(other.getValue());
         }
      }
   }

   final class EntryIterator implements Iterator<java.util.Map.Entry<String, Object>> {
      private int nextKeyIndex = -1;
      private FieldInfo nextFieldInfo;
      private Object nextFieldValue;
      private boolean isRemoved;
      private boolean isComputed;
      private FieldInfo currentFieldInfo;

      public boolean hasNext() {
         if (!this.isComputed) {
            this.isComputed = true;

            for(this.nextFieldValue = null; this.nextFieldValue == null && ++this.nextKeyIndex < DataMap.this.classInfo.names.size(); this.nextFieldValue = this.nextFieldInfo.getValue(DataMap.this.object)) {
               this.nextFieldInfo = DataMap.this.classInfo.getFieldInfo((String)DataMap.this.classInfo.names.get(this.nextKeyIndex));
            }
         }

         return this.nextFieldValue != null;
      }

      public java.util.Map.Entry<String, Object> next() {
         if (!this.hasNext()) {
            throw new NoSuchElementException();
         } else {
            this.currentFieldInfo = this.nextFieldInfo;
            Object currentFieldValue = this.nextFieldValue;
            this.isComputed = false;
            this.isRemoved = false;
            this.nextFieldInfo = null;
            this.nextFieldValue = null;
            return DataMap.this.new Entry(this.currentFieldInfo, currentFieldValue);
         }
      }

      public void remove() {
         Preconditions.checkState(this.currentFieldInfo != null && !this.isRemoved);
         this.isRemoved = true;
         this.currentFieldInfo.setValue(DataMap.this.object, (Object)null);
      }
   }

   final class EntrySet extends AbstractSet<java.util.Map.Entry<String, Object>> {
      public DataMap.EntryIterator iterator() {
         return DataMap.this.new EntryIterator();
      }

      public int size() {
         int result = 0;
         Iterator i$ = DataMap.this.classInfo.names.iterator();

         while(i$.hasNext()) {
            String name = (String)i$.next();
            if (DataMap.this.classInfo.getFieldInfo(name).getValue(DataMap.this.object) != null) {
               ++result;
            }
         }

         return result;
      }

      public void clear() {
         Iterator i$ = DataMap.this.classInfo.names.iterator();

         while(i$.hasNext()) {
            String name = (String)i$.next();
            DataMap.this.classInfo.getFieldInfo(name).setValue(DataMap.this.object, (Object)null);
         }

      }

      public boolean isEmpty() {
         Iterator i$ = DataMap.this.classInfo.names.iterator();

         String name;
         do {
            if (!i$.hasNext()) {
               return true;
            }

            name = (String)i$.next();
         } while(DataMap.this.classInfo.getFieldInfo(name).getValue(DataMap.this.object) == null);

         return false;
      }
   }
}
