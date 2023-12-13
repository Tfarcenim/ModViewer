package com.replaymod.lib.org.cakelab.blender.io.dna;

public class DNAField {
   int index;
   String signatureName;
   DNAType type;
   String name;

   public DNAField(int index, String name, DNAType type) {
      this.index = index;
      this.signatureName = name;
      this.name = this.removeSignatureFromName(name);
      this.type = type;
   }

   private String removeSignatureFromName(String name) {
      return name.replace("*", "").replaceAll("\\[.*\\]", "");
   }

   public DNAType getType() {
      return this.type;
   }

   public String getSignatureName() {
      return this.signatureName;
   }

   public String getSignature() {
      return this.type.name + " " + this.signatureName;
   }

   public String getName() {
      return this.name;
   }
}
