package com.replaymod.replaystudio.rar.containers;

import com.replaymod.lib.com.github.steveice10.packetlib.io.NetInput;
import com.replaymod.lib.com.github.steveice10.packetlib.io.NetOutput;
import com.replaymod.replaystudio.rar.PacketSink;
import com.replaymod.replaystudio.util.IOBiConsumer;
import com.replaymod.replaystudio.util.Location;
import java.io.IOException;

public abstract class LocationStateTree extends FullStateTree<Location> {
   public LocationStateTree(int index) {
      super(index);
   }

   protected Location read(NetInput in) throws IOException {
      return new Location(in.readDouble(), in.readDouble(), in.readDouble(), in.readFloat(), in.readFloat());
   }

   protected void discard(Location value) {
   }

   public static LocationStateTree withApply(int index, IOBiConsumer<PacketSink, Location> apply) {
      return new LocationStateTree.ConsumerBased(index, apply);
   }

   private static class ConsumerBased extends LocationStateTree {
      private final IOBiConsumer<PacketSink, Location> apply;

      public ConsumerBased(int index, IOBiConsumer<PacketSink, Location> apply) {
         super(index);
         this.apply = apply;
      }

      protected void apply(PacketSink sink, Location value) throws IOException {
         this.apply.accept(sink, value);
      }
   }

   public static class Builder extends FullStateTree.Builder<Location> {
      protected void write(NetOutput out, Location value, int time) throws IOException {
         out.writeDouble(value.getX());
         out.writeDouble(value.getY());
         out.writeDouble(value.getZ());
         out.writeFloat(value.getYaw());
         out.writeFloat(value.getPitch());
      }

      protected void discard(Location value) {
      }
   }
}
