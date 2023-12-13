package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import com.replaymod.replaystudio.lib.guava.base.Predicate;
import java.util.Map.Entry;

@GwtCompatible
interface FilteredMultimap<K, V> extends Multimap<K, V> {
   Multimap<K, V> unfiltered();

   Predicate<? super Entry<K, V>> entryPredicate();
}
