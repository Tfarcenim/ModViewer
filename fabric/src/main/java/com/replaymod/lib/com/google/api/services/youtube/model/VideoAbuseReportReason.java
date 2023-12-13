package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class VideoAbuseReportReason extends GenericJson {
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private VideoAbuseReportReasonSnippet snippet;

   public String getEtag() {
      return this.etag;
   }

   public VideoAbuseReportReason setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getId() {
      return this.id;
   }

   public VideoAbuseReportReason setId(String var1) {
      this.id = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public VideoAbuseReportReason setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public VideoAbuseReportReasonSnippet getSnippet() {
      return this.snippet;
   }

   public VideoAbuseReportReason setSnippet(VideoAbuseReportReasonSnippet var1) {
      this.snippet = var1;
      return this;
   }

   public VideoAbuseReportReason set(String var1, Object var2) {
      return (VideoAbuseReportReason)super.set(var1, var2);
   }

   public VideoAbuseReportReason clone() {
      return (VideoAbuseReportReason)super.clone();
   }
}
