package com.replaymod.replaystudio.lib.guava.cache;

import com.replaymod.replaystudio.lib.guava.annotations.Beta;
import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import com.replaymod.replaystudio.lib.guava.base.Function;
import com.replaymod.replaystudio.lib.guava.collect.ImmutableMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

@Beta
@GwtCompatible
public interface LoadingCache<K, V> extends Cache<K, V>, Function<K, V> {
   V get(K var1) throws ExecutionException;

   V getUnchecked(K var1);

   ImmutableMap<K, V> getAll(Iterable<? extends K> var1) throws ExecutionException;

   /** @deprecated */
   @Deprecated
   V apply(K var1);

   void refresh(K var1);

   ConcurrentMap<K, V> asMap();
}
