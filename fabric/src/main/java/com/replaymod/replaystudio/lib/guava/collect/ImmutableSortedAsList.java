package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import com.replaymod.replaystudio.lib.guava.annotations.GwtIncompatible;
import java.util.Comparator;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
final class ImmutableSortedAsList<E> extends RegularImmutableAsList<E> implements SortedIterable<E> {
   ImmutableSortedAsList(ImmutableSortedSet<E> backingSet, ImmutableList<E> backingList) {
      super(backingSet, (ImmutableList)backingList);
   }

   ImmutableSortedSet<E> delegateCollection() {
      return (ImmutableSortedSet)super.delegateCollection();
   }

   public Comparator<? super E> comparator() {
      return this.delegateCollection().comparator();
   }

   @GwtIncompatible("ImmutableSortedSet.indexOf")
   public int indexOf(@Nullable Object target) {
      int index = this.delegateCollection().indexOf(target);
      return index >= 0 && this.get(index).equals(target) ? index : -1;
   }

   @GwtIncompatible("ImmutableSortedSet.indexOf")
   public int lastIndexOf(@Nullable Object target) {
      return this.indexOf(target);
   }

   public boolean contains(Object target) {
      return this.indexOf(target) >= 0;
   }

   @GwtIncompatible("super.subListUnchecked does not exist; inherited subList is valid if slow")
   ImmutableList<E> subListUnchecked(int fromIndex, int toIndex) {
      return (new RegularImmutableSortedSet(super.subListUnchecked(fromIndex, toIndex), this.comparator())).asList();
   }
}
