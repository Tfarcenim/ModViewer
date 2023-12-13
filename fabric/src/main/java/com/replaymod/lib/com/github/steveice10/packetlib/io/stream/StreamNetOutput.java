package com.replaymod.lib.com.github.steveice10.packetlib.io.stream;

import com.replaymod.lib.com.github.steveice10.packetlib.io.NetOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

public class StreamNetOutput implements NetOutput {
   private OutputStream out;

   public StreamNetOutput(OutputStream out) {
      this.out = out;
   }

   public void writeBoolean(boolean b) throws IOException {
      this.writeByte(b ? 1 : 0);
   }

   public void writeByte(int b) throws IOException {
      this.out.write(b);
   }

   public void writeShort(int s) throws IOException {
      this.writeByte((byte)(s >>> 8 & 255));
      this.writeByte((byte)(s >>> 0 & 255));
   }

   public void writeChar(int c) throws IOException {
      this.writeByte((byte)(c >>> 8 & 255));
      this.writeByte((byte)(c >>> 0 & 255));
   }

   public void writeInt(int i) throws IOException {
      this.writeByte((byte)(i >>> 24 & 255));
      this.writeByte((byte)(i >>> 16 & 255));
      this.writeByte((byte)(i >>> 8 & 255));
      this.writeByte((byte)(i >>> 0 & 255));
   }

   public void writeVarInt(int i) throws IOException {
      while((i & -128) != 0) {
         this.writeByte(i & 127 | 128);
         i >>>= 7;
      }

      this.writeByte(i);
   }

   public void writeLong(long l) throws IOException {
      this.writeByte((byte)((int)(l >>> 56)));
      this.writeByte((byte)((int)(l >>> 48)));
      this.writeByte((byte)((int)(l >>> 40)));
      this.writeByte((byte)((int)(l >>> 32)));
      this.writeByte((byte)((int)(l >>> 24)));
      this.writeByte((byte)((int)(l >>> 16)));
      this.writeByte((byte)((int)(l >>> 8)));
      this.writeByte((byte)((int)(l >>> 0)));
   }

   public void writeVarLong(long l) throws IOException {
      while((l & -128L) != 0L) {
         this.writeByte((int)(l & 127L) | 128);
         l >>>= 7;
      }

      this.writeByte((int)l);
   }

   public void writeFloat(float f) throws IOException {
      this.writeInt(Float.floatToIntBits(f));
   }

   public void writeDouble(double d) throws IOException {
      this.writeLong(Double.doubleToLongBits(d));
   }

   public void writeBytes(byte[] b) throws IOException {
      this.writeBytes(b, b.length);
   }

   public void writeBytes(byte[] b, int length) throws IOException {
      this.out.write(b, 0, length);
   }

   public void writeShorts(short[] s) throws IOException {
      this.writeShorts(s, s.length);
   }

   public void writeShorts(short[] s, int length) throws IOException {
      for(int index = 0; index < length; ++index) {
         this.writeShort(s[index]);
      }

   }

   public void writeInts(int[] i) throws IOException {
      this.writeInts(i, i.length);
   }

   public void writeInts(int[] i, int length) throws IOException {
      for(int index = 0; index < length; ++index) {
         this.writeInt(i[index]);
      }

   }

   public void writeLongs(long[] l) throws IOException {
      this.writeLongs(l, l.length);
   }

   public void writeLongs(long[] l, int length) throws IOException {
      for(int index = 0; index < length; ++index) {
         this.writeLong(l[index]);
      }

   }

   public void writeString(String s) throws IOException {
      if (s == null) {
         throw new IllegalArgumentException("String cannot be null!");
      } else {
         byte[] bytes = s.getBytes("UTF-8");
         if (bytes.length > 32767) {
            throw new IOException("String too big (was " + s.length() + " bytes encoded, max " + 32767 + ")");
         } else {
            this.writeVarInt(bytes.length);
            this.writeBytes(bytes);
         }
      }
   }

   public void writeUUID(UUID uuid) throws IOException {
      this.writeLong(uuid.getMostSignificantBits());
      this.writeLong(uuid.getLeastSignificantBits());
   }

   public void flush() throws IOException {
      this.out.flush();
   }
}
