package com.replaymod.lib.org.aspectj.runtime.reflect;

import com.replaymod.lib.org.aspectj.lang.reflect.LockSignature;

class LockSignatureImpl extends SignatureImpl implements LockSignature {
   private Class parameterType;

   LockSignatureImpl(Class c) {
      super(8, "lock", c);
      this.parameterType = c;
   }

   LockSignatureImpl(String stringRep) {
      super(stringRep);
   }

   protected String createToString(StringMaker sm) {
      if (this.parameterType == null) {
         this.parameterType = this.extractType(3);
      }

      return "lock(" + sm.makeTypeName(this.parameterType) + ")";
   }

   public Class getParameterType() {
      if (this.parameterType == null) {
         this.parameterType = this.extractType(3);
      }

      return this.parameterType;
   }
}
