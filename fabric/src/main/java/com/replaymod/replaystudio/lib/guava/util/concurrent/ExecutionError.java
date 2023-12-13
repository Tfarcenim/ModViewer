package com.replaymod.replaystudio.lib.guava.util.concurrent;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
public class ExecutionError extends Error {
   private static final long serialVersionUID = 0L;

   protected ExecutionError() {
   }

   protected ExecutionError(@Nullable String message) {
      super(message);
   }

   public ExecutionError(@Nullable String message, @Nullable Error cause) {
      super(message, cause);
   }

   public ExecutionError(@Nullable Error cause) {
      super(cause);
   }
}
