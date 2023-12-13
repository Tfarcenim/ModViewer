package com.replaymod.replaystudio.lib.viaversion.api.rewriter;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.Protocol;

public interface Rewriter<T extends Protocol> {
   void register();

   T protocol();

   default void onMappingDataLoaded() {
   }
}
