package com.replaymod.replaystudio.lib.guava.util.concurrent;

import com.replaymod.replaystudio.lib.guava.annotations.Beta;
import java.util.concurrent.ScheduledFuture;

@Beta
public interface ListenableScheduledFuture<V> extends ScheduledFuture<V>, ListenableFuture<V> {
}
