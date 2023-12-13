package com.replaymod.lib.de.johni0702.minecraft.gui.versions.mixin;

import com.replaymod.lib.com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.replaymod.lib.de.johni0702.minecraft.gui.versions.ScreenExt;
import net.minecraft.client.KeyboardHandler;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin({KeyboardHandler.class})
public class Mixin_PassEvents_HandleKeys {
   @ModifyExpressionValue(
      method = {"onKey"},
      at = {@At(
   value = "FIELD",
   target = "Lnet/minecraft/client/MinecraftClient;currentScreen:Lnet/minecraft/client/gui/screen/Screen;",
   ordinal = 0
)},
      slice = {@Slice(
   from = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/gui/screen/Screen;wrapScreenError(Ljava/lang/Runnable;Ljava/lang/String;Ljava/lang/String;)V"
)
)}
   )
   private Screen doesScreenPassEvents(Screen screen) {
      if (screen instanceof ScreenExt) {
         ScreenExt ext = (ScreenExt)screen;
         if (ext.doesPassEvents()) {
            screen = null;
         }
      }

      return screen;
   }
}
