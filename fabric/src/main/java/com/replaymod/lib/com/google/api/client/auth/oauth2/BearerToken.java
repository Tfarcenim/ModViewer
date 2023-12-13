package com.replaymod.lib.com.google.api.client.auth.oauth2;

import com.replaymod.lib.com.google.api.client.http.HttpRequest;
import com.replaymod.lib.com.google.api.client.http.UrlEncodedContent;
import com.replaymod.lib.com.google.api.client.util.Data;
import com.replaymod.lib.com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class BearerToken {
   static final String PARAM_NAME = "access_token";
   static final Pattern INVALID_TOKEN_ERROR = Pattern.compile("\\s*error\\s*=\\s*\"?invalid_token\"?");

   public static Credential.AccessMethod authorizationHeaderAccessMethod() {
      return new BearerToken.AuthorizationHeaderAccessMethod();
   }

   public static Credential.AccessMethod formEncodedBodyAccessMethod() {
      return new BearerToken.FormEncodedBodyAccessMethod();
   }

   public static Credential.AccessMethod queryParameterAccessMethod() {
      return new BearerToken.QueryParameterAccessMethod();
   }

   static final class QueryParameterAccessMethod implements Credential.AccessMethod {
      public void intercept(HttpRequest request, String accessToken) throws IOException {
         request.getUrl().set("access_token", accessToken);
      }

      public String getAccessTokenFromRequest(HttpRequest request) {
         Object param = request.getUrl().get("access_token");
         return param == null ? null : param.toString();
      }
   }

   static final class FormEncodedBodyAccessMethod implements Credential.AccessMethod {
      public void intercept(HttpRequest request, String accessToken) throws IOException {
         Preconditions.checkArgument(!"GET".equals(request.getRequestMethod()), "HTTP GET method is not supported");
         getData(request).put("access_token", accessToken);
      }

      public String getAccessTokenFromRequest(HttpRequest request) {
         Object bodyParam = getData(request).get("access_token");
         return bodyParam == null ? null : bodyParam.toString();
      }

      private static Map<String, Object> getData(HttpRequest request) {
         return Data.mapOf(UrlEncodedContent.getContent(request).getData());
      }
   }

   static final class AuthorizationHeaderAccessMethod implements Credential.AccessMethod {
      static final String HEADER_PREFIX = "Bearer ";

      public void intercept(HttpRequest request, String accessToken) throws IOException {
         request.getHeaders().setAuthorization("Bearer " + accessToken);
      }

      public String getAccessTokenFromRequest(HttpRequest request) {
         List<String> authorizationAsList = request.getHeaders().getAuthorizationAsList();
         if (authorizationAsList != null) {
            Iterator i$ = authorizationAsList.iterator();

            while(i$.hasNext()) {
               String header = (String)i$.next();
               if (header.startsWith("Bearer ")) {
                  return header.substring("Bearer ".length());
               }
            }
         }

         return null;
      }
   }
}
