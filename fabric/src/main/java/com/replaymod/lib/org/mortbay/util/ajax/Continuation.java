package com.replaymod.lib.org.mortbay.util.ajax;

public interface Continuation {
   boolean suspend(long var1);

   void resume();

   void reset();

   boolean isNew();

   boolean isPending();

   boolean isResumed();

   Object getObject();

   void setObject(Object var1);
}
