package com.replaymod.replaystudio.rar.cache;

import com.replaymod.lib.com.github.steveice10.packetlib.io.NetInput;
import com.replaymod.lib.com.github.steveice10.packetlib.io.NetOutput;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import com.replaymod.replaystudio.rar.PacketSink;
import com.replaymod.replaystudio.util.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LazyPacketList {
   private final PacketTypeRegistry registry;
   private final int index;

   public LazyPacketList(PacketTypeRegistry registry, int index) {
      this.registry = registry;
      this.index = index;
   }

   public void read(PacketSink sink, ReadableCache cache) throws IOException {
      NetInput in = cache.seek(this.index);

      for(int i = in.readVarInt(); i > 0; --i) {
         sink.accept(Utils.readCompressedPacket(this.registry, in));
      }

   }

   public static class Builder {
      public final List<Packet> list = new ArrayList();

      public void add(Packet packet) {
         this.list.add(packet);
      }

      public int build(WriteableCache cache) throws IOException {
         int index = cache.index();
         NetOutput out = cache.write();
         out.writeVarInt(this.list.size());
         Iterator var4 = this.list.iterator();

         while(var4.hasNext()) {
            Packet packet = (Packet)var4.next();
            Utils.writeCompressedPacket(out, packet);
            packet.release();
         }

         return index;
      }
   }
}
