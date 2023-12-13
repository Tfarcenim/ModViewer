package com.replaymod.lib.org.mortbay.jetty.security;

import com.replaymod.lib.org.mortbay.jetty.Request;
import com.replaymod.lib.org.mortbay.jetty.Response;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.X509Certificate;

public class ClientCertAuthenticator implements Authenticator {
   private int _maxHandShakeSeconds = 60;

   public int getMaxHandShakeSeconds() {
      return this._maxHandShakeSeconds;
   }

   public void setMaxHandShakeSeconds(int maxHandShakeSeconds) {
      this._maxHandShakeSeconds = maxHandShakeSeconds;
   }

   public Principal authenticate(UserRealm realm, String pathInContext, Request request, Response response) throws IOException {
      X509Certificate[] certs = (X509Certificate[])((X509Certificate[])request.getAttribute("javax.servlet.request.X509Certificate"));
      if (certs != null && certs.length != 0 && certs[0] != null) {
         Principal principal = certs[0].getSubjectDN();
         if (principal == null) {
            principal = certs[0].getIssuerDN();
         }

         String username = principal == null ? "clientcert" : principal.getName();
         Principal user = realm.authenticate(username, certs, request);
         if (user == null) {
            if (response != null) {
               response.sendError(403, "The provided client certificate does not correspond to a trusted user.");
            }

            return null;
         } else {
            request.setAuthType("CLIENT_CERT");
            request.setUserPrincipal(user);
            return user;
         }
      } else {
         if (response != null) {
            response.sendError(403, "A client certificate is required for accessing this web application but the server's listener is not configured for mutual authentication (or the client did not provide a certificate).");
         }

         return null;
      }
   }

   public String getAuthMethod() {
      return "CLIENT_CERT";
   }
}
