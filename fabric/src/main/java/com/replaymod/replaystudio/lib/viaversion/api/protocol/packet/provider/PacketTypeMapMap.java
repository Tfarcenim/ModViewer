package com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.provider;

import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.ints.Int2ObjectMap;
import java.util.Collection;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

final class PacketTypeMapMap<P> implements PacketTypeMap<P> {
   private final Map<String, P> packetsByName;
   private final Int2ObjectMap<P> packetsById;

   PacketTypeMapMap(Map<String, P> packetsByName, Int2ObjectMap<P> packetsById) {
      this.packetsByName = packetsByName;
      this.packetsById = packetsById;
   }

   @Nullable
   public P typeByName(String packetTypeName) {
      return this.packetsByName.get(packetTypeName);
   }

   @Nullable
   public P typeById(int packetTypeId) {
      return this.packetsById.get(packetTypeId);
   }

   public Collection<P> types() {
      return this.packetsById.values();
   }
}
