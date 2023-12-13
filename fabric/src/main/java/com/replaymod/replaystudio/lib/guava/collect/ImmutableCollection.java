package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import com.replaymod.replaystudio.lib.guava.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
   private transient ImmutableList<E> asList;

   ImmutableCollection() {
   }

   public abstract UnmodifiableIterator<E> iterator();

   public final Object[] toArray() {
      int size = this.size();
      if (size == 0) {
         return ObjectArrays.EMPTY_ARRAY;
      } else {
         Object[] result = new Object[this.size()];
         this.copyIntoArray(result, 0);
         return result;
      }
   }

   public final <T> T[] toArray(T[] other) {
      Preconditions.checkNotNull(other);
      int size = this.size();
      if (other.length < size) {
         other = ObjectArrays.newArray(other, size);
      } else if (other.length > size) {
         other[size] = null;
      }

      this.copyIntoArray(other, 0);
      return other;
   }

   public boolean contains(@Nullable Object object) {
      return object != null && super.contains(object);
   }

   /** @deprecated */
   @Deprecated
   public final boolean add(E e) {
      throw new UnsupportedOperationException();
   }

   /** @deprecated */
   @Deprecated
   public final boolean remove(Object object) {
      throw new UnsupportedOperationException();
   }

   /** @deprecated */
   @Deprecated
   public final boolean addAll(Collection<? extends E> newElements) {
      throw new UnsupportedOperationException();
   }

   /** @deprecated */
   @Deprecated
   public final boolean removeAll(Collection<?> oldElements) {
      throw new UnsupportedOperationException();
   }

   /** @deprecated */
   @Deprecated
   public final boolean retainAll(Collection<?> elementsToKeep) {
      throw new UnsupportedOperationException();
   }

   /** @deprecated */
   @Deprecated
   public final void clear() {
      throw new UnsupportedOperationException();
   }

   public ImmutableList<E> asList() {
      ImmutableList<E> list = this.asList;
      return list == null ? (this.asList = this.createAsList()) : list;
   }

   ImmutableList<E> createAsList() {
      switch(this.size()) {
      case 0:
         return ImmutableList.of();
      case 1:
         return ImmutableList.of(this.iterator().next());
      default:
         return new RegularImmutableAsList(this, this.toArray());
      }
   }

   abstract boolean isPartialView();

   int copyIntoArray(Object[] dst, int offset) {
      Object e;
      for(Iterator i$ = this.iterator(); i$.hasNext(); dst[offset++] = e) {
         e = i$.next();
      }

      return offset;
   }

   Object writeReplace() {
      return new ImmutableList.SerializedForm(this.toArray());
   }

   abstract static class ArrayBasedBuilder<E> extends ImmutableCollection.Builder<E> {
      Object[] contents;
      int size;

      ArrayBasedBuilder(int initialCapacity) {
         CollectPreconditions.checkNonnegative(initialCapacity, "initialCapacity");
         this.contents = new Object[initialCapacity];
         this.size = 0;
      }

      private void ensureCapacity(int minCapacity) {
         if (this.contents.length < minCapacity) {
            this.contents = ObjectArrays.arraysCopyOf(this.contents, expandedCapacity(this.contents.length, minCapacity));
         }

      }

      public ImmutableCollection.ArrayBasedBuilder<E> add(E element) {
         Preconditions.checkNotNull(element);
         this.ensureCapacity(this.size + 1);
         this.contents[this.size++] = element;
         return this;
      }

      public ImmutableCollection.Builder<E> add(E... elements) {
         ObjectArrays.checkElementsNotNull(elements);
         this.ensureCapacity(this.size + elements.length);
         System.arraycopy(elements, 0, this.contents, this.size, elements.length);
         this.size += elements.length;
         return this;
      }

      public ImmutableCollection.Builder<E> addAll(Iterable<? extends E> elements) {
         if (elements instanceof Collection) {
            Collection<?> collection = (Collection)elements;
            this.ensureCapacity(this.size + collection.size());
         }

         super.addAll(elements);
         return this;
      }
   }

   public abstract static class Builder<E> {
      static final int DEFAULT_INITIAL_CAPACITY = 4;

      static int expandedCapacity(int oldCapacity, int minCapacity) {
         if (minCapacity < 0) {
            throw new AssertionError("cannot store more than MAX_VALUE elements");
         } else {
            int newCapacity = oldCapacity + (oldCapacity >> 1) + 1;
            if (newCapacity < minCapacity) {
               newCapacity = Integer.highestOneBit(minCapacity - 1) << 1;
            }

            if (newCapacity < 0) {
               newCapacity = Integer.MAX_VALUE;
            }

            return newCapacity;
         }
      }

      Builder() {
      }

      public abstract ImmutableCollection.Builder<E> add(E var1);

      public ImmutableCollection.Builder<E> add(E... elements) {
         Object[] arr$ = elements;
         int len$ = elements.length;

         for(int i$ = 0; i$ < len$; ++i$) {
            E element = arr$[i$];
            this.add(element);
         }

         return this;
      }

      public ImmutableCollection.Builder<E> addAll(Iterable<? extends E> elements) {
         Iterator i$ = elements.iterator();

         while(i$.hasNext()) {
            E element = i$.next();
            this.add(element);
         }

         return this;
      }

      public ImmutableCollection.Builder<E> addAll(Iterator<? extends E> elements) {
         while(elements.hasNext()) {
            this.add(elements.next());
         }

         return this;
      }

      public abstract ImmutableCollection<E> build();
   }
}
