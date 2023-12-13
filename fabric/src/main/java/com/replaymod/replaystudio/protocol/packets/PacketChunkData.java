package com.replaymod.replaystudio.protocol.packets;

import com.replaymod.lib.com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.replaymod.lib.com.github.steveice10.packetlib.io.NetInput;
import com.replaymod.lib.com.github.steveice10.packetlib.io.NetOutput;
import com.replaymod.lib.com.github.steveice10.packetlib.io.stream.StreamNetInput;
import com.replaymod.lib.com.github.steveice10.packetlib.io.stream.StreamNetOutput;
import com.replaymod.lib.org.apache.commons.lang3.tuple.Pair;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks.PaletteType;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.ProtocolVersion;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketType;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import com.replaymod.replaystudio.util.Utils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class PacketChunkData {
   private PacketChunkData.Column column;
   private boolean isUnload;
   private int unloadX;
   private int unloadZ;

   public static PacketChunkData read(Packet packet, int sections) throws IOException {
      PacketChunkData chunkData = new PacketChunkData();
      Packet.Reader reader = packet.reader();
      Throwable var4 = null;

      try {
         if (packet.atLeast(ProtocolVersion.v1_9)) {
            if (packet.getType() == PacketType.UnloadChunk) {
               chunkData.readUnload((NetInput)reader);
            } else {
               chunkData.readLoad(packet, reader, sections);
            }
         } else {
            chunkData.readLoad(packet, reader, sections);
         }
      } catch (Throwable var13) {
         var4 = var13;
         throw var13;
      } finally {
         if (reader != null) {
            if (var4 != null) {
               try {
                  reader.close();
               } catch (Throwable var12) {
                  var4.addSuppressed(var12);
               }
            } else {
               reader.close();
            }
         }

      }

      return chunkData;
   }

   public static PacketChunkData readUnload(Packet packet) throws IOException {
      PacketChunkData chunkData = new PacketChunkData();
      Packet.Reader reader = packet.reader();
      Throwable var3 = null;

      try {
         chunkData.readUnload((NetInput)reader);
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

      return chunkData;
   }

   public Packet write(PacketTypeRegistry registry) throws IOException {
      boolean atLeastV1_9 = ProtocolVersion.getIndex(registry.getVersion()) >= ProtocolVersion.getIndex(ProtocolVersion.v1_9);
      PacketType packetType;
      if (atLeastV1_9) {
         packetType = this.isUnload ? PacketType.UnloadChunk : PacketType.ChunkData;
      } else {
         packetType = !this.isUnload && this.column.looksLikeUnloadOnMC1_8() ? PacketType.BulkChunkData : PacketType.ChunkData;
      }

      Packet packet = new Packet(registry, packetType);
      Packet.Writer writer = packet.overwrite();
      Throwable var6 = null;

      try {
         if (atLeastV1_9) {
            if (this.isUnload) {
               this.writeUnload(writer);
            } else {
               this.writeLoad(packet, writer);
            }
         } else if (packetType == PacketType.BulkChunkData) {
            if (packet.atLeast(ProtocolVersion.v1_8)) {
               writeBulkV1_8(packet, writer, Collections.singletonList(this.column));
            } else {
               writeBulkV1_7(packet, writer, Collections.singletonList(this.column));
            }
         } else {
            this.writeLoad(packet, writer);
         }
      } catch (Throwable var15) {
         var6 = var15;
         throw var15;
      } finally {
         if (writer != null) {
            if (var6 != null) {
               try {
                  writer.close();
               } catch (Throwable var14) {
                  var6.addSuppressed(var14);
               }
            } else {
               writer.close();
            }
         }

      }

      return packet;
   }

   public static List<PacketChunkData.Column> readBulk(Packet packet) throws IOException {
      Packet.Reader in = packet.reader();
      Throwable var2 = null;

      List var3;
      try {
         if (packet.atLeast(ProtocolVersion.v1_8)) {
            var3 = readBulkV1_8(packet, in);
            return var3;
         }

         var3 = readBulkV1_7(packet, in);
      } catch (Throwable var13) {
         var2 = var13;
         throw var13;
      } finally {
         if (in != null) {
            if (var2 != null) {
               try {
                  in.close();
               } catch (Throwable var12) {
                  var2.addSuppressed(var12);
               }
            } else {
               in.close();
            }
         }

      }

      return var3;
   }

   private static List<PacketChunkData.Column> readBulkV1_8(Packet packet, Packet.Reader in) throws IOException {
      List<PacketChunkData.Column> result = new ArrayList();
      boolean skylight = in.readBoolean();
      int columns = in.readVarInt();
      int[] xs = new int[columns];
      int[] zs = new int[columns];
      BitSet[] masks = new BitSet[columns];
      int[] lengths = new int[columns];

      int column;
      for(column = 0; column < columns; ++column) {
         xs[column] = in.readInt();
         zs[column] = in.readInt();
         masks[column] = in.readBitSet();
         int nChunks = masks[column].cardinality();
         int length = nChunks * 10240 + (skylight ? nChunks * 2048 : 0) + 256;
         lengths[column] = length;
      }

      for(column = 0; column < columns; ++column) {
         byte[] buf = new byte[lengths[column]];
         in.readBytes(buf);
         result.add(readColumn(packet, buf, xs[column], zs[column], true, skylight, masks[column], new BitSet(), (CompoundTag)null, (int[])null, false));
      }

      return result;
   }

   private static void writeBulkV1_8(Packet packet, Packet.Writer out, List<PacketChunkData.Column> columns) throws IOException {
      out.writeBoolean(columns.stream().anyMatch(PacketChunkData.Column::hasSkyLightV1_8));
      out.writeVarInt(columns.size());
      Iterator var3 = columns.iterator();

      PacketChunkData.Column column;
      while(var3.hasNext()) {
         column = (PacketChunkData.Column)var3.next();
         out.writeInt(column.x);
         out.writeInt(column.z);
         out.writeBitSet(column.getChunkMask());
      }

      var3 = columns.iterator();

      while(var3.hasNext()) {
         column = (PacketChunkData.Column)var3.next();
         writeColumn(packet, out, column, true);
      }

   }

   private static List<PacketChunkData.Column> readBulkV1_7(Packet packet, Packet.Reader in) throws IOException {
      List<PacketChunkData.Column> result = new ArrayList();
      short columns = in.readShort();
      int deflatedLength = in.readInt();
      boolean skylight = in.readBoolean();
      byte[] deflatedBytes = in.readBytes(deflatedLength);
      byte[] inflated = new byte[196864 * columns];
      Inflater inflater = new Inflater();
      inflater.setInput(deflatedBytes, 0, deflatedLength);

      try {
         inflater.inflate(inflated);
      } catch (DataFormatException var21) {
         throw new IOException("Bad compressed data format");
      } finally {
         inflater.end();
      }

      int pos = 0;

      for(int count = 0; count < columns; ++count) {
         int x = in.readInt();
         int z = in.readInt();
         BitSet chunkMask = in.readBitSet();
         BitSet extendedChunkMask = in.readBitSet();
         int chunks = chunkMask.cardinality();
         int extended = extendedChunkMask.cardinality();
         int length = 8192 * chunks + 256 + 2048 * extended;
         if (skylight) {
            length += 2048 * chunks;
         }

         byte[] buf = new byte[length];
         System.arraycopy(inflated, pos, buf, 0, length);
         result.add(readColumn(packet, buf, x, z, true, skylight, chunkMask, extendedChunkMask, (CompoundTag)null, (int[])null, false));
         pos += length;
      }

      return result;
   }

   private static void writeBulkV1_7(Packet packet, Packet.Writer out, List<PacketChunkData.Column> columns) throws IOException {
      throw new UnsupportedOperationException("writeBulkV1_7 is not yet implemented");
   }

   public static PacketChunkData load(PacketChunkData.Column column) {
      PacketChunkData chunkData = new PacketChunkData();
      chunkData.column = column;
      return chunkData;
   }

   public static PacketChunkData unload(int chunkX, int chunkZ) {
      PacketChunkData chunkData = new PacketChunkData();
      chunkData.isUnload = true;
      chunkData.unloadX = chunkX;
      chunkData.unloadZ = chunkZ;
      chunkData.column = new PacketChunkData.Column(chunkX, chunkZ, new PacketChunkData.Chunk[16], new byte[256], (PacketChunkData.TileEntity[])null, (CompoundTag)null, (int[])null, false, (PacketUpdateLight.Data)null);
      return chunkData;
   }

   private PacketChunkData() {
   }

   public PacketChunkData.Column getColumn() {
      return this.column;
   }

   public boolean isUnload() {
      return this.isUnload;
   }

   public int getUnloadX() {
      return this.unloadX;
   }

   public int getUnloadZ() {
      return this.unloadZ;
   }

   private void readUnload(NetInput in) throws IOException {
      this.isUnload = true;
      this.unloadX = in.readInt();
      this.unloadZ = in.readInt();
   }

   private void writeUnload(NetOutput out) throws IOException {
      out.writeInt(this.unloadX);
      out.writeInt(this.unloadZ);
   }

   private void readLoad(Packet packet, Packet.Reader in, int sections) throws IOException {
      int x = in.readInt();
      int z = in.readInt();
      boolean fullChunk;
      if (packet.atLeast(ProtocolVersion.v1_17)) {
         fullChunk = true;
      } else {
         fullChunk = in.readBoolean();
      }

      boolean useExistingLightData = fullChunk;
      if (packet.atLeast(ProtocolVersion.v1_16) && !packet.atLeast(ProtocolVersion.v1_16_2)) {
         useExistingLightData = in.readBoolean();
      }

      BitSet chunkMask;
      if (packet.atLeast(ProtocolVersion.v1_18)) {
         chunkMask = new BitSet();
         chunkMask.set(0, sections);
      } else {
         chunkMask = in.readBitSet();
      }

      BitSet extendedChunkMask;
      if (packet.atLeast(ProtocolVersion.v1_8)) {
         extendedChunkMask = new BitSet();
      } else {
         extendedChunkMask = BitSet.valueOf(new long[]{(long)in.readUnsignedShort()});
      }

      CompoundTag heightmaps = null;
      if (packet.atLeast(ProtocolVersion.v1_14)) {
         heightmaps = in.readNBT();
      }

      int[] biomes = null;
      if (packet.atLeast(ProtocolVersion.v1_15) && packet.olderThan(ProtocolVersion.v1_18) && fullChunk) {
         if (packet.atLeast(ProtocolVersion.v1_16_2)) {
            biomes = new int[in.readVarInt()];

            for(int i = 0; i < biomes.length; ++i) {
               biomes[i] = in.readVarInt();
            }
         } else {
            biomes = in.readInts(1024);
         }
      }

      int i;
      byte[] data;
      if (packet.atLeast(ProtocolVersion.v1_8)) {
         data = in.readBytes(in.readVarInt());
      } else {
         byte[] deflated = in.readBytes(in.readInt());
         i = 12288 * chunkMask.cardinality();
         if (fullChunk) {
            i += 256;
         }

         data = new byte[i];
         Inflater inflater = new Inflater();
         inflater.setInput(deflated, 0, deflated.length);

         try {
            inflater.inflate(data);
         } catch (DataFormatException var20) {
            throw new IOException("Bad compressed data format");
         } finally {
            inflater.end();
         }
      }

      this.column = readColumn(packet, data, x, z, fullChunk, false, chunkMask, extendedChunkMask, heightmaps, biomes, useExistingLightData);
      if (packet.atLeast(ProtocolVersion.v1_9_3)) {
         PacketChunkData.TileEntity[] tileEntities = new PacketChunkData.TileEntity[in.readVarInt()];

         for(i = 0; i < tileEntities.length; ++i) {
            tileEntities[i] = new PacketChunkData.TileEntity(packet, in);
         }

         this.column.tileEntities = tileEntities;
      }

      if (packet.atLeast(ProtocolVersion.v1_18)) {
         this.column.lightData = PacketUpdateLight.readData(packet, in);
      }

      if (packet.atMost(ProtocolVersion.v1_8) && fullChunk && chunkMask.isEmpty()) {
         this.isUnload = true;
         this.unloadX = x;
         this.unloadZ = z;
      }

   }

   private void writeLoad(Packet packet, Packet.Writer out) throws IOException {
      ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
      NetOutput netOut = new StreamNetOutput(byteOut);
      Pair<BitSet, BitSet> masks = writeColumn(packet, netOut, this.column, this.column.isFull());
      BitSet mask = (BitSet)masks.getKey();
      BitSet extendedMask = (BitSet)masks.getValue();
      out.writeInt(this.column.x);
      out.writeInt(this.column.z);
      if (packet.olderThan(ProtocolVersion.v1_17)) {
         out.writeBoolean(this.column.isFull());
      }

      if (packet.atLeast(ProtocolVersion.v1_16) && !packet.atLeast(ProtocolVersion.v1_16_2)) {
         out.writeBoolean(this.column.useExistingLightData);
      }

      if (packet.olderThan(ProtocolVersion.v1_18)) {
         out.writeBitSet(mask);
      }

      if (!packet.atLeast(ProtocolVersion.v1_8)) {
         out.writeBitSet(extendedMask);
      }

      if (packet.atLeast(ProtocolVersion.v1_14)) {
         out.writeNBT(this.column.heightMaps);
      }

      int[] biomes = this.column.biomes;
      int biome;
      if (packet.atLeast(ProtocolVersion.v1_15) && packet.olderThan(ProtocolVersion.v1_18) && biomes != null) {
         if (packet.atLeast(ProtocolVersion.v1_16_2)) {
            out.writeVarInt(biomes.length);
            int[] var9 = biomes;
            int var10 = biomes.length;

            for(int var11 = 0; var11 < var10; ++var11) {
               biome = var9[var11];
               out.writeVarInt(biome);
            }
         } else {
            out.writeInts(biomes);
         }
      }

      int len;
      byte[] data;
      if (packet.atLeast(ProtocolVersion.v1_8)) {
         len = byteOut.size();
         data = byteOut.toByteArray();
      } else {
         Deflater deflater = new Deflater(-1);
         len = byteOut.size();
         data = new byte[len];

         try {
            deflater.setInput(byteOut.toByteArray(), 0, len);
            deflater.finish();
            len = deflater.deflate(data);
         } finally {
            deflater.end();
         }
      }

      out.writeVarInt(len);
      out.writeBytes(data, len);
      if (packet.atLeast(ProtocolVersion.v1_9_3)) {
         out.writeVarInt(this.column.tileEntities.length);
         PacketChunkData.TileEntity[] var20 = this.column.tileEntities;
         biome = var20.length;

         for(int var13 = 0; var13 < biome; ++var13) {
            PacketChunkData.TileEntity tileEntity = var20[var13];
            tileEntity.write(packet, out);
         }
      }

      if (packet.atLeast(ProtocolVersion.v1_18)) {
         PacketUpdateLight.writeData(packet, out, this.column.lightData);
      }

   }

   private static PacketChunkData.Column readColumn(Packet packet, byte[] data, int x, int z, boolean fullChunk, boolean hasSkylight, BitSet mask, BitSet extendedMask, CompoundTag heightmaps, int[] biomes, boolean useExistingLightData) throws IOException {
      NetInput in = new StreamNetInput(new ByteArrayInputStream(data));
      if (packet.atLeast(ProtocolVersion.v1_17)) {
         PacketChunkData.Chunk[] chunks = new PacketChunkData.Chunk[mask.length()];

         for(int index = 0; index < chunks.length; ++index) {
            if (mask.get(index)) {
               chunks[index] = new PacketChunkData.Chunk(packet, in);
            }
         }

         return new PacketChunkData.Column(x, z, chunks, (byte[])null, (PacketChunkData.TileEntity[])null, heightmaps, biomes, useExistingLightData, (PacketUpdateLight.Data)null);
      } else {
         Throwable ex = null;
         PacketChunkData.Column column = null;

         try {
            PacketChunkData.Chunk[] chunks = new PacketChunkData.Chunk[16];

            int index;
            for(index = 0; index < chunks.length; ++index) {
               if (mask.get(index)) {
                  PacketChunkData.Chunk chunk;
                  if (packet.atLeast(ProtocolVersion.v1_9)) {
                     chunk = new PacketChunkData.Chunk(packet, in);
                     if (packet.atMost(ProtocolVersion.v1_13_2)) {
                        chunk.blockLight = in.readBytes(2048);
                        chunk.skyLight = hasSkylight ? in.readBytes(2048) : null;
                     }
                  } else {
                     chunk = new PacketChunkData.Chunk(packet);
                  }

                  chunks[index] = chunk;
               }
            }

            if (!packet.atLeast(ProtocolVersion.v1_9)) {
               int var17;
               PacketChunkData.Chunk chunk;
               PacketChunkData.Chunk[] var22;
               int var23;
               if (packet.atLeast(ProtocolVersion.v1_8)) {
                  var22 = chunks;
                  var23 = chunks.length;

                  for(var17 = 0; var17 < var23; ++var17) {
                     chunk = var22[var17];
                     if (chunk != null) {
                        chunk.blocks.storage = PacketChunkData.FlexibleStorage.from(packet.getRegistry(), 0, 4096, in.readLongs(1024));
                     }
                  }
               } else {
                  var22 = chunks;
                  var23 = chunks.length;

                  for(var17 = 0; var17 < var23; ++var17) {
                     chunk = var22[var17];
                     if (chunk != null) {
                        chunk.blocks.storage = PacketChunkData.FlexibleStorage.from(packet.getRegistry(), 0, 4096, in.readLongs(512));
                     }
                  }

                  var22 = chunks;
                  var23 = chunks.length;

                  for(var17 = 0; var17 < var23; ++var17) {
                     chunk = var22[var17];
                     if (chunk != null) {
                        chunk.blocks.metadata = in.readLongs(256);
                     }
                  }
               }

               var22 = chunks;
               var23 = chunks.length;

               for(var17 = 0; var17 < var23; ++var17) {
                  chunk = var22[var17];
                  if (chunk != null) {
                     chunk.blockLight = in.readBytes(2048);
                  }
               }

               if (hasSkylight) {
                  var22 = chunks;
                  var23 = chunks.length;

                  for(var17 = 0; var17 < var23; ++var17) {
                     chunk = var22[var17];
                     if (chunk != null) {
                        chunk.skyLight = in.readBytes(2048);
                     }
                  }
               }

               for(index = 0; index < chunks.length; ++index) {
                  if (extendedMask.get(index)) {
                     if (chunks[index] == null) {
                        in.readLongs(256);
                     } else {
                        chunks[index].blocks.extended = in.readLongs(256);
                     }
                  }
               }
            }

            byte[] biomeData = null;
            if (fullChunk && in.available() > 0 && !packet.atLeast(ProtocolVersion.v1_15)) {
               biomeData = in.readBytes(packet.atLeast(ProtocolVersion.v1_13) ? 1024 : 256);
            }

            column = new PacketChunkData.Column(x, z, chunks, biomeData, (PacketChunkData.TileEntity[])null, heightmaps, biomes, useExistingLightData, (PacketUpdateLight.Data)null);
         } catch (Throwable var19) {
            ex = var19;
         }

         if ((in.available() > 0 || ex != null) && !hasSkylight) {
            return readColumn(packet, data, x, z, fullChunk, true, mask, extendedMask, heightmaps, biomes, useExistingLightData);
         } else if (ex != null) {
            throw new IOException("Failed to read chunk data.", ex);
         } else {
            return column;
         }
      }
   }

   private static Pair<BitSet, BitSet> writeColumn(Packet packet, NetOutput out, PacketChunkData.Column column, boolean fullChunk) throws IOException {
      BitSet mask = new BitSet();
      BitSet extendedMask = new BitSet();
      PacketChunkData.Chunk[] chunks = column.chunks;

      int index;
      for(index = 0; index < chunks.length; ++index) {
         PacketChunkData.Chunk chunk = chunks[index];
         if (chunk != null) {
            mask.set(index);
            if (packet.atLeast(ProtocolVersion.v1_9)) {
               chunk.write(packet, out);
               if (packet.atMost(ProtocolVersion.v1_13_2)) {
                  out.writeBytes(chunk.blockLight);
                  if (chunk.skyLight != null) {
                     out.writeBytes(chunk.skyLight);
                  }
               }
            }
         }
      }

      if (!packet.atLeast(ProtocolVersion.v1_9)) {
         int var9;
         PacketChunkData.Chunk chunk;
         PacketChunkData.Chunk[] var11;
         int var12;
         if (packet.atLeast(ProtocolVersion.v1_8)) {
            var11 = chunks;
            var12 = chunks.length;

            for(var9 = 0; var9 < var12; ++var9) {
               chunk = var11[var9];
               if (chunk != null) {
                  out.writeLongs(chunk.blocks.storage.data);
               }
            }
         } else {
            var11 = chunks;
            var12 = chunks.length;

            for(var9 = 0; var9 < var12; ++var9) {
               chunk = var11[var9];
               if (chunk != null) {
                  out.writeLongs(chunk.blocks.storage.data);
               }
            }

            var11 = chunks;
            var12 = chunks.length;

            for(var9 = 0; var9 < var12; ++var9) {
               chunk = var11[var9];
               if (chunk != null) {
                  out.writeLongs(chunk.blocks.metadata);
               }
            }
         }

         var11 = chunks;
         var12 = chunks.length;

         for(var9 = 0; var9 < var12; ++var9) {
            chunk = var11[var9];
            if (chunk != null) {
               out.writeBytes(chunk.blockLight);
            }
         }

         var11 = chunks;
         var12 = chunks.length;

         for(var9 = 0; var9 < var12; ++var9) {
            chunk = var11[var9];
            if (chunk != null && chunk.skyLight != null) {
               out.writeBytes(chunk.skyLight);
            }
         }

         for(index = 0; index < chunks.length; ++index) {
            if (chunks[index] != null && chunks[index].blocks.extended != null) {
               extendedMask.set(index);
               out.writeLongs(chunks[index].blocks.extended);
            }
         }
      }

      if (fullChunk && column.biomeData != null && !packet.atLeast(ProtocolVersion.v1_15)) {
         out.writeBytes(column.biomeData);
      }

      return Pair.of(mask, extendedMask);
   }

   public static class TileEntity {
      public byte xz;
      public short y;
      public int type;
      public CompoundTag tag;

      TileEntity(Packet packet, Packet.Reader in) throws IOException {
         if (packet.atLeast(ProtocolVersion.v1_18)) {
            this.xz = in.readByte();
            this.y = in.readShort();
            this.type = in.readVarInt();
         }

         this.tag = in.readNBT();
      }

      void write(Packet packet, Packet.Writer out) throws IOException {
         if (packet.atLeast(ProtocolVersion.v1_18)) {
            out.writeByte(this.xz);
            out.writeShort(this.y);
            out.writeVarInt(this.type);
         }

         out.writeNBT(this.tag);
      }
   }

   private static class CompactFlexibleStorage extends PacketChunkData.FlexibleStorage {
      public CompactFlexibleStorage(int bitsPerEntry, int entries) {
         this(bitsPerEntry, entries, new long[roundToNearest(entries * bitsPerEntry, 64) / 64]);
      }

      public CompactFlexibleStorage(int bitsPerEntry, int entries, long[] data) {
         super(data, bitsPerEntry, entries);
      }

      private static int roundToNearest(int value, int roundTo) {
         if (roundTo == 0) {
            return 0;
         } else if (value == 0) {
            return roundTo;
         } else {
            if (value < 0) {
               roundTo *= -1;
            }

            int remainder = value % roundTo;
            return remainder != 0 ? value + roundTo - remainder : value;
         }
      }

      public int get(int index) {
         if (index >= 0 && index <= this.entries - 1) {
            if (this.bitsPerEntry == 0) {
               return 0;
            } else {
               int bitIndex = index * this.bitsPerEntry;
               int startIndex = bitIndex / 64;
               int endIndex = ((index + 1) * this.bitsPerEntry - 1) / 64;
               int startBitSubIndex = bitIndex % 64;
               if (startIndex == endIndex) {
                  return (int)(this.data[startIndex] >>> startBitSubIndex & this.maxEntryValue);
               } else {
                  int endBitSubIndex = 64 - startBitSubIndex;
                  return (int)((this.data[startIndex] >>> startBitSubIndex | this.data[endIndex] << endBitSubIndex) & this.maxEntryValue);
               }
            }
         } else {
            throw new IndexOutOfBoundsException();
         }
      }

      public void set(int index, int value) {
         if (index >= 0 && index <= this.entries - 1) {
            if (value >= 0 && (long)value <= this.maxEntryValue) {
               int bitIndex = index * this.bitsPerEntry;
               int startIndex = bitIndex / 64;
               int endIndex = ((index + 1) * this.bitsPerEntry - 1) / 64;
               int startBitSubIndex = bitIndex % 64;
               this.data[startIndex] = this.data[startIndex] & ~(this.maxEntryValue << startBitSubIndex) | ((long)value & this.maxEntryValue) << startBitSubIndex;
               if (startIndex != endIndex) {
                  int endBitSubIndex = 64 - startBitSubIndex;
                  this.data[endIndex] = this.data[endIndex] >>> endBitSubIndex << endBitSubIndex | ((long)value & this.maxEntryValue) >> endBitSubIndex;
               }

            } else {
               throw new IllegalArgumentException("Value cannot be outside of accepted range.");
            }
         } else {
            throw new IndexOutOfBoundsException();
         }
      }
   }

   private static class PaddedFlexibleStorage extends PacketChunkData.FlexibleStorage {
      private final int entriesPerLong;

      public PaddedFlexibleStorage(int bitsPerEntry, int entries) {
         this(bitsPerEntry, entries, new long[longsForEntries(bitsPerEntry, entries)]);
      }

      public PaddedFlexibleStorage(int bitsPerEntry, int entries, long[] data) {
         super(data, bitsPerEntry, entries);
         this.entriesPerLong = bitsPerEntry == 0 ? 0 : 64 / bitsPerEntry;
      }

      private static int longsForEntries(int bitsPerEntry, int entries) {
         if (bitsPerEntry == 0) {
            return 0;
         } else {
            int entriesPerLong = 64 / bitsPerEntry;
            return (entries + entriesPerLong - 1) / entriesPerLong;
         }
      }

      public int get(int index) {
         if (index >= 0 && index <= this.entries - 1) {
            if (this.bitsPerEntry == 0) {
               return 0;
            } else {
               int blockIndex = index / this.entriesPerLong;
               int subIndex = index % this.entriesPerLong;
               int subIndexBits = subIndex * this.bitsPerEntry;
               return (int)(this.data[blockIndex] >>> subIndexBits & this.maxEntryValue);
            }
         } else {
            throw new IndexOutOfBoundsException();
         }
      }

      public void set(int index, int value) {
         if (index >= 0 && index <= this.entries - 1) {
            if (value >= 0 && (long)value <= this.maxEntryValue) {
               int blockIndex = index / this.entriesPerLong;
               int subIndex = index % this.entriesPerLong;
               int subIndexBits = subIndex * this.bitsPerEntry;
               this.data[blockIndex] = this.data[blockIndex] & ~(this.maxEntryValue << subIndexBits) | ((long)value & this.maxEntryValue) << subIndexBits;
            } else {
               throw new IllegalArgumentException("Value cannot be outside of accepted range.");
            }
         } else {
            throw new IndexOutOfBoundsException();
         }
      }
   }

   private abstract static class FlexibleStorage {
      protected final long[] data;
      protected final int bitsPerEntry;
      protected final int entries;
      protected final long maxEntryValue;

      protected FlexibleStorage(long[] data, int bitsPerEntry, int entries) {
         this.data = data;
         this.bitsPerEntry = bitsPerEntry;
         this.entries = entries;
         this.maxEntryValue = (1L << this.bitsPerEntry) - 1L;
      }

      public abstract int get(int var1);

      public abstract void set(int var1, int var2);

      static PacketChunkData.FlexibleStorage empty(PacketTypeRegistry registry, int bitsPerEntry, int entries) {
         return (PacketChunkData.FlexibleStorage)(registry.atLeast(ProtocolVersion.v1_16) ? new PacketChunkData.PaddedFlexibleStorage(bitsPerEntry, entries) : new PacketChunkData.CompactFlexibleStorage(bitsPerEntry, entries));
      }

      static PacketChunkData.FlexibleStorage from(PacketTypeRegistry registry, int bitsPerEntry, int entries, long[] data) {
         return (PacketChunkData.FlexibleStorage)(registry.atLeast(ProtocolVersion.v1_16) ? new PacketChunkData.PaddedFlexibleStorage(bitsPerEntry, entries, data) : new PacketChunkData.CompactFlexibleStorage(bitsPerEntry, entries, data));
      }
   }

   public static class PalettedStorage {
      private final PaletteType type;
      private final PacketTypeRegistry registry;
      private int countDelta;
      private int bitsPerEntry;
      private List<Integer> states;
      private PacketChunkData.FlexibleStorage storage;
      private long[] metadata;
      private long[] extended;

      private PalettedStorage(PacketChunkData.PalettedStorage from) {
         this.type = from.type;
         this.registry = from.registry;
         this.countDelta = from.countDelta;
         this.bitsPerEntry = from.bitsPerEntry;
         if (from.states != null) {
            this.states = new ArrayList(from.states);
         }

         if (from.storage != null) {
            this.storage = PacketChunkData.FlexibleStorage.from(this.registry, this.bitsPerEntry, from.storage.entries, (long[])from.storage.data.clone());
         }

         if (from.metadata != null) {
            this.metadata = (long[])from.metadata.clone();
         }

         if (from.extended != null) {
            this.extended = (long[])from.extended.clone();
         }

      }

      public PalettedStorage(PaletteType type, PacketTypeRegistry registry) {
         this.type = type;
         this.registry = registry;
         this.bitsPerEntry = type == PaletteType.BLOCKS ? 4 : 0;
         this.states = new ArrayList();
         this.states.add(0);
         this.storage = PacketChunkData.FlexibleStorage.empty(registry, this.bitsPerEntry, type.size());
      }

      PalettedStorage(PaletteType type, Packet packet) {
         this.type = type;
         this.registry = packet.getRegistry();
         this.bitsPerEntry = type.highestBitsPerValue() + 1;
      }

      PalettedStorage(PaletteType type, Packet packet, NetInput in) throws IOException {
         this.type = type;
         this.registry = packet.getRegistry();
         this.bitsPerEntry = in.readUnsignedByte();
         this.states = new ArrayList();
         int stateCount;
         if (this.bitsPerEntry > type.highestBitsPerValue() && packet.atLeast(ProtocolVersion.v1_13)) {
            stateCount = 0;
         } else if (this.bitsPerEntry == 0 && packet.atLeast(ProtocolVersion.v1_18)) {
            stateCount = 1;
         } else {
            stateCount = in.readVarInt();
         }

         for(int i = 0; i < stateCount; ++i) {
            this.states.add(in.readVarInt());
         }

         this.storage = PacketChunkData.FlexibleStorage.from(this.registry, this.bitsPerEntry, type.size(), in.readLongs(in.readVarInt()));
      }

      void write(Packet packet, NetOutput out) throws IOException {
         out.writeByte(this.bitsPerEntry);
         if (this.bitsPerEntry == 0 && packet.atLeast(ProtocolVersion.v1_18)) {
            out.writeVarInt((Integer)this.states.get(0));
         } else if (this.bitsPerEntry <= this.type.highestBitsPerValue() || !packet.atLeast(ProtocolVersion.v1_13)) {
            out.writeVarInt(this.states.size());
            Iterator var3 = this.states.iterator();

            while(var3.hasNext()) {
               Integer state = (Integer)var3.next();
               out.writeVarInt(state);
            }
         }

         out.writeVarInt(this.storage.data.length);
         out.writeLongs(this.storage.data);
      }

      private int index(int x, int y, int z) {
         return this.type == PaletteType.BIOMES ? y << 4 | z << 2 | x : y << 8 | z << 4 | x;
      }

      public int get(int x, int y, int z) {
         if (this.bitsPerEntry == 0) {
            return (Integer)this.states.get(0);
         } else {
            int id = this.storage.get(this.index(x, y, z));
            return this.bitsPerEntry <= this.type.highestBitsPerValue() ? (id >= 0 && id < this.states.size() ? (Integer)this.states.get(id) : 0) : id;
         }
      }

      public void set(int x, int y, int z, int state) {
         int id = this.bitsPerEntry <= this.type.highestBitsPerValue() ? this.states.indexOf(state) : state;
         int bitsUsed;
         if (id == -1) {
            this.states.add(state);
            if (this.states.size() > 1 << this.bitsPerEntry) {
               ++this.bitsPerEntry;
               List<Integer> oldStates = this.states;
               int i;
               if (this.bitsPerEntry > this.type.highestBitsPerValue()) {
                  new ArrayList(this.states);
                  this.states.clear();
                  if (this.registry.atLeast(ProtocolVersion.v1_16)) {
                     this.bitsPerEntry = 15;
                  } else if (this.registry.atLeast(ProtocolVersion.v1_13)) {
                     this.bitsPerEntry = 14;
                  } else {
                     this.bitsPerEntry = 13;
                  }

                  bitsUsed = (1 << this.bitsPerEntry) - 1;

                  for(i = 0; i < this.storage.entries; ++i) {
                     bitsUsed |= this.storage.get(i);
                  }

                  this.bitsPerEntry = 32 - Integer.numberOfLeadingZeros(bitsUsed);
               }

               PacketChunkData.FlexibleStorage oldStorage = this.storage;
               this.storage = PacketChunkData.FlexibleStorage.empty(this.registry, this.bitsPerEntry, this.storage.entries);

               for(i = 0; i < this.storage.entries; ++i) {
                  this.storage.set(i, oldStorage.get(i));
               }
            }

            id = this.bitsPerEntry <= this.type.highestBitsPerValue() ? this.states.indexOf(state) : state;
         }

         if (this.bitsPerEntry != 0) {
            int ind = this.index(x, y, z);
            bitsUsed = this.storage.get(ind);
            if (state != 0 && bitsUsed == 0) {
               ++this.countDelta;
            } else if (state == 0 && bitsUsed != 0) {
               --this.countDelta;
            }

            if (this.bitsPerEntry > this.type.highestBitsPerValue() && (long)id > this.storage.maxEntryValue) {
               this.bitsPerEntry = 32 - Integer.numberOfLeadingZeros(id);
               PacketChunkData.FlexibleStorage oldStorage = this.storage;
               this.storage = PacketChunkData.FlexibleStorage.empty(this.registry, this.bitsPerEntry, this.storage.entries);

               for(int i = 0; i < this.storage.entries; ++i) {
                  this.storage.set(i, oldStorage.get(i));
               }
            }

            this.storage.set(ind, id);
         }
      }

      public PacketChunkData.PalettedStorage copy() {
         return new PacketChunkData.PalettedStorage(this);
      }
   }

   public static class Chunk {
      private final int blockCount;
      public final PacketChunkData.PalettedStorage blocks;
      public final PacketChunkData.PalettedStorage biomes;
      public byte[] blockLight;
      public byte[] skyLight;

      private Chunk(PacketChunkData.Chunk from) {
         this.blockCount = from.blockCount;
         this.blocks = from.blocks != null ? from.blocks.copy() : null;
         this.biomes = from.biomes != null ? from.biomes.copy() : null;
         this.blockLight = from.blockLight != null ? (byte[])from.blockLight.clone() : null;
         this.skyLight = from.skyLight != null ? (byte[])from.skyLight.clone() : null;
      }

      public Chunk(PacketTypeRegistry registry) {
         this.blockCount = 0;
         this.blocks = new PacketChunkData.PalettedStorage(PaletteType.BLOCKS, registry);
         if (registry.atLeast(ProtocolVersion.v1_18)) {
            this.biomes = new PacketChunkData.PalettedStorage(PaletteType.BIOMES, registry);
         } else {
            this.biomes = null;
         }

      }

      Chunk(Packet packet) {
         this.blockCount = 0;
         this.blocks = new PacketChunkData.PalettedStorage(PaletteType.BLOCKS, packet);
         this.biomes = null;
      }

      Chunk(Packet packet, NetInput in) throws IOException {
         this.blockCount = packet.atLeast(ProtocolVersion.v1_14) ? in.readShort() : 0;
         this.blocks = new PacketChunkData.PalettedStorage(PaletteType.BLOCKS, packet, in);
         if (packet.atLeast(ProtocolVersion.v1_18)) {
            this.biomes = new PacketChunkData.PalettedStorage(PaletteType.BIOMES, packet, in);
         } else {
            this.biomes = null;
         }

      }

      void write(Packet packet, NetOutput out) throws IOException {
         if (packet.atLeast(ProtocolVersion.v1_14)) {
            out.writeShort(this.blockCount + this.blocks.countDelta);
         }

         this.blocks.write(packet, out);
         if (this.biomes != null) {
            this.biomes.write(packet, out);
         }

      }

      public PacketChunkData.Chunk copy() {
         return new PacketChunkData.Chunk(this);
      }
   }

   public static class Column {
      public int x;
      public int z;
      public PacketChunkData.Chunk[] chunks;
      public byte[] biomeData;
      public PacketChunkData.TileEntity[] tileEntities;
      public CompoundTag heightMaps;
      public int[] biomes;
      public boolean useExistingLightData;
      public PacketUpdateLight.Data lightData;

      public Column(int x, int z, PacketChunkData.Chunk[] chunks, byte[] biomeData, PacketChunkData.TileEntity[] tileEntities, CompoundTag heightmaps, int[] biomes, boolean useExistingLightData, PacketUpdateLight.Data lightData) {
         this.x = x;
         this.z = z;
         this.chunks = chunks;
         this.biomeData = biomeData;
         this.tileEntities = tileEntities;
         this.heightMaps = heightmaps;
         this.biomes = biomes;
         this.useExistingLightData = useExistingLightData;
         this.lightData = lightData;
      }

      public boolean isFull() {
         return this.biomeData != null || this.biomes != null || this.lightData != null && this.tileEntities != null;
      }

      public boolean looksLikeUnloadOnMC1_8() {
         return this.isFull() && Utils.containsOnlyNull(this.chunks);
      }

      public BitSet getChunkMask() {
         BitSet mask = new BitSet();

         for(int index = 0; index < this.chunks.length; ++index) {
            if (this.chunks[index] != null) {
               mask.set(index);
            }
         }

         return mask;
      }

      public boolean hasSkyLightV1_8() {
         PacketChunkData.Chunk[] var1 = this.chunks;
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            PacketChunkData.Chunk chunk = var1[var3];
            if (chunk != null && chunk.skyLight != null) {
               return true;
            }
         }

         return false;
      }

      public static long coordToLong(int x, int z) {
         return (long)x << 32 | (long)z & 4294967295L;
      }

      public static int longToX(long v) {
         return (int)(v >> 32);
      }

      public static int longToZ(long v) {
         return (int)(v & 4294967295L);
      }

      public long coordToLong() {
         return coordToLong(this.x, this.z);
      }
   }
}
