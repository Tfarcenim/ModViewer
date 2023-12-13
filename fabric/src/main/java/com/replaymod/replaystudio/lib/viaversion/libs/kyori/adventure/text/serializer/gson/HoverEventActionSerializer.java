package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.serializer.gson;

import com.replaymod.replaystudio.lib.viaversion.libs.gson.TypeAdapter;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.event.HoverEvent;

final class HoverEventActionSerializer {
   static final TypeAdapter<HoverEvent.Action<?>> INSTANCE;

   private HoverEventActionSerializer() {
   }

   static {
      INSTANCE = IndexedSerializer.lenient("hover action", HoverEvent.Action.NAMES);
   }
}
