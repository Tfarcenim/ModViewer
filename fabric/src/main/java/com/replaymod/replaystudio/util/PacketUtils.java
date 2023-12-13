package com.replaymod.replaystudio.util;

import com.replaymod.lib.org.apache.commons.lang3.tuple.Pair;
import com.replaymod.lib.org.apache.commons.lang3.tuple.Triple;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.packets.EntityId;
import com.replaymod.replaystudio.protocol.packets.PacketEntityMovement;
import com.replaymod.replaystudio.protocol.packets.PacketEntityTeleport;
import com.replaymod.replaystudio.protocol.packets.SpawnEntity;
import java.io.IOException;
import java.util.List;

public class PacketUtils {
   public static boolean isSpawnEntityPacket(Packet packet) {
      switch(packet.getType()) {
      case SpawnPlayer:
      case SpawnMob:
      case SpawnObject:
      case SpawnExpOrb:
      case SpawnPainting:
      case SpawnGlobalEntity:
         return true;
      default:
         return false;
      }
   }

   public static Integer getEntityId(Packet packet) throws IOException {
      return EntityId.getEntityId(packet);
   }

   public static List<Integer> getEntityIds(Packet packet) throws IOException {
      return EntityId.getEntityIds(packet);
   }

   public static Location updateLocation(Location loc, Packet packet) throws IOException {
      Location spawnLocation = SpawnEntity.getLocation(packet);
      if (spawnLocation != null) {
         return spawnLocation;
      } else {
         switch(packet.getType()) {
         case EntityMovement:
         case EntityPosition:
         case EntityRotation:
         case EntityPositionRotation:
            if (loc == null) {
               loc = Location.NULL;
            }

            Triple<DPosition, Pair<Float, Float>, Boolean> movement = PacketEntityMovement.getMovement(packet);
            DPosition deltaPos = (DPosition)movement.getLeft();
            Pair<Float, Float> yawPitch = (Pair)movement.getMiddle();
            double x = loc.getX();
            double y = loc.getY();
            double z = loc.getZ();
            if (deltaPos != null) {
               x += deltaPos.getX();
               y += deltaPos.getY();
               z += deltaPos.getZ();
            }

            float yaw = yawPitch != null ? (Float)yawPitch.getKey() : loc.getYaw();
            float pitch = yawPitch != null ? (Float)yawPitch.getValue() : loc.getPitch();
            return new Location(x, y, z, yaw, pitch);
         case EntityTeleport:
            return PacketEntityTeleport.getLocation(packet);
         default:
            return null;
         }
      }
   }
}
