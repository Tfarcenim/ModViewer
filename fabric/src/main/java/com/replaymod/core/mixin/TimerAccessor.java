package com.replaymod.core.mixin;

import net.minecraft.client.Timer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({Timer.class})
public interface TimerAccessor {
   @Accessor("prevTimeMillis")
   long getLastSyncSysClock();

   @Accessor("prevTimeMillis")
   void setLastSyncSysClock(long var1);

   @Accessor("tickTime")
   float getTickLength();

   @Accessor("tickTime")
   @Mutable
   void setTickLength(float var1);
}
