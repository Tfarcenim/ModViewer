package com.replaymod.replaystudio.lib.guava.util.concurrent;

import com.replaymod.replaystudio.lib.guava.base.Preconditions;
import java.util.concurrent.Executor;

public abstract class ForwardingListenableFuture<V> extends ForwardingFuture<V> implements ListenableFuture<V> {
   protected ForwardingListenableFuture() {
   }

   protected abstract ListenableFuture<V> delegate();

   public void addListener(Runnable listener, Executor exec) {
      this.delegate().addListener(listener, exec);
   }

   public abstract static class SimpleForwardingListenableFuture<V> extends ForwardingListenableFuture<V> {
      private final ListenableFuture<V> delegate;

      protected SimpleForwardingListenableFuture(ListenableFuture<V> delegate) {
         this.delegate = (ListenableFuture)Preconditions.checkNotNull(delegate);
      }

      protected final ListenableFuture<V> delegate() {
         return this.delegate;
      }
   }
}
