package com.replaymod.lib.com.fasterxml.jackson.databind.cfg;

import com.replaymod.lib.com.fasterxml.jackson.core.Version;
import com.replaymod.lib.com.fasterxml.jackson.core.Versioned;
import com.replaymod.lib.com.fasterxml.jackson.core.util.VersionUtil;

public final class PackageVersion implements Versioned {
   public static final Version VERSION = VersionUtil.parseVersion("2.9.8", "com.replaymod.lib.com.fasterxml.jackson.core", "jackson-databind");

   public Version version() {
      return VERSION;
   }
}
