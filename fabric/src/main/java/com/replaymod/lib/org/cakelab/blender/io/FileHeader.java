package com.replaymod.lib.org.cakelab.blender.io;

import com.replaymod.lib.org.cakelab.blender.io.util.CDataReadWriteAccess;
import com.replaymod.lib.org.cakelab.blender.io.util.CStringUtils;
import java.io.IOException;
import java.nio.ByteOrder;

public class FileHeader {
   static final String BLENDER_MAGIC = "BLENDER";
   FileHeader.PointerSize pointerSize;
   FileHeader.Endianess endianess;
   FileHeader.Version version;

   public void read(CDataReadWriteAccess in) throws IOException {
      byte[] magic = new byte["BLENDER".length()];
      in.readFully(magic);
      if (!CStringUtils.toString(magic).equals("BLENDER")) {
         throw new IOException("not a blender file");
      } else {
         this.pointerSize = FileHeader.PointerSize.decode(in.readByte());
         this.endianess = FileHeader.Endianess.decode(in.readByte());
         this.version = FileHeader.Version.read(in);
      }
   }

   public void write(CDataReadWriteAccess io) throws IOException {
      io.writeFully("BLENDER".getBytes(CStringUtils.ASCII));
      io.writeByte(this.pointerSize.code);
      io.writeByte(this.endianess.code);
      this.version.write(io);
   }

   public String toString() {
      return "BLENDER" + this.pointerSize.code + this.endianess.code + this.version.code;
   }

   public ByteOrder getByteOrder() {
      return this.endianess.equals(FileHeader.Endianess.BIG_ENDIAN) ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN;
   }

   public int getPointerSize() {
      return this.pointerSize.getSize();
   }

   public static class Version {
      int major;
      int minor;
      int code;

      public Version(int v) {
         this.major = v / 100;
         this.minor = v % 100;
         this.code = v;
      }

      public Version(String verstr) throws NumberFormatException {
         String formatExceptionMsg = "Unsupported version string format in '" + verstr + "'";
         String[] parts = verstr.split("\\.");
         if (parts.length < 2) {
            throw new NumberFormatException(formatExceptionMsg);
         } else {
            try {
               this.major = Integer.valueOf(parts[0]);
               this.minor = Integer.valueOf(parts[1]);
            } catch (NumberFormatException var5) {
               throw new NumberFormatException(formatExceptionMsg);
            }

            if (this.major < 10 && this.minor < 100) {
               this.code = this.major * 100 + this.minor;
            } else {
               throw new NumberFormatException(formatExceptionMsg);
            }
         }
      }

      public String toString() {
         return "" + this.major + '.' + (this.minor < 10 ? "0" + this.minor : this.minor);
      }

      public static FileHeader.Version read(CDataReadWriteAccess in) throws IOException {
         byte[] str = new byte[3];
         in.readFully(str);
         int v = Integer.valueOf(CStringUtils.toString(str));
         return new FileHeader.Version(v);
      }

      public void write(CDataReadWriteAccess io) throws IOException {
         io.writeFully(Integer.toString(this.code).getBytes(CStringUtils.ASCII));
      }

      public int getCode() {
         return this.code;
      }

      public int getMajor() {
         return this.major;
      }

      public int getMinor() {
         return this.minor;
      }
   }

   public static enum PointerSize {
      POINTER_SIZE_32BIT('_', 4),
      POINTER_SIZE_64BIT('-', 8);

      final char code;
      private final int size;

      private PointerSize(char code, int size) {
         this.code = code;
         this.size = size;
      }

      public static FileHeader.PointerSize decode(int code) {
         char c = (char)code;
         if (c == POINTER_SIZE_32BIT.code) {
            return POINTER_SIZE_32BIT;
         } else if (c == POINTER_SIZE_64BIT.code) {
            return POINTER_SIZE_64BIT;
         } else {
            throw new IllegalArgumentException("undefined pointer size code '" + code + "'");
         }
      }

      public int getSize() {
         return this.size;
      }

      public static FileHeader.PointerSize from(int pointerSize) {
         return pointerSize == 8 ? POINTER_SIZE_64BIT : POINTER_SIZE_32BIT;
      }
   }

   public static enum Endianess {
      LITTLE_ENDIAN('v'),
      BIG_ENDIAN('V');

      char code;

      private Endianess(char code) {
         this.code = code;
      }

      public static FileHeader.Endianess decode(int code) {
         char c = (char)code;
         if (c == LITTLE_ENDIAN.code) {
            return LITTLE_ENDIAN;
         } else if (c == BIG_ENDIAN.code) {
            return BIG_ENDIAN;
         } else {
            throw new IllegalArgumentException("undefined endianess code '" + code + "'");
         }
      }

      public static FileHeader.Endianess from(ByteOrder byteOrder) {
         return byteOrder == ByteOrder.BIG_ENDIAN ? BIG_ENDIAN : LITTLE_ENDIAN;
      }
   }
}
