package com.replaymod.replaystudio.rar.state;

import com.replaymod.lib.com.github.steveice10.packetlib.io.NetInput;
import com.replaymod.lib.com.github.steveice10.packetlib.io.NetOutput;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import com.replaymod.replaystudio.protocol.packets.PacketNotifyClient;
import com.replaymod.replaystudio.rar.PacketSink;
import com.replaymod.replaystudio.rar.RandomAccessState;
import com.replaymod.replaystudio.rar.cache.ReadableCache;
import com.replaymod.replaystudio.rar.cache.WriteableCache;
import com.replaymod.replaystudio.rar.containers.PacketStateTree;
import java.io.IOException;

public class Weather extends TransientThing implements RandomAccessState {
   private final PacketStateTree rainStrengths;

   public Weather(PacketTypeRegistry registry, NetInput in) throws IOException {
      super(registry, in);
      this.rainStrengths = new PacketStateTree(registry, in.readVarInt());
   }

   public void load(PacketSink sink, ReadableCache cache) throws IOException {
      super.load(sink, cache);
      this.rainStrengths.load(sink, cache);
   }

   public void unload(PacketSink sink, ReadableCache cache) throws IOException {
      super.unload(sink, cache);
      this.rainStrengths.unload(sink, cache);
   }

   public void play(PacketSink sink, int currentTimeStamp, int targetTime) throws IOException {
      this.rainStrengths.play(sink, currentTimeStamp, targetTime);
   }

   public void rewind(PacketSink sink, int currentTimeStamp, int targetTime) throws IOException {
      this.rainStrengths.rewind(sink, currentTimeStamp, targetTime);
   }

   public static class Builder extends TransientThing.Builder {
      private final PacketStateTree.Builder rainStrengths = new PacketStateTree.Builder();

      public Builder(PacketTypeRegistry registry) throws IOException {
         this.addSpawnPacket(PacketNotifyClient.write(registry, PacketNotifyClient.Action.START_RAIN, 0.0F));
         this.addDespawnPacket(PacketNotifyClient.write(registry, PacketNotifyClient.Action.STOP_RAIN, 0.0F));
      }

      public void updateRainStrength(int time, Packet packet) {
         this.rainStrengths.put(time, packet);
      }

      public void build(NetOutput out, WriteableCache cache) throws IOException {
         super.build(out, cache);
         out.writeVarInt(this.rainStrengths.build(cache));
      }
   }
}
