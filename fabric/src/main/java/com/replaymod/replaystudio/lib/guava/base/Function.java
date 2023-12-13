package com.replaymod.replaystudio.lib.guava.base;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
public interface Function<F, T> {
   @Nullable
   T apply(@Nullable F var1);

   boolean equals(@Nullable Object var1);
}
