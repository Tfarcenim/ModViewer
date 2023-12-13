package com.replaymod.replaystudio.rar.containers;

import com.replaymod.replaystudio.rar.PacketSink;
import com.replaymod.replaystudio.rar.RandomAccessState;
import java.io.IOException;
import java.util.Iterator;

public abstract class DiffStateTree<T> extends StateTree<T> implements RandomAccessState {
   public DiffStateTree(int index) {
      super(index);
   }

   protected abstract void play(PacketSink var1, T var2) throws IOException;

   protected abstract void rewind(PacketSink var1, T var2) throws IOException;

   public void play(PacketSink sink, int currentTimeStamp, int targetTime) throws IOException {
      Iterator var4 = this.map.subMap(currentTimeStamp, false, targetTime, true).values().iterator();

      while(var4.hasNext()) {
         T update = var4.next();
         this.play(sink, update);
      }

   }

   public void rewind(PacketSink sink, int currentTimeStamp, int targetTime) throws IOException {
      Iterator var4 = this.map.subMap(targetTime, false, currentTimeStamp, true).descendingMap().values().iterator();

      while(var4.hasNext()) {
         T update = var4.next();
         this.rewind(sink, update);
      }

   }

   public abstract static class Builder<T> extends StateTree.Builder<T> {
   }
}
