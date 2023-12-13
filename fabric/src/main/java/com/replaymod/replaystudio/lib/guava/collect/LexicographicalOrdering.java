package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(
   serializable = true
)
final class LexicographicalOrdering<T> extends Ordering<Iterable<T>> implements Serializable {
   final Ordering<? super T> elementOrder;
   private static final long serialVersionUID = 0L;

   LexicographicalOrdering(Ordering<? super T> elementOrder) {
      this.elementOrder = elementOrder;
   }

   public int compare(Iterable<T> leftIterable, Iterable<T> rightIterable) {
      Iterator<T> left = leftIterable.iterator();
      Iterator right = rightIterable.iterator();

      int result;
      do {
         if (!left.hasNext()) {
            if (right.hasNext()) {
               return -1;
            }

            return 0;
         }

         if (!right.hasNext()) {
            return 1;
         }

         result = this.elementOrder.compare(left.next(), right.next());
      } while(result == 0);

      return result;
   }

   public boolean equals(@Nullable Object object) {
      if (object == this) {
         return true;
      } else if (object instanceof LexicographicalOrdering) {
         LexicographicalOrdering<?> that = (LexicographicalOrdering)object;
         return this.elementOrder.equals(that.elementOrder);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.elementOrder.hashCode() ^ 2075626741;
   }

   public String toString() {
      return this.elementOrder + ".lexicographical()";
   }
}
