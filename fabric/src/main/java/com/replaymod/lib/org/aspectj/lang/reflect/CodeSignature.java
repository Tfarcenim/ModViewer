package com.replaymod.lib.org.aspectj.lang.reflect;

public interface CodeSignature extends MemberSignature {
   Class[] getParameterTypes();

   String[] getParameterNames();

   Class[] getExceptionTypes();
}
