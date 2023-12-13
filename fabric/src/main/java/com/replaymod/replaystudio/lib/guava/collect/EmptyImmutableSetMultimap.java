package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import java.util.Comparator;

@GwtCompatible(
   serializable = true
)
class EmptyImmutableSetMultimap extends ImmutableSetMultimap<Object, Object> {
   static final EmptyImmutableSetMultimap INSTANCE = new EmptyImmutableSetMultimap();
   private static final long serialVersionUID = 0L;

   private EmptyImmutableSetMultimap() {
      super(ImmutableMap.of(), 0, (Comparator)null);
   }

   private Object readResolve() {
      return INSTANCE;
   }
}
