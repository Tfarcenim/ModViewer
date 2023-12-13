package com.replaymod.core.mixin;

import com.replaymod.core.events.KeyBindingEventCallback;
import com.replaymod.core.events.KeyEventCallback;
import net.minecraft.client.KeyboardHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({KeyboardHandler.class})
public class MixinKeyboardListener {
   private static final String ON_KEY_PRESSED = "Lnet/minecraft/client/option/KeyBinding;onKeyPressed(Lnet/minecraft/client/util/InputUtil$Key;)V";

   @Inject(
      method = {"onKey"},
      at = {@At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/option/KeyBinding;onKeyPressed(Lnet/minecraft/client/util/InputUtil$Key;)V"
)},
      cancellable = true
   )
   private void beforeKeyBindingTick(long windowPointer, int key, int scanCode, int action, int modifiers, CallbackInfo ci) {
      if (((KeyEventCallback)KeyEventCallback.EVENT.invoker()).onKeyEvent(key, scanCode, action, modifiers)) {
         ci.cancel();
      }

   }

   @Inject(
      method = {"onKey"},
      at = {@At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/option/KeyBinding;onKeyPressed(Lnet/minecraft/client/util/InputUtil$Key;)V",
   shift = Shift.AFTER
)}
   )
   private void afterKeyBindingTick(long windowPointer, int key, int scanCode, int action, int modifiers, CallbackInfo ci) {
      ((KeyBindingEventCallback)KeyBindingEventCallback.EVENT.invoker()).onKeybindingEvent();
   }
}
