package com.replaymod.lib.com.coremedia.iso.boxes;

import com.replaymod.lib.com.coremedia.iso.IsoFile;
import com.replaymod.lib.com.coremedia.iso.IsoTypeReader;
import com.replaymod.lib.com.coremedia.iso.IsoTypeWriter;
import com.replaymod.lib.com.coremedia.iso.Utf8;
import com.replaymod.lib.com.googlecode.mp4parser.AbstractFullBox;
import com.replaymod.lib.com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.replaymod.lib.org.aspectj.lang.JoinPoint;
import com.replaymod.lib.org.aspectj.runtime.reflect.Factory;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HandlerBox extends AbstractFullBox {
   public static final String TYPE = "hdlr";
   public static final Map<String, String> readableTypes;
   private String handlerType;
   private String name = null;
   private long a;
   private long b;
   private long c;
   private boolean zeroTerm = true;
   private long shouldBeZeroButAppleWritesHereSomeValue;
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

   static {
      ajc$preClinit();
      HashMap hm = new HashMap();
      hm.put("odsm", "ObjectDescriptorStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
      hm.put("crsm", "ClockReferenceStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
      hm.put("sdsm", "SceneDescriptionStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
      hm.put("m7sm", "MPEG7Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
      hm.put("ocsm", "ObjectContentInfoStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
      hm.put("ipsm", "IPMP Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
      hm.put("mjsm", "MPEG-J Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
      hm.put("mdir", "Apple Meta Data iTunes Reader");
      hm.put("mp7b", "MPEG-7 binary XML");
      hm.put("mp7t", "MPEG-7 XML");
      hm.put("vide", "Video Track");
      hm.put("soun", "Sound Track");
      hm.put("hint", "Hint Track");
      hm.put("appl", "Apple specific");
      hm.put("meta", "Timed Metadata track - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
      readableTypes = Collections.unmodifiableMap(hm);
   }

   public HandlerBox() {
      super("hdlr");
   }

   public String getHandlerType() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_0, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.handlerType;
   }

   public void setName(String name) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_1, this, this, (Object)name);
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.name = name;
   }

   public void setHandlerType(String handlerType) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_2, this, this, (Object)handlerType);
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.handlerType = handlerType;
   }

   public String getName() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_3, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.name;
   }

   public String getHumanReadableTrackType() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_4, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return readableTypes.get(this.handlerType) != null ? (String)readableTypes.get(this.handlerType) : "Unknown Handler Type";
   }

   protected long getContentSize() {
      return this.zeroTerm ? (long)(25 + Utf8.utf8StringLengthInBytes(this.name)) : (long)(24 + Utf8.utf8StringLengthInBytes(this.name));
   }

   public void _parseDetails(ByteBuffer content) {
      this.parseVersionAndFlags(content);
      this.shouldBeZeroButAppleWritesHereSomeValue = IsoTypeReader.readUInt32(content);
      this.handlerType = IsoTypeReader.read4cc(content);
      this.a = IsoTypeReader.readUInt32(content);
      this.b = IsoTypeReader.readUInt32(content);
      this.c = IsoTypeReader.readUInt32(content);
      if (content.remaining() > 0) {
         this.name = IsoTypeReader.readString(content, content.remaining());
         if (this.name.endsWith("\u0000")) {
            this.name = this.name.substring(0, this.name.length() - 1);
            this.zeroTerm = true;
         } else {
            this.zeroTerm = false;
         }
      } else {
         this.zeroTerm = false;
      }

   }

   protected void getContent(ByteBuffer byteBuffer) {
      this.writeVersionAndFlags(byteBuffer);
      IsoTypeWriter.writeUInt32(byteBuffer, this.shouldBeZeroButAppleWritesHereSomeValue);
      byteBuffer.put(IsoFile.fourCCtoBytes(this.handlerType));
      IsoTypeWriter.writeUInt32(byteBuffer, this.a);
      IsoTypeWriter.writeUInt32(byteBuffer, this.b);
      IsoTypeWriter.writeUInt32(byteBuffer, this.c);
      if (this.name != null) {
         byteBuffer.put(Utf8.convert(this.name));
      }

      if (this.zeroTerm) {
         byteBuffer.put((byte)0);
      }

   }

   public String toString() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_5, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return "HandlerBox[handlerType=" + this.getHandlerType() + ";name=" + this.getName() + "]";
   }

   // $FF: synthetic method
   private static void ajc$preClinit() {
      Factory var0 = new Factory("HandlerBox.java", HandlerBox.class);
      ajc$tjp_0 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getHandlerType", "com.replaymod.lib.com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 78);
      ajc$tjp_1 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setName", "com.replaymod.lib.com.coremedia.iso.boxes.HandlerBox", "java.lang.String", "name", "", "void"), 87);
      ajc$tjp_2 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setHandlerType", "com.replaymod.lib.com.coremedia.iso.boxes.HandlerBox", "java.lang.String", "handlerType", "", "void"), 91);
      ajc$tjp_3 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getName", "com.replaymod.lib.com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 95);
      ajc$tjp_4 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getHumanReadableTrackType", "com.replaymod.lib.com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 99);
      ajc$tjp_5 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "toString", "com.replaymod.lib.com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 149);
   }
}
