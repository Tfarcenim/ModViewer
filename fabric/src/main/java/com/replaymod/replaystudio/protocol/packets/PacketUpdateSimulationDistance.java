package com.replaymod.replaystudio.protocol.packets;

import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketType;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import java.io.IOException;

public class PacketUpdateSimulationDistance {
   public static int getDistance(Packet packet) throws IOException {
      Packet.Reader in = packet.reader();
      Throwable var2 = null;

      int var3;
      try {
         var3 = in.readVarInt();
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

   public static Packet write(PacketTypeRegistry registry, int distance) throws IOException {
      Packet packet = new Packet(registry, PacketType.UpdateSimulationDistance);
      Packet.Writer out = packet.overwrite();
      Throwable var4 = null;

      try {
         out.writeVarInt(distance);
      } catch (Throwable var13) {
         var4 = var13;
         throw var13;
      } finally {
         if (out != null) {
            if (var4 != null) {
               try {
                  out.close();
               } catch (Throwable var12) {
                  var4.addSuppressed(var12);
               }
            } else {
               out.close();
            }
         }

      }

      return packet;
   }
}
