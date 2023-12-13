package com.replaymod.lib.org.aspectj.lang.reflect;

public interface SourceLocation {
   Class getWithinType();

   String getFileName();

   int getLine();

   /** @deprecated */
   int getColumn();
}
