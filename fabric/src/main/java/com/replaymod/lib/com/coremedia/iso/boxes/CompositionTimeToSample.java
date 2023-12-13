package com.replaymod.lib.com.coremedia.iso.boxes;

import com.replaymod.lib.com.coremedia.iso.IsoTypeReader;
import com.replaymod.lib.com.coremedia.iso.IsoTypeWriter;
import com.replaymod.lib.com.googlecode.mp4parser.AbstractFullBox;
import com.replaymod.lib.com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.replaymod.lib.com.googlecode.mp4parser.util.CastUtils;
import com.replaymod.lib.org.aspectj.lang.JoinPoint;
import com.replaymod.lib.org.aspectj.runtime.reflect.Factory;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CompositionTimeToSample extends AbstractFullBox {
   public static final String TYPE = "ctts";
   List<CompositionTimeToSample.Entry> entries = Collections.emptyList();
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_0;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_1;

   static {
      ajc$preClinit();
      $assertionsDisabled = !CompositionTimeToSample.class.desiredAssertionStatus();
   }

   public CompositionTimeToSample() {
      super("ctts");
   }

   protected long getContentSize() {
      return (long)(8 + 8 * this.entries.size());
   }

   public List<CompositionTimeToSample.Entry> getEntries() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_0, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.entries;
   }

   public void setEntries(List<CompositionTimeToSample.Entry> entries) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_1, this, this, (Object)entries);
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.entries = entries;
   }

   public void _parseDetails(ByteBuffer content) {
      this.parseVersionAndFlags(content);
      int numberOfEntries = CastUtils.l2i(IsoTypeReader.readUInt32(content));
      this.entries = new ArrayList(numberOfEntries);

      for(int i = 0; i < numberOfEntries; ++i) {
         CompositionTimeToSample.Entry e = new CompositionTimeToSample.Entry(CastUtils.l2i(IsoTypeReader.readUInt32(content)), content.getInt());
         this.entries.add(e);
      }

   }

   protected void getContent(ByteBuffer byteBuffer) {
      this.writeVersionAndFlags(byteBuffer);
      IsoTypeWriter.writeUInt32(byteBuffer, (long)this.entries.size());
      Iterator var3 = this.entries.iterator();

      while(var3.hasNext()) {
         CompositionTimeToSample.Entry entry = (CompositionTimeToSample.Entry)var3.next();
         IsoTypeWriter.writeUInt32(byteBuffer, (long)entry.getCount());
         byteBuffer.putInt(entry.getOffset());
      }

   }

   public static int[] blowupCompositionTimes(List<CompositionTimeToSample.Entry> entries) {
      long numOfSamples = 0L;

      CompositionTimeToSample.Entry entry;
      for(Iterator var4 = entries.iterator(); var4.hasNext(); numOfSamples += (long)entry.getCount()) {
         entry = (CompositionTimeToSample.Entry)var4.next();
      }

      if (!$assertionsDisabled && numOfSamples > 2147483647L) {
         throw new AssertionError();
      } else {
         int[] decodingTime = new int[(int)numOfSamples];
         int current = 0;
         Iterator var6 = entries.iterator();

         while(var6.hasNext()) {
            CompositionTimeToSample.Entry entry = (CompositionTimeToSample.Entry)var6.next();

            for(int i = 0; i < entry.getCount(); ++i) {
               decodingTime[current++] = entry.getOffset();
            }
         }

         return decodingTime;
      }
   }

   // $FF: synthetic method
   private static void ajc$preClinit() {
      Factory var0 = new Factory("CompositionTimeToSample.java", CompositionTimeToSample.class);
      ajc$tjp_0 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getEntries", "com.replaymod.lib.com.coremedia.iso.boxes.CompositionTimeToSample", "", "", "", "java.util.List"), 57);
      ajc$tjp_1 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setEntries", "com.replaymod.lib.com.coremedia.iso.boxes.CompositionTimeToSample", "java.util.List", "entries", "", "void"), 61);
   }

   public static class Entry {
      int count;
      int offset;

      public Entry(int count, int offset) {
         this.count = count;
         this.offset = offset;
      }

      public int getCount() {
         return this.count;
      }

      public int getOffset() {
         return this.offset;
      }

      public void setCount(int count) {
         this.count = count;
      }

      public void setOffset(int offset) {
         this.offset = offset;
      }

      public String toString() {
         return "Entry{count=" + this.count + ", offset=" + this.offset + '}';
      }
   }
}
