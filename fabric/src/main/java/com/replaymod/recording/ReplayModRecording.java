package com.replaymod.recording;

import com.replaymod.core.KeyBindingRegistry;
import com.replaymod.core.Module;
import com.replaymod.core.ReplayMod;
import com.replaymod.core.utils.Restrictions;
import com.replaymod.recording.handler.ConnectionEventHandler;
import com.replaymod.recording.handler.GuiHandler;
import com.replaymod.recording.mixin.NetworkManagerAccessor;
import com.replaymod.recording.packet.PacketListener;
import io.netty.channel.Channel;
import io.netty.util.AttributeKey;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.Connection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReplayModRecording implements Module {
   private static final Logger LOGGER = LogManager.getLogger();
   private static final AttributeKey<Void> ATTR_CHECKED = AttributeKey.newInstance("ReplayModRecording_checked");
   public static ReplayModRecording instance;
   private ReplayMod core;
   private ConnectionEventHandler connectionEventHandler;

   public ReplayModRecording(ReplayMod mod) {
      instance = this;
      this.core = mod;
      this.core.getSettingsRegistry().register(Setting.class);
   }

   public void registerKeyBindings(KeyBindingRegistry registry) {
      registry.registerKeyBinding("replaymod.input.marker", 77, new Runnable() {
         public void run() {
            PacketListener packetListener = ReplayModRecording.this.connectionEventHandler.getPacketListener();
            if (packetListener != null) {
               packetListener.addMarker((String)null);
               ReplayModRecording.this.core.printInfoToChat("replaymod.chat.addedmarker");
            }

         }
      }, false);
   }

   public void initClient() {
      this.connectionEventHandler = new ConnectionEventHandler(LOGGER, this.core);
      (new GuiHandler(this.core)).register();
      ClientPlayNetworking.registerGlobalReceiver(Restrictions.PLUGIN_CHANNEL, (client, handler, buf, resp) -> {
      });
   }

   public void initiateRecording(Connection networkManager) {
      Channel channel = ((NetworkManagerAccessor)networkManager).getChannel();
      if (channel.pipeline().get("ReplayModReplay_replaySender") == null) {
         if (!channel.hasAttr(ATTR_CHECKED)) {
            channel.attr(ATTR_CHECKED).set((Object)null);
            this.connectionEventHandler.onConnectedToServerEvent(networkManager);
         }
      }
   }

   public ConnectionEventHandler getConnectionEventHandler() {
      return this.connectionEventHandler;
   }
}
