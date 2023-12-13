package com.replaymod.replaystudio.rar.state;

import com.replaymod.lib.com.github.steveice10.packetlib.io.NetInput;
import com.replaymod.lib.com.github.steveice10.packetlib.io.NetOutput;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import com.replaymod.replaystudio.rar.PacketSink;
import com.replaymod.replaystudio.rar.RandomAccessState;
import com.replaymod.replaystudio.rar.cache.ReadableCache;
import com.replaymod.replaystudio.rar.cache.WriteableCache;
import com.replaymod.replaystudio.rar.containers.PacketStateTree;
import com.replaymod.replaystudio.rar.containers.WorldStateTree;
import java.io.IOException;

public class Replay implements RandomAccessState {
   private final PacketStateTree features;
   private final PacketStateTree tags;
   private final WorldStateTree world;

   public Replay(PacketTypeRegistry registry, NetInput in) throws IOException {
      this.features = new PacketStateTree(registry, in.readVarInt());
      this.tags = new PacketStateTree(registry, in.readVarInt());
      this.world = new WorldStateTree(registry, this::restoreStateAfterJoinGame, in.readVarInt());
   }

   public void load(PacketSink sink, ReadableCache cache) throws IOException {
      this.features.load(sink, cache);
      this.tags.load(sink, cache);
      this.world.load(sink, cache);
   }

   public void unload(PacketSink sink, ReadableCache cache) throws IOException {
      this.world.unload(sink, cache);
      this.tags.unload(sink, cache);
      this.features.unload(sink, cache);
   }

   public void play(PacketSink sink, int currentTimeStamp, int targetTime) throws IOException {
      this.features.play(sink, currentTimeStamp, targetTime);
      this.tags.play(sink, currentTimeStamp, targetTime);
      this.world.play(sink, currentTimeStamp, targetTime);
   }

   public void rewind(PacketSink sink, int currentTimeStamp, int targetTime) throws IOException {
      this.features.rewind(sink, currentTimeStamp, targetTime);
      this.tags.rewind(sink, currentTimeStamp, targetTime);
      this.world.rewind(sink, currentTimeStamp, targetTime);
   }

   private void restoreStateAfterJoinGame(PacketSink sink, int targetTime) throws IOException {
      this.tags.play(sink, -1, targetTime);
   }

   public static class Builder {
      private final WriteableCache cache;
      public final PacketStateTree.Builder features = new PacketStateTree.Builder();
      public final PacketStateTree.Builder tags = new PacketStateTree.Builder();
      private final WorldStateTree.Builder worlds;
      public World.Builder world;

      public Builder(PacketTypeRegistry registry, WriteableCache cache) throws IOException {
         this.cache = cache;
         this.worlds = new WorldStateTree.Builder(registry, cache);
      }

      public World.Builder newWorld(int time, World.Info info) throws IOException {
         return this.world = this.worlds.newWorld(time, info);
      }

      public void build(NetOutput out, int time) throws IOException {
         out.writeVarInt(this.features.build(this.cache));
         out.writeVarInt(this.tags.build(this.cache));
         out.writeVarInt(this.worlds.build(time));
      }
   }
}
