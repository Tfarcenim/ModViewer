package com.replaymod.replaystudio.lib.viaversion.protocols.base;

import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.VersionProvider;

public class BaseVersionProvider implements VersionProvider {
   public int getClosestServerProtocol(UserConnection connection) throws Exception {
      return Via.getAPI().getServerVersion().lowestSupportedVersion();
   }
}
