package com.replaymod.replay.mixin.entity_tracking;

import com.replaymod.replay.ext.EntityExt;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({ClientPacketListener.class})
public class Mixin_FixPartialUpdates {
   private static final String ENTITY_UPDATE = "Lnet/minecraft/entity/Entity;updateTrackedPositionAndAngles(DDDFFIZ)V";
   @Unique
   private Entity entity;

   @Redirect(
      method = {"onEntity"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/entity/Entity;getYaw()F"
)
   )
   private float getTrackedYaw(Entity instance) {
      return ((EntityExt)instance).replaymod$getTrackedYaw();
   }

   @Redirect(
      method = {"onEntity"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/entity/Entity;getPitch()F"
)
   )
   private float getTrackedPitch(Entity instance) {
      return ((EntityExt)instance).replaymod$getTrackedPitch();
   }

   @Redirect(
      method = {"onEntity"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/entity/Entity;getX()D"
)
   )
   private double getTrackedX(Entity instance) {
      return instance.getPositionCodec().decode(0L, 0L, 0L).x();
   }

   @Redirect(
      method = {"onEntity"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/entity/Entity;getY()D"
)
   )
   private double getTrackedY(Entity instance) {
      return instance.getPositionCodec().decode(0L, 0L, 0L).y();
   }

   @Redirect(
      method = {"onEntity"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/entity/Entity;getZ()D"
)
   )
   private double getTrackedZ(Entity instance) {
      return instance.getPositionCodec().decode(0L, 0L, 0L).z();
   }

   @ModifyVariable(
      method = {"onEntity", "onEntityPosition"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/entity/Entity;updateTrackedPositionAndAngles(DDDFFIZ)V"
),
      ordinal = 0
   )
   private Entity captureEntity(Entity entity) {
      return this.entity = entity;
   }

   @Inject(
      method = {"onEntity", "onEntityPosition"},
      at = {@At("RETURN")}
   )
   private void resetEntityField(CallbackInfo ci) {
      this.entity = null;
   }

   @ModifyArg(
      method = {"onEntity", "onEntityPosition"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/entity/Entity;updateTrackedPositionAndAngles(DDDFFIZ)V"
),
      index = 3
   )
   private float captureTrackedYaw(float value) {
      ((EntityExt)this.entity).replaymod$setTrackedYaw(value);
      return value;
   }

   @ModifyArg(
      method = {"onEntity", "onEntityPosition"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/entity/Entity;updateTrackedPositionAndAngles(DDDFFIZ)V"
),
      index = 4
   )
   private float captureTrackedPitch(float value) {
      ((EntityExt)this.entity).replaymod$setTrackedPitch(value);
      return value;
   }
}
