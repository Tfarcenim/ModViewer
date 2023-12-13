package com.replaymod.lib.org.cakelab.blender.io.dna;

import com.replaymod.lib.org.cakelab.blender.io.dna.internal.StructDNA;

public class DNAModel {
   private StructDNA dna;
   private DNAType[] types;
   private DNAStruct[] structs;

   public DNAModel(StructDNA dna) {
      this.dna = dna;
      this.types = new DNAType[dna.types_len];

      int i;
      for(i = 0; i < this.types.length; ++i) {
         this.types[i] = new DNAType(dna.types[i], dna.type_lengths[i]);
      }

      this.structs = new DNAStruct[dna.structs_len];

      for(i = 0; i < dna.structs.length; ++i) {
         StructDNA.Struct s = dna.structs[i];
         this.structs[i] = this.createStruct(i, s);
      }

   }

   private DNAStruct createStruct(int sdnaIndex, StructDNA.Struct s) {
      DNAType type = this.getType(s.type);
      DNAStruct struct = new DNAStruct(sdnaIndex, type, s.fields_len);

      for(int fieldNo = 0; fieldNo < s.fields_len; ++fieldNo) {
         StructDNA.Struct.Field field = s.fields[fieldNo];
         struct.set(fieldNo, this.createField(struct, fieldNo, field));
      }

      return struct;
   }

   private DNAField createField(DNAStruct struct, int fieldNo, StructDNA.Struct.Field field) {
      DNAField f = new DNAField(fieldNo, this.dna.names[field.name], this.getType(field.type));
      return f;
   }

   public DNAType getType(short typeIndex) {
      return this.types[typeIndex];
   }

   public DNAStruct getStruct(int sdnaIndex) {
      return this.structs[sdnaIndex];
   }

   public DNAStruct getStruct(String structName) {
      DNAStruct[] var2 = this.structs;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         DNAStruct struct = var2[var4];
         if (struct.type.name.equals(structName)) {
            return struct;
         }
      }

      return null;
   }

   public DNAStruct[] getStructs() {
      return this.structs;
   }
}
