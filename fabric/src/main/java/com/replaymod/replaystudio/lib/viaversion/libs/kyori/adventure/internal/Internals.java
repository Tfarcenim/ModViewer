package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.internal;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.Examinable;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.string.StringExaminer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class Internals {
   private Internals() {
   }

   @NotNull
   public static String toString(@NotNull final Examinable examinable) {
      return (String)examinable.examine(StringExaminer.simpleEscaping());
   }
}
