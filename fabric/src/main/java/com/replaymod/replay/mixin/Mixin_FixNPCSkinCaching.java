package com.replaymod.replay.mixin;

import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.RemotePlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({AbstractClientPlayer.class})
public abstract class Mixin_FixNPCSkinCaching {
   @Shadow
   @Nullable
   protected abstract PlayerInfo method_3123();

   @Inject(
      method = {"<init>"},
      at = {@At("RETURN")}
   )
   private void forceCachePlayerListEntry(CallbackInfo ci) {
      if (this instanceof RemotePlayer) {
         if (Minecraft.getInstance().getConnection() != null) {
            try {
               this.method_3123();
            } catch (Exception var3) {
               var3.printStackTrace();
            }

         }
      }
   }
}
