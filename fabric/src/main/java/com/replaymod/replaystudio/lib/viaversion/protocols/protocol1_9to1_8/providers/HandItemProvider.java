package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9to1_8.providers;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.DataItem;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.Item;
import com.replaymod.replaystudio.lib.viaversion.api.platform.providers.Provider;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;

public class HandItemProvider implements Provider {
   public Item getHandItem(UserConnection info) {
      return new DataItem(0, (byte)0, (short)0, (CompoundTag)null);
   }
}
