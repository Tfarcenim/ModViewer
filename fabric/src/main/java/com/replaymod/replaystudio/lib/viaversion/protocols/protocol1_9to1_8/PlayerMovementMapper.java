package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9to1_8;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketWrapper;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandler;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9to1_8.storage.MovementTracker;

public class PlayerMovementMapper implements PacketHandler {
   public void handle(PacketWrapper wrapper) throws Exception {
      MovementTracker tracker = (MovementTracker)wrapper.user().get(MovementTracker.class);
      tracker.incrementIdlePacket();
      if (wrapper.is(Type.BOOLEAN, 0)) {
         tracker.setGround((Boolean)wrapper.get(Type.BOOLEAN, 0));
      }

   }
}
