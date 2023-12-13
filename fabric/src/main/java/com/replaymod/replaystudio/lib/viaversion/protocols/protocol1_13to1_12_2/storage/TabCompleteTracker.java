package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.storage;

import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.connection.StorableObject;
import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.Position;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketWrapper;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_12_1to1_12.ServerboundPackets1_12_1;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.Protocol1_13To1_12_2;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.providers.PlayerLookTargetProvider;
import io.netty.buffer.ByteBuf;

public class TabCompleteTracker implements StorableObject {
   private int transactionId;
   private String input;
   private String lastTabComplete;
   private long timeToSend;

   public void sendPacketToServer(UserConnection connection) {
      if (this.lastTabComplete != null && this.timeToSend <= System.currentTimeMillis()) {
         PacketWrapper wrapper = PacketWrapper.create(ServerboundPackets1_12_1.TAB_COMPLETE, (ByteBuf)null, connection);
         wrapper.write(Type.STRING, this.lastTabComplete);
         wrapper.write(Type.BOOLEAN, false);
         Position playerLookTarget = ((PlayerLookTargetProvider)Via.getManager().getProviders().get(PlayerLookTargetProvider.class)).getPlayerLookTarget(connection);
         wrapper.write(Type.OPTIONAL_POSITION, playerLookTarget);

         try {
            wrapper.scheduleSendToServer(Protocol1_13To1_12_2.class);
         } catch (Exception var5) {
            var5.printStackTrace();
         }

         this.lastTabComplete = null;
      }
   }

   public int getTransactionId() {
      return this.transactionId;
   }

   public void setTransactionId(int transactionId) {
      this.transactionId = transactionId;
   }

   public String getInput() {
      return this.input;
   }

   public void setInput(String input) {
      this.input = input;
   }

   public String getLastTabComplete() {
      return this.lastTabComplete;
   }

   public void setLastTabComplete(String lastTabComplete) {
      this.lastTabComplete = lastTabComplete;
   }

   public long getTimeToSend() {
      return this.timeToSend;
   }

   public void setTimeToSend(long timeToSend) {
      this.timeToSend = timeToSend;
   }
}
