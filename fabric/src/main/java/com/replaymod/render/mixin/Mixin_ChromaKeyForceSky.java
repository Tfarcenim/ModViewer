package com.replaymod.render.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({LevelRenderer.class})
public abstract class Mixin_ChromaKeyForceSky {
   @Shadow
   @Final
   private Minecraft field_4088;
}
