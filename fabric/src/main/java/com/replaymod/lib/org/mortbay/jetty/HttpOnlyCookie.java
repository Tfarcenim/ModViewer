package com.replaymod.lib.org.mortbay.jetty;

import javax.servlet.http.Cookie;

public class HttpOnlyCookie extends Cookie {
   public HttpOnlyCookie(String name, String value) {
      super(name, value);
   }
}
