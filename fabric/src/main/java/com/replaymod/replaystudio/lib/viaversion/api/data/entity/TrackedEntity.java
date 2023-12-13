package com.replaymod.replaystudio.lib.viaversion.api.data.entity;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.EntityType;

public interface TrackedEntity {
   EntityType entityType();

   StoredEntityData data();

   boolean hasData();

   boolean hasSentMetadata();

   void sentMetadata(boolean var1);
}
