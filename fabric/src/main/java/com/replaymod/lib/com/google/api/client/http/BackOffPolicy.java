package com.replaymod.lib.com.google.api.client.http;

import com.replaymod.lib.com.google.api.client.util.Beta;
import java.io.IOException;

/** @deprecated */
@Deprecated
@Beta
public interface BackOffPolicy {
   long STOP = -1L;

   boolean isBackOffRequired(int var1);

   void reset();

   long getNextBackOffMillis() throws IOException;
}
