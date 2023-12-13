package com.replaymod.lib.org.cakelab.blender.io.block;

import com.replaymod.lib.org.cakelab.blender.io.util.CDataReadWriteAccess;
import com.replaymod.lib.org.cakelab.blender.io.util.Identifier;
import java.io.IOException;

public class BlockHeader {
   Identifier code = new Identifier();
   int size;
   long address;
   int sdnaIndex;
   int count;

   public BlockHeader() {
   }

   public BlockHeader(Identifier code, int size, long address) {
      this.code = code;
      this.size = size;
      this.address = address;
   }

   public BlockHeader(Identifier code, int size, long address, int sdnaIndex, int count) {
      this.code = code;
      this.size = size;
      this.address = address;
      this.sdnaIndex = sdnaIndex;
      this.count = count;
   }

   public void read(CDataReadWriteAccess in) throws IOException {
      this.code.read(in);
      this.size = in.readInt();
      this.address = in.readLong();
      this.sdnaIndex = in.readInt();
      this.count = in.readInt();
   }

   public void write(CDataReadWriteAccess out) throws IOException {
      this.code.write(out);
      out.writeInt(this.size);
      out.writeLong(this.address);
      out.writeInt(this.sdnaIndex);
      out.writeInt(this.count);
   }

   public Identifier getCode() {
      return this.code;
   }

   public int getSize() {
      return this.size;
   }

   public long getAddress() {
      return this.address;
   }

   public int getSdnaIndex() {
      return this.sdnaIndex;
   }

   public void setSdnaIndex(int sdnaIndex) {
      this.sdnaIndex = sdnaIndex;
   }

   public int getCount() {
      return this.count;
   }

   public void setCount(int count) {
      this.count = count;
   }

   public String toString() {
      return this.code + ": size=" + this.size + ", address=" + this.address + ", sdnaIndex=" + this.sdnaIndex + ", count=" + this.count;
   }

   public static long getHeaderSize(int pointerSize) {
      return (long)(16 + pointerSize);
   }
}
