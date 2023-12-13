package com.replaymod.replaystudio.lib.guava.hash;

import com.replaymod.replaystudio.lib.guava.annotations.Beta;
import java.io.Serializable;

@Beta
public interface Funnel<T> extends Serializable {
   void funnel(T var1, PrimitiveSink var2);
}
