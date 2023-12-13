package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Collection;
import java.util.EnumSet;

@GwtCompatible(
   serializable = true,
   emulated = true
)
final class ImmutableEnumSet<E extends Enum<E>> extends ImmutableSet<E> {
   private final transient EnumSet<E> delegate;
   private transient int hashCode;

   static <E extends Enum<E>> ImmutableSet<E> asImmutable(EnumSet<E> set) {
      switch(set.size()) {
      case 0:
         return ImmutableSet.of();
      case 1:
         return ImmutableSet.of(Iterables.getOnlyElement(set));
      default:
         return new ImmutableEnumSet(set);
      }
   }

   private ImmutableEnumSet(EnumSet<E> delegate) {
      this.delegate = delegate;
   }

   boolean isPartialView() {
      return false;
   }

   public UnmodifiableIterator<E> iterator() {
      return Iterators.unmodifiableIterator(this.delegate.iterator());
   }

   public int size() {
      return this.delegate.size();
   }

   public boolean contains(Object object) {
      return this.delegate.contains(object);
   }

   public boolean containsAll(Collection<?> collection) {
      return this.delegate.containsAll(collection);
   }

   public boolean isEmpty() {
      return this.delegate.isEmpty();
   }

   public boolean equals(Object object) {
      return object == this || this.delegate.equals(object);
   }

   public int hashCode() {
      int result = this.hashCode;
      return result == 0 ? (this.hashCode = this.delegate.hashCode()) : result;
   }

   public String toString() {
      return this.delegate.toString();
   }

   Object writeReplace() {
      return new ImmutableEnumSet.EnumSerializedForm(this.delegate);
   }

   // $FF: synthetic method
   ImmutableEnumSet(EnumSet x0, Object x1) {
      this(x0);
   }

   private static class EnumSerializedForm<E extends Enum<E>> implements Serializable {
      final EnumSet<E> delegate;
      private static final long serialVersionUID = 0L;

      EnumSerializedForm(EnumSet<E> delegate) {
         this.delegate = delegate;
      }

      Object readResolve() {
         return new ImmutableEnumSet(this.delegate.clone());
      }
   }
}
