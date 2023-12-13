package com.replaymod.core.mixin;

import com.replaymod.core.events.KeyBindingEventCallback;
import net.minecraft.client.MouseHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({MouseHandler.class})
public class MixinMouse {
   @Inject(
      method = {"onMouseButton"},
      at = {@At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/option/KeyBinding;onKeyPressed(Lnet/minecraft/client/util/InputUtil$Key;)V",
   shift = Shift.AFTER
)}
   )
   private void afterKeyBindingTick(CallbackInfo ci) {
      ((KeyBindingEventCallback)KeyBindingEventCallback.EVENT.invoker()).onKeybindingEvent();
   }
}
