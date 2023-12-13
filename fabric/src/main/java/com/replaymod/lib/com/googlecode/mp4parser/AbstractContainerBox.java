package com.replaymod.lib.com.googlecode.mp4parser;

import com.replaymod.lib.com.coremedia.iso.BoxParser;
import com.replaymod.lib.com.coremedia.iso.IsoTypeWriter;
import com.replaymod.lib.com.coremedia.iso.boxes.Box;
import com.replaymod.lib.com.coremedia.iso.boxes.Container;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public class AbstractContainerBox extends BasicContainer implements Box {
   Container parent;
   protected String type;
   protected boolean largeBox;
   private long offset;

   public AbstractContainerBox(String type) {
      this.type = type;
   }

   public Container getParent() {
      return this.parent;
   }

   public long getOffset() {
      return this.offset;
   }

   public void setParent(Container parent) {
      this.parent = parent;
   }

   public long getSize() {
      long s = this.getContainerSize();
      return s + (long)(!this.largeBox && s + 8L < 4294967296L ? 8 : 16);
   }

   public String getType() {
      return this.type;
   }

   protected ByteBuffer getHeader() {
      ByteBuffer header;
      if (!this.largeBox && this.getSize() < 4294967296L) {
         header = ByteBuffer.wrap(new byte[]{0, 0, 0, 0, this.type.getBytes()[0], this.type.getBytes()[1], this.type.getBytes()[2], this.type.getBytes()[3]});
         IsoTypeWriter.writeUInt32(header, this.getSize());
      } else {
         header = ByteBuffer.wrap(new byte[]{0, 0, 0, 1, this.type.getBytes()[0], this.type.getBytes()[1], this.type.getBytes()[2], this.type.getBytes()[3], 0, 0, 0, 0, 0, 0, 0, 0});
         header.position(8);
         IsoTypeWriter.writeUInt64(header, this.getSize());
      }

      header.rewind();
      return header;
   }

   public void parse(DataSource dataSource, ByteBuffer header, long contentSize, BoxParser boxParser) throws IOException {
      this.offset = dataSource.position() - (long)header.remaining();
      this.largeBox = header.remaining() == 16;
      this.initContainer(dataSource, contentSize, boxParser);
   }

   public void getBox(WritableByteChannel writableByteChannel) throws IOException {
      writableByteChannel.write(this.getHeader());
      this.writeContainer(writableByteChannel);
   }

   public void initContainer(DataSource dataSource, long containerSize, BoxParser boxParser) throws IOException {
      this.dataSource = dataSource;
      this.parsePosition = dataSource.position();
      this.startPosition = this.parsePosition - (long)(!this.largeBox && containerSize + 8L < 4294967296L ? 8 : 16);
      dataSource.position(dataSource.position() + containerSize);
      this.endPosition = dataSource.position();
      this.boxParser = boxParser;
   }
}
