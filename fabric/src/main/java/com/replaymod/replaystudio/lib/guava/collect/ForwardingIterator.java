package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import java.util.Iterator;

@GwtCompatible
public abstract class ForwardingIterator<T> extends ForwardingObject implements Iterator<T> {
   protected ForwardingIterator() {
   }

   protected abstract Iterator<T> delegate();

   public boolean hasNext() {
      return this.delegate().hasNext();
   }

   public T next() {
      return this.delegate().next();
   }

   public void remove() {
      this.delegate().remove();
   }
}
