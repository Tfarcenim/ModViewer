package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.chat;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.internal.Internals;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.key.Key;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class ChatTypeImpl implements ChatType {
   private final Key key;

   ChatTypeImpl(@NotNull final Key key) {
      this.key = key;
   }

   @NotNull
   public Key key() {
      return this.key;
   }

   public String toString() {
      return Internals.toString(this);
   }

   static final class BoundImpl implements ChatType.Bound {
      private final ChatType chatType;
      private final Component name;
      @Nullable
      private final Component target;

      BoundImpl(final ChatType chatType, final Component name, @Nullable final Component target) {
         this.chatType = chatType;
         this.name = name;
         this.target = target;
      }

      @NotNull
      public ChatType type() {
         return this.chatType;
      }

      @NotNull
      public Component name() {
         return this.name;
      }

      @Nullable
      public Component target() {
         return this.target;
      }

      public String toString() {
         return Internals.toString(this);
      }
   }
}
