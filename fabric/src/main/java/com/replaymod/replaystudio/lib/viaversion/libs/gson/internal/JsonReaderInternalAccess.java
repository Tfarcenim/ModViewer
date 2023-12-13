package com.replaymod.replaystudio.lib.viaversion.libs.gson.internal;

import com.replaymod.replaystudio.lib.viaversion.libs.gson.stream.JsonReader;
import java.io.IOException;

public abstract class JsonReaderInternalAccess {
   public static JsonReaderInternalAccess INSTANCE;

   public abstract void promoteNameToValue(JsonReader var1) throws IOException;
}
