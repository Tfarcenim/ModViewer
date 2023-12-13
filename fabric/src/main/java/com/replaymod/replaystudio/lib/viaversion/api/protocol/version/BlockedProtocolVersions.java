package com.replaymod.replaystudio.lib.viaversion.api.protocol.version;

import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.ints.IntSet;

public interface BlockedProtocolVersions {
   boolean contains(int var1);

   int blocksBelow();

   int blocksAbove();

   IntSet singleBlockedVersions();
}
