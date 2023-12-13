package com.replaymod.lib.com.googlecode.mp4parser;

import com.replaymod.lib.com.coremedia.iso.IsoTypeReader;
import com.replaymod.lib.com.coremedia.iso.IsoTypeWriter;
import com.replaymod.lib.com.coremedia.iso.boxes.FullBox;
import com.replaymod.lib.com.googlecode.mp4parser.annotations.DoNotParseDetail;
import com.replaymod.lib.org.aspectj.lang.JoinPoint;
import com.replaymod.lib.org.aspectj.runtime.internal.Conversions;
import com.replaymod.lib.org.aspectj.runtime.reflect.Factory;
import java.nio.ByteBuffer;

public abstract class AbstractFullBox extends AbstractBox implements FullBox {
   private int version;
   private int flags;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_0;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_1;

   protected AbstractFullBox(String type) {
      super(type);
   }

   protected AbstractFullBox(String type, byte[] userType) {
      super(type, userType);
   }

   @DoNotParseDetail
   public int getVersion() {
      if (!this.isParsed) {
         this.parseDetails();
      }

      return this.version;
   }

   public void setVersion(int version) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_0, this, this, (Object)Conversions.intObject(version));
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.version = version;
   }

   @DoNotParseDetail
   public int getFlags() {
      if (!this.isParsed) {
         this.parseDetails();
      }

      return this.flags;
   }

   public void setFlags(int flags) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_1, this, this, (Object)Conversions.intObject(flags));
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.flags = flags;
   }

   protected final long parseVersionAndFlags(ByteBuffer content) {
      this.version = IsoTypeReader.readUInt8(content);
      this.flags = IsoTypeReader.readUInt24(content);
      return 4L;
   }

   protected final void writeVersionAndFlags(ByteBuffer bb) {
      IsoTypeWriter.writeUInt8(bb, this.version);
      IsoTypeWriter.writeUInt24(bb, this.flags);
   }

   static {
      ajc$preClinit();
   }

   // $FF: synthetic method
   private static void ajc$preClinit() {
      Factory var0 = new Factory("AbstractFullBox.java", AbstractFullBox.class);
      ajc$tjp_0 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setVersion", "com.replaymod.lib.com.googlecode.mp4parser.AbstractFullBox", "int", "version", "", "void"), 51);
      ajc$tjp_1 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setFlags", "com.replaymod.lib.com.googlecode.mp4parser.AbstractFullBox", "int", "flags", "", "void"), 64);
   }
}
