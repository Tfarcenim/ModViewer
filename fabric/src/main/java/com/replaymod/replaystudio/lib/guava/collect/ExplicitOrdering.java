package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible(
   serializable = true
)
final class ExplicitOrdering<T> extends Ordering<T> implements Serializable {
   final ImmutableMap<T, Integer> rankMap;
   private static final long serialVersionUID = 0L;

   ExplicitOrdering(List<T> valuesInOrder) {
      this(buildRankMap(valuesInOrder));
   }

   ExplicitOrdering(ImmutableMap<T, Integer> rankMap) {
      this.rankMap = rankMap;
   }

   public int compare(T left, T right) {
      return this.rank(left) - this.rank(right);
   }

   private int rank(T value) {
      Integer rank = (Integer)this.rankMap.get(value);
      if (rank == null) {
         throw new Ordering.IncomparableValueException(value);
      } else {
         return rank;
      }
   }

   private static <T> ImmutableMap<T, Integer> buildRankMap(List<T> valuesInOrder) {
      ImmutableMap.Builder<T, Integer> builder = ImmutableMap.builder();
      int rank = 0;
      Iterator i$ = valuesInOrder.iterator();

      while(i$.hasNext()) {
         T value = i$.next();
         builder.put(value, rank++);
      }

      return builder.build();
   }

   public boolean equals(@Nullable Object object) {
      if (object instanceof ExplicitOrdering) {
         ExplicitOrdering<?> that = (ExplicitOrdering)object;
         return this.rankMap.equals(that.rankMap);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.rankMap.hashCode();
   }

   public String toString() {
      return "Ordering.explicit(" + this.rankMap.keySet() + ")";
   }
}
