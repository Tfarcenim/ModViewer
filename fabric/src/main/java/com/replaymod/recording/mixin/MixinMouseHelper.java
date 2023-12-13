package com.replaymod.recording.mixin;

import com.replaymod.replay.InputReplayTimer;
import com.replaymod.replay.ReplayModReplay;
import net.minecraft.client.MouseHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin({MouseHandler.class})
public abstract class MixinMouseHelper {
   @Shadow
   private boolean field_1783;

   @Inject(
      method = {"lockCursor"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void noGrab(CallbackInfo ci) {
      if (Boolean.valueOf(System.getProperty("fml.noGrab", "false"))) {
         this.field_1783 = true;
         ci.cancel();
      }

   }

   @Inject(
      method = {"onMouseScroll"},
      at = {@At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/network/ClientPlayerEntity;isSpectator()Z"
)},
      locals = LocalCapture.CAPTURE_FAILHARD,
      cancellable = true
   )
   private void handleReplayModScroll(long _p0, double _p1, double _p2, CallbackInfo ci, double _l1, int yOffsetAccumulated) {
      if (ReplayModReplay.instance.getReplayHandler() != null) {
         InputReplayTimer.handleScroll(yOffsetAccumulated * 120);
         ci.cancel();
      }

   }
}
