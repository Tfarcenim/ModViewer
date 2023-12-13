package com.replaymod.replaystudio.lib.viaversion.api.data.entity;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.EntityType;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface StoredEntityData {
   EntityType type();

   boolean has(Class<?> var1);

   @Nullable
   <T> T get(Class<T> var1);

   @Nullable
   <T> T remove(Class<T> var1);

   void put(Object var1);
}
