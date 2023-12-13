package com.replaymod.replaystudio;

import com.replaymod.replaystudio.filter.StreamFilter;

public interface Studio {
   String getName();

   int getVersion();

   StreamFilter loadStreamFilter(String var1);

   boolean isCompatible(int var1, int var2, int var3);

   int getCurrentFileFormatVersion();
}
