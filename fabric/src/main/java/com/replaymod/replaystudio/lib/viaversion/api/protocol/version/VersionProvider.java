package com.replaymod.replaystudio.lib.viaversion.api.protocol.version;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.platform.providers.Provider;

public interface VersionProvider extends Provider {
   int getClosestServerProtocol(UserConnection var1) throws Exception;
}
