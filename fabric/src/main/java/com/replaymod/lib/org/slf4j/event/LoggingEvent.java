package com.replaymod.lib.org.slf4j.event;

import com.replaymod.lib.org.slf4j.Marker;

public interface LoggingEvent {
   Level getLevel();

   Marker getMarker();

   String getLoggerName();

   String getMessage();

   String getThreadName();

   Object[] getArgumentArray();

   long getTimeStamp();

   Throwable getThrowable();
}
