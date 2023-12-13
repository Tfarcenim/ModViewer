package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_1to1_19;

import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonElement;

public final class ChatDecorationResult {
   private final JsonElement content;
   private final boolean overlay;

   public ChatDecorationResult(JsonElement content, boolean overlay) {
      this.content = content;
      this.overlay = overlay;
   }

   public JsonElement content() {
      return this.content;
   }

   public boolean overlay() {
      return this.overlay;
   }
}
