package com.replaymod.replay.mixin;

import net.minecraft.client.renderer.ViewArea;
import net.minecraft.client.renderer.chunk.ChunkRenderDispatcher.RenderChunk;
import net.minecraft.core.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({ViewArea.class})
public abstract class MixinViewFrustum {
   @Redirect(
      method = {"updateCameraPosition"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/render/chunk/ChunkBuilder$BuiltChunk;setOrigin(III)V"
)
   )
   private void replayModReplay_updatePositionAndMarkForUpdate(RenderChunk renderChunk, int x, int y, int z) {
      BlockPos pos = new BlockPos(x, y, z);
      if (!pos.equals(renderChunk.getOrigin())) {
         renderChunk.setOrigin(x, y, z);
         renderChunk.setDirty(false);
      }

   }
}
