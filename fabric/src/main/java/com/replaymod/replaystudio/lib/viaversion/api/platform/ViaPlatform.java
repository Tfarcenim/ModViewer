package com.replaymod.replaystudio.lib.viaversion.api.platform;

import com.replaymod.replaystudio.lib.viaversion.api.ViaAPI;
import com.replaymod.replaystudio.lib.viaversion.api.command.ViaCommandSender;
import com.replaymod.replaystudio.lib.viaversion.api.configuration.ConfigurationProvider;
import com.replaymod.replaystudio.lib.viaversion.api.configuration.ViaVersionConfig;
import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonObject;
import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;
import java.util.logging.Logger;

public interface ViaPlatform<T> {
   Logger getLogger();

   String getPlatformName();

   String getPlatformVersion();

   default boolean isProxy() {
      return false;
   }

   String getPluginVersion();

   PlatformTask runAsync(Runnable var1);

   PlatformTask runRepeatingAsync(Runnable var1, long var2);

   PlatformTask runSync(Runnable var1);

   PlatformTask runSync(Runnable var1, long var2);

   PlatformTask runRepeatingSync(Runnable var1, long var2);

   ViaCommandSender[] getOnlinePlayers();

   void sendMessage(UUID var1, String var2);

   boolean kickPlayer(UUID var1, String var2);

   default boolean disconnect(UserConnection connection, String message) {
      if (connection.isClientSide()) {
         return false;
      } else {
         UUID uuid = connection.getProtocolInfo().getUuid();
         return uuid == null ? false : this.kickPlayer(uuid, message);
      }
   }

   boolean isPluginEnabled();

   ViaAPI<T> getApi();

   ViaVersionConfig getConf();

   ConfigurationProvider getConfigurationProvider();

   File getDataFolder();

   void onReload();

   JsonObject getDump();

   boolean isOldClientsAllowed();

   default Collection<UnsupportedSoftware> getUnsupportedSoftwareClasses() {
      return Collections.emptyList();
   }

   boolean hasPlugin(String var1);
}
