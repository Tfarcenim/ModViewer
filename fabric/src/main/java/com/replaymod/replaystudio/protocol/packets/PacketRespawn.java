package com.replaymod.replaystudio.protocol.packets;

import com.replaymod.lib.com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.ProtocolVersion;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketType;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import com.replaymod.replaystudio.protocol.registry.DimensionType;
import com.replaymod.replaystudio.util.IGlobalPosition;
import java.io.IOException;

public class PacketRespawn {
   public byte gameMode;
   public byte prevGameMode;
   public DimensionType dimensionType;
   public String dimension;
   public long seed;
   public int difficulty;
   public boolean debugWorld;
   public boolean flatWorld;
   public boolean keepPlayerAttributes;
   public boolean keepPlayerDataTracker;
   public IGlobalPosition lastDeathPosition;
   public int portalCooldown;

   public static PacketRespawn read(Packet packet, CompoundTag registries) throws IOException {
      Packet.Reader in = packet.reader();
      Throwable var3 = null;

      PacketRespawn var5;
      try {
         PacketRespawn respawn = new PacketRespawn();
         respawn.read(packet, in, registries);
         var5 = respawn;
      } catch (Throwable var14) {
         var3 = var14;
         throw var14;
      } finally {
         if (in != null) {
            if (var3 != null) {
               try {
                  in.close();
               } catch (Throwable var13) {
                  var3.addSuppressed(var13);
               }
            } else {
               in.close();
            }
         }

      }

      return var5;
   }

   public void read(Packet packet, Packet.Reader in, CompoundTag registries) throws IOException {
      if (packet.atLeast(ProtocolVersion.v1_16)) {
         if (packet.atLeast(ProtocolVersion.v1_19)) {
            this.dimensionType = PacketJoinGame.getDimensionType(registries, in.readString());
         } else if (packet.atLeast(ProtocolVersion.v1_16_2)) {
            this.dimensionType = new DimensionType(in.readNBT());
         } else {
            this.dimensionType = new DimensionType(in.readString());
         }

         this.dimension = in.readString();
      } else {
         this.dimension = String.valueOf(in.readInt());
      }

      if (packet.atLeast(ProtocolVersion.v1_15)) {
         this.seed = in.readLong();
      }

      if (packet.olderThan(ProtocolVersion.v1_14)) {
         this.difficulty = in.readByte();
      }

      this.gameMode = in.readByte();
      if (packet.atLeast(ProtocolVersion.v1_16)) {
         this.prevGameMode = in.readByte();
      }

      if (packet.atLeast(ProtocolVersion.v1_16)) {
         this.debugWorld = in.readBoolean();
         this.flatWorld = in.readBoolean();
         if (packet.atLeast(ProtocolVersion.v1_19_3)) {
            int flags = in.readByte();
            this.keepPlayerAttributes = (flags & 1) != 0;
            this.keepPlayerDataTracker = (flags & 2) != 0;
         } else {
            this.keepPlayerAttributes = in.readBoolean();
         }
      } else {
         this.dimensionType = new DimensionType(in.readString());
      }

      if (packet.atLeast(ProtocolVersion.v1_19) && in.readBoolean()) {
         this.lastDeathPosition = in.readGlobalPosition();
      }

      if (packet.atLeast(ProtocolVersion.v1_20)) {
         this.portalCooldown = in.readVarInt();
      }

   }

   public Packet write(PacketTypeRegistry registry) throws IOException {
      Packet packet = new Packet(registry, PacketType.Respawn);
      Packet.Writer out = packet.overwrite();
      Throwable var4 = null;

      try {
         this.write(packet, out);
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

   public void write(Packet packet, Packet.Writer out) throws IOException {
      if (packet.atLeast(ProtocolVersion.v1_16)) {
         if (packet.atLeast(ProtocolVersion.v1_19)) {
            out.writeString(this.dimensionType.getName());
         } else if (packet.atLeast(ProtocolVersion.v1_16_2)) {
            out.writeNBT(this.dimensionType.getTag());
         } else {
            out.writeString(this.dimensionType.getName());
         }

         out.writeString(this.dimension);
      } else {
         out.writeInt(Integer.parseInt(this.dimension));
      }

      if (packet.atLeast(ProtocolVersion.v1_15)) {
         out.writeLong(this.seed);
      }

      if (packet.olderThan(ProtocolVersion.v1_14)) {
         out.writeByte(this.difficulty);
      }

      out.writeByte(this.gameMode);
      if (packet.atLeast(ProtocolVersion.v1_16)) {
         out.writeByte(this.prevGameMode);
         out.writeBoolean(this.debugWorld);
         out.writeBoolean(this.flatWorld);
         if (packet.atLeast(ProtocolVersion.v1_19_3)) {
            int flags = 0;
            if (this.keepPlayerAttributes) {
               flags |= 1;
            }

            if (this.keepPlayerDataTracker) {
               flags |= 2;
            }

            out.writeByte(flags);
         } else {
            out.writeBoolean(this.keepPlayerAttributes);
         }
      } else {
         out.writeString(this.dimensionType.getName());
      }

      if (packet.atLeast(ProtocolVersion.v1_19)) {
         if (this.lastDeathPosition != null) {
            out.writeBoolean(true);
            out.writeGlobalPosition(this.lastDeathPosition);
         } else {
            out.writeBoolean(false);
         }
      }

      if (packet.atLeast(ProtocolVersion.v1_20)) {
         out.writeVarInt(this.portalCooldown);
      }

   }
}
