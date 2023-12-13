package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.builder.AbstractBuilder;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.format.Style;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.util.Buildable;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.Examinable;
import java.util.function.Function;
import java.util.function.Predicate;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.NonExtendable;

@NonExtendable
public interface JoinConfiguration extends Buildable<JoinConfiguration, JoinConfiguration.Builder>, Examinable {
   @NotNull
   static JoinConfiguration.Builder builder() {
      return new JoinConfigurationImpl.BuilderImpl();
   }

   @NotNull
   static JoinConfiguration noSeparators() {
      return JoinConfigurationImpl.NULL;
   }

   @NotNull
   static JoinConfiguration newlines() {
      return JoinConfigurationImpl.STANDARD_NEW_LINES;
   }

   @NotNull
   static JoinConfiguration commas(final boolean spaces) {
      return spaces ? JoinConfigurationImpl.STANDARD_COMMA_SPACE_SEPARATED : JoinConfigurationImpl.STANDARD_COMMA_SEPARATED;
   }

   @NotNull
   static JoinConfiguration arrayLike() {
      return JoinConfigurationImpl.STANDARD_ARRAY_LIKE;
   }

   @NotNull
   static JoinConfiguration separator(@Nullable final ComponentLike separator) {
      return (JoinConfiguration)(separator == null ? JoinConfigurationImpl.NULL : (JoinConfiguration)builder().separator(separator).build());
   }

   @NotNull
   static JoinConfiguration separators(@Nullable final ComponentLike separator, @Nullable final ComponentLike lastSeparator) {
      return (JoinConfiguration)(separator == null && lastSeparator == null ? JoinConfigurationImpl.NULL : (JoinConfiguration)builder().separator(separator).lastSeparator(lastSeparator).build());
   }

   @Nullable
   Component prefix();

   @Nullable
   Component suffix();

   @Nullable
   Component separator();

   @Nullable
   Component lastSeparator();

   @Nullable
   Component lastSeparatorIfSerial();

   @NotNull
   Function<ComponentLike, Component> convertor();

   @NotNull
   Predicate<ComponentLike> predicate();

   @NotNull
   Style parentStyle();

   public interface Builder extends AbstractBuilder<JoinConfiguration>, Buildable.Builder<JoinConfiguration> {
      @Contract("_ -> this")
      @NotNull
      JoinConfiguration.Builder prefix(@Nullable final ComponentLike prefix);

      @Contract("_ -> this")
      @NotNull
      JoinConfiguration.Builder suffix(@Nullable final ComponentLike suffix);

      @Contract("_ -> this")
      @NotNull
      JoinConfiguration.Builder separator(@Nullable final ComponentLike separator);

      @Contract("_ -> this")
      @NotNull
      JoinConfiguration.Builder lastSeparator(@Nullable final ComponentLike lastSeparator);

      @Contract("_ -> this")
      @NotNull
      JoinConfiguration.Builder lastSeparatorIfSerial(@Nullable final ComponentLike lastSeparatorIfSerial);

      @Contract("_ -> this")
      @NotNull
      JoinConfiguration.Builder convertor(@NotNull final Function<ComponentLike, Component> convertor);

      @Contract("_ -> this")
      @NotNull
      JoinConfiguration.Builder predicate(@NotNull final Predicate<ComponentLike> predicate);

      @Contract("_ -> this")
      @NotNull
      JoinConfiguration.Builder parentStyle(@NotNull final Style parentStyle);
   }
}
