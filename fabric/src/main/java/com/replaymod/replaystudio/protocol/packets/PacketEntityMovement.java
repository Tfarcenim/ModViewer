package com.replaymod.replaystudio.protocol.packets;

import com.replaymod.lib.org.apache.commons.lang3.tuple.Pair;
import com.replaymod.lib.org.apache.commons.lang3.tuple.Triple;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.ProtocolVersion;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketType;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import com.replaymod.replaystudio.util.DPosition;
import java.io.IOException;

public class PacketEntityMovement {
   public static Triple<DPosition, Pair<Float, Float>, Boolean> getMovement(Packet packet) throws IOException {
      PacketType type = packet.getType();
      boolean hasPos = type == PacketType.EntityPosition || type == PacketType.EntityPositionRotation;
      boolean hasRot = type == PacketType.EntityRotation || type == PacketType.EntityPositionRotation;
      Packet.Reader in = packet.reader();
      Throwable var5 = null;

      Triple var9;
      try {
         if (packet.atLeast(ProtocolVersion.v1_8)) {
            in.readVarInt();
         } else {
            in.readInt();
         }

         DPosition pos = null;
         if (hasPos) {
            if (packet.atLeast(ProtocolVersion.v1_9)) {
               pos = new DPosition((double)in.readShort() / 4096.0D, (double)in.readShort() / 4096.0D, (double)in.readShort() / 4096.0D);
            } else {
               pos = new DPosition((double)in.readByte() / 32.0D, (double)in.readByte() / 32.0D, (double)in.readByte() / 32.0D);
            }
         }

         Pair<Float, Float> yawPitch = null;
         if (hasRot) {
            yawPitch = Pair.of((float)in.readByte() / 256.0F * 360.0F, (float)in.readByte() / 256.0F * 360.0F);
         }

         boolean onGround = true;
         if (packet.atLeast(ProtocolVersion.v1_8) && (hasPos || hasRot)) {
            onGround = in.readBoolean();
         }

         var9 = Triple.of(pos, yawPitch, onGround);
      } catch (Throwable var18) {
         var5 = var18;
         throw var18;
      } finally {
         if (in != null) {
            if (var5 != null) {
               try {
                  in.close();
               } catch (Throwable var17) {
                  var5.addSuppressed(var17);
               }
            } else {
               in.close();
            }
         }

      }

      return var9;
   }

   public static Packet write(PacketTypeRegistry registry, int entityId, DPosition deltaPos, Pair<Float, Float> yawPitch, boolean onGround) throws IOException {
      boolean hasPos = deltaPos != null;
      boolean hasRot = yawPitch != null;
      PacketType type;
      if (hasPos) {
         if (hasRot) {
            type = PacketType.EntityPositionRotation;
         } else {
            type = PacketType.EntityPosition;
         }
      } else if (hasRot) {
         type = PacketType.EntityRotation;
      } else {
         type = PacketType.EntityMovement;
      }

      Packet packet = new Packet(registry, type);
      Packet.Writer out = packet.overwrite();
      Throwable var10 = null;

      try {
         if (packet.atLeast(ProtocolVersion.v1_8)) {
            out.writeVarInt(entityId);
         } else {
            out.writeInt(entityId);
         }

         if (hasPos) {
            if (packet.atLeast(ProtocolVersion.v1_9)) {
               out.writeShort((int)(deltaPos.getX() * 4096.0D));
               out.writeShort((int)(deltaPos.getY() * 4096.0D));
               out.writeShort((int)(deltaPos.getZ() * 4096.0D));
            } else {
               out.writeByte((int)(deltaPos.getX() * 32.0D));
               out.writeByte((int)(deltaPos.getY() * 32.0D));
               out.writeByte((int)(deltaPos.getZ() * 32.0D));
            }
         }

         if (hasRot) {
            out.writeByte((int)((Float)yawPitch.getKey() / 360.0F * 256.0F));
            out.writeByte((int)((Float)yawPitch.getValue() / 360.0F * 256.0F));
         }

         if (packet.atLeast(ProtocolVersion.v1_8) && (hasPos || hasRot)) {
            out.writeBoolean(onGround);
         }
      } catch (Throwable var19) {
         var10 = var19;
         throw var19;
      } finally {
         if (out != null) {
            if (var10 != null) {
               try {
                  out.close();
               } catch (Throwable var18) {
                  var10.addSuppressed(var18);
               }
            } else {
               out.close();
            }
         }

      }

      return packet;
   }
}
