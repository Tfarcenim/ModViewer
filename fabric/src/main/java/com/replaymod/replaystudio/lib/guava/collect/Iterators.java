package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.Beta;
import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import com.replaymod.replaystudio.lib.guava.annotations.GwtIncompatible;
import com.replaymod.replaystudio.lib.guava.base.Function;
import com.replaymod.replaystudio.lib.guava.base.Objects;
import com.replaymod.replaystudio.lib.guava.base.Optional;
import com.replaymod.replaystudio.lib.guava.base.Preconditions;
import com.replaymod.replaystudio.lib.guava.base.Predicate;
import com.replaymod.replaystudio.lib.guava.base.Predicates;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
public final class Iterators {
   static final UnmodifiableListIterator<Object> EMPTY_LIST_ITERATOR = new UnmodifiableListIterator<Object>() {
      public boolean hasNext() {
         return false;
      }

      public Object next() {
         throw new NoSuchElementException();
      }

      public boolean hasPrevious() {
         return false;
      }

      public Object previous() {
         throw new NoSuchElementException();
      }

      public int nextIndex() {
         return 0;
      }

      public int previousIndex() {
         return -1;
      }
   };
   private static final Iterator<Object> EMPTY_MODIFIABLE_ITERATOR = new Iterator<Object>() {
      public boolean hasNext() {
         return false;
      }

      public Object next() {
         throw new NoSuchElementException();
      }

      public void remove() {
         CollectPreconditions.checkRemove(false);
      }
   };

   private Iterators() {
   }

   public static <T> UnmodifiableIterator<T> emptyIterator() {
      return emptyListIterator();
   }

   static <T> UnmodifiableListIterator<T> emptyListIterator() {
      return EMPTY_LIST_ITERATOR;
   }

   static <T> Iterator<T> emptyModifiableIterator() {
      return EMPTY_MODIFIABLE_ITERATOR;
   }

   public static <T> UnmodifiableIterator<T> unmodifiableIterator(Iterator<T> iterator) {
      Preconditions.checkNotNull(iterator);
      return iterator instanceof UnmodifiableIterator ? (UnmodifiableIterator)iterator : new UnmodifiableIterator<T>() {
         public boolean hasNext() {
            return iterator.hasNext();
         }

         public T next() {
            return iterator.next();
         }
      };
   }

   /** @deprecated */
   @Deprecated
   public static <T> UnmodifiableIterator<T> unmodifiableIterator(UnmodifiableIterator<T> iterator) {
      return (UnmodifiableIterator)Preconditions.checkNotNull(iterator);
   }

   public static int size(Iterator<?> iterator) {
      int count;
      for(count = 0; iterator.hasNext(); ++count) {
         iterator.next();
      }

      return count;
   }

   public static boolean contains(Iterator<?> iterator, @Nullable Object element) {
      return any(iterator, Predicates.equalTo(element));
   }

   public static boolean removeAll(Iterator<?> removeFrom, Collection<?> elementsToRemove) {
      return removeIf(removeFrom, Predicates.in(elementsToRemove));
   }

   public static <T> boolean removeIf(Iterator<T> removeFrom, Predicate<? super T> predicate) {
      Preconditions.checkNotNull(predicate);
      boolean modified = false;

      while(removeFrom.hasNext()) {
         if (predicate.apply(removeFrom.next())) {
            removeFrom.remove();
            modified = true;
         }
      }

      return modified;
   }

   public static boolean retainAll(Iterator<?> removeFrom, Collection<?> elementsToRetain) {
      return removeIf(removeFrom, Predicates.not(Predicates.in(elementsToRetain)));
   }

   public static boolean elementsEqual(Iterator<?> iterator1, Iterator<?> iterator2) {
      while(true) {
         if (iterator1.hasNext()) {
            if (!iterator2.hasNext()) {
               return false;
            }

            Object o1 = iterator1.next();
            Object o2 = iterator2.next();
            if (Objects.equal(o1, o2)) {
               continue;
            }

            return false;
         }

         return !iterator2.hasNext();
      }
   }

