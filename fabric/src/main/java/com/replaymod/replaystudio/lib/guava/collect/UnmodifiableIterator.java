package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import java.util.Iterator;

@GwtCompatible
public abstract class UnmodifiableIterator<E> implements Iterator<E> {
   protected UnmodifiableIterator() {
   }

   /** @deprecated */
   @Deprecated
   public final void remove() {
      throw new UnsupportedOperationException();
   }
}
