package com.replaymod.lib.org.cakelab.blender.metac;

public class CType {
   protected int arrayLength;
   protected CType referencedType;
   protected CType.CKind kind;
   protected String signature;
   public int size32;
   public int size64;

   public CType(String typesig, CType.CKind kind) {
      this.signature = typesig;
      this.kind = kind;
   }

   public CType(String typesig, CType.CKind kind, int size32, int size64) {
      this(typesig, kind);
      this.size32 = size32;
      this.size64 = size64;
   }

   public int getArrayLength() {
      return this.arrayLength;
   }

   public CType getReferencedType() {
      return this.referencedType;
   }

   public CType.CKind getKind() {
      return this.kind;
   }

   public String getSignature() {
      return this.signature;
   }

   public int getTotalNumArrayElems() {
      int totalLength = 1;

      for(CType array = this; array.kind == CType.CKind.TYPE_ARRAY; array = array.getReferencedType()) {
         totalLength *= array.arrayLength;
      }

      return totalLength;
   }

   public int sizeof(int addressWidth) {
      switch(addressWidth) {
      case 4:
         return this.size32;
      case 8:
         return this.size64;
      default:
         throw new IllegalArgumentException("addressWidth must be one of Encoding.ADDR_WIDTH_32BIT or Encoding.ADDR_WIDTH_64BIT");
      }
   }

   public static enum CKind {
      TYPE_POINTER,
      TYPE_FUNCTION_POINTER,
      TYPE_ARRAY,
      TYPE_SCALAR,
      TYPE_STRUCT,
      TYPE_VOID;
   }
}
