package com.replaymod.lib.com.google.api.client.auth.openidconnect;

import com.replaymod.lib.com.google.api.client.json.JsonFactory;
import com.replaymod.lib.com.google.api.client.json.webtoken.JsonWebSignature;
import com.replaymod.lib.com.google.api.client.json.webtoken.JsonWebToken;
import com.replaymod.lib.com.google.api.client.util.Beta;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Beta
public class IdToken extends JsonWebSignature {
   public IdToken(JsonWebSignature.Header header, IdToken.Payload payload, byte[] signatureBytes, byte[] signedContentBytes) {
      super(header, payload, signatureBytes, signedContentBytes);
   }

   public IdToken.Payload getPayload() {
      return (IdToken.Payload)super.getPayload();
   }

   public final boolean verifyIssuer(String expectedIssuer) {
      return this.verifyIssuer((Collection)Collections.singleton(expectedIssuer));
   }

   public final boolean verifyIssuer(Collection<String> expectedIssuer) {
      return expectedIssuer.contains(this.getPayload().getIssuer());
   }

   public final boolean verifyAudience(Collection<String> trustedClientIds) {
      return trustedClientIds.containsAll(this.getPayload().getAudienceAsList());
   }

   public final boolean verifyTime(long currentTimeMillis, long acceptableTimeSkewSeconds) {
      return this.verifyExpirationTime(currentTimeMillis, acceptableTimeSkewSeconds) && this.verifyIssuedAtTime(currentTimeMillis, acceptableTimeSkewSeconds);
   }

   public final boolean verifyExpirationTime(long currentTimeMillis, long acceptableTimeSkewSeconds) {
      return currentTimeMillis <= (this.getPayload().getExpirationTimeSeconds() + acceptableTimeSkewSeconds) * 1000L;
   }

   public final boolean verifyIssuedAtTime(long currentTimeMillis, long acceptableTimeSkewSeconds) {
      return currentTimeMillis >= (this.getPayload().getIssuedAtTimeSeconds() - acceptableTimeSkewSeconds) * 1000L;
   }

   public static IdToken parse(JsonFactory jsonFactory, String idTokenString) throws IOException {
      JsonWebSignature jws = JsonWebSignature.parser(jsonFactory).setPayloadClass(IdToken.Payload.class).parse(idTokenString);
      return new IdToken(jws.getHeader(), (IdToken.Payload)jws.getPayload(), jws.getSignatureBytes(), jws.getSignedContentBytes());
   }

   @Beta
   public static class Payload extends JsonWebToken.Payload {
      @Key("auth_time")
      private Long authorizationTimeSeconds;
      @Key("azp")
      private String authorizedParty;
      @Key
      private String nonce;
      @Key("at_hash")
      private String accessTokenHash;
      @Key("acr")
      private String classReference;
      @Key("amr")
      private List<String> methodsReferences;

      public final Long getAuthorizationTimeSeconds() {
         return this.authorizationTimeSeconds;
      }

      public IdToken.Payload setAuthorizationTimeSeconds(Long authorizationTimeSeconds) {
         this.authorizationTimeSeconds = authorizationTimeSeconds;
         return this;
      }

      public final String getAuthorizedParty() {
         return this.authorizedParty;
      }

      public IdToken.Payload setAuthorizedParty(String authorizedParty) {
         this.authorizedParty = authorizedParty;
         return this;
      }

      public final String getNonce() {
         return this.nonce;
      }

      public IdToken.Payload setNonce(String nonce) {
         this.nonce = nonce;
         return this;
      }

      public final String getAccessTokenHash() {
         return this.accessTokenHash;
      }

      public IdToken.Payload setAccessTokenHash(String accessTokenHash) {
         this.accessTokenHash = accessTokenHash;
         return this;
      }

      public final String getClassReference() {
         return this.classReference;
      }

      public IdToken.Payload setClassReference(String classReference) {
         this.classReference = classReference;
         return this;
      }

      public final List<String> getMethodsReferences() {
         return this.methodsReferences;
      }

      public IdToken.Payload setMethodsReferences(List<String> methodsReferences) {
         this.methodsReferences = methodsReferences;
         return this;
      }

      public IdToken.Payload setExpirationTimeSeconds(Long expirationTimeSeconds) {
         return (IdToken.Payload)super.setExpirationTimeSeconds(expirationTimeSeconds);
      }

      public IdToken.Payload setNotBeforeTimeSeconds(Long notBeforeTimeSeconds) {
         return (IdToken.Payload)super.setNotBeforeTimeSeconds(notBeforeTimeSeconds);
      }

      public IdToken.Payload setIssuedAtTimeSeconds(Long issuedAtTimeSeconds) {
         return (IdToken.Payload)super.setIssuedAtTimeSeconds(issuedAtTimeSeconds);
      }

      public IdToken.Payload setIssuer(String issuer) {
         return (IdToken.Payload)super.setIssuer(issuer);
      }

      public IdToken.Payload setAudience(Object audience) {
         return (IdToken.Payload)super.setAudience(audience);
      }

      public IdToken.Payload setJwtId(String jwtId) {
         return (IdToken.Payload)super.setJwtId(jwtId);
      }

      public IdToken.Payload setType(String type) {
         return (IdToken.Payload)super.setType(type);
      }

      public IdToken.Payload setSubject(String subject) {
         return (IdToken.Payload)super.setSubject(subject);
      }

      public IdToken.Payload set(String fieldName, Object value) {
         return (IdToken.Payload)super.set(fieldName, value);
      }

      public IdToken.Payload clone() {
         return (IdToken.Payload)super.clone();
      }
   }
}
