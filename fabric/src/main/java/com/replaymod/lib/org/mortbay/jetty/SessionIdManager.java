package com.replaymod.lib.org.mortbay.jetty;

import com.replaymod.lib.org.mortbay.component.LifeCycle;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface SessionIdManager extends LifeCycle {
   boolean idInUse(String var1);

   void addSession(HttpSession var1);

   void removeSession(HttpSession var1);

   void invalidateAll(String var1);

   String newSessionId(HttpServletRequest var1, long var2);

   String getWorkerName();

   String getClusterId(String var1);

   String getNodeId(String var1, HttpServletRequest var2);
}
