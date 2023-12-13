package com.replaymod.lib.de.johni0702.minecraft.gui.versions.mixin;

import com.google.common.collect.Collections2;
import com.replaymod.lib.de.johni0702.minecraft.gui.versions.callbacks.InitScreenCallback;
import java.util.List;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(
   value = {Screen.class},
   priority = 1100
)
public class MixinScreen {
   @Shadow
   @Final
   private List<GuiEventListener> field_22786;

   @Inject(
      method = {"init(Lnet/minecraft/client/MinecraftClient;II)V"},
      at = {@At("HEAD")}
   )
   private void preInit(CallbackInfo ci) {
      this.firePreInit();
   }

   @Inject(
      method = {"init(Lnet/minecraft/client/MinecraftClient;II)V"},
      at = {@At("TAIL")}
   )
   private void init(CallbackInfo ci) {
      this.firePostInit();
   }

   @Inject(
      method = {"resize"},
      at = {@At("HEAD")}
   )
   private void preResize(CallbackInfo ci) {
      this.firePreInit();
   }

   @Inject(
      method = {"resize"},
      at = {@At("TAIL")}
   )
   private void resize(CallbackInfo ci) {
      this.firePostInit();
   }

   @Unique
   private void firePreInit() {
      ((InitScreenCallback.Pre)InitScreenCallback.Pre.EVENT.invoker()).preInitScreen((Screen)this);
   }

   @Unique
   private void firePostInit() {
      ((InitScreenCallback)InitScreenCallback.EVENT.invoker()).initScreen((Screen)this, Collections2.transform(Collections2.filter(this.field_22786, (it) -> {
         return it instanceof AbstractWidget;
      }), (it) -> {
         return (AbstractWidget)it;
      }));
   }
}
