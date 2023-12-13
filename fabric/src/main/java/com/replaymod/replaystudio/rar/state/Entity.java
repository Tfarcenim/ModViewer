package com.replaymod.replaystudio.rar.state;

import com.replaymod.lib.com.github.steveice10.packetlib.io.NetInput;
import com.replaymod.lib.com.github.steveice10.packetlib.io.NetOutput;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import com.replaymod.replaystudio.protocol.packets.PacketDestroyEntities;
import com.replaymod.replaystudio.protocol.packets.PacketEntityHeadLook;
import com.replaymod.replaystudio.protocol.packets.PacketEntityTeleport;
import com.replaymod.replaystudio.rar.PacketSink;
import com.replaymod.replaystudio.rar.RandomAccessState;
import com.replaymod.replaystudio.rar.cache.ReadableCache;
import com.replaymod.replaystudio.rar.cache.WriteableCache;
import com.replaymod.replaystudio.rar.containers.LocationStateTree;
import com.replaymod.replaystudio.util.Location;
import java.io.IOException;

public class Entity extends TransientThing implements RandomAccessState {
   private final LocationStateTree locations;

   public Entity(PacketTypeRegistry registry, NetInput in) throws IOException {
      super(registry, in);
      int id = in.readVarInt();
      this.locations = LocationStateTree.withApply(in.readVarInt(), (sink, loc) -> {
         sink.accept(PacketEntityTeleport.write(registry, id, loc, false));
         sink.accept(PacketEntityHeadLook.write(registry, id, loc.getYaw()));
      });
   }

   public void load(PacketSink sink, ReadableCache cache) throws IOException {
      super.load(sink, cache);
      this.locations.load(sink, cache);
   }

   public void unload(PacketSink sink, ReadableCache cache) throws IOException {
      super.unload(sink, cache);
      this.locations.unload(sink, cache);
   }

   public void play(PacketSink sink, int currentTimeStamp, int targetTime) throws IOException {
      this.locations.play(sink, currentTimeStamp, targetTime);
   }

   public void rewind(PacketSink sink, int currentTimeStamp, int targetTime) throws IOException {
      this.locations.rewind(sink, currentTimeStamp, targetTime);
   }

   public static class Builder extends TransientThing.Builder {
      private final int entityId;
      private final LocationStateTree.Builder locations = new LocationStateTree.Builder();

      public Builder(PacketTypeRegistry registry, int entityId) throws IOException {
         this.entityId = entityId;
         this.addDespawnPacket(PacketDestroyEntities.write(registry, entityId));
      }

      public Location getLocation() {
         return (Location)this.locations.getLatest();
      }

      public void updateLocation(int time, Location loc) {
         this.locations.put(time, loc);
      }

      public void build(NetOutput out, WriteableCache cache) throws IOException {
         super.build(out, cache);
         out.writeVarInt(this.entityId);
         out.writeVarInt(this.locations.build(cache));
      }
   }
}
