package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
public interface SortedSetMultimap<K, V> extends SetMultimap<K, V> {
   SortedSet<V> get(@Nullable K var1);

   SortedSet<V> removeAll(@Nullable Object var1);

   SortedSet<V> replaceValues(K var1, Iterable<? extends V> var2);

   Map<K, Collection<V>> asMap();

   Comparator<? super V> valueComparator();
}
