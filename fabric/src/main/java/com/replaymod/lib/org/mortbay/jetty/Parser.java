package com.replaymod.lib.org.mortbay.jetty;

import java.io.IOException;

public interface Parser {
   void reset(boolean var1);

   boolean isComplete();

   long parseAvailable() throws IOException;

   boolean isMoreInBuffer() throws IOException;

   boolean isIdle();
}
