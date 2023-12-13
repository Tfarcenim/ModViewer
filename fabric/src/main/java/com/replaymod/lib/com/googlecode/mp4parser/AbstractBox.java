package com.replaymod.lib.com.googlecode.mp4parser;

import com.replaymod.lib.com.coremedia.iso.BoxParser;
import com.replaymod.lib.com.coremedia.iso.Hex;
import com.replaymod.lib.com.coremedia.iso.IsoFile;
import com.replaymod.lib.com.coremedia.iso.IsoTypeWriter;
import com.replaymod.lib.com.coremedia.iso.boxes.Box;
import com.replaymod.lib.com.coremedia.iso.boxes.Container;
import com.replaymod.lib.com.googlecode.mp4parser.annotations.DoNotParseDetail;
import com.replaymod.lib.com.googlecode.mp4parser.util.CastUtils;
import com.replaymod.lib.com.googlecode.mp4parser.util.Logger;
import com.replaymod.lib.com.googlecode.mp4parser.util.Path;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public abstract class AbstractBox implements Box {
   private static Logger LOG = Logger.getLogger(AbstractBox.class);
   protected String type;
   private byte[] userType;
   private Container parent;
   boolean isParsed;
   boolean isRead;
   private ByteBuffer content;
   long contentStartPosition;
   long offset;
   long memMapSize = -1L;
   DataSource dataSource;
   private ByteBuffer deadBytes = null;

   private synchronized void readContent() {
      if (!this.isRead) {
         try {
            LOG.logDebug("mem mapping " + this.getType());
            this.content = this.dataSource.map(this.contentStartPosition, this.memMapSize);
         } catch (IOException var2) {
            throw new RuntimeException("contentStartPosition: " + this.contentStartPosition + " memMapSize: " + this.memMapSize, var2);
         }

         this.isRead = true;
      }

   }

   public long getOffset() {
      return this.offset;
   }

   protected AbstractBox(String type) {
      this.type = type;
      this.isRead = true;
      this.isParsed = true;
   }

   protected AbstractBox(String type, byte[] userType) {
      this.type = type;
      this.userType = userType;
      this.isRead = true;
      this.isParsed = true;
   }

   protected abstract long getContentSize();

   protected abstract void getContent(ByteBuffer var1);

   protected abstract void _parseDetails(ByteBuffer var1);

   @DoNotParseDetail
   public void parse(DataSource dataSource, ByteBuffer header, long contentSize, BoxParser boxParser) throws IOException {
      this.contentStartPosition = dataSource.position();
      this.offset = this.contentStartPosition - (long)header.remaining();
      this.memMapSize = contentSize;
      this.dataSource = dataSource;
      dataSource.position(dataSource.position() + contentSize);
      this.isRead = false;
      this.isParsed = false;
   }

   public void getBox(WritableByteChannel os) throws IOException {
      ByteBuffer bb;
      if (this.isRead) {
         if (this.isParsed) {
            bb = ByteBuffer.allocate(CastUtils.l2i(this.getSize()));
            this.getHeader(bb);
            this.getContent(bb);
            if (this.deadBytes != null) {
               this.deadBytes.rewind();

               while(this.deadBytes.remaining() > 0) {
                  bb.put(this.deadBytes);
               }
            }

            os.write((ByteBuffer)bb.rewind());
         } else {
            bb = ByteBuffer.allocate((this.isSmallBox() ? 8 : 16) + ("uuid".equals(this.getType()) ? 16 : 0));
            this.getHeader(bb);
            os.write((ByteBuffer)bb.rewind());
            os.write((ByteBuffer)this.content.position(0));
         }
      } else {
         bb = ByteBuffer.allocate((this.isSmallBox() ? 8 : 16) + ("uuid".equals(this.getType()) ? 16 : 0));
         this.getHeader(bb);
         os.write((ByteBuffer)bb.rewind());
         this.dataSource.transferTo(this.contentStartPosition, this.memMapSize, os);
      }

   }

   public final synchronized void parseDetails() {
      this.readContent();
      LOG.logDebug("parsing details of " + this.getType());
      if (this.content != null) {
         ByteBuffer content = this.content;
         this.isParsed = true;
         content.rewind();
         this._parseDetails(content);
         if (content.remaining() > 0) {
            this.deadBytes = content.slice();
         }

         this.content = null;

         assert this.verify(content);
      }

   }

   protected void setDeadBytes(ByteBuffer newDeadBytes) {
      this.deadBytes = newDeadBytes;
   }

   public long getSize() {
      long size = this.isRead ? (this.isParsed ? this.getContentSize() : (long)(this.content != null ? this.content.limit() : 0)) : this.memMapSize;
      size += (long)(8 + (size >= 4294967288L ? 8 : 0) + ("uuid".equals(this.getType()) ? 16 : 0));
      size += (long)(this.deadBytes == null ? 0 : this.deadBytes.limit());
      return size;
   }

   @DoNotParseDetail
   public String getType() {
      return this.type;
   }

   @DoNotParseDetail
   public byte[] getUserType() {
      return this.userType;
   }

   @DoNotParseDetail
   public Container getParent() {
      return this.parent;
   }

   @DoNotParseDetail
   public void setParent(Container parent) {
      this.parent = parent;
   }

   public boolean isParsed() {
      return this.isParsed;
   }

   private boolean verify(ByteBuffer content) {
      ByteBuffer bb = ByteBuffer.allocate(CastUtils.l2i(this.getContentSize() + (long)(this.deadBytes != null ? this.deadBytes.limit() : 0)));
      this.getContent(bb);
      if (this.deadBytes != null) {
         this.deadBytes.rewind();

         while(this.deadBytes.remaining() > 0) {
            bb.put(this.deadBytes);
         }
      }

      content.rewind();
      bb.rewind();
      if (content.remaining() != bb.remaining()) {
         System.err.print(this.getType() + ": remaining differs " + content.remaining() + " vs. " + bb.remaining());
         LOG.logError(this.getType() + ": remaining differs " + content.remaining() + " vs. " + bb.remaining());
         return false;
      } else {
         int p = content.position();
         int i = content.limit() - 1;

         for(int j = bb.limit() - 1; i >= p; --j) {
            byte v1 = content.get(i);
            byte v2 = bb.get(j);
            if (v1 != v2) {
               LOG.logError(String.format("%s: buffers differ at %d: %2X/%2X", this.getType(), i, v1, v2));
               byte[] b1 = new byte[content.remaining()];
               byte[] b2 = new byte[bb.remaining()];
               content.get(b1);
               bb.get(b2);
               System.err.println("original      : " + Hex.encodeHex(b1, 4));
               System.err.println("reconstructed : " + Hex.encodeHex(b2, 4));
               return false;
            }

            --i;
         }

         return true;
      }
   }

   private boolean isSmallBox() {
      int baseSize = 8;
      if ("uuid".equals(this.getType())) {
         baseSize += 16;
      }

      if (this.isRead) {
         if (this.isParsed) {
            return this.getContentSize() + (long)(this.deadBytes != null ? this.deadBytes.limit() : 0) + (long)baseSize < 4294967296L;
         } else {
            return (long)(this.content.limit() + baseSize) < 4294967296L;
         }
      } else {
         return this.memMapSize + (long)baseSize < 4294967296L;
      }
   }

   private void getHeader(ByteBuffer byteBuffer) {
      if (this.isSmallBox()) {
         IsoTypeWriter.writeUInt32(byteBuffer, this.getSize());
         byteBuffer.put(IsoFile.fourCCtoBytes(this.getType()));
      } else {
         IsoTypeWriter.writeUInt32(byteBuffer, 1L);
         byteBuffer.put(IsoFile.fourCCtoBytes(this.getType()));
         IsoTypeWriter.writeUInt64(byteBuffer, this.getSize());
      }

      if ("uuid".equals(this.getType())) {
         byteBuffer.put(this.getUserType());
      }

   }

   @DoNotParseDetail
   public String getPath() {
      return Path.createPath(this);
   }
}
