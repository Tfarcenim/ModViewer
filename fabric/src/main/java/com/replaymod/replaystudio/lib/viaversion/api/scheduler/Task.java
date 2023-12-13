package com.replaymod.replaystudio.lib.viaversion.api.scheduler;

public interface Task {
   TaskStatus status();

   void cancel();
}
