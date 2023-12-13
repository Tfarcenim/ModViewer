package com.replaymod.lib.com.google.api.client.repackaged.com.google.common.base;

import com.replaymod.lib.com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
public interface Function<F, T> {
   @Nullable
   T apply(@Nullable F var1);

   boolean equals(@Nullable Object var1);
}
