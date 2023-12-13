package com.replaymod.lib.com.google.api.client.util;

public final class Throwables {
   public static RuntimeException propagate(Throwable throwable) {
      return com.replaymod.lib.com.google.api.client.repackaged.com.google.common.base.Throwables.propagate(throwable);
   }

   public static void propagateIfPossible(Throwable throwable) {
      com.replaymod.lib.com.google.api.client.repackaged.com.google.common.base.Throwables.propagateIfPossible(throwable);
   }

   public static <X extends Throwable> void propagateIfPossible(Throwable throwable, Class<X> declaredType) throws X {
      com.replaymod.lib.com.google.api.client.repackaged.com.google.common.base.Throwables.propagateIfPossible(throwable, declaredType);
   }

   private Throwables() {
   }
}
