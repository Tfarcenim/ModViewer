package com.replaymod.lib.com.google.api.client.http.javanet;

import com.replaymod.lib.com.google.api.client.http.HttpTransport;
import com.replaymod.lib.com.google.api.client.util.Beta;
import com.replaymod.lib.com.google.api.client.util.Preconditions;
import com.replaymod.lib.com.google.api.client.util.SecurityUtils;
import com.replaymod.lib.com.google.api.client.util.SslUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public final class NetHttpTransport extends HttpTransport {
   private static final String[] SUPPORTED_METHODS = new String[]{"DELETE", "GET", "HEAD", "OPTIONS", "POST", "PUT", "TRACE"};
   private final ConnectionFactory connectionFactory;
   private final SSLSocketFactory sslSocketFactory;
   private final HostnameVerifier hostnameVerifier;

   public NetHttpTransport() {
      this((ConnectionFactory)((ConnectionFactory)null), (SSLSocketFactory)null, (HostnameVerifier)null);
   }

   NetHttpTransport(Proxy proxy, SSLSocketFactory sslSocketFactory, HostnameVerifier hostnameVerifier) {
      this((ConnectionFactory)(new DefaultConnectionFactory(proxy)), sslSocketFactory, hostnameVerifier);
   }

   NetHttpTransport(ConnectionFactory connectionFactory, SSLSocketFactory sslSocketFactory, HostnameVerifier hostnameVerifier) {
      this.connectionFactory = (ConnectionFactory)(connectionFactory == null ? new DefaultConnectionFactory() : connectionFactory);
      this.sslSocketFactory = sslSocketFactory;
      this.hostnameVerifier = hostnameVerifier;
   }

   public boolean supportsMethod(String method) {
      return Arrays.binarySearch(SUPPORTED_METHODS, method) >= 0;
   }

   protected NetHttpRequest buildRequest(String method, String url) throws IOException {
      Preconditions.checkArgument(this.supportsMethod(method), "HTTP method %s not supported", method);
      URL connUrl = new URL(url);
      HttpURLConnection connection = this.connectionFactory.openConnection(connUrl);
      connection.setRequestMethod(method);
      if (connection instanceof HttpsURLConnection) {
         HttpsURLConnection secureConnection = (HttpsURLConnection)connection;
         if (this.hostnameVerifier != null) {
            secureConnection.setHostnameVerifier(this.hostnameVerifier);
         }

         if (this.sslSocketFactory != null) {
            secureConnection.setSSLSocketFactory(this.sslSocketFactory);
         }
      }

      return new NetHttpRequest(connection);
   }

   static {
      Arrays.sort(SUPPORTED_METHODS);
   }

   public static final class Builder {
      private SSLSocketFactory sslSocketFactory;
      private HostnameVerifier hostnameVerifier;
      private Proxy proxy;
      private ConnectionFactory connectionFactory;

      public NetHttpTransport.Builder setProxy(Proxy proxy) {
         this.proxy = proxy;
         return this;
      }

      public NetHttpTransport.Builder setConnectionFactory(ConnectionFactory connectionFactory) {
         this.connectionFactory = connectionFactory;
         return this;
      }

      public NetHttpTransport.Builder trustCertificatesFromJavaKeyStore(InputStream keyStoreStream, String storePass) throws GeneralSecurityException, IOException {
         KeyStore trustStore = SecurityUtils.getJavaKeyStore();
         SecurityUtils.loadKeyStore(trustStore, keyStoreStream, storePass);
         return this.trustCertificates(trustStore);
      }

      public NetHttpTransport.Builder trustCertificatesFromStream(InputStream certificateStream) throws GeneralSecurityException, IOException {
         KeyStore trustStore = SecurityUtils.getJavaKeyStore();
         trustStore.load((InputStream)null, (char[])null);
         SecurityUtils.loadKeyStoreFromCertificates(trustStore, SecurityUtils.getX509CertificateFactory(), certificateStream);
         return this.trustCertificates(trustStore);
      }

      public NetHttpTransport.Builder trustCertificates(KeyStore trustStore) throws GeneralSecurityException {
         SSLContext sslContext = SslUtils.getTlsSslContext();
         SslUtils.initSslContext(sslContext, trustStore, SslUtils.getPkixTrustManagerFactory());
         return this.setSslSocketFactory(sslContext.getSocketFactory());
      }

      @Beta
      public NetHttpTransport.Builder doNotValidateCertificate() throws GeneralSecurityException {
         this.hostnameVerifier = SslUtils.trustAllHostnameVerifier();
         this.sslSocketFactory = SslUtils.trustAllSSLContext().getSocketFactory();
         return this;
      }

      public SSLSocketFactory getSslSocketFactory() {
         return this.sslSocketFactory;
      }

      public NetHttpTransport.Builder setSslSocketFactory(SSLSocketFactory sslSocketFactory) {
         this.sslSocketFactory = sslSocketFactory;
         return this;
      }

      public HostnameVerifier getHostnameVerifier() {
         return this.hostnameVerifier;
      }

      public NetHttpTransport.Builder setHostnameVerifier(HostnameVerifier hostnameVerifier) {
         this.hostnameVerifier = hostnameVerifier;
         return this;
      }

      public NetHttpTransport build() {
         return this.proxy == null ? new NetHttpTransport(this.connectionFactory, this.sslSocketFactory, this.hostnameVerifier) : new NetHttpTransport(this.proxy, this.sslSocketFactory, this.hostnameVerifier);
      }
   }
}
