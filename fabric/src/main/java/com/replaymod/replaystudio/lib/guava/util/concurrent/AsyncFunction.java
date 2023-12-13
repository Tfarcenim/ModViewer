package com.replaymod.replaystudio.lib.guava.util.concurrent;

public interface AsyncFunction<I, O> {
   ListenableFuture<O> apply(I var1) throws Exception;
}
