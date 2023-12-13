package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_11to1_10.storage;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.Entity1_11Types;
import com.replaymod.replaystudio.lib.viaversion.data.entity.EntityTrackerBase;
import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.ints.IntSet;
import com.replaymod.replaystudio.lib.viaversion.libs.flare.fastutil.Int2ObjectSyncMap;

public class EntityTracker1_11 extends EntityTrackerBase {
   private final IntSet holograms = Int2ObjectSyncMap.hashset();

   public EntityTracker1_11(UserConnection user) {
      super(user, Entity1_11Types.EntityType.PLAYER);
   }

   public void removeEntity(int entityId) {
      super.removeEntity(entityId);
      this.removeHologram(entityId);
   }

   public boolean addHologram(int entId) {
      return this.holograms.add(entId);
   }

   public boolean isHologram(int entId) {
      return this.holograms.contains(entId);
   }

   public void removeHologram(int entId) {
      this.holograms.remove(entId);
   }
}
