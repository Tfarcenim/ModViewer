package com.replaymod.lib.org.aspectj.lang.reflect;

import com.replaymod.lib.org.aspectj.lang.Signature;

public interface CatchClauseSignature extends Signature {
   Class getParameterType();

   String getParameterName();
}
