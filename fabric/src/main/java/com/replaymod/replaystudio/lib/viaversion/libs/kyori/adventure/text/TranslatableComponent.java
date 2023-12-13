package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.translation.Translatable;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.ExaminableProperty;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface TranslatableComponent extends BuildableComponent<TranslatableComponent, TranslatableComponent.Builder>, ScopedComponent<TranslatableComponent> {
   @NotNull
   String key();

   @Contract(
      pure = true
   )
   @NotNull
   default TranslatableComponent key(@NotNull final Translatable translatable) {
      return this.key(((Translatable)Objects.requireNonNull(translatable, "translatable")).translationKey());
   }

   @Contract(
      pure = true
   )
   @NotNull
   TranslatableComponent key(@NotNull final String key);

   @NotNull
   List<Component> args();

   @Contract(
      pure = true
   )
   @NotNull
   TranslatableComponent args(@NotNull final ComponentLike... args);

   @Contract(
      pure = true
   )
   @NotNull
   TranslatableComponent args(@NotNull final List<? extends ComponentLike> args);

   @Nullable
   String fallback();

   @Contract(
      pure = true
   )
   @NotNull
   TranslatableComponent fallback(@Nullable final String fallback);

   @NotNull
   default Stream<? extends ExaminableProperty> examinableProperties() {
      return Stream.concat(Stream.of(ExaminableProperty.of("key", this.key()), ExaminableProperty.of("args", (Object)this.args()), ExaminableProperty.of("fallback", this.fallback())), BuildableComponent.super.examinableProperties());
   }

   public interface Builder extends ComponentBuilder<TranslatableComponent, TranslatableComponent.Builder> {
      @Contract(
         pure = true
      )
      @NotNull
      default TranslatableComponent.Builder key(@NotNull final Translatable translatable) {
         return this.key(((Translatable)Objects.requireNonNull(translatable, "translatable")).translationKey());
      }

      @Contract("_ -> this")
      @NotNull
      TranslatableComponent.Builder key(@NotNull final String key);

      @Contract("_ -> this")
      @NotNull
      TranslatableComponent.Builder args(@NotNull final ComponentBuilder<?, ?> arg);

      @Contract("_ -> this")
      @NotNull
      TranslatableComponent.Builder args(@NotNull final ComponentBuilder<?, ?>... args);

      @Contract("_ -> this")
      @NotNull
      TranslatableComponent.Builder args(@NotNull final Component arg);

      @Contract("_ -> this")
      @NotNull
      TranslatableComponent.Builder args(@NotNull final ComponentLike... args);

      @Contract("_ -> this")
      @NotNull
      TranslatableComponent.Builder args(@NotNull final List<? extends ComponentLike> args);

      @Contract("_ -> this")
      @NotNull
      TranslatableComponent.Builder fallback(@Nullable final String fallback);
   }
}
