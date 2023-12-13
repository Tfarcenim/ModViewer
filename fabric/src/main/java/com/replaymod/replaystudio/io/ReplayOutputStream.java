package com.replaymod.replaystudio.io;

import com.google.gson.Gson;
import com.replaymod.lib.com.github.steveice10.packetlib.tcp.io.ByteBufNetOutput;
import com.replaymod.replaystudio.PacketData;
import com.replaymod.replaystudio.Studio;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.State;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.ProtocolVersion;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketType;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import com.replaymod.replaystudio.protocol.packets.PacketLoginSuccess;
import com.replaymod.replaystudio.replay.ReplayMetaData;
import com.replaymod.replaystudio.studio.ReplayStudio;
import com.replaymod.replaystudio.util.Utils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocator;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ReplayOutputStream extends OutputStream {
   private static final Gson GSON = new Gson();
   private static final ByteBufAllocator ALLOC;
   private final ReplayMetaData metaData;
   private final OutputStream out;
   private final ZipOutputStream zipOut;
   private int duration;
   private boolean loginPhase = true;

   public ReplayOutputStream(OutputStream out) {
      this.out = out;
      this.zipOut = null;
      this.metaData = null;
   }

   public ReplayOutputStream(ProtocolVersion version, OutputStream out, ReplayMetaData metaData) throws IOException {
      Studio studio = new ReplayStudio();
      if (metaData == null) {
         metaData = new ReplayMetaData();
         metaData.setSingleplayer(false);
         metaData.setServerName(studio.getName() + " v" + studio.getVersion());
         metaData.setDate(System.currentTimeMillis());
      }

      metaData.setFileFormat("MCPR");
      metaData.setFileFormatVersion(14);
      metaData.setProtocolVersion(version.getOriginalVersion());
      metaData.setGenerator("ReplayStudio v" + studio.getVersion());
      this.metaData = metaData;
      this.out = this.zipOut = new ZipOutputStream(out);
      this.zipOut.putNextEntry(new ZipEntry("recording.tmcpr"));
   }

   public void write(int b) throws IOException {
      this.out.write(b);
   }

   public void write(PacketData data) throws IOException {
      this.write(data.getTime(), data.getPacket());
   }

   public void write(long time, Packet packet) throws IOException {
      if (packet.getRegistry().getState() != State.LOGIN && this.loginPhase) {
         PacketTypeRegistry registry = PacketTypeRegistry.get(packet.getProtocolVersion(), State.LOGIN);
         this.doWrite(0L, (new PacketLoginSuccess(UUID.nameUUIDFromBytes(new byte[0]), "Player", Collections.emptyList())).write(registry));
      }

      this.doWrite(time, packet);
   }

   private void doWrite(long time, Packet packet) throws IOException {
      if ((long)this.duration < time) {
         this.duration = (int)time;
      }

      ByteBuf packetIdBuf = ALLOC.buffer();

      try {
         (new ByteBufNetOutput(packetIdBuf)).writeVarInt(packet.getId());
         int packetIdLen = packetIdBuf.readableBytes();
         int packetBufLen = packet.getBuf().readableBytes();
         Utils.writeInt(this.out, (int)time);
         Utils.writeInt(this.out, packetIdLen + packetBufLen);
         packetIdBuf.readBytes(this.out, packetIdLen);
         packet.getBuf().getBytes(packet.getBuf().readerIndex(), this.out, packetBufLen);
      } finally {
         packetIdBuf.release();
         packet.getBuf().release();
      }

      if (packet.getType() == PacketType.LoginSuccess) {
         this.loginPhase = false;
      }

   }

   public void nextEntry(String name) throws IOException {
      if (this.zipOut != null) {
         this.zipOut.closeEntry();
         this.zipOut.putNextEntry(new ZipEntry(name));
      } else {
         throw new UnsupportedOperationException("Cannot start new entry when writing raw replay output.");
      }
   }

   public void close() throws IOException {
      if (this.zipOut != null) {
         this.zipOut.closeEntry();
         this.metaData.setDuration(this.duration);
         this.zipOut.putNextEntry(new ZipEntry("metaData.json"));
         this.zipOut.write(GSON.toJson(this.metaData).getBytes());
         this.zipOut.closeEntry();
      }

      this.out.close();
   }

   static {
      ALLOC = PooledByteBufAllocator.DEFAULT;
   }
}
