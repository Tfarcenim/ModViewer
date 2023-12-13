package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9to1_8.providers;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.platform.providers.Provider;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9to1_8.Protocol1_9To1_8;

public class EntityIdProvider implements Provider {
   public int getEntityId(UserConnection user) throws Exception {
      return user.getEntityTracker(Protocol1_9To1_8.class).clientEntityId();
   }
}
