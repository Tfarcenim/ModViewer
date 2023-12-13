package com.replaymod.replaystudio.protocol.packets;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.ProtocolVersion;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketType;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PacketDestroyEntities {
   public static List<Integer> getEntityIds(Packet packet) throws IOException {
      Packet.Reader in = packet.reader();
      Throwable var2 = null;

      List var3;
      try {
         if (packet.getType() != PacketType.DestroyEntity) {
            int len = packet.atLeast(ProtocolVersion.v1_8) ? in.readVarInt() : in.readByte();
            List<Integer> result = new ArrayList(len);

            for(int i = 0; i < len; ++i) {
               result.add(packet.atLeast(ProtocolVersion.v1_8) ? in.readVarInt() : in.readInt());
            }

            ArrayList var18 = result;
            return var18;
         }

         var3 = Collections.singletonList(in.readVarInt());
      } catch (Throwable var15) {
         var2 = var15;
         throw var15;
      } finally {
         if (in != null) {
            if (var2 != null) {
               try {
                  in.close();
               } catch (Throwable var14) {
                  var2.addSuppressed(var14);
               }
            } else {
               in.close();
            }
         }

      }

      return var3;
   }

   public static Collection<Packet> write(PacketTypeRegistry registry, int... entityIds) throws IOException {
      if (registry.atLeast(ProtocolVersion.v1_17) && registry.olderThan(ProtocolVersion.v1_17_1)) {
         List<Packet> packets = new ArrayList(entityIds.length);
         int[] var3 = entityIds;
         int var4 = entityIds.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            int entityId = var3[var5];
            packets.add(write(registry, entityId));
         }

         return packets;
      } else {
         return Collections.singletonList(writeDestroyEntities(registry, entityIds));
      }
   }

   public static Packet write(PacketTypeRegistry registry, int entityId) throws IOException {
      if (registry.atLeast(ProtocolVersion.v1_17) && registry.olderThan(ProtocolVersion.v1_17_1)) {
         Packet packet = new Packet(registry, PacketType.DestroyEntity);
         Packet.Writer out = packet.overwrite();
         Throwable var4 = null;

         try {
            out.writeVarInt(entityId);
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
      } else {
         return writeDestroyEntities(registry, entityId);
      }
   }

   private static Packet writeDestroyEntities(PacketTypeRegistry registry, int... entityIds) throws IOException {
      Packet packet = new Packet(registry, PacketType.DestroyEntities);
      Packet.Writer out = packet.overwrite();
      Throwable var4 = null;

      try {
         if (packet.atLeast(ProtocolVersion.v1_8)) {
            out.writeVarInt(entityIds.length);
         } else {
            out.writeByte(entityIds.length);
         }

         int[] var5 = entityIds;
         int var6 = entityIds.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            int entityId = var5[var7];
            if (packet.atLeast(ProtocolVersion.v1_8)) {
               out.writeVarInt(entityId);
            } else {
               out.writeInt(entityId);
            }
         }
      } catch (Throwable var16) {
         var4 = var16;
         throw var16;
      } finally {
         if (out != null) {
            if (var4 != null) {
               try {
                  out.close();
               } catch (Throwable var15) {
                  var4.addSuppressed(var15);
               }
            } else {
               out.close();
            }
         }

      }

      return packet;
   }
}
