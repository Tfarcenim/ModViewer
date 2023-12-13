package com.replaymod.replaystudio.lib.guava.util.concurrent;

import com.replaymod.replaystudio.lib.guava.annotations.Beta;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Beta
public interface CheckedFuture<V, X extends Exception> extends ListenableFuture<V> {
   V checkedGet() throws X;

   V checkedGet(long var1, TimeUnit var3) throws TimeoutException, X;
}
