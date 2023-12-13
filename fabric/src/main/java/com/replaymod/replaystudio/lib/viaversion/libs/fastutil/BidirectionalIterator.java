package com.replaymod.replaystudio.lib.viaversion.libs.fastutil;

import java.util.Iterator;

public interface BidirectionalIterator<K> extends Iterator<K> {
   K previous();

   boolean hasPrevious();
}
