package com.replaymod.replaystudio.lib.guava.util.concurrent;

import com.replaymod.replaystudio.lib.guava.annotations.Beta;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Beta
public interface ListeningScheduledExecutorService extends ScheduledExecutorService, ListeningExecutorService {
   ListenableScheduledFuture<?> schedule(Runnable var1, long var2, TimeUnit var4);

   <V> ListenableScheduledFuture<V> schedule(Callable<V> var1, long var2, TimeUnit var4);

   ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable var1, long var2, long var4, TimeUnit var6);

   ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable var1, long var2, long var4, TimeUnit var6);
}
