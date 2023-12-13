package com.replaymod.lib.org.cakelab.blender.io.util;

import java.io.IOException;
import java.util.Arrays;

public class Identifier {
   byte[] code = new byte[4];

   public Identifier() {
   }

   public Identifier(String strCode) {
      this.code = CStringUtils.valueOf(strCode);
   }

   public Identifier(byte[] code) {
      this.code = code;
   }

   public void read(CDataReadWriteAccess in) throws IOException {
      in.readFully(this.code);
   }

   public void write(CDataReadWriteAccess io) throws IOException {
      io.writeFully(this.code);
   }

   public int hashCode() {
      int prime = true;
      int result = 1;
      int result = 31 * result + Arrays.hashCode(this.code);
      return result;
   }

   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      } else if (obj == null) {
         return false;
      } else if (this.getClass() != obj.getClass()) {
         return false;
      } else {
         Identifier other = (Identifier)obj;
         return Arrays.equals(this.code, other.code);
      }
   }

   public String toString() {
      return CStringUtils.toString(this.code, true);
   }

   public void consume(CDataReadWriteAccess in, Identifier expected) throws IOException {
      Identifier ident = new Identifier();
      ident.read(in);
      if (!ident.equals(expected)) {
         throw new IOException("input did not match expected identifier '" + expected + "'");
      }
   }

   public String getDataString() {
      return Arrays.toString(this.code);
   }

   public byte[] getData() {
      return this.code;
   }
}
