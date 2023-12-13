package com.replaymod.lib.org.cakelab.blender.io.util;

import java.io.IOException;
import java.io.RandomAccessFile;

public abstract class CDataFileRWAccess extends CDataReadWriteAccess {
   protected RandomAccessFile io;

   protected CDataFileRWAccess(RandomAccessFile in, int pointerSize) {
      super(pointerSize);
      this.io = in;
   }

   public final long skip(long n) throws IOException {
      if (n <= 0L) {
         return 0L;
      } else {
         long pos = this.io.getFilePointer();
         long len = this.io.length();
         long newpos = pos + n;
         if (newpos > len) {
            throw new IOException("Skipping beyond file boundary.");
         } else {
            this.io.seek(newpos);
            return newpos - pos;
         }
      }
   }

   public final int available() throws IOException {
      return (int)(this.io.length() - this.io.getFilePointer());
   }

   public final void readFully(byte[] b, int off, int len) throws IOException {
      this.io.readFully(b, off, len);
   }

   public final void writeFully(byte[] b, int off, int len) throws IOException {
      this.io.write(b, off, len);
   }

   public final boolean readBoolean() throws IOException {
      return this.io.readBoolean();
   }

   public final void writeBoolean(boolean value) throws IOException {
      this.io.writeBoolean(value);
   }

   public final byte readByte() throws IOException {
      return this.io.readByte();
   }

   public final void writeByte(int value) throws IOException {
      this.io.writeByte(value);
   }

   public final void offset(long offset) throws IOException {
      this.io.seek(offset);
   }

   public long offset() throws IOException {
      return this.io.getFilePointer();
   }

   public void padding(int alignment) throws IOException {
      this.padding(alignment, false);
   }

   public void padding(int alignment, boolean extend) throws IOException {
      long pos = this.offset();
      long misalignment = pos % (long)alignment;
      if (misalignment > 0L) {
         long len = this.io.length();
         long correction = (long)alignment - misalignment;
         if (pos + correction <= len) {
            this.skip(correction);
         } else {
            if (!extend) {
               throw new IOException("padding beyond file boundary without permission.");
            }

            this.offset(pos + (correction - 1L));
            this.writeByte(0);
         }
      }

   }

   public void close() throws IOException {
      this.io.close();
   }
}
