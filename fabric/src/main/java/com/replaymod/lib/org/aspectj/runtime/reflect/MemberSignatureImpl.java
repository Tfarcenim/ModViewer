package com.replaymod.lib.org.aspectj.runtime.reflect;

import com.replaymod.lib.org.aspectj.lang.reflect.MemberSignature;

abstract class MemberSignatureImpl extends SignatureImpl implements MemberSignature {
   MemberSignatureImpl(int modifiers, String name, Class declaringType) {
      super(modifiers, name, declaringType);
   }

   public MemberSignatureImpl(String stringRep) {
      super(stringRep);
   }
}
