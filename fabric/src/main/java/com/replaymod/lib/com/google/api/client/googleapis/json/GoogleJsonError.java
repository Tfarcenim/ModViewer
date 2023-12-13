package com.replaymod.lib.com.google.api.client.googleapis.json;

import com.replaymod.lib.com.google.api.client.http.HttpResponse;
import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.json.JsonFactory;
import com.replaymod.lib.com.google.api.client.json.JsonObjectParser;
import com.replaymod.lib.com.google.api.client.util.Data;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class GoogleJsonError extends GenericJson {
   @Key
   private List<GoogleJsonError.ErrorInfo> errors;
   @Key
   private int code;
   @Key
   private String message;

   public static GoogleJsonError parse(JsonFactory jsonFactory, HttpResponse response) throws IOException {
      JsonObjectParser jsonObjectParser = (new JsonObjectParser.Builder(jsonFactory)).setWrapperKeys(Collections.singleton("error")).build();
      return (GoogleJsonError)jsonObjectParser.parseAndClose(response.getContent(), response.getContentCharset(), GoogleJsonError.class);
   }

   public final List<GoogleJsonError.ErrorInfo> getErrors() {
      return this.errors;
   }

   public final void setErrors(List<GoogleJsonError.ErrorInfo> errors) {
      this.errors = errors;
   }

   public final int getCode() {
      return this.code;
   }

   public final void setCode(int code) {
      this.code = code;
   }

   public final String getMessage() {
      return this.message;
   }

   public final void setMessage(String message) {
      this.message = message;
   }

   public GoogleJsonError set(String fieldName, Object value) {
      return (GoogleJsonError)super.set(fieldName, value);
   }

   public GoogleJsonError clone() {
      return (GoogleJsonError)super.clone();
   }

   static {
      Data.nullOf(GoogleJsonError.ErrorInfo.class);
   }

   public static class ErrorInfo extends GenericJson {
      @Key
      private String domain;
      @Key
      private String reason;
      @Key
      private String message;
      @Key
      private String location;
      @Key
      private String locationType;

      public final String getDomain() {
         return this.domain;
      }

      public final void setDomain(String domain) {
         this.domain = domain;
      }

      public final String getReason() {
         return this.reason;
      }

      public final void setReason(String reason) {
         this.reason = reason;
      }

      public final String getMessage() {
         return this.message;
      }

      public final void setMessage(String message) {
         this.message = message;
      }

      public final String getLocation() {
         return this.location;
      }

      public final void setLocation(String location) {
         this.location = location;
      }

      public final String getLocationType() {
         return this.locationType;
      }

      public final void setLocationType(String locationType) {
         this.locationType = locationType;
      }

      public GoogleJsonError.ErrorInfo set(String fieldName, Object value) {
         return (GoogleJsonError.ErrorInfo)super.set(fieldName, value);
      }

      public GoogleJsonError.ErrorInfo clone() {
         return (GoogleJsonError.ErrorInfo)super.clone();
      }
   }
}
