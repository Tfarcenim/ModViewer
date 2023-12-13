package com.replaymod.lib.com.google.api.client.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class GenericData extends AbstractMap<String, Object> implements Cloneable {
   Map<String, Object> unknownFields;
   final ClassInfo classInfo;

   public GenericData() {
      this(EnumSet.noneOf(GenericData.Flags.class));
   }

   public GenericData(EnumSet<GenericData.Flags> flags) {
      this.unknownFields = ArrayMap.create();
      this.classInfo = ClassInfo.of(this.getClass(), flags.contains(GenericData.Flags.IGNORE_CASE));
   }

   public final Object get(Object name) {
      if (!(name instanceof String)) {
         return null;
      } else {
         String fieldName = (String)name;
         FieldInfo fieldInfo = this.classInfo.getFieldInfo(fieldName);
         if (fieldInfo != null) {
            return fieldInfo.getValue(this);
         } else {
            if (this.classInfo.getIgnoreCase()) {
               fieldName = fieldName.toLowerCase();
            }

            return this.unknownFields.get(fieldName);
         }
      }
   }

   public final Object put(String fieldName, Object value) {
      FieldInfo fieldInfo = this.classInfo.getFieldInfo(fieldName);
      if (fieldInfo != null) {
         Object oldValue = fieldInfo.getValue(this);
         fieldInfo.setValue(this, value);
         return oldValue;
      } else {
         if (this.classInfo.getIgnoreCase()) {
            fieldName = fieldName.toLowerCase();
         }

         return this.unknownFields.put(fieldName, value);
      }
   }

   public GenericData set(String fieldName, Object value) {
      FieldInfo fieldInfo = this.classInfo.getFieldInfo(fieldName);
      if (fieldInfo != null) {
         fieldInfo.setValue(this, value);
      } else {
         if (this.classInfo.getIgnoreCase()) {
            fieldName = fieldName.toLowerCase();
         }

         this.unknownFields.put(fieldName, value);
      }

      return this;
   }

   public final void putAll(Map<? extends String, ?> map) {
      Iterator i$ = map.entrySet().iterator();

      while(i$.hasNext()) {
         Entry<? extends String, ?> entry = (Entry)i$.next();
         this.set((String)entry.getKey(), entry.getValue());
      }

   }

   public final Object remove(Object name) {
      if (!(name instanceof String)) {
         return null;
      } else {
         String fieldName = (String)name;
         FieldInfo fieldInfo = this.classInfo.getFieldInfo(fieldName);
         if (fieldInfo != null) {
            throw new UnsupportedOperationException();
         } else {
            if (this.classInfo.getIgnoreCase()) {
               fieldName = fieldName.toLowerCase();
            }

            return this.unknownFields.remove(fieldName);
         }
      }
   }

   public Set<Entry<String, Object>> entrySet() {
      return new GenericData.EntrySet();
   }

   public GenericData clone() {
      try {
         GenericData result = (GenericData)super.clone();
         Data.deepCopy(this, result);
         result.unknownFields = (Map)Data.clone(this.unknownFields);
         return result;
      } catch (CloneNotSupportedException var2) {
         throw new IllegalStateException(var2);
      }
   }

   public final Map<String, Object> getUnknownKeys() {
      return this.unknownFields;
   }

   public final void setUnknownKeys(Map<String, Object> unknownFields) {
      this.unknownFields = unknownFields;
   }

   public final ClassInfo getClassInfo() {
      return this.classInfo;
   }

   final class EntryIterator implements Iterator<Entry<String, Object>> {
      private boolean startedUnknown;
      private final Iterator<Entry<String, Object>> fieldIterator;
      private final Iterator<Entry<String, Object>> unknownIterator;

      EntryIterator(DataMap.EntrySet dataEntrySet) {
         this.fieldIterator = dataEntrySet.iterator();
         this.unknownIterator = GenericData.this.unknownFields.entrySet().iterator();
      }

      public boolean hasNext() {
         return this.fieldIterator.hasNext() || this.unknownIterator.hasNext();
      }

      public Entry<String, Object> next() {
         if (!this.startedUnknown) {
            if (this.fieldIterator.hasNext()) {
               return (Entry)this.fieldIterator.next();
            }

            this.startedUnknown = true;
         }

         return (Entry)this.unknownIterator.next();
      }

      public void remove() {
         if (this.startedUnknown) {
            this.unknownIterator.remove();
         }

         this.fieldIterator.remove();
      }
   }

   final class EntrySet extends AbstractSet<Entry<String, Object>> {
      private final DataMap.EntrySet dataEntrySet;

      EntrySet() {
         this.dataEntrySet = (new DataMap(GenericData.this, GenericData.this.classInfo.getIgnoreCase())).entrySet();
      }

      public Iterator<Entry<String, Object>> iterator() {
         return GenericData.this.new EntryIterator(this.dataEntrySet);
      }

      public int size() {
         return GenericData.this.unknownFields.size() + this.dataEntrySet.size();
      }

      public void clear() {
         GenericData.this.unknownFields.clear();
         this.dataEntrySet.clear();
      }
   }

   public static enum Flags {
      IGNORE_CASE;
   }
}
