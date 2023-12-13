package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_4to1_19_3.rewriter;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.Protocol;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.ClientboundPacketType;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketWrapper;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_3to1_19_1.rewriter.RecipeRewriter1_19_3;

public class RecipeRewriter1_19_4<C extends ClientboundPacketType> extends RecipeRewriter1_19_3<C> {
   public RecipeRewriter1_19_4(Protocol<C, ?, ?, ?> protocol) {
      super(protocol);
   }

   public void handleCraftingShaped(PacketWrapper wrapper) throws Exception {
      super.handleCraftingShaped(wrapper);
      wrapper.passthrough(Type.BOOLEAN);
   }
}
