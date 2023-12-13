package com.replaymod.lib.com.google.api.client.json.webtoken;

import com.replaymod.lib.com.google.api.client.json.JsonFactory;
import com.replaymod.lib.com.google.api.client.util.Base64;
import com.replaymod.lib.com.google.api.client.util.Beta;
import com.replaymod.lib.com.google.api.client.util.Key;
import com.replaymod.lib.com.google.api.client.util.Preconditions;
import com.replaymod.lib.com.google.api.client.util.SecurityUtils;
import com.replaymod.lib.com.google.api.client.util.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class JsonWebSignature extends JsonWebToken {
   private final byte[] signatureBytes;
   private final byte[] signedContentBytes;

   public JsonWebSignature(JsonWebSignature.Header header, JsonWebToken.Payload payload, byte[] signatureBytes, byte[] signedContentBytes) {
      super(header, payload);
      this.signatureBytes = (byte[])Preconditions.checkNotNull(signatureBytes);
      this.signedContentBytes = (byte[])Preconditions.checkNotNull(signedContentBytes);
   }

   public JsonWebSignature.Header getHeader() {
      return (JsonWebSignature.Header)super.getHeader();
   }

   public final boolean verifySignature(PublicKey publicKey) throws GeneralSecurityException {
      Signature signatureAlg = null;
      String algorithm = this.getHeader().getAlgorithm();
      if ("RS256".equals(algorithm)) {
         signatureAlg = SecurityUtils.getSha256WithRsaSignatureAlgorithm();
         return SecurityUtils.verify(signatureAlg, publicKey, this.signatureBytes, this.signedContentBytes);
      } else {
         return false;
      }
   }

   @Beta
   public final X509Certificate verifySignature(X509TrustManager trustManager) throws GeneralSecurityException {
      List<String> x509Certificates = this.getHeader().getX509Certificates();
      if (x509Certificates != null && !x509Certificates.isEmpty()) {
         String algorithm = this.getHeader().getAlgorithm();
         Signature signatureAlg = null;
         if ("RS256".equals(algorithm)) {
            signatureAlg = SecurityUtils.getSha256WithRsaSignatureAlgorithm();
            return SecurityUtils.verify(signatureAlg, trustManager, x509Certificates, this.signatureBytes, this.signedContentBytes);
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   @Beta
   public final X509Certificate verifySignature() throws GeneralSecurityException {
      X509TrustManager trustManager = getDefaultX509TrustManager();
      return trustManager == null ? null : this.verifySignature(trustManager);
   }

   private static X509TrustManager getDefaultX509TrustManager() {
      try {
         TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
         factory.init((KeyStore)null);
         TrustManager[] arr$ = factory.getTrustManagers();
         int len$ = arr$.length;

         for(int i$ = 0; i$ < len$; ++i$) {
            TrustManager manager = arr$[i$];
            if (manager instanceof X509TrustManager) {
               return (X509TrustManager)manager;
            }
         }

         return null;
      } catch (NoSuchAlgorithmException var5) {
         return null;
      } catch (KeyStoreException var6) {
         return null;
      }
   }

   public final byte[] getSignatureBytes() {
      return this.signatureBytes;
   }

   public final byte[] getSignedContentBytes() {
      return this.signedContentBytes;
   }

   public static JsonWebSignature parse(JsonFactory jsonFactory, String tokenString) throws IOException {
      return parser(jsonFactory).parse(tokenString);
   }

   public static JsonWebSignature.Parser parser(JsonFactory jsonFactory) {
      return new JsonWebSignature.Parser(jsonFactory);
   }

   public static String signUsingRsaSha256(PrivateKey privateKey, JsonFactory jsonFactory, JsonWebSignature.Header header, JsonWebToken.Payload payload) throws GeneralSecurityException, IOException {
      String content = Base64.encodeBase64URLSafeString(jsonFactory.toByteArray(header)) + "." + Base64.encodeBase64URLSafeString(jsonFactory.toByteArray(payload));
      byte[] contentBytes = StringUtils.getBytesUtf8(content);
      byte[] signature = SecurityUtils.sign(SecurityUtils.getSha256WithRsaSignatureAlgorithm(), privateKey, contentBytes);
      return content + "." + Base64.encodeBase64URLSafeString(signature);
   }

   public static final class Parser {
      private final JsonFactory jsonFactory;
      private Class<? extends JsonWebSignature.Header> headerClass = JsonWebSignature.Header.class;
      private Class<? extends JsonWebToken.Payload> payloadClass = JsonWebToken.Payload.class;

      public Parser(JsonFactory jsonFactory) {
         this.jsonFactory = (JsonFactory)Preconditions.checkNotNull(jsonFactory);
      }

      public Class<? extends JsonWebSignature.Header> getHeaderClass() {
         return this.headerClass;
      }

      public JsonWebSignature.Parser setHeaderClass(Class<? extends JsonWebSignature.Header> headerClass) {
         this.headerClass = headerClass;
         return this;
      }

      public Class<? extends JsonWebToken.Payload> getPayloadClass() {
         return this.payloadClass;
      }

      public JsonWebSignature.Parser setPayloadClass(Class<? extends JsonWebToken.Payload> payloadClass) {
         this.payloadClass = payloadClass;
         return this;
      }

      public JsonFactory getJsonFactory() {
         return this.jsonFactory;
      }

      public JsonWebSignature parse(String tokenString) throws IOException {
         int firstDot = tokenString.indexOf(46);
         Preconditions.checkArgument(firstDot != -1);
         byte[] headerBytes = Base64.decodeBase64(tokenString.substring(0, firstDot));
         int secondDot = tokenString.indexOf(46, firstDot + 1);
         Preconditions.checkArgument(secondDot != -1);
         Preconditions.checkArgument(tokenString.indexOf(46, secondDot + 1) == -1);
         byte[] payloadBytes = Base64.decodeBase64(tokenString.substring(firstDot + 1, secondDot));
         byte[] signatureBytes = Base64.decodeBase64(tokenString.substring(secondDot + 1));
         byte[] signedContentBytes = StringUtils.getBytesUtf8(tokenString.substring(0, secondDot));
         JsonWebSignature.Header header = (JsonWebSignature.Header)this.jsonFactory.fromInputStream(new ByteArrayInputStream(headerBytes), this.headerClass);
         Preconditions.checkArgument(header.getAlgorithm() != null);
         JsonWebToken.Payload payload = (JsonWebToken.Payload)this.jsonFactory.fromInputStream(new ByteArrayInputStream(payloadBytes), this.payloadClass);
         return new JsonWebSignature(header, payload, signatureBytes, signedContentBytes);
      }
   }

   public static class Header extends JsonWebToken.Header {
      @Key("alg")
      private String algorithm;
      @Key("jku")
      private String jwkUrl;
      @Key("jwk")
      private String jwk;
      @Key("kid")
      private String keyId;
      @Key("x5u")
      private String x509Url;
      @Key("x5t")
      private String x509Thumbprint;
      @Key("x5c")
      private List<String> x509Certificates;
      @Key("crit")
      private List<String> critical;

      public JsonWebSignature.Header setType(String type) {
         super.setType(type);
         return this;
      }

      public final String getAlgorithm() {
         return this.algorithm;
      }

      public JsonWebSignature.Header setAlgorithm(String algorithm) {
         this.algorithm = algorithm;
         return this;
      }

      public final String getJwkUrl() {
         return this.jwkUrl;
      }

      public JsonWebSignature.Header setJwkUrl(String jwkUrl) {
         this.jwkUrl = jwkUrl;
         return this;
      }

      public final String getJwk() {
         return this.jwk;
      }

      public JsonWebSignature.Header setJwk(String jwk) {
         this.jwk = jwk;
         return this;
      }

      public final String getKeyId() {
         return this.keyId;
      }

      public JsonWebSignature.Header setKeyId(String keyId) {
         this.keyId = keyId;
         return this;
      }

      public final String getX509Url() {
         return this.x509Url;
      }

      public JsonWebSignature.Header setX509Url(String x509Url) {
         this.x509Url = x509Url;
         return this;
      }

      public final String getX509Thumbprint() {
         return this.x509Thumbprint;
      }

      public JsonWebSignature.Header setX509Thumbprint(String x509Thumbprint) {
         this.x509Thumbprint = x509Thumbprint;
         return this;
      }

      /** @deprecated */
      @Deprecated
      public final String getX509Certificate() {
         return this.x509Certificates != null && !this.x509Certificates.isEmpty() ? (String)this.x509Certificates.get(0) : null;
      }

      public final List<String> getX509Certificates() {
         return this.x509Certificates;
      }

      /** @deprecated */
      @Deprecated
      public JsonWebSignature.Header setX509Certificate(String x509Certificate) {
         ArrayList<String> x509Certificates = new ArrayList();
         x509Certificates.add(x509Certificate);
         this.x509Certificates = x509Certificates;
         return this;
      }

      public JsonWebSignature.Header setX509Certificates(List<String> x509Certificates) {
         this.x509Certificates = x509Certificates;
         return this;
      }

      public final List<String> getCritical() {
         return this.critical;
      }

      public JsonWebSignature.Header setCritical(List<String> critical) {
         this.critical = critical;
         return this;
      }

      public JsonWebSignature.Header set(String fieldName, Object value) {
         return (JsonWebSignature.Header)super.set(fieldName, value);
      }

      public JsonWebSignature.Header clone() {
         return (JsonWebSignature.Header)super.clone();
      }
   }
}
