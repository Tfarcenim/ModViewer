package com.replaymod.lib.com.google.api.client.json.webtoken;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;
import com.replaymod.lib.com.google.api.client.util.Objects;
import com.replaymod.lib.com.google.api.client.util.Preconditions;
import java.util.Collections;
import java.util.List;

public class JsonWebToken {
   private final JsonWebToken.Header header;
   private final JsonWebToken.Payload payload;

   public JsonWebToken(JsonWebToken.Header header, JsonWebToken.Payload payload) {
      this.header = (JsonWebToken.Header)Preconditions.checkNotNull(header);
      this.payload = (JsonWebToken.Payload)Preconditions.checkNotNull(payload);
   }

   public String toString() {
      return Objects.toStringHelper(this).add("header", this.header).add("payload", this.payload).toString();
   }

   public JsonWebToken.Header getHeader() {
      return this.header;
   }

   public JsonWebToken.Payload getPayload() {
      return this.payload;
   }

   public static class Payload extends GenericJson {
      @Key("exp")
      private Long expirationTimeSeconds;
      @Key("nbf")
      private Long notBeforeTimeSeconds;
      @Key("iat")
      private Long issuedAtTimeSeconds;
      @Key("iss")
      private String issuer;
      @Key("aud")
      private Object audience;
      @Key("jti")
      private String jwtId;
      @Key("typ")
      private String type;
      @Key("sub")
      private String subject;

      public final Long getExpirationTimeSeconds() {
         return this.expirationTimeSeconds;
      }

      public JsonWebToken.Payload setExpirationTimeSeconds(Long expirationTimeSeconds) {
         this.expirationTimeSeconds = expirationTimeSeconds;
         return this;
      }

      public final Long getNotBeforeTimeSeconds() {
         return this.notBeforeTimeSeconds;
      }

      public JsonWebToken.Payload setNotBeforeTimeSeconds(Long notBeforeTimeSeconds) {
         this.notBeforeTimeSeconds = notBeforeTimeSeconds;
         return this;
      }

      public final Long getIssuedAtTimeSeconds() {
         return this.issuedAtTimeSeconds;
      }

      public JsonWebToken.Payload setIssuedAtTimeSeconds(Long issuedAtTimeSeconds) {
         this.issuedAtTimeSeconds = issuedAtTimeSeconds;
         return this;
      }

      public final String getIssuer() {
         return this.issuer;
      }

      public JsonWebToken.Payload setIssuer(String issuer) {
         this.issuer = issuer;
         return this;
      }

      public final Object getAudience() {
         return this.audience;
      }

      public final List<String> getAudienceAsList() {
         if (this.audience == null) {
            return Collections.emptyList();
         } else {
            return this.audience instanceof String ? Collections.singletonList((String)this.audience) : (List)this.audience;
         }
      }

      public JsonWebToken.Payload setAudience(Object audience) {
         this.audience = audience;
         return this;
      }

      public final String getJwtId() {
         return this.jwtId;
      }

      public JsonWebToken.Payload setJwtId(String jwtId) {
         this.jwtId = jwtId;
         return this;
      }

      public final String getType() {
         return this.type;
      }

      public JsonWebToken.Payload setType(String type) {
         this.type = type;
         return this;
      }

      public final String getSubject() {
         return this.subject;
      }

      public JsonWebToken.Payload setSubject(String subject) {
         this.subject = subject;
         return this;
      }

      public JsonWebToken.Payload set(String fieldName, Object value) {
         return (JsonWebToken.Payload)super.set(fieldName, value);
      }

      public JsonWebToken.Payload clone() {
         return (JsonWebToken.Payload)super.clone();
      }
   }

   public static class Header extends GenericJson {
      @Key("typ")
      private String type;
      @Key("cty")
      private String contentType;

      public final String getType() {
         return this.type;
      }

      public JsonWebToken.Header setType(String type) {
         this.type = type;
         return this;
      }

      public final String getContentType() {
         return this.contentType;
      }

      public JsonWebToken.Header setContentType(String contentType) {
         this.contentType = contentType;
         return this;
      }

      public JsonWebToken.Header set(String fieldName, Object value) {
         return (JsonWebToken.Header)super.set(fieldName, value);
      }

      public JsonWebToken.Header clone() {
         return (JsonWebToken.Header)super.clone();
      }
   }
}
