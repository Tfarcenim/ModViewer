package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.pointer;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.builder.AbstractBuilder;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.util.Buildable;
import java.util.Optional;
import java.util.function.Supplier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

public interface Pointers extends Buildable<Pointers, Pointers.Builder> {
   @Contract(
      pure = true
   )
   @NotNull
   static Pointers empty() {
      return PointersImpl.EMPTY;
   }

   @Contract(
      pure = true
   )
   @NotNull
   static Pointers.Builder builder() {
      return new PointersImpl.BuilderImpl();
   }

   @NotNull
   <T> Optional<T> get(@NotNull final Pointer<T> pointer);

   @Contract("_, null -> _; _, !null -> !null")
   @Nullable
   default <T> T getOrDefault(@NotNull final Pointer<T> pointer, @Nullable final T defaultValue) {
      return this.get(pointer).orElse(defaultValue);
   }

   @UnknownNullability
   default <T> T getOrDefaultFrom(@NotNull final Pointer<T> pointer, @NotNull final Supplier<? extends T> defaultValue) {
      return this.get(pointer).orElseGet(defaultValue);
   }

   <T> boolean supports(@NotNull final Pointer<T> pointer);

   public interface Builder extends AbstractBuilder<Pointers>, Buildable.Builder<Pointers> {
      @Contract("_, _ -> this")
      @NotNull
      default <T> Pointers.Builder withStatic(@NotNull final Pointer<T> pointer, @Nullable final T value) {
         return this.withDynamic(pointer, () -> {
            return value;
         });
      }

      @Contract("_, _ -> this")
      @NotNull
      <T> Pointers.Builder withDynamic(@NotNull final Pointer<T> pointer, @NotNull Supplier<T> value);
   }
}
