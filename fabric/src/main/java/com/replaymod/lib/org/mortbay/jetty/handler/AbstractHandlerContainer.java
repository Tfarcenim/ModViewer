package com.replaymod.lib.org.mortbay.jetty.handler;

import com.replaymod.lib.org.mortbay.jetty.Handler;
import com.replaymod.lib.org.mortbay.jetty.HandlerContainer;
import com.replaymod.lib.org.mortbay.util.LazyList;

public abstract class AbstractHandlerContainer extends AbstractHandler implements HandlerContainer {
   public Handler[] getChildHandlers() {
      Object list = this.expandChildren((Object)null, (Class)null);
      return (Handler[])((Handler[])LazyList.toArray(list, Handler.class));
   }

   public Handler[] getChildHandlersByClass(Class byclass) {
      Object list = this.expandChildren((Object)null, byclass);
      return (Handler[])((Handler[])LazyList.toArray(list, Handler.class));
   }

   public Handler getChildHandlerByClass(Class byclass) {
      Object list = this.expandChildren((Object)null, byclass);
      return list == null ? null : (Handler)LazyList.get(list, 0);
   }

   protected Object expandChildren(Object list, Class byClass) {
      return list;
   }

   protected Object expandHandler(Handler handler, Object list, Class byClass) {
      if (handler == null) {
         return list;
      } else {
         if (handler != null && (byClass == null || byClass.isAssignableFrom(handler.getClass()))) {
            list = LazyList.add(list, handler);
         }

         if (handler instanceof AbstractHandlerContainer) {
            list = ((AbstractHandlerContainer)handler).expandChildren(list, byClass);
         } else if (handler instanceof HandlerContainer) {
            HandlerContainer container = (HandlerContainer)handler;
            Handler[] handlers = byClass == null ? container.getChildHandlers() : container.getChildHandlersByClass(byClass);
            list = LazyList.addArray(list, handlers);
         }

         return list;
      }
   }
}
