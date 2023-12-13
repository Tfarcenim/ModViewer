package com.replaymod.lib.org.mortbay.jetty.handler;

import com.replaymod.lib.org.mortbay.jetty.Handler;
import com.replaymod.lib.org.mortbay.jetty.HandlerContainer;
import com.replaymod.lib.org.mortbay.jetty.Server;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlerWrapper extends AbstractHandlerContainer {
   private Handler _handler;

   public Handler getHandler() {
      return this._handler;
   }

   public void setHandler(Handler handler) {
      try {
         Handler old_handler = this._handler;
         if (this.getServer() != null) {
            this.getServer().getContainer().update(this, (Object)old_handler, (Object)handler, "handler");
         }

         if (handler != null) {
            handler.setServer(this.getServer());
         }

         this._handler = handler;
         if (old_handler != null && old_handler.isStarted()) {
            old_handler.stop();
         }

      } catch (Exception var4) {
         IllegalStateException ise = new IllegalStateException();
         ise.initCause(var4);
         throw ise;
      }
   }

   public void addHandler(Handler handler) {
      Handler old = this.getHandler();
      if (old != null && !(handler instanceof HandlerContainer)) {
         throw new IllegalArgumentException("Cannot add");
      } else {
         this.setHandler(handler);
         if (old != null) {
            ((HandlerContainer)handler).addHandler(old);
         }

      }
   }

   public void removeHandler(Handler handler) {
      Handler old = this.getHandler();
      if (old != null && old instanceof HandlerContainer) {
         ((HandlerContainer)old).removeHandler(handler);
      } else {
         if (old == null || !handler.equals(old)) {
            throw new IllegalStateException("Cannot remove");
         }

         this.setHandler((Handler)null);
      }

   }

   protected void doStart() throws Exception {
      if (this._handler != null) {
         this._handler.start();
      }

      super.doStart();
   }

   protected void doStop() throws Exception {
      super.doStop();
      if (this._handler != null) {
         this._handler.stop();
      }

   }

   public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch) throws IOException, ServletException {
      if (this._handler != null && this.isStarted()) {
         this._handler.handle(target, request, response, dispatch);
      }

   }

   public void setServer(Server server) {
      Server old_server = this.getServer();
      super.setServer(server);
      Handler h = this.getHandler();
      if (h != null) {
         h.setServer(server);
      }

      if (server != null && server != old_server) {
         server.getContainer().update(this, (Object)null, (Object)this._handler, "handler");
      }

   }

   protected Object expandChildren(Object list, Class byClass) {
      return this.expandHandler(this._handler, list, byClass);
   }
}
