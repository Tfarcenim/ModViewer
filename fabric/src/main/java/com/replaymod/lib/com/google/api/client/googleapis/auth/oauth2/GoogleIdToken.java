package com.replaymod.lib.com.google.api.client.googleapis.auth.oauth2;

import com.replaymod.lib.com.google.api.client.auth.openidconnect.IdToken;
import com.replaymod.lib.com.google.api.client.json.JsonFactory;
import com.replaymod.lib.com.google.api.client.json.webtoken.JsonWebSignature;
import com.replaymod.lib.com.google.api.client.util.Beta;
import com.replaymod.lib.com.google.api.client.util.Key;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@Beta
public class GoogleIdToken extends IdToken {
   public static GoogleIdToken parse(JsonFactory jsonFactory, String idTokenString) throws IOException {
      JsonWebSignature jws = JsonWebSignature.parser(jsonFactory).setPayloadClass(GoogleIdToken.Payload.class).parse(idTokenString);
      return new GoogleIdToken(jws.getHeader(), (GoogleIdToken.Payload)jws.getPayload(), jws.getSignatureBytes(), jws.getSignedContentBytes());
   }

   public GoogleIdToken(JsonWebSignature.Header header, GoogleIdToken.Payload payload, byte[] signatureBytes, byte[] signedContentBytes) {
      super(header, payload, signatureBytes, signedContentBytes);
   }

   public boolean verify(GoogleIdTokenVerifier verifier) throws GeneralSecurityException, IOException {
      return verifier.verify(this);
   }

   public GoogleIdToken.Payload getPayload() {
      return (GoogleIdToken.Payload)super.getPayload();
   }

   @Beta
   public static class Payload extends IdToken.Payload {
      @Key("hd")
      private String hostedDomain;
      @Key("email")
      private String email;
      @Key("email_verified")
      private Object emailVerified;

      /** @deprecated */
      @Deprecated
      public String getUserId() {
         return this.getSubject();
      }

      /** @deprecated */
      @Deprecated
      public GoogleIdToken.Payload setUserId(String userId) {
         return this.setSubject(userId);
      }

      /** @deprecated */
      @Deprecated
      public String getIssuee() {
         return this.getAuthorizedParty();
      }

      /** @deprecated */
      @Deprecated
      public GoogleIdToken.Payload setIssuee(String issuee) {
         return this.setAuthorizedParty(issuee);
      }

      public String getHostedDomain() {
         return this.hostedDomain;
      }

      public GoogleIdToken.Payload setHostedDomain(String hostedDomain) {
         this.hostedDomain = hostedDomain;
         return this;
      }

      public String getEmail() {
         return this.email;
      }

      public GoogleIdToken.Payload setEmail(String email) {
         this.email = email;
         return this;
      }

      public Boolean getEmailVerified() {
         if (this.emailVerified == null) {
            return null;
         } else {
            return this.emailVerified instanceof Boolean ? (Boolean)this.emailVerified : Boolean.valueOf((String)this.emailVerified);
         }
      }

      public GoogleIdToken.Payload setEmailVerified(Boolean emailVerified) {
         this.emailVerified = emailVerified;
         return this;
      }

      public GoogleIdToken.Payload setAuthorizationTimeSeconds(Long authorizationTimeSeconds) {
         return (GoogleIdToken.Payload)super.setAuthorizationTimeSeconds(authorizationTimeSeconds);
      }

      public GoogleIdToken.Payload setAuthorizedParty(String authorizedParty) {
         return (GoogleIdToken.Payload)super.setAuthorizedParty(authorizedParty);
      }

      public GoogleIdToken.Payload setNonce(String nonce) {
         return (GoogleIdToken.Payload)super.setNonce(nonce);
      }

      public GoogleIdToken.Payload setAccessTokenHash(String accessTokenHash) {
         return (GoogleIdToken.Payload)super.setAccessTokenHash(accessTokenHash);
      }

      public GoogleIdToken.Payload setClassReference(String classReference) {
         return (GoogleIdToken.Payload)super.setClassReference(classReference);
      }

      public GoogleIdToken.Payload setMethodsReferences(List<String> methodsReferences) {
         return (GoogleIdToken.Payload)super.setMethodsReferences(methodsReferences);
      }

      public GoogleIdToken.Payload setExpirationTimeSeconds(Long expirationTimeSeconds) {
         return (GoogleIdToken.Payload)super.setExpirationTimeSeconds(expirationTimeSeconds);
      }

      public GoogleIdToken.Payload setNotBeforeTimeSeconds(Long notBeforeTimeSeconds) {
         return (GoogleIdToken.Payload)super.setNotBeforeTimeSeconds(notBeforeTimeSeconds);
      }

      public GoogleIdToken.Payload setIssuedAtTimeSeconds(Long issuedAtTimeSeconds) {
         return (GoogleIdToken.Payload)super.setIssuedAtTimeSeconds(issuedAtTimeSeconds);
      }

      public GoogleIdToken.Payload setIssuer(String issuer) {
         return (GoogleIdToken.Payload)super.setIssuer(issuer);
      }

      public GoogleIdToken.Payload setAudience(Object audience) {
         return (GoogleIdToken.Payload)super.setAudience(audience);
      }

      public GoogleIdToken.Payload setJwtId(String jwtId) {
         return (GoogleIdToken.Payload)super.setJwtId(jwtId);
      }

      public GoogleIdToken.Payload setType(String type) {
         return (GoogleIdToken.Payload)super.setType(type);
      }

      public GoogleIdToken.Payload setSubject(String subject) {
         return (GoogleIdToken.Payload)super.setSubject(subject);
      }

      public GoogleIdToken.Payload set(String fieldName, Object value) {
         return (GoogleIdToken.Payload)super.set(fieldName, value);
      }

      public GoogleIdToken.Payload clone() {
         return (GoogleIdToken.Payload)super.clone();
      }
   }
}
