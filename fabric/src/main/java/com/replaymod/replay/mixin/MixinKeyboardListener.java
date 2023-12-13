package com.replaymod.replay.mixin;

import com.replaymod.extras.advancedscreenshots.AdvancedScreenshots;
import com.replaymod.replay.ReplayModReplay;
import net.minecraft.client.KeyboardHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({KeyboardHandler.class})
public abstract class MixinKeyboardListener {
   @Inject(
      method = {"onKey"},
      at = {@At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/util/ScreenshotRecorder;saveScreenshot(Ljava/io/File;Lnet/minecraft/client/gl/Framebuffer;Ljava/util/function/Consumer;)V"
)},
      cancellable = true
   )
   private void takeScreenshot(CallbackInfo ci) {
      if (ReplayModReplay.instance.getReplayHandler() != null) {
         AdvancedScreenshots.take();
         ci.cancel();
      }

   }
}
