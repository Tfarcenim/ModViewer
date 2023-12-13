package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.serializer.gson.legacyimpl;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.serializer.gson.LegacyHoverEventSerializer;
import org.jetbrains.annotations.NotNull;

public interface NBTLegacyHoverEventSerializer extends LegacyHoverEventSerializer {
   @NotNull
   static LegacyHoverEventSerializer get() {
      return NBTLegacyHoverEventSerializerImpl.INSTANCE;
   }
}
