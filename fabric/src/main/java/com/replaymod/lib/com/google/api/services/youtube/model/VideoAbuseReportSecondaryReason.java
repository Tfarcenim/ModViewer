package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class VideoAbuseReportSecondaryReason extends GenericJson {
   @Key
   private String id;
   @Key
   private String label;

   public String getId() {
      return this.id;
   }

   public VideoAbuseReportSecondaryReason setId(String var1) {
      this.id = var1;
      return this;
   }

   public String getLabel() {
      return this.label;
   }

   public VideoAbuseReportSecondaryReason setLabel(String var1) {
      this.label = var1;
      return this;
   }

   public VideoAbuseReportSecondaryReason set(String var1, Object var2) {
      return (VideoAbuseReportSecondaryReason)super.set(var1, var2);
   }

   public VideoAbuseReportSecondaryReason clone() {
      return (VideoAbuseReportSecondaryReason)super.clone();
   }
}
