package com.replaymod.replay.mixin;

import com.replaymod.replay.ReplayModReplay;
import com.replaymod.replay.camera.CameraEntity;
import net.minecraft.client.ClientRecipeBook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.stats.StatsCounter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({MultiPlayerGameMode.class})
public abstract class MixinPlayerControllerMP {
   @Shadow
   private Minecraft field_3712;
   @Shadow
   private ClientPacketListener field_3720;

   @Inject(
      method = {"createPlayer(Lnet/minecraft/client/world/ClientWorld;Lnet/minecraft/stat/StatHandler;Lnet/minecraft/client/recipebook/ClientRecipeBook;ZZ)Lnet/minecraft/client/network/ClientPlayerEntity;"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void replayModReplay_createReplayCamera(ClientLevel worldIn, StatsCounter statisticsManager, ClientRecipeBook recipeBookClient, boolean lastIsHoldingSneakKey, boolean lastSprinting, CallbackInfoReturnable<LocalPlayer> ci) {
      if (ReplayModReplay.instance.getReplayHandler() != null) {
         ci.setReturnValue(new CameraEntity(this.field_3712, worldIn, this.field_3720, statisticsManager, recipeBookClient));
         ci.cancel();
      }

   }

   @Inject(
      method = {"isFlyingLocked"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void replayModReplay_isSpectator(CallbackInfoReturnable<Boolean> ci) {
      if (this.field_3712.player instanceof CameraEntity) {
         ci.setReturnValue(this.field_3712.player.isSpectator());
      }

   }
}
