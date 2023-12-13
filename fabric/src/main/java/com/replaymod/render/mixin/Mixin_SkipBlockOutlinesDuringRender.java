package com.replaymod.render.mixin;

import com.replaymod.render.hooks.EntityRendererHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({LevelRenderer.class})
public abstract class Mixin_SkipBlockOutlinesDuringRender {
   @Shadow
   @Final
   private Minecraft field_4088;

   @Inject(
      method = {"drawBlockOutline"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void replayModRender_drawSelectionBox(CallbackInfo ci) {
      if (((EntityRendererHandler.IEntityRenderer)this.field_4088.gameRenderer).replayModRender_getHandler() != null) {
         ci.cancel();
      }

   }
}
