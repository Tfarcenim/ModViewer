package com.replaymod.replaystudio.filter;

import com.google.gson.JsonObject;
import com.replaymod.lib.com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.PacketData;
import com.replaymod.replaystudio.Studio;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketType;
import com.replaymod.replaystudio.protocol.packets.PacketJoinGame;
import com.replaymod.replaystudio.protocol.packets.PacketRespawn;
import com.replaymod.replaystudio.protocol.registry.DimensionType;
import com.replaymod.replaystudio.stream.PacketStream;
import java.io.IOException;

public class DimensionTracker implements StreamFilter {
   public CompoundTag registries;
   public String dimension;
   public DimensionType dimensionType;

   public void onStart(PacketStream stream) {
   }

   public boolean onPacket(PacketStream stream, PacketData data) throws IOException {
      Packet packet = data.getPacket();
      PacketType type = packet.getType();
      switch(type) {
      case Respawn:
         PacketRespawn packetRespawn = PacketRespawn.read(packet, this.registries);
         this.dimension = packetRespawn.dimension;
         this.dimensionType = packetRespawn.dimensionType;
         break;
      case JoinGame:
         PacketJoinGame packetJoinGame = PacketJoinGame.read(packet);
         this.registries = packetJoinGame.registry;
         this.dimension = packetJoinGame.dimension;
         this.dimensionType = packetJoinGame.dimensionType;
      }

      return true;
   }

   public void onEnd(PacketStream stream, long timestamp) throws IOException {
   }

   public String getName() {
      return "track_dimension";
   }

   public void init(Studio studio, JsonObject config) {
   }
}
