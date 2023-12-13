package com.replaymod.lib.org.cakelab.blender.io.block;

import com.replaymod.lib.org.cakelab.blender.io.util.CBufferReadWrite;
import com.replaymod.lib.org.cakelab.blender.io.util.CDataReadWriteAccess;
import com.replaymod.lib.org.cakelab.blender.nio.UnsignedLong;
import java.io.IOException;
import java.nio.ByteOrder;

public class Block implements Comparable<Long> {
   Block next;
   Block prev;
   public BlockHeader header;
   public CDataReadWriteAccess data;

   public Block(BlockHeader header, CDataReadWriteAccess data) {
      this.header = header;
      this.data = data;
   }

   Block() {
   }

   public int compareTo(Long address) {
      return UnsignedLong.compare(this.header.address, address);
   }

   private void offset(long address) throws IOException {
      this.data.offset(address - this.header.address);
   }

   public void close() throws IOException {
      this.data.close();
   }

   public boolean readBoolean(long address) throws IOException {
      this.offset(address);
      return this.data.readBoolean();
   }

   public void writeBoolean(long address, boolean value) throws IOException {
      this.offset(address);
      this.data.writeBoolean(value);
   }

   public byte readByte(long address) throws IOException {
      this.offset(address);
      return this.data.readByte();
   }

   public void writeByte(long address, byte value) throws IOException {
      this.offset(address);
      this.data.writeByte(value);
   }

   public short readShort(long address) throws IOException {
      this.offset(address);
      return this.data.readShort();
   }

   public void writeShort(long address, short value) throws IOException {
      this.offset(address);
      this.data.writeShort(value);
   }

   public int readInt(long address) throws IOException {
      this.offset(address);
      return this.data.readInt();
   }

   public void writeInt(long address, int value) throws IOException {
      this.offset(address);
      this.data.writeInt(value);
   }

   public long readLong(long address) throws IOException {
      this.offset(address);
      return this.data.readLong();
   }

   public void writeLong(long address, long value) throws IOException {
      this.offset(address);
      this.data.writeLong(value);
   }

   public long readInt64(long address) throws IOException {
      this.offset(address);
      return this.data.readInt64();
   }

   public void writeInt64(long address, long value) throws IOException {
      this.offset(address);
      this.data.writeInt64(value);
   }

   public float readFloat(long address) throws IOException {
      this.offset(address);
      return this.data.readFloat();
   }

   public void writeFloat(long address, float value) throws IOException {
      this.offset(address);
      this.data.writeFloat(value);
   }

   public double readDouble(long address) throws IOException {
      this.offset(address);
      return this.data.readDouble();
   }

   public void writeDouble(long address, double value) throws IOException {
      this.offset(address);
      this.data.writeDouble(value);
   }

   public void readFully(long address, byte[] b) throws IOException {
      this.offset(address);
      this.data.readFully(b);
   }

   public void writeFully(long address, byte[] b) throws IOException {
      this.offset(address);
      this.data.writeFully(b);
   }

   public void readFully(long address, byte[] b, int off, int len) throws IOException {
      this.offset(address);
      this.data.readFully(b, off, len);
   }

   public void writeFully(long address, byte[] b, int off, int len) throws IOException {
      this.offset(address);
      this.data.writeFully(b, off, len);
   }

   public boolean contains(long address) {
      return address >= this.header.address && address < this.header.address + (long)this.header.size;
   }

   public void readFully(long address, short[] b, int off, int len) throws IOException {
      this.offset(address);
      this.data.readFully(b, off, len);
   }

   public void writeFully(long address, short[] b, int off, int len) throws IOException {
      this.offset(address);
      this.data.writeFully(b, off, len);
   }

   public void readFully(long address, int[] b, int off, int len) throws IOException {
      this.offset(address);
      this.data.readFully(b, off, len);
   }

   public void writeFully(long address, int[] b, int off, int len) throws IOException {
      this.offset(address);
      this.data.writeFully(b, off, len);
   }

   public void readFully(long address, long[] b, int off, int len) throws IOException {
      this.offset(address);
      this.data.readFully(b, off, len);
   }

   public void writeFully(long address, long[] b, int off, int len) throws IOException {
      this.offset(address);
      this.data.writeFully(b, off, len);
   }

   public void readFullyInt64(long address, long[] b, int off, int len) throws IOException {
      this.offset(address);
      this.data.readFullyInt64(b, off, len);
   }

   public void writeFullyInt64(long address, long[] b, int off, int len) throws IOException {
      this.offset(address);
      this.data.writeFullyInt64(b, off, len);
   }

   public void readFully(long address, float[] b, int off, int len) throws IOException {
      this.offset(address);
      this.data.readFully(b, off, len);
   }

   public void writeFully(long address, float[] b, int off, int len) throws IOException {
      this.offset(address);
      this.data.writeFully(b, off, len);
   }

   public void readFully(long address, double[] b, int off, int len) throws IOException {
      this.offset(address);
      this.data.readFully(b, off, len);
   }

   public void writeFully(long address, double[] b, int off, int len) throws IOException {
      this.offset(address);
      this.data.writeFully(b, off, len);
   }

   public ByteOrder getByteOrder() {
      return this.data.getByteOrder();
   }

   public void flush(CDataReadWriteAccess io) throws IOException {
      if (this.data instanceof CBufferReadWrite) {
         this.header.write(io);
         io.writeFully(((CBufferReadWrite)this.data).getBytes());
      } else if (io == this.data) {
         this.header.write(io);
         io.skip((long)this.header.size);
      } else {
         if (!io.getByteOrder().equals(this.data.getByteOrder()) || io.getPointerSize() != this.data.getPointerSize()) {
            throw new IOException("error: attempt to write a block with different encoding to another file");
         }

         this.header.write(io);
         byte[] buf = new byte[this.header.size];
         this.data.readFully(buf);
         io.writeFully(buf);
      }

   }
}
