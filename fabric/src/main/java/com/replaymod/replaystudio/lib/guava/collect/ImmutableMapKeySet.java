package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import com.replaymod.replaystudio.lib.guava.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
final class ImmutableMapKeySet<K, V> extends ImmutableSet<K> {
   private final ImmutableMap<K, V> map;

   ImmutableMapKeySet(ImmutableMap<K, V> map) {
      this.map = map;
   }

   public int size() {
      return this.map.size();
   }

   public UnmodifiableIterator<K> iterator() {
      return this.asList().iterator();
   }

   public boolean contains(@Nullable Object object) {
      return this.map.containsKey(object);
   }

   ImmutableList<K> createAsList() {
      final ImmutableList<Entry<K, V>> entryList = this.map.entrySet().asList();
      return new ImmutableAsList<K>() {
         public K get(int index) {
            return ((Entry)entryList.get(index)).getKey();
         }

         ImmutableCollection<K> delegateCollection() {
            return ImmutableMapKeySet.this;
         }
      };
   }

   boolean isPartialView() {
      return true;
   }

   @GwtIncompatible("serialization")
   Object writeReplace() {
      return new ImmutableMapKeySet.KeySetSerializedForm(this.map);
   }

   @GwtIncompatible("serialization")
   private static class KeySetSerializedForm<K> implements Serializable {
      final ImmutableMap<K, ?> map;
      private static final long serialVersionUID = 0L;

      KeySetSerializedForm(ImmutableMap<K, ?> map) {
         this.map = map;
      }

      Object readResolve() {
         return this.map.keySet();
      }
   }
}
