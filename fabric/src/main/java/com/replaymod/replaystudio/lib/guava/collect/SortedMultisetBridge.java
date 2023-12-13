package com.replaymod.replaystudio.lib.guava.collect;

import java.util.SortedSet;

interface SortedMultisetBridge<E> extends Multiset<E> {
   SortedSet<E> elementSet();
}
