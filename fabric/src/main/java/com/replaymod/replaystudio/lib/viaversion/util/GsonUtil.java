package com.replaymod.replaystudio.lib.viaversion.util;

import com.replaymod.replaystudio.lib.viaversion.libs.gson.Gson;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.GsonBuilder;

public final class GsonUtil {
   private static final Gson GSON = (new GsonBuilder()).create();

   public static Gson getGson() {
      return GSON;
   }
}
