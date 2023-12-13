package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import com.replaymod.replaystudio.lib.guava.base.Preconditions;
import java.util.Comparator;
import java.util.SortedSet;

@GwtCompatible
final class SortedIterables {
   private SortedIterables() {
   }

   public static boolean hasSameComparator(Comparator<?> comparator, Iterable<?> elements) {
      Preconditions.checkNotNull(comparator);
      Preconditions.checkNotNull(elements);
      Comparator comparator2;
      if (elements instanceof SortedSet) {
         comparator2 = comparator((SortedSet)elements);
      } else {
         if (!(elements instanceof SortedIterable)) {
            return false;
         }

         comparator2 = ((SortedIterable)elements).comparator();
      }

      return comparator.equals(comparator2);
   }

   public static <E> Comparator<? super E> comparator(SortedSet<E> sortedSet) {
      Comparator<? super E> result = sortedSet.comparator();
      if (result == null) {
         result = Ordering.natural();
      }

      return (Comparator)result;
   }
}
