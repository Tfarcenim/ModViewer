package com.replaymod.replay.mixin;

import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({LivingEntity.class})
public interface EntityLivingBaseAccessor {
   @Accessor("serverX")
   double getInterpTargetX();

   @Accessor("serverY")
   double getInterpTargetY();

   @Accessor("serverZ")
   double getInterpTargetZ();

   @Accessor("serverYaw")
   double getInterpTargetYaw();

   @Accessor("serverPitch")
   double getInterpTargetPitch();

   @Accessor("itemUseTimeLeft")
   int getActiveItemStackUseCount();

   @Accessor("itemUseTimeLeft")
   void setActiveItemStackUseCount(int var1);
}
