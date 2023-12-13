package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;

@GwtCompatible(
   serializable = true
)
class EmptyImmutableListMultimap extends ImmutableListMultimap<Object, Object> {
   static final EmptyImmutableListMultimap INSTANCE = new EmptyImmutableListMultimap();
   private static final long serialVersionUID = 0L;

   private EmptyImmutableListMultimap() {
      super(ImmutableMap.of(), 0);
   }

   private Object readResolve() {
      return INSTANCE;
   }
}
