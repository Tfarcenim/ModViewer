package com.replaymod.lib.org.aspectj.lang.reflect;

import java.lang.reflect.Method;

public interface MethodSignature extends CodeSignature {
   Class getReturnType();

   Method getMethod();
}
