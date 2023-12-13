package com.replaymod.replaystudio.lib.guava.util.concurrent;

import com.replaymod.replaystudio.lib.guava.annotations.Beta;

@Beta
public interface FutureFallback<V> {
   ListenableFuture<V> create(Throwable var1) throws Exception;
}
