package com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.mapping;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketType;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketWrapper;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandler;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface PacketMapping {
   void applyType(PacketWrapper var1);

   @Nullable
   PacketHandler handler();

   static PacketMapping of(int mappedPacketId, @Nullable PacketHandler handler) {
      return new PacketIdMapping(mappedPacketId, handler);
   }

   static PacketMapping of(@Nullable PacketType mappedPacketType, @Nullable PacketHandler handler) {
      return new PacketTypeMapping(mappedPacketType, handler);
   }
}
