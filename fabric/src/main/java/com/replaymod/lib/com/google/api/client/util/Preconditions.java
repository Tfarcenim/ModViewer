package com.replaymod.lib.com.google.api.client.util;

public final class Preconditions {
   public static void checkArgument(boolean expression) {
      com.replaymod.lib.com.google.api.client.repackaged.com.google.common.base.Preconditions.checkArgument(expression);
   }

   public static void checkArgument(boolean expression, Object errorMessage) {
      com.replaymod.lib.com.google.api.client.repackaged.com.google.common.base.Preconditions.checkArgument(expression, errorMessage);
   }

   public static void checkArgument(boolean expression, String errorMessageTemplate, Object... errorMessageArgs) {
      com.replaymod.lib.com.google.api.client.repackaged.com.google.common.base.Preconditions.checkArgument(expression, errorMessageTemplate, errorMessageArgs);
   }

   public static void checkState(boolean expression) {
      com.replaymod.lib.com.google.api.client.repackaged.com.google.common.base.Preconditions.checkState(expression);
   }

   public static void checkState(boolean expression, Object errorMessage) {
      com.replaymod.lib.com.google.api.client.repackaged.com.google.common.base.Preconditions.checkState(expression, errorMessage);
   }

   public static void checkState(boolean expression, String errorMessageTemplate, Object... errorMessageArgs) {
      com.replaymod.lib.com.google.api.client.repackaged.com.google.common.base.Preconditions.checkState(expression, errorMessageTemplate, errorMessageArgs);
   }

   public static <T> T checkNotNull(T reference) {
      return com.replaymod.lib.com.google.api.client.repackaged.com.google.common.base.Preconditions.checkNotNull(reference);
   }

   public static <T> T checkNotNull(T reference, Object errorMessage) {
      return com.replaymod.lib.com.google.api.client.repackaged.com.google.common.base.Preconditions.checkNotNull(reference, errorMessage);
   }

   public static <T> T checkNotNull(T reference, String errorMessageTemplate, Object... errorMessageArgs) {
      return com.replaymod.lib.com.google.api.client.repackaged.com.google.common.base.Preconditions.checkNotNull(reference, errorMessageTemplate, errorMessageArgs);
   }

   private Preconditions() {
   }
}
