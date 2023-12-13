package com.replaymod.replaystudio.viaversion;

import com.replaymod.lib.com.github.steveice10.packetlib.tcp.io.ByteBufNetInput;
import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.connection.ProtocolInfo;
import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.ProtocolPathEntry;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.ProtocolPipeline;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.Direction;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketWrapper;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.State;
import com.replaymod.replaystudio.lib.viaversion.connection.UserConnectionImpl;
import com.replaymod.replaystudio.lib.viaversion.exception.CancelException;
import com.replaymod.replaystudio.lib.viaversion.protocol.ProtocolPipelineImpl;
import com.replaymod.replaystudio.replay.ReplayMetaData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.embedded.EmbeddedChannel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class ViaVersionPacketConverter {
   private final UserConnection user;
   private final CustomViaAPI viaAPI;
   private final ProtocolPipeline pipeline;
   private List<ByteBuf> out = new ArrayList();

   /** @deprecated */
   @Deprecated
   public static ViaVersionPacketConverter createForFileVersion(int input, int output) {
      return createForFileVersion(input, 0, (Integer)ReplayMetaData.PROTOCOL_FOR_FILE_FORMAT.get(output));
   }

   public static ViaVersionPacketConverter createForFileVersion(int fileVersion, int fileProtocol, int outputProtocol) {
      if (!ReplayMetaData.PROTOCOL_FOR_FILE_FORMAT.containsKey(fileVersion) && fileVersion < 10) {
         throw new IllegalArgumentException("Unknown file version");
      } else {
         return createForProtocolVersion(fileVersion < 10 ? (Integer)ReplayMetaData.PROTOCOL_FOR_FILE_FORMAT.get(fileVersion) : fileProtocol, outputProtocol);
      }
   }

   public static ViaVersionPacketConverter createForProtocolVersion(int input, int output) {
      return new ViaVersionPacketConverter(input, output);
   }

   /** @deprecated */
   @Deprecated
   public static boolean isFileVersionSupported(int input, int output) {
      return ReplayMetaData.PROTOCOL_FOR_FILE_FORMAT.containsKey(input) && ReplayMetaData.PROTOCOL_FOR_FILE_FORMAT.containsKey(output) && isProtocolVersionSupported((Integer)ReplayMetaData.PROTOCOL_FOR_FILE_FORMAT.get(input), (Integer)ReplayMetaData.PROTOCOL_FOR_FILE_FORMAT.get(output));
   }

   public static boolean isFileVersionSupported(int fileVersion, int fileProtocol, int outputProtocol) {
      if (fileVersion < 10) {
         if (!ReplayMetaData.PROTOCOL_FOR_FILE_FORMAT.containsKey(fileVersion)) {
            return false;
         }

         fileProtocol = (Integer)ReplayMetaData.PROTOCOL_FOR_FILE_FORMAT.get(fileVersion);
      }

      return isProtocolVersionSupported(fileProtocol, outputProtocol);
   }

   public static boolean isProtocolVersionSupported(int input, int output) {
      if (input == output) {
         return true;
      } else {
         CustomViaManager.initialize();
         return Via.getManager().getProtocolManager().getProtocolPath(output, input) != null;
      }
   }

   private ViaVersionPacketConverter(int inputProtocol, int outputProtocol) {
      CustomViaManager.initialize();
      List<ProtocolPathEntry> path = Via.getManager().getProtocolManager().getProtocolPath(outputProtocol, inputProtocol);
      if (path != null) {
         this.user = new ViaVersionPacketConverter.DummyUserConnection();
         this.viaAPI = new CustomViaAPI(inputProtocol, this.user);
         this.pipeline = new ProtocolPipelineImpl(this.user);
         ProtocolInfo protocolInfo = this.user.getProtocolInfo();
         protocolInfo.setState(State.PLAY);
         protocolInfo.setUsername("$Camera$");
         protocolInfo.setUuid(UUID.randomUUID());
         Stream var10000 = path.stream().map(ProtocolPathEntry::getProtocol);
         ProtocolPipeline var10001 = this.pipeline;
         var10000.forEachOrdered(var10001::add);
      } else {
         this.user = null;
         this.viaAPI = null;
         this.pipeline = null;
      }

   }

   /** @deprecated */
   @Deprecated
   public List<ByteBuf> convertPacket(ByteBuf buf) throws IOException {
      return this.convertPacket(buf, State.PLAY);
   }

   public List<ByteBuf> convertPacket(ByteBuf buf, State state) throws IOException {
      if (this.user == null) {
         buf.retain();
         return Collections.singletonList(buf);
      } else {
         CustomViaAPI.INSTANCE.set(this.viaAPI);

         List var6;
         try {
            int packetId = (new ByteBufNetInput(buf)).readVarInt();
            PacketWrapper packetWrapper = PacketWrapper.create(packetId, buf, this.user);

            try {
               this.pipeline.transform(Direction.CLIENTBOUND, state, packetWrapper);
            } catch (CancelException var12) {
               if (!this.out.isEmpty()) {
                  var6 = this.popOut();
                  return var6;
               }

               var6 = Collections.emptyList();
               return var6;
            }

            ByteBuf result = buf.alloc().buffer();
            packetWrapper.writeToBuffer(result);
            if (!this.out.isEmpty()) {
               this.out.add(0, result);
               var6 = this.popOut();
               return var6;
            }

            var6 = Collections.singletonList(result);
         } catch (IOException var13) {
            throw var13;
         } catch (Exception var14) {
            throw new IOException("Exception during ViaVersion conversion:", var14);
         } finally {
            CustomViaAPI.INSTANCE.remove();
         }

         return var6;
      }
   }

   private List<ByteBuf> popOut() {
      List var1;
      try {
         var1 = this.out;
      } finally {
         this.out = new ArrayList();
      }

      return var1;
   }

   private final class DummyUserConnection extends UserConnectionImpl {
      DummyUserConnection() {
         super(new EmbeddedChannel());
      }

      public void sendRawPacket(ByteBuf packet) {
         ViaVersionPacketConverter.this.out.add(packet);
      }

      public void scheduleSendRawPacket(ByteBuf packet) {
         ViaVersionPacketConverter.this.out.add(packet);
      }

      public ChannelFuture sendRawPacketFuture(ByteBuf packet) {
         throw new UnsupportedOperationException();
      }
   }
}
