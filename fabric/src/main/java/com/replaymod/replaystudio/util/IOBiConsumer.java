package com.replaymod.replaystudio.util;

import java.io.IOException;

@FunctionalInterface
public interface IOBiConsumer<T, U> {
   void accept(T var1, U var2) throws IOException;
}
