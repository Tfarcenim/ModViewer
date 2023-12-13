package com.replaymod.lib.com.coremedia.iso.boxes;

import com.replaymod.lib.com.coremedia.iso.IsoTypeReader;
import com.replaymod.lib.com.coremedia.iso.IsoTypeWriter;
import com.replaymod.lib.com.googlecode.mp4parser.AbstractFullBox;
import com.replaymod.lib.com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.replaymod.lib.com.googlecode.mp4parser.util.DateHelper;
import com.replaymod.lib.com.googlecode.mp4parser.util.Logger;
import com.replaymod.lib.com.googlecode.mp4parser.util.Matrix;
import com.replaymod.lib.org.aspectj.lang.JoinPoint;
import com.replaymod.lib.org.aspectj.runtime.internal.Conversions;
import com.replaymod.lib.org.aspectj.runtime.reflect.Factory;
import java.nio.ByteBuffer;
import java.util.Date;

public class MovieHeaderBox extends AbstractFullBox {
   private static Logger LOG;
   private Date creationTime;
   private Date modificationTime;
   private long timescale;
   private long duration;
   private double rate = 1.0D;
   private float volume = 1.0F;
   private Matrix matrix;
   private long nextTrackId;
   private int previewTime;
   private int previewDuration;
   private int posterTime;
   private int selectionTime;
   private int selectionDuration;
   private int currentTime;
   public static final String TYPE = "mvhd";
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
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_11;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_12;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_13;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_14;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_15;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_16;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_17;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_18;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_19;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_20;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_21;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_22;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_23;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_24;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_25;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_26;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_27;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_28;

   static {
      ajc$preClinit();
      LOG = Logger.getLogger(MovieHeaderBox.class);
   }

   public MovieHeaderBox() {
      super("mvhd");
      this.matrix = Matrix.ROTATE_0;
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

   public double getRate() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_4, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.rate;
   }

