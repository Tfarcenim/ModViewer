package com.replaymod.replaystudio.lib.guava.io;

import com.replaymod.replaystudio.lib.guava.annotations.Beta;
import java.io.IOException;

@Beta
public interface ByteProcessor<T> {
   boolean processBytes(byte[] var1, int var2, int var3) throws IOException;

   T getResult();
}
