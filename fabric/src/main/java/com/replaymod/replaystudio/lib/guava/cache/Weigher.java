package com.replaymod.replaystudio.lib.guava.cache;

import com.replaymod.replaystudio.lib.guava.annotations.Beta;
import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;

@Beta
@GwtCompatible
public interface Weigher<K, V> {
   int weigh(K var1, V var2);
}
