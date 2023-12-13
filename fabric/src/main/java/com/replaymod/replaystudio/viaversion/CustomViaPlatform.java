package com.replaymod.replaystudio.viaversion;

import com.replaymod.replaystudio.lib.viaversion.api.ViaAPI;
import com.replaymod.replaystudio.lib.viaversion.api.command.ViaCommandSender;
import com.replaymod.replaystudio.lib.viaversion.api.configuration.ConfigurationProvider;
import com.replaymod.replaystudio.lib.viaversion.api.configuration.ViaVersionConfig;
import com.replaymod.replaystudio.lib.viaversion.api.platform.PlatformTask;
import com.replaymod.replaystudio.lib.viaversion.api.platform.ViaPlatform;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonObject;
import java.io.File;
import java.util.UUID;
import java.util.logging.Logger;

public class CustomViaPlatform implements ViaPlatform<Void> {
   private CustomViaConfig config = new CustomViaConfig();

   public Logger getLogger() {
      return Logger.getLogger(CustomViaPlatform.class.getName());
   }

   public String getPlatformName() {
      return "ReplayStudio";
   }

   public String getPlatformVersion() {
      return null;
   }

   public String getPluginVersion() {
      return "1.0";
   }

   public PlatformTask<?> runAsync(Runnable runnable) {
      throw new UnsupportedOperationException();
   }

   public PlatformTask<?> runRepeatingAsync(Runnable runnable, long l) {
      throw new UnsupportedOperationException();
   }

   public PlatformTask<?> runSync(Runnable runnable) {
      throw new UnsupportedOperationException();
   }

   public PlatformTask<?> runSync(Runnable runnable, long aLong) {
      throw new UnsupportedOperationException();
   }

   public PlatformTask<?> runRepeatingSync(Runnable runnable, long aLong) {
      throw new UnsupportedOperationException();
   }

   public ViaCommandSender[] getOnlinePlayers() {
      throw new UnsupportedOperationException();
   }

   public void sendMessage(UUID uuid, String s) {
      throw new UnsupportedOperationException();
   }

   public boolean kickPlayer(UUID uuid, String s) {
      throw new UnsupportedOperationException();
   }

   public boolean isPluginEnabled() {
      return true;
   }

   public ViaAPI<Void> getApi() {
      return (ViaAPI)CustomViaAPI.INSTANCE.get();
   }

   public ViaVersionConfig getConf() {
      return this.config;
   }

   public ConfigurationProvider getConfigurationProvider() {
      throw new UnsupportedOperationException();
   }

   public File getDataFolder() {
      return null;
   }

   public void onReload() {
   }

   public JsonObject getDump() {
      throw new UnsupportedOperationException();
   }

   public boolean isOldClientsAllowed() {
      return false;
   }

   public boolean hasPlugin(String name) {
      return false;
   }
}
