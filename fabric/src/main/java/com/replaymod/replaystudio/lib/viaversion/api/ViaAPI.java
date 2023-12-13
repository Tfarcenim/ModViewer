package com.replaymod.replaystudio.lib.viaversion.api;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.legacy.LegacyViaAPI;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.ServerProtocolVersion;
import io.netty.buffer.ByteBuf;
import java.util.SortedSet;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface ViaAPI<T> {
   default int majorVersion() {
      return 4;
   }

   default int apiVersion() {
      return 19;
   }

   ServerProtocolVersion getServerVersion();

   int getPlayerVersion(T var1);

   int getPlayerVersion(UUID var1);

   boolean isInjected(UUID var1);

   @Nullable
   UserConnection getConnection(UUID var1);

   String getVersion();

   void sendRawPacket(T var1, ByteBuf var2);

   void sendRawPacket(UUID var1, ByteBuf var2);

   SortedSet<Integer> getSupportedVersions();

   SortedSet<Integer> getFullSupportedVersions();

   LegacyViaAPI<T> legacyAPI();
}
