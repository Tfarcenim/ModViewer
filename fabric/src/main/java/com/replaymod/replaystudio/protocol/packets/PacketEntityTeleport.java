package com.replaymod.replaystudio.protocol.packets;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.ProtocolVersion;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketType;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import com.replaymod.replaystudio.util.Location;
import java.io.IOException;

public class PacketEntityTeleport {
   public static Location getLocation(Packet packet) throws IOException {
      Packet.Reader in = packet.reader();
      Throwable var2 = null;

      Location var3;
      try {
         if (packet.atLeast(ProtocolVersion.v1_8)) {
            in.readVarInt();
         } else {
            in.readInt();
         }

         var3 = SpawnEntity.readXYZYaPi(packet, in, false);
      } catch (Throwable var12) {
         var2 = var12;
         throw var12;
      } finally {
         if (in != null) {
            if (var2 != null) {
               try {
                  in.close();
               } catch (Throwable var11) {
                  var2.addSuppressed(var11);
               }
            } else {
               in.close();
            }
         }

      }

      return var3;
   }

   public static Packet write(PacketTypeRegistry registry, int entityId, Location location, boolean onGround) throws IOException {
      Packet packet = new Packet(registry, PacketType.EntityTeleport);
      Packet.Writer out = packet.overwrite();
      Throwable var6 = null;

      try {
         if (packet.atLeast(ProtocolVersion.v1_8)) {
            out.writeVarInt(entityId);
         } else {
            out.writeInt(entityId);
         }

         SpawnEntity.writeXYZYaPi(packet, out, location);
         if (packet.atLeast(ProtocolVersion.v1_8)) {
            out.writeBoolean(onGround);
         }
      } catch (Throwable var15) {
         var6 = var15;
         throw var15;
      } finally {
         if (out != null) {
            if (var6 != null) {
               try {
                  out.close();
               } catch (Throwable var14) {
                  var6.addSuppressed(var14);
               }
            } else {
               out.close();
            }
         }

      }

      return packet;
   }
}
