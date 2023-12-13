package com.replaymod.lib.com.google.api.client.auth.openidconnect;

import com.replaymod.lib.com.google.api.client.util.Beta;
import com.replaymod.lib.com.google.api.client.util.Clock;
import com.replaymod.lib.com.google.api.client.util.Preconditions;
import java.util.Collection;
import java.util.Collections;

@Beta
public class IdTokenVerifier {
   public static final long DEFAULT_TIME_SKEW_SECONDS = 300L;
   private final Clock clock;
   private final long acceptableTimeSkewSeconds;
   private final Collection<String> issuers;
   private final Collection<String> audience;

   public IdTokenVerifier() {
      this(new IdTokenVerifier.Builder());
   }

   protected IdTokenVerifier(IdTokenVerifier.Builder builder) {
      this.clock = builder.clock;
      this.acceptableTimeSkewSeconds = builder.acceptableTimeSkewSeconds;
      this.issuers = builder.issuers == null ? null : Collections.unmodifiableCollection(builder.issuers);
      this.audience = builder.audience == null ? null : Collections.unmodifiableCollection(builder.audience);
   }

   public final Clock getClock() {
      return this.clock;
   }

   public final long getAcceptableTimeSkewSeconds() {
      return this.acceptableTimeSkewSeconds;
   }

   public final String getIssuer() {
      return this.issuers == null ? null : (String)this.issuers.iterator().next();
   }

   public final Collection<String> getIssuers() {
      return this.issuers;
   }

   public final Collection<String> getAudience() {
      return this.audience;
   }

   public boolean verify(IdToken idToken) {
      return (this.issuers == null || idToken.verifyIssuer(this.issuers)) && (this.audience == null || idToken.verifyAudience(this.audience)) && idToken.verifyTime(this.clock.currentTimeMillis(), this.acceptableTimeSkewSeconds);
   }

   @Beta
   public static class Builder {
      Clock clock;
      long acceptableTimeSkewSeconds;
      Collection<String> issuers;
      Collection<String> audience;

      public Builder() {
         this.clock = Clock.SYSTEM;
         this.acceptableTimeSkewSeconds = 300L;
      }

      public IdTokenVerifier build() {
         return new IdTokenVerifier(this);
      }

      public final Clock getClock() {
         return this.clock;
      }

      public IdTokenVerifier.Builder setClock(Clock clock) {
         this.clock = (Clock)Preconditions.checkNotNull(clock);
         return this;
      }

      public final String getIssuer() {
         return this.issuers == null ? null : (String)this.issuers.iterator().next();
      }

      public IdTokenVerifier.Builder setIssuer(String issuer) {
         return issuer == null ? this.setIssuers((Collection)null) : this.setIssuers(Collections.singleton(issuer));
      }

      public final Collection<String> getIssuers() {
         return this.issuers;
      }

      public IdTokenVerifier.Builder setIssuers(Collection<String> issuers) {
         Preconditions.checkArgument(issuers == null || !issuers.isEmpty(), "Issuers must not be empty");
         this.issuers = issuers;
         return this;
      }

      public final Collection<String> getAudience() {
         return this.audience;
      }

      public IdTokenVerifier.Builder setAudience(Collection<String> audience) {
         this.audience = audience;
         return this;
      }

      public final long getAcceptableTimeSkewSeconds() {
         return this.acceptableTimeSkewSeconds;
      }

      public IdTokenVerifier.Builder setAcceptableTimeSkewSeconds(long acceptableTimeSkewSeconds) {
         Preconditions.checkArgument(acceptableTimeSkewSeconds >= 0L);
         this.acceptableTimeSkewSeconds = acceptableTimeSkewSeconds;
         return this;
      }
   }
}
