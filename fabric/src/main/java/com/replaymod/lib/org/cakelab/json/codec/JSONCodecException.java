package com.replaymod.lib.org.cakelab.json.codec;

public class JSONCodecException extends Exception {
   private static final long serialVersionUID = 1L;

   public JSONCodecException() {
   }

   public JSONCodecException(String message) {
      super(message);
   }

   public JSONCodecException(Throwable cause) {
      super(cause);
   }

   public JSONCodecException(String message, Throwable cause) {
      super(message, cause);
   }

   public synchronized Throwable getCause() {
      Throwable cause = super.getCause();
      return (Throwable)(cause == null ? this : cause);
   }
}
