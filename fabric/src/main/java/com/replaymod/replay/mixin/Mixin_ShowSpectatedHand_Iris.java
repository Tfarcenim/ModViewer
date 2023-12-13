package com.replaymod.replay.mixin;

import com.replaymod.core.versions.MCVer;
import com.replaymod.replay.camera.CameraEntity;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Pseudo
@Mixin(
   targets = {"net.coderbot.iris.pipeline.HandRenderer"},
   remap = false
)
public abstract class Mixin_ShowSpectatedHand_Iris {
   @Redirect(
      method = {"*"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/network/ClientPlayerInteractionManager;getCurrentGameMode()Lnet/minecraft/world/GameMode;",
   remap = true
)
   )
   private GameType getGameMode(MultiPlayerGameMode interactionManager) {
      LocalPlayer camera = MCVer.getMinecraft().player;
      if (camera instanceof CameraEntity) {
         return camera.isSpectator() ? GameType.SPECTATOR : GameType.SURVIVAL;
      } else {
         return interactionManager.getPlayerMode();
      }
   }
}
