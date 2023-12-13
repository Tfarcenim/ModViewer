package com.replaymod.replaystudio.lib.guava.cache;

import com.replaymod.replaystudio.lib.guava.annotations.Beta;
import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;

@Beta
@GwtCompatible
public interface RemovalListener<K, V> {
   void onRemoval(RemovalNotification<K, V> var1);
}
