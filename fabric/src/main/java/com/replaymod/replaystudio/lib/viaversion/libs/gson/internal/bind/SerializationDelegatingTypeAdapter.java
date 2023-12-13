package com.replaymod.replaystudio.lib.viaversion.libs.gson.internal.bind;

import com.replaymod.replaystudio.lib.viaversion.libs.gson.TypeAdapter;

public abstract class SerializationDelegatingTypeAdapter<T> extends TypeAdapter<T> {
   public abstract TypeAdapter<T> getSerializationDelegate();
}
