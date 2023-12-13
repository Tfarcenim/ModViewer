package com.replaymod.lib.org.mortbay.jetty.security;

import com.replaymod.lib.org.mortbay.jetty.Connector;
import com.replaymod.lib.org.mortbay.jetty.HttpConnection;
import com.replaymod.lib.org.mortbay.jetty.Request;
import com.replaymod.lib.org.mortbay.jetty.Response;
import com.replaymod.lib.org.mortbay.jetty.handler.HandlerWrapper;
import com.replaymod.lib.org.mortbay.jetty.servlet.PathMap;
import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.util.LazyList;
import com.replaymod.lib.org.mortbay.util.StringUtil;
import java.io.IOException;
import java.security.Principal;
import java.util.Map.Entry;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityHandler extends HandlerWrapper {
   private String _authMethod = "BASIC";
   private UserRealm _userRealm;
   private ConstraintMapping[] _constraintMappings;
   private PathMap _constraintMap = new PathMap();
   private Authenticator _authenticator;
   private SecurityHandler.NotChecked _notChecked = new SecurityHandler.NotChecked();
   private boolean _checkWelcomeFiles = false;
   public static Principal __NO_USER = new Principal() {
      public String getName() {
         return null;
      }

      public String toString() {
         return "No User";
      }
   };
   public static Principal __NOBODY = new Principal() {
      public String getName() {
         return "Nobody";
      }

      public String toString() {
         return this.getName();
      }
   };

   public Authenticator getAuthenticator() {
      return this._authenticator;
   }

   public void setAuthenticator(Authenticator authenticator) {
      this._authenticator = authenticator;
   }

   public UserRealm getUserRealm() {
      return this._userRealm;
   }

   public void setUserRealm(UserRealm userRealm) {
      this._userRealm = userRealm;
   }

   public ConstraintMapping[] getConstraintMappings() {
      return this._constraintMappings;
   }

   public void setConstraintMappings(ConstraintMapping[] constraintMappings) {
      this._constraintMappings = constraintMappings;
      if (this._constraintMappings != null) {
         this._constraintMappings = constraintMappings;
         this._constraintMap.clear();

         for(int i = 0; i < this._constraintMappings.length; ++i) {
            Object mappings = this._constraintMap.get(this._constraintMappings[i].getPathSpec());
            mappings = LazyList.add(mappings, this._constraintMappings[i]);
            this._constraintMap.put(this._constraintMappings[i].getPathSpec(), mappings);
         }
      }

   }

   public String getAuthMethod() {
      return this._authMethod;
   }

   public void setAuthMethod(String method) {
      if (this.isStarted() && this._authMethod != null && !this._authMethod.equals(method)) {
         throw new IllegalStateException("Handler started");
      } else {
         this._authMethod = method;
      }
   }

   public boolean hasConstraints() {
      return this._constraintMappings != null && this._constraintMappings.length > 0;
   }

   public boolean isCheckWelcomeFiles() {
      return this._checkWelcomeFiles;
   }

   public void setCheckWelcomeFiles(boolean authenticateWelcomeFiles) {
      this._checkWelcomeFiles = authenticateWelcomeFiles;
   }

   public void doStart() throws Exception {
      if (this._authenticator == null) {
         if ("BASIC".equalsIgnoreCase(this._authMethod)) {
            this._authenticator = new BasicAuthenticator();
         } else if ("DIGEST".equalsIgnoreCase(this._authMethod)) {
            this._authenticator = new DigestAuthenticator();
         } else if ("CLIENT_CERT".equalsIgnoreCase(this._authMethod)) {
            this._authenticator = new ClientCertAuthenticator();
         } else if ("FORM".equalsIgnoreCase(this._authMethod)) {
            this._authenticator = new FormAuthenticator();
         } else {
            Log.warn("Unknown Authentication method:" + this._authMethod);
         }
      }

      super.doStart();
   }

   public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch) throws IOException, ServletException {
      Request base_request = request instanceof Request ? (Request)request : HttpConnection.getCurrentConnection().getRequest();
      Response base_response = response instanceof Response ? (Response)response : HttpConnection.getCurrentConnection().getResponse();
      UserRealm old_realm = base_request.getUserRealm();

      try {
         base_request.setUserRealm(this.getUserRealm());
         if (dispatch == 1 && !this.checkSecurityConstraints(target, base_request, base_response)) {
            base_request.setHandled(true);
            return;
         }

         if (dispatch == 2 && this._checkWelcomeFiles && request.getAttribute("com.replaymod.lib.org.mortbay.jetty.welcome") != null) {
            request.removeAttribute("com.replaymod.lib.org.mortbay.jetty.welcome");
            if (!this.checkSecurityConstraints(target, base_request, base_response)) {
               base_request.setHandled(true);
               return;
            }
         }

         if (this._authenticator instanceof FormAuthenticator && target.endsWith("/j_security_check")) {
            this._authenticator.authenticate(this.getUserRealm(), target, base_request, base_response);
            base_request.setHandled(true);
            return;
         }

         if (this.getHandler() != null) {
            this.getHandler().handle(target, request, response, dispatch);
         }
      } finally {
         if (this._userRealm != null && dispatch == 1) {
            this._userRealm.disassociate(base_request.getUserPrincipal());
         }

         base_request.setUserRealm(old_realm);
      }

   }

   public boolean checkSecurityConstraints(String pathInContext, Request request, Response response) throws IOException {
      Object mapping_entries = this._constraintMap.getLazyMatches(pathInContext);
      String pattern = null;
      Object constraints = null;
      if (mapping_entries == null) {
         request.setUserPrincipal(this._notChecked);
         return true;
      } else {
         for(int m = 0; m < LazyList.size(mapping_entries); ++m) {
            Entry entry = (Entry)LazyList.get(mapping_entries, m);
            Object mappings = entry.getValue();
            String path_spec = (String)entry.getKey();

            for(int c = 0; c < LazyList.size(mappings); ++c) {
               ConstraintMapping mapping = (ConstraintMapping)LazyList.get(mappings, c);
               if (mapping.getMethod() == null || mapping.getMethod().equalsIgnoreCase(request.getMethod())) {
                  if (pattern != null && !pattern.equals(path_spec)) {
                     return this.check(constraints, this._authenticator, this._userRealm, pathInContext, request, response);
                  }

                  pattern = path_spec;
                  constraints = LazyList.add(constraints, mapping.getConstraint());
               }
            }
         }

         return this.check(constraints, this._authenticator, this._userRealm, pathInContext, request, response);
      }
   }

   private boolean check(Object constraints, Authenticator authenticator, UserRealm realm, String pathInContext, Request request, Response response) throws IOException {
      int dataConstraint = 0;
      Object roles = null;
      boolean unauthenticated = false;
      boolean forbidden = false;

      for(int c = 0; c < LazyList.size(constraints); ++c) {
         Constraint sc = (Constraint)LazyList.get(constraints, c);
         if (dataConstraint > -1 && sc.hasDataConstraint()) {
            if (sc.getDataConstraint() > dataConstraint) {
               dataConstraint = sc.getDataConstraint();
            }
         } else {
            dataConstraint = -1;
         }

         if (!unauthenticated && !forbidden) {
            if (sc.getAuthenticate()) {
               if (sc.isAnyRole()) {
                  roles = "*";
               } else {
                  String[] scr = sc.getRoles();
                  if (scr == null || scr.length == 0) {
                     forbidden = true;
                     break;
                  }

                  if (roles != "*") {
                     for(int r = scr.length; r-- > 0; roles = LazyList.add(roles, scr[r])) {
                     }
                  }
               }
            } else {
               unauthenticated = true;
            }
         }
      }

      if (forbidden && (!(authenticator instanceof FormAuthenticator) || !((FormAuthenticator)authenticator).isLoginOrErrorPage(pathInContext))) {
         response.sendError(403);
         return false;
      } else {
         if (dataConstraint > 0) {
            HttpConnection connection = HttpConnection.getCurrentConnection();
            Connector connector = connection.getConnector();
            String url;
            switch(dataConstraint) {
            case 1:
               if (!connector.isIntegral(request)) {
                  if (connector.getConfidentialPort() > 0) {
                     url = connector.getIntegralScheme() + "://" + request.getServerName() + ":" + connector.getIntegralPort() + request.getRequestURI();
                     if (request.getQueryString() != null) {
                        url = url + "?" + request.getQueryString();
                     }

                     response.setContentLength(0);
                     response.sendRedirect(response.encodeRedirectURL(url));
                  } else {
                     response.sendError(403, (String)null);
                  }

                  return false;
               }
               break;
            case 2:
               if (!connector.isConfidential(request)) {
                  if (connector.getConfidentialPort() > 0) {
                     url = connector.getConfidentialScheme() + "://" + request.getServerName() + ":" + connector.getConfidentialPort() + request.getRequestURI();
                     if (request.getQueryString() != null) {
                        url = url + "?" + request.getQueryString();
                     }

                     response.setContentLength(0);
                     response.sendRedirect(response.encodeRedirectURL(url));
                  } else {
                     response.sendError(403, (String)null);
                  }

                  return false;
               }
               break;
            default:
               response.sendError(403, (String)null);
               return false;
            }
         }

         if (!unauthenticated && roles != null) {
            if (realm == null) {
               Log.warn("Request " + request.getRequestURI() + " failed - no realm");
               response.sendError(500, "No realm");
               return false;
            }

            Principal user = null;
            if (request.getAuthType() != null && request.getRemoteUser() != null) {
               user = request.getUserPrincipal();
               if (user == null) {
                  user = realm.authenticate(request.getRemoteUser(), (Object)null, request);
               }

               if (user == null && authenticator != null) {
                  user = authenticator.authenticate(realm, pathInContext, request, response);
               }
            } else if (authenticator != null) {
               user = authenticator.authenticate(realm, pathInContext, request, response);
            } else {
               Log.warn("Mis-configured Authenticator for " + request.getRequestURI());
               response.sendError(500, "Configuration error");
            }

            if (user == null) {
               return false;
            }

            if (user == __NOBODY) {
               return true;
            }

            if (roles != "*") {
               boolean inRole = false;
               int r = LazyList.size(roles);

               while(r-- > 0) {
                  if (realm.isUserInRole(user, (String)LazyList.get(roles, r))) {
                     inRole = true;
                     break;
                  }
               }

               if (!inRole) {
                  Log.warn("AUTH FAILURE: incorrect role for " + StringUtil.printable(user.getName()));
                  response.sendError(403, "User not in required role");
                  return false;
               }
            }
         } else {
            request.setUserPrincipal(this._notChecked);
         }

         return true;
      }
   }

   public class NotChecked implements Principal {
      public String getName() {
         return null;
      }

      public String toString() {
         return "NOT CHECKED";
      }

      public SecurityHandler getSecurityHandler() {
         return SecurityHandler.this;
      }
   }
}
