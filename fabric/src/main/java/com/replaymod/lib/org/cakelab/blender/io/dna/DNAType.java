package com.replaymod.lib.org.cakelab.blender.io.dna;

public class DNAType {
   String name;
   short size;

   public DNAType(String name, short size) {
      this.name = name;
      this.size = size;
   }

   public String getName() {
      return this.name;
   }

   public short getSize() {
      return this.size;
   }
}
