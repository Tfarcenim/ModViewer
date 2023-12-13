package com.replaymod.lib.com.google.api.client.util.store;

import com.replaymod.lib.com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.Serializable;

public abstract class AbstractDataStore<V extends Serializable> implements DataStore<V> {
   private final DataStoreFactory dataStoreFactory;
   private final String id;

   protected AbstractDataStore(DataStoreFactory dataStoreFactory, String id) {
      this.dataStoreFactory = (DataStoreFactory)Preconditions.checkNotNull(dataStoreFactory);
      this.id = (String)Preconditions.checkNotNull(id);
   }

   public DataStoreFactory getDataStoreFactory() {
      return this.dataStoreFactory;
   }

   public final String getId() {
      return this.id;
   }

   public boolean containsKey(String key) throws IOException {
      return this.get(key) != null;
   }

   public boolean containsValue(V value) throws IOException {
      return this.values().contains(value);
   }

   public boolean isEmpty() throws IOException {
      return this.size() == 0;
   }

   public int size() throws IOException {
      return this.keySet().size();
   }
}
