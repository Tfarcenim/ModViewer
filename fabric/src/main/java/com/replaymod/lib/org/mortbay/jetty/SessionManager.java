package com.replaymod.lib.org.mortbay.jetty;

import com.replaymod.lib.org.mortbay.component.LifeCycle;
import com.replaymod.lib.org.mortbay.jetty.servlet.SessionHandler;
import java.util.EventListener;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface SessionManager extends LifeCycle {
   String __SessionCookieProperty = "com.replaymod.lib.org.mortbay.jetty.servlet.SessionCookie";
   String __DefaultSessionCookie = "JSESSIONID";
   String __SessionURLProperty = "com.replaymod.lib.org.mortbay.jetty.servlet.SessionURL";
   String __DefaultSessionURL = "jsessionid";
   String __SessionDomainProperty = "com.replaymod.lib.org.mortbay.jetty.servlet.SessionDomain";
   String __DefaultSessionDomain = null;
   String __SessionPathProperty = "com.replaymod.lib.org.mortbay.jetty.servlet.SessionPath";
   String __MaxAgeProperty = "com.replaymod.lib.org.mortbay.jetty.servlet.MaxAge";

   HttpSession getHttpSession(String var1);

   HttpSession newHttpSession(HttpServletRequest var1);

   boolean getSecureCookies();

   boolean getHttpOnly();

   int getMaxInactiveInterval();

   void setMaxInactiveInterval(int var1);

   void setSessionHandler(SessionHandler var1);

   void addEventListener(EventListener var1);

   void removeEventListener(EventListener var1);

   void clearEventListeners();

   Cookie getSessionCookie(HttpSession var1, String var2, boolean var3);

   SessionIdManager getIdManager();

   /** @deprecated */
   SessionIdManager getMetaManager();

   void setIdManager(SessionIdManager var1);

   boolean isValid(HttpSession var1);

   String getNodeId(HttpSession var1);

   String getClusterId(HttpSession var1);

   Cookie access(HttpSession var1, boolean var2);

   void complete(HttpSession var1);

   void setSessionCookie(String var1);

   String getSessionCookie();

   void setSessionURL(String var1);

   String getSessionURL();

   String getSessionURLPrefix();

   void setSessionDomain(String var1);

   String getSessionDomain();

   void setSessionPath(String var1);

   String getSessionPath();

   void setMaxCookieAge(int var1);

   int getMaxCookieAge();

   boolean isUsingCookies();
}
