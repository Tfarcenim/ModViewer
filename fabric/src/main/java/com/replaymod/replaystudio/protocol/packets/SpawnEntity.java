package com.replaymod.replaystudio.protocol.packets;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.ProtocolVersion;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketType;
import com.replaymod.replaystudio.util.IPosition;
import com.replaymod.replaystudio.util.Location;
import java.io.IOException;

public class SpawnEntity {
   public static Location getLocation(Packet packet) throws IOException {
      PacketType type = packet.getType();
      Packet.Reader in;
      Throwable var3;
      Location var4;
      switch(type) {
      case SpawnExpOrb:
         in = packet.reader();
         var3 = null;

         try {
            in.readVarInt();
            if (!packet.atLeast(ProtocolVersion.v1_9)) {
               var4 = new Location((double)in.readInt() / 32.0D, (double)in.readInt() / 32.0D, (double)in.readInt() / 32.0D, 0.0F, 0.0F);
               return var4;
            }

            var4 = new Location(in.readDouble(), in.readDouble(), in.readDouble(), 0.0F, 0.0F);
         } catch (Throwable var85) {
            var3 = var85;
            throw var85;
         } finally {
            if (in != null) {
               if (var3 != null) {
                  try {
                     in.close();
                  } catch (Throwable var75) {
                     var3.addSuppressed(var75);
                  }
               } else {
                  in.close();
               }
            }

         }

         return var4;
      case SpawnObject:
      case SpawnMob:
         in = packet.reader();
         var3 = null;

         try {
            in.readVarInt();
            if (packet.atLeast(ProtocolVersion.v1_9)) {
               in.readUUID();
            }

            if (packet.atLeast(ProtocolVersion.v1_11)) {
               in.readVarInt();
            } else {
               in.readUnsignedByte();
            }

            var4 = readXYZYaPi(packet, in, type == PacketType.SpawnObject);
         } catch (Throwable var83) {
            var3 = var83;
            throw var83;
         } finally {
            if (in != null) {
               if (var3 != null) {
                  try {
                     in.close();
                  } catch (Throwable var78) {
                     var3.addSuppressed(var78);
                  }
               } else {
                  in.close();
               }
            }

         }

         return var4;
      case SpawnPlayer:
         in = packet.reader();
         var3 = null;

         try {
            in.readVarInt();
            if (packet.atLeast(ProtocolVersion.v1_8)) {
               in.readUUID();
            } else {
               in.readString();
               in.readString();
               int properties = in.readVarInt();

               for(int i = 0; i < properties; ++i) {
                  in.readString();
                  in.readString();
                  in.readString();
               }
            }

            var4 = readXYZYaPi(packet, in, false);
         } catch (Throwable var81) {
            var3 = var81;
            throw var81;
         } finally {
            if (in != null) {
               if (var3 != null) {
                  try {
                     in.close();
                  } catch (Throwable var76) {
                     var3.addSuppressed(var76);
                  }
               } else {
                  in.close();
               }
            }

         }

         return var4;
      case SpawnPainting:
         in = packet.reader();
         var3 = null;

         try {
            in.readVarInt();
            if (packet.atLeast(ProtocolVersion.v1_9)) {
               in.readUUID();
            }

            if (packet.atLeast(ProtocolVersion.v1_13)) {
               in.readVarInt();
            } else {
               in.readString();
            }

            if (packet.atLeast(ProtocolVersion.v1_8)) {
               IPosition pos = in.readPosition();
               Location var5 = new Location((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), 0.0F, 0.0F);
               return var5;
            }

            var4 = new Location((double)in.readInt(), (double)in.readInt(), (double)in.readInt(), 0.0F, 0.0F);
         } catch (Throwable var79) {
            var3 = var79;
            throw var79;
         } finally {
            if (in != null) {
               if (var3 != null) {
                  try {
                     in.close();
                  } catch (Throwable var77) {
                     var3.addSuppressed(var77);
                  }
               } else {
                  in.close();
               }
            }

         }

         return var4;
      default:
         return null;
      }
   }

   static Location readXYZYaPi(Packet packet, Packet.Reader in, boolean flippedYawPitch) throws IOException {
      double x;
      double y;
      double z;
      if (packet.atLeast(ProtocolVersion.v1_9)) {
         x = in.readDouble();
         y = in.readDouble();
         z = in.readDouble();
      } else {
         x = (double)in.readInt() / 32.0D;
         y = (double)in.readInt() / 32.0D;
         z = (double)in.readInt() / 32.0D;
      }

      float yaw = (float)in.readByte() / 256.0F * 360.0F;
      float pitch = (float)in.readByte() / 256.0F * 360.0F;
      if (flippedYawPitch) {
         float tmp = pitch;
         pitch = yaw;
         yaw = tmp;
      }

      return new Location(x, y, z, yaw, pitch);
   }

   static void writeXYZYaPi(Packet packet, Packet.Writer out, Location loc) throws IOException {
      if (packet.atLeast(ProtocolVersion.v1_9)) {
         out.writeDouble(loc.getX());
         out.writeDouble(loc.getY());
         out.writeDouble(loc.getZ());
      } else {
         out.writeInt((int)(loc.getX() * 32.0D));
         out.writeInt((int)(loc.getY() * 32.0D));
         out.writeInt((int)(loc.getZ() * 32.0D));
      }

      out.writeByte((int)(loc.getYaw() / 360.0F * 256.0F));
      out.writeByte((int)(loc.getPitch() / 360.0F * 256.0F));
   }
}
