package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.Position;

public abstract class ConnectionHandler {
   public abstract int connect(UserConnection var1, Position var2, int var3);

   public int getBlockData(UserConnection user, Position position) {
      return ConnectionData.blockConnectionProvider.getBlockData(user, position.x(), position.y(), position.z());
   }
}
