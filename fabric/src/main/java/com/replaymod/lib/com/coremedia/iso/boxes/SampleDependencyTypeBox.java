package com.replaymod.lib.com.coremedia.iso.boxes;

import com.replaymod.lib.com.coremedia.iso.IsoTypeReader;
import com.replaymod.lib.com.coremedia.iso.IsoTypeWriter;
import com.replaymod.lib.com.googlecode.mp4parser.AbstractFullBox;
import com.replaymod.lib.com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.replaymod.lib.org.aspectj.lang.JoinPoint;
import com.replaymod.lib.org.aspectj.runtime.reflect.Factory;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SampleDependencyTypeBox extends AbstractFullBox {
   public static final String TYPE = "sdtp";
   private List<SampleDependencyTypeBox.Entry> entries = new ArrayList();
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_0;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_1;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_2;

   public SampleDependencyTypeBox() {
      super("sdtp");
   }

   protected long getContentSize() {
      return (long)(4 + this.entries.size());
   }

   protected void getContent(ByteBuffer byteBuffer) {
      this.writeVersionAndFlags(byteBuffer);
      Iterator var3 = this.entries.iterator();

      while(var3.hasNext()) {
         SampleDependencyTypeBox.Entry entry = (SampleDependencyTypeBox.Entry)var3.next();
         IsoTypeWriter.writeUInt8(byteBuffer, entry.value);
      }

   }

   public void _parseDetails(ByteBuffer content) {
      this.parseVersionAndFlags(content);

      while(content.remaining() > 0) {
         this.entries.add(new SampleDependencyTypeBox.Entry(IsoTypeReader.readUInt8(content)));
      }

   }

   public List<SampleDependencyTypeBox.Entry> getEntries() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_0, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.entries;
   }

   public void setEntries(List<SampleDependencyTypeBox.Entry> entries) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_1, this, this, (Object)entries);
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.entries = entries;
   }

   public String toString() {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_2, this, this);
      RequiresParseDetailAspect.aspectOf().before(var2);
      StringBuilder sb = new StringBuilder();
      sb.append("SampleDependencyTypeBox");
      sb.append("{entries=").append(this.entries);
      sb.append('}');
      return sb.toString();
   }

   static {
      ajc$preClinit();
   }

   // $FF: synthetic method
   private static void ajc$preClinit() {
      Factory var0 = new Factory("SampleDependencyTypeBox.java", SampleDependencyTypeBox.class);
      ajc$tjp_0 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getEntries", "com.replaymod.lib.com.coremedia.iso.boxes.SampleDependencyTypeBox", "", "", "", "java.util.List"), 139);
      ajc$tjp_1 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setEntries", "com.replaymod.lib.com.coremedia.iso.boxes.SampleDependencyTypeBox", "java.util.List", "entries", "", "void"), 143);
      ajc$tjp_2 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "toString", "com.replaymod.lib.com.coremedia.iso.boxes.SampleDependencyTypeBox", "", "", "", "java.lang.String"), 148);
   }

   public static class Entry {
      private int value;

      public Entry(int value) {
         this.value = value;
      }

      public int getIsLeading() {
         return this.value >> 6 & 3;
      }

      public void setIsLeading(int res) {
         this.value = (res & 3) << 6 | this.value & 63;
      }

      public int getSampleDependsOn() {
         return this.value >> 4 & 3;
      }

      public void setSampleDependsOn(int sdo) {
         this.value = (sdo & 3) << 4 | this.value & 207;
      }

      public int getSampleIsDependentOn() {
         return this.value >> 2 & 3;
      }

      public void setSampleIsDependentOn(int sido) {
         this.value = (sido & 3) << 2 | this.value & 243;
      }

      public int getSampleHasRedundancy() {
         return this.value & 3;
      }

      public void setSampleHasRedundancy(int shr) {
         this.value = shr & 3 | this.value & 252;
      }

      public String toString() {
         return "Entry{isLeading=" + this.getIsLeading() + ", sampleDependsOn=" + this.getSampleDependsOn() + ", sampleIsDependentOn=" + this.getSampleIsDependentOn() + ", sampleHasRedundancy=" + this.getSampleHasRedundancy() + '}';
      }

      public boolean equals(Object o) {
         if (this == o) {
            return true;
         } else if (o != null && this.getClass() == o.getClass()) {
            SampleDependencyTypeBox.Entry entry = (SampleDependencyTypeBox.Entry)o;
            return this.value == entry.value;
         } else {
            return false;
         }
      }

      public int hashCode() {
         return this.value;
      }
   }
}
