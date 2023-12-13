package com.replaymod.lib.org.slf4j.helpers;

import com.replaymod.lib.org.slf4j.ILoggerFactory;
import com.replaymod.lib.org.slf4j.Logger;

public class NOPLoggerFactory implements ILoggerFactory {
   public Logger getLogger(String name) {
      return NOPLogger.NOP_LOGGER;
   }
}
