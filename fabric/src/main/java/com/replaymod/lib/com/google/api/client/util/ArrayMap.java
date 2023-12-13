package com.replaymod.lib.com.google.api.client.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class ArrayMap<K, V> extends AbstractMap<K, V> implements Cloneable {
   int size;
   private Object[] data;

   public static <K, V> ArrayMap<K, V> create() {
      return new ArrayMap();
   }

   public static <K, V> ArrayMap<K, V> create(int initialCapacity) {
      ArrayMap<K, V> result = create();
      result.ensureCapacity(initialCapacity);
      return result;
   }

   public static <K, V> ArrayMap<K, V> of(Object... keyValuePairs) {
      ArrayMap<K, V> result = create(1);
      int length = keyValuePairs.length;
      if (1 == length % 2) {
         throw new IllegalArgumentException("missing value for last key: " + keyValuePairs[length - 1]);
      } else {
         result.size = keyValuePairs.length / 2;
         Object[] data = result.data = new Object[length];
         System.arraycopy(keyValuePairs, 0, data, 0, length);
         return result;
      }
   }

   public final int size() {
      return this.size;
   }

   public final K getKey(int index) {
      if (index >= 0 && index < this.size) {
         K result = this.data[index << 1];
         return result;
      } else {
         return null;
      }
   }

   public final V getValue(int index) {
      return index >= 0 && index < this.size ? this.valueAtDataIndex(1 + (index << 1)) : null;
   }

   public final V set(int index, K key, V value) {
      if (index < 0) {
         throw new IndexOutOfBoundsException();
      } else {
         int minSize = index + 1;
         this.ensureCapacity(minSize);
         int dataIndex = index << 1;
         V result = this.valueAtDataIndex(dataIndex + 1);
         this.setData(dataIndex, key, value);
         if (minSize > this.size) {
            this.size = minSize;
         }

         return result;
      }
   }

   public final V set(int index, V value) {
      int size = this.size;
      if (index >= 0 && index < size) {
         int valueDataIndex = 1 + (index << 1);
         V result = this.valueAtDataIndex(valueDataIndex);
         this.data[valueDataIndex] = value;
         return result;
      } else {
         throw new IndexOutOfBoundsException();
      }
   }

   public final void add(K key, V value) {
      this.set(this.size, key, value);
   }

   public final V remove(int index) {
      return this.removeFromDataIndexOfKey(index << 1);
   }

   public final boolean containsKey(Object key) {
      return -2 != this.getDataIndexOfKey(key);
   }

   public final int getIndexOfKey(K key) {
      return this.getDataIndexOfKey(key) >> 1;
   }

   public final V get(Object key) {
      return this.valueAtDataIndex(this.getDataIndexOfKey(key) + 1);
   }

   public final V put(K key, V value) {
      int index = this.getIndexOfKey(key);
      if (index == -1) {
         index = this.size;
      }

      return this.set(index, key, value);
   }

   public final V remove(Object key) {
      return this.removeFromDataIndexOfKey(this.getDataIndexOfKey(key));
   }

   public final void trim() {
      this.setDataCapacity(this.size << 1);
   }

   public final void ensureCapacity(int minCapacity) {
      if (minCapacity < 0) {
         throw new IndexOutOfBoundsException();
      } else {
         Object[] data = this.data;
         int minDataCapacity = minCapacity << 1;
         int oldDataCapacity = data == null ? 0 : data.length;
         if (minDataCapacity > oldDataCapacity) {
            int newDataCapacity = oldDataCapacity / 2 * 3 + 1;
            if (newDataCapacity % 2 != 0) {
               ++newDataCapacity;
            }

            if (newDataCapacity < minDataCapacity) {
               newDataCapacity = minDataCapacity;
            }

            this.setDataCapacity(newDataCapacity);
         }

      }
   }

   private void setDataCapacity(int newDataCapacity) {
      if (newDataCapacity == 0) {
         this.data = null;
      } else {
         int size = this.size;
         Object[] oldData = this.data;
         if (size == 0 || newDataCapacity != oldData.length) {
            Object[] newData = this.data = new Object[newDataCapacity];
            if (size != 0) {
               System.arraycopy(oldData, 0, newData, 0, size << 1);
            }
         }

      }
   }

   private void setData(int dataIndexOfKey, K key, V value) {
      Object[] data = this.data;
      data[dataIndexOfKey] = key;
      data[dataIndexOfKey + 1] = value;
   }

   private V valueAtDataIndex(int dataIndex) {
      if (dataIndex < 0) {
         return null;
      } else {
         V result = this.data[dataIndex];
         return result;
      }
   }

   private int getDataIndexOfKey(Object key) {
      int dataSize = this.size << 1;
      Object[] data = this.data;
      int i = 0;

      while(true) {
         if (i >= dataSize) {
            return -2;
         }

         Object k = data[i];
         if (key == null) {
            if (k == null) {
               break;
            }
         } else if (key.equals(k)) {
            break;
         }

         i += 2;
      }

      return i;
   }

   private V removeFromDataIndexOfKey(int dataIndexOfKey) {
      int dataSize = this.size << 1;
      if (dataIndexOfKey >= 0 && dataIndexOfKey < dataSize) {
         V result = this.valueAtDataIndex(dataIndexOfKey + 1);
         Object[] data = this.data;
         int moved = dataSize - dataIndexOfKey - 2;
         if (moved != 0) {
            System.arraycopy(data, dataIndexOfKey + 2, data, dataIndexOfKey, moved);
         }

         --this.size;
         this.setData(dataSize - 2, (Object)null, (Object)null);
         return result;
      } else {
         return null;
      }
   }

   public void clear() {
      this.size = 0;
      this.data = null;
   }

   public final boolean containsValue(Object value) {
      int dataSize = this.size << 1;
      Object[] data = this.data;
      int i = 1;

      while(true) {
         if (i >= dataSize) {
            return false;
         }

         Object v = data[i];
         if (value == null) {
            if (v == null) {
               break;
            }
         } else if (value.equals(v)) {
            break;
         }

         i += 2;
      }

      return true;
   }

   public final Set<java.util.Map.Entry<K, V>> entrySet() {
      return new ArrayMap.EntrySet();
   }

   public ArrayMap<K, V> clone() {
      try {
         ArrayMap<K, V> result = (ArrayMap)super.clone();
         Object[] data = this.data;
         if (data != null) {
            int length = data.length;
            Object[] resultData = result.data = new Object[length];
            System.arraycopy(data, 0, resultData, 0, length);
         }

         return result;
      } catch (CloneNotSupportedException var5) {
         return null;
      }
   }

   final class Entry implements java.util.Map.Entry<K, V> {
      private int index;

      Entry(int index) {
         this.index = index;
      }

      public K getKey() {
         return ArrayMap.this.getKey(this.index);
      }

      public V getValue() {
         return ArrayMap.this.getValue(this.index);
      }

      public V setValue(V value) {
         return ArrayMap.this.set(this.index, value);
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
            return Objects.equal(this.getKey(), other.getKey()) && Objects.equal(this.getValue(), other.getValue());
         }
      }
   }

   final class EntryIterator implements Iterator<java.util.Map.Entry<K, V>> {
      private boolean removed;
      private int nextIndex;

      public boolean hasNext() {
         return this.nextIndex < ArrayMap.this.size;
      }

      public java.util.Map.Entry<K, V> next() {
         int index = this.nextIndex;
         if (index == ArrayMap.this.size) {
            throw new NoSuchElementException();
         } else {
            ++this.nextIndex;
            return ArrayMap.this.new Entry(index);
         }
      }

      public void remove() {
         int index = this.nextIndex - 1;
         if (!this.removed && index >= 0) {
            ArrayMap.this.remove(index);
            this.removed = true;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   final class EntrySet extends AbstractSet<java.util.Map.Entry<K, V>> {
      public Iterator<java.util.Map.Entry<K, V>> iterator() {
         return ArrayMap.this.new EntryIterator();
      }

      public int size() {
         return ArrayMap.this.size;
      }
   }
}
