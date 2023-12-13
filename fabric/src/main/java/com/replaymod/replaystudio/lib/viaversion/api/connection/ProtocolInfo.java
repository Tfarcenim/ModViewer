package com.replaymod.replaystudio.lib.viaversion.api.connection;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.ProtocolPipeline;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.State;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface ProtocolInfo {
   State getState();

   void setState(State var1);

   int getProtocolVersion();

   void setProtocolVersion(int var1);

   int getServerProtocolVersion();

   void setServerProtocolVersion(int var1);

   @Nullable
   String getUsername();

   void setUsername(String var1);

   @Nullable
   UUID getUuid();

   void setUuid(UUID var1);

   ProtocolPipeline getPipeline();

   void setPipeline(ProtocolPipeline var1);

   /** @deprecated */
   @Deprecated
   UserConnection getUser();
}
