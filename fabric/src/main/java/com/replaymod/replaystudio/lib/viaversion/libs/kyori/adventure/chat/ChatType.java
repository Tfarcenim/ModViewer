package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.chat;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.key.Key;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.key.Keyed;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.Component;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.ComponentLike;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.Examinable;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.ExaminableProperty;
import java.util.Objects;
import java.util.stream.Stream;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ChatType extends Examinable, Keyed {
   ChatType CHAT = new ChatTypeImpl(Key.key("chat"));
   ChatType SAY_COMMAND = new ChatTypeImpl(Key.key("say_command"));
   ChatType MSG_COMMAND_INCOMING = new ChatTypeImpl(Key.key("msg_command_incoming"));
   ChatType MSG_COMMAND_OUTGOING = new ChatTypeImpl(Key.key("msg_command_outgoing"));
   ChatType TEAM_MSG_COMMAND_INCOMING = new ChatTypeImpl(Key.key("team_msg_command_incoming"));
   ChatType TEAM_MSG_COMMAND_OUTGOING = new ChatTypeImpl(Key.key("team_msg_command_outgoing"));
   ChatType EMOTE_COMMAND = new ChatTypeImpl(Key.key("emote_command"));

   @NotNull
   static ChatType chatType(@NotNull final Keyed key) {
      return (ChatType)(key instanceof ChatType ? (ChatType)key : new ChatTypeImpl(((Keyed)Objects.requireNonNull(key, "key")).key()));
   }

   @Contract(
      value = "_ -> new",
      pure = true
   )
   @NotNull
   default ChatType.Bound bind(@NotNull final ComponentLike name) {
      return this.bind(name, (ComponentLike)null);
   }

   @Contract(
      value = "_, _ -> new",
      pure = true
   )
   @NotNull
   default ChatType.Bound bind(@NotNull final ComponentLike name, @Nullable final ComponentLike target) {
      return new ChatTypeImpl.BoundImpl(this, (Component)Objects.requireNonNull(name.asComponent(), "name"), ComponentLike.unbox(target));
   }

   @NotNull
   default Stream<? extends ExaminableProperty> examinableProperties() {
      return Stream.of(ExaminableProperty.of("key", (Object)this.key()));
   }

   public interface Bound extends Examinable {
      @Contract(
         pure = true
      )
      @NotNull
      ChatType type();

      @Contract(
         pure = true
      )
      @NotNull
      Component name();

      @Contract(
         pure = true
      )
      @Nullable
      Component target();

      @NotNull
      default Stream<? extends ExaminableProperty> examinableProperties() {
         return Stream.of(ExaminableProperty.of("type", (Object)this.type()), ExaminableProperty.of("name", (Object)this.name()), ExaminableProperty.of("target", (Object)this.target()));
      }
   }
}
