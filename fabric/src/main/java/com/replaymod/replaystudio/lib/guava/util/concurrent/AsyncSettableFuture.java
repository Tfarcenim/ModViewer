package com.replaymod.replaystudio.lib.guava.util.concurrent;

import com.replaymod.replaystudio.lib.guava.base.Preconditions;
import javax.annotation.Nullable;

final class AsyncSettableFuture<V> extends ForwardingListenableFuture<V> {
   private final AsyncSettableFuture.NestedFuture<V> nested = new AsyncSettableFuture.NestedFuture();
   private final ListenableFuture<V> dereferenced;

   public static <V> AsyncSettableFuture<V> create() {
      return new AsyncSettableFuture();
   }

   private AsyncSettableFuture() {
      this.dereferenced = Futures.dereference(this.nested);
   }

   protected ListenableFuture<V> delegate() {
      return this.dereferenced;
   }

   public boolean setFuture(ListenableFuture<? extends V> future) {
      return this.nested.setFuture((ListenableFuture)Preconditions.checkNotNull(future));
   }

   public boolean setValue(@Nullable V value) {
      return this.setFuture(Futures.immediateFuture(value));
   }

   public boolean setException(Throwable exception) {
      return this.setFuture(Futures.immediateFailedFuture(exception));
   }

   public boolean isSet() {
      return this.nested.isDone();
   }

   private static final class NestedFuture<V> extends AbstractFuture<ListenableFuture<? extends V>> {
      private NestedFuture() {
      }

      boolean setFuture(ListenableFuture<? extends V> value) {
         boolean result = this.set(value);
         if (this.isCancelled()) {
            value.cancel(this.wasInterrupted());
         }

         return result;
      }

      // $FF: synthetic method
      NestedFuture(Object x0) {
         this();
      }
   }
}
