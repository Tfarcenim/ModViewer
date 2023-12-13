package com.replaymod.lib.com.coremedia.iso.boxes;

import com.replaymod.lib.com.googlecode.mp4parser.AbstractBox;
import com.replaymod.lib.com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.replaymod.lib.org.aspectj.lang.JoinPoint;
import com.replaymod.lib.org.aspectj.runtime.reflect.Factory;
import java.nio.ByteBuffer;

public class UserBox extends AbstractBox {
   byte[] data;
   public static final String TYPE = "uuid";
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_0;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_1;
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_2;

   public UserBox(byte[] userType) {
      super("uuid", userType);
   }

   protected long getContentSize() {
      return (long)this.data.length;
   }

   public String toString() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_0, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return "UserBox[type=" + this.getType() + ";userType=" + new String(this.getUserType()) + ";contentLength=" + this.data.length + "]";
   }

   public byte[] getData() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_1, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.data;
   }

   public void setData(byte[] data) {
      JoinPoint var2 = Factory.makeJP(ajc$tjp_2, this, this, (Object)data);
      RequiresParseDetailAspect.aspectOf().before(var2);
      this.data = data;
   }

   public void _parseDetails(ByteBuffer content) {
      this.data = new byte[content.remaining()];
      content.get(this.data);
   }

   protected void getContent(ByteBuffer byteBuffer) {
      byteBuffer.put(this.data);
   }

   static {
      ajc$preClinit();
   }

   // $FF: synthetic method
   private static void ajc$preClinit() {
      Factory var0 = new Factory("UserBox.java", UserBox.class);
      ajc$tjp_0 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "toString", "com.replaymod.lib.com.coremedia.iso.boxes.UserBox", "", "", "", "java.lang.String"), 40);
      ajc$tjp_1 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "getData", "com.replaymod.lib.com.coremedia.iso.boxes.UserBox", "", "", "", "[B"), 47);
      ajc$tjp_2 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "setData", "com.replaymod.lib.com.coremedia.iso.boxes.UserBox", "[B", "data", "", "void"), 51);
   }
}
