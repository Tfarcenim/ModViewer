package com.replaymod.replaystudio.lib.viaversion.legacy;

import com.replaymod.replaystudio.lib.viaversion.api.legacy.LegacyViaAPI;
import com.replaymod.replaystudio.lib.viaversion.api.legacy.bossbar.BossBar;
import com.replaymod.replaystudio.lib.viaversion.api.legacy.bossbar.BossColor;
import com.replaymod.replaystudio.lib.viaversion.api.legacy.bossbar.BossStyle;
import com.replaymod.replaystudio.lib.viaversion.legacy.bossbar.CommonBoss;

public final class LegacyAPI<T> implements LegacyViaAPI<T> {
   public BossBar createLegacyBossBar(String title, float health, BossColor color, BossStyle style) {
      return new CommonBoss(title, health, color, style);
   }
}
