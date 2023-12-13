package com.replaymod.lib.org.mortbay.jetty.security;

import com.replaymod.lib.org.mortbay.jetty.Request;
import com.replaymod.lib.org.mortbay.jetty.Response;
import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.util.StringUtil;
import java.io.IOException;
import java.security.Principal;

public class BasicAuthenticator implements Authenticator {
   public Principal authenticate(UserRealm realm, String pathInContext, Request request, Response response) throws IOException {
      Principal user = null;
      String credentials = request.getHeader("Authorization");
      if (credentials != null) {
         try {
            if (Log.isDebugEnabled()) {
               Log.debug("Credentials: " + credentials);
            }

            credentials = credentials.substring(credentials.indexOf(32) + 1);
            credentials = B64Code.decode(credentials, StringUtil.__ISO_8859_1);
            int i = credentials.indexOf(58);
            String username = credentials.substring(0, i);
            String password = credentials.substring(i + 1);
            user = realm.authenticate(username, password, request);
            if (user == null) {
               Log.warn("AUTH FAILURE: user {}", (Object)StringUtil.printable(username));
            } else {
               request.setAuthType("BASIC");
               request.setUserPrincipal(user);
            }
         } catch (Exception var10) {
            Log.warn("AUTH FAILURE: " + var10.toString());
            Log.ignore(var10);
         }
      }

      if (user == null && response != null) {
         this.sendChallenge(realm, response);
      }

      return user;
   }

   public String getAuthMethod() {
      return "BASIC";
   }

   public void sendChallenge(UserRealm realm, Response response) throws IOException {
      response.setHeader("WWW-Authenticate", "Basic realm=\"" + realm.getName() + '"');
      response.sendError(401);
   }
}
