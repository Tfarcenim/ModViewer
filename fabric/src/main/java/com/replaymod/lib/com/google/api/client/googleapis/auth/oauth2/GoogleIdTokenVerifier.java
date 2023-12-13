package com.replaymod.lib.com.google.api.client.googleapis.auth.oauth2;

import com.replaymod.lib.com.google.api.client.auth.openidconnect.IdTokenVerifier;
import com.replaymod.lib.com.google.api.client.http.HttpTransport;
import com.replaymod.lib.com.google.api.client.json.JsonFactory;
import com.replaymod.lib.com.google.api.client.util.Beta;
import com.replaymod.lib.com.google.api.client.util.Clock;
import com.replaymod.lib.com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Beta
public class GoogleIdTokenVerifier extends IdTokenVerifier {
   private final GooglePublicKeysManager publicKeys;

   public GoogleIdTokenVerifier(HttpTransport transport, JsonFactory jsonFactory) {
      this(new GoogleIdTokenVerifier.Builder(transport, jsonFactory));
   }

   public GoogleIdTokenVerifier(GooglePublicKeysManager publicKeys) {
      this(new GoogleIdTokenVerifier.Builder(publicKeys));
   }

   protected GoogleIdTokenVerifier(GoogleIdTokenVerifier.Builder builder) {
      super(builder);
      this.publicKeys = builder.publicKeys;
   }

   public final GooglePublicKeysManager getPublicKeysManager() {
      return this.publicKeys;
   }

   public final HttpTransport getTransport() {
      return this.publicKeys.getTransport();
   }

   public final JsonFactory getJsonFactory() {
      return this.publicKeys.getJsonFactory();
   }

   /** @deprecated */
   @Deprecated
   public final String getPublicCertsEncodedUrl() {
      return this.publicKeys.getPublicCertsEncodedUrl();
   }

   /** @deprecated */
   @Deprecated
   public final List<PublicKey> getPublicKeys() throws GeneralSecurityException, IOException {
      return this.publicKeys.getPublicKeys();
   }

   /** @deprecated */
   @Deprecated
   public final long getExpirationTimeMilliseconds() {
      return this.publicKeys.getExpirationTimeMilliseconds();
   }

   public boolean verify(GoogleIdToken googleIdToken) throws GeneralSecurityException, IOException {
      if (!super.verify(googleIdToken)) {
         return false;
      } else {
         Iterator i$ = this.publicKeys.getPublicKeys().iterator();

         PublicKey publicKey;
         do {
            if (!i$.hasNext()) {
               return false;
            }

            publicKey = (PublicKey)i$.next();
         } while(!googleIdToken.verifySignature(publicKey));

         return true;
      }
   }

   public GoogleIdToken verify(String idTokenString) throws GeneralSecurityException, IOException {
      GoogleIdToken idToken = GoogleIdToken.parse(this.getJsonFactory(), idTokenString);
      return this.verify(idToken) ? idToken : null;
   }

   /** @deprecated */
   @Deprecated
   public GoogleIdTokenVerifier loadPublicCerts() throws GeneralSecurityException, IOException {
      this.publicKeys.refresh();
      return this;
   }

   @Beta
   public static class Builder extends IdTokenVerifier.Builder {
      GooglePublicKeysManager publicKeys;

      public Builder(HttpTransport transport, JsonFactory jsonFactory) {
         this(new GooglePublicKeysManager(transport, jsonFactory));
      }

      public Builder(GooglePublicKeysManager publicKeys) {
         this.publicKeys = (GooglePublicKeysManager)Preconditions.checkNotNull(publicKeys);
         this.setIssuers(Arrays.asList("accounts.google.com", "https://accounts.google.com"));
      }

      public GoogleIdTokenVerifier build() {
         return new GoogleIdTokenVerifier(this);
      }

      public final GooglePublicKeysManager getPublicCerts() {
         return this.publicKeys;
      }

      public final HttpTransport getTransport() {
         return this.publicKeys.getTransport();
      }

      public final JsonFactory getJsonFactory() {
         return this.publicKeys.getJsonFactory();
      }

      /** @deprecated */
      @Deprecated
      public final String getPublicCertsEncodedUrl() {
         return this.publicKeys.getPublicCertsEncodedUrl();
      }

      /** @deprecated */
      @Deprecated
      public GoogleIdTokenVerifier.Builder setPublicCertsEncodedUrl(String publicKeysEncodedUrl) {
         this.publicKeys = (new GooglePublicKeysManager.Builder(this.getTransport(), this.getJsonFactory())).setPublicCertsEncodedUrl(publicKeysEncodedUrl).setClock(this.publicKeys.getClock()).build();
         return this;
      }

      public GoogleIdTokenVerifier.Builder setIssuer(String issuer) {
         return (GoogleIdTokenVerifier.Builder)super.setIssuer(issuer);
      }

      public GoogleIdTokenVerifier.Builder setIssuers(Collection<String> issuers) {
         return (GoogleIdTokenVerifier.Builder)super.setIssuers(issuers);
      }

      public GoogleIdTokenVerifier.Builder setAudience(Collection<String> audience) {
         return (GoogleIdTokenVerifier.Builder)super.setAudience(audience);
      }

      public GoogleIdTokenVerifier.Builder setAcceptableTimeSkewSeconds(long acceptableTimeSkewSeconds) {
         return (GoogleIdTokenVerifier.Builder)super.setAcceptableTimeSkewSeconds(acceptableTimeSkewSeconds);
      }

      public GoogleIdTokenVerifier.Builder setClock(Clock clock) {
         return (GoogleIdTokenVerifier.Builder)super.setClock(clock);
      }
   }
}
