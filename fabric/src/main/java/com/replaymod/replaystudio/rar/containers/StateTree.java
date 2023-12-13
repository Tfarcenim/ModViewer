package com.replaymod.replaystudio.rar.containers;

import com.replaymod.lib.com.github.steveice10.packetlib.io.NetInput;
import com.replaymod.lib.com.github.steveice10.packetlib.io.NetOutput;
import com.replaymod.replaystudio.rar.PacketSink;
import com.replaymod.replaystudio.rar.RandomAccessState;
import com.replaymod.replaystudio.rar.cache.ReadableCache;
import com.replaymod.replaystudio.rar.cache.WriteableCache;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map.Entry;

public abstract class StateTree<T> implements RandomAccessState {
   protected final int index;
   protected final TreeMap<Integer, T> map = new TreeMap();

   public StateTree(int index) {
      this.index = index;
   }

   protected abstract T read(NetInput var1) throws IOException;

   protected abstract void discard(T var1);

   public void load(PacketSink sink, ReadableCache cache) throws IOException {
      NetInput in = cache.seek(this.index);
      int time = 0;

      for(int i = in.readVarInt(); i > 0; --i) {
         time += in.readVarInt();
         this.map.put(time, this.read(in));
      }

   }

   public void unload(PacketSink sink, ReadableCache cache) throws IOException {
      this.map.values().forEach(this::discard);
      this.map.clear();
   }

   public abstract static class Builder<T> {
      protected final TreeMap<Integer, T> map = new TreeMap();

      protected abstract void write(NetOutput var1, T var2, int var3) throws IOException;

      protected abstract void discard(T var1);

      public void put(int time, T value) {
         T oldValue = this.map.put(time, value);
         if (oldValue != null) {
            this.discard(oldValue);
         }

      }

      public int build(WriteableCache cache) throws IOException {
         WriteableCache.Deferred out = cache.deferred();
         out.writeVarInt(this.map.size());
         int lastTime = 0;
         Iterator var4 = this.map.entrySet().iterator();

         while(var4.hasNext()) {
            Entry<Integer, T> entry = (Entry)var4.next();
            int time = (Integer)entry.getKey();
            out.writeVarInt(time - lastTime);
            lastTime = time;
            T value = entry.getValue();
            this.write(out, value, time);
         }

         this.map.clear();
         return out.commit();
      }
   }
}
