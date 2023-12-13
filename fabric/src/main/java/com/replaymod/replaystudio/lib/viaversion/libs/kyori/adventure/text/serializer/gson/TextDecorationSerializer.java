package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.serializer.gson;

import com.replaymod.replaystudio.lib.viaversion.libs.gson.TypeAdapter;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.format.TextDecoration;

final class TextDecorationSerializer {
   static final TypeAdapter<TextDecoration> INSTANCE;

   private TextDecorationSerializer() {
   }

   static {
      INSTANCE = IndexedSerializer.strict("text decoration", TextDecoration.NAMES);
   }
}
