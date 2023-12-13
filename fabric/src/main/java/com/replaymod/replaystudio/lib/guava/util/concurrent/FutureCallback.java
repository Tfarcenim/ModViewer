package com.replaymod.replaystudio.lib.guava.util.concurrent;

import javax.annotation.Nullable;

public interface FutureCallback<V> {
   void onSuccess(@Nullable V var1);

   void onFailure(Throwable var1);
}
