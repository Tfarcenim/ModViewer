package com.replaymod.replaystudio.lib.viaversion.api;

import com.replaymod.replaystudio.lib.viaversion.api.command.ViaVersionCommand;
import com.replaymod.replaystudio.lib.viaversion.api.connection.ConnectionManager;
import com.replaymod.replaystudio.lib.viaversion.api.debug.DebugHandler;
import com.replaymod.replaystudio.lib.viaversion.api.platform.ViaInjector;
import com.replaymod.replaystudio.lib.viaversion.api.platform.ViaPlatform;
import com.replaymod.replaystudio.lib.viaversion.api.platform.ViaPlatformLoader;
import com.replaymod.replaystudio.lib.viaversion.api.platform.providers.ViaProviders;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.ProtocolManager;
import com.replaymod.replaystudio.lib.viaversion.api.scheduler.Scheduler;
import java.util.Set;

public interface ViaManager {
   ProtocolManager getProtocolManager();

   ViaPlatform<?> getPlatform();

   ConnectionManager getConnectionManager();

   ViaProviders getProviders();

   ViaInjector getInjector();

   ViaVersionCommand getCommandHandler();

   ViaPlatformLoader getLoader();

   Scheduler getScheduler();

   default boolean isDebug() {
      return this.debugHandler().enabled();
   }

   /** @deprecated */
   @Deprecated
   default void setDebug(boolean debug) {
      this.debugHandler().setEnabled(debug);
   }

   DebugHandler debugHandler();

   Set<String> getSubPlatforms();

   void addEnableListener(Runnable var1);

   boolean isInitialized();
}
