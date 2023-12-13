package com.replaymod.core.mixin;

import com.replaymod.core.events.PostRenderCallback;
import com.replaymod.core.events.PreRenderCallback;
import com.replaymod.core.versions.MCVer;
import net.minecraft.client.Minecraft;
import net.minecraft.util.thread.ReentrantBlockableEventLoop;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({Minecraft.class})
public abstract class MixinMinecraft extends ReentrantBlockableEventLoop<Runnable> implements MCVer.MinecraftMethodAccessor {
   public MixinMinecraft(String string_1) {
      super(string_1);
   }

   @Shadow
   protected abstract void method_1508();

   public void replayModProcessKeyBinds() {
      this.method_1508();
   }

   public void replayModExecuteTaskQueue() {
      this.runAllTasks();
   }

   @Inject(
      method = {"render"},
      at = {@At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/render/GameRenderer;render(FJZ)V"
)}
   )
   private void preRender(boolean unused, CallbackInfo ci) {
      ((PreRenderCallback)PreRenderCallback.EVENT.invoker()).preRender();
   }

   @Inject(
      method = {"render"},
      at = {@At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/render/GameRenderer;render(FJZ)V",
   shift = Shift.AFTER
)}
   )
   private void postRender(boolean unused, CallbackInfo ci) {
      ((PostRenderCallback)PostRenderCallback.EVENT.invoker()).postRender();
   }
}
