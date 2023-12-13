package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.examination.ExaminableProperty;
import java.util.stream.Stream;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.ScheduledForRemoval;

public interface TextComponent extends BuildableComponent<TextComponent, TextComponent.Builder>, ScopedComponent<TextComponent> {
   /** @deprecated */
   @Deprecated
   @ScheduledForRemoval(
      inVersion = "5.0.0"
   )
   @NotNull
   static TextComponent ofChildren(@NotNull final ComponentLike... components) {
      return Component.textOfChildren(components);
   }

   @NotNull
   String content();

   @Contract(
      pure = true
   )
   @NotNull
   TextComponent content(@NotNull final String content);

   @NotNull
   default Stream<? extends ExaminableProperty> examinableProperties() {
      return Stream.concat(Stream.of(ExaminableProperty.of("content", this.content())), BuildableComponent.super.examinableProperties());
   }

   public interface Builder extends ComponentBuilder<TextComponent, TextComponent.Builder> {
      @NotNull
      String content();

      @Contract("_ -> this")
      @NotNull
      TextComponent.Builder content(@NotNull final String content);
   }
}
