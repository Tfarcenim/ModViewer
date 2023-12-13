package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_12to1_11_1.providers;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.platform.providers.Provider;

public class InventoryQuickMoveProvider implements Provider {
   public boolean registerQuickMoveAction(short windowId, short slotId, short actionId, UserConnection userConnection) {
      return false;
   }
}
