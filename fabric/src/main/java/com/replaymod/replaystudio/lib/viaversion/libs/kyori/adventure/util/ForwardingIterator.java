package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.util;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;

public final class ForwardingIterator<T> implements Iterable<T> {
   private final Supplier<Iterator<T>> iterator;
   private final Supplier<Spliterator<T>> spliterator;

   public ForwardingIterator(@NotNull final Supplier<Iterator<T>> iterator, @NotNull final Supplier<Spliterator<T>> spliterator) {
      this.iterator = (Supplier)Objects.requireNonNull(iterator, "iterator");
      this.spliterator = (Supplier)Objects.requireNonNull(spliterator, "spliterator");
   }

   @NotNull
   public Iterator<T> iterator() {
      return (Iterator)this.iterator.get();
   }

   @NotNull
   public Spliterator<T> spliterator() {
      return (Spliterator)this.spliterator.get();
   }
}
