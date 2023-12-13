package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.util.Nag;

final class LegacyFormattingDetected extends Nag {
   private static final long serialVersionUID = -947793022628807411L;

   LegacyFormattingDetected(final Component component) {
      super("Legacy formatting codes have been detected in a component - this is unsupported behaviour. Please refer to the Adventure documentation (https://docs.advntr.dev) for more information. Component: " + component);
   }
}
