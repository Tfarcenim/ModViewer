package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.util.List;

public final class VideoAbuseReportReasonSnippet extends GenericJson {
   @Key
   private String label;
   @Key
   private List<VideoAbuseReportSecondaryReason> secondaryReasons;

   public String getLabel() {
      return this.label;
   }

   public VideoAbuseReportReasonSnippet setLabel(String var1) {
      this.label = var1;
      return this;
   }

   public List<VideoAbuseReportSecondaryReason> getSecondaryReasons() {
      return this.secondaryReasons;
   }

   public VideoAbuseReportReasonSnippet setSecondaryReasons(List<VideoAbuseReportSecondaryReason> var1) {
      this.secondaryReasons = var1;
      return this;
   }

   public VideoAbuseReportReasonSnippet set(String var1, Object var2) {
      return (VideoAbuseReportReasonSnippet)super.set(var1, var2);
   }

   public VideoAbuseReportReasonSnippet clone() {
      return (VideoAbuseReportReasonSnippet)super.clone();
   }
}
