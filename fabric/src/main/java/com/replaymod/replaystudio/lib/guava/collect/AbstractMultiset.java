package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import com.replaymod.replaystudio.lib.guava.base.Objects;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractMultiset<E> extends AbstractCollection<E> implements Multiset<E> {
   private transient Set<E> elementSet;
   private transient Set<Multiset.Entry<E>> entrySet;

   public int size() {
      return Multisets.sizeImpl(this);
   }

   public boolean isEmpty() {
      return this.entrySet().isEmpty();
   }

   public boolean contains(@Nullable Object element) {
      return this.count(element) > 0;
   }

   public Iterator<E> iterator() {
      return Multisets.iteratorImpl(this);
   }

   public int count(@Nullable Object element) {
      Iterator i$ = this.entrySet().iterator();

      Multiset.Entry entry;
      do {
         if (!i$.hasNext()) {
            return 0;
         }

         entry = (Multiset.Entry)i$.next();
      } while(!Objects.equal(entry.getElement(), element));

      return entry.getCount();
   }

   public boolean add(@Nullable E element) {
      this.add(element, 1);
      return true;
   }

   public int add(@Nullable E element, int occurrences) {
      throw new UnsupportedOperationException();
   }

   public boolean remove(@Nullable Object element) {
      return this.remove(element, 1) > 0;
   }

   public int remove(@Nullable Object element, int occurrences) {
      throw new UnsupportedOperationException();
   }

   public int setCount(@Nullable E element, int count) {
      return Multisets.setCountImpl(this, element, count);
   }

   public boolean setCount(@Nullable E element, int oldCount, int newCount) {
      return Multisets.setCountImpl(this, element, oldCount, newCount);
   }

   public boolean addAll(Collection<? extends E> elementsToAdd) {
      return Multisets.addAllImpl(this, elementsToAdd);
   }

   public boolean removeAll(Collection<?> elementsToRemove) {
      return Multisets.removeAllImpl(this, elementsToRemove);
   }

   public boolean retainAll(Collection<?> elementsToRetain) {
      return Multisets.retainAllImpl(this, elementsToRetain);
   }

   public void clear() {
      Iterators.clear(this.entryIterator());
   }

   public Set<E> elementSet() {
      Set<E> result = this.elementSet;
      if (result == null) {
         this.elementSet = result = this.createElementSet();
      }

      return result;
   }

   Set<E> createElementSet() {
      return new AbstractMultiset.ElementSet();
   }

   abstract Iterator<Multiset.Entry<E>> entryIterator();

   abstract int distinctElements();

   public Set<Multiset.Entry<E>> entrySet() {
      Set<Multiset.Entry<E>> result = this.entrySet;
      return result == null ? (this.entrySet = this.createEntrySet()) : result;
   }

   Set<Multiset.Entry<E>> createEntrySet() {
      return new AbstractMultiset.EntrySet();
   }

   public boolean equals(@Nullable Object object) {
      return Multisets.equalsImpl(this, object);
   }

   public int hashCode() {
      return this.entrySet().hashCode();
   }

   public String toString() {
      return this.entrySet().toString();
   }

   class EntrySet extends Multisets.EntrySet<E> {
      Multiset<E> multiset() {
         return AbstractMultiset.this;
      }

      public Iterator<Multiset.Entry<E>> iterator() {
         return AbstractMultiset.this.entryIterator();
      }

      public int size() {
         return AbstractMultiset.this.distinctElements();
      }
   }

   class ElementSet extends Multisets.ElementSet<E> {
      Multiset<E> multiset() {
         return AbstractMultiset.this;
      }
   }
}
