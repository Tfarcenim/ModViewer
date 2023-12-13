package com.replaymod.lib.com.google.api.client.util.store;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

public interface DataStore<V extends Serializable> {
   DataStoreFactory getDataStoreFactory();

   String getId();

   int size() throws IOException;

   boolean isEmpty() throws IOException;

   boolean containsKey(String var1) throws IOException;

   boolean containsValue(V var1) throws IOException;

   Set<String> keySet() throws IOException;

   Collection<V> values() throws IOException;

   V get(String var1) throws IOException;

   DataStore<V> set(String var1, V var2) throws IOException;

   DataStore<V> clear() throws IOException;

   DataStore<V> delete(String var1) throws IOException;
}
