package com.replaymod.lib.org.mortbay.jetty.security;

import com.replaymod.lib.org.mortbay.jetty.Request;
import com.replaymod.lib.org.mortbay.jetty.Response;
import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.util.QuotedStringTokenizer;
import com.replaymod.lib.org.mortbay.util.StringUtil;
import com.replaymod.lib.org.mortbay.util.TypeUtil;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.Principal;

public class DigestAuthenticator implements Authenticator {
   protected long maxNonceAge = 0L;
   protected long nonceSecret = (long)this.hashCode() ^ System.currentTimeMillis();
   protected boolean useStale = false;

   public Principal authenticate(UserRealm realm, String pathInContext, Request request, Response response) throws IOException {
      boolean stale = false;
      Principal user = null;
      String credentials = request.getHeader("Authorization");
      if (credentials != null) {
         if (Log.isDebugEnabled()) {
            Log.debug("Credentials: " + credentials);
         }

         QuotedStringTokenizer tokenizer = new QuotedStringTokenizer(credentials, "=, ", true, false);
         DigestAuthenticator.Digest digest = new DigestAuthenticator.Digest(request.getMethod());
         String last = null;
         String name = null;

         while(tokenizer.hasMoreTokens()) {
            String tok = tokenizer.nextToken();
            char c = tok.length() == 1 ? tok.charAt(0) : 0;
            switch(c) {
            case ' ':
               break;
            case ',':
               name = null;
               break;
            case '=':
               name = last;
               last = tok;
               break;
            default:
               last = tok;
               if (name != null) {
                  if ("username".equalsIgnoreCase(name)) {
                     digest.username = tok;
                  } else if ("realm".equalsIgnoreCase(name)) {
                     digest.realm = tok;
                  } else if ("nonce".equalsIgnoreCase(name)) {
                     digest.nonce = tok;
                  } else if ("nc".equalsIgnoreCase(name)) {
                     digest.nc = tok;
                  } else if ("cnonce".equalsIgnoreCase(name)) {
                     digest.cnonce = tok;
                  } else if ("qop".equalsIgnoreCase(name)) {
                     digest.qop = tok;
                  } else if ("uri".equalsIgnoreCase(name)) {
                     digest.uri = tok;
                  } else if ("response".equalsIgnoreCase(name)) {
                     digest.response = tok;
                  }

                  name = null;
               }
            }
         }

         int n = this.checkNonce(digest.nonce, request);
         if (n > 0) {
            user = realm.authenticate(digest.username, digest, request);
         } else if (n == 0) {
            stale = true;
         }

         if (user == null) {
            Log.warn("AUTH FAILURE: user " + StringUtil.printable(digest.username));
         } else {
            request.setAuthType("DIGEST");
            request.setUserPrincipal(user);
         }
      }

      if (user == null && response != null) {
         this.sendChallenge(realm, request, response, stale);
      }

      return user;
   }

   public String getAuthMethod() {
      return "DIGEST";
   }

   public void sendChallenge(UserRealm realm, Request request, Response response, boolean stale) throws IOException {
      String domain = request.getContextPath();
      if (domain == null) {
         domain = "/";
      }

      response.setHeader("WWW-Authenticate", "Digest realm=\"" + realm.getName() + "\", domain=\"" + domain + "\", nonce=\"" + this.newNonce(request) + "\", algorithm=MD5, qop=\"auth\"" + (this.useStale ? " stale=" + stale : ""));
      response.sendError(401);
   }

   public String newNonce(Request request) {
      long ts = request.getTimeStamp();
      long sk = this.nonceSecret;
      byte[] nounce = new byte[24];

      for(int i = 0; i < 8; ++i) {
         nounce[i] = (byte)((int)(ts & 255L));
         ts >>= 8;
         nounce[8 + i] = (byte)((int)(sk & 255L));
         sk >>= 8;
      }

      byte[] hash = null;

      try {
         MessageDigest md = MessageDigest.getInstance("MD5");
         md.reset();
         md.update(nounce, 0, 16);
         hash = md.digest();
      } catch (Exception var9) {
         Log.warn((Throwable)var9);
      }

      for(int i = 0; i < hash.length; ++i) {
         nounce[8 + i] = hash[i];
         if (i == 23) {
            break;
         }
      }

      return new String(B64Code.encode(nounce));
   }

