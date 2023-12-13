package com.replaymod.lib.org.slf4j.spi;

import com.replaymod.lib.org.slf4j.ILoggerFactory;

public interface LoggerFactoryBinder {
   ILoggerFactory getLoggerFactory();

   String getLoggerFactoryClassStr();
}
