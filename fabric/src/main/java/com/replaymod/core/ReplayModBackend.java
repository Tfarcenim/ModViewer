package com.replaymod.core;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.SharedConstants;

public class ReplayModBackend implements ClientModInitializer {
   private final ReplayMod mod = new ReplayMod(this);

   public void onInitializeClient() {
      this.mod.initModules();
   }

   public String getVersion() {
      return FabricLoader.getInstance().getModContainer("replaymod").orElseThrow(IllegalStateException::new).getMetadata().getVersion().toString();
   }

   public String getMinecraftVersion() {
      return SharedConstants.getCurrentVersion().getName();
   }

   public boolean isModLoaded(String id) {
      return FabricLoader.getInstance().isModLoaded(id.toLowerCase());
   }
}
