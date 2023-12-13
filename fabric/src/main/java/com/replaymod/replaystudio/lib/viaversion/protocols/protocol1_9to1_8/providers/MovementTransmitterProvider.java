package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9to1_8.providers;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.platform.providers.Provider;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9to1_8.storage.MovementTracker;
import com.replaymod.replaystudio.lib.viaversion.util.PipelineUtil;
import io.netty.channel.ChannelHandlerContext;

public abstract class MovementTransmitterProvider implements Provider {
   public abstract Object getFlyingPacket();

   public abstract Object getGroundPacket();

   public void sendPlayer(UserConnection userConnection) {
      ChannelHandlerContext context = PipelineUtil.getContextBefore("decoder", userConnection.getChannel().pipeline());
      if (context != null) {
         if (((MovementTracker)userConnection.get(MovementTracker.class)).isGround()) {
            context.fireChannelRead(this.getGroundPacket());
         } else {
            context.fireChannelRead(this.getFlyingPacket());
         }

         ((MovementTracker)userConnection.get(MovementTracker.class)).incrementIdlePacket();
      }

   }
}
