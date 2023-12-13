package com.replaymod.lib.com.googlecode.mp4parser.util;

import java.util.logging.Level;

public class JuliLogger extends Logger {
   java.util.logging.Logger logger;

   public JuliLogger(String name) {
      this.logger = java.util.logging.Logger.getLogger(name);
   }

   public void logDebug(String message) {
      this.logger.log(Level.FINE, message);
   }

   public void logWarn(String message) {
      this.logger.log(Level.WARNING, message);
   }

   public void logError(String message) {
      this.logger.log(Level.SEVERE, message);
   }
}
