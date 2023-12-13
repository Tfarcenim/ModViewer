package com.replaymod.replaystudio.io;

import com.replaymod.lib.com.github.steveice10.packetlib.tcp.io.ByteBufNetInput;
import com.replaymod.replaystudio.PacketData;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.State;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketType;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import com.replaymod.replaystudio.protocol.packets.PacketJoinGame;
import com.replaymod.replaystudio.protocol.packets.PacketLoginSuccess;
import com.replaymod.replaystudio.replay.ReplayMetaData;
import com.replaymod.replaystudio.stream.PacketStream;
import com.replaymod.replaystudio.studio.StudioPacketStream;
import com.replaymod.replaystudio.util.Utils;
import com.replaymod.replaystudio.viaversion.ViaVersionPacketConverter;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocator;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

public class ReplayInputStream extends InputStream {
   private static final ByteBufAllocator ALLOC;
   private PacketTypeRegistry rawRegistry;
   private PacketTypeRegistry registry;
   private final InputStream in;
   private ViaVersionPacketConverter viaVersionConverter;
   private boolean loginPhase;
   private boolean outputLoginPhase;
   private Queue<PacketData> buffer = new ArrayDeque();

   public ReplayInputStream(PacketTypeRegistry registry, InputStream in, int fileFormatVersion, int fileProtocol) throws IOException {
      boolean includeLoginPhase = fileFormatVersion >= 14;
      this.registry = registry;
      this.loginPhase = includeLoginPhase;
      this.outputLoginPhase = registry.getState() == State.LOGIN;
      if (!includeLoginPhase && this.outputLoginPhase) {
         this.buffer.offer(new PacketData(0L, (new PacketLoginSuccess(UUID.nameUUIDFromBytes(new byte[0]), "Player", Collections.emptyList())).write(registry)));
         this.registry = PacketTypeRegistry.get(registry.getVersion(), State.PLAY);
      } else if (includeLoginPhase && !this.outputLoginPhase) {
         this.registry = PacketTypeRegistry.get(registry.getVersion(), State.LOGIN);
      }

      this.in = in;
      this.viaVersionConverter = ViaVersionPacketConverter.createForFileVersion(fileFormatVersion, fileProtocol, registry.getVersion().getOriginalVersion());
      this.rawRegistry = PacketTypeRegistry.get(ReplayMetaData.getProtocolVersion(fileFormatVersion, fileProtocol), this.registry.getState());
   }

   public int read() throws IOException {
      return this.in.read();
   }

   public void close() throws IOException {
      this.in.close();
   }

   public PacketTypeRegistry getRegistry() {
      return this.registry;
   }

   public PacketData readPacket() throws IOException {
      this.fillBuffer();
      return (PacketData)this.buffer.poll();
   }

   private void fillBuffer() throws IOException {
      label239:
      while(true) {
         if (this.buffer.isEmpty()) {
            int next = Utils.readInt(this.in);
            int length = Utils.readInt(this.in);
            if (next != -1 && length != -1) {
               if (length == 0) {
                  continue;
               }

               ByteBuf buf;
               int read;
               for(buf = ALLOC.buffer(length); length > 0; length -= read) {
                  read = buf.writeBytes(this.in, length);
                  if (read == -1) {
                     throw new EOFException();
                  }
               }

               read = (new ByteBufNetInput(buf)).readVarInt();
               Packet rawPacket = new Packet(this.rawRegistry, read, buf);
               if (rawPacket.getType() == PacketType.JoinGame) {
                  PacketJoinGame joinGame = PacketJoinGame.read(rawPacket);
                  joinGame.entityId = -1789435;
                  joinGame.gameMode = 3;
                  Packet.Writer writer = rawPacket.overwrite();
                  Throwable var8 = null;

                  try {
                     joinGame.write(rawPacket, writer);
                  } catch (Throwable var18) {
                     var8 = var18;
                     throw var18;
                  } finally {
                     if (writer != null) {
                        if (var8 != null) {
                           try {
                              writer.close();
                           } catch (Throwable var17) {
                              var8.addSuppressed(var17);
                           }
                        } else {
                           writer.close();
                        }
                     }

                  }
               } else if (rawPacket.getType() == PacketType.LoginSuccess) {
                  this.rawRegistry = PacketTypeRegistry.get(this.rawRegistry.getVersion(), State.PLAY);
               }

               buf.resetReaderIndex();
               LinkedList decoded = new LinkedList();

               Iterator var22;
               try {
                  var22 = this.viaVersionConverter.convertPacket(buf, this.loginPhase ? State.LOGIN : State.PLAY).iterator();

                  while(var22.hasNext()) {
                     ByteBuf packet = (ByteBuf)var22.next();
                     int packetId = (new ByteBufNetInput(packet)).readVarInt();
                     decoded.add(new Packet(this.registry, packetId, this.registry.getType(packetId), packet));
                  }
               } catch (Exception var20) {
                  throw var20 instanceof IOException ? (IOException)var20 : new IOException("decoding", var20);
               }

               buf.release();
               var22 = decoded.iterator();

               while(true) {
                  while(true) {
                     if (!var22.hasNext()) {
                        continue label239;
                     }

                     Packet packet = (Packet)var22.next();
                     PacketType type = packet.getType();
                     if (type == PacketType.KeepAlive) {
                        packet.release();
                     } else {
                        if (type == PacketType.LoginSuccess) {
                           this.loginPhase = false;
                           this.registry = PacketTypeRegistry.get(this.registry.getVersion(), State.PLAY);
                        }

                        if ((this.loginPhase || type == PacketType.LoginSuccess) && !this.outputLoginPhase) {
                           packet.release();
                        } else {
                           this.buffer.offer(new PacketData((long)next, packet));
                        }
                     }
                  }
               }
            }
         }

         return;
      }
   }

   public PacketStream asPacketStream() {
      return new StudioPacketStream(this);
   }

   static {
      ALLOC = PooledByteBufAllocator.DEFAULT;
   }
}
