package com.replaymod.lib.com.coremedia.iso.boxes.sampleentry;

import com.replaymod.lib.com.coremedia.iso.BoxParser;
import com.replaymod.lib.com.googlecode.mp4parser.AbstractContainerBox;
import com.replaymod.lib.com.googlecode.mp4parser.DataSource;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public abstract class AbstractSampleEntry extends AbstractContainerBox implements SampleEntry {
   protected int dataReferenceIndex = 1;

   protected AbstractSampleEntry(String type) {
      super(type);
   }

   public int getDataReferenceIndex() {
      return this.dataReferenceIndex;
   }

   public void setDataReferenceIndex(int dataReferenceIndex) {
      this.dataReferenceIndex = dataReferenceIndex;
   }

   public abstract void parse(DataSource var1, ByteBuffer var2, long var3, BoxParser var5) throws IOException;

   public abstract void getBox(WritableByteChannel var1) throws IOException;
}
