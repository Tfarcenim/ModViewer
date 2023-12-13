package com.replaymod.lib.com.fasterxml.jackson.databind.cfg;

public interface ConfigFeature {
   boolean enabledByDefault();

   int getMask();

   boolean enabledIn(int var1);
}
