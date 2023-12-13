package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_3to1_9_1_2.storage;

import com.replaymod.replaystudio.lib.viaversion.api.connection.StoredObject;
import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.Environment;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ClientWorld extends StoredObject {
   private Environment environment;

   public ClientWorld(UserConnection connection) {
      super(connection);
   }

   @Nullable
   public Environment getEnvironment() {
      return this.environment;
   }

   public void setEnvironment(int environmentId) {
      this.environment = Environment.getEnvironmentById(environmentId);
   }
}
