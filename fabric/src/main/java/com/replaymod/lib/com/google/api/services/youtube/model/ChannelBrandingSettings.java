package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class ChannelBrandingSettings extends GenericJson {
   @Key
   private ChannelSettings channel;
   @Key
   private List<PropertyValue> hints;
   @Key
   private ImageSettings image;
   @Key
   private WatchSettings watch;

   public ChannelSettings getChannel() {
      return this.channel;
   }

   public ChannelBrandingSettings setChannel(ChannelSettings var1) {
      this.channel = var1;
      return this;
   }

   public List<PropertyValue> getHints() {
      return this.hints;
   }

   public ChannelBrandingSettings setHints(List<PropertyValue> var1) {
      this.hints = var1;
      return this;
   }

   public ImageSettings getImage() {
      return this.image;
   }

   public ChannelBrandingSettings setImage(ImageSettings var1) {
      this.image = var1;
      return this;
   }

   public WatchSettings getWatch() {
      return this.watch;
   }

   public ChannelBrandingSettings setWatch(WatchSettings var1) {
      this.watch = var1;
      return this;
   }

   public ChannelBrandingSettings set(String var1, Object var2) {
      return (ChannelBrandingSettings)super.set(var1, var2);
   }

   public ChannelBrandingSettings clone() {
      return (ChannelBrandingSettings)super.clone();
   }
}
