package com.replaymod.lib.org.aspectj.lang.reflect;

import java.lang.reflect.Method;

public interface AdviceSignature extends CodeSignature {
   Class getReturnType();

   Method getAdvice();
}
