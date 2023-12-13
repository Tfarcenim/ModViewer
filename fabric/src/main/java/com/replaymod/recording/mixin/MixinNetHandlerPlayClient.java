package com.replaymod.recording.mixin;

import com.replaymod.core.versions.MCVer;
import com.replaymod.recording.handler.RecordingEventHandler;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketType;
import com.replaymod.replaystudio.protocol.packets.PacketPlayerListEntry;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket;
import net.minecraft.network.protocol.game.ClientboundRespawnPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket.Action;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({ClientPacketListener.class})
public abstract class MixinNetHandlerPlayClient {
   private static Minecraft mcStatic = MCVer.getMinecraft();
   @Shadow
   private Map<UUID, PlayerInfo> field_3693;

   public RecordingEventHandler getRecordingEventHandler() {
      return ((RecordingEventHandler.RecordingEventSender)mcStatic.levelRenderer).getRecordingEventHandler();
   }

   @Inject(
      method = {"onPlayerList"},
      at = {@At("HEAD")}
   )
   public void recordOwnJoin(ClientboundPlayerInfoUpdatePacket packet, CallbackInfo ci) {
      if (mcStatic.isSameThread()) {
         if (mcStatic.player != null) {
            RecordingEventHandler handler = this.getRecordingEventHandler();
            if (handler != null && packet.actions().contains(Action.ADD_PLAYER)) {
               ByteBuf byteBuf = Unpooled.buffer();

               try {
                  packet.write(new FriendlyByteBuf(byteBuf));
                  byteBuf.readerIndex(0);
                  byte[] array = new byte[byteBuf.readableBytes()];
                  byteBuf.readBytes(array);
                  Iterator var6 = PacketPlayerListEntry.read(new Packet(MCVer.getPacketTypeRegistry(false), 0, PacketType.PlayerListEntry, Unpooled.wrappedBuffer(array))).iterator();

                  while(var6.hasNext()) {
                     PacketPlayerListEntry data = (PacketPlayerListEntry)var6.next();
                     if (data.getUuid() != null && data.getUuid().equals(mcStatic.player.getGameProfile().getId()) && !this.field_3693.containsKey(data.getUuid())) {
                        handler.spawnRecordingPlayer();
                     }
                  }
               } catch (IOException var11) {
                  throw new RuntimeException(var11);
               } finally {
                  byteBuf.release();
               }
            }

         }
      }
   }

   @Inject(
      method = {"onPlayerRespawn"},
      at = {@At("RETURN")}
   )
   public void recordOwnRespawn(ClientboundRespawnPacket packet, CallbackInfo ci) {
      RecordingEventHandler handler = this.getRecordingEventHandler();
      if (handler != null) {
         handler.spawnRecordingPlayer();
      }

   }
}
