package com.replaymod.lib.com.coremedia.iso.boxes;

import com.replaymod.lib.com.coremedia.iso.IsoTypeReader;
import com.replaymod.lib.com.coremedia.iso.IsoTypeWriter;
import com.replaymod.lib.com.googlecode.mp4parser.AbstractFullBox;
import com.replaymod.lib.com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.replaymod.lib.com.googlecode.mp4parser.util.CastUtils;
import com.replaymod.lib.org.aspectj.lang.JoinPoint;
import com.replaymod.lib.org.aspectj.runtime.internal.Conversions;
import com.replaymod.lib.org.aspectj.runtime.reflect.Factory;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SampleToChunkBox extends AbstractFullBox {
   List<SampleToChunkBox.Entry> entries = Collections.emptyList();
   public static final String TYPE = "stsc";
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_0;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_1;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_2;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_3;

   public SampleToChunkBox() {
      super("stsc");
   }

   public List<SampleToChunkBox.Entry> getEntries() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_0, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.entries;
   }

   public void setEntries(List<SampleToChunkBox.Entry> entries) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_1, this, this, (Object)entries);
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.entries = entries;
   }

   protected long getContentSize() {
      return (long)(this.entries.size() * 12 + 8);
   }

   public void _parseDetails(ByteBuffer content) {
      this.parseVersionAndFlags(content);
      int entryCount = CastUtils.l2i(IsoTypeReader.readUInt32(content));
      this.entries = new ArrayList(entryCount);

      for(int i = 0; i < entryCount; ++i) {
         this.entries.add(new SampleToChunkBox.Entry(IsoTypeReader.readUInt32(content), IsoTypeReader.readUInt32(content), IsoTypeReader.readUInt32(content)));
      }

   }

   protected void getContent(ByteBuffer byteBuffer) {
      this.writeVersionAndFlags(byteBuffer);
      IsoTypeWriter.writeUInt32(byteBuffer, (long)this.entries.size());
      Iterator var3 = this.entries.iterator();

      while(var3.hasNext()) {
         SampleToChunkBox.Entry entry = (SampleToChunkBox.Entry)var3.next();
         IsoTypeWriter.writeUInt32(byteBuffer, entry.getFirstChunk());
         IsoTypeWriter.writeUInt32(byteBuffer, entry.getSamplesPerChunk());
         IsoTypeWriter.writeUInt32(byteBuffer, entry.getSampleDescriptionIndex());
      }

   }

   public String toString() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_2, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return "SampleToChunkBox[entryCount=" + this.entries.size() + "]";
   }

   public long[] blowup(int chunkCount) {
      JoinPoint var7 = Factory.makeJP(ajc$tjp_3, this, this, (Object)Conversions.intObject(chunkCount));
      RequiresParseDetailAspect.aspectOf().before(var7);
      long[] numberOfSamples = new long[chunkCount];
      boolean var10000 = false;
      List sampleToChunkEntries = new LinkedList(this.entries);
      Collections.reverse(sampleToChunkEntries);
      Iterator iterator = sampleToChunkEntries.iterator();
      SampleToChunkBox.Entry currentEntry = (SampleToChunkBox.Entry)iterator.next();

      for(int i = numberOfSamples.length; i > 1; --i) {
         numberOfSamples[i - 1] = currentEntry.getSamplesPerChunk();
         if ((long)i == currentEntry.getFirstChunk()) {
            currentEntry = (SampleToChunkBox.Entry)iterator.next();
         }
      }

      numberOfSamples[0] = currentEntry.getSamplesPerChunk();
      return numberOfSamples;
   }

   static {
      ajc$preClinit();
   }

   // $FF: synthetic method
   private static void ajc$preClinit() {
      Factory var0 = new Factory("SampleToChunkBox.java", SampleToChunkBox.class);
      ajc$tjp_0 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getEntries", "com.replaymod.lib.com.coremedia.iso.boxes.SampleToChunkBox", "", "", "", "java.util.List"), 47);
      ajc$tjp_1 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setEntries", "com.replaymod.lib.com.coremedia.iso.boxes.SampleToChunkBox", "java.util.List", "entries", "", "void"), 51);
      ajc$tjp_2 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "toString", "com.replaymod.lib.com.coremedia.iso.boxes.SampleToChunkBox", "", "", "", "java.lang.String"), 84);
      ajc$tjp_3 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "blowup", "com.replaymod.lib.com.coremedia.iso.boxes.SampleToChunkBox", "int", "chunkCount", "", "[J"), 95);
   }

   public static class Entry {
      long firstChunk;
      long samplesPerChunk;
      long sampleDescriptionIndex;

      public Entry(long firstChunk, long samplesPerChunk, long sampleDescriptionIndex) {
         this.firstChunk = firstChunk;
         this.samplesPerChunk = samplesPerChunk;
         this.sampleDescriptionIndex = sampleDescriptionIndex;
      }

      public long getFirstChunk() {
         return this.firstChunk;
      }

      public void setFirstChunk(long firstChunk) {
         this.firstChunk = firstChunk;
      }

      public long getSamplesPerChunk() {
         return this.samplesPerChunk;
      }

      public void setSamplesPerChunk(long samplesPerChunk) {
         this.samplesPerChunk = samplesPerChunk;
      }

      public long getSampleDescriptionIndex() {
         return this.sampleDescriptionIndex;
      }

      public void setSampleDescriptionIndex(long sampleDescriptionIndex) {
         this.sampleDescriptionIndex = sampleDescriptionIndex;
      }

      public String toString() {
         return "Entry{firstChunk=" + this.firstChunk + ", samplesPerChunk=" + this.samplesPerChunk + ", sampleDescriptionIndex=" + this.sampleDescriptionIndex + '}';
      }

      public boolean equals(Object o) {
         if (this == o) {
            return true;
         } else if (o != null && this.getClass() == o.getClass()) {
            SampleToChunkBox.Entry entry = (SampleToChunkBox.Entry)o;
            if (this.firstChunk != entry.firstChunk) {
               return false;
            } else if (this.sampleDescriptionIndex != entry.sampleDescriptionIndex) {
               return false;
            } else {
               return this.samplesPerChunk == entry.samplesPerChunk;
            }
         } else {
            return false;
         }
      }

      public int hashCode() {
         int result = (int)(this.firstChunk ^ this.firstChunk >>> 32);
         result = 31 * result + (int)(this.samplesPerChunk ^ this.samplesPerChunk >>> 32);
         result = 31 * result + (int)(this.sampleDescriptionIndex ^ this.sampleDescriptionIndex >>> 32);
         return result;
      }
   }
}