   public float getVolume() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_5, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.volume;
   }

   public Matrix getMatrix() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_6, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.matrix;
   }

   public long getNextTrackId() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_7, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.nextTrackId;
   }

   protected long getContentSize() {
      long contentSize = 4L;
      if (this.getVersion() == 1) {
         contentSize += 28L;
      } else {
         contentSize += 16L;
      }

      contentSize += 80L;
      return contentSize;
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
         LOG.logWarn("mvhd duration is not in expected range");
      }

      this.rate = IsoTypeReader.readFixedPoint1616(content);
      this.volume = IsoTypeReader.readFixedPoint88(content);
      IsoTypeReader.readUInt16(content);
      IsoTypeReader.readUInt32(content);
      IsoTypeReader.readUInt32(content);
      this.matrix = Matrix.fromByteBuffer(content);
      this.previewTime = content.getInt();
      this.previewDuration = content.getInt();
      this.posterTime = content.getInt();
      this.selectionTime = content.getInt();
      this.selectionDuration = content.getInt();
      this.currentTime = content.getInt();
      this.nextTrackId = IsoTypeReader.readUInt32(content);
   }

   public String toString() {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_8, this, this);
      RequiresParseDetailAspect.aspectOf().before(var2);
      StringBuilder result = new StringBuilder();
      result.append("MovieHeaderBox[");
      result.append("creationTime=").append(this.getCreationTime());
      result.append(";");
      result.append("modificationTime=").append(this.getModificationTime());
      result.append(";");
      result.append("timescale=").append(this.getTimescale());
      result.append(";");
      result.append("duration=").append(this.getDuration());
      result.append(";");
      result.append("rate=").append(this.getRate());
      result.append(";");
      result.append("volume=").append(this.getVolume());
      result.append(";");
      result.append("matrix=").append(this.matrix);
      result.append(";");
      result.append("nextTrackId=").append(this.getNextTrackId());
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

      IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.rate);
      IsoTypeWriter.writeFixedPoint88(byteBuffer, (double)this.volume);
      IsoTypeWriter.writeUInt16(byteBuffer, 0);
      IsoTypeWriter.writeUInt32(byteBuffer, 0L);
      IsoTypeWriter.writeUInt32(byteBuffer, 0L);
      this.matrix.getContent(byteBuffer);
      byteBuffer.putInt(this.previewTime);
      byteBuffer.putInt(this.previewDuration);
      byteBuffer.putInt(this.posterTime);
      byteBuffer.putInt(this.selectionTime);
      byteBuffer.putInt(this.selectionDuration);
      byteBuffer.putInt(this.currentTime);
      IsoTypeWriter.writeUInt32(byteBuffer, this.nextTrackId);
   }

   public void setCreationTime(Date creationTime) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_9, this, this, (Object)creationTime);
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.creationTime = creationTime;
      if (DateHelper.convert(creationTime) >= 4294967296L) {
         this.setVersion(1);
      }

   }

   public void setModificationTime(Date modificationTime) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_10, this, this, (Object)modificationTime);
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.modificationTime = modificationTime;
      if (DateHelper.convert(modificationTime) >= 4294967296L) {
         this.setVersion(1);
      }

   }

   public void setTimescale(long timescale) {
      JoinPoint var3 = Factory.makeJP(ajc$tjp_11, this, this, (Object)Conversions.longObject(timescale));
      RequiresParseDetailAspect.aspectOf().before(var3);
      this.timescale = timescale;
   }

   public void setDuration(long duration) {
      JoinPoint var3 = Factory.makeJP(ajc$tjp_12, this, this, (Object)Conversions.longObject(duration));
      RequiresParseDetailAspect.aspectOf().before(var3);
      this.duration = duration;
      if (duration >= 4294967296L) {
         this.setVersion(1);
      }

   }

   public void setRate(double rate) {
      JoinPoint var3 = Factory.makeJP(ajc$tjp_13, this, this, (Object)Conversions.doubleObject(rate));
      RequiresParseDetailAspect.aspectOf().before(var3);
      this.rate = rate;
   }

   public void setVolume(float volume) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_14, this, this, (Object)Conversions.floatObject(volume));
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.volume = volume;
   }

   public void setMatrix(Matrix matrix) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_15, this, this, (Object)matrix);
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.matrix = matrix;
   }

   public void setNextTrackId(long nextTrackId) {
      JoinPoint var3 = Factory.makeJP(ajc$tjp_16, this, this, (Object)Conversions.longObject(nextTrackId));
      RequiresParseDetailAspect.aspectOf().before(var3);
      this.nextTrackId = nextTrackId;
   }

   public int getPreviewTime() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_17, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.previewTime;
   }

   public void setPreviewTime(int previewTime) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_18, this, this, (Object)Conversions.intObject(previewTime));
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.previewTime = previewTime;
   }

   public int getPreviewDuration() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_19, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.previewDuration;
   }

   public void setPreviewDuration(int previewDuration) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_20, this, this, (Object)Conversions.intObject(previewDuration));
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.previewDuration = previewDuration;
   }

   public int getPosterTime() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_21, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.posterTime;
   }

   public void setPosterTime(int posterTime) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_22, this, this, (Object)Conversions.intObject(posterTime));
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.posterTime = posterTime;
   }

   public int getSelectionTime() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_23, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.selectionTime;
   }

   public void setSelectionTime(int selectionTime) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_24, this, this, (Object)Conversions.intObject(selectionTime));
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.selectionTime = selectionTime;
   }

   public int getSelectionDuration() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_25, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.selectionDuration;
   }

   public void setSelectionDuration(int selectionDuration) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_26, this, this, (Object)Conversions.intObject(selectionDuration));
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.selectionDuration = selectionDuration;
   }

   public int getCurrentTime() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_27, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.currentTime;
   }

   public void setCurrentTime(int currentTime) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_28, this, this, (Object)Conversions.intObject(currentTime));
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.currentTime = currentTime;
   }

   // $FF: synthetic method
   private static void ajc$preClinit() {
      Factory var0 = new Factory("MovieHeaderBox.java", MovieHeaderBox.class);
      ajc$tjp_0 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getCreationTime", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.util.Date"), 66);
      ajc$tjp_1 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getModificationTime", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.util.Date"), 70);
      ajc$tjp_10 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setModificationTime", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "java.util.Date", "modificationTime", "", "void"), 212);
      ajc$tjp_11 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setTimescale", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "long", "timescale", "", "void"), 220);
      ajc$tjp_12 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setDuration", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "long", "duration", "", "void"), 224);
      ajc$tjp_13 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setRate", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "double", "rate", "", "void"), 231);
      ajc$tjp_14 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setVolume", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "float", "volume", "", "void"), 235);
      ajc$tjp_15 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setMatrix", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "com.replaymod.lib.com.googlecode.mp4parser.util.Matrix", "matrix", "", "void"), 239);
      ajc$tjp_16 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setNextTrackId", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "long", "nextTrackId", "", "void"), 243);
      ajc$tjp_17 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getPreviewTime", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 247);
      ajc$tjp_18 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setPreviewTime", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "int", "previewTime", "", "void"), 251);
      ajc$tjp_19 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getPreviewDuration", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 255);
      ajc$tjp_2 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getTimescale", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 74);
      ajc$tjp_20 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setPreviewDuration", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "int", "previewDuration", "", "void"), 259);
      ajc$tjp_21 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getPosterTime", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 263);
      ajc$tjp_22 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setPosterTime", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "int", "posterTime", "", "void"), 267);
      ajc$tjp_23 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getSelectionTime", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 271);
      ajc$tjp_24 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setSelectionTime", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "int", "selectionTime", "", "void"), 275);
      ajc$tjp_25 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getSelectionDuration", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 279);
      ajc$tjp_26 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setSelectionDuration", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "int", "selectionDuration", "", "void"), 283);
      ajc$tjp_27 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getCurrentTime", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 287);
      ajc$tjp_28 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setCurrentTime", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "int", "currentTime", "", "void"), 291);
      ajc$tjp_3 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getDuration", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 78);
      ajc$tjp_4 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getRate", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "double"), 82);
      ajc$tjp_5 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getVolume", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "float"), 86);
      ajc$tjp_6 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getMatrix", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "com.replaymod.lib.com.googlecode.mp4parser.util.Matrix"), 90);
      ajc$tjp_7 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getNextTrackId", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 94);
      ajc$tjp_8 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "toString", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.lang.String"), 148);
      ajc$tjp_9 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setCreationTime", "com.replaymod.lib.com.coremedia.iso.boxes.MovieHeaderBox", "java.util.Date", "creationTime", "", "void"), 204);
   }
}