   public static String toString(Iterator<?> iterator) {
      return Collections2.STANDARD_JOINER.appendTo((new StringBuilder()).append('['), iterator).append(']').toString();
   }

   public static <T> T getOnlyElement(Iterator<T> iterator) {
      T first = iterator.next();
      if (!iterator.hasNext()) {
         return first;
      } else {
         StringBuilder sb = new StringBuilder();
         sb.append("expected one element but was: <" + first);

         for(int i = 0; i < 4 && iterator.hasNext(); ++i) {
            sb.append(", " + iterator.next());
         }

         if (iterator.hasNext()) {
            sb.append(", ...");
         }

         sb.append('>');
         throw new IllegalArgumentException(sb.toString());
      }
   }

   @Nullable
   public static <T> T getOnlyElement(Iterator<? extends T> iterator, @Nullable T defaultValue) {
      return iterator.hasNext() ? getOnlyElement(iterator) : defaultValue;
   }

   @GwtIncompatible("Array.newInstance(Class, int)")
   public static <T> T[] toArray(Iterator<? extends T> iterator, Class<T> type) {
      List<T> list = Lists.newArrayList(iterator);
      return Iterables.toArray(list, type);
   }

   public static <T> boolean addAll(Collection<T> addTo, Iterator<? extends T> iterator) {
      Preconditions.checkNotNull(addTo);
      Preconditions.checkNotNull(iterator);

      boolean wasModified;
      for(wasModified = false; iterator.hasNext(); wasModified |= addTo.add(iterator.next())) {
      }

      return wasModified;
   }

   public static int frequency(Iterator<?> iterator, @Nullable Object element) {
      return size(filter(iterator, Predicates.equalTo(element)));
   }

   public static <T> Iterator<T> cycle(Iterable<T> iterable) {
      Preconditions.checkNotNull(iterable);
      return new Iterator<T>() {
         Iterator<T> iterator = Iterators.emptyIterator();
         Iterator<T> removeFrom;

         public boolean hasNext() {
            if (!this.iterator.hasNext()) {
               this.iterator = iterable.iterator();
            }

            return this.iterator.hasNext();
         }

         public T next() {
            if (!this.hasNext()) {
               throw new NoSuchElementException();
            } else {
               this.removeFrom = this.iterator;
               return this.iterator.next();
            }
         }

         public void remove() {
            CollectPreconditions.checkRemove(this.removeFrom != null);
            this.removeFrom.remove();
            this.removeFrom = null;
         }
      };
   }

   public static <T> Iterator<T> cycle(T... elements) {
      return cycle((Iterable)Lists.newArrayList(elements));
   }

   public static <T> Iterator<T> concat(Iterator<? extends T> a, Iterator<? extends T> b) {
      return concat((Iterator)ImmutableList.of(a, b).iterator());
   }

   public static <T> Iterator<T> concat(Iterator<? extends T> a, Iterator<? extends T> b, Iterator<? extends T> c) {
      return concat((Iterator)ImmutableList.of(a, b, c).iterator());
   }

   public static <T> Iterator<T> concat(Iterator<? extends T> a, Iterator<? extends T> b, Iterator<? extends T> c, Iterator<? extends T> d) {
      return concat((Iterator)ImmutableList.of(a, b, c, d).iterator());
   }

   public static <T> Iterator<T> concat(Iterator<? extends T>... inputs) {
      return concat((Iterator)ImmutableList.copyOf((Object[])inputs).iterator());
   }

   public static <T> Iterator<T> concat(Iterator<? extends Iterator<? extends T>> inputs) {
      Preconditions.checkNotNull(inputs);
      return new Iterator<T>() {
         Iterator<? extends T> current = Iterators.emptyIterator();
         Iterator<? extends T> removeFrom;

         public boolean hasNext() {
            boolean currentHasNext;
            while(!(currentHasNext = ((Iterator)Preconditions.checkNotNull(this.current)).hasNext()) && inputs.hasNext()) {
               this.current = (Iterator)inputs.next();
            }

            return currentHasNext;
         }

         public T next() {
            if (!this.hasNext()) {
               throw new NoSuchElementException();
            } else {
               this.removeFrom = this.current;
               return this.current.next();
            }
         }

         public void remove() {
            CollectPreconditions.checkRemove(this.removeFrom != null);
            this.removeFrom.remove();
            this.removeFrom = null;
         }
      };
   }

