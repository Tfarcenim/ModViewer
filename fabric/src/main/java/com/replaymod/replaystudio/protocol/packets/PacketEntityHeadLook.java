package com.replaymod.replaystudio.protocol.packets;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.ProtocolVersion;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketType;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import java.io.IOException;

public class PacketEntityHeadLook {
   public static float getYaw(Packet packet) throws IOException {
      Packet.Reader in = packet.reader();
      Throwable var2 = null;

      float var3;
      try {
         if (packet.atLeast(ProtocolVersion.v1_8)) {
            in.readVarInt();
         } else {
            in.readInt();
         }

         var3 = (float)in.readByte() / 256.0F * 360.0F;
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

   public static Packet write(PacketTypeRegistry registry, int entityId, float yaw) throws IOException {
      Packet packet = new Packet(registry, PacketType.EntityHeadLook);
      Packet.Writer out = packet.overwrite();
      Throwable var5 = null;

      try {
         if (packet.atLeast(ProtocolVersion.v1_8)) {
            out.writeVarInt(entityId);
         } else {
            out.writeInt(entityId);
         }

         out.writeByte((int)(yaw / 360.0F * 256.0F));
      } catch (Throwable var14) {
         var5 = var14;
         throw var14;
      } finally {
         if (out != null) {
            if (var5 != null) {
               try {
                  out.close();
               } catch (Throwable var13) {
                  var5.addSuppressed(var13);
               }
            } else {
               out.close();
            }
         }

      }

      return packet;
   }
}