   public int checkNonce(String nonce, Request request) {
      try {
         byte[] n = B64Code.decode(nonce.toCharArray());
         if (n.length != 24) {
            return -1;
         } else {
            long ts = 0L;
            long sk = this.nonceSecret;
            byte[] n2 = new byte[16];
            System.arraycopy(n, 0, n2, 0, 8);

            for(int i = 0; i < 8; ++i) {
               n2[8 + i] = (byte)((int)(sk & 255L));
               sk >>= 8;
               ts = (ts << 8) + (255L & (long)n[7 - i]);
            }

            long age = request.getTimeStamp() - ts;
            if (Log.isDebugEnabled()) {
               Log.debug("age=" + age);
            }

            byte[] hash = null;

            try {
               MessageDigest md = MessageDigest.getInstance("MD5");
               md.reset();
               md.update(n2, 0, 16);
               hash = md.digest();
            } catch (Exception var13) {
               Log.warn((Throwable)var13);
            }

            for(int i = 0; i < 16; ++i) {
               if (n[i + 8] != hash[i]) {
                  return -1;
               }
            }

            return this.maxNonceAge <= 0L || age >= 0L && age <= this.maxNonceAge ? 1 : 0;
         }
      } catch (Exception var14) {
         Log.ignore(var14);
         return -1;
      }
   }

   public long getMaxNonceAge() {
      return this.maxNonceAge;
   }

   public void setMaxNonceAge(long maxNonceAge) {
      this.maxNonceAge = maxNonceAge;
   }

   public long getNonceSecret() {
      return this.nonceSecret;
   }

   public void setNonceSecret(long nonceSecret) {
      this.nonceSecret = nonceSecret;
   }

   public void setUseStale(boolean us) {
      this.useStale = us;
   }

   public boolean getUseStale() {
      return this.useStale;
   }

   private static class Digest extends Credential {
      String method = null;
      String username = null;
      String realm = null;
      String nonce = null;
      String nc = null;
      String cnonce = null;
      String qop = null;
      String uri = null;
      String response = null;

      Digest(String m) {
         this.method = m;
      }

      public boolean check(Object credentials) {
         String password = credentials instanceof String ? (String)credentials : credentials.toString();

         try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] ha1;
            if (credentials instanceof Credential.MD5) {
               ha1 = ((Credential.MD5)credentials).getDigest();
            } else {
               md.update(this.username.getBytes(StringUtil.__ISO_8859_1));
               md.update((byte)58);
               md.update(this.realm.getBytes(StringUtil.__ISO_8859_1));
               md.update((byte)58);
               md.update(password.getBytes(StringUtil.__ISO_8859_1));
               ha1 = md.digest();
            }

            md.reset();
            md.update(this.method.getBytes(StringUtil.__ISO_8859_1));
            md.update((byte)58);
            md.update(this.uri.getBytes(StringUtil.__ISO_8859_1));
            byte[] ha2 = md.digest();
            md.update(TypeUtil.toString(ha1, 16).getBytes(StringUtil.__ISO_8859_1));
            md.update((byte)58);
            md.update(this.nonce.getBytes(StringUtil.__ISO_8859_1));
            md.update((byte)58);
            md.update(this.nc.getBytes(StringUtil.__ISO_8859_1));
            md.update((byte)58);
            md.update(this.cnonce.getBytes(StringUtil.__ISO_8859_1));
            md.update((byte)58);
            md.update(this.qop.getBytes(StringUtil.__ISO_8859_1));
            md.update((byte)58);
            md.update(TypeUtil.toString(ha2, 16).getBytes(StringUtil.__ISO_8859_1));
            byte[] digest = md.digest();
            return TypeUtil.toString(digest, 16).equalsIgnoreCase(this.response);
         } catch (Exception var7) {
            Log.warn((Throwable)var7);
            return false;
         }
      }

      public String toString() {
         return this.username + "," + this.response;
      }
   }
}
