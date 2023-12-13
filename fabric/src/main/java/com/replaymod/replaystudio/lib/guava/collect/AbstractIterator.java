package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import com.replaymod.replaystudio.lib.guava.base.Preconditions;
import java.util.NoSuchElementException;

@GwtCompatible
public abstract class AbstractIterator<T> extends UnmodifiableIterator<T> {
   private AbstractIterator.State state;
   private T next;

   protected AbstractIterator() {
      this.state = AbstractIterator.State.NOT_READY;
   }

   protected abstract T computeNext();

   protected final T endOfData() {
      this.state = AbstractIterator.State.DONE;
      return null;
   }

   public final boolean hasNext() {
      Preconditions.checkState(this.state != AbstractIterator.State.FAILED);
      switch(this.state) {
      case DONE:
         return false;
      case READY:
         return true;
      default:
         return this.tryToComputeNext();
      }
   }

   private boolean tryToComputeNext() {
      this.state = AbstractIterator.State.FAILED;
      this.next = this.computeNext();
      if (this.state != AbstractIterator.State.DONE) {
         this.state = AbstractIterator.State.READY;
         return true;
      } else {
         return false;
      }
   }

   public final T next() {
      if (!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         this.state = AbstractIterator.State.NOT_READY;
         T result = this.next;
         this.next = null;
         return result;
      }
   }

   public final T peek() {
      if (!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         return this.next;
      }
   }

   private static enum State {
      READY,
      NOT_READY,
      DONE,
      FAILED;
   }
}
