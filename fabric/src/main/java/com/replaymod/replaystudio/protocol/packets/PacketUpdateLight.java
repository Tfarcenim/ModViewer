package com.replaymod.replaystudio.protocol.packets;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.ProtocolVersion;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketType;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

public class PacketUpdateLight {
   private static final byte[] EMPTY = new byte[2048];
   private int x;
   private int z;
   private PacketUpdateLight.Data data;

   public static PacketUpdateLight read(Packet packet) throws IOException {
      if (packet.getType() != PacketType.UpdateLight) {
         throw new IllegalArgumentException("Can only read packets of type UpdateLight.");
      } else {
         PacketUpdateLight updateLight = new PacketUpdateLight();
         Packet.Reader reader = packet.reader();
         Throwable var3 = null;

         try {
            updateLight.read(packet, reader);
         } catch (Throwable var12) {
            var3 = var12;
            throw var12;
         } finally {
            if (reader != null) {
               if (var3 != null) {
                  try {
                     reader.close();
                  } catch (Throwable var11) {
                     var3.addSuppressed(var11);
                  }
               } else {
                  reader.close();
               }
            }

         }

         return updateLight;
      }
   }

   public Packet write(PacketTypeRegistry registry) throws IOException {
      Packet packet = new Packet(registry, PacketType.UpdateLight);
      Packet.Writer writer = packet.overwrite();
      Throwable var4 = null;

      try {
         this.write(packet, writer);
      } catch (Throwable var13) {
         var4 = var13;
         throw var13;
      } finally {
         if (writer != null) {
            if (var4 != null) {
               try {
                  writer.close();
               } catch (Throwable var12) {
                  var4.addSuppressed(var12);
               }
            } else {
               writer.close();
            }
         }

      }

      return packet;
   }

   private PacketUpdateLight() {
   }

   public PacketUpdateLight(int x, int z, List<byte[]> skyLight, List<byte[]> blockLight) {
      this(x, z, new PacketUpdateLight.Data(skyLight, blockLight));
   }

   public PacketUpdateLight(int x, int z, PacketUpdateLight.Data data) {
      this.x = x;
      this.z = z;
      this.data = data;
   }

   public int getX() {
      return this.x;
   }

   public int getZ() {
      return this.z;
   }

   public PacketUpdateLight.Data getData() {
      return this.data;
   }

   public List<byte[]> getSkyLight() {
      return this.data.skyLight;
   }

   public List<byte[]> getBlockLight() {
      return this.data.blockLight;
   }

   private void read(Packet packet, Packet.Reader in) throws IOException {
      this.x = in.readVarInt();
      this.z = in.readVarInt();
      this.data = readData(packet, in);
   }

   static PacketUpdateLight.Data readData(Packet packet, Packet.Reader in) throws IOException {
      PacketUpdateLight.Data data = new PacketUpdateLight.Data();
      if (packet.atLeast(ProtocolVersion.v1_16) && packet.olderThan(ProtocolVersion.v1_20)) {
         in.readBoolean();
      }

      BitSet skyLightMask = in.readBitSet();
      BitSet blockLightMask = in.readBitSet();
      BitSet emptySkyLightMask = in.readBitSet();
      BitSet emptyBlockLightMask = in.readBitSet();
      int skySections = Math.max(skyLightMask.length(), emptySkyLightMask.length());
      int blockSections = Math.max(blockLightMask.length(), emptyBlockLightMask.length());
      int i;
      if (packet.atLeast(ProtocolVersion.v1_17)) {
         i = in.readVarInt();
         if (skyLightMask.cardinality() != i) {
            throw new IOException("Expected " + skyLightMask.cardinality() + " sky light sections but got " + i);
         }
      }

      data.skyLight = new ArrayList(skySections);

      for(i = 0; i < skySections; ++i) {
         if (skyLightMask.get(i)) {
            if (in.readVarInt() != 2048) {
               throw new IOException("Expected sky light byte array to be of length 2048");
            }

            data.skyLight.add(in.readBytes(2048));
         } else if (emptySkyLightMask.get(i)) {
            data.skyLight.add(new byte[2048]);
         } else {
            data.skyLight.add((Object)null);
         }
      }

      if (packet.atLeast(ProtocolVersion.v1_17)) {
         i = in.readVarInt();
         if (blockLightMask.cardinality() != i) {
            throw new IOException("Expected " + blockLightMask.cardinality() + " block light sections but got " + i);
         }
      }

      data.blockLight = new ArrayList(blockSections);

      for(i = 0; i < blockSections; ++i) {
         if (blockLightMask.get(i)) {
            if (in.readVarInt() != 2048) {
               throw new IOException("Expected block light byte array to be of length 2048");
            }

            data.blockLight.add(in.readBytes(2048));
         } else if (emptyBlockLightMask.get(i)) {
            data.blockLight.add(new byte[2048]);
         } else {
            data.blockLight.add((Object)null);
         }
      }

      return data;
   }

   private void write(Packet packet, Packet.Writer out) throws IOException {
      out.writeVarInt(this.x);
      out.writeVarInt(this.z);
      writeData(packet, out, this.data);
   }

   static void writeData(Packet packet, Packet.Writer out, PacketUpdateLight.Data data) throws IOException {
      if (packet.atLeast(ProtocolVersion.v1_16) && packet.olderThan(ProtocolVersion.v1_20)) {
         out.writeBoolean(true);
      }

      BitSet skyLightMask = new BitSet();
      BitSet blockLightMask = new BitSet();
      BitSet emptySkyLightMask = new BitSet();
      BitSet emptyBlockLightMask = new BitSet();
      List<byte[]> skyLights = new ArrayList();
      List<byte[]> blockLights = new ArrayList();

      int i;
      byte[] bytes;
      for(i = 0; i < data.skyLight.size(); ++i) {
         bytes = (byte[])data.skyLight.get(i);
         if (bytes != null) {
            if (Arrays.equals(EMPTY, bytes)) {
               emptySkyLightMask.set(i);
            } else {
               skyLightMask.set(i);
               skyLights.add(bytes);
            }
         }
      }

      for(i = 0; i < data.blockLight.size(); ++i) {
         bytes = (byte[])data.blockLight.get(i);
         if (bytes != null) {
            if (Arrays.equals(EMPTY, bytes)) {
               emptyBlockLightMask.set(i);
            } else {
               blockLightMask.set(i);
               blockLights.add(bytes);
            }
         }
      }

      out.writeBitSet(skyLightMask);
      out.writeBitSet(blockLightMask);
      out.writeBitSet(emptySkyLightMask);
      out.writeBitSet(emptyBlockLightMask);
      if (packet.atLeast(ProtocolVersion.v1_17)) {
         out.writeVarInt(skyLights.size());
      }

      Iterator var11 = skyLights.iterator();

      while(var11.hasNext()) {
         bytes = (byte[])var11.next();
         out.writeVarInt(2048);
         out.writeBytes(bytes);
      }

      if (packet.atLeast(ProtocolVersion.v1_17)) {
         out.writeVarInt(blockLights.size());
      }

      var11 = blockLights.iterator();

      while(var11.hasNext()) {
         bytes = (byte[])var11.next();
         out.writeVarInt(2048);
         out.writeBytes(bytes);
      }

   }

   public static class Data {
      public List<byte[]> skyLight;
      public List<byte[]> blockLight;

      public Data() {
      }

      public Data(List<byte[]> skyLight, List<byte[]> blockLight) {
         this.skyLight = skyLight;
         this.blockLight = blockLight;
      }
   }
}
