package com.replaymod.replaystudio.lib.guava.base;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;

@GwtCompatible
public interface Supplier<T> {
   T get();
}
