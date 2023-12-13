package com.replaymod.replaystudio.protocol.packets;

import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketType;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import java.io.IOException;

public class PacketUpdateViewPosition {
   public static int getChunkX(Packet packet) throws IOException {
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

   public static int getChunkZ(Packet packet) throws IOException {
      Packet.Reader in = packet.reader();
      Throwable var2 = null;

      int var3;
      try {
         in.readVarInt();
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

   public static Packet write(PacketTypeRegistry registry, int chunkX, int chunkZ) throws IOException {
      Packet packet = new Packet(registry, PacketType.UpdateViewPosition);
      Packet.Writer out = packet.overwrite();
      Throwable var5 = null;

      try {
         out.writeVarInt(chunkX);
         out.writeVarInt(chunkZ);
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
