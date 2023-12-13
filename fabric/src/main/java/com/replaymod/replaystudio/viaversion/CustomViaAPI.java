package com.replaymod.replaystudio.viaversion;

import com.replaymod.replaystudio.lib.viaversion.ViaAPIBase;
import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import io.netty.buffer.ByteBuf;
import java.util.SortedSet;
import java.util.UUID;

class CustomViaAPI extends ViaAPIBase<Void> {
   static final ThreadLocal<CustomViaAPI> INSTANCE = new ThreadLocal();
   private final int sourceVersion;
   private final UserConnection userConnection;

   CustomViaAPI(int sourceVersion, UserConnection userConnection) {
      this.sourceVersion = sourceVersion;
      this.userConnection = userConnection;
   }

   UserConnection user() {
      return this.userConnection;
   }

   public int getPlayerVersion(Void aVoid) {
      throw new UnsupportedOperationException();
   }

   public int getPlayerVersion(UUID uuid) {
      if (uuid.equals(this.userConnection.getProtocolInfo().getUuid())) {
         return this.sourceVersion;
      } else {
         throw new UnsupportedOperationException();
      }
   }

   public boolean isInjected(UUID uuid) {
      return this.sourceVersion >= 107;
   }

   public String getVersion() {
      return Via.getPlatform().getPluginVersion();
   }

   public void sendRawPacket(Void aVoid, ByteBuf byteBuf) throws IllegalArgumentException {
      throw new UnsupportedOperationException();
   }

   public void sendRawPacket(UUID uuid, ByteBuf byteBuf) throws IllegalArgumentException {
      if (uuid.equals(this.userConnection.getProtocolInfo().getUuid())) {
         this.userConnection.sendRawPacket(byteBuf);
      } else {
         throw new UnsupportedOperationException();
      }
   }

   public SortedSet<Integer> getSupportedVersions() {
      return Via.getManager().getProtocolManager().getSupportedVersions();
   }
}
