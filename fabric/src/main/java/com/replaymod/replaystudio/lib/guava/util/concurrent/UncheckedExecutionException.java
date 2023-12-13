package com.replaymod.replaystudio.lib.guava.util.concurrent;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
public class UncheckedExecutionException extends RuntimeException {
   private static final long serialVersionUID = 0L;

   protected UncheckedExecutionException() {
   }

   protected UncheckedExecutionException(@Nullable String message) {
      super(message);
   }

   public UncheckedExecutionException(@Nullable String message, @Nullable Throwable cause) {
      super(message, cause);
   }

   public UncheckedExecutionException(@Nullable Throwable cause) {
      super(cause);
   }
}
