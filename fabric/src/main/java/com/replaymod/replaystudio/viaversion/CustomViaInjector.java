package com.replaymod.replaystudio.viaversion;

import com.replaymod.replaystudio.lib.viaversion.api.platform.ViaInjector;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonObject;
import com.replaymod.replaystudio.studio.ReplayStudio;

public class CustomViaInjector implements ViaInjector {
   private final int serverProtocolVersion = (new ReplayStudio()).getCurrentFileFormatVersion();

   public void inject() throws Exception {
   }

   public void uninject() throws Exception {
   }

   public int getServerProtocolVersion() throws Exception {
      return this.serverProtocolVersion;
   }

   public String getEncoderName() {
      throw new UnsupportedOperationException();
   }

   public String getDecoderName() {
      throw new UnsupportedOperationException();
   }

   public JsonObject getDump() {
      throw new UnsupportedOperationException();
   }
}
