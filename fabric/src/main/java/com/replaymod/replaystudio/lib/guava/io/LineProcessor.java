package com.replaymod.replaystudio.lib.guava.io;

import com.replaymod.replaystudio.lib.guava.annotations.Beta;
import java.io.IOException;

@Beta
public interface LineProcessor<T> {
   boolean processLine(String var1) throws IOException;

   T getResult();
}
