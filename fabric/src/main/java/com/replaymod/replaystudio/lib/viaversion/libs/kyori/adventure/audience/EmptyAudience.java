package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.audience;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.chat.ChatType;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.chat.SignedMessage;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.identity.Identified;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.identity.Identity;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.inventory.Book;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.pointer.Pointer;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.Component;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.ComponentLike;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

final class EmptyAudience implements Audience {
   static final EmptyAudience INSTANCE = new EmptyAudience();

   @NotNull
   public <T> Optional<T> get(@NotNull final Pointer<T> pointer) {
      return Optional.empty();
   }

   @Contract("_, null -> null; _, !null -> !null")
   @Nullable
   public <T> T getOrDefault(@NotNull final Pointer<T> pointer, @Nullable final T defaultValue) {
      return defaultValue;
   }

   @UnknownNullability
   public <T> T getOrDefaultFrom(@NotNull final Pointer<T> pointer, @NotNull final Supplier<? extends T> defaultValue) {
      return defaultValue.get();
   }

   @NotNull
   public Audience filterAudience(@NotNull final Predicate<? super Audience> filter) {
      return this;
   }

   public void forEachAudience(@NotNull final Consumer<? super Audience> action) {
   }

   public void sendMessage(@NotNull final ComponentLike message) {
   }

   public void sendMessage(@NotNull final Component message) {
   }

   /** @deprecated */
   @Deprecated
   public void sendMessage(@NotNull final Identified source, @NotNull final Component message, @NotNull final MessageType type) {
   }

   /** @deprecated */
   @Deprecated
   public void sendMessage(@NotNull final Identity source, @NotNull final Component message, @NotNull final MessageType type) {
   }

   public void sendMessage(@NotNull final Component message, @NotNull final ChatType.Bound boundChatType) {
   }

   public void sendMessage(@NotNull final SignedMessage signedMessage, @NotNull final ChatType.Bound boundChatType) {
   }

   public void deleteMessage(@NotNull final SignedMessage.Signature signature) {
   }

   public void sendActionBar(@NotNull final ComponentLike message) {
   }

   public void sendPlayerListHeader(@NotNull final ComponentLike header) {
   }

   public void sendPlayerListFooter(@NotNull final ComponentLike footer) {
   }

   public void sendPlayerListHeaderAndFooter(@NotNull final ComponentLike header, @NotNull final ComponentLike footer) {
   }

   public void openBook(@NotNull final Book.Builder book) {
   }

   public boolean equals(final Object that) {
      return this == that;
   }

   public int hashCode() {
      return 0;
   }

   public String toString() {
      return "EmptyAudience";
   }
}
