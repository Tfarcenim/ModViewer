package com.replaymod.replaystudio.stream;

import com.replaymod.replaystudio.PacketData;
import com.replaymod.replaystudio.filter.StreamFilter;
import com.replaymod.replaystudio.lib.guava.base.Preconditions;
import com.replaymod.replaystudio.lib.guava.base.Supplier;
import com.replaymod.replaystudio.lib.guava.collect.Lists;
import com.replaymod.replaystudio.protocol.Packet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class AbstractPacketStream implements PacketStream {
   private final Queue<PacketData> inserted = new LinkedList();
   private final List<AbstractPacketStream.StreamElement> filters = new ArrayList();
   private AbstractPacketStream.StreamElement firstElement;

   public static AbstractPacketStream of(Supplier<PacketData> supplier) {
      return new AbstractPacketStream.AbstractPacketStreamImpl(supplier);
   }

   public void insert(PacketData packet) {
      this.inserted.add(packet);
   }

   public void insert(long time, Packet packet) {
      this.inserted.add(new PacketData(time, packet));
   }

   private void buildPipe() {
      Iterator<AbstractPacketStream.StreamElement> iter = this.filters.iterator();

      AbstractPacketStream.StreamElement l;
      AbstractPacketStream.StreamElement e;
      for(l = null; iter.hasNext(); l = e) {
         e = (AbstractPacketStream.StreamElement)iter.next();
         if (l == null) {
            this.firstElement = e;
         } else {
            l.next = e;
         }
      }

      if (l == null) {
         this.firstElement = new AbstractPacketStream.StreamElementEnd();
      } else {
         l.next = new AbstractPacketStream.StreamElementEnd();
      }

   }

   public void addFilter(StreamFilter filter) {
      this.addFilter(filter, -1L, -1L);
   }

   public void addFilter(StreamFilter filter, long from, long to) {
      this.filters.add(new AbstractPacketStream.StreamElement(new PacketStream.FilterInfo(filter, from, to)));
      this.buildPipe();
   }

   public void removeFilter(StreamFilter filter) {
      Iterator iter = this.filters.iterator();

      while(iter.hasNext()) {
         if (filter == ((AbstractPacketStream.StreamElement)iter.next()).filter.getFilter()) {
            iter.remove();
         }
      }

      this.buildPipe();
   }

   protected abstract PacketData nextInput();

   public PacketData next() throws IOException {
      while(true) {
         if (this.inserted.isEmpty()) {
            PacketData next = this.nextInput();
            if (next != null) {
               this.firstElement.process(next);
               continue;
            }
         }

         return (PacketData)this.inserted.poll();
      }
   }

   public Collection<PacketStream.FilterInfo> getFilters() {
      return Collections.unmodifiableList(Lists.transform(this.filters, (e) -> {
         return e.filter;
      }));
   }

   public List<PacketData> end() throws IOException {
      this.firstElement.process((PacketData)null);
      List<PacketData> result = new LinkedList(this.inserted);
      this.inserted.clear();
      return result;
   }

   protected abstract void cleanup();

   public String toString() {
      StringBuilder sb = new StringBuilder("PacketStream[");

      for(AbstractPacketStream.StreamElement e = this.firstElement; e != null; e = e.next) {
         sb.append(e);
         if (e.next != null) {
            sb.append(" -> ");
         }
      }

      sb.append("]");
      return sb.toString();
   }

   private class StreamElementEnd extends AbstractPacketStream.StreamElement {
      public StreamElementEnd() {
         super();
      }

      public void process(PacketData data) {
         if (data != null) {
            AbstractPacketStream.this.inserted.add(data);
         }

      }

      public String toString() {
         return "Out";
      }
   }

   private class StreamElement {
      private final PacketStream.FilterInfo filter;
      private final AbstractPacketStream.PacketStreamContext context;
      private final Queue<PacketData> inserted;
      private boolean active;
      private long lastTimestamp;
      private AbstractPacketStream.StreamElement next;

      protected StreamElement() {
         this.context = AbstractPacketStream.this.new PacketStreamContext(this);
         this.inserted = new LinkedList();
         this.filter = null;
      }

      public StreamElement(PacketStream.FilterInfo filter) {
         this.context = AbstractPacketStream.this.new PacketStreamContext(this);
         this.inserted = new LinkedList();
         this.filter = (PacketStream.FilterInfo)Preconditions.checkNotNull(filter);
      }

      public void process(PacketData data) throws IOException {
         boolean keep = true;
         Iterator var3;
         PacketData d;
         if (data != null && this.filter.applies(data.getTime())) {
            if (!this.active) {
               this.filter.getFilter().onStart(this.context);
               this.active = true;
            }

            keep = this.filter.getFilter().onPacket(this.context, data);
            if (!keep) {
               data.getPacket().getBuf().release();
            }
         } else if (this.active) {
            this.filter.getFilter().onEnd(this.context, this.lastTimestamp);
            this.active = false;

            for(var3 = this.inserted.iterator(); var3.hasNext(); this.next.process(d)) {
               d = (PacketData)var3.next();
               if (d.getTime() > this.lastTimestamp) {
                  this.lastTimestamp = d.getTime();
               }
            }

            this.inserted.clear();
         }

         if (data != null && keep) {
            if (data.getTime() > this.lastTimestamp) {
               this.lastTimestamp = data.getTime();
            }

            this.next.process(data);
         }

         for(var3 = this.inserted.iterator(); var3.hasNext(); this.next.process(d)) {
            d = (PacketData)var3.next();
            if (d.getTime() > this.lastTimestamp) {
               this.lastTimestamp = d.getTime();
            }
         }

         this.inserted.clear();
         if (data == null) {
            this.next.process((PacketData)null);
         }

      }

      public String toString() {
         return (this.active ? "" : "in") + "active " + this.filter;
      }
   }

   private class PacketStreamContext implements PacketStream {
      private final AbstractPacketStream.StreamElement element;

      public PacketStreamContext(AbstractPacketStream.StreamElement element) {
         this.element = (AbstractPacketStream.StreamElement)Preconditions.checkNotNull(element);
      }

      public void insert(PacketData packet) {
         this.element.inserted.add(packet);
      }

      public void insert(long time, Packet packet) {
         this.element.inserted.add(new PacketData(time, packet));
      }

      public void addFilter(StreamFilter filter) {
         AbstractPacketStream.this.addFilter(filter);
      }

      public void addFilter(StreamFilter filter, long from, long to) {
         AbstractPacketStream.this.addFilter(filter, from, to);
      }

      public void removeFilter(StreamFilter filter) {
         AbstractPacketStream.this.removeFilter(filter);
      }

      public Collection<PacketStream.FilterInfo> getFilters() {
         return AbstractPacketStream.this.getFilters();
      }

      public PacketData next() {
         throw new IllegalStateException("Cannot get next data from within stream pipeline");
      }

      public void start() {
         throw new IllegalStateException("Cannot start from within stream pipeline");
      }

      public List<PacketData> end() {
         throw new IllegalStateException("Cannot end from within stream pipeline");
      }
   }

   private static final class AbstractPacketStreamImpl extends AbstractPacketStream {
      private final Supplier<PacketData> supplier;

      public AbstractPacketStreamImpl(Supplier<PacketData> supplier) {
         this.supplier = supplier;
      }

      public void start() {
      }

      protected void cleanup() {
      }

      protected PacketData nextInput() {
         return (PacketData)this.supplier.get();
      }
   }
}