   public static <T> UnmodifiableIterator<List<T>> partition(Iterator<T> iterator, int size) {
      return partitionImpl(iterator, size, false);
   }

   public static <T> UnmodifiableIterator<List<T>> paddedPartition(Iterator<T> iterator, int size) {
      return partitionImpl(iterator, size, true);
   }

   private static <T> UnmodifiableIterator<List<T>> partitionImpl(Iterator<T> iterator, int size, boolean pad) {
      Preconditions.checkNotNull(iterator);
      Preconditions.checkArgument(size > 0);
      return new UnmodifiableIterator<List<T>>() {
         public boolean hasNext() {
            return iterator.hasNext();
         }

         public List<T> next() {
            if (!this.hasNext()) {
               throw new NoSuchElementException();
            } else {
               Object[] array = new Object[size];

               int count;
               for(count = 0; count < size && iterator.hasNext(); ++count) {
                  array[count] = iterator.next();
               }

               for(int i = count; i < size; ++i) {
                  array[i] = null;
               }

               List<T> list = Collections.unmodifiableList(Arrays.asList(array));
               return !pad && count != size ? list.subList(0, count) : list;
            }
         }
      };
   }

   public static <T> UnmodifiableIterator<T> filter(Iterator<T> unfiltered, Predicate<? super T> predicate) {
      Preconditions.checkNotNull(unfiltered);
      Preconditions.checkNotNull(predicate);
      return new AbstractIterator<T>() {
         protected T computeNext() {
            while(true) {
               if (unfiltered.hasNext()) {
                  T element = unfiltered.next();
                  if (!predicate.apply(element)) {
                     continue;
                  }

                  return element;
               }

               return this.endOfData();
            }
         }
      };
   }

   @GwtIncompatible("Class.isInstance")
   public static <T> UnmodifiableIterator<T> filter(Iterator<?> unfiltered, Class<T> type) {
      return filter(unfiltered, Predicates.instanceOf(type));
   }

   public static <T> boolean any(Iterator<T> iterator, Predicate<? super T> predicate) {
      return indexOf(iterator, predicate) != -1;
   }

   public static <T> boolean all(Iterator<T> iterator, Predicate<? super T> predicate) {
      Preconditions.checkNotNull(predicate);

      Object element;
      do {
         if (!iterator.hasNext()) {
            return true;
         }

         element = iterator.next();
      } while(predicate.apply(element));

      return false;
   }

   public static <T> T find(Iterator<T> iterator, Predicate<? super T> predicate) {
      return filter(iterator, predicate).next();
   }

   @Nullable
   public static <T> T find(Iterator<? extends T> iterator, Predicate<? super T> predicate, @Nullable T defaultValue) {
      return getNext(filter(iterator, predicate), defaultValue);
   }

   public static <T> Optional<T> tryFind(Iterator<T> iterator, Predicate<? super T> predicate) {
      UnmodifiableIterator<T> filteredIterator = filter(iterator, predicate);
      return filteredIterator.hasNext() ? Optional.of(filteredIterator.next()) : Optional.absent();
   }

   public static <T> int indexOf(Iterator<T> iterator, Predicate<? super T> predicate) {
      Preconditions.checkNotNull(predicate, "predicate");

      for(int i = 0; iterator.hasNext(); ++i) {
         T current = iterator.next();
         if (predicate.apply(current)) {
            return i;
         }
      }

      return -1;
   }

   public static <F, T> Iterator<T> transform(Iterator<F> fromIterator, Function<? super F, ? extends T> function) {
      Preconditions.checkNotNull(function);
      return new TransformedIterator<F, T>(fromIterator) {
         T transform(F from) {
            return function.apply(from);
         }
      };
   }

