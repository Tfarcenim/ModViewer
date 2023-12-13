package com.replaymod.lib.org.mortbay.jetty;

import com.replaymod.lib.org.mortbay.component.LifeCycle;

public interface HandlerContainer extends LifeCycle {
   void addHandler(Handler var1);

   void removeHandler(Handler var1);

   Handler[] getChildHandlers();

   Handler[] getChildHandlersByClass(Class var1);

   Handler getChildHandlerByClass(Class var1);
}
