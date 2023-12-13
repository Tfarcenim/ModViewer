package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public interface BiMap<K, V> extends Map<K, V> {
   V put(@Nullable K var1, @Nullable V var2);

   V forcePut(@Nullable K var1, @Nullable V var2);

   void putAll(Map<? extends K, ? extends V> var1);

   Set<V> values();

   BiMap<V, K> inverse();
}
