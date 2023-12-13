package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import java.util.SortedMap;

@GwtCompatible
public interface SortedMapDifference<K, V> extends MapDifference<K, V> {
   SortedMap<K, V> entriesOnlyOnLeft();

   SortedMap<K, V> entriesOnlyOnRight();

   SortedMap<K, V> entriesInCommon();

   SortedMap<K, MapDifference.ValueDifference<V>> entriesDiffering();
}
