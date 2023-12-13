package com.replaymod.lib.com.coremedia.iso.boxes;

import com.replaymod.lib.com.coremedia.iso.IsoTypeReader;
import com.replaymod.lib.com.coremedia.iso.IsoTypeWriter;
import com.replaymod.lib.com.googlecode.mp4parser.AbstractFullBox;
import com.replaymod.lib.com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.replaymod.lib.com.googlecode.mp4parser.util.CastUtils;
import com.replaymod.lib.org.aspectj.lang.JoinPoint;
import com.replaymod.lib.org.aspectj.runtime.reflect.Factory;
import java.nio.ByteBuffer;

public class SyncSampleBox extends AbstractFullBox {
   public static final String TYPE = "stss";
   private long[] sampleNumber;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_0;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_1;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_2;

   public SyncSampleBox() {
      super("stss");
   }

   public long[] getSampleNumber() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_0, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.sampleNumber;
   }

   protected long getContentSize() {
      return (long)(this.sampleNumber.length * 4 + 8);
   }

   public void _parseDetails(ByteBuffer content) {
      this.parseVersionAndFlags(content);
      int entryCount = CastUtils.l2i(IsoTypeReader.readUInt32(content));
      this.sampleNumber = new long[entryCount];

      for(int i = 0; i < entryCount; ++i) {
         this.sampleNumber[i] = IsoTypeReader.readUInt32(content);
      }

   }

   protected void getContent(ByteBuffer byteBuffer) {
      this.writeVersionAndFlags(byteBuffer);
      IsoTypeWriter.writeUInt32(byteBuffer, (long)this.sampleNumber.length);
      long[] var6;
      int var5 = (var6 = this.sampleNumber).length;

      for(int var4 = 0; var4 < var5; ++var4) {
         long aSampleNumber = var6[var4];
         IsoTypeWriter.writeUInt32(byteBuffer, aSampleNumber);
      }

   }

   public String toString() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_1, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return "SyncSampleBox[entryCount=" + this.sampleNumber.length + "]";
   }

   public void setSampleNumber(long[] sampleNumber) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_2, this, this, (Object)sampleNumber);
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.sampleNumber = sampleNumber;
   }

   static {
      ajc$preClinit();
   }

   // $FF: synthetic method
   private static void ajc$preClinit() {
      Factory var0 = new Factory("SyncSampleBox.java", SyncSampleBox.class);
      ajc$tjp_0 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getSampleNumber", "com.replaymod.lib.com.coremedia.iso.boxes.SyncSampleBox", "", "", "", "[J"), 46);
      ajc$tjp_1 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "toString", "com.replaymod.lib.com.coremedia.iso.boxes.SyncSampleBox", "", "", "", "java.lang.String"), 77);
      ajc$tjp_2 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setSampleNumber", "com.replaymod.lib.com.coremedia.iso.boxes.SyncSampleBox", "[J", "sampleNumber", "", "void"), 81);
   }
}
