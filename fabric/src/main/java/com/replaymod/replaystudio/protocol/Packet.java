package com.replaymod.replaystudio.protocol;

import com.replaymod.lib.com.github.steveice10.opennbt.NBTIO;
import com.replaymod.lib.com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.replaymod.lib.com.github.steveice10.packetlib.io.NetInput;
import com.replaymod.lib.com.github.steveice10.packetlib.io.NetOutput;
import com.replaymod.lib.com.github.steveice10.packetlib.tcp.io.ByteBufNetInput;
import com.replaymod.lib.com.github.steveice10.packetlib.tcp.io.ByteBufNetOutput;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.ProtocolVersion;
import com.replaymod.replaystudio.util.IGlobalPosition;
import com.replaymod.replaystudio.util.IOConsumer;
import com.replaymod.replaystudio.util.IOSupplier;
import com.replaymod.replaystudio.util.IPosition;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Packet {
   private final PacketTypeRegistry registry;
   private final int id;
   private final PacketType type;
   private final ByteBuf buf;

   public Packet(PacketTypeRegistry registry, PacketType type) {
      this(registry, type, Unpooled.buffer());
   }

   public Packet(PacketTypeRegistry registry, PacketType type, ByteBuf buf) {
      this(registry, registry.getId(type), type, buf);
   }

   public Packet(PacketTypeRegistry registry, int packetId, ByteBuf buf) {
      this(registry, packetId, registry.getType(packetId), buf);
   }

   public Packet(PacketTypeRegistry registry, int id, PacketType type, ByteBuf buf) {
      this.registry = registry;
      this.id = id;
      this.type = type;
      this.buf = buf;
   }

   public PacketTypeRegistry getRegistry() {
      return this.registry;
   }

   public ProtocolVersion getProtocolVersion() {
      return this.registry.getVersion();
   }

   public int getId() {
      return this.id;
   }

   public PacketType getType() {
      return this.type;
   }

   public ByteBuf getBuf() {
      return this.buf;
   }

   public Packet retain() {
      this.buf.retain();
      return this;
   }

   public Packet copy() {
      return new Packet(this.registry, this.id, this.type, this.buf.retainedSlice());
   }

   public boolean release() {
      return this.buf.release();
   }

   public Packet.Reader reader() {
      return new Packet.Reader(this, this.buf);
   }

   public Packet.Writer overwrite() {
      this.buf.writerIndex(this.buf.readerIndex());
      return new Packet.Writer(this, this.buf);
   }

   public boolean atLeast(ProtocolVersion protocolVersion) {
      return this.registry.atLeast(protocolVersion);
   }

   public boolean atMost(ProtocolVersion protocolVersion) {
      return this.registry.atMost(protocolVersion);
   }

   public boolean olderThan(ProtocolVersion protocolVersion) {
      return this.registry.olderThan(protocolVersion);
   }

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         Packet packet = (Packet)o;
         return this.id == packet.id && this.registry.equals(packet.registry) && this.buf.equals(packet.buf);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.registry, this.id, this.buf});
   }

   public static class Writer extends ByteBufNetOutput implements AutoCloseable {
      private final Packet packet;

      private Writer(Packet packet, ByteBuf buf) {
         super(buf);
         this.packet = packet;
      }

      public void close() {
      }

      public void writePosition(IPosition pos) throws IOException {
         writePosition(this.packet.registry, this, pos);
      }

      public static void writePosition(PacketTypeRegistry registry, NetOutput out, IPosition pos) throws IOException {
         long x = (long)(pos.getX() & 67108863);
         long y = (long)(pos.getY() & 4095);
         long z = (long)(pos.getZ() & 67108863);
         if (registry.atLeast(ProtocolVersion.v1_14)) {
            out.writeLong(x << 38 | z << 12 | y);
         } else {
            out.writeLong(x << 38 | y << 26 | z);
         }

      }

      public void writeGlobalPosition(IGlobalPosition pos) throws IOException {
         writeGlobalPosition(this.packet.registry, this, pos);
      }

      public static void writeGlobalPosition(PacketTypeRegistry registry, NetOutput out, IGlobalPosition pos) throws IOException {
         out.writeString(pos.getDimension());
         writePosition(registry, out, pos.getPosition());
      }

      public void writeNBT(CompoundTag tag) throws IOException {
         writeNBT(this.packet.registry, this, tag);
      }

      public static void writeNBT(PacketTypeRegistry registry, NetOutput out, CompoundTag tag) throws IOException {
         if (registry.atLeast(ProtocolVersion.v1_8)) {
            if (tag == null) {
               out.writeByte(0);
            } else {
               NBTIO.writeTag(new OutputStream() {
                  public void write(int i) throws IOException {
                     out.writeByte(i);
                  }
               }, tag);
            }
         } else {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            GZIPOutputStream gzip = new GZIPOutputStream(output);
            NBTIO.writeTag((OutputStream)gzip, tag);
            gzip.close();
            output.close();
            byte[] bytes = output.toByteArray();
            out.writeShort(bytes.length);
            out.writeBytes(bytes);
         }

      }

      public void writeBitSet(BitSet bitSet) throws IOException {
         writeBitSet(this.packet.registry, this, bitSet);
      }

      public static void writeBitSet(PacketTypeRegistry registry, NetOutput out, BitSet bitSet) throws IOException {
         long[] longs;
         if (registry.atLeast(ProtocolVersion.v1_17)) {
            longs = bitSet.toLongArray();
            out.writeVarInt(longs.length);
            out.writeLongs(longs);
         } else {
            longs = bitSet.toLongArray();
            long value;
            if (longs.length == 0) {
               value = 0L;
            } else {
               if (longs.length != 1) {
                  throw new IllegalArgumentException("Pre-1.17 bitset cannot encode more than 64 bits.");
               }

               value = longs[0];
            }

            if (registry.atLeast(ProtocolVersion.v1_9)) {
               out.writeVarInt((int)value);
            } else {
               out.writeShort((int)value);
            }
         }

      }

      public <T> void writeList(List<T> list, IOConsumer<T> entryWriter) throws IOException {
         writeList(this.packet.registry, this, list, entryWriter);
      }

      public static <T> void writeList(PacketTypeRegistry registry, NetOutput out, List<T> list, IOConsumer<T> entryWriter) throws IOException {
         out.writeVarInt(list.size());
         Iterator var4 = list.iterator();

         while(var4.hasNext()) {
            T entry = var4.next();
            entryWriter.consume(entry);
         }

      }

      // $FF: synthetic method
      Writer(Packet x0, ByteBuf x1, Object x2) {
         this(x0, x1);
      }
   }

   public static class Reader extends ByteBufNetInput implements AutoCloseable {
      private final Packet packet;
      private final ByteBuf buf;
      private int orgReaderIndex;

      Reader(Packet packet, ByteBuf buf) {
         super(buf);
         this.packet = packet;
         this.buf = buf;
         this.orgReaderIndex = buf.readerIndex();
      }

      public void close() {
         this.buf.readerIndex(this.orgReaderIndex);
      }

      public IPosition readPosition() throws IOException {
         return readPosition(this.packet.registry, this);
      }

      public static IPosition readPosition(PacketTypeRegistry registry, NetInput in) throws IOException {
         long val = in.readLong();
         long x;
         long y;
         long z;
         if (registry.atLeast(ProtocolVersion.v1_14)) {
            x = val >> 38;
            y = val;
            z = val >> 12;
         } else {
            x = val >> 38;
            y = val >> 26;
            z = val;
         }

         return new IPosition((int)(x << 38 >> 38), (int)(y << 52 >> 52), (int)(z << 38 >> 38));
      }

      public IGlobalPosition readGlobalPosition() throws IOException {
         return readGlobalPosition(this.packet.registry, this);
      }

      public static IGlobalPosition readGlobalPosition(PacketTypeRegistry registry, NetInput in) throws IOException {
         String dimension = in.readString();
         return new IGlobalPosition(dimension, readPosition(registry, in));
      }

      public CompoundTag readNBT() throws IOException {
         return readNBT(this.packet.registry, this);
      }

      public static CompoundTag readNBT(PacketTypeRegistry registry, NetInput in) throws IOException {
         if (registry.atLeast(ProtocolVersion.v1_8)) {
            final byte b = in.readByte();
            return b == 0 ? null : NBTIO.readTag(new InputStream() {
               private boolean first = true;

               public int read() throws IOException {
                  if (this.first) {
                     this.first = false;
                     return b;
                  } else {
                     return in.readUnsignedByte();
                  }
               }
            });
         } else {
            short length = in.readShort();
            return length < 0 ? null : NBTIO.readTag((InputStream)(new GZIPInputStream(new ByteArrayInputStream(in.readBytes(length)))));
         }
      }

      public BitSet readBitSet() throws IOException {
         return readBitSet(this.packet.registry, this);
      }

      public static BitSet readBitSet(PacketTypeRegistry registry, NetInput in) throws IOException {
         if (registry.atLeast(ProtocolVersion.v1_17)) {
            return BitSet.valueOf(in.readLongs(in.readVarInt()));
         } else if (registry.atLeast(ProtocolVersion.v1_9)) {
            int value = in.readVarInt();
            value &= Integer.MAX_VALUE;
            return BitSet.valueOf(new long[]{(long)value});
         } else {
            return BitSet.valueOf(new long[]{(long)in.readUnsignedShort()});
         }
      }

      public <T> List<T> readList(IOSupplier<T> entryReader) throws IOException {
         return readList(this.packet.registry, this, entryReader);
      }

      public static <T> List<T> readList(PacketTypeRegistry registry, NetInput in, IOSupplier<T> entryReader) throws IOException {
         int len = in.readVarInt();
         List<T> result = new ArrayList(len);

         for(int i = 0; i < len; ++i) {
            result.add(entryReader.get());
         }

         return result;
      }
   }
}
