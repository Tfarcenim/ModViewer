package com.replaymod.replaystudio.rar;

import com.replaymod.lib.com.github.steveice10.packetlib.io.NetInput;
import com.replaymod.lib.com.github.steveice10.packetlib.io.NetOutput;
import com.replaymod.lib.com.github.steveice10.packetlib.io.stream.StreamNetInput;
import com.replaymod.lib.com.github.steveice10.packetlib.io.stream.StreamNetOutput;
import com.replaymod.lib.org.apache.commons.lang3.tuple.Pair;
import com.replaymod.replaystudio.io.ReplayInputStream;
import com.replaymod.replaystudio.lib.guava.base.Optional;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import com.replaymod.replaystudio.rar.analyse.ReplayAnalyzer;
import com.replaymod.replaystudio.rar.cache.ReadableCache;
import com.replaymod.replaystudio.rar.cache.WriteableCache;
import com.replaymod.replaystudio.rar.state.Replay;
import com.replaymod.replaystudio.replay.ReplayFile;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class RandomAccessReplay {
   private static final String CACHE_ENTRY = "quickModeCache.bin";
   private static final String CACHE_INDEX_ENTRY = "quickModeCacheIndex.bin";
   private static final int CACHE_VERSION = 7;
   private static final Logger LOGGER = Logger.getLogger(RandomAccessReplay.class.getName());
   private final ReplayFile replayFile;
   private final PacketTypeRegistry registry;
   private int currentTimeStamp;
   private Replay state;
   private ReadableCache cache;

   public RandomAccessReplay(ReplayFile replayFile, PacketTypeRegistry registry) {
      this.replayFile = replayFile;
      this.registry = registry;
   }

   protected abstract void dispatch(Packet var1);

   public void load(Consumer<Double> progress) throws IOException {
      if (!this.tryLoadFromCache(progress)) {
         double progressSplit = 0.9D;
         this.analyseReplay((d) -> {
            progress.accept(d * progressSplit);
         });
         this.tryLoadFromCache((d) -> {
            progress.accept(d * (1.0D - progressSplit) + progressSplit);
         });
      }

   }

   private boolean tryLoadFromCache(Consumer<Double> progress) throws IOException {
      this.release();
      Optional<InputStream> cacheIndexOpt = this.replayFile.getCache("quickModeCacheIndex.bin");
      if (!cacheIndexOpt.isPresent()) {
         return false;
      } else {
         try {
            InputStream indexIn = (InputStream)cacheIndexOpt.get();
            Throwable var4 = null;

            boolean var11;
            try {
               Optional<InputStream> cacheOpt = this.replayFile.getCache("quickModeCache.bin");
               if (!cacheOpt.isPresent()) {
                  boolean var45 = false;
                  return var45;
               }

               InputStream cacheIn = (InputStream)cacheOpt.get();
               Throwable var7 = null;

               try {
                  Pair<Replay, ReadableCache> result = this.loadFromCache(cacheIn, indexIn, progress);
                  Replay replay;
                  if (result == null) {
                     replay = false;
                     return (boolean)replay;
                  }

                  replay = (Replay)result.getLeft();
                  ReadableCache cache = (ReadableCache)result.getRight();
                  replay.load(Packet::release, cache);
                  this.state = replay;
                  this.cache = cache;
                  var11 = true;
               } catch (Throwable var40) {
                  var7 = var40;
                  throw var40;
               } finally {
                  if (cacheIn != null) {
                     if (var7 != null) {
                        try {
                           cacheIn.close();
                        } catch (Throwable var39) {
                           var7.addSuppressed(var39);
                        }
                     } else {
                        cacheIn.close();
                     }
                  }

               }
            } catch (Throwable var42) {
               var4 = var42;
               throw var42;
            } finally {
               if (indexIn != null) {
                  if (var4 != null) {
                     try {
                        indexIn.close();
                     } catch (Throwable var38) {
                        var4.addSuppressed(var38);
                     }
                  } else {
                     indexIn.close();
                  }
               }

            }

            return var11;
         } catch (EOFException var44) {
            LOGGER.log(Level.WARNING, "Re-analysing replay due to premature EOF while loading the cache:", var44);
            return false;
         }
      }
   }

   private Pair<Replay, ReadableCache> loadFromCache(InputStream rawCacheIn, InputStream rawIndexIn, Consumer<Double> progress) throws IOException {
      long sysTimeStart = System.currentTimeMillis();
      NetInput cacheIn = new StreamNetInput(rawCacheIn);
      NetInput in = new StreamNetInput(rawIndexIn);
      if (in.readVarInt() != 7) {
         return null;
      } else if (cacheIn.readVarInt() != 7) {
         return null;
      } else if (in.readVarInt() != this.registry.getVersion().getOriginalVersion()) {
         return null;
      } else if (cacheIn.readVarInt() != this.registry.getVersion().getOriginalVersion()) {
         return null;
      } else {
         Replay replay = new Replay(this.registry, in);
         int size = in.readVarInt();
         LOGGER.info("Creating quick mode buffer of size: " + size / 1024 + "KB");
         ByteBuf buf = Unpooled.buffer(size);
         int read = 0;

         while(true) {
            int len = buf.writeBytes(rawCacheIn, Math.min(size - read, 4096));
            if (len <= 0) {
               ReadableCache cache = new ReadableCache(buf);
               LOGGER.info("Loaded quick replay from cache in " + (System.currentTimeMillis() - sysTimeStart) + "ms");
               return Pair.of(replay, cache);
            }

            read += len;
            progress.accept((double)read / (double)size);
         }
      }
   }

   private void analyseReplay(Consumer<Double> progress) throws IOException {
      double sysTimeStart = (double)System.currentTimeMillis();
      ReplayInputStream in = this.replayFile.getPacketData(this.registry);
      Throwable var5 = null;

      try {
         OutputStream cacheOut = this.replayFile.writeCache("quickModeCache.bin");
         Throwable var7 = null;

         try {
            OutputStream cacheIndexOut = this.replayFile.writeCache("quickModeCacheIndex.bin");
            Throwable var9 = null;

            try {
               NetOutput out = new StreamNetOutput(cacheOut);
               out.writeVarInt(7);
               out.writeVarInt(this.registry.getVersion().getOriginalVersion());
               NetOutput indexOut = new StreamNetOutput(cacheIndexOut);
               indexOut.writeVarInt(7);
               indexOut.writeVarInt(this.registry.getVersion().getOriginalVersion());
               WriteableCache cache = new WriteableCache(cacheOut);
               double duration = (double)this.replayFile.getMetaData().getDuration();
               (new ReplayAnalyzer(this.registry, indexOut, cache)).analyse(in, (time) -> {
                  progress.accept((double)time / duration);
               });
               indexOut.writeVarInt(cache.index());
            } catch (Throwable var57) {
               var9 = var57;
               throw var57;
            } finally {
               if (cacheIndexOut != null) {
                  if (var9 != null) {
                     try {
                        cacheIndexOut.close();
                     } catch (Throwable var56) {
                        var9.addSuppressed(var56);
                     }
                  } else {
                     cacheIndexOut.close();
                  }
               }

            }
         } catch (Throwable var59) {
            var7 = var59;
            throw var59;
         } finally {
            if (cacheOut != null) {
               if (var7 != null) {
                  try {
                     cacheOut.close();
                  } catch (Throwable var55) {
                     var7.addSuppressed(var55);
                  }
               } else {
                  cacheOut.close();
               }
            }

         }
      } catch (Throwable var61) {
         var5 = var61;
         throw var61;
      } finally {
         if (in != null) {
            if (var5 != null) {
               try {
                  in.close();
               } catch (Throwable var54) {
                  var5.addSuppressed(var54);
               }
            } else {
               in.close();
            }
         }

      }

      LOGGER.info("Analysed replay in " + ((double)System.currentTimeMillis() - sysTimeStart) + "ms");
   }

   public void release() {
      if (this.state != null && this.cache != null) {
         try {
            this.state.unload(Packet::release, this.cache);
         } catch (IOException var2) {
            var2.printStackTrace();
         }

         this.state = null;
         this.cache.release();
         this.cache = null;
      }

   }

   public void reset() {
      this.currentTimeStamp = -1;
   }

   public void seek(int targetTime) throws IOException {
      if (targetTime > this.currentTimeStamp) {
         this.state.play(this::dispatch, this.currentTimeStamp, targetTime);
      } else {
         this.state.rewind(this::dispatch, this.currentTimeStamp, targetTime);
      }

      this.currentTimeStamp = targetTime;
   }
}
