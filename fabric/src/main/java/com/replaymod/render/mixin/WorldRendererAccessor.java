package com.replaymod.render.mixin;

import net.minecraft.client.renderer.LevelRenderer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin({LevelRenderer.class})
public interface WorldRendererAccessor {
}
