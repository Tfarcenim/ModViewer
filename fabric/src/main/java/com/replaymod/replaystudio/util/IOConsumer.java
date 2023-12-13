package com.replaymod.replaystudio.util;

import java.io.IOException;

@FunctionalInterface
public interface IOConsumer<T> {
   void consume(T var1) throws IOException;
}
