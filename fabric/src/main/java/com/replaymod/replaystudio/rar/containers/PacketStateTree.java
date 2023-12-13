package com.replaymod.replaystudio.rar.containers;

import com.replaymod.lib.com.github.steveice10.packetlib.io.NetInput;
import com.replaymod.lib.com.github.steveice10.packetlib.io.NetOutput;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import com.replaymod.replaystudio.rar.PacketSink;
import com.replaymod.replaystudio.util.Utils;
import java.io.IOException;

public class PacketStateTree extends FullStateTree<Packet> {
   private final PacketTypeRegistry registry;

   public PacketStateTree(PacketTypeRegistry registry, int index) {
      super(index);
      this.registry = registry;
   }

   protected Packet read(NetInput in) throws IOException {
      return Utils.readCompressedPacket(this.registry, in);
   }

   protected void discard(Packet value) {
      value.release();
   }

   protected void apply(PacketSink sink, Packet value) throws IOException {
      sink.accept(value.retain());
   }

   public static class Builder extends FullStateTree.Builder<Packet> {
      protected void write(NetOutput out, Packet value, int time) throws IOException {
         Utils.writeCompressedPacket(out, value);
         value.release();
      }

      protected void discard(Packet value) {
         value.release();
      }
   }
}
