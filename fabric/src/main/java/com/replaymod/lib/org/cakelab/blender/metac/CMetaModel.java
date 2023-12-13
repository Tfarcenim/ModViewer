package com.replaymod.lib.org.cakelab.blender.metac;

import com.replaymod.lib.org.cakelab.blender.io.dna.DNAField;
import com.replaymod.lib.org.cakelab.blender.io.dna.DNAModel;
import com.replaymod.lib.org.cakelab.blender.io.dna.DNAStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class CMetaModel {
   HashMap<String, CType> types = new HashMap();
   ArrayList<CStruct> structs = new ArrayList();

   public CMetaModel(DNAModel model) {
      DNAStruct[] var2 = model.getStructs();
      int i = var2.length;

      int var4;
      DNAStruct bstruct;
      CStruct struct;
      for(var4 = 0; var4 < i; ++var4) {
         bstruct = var2[var4];
         struct = new CStruct(bstruct);
         this.types.put(bstruct.getType().getName(), struct);
         this.structs.add(struct);
      }

      var2 = model.getStructs();
      i = var2.length;

      int size32;
      for(var4 = 0; var4 < i; ++var4) {
         bstruct = var2[var4];
         struct = (CStruct)this.types.get(bstruct.getType().getName());
         DNAField[] var7 = bstruct.getFields();
         int var8 = var7.length;

         for(size32 = 0; size32 < var8; ++size32) {
            DNAField bfield = var7[size32];
            String name = this.getFieldName(bfield);
            String typespec = this.getFieldTypeSpec(name, bfield.getSignatureName());
            String basetype = bfield.getType().getName();
            CType ctype = this.getType(basetype, typespec);
            CField cfield = new CField(name, ctype);
            struct.addField(cfield);
         }
      }

      LinkedList unresolved = new LinkedList(this.structs);

      do {
         i = 0;

         do {
            CStruct struct = (CStruct)unresolved.get(i);
            boolean success = true;

            CType ctype;
            for(Iterator var19 = struct.getFields().iterator(); var19.hasNext(); struct.size64 += ctype.sizeof(8)) {
               CField cfield = (CField)var19.next();
               ctype = cfield.getType();
               if (ctype.kind == CType.CKind.TYPE_ARRAY) {
                  this.calcArraySize(ctype);
               }

               size32 = ctype.sizeof(4);
               if (size32 == 0) {
                  if (ctype.kind == CType.CKind.TYPE_VOID) {
                     throw new IllegalArgumentException("error in struct size calculation. Struct contains field of type void");
                  }

                  struct.size32 = 0;
                  struct.size64 = 0;
                  success = false;
                  break;
               }

               struct.size32 += size32;
            }

            if (success) {
               unresolved.remove(i);
            } else {
               ++i;
            }
         } while(i < unresolved.size());
      } while(!unresolved.isEmpty());

   }

   private CType getType(String basetype, String typespec) {
      CType type = (CType)this.types.get(basetype + typespec);
      if (type == null) {
         type = this.createType(basetype, typespec);
      }

      return type;
   }

   private CType createType(String basetype, String typespec) {
      String typesig = basetype + typespec;
      CType ctype;
      if (typespec.contains("(")) {
         ctype = new CType(typesig, CType.CKind.TYPE_FUNCTION_POINTER, 4, 8);
      } else {
         if (typespec.endsWith("]")) {
            return this.getArrayType(basetype, typespec);
         }

         if (typespec.startsWith("*")) {
            return this.getPointerType(basetype, typespec);
         }

         if (this.isScalar(typesig)) {
            ctype = new CType(typesig, CType.CKind.TYPE_SCALAR, this.getScalarSize(basetype, 4), this.getScalarSize(basetype, 4));
         } else if (typesig.equals("void")) {
            ctype = new CType(typesig, CType.CKind.TYPE_VOID, 0, 0);
         } else {
            ctype = null;
         }
      }

      if (ctype != null) {
         this.types.put(ctype.getSignature(), ctype);
      }

      return ctype;
   }

   private CType getPointerType(String typename, String typespec) {
      CType ctype = new CType(typename + typespec, CType.CKind.TYPE_POINTER, 4, 8);
      typespec = typespec.substring(1);
      ctype.referencedType = this.getType(typename, typespec);
      if (ctype.referencedType == null) {
         ctype.referencedType = this.getType("void", "");
      }

      return ctype;
   }

   public CType getArrayType(String typename, String typespec) {
      CType ctype = new CType(typename + typespec, CType.CKind.TYPE_ARRAY);
      int start = typespec.indexOf(91);
      if (start < 0) {
         throw new Error("inconsistent type declaration: " + typespec);
      } else {
         int end = typespec.indexOf(93);
         String substr = typespec.substring(start + 1, end);
         ctype.arrayLength = Integer.valueOf(substr.trim());
         typespec = typespec.substring(0, start) + typespec.substring(end + 1);
         ctype.referencedType = this.getType(typename, typespec);
         if (ctype.referencedType == null) {
            throw new IllegalArgumentException("unkown component type in array of fixed length");
         } else {
            this.calcArraySize(ctype);
            return ctype;
         }
      }
   }

   private void calcArraySize(CType ctype) {
      if (ctype.referencedType.kind == CType.CKind.TYPE_ARRAY) {
         this.calcArraySize(ctype.referencedType);
      }

      if (ctype.size32 == 0 && ctype.referencedType.size32 != 0) {
         ctype.size32 = ctype.referencedType.size32 * ctype.arrayLength;
         ctype.size64 = ctype.referencedType.size64 * ctype.arrayLength;
      }

   }

   private String getFieldTypeSpec(String fieldName, String fieldSignature) {
      return fieldSignature.replaceFirst(fieldName, "");
   }

   private String getFieldName(DNAField field) {
      String name = field.getSignatureName();
      name = name.replaceAll("\\*", "");
      name = name.replaceAll("\\[.*\\]$", "");
      name = name.replaceAll("[()]", "");
      return name;
   }

   private boolean isScalar(String typeName) {
      return typeName.equals("char") || typeName.equals("short") || typeName.equals("ushort") || typeName.equals("int") || typeName.equals("uint") || typeName.equals("long") || typeName.equals("ulong") || typeName.equals("int64_t") || typeName.equals("uint64_t") || typeName.equals("float") || typeName.equals("double");
   }

   private int getScalarSize(String typeName, int addressWidth) {
      if (typeName.equals("char")) {
         return 1;
      } else if (!typeName.equals("short") && !typeName.equals("ushort")) {
         if (!typeName.equals("int") && !typeName.equals("uint") && !typeName.equals("unsigned int")) {
            if (!typeName.equals("long") && !typeName.equals("ulong")) {
               if (!typeName.equals("int64_t") && !typeName.equals("uint64_t")) {
                  if (typeName.equals("float")) {
                     return 4;
                  } else if (typeName.equals("double")) {
                     return 8;
                  } else {
                     throw new IllegalArgumentException("unknown type name " + typeName);
                  }
               } else {
                  return 8;
               }
            } else {
               return addressWidth == 4 ? 4 : 8;
            }
         } else {
            return 4;
         }
      } else {
         return 2;
      }
   }

   public ArrayList<CStruct> getStructs() {
      return this.structs;
   }

   public CStruct getStruct(int sdnaIndex) {
      return (CStruct)this.structs.get(sdnaIndex);
   }

   public CType getType(String typeSignature) {
      return (CType)this.types.get(typeSignature);
   }
}
