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

public class TrackHeaderBox extends AbstractFullBox {
   private static Logger LOG;
   public static final String TYPE = "tkhd";
   private Date creationTime = new Date(0L);
   private Date modificationTime = new Date(0L);
   private long trackId;
   private long duration;
   private int layer;
   private int alternateGroup;
   private float volume;
   private Matrix matrix;
   private double width;
   private double height;
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
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_29;

   static {
      ajc$preClinit();
      LOG = Logger.getLogger(TrackHeaderBox.class);
   }

   public TrackHeaderBox() {
      super("tkhd");
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

   public long getTrackId() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_2, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.trackId;
   }

   public long getDuration() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_3, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.duration;
   }

   public int getLayer() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_4, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.layer;
   }

   public int getAlternateGroup() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_5, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.alternateGroup;
   }

   public float getVolume() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_6, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.volume;
   }

   public Matrix getMatrix() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_7, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.matrix;
   }

   public double getWidth() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_8, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.width;
   }

   public double getHeight() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_9, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.height;
   }

   protected long getContentSize() {
      long contentSize = 4L;
      if (this.getVersion() == 1) {
         contentSize += 32L;
      } else {
         contentSize += 20L;
      }

      contentSize += 60L;
      return contentSize;
   }

   public void _parseDetails(ByteBuffer content) {
      this.parseVersionAndFlags(content);
      if (this.getVersion() == 1) {
         this.creationTime = DateHelper.convert(IsoTypeReader.readUInt64(content));
         this.modificationTime = DateHelper.convert(IsoTypeReader.readUInt64(content));
         this.trackId = IsoTypeReader.readUInt32(content);
         IsoTypeReader.readUInt32(content);
         this.duration = content.getLong();
      } else {
         this.creationTime = DateHelper.convert(IsoTypeReader.readUInt32(content));
         this.modificationTime = DateHelper.convert(IsoTypeReader.readUInt32(content));
         this.trackId = IsoTypeReader.readUInt32(content);
         IsoTypeReader.readUInt32(content);
         this.duration = (long)content.getInt();
      }

      if (this.duration < -1L) {
         LOG.logWarn("tkhd duration is not in expected range");
      }

      IsoTypeReader.readUInt32(content);
      IsoTypeReader.readUInt32(content);
      this.layer = IsoTypeReader.readUInt16(content);
      this.alternateGroup = IsoTypeReader.readUInt16(content);
      this.volume = IsoTypeReader.readFixedPoint88(content);
      IsoTypeReader.readUInt16(content);
      this.matrix = Matrix.fromByteBuffer(content);
      this.width = IsoTypeReader.readFixedPoint1616(content);
      this.height = IsoTypeReader.readFixedPoint1616(content);
   }

   public void getContent(ByteBuffer byteBuffer) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_10, this, this, (Object)byteBuffer);
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.writeVersionAndFlags(byteBuffer);
      if (this.getVersion() == 1) {
         IsoTypeWriter.writeUInt64(byteBuffer, DateHelper.convert(this.creationTime));
         IsoTypeWriter.writeUInt64(byteBuffer, DateHelper.convert(this.modificationTime));
         IsoTypeWriter.writeUInt32(byteBuffer, this.trackId);
         IsoTypeWriter.writeUInt32(byteBuffer, 0L);
         byteBuffer.putLong(this.duration);
      } else {
         IsoTypeWriter.writeUInt32(byteBuffer, DateHelper.convert(this.creationTime));
         IsoTypeWriter.writeUInt32(byteBuffer, DateHelper.convert(this.modificationTime));
         IsoTypeWriter.writeUInt32(byteBuffer, this.trackId);
         IsoTypeWriter.writeUInt32(byteBuffer, 0L);
         byteBuffer.putInt((int)this.duration);
      }

      IsoTypeWriter.writeUInt32(byteBuffer, 0L);
      IsoTypeWriter.writeUInt32(byteBuffer, 0L);
      IsoTypeWriter.writeUInt16(byteBuffer, this.layer);
      IsoTypeWriter.writeUInt16(byteBuffer, this.alternateGroup);
      IsoTypeWriter.writeFixedPoint88(byteBuffer, (double)this.volume);
      IsoTypeWriter.writeUInt16(byteBuffer, 0);
      boolean var10000 = false;
      this.matrix.getContent(byteBuffer);
      IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.width);
      IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.height);
   }

   public String toString() {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_11, this, this);
      RequiresParseDetailAspect.aspectOf().before(var2);
      StringBuilder result = new StringBuilder();
      result.append("TrackHeaderBox[");
      result.append("creationTime=").append(this.getCreationTime());
      result.append(";");
      result.append("modificationTime=").append(this.getModificationTime());
      result.append(";");
      result.append("trackId=").append(this.getTrackId());
      result.append(";");
      result.append("duration=").append(this.getDuration());
      result.append(";");
      result.append("layer=").append(this.getLayer());
      result.append(";");
      result.append("alternateGroup=").append(this.getAlternateGroup());
      result.append(";");
      result.append("volume=").append(this.getVolume());
      result.append(";");
      result.append("matrix=").append(this.matrix);
      result.append(";");
      result.append("width=").append(this.getWidth());
      result.append(";");
      result.append("height=").append(this.getHeight());
      result.append("]");
      return result.toString();
   }

   public void setCreationTime(Date creationTime) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_12, this, this, (Object)creationTime);
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.creationTime = creationTime;
      if (DateHelper.convert(creationTime) >= 4294967296L) {
         this.setVersion(1);
      }

   }

   public void setModificationTime(Date modificationTime) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_13, this, this, (Object)modificationTime);
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.modificationTime = modificationTime;
      if (DateHelper.convert(modificationTime) >= 4294967296L) {
         this.setVersion(1);
      }

   }

   public void setTrackId(long trackId) {
      JoinPoint var3 = Factory.makeJP(ajc$tjp_14, this, this, (Object)Conversions.longObject(trackId));
      RequiresParseDetailAspect.aspectOf().before(var3);
      this.trackId = trackId;
   }

   public void setDuration(long duration) {
      JoinPoint var3 = Factory.makeJP(ajc$tjp_15, this, this, (Object)Conversions.longObject(duration));
      RequiresParseDetailAspect.aspectOf().before(var3);
      this.duration = duration;
      if (duration >= 4294967296L) {
         this.setFlags(1);
      }

   }

   public void setLayer(int layer) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_16, this, this, (Object)Conversions.intObject(layer));
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.layer = layer;
   }

   public void setAlternateGroup(int alternateGroup) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_17, this, this, (Object)Conversions.intObject(alternateGroup));
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.alternateGroup = alternateGroup;
   }

   public void setVolume(float volume) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_18, this, this, (Object)Conversions.floatObject(volume));
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.volume = volume;
   }

   public void setMatrix(Matrix matrix) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_19, this, this, (Object)matrix);
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.matrix = matrix;
   }

   public void setWidth(double width) {
      JoinPoint var3 = Factory.makeJP(ajc$tjp_20, this, this, (Object)Conversions.doubleObject(width));
      RequiresParseDetailAspect.aspectOf().before(var3);
      this.width = width;
   }

   public void setHeight(double height) {
      JoinPoint var3 = Factory.makeJP(ajc$tjp_21, this, this, (Object)Conversions.doubleObject(height));
      RequiresParseDetailAspect.aspectOf().before(var3);
      this.height = height;
   }

   public boolean isEnabled() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_22, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return (this.getFlags() & 1) > 0;
   }

   public boolean isInMovie() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_23, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return (this.getFlags() & 2) > 0;
   }

   public boolean isInPreview() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_24, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return (this.getFlags() & 4) > 0;
   }

   public boolean isInPoster() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_25, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return (this.getFlags() & 8) > 0;
   }

   public void setEnabled(boolean enabled) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_26, this, this, (Object)Conversions.booleanObject(enabled));
      RequiresParseDetailAspect.aspectOf().before(var2);
      if (enabled) {
         this.setFlags(this.getFlags() | 1);
      } else {
         this.setFlags(this.getFlags() & -2);
      }

   }

   public void setInMovie(boolean inMovie) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_27, this, this, (Object)Conversions.booleanObject(inMovie));
      RequiresParseDetailAspect.aspectOf().before(var2);
      if (inMovie) {
         this.setFlags(this.getFlags() | 2);
      } else {
         this.setFlags(this.getFlags() & -3);
      }

   }

   public void setInPreview(boolean inPreview) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_28, this, this, (Object)Conversions.booleanObject(inPreview));
      RequiresParseDetailAspect.aspectOf().before(var2);
      if (inPreview) {
         this.setFlags(this.getFlags() | 4);
      } else {
         this.setFlags(this.getFlags() & -5);
      }

   }

   public void setInPoster(boolean inPoster) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_29, this, this, (Object)Conversions.booleanObject(inPoster));
      RequiresParseDetailAspect.aspectOf().before(var2);
      if (inPoster) {
         this.setFlags(this.getFlags() | 8);
      } else {
         this.setFlags(this.getFlags() & -9);
      }

   }

   // $FF: synthetic method
   private static void ajc$preClinit() {
      Factory var0 = new Factory("TrackHeaderBox.java", TrackHeaderBox.class);
      ajc$tjp_0 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getCreationTime", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.util.Date"), 62);
      ajc$tjp_1 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getModificationTime", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.util.Date"), 66);
      ajc$tjp_10 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getContent", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 145);
      ajc$tjp_11 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "toString", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.lang.String"), 173);
      ajc$tjp_12 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setCreationTime", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "java.util.Date", "creationTime", "", "void"), 199);
      ajc$tjp_13 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setModificationTime", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "java.util.Date", "modificationTime", "", "void"), 206);
      ajc$tjp_14 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setTrackId", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "long", "trackId", "", "void"), 214);
      ajc$tjp_15 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setDuration", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "long", "duration", "", "void"), 218);
      ajc$tjp_16 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setLayer", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "int", "layer", "", "void"), 225);
      ajc$tjp_17 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setAlternateGroup", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "int", "alternateGroup", "", "void"), 229);
      ajc$tjp_18 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setVolume", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "float", "volume", "", "void"), 233);
      ajc$tjp_19 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setMatrix", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "com.replaymod.lib.com.googlecode.mp4parser.util.Matrix", "matrix", "", "void"), 237);
      ajc$tjp_2 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getTrackId", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "long"), 70);
      ajc$tjp_20 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setWidth", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "double", "width", "", "void"), 241);
      ajc$tjp_21 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setHeight", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "double", "height", "", "void"), 245);
      ajc$tjp_22 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "isEnabled", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 250);
      ajc$tjp_23 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "isInMovie", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 254);
      ajc$tjp_24 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "isInPreview", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 258);
      ajc$tjp_25 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "isInPoster", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 262);
      ajc$tjp_26 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setEnabled", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "enabled", "", "void"), 266);
      ajc$tjp_27 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setInMovie", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inMovie", "", "void"), 274);
      ajc$tjp_28 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setInPreview", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inPreview", "", "void"), 282);
      ajc$tjp_29 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setInPoster", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inPoster", "", "void"), 290);
      ajc$tjp_3 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getDuration", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "long"), 74);
      ajc$tjp_4 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getLayer", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "int"), 78);
      ajc$tjp_5 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getAlternateGroup", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "int"), 82);
      ajc$tjp_6 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getVolume", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "float"), 86);
      ajc$tjp_7 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getMatrix", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "com.replaymod.lib.com.googlecode.mp4parser.util.Matrix"), 90);
      ajc$tjp_8 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getWidth", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "double"), 94);
      ajc$tjp_9 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getHeight", "com.replaymod.lib.com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "double"), 98);
   }
}
