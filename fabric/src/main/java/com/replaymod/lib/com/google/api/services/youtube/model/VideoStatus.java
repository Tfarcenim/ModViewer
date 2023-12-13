package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.DateTime;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class VideoStatus extends GenericJson {
   @Key
   private Boolean embeddable;
   @Key
   private String failureReason;
   @Key
   private String license;
   @Key
   private String privacyStatus;
   @Key
   private Boolean publicStatsViewable;
   @Key
   private DateTime publishAt;
   @Key
   private String rejectionReason;
   @Key
   private String uploadStatus;

   public Boolean getEmbeddable() {
      return this.embeddable;
   }

   public VideoStatus setEmbeddable(Boolean var1) {
      this.embeddable = var1;
      return this;
   }

   public String getFailureReason() {
      return this.failureReason;
   }

   public VideoStatus setFailureReason(String var1) {
      this.failureReason = var1;
      return this;
   }

   public String getLicense() {
      return this.license;
   }

   public VideoStatus setLicense(String var1) {
      this.license = var1;
      return this;
   }

   public String getPrivacyStatus() {
      return this.privacyStatus;
   }

   public VideoStatus setPrivacyStatus(String var1) {
      this.privacyStatus = var1;
      return this;
   }

   public Boolean getPublicStatsViewable() {
      return this.publicStatsViewable;
   }

   public VideoStatus setPublicStatsViewable(Boolean var1) {
      this.publicStatsViewable = var1;
      return this;
   }

   public DateTime getPublishAt() {
      return this.publishAt;
   }

   public VideoStatus setPublishAt(DateTime var1) {
      this.publishAt = var1;
      return this;
   }

   public String getRejectionReason() {
      return this.rejectionReason;
   }

   public VideoStatus setRejectionReason(String var1) {
      this.rejectionReason = var1;
      return this;
   }

   public String getUploadStatus() {
      return this.uploadStatus;
   }

   public VideoStatus setUploadStatus(String var1) {
      this.uploadStatus = var1;
      return this;
   }

   public VideoStatus set(String var1, Object var2) {
      return (VideoStatus)super.set(var1, var2);
   }

   public VideoStatus clone() {
      return (VideoStatus)super.clone();
   }
}
