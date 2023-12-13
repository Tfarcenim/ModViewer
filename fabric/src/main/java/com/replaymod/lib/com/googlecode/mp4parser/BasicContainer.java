package com.replaymod.lib.com.googlecode.mp4parser;

import com.replaymod.lib.com.coremedia.iso.BoxParser;
import com.replaymod.lib.com.coremedia.iso.boxes.Box;
import com.replaymod.lib.com.coremedia.iso.boxes.Container;
import com.replaymod.lib.com.googlecode.mp4parser.util.CastUtils;
import com.replaymod.lib.com.googlecode.mp4parser.util.LazyList;
import com.replaymod.lib.com.googlecode.mp4parser.util.Logger;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BasicContainer implements Container, Iterator<Box>, Closeable {
   private static final Box EOF = new AbstractBox("eof ") {
      protected long getContentSize() {
         return 0L;
      }

      protected void getContent(ByteBuffer byteBuffer) {
      }

      protected void _parseDetails(ByteBuffer content) {
      }
   };
   private static Logger LOG = Logger.getLogger(BasicContainer.class);
   protected BoxParser boxParser;
   protected DataSource dataSource;
   Box lookahead = null;
   long parsePosition = 0L;
   long startPosition = 0L;
   long endPosition = 0L;
   private List<Box> boxes = new ArrayList();

   public List<Box> getBoxes() {
      return (List)(this.dataSource != null && this.lookahead != EOF ? new LazyList(this.boxes, this) : this.boxes);
   }

   public void setBoxes(List<Box> boxes) {
      this.boxes = new ArrayList(boxes);
      this.lookahead = EOF;
      this.dataSource = null;
   }

   protected long getContainerSize() {
      long contentSize = 0L;

      for(int i = 0; i < this.getBoxes().size(); ++i) {
         contentSize += ((Box)this.boxes.get(i)).getSize();
      }

      return contentSize;
   }

   public <T extends Box> List<T> getBoxes(Class<T> clazz) {
      List<T> boxesToBeReturned = null;
      T oneBox = null;
      List<Box> boxes = this.getBoxes();

      for(int i = 0; i < boxes.size(); ++i) {
         Box boxe = (Box)boxes.get(i);
         if (clazz.isInstance(boxe)) {
            if (oneBox == null) {
               oneBox = boxe;
            } else {
               if (boxesToBeReturned == null) {
                  boxesToBeReturned = new ArrayList(2);
                  boxesToBeReturned.add(oneBox);
               }

               boxesToBeReturned.add(boxe);
            }
         }
      }

      if (boxesToBeReturned != null) {
         return boxesToBeReturned;
      } else if (oneBox != null) {
         return Collections.singletonList(oneBox);
      } else {
         return Collections.emptyList();
      }
   }

   public <T extends Box> List<T> getBoxes(Class<T> clazz, boolean recursive) {
      List<T> boxesToBeReturned = new ArrayList(2);
      List<Box> boxes = this.getBoxes();

      for(int i = 0; i < boxes.size(); ++i) {
         Box boxe = (Box)boxes.get(i);
         if (clazz.isInstance(boxe)) {
            boxesToBeReturned.add(boxe);
         }

         if (recursive && boxe instanceof Container) {
            boxesToBeReturned.addAll(((Container)boxe).getBoxes(clazz, recursive));
         }
      }

      return boxesToBeReturned;
   }

   public void addBox(Box box) {
      if (box != null) {
         this.boxes = new ArrayList(this.getBoxes());
         box.setParent(this);
         this.boxes.add(box);
      }

   }

   public void initContainer(DataSource dataSource, long containerSize, BoxParser boxParser) throws IOException {
      this.dataSource = dataSource;
      this.parsePosition = this.startPosition = dataSource.position();
      dataSource.position(dataSource.position() + containerSize);
      this.endPosition = dataSource.position();
      this.boxParser = boxParser;
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }

   public boolean hasNext() {
      if (this.lookahead == EOF) {
         return false;
      } else if (this.lookahead != null) {
         return true;
      } else {
         try {
            this.lookahead = this.next();
            return true;
         } catch (NoSuchElementException var1) {
            this.lookahead = EOF;
            return false;
         }
      }
   }

   public Box next() {
      if (this.lookahead != null && this.lookahead != EOF) {
         Box b = this.lookahead;
         this.lookahead = null;
         return b;
      } else if (this.dataSource != null && this.parsePosition < this.endPosition) {
         try {
            synchronized(this.dataSource) {
               this.dataSource.position(this.parsePosition);
               Box b = this.boxParser.parseBox(this.dataSource, this);
               this.parsePosition = this.dataSource.position();
               return b;
            }
         } catch (EOFException var4) {
            throw new NoSuchElementException();
         } catch (IOException var5) {
            throw new NoSuchElementException();
         }
      } else {
         this.lookahead = EOF;
         throw new NoSuchElementException();
      }
   }

   public String toString() {
      StringBuilder buffer = new StringBuilder();
      buffer.append(this.getClass().getSimpleName()).append("[");

      for(int i = 0; i < this.boxes.size(); ++i) {
         if (i > 0) {
            buffer.append(";");
         }

         buffer.append(((Box)this.boxes.get(i)).toString());
      }

      buffer.append("]");
      return buffer.toString();
   }

   public final void writeContainer(WritableByteChannel bb) throws IOException {
      Iterator var3 = this.getBoxes().iterator();

      while(var3.hasNext()) {
         Box box = (Box)var3.next();
         box.getBox(bb);
      }

   }

   public ByteBuffer getByteBuffer(long rangeStart, long size) throws IOException {
      if (this.dataSource != null) {
         synchronized(this.dataSource) {
            return this.dataSource.map(this.startPosition + rangeStart, size);
         }
      } else {
         ByteBuffer out = ByteBuffer.allocate(CastUtils.l2i(size));
         long rangeEnd = rangeStart + size;
         long boxEnd = 0L;
         Iterator var13 = this.boxes.iterator();

         while(true) {
            while(true) {
               long boxStart;
               Box box;
               do {
                  do {
                     if (!var13.hasNext()) {
                        return (ByteBuffer)out.rewind();
                     }

                     box = (Box)var13.next();
                     boxStart = boxEnd;
                     boxEnd += box.getSize();
                  } while(boxEnd <= rangeStart);
               } while(boxStart >= rangeEnd);

               ByteArrayOutputStream baos = new ByteArrayOutputStream();
               WritableByteChannel wbc = Channels.newChannel(baos);
               box.getBox(wbc);
               wbc.close();
               if (boxStart >= rangeStart && boxEnd <= rangeEnd) {
                  out.put(baos.toByteArray());
               } else {
                  int length;
                  if (boxStart < rangeStart && boxEnd > rangeEnd) {
                     length = CastUtils.l2i(box.getSize() - (rangeStart - boxStart) - (boxEnd - rangeEnd));
                     out.put(baos.toByteArray(), CastUtils.l2i(rangeStart - boxStart), length);
                  } else if (boxStart < rangeStart && boxEnd <= rangeEnd) {
                     length = CastUtils.l2i(box.getSize() - (rangeStart - boxStart));
                     out.put(baos.toByteArray(), CastUtils.l2i(rangeStart - boxStart), length);
                  } else if (boxStart >= rangeStart && boxEnd > rangeEnd) {
                     length = CastUtils.l2i(box.getSize() - (boxEnd - rangeEnd));
                     out.put(baos.toByteArray(), 0, length);
                  }
               }
            }
         }
      }
   }

   public void close() throws IOException {
      this.dataSource.close();
   }
}
