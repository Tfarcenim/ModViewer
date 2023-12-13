package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.title;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.Component;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.util.Ticks;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.Examinable;
import java.time.Duration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;
import org.jetbrains.annotations.ApiStatus.NonExtendable;
import org.jetbrains.annotations.ApiStatus.ScheduledForRemoval;

@NonExtendable
public interface Title extends Examinable {
   Title.Times DEFAULT_TIMES = Title.Times.times(Ticks.duration(10L), Ticks.duration(70L), Ticks.duration(20L));

   @NotNull
   static Title title(@NotNull final Component title, @NotNull final Component subtitle) {
      return title(title, subtitle, DEFAULT_TIMES);
   }

   @NotNull
   static Title title(@NotNull final Component title, @NotNull final Component subtitle, @Nullable final Title.Times times) {
      return new TitleImpl(title, subtitle, times);
   }

   @NotNull
   Component title();

   @NotNull
   Component subtitle();

   @Nullable
   Title.Times times();

   @UnknownNullability
   <T> T part(@NotNull final TitlePart<T> part);

   public interface Times extends Examinable {
      /** @deprecated */
      @Deprecated
      @ScheduledForRemoval(
         inVersion = "5.0.0"
      )
      @NotNull
      static Title.Times of(@NotNull final Duration fadeIn, @NotNull final Duration stay, @NotNull final Duration fadeOut) {
         return times(fadeIn, stay, fadeOut);
      }

      @NotNull
      static Title.Times times(@NotNull final Duration fadeIn, @NotNull final Duration stay, @NotNull final Duration fadeOut) {
         return new TitleImpl.TimesImpl(fadeIn, stay, fadeOut);
      }

      @NotNull
      Duration fadeIn();

      @NotNull
      Duration stay();

      @NotNull
      Duration fadeOut();
   }
}
