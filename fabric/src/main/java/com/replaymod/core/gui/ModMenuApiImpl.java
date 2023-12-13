package com.replaymod.core.gui;

import com.replaymod.core.ReplayMod;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

public class ModMenuApiImpl implements ModMenuApi {
   public ConfigScreenFactory<?> getModConfigScreenFactory() {
      return (parent) -> {
         return (new GuiReplaySettings(parent, ReplayMod.instance.getSettingsRegistry())).toMinecraft();
      };
   }
}
