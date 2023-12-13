package com.replaymod.lib.com.google.api.client.auth.oauth2;

import com.replaymod.lib.com.google.api.client.http.GenericUrl;
import com.replaymod.lib.com.google.api.client.http.HttpExecuteInterceptor;
import com.replaymod.lib.com.google.api.client.http.HttpRequest;
import com.replaymod.lib.com.google.api.client.http.HttpRequestInitializer;
import com.replaymod.lib.com.google.api.client.http.HttpResponse;
import com.replaymod.lib.com.google.api.client.http.HttpTransport;
import com.replaymod.lib.com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.replaymod.lib.com.google.api.client.json.JsonFactory;
import com.replaymod.lib.com.google.api.client.util.Clock;
import com.replaymod.lib.com.google.api.client.util.Lists;
import com.replaymod.lib.com.google.api.client.util.Objects;
import com.replaymod.lib.com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Credential implements HttpExecuteInterceptor, HttpRequestInitializer, HttpUnsuccessfulResponseHandler {
   static final Logger LOGGER = Logger.getLogger(Credential.class.getName());
   private final Lock lock;
   private final Credential.AccessMethod method;
   private final Clock clock;
   private String accessToken;
   private Long expirationTimeMilliseconds;
   private String refreshToken;
   private final HttpTransport transport;
   private final HttpExecuteInterceptor clientAuthentication;
   private final JsonFactory jsonFactory;
   private final String tokenServerEncodedUrl;
   private final Collection<CredentialRefreshListener> refreshListeners;
   private final HttpRequestInitializer requestInitializer;

   public Credential(Credential.AccessMethod method) {
      this(new Credential.Builder(method));
   }

   protected Credential(Credential.Builder builder) {
      this.lock = new ReentrantLock();
      this.method = (Credential.AccessMethod)Preconditions.checkNotNull(builder.method);
      this.transport = builder.transport;
      this.jsonFactory = builder.jsonFactory;
      this.tokenServerEncodedUrl = builder.tokenServerUrl == null ? null : builder.tokenServerUrl.build();
      this.clientAuthentication = builder.clientAuthentication;
      this.requestInitializer = builder.requestInitializer;
      this.refreshListeners = Collections.unmodifiableCollection(builder.refreshListeners);
      this.clock = (Clock)Preconditions.checkNotNull(builder.clock);
   }

   public void intercept(HttpRequest request) throws IOException {
      this.lock.lock();

      try {
         Long expiresIn = this.getExpiresInSeconds();
         if (this.accessToken == null || expiresIn != null && expiresIn <= 60L) {
            this.refreshToken();
            if (this.accessToken == null) {
               return;
            }
         }

         this.method.intercept(request, this.accessToken);
      } finally {
         this.lock.unlock();
      }

   }

   public boolean handleResponse(HttpRequest request, HttpResponse response, boolean supportsRetry) {
      boolean refreshToken = false;
      boolean bearer = false;
      List<String> authenticateList = response.getHeaders().getAuthenticateAsList();
      if (authenticateList != null) {
         Iterator i$ = authenticateList.iterator();

         while(i$.hasNext()) {
            String authenticate = (String)i$.next();
            if (authenticate.startsWith("Bearer ")) {
               bearer = true;
               refreshToken = BearerToken.INVALID_TOKEN_ERROR.matcher(authenticate).find();
               break;
            }
         }
      }

      if (!bearer) {
         refreshToken = response.getStatusCode() == 401;
      }

      if (refreshToken) {
         try {
            this.lock.lock();

            boolean var14;
            try {
               var14 = !Objects.equal(this.accessToken, this.method.getAccessTokenFromRequest(request)) || this.refreshToken();
            } finally {
               this.lock.unlock();
            }

            return var14;
         } catch (IOException var13) {
            LOGGER.log(Level.SEVERE, "unable to refresh token", var13);
         }
      }

      return false;
   }

   public void initialize(HttpRequest request) throws IOException {
      request.setInterceptor(this);
      request.setUnsuccessfulResponseHandler(this);
   }

   public final String getAccessToken() {
      this.lock.lock();

      String var1;
      try {
         var1 = this.accessToken;
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public Credential setAccessToken(String accessToken) {
      this.lock.lock();

      try {
         this.accessToken = accessToken;
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   public final Credential.AccessMethod getMethod() {
      return this.method;
   }

   public final Clock getClock() {
      return this.clock;
   }

   public final HttpTransport getTransport() {
      return this.transport;
   }

   public final JsonFactory getJsonFactory() {
      return this.jsonFactory;
   }

   public final String getTokenServerEncodedUrl() {
      return this.tokenServerEncodedUrl;
   }

   public final String getRefreshToken() {
      this.lock.lock();

      String var1;
      try {
         var1 = this.refreshToken;
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public Credential setRefreshToken(String refreshToken) {
      this.lock.lock();

      try {
         if (refreshToken != null) {
            Preconditions.checkArgument(this.jsonFactory != null && this.transport != null && this.clientAuthentication != null && this.tokenServerEncodedUrl != null, "Please use the Builder and call setJsonFactory, setTransport, setClientAuthentication and setTokenServerUrl/setTokenServerEncodedUrl");
         }

         this.refreshToken = refreshToken;
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   public final Long getExpirationTimeMilliseconds() {
      this.lock.lock();

      Long var1;
      try {
         var1 = this.expirationTimeMilliseconds;
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public Credential setExpirationTimeMilliseconds(Long expirationTimeMilliseconds) {
      this.lock.lock();

      try {
         this.expirationTimeMilliseconds = expirationTimeMilliseconds;
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   public final Long getExpiresInSeconds() {
      this.lock.lock();

      Long var1;
      try {
         if (this.expirationTimeMilliseconds == null) {
            var1 = null;
            return var1;
         }

         var1 = (this.expirationTimeMilliseconds - this.clock.currentTimeMillis()) / 1000L;
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public Credential setExpiresInSeconds(Long expiresIn) {
      return this.setExpirationTimeMilliseconds(expiresIn == null ? null : this.clock.currentTimeMillis() + expiresIn * 1000L);
   }

   public final HttpExecuteInterceptor getClientAuthentication() {
      return this.clientAuthentication;
   }

   public final HttpRequestInitializer getRequestInitializer() {
      return this.requestInitializer;
   }

   public final boolean refreshToken() throws IOException {
      this.lock.lock();

      try {
         boolean statusCode4xx;
         try {
            TokenResponse tokenResponse = this.executeRefreshToken();
            if (tokenResponse != null) {
               this.setFromTokenResponse(tokenResponse);
               Iterator i$ = this.refreshListeners.iterator();

               while(i$.hasNext()) {
                  CredentialRefreshListener refreshListener = (CredentialRefreshListener)i$.next();
                  refreshListener.onTokenResponse(this, tokenResponse);
               }

               statusCode4xx = true;
               return statusCode4xx;
            }
         } catch (TokenResponseException var8) {
            TokenResponseException e = var8;
            statusCode4xx = 400 <= var8.getStatusCode() && var8.getStatusCode() < 500;
            if (var8.getDetails() != null && statusCode4xx) {
               this.setAccessToken((String)null);
               this.setExpiresInSeconds((Long)null);
            }

            Iterator i$ = this.refreshListeners.iterator();

            while(true) {
               if (!i$.hasNext()) {
                  if (statusCode4xx) {
                     throw e;
                  }
                  break;
               }

               CredentialRefreshListener refreshListener = (CredentialRefreshListener)i$.next();
               refreshListener.onTokenErrorResponse(this, e.getDetails());
            }
         }

         boolean var11 = false;
         return var11;
      } finally {
         this.lock.unlock();
      }
   }

   public Credential setFromTokenResponse(TokenResponse tokenResponse) {
      this.setAccessToken(tokenResponse.getAccessToken());
      if (tokenResponse.getRefreshToken() != null) {
         this.setRefreshToken(tokenResponse.getRefreshToken());
      }

      this.setExpiresInSeconds(tokenResponse.getExpiresInSeconds());
      return this;
   }

   protected TokenResponse executeRefreshToken() throws IOException {
      return this.refreshToken == null ? null : (new RefreshTokenRequest(this.transport, this.jsonFactory, new GenericUrl(this.tokenServerEncodedUrl), this.refreshToken)).setClientAuthentication(this.clientAuthentication).setRequestInitializer(this.requestInitializer).execute();
   }

   public final Collection<CredentialRefreshListener> getRefreshListeners() {
      return this.refreshListeners;
   }

   public static class Builder {
      final Credential.AccessMethod method;
      HttpTransport transport;
      JsonFactory jsonFactory;
      GenericUrl tokenServerUrl;
      Clock clock;
      HttpExecuteInterceptor clientAuthentication;
      HttpRequestInitializer requestInitializer;
      Collection<CredentialRefreshListener> refreshListeners;

      public Builder(Credential.AccessMethod method) {
         this.clock = Clock.SYSTEM;
         this.refreshListeners = Lists.newArrayList();
         this.method = (Credential.AccessMethod)Preconditions.checkNotNull(method);
      }

      public Credential build() {
         return new Credential(this);
      }

      public final Credential.AccessMethod getMethod() {
         return this.method;
      }

      public final HttpTransport getTransport() {
         return this.transport;
      }

      public Credential.Builder setTransport(HttpTransport transport) {
         this.transport = transport;
         return this;
      }

      public final Clock getClock() {
         return this.clock;
      }

      public Credential.Builder setClock(Clock clock) {
         this.clock = (Clock)Preconditions.checkNotNull(clock);
         return this;
      }

      public final JsonFactory getJsonFactory() {
         return this.jsonFactory;
      }

      public Credential.Builder setJsonFactory(JsonFactory jsonFactory) {
         this.jsonFactory = jsonFactory;
         return this;
      }

      public final GenericUrl getTokenServerUrl() {
         return this.tokenServerUrl;
      }

      public Credential.Builder setTokenServerUrl(GenericUrl tokenServerUrl) {
         this.tokenServerUrl = tokenServerUrl;
         return this;
      }

      public Credential.Builder setTokenServerEncodedUrl(String tokenServerEncodedUrl) {
         this.tokenServerUrl = tokenServerEncodedUrl == null ? null : new GenericUrl(tokenServerEncodedUrl);
         return this;
      }

      public final HttpExecuteInterceptor getClientAuthentication() {
         return this.clientAuthentication;
      }

      public Credential.Builder setClientAuthentication(HttpExecuteInterceptor clientAuthentication) {
         this.clientAuthentication = clientAuthentication;
         return this;
      }

      public final HttpRequestInitializer getRequestInitializer() {
         return this.requestInitializer;
      }

      public Credential.Builder setRequestInitializer(HttpRequestInitializer requestInitializer) {
         this.requestInitializer = requestInitializer;
         return this;
      }

      public Credential.Builder addRefreshListener(CredentialRefreshListener refreshListener) {
         this.refreshListeners.add(Preconditions.checkNotNull(refreshListener));
         return this;
      }

      public final Collection<CredentialRefreshListener> getRefreshListeners() {
         return this.refreshListeners;
      }

      public Credential.Builder setRefreshListeners(Collection<CredentialRefreshListener> refreshListeners) {
         this.refreshListeners = (Collection)Preconditions.checkNotNull(refreshListeners);
         return this;
      }
   }

   public interface AccessMethod {
      void intercept(HttpRequest var1, String var2) throws IOException;

      String getAccessTokenFromRequest(HttpRequest var1);
   }
}
