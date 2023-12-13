package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import java.util.Iterator;

@GwtCompatible
public interface PeekingIterator<E> extends Iterator<E> {
   E peek();

   E next();

   void remove();
}
