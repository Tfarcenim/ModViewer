package com.replaymod.lib.org.cakelab.blender.io;

import com.replaymod.lib.org.cakelab.blender.io.util.CDataReadWriteAccess;
import com.replaymod.lib.org.cakelab.blender.metac.CField;
import com.replaymod.lib.org.cakelab.blender.metac.CStruct;
import com.replaymod.lib.org.cakelab.blender.metac.CType;
import java.io.IOException;
import java.util.Iterator;

public class FileVersionInfo {
   int subversion;
   int minversion;
   int minsubversion;
   FileHeader.Version version;

   public void read(CStruct struct, CDataReadWriteAccess cin) throws IOException {
      int remaining = 3;
      Iterator var4 = struct.getFields().iterator();

      while(var4.hasNext()) {
         CField field = (CField)var4.next();
         if (field.getName().equals("subversion")) {
            this.subversion = this.getIntegerValue(field, cin);
            --remaining;
         } else if (field.getName().equals("minversion")) {
            this.minversion = this.getIntegerValue(field, cin);
            --remaining;
         } else if (field.getName().equals("minsubversion")) {
            this.minsubversion = this.getIntegerValue(field, cin);
            --remaining;
         } else {
            this.skipField(field, cin);
         }

         if (remaining == 0) {
            break;
         }
      }

      if (remaining != 0) {
         throw new IOException("didn't found all required version specifiers in FileGlobal");
      }
   }

   private void skipField(CField field, CDataReadWriteAccess cin) throws IOException {
      cin.skip((long)field.getType().sizeof(cin.getPointerSize()));
   }

   private int getIntegerValue(CField field, CDataReadWriteAccess cin) throws IOException {
      CType type = field.getType();
      if (type.getKind().equals(CType.CKind.TYPE_SCALAR)) {
         String typeName = type.getSignature();
         if (typeName.contains("short")) {
            return cin.readShort();
         }

         if (typeName.contains("int")) {
            return cin.readInt();
         }

         if (typeName.contains("int64")) {
            return (int)cin.readInt64();
         }

         if (typeName.contains("long")) {
            return (int)cin.readLong();
         }
      }

      throw new IOException("version specifier field not an integer value");
   }

   public int getSubversion() {
      return this.subversion;
   }

   public int getMinversion() {
      return this.minversion;
   }

   public int getMinsubversion() {
      return this.minsubversion;
   }

   public FileHeader.Version getVersion() {
      return this.version;
   }
}
