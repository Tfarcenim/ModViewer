package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import java.util.ListIterator;

@GwtCompatible
public abstract class UnmodifiableListIterator<E> extends UnmodifiableIterator<E> implements ListIterator<E> {
   protected UnmodifiableListIterator() {
   }

   /** @deprecated */
   @Deprecated
   public final void add(E e) {
      throw new UnsupportedOperationException();
   }

   /** @deprecated */
   @Deprecated
   public final void set(E e) {
      throw new UnsupportedOperationException();
   }
}
