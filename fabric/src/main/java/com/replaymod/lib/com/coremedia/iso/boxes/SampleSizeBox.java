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

public class SampleSizeBox extends AbstractFullBox {
   private long sampleSize;
   private long[] sampleSizes = new long[0];
   public static final String TYPE = "stsz";
   int sampleCount;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_0;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_1;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_2;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_3;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_4;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_5;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_6;

   public SampleSizeBox() {
      super("stsz");
   }

   public long getSampleSize() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_0, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.sampleSize;
   }

   public void setSampleSize(long sampleSize) {
      JoinPoint var3 = Factory.makeJP(ajc$tjp_1, this, this, (Object)Conversions.longObject(sampleSize));
      RequiresParseDetailAspect.aspectOf().before(var3);
      this.sampleSize = sampleSize;
   }

   public long getSampleSizeAtIndex(int index) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_2, this, this, (Object)Conversions.intObject(index));
      RequiresParseDetailAspect.aspectOf().before(var2);
      return this.sampleSize > 0L ? this.sampleSize : this.sampleSizes[index];
   }

   public long getSampleCount() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_3, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.sampleSize > 0L ? (long)this.sampleCount : (long)this.sampleSizes.length;
   }

   public long[] getSampleSizes() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_4, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.sampleSizes;
   }

   public void setSampleSizes(long[] sampleSizes) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_5, this, this, (Object)sampleSizes);
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.sampleSizes = sampleSizes;
   }

   protected long getContentSize() {
      return (long)(12 + (this.sampleSize == 0L ? this.sampleSizes.length * 4 : 0));
   }

   public void _parseDetails(ByteBuffer content) {
      this.parseVersionAndFlags(content);
      this.sampleSize = IsoTypeReader.readUInt32(content);
      this.sampleCount = CastUtils.l2i(IsoTypeReader.readUInt32(content));
      if (this.sampleSize == 0L) {
         this.sampleSizes = new long[this.sampleCount];

         for(int i = 0; i < this.sampleCount; ++i) {
            this.sampleSizes[i] = IsoTypeReader.readUInt32(content);
         }
      }

   }

   protected void getContent(ByteBuffer byteBuffer) {
      this.writeVersionAndFlags(byteBuffer);
      IsoTypeWriter.writeUInt32(byteBuffer, this.sampleSize);
      if (this.sampleSize == 0L) {
         IsoTypeWriter.writeUInt32(byteBuffer, (long)this.sampleSizes.length);
         long[] var6;
         int var5 = (var6 = this.sampleSizes).length;

         for(int var4 = 0; var4 < var5; ++var4) {
            long sampleSize1 = var6[var4];
            IsoTypeWriter.writeUInt32(byteBuffer, sampleSize1);
         }
      } else {
         IsoTypeWriter.writeUInt32(byteBuffer, (long)this.sampleCount);
      }

   }

   public String toString() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_6, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return "SampleSizeBox[sampleSize=" + this.getSampleSize() + ";sampleCount=" + this.getSampleCount() + "]";
   }

   static {
      ajc$preClinit();
   }

   // $FF: synthetic method
   private static void ajc$preClinit() {
      Factory var0 = new Factory("SampleSizeBox.java", SampleSizeBox.class);
      ajc$tjp_0 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getSampleSize", "com.replaymod.lib.com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "long"), 50);
      ajc$tjp_1 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setSampleSize", "com.replaymod.lib.com.coremedia.iso.boxes.SampleSizeBox", "long", "sampleSize", "", "void"), 54);
      ajc$tjp_2 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getSampleSizeAtIndex", "com.replaymod.lib.com.coremedia.iso.boxes.SampleSizeBox", "int", "index", "", "long"), 59);
      ajc$tjp_3 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getSampleCount", "com.replaymod.lib.com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "long"), 67);
      ajc$tjp_4 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getSampleSizes", "com.replaymod.lib.com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "[J"), 76);
      ajc$tjp_5 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setSampleSizes", "com.replaymod.lib.com.coremedia.iso.boxes.SampleSizeBox", "[J", "sampleSizes", "", "void"), 80);
      ajc$tjp_6 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "toString", "com.replaymod.lib.com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "java.lang.String"), 119);
   }
}
