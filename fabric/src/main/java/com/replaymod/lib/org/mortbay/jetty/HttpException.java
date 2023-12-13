package com.replaymod.lib.org.mortbay.jetty;

import java.io.IOException;

public class HttpException extends IOException {
   int _status;
   String _reason;

   public HttpException(int status) {
      this._status = status;
      this._reason = null;
   }

   public HttpException(int status, String reason) {
      this._status = status;
      this._reason = reason;
   }

   protected HttpException(int status, String reason, Throwable rootCause) {
      this._status = status;
      this._reason = reason;
      this.initCause(rootCause);
   }

   public String getReason() {
      return this._reason;
   }

   public void setReason(String reason) {
      this._reason = reason;
   }

   public int getStatus() {
      return this._status;
   }

   public void setStatus(int status) {
      this._status = status;
   }

   public String toString() {
      return "HttpException(" + this._status + "," + this._reason + "," + super.getCause() + ")";
   }
}
