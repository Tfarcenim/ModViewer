package com.replaymod.core.mixin;

import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import net.minecraft.CrashReport;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Timer;
import net.minecraft.network.Connection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({Minecraft.class})
public interface MinecraftAccessor {
   @Accessor("renderTickCounter")
   Timer getTimer();

   @Accessor("renderTickCounter")
   @Mutable
   void setTimer(Timer var1);

   @Accessor
   CompletableFuture<Void> getResourceReloadFuture();

   @Accessor
   void setResourceReloadFuture(CompletableFuture<Void> var1);

   @Accessor
   Queue<Runnable> getRenderTaskQueue();

   @Accessor("crashReportSupplier")
   Supplier<CrashReport> getCrashReporter();

   @Accessor("integratedServerConnection")
   void setConnection(Connection var1);
}
