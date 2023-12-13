package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.serializer.gson;

import com.replaymod.replaystudio.lib.viaversion.libs.gson.Gson;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.GsonBuilder;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonElement;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.builder.AbstractBuilder;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.Component;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.serializer.ComponentSerializer;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.util.Buildable;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.util.PlatformAPI;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ApiStatus.Internal;

public interface GsonComponentSerializer extends ComponentSerializer<Component, Component, String>, Buildable<GsonComponentSerializer, GsonComponentSerializer.Builder> {
   @NotNull
   static GsonComponentSerializer gson() {
      return GsonComponentSerializerImpl.Instances.INSTANCE;
   }

   @NotNull
   static GsonComponentSerializer colorDownsamplingGson() {
      return GsonComponentSerializerImpl.Instances.LEGACY_INSTANCE;
   }

   static GsonComponentSerializer.Builder builder() {
      return new GsonComponentSerializerImpl.BuilderImpl();
   }

   @NotNull
   Gson serializer();

   @NotNull
   UnaryOperator<GsonBuilder> populator();

   @NotNull
   Component deserializeFromTree(@NotNull final JsonElement input);

   @NotNull
   JsonElement serializeToTree(@NotNull final Component component);

   @PlatformAPI
   @Internal
   public interface Provider {
      @PlatformAPI
      @Internal
      @NotNull
      GsonComponentSerializer gson();

      @PlatformAPI
      @Internal
      @NotNull
      GsonComponentSerializer gsonLegacy();

      @PlatformAPI
      @Internal
      @NotNull
      Consumer<GsonComponentSerializer.Builder> builder();
   }

   public interface Builder extends AbstractBuilder<GsonComponentSerializer>, Buildable.Builder<GsonComponentSerializer> {
      @NotNull
      GsonComponentSerializer.Builder downsampleColors();

      @NotNull
      GsonComponentSerializer.Builder legacyHoverEventSerializer(@Nullable final LegacyHoverEventSerializer serializer);

      @NotNull
      GsonComponentSerializer.Builder emitLegacyHoverEvent();

      @NotNull
      GsonComponentSerializer build();
   }
}
