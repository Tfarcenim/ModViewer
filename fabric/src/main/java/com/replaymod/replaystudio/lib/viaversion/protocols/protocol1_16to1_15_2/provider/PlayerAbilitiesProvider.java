package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16to1_15_2.provider;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.platform.providers.Provider;

public class PlayerAbilitiesProvider implements Provider {
   public float getFlyingSpeed(UserConnection connection) {
      return 0.05F;
   }

   public float getWalkingSpeed(UserConnection connection) {
      return 0.1F;
   }
}
