package com.replaymod.replaystudio.protocol.packets;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.ProtocolVersion;
import com.replaymod.replaystudio.protocol.Packet;
import java.io.IOException;

public class PacketSpawnPlayer extends SpawnEntity {
   public static String getPlayerListEntryId(Packet packet) throws IOException {
      Packet.Reader in = packet.reader();
      Throwable var2 = null;

      String var3;
      try {
         in.readVarInt();
         if (!packet.atLeast(ProtocolVersion.v1_8)) {
            in.readString();
            var3 = in.readString();
            return var3;
         }

         var3 = in.readUUID().toString();
      } catch (Throwable var13) {
         var2 = var13;
         throw var13;
      } finally {
         if (in != null) {
            if (var2 != null) {
               try {
                  in.close();
               } catch (Throwable var12) {
                  var2.addSuppressed(var12);
               }
            } else {
               in.close();
            }
         }

      }

      return var3;
   }
}
