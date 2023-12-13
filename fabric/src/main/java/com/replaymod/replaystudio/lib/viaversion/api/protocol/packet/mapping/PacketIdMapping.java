package com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.mapping;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketWrapper;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandler;
import org.checkerframework.checker.nullness.qual.Nullable;

final class PacketIdMapping implements PacketMapping {
   private final int mappedPacketId;
   private final PacketHandler handler;

   PacketIdMapping(int mappedPacketId, @Nullable PacketHandler handler) {
      this.mappedPacketId = mappedPacketId;
      this.handler = handler;
   }

   public void applyType(PacketWrapper wrapper) {
      wrapper.setId(this.mappedPacketId);
   }

   @Nullable
   public PacketHandler handler() {
      return this.handler;
   }
}