   public static <T> T get(Iterator<T> iterator, int position) {
      checkNonnegative(position);
      int skipped = advance(iterator, position);
      if (!iterator.hasNext()) {
         throw new IndexOutOfBoundsException("position (" + position + ") must be less than the number of elements that remained (" + skipped + ")");
      } else {
         return iterator.next();
      }
   }

   static void checkNonnegative(int position) {
      if (position < 0) {
         throw new IndexOutOfBoundsException("position (" + position + ") must not be negative");
      }
   }

   @Nullable
   public static <T> T get(Iterator<? extends T> iterator, int position, @Nullable T defaultValue) {
      checkNonnegative(position);
      advance(iterator, position);
      return getNext(iterator, defaultValue);
   }

   @Nullable
   public static <T> T getNext(Iterator<? extends T> iterator, @Nullable T defaultValue) {
      return iterator.hasNext() ? iterator.next() : defaultValue;
   }

   public static <T> T getLast(Iterator<T> iterator) {
      Object current;
      do {
         current = iterator.next();
      } while(iterator.hasNext());

      return current;
   }

   @Nullable
   public static <T> T getLast(Iterator<? extends T> iterator, @Nullable T defaultValue) {
      return iterator.hasNext() ? getLast(iterator) : defaultValue;
   }

   public static int advance(Iterator<?> iterator, int numberToAdvance) {
      Preconditions.checkNotNull(iterator);
      Preconditions.checkArgument(numberToAdvance >= 0, "numberToAdvance must be nonnegative");

      int i;
      for(i = 0; i < numberToAdvance && iterator.hasNext(); ++i) {
         iterator.next();
      }

      return i;
   }

   public static <T> Iterator<T> limit(Iterator<T> iterator, int limitSize) {
      Preconditions.checkNotNull(iterator);
      Preconditions.checkArgument(limitSize >= 0, "limit is negative");
      return new Iterator<T>() {
         private int count;

         public boolean hasNext() {
            return this.count < limitSize && iterator.hasNext();
         }

         public T next() {
            if (!this.hasNext()) {
               throw new NoSuchElementException();
            } else {
               ++this.count;
               return iterator.next();
            }
         }

         public void remove() {
            iterator.remove();
         }
      };
   }

   public static <T> Iterator<T> consumingIterator(Iterator<T> iterator) {
      Preconditions.checkNotNull(iterator);
      return new UnmodifiableIterator<T>() {
         public boolean hasNext() {
            return iterator.hasNext();
         }

         public T next() {
            T next = iterator.next();
            iterator.remove();
            return next;
         }

         public String toString() {
            return "Iterators.consumingIterator(...)";
         }
      };
   }

   @Nullable
   static <T> T pollNext(Iterator<T> iterator) {
      if (iterator.hasNext()) {
         T result = iterator.next();
         iterator.remove();
         return result;
      } else {
         return null;
      }
   }

   static void clear(Iterator<?> iterator) {
      Preconditions.checkNotNull(iterator);

      while(iterator.hasNext()) {
         iterator.next();
         iterator.remove();
      }

   }

   public static <T> UnmodifiableIterator<T> forArray(T... array) {
      return forArray(array, 0, array.length, 0);
   }

   static <T> UnmodifiableListIterator<T> forArray(T[] array, int offset, int length, int index) {
      Preconditions.checkArgument(length >= 0);
      int end = offset + length;
      Preconditions.checkPositionIndexes(offset, end, array.length);
      Preconditions.checkPositionIndex(index, length);
      return (UnmodifiableListIterator)(length == 0 ? emptyListIterator() : new AbstractIndexedListIterator<T>(length, index) {
         protected T get(int index) {
            return array[offset + index];
         }
      });
   }

   public static <T> UnmodifiableIterator<T> singletonIterator(@Nullable T value) {
      return new UnmodifiableIterator<T>() {
         boolean done;

         public boolean hasNext() {
            return !this.done;
         }

         public T next() {
            if (this.done) {
               throw new NoSuchElementException();
            } else {
               this.done = true;
               return value;
            }
         }
      };
   }

