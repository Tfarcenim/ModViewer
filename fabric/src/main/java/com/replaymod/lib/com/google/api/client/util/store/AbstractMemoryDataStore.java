package com.replaymod.lib.com.google.api.client.util.store;

import com.replaymod.lib.com.google.api.client.util.IOUtils;
import com.replaymod.lib.com.google.api.client.util.Lists;
import com.replaymod.lib.com.google.api.client.util.Maps;
import com.replaymod.lib.com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AbstractMemoryDataStore<V extends Serializable> extends AbstractDataStore<V> {
   private final Lock lock = new ReentrantLock();
   HashMap<String, byte[]> keyValueMap = Maps.newHashMap();

   protected AbstractMemoryDataStore(DataStoreFactory dataStoreFactory, String id) {
      super(dataStoreFactory, id);
   }

   public final Set<String> keySet() throws IOException {
      this.lock.lock();

      Set var1;
      try {
         var1 = Collections.unmodifiableSet(this.keyValueMap.keySet());
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public final Collection<V> values() throws IOException {
      this.lock.lock();

      try {
         List<V> result = Lists.newArrayList();
         Iterator i$ = this.keyValueMap.values().iterator();

         while(i$.hasNext()) {
            byte[] bytes = (byte[])i$.next();
            result.add(IOUtils.deserialize(bytes));
         }

         List var7 = Collections.unmodifiableList(result);
         return var7;
      } finally {
         this.lock.unlock();
      }
   }

   public final V get(String key) throws IOException {
      if (key == null) {
         return null;
      } else {
         this.lock.lock();

         Serializable var2;
         try {
            var2 = IOUtils.deserialize((byte[])this.keyValueMap.get(key));
         } finally {
            this.lock.unlock();
         }

         return var2;
      }
   }

   public final DataStore<V> set(String key, V value) throws IOException {
      Preconditions.checkNotNull(key);
      Preconditions.checkNotNull(value);
      this.lock.lock();

      try {
         this.keyValueMap.put(key, IOUtils.serialize(value));
         this.save();
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   public DataStore<V> delete(String key) throws IOException {
      if (key == null) {
         return this;
      } else {
         this.lock.lock();

         try {
            this.keyValueMap.remove(key);
            this.save();
         } finally {
            this.lock.unlock();
         }

         return this;
      }
   }

   public final DataStore<V> clear() throws IOException {
      this.lock.lock();

      try {
         this.keyValueMap.clear();
         this.save();
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   public boolean containsKey(String key) throws IOException {
      if (key == null) {
         return false;
      } else {
         this.lock.lock();

         boolean var2;
         try {
            var2 = this.keyValueMap.containsKey(key);
         } finally {
            this.lock.unlock();
         }

         return var2;
      }
   }

   public boolean containsValue(V value) throws IOException {
      if (value == null) {
         return false;
      } else {
         this.lock.lock();

         boolean var5;
         try {
            byte[] serialized = IOUtils.serialize(value);
            Iterator i$ = this.keyValueMap.values().iterator();

            byte[] bytes;
            do {
               if (!i$.hasNext()) {
                  boolean var9 = false;
                  return var9;
               }

               bytes = (byte[])i$.next();
            } while(!Arrays.equals(serialized, bytes));

            var5 = true;
         } finally {
            this.lock.unlock();
         }

         return var5;
      }
   }

   public boolean isEmpty() throws IOException {
      this.lock.lock();

      boolean var1;
      try {
         var1 = this.keyValueMap.isEmpty();
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public int size() throws IOException {
      this.lock.lock();

      int var1;
      try {
         var1 = this.keyValueMap.size();
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   void save() throws IOException {
   }

   public String toString() {
      return DataStoreUtils.toString(this);
   }
}
