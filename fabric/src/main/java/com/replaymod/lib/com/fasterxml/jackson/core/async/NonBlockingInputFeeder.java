package com.replaymod.lib.com.fasterxml.jackson.core.async;

public interface NonBlockingInputFeeder {
   boolean needMoreInput();

   void endOfInput();
}
