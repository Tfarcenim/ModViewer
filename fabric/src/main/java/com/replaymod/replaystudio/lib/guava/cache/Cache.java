package com.replaymod.replaystudio.lib.guava.cache;

import com.replaymod.replaystudio.lib.guava.annotations.Beta;
import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import com.replaymod.replaystudio.lib.guava.collect.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public interface Cache<K, V> {
   @Nullable
   V getIfPresent(Object var1);

   V get(K var1, Callable<? extends V> var2) throws ExecutionException;

   ImmutableMap<K, V> getAllPresent(Iterable<?> var1);

   void put(K var1, V var2);

   void putAll(Map<? extends K, ? extends V> var1);

   void invalidate(Object var1);

   void invalidateAll(Iterable<?> var1);

   void invalidateAll();

   long size();

   CacheStats stats();

   ConcurrentMap<K, V> asMap();

   void cleanUp();
}
