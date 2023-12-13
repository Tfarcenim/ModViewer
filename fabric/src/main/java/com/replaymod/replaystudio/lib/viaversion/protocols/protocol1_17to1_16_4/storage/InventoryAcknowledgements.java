package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_17to1_16_4.storage;

import com.replaymod.replaystudio.lib.viaversion.api.connection.StorableObject;
import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.ints.IntArrayList;
import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.ints.IntList;

public final class InventoryAcknowledgements implements StorableObject {
   private final IntList ids = new IntArrayList();

   public void addId(int id) {
      this.ids.add(id);
   }

   public boolean removeId(int id) {
      return this.ids.rem(id);
   }
}
