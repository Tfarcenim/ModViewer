package com.replaymod.lib.org.mortbay.jetty.security;

import com.replaymod.lib.org.mortbay.jetty.Request;
import com.replaymod.lib.org.mortbay.jetty.Response;
import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.util.StringUtil;
import com.replaymod.lib.org.mortbay.util.URIUtil;
import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class FormAuthenticator implements Authenticator {
   public static final String __J_URI = "com.replaymod.lib.org.mortbay.jetty.URI";
   public static final String __J_AUTHENTICATED = "com.replaymod.lib.org.mortbay.jetty.Auth";
   public static final String __J_SECURITY_CHECK = "/j_security_check";
   public static final String __J_USERNAME = "j_username";
   public static final String __J_PASSWORD = "j_password";
   private String _formErrorPage;
   private String _formErrorPath;
   private String _formLoginPage;
   private String _formLoginPath;

   public String getAuthMethod() {
      return "FORM";
   }

   public void setLoginPage(String path) {
      if (!path.startsWith("/")) {
         Log.warn("form-login-page must start with /");
         path = "/" + path;
      }

      this._formLoginPage = path;
      this._formLoginPath = path;
      if (this._formLoginPath.indexOf(63) > 0) {
         this._formLoginPath = this._formLoginPath.substring(0, this._formLoginPath.indexOf(63));
      }

   }

   public String getLoginPage() {
      return this._formLoginPage;
   }

   public void setErrorPage(String path) {
      if (path != null && path.trim().length() != 0) {
         if (!path.startsWith("/")) {
            Log.warn("form-error-page must start with /");
            path = "/" + path;
         }

         this._formErrorPage = path;
         this._formErrorPath = path;
         if (this._formErrorPath != null && this._formErrorPath.indexOf(63) > 0) {
            this._formErrorPath = this._formErrorPath.substring(0, this._formErrorPath.indexOf(63));
         }
      } else {
         this._formErrorPath = null;
         this._formErrorPage = null;
      }

   }

   public String getErrorPage() {
      return this._formErrorPage;
   }

   public Principal authenticate(UserRealm realm, String pathInContext, Request request, Response response) throws IOException {
      String uri = pathInContext;
      HttpSession session = request.getSession(response != null);
      if (session == null) {
         return null;
      } else {
         FormAuthenticator.FormCredential form_cred;
         if (!this.isJSecurityCheck(pathInContext)) {
            form_cred = (FormAuthenticator.FormCredential)session.getAttribute("com.replaymod.lib.org.mortbay.jetty.Auth");
            if (form_cred != null) {
               if (form_cred._userPrincipal == null) {
                  form_cred.authenticate(realm, request);
                  if (form_cred._userPrincipal != null && realm instanceof SSORealm) {
                     ((SSORealm)realm).setSingleSignOn(request, response, form_cred._userPrincipal, new Password(form_cred._jPassword));
                  }
               } else if (!realm.reauthenticate(form_cred._userPrincipal)) {
                  form_cred._userPrincipal = null;
               }

               if (form_cred._userPrincipal != null) {
                  if (Log.isDebugEnabled()) {
                     Log.debug("FORM Authenticated for " + form_cred._userPrincipal.getName());
                  }

                  request.setAuthType("FORM");
                  request.setUserPrincipal(form_cred._userPrincipal);
                  return form_cred._userPrincipal;
               }

               session.setAttribute("com.replaymod.lib.org.mortbay.jetty.Auth", (Object)null);
            } else if (realm instanceof SSORealm) {
               Credential cred = ((SSORealm)realm).getSingleSignOn(request, response);
               if (request.getUserPrincipal() != null) {
                  form_cred = new FormAuthenticator.FormCredential();
                  form_cred._userPrincipal = request.getUserPrincipal();
                  form_cred._jUserName = form_cred._userPrincipal.getName();
                  if (cred != null) {
                     form_cred._jPassword = cred.toString();
                  }

                  if (Log.isDebugEnabled()) {
                     Log.debug("SSO for " + form_cred._userPrincipal);
                  }

                  request.setAuthType("FORM");
                  session.setAttribute("com.replaymod.lib.org.mortbay.jetty.Auth", form_cred);
                  return form_cred._userPrincipal;
               }
            }

            if (this.isLoginOrErrorPage(pathInContext)) {
               return SecurityHandler.__NOBODY;
            } else {
               if (response != null) {
                  if (request.getQueryString() != null) {
                     uri = pathInContext + "?" + request.getQueryString();
                  }

                  session.setAttribute("com.replaymod.lib.org.mortbay.jetty.URI", request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + URIUtil.addPaths(request.getContextPath(), uri));
                  response.setContentLength(0);
                  response.sendRedirect(response.encodeRedirectURL(URIUtil.addPaths(request.getContextPath(), this._formLoginPage)));
               }

               return null;
            }
         } else {
            form_cred = new FormAuthenticator.FormCredential();
            form_cred.authenticate(realm, request.getParameter("j_username"), request.getParameter("j_password"), request);
            String nuri = (String)session.getAttribute("com.replaymod.lib.org.mortbay.jetty.URI");
            if (nuri == null || nuri.length() == 0) {
               nuri = request.getContextPath();
               if (nuri.length() == 0) {
                  nuri = "/";
               }
            }

            if (form_cred._userPrincipal != null) {
               if (Log.isDebugEnabled()) {
                  Log.debug("Form authentication OK for " + form_cred._jUserName);
               }

               session.removeAttribute("com.replaymod.lib.org.mortbay.jetty.URI");
               request.setAuthType("FORM");
               request.setUserPrincipal(form_cred._userPrincipal);
               session.setAttribute("com.replaymod.lib.org.mortbay.jetty.Auth", form_cred);
               if (realm instanceof SSORealm) {
                  ((SSORealm)realm).setSingleSignOn(request, response, form_cred._userPrincipal, new Password(form_cred._jPassword));
               }

               if (response != null) {
                  response.setContentLength(0);
                  response.sendRedirect(response.encodeRedirectURL(nuri));
               }
            } else {
               if (Log.isDebugEnabled()) {
                  Log.debug("Form authentication FAILED for " + StringUtil.printable(form_cred._jUserName));
               }

               if (response != null) {
                  if (this._formErrorPage == null) {
                     response.sendError(403);
                  } else {
                     response.setContentLength(0);
                     response.sendRedirect(response.encodeRedirectURL(URIUtil.addPaths(request.getContextPath(), this._formErrorPage)));
                  }
               }
            }

            return null;
         }
      }
   }

   public boolean isLoginOrErrorPage(String pathInContext) {
      return pathInContext != null && (pathInContext.equals(this._formErrorPath) || pathInContext.equals(this._formLoginPath));
   }

   public boolean isJSecurityCheck(String uri) {
      int jsc = uri.indexOf("/j_security_check");
      if (jsc < 0) {
         return false;
      } else {
         int e = jsc + "/j_security_check".length();
         if (e == uri.length()) {
            return true;
         } else {
            char c = uri.charAt(e);
            return c == ';' || c == '#' || c == '/' || c == '?';
         }
      }
   }

   private static class FormCredential implements Serializable, HttpSessionBindingListener {
      String _jUserName;
      String _jPassword;
      transient Principal _userPrincipal;
      transient UserRealm _realm;

      private FormCredential() {
      }

      void authenticate(UserRealm realm, String user, String password, Request request) {
         this._jUserName = user;
         this._jPassword = password;
         this._userPrincipal = realm.authenticate(user, password, request);
         if (this._userPrincipal != null) {
            this._realm = realm;
         } else {
            Log.warn("AUTH FAILURE: user {}", (Object)StringUtil.printable(user));
            request.setUserPrincipal((Principal)null);
         }

      }

      void authenticate(UserRealm realm, Request request) {
         this._userPrincipal = realm.authenticate(this._jUserName, this._jPassword, request);
         if (this._userPrincipal != null) {
            this._realm = realm;
         } else {
            Log.warn("AUTH FAILURE: user {}", (Object)StringUtil.printable(this._jUserName));
            request.setUserPrincipal((Principal)null);
         }

      }

      public void valueBound(HttpSessionBindingEvent event) {
      }

      public void valueUnbound(HttpSessionBindingEvent event) {
         if (Log.isDebugEnabled()) {
            Log.debug("Logout " + this._jUserName);
         }

         if (this._realm instanceof SSORealm) {
            ((SSORealm)this._realm).clearSingleSignOn(this._jUserName);
         }

         if (this._realm != null && this._userPrincipal != null) {
            this._realm.logout(this._userPrincipal);
         }

      }

      public int hashCode() {
         return this._jUserName.hashCode() + this._jPassword.hashCode();
      }

      public boolean equals(Object o) {
         if (!(o instanceof FormAuthenticator.FormCredential)) {
            return false;
         } else {
            FormAuthenticator.FormCredential fc = (FormAuthenticator.FormCredential)o;
            return this._jUserName.equals(fc._jUserName) && this._jPassword.equals(fc._jPassword);
         }
      }

      public String toString() {
         return "Cred[" + this._jUserName + "]";
      }

      // $FF: synthetic method
      FormCredential(Object x0) {
         this();
      }
   }
}
