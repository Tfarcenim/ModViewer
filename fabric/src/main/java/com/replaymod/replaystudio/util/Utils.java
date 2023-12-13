package com.replaymod.replaystudio.util;

import com.replaymod.lib.com.github.steveice10.packetlib.io.NetInput;
import com.replaymod.lib.com.github.steveice10.packetlib.io.NetOutput;
import com.replaymod.lib.com.github.steveice10.packetlib.tcp.io.ByteBufNetInput;
import com.replaymod.lib.com.github.steveice10.packetlib.tcp.io.ByteBufNetOutput;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.ReferenceCountUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class Utils {
   public static int readInt(InputStream in) throws IOException {
      int b0 = in.read();
      int b1 = in.read();
      int b2 = in.read();
      int b3 = in.read();
      return (b0 | b1 | b2 | b3) < 0 ? -1 : b0 << 24 | b1 << 16 | b2 << 8 | b3;
   }

   public static void writeInt(OutputStream out, int x) throws IOException {
      out.write(x >>> 24 & 255);
      out.write(x >>> 16 & 255);
      out.write(x >>> 8 & 255);
      out.write(x & 255);
   }

   public static boolean containsOnlyNull(Object[] array) {
      Object[] var1 = array;
      int var2 = array.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Object o = var1[var3];
         if (o != null) {
            return false;
         }
      }

      return true;
   }

   public static long within(long i, long min, long max) {
      if (i > max) {
         return max;
      } else {
         return i < min ? min : i;
      }
   }

   public static InputStream notCloseable(InputStream source) {
      return new InputStream() {
         boolean closed;

         public void close() throws IOException {
            this.closed = true;
         }

         public int read() throws IOException {
            return this.closed ? -1 : source.read();
         }

         public int read(byte[] b, int off, int len) throws IOException {
            return this.closed ? -1 : source.read(b, off, len);
         }

         public int available() throws IOException {
            return source.available();
         }

         public long skip(long n) throws IOException {
            return this.closed ? 0L : source.skip(n);
         }

         public synchronized void mark(int readlimit) {
            source.mark(readlimit);
         }

         public synchronized void reset() throws IOException {
            source.reset();
         }

         public boolean markSupported() {
            return source.markSupported();
         }

         public int read(byte[] b) throws IOException {
            return this.closed ? -1 : source.read(b);
         }
      };
   }

   public static void copy(InputStream in, OutputStream out) throws IOException {
      byte[] buffer = new byte[1024];

      int read;
      while((read = in.read(buffer)) > -1) {
         out.write(buffer, 0, read);
      }

      in.close();
   }

   public static ByteBuf readRetainedSlice(NetInput in, int len) throws IOException {
      if (in instanceof ByteBufExtNetInput) {
         ByteBuf inBuf = ((ByteBufExtNetInput)in).getBuf();
         return inBuf.readRetainedSlice(len);
      } else {
         return Unpooled.wrappedBuffer(in.readBytes(len));
      }
   }

   public static void writeBytes(NetOutput out, ByteBuf buf) throws IOException {
      if (out instanceof ByteBufExtNetOutput) {
         ByteBuf outBuf = ((ByteBufExtNetOutput)out).getBuf();
         outBuf.writeBytes(buf);
      } else {
         byte[] bytes = new byte[buf.readableBytes()];
         buf.getBytes(buf.readerIndex(), bytes);
         out.writeBytes(bytes);
      }
   }

   public static Packet readCompressedPacket(PacketTypeRegistry registry, NetInput in) throws IOException {
      ByteBuf byteBuf = null;

      Packet var14;
      try {
         int prefix = in.readVarInt();
         int len = prefix >> 1;
         int packetId;
         if ((prefix & 1) == 1) {
            packetId = in.readVarInt();
            byteBuf = Unpooled.buffer(packetId);
            Inflater inflater = new Inflater();
            inflater.setInput(in.readBytes(len));
            inflater.inflate(byteBuf.array(), byteBuf.arrayOffset(), packetId);
            byteBuf.writerIndex(packetId);
         } else {
            byteBuf = readRetainedSlice(in, len);
         }

         packetId = (new ByteBufNetInput(byteBuf)).readVarInt();
         var14 = new Packet(registry, packetId, registry.getType(packetId), byteBuf.retain());
      } catch (IOException var11) {
         throw var11;
      } catch (Exception var12) {
         throw new RuntimeException(var12);
      } finally {
         ReferenceCountUtil.release(byteBuf);
      }

      return var14;
   }

   public static void writeCompressedPacket(NetOutput out, Packet packet) throws IOException {
      ByteBuf byteBuf = Unpooled.buffer();

      try {
         (new ByteBufNetOutput(byteBuf)).writeVarInt(packet.getId());
         byteBuf.writeBytes(packet.getBuf());
         int rawIndex = byteBuf.readerIndex();
         int size = byteBuf.readableBytes();
         byteBuf.ensureWritable(size);
         Deflater deflater = new Deflater();
         deflater.setInput(byteBuf.array(), byteBuf.arrayOffset() + byteBuf.readerIndex(), size);
         deflater.finish();

         int compressedSize;
         for(compressedSize = 0; !deflater.finished() && compressedSize < size; compressedSize += deflater.deflate(byteBuf.array(), byteBuf.arrayOffset() + byteBuf.writerIndex() + compressedSize, size - compressedSize)) {
         }

         if (compressedSize < size) {
            byteBuf.readerIndex(rawIndex + size);
            byteBuf.writerIndex(rawIndex + size + compressedSize);
            out.writeVarInt(compressedSize << 1 | 1);
            out.writeVarInt(size);
         } else {
            byteBuf.readerIndex(rawIndex);
            byteBuf.writerIndex(rawIndex + size);
            out.writeVarInt(size << 1);
         }

         writeBytes(out, byteBuf);
      } catch (IOException var11) {
         throw var11;
      } catch (Exception var12) {
         throw new RuntimeException(var12);
      } finally {
         ReferenceCountUtil.release(byteBuf);
      }
   }
}
