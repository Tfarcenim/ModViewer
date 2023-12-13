package com.replaymod.replaystudio.protocol.packets;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.ProtocolVersion;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketType;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PacketTeam {
   public static String getName(Packet packet) throws IOException {
      Packet.Reader in = packet.reader();
      Throwable var2 = null;

      String var3;
      try {
         var3 = in.readString();
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

   public static PacketTeam.Action getAction(Packet packet) throws IOException {
      Packet.Reader in = packet.reader();
      Throwable var2 = null;

      PacketTeam.Action var3;
      try {
         in.readString();
         var3 = PacketTeam.Action.values()[in.readByte()];
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

   public static List<String> getPlayers(Packet packet) throws IOException {
      Packet.Reader in = packet.reader();
      Throwable var2 = null;

      try {
         in.readString();
         PacketTeam.Action action = PacketTeam.Action.values()[in.readByte()];
         if (action != PacketTeam.Action.CREATE && action != PacketTeam.Action.ADD_PLAYER && action != PacketTeam.Action.REMOVE_PLAYER) {
            List var18 = Collections.emptyList();
            return var18;
         } else {
            if (action == PacketTeam.Action.CREATE) {
               in.readString();
               if (!packet.atLeast(ProtocolVersion.v1_13)) {
                  in.readString();
                  in.readString();
               }

               in.readByte();
               if (packet.atLeast(ProtocolVersion.v1_8)) {
                  in.readString();
                  if (packet.atLeast(ProtocolVersion.v1_9)) {
                     in.readString();
                  }

                  if (packet.atLeast(ProtocolVersion.v1_13)) {
                     in.readVarInt();
                     in.readString();
                     in.readString();
                  } else {
                     in.readByte();
                  }
               }
            }

            int count;
            if (packet.atLeast(ProtocolVersion.v1_8)) {
               count = in.readVarInt();
            } else {
               count = in.readShort();
            }

            List<String> result = new ArrayList(count);

            for(int i = 0; i < count; ++i) {
               result.add(in.readString());
            }

            ArrayList var19 = result;
            return var19;
         }
      } catch (Throwable var16) {
         var2 = var16;
         throw var16;
      } finally {
         if (in != null) {
            if (var2 != null) {
               try {
                  in.close();
               } catch (Throwable var15) {
                  var2.addSuppressed(var15);
               }
            } else {
               in.close();
            }
         }

      }
   }

   public static Packet addPlayers(PacketTypeRegistry registry, String name, Collection<String> players) throws IOException {
      return addOrRemovePlayers(registry, name, PacketTeam.Action.ADD_PLAYER, players);
   }

   public static Packet removePlayers(PacketTypeRegistry registry, String name, Collection<String> players) throws IOException {
      return addOrRemovePlayers(registry, name, PacketTeam.Action.REMOVE_PLAYER, players);
   }

   private static Packet addOrRemovePlayers(PacketTypeRegistry registry, String name, PacketTeam.Action action, Collection<String> players) throws IOException {
      Packet packet = new Packet(registry, PacketType.Team);
      Packet.Writer out = packet.overwrite();
      Throwable var6 = null;

      try {
         out.writeString(name);
         out.writeByte(action.ordinal());
         if (packet.atLeast(ProtocolVersion.v1_8)) {
            out.writeVarInt(players.size());
         } else {
            out.writeShort(players.size());
         }

         Iterator var7 = players.iterator();

         while(var7.hasNext()) {
            String player = (String)var7.next();
            out.writeString(player);
         }
      } catch (Throwable var16) {
         var6 = var16;
         throw var16;
      } finally {
         if (out != null) {
            if (var6 != null) {
               try {
                  out.close();
               } catch (Throwable var15) {
                  var6.addSuppressed(var15);
               }
            } else {
               out.close();
            }
         }

      }

      return packet;
   }

   public static enum Action {
      CREATE,
      REMOVE,
      UPDATE,
      ADD_PLAYER,
      REMOVE_PLAYER;
   }
}
