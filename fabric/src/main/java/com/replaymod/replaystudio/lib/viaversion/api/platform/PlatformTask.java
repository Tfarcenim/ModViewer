package com.replaymod.replaystudio.lib.viaversion.api.platform;

import org.checkerframework.checker.nullness.qual.Nullable;

public interface PlatformTask<T> {
   /** @deprecated */
   @Deprecated
   @Nullable
   T getObject();

   void cancel();
}
