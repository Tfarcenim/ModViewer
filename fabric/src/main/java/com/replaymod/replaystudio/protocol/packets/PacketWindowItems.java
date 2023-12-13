package com.replaymod.replaystudio.protocol.packets;

import com.replaymod.replaystudio.protocol.Packet;
import java.io.IOException;

public class PacketWindowItems {
   public static int getWindowId(Packet packet) throws IOException {
      Packet.Reader in = packet.reader();
      Throwable var2 = null;

      int var3;
      try {
         var3 = in.readUnsignedByte();
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
}
