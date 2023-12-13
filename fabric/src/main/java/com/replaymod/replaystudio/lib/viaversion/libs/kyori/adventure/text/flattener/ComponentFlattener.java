package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.flattener;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.builder.AbstractBuilder;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.Component;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.util.Buildable;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ComponentFlattener extends Buildable<ComponentFlattener, ComponentFlattener.Builder> {
   @NotNull
   static ComponentFlattener.Builder builder() {
      return new ComponentFlattenerImpl.BuilderImpl();
   }

   @NotNull
   static ComponentFlattener basic() {
      return ComponentFlattenerImpl.BASIC;
   }

   @NotNull
   static ComponentFlattener textOnly() {
      return ComponentFlattenerImpl.TEXT_ONLY;
   }

   void flatten(@NotNull final Component input, @NotNull final FlattenerListener listener);

   public interface Builder extends AbstractBuilder<ComponentFlattener>, Buildable.Builder<ComponentFlattener> {
      @NotNull
      <T extends Component> ComponentFlattener.Builder mapper(@NotNull final Class<T> type, @NotNull final Function<T, String> converter);

      @NotNull
      <T extends Component> ComponentFlattener.Builder complexMapper(@NotNull final Class<T> type, @NotNull final BiConsumer<T, Consumer<Component>> converter);

      @NotNull
      ComponentFlattener.Builder unknownMapper(@Nullable final Function<Component, String> converter);
   }
}