   public static <T> UnmodifiableIterator<T> forEnumeration(Enumeration<T> enumeration) {
      Preconditions.checkNotNull(enumeration);
      return new UnmodifiableIterator<T>() {
         public boolean hasNext() {
            return enumeration.hasMoreElements();
         }

         public T next() {
            return enumeration.nextElement();
         }
      };
   }

   public static <T> Enumeration<T> asEnumeration(Iterator<T> iterator) {
      Preconditions.checkNotNull(iterator);
      return new Enumeration<T>() {
         public boolean hasMoreElements() {
            return iterator.hasNext();
         }

         public T nextElement() {
            return iterator.next();
         }
      };
   }

   public static <T> PeekingIterator<T> peekingIterator(Iterator<? extends T> iterator) {
      if (iterator instanceof Iterators.PeekingImpl) {
         Iterators.PeekingImpl<T> peeking = (Iterators.PeekingImpl)iterator;
         return peeking;
      } else {
         return new Iterators.PeekingImpl(iterator);
      }
   }

   /** @deprecated */
   @Deprecated
   public static <T> PeekingIterator<T> peekingIterator(PeekingIterator<T> iterator) {
      return (PeekingIterator)Preconditions.checkNotNull(iterator);
   }

   @Beta
   public static <T> UnmodifiableIterator<T> mergeSorted(Iterable<? extends Iterator<? extends T>> iterators, Comparator<? super T> comparator) {
      Preconditions.checkNotNull(iterators, "iterators");
      Preconditions.checkNotNull(comparator, "comparator");
      return new Iterators.MergingIterator(iterators, comparator);
   }

   static <T> ListIterator<T> cast(Iterator<T> iterator) {
      return (ListIterator)iterator;
   }

   private static class MergingIterator<T> extends UnmodifiableIterator<T> {
      final Queue<PeekingIterator<T>> queue;

      public MergingIterator(Iterable<? extends Iterator<? extends T>> iterators, Comparator<? super T> itemComparator) {
         Comparator<PeekingIterator<T>> heapComparator = new Comparator<PeekingIterator<T>>() {
            public int compare(PeekingIterator<T> o1, PeekingIterator<T> o2) {
               return itemComparator.compare(o1.peek(), o2.peek());
            }
         };
         this.queue = new PriorityQueue(2, heapComparator);
         Iterator i$ = iterators.iterator();

         while(i$.hasNext()) {
            Iterator<? extends T> iterator = (Iterator)i$.next();
            if (iterator.hasNext()) {
               this.queue.add(Iterators.peekingIterator(iterator));
            }
         }

      }

      public boolean hasNext() {
         return !this.queue.isEmpty();
      }

      public T next() {
         PeekingIterator<T> nextIter = (PeekingIterator)this.queue.remove();
         T next = nextIter.next();
         if (nextIter.hasNext()) {
            this.queue.add(nextIter);
         }

         return next;
      }
   }

   private static class PeekingImpl<E> implements PeekingIterator<E> {
      private final Iterator<? extends E> iterator;
      private boolean hasPeeked;
      private E peekedElement;

      public PeekingImpl(Iterator<? extends E> iterator) {
         this.iterator = (Iterator)Preconditions.checkNotNull(iterator);
      }

      public boolean hasNext() {
         return this.hasPeeked || this.iterator.hasNext();
      }

      public E next() {
         if (!this.hasPeeked) {
            return this.iterator.next();
         } else {
            E result = this.peekedElement;
            this.hasPeeked = false;
            this.peekedElement = null;
            return result;
         }
      }

      public void remove() {
         Preconditions.checkState(!this.hasPeeked, "Can't remove after you've peeked at next");
         this.iterator.remove();
      }

      public E peek() {
         if (!this.hasPeeked) {
            this.peekedElement = this.iterator.next();
            this.hasPeeked = true;
         }

         return this.peekedElement;
      }
   }
}
