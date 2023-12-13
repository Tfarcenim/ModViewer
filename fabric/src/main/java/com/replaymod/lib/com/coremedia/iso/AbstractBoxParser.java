package com.replaymod.lib.com.coremedia.iso;

import com.replaymod.lib.com.coremedia.iso.boxes.Box;
import com.replaymod.lib.com.coremedia.iso.boxes.Container;
import com.replaymod.lib.com.googlecode.mp4parser.DataSource;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;

public abstract class AbstractBoxParser implements BoxParser {
   private static Logger LOG = Logger.getLogger(AbstractBoxParser.class.getName());
   ThreadLocal<ByteBuffer> header = new ThreadLocal<ByteBuffer>() {
      protected ByteBuffer initialValue() {
         return ByteBuffer.allocate(32);
      }
   };

   public abstract Box createBox(String var1, byte[] var2, String var3);

   public Box parseBox(DataSource byteChannel, Container parent) throws IOException {
      long startPos = byteChannel.position();
      ((ByteBuffer)this.header.get()).rewind().limit(8);
      boolean var5 = false;

      int b;
      while((b = byteChannel.read((ByteBuffer)this.header.get())) != 8) {
         if (b < 0) {
            byteChannel.position(startPos);
            throw new EOFException();
         }
      }

      ((ByteBuffer)this.header.get()).rewind();
      long size = IsoTypeReader.readUInt32((ByteBuffer)this.header.get());
      if (size < 8L && size > 1L) {
         LOG.severe("Plausibility check failed: size < 8 (size = " + size + "). Stop parsing!");
         return null;
      } else {
         String type = IsoTypeReader.read4cc((ByteBuffer)this.header.get());
         byte[] usertype = null;
         long contentSize;
         if (size == 1L) {
            ((ByteBuffer)this.header.get()).limit(16);
            byteChannel.read((ByteBuffer)this.header.get());
            ((ByteBuffer)this.header.get()).position(8);
            size = IsoTypeReader.readUInt64((ByteBuffer)this.header.get());
            contentSize = size - 16L;
         } else if (size == 0L) {
            contentSize = byteChannel.size() - byteChannel.position();
            size = contentSize + 8L;
         } else {
            contentSize = size - 8L;
         }

         if ("uuid".equals(type)) {
            ((ByteBuffer)this.header.get()).limit(((ByteBuffer)this.header.get()).limit() + 16);
            byteChannel.read((ByteBuffer)this.header.get());
            usertype = new byte[16];

            for(int i = ((ByteBuffer)this.header.get()).position() - 16; i < ((ByteBuffer)this.header.get()).position(); ++i) {
               usertype[i - (((ByteBuffer)this.header.get()).position() - 16)] = ((ByteBuffer)this.header.get()).get(i);
            }

            contentSize -= 16L;
         }

         Box box = this.createBox(type, usertype, parent instanceof Box ? ((Box)parent).getType() : "");
         box.setParent(parent);
         ((ByteBuffer)this.header.get()).rewind();
         box.parse(byteChannel, (ByteBuffer)this.header.get(), contentSize, this);
         return box;
      }
   }
}
