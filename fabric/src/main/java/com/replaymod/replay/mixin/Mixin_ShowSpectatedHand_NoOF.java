package com.replaymod.replay.mixin;

import com.replaymod.core.versions.MCVer;
import com.replaymod.replay.camera.CameraEntity;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({GameRenderer.class})
public abstract class Mixin_ShowSpectatedHand_NoOF {
   @Redirect(
      method = {"renderHand"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/network/ClientPlayerInteractionManager;getCurrentGameMode()Lnet/minecraft/world/GameMode;"
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
