package com.replaymod.recording.mixin;

import javax.annotation.Nonnull;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({LivingEntity.class})
public interface EntityLivingBaseAccessor {
   @Accessor("LIVING_FLAGS")
   @Nonnull
   static EntityDataAccessor<Byte> getLivingFlags() {
      return null;
   }
}
