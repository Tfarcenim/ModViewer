package com.replaymod.lib.com.google.api.services.youtube;

import com.replaymod.lib.com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.replaymod.lib.com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer;
import java.io.IOException;

public class YouTubeRequestInitializer extends CommonGoogleJsonClientRequestInitializer {
   public YouTubeRequestInitializer() {
   }

   public YouTubeRequestInitializer(String var1) {
      super(var1);
   }

   public YouTubeRequestInitializer(String var1, String var2) {
      super(var1, var2);
   }

   public final void initializeJsonRequest(AbstractGoogleJsonClientRequest<?> var1) throws IOException {
      super.initializeJsonRequest(var1);
      this.initializeYouTubeRequest((YouTubeRequest)var1);
   }

   protected void initializeYouTubeRequest(YouTubeRequest<?> var1) throws IOException {
   }
}
