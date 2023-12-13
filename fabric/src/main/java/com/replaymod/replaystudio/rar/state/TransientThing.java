package com.replaymod.replaystudio.rar.state;

import com.replaymod.lib.com.github.steveice10.packetlib.io.NetInput;
import com.replaymod.lib.com.github.steveice10.packetlib.io.NetOutput;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import com.replaymod.replaystudio.rar.PacketSink;
import com.replaymod.replaystudio.rar.RandomAccessState;
import com.replaymod.replaystudio.rar.cache.LazyPacketList;
import com.replaymod.replaystudio.rar.cache.ReadableCache;
import com.replaymod.replaystudio.rar.cache.WriteableCache;
import java.io.IOException;

public abstract class TransientThing implements RandomAccessState {
   protected final PacketTypeRegistry registry;
   public final int spawnTime;
   public final int despawnTime;
   private final LazyPacketList spawnPackets;
   private final LazyPacketList despawnPackets;

   public TransientThing(PacketTypeRegistry registry, NetInput in) throws IOException {
      this.registry = registry;
      this.spawnTime = in.readVarInt();
      this.despawnTime = in.readVarInt();
      this.spawnPackets = new LazyPacketList(registry, in.readVarInt());
      this.despawnPackets = new LazyPacketList(registry, in.readVarInt());
   }

   public void load(PacketSink sink, ReadableCache cache) throws IOException {
      this.spawnPackets.read(sink, cache);
   }

   public void unload(PacketSink sink, ReadableCache cache) throws IOException {
      this.despawnPackets.read(sink, cache);
   }

   public static class Builder {
      private int spawnTime;
      private int despawnTime;
      public final LazyPacketList.Builder spawnPackets = new LazyPacketList.Builder();
      public final LazyPacketList.Builder despawnPackets = new LazyPacketList.Builder();

      public void build(NetOutput out, WriteableCache cache) throws IOException {
         out.writeVarInt(this.spawnTime);
         out.writeVarInt(this.despawnTime);
         out.writeVarInt(this.spawnPackets.build(cache));
         out.writeVarInt(this.despawnPackets.build(cache));
      }

      public void setSpawnTime(int spawnTime) {
         this.spawnTime = spawnTime;
      }

      public void setDespawnTime(int despawnTime) {
         this.despawnTime = despawnTime;
      }

      public void addSpawnPacket(Packet packet) {
         this.spawnPackets.add(packet);
      }

      public void addDespawnPacket(Packet packet) {
         this.despawnPackets.add(packet);
      }
   }
}
