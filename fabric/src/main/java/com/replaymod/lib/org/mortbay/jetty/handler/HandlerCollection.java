package com.replaymod.lib.org.mortbay.jetty.handler;

import com.replaymod.lib.org.mortbay.jetty.Handler;
import com.replaymod.lib.org.mortbay.jetty.Server;
import com.replaymod.lib.org.mortbay.util.LazyList;
import com.replaymod.lib.org.mortbay.util.MultiException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlerCollection extends AbstractHandlerContainer {
   private Handler[] _handlers;

   public Handler[] getHandlers() {
      return this._handlers;
   }

   public void setHandlers(Handler[] handlers) {
      Handler[] old_handlers = this._handlers == null ? null : (Handler[])((Handler[])this._handlers.clone());
      if (this.getServer() != null) {
         this.getServer().getContainer().update(this, (Object[])old_handlers, (Object[])handlers, "handler");
      }

      Server server = this.getServer();
      MultiException mex = new MultiException();

      int i;
      for(i = 0; handlers != null && i < handlers.length; ++i) {
         if (handlers[i].getServer() != server) {
            handlers[i].setServer(server);
         }
      }

      this._handlers = handlers;

      for(i = 0; old_handlers != null && i < old_handlers.length; ++i) {
         if (old_handlers[i] != null) {
            try {
               if (old_handlers[i].isStarted()) {
                  old_handlers[i].stop();
               }
            } catch (Throwable var7) {
               mex.add(var7);
            }
         }
      }

      mex.ifExceptionThrowRuntime();
   }

   public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch) throws IOException, ServletException {
      if (this._handlers != null && this.isStarted()) {
         MultiException mex = null;

         for(int i = 0; i < this._handlers.length; ++i) {
            try {
               this._handlers[i].handle(target, request, response, dispatch);
            } catch (IOException var8) {
               throw var8;
            } catch (RuntimeException var9) {
               throw var9;
            } catch (Exception var10) {
               if (mex == null) {
                  mex = new MultiException();
               }

               mex.add(var10);
            }
         }

         if (mex != null) {
            if (mex.size() == 1) {
               throw new ServletException(mex.getThrowable(0));
            }

            throw new ServletException(mex);
         }
      }

   }

   protected void doStart() throws Exception {
      MultiException mex = new MultiException();
      if (this._handlers != null) {
         for(int i = 0; i < this._handlers.length; ++i) {
            try {
               this._handlers[i].start();
            } catch (Throwable var4) {
               mex.add(var4);
            }
         }
      }

      super.doStart();
      mex.ifExceptionThrow();
   }

   protected void doStop() throws Exception {
      MultiException mex = new MultiException();

      try {
         super.doStop();
      } catch (Throwable var5) {
         mex.add(var5);
      }

      if (this._handlers != null) {
         int i = this._handlers.length;

         while(i-- > 0) {
            try {
               this._handlers[i].stop();
            } catch (Throwable var4) {
               mex.add(var4);
            }
         }
      }

      mex.ifExceptionThrow();
   }

   public void setServer(Server server) {
      Server old_server = this.getServer();
      super.setServer(server);
      Handler[] h = this.getHandlers();

      for(int i = 0; h != null && i < h.length; ++i) {
         h[i].setServer(server);
      }

      if (server != null && server != old_server) {
         server.getContainer().update(this, (Object[])null, (Object[])this._handlers, "handler");
      }

   }

   public void addHandler(Handler handler) {
      this.setHandlers((Handler[])((Handler[])LazyList.addToArray(this.getHandlers(), handler, Handler.class)));
   }

   public void removeHandler(Handler handler) {
      Handler[] handlers = this.getHandlers();
      if (handlers != null && handlers.length > 0) {
         this.setHandlers((Handler[])((Handler[])LazyList.removeFromArray(handlers, handler)));
      }

   }

   protected Object expandChildren(Object list, Class byClass) {
      Handler[] handlers = this.getHandlers();

      for(int i = 0; handlers != null && i < handlers.length; ++i) {
         list = this.expandHandler(handlers[i], list, byClass);
      }

      return list;
   }
}
