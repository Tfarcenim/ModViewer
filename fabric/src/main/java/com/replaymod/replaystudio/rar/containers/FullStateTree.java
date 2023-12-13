package com.replaymod.replaystudio.rar.containers;

import com.replaymod.replaystudio.rar.PacketSink;
import com.replaymod.replaystudio.rar.RandomAccessState;
import java.io.IOException;
import java.util.Map.Entry;

public abstract class FullStateTree<T> extends StateTree<T> implements RandomAccessState {
   public FullStateTree(int index) {
      super(index);
   }

   protected abstract void apply(PacketSink var1, T var2) throws IOException;

   public void play(PacketSink sink, int currentTimeStamp, int targetTime) throws IOException {
      Entry<Integer, T> lastUpdate = this.map.floorEntry(targetTime);
      if (lastUpdate != null && (Integer)lastUpdate.getKey() > currentTimeStamp) {
         this.apply(sink, lastUpdate.getValue());
      }

   }

   public void rewind(PacketSink sink, int currentTimeStamp, int targetTime) throws IOException {
      Entry<Integer, T> lastUpdate = this.map.floorEntry(targetTime);
      if (lastUpdate != null && !((Integer)lastUpdate.getKey()).equals(this.map.floorKey(currentTimeStamp))) {
         this.apply(sink, lastUpdate.getValue());
      }

   }

   public abstract static class Builder<T> extends StateTree.Builder<T> {
      public T getLatest() {
         return this.map.isEmpty() ? null : this.map.lastEntry().getValue();
      }
   }
}
