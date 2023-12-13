package com.replaymod.render.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import com.replaymod.render.hooks.ForceChunkLoadingHook;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import net.minecraft.client.renderer.ChunkBufferBuilderPack;
import net.minecraft.client.renderer.chunk.ChunkRenderDispatcher;
import net.minecraft.util.thread.ProcessorMailbox;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({ChunkRenderDispatcher.class})
public abstract class Mixin_BlockOnChunkRebuilds implements ForceChunkLoadingHook.IBlockOnChunkRebuilds {
   @Shadow
   @Final
   private Queue<ChunkBufferBuilderPack> field_20827;
   @Shadow
   @Final
   private ProcessorMailbox<Runnable> field_20829;
   @Shadow
   @Final
   private Queue<Runnable> field_4443;
   private final Lock waitingForWorkLock = new ReentrantLock();
   private final Condition newWork;
   private volatile boolean allDone;
   private int totalBufferCount;

   public Mixin_BlockOnChunkRebuilds() {
      this.newWork = this.waitingForWorkLock.newCondition();
   }

   @Unique
   private boolean upload() {
      boolean anything;
      Runnable runnable;
      for(anything = false; (runnable = (Runnable)this.field_4443.poll()) != null; anything = true) {
         runnable.run();
      }

      return anything;
   }

   @Shadow
   protected abstract void method_22763();

   @Inject(
      method = {"<init>"},
      at = {@At("RETURN")}
   )
   private void rememberTotalThreads(CallbackInfo ci) {
      this.totalBufferCount = this.field_20827.size();
   }

   @Inject(
      method = {"scheduleRunTasks"},
      at = {@At("RETURN")}
   )
   private void notifyMainThreadIfEverythingIsDone(CallbackInfo ci) {
      if (this.field_20827.size() == this.totalBufferCount) {
         this.waitingForWorkLock.lock();

         try {
            this.allDone = true;
            this.newWork.signalAll();
         } finally {
            this.waitingForWorkLock.unlock();
         }
      } else {
         this.allDone = false;
      }

   }

   @Inject(
      method = {"scheduleUpload"},
      at = {@At("RETURN")}
   )
   private void notifyMainThreadOfNewUpload(CallbackInfoReturnable<CompletableFuture<Void>> ci) {
      this.waitingForWorkLock.lock();

      try {
         this.newWork.signal();
      } finally {
         this.waitingForWorkLock.unlock();
      }

   }

   private boolean waitForMainThreadWork() {
      boolean allDone = (Boolean)this.field_20829.ask((reply) -> {
         return () -> {
            this.method_22763();
            reply.tell(this.field_20827.size() == this.totalBufferCount);
         };
      }).join();
      if (allDone) {
         return true;
      } else {
         this.waitingForWorkLock.lock();

         try {
            while(true) {
               RenderSystem.replayQueue();
               boolean var2;
               if (this.allDone) {
                  var2 = true;
                  return var2;
               }

               if (!this.field_4443.isEmpty()) {
                  var2 = false;
                  return var2;
               }

               this.newWork.awaitUninterruptibly();
            }
         } finally {
            this.waitingForWorkLock.unlock();
         }
      }
   }

   public boolean uploadEverythingBlocking() {
      boolean anything = false;

      boolean allChunksBuilt;
      do {
         for(allChunksBuilt = this.waitForMainThreadWork(); this.upload(); anything = true) {
         }
      } while(!allChunksBuilt);

      return anything;
   }
}
