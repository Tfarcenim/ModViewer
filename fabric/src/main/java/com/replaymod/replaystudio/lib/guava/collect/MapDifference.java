package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
public interface MapDifference<K, V> {
   boolean areEqual();

   Map<K, V> entriesOnlyOnLeft();

   Map<K, V> entriesOnlyOnRight();

   Map<K, V> entriesInCommon();

   Map<K, MapDifference.ValueDifference<V>> entriesDiffering();

   boolean equals(@Nullable Object var1);

   int hashCode();

   public interface ValueDifference<V> {
      V leftValue();

      V rightValue();

      boolean equals(@Nullable Object var1);

      int hashCode();
   }
}
