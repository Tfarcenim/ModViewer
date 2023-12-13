package com.replaymod.replaystudio.lib.viaversion.util;

import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.ints.Int2IntMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.NonNull;

public interface Int2IntBiMap extends Int2IntMap {
   Int2IntBiMap inverse();

   int put(int var1, int var2);

   /** @deprecated */
   @Deprecated
   default void putAll(@NonNull Map<? extends Integer, ? extends Integer> m) {
      throw new UnsupportedOperationException();
   }
}
