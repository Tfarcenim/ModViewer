package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.audience;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.ComponentLike;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public final class Audiences {
   static final Collector<? super Audience, ?, ForwardingAudience> COLLECTOR = Collectors.collectingAndThen(Collectors.toCollection(ArrayList::new), (audiences) -> {
      return Audience.audience((Iterable)Collections.unmodifiableCollection(audiences));
   });

   private Audiences() {
   }

   @NotNull
   public static Consumer<? super Audience> sendingMessage(@NotNull final ComponentLike message) {
      return (audience) -> {
         audience.sendMessage(message);
      };
   }
}
