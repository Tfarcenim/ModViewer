package com.replaymod.lib.org.cakelab.blender.io.dna;

public class DNAStruct {
   int index;
   DNAType type;
   DNAField[] fields;

   public DNAStruct(int sdnaIndex, DNAType type, short fields_len) {
      this.index = sdnaIndex;
      this.type = type;
      this.fields = new DNAField[fields_len];
   }

   public void set(int i, DNAField f) {
      this.fields[i] = f;
   }

   public DNAType getType() {
      return this.type;
   }

   public DNAField[] getFields() {
      return this.fields;
   }

   public int getIndex() {
      return this.index;
   }
}
