package com.replaymod.lib.com.google.api.client.util.store;

import java.io.IOException;
import java.util.Iterator;

public final class DataStoreUtils {
   public static String toString(DataStore<?> dataStore) {
      try {
         StringBuilder sb = new StringBuilder();
         sb.append('{');
         boolean first = true;

         String key;
         for(Iterator i$ = dataStore.keySet().iterator(); i$.hasNext(); sb.append(key).append('=').append(dataStore.get(key))) {
            key = (String)i$.next();
            if (first) {
               first = false;
            } else {
               sb.append(", ");
            }
         }

         return sb.append('}').toString();
      } catch (IOException var5) {
         throw new RuntimeException(var5);
      }
   }

   private DataStoreUtils() {
   }
}
