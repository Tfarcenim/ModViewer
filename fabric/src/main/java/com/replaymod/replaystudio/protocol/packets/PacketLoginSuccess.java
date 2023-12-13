package com.replaymod.replaystudio.protocol.packets;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.ProtocolVersion;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketType;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import com.replaymod.replaystudio.util.Property;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class PacketLoginSuccess {
   private final UUID id;
   private final String name;
   private final List<Property> properties;

   public PacketLoginSuccess(UUID id, String name, List<Property> properties) {
      this.id = id;
      this.name = name;
      this.properties = properties;
   }

   public static PacketLoginSuccess read(Packet packet) throws IOException {
      Packet.Reader in = packet.reader();
      Throwable var2 = null;

      PacketLoginSuccess var6;
      try {
         UUID id;
         if (packet.atLeast(ProtocolVersion.v1_16)) {
            id = in.readUUID();
         } else {
            id = UUID.fromString(in.readString());
         }

         String name = in.readString();
         List<Property> properties = null;
         if (packet.atLeast(ProtocolVersion.v1_19)) {
            properties = in.readList(() -> {
               return Property.read(in);
            });
         }

         var6 = new PacketLoginSuccess(id, name, properties);
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

      return var6;
   }

   public Packet write(PacketTypeRegistry registry) throws IOException {
      Packet packet = new Packet(registry, PacketType.LoginSuccess);
      Packet.Writer out = packet.overwrite();
      Throwable var4 = null;

      try {
         if (packet.atLeast(ProtocolVersion.v1_16)) {
            out.writeUUID(this.id);
         } else {
            out.writeString(this.id.toString());
         }

         out.writeString(this.name);
         if (packet.atLeast(ProtocolVersion.v1_19)) {
            out.writeList(this.properties, (it) -> {
               it.write(out);
            });
         }
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
