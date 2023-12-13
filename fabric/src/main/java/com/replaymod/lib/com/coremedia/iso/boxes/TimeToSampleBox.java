package com.replaymod.lib.com.coremedia.iso.boxes;

import com.replaymod.lib.com.coremedia.iso.IsoTypeReader;
import com.replaymod.lib.com.coremedia.iso.IsoTypeWriter;
import com.replaymod.lib.com.googlecode.mp4parser.AbstractFullBox;
import com.replaymod.lib.com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.replaymod.lib.com.googlecode.mp4parser.util.CastUtils;
import com.replaymod.lib.org.aspectj.lang.JoinPoint;
import com.replaymod.lib.org.aspectj.runtime.reflect.Factory;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class TimeToSampleBox extends AbstractFullBox {
   public static final String TYPE = "stts";
   List<TimeToSampleBox.Entry> entries = Collections.emptyList();
   static Map<List<TimeToSampleBox.Entry>, SoftReference<long[]>> cache;
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_0;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_1;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_2;

   static {
      ajc$preClinit();
      $assertionsDisabled = !TimeToSampleBox.class.desiredAssertionStatus();
      cache = new WeakHashMap();
   }

   public TimeToSampleBox() {
      super("stts");
   }

   protected long getContentSize() {
      return (long)(8 + this.entries.size() * 8);
   }

   public void _parseDetails(ByteBuffer content) {
      this.parseVersionAndFlags(content);
      int entryCount = CastUtils.l2i(IsoTypeReader.readUInt32(content));
      this.entries = new ArrayList(entryCount);

      for(int i = 0; i < entryCount; ++i) {
         this.entries.add(new TimeToSampleBox.Entry(IsoTypeReader.readUInt32(content), IsoTypeReader.readUInt32(content)));
      }

   }

   protected void getContent(ByteBuffer byteBuffer) {
      this.writeVersionAndFlags(byteBuffer);
      IsoTypeWriter.writeUInt32(byteBuffer, (long)this.entries.size());
      Iterator var3 = this.entries.iterator();

      while(var3.hasNext()) {
         TimeToSampleBox.Entry entry = (TimeToSampleBox.Entry)var3.next();
         IsoTypeWriter.writeUInt32(byteBuffer, entry.getCount());
         IsoTypeWriter.writeUInt32(byteBuffer, entry.getDelta());
      }

   }

   public List<TimeToSampleBox.Entry> getEntries() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_0, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.entries;
   }

   public void setEntries(List<TimeToSampleBox.Entry> entries) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_1, this, this, (Object)entries);
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.entries = entries;
   }

   public String toString() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_2, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return "TimeToSampleBox[entryCount=" + this.entries.size() + "]";
   }

   public static synchronized long[] blowupTimeToSamples(List<TimeToSampleBox.Entry> entries) {
      SoftReference cacheEntry;
      long[] cacheVal;
      if ((cacheEntry = (SoftReference)cache.get(entries)) != null && (cacheVal = (long[])cacheEntry.get()) != null) {
         return cacheVal;
      } else {
         long numOfSamples = 0L;

         TimeToSampleBox.Entry entry;
         for(Iterator var5 = entries.iterator(); var5.hasNext(); numOfSamples += entry.getCount()) {
            entry = (TimeToSampleBox.Entry)var5.next();
         }

         if (!$assertionsDisabled && numOfSamples > 2147483647L) {
            throw new AssertionError();
         } else {
            long[] decodingTime = new long[(int)numOfSamples];
            int current = 0;
            Iterator var7 = entries.iterator();

            while(var7.hasNext()) {
               TimeToSampleBox.Entry entry = (TimeToSampleBox.Entry)var7.next();

               for(int i = 0; (long)i < entry.getCount(); ++i) {
                  decodingTime[current++] = entry.getDelta();
               }
            }

            cache.put(entries, new SoftReference(decodingTime));
            return decodingTime;
         }
      }
   }

   // $FF: synthetic method
   private static void ajc$preClinit() {
      Factory var0 = new Factory("TimeToSampleBox.java", TimeToSampleBox.class);
      ajc$tjp_0 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getEntries", "com.replaymod.lib.com.coremedia.iso.boxes.TimeToSampleBox", "", "", "", "java.util.List"), 79);
      ajc$tjp_1 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setEntries", "com.replaymod.lib.com.coremedia.iso.boxes.TimeToSampleBox", "java.util.List", "entries", "", "void"), 83);
      ajc$tjp_2 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "toString", "com.replaymod.lib.com.coremedia.iso.boxes.TimeToSampleBox", "", "", "", "java.lang.String"), 87);
   }

   public static class Entry {
      long count;
      long delta;

      public Entry(long count, long delta) {
         this.count = count;
         this.delta = delta;
      }

      public long getCount() {
         return this.count;
      }

      public long getDelta() {
         return this.delta;
      }

      public void setCount(long count) {
         this.count = count;
      }

      public void setDelta(long delta) {
         this.delta = delta;
      }

      public String toString() {
         return "Entry{count=" + this.count + ", delta=" + this.delta + '}';
      }
   }
}
