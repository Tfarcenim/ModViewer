package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class ChannelBannerResource extends GenericJson {
   @Key
   private String etag;
   @Key
   private String kind;
   @Key
   private String url;

   public String getEtag() {
      return this.etag;
   }

   public ChannelBannerResource setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public ChannelBannerResource setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public String getUrl() {
      return this.url;
   }

   public ChannelBannerResource setUrl(String var1) {
      this.url = var1;
      return this;
   }

   public ChannelBannerResource set(String var1, Object var2) {
      return (ChannelBannerResource)super.set(var1, var2);
   }

   public ChannelBannerResource clone() {
      return (ChannelBannerResource)super.clone();
   }
}
