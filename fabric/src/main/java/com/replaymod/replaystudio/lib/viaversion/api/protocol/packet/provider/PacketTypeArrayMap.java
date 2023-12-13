package com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.provider;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

final class PacketTypeArrayMap<P> implements PacketTypeMap<P> {
   private final Map<String, P> packetsByName;
   private final P[] packets;

   PacketTypeArrayMap(Map<String, P> packetsByName, P[] packets) {
      this.packetsByName = packetsByName;
      this.packets = packets;
   }

   @Nullable
   public P typeByName(String packetTypeName) {
      return this.packetsByName.get(packetTypeName);
   }

   @Nullable
   public P typeById(int packetTypeId) {
      return packetTypeId >= 0 && packetTypeId < this.packets.length ? this.packets[packetTypeId] : null;
   }

   public Collection<P> types() {
      return Arrays.asList(this.packets);
   }
}
