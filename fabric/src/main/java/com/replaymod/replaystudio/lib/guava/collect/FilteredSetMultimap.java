package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;

@GwtCompatible
interface FilteredSetMultimap<K, V> extends FilteredMultimap<K, V>, SetMultimap<K, V> {
   SetMultimap<K, V> unfiltered();
}
