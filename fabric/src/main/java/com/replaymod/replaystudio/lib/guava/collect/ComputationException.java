package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
public class ComputationException extends RuntimeException {
   private static final long serialVersionUID = 0L;

   public ComputationException(@Nullable Throwable cause) {
      super(cause);
   }
}
