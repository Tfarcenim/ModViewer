package com.replaymod.replaystudio.lib.viaversion.libs.gson;

public interface ExclusionStrategy {
   boolean shouldSkipField(FieldAttributes var1);

   boolean shouldSkipClass(Class<?> var1);
}
