package com.replaymod.replaystudio.lib.guava.base;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
public interface Predicate<T> {
   boolean apply(@Nullable T var1);

   boolean equals(@Nullable Object var1);
}
