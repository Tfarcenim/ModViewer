package com.replaymod.replaystudio.viaversion;

import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.ViaManager;
import com.replaymod.replaystudio.lib.viaversion.api.command.ViaVersionCommand;
import com.replaymod.replaystudio.lib.viaversion.api.connection.ConnectionManager;
import com.replaymod.replaystudio.lib.viaversion.api.debug.DebugHandler;
import com.replaymod.replaystudio.lib.viaversion.api.platform.ViaInjector;
import com.replaymod.replaystudio.lib.viaversion.api.platform.ViaPlatform;
import com.replaymod.replaystudio.lib.viaversion.api.platform.ViaPlatformLoader;
import com.replaymod.replaystudio.lib.viaversion.api.platform.providers.ViaProviders;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.ProtocolManager;
import com.replaymod.replaystudio.lib.viaversion.api.scheduler.Scheduler;
import com.replaymod.replaystudio.lib.viaversion.debug.DebugHandlerImpl;
import com.replaymod.replaystudio.lib.viaversion.protocol.ProtocolManagerImpl;
import java.util.HashSet;
import java.util.Set;

public class CustomViaManager implements ViaManager {
   private final ProtocolManagerImpl protocolManager = new ProtocolManagerImpl();
   private final ConnectionManager connectionManager = new CustomConnectionManager();
   private final ViaProviders providers = new ViaProviders();
   private final ViaPlatform<?> platform = new CustomViaPlatform();
   private final ViaInjector injector = new CustomViaInjector();
   private final Set<String> subPlatforms = new HashSet();
   private final DebugHandler debugHandler = new DebugHandlerImpl();
   private boolean initialized;

   public static synchronized void initialize() {
   }

   private CustomViaManager() {
   }

   public ProtocolManager getProtocolManager() {
      return this.protocolManager;
   }

   public ViaPlatform<?> getPlatform() {
      return this.platform;
   }

   public ConnectionManager getConnectionManager() {
      return this.connectionManager;
   }

   public ViaProviders getProviders() {
      return this.providers;
   }

   public ViaInjector getInjector() {
      return this.injector;
   }

   public ViaVersionCommand getCommandHandler() {
      throw new UnsupportedOperationException();
   }

   public ViaPlatformLoader getLoader() {
      throw new UnsupportedOperationException();
   }

   public Scheduler getScheduler() {
      return null;
   }

   public DebugHandler debugHandler() {
      return this.debugHandler;
   }

   public Set<String> getSubPlatforms() {
      return this.subPlatforms;
   }

   public void addEnableListener(Runnable runnable) {
      throw new UnsupportedOperationException();
   }

   public boolean isInitialized() {
      return this.initialized;
   }

   static {
      CustomViaManager manager = new CustomViaManager();
      Via.init(manager);
      manager.protocolManager.registerProtocols();
      manager.protocolManager.refreshVersions();
      manager.initialized = true;
   }
}
