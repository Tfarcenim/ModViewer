package com.replaymod.lib.com.google.api.client.googleapis;

import com.replaymod.lib.com.google.api.client.util.SecurityUtils;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;

public final class GoogleUtils {
   public static final Integer MAJOR_VERSION = 1;
   public static final Integer MINOR_VERSION = 22;
   public static final Integer BUGFIX_VERSION = 0;
   public static final String VERSION;
   static KeyStore certTrustStore;

   public static synchronized KeyStore getCertificateTrustStore() throws IOException, GeneralSecurityException {
      if (certTrustStore == null) {
         certTrustStore = SecurityUtils.getJavaKeyStore();
         InputStream keyStoreStream = GoogleUtils.class.getResourceAsStream("google.jks");
         SecurityUtils.loadKeyStore(certTrustStore, keyStoreStream, "notasecret");
      }

      return certTrustStore;
   }

   private GoogleUtils() {
   }

   static {
      VERSION = (MAJOR_VERSION + "." + MINOR_VERSION + "." + BUGFIX_VERSION + "").toString();
   }
}
