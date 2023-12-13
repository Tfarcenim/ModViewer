package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.json.JsonString;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.math.BigInteger;
import java.util.List;

public final class VideoFileDetails extends GenericJson {
   @Key
   private List<VideoFileDetailsAudioStream> audioStreams;
   @Key
   @JsonString
   private BigInteger bitrateBps;
   @Key
   private String container;
   @Key
   private String creationTime;
   @Key
   @JsonString
   private BigInteger durationMs;
   @Key
   private String fileName;
   @Key
   @JsonString
   private BigInteger fileSize;
   @Key
   private String fileType;
   @Key
   private GeoPoint recordingLocation;
   @Key
   private List<VideoFileDetailsVideoStream> videoStreams;

   public List<VideoFileDetailsAudioStream> getAudioStreams() {
      return this.audioStreams;
   }

   public VideoFileDetails setAudioStreams(List<VideoFileDetailsAudioStream> var1) {
      this.audioStreams = var1;
      return this;
   }

   public BigInteger getBitrateBps() {
      return this.bitrateBps;
   }

   public VideoFileDetails setBitrateBps(BigInteger var1) {
      this.bitrateBps = var1;
      return this;
   }

   public String getContainer() {
      return this.container;
   }

   public VideoFileDetails setContainer(String var1) {
      this.container = var1;
      return this;
   }

   public String getCreationTime() {
      return this.creationTime;
   }

   public VideoFileDetails setCreationTime(String var1) {
      this.creationTime = var1;
      return this;
   }

   public BigInteger getDurationMs() {
      return this.durationMs;
   }

   public VideoFileDetails setDurationMs(BigInteger var1) {
      this.durationMs = var1;
      return this;
   }

   public String getFileName() {
      return this.fileName;
   }

   public VideoFileDetails setFileName(String var1) {
      this.fileName = var1;
      return this;
   }

   public BigInteger getFileSize() {
      return this.fileSize;
   }

   public VideoFileDetails setFileSize(BigInteger var1) {
      this.fileSize = var1;
      return this;
   }

   public String getFileType() {
      return this.fileType;
   }

   public VideoFileDetails setFileType(String var1) {
      this.fileType = var1;
      return this;
   }

   public GeoPoint getRecordingLocation() {
      return this.recordingLocation;
   }

   public VideoFileDetails setRecordingLocation(GeoPoint var1) {
      this.recordingLocation = var1;
      return this;
   }

   public List<VideoFileDetailsVideoStream> getVideoStreams() {
      return this.videoStreams;
   }

   public VideoFileDetails setVideoStreams(List<VideoFileDetailsVideoStream> var1) {
      this.videoStreams = var1;
      return this;
   }

   public VideoFileDetails set(String var1, Object var2) {
      return (VideoFileDetails)super.set(var1, var2);
   }

   public VideoFileDetails clone() {
      return (VideoFileDetails)super.clone();
   }
}
