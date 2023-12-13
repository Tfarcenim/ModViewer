package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9to1_8.storage;

import com.replaymod.replaystudio.lib.guava.collect.Sets;
import com.replaymod.replaystudio.lib.viaversion.api.connection.StoredObject;
import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import java.util.Set;

public class ClientChunks extends StoredObject {
   private final Set<Long> loadedChunks = Sets.newConcurrentHashSet();

   public ClientChunks(UserConnection connection) {
      super(connection);
   }

   public static long toLong(int msw, int lsw) {
      return ((long)msw << 32) + (long)lsw + 2147483648L;
   }

   public Set<Long> getLoadedChunks() {
      return this.loadedChunks;
   }
}
