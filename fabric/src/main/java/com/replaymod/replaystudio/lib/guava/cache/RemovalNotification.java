package com.replaymod.replaystudio.lib.guava.cache;

import com.replaymod.replaystudio.lib.guava.annotations.Beta;
import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import com.replaymod.replaystudio.lib.guava.base.Objects;
import com.replaymod.replaystudio.lib.guava.base.Preconditions;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public final class RemovalNotification<K, V> implements Entry<K, V> {
   @Nullable
   private final K key;
   @Nullable
   private final V value;
   private final RemovalCause cause;
   private static final long serialVersionUID = 0L;

   RemovalNotification(@Nullable K key, @Nullable V value, RemovalCause cause) {
      this.key = key;
      this.value = value;
      this.cause = (RemovalCause)Preconditions.checkNotNull(cause);
   }

   public RemovalCause getCause() {
      return this.cause;
   }

   public boolean wasEvicted() {
      return this.cause.wasEvicted();
   }

   @Nullable
   public K getKey() {
      return this.key;
   }

   @Nullable
   public V getValue() {
      return this.value;
   }

   public final V setValue(V value) {
      throw new UnsupportedOperationException();
   }

   public boolean equals(@Nullable Object object) {
      if (!(object instanceof Entry)) {
         return false;
      } else {
         Entry<?, ?> that = (Entry)object;
         return Objects.equal(this.getKey(), that.getKey()) && Objects.equal(this.getValue(), that.getValue());
      }
   }

   public int hashCode() {
      K k = this.getKey();
      V v = this.getValue();
      return (k == null ? 0 : k.hashCode()) ^ (v == null ? 0 : v.hashCode());
   }

   public String toString() {
      return this.getKey() + "=" + this.getValue();
   }
}
