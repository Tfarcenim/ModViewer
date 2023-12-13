package com.replaymod.lib.com.coremedia.iso.boxes;

import com.replaymod.lib.com.googlecode.mp4parser.AbstractFullBox;
import com.replaymod.lib.com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.replaymod.lib.org.aspectj.lang.JoinPoint;
import com.replaymod.lib.org.aspectj.runtime.reflect.Factory;

public abstract class ChunkOffsetBox extends AbstractFullBox {
   // $FF: synthetic field
   private static final JoinPoint.StaticPart ajc$tjp_0;

   public ChunkOffsetBox(String type) {
      super(type);
   }

   public abstract long[] getChunkOffsets();

   public abstract void setChunkOffsets(long[] var1);

   public String toString() {
      JoinPoint var1 = Factory.makeJP(ajc$tjp_0, this, this);
      RequiresParseDetailAspect.aspectOf().before(var1);
      return this.getClass().getSimpleName() + "[entryCount=" + this.getChunkOffsets().length + "]";
   }

   static {
      ajc$preClinit();
   }

   // $FF: synthetic method
   private static void ajc$preClinit() {
      Factory var0 = new Factory("ChunkOffsetBox.java", ChunkOffsetBox.class);
      ajc$tjp_0 = var0.makeSJP("method-execution", var0.makeMethodSig("1", "toString", "com.replaymod.lib.com.coremedia.iso.boxes.ChunkOffsetBox", "", "", "", "java.lang.String"), 18);
   }
}
