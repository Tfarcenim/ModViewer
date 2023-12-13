package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import java.util.concurrent.ConcurrentMap;

@GwtCompatible
public abstract class ForwardingConcurrentMap<K, V> extends ForwardingMap<K, V> implements ConcurrentMap<K, V> {
   protected ForwardingConcurrentMap() {
   }

   protected abstract ConcurrentMap<K, V> delegate();

   public V putIfAbsent(K key, V value) {
      return this.delegate().putIfAbsent(key, value);
   }

   public boolean remove(Object key, Object value) {
      return this.delegate().remove(key, value);
   }

   public V replace(K key, V value) {
      return this.delegate().replace(key, value);
   }

   public boolean replace(K key, V oldValue, V newValue) {
      return this.delegate().replace(key, oldValue, newValue);
   }
}
