package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9to1_8.providers;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.Position;
import com.replaymod.replaystudio.lib.viaversion.api.platform.providers.Provider;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketWrapper;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9to1_8.ClientboundPackets1_9;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9to1_8.Protocol1_9To1_8;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9to1_8.storage.CommandBlockStorage;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9to1_8.storage.EntityTracker1_9;
import io.netty.buffer.ByteBuf;
import java.util.Optional;

public class CommandBlockProvider implements Provider {
   public void addOrUpdateBlock(UserConnection user, Position position, CompoundTag tag) throws Exception {
      this.checkPermission(user);
      if (this.isEnabled()) {
         this.getStorage(user).addOrUpdateBlock(position, tag);
      }

   }

   public Optional<CompoundTag> get(UserConnection user, Position position) throws Exception {
      this.checkPermission(user);
      return this.isEnabled() ? this.getStorage(user).getCommandBlock(position) : Optional.empty();
   }

   public void unloadChunk(UserConnection user, int x, int z) throws Exception {
      this.checkPermission(user);
      if (this.isEnabled()) {
         this.getStorage(user).unloadChunk(x, z);
      }

   }

   private CommandBlockStorage getStorage(UserConnection connection) {
      return (CommandBlockStorage)connection.get(CommandBlockStorage.class);
   }

   public void sendPermission(UserConnection user) throws Exception {
      if (this.isEnabled()) {
         PacketWrapper wrapper = PacketWrapper.create(ClientboundPackets1_9.ENTITY_STATUS, (ByteBuf)null, user);
         EntityTracker1_9 tracker = (EntityTracker1_9)user.getEntityTracker(Protocol1_9To1_8.class);
         wrapper.write(Type.INT, tracker.getProvidedEntityId());
         wrapper.write(Type.BYTE, (byte)26);
         wrapper.scheduleSend(Protocol1_9To1_8.class);
         ((CommandBlockStorage)user.get(CommandBlockStorage.class)).setPermissions(true);
      }
   }

   private void checkPermission(UserConnection user) throws Exception {
      if (this.isEnabled()) {
         CommandBlockStorage storage = this.getStorage(user);
         if (!storage.isPermissions()) {
            this.sendPermission(user);
         }

      }
   }

   public boolean isEnabled() {
      return true;
   }

   public void unloadChunks(UserConnection userConnection) {
      if (this.isEnabled()) {
         this.getStorage(userConnection).unloadChunks();
      }

   }
}
