package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import com.replaymod.replaystudio.lib.guava.base.Preconditions;
import java.util.Iterator;

@GwtCompatible
abstract class TransformedIterator<F, T> implements Iterator<T> {
   final Iterator<? extends F> backingIterator;

   TransformedIterator(Iterator<? extends F> backingIterator) {
      this.backingIterator = (Iterator)Preconditions.checkNotNull(backingIterator);
   }

   abstract T transform(F var1);

   public final boolean hasNext() {
      return this.backingIterator.hasNext();
   }

   public final T next() {
      return this.transform(this.backingIterator.next());
   }

   public final void remove() {
      this.backingIterator.remove();
   }
}
