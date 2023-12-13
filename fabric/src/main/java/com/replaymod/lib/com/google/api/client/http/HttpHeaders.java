package com.replaymod.lib.com.google.api.client.http;

import com.replaymod.lib.com.google.api.client.util.ArrayValueMap;
import com.replaymod.lib.com.google.api.client.util.Base64;
import com.replaymod.lib.com.google.api.client.util.ClassInfo;
import com.replaymod.lib.com.google.api.client.util.Data;
import com.replaymod.lib.com.google.api.client.util.FieldInfo;
import com.replaymod.lib.com.google.api.client.util.GenericData;
import com.replaymod.lib.com.google.api.client.util.Key;
import com.replaymod.lib.com.google.api.client.util.Preconditions;
import com.replaymod.lib.com.google.api.client.util.StringUtils;
import com.replaymod.lib.com.google.api.client.util.Throwables;
import com.replaymod.lib.com.google.api.client.util.Types;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpHeaders extends GenericData {
   @Key("Accept")
   private List<String> accept;
   @Key("Accept-Encoding")
   private List<String> acceptEncoding = new ArrayList(Collections.singleton("gzip"));
   @Key("Authorization")
   private List<String> authorization;
   @Key("Cache-Control")
   private List<String> cacheControl;
   @Key("Content-Encoding")
   private List<String> contentEncoding;
   @Key("Content-Length")
   private List<Long> contentLength;
   @Key("Content-MD5")
   private List<String> contentMD5;
   @Key("Content-Range")
   private List<String> contentRange;
   @Key("Content-Type")
   private List<String> contentType;
   @Key("Cookie")
   private List<String> cookie;
   @Key("Date")
   private List<String> date;
   @Key("ETag")
   private List<String> etag;
   @Key("Expires")
   private List<String> expires;
   @Key("If-Modified-Since")
   private List<String> ifModifiedSince;
   @Key("If-Match")
   private List<String> ifMatch;
   @Key("If-None-Match")
   private List<String> ifNoneMatch;
   @Key("If-Unmodified-Since")
   private List<String> ifUnmodifiedSince;
   @Key("If-Range")
   private List<String> ifRange;
   @Key("Last-Modified")
   private List<String> lastModified;
   @Key("Location")
   private List<String> location;
   @Key("MIME-Version")
   private List<String> mimeVersion;
   @Key("Range")
   private List<String> range;
   @Key("Retry-After")
   private List<String> retryAfter;
   @Key("User-Agent")
   private List<String> userAgent;
   @Key("WWW-Authenticate")
   private List<String> authenticate;
   @Key("Age")
   private List<Long> age;

   public HttpHeaders() {
      super(EnumSet.of(GenericData.Flags.IGNORE_CASE));
   }

   public HttpHeaders clone() {
      return (HttpHeaders)super.clone();
   }

   public HttpHeaders set(String fieldName, Object value) {
      return (HttpHeaders)super.set(fieldName, value);
   }

   public final String getAccept() {
      return (String)this.getFirstHeaderValue(this.accept);
   }

   public HttpHeaders setAccept(String accept) {
      this.accept = this.getAsList(accept);
      return this;
   }

   public final String getAcceptEncoding() {
      return (String)this.getFirstHeaderValue(this.acceptEncoding);
   }

   public HttpHeaders setAcceptEncoding(String acceptEncoding) {
      this.acceptEncoding = this.getAsList(acceptEncoding);
      return this;
   }

   public final String getAuthorization() {
      return (String)this.getFirstHeaderValue(this.authorization);
   }

   public final List<String> getAuthorizationAsList() {
      return this.authorization;
   }

   public HttpHeaders setAuthorization(String authorization) {
      return this.setAuthorization(this.getAsList(authorization));
   }

   public HttpHeaders setAuthorization(List<String> authorization) {
      this.authorization = authorization;
      return this;
   }

   public final String getCacheControl() {
      return (String)this.getFirstHeaderValue(this.cacheControl);
   }

   public HttpHeaders setCacheControl(String cacheControl) {
      this.cacheControl = this.getAsList(cacheControl);
      return this;
   }

   public final String getContentEncoding() {
      return (String)this.getFirstHeaderValue(this.contentEncoding);
   }

   public HttpHeaders setContentEncoding(String contentEncoding) {
      this.contentEncoding = this.getAsList(contentEncoding);
      return this;
   }

   public final Long getContentLength() {
      return (Long)this.getFirstHeaderValue(this.contentLength);
   }

   public HttpHeaders setContentLength(Long contentLength) {
      this.contentLength = this.getAsList(contentLength);
      return this;
   }

   public final String getContentMD5() {
      return (String)this.getFirstHeaderValue(this.contentMD5);
   }

   public HttpHeaders setContentMD5(String contentMD5) {
      this.contentMD5 = this.getAsList(contentMD5);
      return this;
   }

   public final String getContentRange() {
      return (String)this.getFirstHeaderValue(this.contentRange);
   }

   public HttpHeaders setContentRange(String contentRange) {
      this.contentRange = this.getAsList(contentRange);
      return this;
   }

   public final String getContentType() {
      return (String)this.getFirstHeaderValue(this.contentType);
   }

   public HttpHeaders setContentType(String contentType) {
      this.contentType = this.getAsList(contentType);
      return this;
   }

   public final String getCookie() {
      return (String)this.getFirstHeaderValue(this.cookie);
   }

   public HttpHeaders setCookie(String cookie) {
      this.cookie = this.getAsList(cookie);
      return this;
   }

   public final String getDate() {
      return (String)this.getFirstHeaderValue(this.date);
   }

   public HttpHeaders setDate(String date) {
      this.date = this.getAsList(date);
      return this;
   }

   public final String getETag() {
      return (String)this.getFirstHeaderValue(this.etag);
   }

   public HttpHeaders setETag(String etag) {
      this.etag = this.getAsList(etag);
      return this;
   }

   public final String getExpires() {
      return (String)this.getFirstHeaderValue(this.expires);
   }

   public HttpHeaders setExpires(String expires) {
      this.expires = this.getAsList(expires);
      return this;
   }

   public final String getIfModifiedSince() {
      return (String)this.getFirstHeaderValue(this.ifModifiedSince);
   }

   public HttpHeaders setIfModifiedSince(String ifModifiedSince) {
      this.ifModifiedSince = this.getAsList(ifModifiedSince);
      return this;
   }

   public final String getIfMatch() {
      return (String)this.getFirstHeaderValue(this.ifMatch);
   }

   public HttpHeaders setIfMatch(String ifMatch) {
      this.ifMatch = this.getAsList(ifMatch);
      return this;
   }

   public final String getIfNoneMatch() {
      return (String)this.getFirstHeaderValue(this.ifNoneMatch);
   }

   public HttpHeaders setIfNoneMatch(String ifNoneMatch) {
      this.ifNoneMatch = this.getAsList(ifNoneMatch);
      return this;
   }

   public final String getIfUnmodifiedSince() {
      return (String)this.getFirstHeaderValue(this.ifUnmodifiedSince);
   }

   public HttpHeaders setIfUnmodifiedSince(String ifUnmodifiedSince) {
      this.ifUnmodifiedSince = this.getAsList(ifUnmodifiedSince);
      return this;
   }

   public final String getIfRange() {
      return (String)this.getFirstHeaderValue(this.ifRange);
   }

   public HttpHeaders setIfRange(String ifRange) {
      this.ifRange = this.getAsList(ifRange);
      return this;
   }

   public final String getLastModified() {
      return (String)this.getFirstHeaderValue(this.lastModified);
   }

   public HttpHeaders setLastModified(String lastModified) {
      this.lastModified = this.getAsList(lastModified);
      return this;
   }

   public final String getLocation() {
      return (String)this.getFirstHeaderValue(this.location);
   }

   public HttpHeaders setLocation(String location) {
      this.location = this.getAsList(location);
      return this;
   }

   public final String getMimeVersion() {
      return (String)this.getFirstHeaderValue(this.mimeVersion);
   }

   public HttpHeaders setMimeVersion(String mimeVersion) {
      this.mimeVersion = this.getAsList(mimeVersion);
      return this;
   }

   public final String getRange() {
      return (String)this.getFirstHeaderValue(this.range);
   }

   public HttpHeaders setRange(String range) {
      this.range = this.getAsList(range);
      return this;
   }

   public final String getRetryAfter() {
      return (String)this.getFirstHeaderValue(this.retryAfter);
   }

   public HttpHeaders setRetryAfter(String retryAfter) {
      this.retryAfter = this.getAsList(retryAfter);
      return this;
   }

   public final String getUserAgent() {
      return (String)this.getFirstHeaderValue(this.userAgent);
   }

   public HttpHeaders setUserAgent(String userAgent) {
      this.userAgent = this.getAsList(userAgent);
      return this;
   }

   public final String getAuthenticate() {
      return (String)this.getFirstHeaderValue(this.authenticate);
   }

   public final List<String> getAuthenticateAsList() {
      return this.authenticate;
   }

   public HttpHeaders setAuthenticate(String authenticate) {
      this.authenticate = this.getAsList(authenticate);
      return this;
   }

   public final Long getAge() {
      return (Long)this.getFirstHeaderValue(this.age);
   }

   public HttpHeaders setAge(Long age) {
      this.age = this.getAsList(age);
      return this;
   }

   public HttpHeaders setBasicAuthentication(String username, String password) {
      String userPass = (String)Preconditions.checkNotNull(username) + ":" + (String)Preconditions.checkNotNull(password);
      String encoded = Base64.encodeBase64String(StringUtils.getBytesUtf8(userPass));
      return this.setAuthorization("Basic " + encoded);
   }

   private static void addHeader(Logger logger, StringBuilder logbuf, StringBuilder curlbuf, LowLevelHttpRequest lowLevelHttpRequest, String name, Object value, Writer writer) throws IOException {
      if (value != null && !Data.isNull(value)) {
         String stringValue = toStringValue(value);
         String loggedStringValue = stringValue;
         if (("Authorization".equalsIgnoreCase(name) || "Cookie".equalsIgnoreCase(name)) && (logger == null || !logger.isLoggable(Level.ALL))) {
            loggedStringValue = "<Not Logged>";
         }

         if (logbuf != null) {
            logbuf.append(name).append(": ");
            logbuf.append(loggedStringValue);
            logbuf.append(StringUtils.LINE_SEPARATOR);
         }

         if (curlbuf != null) {
            curlbuf.append(" -H '").append(name).append(": ").append(loggedStringValue).append("'");
         }

         if (lowLevelHttpRequest != null) {
            lowLevelHttpRequest.addHeader(name, stringValue);
         }

         if (writer != null) {
            writer.write(name);
            writer.write(": ");
            writer.write(stringValue);
            writer.write("\r\n");
         }

      }
   }

   private static String toStringValue(Object headerValue) {
      return headerValue instanceof Enum ? FieldInfo.of((Enum)headerValue).getName() : headerValue.toString();
   }

   static void serializeHeaders(HttpHeaders headers, StringBuilder logbuf, StringBuilder curlbuf, Logger logger, LowLevelHttpRequest lowLevelHttpRequest) throws IOException {
      serializeHeaders(headers, logbuf, curlbuf, logger, lowLevelHttpRequest, (Writer)null);
   }

   public static void serializeHeadersForMultipartRequests(HttpHeaders headers, StringBuilder logbuf, Logger logger, Writer writer) throws IOException {
      serializeHeaders(headers, logbuf, (StringBuilder)null, logger, (LowLevelHttpRequest)null, writer);
   }

   static void serializeHeaders(HttpHeaders headers, StringBuilder logbuf, StringBuilder curlbuf, Logger logger, LowLevelHttpRequest lowLevelHttpRequest, Writer writer) throws IOException {
      HashSet<String> headerNames = new HashSet();
      Iterator i$ = headers.entrySet().iterator();

      while(true) {
         while(true) {
            String name;
            Object value;
            do {
               if (!i$.hasNext()) {
                  if (writer != null) {
                     writer.flush();
                  }

                  return;
               }

               Entry<String, Object> headerEntry = (Entry)i$.next();
               name = (String)headerEntry.getKey();
               Preconditions.checkArgument(headerNames.add(name), "multiple headers of the same name (headers are case insensitive): %s", name);
               value = headerEntry.getValue();
            } while(value == null);

            String displayName = name;
            FieldInfo fieldInfo = headers.getClassInfo().getFieldInfo(name);
            if (fieldInfo != null) {
               displayName = fieldInfo.getName();
            }

            Class<? extends Object> valueClass = value.getClass();
            if (!(value instanceof Iterable) && !valueClass.isArray()) {
               addHeader(logger, logbuf, curlbuf, lowLevelHttpRequest, displayName, value, writer);
            } else {
               Iterator i$ = Types.iterableOf(value).iterator();

               while(i$.hasNext()) {
                  Object repeatedValue = i$.next();
                  addHeader(logger, logbuf, curlbuf, lowLevelHttpRequest, displayName, repeatedValue, writer);
               }
            }
         }
      }
   }

   public final void fromHttpResponse(LowLevelHttpResponse response, StringBuilder logger) throws IOException {
      this.clear();
      HttpHeaders.ParseHeaderState state = new HttpHeaders.ParseHeaderState(this, logger);
      int headerCount = response.getHeaderCount();

      for(int i = 0; i < headerCount; ++i) {
         this.parseHeader(response.getHeaderName(i), response.getHeaderValue(i), state);
      }

      state.finish();
   }

   private <T> T getFirstHeaderValue(List<T> internalValue) {
      return internalValue == null ? null : internalValue.get(0);
   }

   private <T> List<T> getAsList(T passedValue) {
      if (passedValue == null) {
         return null;
      } else {
         List<T> result = new ArrayList();
         result.add(passedValue);
         return result;
      }
   }

   public String getFirstHeaderStringValue(String name) {
      Object value = this.get(name.toLowerCase());
      if (value == null) {
         return null;
      } else {
         Class<? extends Object> valueClass = value.getClass();
         if (value instanceof Iterable || valueClass.isArray()) {
            Iterator i$ = Types.iterableOf(value).iterator();
            if (i$.hasNext()) {
               Object repeatedValue = i$.next();
               return toStringValue(repeatedValue);
            }
         }

         return toStringValue(value);
      }
   }

   public List<String> getHeaderStringValues(String name) {
      Object value = this.get(name.toLowerCase());
      if (value == null) {
         return Collections.emptyList();
      } else {
         Class<? extends Object> valueClass = value.getClass();
         if (!(value instanceof Iterable) && !valueClass.isArray()) {
            return Collections.singletonList(toStringValue(value));
         } else {
            List<String> values = new ArrayList();
            Iterator i$ = Types.iterableOf(value).iterator();

            while(i$.hasNext()) {
               Object repeatedValue = i$.next();
               values.add(toStringValue(repeatedValue));
            }

            return Collections.unmodifiableList(values);
         }
      }
   }

   public final void fromHttpHeaders(HttpHeaders headers) {
      try {
         HttpHeaders.ParseHeaderState state = new HttpHeaders.ParseHeaderState(this, (StringBuilder)null);
         serializeHeaders(headers, (StringBuilder)null, (StringBuilder)null, (Logger)null, new HttpHeaders.HeaderParsingFakeLevelHttpRequest(this, state));
         state.finish();
      } catch (IOException var3) {
         throw Throwables.propagate(var3);
      }
   }

   void parseHeader(String headerName, String headerValue, HttpHeaders.ParseHeaderState state) {
      List<Type> context = state.context;
      ClassInfo classInfo = state.classInfo;
      ArrayValueMap arrayValueMap = state.arrayValueMap;
      StringBuilder logger = state.logger;
      if (logger != null) {
         logger.append(headerName + ": " + headerValue).append(StringUtils.LINE_SEPARATOR);
      }

      FieldInfo fieldInfo = classInfo.getFieldInfo(headerName);
      if (fieldInfo != null) {
         Type type = Data.resolveWildcardTypeOrTypeVariable(context, fieldInfo.getGenericType());
         if (Types.isArray(type)) {
            Class<?> rawArrayComponentType = Types.getRawArrayComponentType(context, Types.getArrayComponentType(type));
            arrayValueMap.put(fieldInfo.getField(), rawArrayComponentType, parseValue(rawArrayComponentType, context, headerValue));
         } else if (Types.isAssignableToOrFrom(Types.getRawArrayComponentType(context, type), Iterable.class)) {
            Collection<Object> collection = (Collection)fieldInfo.getValue(this);
            if (collection == null) {
               collection = Data.newCollectionInstance(type);
               fieldInfo.setValue(this, collection);
            }

            Type subFieldType = type == Object.class ? null : Types.getIterableParameter(type);
            collection.add(parseValue(subFieldType, context, headerValue));
         } else {
            fieldInfo.setValue(this, parseValue(type, context, headerValue));
         }
      } else {
         ArrayList<String> listValue = (ArrayList)this.get(headerName);
         if (listValue == null) {
            listValue = new ArrayList();
            this.set(headerName, listValue);
         }

         listValue.add(headerValue);
      }

   }

   private static Object parseValue(Type valueType, List<Type> context, String value) {
      Type resolved = Data.resolveWildcardTypeOrTypeVariable(context, valueType);
      return Data.parsePrimitiveValue(resolved, value);
   }

   private static final class ParseHeaderState {
      final ArrayValueMap arrayValueMap;
      final StringBuilder logger;
      final ClassInfo classInfo;
      final List<Type> context;

      public ParseHeaderState(HttpHeaders headers, StringBuilder logger) {
         Class<? extends HttpHeaders> clazz = headers.getClass();
         this.context = Arrays.asList(clazz);
         this.classInfo = ClassInfo.of(clazz, true);
         this.logger = logger;
         this.arrayValueMap = new ArrayValueMap(headers);
      }

      void finish() {
         this.arrayValueMap.setValues();
      }
   }

   private static class HeaderParsingFakeLevelHttpRequest extends LowLevelHttpRequest {
      private final HttpHeaders target;
      private final HttpHeaders.ParseHeaderState state;

      HeaderParsingFakeLevelHttpRequest(HttpHeaders target, HttpHeaders.ParseHeaderState state) {
         this.target = target;
         this.state = state;
      }

      public void addHeader(String name, String value) {
         this.target.parseHeader(name, value, this.state);
      }

      public LowLevelHttpResponse execute() throws IOException {
         throw new UnsupportedOperationException();
      }
   }
}
