package com.replaymod.replaystudio.lib.viaversion.api.connection;

public interface StorableObject {
   default boolean clearOnServerSwitch() {
      return true;
   }
}
