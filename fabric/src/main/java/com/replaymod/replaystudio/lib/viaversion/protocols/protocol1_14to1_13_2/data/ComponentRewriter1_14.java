package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_14to1_13_2.data;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.Protocol;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.ClientboundPacketType;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonObject;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.data.ComponentRewriter1_13;

public class ComponentRewriter1_14<C extends ClientboundPacketType> extends ComponentRewriter1_13<C> {
   public ComponentRewriter1_14(Protocol<C, ?, ?, ?> protocol) {
      super(protocol);
   }

   protected void handleTranslate(JsonObject object, String translate) {
   }
}
