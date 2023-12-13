package com.replaymod.replaystudio.lib.viaversion.api.legacy;

import com.replaymod.replaystudio.lib.viaversion.api.legacy.bossbar.BossBar;
import com.replaymod.replaystudio.lib.viaversion.api.legacy.bossbar.BossColor;
import com.replaymod.replaystudio.lib.viaversion.api.legacy.bossbar.BossStyle;

public interface LegacyViaAPI<T> {
   BossBar createLegacyBossBar(String var1, float var2, BossColor var3, BossStyle var4);

   default BossBar createLegacyBossBar(String title, BossColor color, BossStyle style) {
      return this.createLegacyBossBar(title, 1.0F, color, style);
   }
}
