package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.Iterator;

@GwtCompatible
interface SortedIterable<T> extends Iterable<T> {
   Comparator<? super T> comparator();

   Iterator<T> iterator();
}
