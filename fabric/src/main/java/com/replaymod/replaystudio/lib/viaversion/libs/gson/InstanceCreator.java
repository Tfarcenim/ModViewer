package com.replaymod.replaystudio.lib.viaversion.libs.gson;

import java.lang.reflect.Type;

public interface InstanceCreator<T> {
   T createInstance(Type var1);
}
