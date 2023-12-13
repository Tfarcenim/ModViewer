package com.replaymod.lib.org.mortbay.jetty;

import com.replaymod.lib.org.mortbay.component.LifeCycle;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Handler extends LifeCycle {
   int DEFAULT = 0;
   int REQUEST = 1;
   int FORWARD = 2;
   int INCLUDE = 4;
   int ERROR = 8;
   int ALL = 15;

   void handle(String var1, HttpServletRequest var2, HttpServletResponse var3, int var4) throws IOException, ServletException;

   void setServer(Server var1);

   Server getServer();

   void destroy();
}
