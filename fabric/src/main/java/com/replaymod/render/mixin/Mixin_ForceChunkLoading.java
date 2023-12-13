package com.replaymod.render.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.replaymod.render.hooks.ForceChunkLoadingHook;
import com.replaymod.render.hooks.IForceChunkLoading;
import com.replaymod.render.utils.FlawlessFrames;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.chunk.ChunkRenderDispatcher;
import net.minecraft.client.renderer.chunk.RenderRegionCache;
import net.minecraft.client.renderer.chunk.ChunkRenderDispatcher.RenderChunk;
import net.minecraft.client.renderer.culling.Frustum;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({LevelRenderer.class})
public abstract class Mixin_ForceChunkLoading implements IForceChunkLoading {
   private ForceChunkLoadingHook replayModRender_hook;
   @Shadow
   private ChunkRenderDispatcher field_4106;
   @Shadow
   private Frustum field_27740;
   @Shadow
   private Frustum field_4056;
   @Shadow
   @Final
   private Minecraft field_4088;
   @Shadow
   @Final
   private ObjectArrayList<ChunkInfoAccessor> field_34807;
   @Shadow
   private boolean field_34810;
   @Shadow
   @Final
   private BlockingQueue<RenderChunk> field_34816;
   @Shadow
   private Future<?> field_34808;
   @Shadow
   @Final
   private AtomicBoolean field_34809;

   public void replayModRender_setHook(ForceChunkLoadingHook hook) {
      this.replayModRender_hook = hook;
   }

   @Shadow
   protected abstract void method_3273(Camera var1, Frustum var2, boolean var3, boolean var4);

   @Shadow
   protected abstract void method_38551(Frustum var1);

   @Inject(
      method = {"render"},
      at = {@At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/render/WorldRenderer;setupTerrain(Lnet/minecraft/client/render/Camera;Lnet/minecraft/client/render/Frustum;ZZ)V"
)}
   )
   private void forceAllChunks(PoseStack matrices, float tickDelta, long limitTime, boolean renderBlockOutline, Camera camera, GameRenderer gameRenderer, LightTexture lightmapTextureManager, Matrix4f matrix4f, CallbackInfo ci) {
      if (this.replayModRender_hook != null) {
         if (!FlawlessFrames.hasSodium()) {
            assert this.field_4088.player != null;

            RenderRegionCache chunkRendererRegionBuilder = new RenderRegionCache();

            do {
               this.method_3273(camera, this.field_27740, this.field_4056 != null, this.field_4088.player.isSpectator());
               if (this.field_34808 != null) {
                  try {
                     this.field_34808.get(5L, TimeUnit.SECONDS);
                  } catch (InterruptedException var15) {
                     Thread.currentThread().interrupt();
                     return;
                  } catch (ExecutionException var16) {
                     throw new RuntimeException(var16);
                  } catch (TimeoutException var17) {
                     var17.printStackTrace();
                  }
               }

               if (this.field_34809.compareAndSet(true, false)) {
                  this.method_38551((new Frustum(this.field_27740)).offsetToFullyIncludeCameraCube(8));
               }

               ObjectListIterator var12 = this.field_34807.iterator();

               while(var12.hasNext()) {
                  ChunkInfoAccessor chunkInfo = (ChunkInfoAccessor)var12.next();
                  RenderChunk builtChunk = chunkInfo.getChunk();
                  if (builtChunk.isDirty()) {
                     if (builtChunk.hasAllNeighbors()) {
                        builtChunk.rebuildChunkAsync(this.field_4106, chunkRendererRegionBuilder);
                     }

                     builtChunk.setNotDirty();
                  }
               }

               this.field_34810 |= ((ForceChunkLoadingHook.IBlockOnChunkRebuilds)this.field_4106).uploadEverythingBlocking();
            } while(this.field_34810 || !this.field_34816.isEmpty());

         }
      }
   }
}
