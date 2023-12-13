package com.replaymod.replaystudio.lib.viaversion.protocols.base;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketWrapper;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import java.util.UUID;

public class BaseProtocol1_16 extends BaseProtocol1_7 {
   protected UUID passthroughLoginUUID(PacketWrapper wrapper) throws Exception {
      return (UUID)wrapper.passthrough(Type.UUID);
   }
}
