package com.replaymod.lib.org.aspectj.lang;

import com.replaymod.lib.org.aspectj.runtime.internal.AroundClosure;

public interface ProceedingJoinPoint extends JoinPoint {
   void set$AroundClosure(AroundClosure var1);

   Object proceed() throws Throwable;

   Object proceed(Object[] var1) throws Throwable;
}
