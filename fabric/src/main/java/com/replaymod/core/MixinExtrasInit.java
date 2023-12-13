package com.replaymod.core;

import com.replaymod.lib.com.llamalad7.mixinextras.MixinExtrasBootstrap;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

public class MixinExtrasInit implements PreLaunchEntrypoint {
   public void onPreLaunch() {
      MixinExtrasBootstrap.init();
   }
}
