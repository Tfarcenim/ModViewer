package com.replaymod.render.rendering;

import com.replaymod.core.mixin.MinecraftAccessor;
import com.replaymod.core.versions.MCVer;
import com.replaymod.render.capturer.WorldRenderer;
import com.replaymod.render.frame.BitmapFrame;
import com.replaymod.render.processor.GlToAbsoluteDepthProcessor;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import net.minecraft.CrashReport;
import net.minecraft.ReportedException;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

public class Pipeline<R extends Frame, P extends Frame> implements Runnable {
   private final WorldRenderer worldRenderer;
   private final FrameCapturer<R> capturer;
   private final FrameProcessor<R, P> processor;
   private final GlToAbsoluteDepthProcessor depthProcessor;
   private final FrameConsumer<P> consumer;
   private volatile boolean abort;

   public Pipeline(WorldRenderer worldRenderer, FrameCapturer<R> capturer, FrameProcessor<R, P> processor, FrameConsumer<P> consumer) {
      this.worldRenderer = worldRenderer;
      this.capturer = capturer;
      this.processor = processor;
      this.consumer = new Pipeline.ParallelSafeConsumer(consumer);
      float near = 0.05F;
      float far = (float)((Integer)MCVer.getMinecraft().options.renderDistance().get() * 16 * 4);
      this.depthProcessor = new GlToAbsoluteDepthProcessor(near, far);
   }

   public synchronized void run() {
      int processors = Runtime.getRuntime().availableProcessors();
      int processThreads = Math.max(1, processors - 2);
      ExecutorService processService = new ThreadPoolExecutor(processThreads, processThreads, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(2) {
         public boolean offer(Runnable runnable) {
            try {
               this.put(runnable);
               return true;
            } catch (InterruptedException var3) {
               Thread.currentThread().interrupt();
               return false;
            }
         }
      }, new DiscardPolicy());
      Minecraft mc = MCVer.getMinecraft();

      while(true) {
         if (!this.capturer.isDone() && !this.abort) {
            if (!GLFW.glfwWindowShouldClose(mc.getWindow().getWindow()) && ((MinecraftAccessor)mc).getCrashReporter() == null) {
               Map<Channel, R> rawFrame = this.capturer.process();
               if (rawFrame != null) {
                  processService.submit(new Pipeline.ProcessTask(rawFrame));
               }
               continue;
            }

            processService.shutdown();
            return;
         }

         processService.shutdown();

         try {
            processService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
         } catch (InterruptedException var8) {
            Thread.currentThread().interrupt();
         }

         try {
            this.worldRenderer.close();
            this.capturer.close();
            this.processor.close();
            this.consumer.close();
            return;
         } catch (Throwable var7) {
            CrashReport crashReport = CrashReport.forThrowable(var7, "Cleaning up rendering pipeline");
            throw new ReportedException(crashReport);
         }
      }
   }

   public void cancel() {
      this.abort = true;
   }

   private static class ParallelSafeConsumer<P extends Frame> implements FrameConsumer<P> {
      private final FrameConsumer<P> inner;
      private int nextFrame;
      private final Object lock = new Object();

      private ParallelSafeConsumer(FrameConsumer<P> inner) {
         this.inner = inner;
      }

      public void consume(Map<Channel, P> channels) {
         if (this.inner.isParallelCapable()) {
            this.inner.consume(channels);
         } else {
            int frameId = ((Frame)channels.values().iterator().next()).getFrameId();
            synchronized(this.lock) {
               while(this.nextFrame != frameId) {
                  try {
                     this.lock.wait();
                  } catch (InterruptedException var6) {
                     Thread.currentThread().interrupt();
                  }
               }

               this.inner.consume(channels);
               ++this.nextFrame;
               this.lock.notifyAll();
            }
         }

      }

      public boolean isParallelCapable() {
         return true;
      }

      public void close() throws IOException {
         this.inner.close();
      }
   }

   private class ProcessTask implements Runnable {
      private final Map<Channel, R> rawChannels;

      public ProcessTask(Map<Channel, R> rawChannels) {
         this.rawChannels = rawChannels;
      }

      public void run() {
         try {
            Map<Channel, P> processedChannels = new HashMap();

            Entry entry;
            Frame processedFrame;
            for(Iterator var6 = this.rawChannels.entrySet().iterator(); var6.hasNext(); processedChannels.put((Channel)entry.getKey(), processedFrame)) {
               entry = (Entry)var6.next();
               processedFrame = Pipeline.this.processor.process((Frame)entry.getValue());
               if (entry.getKey() == Channel.DEPTH && processedFrame instanceof BitmapFrame) {
                  Pipeline.this.depthProcessor.process((BitmapFrame)processedFrame);
               }
            }

            if (processedChannels.isEmpty()) {
               return;
            }

            Pipeline.this.consumer.consume(processedChannels);
         } catch (Throwable var5) {
            CrashReport crashReport = CrashReport.forThrowable(var5, "Processing frame");
            MCVer.getMinecraft().delayCrashRaw(crashReport);
         }

      }
   }
}
