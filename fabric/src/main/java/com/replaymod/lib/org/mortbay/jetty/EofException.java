package com.replaymod.lib.org.mortbay.jetty;

import java.io.EOFException;

public class EofException extends EOFException {
   public EofException() {
   }

   public EofException(String reason) {
      super(reason);
   }

   public EofException(Throwable th) {
      this.initCause(th);
   }
}
