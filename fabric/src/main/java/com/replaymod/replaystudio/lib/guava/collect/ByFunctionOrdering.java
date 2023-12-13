package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import com.replaymod.replaystudio.lib.guava.base.Function;
import com.replaymod.replaystudio.lib.guava.base.Objects;
import com.replaymod.replaystudio.lib.guava.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible(
   serializable = true
)
final class ByFunctionOrdering<F, T> extends Ordering<F> implements Serializable {
   final Function<F, ? extends T> function;
   final Ordering<T> ordering;
   private static final long serialVersionUID = 0L;

   ByFunctionOrdering(Function<F, ? extends T> function, Ordering<T> ordering) {
      this.function = (Function)Preconditions.checkNotNull(function);
      this.ordering = (Ordering)Preconditions.checkNotNull(ordering);
   }

   public int compare(F left, F right) {
      return this.ordering.compare(this.function.apply(left), this.function.apply(right));
   }

   public boolean equals(@Nullable Object object) {
      if (object == this) {
         return true;
      } else if (!(object instanceof ByFunctionOrdering)) {
         return false;
      } else {
         ByFunctionOrdering<?, ?> that = (ByFunctionOrdering)object;
         return this.function.equals(that.function) && this.ordering.equals(that.ordering);
      }
   }

   public int hashCode() {
      return Objects.hashCode(this.function, this.ordering);
   }

   public String toString() {
      return this.ordering + ".onResultOf(" + this.function + ")";
   }
}
