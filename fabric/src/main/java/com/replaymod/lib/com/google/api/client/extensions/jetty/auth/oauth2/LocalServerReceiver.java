package com.replaymod.lib.com.google.api.client.extensions.jetty.auth.oauth2;

import com.replaymod.lib.com.google.api.client.extensions.java6.auth.oauth2.VerificationCodeReceiver;
import com.replaymod.lib.com.google.api.client.util.Throwables;
import com.replaymod.lib.org.mortbay.jetty.Connector;
import com.replaymod.lib.org.mortbay.jetty.Request;
import com.replaymod.lib.org.mortbay.jetty.Server;
import com.replaymod.lib.org.mortbay.jetty.handler.AbstractHandler;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class LocalServerReceiver implements VerificationCodeReceiver {
   private static final String CALLBACK_PATH = "/Callback";
   private Server server;
   String code;
   String error;
   final Lock lock;
   final Condition gotAuthorizationResponse;
   private int port;
   private final String host;

   public LocalServerReceiver() {
      this("localhost", -1);
   }

   LocalServerReceiver(String host, int port) {
      this.lock = new ReentrantLock();
      this.gotAuthorizationResponse = this.lock.newCondition();
      this.host = host;
      this.port = port;
   }

   public String getRedirectUri() throws IOException {
      if (this.port == -1) {
         this.port = getUnusedPort();
      }

      this.server = new Server(this.port);
      Connector[] arr$ = this.server.getConnectors();
      int len$ = arr$.length;

      for(int i$ = 0; i$ < len$; ++i$) {
         Connector c = arr$[i$];
         c.setHost(this.host);
      }

      this.server.addHandler(new LocalServerReceiver.CallbackHandler());

      try {
         this.server.start();
      } catch (Exception var5) {
         Throwables.propagateIfPossible(var5);
         throw new IOException(var5);
      }

      String var6 = String.valueOf(String.valueOf(this.host));
      len$ = this.port;
      String var7 = String.valueOf(String.valueOf("/Callback"));
      return (new StringBuilder(19 + var6.length() + var7.length())).append("http://").append(var6).append(":").append(len$).append(var7).toString();
   }

   public String waitForCode() throws IOException {
      this.lock.lock();

      String var1;
      try {
         while(this.code == null && this.error == null) {
            this.gotAuthorizationResponse.awaitUninterruptibly();
         }

         if (this.error != null) {
            var1 = String.valueOf(String.valueOf(this.error));
            throw new IOException((new StringBuilder(28 + var1.length())).append("User authorization failed (").append(var1).append(")").toString());
         }

         var1 = this.code;
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public void stop() throws IOException {
      if (this.server != null) {
         try {
            this.server.stop();
         } catch (Exception var2) {
            Throwables.propagateIfPossible(var2);
            throw new IOException(var2);
         }

         this.server = null;
      }

   }

   public String getHost() {
      return this.host;
   }

   public int getPort() {
      return this.port;
   }

   private static int getUnusedPort() throws IOException {
      Socket s = new Socket();
      s.bind((SocketAddress)null);

      int var1;
      try {
         var1 = s.getLocalPort();
      } finally {
         s.close();
      }

      return var1;
   }

   class CallbackHandler extends AbstractHandler {
      public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch) throws IOException {
         if ("/Callback".equals(target)) {
            this.writeLandingHtml(response);
            response.flushBuffer();
            ((Request)request).setHandled(true);
            LocalServerReceiver.this.lock.lock();

            try {
               LocalServerReceiver.this.error = request.getParameter("error");
               LocalServerReceiver.this.code = request.getParameter("code");
               LocalServerReceiver.this.gotAuthorizationResponse.signal();
            } finally {
               LocalServerReceiver.this.lock.unlock();
            }

         }
      }

      private void writeLandingHtml(HttpServletResponse response) throws IOException {
         response.setStatus(200);
         response.setContentType("text/html");
         PrintWriter doc = response.getWriter();
         doc.println("<html>");
         doc.println("<head><title>OAuth 2.0 Authentication Token Recieved</title></head>");
         doc.println("<body>");
         doc.println("Received verification code. You may now close this window...");
         doc.println("</body>");
         doc.println("</HTML>");
         doc.flush();
      }
   }

   public static final class Builder {
      private String host = "localhost";
      private int port = -1;

      public LocalServerReceiver build() {
         return new LocalServerReceiver(this.host, this.port);
      }

      public String getHost() {
         return this.host;
      }

      public LocalServerReceiver.Builder setHost(String host) {
         this.host = host;
         return this;
      }

      public int getPort() {
         return this.port;
      }

      public LocalServerReceiver.Builder setPort(int port) {
         this.port = port;
         return this;
      }
   }
}
