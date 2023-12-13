package com.replaymod.lib.com.coremedia.iso.boxes;

import com.replaymod.lib.com.coremedia.iso.BoxParser;
import com.replaymod.lib.com.coremedia.iso.IsoTypeReader;
import com.replaymod.lib.com.coremedia.iso.IsoTypeWriter;
import com.replaymod.lib.com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry;
import com.replaymod.lib.com.googlecode.mp4parser.AbstractContainerBox;
import com.replaymod.lib.com.googlecode.mp4parser.DataSource;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Iterator;

public class SampleDescriptionBox extends AbstractContainerBox implements FullBox {
   public static final String TYPE = "stsd";
   private int version;
   private int flags;

   public SampleDescriptionBox() {
      super("stsd");
   }

   public int getVersion() {
      return this.version;
   }

   public void setVersion(int version) {
      this.version = version;
   }

   public int getFlags() {
      return this.flags;
   }

   public void setFlags(int flags) {
      this.flags = flags;
   }

   public void parse(DataSource dataSource, ByteBuffer header, long contentSize, BoxParser boxParser) throws IOException {
      ByteBuffer versionFlagNumOfChildBoxes = ByteBuffer.allocate(8);
      dataSource.read(versionFlagNumOfChildBoxes);
      versionFlagNumOfChildBoxes.rewind();
      this.version = IsoTypeReader.readUInt8(versionFlagNumOfChildBoxes);
      this.flags = IsoTypeReader.readUInt24(versionFlagNumOfChildBoxes);
      this.initContainer(dataSource, contentSize - 8L, boxParser);
   }

   public void getBox(WritableByteChannel writableByteChannel) throws IOException {
      writableByteChannel.write(this.getHeader());
      ByteBuffer versionFlagNumOfChildBoxes = ByteBuffer.allocate(8);
      IsoTypeWriter.writeUInt8(versionFlagNumOfChildBoxes, this.version);
      IsoTypeWriter.writeUInt24(versionFlagNumOfChildBoxes, this.flags);
      IsoTypeWriter.writeUInt32(versionFlagNumOfChildBoxes, (long)this.getBoxes().size());
      writableByteChannel.write((ByteBuffer)versionFlagNumOfChildBoxes.rewind());
      this.writeContainer(writableByteChannel);
   }

   public AbstractSampleEntry getSampleEntry() {
      Iterator var2 = this.getBoxes(AbstractSampleEntry.class).iterator();
      if (var2.hasNext()) {
         AbstractSampleEntry box = (AbstractSampleEntry)var2.next();
         return box;
      } else {
         return null;
      }
   }

   public long getSize() {
      long s = this.getContainerSize();
      long t = 8L;
      return s + t + (long)(!this.largeBox && s + t + 8L < 4294967296L ? 8 : 16);
   }
}
