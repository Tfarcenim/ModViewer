package com.replaymod.replaystudio.lib.guava.cache;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;

@GwtCompatible
interface LongAddable {
   void increment();

   void add(long var1);

   long sum();
}
