package com.replaymod.lib.com.coremedia.iso.boxes;

import com.replaymod.lib.com.coremedia.iso.IsoTypeReader;
import com.replaymod.lib.com.coremedia.iso.IsoTypeWriter;
import com.replaymod.lib.com.googlecode.mp4parser.AbstractFullBox;
import com.replaymod.lib.com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.replaymod.lib.com.googlecode.mp4parser.util.DateHelper;
import com.replaymod.lib.com.googlecode.mp4parser.util.Logger;
import com.replaymod.lib.org.aspectj.lang.JoinPoint;
import com.replaymod.lib.org.aspectj.runtime.internal.Conversions;
import com.replaymod.lib.org.aspectj.runtime.reflect.Factory;
import java.nio.ByteBuffer;
import java.util.Date;

public class MediaHeaderBox extends AbstractFullBox {
   private static Logger LOG;
   public static final String TYPE = "mdhd";
   private Date creationTime = new Date();
   private Date modificationTime = new Date();
   private long timescale;
   private long duration;
   private String language = "eng";
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
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_7;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_8;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_9;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_10;

   static {
      ajc$preClinit();
      LOG = Logger.getLogger(MediaHeaderBox.class);
   }

   public MediaHeaderBox() {
      super("mdhd");
   }

   public Date getCreationTime() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_0, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.creationTime;
   }

   public Date getModificationTime() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_1, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.modificationTime;
   }

   public long getTimescale() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_2, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.timescale;
   }

   public long getDuration() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_3, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.duration;
   }

   public String getLanguage() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_4, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.language;
   }

   protected long getContentSize() {
      long contentSize = 4L;
      if (this.getVersion() == 1) {
         contentSize += 28L;
      } else {
         contentSize += 16L;
      }

      contentSize += 2L;
      contentSize += 2L;
      return contentSize;
   }

   public void setCreationTime(Date creationTime) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_5, this, this, (Object)creationTime);
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.creationTime = creationTime;
   }

   public void setModificationTime(Date modificationTime) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_6, this, this, (Object)modificationTime);
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.modificationTime = modificationTime;
   }

   public void setTimescale(long timescale) {
      JoinPoint var3 = Factory.makeJP(ajc$tjp_7, this, this, (Object)Conversions.longObject(timescale));
      RequiresParseDetailAspect.aspectOf().before(var3);
      this.timescale = timescale;
   }

   public void setDuration(long duration) {
      JoinPoint var3 = Factory.makeJP(ajc$tjp_8, this, this, (Object)Conversions.longObject(duration));
      RequiresParseDetailAspect.aspectOf().before(var3);
      this.duration = duration;
   }

   public void setLanguage(String language) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_9, this, this, (Object)language);
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.language = language;
   }

   public void _parseDetails(ByteBuffer content) {
      this.parseVersionAndFlags(content);
      if (this.getVersion() == 1) {
         this.creationTime = DateHelper.convert(IsoTypeReader.readUInt64(content));
         this.modificationTime = DateHelper.convert(IsoTypeReader.readUInt64(content));
         this.timescale = IsoTypeReader.readUInt32(content);
         this.duration = content.getLong();
      } else {
         this.creationTime = DateHelper.convert(IsoTypeReader.readUInt32(content));
         this.modificationTime = DateHelper.convert(IsoTypeReader.readUInt32(content));
         this.timescale = IsoTypeReader.readUInt32(content);
         this.duration = (long)content.getInt();
      }

      if (this.duration < -1L) {
         LOG.logWarn("mdhd duration is not in expected range");
      }

      this.language = IsoTypeReader.readIso639(content);
      IsoTypeReader.readUInt16(content);
   }

   public String toString() {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_10, this, this);
      RequiresParseDetailAspect.aspectOf().before(var2);
      StringBuilder result = new StringBuilder();
      result.append("MediaHeaderBox[");
      result.append("creationTime=").append(this.getCreationTime());
      result.append(";");
      result.append("modificationTime=").append(this.getModificationTime());
      result.append(";");
      result.append("timescale=").append(this.getTimescale());
      result.append(";");
      result.append("duration=").append(this.getDuration());
      result.append(";");
      result.append("language=").append(this.getLanguage());
      result.append("]");
      return result.toString();
   }

   protected void getContent(ByteBuffer byteBuffer) {
      this.writeVersionAndFlags(byteBuffer);
      if (this.getVersion() == 1) {
         IsoTypeWriter.writeUInt64(byteBuffer, DateHelper.convert(this.creationTime));
         IsoTypeWriter.writeUInt64(byteBuffer, DateHelper.convert(this.modificationTime));
         IsoTypeWriter.writeUInt32(byteBuffer, this.timescale);
         byteBuffer.putLong(this.duration);
      } else {
         IsoTypeWriter.writeUInt32(byteBuffer, DateHelper.convert(this.creationTime));
         IsoTypeWriter.writeUInt32(byteBuffer, DateHelper.convert(this.modificationTime));
         IsoTypeWriter.writeUInt32(byteBuffer, this.timescale);
         byteBuffer.putInt((int)this.duration);
      }

      IsoTypeWriter.writeIso639(byteBuffer, this.language);
      IsoTypeWriter.writeUInt16(byteBuffer, 0);
   }

   // $FF: synthetic method
   private static void ajc$preClinit() {
      Factory var0 = new Factory("MediaHeaderBox.java", MediaHeaderBox.class);
      ajc$tjp_0 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getCreationTime", "com.replaymod.lib.com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.util.Date"), 48);
      ajc$tjp_1 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getModificationTime", "com.replaymod.lib.com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.util.Date"), 52);
      ajc$tjp_10 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "toString", "com.replaymod.lib.com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.lang.String"), 125);
      ajc$tjp_2 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getTimescale", "com.replaymod.lib.com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "long"), 56);
      ajc$tjp_3 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getDuration", "com.replaymod.lib.com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "long"), 60);
      ajc$tjp_4 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getLanguage", "com.replaymod.lib.com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.lang.String"), 64);
      ajc$tjp_5 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setCreationTime", "com.replaymod.lib.com.coremedia.iso.boxes.MediaHeaderBox", "java.util.Date", "creationTime", "", "void"), 81);
      ajc$tjp_6 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setModificationTime", "com.replaymod.lib.com.coremedia.iso.boxes.MediaHeaderBox", "java.util.Date", "modificationTime", "", "void"), 85);
      ajc$tjp_7 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setTimescale", "com.replaymod.lib.com.coremedia.iso.boxes.MediaHeaderBox", "long", "timescale", "", "void"), 89);
      ajc$tjp_8 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setDuration", "com.replaymod.lib.com.coremedia.iso.boxes.MediaHeaderBox", "long", "duration", "", "void"), 93);
      ajc$tjp_9 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setLanguage", "com.replaymod.lib.com.coremedia.iso.boxes.MediaHeaderBox", "java.lang.String", "language", "", "void"), 97);
   }
}
