package com.replaymod.replaystudio.protocol.packets;

import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketType;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import java.io.IOException;

public class PacketNotifyClient {
   public static PacketNotifyClient.Action getAction(Packet packet) throws IOException {
      Packet.Reader in = packet.reader();
      Throwable var2 = null;

      PacketNotifyClient.Action var3;
      try {
         var3 = PacketNotifyClient.Action.values()[in.readUnsignedByte()];
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

   public static float getValue(Packet packet) throws IOException {
      Packet.Reader in = packet.reader();
      Throwable var2 = null;

      float var3;
      try {
         in.readUnsignedByte();
         var3 = in.readFloat();
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

   public static Packet write(PacketTypeRegistry registry, PacketNotifyClient.Action action, float value) throws IOException {
      Packet packet = new Packet(registry, PacketType.PlayerListEntry);
      Packet.Writer out = packet.overwrite();
      Throwable var5 = null;

      try {
         out.writeByte(action.ordinal());
         out.writeFloat(value);
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

   public static enum Action {
      INVALID_BED,
      START_RAIN,
      STOP_RAIN,
      CHANGE_GAMEMODE,
      ENTER_CREDITS,
      DEMO_MESSAGE,
      ARROW_HIT_PLAYER,
      RAIN_STRENGTH,
      THUNDER_STRENGTH,
      AFFECTED_BY_PUFFERFISH,
      AFFECTED_BY_ELDER_GUARDIAN,
      ENABLE_RESPAWN_SCREEN;
   }
}
