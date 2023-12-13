package com.replaymod.replaystudio.protocol.packets;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.ProtocolVersion;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketType;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import com.replaymod.replaystudio.util.IPosition;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PacketBlockChange {
   private IPosition pos;
   private int id;

   private PacketBlockChange() {
   }

   public PacketBlockChange(IPosition pos, int id) {
      this.pos = pos;
      this.id = id;
   }

   public static PacketBlockChange read(Packet packet) throws IOException {
      PacketBlockChange p = new PacketBlockChange();
      Packet.Reader in = packet.reader();
      Throwable var3 = null;

      try {
         if (packet.atLeast(ProtocolVersion.v1_8)) {
            p.pos = in.readPosition();
            p.id = in.readVarInt();
         } else {
            int x = in.readInt();
            int y = in.readUnsignedByte();
            int z = in.readInt();
            p.pos = new IPosition(x, y, z);
            p.id = in.readVarInt() << 4 | in.readUnsignedByte() & 15;
         }
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

      return p;
   }

   public static Packet write(PacketTypeRegistry registry, IPosition pos, int id) throws IOException {
      return (new PacketBlockChange(pos, id)).write(registry);
   }

   public Packet write(PacketTypeRegistry registry) throws IOException {
      Packet packet = new Packet(registry, PacketType.BlockChange);
      Packet.Writer out = packet.overwrite();
      Throwable var4 = null;

      try {
         if (packet.atLeast(ProtocolVersion.v1_8)) {
            out.writePosition(this.pos);
            out.writeVarInt(this.id);
         } else {
            out.writeInt(this.pos.getX());
            out.writeByte(this.pos.getY());
            out.writeInt(this.pos.getZ());
            out.writeVarInt(this.id >> 4);
            out.writeByte(this.id & 15);
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

   public static List<PacketBlockChange> readBulk(Packet packet) throws IOException {
      Packet.Reader in = packet.reader();
      Throwable var2 = null;

      List var24;
      try {
         int chunkX;
         int chunkY;
         int chunkZ;
         if (packet.atLeast(ProtocolVersion.v1_16_2)) {
            long coord = in.readLong();
            chunkX = (int)(coord >> 42);
            chunkY = (int)(coord << 44 >> 44);
            chunkZ = (int)(coord << 22 >> 42);
            if (packet.olderThan(ProtocolVersion.v1_20)) {
               in.readBoolean();
            }
         } else {
            chunkX = in.readInt();
            chunkY = 0;
            chunkZ = in.readInt();
         }

         PacketBlockChange[] result;
         if (packet.atLeast(ProtocolVersion.v1_8)) {
            result = new PacketBlockChange[in.readVarInt()];
         } else {
            result = new PacketBlockChange[in.readShort()];
            in.readInt();
         }

         for(int index = 0; index < result.length; ++index) {
            PacketBlockChange p = new PacketBlockChange();
            int x;
            int y;
            if (packet.atLeast(ProtocolVersion.v1_16_2)) {
               long change = in.readVarLong();
               x = (chunkX << 4) + (int)(change >> 8 & 15L);
               y = (chunkY << 4) + (int)(change & 15L);
               int z = (chunkZ << 4) + (int)(change >> 4 & 15L);
               p.pos = new IPosition(x, y, z);
               p.id = (int)(change >>> 12);
            } else {
               short coords = in.readShort();
               int x = (chunkX << 4) + (coords >> 12 & 15);
               x = coords & 255;
               y = (chunkZ << 4) + (coords >> 8 & 15);
               p.pos = new IPosition(x, x, y);
               if (packet.atLeast(ProtocolVersion.v1_8)) {
                  p.id = in.readVarInt();
               } else {
                  p.id = in.readShort();
               }
            }

            result[index] = p;
         }

         var24 = Arrays.asList(result);
      } catch (Throwable var21) {
         var2 = var21;
         throw var21;
      } finally {
         if (in != null) {
            if (var2 != null) {
               try {
                  in.close();
               } catch (Throwable var20) {
                  var2.addSuppressed(var20);
               }
            } else {
               in.close();
            }
         }

      }

      return var24;
   }

   public static List<PacketBlockChange> readSingleOrBulk(Packet packet) throws IOException {
      return packet.getType() == PacketType.BlockChange ? Collections.singletonList(read(packet)) : readBulk(packet);
   }

   public IPosition getPosition() {
      return this.pos;
   }

   public int getId() {
      return this.id;
   }
}
