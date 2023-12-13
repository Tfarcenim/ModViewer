package com.replaymod.replaystudio.viaversion;

import com.replaymod.replaystudio.lib.viaversion.api.connection.ConnectionManager;
import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class CustomConnectionManager implements ConnectionManager {
   public boolean isClientConnected(UUID uuid) {
      return this.getConnectedClient(uuid) != null;
   }

   public UserConnection getConnectedClient(UUID uuid) {
      UserConnection user = ((CustomViaAPI)CustomViaAPI.INSTANCE.get()).user();
      if (uuid.equals(user.getProtocolInfo().getUuid())) {
         return user;
      } else {
         throw new UnsupportedOperationException();
      }
   }

   public UUID getConnectedClientId(UserConnection userConnection) {
      return userConnection.getProtocolInfo().getUuid();
   }

   public Set<UserConnection> getConnections() {
      return Collections.singleton(((CustomViaAPI)CustomViaAPI.INSTANCE.get()).user());
   }

   public Map<UUID, UserConnection> getConnectedClients() {
      UserConnection user = ((CustomViaAPI)CustomViaAPI.INSTANCE.get()).user();
      UUID uuid = user.getProtocolInfo().getUuid();
      return Collections.singletonMap(uuid, user);
   }

   public void onLoginSuccess(UserConnection userConnection) {
   }

   public void onDisconnect(UserConnection userConnection) {
   }
}
