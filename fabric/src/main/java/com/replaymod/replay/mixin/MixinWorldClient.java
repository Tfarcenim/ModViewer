package com.replaymod.replay.mixin;

import net.minecraft.client.multiplayer.ClientLevel;
import org.spongepowered.asm.mixin.Mixin;

@Mixin({ClientLevel.class})
public abstract class MixinWorldClient {
}
