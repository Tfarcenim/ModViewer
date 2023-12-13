package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.serializer.gson;

import com.replaymod.replaystudio.lib.viaversion.libs.gson.TypeAdapter;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.event.ClickEvent;

final class ClickEventActionSerializer {
   static final TypeAdapter<ClickEvent.Action> INSTANCE;

   private ClickEventActionSerializer() {
   }

   static {
      INSTANCE = IndexedSerializer.lenient("click action", ClickEvent.Action.NAMES);
   }
}
