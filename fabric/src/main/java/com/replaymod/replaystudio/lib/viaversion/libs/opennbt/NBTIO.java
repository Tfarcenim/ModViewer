package com.replaymod.replaystudio.lib.viaversion.libs.opennbt;

import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.limiter.TagLimiter;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class NBTIO {
   public static CompoundTag readFile(String path) throws IOException {
      return readFile(new File(path));
   }

   public static CompoundTag readFile(File file) throws IOException {
      return readFile(file, true, false);
   }

   public static CompoundTag readFile(String path, boolean compressed, boolean littleEndian) throws IOException {
      return readFile(new File(path), compressed, littleEndian);
   }

   public static CompoundTag readFile(File file, boolean compressed, boolean littleEndian) throws IOException {
      Object in = Files.newInputStream(file.toPath());

      CompoundTag var5;
      try {
         if (compressed) {
            in = new GZIPInputStream((InputStream)in);
         }

         CompoundTag tag = readTag((InputStream)in, littleEndian);
         if (!(tag instanceof CompoundTag)) {
            throw new IOException("Root tag is not a CompoundTag!");
         }

         var5 = tag;
      } finally {
         ((InputStream)in).close();
      }

      return var5;
   }

   public static void writeFile(CompoundTag tag, String path) throws IOException {
      writeFile(tag, new File(path));
   }

   public static void writeFile(CompoundTag tag, File file) throws IOException {
      writeFile(tag, file, true, false);
   }

   public static void writeFile(CompoundTag tag, String path, boolean compressed, boolean littleEndian) throws IOException {
      writeFile(tag, new File(path), compressed, littleEndian);
   }

   public static void writeFile(CompoundTag tag, File file, boolean compressed, boolean littleEndian) throws IOException {
      if (!file.exists()) {
         if (file.getParentFile() != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
         }

         file.createNewFile();
      }

      Object out = Files.newOutputStream(file.toPath());

      try {
         if (compressed) {
            out = new GZIPOutputStream((OutputStream)out);
         }

         writeTag((OutputStream)out, tag, littleEndian);
      } finally {
         ((OutputStream)out).close();
      }

   }

   public static CompoundTag readTag(InputStream in) throws IOException {
      return readTag(in, TagLimiter.noop());
   }

   public static CompoundTag readTag(InputStream in, TagLimiter tagLimiter) throws IOException {
      return readTag((DataInput)(new DataInputStream(in)), tagLimiter);
   }

   public static CompoundTag readTag(InputStream in, boolean littleEndian) throws IOException {
      return readTag((DataInput)(littleEndian ? new NBTIO.LittleEndianDataInputStream(in) : new DataInputStream(in)));
   }

   public static CompoundTag readTag(DataInput in) throws IOException {
      return readTag(in, TagLimiter.noop());
   }

   public static CompoundTag readTag(DataInput in, TagLimiter tagLimiter) throws IOException {
      int id = in.readByte();
      if (id != 10) {
         throw new IOException(String.format("Expected root tag to be a CompoundTag, was %s", Integer.valueOf(id)));
      } else {
         in.skipBytes(in.readUnsignedShort());
         CompoundTag tag = new CompoundTag();
         tag.read(in, tagLimiter);
         return tag;
      }
   }

   public static void writeTag(OutputStream out, CompoundTag tag) throws IOException {
      writeTag(out, tag, false);
   }

   public static void writeTag(OutputStream out, CompoundTag tag, boolean littleEndian) throws IOException {
      writeTag((DataOutput)(littleEndian ? new NBTIO.LittleEndianDataOutputStream(out) : new DataOutputStream(out)), tag);
   }

   public static void writeTag(DataOutput out, CompoundTag tag) throws IOException {
      out.writeByte(10);
      out.writeUTF("");
      tag.write(out);
   }

   private static final class LittleEndianDataOutputStream extends FilterOutputStream implements DataOutput {
      private LittleEndianDataOutputStream(OutputStream out) {
         super(out);
      }

      public synchronized void write(int b) throws IOException {
         this.out.write(b);
      }

      public synchronized void write(byte[] b, int off, int len) throws IOException {
         this.out.write(b, off, len);
      }

      public void flush() throws IOException {
         this.out.flush();
      }

      public void writeBoolean(boolean b) throws IOException {
         this.out.write(b ? 1 : 0);
      }

      public void writeByte(int b) throws IOException {
         this.out.write(b);
      }

      public void writeShort(int s) throws IOException {
         this.out.write(s & 255);
         this.out.write(s >>> 8 & 255);
      }

      public void writeChar(int c) throws IOException {
         this.out.write(c & 255);
         this.out.write(c >>> 8 & 255);
      }

      public void writeInt(int i) throws IOException {
         this.out.write(i & 255);
         this.out.write(i >>> 8 & 255);
         this.out.write(i >>> 16 & 255);
         this.out.write(i >>> 24 & 255);
      }

      public void writeLong(long l) throws IOException {
         this.out.write((int)(l & 255L));
         this.out.write((int)(l >>> 8 & 255L));
         this.out.write((int)(l >>> 16 & 255L));
         this.out.write((int)(l >>> 24 & 255L));
         this.out.write((int)(l >>> 32 & 255L));
         this.out.write((int)(l >>> 40 & 255L));
         this.out.write((int)(l >>> 48 & 255L));
         this.out.write((int)(l >>> 56 & 255L));
      }

      public void writeFloat(float f) throws IOException {
         this.writeInt(Float.floatToIntBits(f));
      }

      public void writeDouble(double d) throws IOException {
         this.writeLong(Double.doubleToLongBits(d));
      }

      public void writeBytes(String s) throws IOException {
         int len = s.length();

         for(int index = 0; index < len; ++index) {
            this.out.write((byte)s.charAt(index));
         }

      }

      public void writeChars(String s) throws IOException {
         int len = s.length();

         for(int index = 0; index < len; ++index) {
            char c = s.charAt(index);
            this.out.write(c & 255);
            this.out.write(c >>> 8 & 255);
         }

      }

      public void writeUTF(String s) throws IOException {
         byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
         this.writeShort(bytes.length);
         this.write(bytes);
      }

      // $FF: synthetic method
      LittleEndianDataOutputStream(OutputStream x0, Object x1) {
         this(x0);
      }
   }

   private static final class LittleEndianDataInputStream extends FilterInputStream implements DataInput {
      private LittleEndianDataInputStream(InputStream in) {
         super(in);
      }

      public int read(byte[] b) throws IOException {
         return this.in.read(b, 0, b.length);
      }

      public int read(byte[] b, int off, int len) throws IOException {
         return this.in.read(b, off, len);
      }

      public void readFully(byte[] b) throws IOException {
         this.readFully(b, 0, b.length);
      }

      public void readFully(byte[] b, int off, int len) throws IOException {
         if (len < 0) {
            throw new IndexOutOfBoundsException();
         } else {
            int read;
            for(int pos = 0; pos < len; pos += read) {
               read = this.in.read(b, off + pos, len - pos);
               if (read < 0) {
                  throw new EOFException();
               }
            }

         }
      }

      public int skipBytes(int n) throws IOException {
         int total = 0;

         int skipped;
         for(boolean var3 = false; total < n && (skipped = (int)this.in.skip((long)(n - total))) > 0; total += skipped) {
         }

         return total;
      }

      public boolean readBoolean() throws IOException {
         int val = this.in.read();
         if (val < 0) {
            throw new EOFException();
         } else {
            return val != 0;
         }
      }

      public byte readByte() throws IOException {
         int val = this.in.read();
         if (val < 0) {
            throw new EOFException();
         } else {
            return (byte)val;
         }
      }

      public int readUnsignedByte() throws IOException {
         int val = this.in.read();
         if (val < 0) {
            throw new EOFException();
         } else {
            return val;
         }
      }

      public short readShort() throws IOException {
         int b1 = this.in.read();
         int b2 = this.in.read();
         if ((b1 | b2) < 0) {
            throw new EOFException();
         } else {
            return (short)(b1 | b2 << 8);
         }
      }

      public int readUnsignedShort() throws IOException {
         int b1 = this.in.read();
         int b2 = this.in.read();
         if ((b1 | b2) < 0) {
            throw new EOFException();
         } else {
            return b1 | b2 << 8;
         }
      }

      public char readChar() throws IOException {
         int b1 = this.in.read();
         int b2 = this.in.read();
         if ((b1 | b2) < 0) {
            throw new EOFException();
         } else {
            return (char)(b1 | b2 << 8);
         }
      }

      public int readInt() throws IOException {
         int b1 = this.in.read();
         int b2 = this.in.read();
         int b3 = this.in.read();
         int b4 = this.in.read();
         if ((b1 | b2 | b3 | b4) < 0) {
            throw new EOFException();
         } else {
            return b1 | b2 << 8 | b3 << 16 | b4 << 24;
         }
      }

      public long readLong() throws IOException {
         long b1 = (long)this.in.read();
         long b2 = (long)this.in.read();
         long b3 = (long)this.in.read();
         long b4 = (long)this.in.read();
         long b5 = (long)this.in.read();
         long b6 = (long)this.in.read();
         long b7 = (long)this.in.read();
         long b8 = (long)this.in.read();
         if ((b1 | b2 | b3 | b4 | b5 | b6 | b7 | b8) < 0L) {
            throw new EOFException();
         } else {
            return b1 | b2 << 8 | b3 << 16 | b4 << 24 | b5 << 32 | b6 << 40 | b7 << 48 | b8 << 56;
         }
      }

      public float readFloat() throws IOException {
         return Float.intBitsToFloat(this.readInt());
      }

      public double readDouble() throws IOException {
         return Double.longBitsToDouble(this.readLong());
      }

      public String readLine() throws IOException {
         throw new UnsupportedOperationException("Use readUTF.");
      }

      public String readUTF() throws IOException {
         byte[] bytes = new byte[this.readUnsignedShort()];
         this.readFully(bytes);
         return new String(bytes, StandardCharsets.UTF_8);
      }

      // $FF: synthetic method
      LittleEndianDataInputStream(InputStream x0, Object x1) {
         this(x0);
      }
   }
}
