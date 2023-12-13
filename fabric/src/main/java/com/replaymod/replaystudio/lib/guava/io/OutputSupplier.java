package com.replaymod.replaystudio.lib.guava.io;

import java.io.IOException;

/** @deprecated */
@Deprecated
public interface OutputSupplier<T> {
   T getOutput() throws IOException;
}
