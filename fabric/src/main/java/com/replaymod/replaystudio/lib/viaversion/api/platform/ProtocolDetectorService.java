package com.replaymod.replaystudio.lib.viaversion.api.platform;

import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.objects.Object2IntMap;

public interface ProtocolDetectorService {
   int serverProtocolVersion(String var1);

   void probeAllServers();

   void setProtocolVersion(String var1, int var2);

   int uncacheProtocolVersion(String var1);

   Object2IntMap<String> detectedProtocolVersions();
}
