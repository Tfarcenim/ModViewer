package com.replaymod.lib.com.coremedia.iso.boxes;

import com.replaymod.lib.com.coremedia.iso.BoxParser;
import com.replaymod.lib.com.coremedia.iso.IsoTypeWriter;
import com.replaymod.lib.com.googlecode.mp4parser.DataSource;
import com.replaymod.lib.com.googlecode.mp4parser.util.CastUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FreeBox implements Box {
   public static final String TYPE = "free";
   ByteBuffer data;
   List<Box> replacers = new LinkedList();
   private Container parent;
   private long offset;

   public FreeBox() {
      this.data = ByteBuffer.wrap(new byte[0]);
   }

   public FreeBox(int size) {
      this.data = ByteBuffer.allocate(size);
   }

   public long getOffset() {
      return this.offset;
   }

   public ByteBuffer getData() {
      return this.data != null ? (ByteBuffer)this.data.duplicate().rewind() : null;
   }

   public void setData(ByteBuffer data) {
      this.data = data;
   }

   public void getBox(WritableByteChannel os) throws IOException {
      Iterator var3 = this.replacers.iterator();

      while(var3.hasNext()) {
         Box replacer = (Box)var3.next();
         replacer.getBox(os);
      }

      ByteBuffer header = ByteBuffer.allocate(8);
      IsoTypeWriter.writeUInt32(header, (long)(8 + this.data.limit()));
      header.put("free".getBytes());
      header.rewind();
      os.write(header);
      header.rewind();
      this.data.rewind();
      os.write(this.data);
      this.data.rewind();
   }

   public Container getParent() {
      return this.parent;
   }

   public void setParent(Container parent) {
      this.parent = parent;
   }

   public long getSize() {
      long size = 8L;

      Box replacer;
      for(Iterator var4 = this.replacers.iterator(); var4.hasNext(); size += replacer.getSize()) {
         replacer = (Box)var4.next();
      }

      size += (long)this.data.limit();
      return size;
   }

   public String getType() {
      return "free";
   }

   public void parse(DataSource dataSource, ByteBuffer header, long contentSize, BoxParser boxParser) throws IOException {
      this.offset = dataSource.position() - (long)header.remaining();
      if (contentSize > 1048576L) {
         this.data = dataSource.map(dataSource.position(), contentSize);
         dataSource.position(dataSource.position() + contentSize);
      } else {
         assert contentSize < 2147483647L;

         this.data = ByteBuffer.allocate(CastUtils.l2i(contentSize));
         dataSource.read(this.data);
      }

   }

   public void addAndReplace(Box box) {
      this.data.position(CastUtils.l2i(box.getSize()));
      this.data = this.data.slice();
      this.replacers.add(box);
   }

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         FreeBox freeBox = (FreeBox)o;
         if (this.getData() != null) {
            if (!this.getData().equals(freeBox.getData())) {
               return false;
            }
         } else if (freeBox.getData() != null) {
            return false;
         }

         return true;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.data != null ? this.data.hashCode() : 0;
   }
}
